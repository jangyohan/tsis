<template>
    <div>
        <div class="f">
            <div class="screen invisible"></div>
            <div class="screen text">screen</div>
            <div class="screen btn ml-5">
                <button class="check_btn" @click="onSelect">선택</button>
            </div>
        </div>
        <div class="seat-wrapper mt-3"></div> 
    </div>
</template>

<script>
import axios from 'axios'

export default {
    name: 'SeatModal',
    data() {
        return {
            seatsList: [],
        }
    },
    props: {
        movieNum: Number,
    },
    methods: {
        onSelect() {
            let test = () => {
                this.$emit('on-select', this.seatsList)
            }
            test()
        }
    },
    mounted : function() {
        let $vm = this
        let selectedSeats = new Array();
        const seatWrapper = document.querySelector(".seat-wrapper");
        let clicked = "";
        let div = "";
        
        for (let i = 1; i < 13; i++) {
            div = document.createElement("div");
            div.classList = "seat_line"
            const input_index = document.createElement('input');
            seatWrapper.append(div);
            
            if (i == 1) {
                input_index.value = "A";
            }
            else if (i == 2) {
                input_index.value = "B";
            }
            else if (i == 3) {
                input_index.value = "C";
            }
            else if (i == 4) {
                input_index.value = "D";
            }
            else if (i == 5) {
                input_index.value = "E";
            }
            else if (i == 6) {
                input_index.value = "F";
            }
            else if (i == 7) {
                input_index.value = "G";
            }
            else if (i == 8) {
                input_index.value = "H";
            }
            else if (i == 9) {
                input_index.value = "I";
            }
            else if (i == 10) {
                input_index.value = "J";
            }
            else if (i == 11) {
                input_index.value = "K";
            }
            else if (i == 12) {
                input_index.value = "L";
            }
            
            input_index.type = "button";
            input_index.classList = "seat_index";
            div.append(input_index);
            input_index.style = "font-size: 13px;border: 1px solid gray;background-color: white;color: black;width: 20px;height: 25px;margin-bottom: 3px; margin-right: 10px;"
            for (let j = 1; j < 14; j++) {
                const input = document.createElement('input');
                input.type = "button";
                if (j <= 9) {
                    input.name = `${input_index.value}0${j}`
                }
                else {
                    input.name = `${input_index.value}${j}`
                }
                input.classList = "seat";
                input.style = "border-radius: 5px;border: 1px solid gray;background-color: rgb(100 94 94 / 50%);font-size: 10px;color: white;width: 28px;height: 25px;margin-bottom: 3px; margin-right: 3px;"
                mapping(input, i, j);      
                div.append(input);
                input.addEventListener('click', function(e) {
                    input.style = "border-radius: 5px;border: 1px solid gray;background-color: orange;font-size: 10px;color: white;width: 28px;height: 25px;margin-bottom: 3px; margin-right: 3px;"
                    selectedSeats = selectedSeats.filter((element, index) => selectedSeats.indexOf(element) != index);

                    if (input.classList.contains("clicked")) {
                        input.classList.remove("clicked");
                        input.style = "border-radius: 5px;border: 1px solid gray;background-color: rgb(100 94 94 / 50%);font-size: 10px;color: white;width: 28px;height: 25px;margin-bottom: 3px; margin-right: 3px;"
                        clicked = document.querySelectorAll(".clicked");
                        selectedSeats.splice(selectedSeats.indexOf(e.target.value), 1);
                        clicked.forEach((data) => {
                            selectedSeats.push(data.value);
                        });

                    } else {
                        input.classList.add("clicked");
                        clicked = document.querySelectorAll(".clicked");
                        clicked.forEach((data) => {
                            selectedSeats.push(input_index.value + data.value);
                        })
                    }
                    
                    $vm.seatsList = selectedSeats           
                })
            }
        }

        function mapping(input, i, j) {
            if (i === 1) {
                if (j <= '9') {
                    input.value = "0" + j;
                } else {
                input.value = j; }
            } else if (i === 2) {
                if (j <= '9') {
                    input.value = "0" + j;
                } else {
                input.value = j; }
            } else if (i === 3) {
                if (j <= '9') {
                    input.value = "0" + j;
                } else {
                input.value = j; }
            } else if (i === 4) {
                if (j <= '9') {
                    input.value = "0" + j;
                } else {
                input.value = j; }
            } else if (i === 5) {
                if (j <= '9') {
                    input.value = "0" + j;
                } else {
                input.value = j; }
            } else if (i === 6) {
                if (j <= '9') {
                    input.value = "0" + j;
                } else {
                input.value = j; }      
            } else if (i === 7) {
                if (j <= '9') {
                    input.value = "0" + j;
                } else {
                input.value = j; }
            }else if (i === 8) {
                if (j <= '9') {
                    input.value = "0" + j;
                } else {
                input.value = j; }
            } else if (i === 9) {
                if (j <= '9') {
                    input.value = "0" + j;
                } else {
                input.value = j; }
            } else if (i === 10) {
                if (j <= '9') {
                    input.value = "0" + j;
                } else {
                input.value = j; }
            } else if (i === 11) {
                if (j <= '9') {
                    input.value = "0" + j;
                } else {
                input.value = j; }
            } else if (i === 12) {
                if (j <= '9') {
                    input.value = "0" + j;
                } else {
                input.value = j; } 
        }
        }
        
        axios.get(`http://localhost:8080/ticketing/get/${this.movieNum}`)
            .then((data) => {
                for(let j=0; j<data.data.length;j++) {
                    var seats = data.data[j].split(', ')
                    for(let i=0; i<seats.length;i++) {
                        var x = document.querySelector(`div.seat_line > input.seat[name=${seats[i]}]`)
                        x.value = 'X';
                        x.style = "border-radius: 5px;border: 1px solid gray;background-color: black;font-size: 10px;color: white;width: 28px;height: 25px;margin-bottom: 3px; margin-right: 3px;" 
                        x.disabled = true
                    }
                }
            })
            .catch((err) => {
                console.log(err)
            })
    }
}

