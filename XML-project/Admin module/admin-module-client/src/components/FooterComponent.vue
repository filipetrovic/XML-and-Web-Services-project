<template>
<footer>
  <section class="footer">
    <nav class="footer-nav">
      <ul class="footer-nav__items">
        <li class="footer-nav__item ">
            <a  href="#">About us</a>
        </li>
        <li class="footer-nav__item ">
            <a  href="#">Contact</a>
        </li>
      </ul>
    </nav>

    <div class="footer__logo">

      <a disabled href="" class="footer__logo--image">
         <img src="../assets/images/admin_logo.png" alt="uHost"/>
      </a>
    </div>
  </section>
</footer>
</template>

<script>
  export default {

  }
</script>

<style lang="scss" scoped>
  @import '../assets/scss/variables/vars.scss';


  footer {
    display: flex;
    flex-direction: column;
  }

  .footer {
    width: 100%;
    color: white;
    background-color: rgba(16, 16, 16, 0.952);
    display: flex;
    align-items:center;
    justify-content: space-between;
    min-height: 9rem;

    .footer-nav {
      margin-left: 4rem;

      .footer-nav__item a {
        margin: 0rem 1.2rem;
        color: white;
        text-decoration: none;
        font-size: 1rem;
        text-transform: uppercase;
        transition: color 0.2s;

        &:hover,
        &:active {
          color: #919191;
          transition: color 0.2s;
        }
      }
    }
  }

  .footer__logo {
    display:flex;
    align-items: center;

    a  {
      text-decoration: none;
      margin-right : 6.25rem;
      margin-left: 0.8rem;

      img {
        height: 4.7rem;
      }
    }
  }




</style>

