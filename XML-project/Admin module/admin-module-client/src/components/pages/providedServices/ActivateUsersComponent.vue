<template>
  <main>
    {{listOfUsers}}
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

</style>
