<template>
  <div class="columns is-centered">
     <div class="column is-one-third">
        <h1 class="title">ADD A PRODUCT</h1>
       <div class="field">
         <label class="label">Name of product</label>
         <div class="control">
          <input class="input" type="text" placeholder="Text input">
         </div>
      </div>

      <div class="field">
        <label class="label">Brand</label>
        <div class="control">
          <input class="input" type="text" placeholder="Text input">
        </div>
      </div>

      <div class="field">
        <label class="label">Roasting</label>
        <div class="control">
          <input class="input" type="text" placeholder="Roasting">
        </div>
      </div>

      <div class="field">
        <label class="label">Description</label>
        <div class="control">
          <input class="input" type="text" placeholder="Description">
        </div>
      </div>

      <div class="field">
        <label class="label">Brand</label>
        <div class="control">
          <input class="input" type="text" placeholder="Brand">
        </div>
      </div>

      <div class="field">
        <label class="label">Price</label>
        <div class="control">
          <input class="input" type="text" placeholder="Price">
        </div>
      </div>

      <div class="field">
        <label class="label">Stock balance</label>
        <div class="control">
          <input class="input" type="text" placeholder="Stock balance">
        </div>
      </div>

      <input @click="submitCoffee" class="button is-primary" name="add" value="Submit">
  </div>
</div>
</template>

<script>

   export default {
      data() {
         return {
            productName: '',
            brand: '',
            roasting: '',
            description: '',
            price: '',
            stockBalance: ''
         }
      },
      methods: {
         submitCoffee() {

         }
      }
   }

</script>

<style lang="css" scoped>
</style>


<!-- Exempel j:son:
{
    "productName": "Coffe",
    "brand": "Java",
    "roasting": "Dark",
    "description": "Blablablablablabla",
    "price": 199
} -->
