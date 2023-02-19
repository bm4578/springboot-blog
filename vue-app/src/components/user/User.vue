<template>
    <n-tabs default-value="signin" size="large" justify-content="space-evenly">
      <n-tab-pane name="signin" tab="登录">
        <n-form
            ref="formRef"
            :model="formValue"
            :rules="rules.rules"
        >
          <n-form-item label="用户名" path="username">
            <n-input v-model:value="formValue.username" placeholder="输入用户名"/>
          </n-form-item>

          <n-form-item label="密码" path="password">
            <n-input type="password"  v-model:value="formValue.password"
                     placeholder="输入密码"/>
          </n-form-item>
          <div class="imgCode">
            <n-form-item label="验证码" path="imgCode">
              <n-input v-model:value="formValue.imgCode" placeholder="输入用户名"/>
            </n-form-item>
            <img :src="img.imgUrl" alt="加载失败" style="margin-left: 5px"/>
            <n-button
                text
                tag="a"
                v-if="!img.isCode"
                @click="sendCode"
                target="_blank"
                type="primary"
            >
              重新获取
            </n-button>
            <n-button
                text
                tag="a"
                v-if="img.isCode"
                target="_blank"
                type="info"
                class="imgTime"
            >
              剩余{{ img.codeTime }}秒
            </n-button>

          </div>
        </n-form>
        <n-button type="primary" block secondary strong @click="handleValidateClick">
          登录
        </n-button>

      </n-tab-pane>
      <n-tab-pane name="signup" tab="注册">
        <n-form>
          <n-form-item label="用户名">
            <n-input/>
          </n-form-item>
          <n-form-item label="密码">
            <n-input/>
          </n-form-item>
          <n-form-item label="重复密码">
            <n-input/>
          </n-form-item>
        </n-form>
        <n-button type="primary" block secondary strong>
          注册
        </n-button>
      </n-tab-pane>
    </n-tabs>
</template>
<script setup>
import {ref, reactive,inject} from 'vue'
import {user_login, isToken,user_info} from '../../api/user.js'
import {userStore,userInfo} from "../../store/user/user.js";
import router from "../../router";
import {ElMessage,ElNotification} from 'element-plus'

//持久化存储
const store = userStore()
const user = userInfo()

//显示登录与注册弹窗
let showModal = ref(false)


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
          //存入token
          store.setToken(res.msg)
          //存入用户信息
          UserInfo()
          setTimeout(function () {
            // location.reload();
            router.go(0)
          },100)
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
.imgCode {
  display: flex;
}

.imgCode img {
  width: 90px;
  height: 33px;
  margin-top: 27px;
}

.imgTime {
  margin-left: 10px;
}
</style>