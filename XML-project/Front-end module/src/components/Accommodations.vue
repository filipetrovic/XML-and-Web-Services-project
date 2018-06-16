<template>
  <div class="container">
    
    <h1> Accomodations available </h1> 

    <table class="table table-bordered">
        <thead class="thead-dark">
            <tr>
            <th scope="col">Name</th>
            <th scope="col">Description</th>
            <th scope="col">Address</th>
            <th scope="col">Number of people</th>
            <th scope="col">Type</th>
            <th scope="col">Category</th>
            <th scope="col">Price per night</th>
            <th scope="col">Pictures</th>
            <th scope="col">Additional facilities</th>
            <th scope="col"> </th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="(accommodation, index) in listOfAccommodations">
            <td>{{accommodation.name}}</td>
            <td>{{accommodation.description}}</td>
            <td>{{accommodation.inputAddress}}</td>
            <td>{{numberOfPeople / accommodation.numberOfPeople}}</td>
            <td>{{accommodation.typeOfAccommodation}}</td>
            <td>{{accommodation.category}}</td>
            <td>{{accommodation.pricePerPerson * numberOfPeople}}</td>
            <td>{{accommodation.pictures}}</td>
            <td> <p v-for="fac in accommodation.additionalFacilities"> {{fac.name}} </p></td>
            <td> <button class="btn btn-primary"> Reserve </button> </td>
            </tr>
        </tbody>
    </table>

    <div class="form-group row">

            <label for="sort" class="col-md-1 col-form-label"> <b> Sort by: </b> </label>
            <div class="col-md-2">
                <select id="sort" class="form-control" v-model="sortType" @click="sorted">
                    <option value="Price" >Price</option>
                    <option value="Rating">Rating</option>
                    <option value="Category">Category</option>
                </select>
            </div>

    </div>


  </div>
</template>

<script>
export default {
  name: 'Accommodations',
  data () {
    return {
      listOfAccommodations : [],
      numberOfPeople: Number = 0,
      sortType: '',
      sort: [
          {price:2000, name:'app1'},
          {price:6000, name:'app2'},
          {price:4000, name:'app3'}
      ]
    }
  },
  watch: {
      sortType: function(val) {
        console.log(val);


        
        


  
        

      },
  },
  methods: {

    sorted: function() {

        

        var niz = [];

        for(let item in this.listOfAccommodations)
            niz.push(item);
            

        console.log(niz);

        this.sort.sort( ( a, b) => {
                return (a.price - b.price);
            });

        console.log(this.sort);
        console.log("Usao");
    }
  },
  created() {
      
    console.log(this.$store.state.ListOfAccommodations);
    this.listOfAccommodations = this.$store.state.ListOfAccommodations;
    this.numberOfPeople = this.$store.state.numberOfPeople;
    console.log(this.numberOfPeople * 1000);
      
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
