<template>

</template>

<script setup>

//初始信息
const formRef = ref();
//表单数据
const formValue = reactive({
  username: "2109961182",
  password: "2109961182",
  imgCode: ""
})
//验证码
const img = reactive({
  imgUrl: '/api/user/imgCode',
  codeTime: 60,
  isCode: false
})
let clear = null
//异步获取验证码
const sendCode = async () => {
  img.isCode = true
  img.imgUrl = '/api/user/imgCode?time=' + new Date()
  clear = setInterval(() => {
    // 每次时间 -1
    img.codeTime--;
    // 时间=0时 清除定时器
    if (img.codeTime === 0) {
      //清除定时器
      clearInterval(clear);
      // 还原 倒计时60s
      img.codeTime = 60;
      img.isCode = false
    }
  }, 1000);
}
//表单校验规则
const rules = reactive({
  rules: {
    username: {
      required: true,
      message: "请输入用户名",
      trigger: "blur"
    },
    password: {
      required: true,
      message: "请输入密码",
      trigger: ["input", "blur"]
    },
    imgCode: {
      required: true,
      message: "请输入验证码",
      trigger: "blur"
    }
  }
})

//登录
const handleValidateClick = (e) => {
  e.preventDefault();
  formRef.value?.validate((errors) => {
    if (!errors) {
      user_login({
        code: formValue.imgCode,
        username: formValue.username,
        password: formValue.password
      }).then(res => {
        if (res.code === 200) {
          ElMessage({
            message: '登录成功 ！！！' + '欢迎您' + formValue.username + '。',
            type: 'success',
          })
          //存入token
          store.setToken(res.msg)
          isLogin.value= false
          showModal.value = false
          //存入用户信息
          UserInfo()
          setTimeout(function () {
            location.reload();
          },500)
        } else {
          ElMessage({
            message: res.result,
            type: 'error',
          })
        }
      })
    } else {
      ElMessage({
        message: errors,
        type: 'error',
      })
    }
  });
}
//获取用户基本信息
const UserInfo =()=>{
  //获取头像基本信息
  user_info().then(res=>{
    if (res.code === 200){
      //存入pinia
      user.setData(res.result)
    }
  })
}
</script>

<style scoped>

</style>