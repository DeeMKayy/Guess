<template>
  <div id="butterflyContainer" colorButterfly>
    <img src="../assets/butterfly.png" class="blue">
    <img src="../assets/butterfly2.png" class="blue">
    <img src="../assets/butterfly1.png" class="pink">
    <img src="../assets/butterfly3.png" class="purple">
    <img src="../assets/butterfly4.png" class="yellow">
    <img src="../assets/butterfly5.png" class="green">
    <img src="../assets/Obutterfly.png" class="pink">
    <img src="../assets/Obutterfly1.png" class="purple">
    <img src="../assets/Obutterfly2.png" class="yellow">
    <img src="../assets/Obutterfly3.png" class="green">
  </div>
</template>

<script>
export default {
    mounted() {
        this.colorButterfly();
    },
    methods: {
        colorButterfly() {
            const pinks = document.querySelectorAll('.pink');
            const blues = document.querySelectorAll('.blue');
            const yellows = document.querySelectorAll('.yellow');
            const purples = document.querySelectorAll('.purple');
            const greens = document.querySelectorAll('.green');

            pinks.forEach(pink => pink.style.filter = 'sepia(1) hue-rotate(300deg) saturate(200%) contrast(150%)');
            blues.forEach(blue => blue.style.filter = 'sepia(1) hue-rotate(180deg) saturate(200%) contrast(150%)');
            yellows.forEach(yellow => yellow.style.filter = 'sepia(1) hue-rotate(10deg) saturate(200%) contrast(150%)');
            purples.forEach(purple => purple.style.filter = 'sepia(1) hue-rotate(240deg) saturate(200%) contrast(150%)');
            greens.forEach(green => green.style.filter = 'sepia(1) hue-rotate(90deg) saturate(200%) contrast(150%'); 
        }
    }
}
</script>

<style scoped>
    #butterflyContainer {
        position: absolute;
        top: -12%;
        left: 25%;
        display: flex;
        align-items: center;
        justify-content: space-between;
    }
    img {
        filter: grayscale(100%);
        transition: filter 0.5s, background-color 0.5s;
        animation: flutter 0.7s infinite alternate, move 10s linear infinite alternate;
        width: 10%;
        height: 10%;
    }
    @keyframes flutter {
        0% {
            transform: translateY(0) rotate(0deg);
            opacity: 0.5;
            left: 0;
            top: 50%;
        }
        50% {
            transform: translateY(-10px) rotate(5deg);
        }
        100% {
            transform: translateY(0) rotate(-5deg);
            left: 100%;
            top: 0;
        }
    }
    @keyframes move {
        0%, 100% {
            transform: translate(0, 0) scale(1.2);
        }
        25% {
            transform: translate(-30vw, 30vh) scale(1);
        }
        50% {
            transform: translate(50vw, 50vh) scale(0.8);
        }
        75% {
            transform: translate(-20vw, 80vh) scale(1.2);
        }
    }
    #butterflyContainer img:nth-child(1) {
        animation-delay: 0s;
        width: 60px;
    }

    #butterflyContainer img:nth-child(2) {
        animation-delay: 2s;
        width: 70px;
    }

    #butterflyContainer img:nth-child(3) {
        animation-delay: 4s;
        width: 90px;
    }

    #butterflyContainer img:nth-child(4) {
        animation-delay: 5s;
        width: 80px;
    }

    #butterflyContainer img:nth-child(5) {
        animation-delay: 3s;
        width: 60px;
    }
    #butterflyContainer img:nth-child(6) {
        animation-delay: 1s;
        width: 70px;
    }

    #butterflyContainer img:nth-child(7) {
        animation-delay: 6s;
        width: 80px;
    }

    #butterflyContainer img:nth-child(8) {
        animation-delay: 7s;
        width: 90px;
    }

    #butterflyContainer img:nth-child(9) {
        animation-delay: 8s;
        width: 90px;
    }
    
    #butterflyContainer img:nth-child(10) {
        animation-delay: 9s;
        width: 60px;
    }

</style>