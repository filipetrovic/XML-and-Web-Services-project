<template>
  <main>
    <div class="backdrop" @click="popupActivated = false" v-bind:class="{popupActive: popupActivated}"></div>
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
            <span>
              <i class="material-icons" @click="editRegistryCode(registry)">
                edit
              </i>
              <span class="tooltiptext">Edit</span>
            </span>

            <span>
              <i class="material-icons" @click="deleteRegistryCode(registry)">
              delete
              </i>
              <span class="tooltiptext">Delete</span>
            </span>


          </td>
        </tr>

      </table>
    </section>

    <section class="addNewCode" >
      <h4 @click="formActivated = true; validAddForm=true" v-if="!formActivated">
          <i class="material-icons"> add </i> New code
      </h4>

      <div class="form" v-if="formActivated">
        <label >Enter code name </label>
        <input type="text"  placeholder="If empty click add to cancel..." v-model="newRegistryCode"
        v-on:keyup.enter="formActivated = false; addRegistryCode()"

        >
        <button type="button" @click="formActivated = false; addRegistryCode()"> Add </button>
      </div>
    </section>

    <section class="edit-popup" v-bind:class="{popupActive: popupActivated}">
      <h4>
          Edit code
      </h4>
      <div class="form-popup" >
        <label >Enter new code name </label>
        <input type="text" @input="validateForm()" v-bind:class="{ 'has-error': !validForm }"  v-model.once="codeForEditing.name" v-on:keyup.enter="popupActivated=false; submitEditRegistryCode()">
        <button type="button" @click="popupActivated=false;submitEditRegistryCode()" > Edit </button>
      </div>
    </section>
  </main>
</template>

