new Vue ({

  el: 'app',

  data: {
    productName: null,
    brand: null,
    roasting: null,
    description: null,
    price: null
  },

  created() {
  fetch('http://localhost:8080/webapp/resources/cbt')
    .then(response => response.json())
    .then(result => {
      this.productName = result
    })
  },

  methods: {
    addCity() {
      fetch('http://localhost:8080/webapp/resources/cbt', {
        body: JSON.stringify({
          "productName": this.name ,
          "brand": this.brand,
          "roasting": this.roasting,
          "description": this.description,
          "price": this.price
        }),
        headers: {
          "Content-Type": 'application/json'
        },
        method: 'POST'
      })
        .then(response => response.json())
          .then(result => {
            this.productName = result
          })
        }

    }
})
