<template>
  <div class="app">
    <n-card size="huge">
      <template #cover>
        <n-avatar
            round
            :size="48"
            :src='user_info.isImg'
            style="margin: 40px 0 10px 40px"
        />
        {{user_info.username}}
      </template>

      <template #action>
        <n-layout has-sider>
          <n-layout-sider
              bordered
              collapse-mode="width"
              :collapsed-width="64"
              :width="240"
              :collapsed="collapsed"
              show-trigger
              @collapse="collapsed = true"
              @expand="collapsed = false"
          >
            <n-menu
                :collapsed="collapsed"
                :collapsed-width="64"
                :collapsed-icon-size="22"
                :options="menuOptions"
                key-field="whateverKey"
                label-field="menuName"
                children-field="childNode"
            />
          </n-layout-sider>
          <n-layout />
        </n-layout>
      </template>
    </n-card>
  </div>

</template>

<script setup>
import {reactive, onMounted, ref} from "vue";
import {userInfo} from "../../store/user/user.js";
//持久化存储
const user = userInfo()
let collapsed = ref(false)
const  menuOptions = reactive([])
let user_info= reactive(
  {
    username:'',
    isImg:''
  })
onMounted(()=>{
  user_info.username=user.$state.data.username
  user_info.isImg=user.$state.data.isImg
  for (let sysMenusKey in user.$state.data.sysMenus) {
    menuOptions[sysMenusKey] = user.$state.data.sysMenus[sysMenusKey]
  }
  console.log(user.$state.data.sysMenus)
})

</script>


<style scoped>
.app {
  width: 70%;
  margin: 0 auto;
}
</style>