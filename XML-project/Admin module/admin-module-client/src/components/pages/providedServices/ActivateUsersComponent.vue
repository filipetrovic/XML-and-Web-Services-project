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
          <th> Password</th>
          <th> Status</th>
          <th> </th>
        </tr>
<!--  -->
        <tr  class="table-row" v-for="user in listOfUsers"  >
          <td>{{user.username}}</td>
          <td>{{user.email}}</td>
          <td> {{user.password}} </td>
          <td> {{user.banned}}</td>
          <td class="operations">
            <i class="material-icons" @click="deleteRegistryCode(registry)">
              block
            </i>
            <i class="material-icons" @click="editRegistryCode(registry)">
              check_circle_outline
            </i>
            <i class="material-icons" @click="deleteRegistryCode(registry)">
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
  }}
</style>
