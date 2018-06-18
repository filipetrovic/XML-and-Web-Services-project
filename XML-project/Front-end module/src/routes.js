import Home from './components/Home.vue'
import Registration from './components/Registration.vue'
import Accommodations from './components/Accommodations.vue'
import Login from './components/Login.vue'
import Profile from './components/Profile.vue'

export const routes = [
    {path: '*', redirect: '/home'},
    {path: '/home', component: Home},
    {path: '/registration', component: Registration},
    {path: '/login', component: Login},
    {path: '/accommodations', component: Accommodations},
    {path: '/profile', component: Profile}
]