<template>
<div id="app">
  <div id="flyCont">
    <ButterflyAction></ButterflyAction>
  </div>
  <div id="txtBackdrop"> 
    <h1>
      {{ title }}
    </h1>
  </div>
  <GuessGame></GuessGame>
  </div>
</template>

<script>
import GuessGame from './components/game.vue'
import ButterflyAction from './components/ButterflyAction.vue';

export default {
  name: 'App',
  components: {
    GuessGame,
    ButterflyAction
  },
  data() {
    return {
      title: 'Guess Guess'
    }
  }
}
</script>

<style>
body {
  background-image: url('../src/assets/background.webp');
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  overflow: hidden;
  height: auto;
  width: 100%;
}

#app {
  font-family: 'Times New Roman', Times, serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  margin-top: 60px;
  overflow: hidden;
}

h1 {
  margin-top: 10%;
  padding: 5px;
  font-size: 70px;
  text-shadow: 1px 1px 3px rgba(248, 246, 130, 0.884);
  background: linear-gradient(to right, rgb(241, 241, 228), #fdfdfd);
  background-clip: text;
  -webkit-background-clip: text;
  color: transparent;
}

#txtBackdrop {
  backdrop-filter: blur (10px) brightness(0.5);
  background-color: rgba(0, 0, 0, 0.308);
  border-radius: 5%;
  width: 30%;
  top: 10%;
  left: 40%;
  margin-left: 35%;
  margin-top: 10%;
}
#flyCont{
  top: -10%;
}

@media (min-width: 320px) and (max-width: 425px) {
  .app {
    overflow: hidden;
  }
  
  h1 {
    position: relative;
    left: 50%;
    transform: translate(-50%);
}

#txtBackdrop {
  margin-left: 35%;
  margin-top: 10%;
}

}
</style>
