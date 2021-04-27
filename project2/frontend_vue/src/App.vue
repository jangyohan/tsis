<template>
  <div id="app">
    <Movie />
  </div>
</template>

<script>
import Movie from '@/components/Movie.vue'

export default {
  name: 'App',
  components: {
    Movie,
  }
}
</script>

<style>
* {
  margin: 0;
  padding: 0;
  font-family: 'GmarketSansBold';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansBold.woff') format('woff');
  font-weight: normal;
  font-style: normal;
}
@font-face {
  font-family: 'GmarketSansBold';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansBold.woff') format('woff');
  font-weight: normal;
  font-style: normal;
}
</style>
