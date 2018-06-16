<template>
  <div id="app" >
    
    <router-view ></router-view>
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld'
import Home from './components/Home'
import Registration from './components/Registration'
import Accommodations from './components/Accommodations'

export default {
  name: 'App',
  components: {
    HelloWorld,
    Home,
    Registration,
    Accommodations
  }
}
</script>

<style>

.page {
   background-image: linear-gradient(rgba(255,255,255,0.3), rgba(255,255,255,0.3)), url("assets/images/sand.png");
   background-size: 100%;
   background-repeat: no-repeat;
   
}

#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
