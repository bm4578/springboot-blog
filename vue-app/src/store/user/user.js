import { defineStore } from 'pinia'

//存储token
export const userStore = defineStore({
    id: 'user',
    state: () => {
        return {
            token: ''
        }
    },
    actions:{
        //设置token
        setToken( token ){
            this.token = token;
        },
        //清除token
        clearToken(){
            this.token='';
        }
    },
    // 开启数据缓存
    persist: {
        enabled: true,
        strategies: [{
            key: 'blog_user',
            storage: localStorage,
            // paths: ['token']
        }]
    }
})

