<template>
  <main class="background">
    <section class="welcome-message">
      <h1> Welcome to Admin module </h1>
      <p> Here you can do admin stuff:</p>
    </section>

    <section class="main-content">
      <ul class="items" >
        <li class="item codes" @click="$router.push('/updateCodes')">
          <img class="item_image" src="../../assets/images/encoder_icon.png" />
          <h2 class="item_title"> Update codes </h2>
          <p class="item_description">
            Here you can add, remove, or update avialable values for accommodation types, star ratings and facilities
          </p>
        </li>

        <li class="item comments" @click="$router.push('/approveComments')">
          <img class="item_image" src="../../assets/images/comment_icon.png" />
          <h2 class="item_title"> Approve user comments</h2>
          <p class="item_description"> Here you can delete comments before anyone can see them or you can make them public </p>
        </li>

        <li class="item users" @click="$router.push('/activateUsers')">
          <img class="item_image" src="../../assets/images/user_icon.png" />
          <h2 class="item_title">Activate/Block users</h2>
          <p class="item_description"> Here you can block, unblock and remove registered users </p>
        </li>

        <li class="item agents" @click="$router.push('/addAgents')">
          <img class="item_image " src="../../assets/images/agent_icon.png" />
          <h2 class="item_title"> Add agents</h2>
          <p class="item_description"> Here you can add bussiness agents who manage accommodation objects</p>
        </li>
      </ul>
    </section>


  </main>
</template>

<script>
  export default {

  }
</script>

<style lang="scss" scoped>
  @import '../../assets/scss/variables/vars.scss';
  @import '../../assets/scss/mixins/transitions/_itemTransition.scss';
  .welcome-message {
    text-align: left;
    text-shadow: 1px 1px 1px black;
    color: $text-color;
    * {
      margin: 0;
    }

    h1 {
      padding: 2rem;
      text-align: left;
      font-size: 2.5rem;
    }

    p {
      margin: 0;
      padding-top: 0;
      padding-left: 4rem;
      font-size: 1.5rem;
    }
  }

  .items {
    margin: 3rem 0;
    display: grid;
    grid-template-columns: 1fr 1fr;
    grid-template-rows: 1fr 1fr 1fr;
    grid-gap: 2rem 4rem;
    grid-template-areas: "codes codes"
                         "comments users"
                         "agents agents";

    .item {
      border: 2px solid $default-color;
      border-radius: 20px;
      padding: 1rem;
      color: $text-color;
      cursor: pointer;


      &:hover,
      &:active {
        @include itemOnHover;
      }

      .item_image {
        width: 4rem;
        height: 4rem
      }

      h2 {
        font-weight: bold;
      }

      p {
        padding-left: 3rem;
        padding-right: 3rem;
      }
    }

    .codes {
      grid-area: codes;
      width: 40%;
      margin: auto;
      transition: transform 0.1s ease-out;

      &:hover,
      &:active {
        transform: translateY(0.3rem);
      }
    }

    .agents {
      grid-area: agents;
      width: 40%;
      margin: auto;
      transition: transform 0.1s ease-out;
      &:hover,
      &:active {
        transform: translateY(-0.3rem);

      }
    }

    .comments {
      border-left: none;
      grid-area: comments;
      padding-left:0;
      margin-left:0;
      transition: transform 0.1s ease-out;
      &:hover,
      &:active {
        transform: translateX(0.3rem);
      }
    }

    .users {
      border-right: none;
      grid-area: users;
      padding-right: 0;
      margin-right: 0;
      transition: transform 0.1s ease-out;
      &:hover,
      &:active {
        transform: translateX(-0.3rem);
      }

    }

  }






</style>

