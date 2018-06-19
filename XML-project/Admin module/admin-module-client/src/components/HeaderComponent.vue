<template>
    <section class="main-header">
        <div class="main-header__name">
            <router-link to="/home" class="main-header__brand">
                <img src="../assets/images/admin_logo.png" alt="Moore Creations"/>
                <p class="uppercase"> <span class="main-header__brand--title ">Administration</span> module</p>
            </router-link>
        </div>
        <nav class="main-nav">
            <ul class="main-nav__items">

                <li class="main-nav__item ">
                    <router-link to="/updateCodes" tag="a"  >Codes</router-link>
                </li>
                <li class="main-nav__item ">
                    <router-link  to="/approveComments" tag="a"  >Comments</router-link>
                </li>
                <li class="main-nav__item ">
                    <router-link  to="/activateUsers" tag="a" >Users</router-link>
                </li>
                <li class="main-nav__item ">
                    <router-link  to="/addAgents" tag="a" >Agents</router-link>
                </li>
                <li class="main-nav__item--cta">
                    <router-link  to="/login" tag="a" >Login</router-link>
                </li>

            </ul>
        </nav>
    </section>

</template>


<script>
export default {
    data() {
        return {
            phoneNumber: '07123 456 890',
            clicked: false
        }
    },
    methods: {
        activate() {
            this.$store.commit('changeIsActivated');
            if (this.clicked === false){
                this.clicked = true;
            }
        },
        deactivate() {
            console.log('deactivated');
            this.$store.commit('changeIsActivated');
        }
    },
    computed: {
        isActivated() {
            return this.$store.getters.getIsActivated;
        }
    }

}

</script>

<style lang="scss" scoped>
    @import '../assets/scss/variables/vars.scss';

    .main-header {
        padding: 0.5rem 1rem;
        width: 100vw;
        position:fixed;
        display: flex;
        align-items: center;
        justify-content: space-between;
        z-index: 2;
        background-color: white;
        overflow: hidden;

    }

    .main-header__brand {
        display: flex;
        align-items: center;
        text-decoration: none;
        text-align: left;
        color: $default-color;
        text-transform: uppercase;

        p {
            padding: 1rem;
            font-size: 1rem;

            span {
                display: block;
                font-weight: bold;
                font-size: 1.5rem;
                color: black;
            }
        }

        img {
            height: 4.43rem;
            position:relative;
            top: 0.156rem;

        }
    }

    .main-nav {
      margin-right: 2rem;
      overflow: hidden;

    }

    .main-nav__items {

        padding: 0;


        .main-nav__item {
            padding: 0.2rem 0.4rem;
            font-weight: normal;

            a {
                color: black;
                text-decoration: none;
                font-family: 'Gill Sans',  sans-serif;
                text-transform: uppercase;
                transition: color 0.2s;

                &:hover,
                &:active {
                    transition: color 0.2s;
                    color:  $default-color;
                }
            }
        }

        .main-nav__item--cta {
          padding: 0;
          padding-right: 0.4rem;
          a {
              padding: 0.5rem 1rem;
              padding-left: 0;
              color:  $default-color !important;
              font-weight: bolder;
              text-transform: uppercase;
              text-decoration: none;
              transition: color 0.2s ease-out;

              &:hover,
              &:active {
              cursor: pointer;
              color: darken($default-color, 20%) !important;
              transition: color 0.2s ease-out;

          }
        }


    }


    }






</style>
