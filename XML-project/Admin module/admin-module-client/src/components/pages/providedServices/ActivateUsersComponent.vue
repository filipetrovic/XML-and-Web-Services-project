<template>
  <main>
    <section class="welcome-message">
      <h1> Welcome to Users page </h1>
      <p> Here you can ban, unban or delete registered users</p>
    </section>

    <section class="usersTable">

      <table>
        <tr class="header-row">

          <th> Username </th>
          <th> e-mail</th>
          <th> Full name</th>
          <th> Status</th>
          <th> </th>
        </tr>
<!--  -->
        <tr  class="table-row" v-for="user in listOfUsers"  >
          <td>{{user.username}}</td>
          <td>{{user.email}}</td>
          <td> {{user.firstName}} {{user.lastName}} </td>
          <td>
            <span v-if="user.deleted"> Deleted</span>
            <span v-else>
              <span v-if="user.banned">Banned</span>
              <span v-else> Regular user</span>
            </span>


          </td>
          <td class="operations">
            <i class="material-icons" @click="banUser(user)">
              block
            </i>
            <i class="material-icons" @click="unbanUser(user)">
              check_circle_outline
            </i>
            <i class="material-icons" @click="deleteUser(user)">
              delete
            </i>
          </td>
        </tr>


      </table>
    </section>
  </main>
</template>

<script>
export default {
  data() {
    return {
      listOfUsers : []
    }
  },
  methods: {
    banUser(user){
      var body = user;
      this.$http.put("http://localhost:8090/banUser", body)
      .then(response => {
        if(response.body){
          this.$http.get("http://localhost:8090/getAllUsers")
          .then(response => {
            this.listOfUsers = response.body;
          })
        } else {
          alert("Error occurred");
        }
      })
    },
    unbanUser(user) {
      var body = user;
      this.$http.put("http://localhost:8090/unbanUser", body)
      .then(response => {
        if(response.body){
          this.$http.get("http://localhost:8090/getAllUsers")
          .then(response => {
            this.listOfUsers = response.body;
          })
        } else {
          alert("Error occurred");
        }
      })
    },
    deleteUser(user) {
      var body = user;
      this.$http.delete("http://localhost:8090/deleteUser",{body: body} )
      .then(response => {
        if(response.body){
          this.$http.get("http://localhost:8090/getAllUsers")
          .then(response => {
            this.listOfUsers = response.body;
          })
        } else {
          alert("Error occurred");
        }
      })
    }
  },
  created(){
    this.$http.get("http://localhost:8090/getAllUsers")
      .then(response => {
        this.listOfUsers = response.body;
      })
  }
}
</script>

<style lang="scss" scoped>
  @import '../../../assets/scss/variables/vars.scss';
  @import '../../../assets/scss/mixins/transitions/_itemTransition.scss';
  @import '../../../assets/scss/mixins/buttons/_default.scss';
  @import '../../../assets/scss/mixins/forms/_forms.scss';
  @import '../../../assets/scss/mixins/pageParts/_pageParts.scss';
  @import '../../../assets/scss/mixins/tables/_defaultTable.scss';

  .welcome-message {
    @include welcomeMessage;
    margin-bottom: 6rem;
    }

  .usersTable {
    margin-bottom: 4rem;
    h1 {
      color: $text-color;
      font-size: 2rem;
      text-shadow: 1px 1px 1px $text-color;
    }
    table {
      @include defaultTable;
      min-width: 700px;

      .header-row {
        th:first-of-type{
          width: auto;
        }
      }

      tr {
        .operations {
           i{
            font-size:1.7rem;
            transition: transform 0.2s ease-out;

            &:hover,
            &:active {
              transform: scaleX(1.2) scaleY(1.2);
              transition: transform 0.2s ease-out ;
            }
           }

        }
      }
  }}
</style>
