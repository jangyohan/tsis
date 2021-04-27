<template>
    <div class="container" style="overflow: auto; height:400px;">
        <div v-for="(reserve, index) in reserves" :key="`hash-${index}`" class="info">
            <h5 class="movie_info">상영 : {{reserve.Theater}}관 {{reserve.Name}} {{reserve.Time}}</h5>
            <h5 class="movie_info">가격 : {{reserve.Price * reserve.Seat.split(', ').length}}원</h5>
            <h5 class="movie_info">좌석 : {{reserve.Seat}}</h5>
        </div>
    </div>
</template>

<script>
export default {
    name: 'info',
    props: {
        reserves: Array,
    },
    data() {
        return {
            len: 0,
        }
    },
    mounted(){

    }

}
</script>

<style>
  .container::-webkit-scrollbar {
    width: 10px;
  }
  .container::-webkit-scrollbar-thumb {
    background-color: skyblue;
    border-radius: 10px;
    background-clip: padding-box;
    border: 2px solid transparent;
  }
  .container::-webkit-scrollbar-track {
    background-color: white;
    border-radius: 10px;
    box-shadow: inset 0px 0px 5px white;
  }

.info {
    border: 2px solid skyblue;
    border-radius: 10px;
    padding: 10px;
    margin: 10px;
    margin-top: 20px;
}

.movie_info {
    margin-bottom: 0px;
    margin-top: 0px;
}
</style>