<template>
 <main>
    <section class="welcome-message">
      <h1> Welcome to Comment approver </h1>
      <p> Here you can approve or delete user comments</p>
    </section>

    <section class="main-content">
      <h2>
        Comments
      </h2>

      <ul class="comments" >
        <li class="comment" v-for="(comment, index) in comments" :class="{left: index % 2 === 0 , right: index % 2 === 1 }">
          <i class="material-icons" > format_quote</i>

          <p>
            <i class="material-icons"> format_quote</i>
             {{comment.comment}}
            <i class="material-icons"> format_quote</i>

          </p>
          <label>
            <span> Some user</span>
            on
            <span> Some accommodation</span>
          </label>

          <div class="buttons">
            <a> <i class="material-icons" @click="approveComment(comment)"> check_circle_outline  </i> <span class="tooltiptext">Approve</span></a>
            <a><i class="material-icons" @click="deleteComment(comment)"> highlight_off  </i> <span class="tooltiptext">Delete</span></a>
          </div>
        </li>
      </ul>

    </section>
 </main>

</template>

<script>

export default {
  data() {
    return {
      comments: []
    }
  },
  methods: {
    approveComment(comment){
      var body = comment;
      console.log(JSON.stringify(body));
      this.$http.put("http://localhost:8084/approveComment", body)
      .then(response => {
        this.$http.get("http://localhost:8084/getUnapprovedComments")
        .then(list => {
                this.comments = list.body;
              })
        },
        (err) => {
          alert('This comments\'s status has  been edited meanwhile.');
          this.$http.get("http://localhost:8084/getUnapprovedComments")
          .then(response => {
            this.comments = response.body;

          });
        })
      },
      deleteComment(comment){
        var body = comment;
        this.$http.delete("http://localhost:8084/deleteComment", {body: body})
        .then(response => {
          this.$http.get("http://localhost:8084/getUnapprovedComments")
          .then(list => {
                  this.comments = list.body;
                })
          },
          (err) => {
            alert('This comments\'s status has  been edited meanwhile.');
            this.$http.get("http://localhost:8084/getUnapprovedComments")
            .then(response => {
              this.comments = response.body;

            });
        })
      }
  },
  created() {
    this.$http.get("http://localhost:8084/getUnapprovedComments")
      .then(response =>{
        this.comments = response.body;
      })
  }

}

</script>

<style lang="scss" scoped>

  @import '../../../assets/scss/variables/vars.scss';
  @import '../../../assets/scss/mixins/pageParts/_pageParts.scss';
  @import '../../../assets/scss/mixins/tooltips/tooltip.scss';
  main {
    min-width: 700px;
  }
  .welcome-message {
    @include welcomeMessage;
  }

  .main-content {
    margin-top: 3rem;
    text-align: left;
    padding-left: 2rem;
    color: $text-color;

    h2 {
      font-size: 1.8rem;
    }

    .comments {
      margin: 3rem 0;
      display:flex;
      flex-direction: column;

      .comment {
        padding: 0.5rem;
        width: 40%;
        border: 3px solid $default-color;
        border-radius: 20px;
        background: white;

        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        position:relative;

        i {
            font-size: 3rem;
            color: $default-color;
        }

        p {
          padding-bottom: 0.5rem;
          width: 300px;
          text-align: center;
          word-break: break-all;
          i {
            font-size: 1rem;
          }
        }

        label {
          font-size: 0.7rem;
          span {
            font-weight: bold;
          }
        }
      }

      .left{
        align-self: flex-start;

        .buttons {
          position: absolute;
          display:flex;
          flex-direction: column;
          left: 103%;
        }

        a {
            padding: 0.3rem 0;
            i {
              font-size: 2rem;
              cursor: pointer;
            }
          }

          a:first-of-type {
            @include tooltipContainer;

            i{
              color: darken($default-color, 10%);
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

          a:last-of-type {
           @include tooltipContainer;
            i {
              color: $text-color;
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

        &:after {
            border-top: 1rem solid $default-color;
            border-right: 1rem solid transparent;
            content: '';
            position: absolute;
            left: 4rem;
            top:  100%;;

          }
      }
      .right{
        align-self: flex-end;

        .buttons {
          position: absolute;
          display:flex;
          flex-direction: column;
          right: 103%;

          a {
            padding: 0.3rem 0;
            i {
              font-size: 2rem;
              cursor: pointer;
            }
          }

          a:first-of-type {
            @include tooltipContainer;

            i{
              color: darken($default-color, 10%);
              transition: transform 0.2s ease-out;

              &:hover,
              &:active {
                transform: scaleX(1.2) scaleY(1.2);
                transition: transform 0.2s ease-out ;
              }
            }

            span {
              @include tooltip;
              right:110%;
              bottom: 85%;

              &:before {
                border-top: 0.5rem solid $text-color;
                border-bottom: none;
                border-left: 0.5rem solid transparent;
                border-right: none;
                content: '';
                position: absolute;
                left: 70%;
                top:  90%;;
              }
            }
          }

          a:last-of-type {
            @include tooltipContainer;
           i{
              color: $text-color;
              transition: transform 0.2s ease-out;

              &:hover,
              &:active {
                transform: scaleX(1.2) scaleY(1.2);
                transition: transform 0.2s ease-out ;
              }
            }

            span {
              @include tooltip;
              right:110%;
              bottom: 85%;

              &:before {
                border-top: 0.5rem solid $text-color;
                border-bottom: none;
                border-left: 0.5rem solid transparent;
                border-right: none;
                content: '';
                position: absolute;
                left: 70%;
                top:  90%;;
              }
            }
          }
        }
         &:after {
          border-top: 1rem solid $default-color;
          border-left: 1rem solid transparent;
          content: '';
          position: absolute;
          right: 4rem;
          top: 100%;

        }
      }
    }


  }
</style>
