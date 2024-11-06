<template>
    <div id="colorCont">
        <p><strong>What color is the butterfly?</strong></p> 
        <br>
        <button v-for="color in colorsArr"
        :key="color.name"
        :style="{ backgroundColor: color.name.toLowerCase() }"
        class="colorbtn"
        @click="validateGuess(color.name)">
        </button>
    </div>
</template>

<script>
import axios from 'axios';

export default ({
    name: 'ColorChart',
    data() {
        return {
            colorsArr: []
        };
    },
    async created() {
        try {
            const response = await axios.get('http://localhost:8080/api/getColors');
            this.colorsArr = response.data;
        } catch (error) {
            console.error('Error fetching colors:', error);
        }
    },
    methods: {
        async validateGuess(selection) {
            try {
                const response = await axios.post('http://localhost:8080/api/guess', { selection });
                alert(response.data);
            } catch (error) {
                console.error('Error verifying color: ', error);
            }
        }
    }
});
</script>

<style scoped>
p {
    font-size: xx-large;
    color: black;
}
#colorCont {
    background-color: grey;
    margin: 10%;
    padding: 2%;
    padding-bottom: 5%;
    display: block;
    justify-content: space-between;

}

.colorbtn {
    width: 100px;
    height: 100px;
    margin: 10px;
    cursor: pointer;
    border-width: 0px;
    border-radius: 50%;
    display: absolute;
    transition: transform 0.2s;
}
 
.colorbtn:hover {
    transform: scale(1.1);
}
</style>