<template>
  <main>

    <section class="welcome-message">
      <h1> Welcome to Codes update </h1>
      <p> Here you can choose which code registry you want to change:</p>
    </section>

    <section class="main-content">
      <ul class="items">
        <li class="item " @click="changeSelectedRegistry('Accommodation type')" :class="{active: selectedRegistry === 'Accommodation type'}">
          <h3 class="item_title">Accomodation types</h3>
        </li>
        <li class="item" @click="changeSelectedRegistry('Star rating')" :class="{active: selectedRegistry === 'Star rating'}">
          <h3 class="item_title">Star ratings </h3>
        </li>
        <li class="item"  @click="changeSelectedRegistry('Facility')" :class="{active: selectedRegistry === 'Facility'}">
          <h3 class="item_title" >Facilities</h3>
        </li>
      </ul>
    </section>

    <section class="selectedRegistryTable">
      <h2> {{selectedRegistry}} </h2>
      <table>
        <tr class="header-row">
          <th > Id </th>
          <th> Name </th>
          <th class="header-operations"> </th>
        </tr>
        <tr v-for="registry in listOfSelectedRegistries" class="table-row" >
          <td>{{registry.id}}</td>
          <td>{{registry.name}}</td>
          <td class="operations">
            <i class="material-icons">
              delete
            </i>
            <i class="material-icons">
              edit
            </i>
          </td>
        </tr>

      </table>
    </section>

    <section class="addNewCode" >
      <h4 @click="formActivated = true" v-if="!formActivated">
          <i class="material-icons"> add </i> New code
      </h4>

      <form class="form" v-if="formActivated">
        <label >Enter code name </label>
        <input type="text"  placeholder="Enter code name here...">
        <button type="button" @click="formActivated = false"> Add </button>
      </form>
    </section>
  </main>
</template>

<script>
export default {
  data() {
    return {
      selectedRegistry : "Accommodation type",
      listOfSelectedRegistries : [],
      formActivated: false
    }
  },
  methods: {
    changeSelectedRegistry(registry) {
      this.selectedRegistry = registry;
      if (this.selectedRegistry ===  'Accommodation type') {
        this.$http.get("http://localhost:8090/getAllAccommodationTypes")
          .then(response => {
            this.listOfSelectedRegistries = response.body;
          },
          (err) => {
            console.log("Err", err);
          })
          .catch((e) => {
            console.log("Caught exception", e);
          })
      } else if (this.selectedRegistry ===  'Star rating') {
        this.$http.get("http://localhost:8090/getAllStarRatings")
          .then(response => {
            this.listOfSelectedRegistries = response.body;
          },
          (err) => {
            console.log("Err ", err);
          })
          .catch((e) => {
            console.log("Caught exception", e);
          })
      } else {
        this.$http.get("http://localhost:8090/getAllFacilities")
          .then(response => {
            this.listOfSelectedRegistries = response.body;
          },
          (err) => {
            console.log("Err", err);
          })
          .catch((e) => {
            console.log("Caught exception", e);
          })
      }
    }

  },
  created() {
      this.$http.get("http://localhost:8090/getAllAccommodationTypes")
          .then(response => {
            this.listOfSelectedRegistries = response.body;
          },
          (err) => {
            console.log("Err", err);
          })
          .catch((e) => {
            console.log("Caught exception", e);
          })
    }
}
</script>

<style lang="scss" scoped>
  @import '../../../assets/scss/variables/vars.scss';
  @import '../../../assets/scss/mixins/transitions/_itemTransition.scss';
  @import '../../../assets/scss/mixins/buttons/_default.scss';
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
    display: flex;
    justify-content: center;
    margin: 3rem 0;
    .item {
      padding: 0;
      width: 30%;
      height: 60px;
      border: 2px solid $default-color;
      border-radius: 20px;
      &:hover,
      &:active {
        @include itemOnHover;
      }
    }
    .active {
      @include itemOnHover;
    }
  }

  .selectedRegistryTable {
    h2 {
      text-align: left;
      padding: 1rem 2rem;
      color: $text-color;
      text-shadow: 1px 1px 1px black;
    }

    table {
      width: 90%;
      margin: 1rem auto;
      border-collapse: collapse;

      .header-row {
        box-sizing: border-box;
        background: $default-color;
        color: white;
        text-transform: uppercase;

        th:first-of-type{
          width: 50px;
        }
        th {
          padding: 0.5rem;
          border-left: 2px solid white;
        }

        .header-operations {
          width: 100px;
        }

      }
      tr:not(:first-of-type) {
      border-bottom: 1px solid $default-color;

      &:hover,
      &:active {
        background: lighten($default-color,30%);
      }


      td {
        padding: 0.5rem;
      }

      td:first-of-type {
        font-weight: bold;
      }

      .operations {
        display: flex;
        justify-content: space-around;

          i {
            cursor: pointer;
            @include linkTransition;
            &:hover,
            &:active {
              @include linkTransition;
              color: darken($default-text-color,15%)
            }
          }
        }
      }
    }
  }

  .addNewCode {
      h4 {
        text-align: left;
        color: $default-color;
        padding-left: 4rem;
        @include linkTransition;

        &:hover,
        &:active {
          color: darken($default-color,15%);
          cursor: pointer;
          @include linkTransition;
        }

        i {
          position: relative;
          top: 5px;
        }
      }

      .form {
        display: flex;
        flex-direction:  column;
        justify-content: left;
        text-align: left;
        width: 90%;
        margin: 1rem auto;

        label {
          font-weight: bold;
          padding-bottom: 0.3rem;
        }
        input {
          padding: 0.8rem;
          margin: 0.5rem 0;
          border: 2px solid lighten($default-color,15%);
          border-radius: 4px;
          font-size: 1rem;

          &:focus {
            background : lighten($default-color,40%)
          }
        }

        button {
          @include defaultButton;
          margin-top: 0.3rem;

        }
      }
    }



</style>
