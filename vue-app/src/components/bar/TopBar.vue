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
              <li @click="showModal = true" v-if="isLogin">
                <n-gradient-text type="info">
                  登录/注册
                </n-gradient-text></li>
              <li v-if="!isLogin">
                  <n-dropdown :options="options" @select="handleSelect">
                    <n-avatar
                        style="margin-top: 5px"
                        round
                        size="small"
                        :src='avatar'
                    />
                  </n-dropdown>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </n-card>
    <n-modal v-model:show="showModal" transform-origin="center" preset="card" style="width: 400px">
    <login />
    </n-modal>
  </div>
</template>
<script setup>
import {ref, reactive,provide, onMounted, markRaw} from 'vue'
import {UserAstronaut} from '@vicons/fa'
import {isToken} from '../../api/user.js'
import {userStore,userInfo} from "../../store/user/user.js";
import router from "../../router";
import login from '../user/User.vue'

//持久化存储
const store = userStore()
const user = userInfo()
//菜单信息
const menu = markRaw([
  {
    menuName: "首页",
    menuURL: "user",
    icon: UserAstronaut
  }
])
//用户菜单
const options =reactive( [
  {
    label: "用户中心",
    key: "profile",
  },
  {
    label: "退出登录",
    key: "logout",
  }
])
//是否显示登录/注册
let isLogin = ref(false)
//头像
let avatar = ref(null)
const handleSelect = (key)=>{
  //用户资料
  if (key === "profile"){
    router.push('/user')
  }
  if (key === "logout"){
    //清除token
    store.clearToken();
    user.clearData();
    router.go(0)
  }
}
//显示登录与注册弹窗
let showModal = ref(false)
onMounted(() => {
  //校验token是否过期
  isToken().then(res => {
    //已经过期
    if (res.code === 601){
      isLogin.value = true
    }
    //未过期
    if (!res){
      isLogin.value= false
      showModal.value = false
      //设置头像
      avatar.value = user.$state.data.isImg
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
  height: 33px;
  margin-top: 27px;
}

.imgTime {
  margin-left: 10px;
}
</style>