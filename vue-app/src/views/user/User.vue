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
        {{ user_info.username }}
      </template>
      <!--      菜单-->
      <template #action>
        <div class="body">
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
                  @update:value="handleUpdateValue"
                  :collapsed="collapsed"
                  :collapsed-width="64"
                  :collapsed-icon-size="22"
                  :options="menuOptions"
                  key-field="menuName"
                  label-field="menuName"
                  children-field="childNode"
              />
            </n-layout-sider>

            <n-card size="huge">
              <router-view />
            </n-card>
            <n-layout/>
          </n-layout>
        </div>
      </template>
    </n-card>
  </div>

</template>

<script setup>
import {reactive, onMounted, ref} from "vue";
import {userInfo} from "../../store/user/user.js";
import router from "../../router";
//持久化存储
const user = userInfo()
let collapsed = ref(false)
const menuOptions = reactive([])
let user_info = reactive(
    {
      username: '',
      isImg: ''
    })
//选中菜单执行操作
const handleUpdateValue = (key, item) => {
  router.replace(item.menuUrl);
}
onMounted(() => {
  user_info.username = user.$state.data.username
  user_info.isImg = user.$state.data.isImg
  console.log(user.$state.data)
  for (let sysMenusKey in user.$state.data.sysMenus) {
    menuOptions[sysMenusKey] = user.$state.data.sysMenus[sysMenusKey]
  }
})

</script>


<style scoped>
.app {
  width: 70%;
  margin: 0 auto;
}

.body{

}

.right{
  margin-left: 5px;
}
</style>