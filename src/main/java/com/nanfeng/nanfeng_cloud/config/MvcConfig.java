package com.nanfeng.nanfeng_cloud.config;

import com.nanfeng.nanfeng_cloud.component.LoginHandlerInterceptor;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * @Description 配置I/O数据
     * @Author  nanfeng
     * @Date  13:09 2020/3/27
     * @Param []
     * @Return javax.servlet.MultipartConfigElement
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大
        factory.setMaxFileSize(DataSize.parse("1024000KB"));
        /// 设置总上传数据总大小
        factory.setMaxRequestSize(DataSize.parse("1024000KB"));
        return factory.createMultipartConfig();
    }

    /**
     * @Description 注册视图控制器
     * @Author  nanfeng
     * @Date  13:09 2020/3/27
     * @Param [registry]
     * @Return void
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //param1：路径，param2：名称
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
    }

    /**
     * @Description  注册登录拦截器 addPathPatterns() -> 拦截的请求  excludePathPatterns -> 不拦截的请求
     * @Author nanfeng
     * @Date 15:10 2020/2/26
     * @Param [registry]
     * @return void
     **/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns(
                        "/","index.html","/login","/file/share","/connection","/error","/favicon.ico",
                        "/asserts/**","/**/*.css", "/**/*.js", "/**/*.png ", "/**/*.jpg","/viewOffice"
                        ,"/**/*.jpeg","/**/*.gif", "/**/fonts/*", "/**/*.svg");
    }
}
