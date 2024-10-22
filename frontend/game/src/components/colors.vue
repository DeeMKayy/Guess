<template>
    <div>
        <button v-for="color in colorsArr"
        :key="color.name"
        :style="{backgroundColor: color.name.toLowerCase()}"
        class="colorbtn"
        @click="validateGuess(color.name)">
        </button>
    </div>
</template>

<script>
import axios from 'axios';

export default ({
    name: 'colorChart',
    data() {
        return {
            colorsArr: []
        };
    },
    async created() {
        try {
            const response = await axios.get('http://localhost:8080/getColors');
            this.colorsArr = response.data;
        } catch (error) {
            console.error('Error fetching colors:', error);
        }
    },
    methods: {
        async validateGuess(selection) {
            try {
                const response = await axios.post('http://localhost:8080/guess', {
                    color: selection
                });

                alert(response.data);
            } catch (error) {
                console.error('Error verifying color: ', error);
            }
        }
    }
});
</script>

<style scoped>
.colorbtn {
    width: 50px;
    height: 50px;
    margin: 10px;
    cursor: pointer;
    border-radius: 50%;
    display: inline-block;
    transition: transform 0.2s;
}
 
.colorbtn:hover {
    transform: scale(1.1);
}
</style>