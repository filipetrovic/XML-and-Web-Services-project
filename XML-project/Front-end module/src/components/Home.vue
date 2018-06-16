<template>
<div class="container">
    <br>
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
                <select id="typeOfAccomodation" class="form-control" v-model="searchData.typeOfAccomodation">
                    <option value="hotel" >Hotel</option>
                    <option value="bed&breakfast">Bed&breakfast</option>
                    <option value="apartment">Apartment</option> 
                </select>
            </div>

             <label for="category" class="col-md-2 col-form-label"> <b>Category:</b> </label>
            <div class="col-md-4">
                <select id="category" class="form-control" v-model="searchData.category" >
                    <option value="Uncategorized" >Uncategorized</option>
                    <option value="1 star" >1 star</option>
                    <option value="2 stars">2 stars</option>
                    <option value="3 stars">3 stars</option>
                    <option value="4 stars">4 stars</option>
                    <option value="5 stars">5 stars</option>
                </select>
            </div>

        </div>

        <div class="form-group row" v-if="advancedSearchChecked">
            <label class="col-md-12 col-form-label"> <b>Additional facilities:</b> </label>

        </div>

              <div class="form-group row" v-if="advancedSearchChecked">

            <div class="form-group col-md-3">

                <div class="form-check">
                    <input class="form-check-input" type="checkbox"
                     id="parkingSpot" value="Parking spot" v-model="searchData.additionalServices">
                    <label class="form-check-label" for="parkingSpot">
                        Parking spot
                    </label>
                </div>

            </div>

              <div class="form-group col-md-3">

                <div class="form-check">
                    <input class="form-check-input" type="checkbox"
                     id="wifi" value="WiFi" v-model="searchData.additionalServices">
                    <label class="form-check-label" for="wifi">
                        WiFi
                    </label>
                </div>

            </div>

          <div class="form-group col-md-3">

                <div class="form-check">
                    <input class="form-check-input" type="checkbox" 
                    id="breakfast" value="Breakfast" v-model="searchData.additionalServices">
                    <label class="form-check-label" for="breakfast">
                        Breakfast
                    </label>
                </div>

            </div>

          <div class="form-group col-md-3">

                <div class="form-check">
                    <input class="form-check-input" type="checkbox"
                     id="halfBoard" value="Half-board" v-model="searchData.additionalServices">
                    <label class="form-check-label" for="halfBoard">
                        Half-board
                    </label>
                </div>

            </div>
        </div>

        <div class="form-group row" v-if="advancedSearchChecked">

            <div class="form-group col-md-3">

                <div class="form-check">
                    <input class="form-check-input" type="checkbox"
                     id="board" value="Board" v-model="searchData.additionalServices">
                    <label class="form-check-label" for="board">
                        Board
                    </label>
                </div>

            </div>

              <div class="form-group col-md-3">

                <div class="form-check">
                    <input class="form-check-input" type="checkbox"
                     id="tv" value="TV" v-model="searchData.additionalServices">
                    <label class="form-check-label" for="tv">
                        TV
                    </label>
                </div>

            </div>

          <div class="form-group col-md-3">

                <div class="form-check">
                    <input class="form-check-input" type="checkbox"
                     id="kitchen" value="Kitchen" v-model="searchData.additionalServices">
                    <label class="form-check-label" for="kitchen">
                        Kitchen
                    </label>
                </div>

            </div>

          <div class="form-group col-md-3">

                <div class="form-check">
                    <input class="form-check-input" type="checkbox"
                     id="privateBathroom"  value="Private bathroom" v-model="searchData.additionalServices">
                    <label class="form-check-label" for="privateBathroom">
                        Private bathroom
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
        typeOfAccomodation: '',
        category: '',
        additionalServices: []
      },
      advancedSearchChecked: false
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
         

        //   this.$http.post('https://us-central1-booking-rating-system-c35da.cloudfunctions.net/addComment',
        //    JSON.stringify(this.searchData))
	    //     .then(response =>  {
		// 	console.log(response)
		//     }, error => {
		// 	console.log(error)
		// 	});

        this.$http
                    .post('http://localhost:8080/api/client/search',
                    JSON.stringify(this.searchData),
                    headers)

                    .then(response => {
                        const data = response.body;
                        console.log(data);

                        this.$store.state.ListOfAccommodations = data;
                        this.$store.state.numberOfPeople = this.searchData.numberOfPeople;

                        //this.$store.dispatch('imeMutacije');

                        this.$router.push('Accommodations'); 
                    });
      }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
