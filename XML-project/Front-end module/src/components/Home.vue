<template>
<div class="container">
    <br>
    <h1> Book unique homes and experiences all over the world. </h1>

  
    <br/>
    <br/>
    <br/>

    <form>

        <div class="form-group">
            <input type="text" style="text-align: center;" class="form-control" id="inputAddress" placeholder="Where do you want to travel?">
        </div>

        <div class="form-row">

            <div class="form-group col-md-6">
                <label for="checkInDate">Check in</label>
                <input type="date" style="text-align: center;" class="form-control" id="checkInDate">
            </div>

            <div class="form-group col-md-6">
                <label for="checkOutDate">Check out</label>
                <input type="date" style="text-align: center;" class="form-control" id="checkOutDate">
            </div>

        </div>

        <br/>

        <div class="form-group row">

            <label for="numberOfPeople" class="col-md-2 col-form-label"> Number of people: </label>
            <div class="col-md-4">
                <select id="numberOfPeople" class="form-control" >
                    <option value="volvo" >1</option>
                    <option value="saab">2</option>
                    <option value="mercedes">3</option>
                    <option value="audi">4</option>
                </select>
            </div>

        
            <label  for="advancedSearchChecked" class="col-md-2 col-form-label">
                Advanced search
            </label>
            <div class="col-md-4">
                <input type="checkbox" id="advancedSearchChecked" v-model="advancedSearchChecked" >
            </div>
        
        </div>

      
        <hr v-if="advancedSearchChecked"  class="my-4">
        <br v-if="advancedSearchChecked">


        <div class="form-group row" v-if="advancedSearchChecked">

            <label for="numberOfPeople" class="col-md-2 col-form-label"> Type of accomodation: </label>
            <div class="col-md-4">
                <select id="numberOfPeople" class="form-control" >
                    <option value="hotel" >Hotel</option>
                    <option value="bed&breakfast">Bed&breakfast</option>
                    <option value="apartment">Apartment</option> 
                </select>
            </div>

             <label for="numberOfPeople" class="col-md-2 col-form-label"> Category: </label>
            <div class="col-md-4">
                <select id="numberOfPeople" class="form-control" >
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
            <label class="col-md-12 col-form-label"> Additional services: </label>

        </div>

              <div class="form-group row" v-if="advancedSearchChecked">

            <div class="form-group col-md-3">

                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="gridCheck">
                    <label class="form-check-label" for="gridCheck">
                        Parking spot
                    </label>
                </div>

            </div>

              <div class="form-group col-md-3">

                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="gridCheck">
                    <label class="form-check-label" for="gridCheck">
                        WiFi
                    </label>
                </div>

            </div>

          <div class="form-group col-md-3">

                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="gridCheck">
                    <label class="form-check-label" for="gridCheck">
                        Breakfast
                    </label>
                </div>

            </div>

          <div class="form-group col-md-3">

                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="gridCheck">
                    <label class="form-check-label" for="gridCheck">
                        Half-board
                    </label>
                </div>

            </div>
        </div>

        <div class="form-group row" v-if="advancedSearchChecked">

            <div class="form-group col-md-3">

                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="gridCheck">
                    <label class="form-check-label" for="gridCheck">
                        Board
                    </label>
                </div>

            </div>

              <div class="form-group col-md-3">

                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="gridCheck">
                    <label class="form-check-label" for="gridCheck">
                        TV
                    </label>
                </div>

            </div>

          <div class="form-group col-md-3">

                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="gridCheck">
                    <label class="form-check-label" for="gridCheck">
                        Kitchen
                    </label>
                </div>

            </div>

          <div class="form-group col-md-3">

                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="gridCheck">
                    <label class="form-check-label" for="gridCheck">
                        Private bathroom
                    </label>
                </div>

            </div>
        </div>

         


     
        <hr  class="my-4"> 
        
        <button type="submit" class="btn btn-primary btn-block">Book</button>

    </form>

  </div> <!-- end of div container -->
</template>

<script>
export default {
  name: 'Home',
  data () {
    return {
      date: new Date('2011-04-11T10:20:30Z'),
      advancedSearchChecked: false
    }
  },
  methods : {
      advancedSearchCheckedChanged : function() {
      }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
