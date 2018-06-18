<template>
  <div class="container">
        <h1> My Profile </h1>

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
            <thead class="thead-default">
            
            </thead>
            <tbody >
                <tr v-for="r in reservations">
                
                <td>{{r.name}}</td>
                <td>{{r.date}}</td>
                <td>{{r.price}}</td>
                <td><button class="btn btn-warning" > Rate my stay </button>
                </td>
                </tr>
                
            </tbody>
            </table>
        </div>
    </div>
    </div>
<!-- End:Reservations -->

  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
        user: '',
        reservations: [
            {name:'Apartmani Jancic', date:Date, price: 3000 },
            {name:'Hotel Pancic', date:Date, price: 1500}
        ]
    }
  },

  created() {
       this.user = this.$store.state.loggedUser;
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
