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
                        <h3 class="mt-3">예매 확인</h3>
                    </div>
                    <div class="modal_close child">
                        <span class="modal_close_button" style="color:skyblue"><i class="back fas fa-times-circle fa-2x" @click="$emit('close')" ></i></span>
                    </div>
                </div>
                <hr>
                <Info :reserves="reserves" v-if="isInfo"/>
                <div v-if="isCheckModal" class="modal_content">
                    <div class="wrapper">
                        <div class="input-data">
                            <input v-model="phone" type="text" minlength="11" maxlength="11" required oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
                            <div class="underline">
                            </div>
                            <label>'-'를 제외한 핸드폰 번호를 입력하세요.</label>
                        </div>
                    </div>
                    <div class="wrap" @click="isInfo=true">
                        <a href="#" class="button" @click="[getInfo(), isCheckModal=false]">확인</a>
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
import Info from '@/components/Info.vue'

export default {
    name: 'CheckModal',
    components: {
        Info,
    },
    data() {
        return {
            isInfo: false,
            isCheckModal: true,
            phone: '',
            reserves: [],
            // cnt: 0,
        }
    },
    methods: {
      getInfo() {
        if(this.phone.length != 11) {
          alert('핸드폰 번호 11자리를 입력해 주세요!')
        }
        else {
          axios.get(`http://localhost:8080/ticketing/check/${this.phone}`)
            .then((data) => {
              this.reserves = data.data
            })
            .catch((err) => {
              console.log(err)
            })
        }

      }
    }
}
</script>

<style>
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

.modal-wrapper {
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
    text-align: right !important;
}

.back {
    margin-top: 13px;
    margin-right: 15px;
    cursor: pointer;
}

hr {
    margin-top: 2px;
}

.modal_head {
    display: flex;
    justify-content: space-between;
}

.child {
    flex: 1;
    text-align: center;
}

h3 {
    color:skyblue;
}

a {
	-webkit-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-moz-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-ms-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	-o-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
	display: block;
	margin: 20px auto;
	max-width: 180px;
	text-decoration: none;
	border-radius: 4px;
	padding: 20px 30px;
}

a.button {
	color: rgba(30, 22, 54, 0.6);
	box-shadow: rgba(30, 22, 54, 0.4) 0 0px 0px 2px inset;
    text-align: center;
}

a.button:hover {
	color: rgba(255, 255, 255, 0.85);
	box-shadow: rgba(30, 22, 54, 0.7) 0 0px 0px 40px inset;
}

.wrapper{
  width: 450px;
  background: #fff;
  padding: 30px;
  border: 2px solid skyblue;
  margin-left: 25px;
  margin-top: 100px;
}
.wrapper .input-data{
  height: 40px;
  width: 100%;
  position: relative;
}
.wrapper .input-data input{
  height: 100%;
  width: 100%;
  border: none;
  font-size: 17px;
  border-bottom: 2px solid silver;
  padding: 5px;
}
.input-data input:focus ~ label,
.input-data input:valid ~ label{
  transform: translateY(-38.5px);
  font-size: 15px;                                                                      
  color: skyblue;
}
.wrapper .input-data label{
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

</style>