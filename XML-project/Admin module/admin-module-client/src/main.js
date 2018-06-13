// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import VueResource from 'vue-resource';
import VueRouter from 'vue-router';

import './assets/scss/globals/index.scss';
import {routes} from './routes';
import {store} from './store';

const router = new VueRouter({
  routes : routes,
  mode: 'history'
})

router.beforeEach(function (to, from, next) {
  setTimeout(() => {
      window.scrollTo(0, 0);
  }, 100);
  next();
});

Vue.config.productionTip = false
Vue.use(VueResource);
Vue.use(VueRouter);


new Vue({
  el: '#app',
  components: { App },
  router,
  store,
  template: '<App/>'
})
