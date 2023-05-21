<template>
  <main>
    <div class="postdetail-header">
      <span>Post</span>
      <i class="bx bx-arrow-back" id="back-btn" @click="moveList"></i>
      <span id="postdetail-header-logo">Post</span>
    </div>
    <div class="line"></div>
  </main>
</template>

<script>
import { mapState } from "vuex";
export default {
  computed: {
    ...mapState(["post"]),
  },
  created() {
    console.log(this.$router);
    this.$store.dispatch("getPost", this.$router.params.postId);
  },
  methods: {
    moveList(){
      this.$router.push({name : 'home'});
    }

  },
};
</script>

<style></style>
