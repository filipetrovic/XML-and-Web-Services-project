<template>
  <div class="container">
    
    <h1> Accomodations available </h1> 

    <table class="table">
        <thead class="thead-dark">
            <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Address</th>
            <th scope="col">Number of people</th>
            <th scope="col">Type</th>
            <th scope="col">Category</th>
            <th scope="col">Additional facilities</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="(accommodation, index) in listOfAccommodations">
            <th scope="row">{{index + 1}}</th>
            <td>{{accommodation.inputAddress}}</td>
            <td>{{accommodation.startDateAvailable}}</td>
            <td>{{accommodation.endDateAvailable}}</td>
            <td>{{accommodation.additionalFacilities}}</td>
            </tr>
        </tbody>
    </table>


  </div>
</template>

<script>
export default {
  name: 'Accommodations',
  data () {
    return {
      listOfAccommodations : []
    }
  },
  created() {
      
        
        console.log(this.$store.state.ListOfAccommodations);
        this.listOfAccommodations = this.$store.state.ListOfAccommodations;
      
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
