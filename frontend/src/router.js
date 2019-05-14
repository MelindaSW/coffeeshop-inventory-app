import Vue from 'vue'
import Router from 'vue-router'

import Start from '../components/Start.vue'
import AddCoffee from '../components/AddCoffee.vue'
import EditCoffee from '../components/EditCoffee.vue'


Vue.use(Router)

export default new Router({
   routes: [{
      component: Start,
      path: '/'
   },{
      component: AddCoffee,
      path: '/add'
   },{
      component: EditCoffee,
      path: '/edit'
   }]
})