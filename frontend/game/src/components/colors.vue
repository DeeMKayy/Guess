<template>
    <div id="colorCont">
        <div>        
        <button v-if="!isGameStarted && !gameOver" @click="startGame" id="playBtn">{{ startText }}</button>
        <button v-else-if="gameOver" @click="startGame" id="playAgainBtn">{{ playAgainText }}</button>
        <div v-if="isGameStarted" id="gameChart">
            <img src="../assets/variant.png" alt="variant" id="variant">
            <p><strong>What color is the butterfly?</strong></p> 
            <br>    
            <button v-for="color in colorsArr"
            :key="color.name"
            :style="{ backgroundColor: color.name.toLowerCase() }"
            class="colorbtn"
            @click="validateGuess(color.name)">
            </button>
            <div id="resultMessage">{{ resultMessage }}</div>
        </div>
        </div>

    </div>
</template>

<script>
import axios from 'axios';

export default ({
    name: 'ColorChart',
    data() {
        return {
            colorsArr: [],
            isGameStarted: false,
            correctGuess: false,
            gameOver: false,
            resultMessage: '',
            startText: 'Play',
            playAgainText: 'You Got It! 👍\nPlay Again',
            answer: '',
        };
    },
    async created() {
        try {
            const response = await axios.get('http://localhost:8082/api/getColors');
            this.colorsArr = response.data;
        } catch (error) {
            console.error('Error fetching colors:', error);
        }
    },
    methods: {
        async startGame() {
        try {
            const response = await axios.get("http://localhost:8082/api/start");
            console.log(response.data);
            this.answer = response.data.name;
            this.isGameStarted = true;
            this.correctGuess = false;
            this.gameOver = false;
        } catch (error) {
            console.error('Error starting game: ', error.message);
        }
        },
        async validateGuess(selection) {
            try {
                const response = await axios.post('http://localhost:8082/api/guess', { guess: selection });
                //alert(response.data);
                this.resultMessage = response.data.message;

                const result = document.getElementById('resultMessage');

                const resultBoolean = response.data.boolean;
                console.log("resultboolean:", resultBoolean);

                this.isGameStarted = true;

                const gameChart = document.getElementById('gameChart');
                const variant = document.getElementById('variant');
                let animationPlayed = false;
                
                if (this.correctGuess === resultBoolean) {
                    result.style.display = "block";
                    gameChart.style.display = "block";
                } else if (!this.correctGuess === resultBoolean) {
                    this.isGameStarted = false;
                    this.gameOver = true;

                    variant.changeVariantColor(this.response.name);
                    if (animationPlayed) {
                        result.style.display = "block";
                        gameChart.style.display = "block";
                    } else {
                        this.resultMessage = " ";
                        result.style.display = "none";
                        gameChart.style.display = "none";
                    }
                }

            } catch (error) {
                console.error('Error verifying color: ', error);
            }
        },
        changeVariantColor(answer) {
            const variant = document.getElementById("variant");
            variant.style.filter = "none";
            switch (answer) {
                case 'pink':
                    variant.style.backgroundColor = 'pink';
                    break;
                case 'blue':
                    variant.style.backgroundColor = 'blue';
                    break;
                case 'green':
                    variant.style.backgroundColor = 'green';
                    break;
                case 'purple':
                    variant.style.backgroundColor = 'green';
                    break;
                case 'yellow':
                    variant.style.backgroundColor = 'green';
                    break;
                default:
                    variant.style.backgroundColor = 'gray'; // Default or fallback color
            }
        }
    },
});
</script>

<style scoped>
img {
  position: inherit;
  margin-left: 45%;
  width: 12%;
  height:  13%;
  display: block;
  filter: grayscale(100%);
  transition: filter 0.5s, background-color 0.5s;
/* animation: fly 3s infinite alternate, scale 8s linear infinite alternate;
    animation-delay: 4s;
    transform-origin: center center;*/
}
p {
    font-size: xx-large;
    text-shadow: 1px 1px 3px rgba(248, 246, 130, 0.884);
    background: linear-gradient(to right, rgb(241, 241, 228), #fdfdfd);
    background-clip: text;
    -webkit-background-clip: text;
    color: transparent;
}

#colorCont {
    /*background-color: grey;*/
    margin: 10%;
    padding: 2%;
    padding-bottom: 5%;
    display: block;
    justify-content: space-between;

}

#playBtn, .colorbtn {
    background-color: rgba(0, 0, 0, 0.712);
    color: rgb(252, 252, 150);;
    font-size: 30px;
    font-family: 'Times New Roman', Times, serif;
    font-style: italic;
    font-weight: bolder;
    width: 100px;
    height: 100px;
    margin: 10px;
    cursor: pointer;
    border-width: 0px;
    border-radius: 50%;
    display: absolute;
    transition: transform 0.2s;
}
 
#playAgainBtn {
    background-color: rgba(0, 0, 0, 0.712);
    color: rgb(252, 252, 150);;
    font-size: 18px;
    font-family: 'Times New Roman', Times, serif;
    font-style: italic;
    font-weight: bolder;
    width: 120px;
    height: 120px;
    margin: 20px;
    cursor: pointer;
    border-width: 0px;
    border-radius: 50%;
    display: absolute;
    padding: 2%;
    transition: transform 0.2s;
}

#playBtn:hover, #playAgainBtn:hover, .colorbtn:hover {
    background-color: rgb(252, 252, 150);
    color: rgba(0, 0, 0, 0.712);
    transform: scale(1.1);
}

.colorbtn:hover {
    transform: scale(1.1);
}

#resultMessage {
    margin: 10px;
    padding: 2%;
    color: rgb(252, 252, 150);
    text-shadow: 1px 1px 2px rgb(221, 221, 221);
    font-size: 40px;
    font-weight: bold;
}
#gameChart {
  backdrop-filter: blur (10px) brightness(0.5);
  background-color: rgba(0, 0, 0, 0.308);
  border-radius: 5%;
  margin-top: -15.8%;
  padding-top: 10%;
  /*width: 30%;
  left: 40%;
  margin-left: 35%;
  margin-top: 10%;*/
}
</style>