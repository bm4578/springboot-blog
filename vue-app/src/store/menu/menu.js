import {defineStore} from 'pinia'

//存储token
export const menuStore = defineStore({
    id: 'menu',
    //状态
    state: () => {
        return {
            menu: ''
        }
    },
    //存储状态
    actions: {
        //设置menu
        setMenu(menu) {
            this.menu = menu;
        },
        //清除menu
        clearMenu() {
            this.Menu = '';
        }
    },
    // 开启数据缓存
    persist: {
        enabled: true,
        strategies: [{
            key: 'menu',
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

