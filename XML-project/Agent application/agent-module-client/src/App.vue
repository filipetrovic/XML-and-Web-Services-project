<template>
  <div id="app">
    <header class="header-container">
      <header-component class="header"></header-component>
    </header>
    <router-view class="page"></router-view>
    <footer-component class="footer-class"></footer-component>

  </div>
</template>

<script>
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent'

export default {
  name: 'App',
  components: {
    HeaderComponent,
    FooterComponent
  }
}
</script>

<style lang="scss">
@import './assets/scss/variables/vars.scss';

.page {
  color: white;
  margin: 0;
  min-height: 66vh;
  background:  linear-gradient( rgba(0,0,0, 0.6), rgba(0, 0, 0, 0.6)),  url("./assets/images/mudri-background.jpg");
  position:relative;
  z-index: -1;
  overflow: hidden;


}

.footer-class {
  position: relative;
  top: 100%;
  z-index: 2;

}

body {
  margin: 0;
}
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 0px;
  position: relative;
  z-index: 0;
}

.header-container {
  height : 162px;

}

.header{
  position: fixed;
  z-index: 1;

}

h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}

button {
  margin: 5px;
}


</style>
