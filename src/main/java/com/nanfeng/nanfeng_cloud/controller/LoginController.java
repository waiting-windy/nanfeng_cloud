package com.nanfeng.nanfeng_cloud.controller;

import com.nanfeng.nanfeng_cloud.entity.FileStore;
import com.nanfeng.nanfeng_cloud.entity.User;
import com.nanfeng.nanfeng_cloud.utils.LogUtils;
import com.qq.connect.QQConnectException;
import com.qq.connect.api.OpenID;
import com.qq.connect.api.qzone.UserInfo;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.qq.connect.oauth.Oauth;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Date;

/**
 * @Description 登录控制器
 **/
@Controller
public class LoginController extends BaseController {

    private Logger logger = LogUtils.getInstance(LoginController.class);

    /**
     * @Description 免登陆用户入口，用于本地开发测试，上线运营为了安全请删除此方法
     * @Author  nanfeng
     * @Date  13:28 2020/3/27
     * @Param []
     * @Return java.lang.String
     */
    /*@GetMapping("/admin")
    public String adminLogin(){
        User user = userService.getUserByOpenId("1");
        logger.info("QQ用户登录成功！"+user);
        session.setAttribute("loginUser", user);
        return "redirect:/main";
    }*/

    /**
     * @Description 请求QQ登录
     * @Author  nanfeng
     * @Date  13:28 2020/3/27
     * @Param []
     * @Return void
     */
    @GetMapping("/login")
    public void login() {
        response.setContentType("text/html;charset=utf-8");
        try {
            response.sendRedirect(new Oauth().getAuthorizeURL(request));
            logger.info("请求QQ登录,开始跳转...");
        } catch (QQConnectException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description QQ登录回调地址
     * @Author  nanfeng
     * @Date  13:29 2020/3/27
     * @Param []
     * @Return java.lang.String
     */
    @GetMapping("/connection")
    public String connection(Model model) {
        try {
            AccessToken accessTokenObj = (new Oauth()).getAccessTokenByRequest(request);
            String accessToken = null, openID = null;
            long tokenExpireIn = 0L;
            if ("".equals(accessTokenObj.getAccessToken())) {
                logger.error("登录失败:没有获取到响应参数");
                model.addAttribute("msg","accessTokenObj=>" + accessTokenObj + "; accessToken" + accessTokenObj.getAccessToken());
            } else {
                accessToken = accessTokenObj.getAccessToken();
                tokenExpireIn = accessTokenObj.getExpireIn();
                logger.info("当前accessToken" + accessToken);
                request.getSession().setAttribute("demo_access_token", accessToken);
                request.getSession().setAttribute("demo_token_expirein", String.valueOf(tokenExpireIn));
                // 利用获取到的accessToken 去获取当前用的openid -------- start
                OpenID openIDObj = new OpenID(accessToken);
                openID = openIDObj.getUserOpenID();
                logger.info("当前openId" + openID);
                UserInfo qzoneUserInfo = new UserInfo(accessToken, openID);
                UserInfoBean userInfoBean = qzoneUserInfo.getUserInfo();
                if (userInfoBean.getRet() == 0) {
                    logger.info("用户的OPEN_ID: " + openID);
                    logger.info("用户的昵称: " + removeNonBmpUnicode(userInfoBean.getNickname()));
                    logger.info("用户的头像URI: " + userInfoBean.getAvatar().getAvatarURL100());
                    //设置用户信息
                    User user = userService.getUserByOpenId(openID);
                    if (user == null){
                        user = User.builder()
                                .openId(openID).userName(removeNonBmpUnicode(userInfoBean.getNickname()))
                                .imagePath(userInfoBean.getAvatar().getAvatarURL100()).
                                        registerTime(new Date()).build();
                        if (userService.insert(user)){
                            logger.info("注册用户成功！当前注册用户" + user);
                            FileStore store = FileStore.builder().userId(user.getUserId()).build();
                            if (fileStoreService.addFileStore(store) == 1){
                                user.setFileStoreId(store.getFileStoreId());
                                userService.update(user);
                                logger.info("注册仓库成功！当前注册仓库" + store);
                            }
                        } else {
                            logger.error("注册用户失败！");
                        }
                    }else {
                        user.setUserName(removeNonBmpUnicode(userInfoBean.getNickname()));
                        user.setImagePath(userInfoBean.getAvatar().getAvatarURL100());
                        userService.update(user);
                    }
                    logger.info("QQ用户登录成功！"+user);
                    session.setAttribute("loginUser", user);
                    return "redirect:/main";
                } else {
                    logger.error("很抱歉，我们没能正确获取到您的信息，原因是： " + userInfoBean.getMsg());
                    model.addAttribute("msg","很抱歉，我们没能正确获取到您的信息，原因是： " + userInfoBean.getMsg());
                }
            }
        } catch (QQConnectException e) {
            model.addAttribute("msg","登录异常，请联系管理员");
        } finally {
            logger.error("登录失败!");
        }
        return "index";
    }

    /**
     * @Description 处理掉QQ网名中的特殊表情
     * @Author  nanfeng
     * @Date  15:02 2020/3/27
     * @Param [str]
     * @Return java.lang.String
     */
    public String removeNonBmpUnicode(String str) {
        if (str == null) {
            return null;
        }
        str = str.replaceAll("[^\\u0000-\\uFFFF]", "");
        if ("".equals(str)) {
            str = "($ _ $)";
        }
        return str;
    }

    /**
     * @Description 退出登录，清空session
     * @Author  nanfeng
     * @Date  15:02 2020/3/27
     * @Param []
     * @Return java.lang.String
     */
    @GetMapping("/logout")
    public String logout() {
        logger.info("用户退出登录！");
        session.invalidate();
        return "redirect:/";
    }

}
