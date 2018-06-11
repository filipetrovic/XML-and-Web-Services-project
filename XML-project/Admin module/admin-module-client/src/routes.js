import HelloWorld from './components/HelloWorld.vue'

export const routes = [
    {path: '*', redirect: '/home'},
    {path: '/home', component: HelloWorld}
]