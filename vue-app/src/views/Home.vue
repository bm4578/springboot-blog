<template>
  <n-space vertical size="large">
    <n-layout>
      <!-- 头部-->
      <n-layout-header><TopBar /></n-layout-header>
      <!--身体-->
      <n-layout-content><BlogList /></n-layout-content>
      <!--底栏-->
      <n-layout-footer><BottomBar /></n-layout-footer>
    </n-layout>
  </n-space>
</template>

<script setup>
import TopBar from '../components/bar/TopBar.vue'
import BlogList from '../components/body/BlogList.vue'
import BottomBar from "../components/bottom/BottomBar.vue";
</script>