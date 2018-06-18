<template>
  <main>
    <section class="login-container">
      <p>login</p>
    </section>

  </main>
</template>

<script>
export default {

}
</script>

<style lang="scss" scoped>
@import '../../../assets/scss/variables/vars.scss';
@import '../../../assets/scss/mixins/buttons/_default.scss';
@import '../../../assets/scss/mixins/forms/_forms.scss';

  main {
    background: linear-gradient( rgba(0,0,0, 0.3), rgba(0, 0, 0, 0.3)),  url("../../../assets/images/login-image.jpg");
    background-size: 100%;
    background-position: center;
    position: relative;
    z-index: 100;
    display: flex;
    justify-content: center;
    align-items: center;

    &:before {
      display: none;
    }
  }

  .login-container {
    width: 30vw;
    height: 8vh;
    background: white;
  }
</style>


