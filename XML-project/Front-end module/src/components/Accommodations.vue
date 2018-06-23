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
    <h1> Accomodations available </h1> 
    <br/>
    <br/>
    <table class="table table-bordered table-hover">
        <thead class="thead-dark">
            <tr>
            <th scope="col">Name</th>
            <th scope="col">Description</th>
            <th scope="col">Address</th>
            <th scope="col">Number of people/Available beds</th>
            <th scope="col">Type</th>
            <th scope="col">Category(*)</th>
            <th scope="col">Price per night</th>
            <th scope="col">Rating</th>
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
            <td>{{accommodation.typeOfAccommodation.name}}</td>
            <td>{{accommodation.category.name}}</td>
            <td>{{accommodation.pricePerPerson * numberOfPeople}}</td>
            <td>{{accommodation.rating}}</td>
            <td>{{accommodation.pictures}}</td>
            <td> <p v-for="fac in accommodation.additionalFacilities"> {{fac.name}} </p></td>
            <td> <button class="btn btn-primary" v-if="userLogged" @click="reserveAccommodation(accommodation)"> Reserve </button> </td>
            </tr>
        </tbody>
    </table>

    <div class="form-group row">

            <label for="sort" class="col-md-1 col-form-label"> <b> Sort by: </b> </label>
            <div class="col-md-2">
                <select id="sort" class="form-control" v-model="sortType">
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
      user: '',
      loggedUser: false
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
            for(let ac in this.listOfAccommodations)
            {
                let c = this.listOfAccommodations[ac].category.name.substring(0,1);
                this.listOfAccommodations[ac].category.name = c;
            }
            
            this.listOfAccommodations.sort( ( a, b) => {
                return (a.category.name - b.category.name);
            });

            for(let ac in this.listOfAccommodations)
            {
                this.listOfAccommodations[ac].category.name += ' stars';
            }
        }
        else if(val === 'Rating')
        {
            this.listOfAccommodations.sort( ( a, b) => {
                return (a.rating - b.rating);
            });
        }
      },
  },
  methods: {
      reserveAccommodation: function(ac) {

        let headers = {
                headers: {
                    'Content-Type': 'application/json'
                }
        };

        var reservation = {
            checkInDate: this.$store.state.dates.checkInDate,
            checkOutDate: this.$store.state.dates.checkOutDate,
            priceOfReservation: ac.pricePerPerson * this.numberOfPeople,
            username: this.user.username,
            accommodationId: ac.id,
        };

        this.$http
                .post('http://localhost:8080/api/client/reserve',
                reservation,
                headers)

                .then(response => {
                    const data = response.body;
                    console.log(data);

                    this.$router.push('Profile'); 
                },
                (err) => {
                    alert(err.status + " Reservation already exists!");
                });
      }
  },
  created() {
      
    
    this.listOfAccommodations = this.$store.state.ListOfAccommodations;
    this.numberOfPeople = this.$store.state.numberOfPeople;
    this.user = this.$store.state.loggedUser;
    
    //console.log(this.user);

    if(this.$store.state.loggedUser == '')
    {
        //console.log('User is not logged: ' + this.$store.state.loggedUser);
        this.userLogged = false;
    }
    else
    {
        //console.log('User is logged: ' + this.$store.state.loggedUser);
        this.userLogged = true;
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
