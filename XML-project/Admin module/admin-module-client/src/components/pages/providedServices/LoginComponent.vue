<template>
  <main>
    <section class="login-container">
      <div class="form">
        <img src="../../../assets/images/user.png" />
        <h4> Login</h4>

        <div>

          <input type="text" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Username'" placeholder="Username" v-model="user.username" @input="loginError =  false">
          <span></span>
          <i class="material-icons"> person </i>
        </div>
        <div>

          <input type="password" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Password'" placeholder="Password" v-model="user.password" @input="loginError =  false">
          <span></span>
          <i class="material-icons"> lock </i>
        </div>

        <span class="error-message" v-bind:class="{'error': loginError}">
          <i class="material-icons"> warning </i><p> <span>ERROR:</span> Wrong username or password </p>
        </span>

        <button @click="login()"> Login</button>
      </div>
    </section>

  </main>
</template>

<script>
export default {
  data() {
    return {
      user: {
        username: '',
        password: '',
        firstName: '',
        lastName: '',
        email: ''
      },
      loginError: false
    }
  },
  methods: {
    login() {
      var body = this.user;
      this.$http.post("http://localhost:8090/login", body)
      .then(response => {
        this.$store.state.loggedUser = response.body;
        this.$router.push("/home");
    }, err => {
      this.loginError = true;
    })
    }
  }
}
</script>

<style lang="scss" scoped>
@import '../../../assets/scss/variables/vars.scss';
@import '../../../assets/scss/mixins/buttons/_default.scss';
@import '../../../assets/scss/mixins/forms/_forms.scss';

 ::placeholder {
   color: $login-form-color;
 }

  main {
    background: linear-gradient( rgba(0,0,0, 0.3), rgba(0, 0, 0, 0.3)),  url("../../../assets/images/login-image.jpg");
    background-size: auto auto;
    background-repeat: no-repeat;
    background-position: left top;
    position: relative;
    min-height: 768px;
    z-index: 1;
    display: flex;
    justify-content: center;
    align-items: center;

    &:before {
      display: none;
    }
  }

  .login-container {
    box-shadow: 2px 2px 2px 2px gray;
    padding: 1rem;
    width: 390px;
    min-height: 480px;
    max-height: 520px;

    background: linear-gradient(rgba(115, 68, 177,0.95), rgba(100, 2, 100,0.95));
    border-radius:20px;
    position:relative;

    .form {

      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;

      h4 {
        font-size: 2rem;
        color: $login-form-color;
        margin: 0;
        padding: 0;
      }

      img {
        width: 4rem;
        height: 4rem;
        border-radius: 50%;
        background: $default-color;
        color: $text-color;
        font-size: 3rem;
        border: 2px solid white;
        margin-bottom: 2rem;
      }

      div {
        box-sizing: border-box;
        width: 90%;
        color: black;
        position: relative;
        display: flex;
        justify-content: center;
        align-items: center;

        i {
          position: absolute;
          left: 0;
          bottom: 7px;
          color: white;
          transition: all 0.3s linear;
        }


        input {
          width: 100%;
          height: 30px;
          border: none;
          padding: 0.2rem 0.5rem;
          font-size: 1.3rem;
          padding-left: 2rem;
          margin-top: 2rem;
          border-bottom: 2px solid darken($login-form-color,10%);
          transition: all 0.2s linear;
          background: transparent;
          color: white;

          &:focus {
            padding-left: 0;
            transition: all 0.2s linear;
          }

          &:focus ~ span {
            width: 100%;
            transition: all 0.3s linear;
          }

          &:focus ~ i {
            bottom: 40px;
            transform: scaleX(0.8) scaleY(0.8);
            transition: all 0.2s linear;
          }
        }

        span {

          position: absolute;
          left: 0%;
          content: '';

          height: 2px;
          background: white;
          transition: all 0.3s linear;
          width: 0;
          bottom: 0px;
          z-index: 1;
        }



      }

      .error-message{
        opacity: 0;
        z-index: -1;
        transition: all 0.3s ease-out;
        border: 2px solid red;
        background: darken(red,20%);
        border-radius: 10px;
        margin: 1rem;
        margin-top: 1.5rem;
        padding: 0.6rem;
        color: white;
        text-align: left;
        text-shadow: 1px 1px 1px black;
        position: relative;

        i {
          position: absolute;
          font-size: 2.2rem;
          bottom: 3px;
        }

        p {
          margin: 0;
          padding:0;
          padding-left: 3rem;
          span {

          font-weight: bold;
        }
        }

      }

      .error {
        opacity: 1 ;
        z-index: 1;
        transition: all 0.3s ease-out;
      }

      button {
        margin-top: 2rem;
        border-radius: 30px;
        border: none;
        background-color:  $login-form-color;
        color: black;
        font-size: 1.3rem;
        padding: 0.5rem 1rem;
        width: 50%;
        min-height: 55px;
        transition: all 0.3s ;
        position:absolute;
        bottom: 6%;

        &:hover,
        &:active {
          background-color: white;
          box-shadow: 1px 1px 1px 1px gray;
          transform: scaleX(1.05) scaleY(1.05);
          transition: all 0.3s ;
        }
      }




    }
  }


</style>


