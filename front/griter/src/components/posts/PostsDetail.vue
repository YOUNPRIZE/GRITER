<template>
  <body>
    
  </body>
</template>

<script>
import {mapState} from 'vuex';
export default {
  computed:{
    ...mapState(["post"])
  },
  created(){
    console.log(this.$router);
    this.$store.dispatch("getPost", this.$router.params.postId)
  },
  methods:{

  }
}
</script>

<style>
  
</style>