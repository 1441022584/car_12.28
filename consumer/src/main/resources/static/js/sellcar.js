
/**
 * @description: 登录弹窗
 */
$('#login').on('click', function () {
  $('#login_modal').slideDown('fast')
})

$('#closeLogin').on('click', function () {
  $('#login_modal').slideUp('fast')
})

/**
 * @description: 获取验证码
 */

$('#code').on('click', function () {
    // 获取手机号
    var phone_number = $('#phone_num').val()
    if (!phone_number) {
        bootbox.alert({
            size: "small",
            title: "提示",
            message: "请输入手机号!",
        });
        return;
    }
     secs = 60; // 设置多少秒
     wait = secs * 100;
    document.getElementById("code").disabled = true;
    for (i = 1; i <= secs; i++) {
        if (i == 1) {
            window.setTimeout("doUpdate(" + i + ")");
        }	 //立马进入倒计时
        window.setTimeout("doUpdate(" + i + ")", (i - 1) * 1000);
    }
    window.setTimeout("Timer()", wait);
    // 发送ajax 请求 ，字段可以自己定义，接口地址按项目填
    $.ajax({
        url: '../getCode',
        type: 'post',
        data: {
            phone_number: phone_number
        },
        success: function (data) {
            console.log(data)
        },
        error: function (data) {
            console.log(data)
        }
    })
})

function Timer() {
    document.getElementById("code").disabled =false;
}
function doUpdate(code) {
    if(code == (wait/100)) {
        document.getElementById("code").style.setProperty('background', '#22ac38');
        document.getElementById("code").style.setProperty('pointer-events', 'auto');
        document.getElementById("code").innerHTML = "获取验证码";
    } else {
        document.getElementById("code").style.setProperty('background', '#a7a7a7');
        document.getElementById("code").style.setProperty('pointer-events', 'none');

        wut = (wait/100)-code;
        document.getElementById("code").innerHTML  = wut + "s";
    }
}



// 点击登录
$('#login_but').on('click', function (e) {
  // 组织表单默认事件
  e.stopPropagation()
  var phone_number = $('#phone_num').val() // 获取手机号
  var login_code = $('#login_code').val() // 获取验证码
  if (!phone_number) {
      bootbox.alert({
          size: "small",
          title: "提示",
          message: "请输入手机号!",
      });
    return
  }
  if (!login_code) {
      bootbox.alert({
          size: "small",
          title: "提示",
          message: "请输入验证码!",
      });
    return
  }

  // 发送ajax 请求 ，字段可以自己定义，接口地址按项目填
  $.ajax({
    url: '../login',
    type: 'post',
    data: {
      login_code: login_code
    },
    dataType: 'json',
    success: function (data) {
          if (data){
            location.href=location;
          } else{
              bootbox.alert({
                  size: "small",
                  title: "提示",
                  message: "验证码错误!",
              });
          }
    },
    error: function (data) {

    }
  })

})


//关闭
$('#closeLogin2').on('click', function () {
    $('#login_modal2').slideUp('fast')
})
//点击获取手机号
$('#code2').on('click', function () {
    // 获取手机号
    var phone_number = $('#phone_num2').val()
    if (!phone_number) {
        bootbox.alert({
            size: "small",
            title: "提示",
            message: "请输入手机号!",
        });
        return;
    }
    scount = 60; // 设置多少秒
    wait2 = scount * 100;
    document.getElementById("code2").disabled = true;
    for (i = 1; i <= scount; i++) {
        if (i == 1) {
            window.setTimeout("doUpdate2(" + i + ")");
        }	 //立马进入倒计时
        window.setTimeout("doUpdate2(" + i + ")", (i - 1) * 1000);
    }
    window.setTimeout("Timer2()", wait2);
    // 发送ajax 请求 ，字段可以自己定义，接口地址按项目填
    $.ajax({
        url: '../getCode',
        type: 'post',
        data: {
            phone_number: phone_number
        },
        success: function (data) {
            console.log(data)
        },
        error: function (data) {
            console.log(data)
        }
    })
})

function Timer2() {
    document.getElementById("code2").disabled =false;
}
function doUpdate2(code) {
    if(code == (wait2/100)) {
        document.getElementById("code2").style.setProperty('background', '#22ac38');
        document.getElementById("code2").style.setProperty('pointer-events', 'auto');
        document.getElementById("code2").innerHTML = "获取验证码";
    } else {
        document.getElementById("code2").style.setProperty('background', '#a7a7a7');
        document.getElementById("code2").style.setProperty('pointer-events', 'none');

        wut = (wait2/100)-code;
        document.getElementById("code2").innerHTML  = wut + "s";
    }
}
//点击确认电话号码
$('#login_but2').on('click', function (e) {
    // 组织表单默认事件
    e.stopPropagation()
    var userId=$("#useridhidden").val()
    var phone_number = $('#phone_num2').val() // 获取手机号
    var login_code = $('#login_code2').val() // 获取验证码
    if (!phone_number) {
        bootbox.alert({
            size: "small",
            title: "提示",
            message: "请输入手机号!",
        });
        return
    }
    if (!login_code) {
        bootbox.alert({
            size: "small",
            title: "提示",
            message: "请输入验证码!",
        });
        return
    }

    $.ajax({
        url: '../confirmPhone',
        type: 'post',
        data: {
            login_code: login_code,
            phone_number:phone_number,
            userId:userId
        },
        dataType: 'json',
        success: function (data) {
            if (data){
                bootbox.alert({
                    size: "small",
                    title: "提示",
                    message: "确认卖车成功!我们会在2-3个工作日与您联系,请保持手机通畅!",
                });
                location.href=location;
            } else{
                bootbox.alert({
                    size: "small",
                    title: "提示",
                    message: "验证码错误,请重新输入!",
                });
            }
        },
        error: function (data) {

        }
    })

})
