<template>
  <div class="columns is-centered">
    <div class="column is-one-third">
      <h1 class="title">EDIT PRODUCTS</h1>

      <div id="searchBar" class="field has-addons">
        <div class="control">
          <input v-model="searchBar" class="input" type="text" placeholder="Find product">
        </div>
        <div class="control">
          <a @click="onSearch" class="button is-primary">
            Search
          </a>
        </div>
      </div>

      <div id="product" v-for="(product, index) in products">

        <div class="separator" />

        <div class="field product-field">
          <label class="label">Name of product:</label>
          <div v-if="!editMode[index]" class="product-text">
            {{ product.productName }}
          </div>
          <div v-if="editMode[index]" class="control">
            <input class="input" type="text" placeholder="Text input" v-model.trim="productName">
          </div>
        </div>

        <div class="field product-field">
          <label class="label">Brand:</label>
          <div v-if="!editMode[index]" class="product-text">
            {{ product.brand }}
          </div>
          <div v-if="editMode[index]" class="control">
            <input class="input" type="text" placeholder="Text input" v-model.trim="brand">
          </div>
        </div>

        <div class="field product-field">
          <label class="label">Roasting:</label>
          <div v-if="!editMode[index]" class="product-text">
            {{ product.roasting }}
          </div>
          <div v-if="editMode[index]" class="control">
            <input class="input" type="text" placeholder="Text input" v-model.trim="roasting">
          </div>
        </div>

        <div class="field product-field">
          <label class="label">Description:</label>
          <div v-if="!editMode[index]" class="product-text">
            {{ product.description }}
          </div>
          <div v-if="editMode[index]" class="control">
            <input class="input" type="text" placeholder="Text input" v-model.trim="description">
          </div>
        </div>

        <div class="field product-field">
          <label class="label">Price:</label>
          <div v-if="!editMode[index]" class="product-text">
            {{ product.price }} sek/hg
          </div>
          <div v-if="editMode[index]" class="control">
            <input class="input" type="text" placeholder="Text input" v-model.trim="price">
          </div>
        </div>

        <div class="field product-field">
          <label class="label">Stock balance:</label>
          <div v-if="!editMode[index]" class="product-text">
            {{ product.stockBalance }} hg
          </div>
          <div v-if="editMode[index]" class="control">
            <input class="input" type="text" placeholder="Text input" v-model.trim="stockBalance">
          </div>
        </div>

        <div id="buttons">
          <input id="editButton" @click="onEdit(index)" class="button is-primary" value="Edit">
          <input v-if="!editMode[index]" id="deleteButton" @click="onDelete(index)" class="button is-primary" value="Delete">
          <input v-if="editMode[index]" id="updateButton" @click="onUpdate(index)" class="button is-primary" value="Update">
        </div>
      </div>

    </div>
  </div>
</template>

<script>
   export default {
     data() {
        return {
          url: "",
          searchBar: "",
          id: '',
          message:'',
          productName: '',
          brand: '',
          roasting: '',
          description: '',
          stockBalance: null,
          price: null,
          products: [],
          editMode: [],
        }
      },
      methods: {
         onSearch() {
           const url = 'http://localhost:8080/webapp/resources/cbt/' + this.searchBar
           fetch(url)
             .then(response => response.json())
             .then(result => {
               this.products = result
               this.editMode = []
               for(let i = 0; i < this.products.length; i++) {
                 this.editMode.push(false)
               }
             })
          },
          onEdit(index) {
            if(this.editMode[index] == false){
              this.$set(this.editMode, index, true)

              for(let i = 0; i < this.products.length; i++) {
                if (i !== index && this.editMode[index] == true) {
                  this.$set(this.editMode, i, false)
                }
              }

              this.id = this.products[index].id
              this.productName = this.products[index].productName
              this.brand = this.products[index].brand
              this.roasting = this.products[index].roasting
              this.description = this.products[index].description
              this.price = this.products[index].price
              this.stockBalance = this.products[index].stockBalance
            } else {
              this.$set(this.editMode, index, false)

              this.id = null
              this.productName = ''
              this.brand = ''
              this.roasting = ''
              this.description = ''
              this.price = null
              this.stockBalance = null
            }
          },
          onUpdate(index){
            const url = 'http://localhost:8080/webapp/resources/cbt/update/' + this.id
            fetch(url, {
               body: JSON.stringify({
                "productName": this.productName,
                "brand": this.brand,
                "roasting": this.roasting,
                "description": this.description,
                "price": this.price,
                "stockBalance": this.stockBalance
               }),
               headers: {
                 "Content-Type": 'application/json'
               },
               method: 'PUT'
               }).then(() => {
                 this.onSearch()
               })
               this.$set(this.editMode, index, false)
          },
          onDelete(index) {
            const id = this.products[index].id
            const url = 'http://localhost:8080/webapp/resources/cbt/delete/' + id
            fetch(url, {
              method: 'DELETE'
            }).then(() => {
              this.onSearch()
            })
          }
      }

 }
</script>

<style lang="css" scoped>
  h1 {
     margin-top: 3rem;
     padding: 2rem 0rem 2rem 0rem;
     color: #f5efeb;
  }
  .product-text {
    color: black;
    font-size: 1.2rem;
    padding: 7px 0 0 0;
  }
  #searchBar {
    margin-top: 56px;
  }
  #product {
    margin: 80px 0;
  }
  .separator {
    height: 2px;
    background-color: #5e422f;
    margin-bottom: 40px;
  }
  #buttons {
    margin-top: 40px;
  }
</style>

 <!-- // Administrationssida
 // Här ska vi kunna ta bort, redigera och titta på innehållet i kaffedatabasen-
 //   1a alternativet - sök på namn (en sökruta och en knapp. Man kan söka på wildcards.)
 //   2a alternativet - välj ur listan av allt innehåll. Vid varje kaffesort ska det finnas en knapp för editering och en knapp för att ta bort kaffesorten ur databasen. -->


<!-- //  <dl>
//    <template v-for="product in products">
//       <dt> {{ product.productName }} </dt>
//       <dd> {{ product.brand }} </dd>
//       <dd> {{ product.roasting }} </dd>
//       <dd> {{ product.price }} </dd>
//       <dd> {{ product.description }} </dd>
//    </template>
// </dl> -->
