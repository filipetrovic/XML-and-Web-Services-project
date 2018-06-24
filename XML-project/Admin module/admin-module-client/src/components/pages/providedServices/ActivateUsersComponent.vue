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
        <tr  class="table-row" v-for="(user,index) in listOfUsers"  >
          <td>{{user.username}}</td>
          <td>{{user.email}}</td>
          <td> {{user.firstName}} {{user.lastName}} </td>
          <td  v-bind:class="{'animated': activeIndex === index}">
            <span v-if="user.deleted" >
              <span v-if="activeIndex === index" v-bind:class="{'animated': activeIndex === index}">
                Deleted
              </span>
              <span v-else> Deleted</span>
            </span>
            <span v-else>
              <span v-if="user.banned">Banned</span>
              <span v-else> Regular user</span>
            </span>


          </td>
          <td class="operations">
            <span>
              <i class="material-icons" @click="banUser(user,index)">
                block
              </i>
              <span class="tooltiptext">Ban</span>
            </span>
            <span>
               <i class="material-icons" @click="unbanUser(user,index)">
                check_circle_outline
              </i>
              <span class="tooltiptext">Unban</span>
            </span>
            <span>
              <i class="material-icons" @click="deleteUser(user,index)">
                delete
              </i>
              <span class="tooltiptext">Delete</span>
            </span>


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
      listOfUsers : [],
      activeIndex: -1
    }
  },
  methods: {
    banUser(user,index){
      if(user.deleted){
        this.activeIndex = index;
        setTimeout(() =>{
          this.activeIndex= -1;
        },650)
      } else {
      var body = user;
      this.$http.put("http://localhost:8084/banUser", body)
      .then(response => {
        this.$http.get("http://localhost:8084/getAllUsersThatAreNotAdmins")
        .then(list => {
                this.listOfUsers = list.body;
              })
        },
        (err) => {
          alert('This user\'s status has  been edited meanwhile.');
          this.$http.get("http://localhost:8084/getAllUsersThatAreNotAdmins")
          .then(response => {
            this.listOfUsers = response.body;

          });
        })
      }
    },

    unbanUser(user,index) {
      if(user.deleted){
        this.activeIndex = index;
        setTimeout(() =>{
          this.activeIndex= -1;
        },650)
      } else {
      var body = user;
      this.$http.put("http://localhost:8084/unbanUser", body)
      .then(response => {
        this.$http.get("http://localhost:8084/getAllUsersThatAreNotAdmins")
        .then(list => {
                this.listOfUsers = list.body;
              })
        },
        (err) => {
          alert('This user\'s status has  been edited meanwhile.');
          this.$http.get("http://localhost:8084/getAllUsersThatAreNotAdmins")
          .then(response => {
            this.listOfUsers = response.body;

          });
        })
      }
    },
    deleteUser(user,index) {
      if(user.deleted){
        this.activeIndex = index;
        setTimeout(() =>{
          this.activeIndex= -1;
        },650)
      } else {
        var body = user;
        this.$http.delete("http://localhost:8084/deleteUser", {body:body})
        .then(response => {
          this.$http.get("http://localhost:8084/getAllUsersThatAreNotAdmins")
          .then(list => {
                  this.listOfUsers = list.body;
                })
          },
          (err) => {
            alert('This user\'s status has  been edited meanwhile.');
            this.$http.get("http://localhost:8084/getAllUsersThatAreNotAdmins")
            .then(response => {
              this.listOfUsers = response.body;

            });
          })
        }
    }
  },
  created(){
    this.$http.get("http://localhost:8084/getAllUsersThatAreNotAdmins")
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
  @import '../../../assets/scss/mixins/tooltips/_tooltip.scss';

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
          span {
            @include tooltipContainer;

           i {
            font-size:1.7rem;
            transition: transform 0.2s ease-out;

            &:hover,
            &:active {
              transform: scaleX(1.2) scaleY(1.2);
              transition: transform 0.2s ease-out ;
            }
           }

           span {
             @include tooltip;
           }
        }
        }
      }
    }
  }

  .animated {
    animation: wiggle 0.3s 2 running ;
  }





  @keyframes wiggle {
    0% {
      transform: none;
      font-weight: normal;
    }
    1% {
      transform: rotateZ(5deg);
      font-weight: bold;
    }
    50% {
      transform: rotateZ(-10deg);
      font-weight: bold;
    }
    100% {
      transform: rotateX(5deg);
      font-weight: bold;
    }
  }
</style>
