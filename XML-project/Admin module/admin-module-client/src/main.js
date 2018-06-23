// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import VueResource from 'vue-resource';
import VueRouter from 'vue-router';
import VeeValidate from 'vee-validate';




import './assets/scss/globals/index.scss';
import {routes} from './routes';
import {store} from './store';

const router = new VueRouter({
  routes : routes,
  mode: 'history'
})

router.beforeEach(function (to, from, next) {
  if (to.matched.some(record => record.meta.mustBeLoggedIn)) {

    if (store.state.loggedUser === null){
      alert("You must log in to access this service!")
      next('/login');
    } else {
      setTimeout(() => {
        window.scrollTo(0, 0);
        next();
      }, 100);
    }
  } else {
      setTimeout(() => {
        window.scrollTo(0, 0);
        next();
      }, 100);
  }
  // if( this.$store.state.loggedUser === null){
  //   console.log("You must be logged in to access this service");
  //   next();
  // } else {
  //   setTimeout(() => {
  //     window.scrollTo(0, 0);
  //     next();
  //   }, 100);
  // }
});

Vue.config.productionTip = false
Vue.use(VueResource);
Vue.use(VueRouter);
Vue.use(VeeValidate);

new Vue({
  el: '#app',
  components: { App },
  router,
  store,
  template: '<App/>'
})
