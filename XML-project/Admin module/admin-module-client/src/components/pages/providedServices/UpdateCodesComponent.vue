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

    <section class="selectedRegistryTable" >
      <h2> {{selectedRegistry}} </h2>
      <table>
        <tr class="header-row">
          <th > Id </th>
          <th> Name </th>
          <th> </th>
        </tr>
        <tr class="table-row" >
          <td>Id</td>
          <td>Name</td>
        </tr>
      </table>
    </section>


    <ul>
      <li>
        <h2 @click="test()"> bbb</h2>

      </li>
    </ul>
  </main>
</template>

<script>
export default {
  data() {
    return {
      selectedRegistry : "Accommodation type"
    }
  },
  methods: {
    test() {
      this.$http.get("http://localhost:8090/getAllFacilities")
      .then(response=> {
        console.log(response);
      })
    },
    changeSelectedRegistry(registry) {
      this.selectedRegistry = registry;
    }
  }
}
</script>

<style lang="scss" scoped>
  @import '../../../assets/scss/variables/vars.scss';
   @import '../../../assets/scss/mixins/transitions/_itemTransition.scss';
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
    }

    table {
      width: 90%;
      margin: 1rem auto;
      border-collapse: collapse;

      .header-row {
        background: $default-color;
      }
      tr {
       border-bottom: 1px solid $default-color;
       padding: 0.5rem;

        th {
          text-transform: uppercase;
          border-right: 1px solid white;
          padding: 0.5rem;
        }

        td {
          padding: 0.5rem;
        }
      }


    }

  }



</style>
