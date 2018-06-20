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

            </div>
        </div>
    </nav>

        

    <header class="header">
        <div class="container">
            <div class="teacher-name" style="padding-top:20px;">

                <div class="row" style="margin-top:0px;">

                    <div class="col-md-3"> <!-- Image -->
                        <a href="#"> <img  class="rounded-circle mx-auto d-block" src="https://st2.depositphotos.com/1007566/11575/v/950/depositphotos_115754578-stock-illustration-young-male-profile-vector-illustration.jpg" alt="Kamal" style="width:100px;height:100px"></a>
                    </div>

                    <div class="col-md-7">
                        <h2 style="font-size:38px"><strong>{{user.firstName}} {{user.lastName}} </strong></h2>
                        <span style="font-size:18px">Username: {{user.username}}</span>
                    </div>

                </div>
            </div>
        </div>
  </header>

<!--End of Header-->

<!-- Section:Reservations -->
    <div class="row" >
    <div class="col-md-12">
        <div class="card card-block">
            <h2 class="card-title"  style="color:#009688; padding-top:15px; padding-left: 10px;" ><i class="fa fa-trophy fa-fw"></i> My Reservations </h2>
            <div style="height: 15px"></div>

            <table class="table table-bordered table-hover">

            <thead class="thead-dark">

                <tr>
                    <th scope="col">Check in date</th>
                    <th scope="col">Check out date</th>
                    <th scope="col">Price</th>
                    <th scope="col">Name</th>
                    <th scope="col">Rating</th>
                    <th scope="col">Review</th>
                    <th scope="col"></th>
                </tr>

            </thead>

            <tbody >
                <tr v-for="r in reservations">
                
                <td>{{r.checkInDate}}</td>
                <td>{{r.checkOutDate}}</td>
                <td>{{r.priceOfReservation}}</td>
                <td>{{r.accommodation.name}}</td>
                <td>{{r.ratingValue}}</td>
                <td>{{r.ratingComment}}</td>
                <td>
                    <button class="btn btn-success btn-block" v-if="r.arrivalConfirmed" @click="rateStay(r)" data-toggle="modal" data-target="#exampleModal"> Rate my stay </button>
                    <button class="btn btn-danger btn-block" v-if="!r.arrivalConfirmed" @click="cancelReservation(r.id)"> Cancel reservation </button>
                </td>
                </tr>
                
            </tbody>
            </table>
        </div>
    </div>
    </div>
<!-- End:Reservations -->

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Rating</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form>
            <div class="form-group row">
                <label for="rating" class="col-sm-2 col-form-label">Rate your stay from 1-5</label>
                <div class="col-sm-10">
                <select id="rating" class="form-control" v-model="ratingValue">
                    <option value="1" >1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                </select>
                </div>
            </div>

            <div class="form-group row">
                <label for="comment" class="col-sm-2 col-form-label">Describe your stay</label>
                <div class="col-sm-10">
                <textarea class="form-control" id="comment" rows="3" v-model="ratingComment"></textarea>
                </div>
            </div>

        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal" @click="submitRating()">Save changes</button>
      </div>
    </div>
  </div>
</div>

  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
        user: '',
        reservations: [],
        reservationForRating: '',
        ratingComment: '',
        ratingValue: ''
    }
  },
  methods: {
      cancelReservation: function(id) {
          
        let params = {
           reservationId : id,
           username : this.user.username
       };

       this.$http
                .delete('http://localhost:8080/api/client/cancelReservation',
                { params : params }
                )
                .then(response => {
                    const data = response.body;
                    this.reservations = data;
                });

      },
      rateStay: function(res) {
        
        this.reservationForRating = res;

      },
      submitRating: function() {

        console.log(this.ratingComment + ' ' + this.ratingValue);
        console.log(this.reservationForRating);

        var rating = {
            comment: this.ratingComment,
            value: this.ratingValue,
            reservationId: this.reservationForRating.id,
            accommodationId: this.reservationForRating.accommodation.id,
        };

        this.reservations.forEach((item, index) => {
            console.log(item); // 9, 2, 5
            console.log(index); // 0, 1, 2

            this.reservations[index].comment = '';
        });

        this.reservations[0].comment = this.ratingComment;

        console.log(this.reservations);

        let headers = {
            headers: {
                'Content-Type': 'application/json'
            }
        };

        console.log(rating);

        this.$http
                .post('http://localhost:8010/cloud-demo/us-central1/addRating',
                JSON.stringify(rating))

                .then(response => {
                    console.log(response.body);
                });

      }
  },
  created() {

       this.user = this.$store.state.loggedUser;

       let params = {
           username : this.user.username
       }

       this.$http
                .get('http://localhost:8080/api/client/getReservations',
                { params : params }
                )
                .then(response => {
                    const data = response.body;
                    this.reservations = data;

                this.$http
                    .get('http://localhost:8080/api/client/getRatings',
                    { params : params }
                    )
                    .then(response => {
                        const data = response.body;
                        var ratings = [];
                        ratings = data;

                        this.reservations.forEach((reservation, indexReservation) => {
                            console.log('Reservation: ');
                            console.log(reservation); 
                            console.log(indexReservation); 

                            ratings.forEach((rating, indexRating) => {
                            console.log('Rating :'); 
                            console.log(rating); 
                            console.log(indexRating); 
        
                                if(this.reservations[indexReservation].id === rating.reservationId)
                                {
                                    if(this.reservations[indexReservation].approved)
                                        this.reservations[indexReservation].comment = rating.comment;

                                    this.reservations[indexReservation].value = rating.value;
                                }
                        });
                        });
                    });

                });

  

      
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
body {
    padding: 0px;
    }
    .container {
      width: auto;
      margin-left: 200px;
      margin-right: 200px;
    }​
    .center {
      margin-left: auto;
      margin-right: auto;
      }
      .center.navbar .nav,
      .center.navbar .nav > li {
      float:none;
      display:inline-block;
      *display:inline; /* ie7 fix */
      *zoom:1; /* hasLayout ie7 trigger */
      vertical-align: top;
      }
      .center.navbar-inner {
      text-align:center;
      }
      .center .dropdown-menu {
      text-align: left;
      }
      .navbar-inner {
      margin: 0 auto;
      }
      
      
      body{
        background: #DAE3E7;
      }
      
      .row{
        margin-top: 40px;
      }
      
      
      html,body,h1,h2,h3,h4,h5,h6 {font-family: "Roboto", sans-serif}
      div.card {
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.1), 0 3px 10px 0 rgba(0, 0, 0, 0.1);
      }
      
      .header {
        padding: 10px 0;
        background: #f5f5f5;
        border-top: 3px solid #3AAA64;
      }
      
      .list-group {
          list-style: disc inside;
      
      }
      
      .list-group-item {
          display: list-item;
      }
      
       .find-more{
         text-align: right;
       }
      
      
      .label-theme{
        background: #3AAA64;
        font-size: 14px;
        padding: .3em .7em .3em;
        color: #fff;
        border-radius: .25em;
      }
      
      .label a{
        color: inherit;
      }
</style>
