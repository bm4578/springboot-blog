<template>
  <div class="app">
    <n-card
        embedded
        hoverable
        :bordered="false"
        :segmented="{
      footer: 'soft'
    }"
    >
      <router-link :to="{name:'article',params:{num:add}}" tag="a"> {{ add }}</router-link>
      <!--      如果你年轻的时候不 996，你什么时候可以 996？你一辈子没有-->
<!--      996，你觉得你就很骄傲了？这个世界上，我们每一个人都希望成功，都希望美好生活，都希望被尊重，我请问大家，你不付出超越别人的努力和时间，你怎么能够实现你想要的成功？-->
      <template #footer>
        <n-tag :bordered="false" type="info" size="small">
          暑夜
        </n-tag>
      </template>
    </n-card>
  </div>
</template>

<script setup>
import {ref} from "vue";

let add = ref("01")
</script>

<style scoped>
.app{
  height: 1300px;
  width: 75%;
  margin: 0 auto;
}
</style>