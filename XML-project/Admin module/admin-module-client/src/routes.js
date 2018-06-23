import HomeComponent from './components/pages/HomeComponent.vue'
import UpdateCodesComponent from './components/pages/providedServices/UpdateCodesComponent.vue'
import ApproveCommentsComponent from './components/pages/providedServices/ApproveCommentsComponent.vue'
import ActivateUsersComponent from './components/pages/providedServices/ActivateUsersComponent.vue'
import AddAgentsComponent from './components/pages/providedServices/AddAgentsComponent.vue'
import LoginComponent from './components/pages/providedServices/LoginComponent.vue'
import {store} from './store';

export const routes = [
    {path: '*', redirect: '/login'},
    {path: '', component: LoginComponent},
    {path: '/home', component: HomeComponent, meta: {mustBeLoggedIn: true}},
    {path: '/updateCodes', component: UpdateCodesComponent,  meta: {mustBeLoggedIn: true} },
    {path: '/approveComments', component: ApproveCommentsComponent, meta: {mustBeLoggedIn: true} },
    {path: '/activateUsers', component: ActivateUsersComponent, meta: {mustBeLoggedIn: true}},
    {path: '/addAgents', component: AddAgentsComponent,  meta: {mustBeLoggedIn: true}},
    {path: '/login', component: LoginComponent},

]

// function checkAuth(to,from,next){
//   console.log("Usao dobro !!!!")
//   console.log(store.state.loggedUser)
//   if (store.state.loggedUser === null) {
//     console.log("redirect");
//     next('')  // they are not authorized, so redirect to login
//   } else {
//     console.log('continue');
//     next() // we are authorized, continue on to the requested route
//  }
// }
