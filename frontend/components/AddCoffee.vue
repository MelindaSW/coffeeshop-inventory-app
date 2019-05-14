<template>
  <div class="columns is-centered">
     <div class="column is-one-third">
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

      <input class="button is-primary" name="add" value="Submit">
  </div>
</div>
</template>

<script>
export default {
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
