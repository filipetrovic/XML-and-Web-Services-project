import HomeComponent from './components/HomeComponent.vue';
import AddUnitsComponent from './components/providedServices/AddUnitsComponent.vue';
import LoginComponent from './components/providedServices/LoginComponent.vue';
import ReservationsComponent from './components/providedServices/ReservationsComponent.vue';

export const routes = [
    {path: '*', redirect: '/home'},
    {path: '/home', component: HomeComponent},
    {path: '/addUnits', component: AddUnitsComponent},
    {path: '/login', component: LoginComponent},
    {path: '/reservations', component: ReservationsComponent},

]
