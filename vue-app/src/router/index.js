import {createRouter, createWebHistory} from "vue-router";
import Home from '../views/Home.vue'
import User from "../views/user/User.vue";
import article from '../views/body/Article.vue'
import BlogList from '../views/body/BlogList.vue'
import {page_menu} from "../api/menu.js";

const routes = [
    {
        path: "/",
        name: "home",
        component: Home,
        redirect: '/index',
        children: [
            {
                path: 'index',
                name: 'blogList',
                component: BlogList
            },
            {
                path: 'article/list/:num',
                name: 'article',
                component: article
            },
            {
                path: "/user",
                name: "user",
                component: User,
                redirect: '/role',
                children:[
                    {
                        path: '/role',
                        component: ()=>import('../views/user/role/UserRole.vue')
                    },{
                        path: '/menu',
                        component: ()=>import('../views/user/menu/UserMenu.vue')
                    }
                ]
            },
        ]
    },
];


//权限菜单

// const  menu = page_menu().then(res=>{
//    res.result.forEach(item=>{
//        console.log(item)
//        routes[0].children.push({
//            path: item.menuUrl
//        })
//    })
// })

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;