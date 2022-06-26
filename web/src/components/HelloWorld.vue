
<template>
  <div class="home">
    <h1>{{ bpi.id }}</h1>>
    <h1>{{ bpi.name }}</h1>>
  </div>
</template>

<script>

import axios from 'axios'

export default {
//API格納用のプロパティ
  data: function(){
    return{
      data:{
        bpi: "hello"
      }
    }
  },
  mounted: function(){
   axios.get('http://localhost:80/v1/matches/1/?condition=300')
       .then(response => this.bpi = response.data)
       .catch(err => console.log(err))
  }
}
</script>
