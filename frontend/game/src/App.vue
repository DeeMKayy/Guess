<template>
<div>
  <h1>
    {{ title }}
  </h1>
  <GuessGame></GuessGame>
</div>
</template>

<script>
import GuessGame from './components/game.vue'

export default {
  name: 'App',
  components: {
    GuessGame
  },
  data() {
    return {
      title: 'Guess Game'
    }
  }
}
</script>

<style>
#app {
  font-family: 'Times New Roman', Times, serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
