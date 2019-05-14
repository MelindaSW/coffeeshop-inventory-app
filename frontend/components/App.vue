<template>
   <div class="">
      <nav-bar></nav-bar>
      <router-view></router-view>
   </div>
</template>

<script>
   import Start from './Start.vue'
   import AddCoffee from './AddCoffee.vue'
   import EditCoffee from './EditCoffee.vue'
   import NavBar from './NavBar.vue'

   export default {
      components: {
         'add-coffee': AddCoffee,
         'edit-coffee': EditCoffee,
         'start': Start,
         'nav-bar': NavBar
      }
   }
</script>

<style lang="css">
</style>