import Home from './components/Home.vue'

export const routes = [
    {path: '*', redirect: '/home'},
    {path: '/home', component: Home}
]