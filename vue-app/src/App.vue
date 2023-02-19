<template>
  <n-config-provider :theme="theme">
    <n-global-style />
      <router-view />
  </n-config-provider>
</template>

<script lang="ts">
import { defineComponent, computed } from 'vue'
import { useOsTheme, darkTheme } from 'naive-ui'

export default defineComponent({
  setup () {
    const osThemeRef = useOsTheme()
    return {
      theme: computed(() => (osThemeRef.value === 'dark' ? darkTheme : null)),
      osTheme: osThemeRef
    }
  }
})
</script>