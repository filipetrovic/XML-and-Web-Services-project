<template>
  <main>
    <div class="backdrop"></div>
    <table>
      <tr>
        <th>ID</th>
        <th>Check in</th>
        <th>Check out</th>
        <th>Accommodation</th>
        <th>Client</th>
        <th>Confirmed</th>
        <th></th>
      </tr>
      <tr v-for="res in reservations">
        <td> {{res.id}}</td>
        <td> {{res.checkInDate}}</td>
        <td> {{res.checkOutDate}}</td>
        <td> {{res.accommodation.name}}</td>
        <td> {{res.user.username}}</td>
        <td> {{res.arrivalConfirmed}}</td>
        <td class="operations">
          <i class="material-icons" @click="openMessage()"> message</i>
          <i class="material-icons" @click="confirmReservation(res)"> done</i>
        </td>
      </tr>
    </table>

    <section class="message-popup">


    </section>
  </main>

</template>

<script>
export default {
  data() {
    return {
      reservations: [
    {
        "id": 2,
        "checkInDate": "1970-01-01",
        "checkOutDate": "1970-01-01",
        "arrivalConfirmed": false,
        "priceOfReservation": 10000,
        "user": {
            "id": 1,
            "username": "ivan@gmail.com",
            "password": "MTIz",
            "firstName": "Ivan",
            "lastName": "Jancic",
            "email": "ivan@gmail.com",
            "banned": false,
            "deleted": false,
            "authorities": [
                {
                    "name": "REGISTERED_USER"
                }
            ],
            "version": 3
        },
        "accommodation": {
            "id": 2,
            "startDateAvailable": "3918-07-14",
            "endDateAvailable": "3918-09-14",
            "name": "Hotel Viking",
            "pictures": "",
            "description": "veliki hotel vikinga",
            "pricePerPerson": 4000,
            "rating": 5,
            "inputAddress": "Smederevo, Kneza Milosa 35",
            "numberOfPeople": 4,
            "typeOfAccommodation": "hotel",
            "category": "2 star",
            "additionalFacilities": []
        }
    },
    {
        "id": 1,
        "checkInDate": "1970-01-01",
        "checkOutDate": "1970-01-01",
        "arrivalConfirmed": false,
        "priceOfReservation": 5000,
        "user": {
            "id": 1,
            "username": "ivan@gmail.com",
            "password": "MTIz",
            "firstName": "Ivan",
            "lastName": "Jancic",
            "email": "ivan@gmail.com",
            "banned": false,
            "deleted": false,
            "authorities": [
                {
                    "name": "REGISTERED_USER"
                }
            ],
            "version": 3
        },
        "accommodation": {
            "id": 1,
            "startDateAvailable": "3918-07-18",
            "endDateAvailable": "3918-09-18",
            "name": "Apartmani Pekic",
            "pictures": "",
            "description": "neki novi apartmani",
            "pricePerPerson": 1750,
            "rating": 3,
            "inputAddress": "Smederevo, Carina",
            "numberOfPeople": 5,
            "typeOfAccommodation": "appartment",
            "category": "5 stars",
            "additionalFacilities": []
        }
    }]
    }
  },
  methods: {
    openMessage() {
      console.log("open message");

    },
    confirmReservation(res) {
      console.log(JSON.stringify(res));
    }
  }

}
</script>

<style lang="scss" scoped>
@import '../../assets/scss/variables/vars.scss';

.backdrop {
  display: none;
  z-index: 100;
  width: 100vw;
  height: 100vh;
  background: gray;
}

table {
  padding: 0.3rem;

  width: 90%;
  border-collapse: collapse;
  margin: auto;
  margin-top: 50px;
  tr:first-of-type{
    background: $default-color;;
    border: none;
    height: 50px;
  }

  tr {
    border-bottom: 1px solid $default-color;
    &:hover {
      background: $default-color
    }

    .operations {
      i {
        cursor: pointer;
      }
    }
  }
}
</style>
