<template>
  <n-button @click="createMessage">
    漏斗图标
  </n-button>
</template>

<script lang="ts">
import { defineComponent, h } from 'vue'
import { NIcon, useMessage } from 'naive-ui'

export default defineComponent({
  setup () {
    const  msg = window.$message = useMessage()
    return {
      createMessage () {
        msg.warning("I never needed anybody's help in any way")
      }
    }
  }
})
</script>