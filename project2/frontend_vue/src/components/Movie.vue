<template>
  <div class="container">
    <h3>오늘의 영화!!</h3>
    <div class="row row-cols-1 row-cols-md-3 g-5">
      <div class="col">
        <div class="card h-100">
          <img src="@/assets/images/movie_img1.jpg" class="card-img-top" alt="">
          <div class="card-body">
            <h5 class="card-title">클레멘타인</h5>
            <div class="ticketing">
              <button @click="[checkNum(1), showModal=true]" type="button" class="btn btn-primary">예매</button>
            </div>
          </div>
        </div>
      </div>
      <div class="col">
        <div class="card h-100">
          <img src="@/assets/images/movie_img2.jpg" class="card-img-top" alt="">
          <div class="card-body">
            <h5 class="card-title">영웅</h5>
            <div class="ticketing">
              <button @click="[checkNum(2), showModal=true]" type="button" class="btn btn-primary">예매</button>
            </div>
          </div>
        </div>
      </div>
      <div class="col">
        <div class="card h-100">
          <img src="@/assets/images/movie_img3.jpg" class="card-img-top" alt="">
          <div class="card-body">
            <h5 class="card-title">성냥팔이소녀의재림</h5>
            <div class="ticketing">
              <button @click="[checkNum(3), showModal=true]" type="button" class="btn btn-primary">예매</button>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="ticketing_check">
      <div class="wrap">
          <a href="#" class="button" @click="checkModal=true">예매 확인</a>
      </div>
    </div>
    <MovieModal :num="num" v-if="showModal" @close="showModal=false"/>
    <CheckModal v-if="checkModal" @close="checkModal=false"/>
  </div>
</template>

<script>
import axios from "axios";
import MovieModal from "@/components/MovieModal.vue";
import CheckModal from "@/components/CheckModal.vue";

export default {
  name: 'Movie',
  data() {
    return {
      showModal: false,
      checkModal: false,
      movies: [],
      num: '',
    }
  },
  components: {
    MovieModal,
    CheckModal,
  },
  mounted() {
    axios.get("http://localhost:8080/movie")
      .then((data) => {
        // console.log(data)
        this.movies = data
      })
      .catch((err) => {
        console.log(err)
      })
  },
  methods: {
    checkNum(num) {
      this.num = num
    }
  }
}
</script>

<style scoped>
.container {
  margin: 10px auto;
  width: 1125px;
  height: 530px;
}

h3 {
  text-align: center;
  color: turquoise;
}

.card-title {
  text-align: center;
}

.ticketing {
  text-align: center;
}

.ticketing_check {
  text-align: center;
  margin-top: 20px;
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
}

a.button:hover {
	color: rgba(255, 255, 255, 0.85);
	box-shadow: rgba(30, 22, 54, 0.7) 0 0px 0px 40px inset;
}

</style>
