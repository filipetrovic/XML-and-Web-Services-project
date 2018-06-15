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
                    <a class="uppercase" href="start-hosting/index.html">About us</a>
                </li>
                <li class="main-nav__item ">
                    <a class="uppercase" href="start-hosting/index.html">Contact</a>
                </li>
                <li class="main-nav__item main-nav__item--cta ">
                  <a href="#">{{phoneNumber}}</a>
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

    .main-nav__items {
        margin-right: 0.5rem;
        padding: 0;

        .main-nav__item {
            padding: 0.2rem 0.7rem;
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
    }


    .main-nav__item--cta {
        padding: 0;
        padding-right: 0.4rem;
        border-bottom: 2px solid transparent;

        &:hover,
        &:active {
            cursor: pointer;
            border-bottom: 2px solid $default-color;
        }

        a {
            padding: 0.5rem 1rem;
            padding-left: 0;
            color:  $default-color !important;
            font-weight: bolder;
        }


    }

    @media only screen and (max-width:768px) {
        .main-header {
            padding-left: 0;
        }

        .main-header__name {
            padding-left: 0.5rem;

            .main-header__brand p {
                font-size: .8rem;


                span {
                    display: block;
                    font-weight: bold;
                    font-size: 1.2rem;
                    color: black;
                }
            }

            .main-header__brand img {
                height: 2.43rem;
            }
        }

        .main-nav__items {
            display: none;
        }
    }




</style>
