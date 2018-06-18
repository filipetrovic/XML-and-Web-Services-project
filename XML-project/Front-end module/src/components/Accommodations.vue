<template>
  <div class="container">

    <nav class="navbar  navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="#">Booking client</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
            <a class="nav-item nav-link active" style="width:500px;" href="/home">Home <span class="sr-only">(current)</span></a>
            <a class="nav-item nav-link" href="/login">Sign in/Sign up</a>
            </div>
        </div>
    </nav>

    <br/>
    <br/>
    <h1> Accomodations available </h1> 
    <br/>
    <br/>
    <table class="table table-bordered">
        <thead class="thead-dark">
            <tr>
            <th scope="col">Name</th>
            <th scope="col">Description</th>
            <th scope="col">Address</th>
            <th scope="col">Number of people/Available beds</th>
            <th scope="col">Type</th>
            <th scope="col">Category(*)</th>
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
            <td>{{numberOfPeople + '/' + accommodation.numberOfPeople}}</td>
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
                <select id="sort" class="form-control" v-model="sortType" v-on:change="sorted">
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
      sortType: ''
    }
  },
  watch: {
      sortType: function(val) {
        
        if(val === 'Price')
        {
            this.listOfAccommodations.sort( ( a, b) => {
                return (a.pricePerPerson - b.pricePerPerson);
            });
        }
        else if(val === 'Category')
        {
            //console.log('Before');
            //console.log(this.listOfAccommodations);
            
            for(let ac in this.listOfAccommodations)
            {
                let c = this.listOfAccommodations[ac].category.substring(0,1);
                //console.log('Category: ' + c);
                this.listOfAccommodations[ac].category = c;
            }
            
            //console.log('After');
            //console.log(this.listOfAccommodations);

            this.listOfAccommodations.sort( ( a, b) => {
                return (a.category - b.category);
            });

            for(let ac in this.listOfAccommodations)
            {
                this.listOfAccommodations[ac].category += ' stars';
            }


            //console.log('Sorted');
           // console.log(this.listOfAccommodations);
        }
      },
  },
  methods: {

  },
  created() {
      
    
    this.listOfAccommodations = this.$store.state.ListOfAccommodations;
    this.numberOfPeople = this.$store.state.numberOfPeople;
      
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
