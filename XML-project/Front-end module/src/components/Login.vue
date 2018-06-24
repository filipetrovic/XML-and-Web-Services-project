<template>
  <div class="container">

     <nav class="navbar  navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="#">Booking client</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
            <router-link tag="a" class="nav-item nav-link" style="width:500px;" to="/home">Home </router-link>
            <router-link tag="a" class="nav-item nav-link active" to="/login">Sign in/Sign up <span class="sr-only">(current)</span></router-link>
            </div>
        </div>
    </nav>

    <form class="form-signin" v-if="registrationClicked">
      
      <br>
      <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
      
      <br>
      
      <label for="inputEmail" class="sr-only">Email address</label>
      <input type="email" id="inputEmail" class="form-control"
       placeholder="Email address" required autofocus v-model="user.username">
      
      <br>
      
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" id="inputPassword" class="form-control"
       placeholder="Password" required v-model="user.password">

      <hr>

      <button class="btn btn-lg btn-primary btn-block" type="button" @click="submit()">Sign in</button>
      <button type="button" class="btn btn-lg btn-success btn-block" @click="openRegistration()">Register</button>

      <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>

    </form>

    <form class="form-horizontal" v-if="!registrationClicked">
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
            <br>
                <h2> Please enter the following information </h2>
                <hr>
                <br>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3 field-label-responsive">
                <label for="firstName">First Name</label>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                        <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-user"></i></div>
                        <input type="text" name="firstName" class="form-control" id="firstName"
                               placeholder="John" required autofocus v-model="user.firstName">
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-control-feedback">
                        <span class="text-danger align-middle">
                            <!-- Put name validation error messages here -->
                        </span>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-3 field-label-responsive">
                <label for="lastName">Last Name</label>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                        <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-user"></i></div>
                        <input type="text" name="lastName" class="form-control" id="lastName"
                               placeholder="Doe" required autofocus v-model="user.lastName">
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-control-feedback">
                        <span class="text-danger align-middle">
                            <!-- Put name validation error messages here -->
                        </span>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-3 field-label-responsive">
                <label for="username">Username</label>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                        <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-user"></i></div>
                        <input type="text" name="username" class="form-control" id="username"
                               placeholder="johndoe123" required autofocus v-model="user.username">
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-control-feedback">
                        <span class="text-danger align-middle">
                            <!-- Put name validation error messages here -->
                        </span>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-3 field-label-responsive">
                <label for="email">E-Mail Address</label>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                        <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-at"></i></div>
                        <input type="text" name="email" class="form-control" id="email"
                               placeholder="john@example.com" required autofocus v-model="user.email">
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-control-feedback">
                        <span class="text-danger align-middle">
                            <!-- Put e-mail validation error messages here -->
                        </span>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3 field-label-responsive">
                <label for="password">Password</label>
            </div>
            <div class="col-md-6">
                <div class="form-group has-danger">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                        <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-key"></i></div>
                        <input type="password" name="password" class="form-control" id="password"
                               placeholder="Password" required v-model="user.password">
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-control-feedback">
                        <span class="text-danger align-middle">
                           
                        </span>
                </div>
            </div>
        </div>

    <hr>
    <br>
    <button type="button" class="btn btn-lg btn-success btn-block" @click="finishRegistration()"> Register </button>


    </form>

  </div>


</template>

<script>
export default {
  name: 'Login',
  data () {
    return {
      user: {
          username: '',
          password: '',
          firstName: '',
          lastName: '',
          email: ''
      },
      registrationClicked: true
    }
  },
  methods: {
    openRegistration: function() {
        
    this.registrationClicked = !this.registrationClicked;

    },
    
    finishRegistration: function() {

    let headers = {
        headers: {
            'Content-Type': 'application/json'
        }
    };

    this.$http
            .post('http://localhost:8083/api/client/login/registration',
            JSON.stringify(this.user),
            headers)

            .then(response => {
                const data = response.body;
            },
            (err) => {
                alert(err.status + " FAILED REGISTRATION!");
                });

        this.registrationClicked = !this.registrationClicked;
    },

    submit: function() {

    let headers = {
        headers: {
            'Content-Type': 'application/json'
        }
    };

    this.$http
            .post('http://localhost:8083/api/client/login',
            JSON.stringify(this.user),
            headers)

            .then(response => {
                const data = response.body;
                console.log(data);
                this.$store.state.loggedUser = data;

                this.$router.push('Profile'); 

            },
            (err) => {
                alert(err.status + " UNAUTHORIZED!");
                });
      }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
