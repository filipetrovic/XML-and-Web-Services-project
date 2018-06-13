import HomeComponent from './components/pages/HomeComponent.vue'
import UpdateCodesComponent from './components/pages/providedServices/UpdateCodesComponent.vue'
import ApproveCommentsComponent from './components/pages/providedServices/ApproveCommentsComponent.vue'
import ActivateUsersComponent from './components/pages/providedServices/ActivateUsersComponent.vue'
import AddAgentsComponent from './components/pages/providedServices/AddAgentsComponent.vue'

export const routes = [
    {path: '*', redirect: '/home'},
    {path: '/home', component: HomeComponent},
    {path: '/updateCodes', component: UpdateCodesComponent},
    {path: '/approveComments', component: ApproveCommentsComponent},
    {path: '/activateUsers', component: ActivateUsersComponent},
    {path: '/addAgents', component: AddAgentsComponent},

]