</script>

<style scoped>
.modal-enter-active, .modal-leave-active {
  transition: opacity 0.4s;

}

.modal-leave-active {
  transition: opacity 0.6s ease 0.4s;
}

.modal-enter, .modal-leave-to {
  opacity: 0;

}

.modal-mask {
  position: fixed;
  z-index: 9998;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, .5);
  display: table;
  transition: opacity .3s ease;
}

.modal-wrapper2 {
  display: table-cell;
  vertical-align: middle;
}
.modal-container {
  position: relative;
  width: 90VW;
  height: 488px;
  margin: 0px auto;
  
  background-color: #fff;
  border-radius: 10px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, .33);
  transition: all .3s ease;
  font-family: Helvetica, Arial, sans-serif;
}
@media (min-width: 500px) {
  .modal-container {
    width: 500px;
  }
}   

.modal-back-btn .fas {
  font-size: 100% !important;
  padding-left: 5%;
  color: skyblue;
  margin-top: 3px;
}

.modal_close {
    text-align: right;
}

.back {
    margin-top: 13px;
    margin-right: 15px;
}

.seat-wrapper {
    width: 100%;
    text-align: center;
}

.seat {
    width: 1150px;
    height: 50px;
}

.clicked {
    background-color: red;
    color: white;
}

.screen {
    text-align: center;
    border: 2px solid gray;
    width: 80px;
    height: 40px;
    padding: 5px;
    margin: 0 auto;
    flex: 1;
}

.f {
    display: flex;
}

.screen.btn {
    border: 0px !important;
    padding: 0px;
}

.check_btn {
    margin-left: 40px;
    margin-top: 2px;
    padding: 5px;
    color: skyblue;
    background-color: white;
    border: 1px solid skyblue;
}

.check_btn:hover {
  color: white;
  background-color: skyblue;
}
</style>