<script>
export default {
  data() {
    return {
      selectedRegistry : "Accommodation type",
      listOfSelectedRegistries : [],
      formActivated: false,
      newRegistryCode: "",
      codeForEditing: { 'id' : '0', 'name' : ''},
      popupActivated: false,
      validForm : true
    }
  },
  methods: {
    changeSelectedRegistry(registry) {
      this.selectedRegistry = registry;
      switch (this.selectedRegistry){
        case 'Accommodation type':
          this.$http.get("http://localhost:8084/getAllAccommodationTypes")
          .then(response => {
            this.listOfSelectedRegistries = response.body;
          })
          break;
        case 'Star rating':
          this.$http.get("http://localhost:8084/getAllStarRatings")
          .then(response => {
            this.listOfSelectedRegistries = response.body;
          })
          break;
        case 'Facility':
          this.$http.get("http://localhost:8084/getAllFacilities")
          .then(response => {
            this.listOfSelectedRegistries = response.body;

          })
      }
    },
    addRegistryCode() {
      if (this.newRegistryCode === ''){
        //napisi pored dugmeta, polje je prazno, klikni opet da cancel
      } else {
        var params = { 'name' : this.newRegistryCode };

        switch (this.selectedRegistry){
          case 'Accommodation type':
            this.$http.post("http://localhost:8084/addAccommodationType", null, {params: params} )
            .then(response => {
              if (response.body) {
                this.$http.get("http://localhost:8084/getAllAccommodationTypes")
                .then(list => {
                  this.listOfSelectedRegistries = list.body;
                  this.newRegistryCode = '';
                })
              } else {
                alert ("Error occurred! Can't enter same " + this.selectedRegistry);
              }
            })
            break;
          case 'Star rating':
            this.$http.post("http://localhost:8084/addStarRating", null, {params: params} )
            .then(response => {
              if (response.body) {
                this.$http.get("http://localhost:8084/getAllStarRatings")
                .then(list => {
                  this.listOfSelectedRegistries = list.body;
                  this.newRegistryCode = '';
                })
              } else {
                alert ("Error occurred! Can't enter same " + this.selectedRegistry);
              }
            })
            break;
          case 'Facility':
            this.$http.post("http://localhost:8084/addFacility", null, {params: params} )
            .then(response => {
              if (response.body) {
                this.$http.get("http://localhost:8084/getAllFacilities")
                .then(list => {
                  this.listOfSelectedRegistries = list.body;
                  this.newRegistryCode = '';
                })
              } else {
                alert ("Error occurred! Can't enter same " + this.selectedRegistry);
              }
            })
        }


      }
    },
    deleteRegistryCode(reg) {
      var body = reg;
      switch (this.selectedRegistry){
          case 'Accommodation type':
            this.$http.delete("http://localhost:8084/deleteAccommodationType", {body : body} )
            .then(response => {
              if (response.body) {
                this.$http.get("http://localhost:8084/getAllAccommodationTypes")
                .then(list => {
                  this.listOfSelectedRegistries = list.body;
                })
              } else {
                alert ("Error occurred!");
              }
            })
            break;
          case 'Star rating':
            this.$http.delete("http://localhost:8084/deleteStarRating", {body : body} )
            .then(response => {
              if (response.body) {
                this.$http.get("http://localhost:8084/getAllStarRatings")
                .then(list => {
                  this.listOfSelectedRegistries = list.body;
                })
              } else {
                alert ("Error occurred!");
              }
            })
            break;
          case 'Facility':
            this.$http.delete("http://localhost:8084/deleteFacility", {body : body})
            .then(response => {

              if (response.body) {
                this.$http.get("http://localhost:8084/getAllFacilities")
                .then(list => {
                  this.listOfSelectedRegistries = list.body;
                })
              } else {
                alert ("Error occurred!");
              }
            })
      }
    },
    editRegistryCode(reg){
      this.popupActivated = true;
      var params= {'id' : reg.id }

      switch (this.selectedRegistry){
          case 'Accommodation type':
            this.$http.get("http://localhost:8084/getAccommodationType", {params: params} )
            .then(response => {
              this.codeForEditing = response.body;
            })
            break;
          case 'Star rating':
            this.$http.get("http://localhost:8084/getStarRating", {params: params} )
            .then(response => {
              this.codeForEditing = response.body;

            })
            break;
          case 'Facility':
            this.$http.get("http://localhost:8084/getFacility", {params: params})
            .then(response => {
              this.codeForEditing = response.body;
            })
      }

    },
    submitEditRegistryCode(){
      if( !this.validateForm()){

      } else {


        var body = this.codeForEditing;
        switch (this.selectedRegistry){
            case 'Accommodation type':
              this.$http.put("http://localhost:8084/editAccommodationType", body )
              .then(response => {
                  this.$http.get("http://localhost:8084/getAllAccommodationTypes")
                  .then(list => {
                    this.listOfSelectedRegistries = list.body;

                  })
              },
              (err) => {
                alert('This ' + this.selectedRegistry + ' has already been edited or you entered ' + this.selectedRegistry + ' already exists ');
                this.$http.get("http://localhost:8084/getAllAccommodationTypes")
                .then(response => {
                  this.listOfSelectedRegistries = response.body;

                });
              })
              break;
            case 'Star rating':
              this.$http.put("http://localhost:8084/editStarRating", body )
              .then(response => {
                  this.$http.get("http://localhost:8084/getAllStarRatings")
                  .then(list => {
                    this.listOfSelectedRegistries = list.body;
                    this.popupActivated = false;
                  })
              },
              (err) => {
                alert('This ' + this.selectedRegistry + ' has already been edited or you entered ' + this.selectedRegistry + ' already exists ');
                this.$http.get("http://localhost:8084/getAllStarRatings")
                .then(response => {
                  this.listOfSelectedRegistries = response.body;

                });
              })
              break;
            case 'Facility':
              this.$http.put("http://localhost:8084/editFacility", body )
              .then(response => {
                  this.$http.get("http://localhost:8084/getAllFacilities")
                  .then(list => {
                    this.listOfSelectedRegistries = list.body;
                    this.popupActivated = false;
                  })
              },
              (err) => {
                alert('This ' + this.selectedRegistry + ' has already been edited or you entered ' + this.selectedRegistry + ' already exists ');
                this.$http.get("http://localhost:8084/getAllFacilities")
                .then(response => {
                  this.listOfSelectedRegistries = response.body;
                  this.popupActivated = false;
                });
              })
              break;
        }
     }
    },
    validateForm(){
      if(this.codeForEditing.name ==='' ){
        this.validForm = false;
        return false;
      } else {
        this.validForm = true;
        return true;
      }
    }

  },
  created() {
      this.$http.get("http://localhost:8084/getAllAccommodationTypes")
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
  @import '../../../assets/scss/mixins/forms/_forms.scss';
  @import '../../../assets/scss/mixins/pageParts/_pageParts.scss';
  @import '../../../assets/scss/mixins/tables/_defaultTable.scss';
  @import '../../../assets/scss/mixins/tooltips/_tooltip.scss';

  .welcome-message {
    @include welcomeMessage
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
    }}

  .selectedRegistryTable {
    h2 {
      text-align: left;
      padding: 1rem 2rem;
      color: $text-color;
      text-shadow: 1px 1px 1px black;
    }

    table {
      @include defaultTable;

      tr {
        .operations {
          span {
            @include tooltipContainer;
            i {
              @include linkTransition;

              &:hover,
              &:active {
                transform: scaleX(1.2) scaleY(1.2);
                @include linkTransition;
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

  .addNewCode {
      @include simpleForm;
    }




  .edit-popup {
    @extend .addNewCode;
    display: none;
    background: $popup-window-color;
    border: 3px solid $default-color;
    padding: 1rem;
    border-radius: 20px;
    width: 35%;
    position: fixed;
    z-index: 6;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    box-shadow: 2px 2px 2px 2px gray;

      h4 {
        color: $text-color;
        text-align: center;
        font-size: 1.3rem;
        padding: 0;

        &:hover,
        &:active {
          color: $text-color;
          cursor:default;
        }
      }

      div {


        input {
          width: 15rem;
        }
        button {
          &:after {
            display: none;
          }
        }
      }
  }

  .popupActive {
    display: block !important;

  }

  .backdrop {
      display: none;
      position:fixed;
      width: 100vw;
      height: 100vh;
      z-index: 5;
      background: transparentize($backdrop-color,0.7);
    }

.has-error {
      border:2px solid $form-error-color !important;
      background: lighten($form-error-color, 15%) !important;
    }



</style>
