<template>
  <div>
    <transition name="modal">
      <div class="modal-mask" @click.self="$emit('close')">
        <div class="modal-wrapper" @click.self="$emit('close')">
            <div class="modal-container">
                <div class="modal_head">
                    <div class="child"> 
                    </div>
                    <div class="child">
                        <h3 class="mt-3">예매</h3>
                    </div>
                    <div class="modal_close child">
                        <span class="modal_close_button" style="color:skyblue"><i class="back fas fa-times-circle fa-2x" @click="$emit('close')" ></i></span>
                    </div>
                </div>
                <hr>
                <SeatModal v-if="isSeat" @on-select="onSelect" :movieNum="movieNum"/>
                <div class="container mt-4" v-if="isMovie">
                    <div class="ticketing_form">                    
                        <h5>상영관 : {{theater}}관</h5>
                        <h5>상영작 : {{name}}</h5>
                        <div class="ticketing_time">
                            <div class="mt-1 mr-3">상영시간 :</div>
                            <div class="ml-5">
                                <select v-model="time" class="form-select" aria-label="Default select example">
                                  <option value="" hidden>먼저 선택해 주세요.</option>
                                    <option v-for="(item, index) in info" :key="`hash-${index}`" :value="item.time">{{item.time}}</option>
                                </select>
                            </div>
                        </div>
                        <h5 class="mt-2">좌석 : <button class="seatInfo" v-if="time" @click="[getNum(), isSeat=true ,isMovie=false]">보기</button>{{show}}</h5>
                        <h5>가격 : {{sumPrice}}원</h5>
                        <h5 class="mb-0">핸드폰번호 : </h5>
                        <div class="wrapper2">
                            <div class="input-data">
                                <input v-model="phone_number" type="text" minlength="11" maxlength="11" required oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
                                <div class="underline">
                                </div>
                                <label>'-'를 제외한 핸드폰 번호를 입력하세요.</label>
                            </div>
                        </div>
                    </div>
                    <div class="ticketing_button">
                        <button id="confirm" @click="onTicketing">확인</button>
                        <button id="cancel" @click="$emit('close')">취소</button>
                    </div>
                </div>
                
            </div>
        </div>
      </div>
    </transition>
  </div>
</template>

<script>
import axios from 'axios'
import SeatModal from '@/components/SeatModal.vue'

