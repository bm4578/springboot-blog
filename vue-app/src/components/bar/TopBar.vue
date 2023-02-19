<template>
  <div class="app">
    <n-card size="small">
      <div class="bar">
        <!--左侧-->
        <div class="left">
          <div class='content-nav'>
            <ul>
              <li>logo</li>
            </ul>
          </div>
        </div>
        <!--右侧-->
        <div class="right">
          <div class='content-nav'>
            <ul>
              <li v-for="item in menu">
                <router-link :to="item.menuURL">
                  <n-icon size="18" :component="item.icon"/>
                  {{ item.menuName }}
                </router-link>
              </li>
              <li @click="showModal = true" v-if="isLogin">登录/注册</li>
              <li v-if="!isLogin">已登录</li>
            </ul>
          </div>
        </div>
      </div>
    </n-card>

    <n-modal v-model:show="showModal" transform-origin="center" preset="card" style="width: 400px">

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
              <n-input type="password" @input="handlePasswordInput" v-model:value="formValue.password"
                       placeholder="输入密码"/>
            </n-form-item>
            <div class="imgCode">
              <n-form-item label="验证码" path="imgCode">
                <n-input v-model:value="formValue.imgCode" placeholder="输入用户名"/>
              </n-form-item>
              <img :src="img.imgUrl" alt="加载失败"/>
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
    </n-modal>
  </div>
</template>
<script setup>
import {ref, reactive, h, onMounted, markRaw, watch} from 'vue'
import {UserAstronaut} from '@vicons/fa'
import {user_login, isToken} from '../../api/user.js'
import {userStore} from "../../store/user/user.js";
import router from "../../router";
import {ElMessage, ElButton} from 'element-plus'
import {storeToRefs} from 'pinia'
//持久化存储
const store = userStore()
//菜单信息
const menu = markRaw([
  {
    menuName: "首页",
    menuURL: "user",
    icon: UserAstronaut
  }
])
//登录注册
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
          ElMessage({
            message: '登录成功 ！！！' + '欢迎您' + formValue.username + '。',
            type: 'success',
          })
          store.setToken(res.msg)
          isLogin.value= false
          showModal.value = false
          router.go(0)
        } else {
          ElMessage({
            message: res.result,
            type: 'error',
          })
        }
      })
    } else {
      console.log(errors);
    }
  });
}

//是否显示登录/注册
let isLogin = ref(false)
onMounted(() => {
  //校验token是否过期
  isToken().then(res => {
    //已经过期
    if (res.code === 601){
      store.clearToken();
      isLogin.value = true
    }
    //未过期
    if (!res){
      isLogin.value= false
    }
  })
})

</script>

<style scoped>
.app {
  position: fixed;
  z-index: 10;
  left: 0;
  right: 0;
  top: 0;
}

.bar {
  width: 65%;
  margin: 0 auto;
  display: flex;
}

.right {
  margin-left: 40%;
}

.content-nav {
  width: 300px;
  height: 65px;
}

.content-nav ul {
  display: flex;
  justify-content: space-around;
  align-items: center;
  width: 100%;
  height: 65px;
}

.content-nav ul li {
  font-size: 18px;
}

.imgCode {
  display: flex;
}

.imgCode img {
  width: 90px;
  height: 34px;
  margin-top: 25px;
}

.imgTime {
  margin-left: 10px;
}
</style>