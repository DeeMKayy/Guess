<template>
  <div class="container">
    <ColorChart></ColorChart>
  </div>
</template>

<script>
import ColorChart from '../components/colors.vue';

export default {
  name: 'GuessGame',
  components: {
    ColorChart
  }
};
</script>

<style scoped>
img {
  position: absolute;
  left: 45%;
  width: 10%;
  height:  13%;
  display: block;
/* animation: fly 3s infinite alternate, scale 8s linear infinite alternate;
    animation-delay: 4s;
    transform-origin: center center;*/
}

</style>