export default {
  name: 'Movie',
  components: {
      SeatModal,
  },
  data() {
      return {
          isSeat: false,
          isMovie: true,
          seats: [],
          show: '',
          time: '',
          phone_number: '',
          info: [],
          theater: '',
          name: '',
          price: '',
          cnt: '',
          movieID: 0,
          sumPrice: 0,
          movieNum: 0,
      }
  },
  props: {
    num: Number,
  },
  methods: {
    onTicketing() {
      if (this.time == ''){
        alert("상영시간을 선택해 주세요!")
      }
      else if (this.show == '') {
        alert("좌석을 선택해 주세요!")
      }
      else if (this.phone_number == '') {
        alert("핸드폰 번호를 입력해 주세요!")
      }
      else if (this.phone_number.length != 11) {
        alert("핸드폰 번호 11자리를 입력해 주세요!")
      }
      else {
        if (this.theater == 1) {
          if (this.time == '09:00') {
            this.movieID = 1
          }
          else if (this.time == '15:00') {
            this.movieID = 2
          }
          else if (this.time == '21:00') {
            this.movieID = 3
          }
        }
        else if (this.theater == 2) {
          if (this.time == '08:30') {
            this.movieID = 4
          }
          else if (this.time == '13:30') {
            this.movieID = 5
          }
          else if (this.time == '18:30') {
            this.movieID = 6
          }
        }
        else if (this.theater == 3) {
          if (this.time == '10:00') {
            this.movieID = 7
          }
          else if (this.time == '14:00') {
            this.movieID = 8
          }
          else if (this.time == '18:00') {
            this.movieID = 9
          }
          else if (this.time == '20:00') {
            this.movieID = 10
          }
        }
        let test ={
          phoneNumber : this.phone_number,
          seat : this.show,
          movieID : this.movieID
        }
        
        axios.post("http://localhost:8080/ticketing/reserve", test)
        .then((data) => {
          console.log(data)
        })
        .catch((err) => {
          console.log(err)
        })
        alert("예매가 완료 되었습니다.")
        window.location.reload()
      }
    },
    onSelect(data) {
      this.seats = data
      this.isSeat = false,
      this.isMovie = true
      this.show = ''
      

      for(var step in this.seats) {
        this.show += this.seats[step]+', '
      }
      this.show = this.show.slice(0,-2)
      this.sumPrice = this.seats.length * this.price
    },
    getNum() {
      if (this.theater == 1) {
        if (this.time == '09:00') {
          this.movieNum = 1
        }
        else if (this.time == '15:00') {
          this.movieNum = 2
        }
        else if (this.time == '21:00') {
          this.movieNum = 3
        }
      }
      else if (this.theater == 2) {
        if (this.time == '08:30') {
          this.movieNum = 4
        }
        else if (this.time == '13:30') {
          this.movieNum = 5
        }
        else if (this.time == '18:30') {
          this.movieNum = 6
        }
      }
      else if (this.theater == 3) {
        if (this.time == '10:00') {
          this.movieNum = 7
        }
        else if (this.time == '14:00') {
          this.movieNum = 8
        }
        else if (this.time == '18:00') {
          this.movieNum = 9
        }
        else if (this.time == '20:00') {
          this.movieNum = 10
        }
      }
    }
  },
  mounted() {
    const url = 'http://localhost:8080/movie';
    axios.get(`${url}/${this.num}`)
      .then((data) => {
        this.info = data.data
        this.theater = this.info[0].theater
        this.name = this.info[0].name
        this.price = this.info[0].price
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

.form-select {
    width: 100%;
    display: inline;
}

.ticketing_time {
    font-size: 20px;
}

.ticketing_form {
    width: 456px;
    height: 320px;
    border: 2px solid skyblue;
    margin: 10px;
    padding: 10px;
}

.ticketing_button {
    text-align: center;
    margin-top: 20px;
}

#confirm:hover {
    color: white;
    background-color: skyblue;
}

#cancel:hover {
    color: white;
    background-color: skyblue;
}

#confirm {
    border: 1px solid skyblue;
    background-color: rgba(0, 0, 0, 0);
    color: skyblue;
    padding: 10px;
    padding-left: 20px;
    padding-right: 20px;
    margin-right: 10px;
}

#cancel {
    border: 1px solid skyblue;
    background-color: rgba(0, 0, 0, 0);
    color: skyblue;
    padding: 10px;
    padding-left: 20px;
    padding-right: 20px;
    margin-left: 10px;
}


.wrapper2{
  width: 430px;
  background: #fff;
}
.wrapper2 .input-data{
  height: 40px;
  width: 100%;
  position: relative;
}
.wrapper2 .input-data input{
  height: 100%;
  width: 100%;
  border: none;
  font-size: 17px;
  border-bottom: 2px solid silver;
  padding: 5px;
}
.input-data input:focus ~ label,
.input-data input:valid ~ label{
  transform: translateY(34px);
  font-size: 15px;                                                                      
  color: skyblue;
}
.wrapper2 .input-data label{
  position: absolute;
  bottom: 5px;
  left: 0;
  color: grey;
  pointer-events: none;
  transition: all 0.3s ease;
}
.input-data .underline{
  height: 2px;
  width: 100%;
  bottom: 0;
}

.seatInfo {
    color: skyblue;
    border: 2px solid skyblue;
    background-color: white;
    padding: 2px;
    width: 47px;
    height: 32px;
    font-size: 15px;
    position: relative;
    top: -2px;
    margin-right: 15px;
}

.seatInfo:hover {
  color: white;
  background-color: skyblue;
}
</style>