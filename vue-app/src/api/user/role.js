import request from '../../utils/request.js'

//获取首页菜单信息
export function query_Role(){
    return request({
        url:'/api/article/menu',
        method:"get",
    })
}