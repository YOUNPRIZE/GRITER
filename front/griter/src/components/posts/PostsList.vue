<template>
  <body>
    <div class="dashboard-container">
      <div class="dashboard-container-header">
        <h5>DashBoard</h5>
        <form action="" class="search-form">
          <div class="input-group mb-3">
            <span class="input-group-text"><box-icon name="search"></box-icon></span>
            <input class="form-control" id="search" type="text" placeholder="Search" />
          </div>
        </form>
      </div>
      <hr style="margin-top: 0.5rem" />
      <div class="dashboard-container-content">
        <div class="dashboard-container-content-buttons">
          <!-- 여유되면 카테고리랑 부위 버튼 넣을 자리-->
          <div></div>
          <button class="btn btn-primary" id="newPost" @click="movePage">New Post</button>
        </div>
        <div class="dashboard-container-content-posts">
          <list-row v-for="(post, index) in posts" :key="index" />
        </div>
      </div>
    </div>
  </body>
</template>

<script>
// import http from "@/util/http-common";

export default {
  name: "PostsList",
  data() {
    return {
      posts: [],
    };
  },
  components: {},
  methods:{
    movePage(){
      this.$router.push('createPost');
    }
  }
};
</script>

<style scoped>
* {
  /* border: solid green; */
}

.dashboard-container {
  display: flex;
  flex-direction: column;
  box-shadow: 0 0 5px rgb(190, 190, 190);
  background-color: white;
  padding: 1.5rem;
  width: 90vw;
  height: 84vh;
}

.dashboard-container-header {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
}

hr {
  margin: 1rem;
  margin-left: 0;
  margin-right: 0;
}

#newPost {
  background-color: #2388f5;
  padding-left: 2rem;
  padding-right: 2rem;
}

.search-form {
  /* border: solid red; */
  display: flex;
  flex-direction: column;
  height: 3rem;
}

.dashboard-container-content-buttons {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}
</style>
