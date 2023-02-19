import request from '../utils/request.js'
import qs from 'qs';

export function user_login(data){
    return request({
        url:'/api/user/login',
        method:"post",
        data:qs.stringify(data)
    })
}
//校验token是否过期
export function isToken(){
    return request({
        url:'/api/token/',
        method:"post",
    })
}
export function user_info(data){
    return request({
        url:'/api/file',
        method:"get",
        data:qs.stringify(data)
    })
}