import axios from 'axios';
import {ElMessage} from 'element-plus'
import {userStore,userInfo} from "../store/user/user.js";

//1. 创建axios对象
const service = axios.create();

//2. 请求拦截器
service.interceptors.request.use(config => {
    const store = userStore();
    let userToken = store.token;
    if (userToken){
        config.headers['token'] = userToken;
    }
    return config;
}, error => {
    Promise.reject(error);
});

//3. 响应拦截器
service.interceptors.response.use(response => {
    //判断code码
    if (response.data.code === 601){
        const store = userStore()
        const user = userInfo()
        store.clearToken();
        user.clearData();
    }
    return response.data;
},error => {
    return Promise.reject(error);
});

export default service;