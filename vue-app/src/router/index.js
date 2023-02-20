import {createRouter, createWebHistory} from "vue-router";
import Home from '../views/Home.vue'
import User from "../views/user/User.vue";
import article from '../views/body/Article.vue'
import BlogList from '../views/body/BlogList.vue'

const routes = [
    {
        path: "/",
        name: "home",
        component: Home,
        redirect:'/index',
        children:[
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
                component: User
            },
        ]
    },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;