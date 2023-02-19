import {defineStore} from 'pinia'

//存储token
export const userStore = defineStore({
    id: 'user',
    //状态
    state: () => {
        return {
            token: ''
        }
    },
    //存储状态
    actions: {
        //设置token
        setToken(token) {
            this.token = token;
        },
        //清除token
        clearToken() {
            this.token = '';
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

//存储用户基本信息
export const userInfo = defineStore({
    id: 'userInfo',
    //状态
    state: () => {
        return {
            data: ''
        }
    },
    //存储状态
    actions: {
        //设置data
        setData(data) {
            this.data = data;
        },
        //清除data
        clearData() {
            this.data = '';
        }
    },
    // 开启数据缓存
    persist: {
        enabled: true,
        strategies: [{
            key: 'blog_userInfo',
            storage: localStorage,
        }]
    }

})

