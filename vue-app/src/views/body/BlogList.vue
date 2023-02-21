<template>
  <div class="app">
    <n-card
        style="margin-top: 20px"
        v-for="item in article_list.blogList"
        embedded
        hoverable
        :bordered="false"
        :segmented="{
      footer: 'soft'
    }"
    >
      <router-link :to="{name:'article',params:{num:add}}" tag="a">
        {{ item.articleTitle }}
      </router-link>
      <template #footer>
        <n-tag :bordered="false" type="info" size="small">
          {{item.articleType}}
        </n-tag>
      </template>
    </n-card>
  </div>
</template>

<script setup>
import {ref,reactive,onMounted} from "vue";

import {articleList} from "../../api/article";
let add = ref("01")
let article_list = reactive(
    {
      pageIndex:'',
      pageSize:'',
      total:'',
      blogList:[],
    }
)

onMounted(() => {
  articleList(1,2).then(res=>{
    article_list.pageIndex= res.result.pageIndex
    article_list.pageSize= res.result.pageSize
    article_list.total=res.result.total
    article_list.blogList= res.result.rows
  })
})
</script>

<style scoped>
.app{
  height: 1300px;
  width: 75%;
  margin: 0 auto;
}
</style>