import {createRouter, createWebHistory} from "vue-router";
import Home from '../views/Home.vue'
import User from "../views/User.vue";


const routes = [
    {
        path: "/",
        name: "home",
        component: Home
    },  {
        path: "/user",
        name: "user",
        component: User
    },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;