<template>
  <div class="columns is-centered">
         <div class="column is-one-third">
           <h1 class="title">ADD A PRODUCT</h1>
          <div class="field">
            <label class="label">Name of product *</label>
            <div class="control">
             <input class="input" type="text" placeholder="Text input" v-model.trim="productName">
            </div>
         </div>

         <div class="field">
           <label class="label">Brand *</label>
           <div class="control">
             <input class="input" type="text" placeholder="Product brand" v-model.trim="brand">
           </div>
         </div>

         <div class="field">
           <label class="label">Roasting *</label>
           <div class="control">
             <input class="input" type="text" placeholder="Roasting" v-model.trim="roasting">
           </div>
         </div>

         <div class="field">
           <label class="label">Description *</label>
           <div class="control">
             <input class="input" type="text" placeholder="Description" v-model.trim="description">
           </div>
         </div>

         <div class="field">
           <label class="label">Price *</label>
           <div class="control">
             <input class="input" type="number" placeholder="Price" v-model.number="price">
           </div>
         </div>

         <div class="field">
           <label class="label">Stock balance *</label>
           <div class="control">
             <input class="input" type="number" placeholder="Stock balance" v-model.number="stockBalance">
           </div>
         </div>

         <input id="submitbutton" @click="submitCoffee" class="button is-primary" name="add" value="Submit">

         <div class="">
            {{ this.message }}
         </div>
     </div>
   </div>
</template>

<script>

   export default {
      data() {
         return {
            brand: '',
            description: '',
            message:'',
            price: null,
            productName: '',
            roasting: '',
            stockBalance: null
         }
      },
      methods: {
         submitCoffee() {
         // Kolla om alla värden är ifyllda, om true - skicka ett post request
         // Om falskt- ge ett felmeddelande.
            if (  this.brand === '' ||
                  this.description === '' ||
                  this.price === '' || this.price === null ||
                  this.productName === '' ||
                  this.roasting === '' ||
                  this.stockBalance === null || this.stockBalance === '') {

               alert("Unable to submit. Please check if the fields are filled in, or if the price or stock balance fields contain letters or other symbols.")

            } else {

               fetch('http://localhost:8080/webapp/resources/cbt', {
                  body: JSON.stringify({
                   "productName": this.name ,
                   "brand": this.brand,
                   "roasting": this.roasting,
                   "description": this.description,
                   "price": this.price,
                   "stockBalance": this.stockBalance
                  }),
                  headers: {
                    "Content-Type": 'application/json'
                  },
                  method: 'POST'
                  })

                  this.message = 'Submitting the product'

            }
         }
      }
   }

</script>

<style lang="css" scoped>
   h1 {
      padding: 2rem 0rem 2rem 0rem;
      color: #f5efeb;
   }
   input {
      margin-bottom: 1.5rem;
   }

   #submitbutton {
      margin-top: 2rem;
   }

</style>

