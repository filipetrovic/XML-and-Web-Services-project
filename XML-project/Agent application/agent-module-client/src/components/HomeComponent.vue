<template>
  <main>
    <ul class="actions">
      <li @click="$router.push('/addUnits')">
        <h2> Add units</h2>
        <p> Here you can add new accommodation units </p>
      </li>
      <li @click="$router.push('/occupyUnits')">
        <h2>Occupy  units</h2>
        <p> Here you can se accommodation units to be occupied </p>
      </li>
      <li @click="$router.push('/reservations')">
        <h2> Messages and confirm reservations</h2>
        <p>
          Here you can confirm that the user who reserved accommodation actually showed up,
          and you can also browse and answer user messages
        </p>
      </li>
    </ul>
  </main>

</template>

<script>

</script>

<style lang="scss" scoped>

  @import '../assets/scss/variables/vars.scss';
  .actions {
    display: flex;
    align-items: center;
    justify-content: center;
    flex-wrap: wrap;

    li {

      border-radius: 10px;
      background: $default-color;
      padding: 1rem;
      margin: 2rem;

      &:hover,
      &:active {
        background: darken($default-color, 20%)
      }
    }



  }
</style>

