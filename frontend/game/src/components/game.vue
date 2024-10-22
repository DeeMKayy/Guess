<template>
  <div class="container">
    <div>
      <img src="/src/assets/variant.png" alt="variant">
    <colorChart></colorChart>
    </div>
  </div>
</template>

<script>

import colorChart from './colors.vue';

export default {
  name: 'GuessGame',
  components: {
    colorChart
  }
}
</script>

<style scoped>
img {
  position: absolute;
  width: 9%;
  height:  12%;
/* animation: fly 3s infinite alternate, scale 8s linear infinite alternate;
    animation-delay: 4s;
    transform-origin: center center;*/
}
</style>
