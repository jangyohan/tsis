<template>
    <div class="calculator">
        <div class="result">{{ result || "0"}}</div>
        <div class= "btn function" @click="clear">AC</div>
        <div class= "btn function" @click="changeSign">+/-</div>
        <div class= "btn function" @click="checkLength">DEL</div>
        <div class= "btn operator" @click="getNum('/')">/</div>
        <div class= "btn" @click="getNum(7)">7</div>
        <div class= "btn" @click="getNum(8)">8</div>
        <div class= "btn" @click="getNum(9)">9</div>
        <div class= "btn operator" @click="getNum('*')">X</div>
        <div class= "btn" @click="getNum(4)">4</div>
        <div class= "btn" @click="getNum(5)">5</div>
        <div class= "btn" @click="getNum(6)">6</div>
        <div class= "btn operator" @click="getNum('-')">-</div>
        <div class= "btn" @click="getNum(1)">1</div>
        <div class= "btn" @click="getNum(2)">2</div>
        <div class= "btn" @click="getNum(3)">3</div>
        <div class= "btn operator" @click="getNum('+')">+</div>
        <div class= "btn zero" @click="getNum(0)">0</div>
        <div class= "btn" @click="getNum('.')">.</div>
        <div class= "btn operator" @click="getResult">=</div>
    </div>
</template>

<script>
export default {
    name: "Calculator",
    data() {
        return {
            result: '',
        }
    },
    // mounted() {
    //     document.onkeypress = function(e) {
    //         console.log(e.key)
    //         this.getNum(e.key)
    //     }
    // },
    methods: {
        clear() {
           this.result = ''
        },
        changeSign() {
            this.result = -this.result
        },
        getNum(num) {
            this.result += num
        },
        checkLength() {
            if (this.result.length >= 2) {
                this.result = this.result.slice(0, -1)
            }
            else {
                this.result = '0'
            }
        },
        getResult() {
            this.result = eval(this.result)
        },

    }
}

</script>

<style>
.calculator {
    display: grid;
    grid-template-columns: repeat(4, 1fr);
    grid-auto-rows: minmax(px, auto);
    font-size: 40px;
    width: 400px;
    margin: 150px auto;  
}

.result {
    grid-column: 1 / 5;
    background-color: #333;
    color: white;
}

.zero {
    grid-column: 1 / 3;
}

.btn {
    background-color: rgb(141, 140, 140);
    border: 2px solid #333;
    color: rgb(219, 217, 217);
}

.operator {
    background-color: rgb(189, 98, 37);
}

.function {
    background-color: rgb(221, 213, 213);
    color: black;
}
</style>

