// new Vue ({
//
//   el: '#app',
//
//   data: {
//     products: [],
//     brand: null,
//     roasting: null,
//     description: null,
//     price: null
//   },
//
//   created() {
//   fetch('http://localhost:8080/webapp/resources/cbt')
//     .then(response => response.json())
//     .then(result => {
//       this.products = result
//     })
//   },
//
//   methods: {
//     getCoffeeList() {
//       fetch('http://localhost:8080/webapp/resources/cbt')
//         .then(response => response.json())
//         .then(result => {
//           this.products = result
//         })
//     },
//     addCoffee() {
//       fetch('http://localhost:8080/webapp/resources/cbt', {
//         body: JSON.stringify({
//           "productName": this.name ,
//           "brand": this.brand,
//           "roasting": this.roasting,
//           "description": this.description,
//           "price": this.price
//         }),
//         headers: {
//           "Content-Type": 'application/json'
//         },
//         method: 'POST'
//       })
//         .then(response => response.json())
//           .then(result => {
//             this.productName = result
//           })
//         }
//
//     }
// })

import Vue from 'vue'
import App from '../components/App.vue'
// import store from './store.js'
import router from './router.js'
import '../style/index.scss'
// Vue.config.devtools = true

new Vue ({
   el: '#app',
   render: h => h(App),
   router,
   // store
})