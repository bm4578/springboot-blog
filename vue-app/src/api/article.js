import request from '../utils/request.js'
import qs from 'qs';

//分页查询首页文章
export function articleList(pageNum,pageSize) {
    return request({
        url: '/api/article/all/'+pageNum+'/'+pageSize,
        method: "get",
    })
}