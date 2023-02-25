import request from '../../utils/request.js'

//获取首页菜单信息
export function page_menu(){
    return request({
        url:'/api/article/menu',
        method:"get",
    })
}