import Home from './components/Home.vue'
import Registration from './components/Registration.vue'
import Accommodations from './components/Accommodations.vue'

export const routes = [
    {path: '*', redirect: '/home'},
    {path: '/home', component: Home},
    {path: '/registration', component: Registration},
    {path: '/accommodations', component: Accommodations}
]