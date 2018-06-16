<template>
  <main>
    <section class="welcome-message">
      <h1> Welcome to Agents page </h1>
      <p> Here you can add new agents and see infromation about all other agents  </p>
    </section>

    <section class="main-content">
      <h1> Add new agent </h1>
      <form class="add-agent-form">
        <label>Name</label>
        <input type="text" placeholder="Enter agent's name" v-model="agent.name"/>
        <label>Surname</label>
        <input type="text" placeholder="Enter agent's surname" v-model="agent.surname"/>
        <label>Address <span> * </span></label>

        <input type="text" placeholder="Enter agent's address"
        v-model="agent.address"
        v-bind:class="{  'has-error': !validAddress }"
        @input="validateForm()"/>

        <label>Bussiness number <span> * </span></label>

        <input type="text" placeholder="Enter agent's bussines number"
        v-model="agent.bussinessNumber"
        v-bind:class="{ 'has-error': !validBussinessNumber }"
        @input="validateForm()"/>

        <button type="button" @click="addNewAgent()"> Add </button>
      </form>
    </section>

    <section class="agentsTable">
      <h1> All agents </h1>
      <table>
        <tr class="header-row">
          <th > Id </th>
          <th> Name </th>
          <th> Surname</th>
          <th> Address</th>
          <th> Bussiness Number</th>

        </tr>

        <tr  class="table-row"  v-for="a in listOfAgents" >
          <td>{{a.id}}</td>
          <td>{{a.name}}</td>
          <td> {{a.surname}}</td>
          <td> {{a.address}} </td>
          <td> {{a.bussinessNumber}}</td>
        </tr>


      </table>
    </section>

  </main>
</template>

<script>
import {required, maxLength} from 'vuelidate/lib/validators';

export default {
  data() {
    return {
      agent: {
        name: '',
        surname: '',
        address: '',
        bussinessNumber: ''
      },
      validAddress: true,
      validBussinessNumber: true,
      listOfAgents: []
    }
  },
  methods: {
    addNewAgent() {
      var f = this.validateForm();

      if (!f){
      } else {
      var params = {  'name' : this.agent.name,
                      'surname' : this.agent.surname,
                      'address' : this.agent.address,
                      'bussinessNumber' : this.agent.bussinessNumber };

      this.$http.post("http://localhost:8090/addAgent", null, {params: params})
        .then(response => {
          this.$http.get("http://localhost:8090/getAllAgents")
            .then(list => {
              this.listOfAgents = list.body;
            })
          if (!response.body){
            alert('Error occurred!');
          }
        })
      }
    },
    validateForm(){
      console.log('usao')
      if (this.agent.address !== ''){
        this.validAddress = true;
      } else {
        this.validAddress = false;
      }
      if (this.agent.bussinessNumber !== ''){
        this.validBussinessNumber = true;
      } else {
        this.validBussinessNumber = false;
      }
      if(this.agent.address ==='' || this.agent.bussinessNumber === ''){
        return false;
      } else {
        return true;
      }
    }
  },
  created() {
    this.$http.get("http://localhost:8090/getAllAgents")
      .then(response => {
        this.listOfAgents = response.body;

      })
  }

}
</script>

<style lang="scss" scoped>
  @import '../../../assets/scss/variables/vars.scss';
  @import '../../../assets/scss/mixins/pageParts/_pageParts.scss';
  @import '../../../assets/scss/mixins/buttons/_default.scss';
  @import '../../../assets/scss/mixins/tables/_defaultTable.scss';
  @import '../../../assets/scss/mixins/transitions/_itemTransition.scss';

  .welcome-message {
    @include welcomeMessage;
  }

  .main-content {
    margin-top: 3rem;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    h1 {
      color: $text-color;
      font-size: 2rem;
      text-shadow: 1px 1px 1px $text-color;
    }
    form {
      margin-bottom: 4rem;
      width: 50%;
      display: grid;
      grid-template-columns: 1fr 3fr;
      grid-template-rows: 1fr 1fr 1fr;
      grid-gap: 1rem;

      label {
        align-self: center;
        text-align: left;
        font-weight: bold;

        span {
          color: red;
        }
      }

      input {
      padding: 0.5rem 1rem;
      margin: 0.5rem 0;
      border: 2px solid lighten($default-color,15%);
      border-radius: 6px;
      font-size: 1rem;

      &:focus {
        background : lighten($default-color,40%)
        }
      }

      button {
        @include defaultButton;
        width: 40%;
        justify-self: center;
        grid-column-start: 1;
        grid-column-end: span 2;
      }

    }

    .has-error {
      border:2px solid $form-error-color;
      background: lighten($form-error-color, 15%) !important;
    }
  }

.agentsTable {
  margin-bottom: 4rem;
  h1 {
    color: $text-color;
    font-size: 2rem;
    text-shadow: 1px 1px 1px $text-color;
  }
  table {
    @include defaultTable;
    min-width: 700px
  }
}

</style>
