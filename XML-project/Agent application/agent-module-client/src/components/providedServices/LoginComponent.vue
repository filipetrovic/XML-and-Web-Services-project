<template>
  <main>
    <section class="login-form">
      <h1>Login </h1>
      <input type="text" placeholder="Username" v-model="user.username">
      <input type="password" placeholder="Password" v-model="user.password">
      <button type="button" @click="login()"> Login </button>
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
      }
    }
  },
  methods: {
    login() { //ovo je sa mog modula kontam da ces slicno da napravis
      var body = this.user;
      console.log(JSON.stringify(body));
      this.$router.push('/home');
    //   this.$http.post("http://localhost:8090/login", body)
    //   .then(response => {
    //     this.$store.state.loggedUser = response.body;
    //     this.$router.push("/home");
    // }, err => {
    //   this.loginError = true;
    // })
    }

  }
}
</script>

<style lang="scss" scoped>
@import '../../assets/scss/variables/vars.scss';
  main {
    display:flex;
    justify-content: center;
    align-items:  center;

    section {
      width: 300px;
      height: 350px;
      border-radius: 20px;
      background: white;
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items:  center;

      h1 {
        color: $default-color;
      }

      input {
        color: white;
        width: 90%;
        height: 30px;
        padding: 0.2rem;
        padding-left: 1rem;
        margin: 1rem  0.2rem;
        border: none;
        background: $default-color;
        border-radius: 20px;
      }

      button {
        width: 50%;
        height: 30px;
        background: $default-color;
        border-radius: 20px;
        color: white;
        cursor: pointer;

        &:hover,
        &:active {
          color: black;
          background: gray;

        }

      }

    }
  }
</style>
