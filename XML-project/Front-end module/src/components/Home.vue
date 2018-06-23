<template>
<div class="container">

    <nav class="navbar  navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="#">Booking client</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
            <router-link tag="a" class="nav-item nav-link active" style="width:500px;" to="/home">Home <span class="sr-only">(current)</span></router-link>
            <router-link tag="a" class="nav-item nav-link" to="/login" v-if="!userLogged">Sign in/Sign up</router-link>
            <router-link tag="a" class="nav-item nav-link" to="/profile" v-if="userLogged">My Profile</router-link>
            </div>
        </div>
    </nav>


    <br/>
    <br/>
    <h1> Book unique homes and experiences all over the world. </h1>

    
    <br/>
    <br/>
    <br/>

    <form>

        <div class="form-group">
            <input type="text" style="text-align: center;"
             class="form-control" id="inputAddress" placeholder="Where do you want to travel?"
             v-model="searchData.inputAddress">
        </div>

        <div class="form-row">

            <div class="form-group col-md-6">
                <label for="checkInDate"> <b> Check in </b></label>
                <input type="date" style="text-align: center;"
                 class="form-control" id="checkInDate"
                 v-model="searchData.checkInDate">
            </div>

            <div class="form-group col-md-6">
                <label for="checkOutDate"> <b> Check out </b></label>
                <input type="date" style="text-align: center;"
                 class="form-control" id="checkOutDate"
                 v-model="searchData.checkOutDate">
            </div>

        </div>

        <br/>

        <div class="form-group row">

            <label for="numberOfPeople" class="col-md-2 col-form-label"> <b> Number of people: </b> </label>
            <div class="col-md-4">
                <select id="numberOfPeople" class="form-control" v-model="searchData.numberOfPeople">
                    <option value="1" >1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                </select>
            </div>

        
            <label  for="advancedSearchChecked" class="col-md-2 col-form-label">
                <b>Advanced search</b>
            </label>
            <div class="col-md-4">
                <input type="checkbox" id="advancedSearchChecked" v-model="advancedSearchChecked" >
            </div>
        
        </div>

      
        <hr v-if="advancedSearchChecked"  class="my-4">
        <br v-if="advancedSearchChecked">


        <div class="form-group row" v-if="advancedSearchChecked">

            <label for="typeOfAccomodation" class="col-md-2 col-form-label"> <b> Type of accomodation: </b> </label>
            <div class="col-md-4">
                <select id="typeOfAccomodation" class="form-control" v-model="searchData.typeOfAccomodation" >
                    <option :value="t" v-for="t in accomodationTypes">{{t.name}}</option>
                </select>
            </div>

             <label for="category" class="col-md-2 col-form-label"> <b>Category:</b> </label>
            <div class="col-md-4">
                <select id="category" class="form-control" v-model="searchData.category" >
                    <option :value="rating" v-for="rating in accomodationStarsRating">{{rating.name}}</option>
                </select>
            </div>

        </div>

        <div class="form-group row" v-if="advancedSearchChecked">
            <label class="col-md-2 col-form-label"> <b>Additional facilities:</b> </label>

        </div>


        <div class="form-group row" v-if="advancedSearchChecked" v-for="facility in additionalFacilities">

            <div class="form-group col-md-2">

                <div class="form-check">
                    <input class="form-check-input checkbox-inline" type="checkbox"
                     :id="facility.name" :value="facility.name" v-model="searchData.additionalServices">
                    <label class="form-check-label" :for="facility.name">
                        {{facility.name}}
                    </label>
                </div>

            </div>

        </div>



        <hr  class="my-4"> 
        
        <button type="button" class="btn btn-primary btn-block"
        @click="searchClicked()">Search</button>

    </form>

  </div> <!-- end of div container -->
</template>

<script>
export default {
  name: 'Home',
  data () {
    return {
      searchData: {
        checkInDate: new Date(),
        checkOutDate: new Date(),
        inputAddress: '',
        numberOfPeople: '',
        typeOfAccomodation: {id:1,name:'',version:0},
        category: {id:1,name:'',version:0},
        additionalServices: []
      },
      advancedSearchChecked: false,
      userLogged: false,
      user: '',
      accomodationTypes: [],
      accomodationStarsRating: [],
      additionalFacilities: []
    }
  },
  methods : {
      advancedSearchCheckedChanged : function() {
      },

      searchClicked: function() {
        
        console.log(JSON.stringify(this.searchData));

        let headers = {
            headers: {
                'Content-Type': 'application/json'
            }
        };

        this.$http
            .post('http://localhost:8080/api/client/search',
            JSON.stringify(this.searchData),
            headers)

            .then(response => {
                const data = response.body;

                this.$store.state.ListOfAccommodations = data;
                this.$store.state.numberOfPeople = this.searchData.numberOfPeople;
                this.$store.state.dates = {
                    checkInDate: this.searchData.checkInDate,
                    checkOutDate: this.searchData.checkOutDate
                };
                
                this.$router.push('Accommodations'); 
            });
      }
  },
  created() {

        this.user = this.$store.state.loggedUser;

        console.log(this.user);

        if(this.$store.state.loggedUser == '')
        {
            console.log('User is not logged: ' + this.$store.state.loggedUser);
            this.userLogged = false;
        }
        else
        {
            console.log('User is logged: ' + this.$store.state.loggedUser);
            this.userLogged = true;
        }

        this.$http
            .get('http://localhost:8080/api/encoded/getAllAccommodationTypes')
            .then(response => {
                const data = response.body;
                this.accomodationTypes = data;
            });

        this.$http
            .get('http://localhost:8080/api/encoded/getAllStarRatings')
            .then(response => {
                const data = response.body;
                this.accomodationStarsRating = data;
            });

        this.$http
            .get('http://localhost:8080/api/encoded/getAllFacilities')
            .then(response => {
                const data = response.body;
                this.additionalFacilities = data;
            });

  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
