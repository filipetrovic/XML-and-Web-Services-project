<template>
  <main>
    <section class="welcome-message">
      <h1> Welcome to Add units page </h1>
      <p> Here you can add new accommodation units  </p>
    </section>

    <section class="main-content">

      <form class="add-agent-form">
        <label>Address <span> * </span></label></label>
        <input type="text" placeholder="Enter accommodation location" v-model="accommodationUnit.address" />

        <label>Accommodation type</label>
        <select v-model="accommodationUnit.selectedAccommodationType">
          <option v-for="type in accommodationTypes" >
            {{type.name}}
          </option>
        </select>


        <label>Description <span> * </span></label>
        <input type="text" placeholder="Enter accommodation description" v-model="accommodationUnit.description"/>

        <label>Capacity <span> * </span></label>
        <input type="text" placeholder="Enter how many people can be handled" v-model="accommodationUnit.capacity"/>

        <label>Facilities <span> * </span></label>
        <div class="checkbox-container">
          <div v-for="facility in facilities">
          <input type="checkbox" v-bind:value="facility.name" v-model="accommodationUnit.selectedFacilities" />
          <label> {{facility.name}}</label>
        </div>
        </div>


        <label>Price <span> * </span></label>
        <input type="text" placeholder="Enter price for one night" v-model="accommodationUnit.price"/>

        <p>ovde dodaj sliku</p>

        <button type="button" @click="addAccommodationUnit()" > Add </button>
      </form>
    </section>
    {{accommodationUnit}}

    <!-- <section class="agentsTable">
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
    </section> -->

  </main>
</template>

<script>


export default {
  data() {
    return {
      facilities: [
    {
        "id": 1,
        "name": "WiFi",
        "version": 0
    },
    {
        "id": 2,
        "name": "Parking",
        "version": 0
    },
    {
        "id": 3,
        "name": "Spa centre",
        "version": 0
    },
    {
        "id": 4,
        "name": "Gym",
        "version": 0
    },
    {
        "id": 5,
        "name": "Swimming pool",
        "version": 0
    },
    {
        "id": 6,
        "name": "Sauna",
        "version": 0
    }],
      accommodationTypes: [
    {
        "id": 1,
        "name": "Hotel",
        "version": 0
    },
    {
        "id": 2,
        "name": "Hostel",
        "version": 0
    },
    {
        "id": 3,
        "name": "Apartments",
        "version": 0
    },
    {
        "id": 4,
        "name": "Guest house",
        "version": 0
    },
    {
        "id": 5,
        "name": "Homestay",
        "version": 0
    },
    {
        "id": 6,
        "name": "Bed and breakfast",
        "version": 0
    }],
      accommodationUnit: {
        address: '',
        selectedAccommodationType: 'sasggasgas',
        description: '',
        capacity: Number = 0,
        selectedFacilities: [],
        price: Number = 0
      }


    }
  },
  methods: {
    addAccommodationUnit(){
      //ovde saljes this.accomodationUnit na backend da se doda u bazu
      console.log(this.accommodationUnit);
    }
  },
  created() {
    //ovde getujes facilitije i accommodationTypes
    console.log('get Facilities i getAccommodationTypes')
  }


}
</script>

<style lang="scss" scoped>
@import '../../assets/scss/variables/vars.scss';

  .welcome-message {
    text-align: left;
    padding: 1rem;
    p {
      padding-left: 2rem;
    }
  }
  .main-content {
    display: flex;
    justify-content:  center;
    align-items:  center;


    form {
      padding: 1rem;
      margin-bottom: 4rem;
      width: 50%;
      display: grid;
      grid-template-columns: 1fr 3fr;
      grid-template-rows: 1fr 1fr 1fr;
      grid-gap: 1rem;

      .checkbox-container {
        display: flex;
        align-items: flex-start;
        flex-direction: column;
      }

      p  {
        background: white;
        color: black;
        padding: 0.2rem 2rem;
        border: 3px solid  red;
        position: relative;
        float: right;
      }

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

      select {
        height: 2.6rem;
        border: 2px solid $default-color;
        border-radius: 5px;
      }

      button {

        width: 40%;
        height: 3rem;
        justify-self: center;
        grid-column-start: 1;
        grid-column-end: span 2;
        background: $default-color;
        color: white;
        border: none;
        border-radius: 5px;

        &:hover,
        &:active {
          background: white;
          color: black
        }

      }

    }
  }

</style>
