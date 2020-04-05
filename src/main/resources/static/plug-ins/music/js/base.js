$(function () {
    var audio = document.getElementById('audio-my');
    var audioPlay = false;
    var audioMax = false;
    var audioIndex = 0;
    var audioText = new Array();
    var audioLoop = false;
    var outTextValue = 0;
    var audioSpeed = 1.8;
    function drawAudioArc() {
        var audioCanvas = document.getElementById('audio-img-canvas');
        var audioCtx = audioCanvas.getContext('2d');
        audioCtx.translate(100, 100);
        audioCtx.strokeStyle = 'rgba(255,255,255,1)';
        audioCtx.lineWidth= '6';
        audioCtx.arc(0, 0, 80, 0, Math.PI*2, true);
        audioCtx.stroke();
        audioCtx.beginPath();
        audioCtx.lineWidth= '3';
        audioCtx.arc(0,0,72,Math.PI/6, Math.PI/6*4, false);
        audioCtx.stroke();
        audioCtx.beginPath();
        audioCtx.arc(0,0,72,Math.PI/6*9, Math.PI/6*6, true);
        audioCtx.stroke();
        audioCtx.beginPath();
        audioCtx.lineWidth= '2';
        audioCtx.arc(0,0,50,Math.PI/6*9, Math.PI/6*11, true);
        audioCtx.stroke();
    }
    function drawAudioPlay() {
        var audioCanvasPlay = document.getElementById('audio-img-canvas-play');
        var audioCtxPlay = audioCanvasPlay.getContext('2d');
        audioCtxPlay.translate(25, 10);
        audioCtxPlay.lineWidth= '4';
        audioCtxPlay.strokeStyle = 'rgba(255,255,255,1)';
        audioCtxPlay.rect(-10,0,20,20);
        audioCtxPlay.stroke();
        audioCtxPlay.beginPath();
        audioCtxPlay.rect(-10,20,20,10);
        audioCtxPlay.stroke();
        audioCtxPlay.beginPath();
        audioCtxPlay.moveTo(0,30);
        audioCtxPlay.lineTo(0,140);
        audioCtxPlay.stroke();
        audioCtxPlay.beginPath();
        audioCtxPlay.translate(0, 140);
        audioCtxPlay.rotate(120);
        audioCtxPlay.rect(0,0,18,32);
        audioCtxPlay.stroke();
        audioCtxPlay.beginPath();
        audioCtxPlay.lineWidth= '2';
        audioCtxPlay.moveTo(10,25);
        audioCtxPlay.lineTo(30,25);
        audioCtxPlay.stroke();
        audioCtxPlay.beginPath();
    }
    function playAudio(){
        if(audio.paused || audio.ended) {
            audioPlay = true;
            audio.play();
            $('.audio-btn-play').removeClass('audio-btn-play-off').addClass('audio-btn-play-on');
        }
        else {
            audioPlay = false;
            $('.audio-btn-play').removeClass('audio-btn-play-on').addClass('audio-btn-play-off');
            audio.pause();
        }
        $('#audio-img-canvas-play').toggleClass('audio-img-canvas-play-on');
        $('#audio-img-canvas').toggleClass('audio-img-canvas-on');
    }

    function timeFormat(seconds) {
        var minite = Math.floor(seconds / 60);
        if(minite < 10) {
            minite = "0" + minite;
        }
        var second = Math.floor(seconds % 60);
        if(second < 10) {
            second = "0" + second;
        }
        return minite + ":" + second;
    }

    function updateProgress(x){
        var progress = $('.audio-by-all');
        var position = x - progress.offset().left;
        var percentage = 100 * position / progress.width();
        if(percentage > 100) {
            percentage = 100;
        }
        if(percentage < 0) {
            percentage = 0;
        }
        $('.audio-by-now').css('width', percentage+'%');
        audio.currentTime = audio.duration * percentage / 100;
    }

    function enableProgressDrag() {
            var progressDrag = false;
            $('.audio-by-all').on('mousedown', function(e) {
                progressDrag = true;
                updateProgress(e.pageX);
            });
            $(document).on('mouseup', function(e) {
                if(progressDrag) {
                    progressDrag = false;
                    updateProgress(e.pageX);
                }
            });
            $(document).on('mousemove', function(e) {
                if(progressDrag) {
                    updateProgress(e.pageX);
                }
            });
    };

    function enableSoundDrag() {
            var volumeDrag = false;
            $('.audio-sound').on('mousedown', function(e) {
                volumeDrag = true;
                updateVolume(e.pageX);
            });
            $(document).on('mouseup', function(e) {
                if(volumeDrag) {
                    volumeDrag = false;
                    updateVolume(e.pageX);
                }
            });
            $(document).on('mousemove', function(e) {
                if(volumeDrag) {
                    updateVolume(e.pageX);
                }
            });
    };
    function updateVolume(x, vol) {
        var volume = $('.audio-sound');
        var soundLeft = x - volume.offset().left;
        var percentage;
        if(vol) {
            percentage =vol * 100;
        } else {
            var position = soundLeft;
            percentage = 100 * position / volume.width();
        }
        if(percentage > 100) {
            percentage = 100;
        }
        if(percentage < 0) {
            percentage = 0;
        }
        percentage = parseInt(percentage);
        $('.audio-sound-now').css('width', percentage + '%');
        $('.audio-sound-art').css('left', percentage + '%');
        audio.volume = percentage / 100;
    };
    function audioTextOut() {
        if(audioMax){
            var audioTextWidth = $('.audio-head-tittle-text-out-a').width();
            var audioTittleWidth = $('.audio-head-tittle-text').width();
        } else {
            var audioTextWidth = $('.audio-head-tittle-text-out').width();
            var audioTittleWidth = $('.audio-head-tittle-text').width();
        }
        if((audioTextWidth > audioTittleWidth) && !audioMax){
            if(outTextValue <= -(audioTextWidth - audioTittleWidth + 8)){
                audioSpeed = -audioSpeed;
            }
            if(outTextValue >= 8){
                audioSpeed = -audioSpeed;
            }
            outTextValue -= audioSpeed;
            var outText = outTextValue + 'px';
            $('.audio-head-tittle-text').css('text-indent', outText);
        }
        if((audioTextWidth > audioTittleWidth) && audioMax){
            if(outTextValue <= -(audioTextWidth - audioTittleWidth + 20)){
                audioSpeed = -audioSpeed;
            }
            if(outTextValue >= 20){
                audioSpeed = -audioSpeed;
            }
            outTextValue -= audioSpeed;
            var outText = outTextValue + 'px';
            $('.audio-head-tittle-text').css('text-indent', outText);
        }
    }

    drawAudioArc();
    drawAudioPlay();
    updateVolume(0, 0.5);
    $('#audio-my').on("loadedmetadata", function(){
        $('.audio-by-text-now').text(timeFormat(0));
        $('.audio-by-text-all').text(timeFormat(audio.duration));
        enableProgressDrag();
        enableSoundDrag();
    });
    $('.audio-by-text-now').text(timeFormat(0));
    $('.audio-by-text-all').text(timeFormat(audio.duration));
    $('#audio-my').on("timeupdate", function(){
        var currentTime = audio.currentTime;
        var duration = audio.duration;
        var percent = 100 * currentTime / duration;
        $('.audio-by-now').css('width', percent + '%');
        $('.min-time').css('width', percent+'%');
        $('.audio-by-text-now').text(timeFormat(currentTime));
        audioTextOut();
    });
    $('#audio-img-canvas-play').on('click', function () {
        playAudio();
    });
    $('.audio-btn-play').on('click', function () {
        playAudio();
    });
    $('.audio-btn-sound').on('click', function () {
        $('.audio-sound').toggleClass('audio-sound-on');
    });
    $('.audio-btn-list').on('click', function () {
        if (!audioLoop){
            $('.audio-btn-list').removeClass('audio-btn-list-off').addClass('audio-btn-list-on');
        } else {
            $('.audio-btn-list').removeClass('audio-btn-list-on').addClass('audio-btn-list-off');
        }
        audioLoop = ! audioLoop;
    });
    $("#audio").hover(function() {
        $('.audio').toggleClass('audio-off');
        $('.audio-img-cover').toggleClass('audio-img-cover-off');
        $('.audio-btn-play').toggleClass('audio-btn-play-off-a');
        $('.audio-head-tittle-by').toggleClass('audio-head-tittle-by-off');
        $('.audio-head-tittle').toggleClass('audio-head-tittle-off');
        $('.min-time').toggleClass('min-time-off');
        $('.audio-head-tittle-text').toggleClass('audio-head-tittle-text-off');
        $('.audio-btn-play').css('animation', '');
        audioMax = !audioMax;
        $('.audio-head-tittle-text').css('text-indent', 0);
        outTextValue = 0;
        audioSpeed = Math.abs(audioSpeed);
    });
    $("#audio").mouseleave(function() {
        if(audioPlay){
            $('.audio-btn-play').css('animation', 'img-cover linear 2.5s infinite');
        }
        $('.audio-sound').removeClass('audio-sound-on');
    })
});
