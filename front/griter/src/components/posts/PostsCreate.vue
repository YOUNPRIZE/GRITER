<template>
  <main>
    <div class="postcreate">
      <div class="postcreate-header">
        <i class="bx bx-arrow-back" id="back-btn" @click="moveList"></i>
        <span id="postcreate-header-logo">New Post</span>
      </div>
      <div class="line"></div>
      <div class="postcreate-content">
        <fieldset class="create-form">
          <div class="label">Title</div>
          <input type="text" id="title" v-model="title" class="form-control" placeholder="Enter title here" required /><br />
          <div class="label">Category</div>
          <select
            id="category"
            v-model="category"
            class="form-select"
            aria-label="Default select example"
          >
            <option selected hidden>Select</option>
            <option value="routine">Routine</option>
            <option value="diet">Diet</option>
            <option value="etc">Something Else</option>
          </select>
          <div class="label">Content</div>
          <textarea
            type="text"
            id="content"
            v-model="content"
            class="form-control"
            placeholder="Enter content here"
            required
          /><br />
          <button class="btn btn-primary" @click="createPost" id="post-btn">POST</button>
        </fieldset>
      </div>
    </div>
  </main>
</template>

<script>
import { mapActions, mapState } from 'vuex';

export default {
  name: "createPost",
  data() {
    return {
      title: "",
      content: "",
      // generated_date: "",
      // modified_date: "",
      // view_cnt: 0,
      // like_cnt: 0,
      category: "",
      img: [],
    };
  },
  computed:{
    ...mapState('userModule', ["loginUser"]),
  },
  methods: {
    createPost() {
      const user_id = localStorage("loginUser");
      console.log(user_id);
      const post = {
        user_id: user_id,
        title: this.title,
        content: this.content,
        category: this.category,
      }
      this.createPost(post);
    },
    moveList() {
      this.$router.push("/posts");
    },
    ...mapActions('userModule', ["getLoginUser"]),
    ...mapActions('postModule', ["createPost"]),
  },
  created(){
    const user_id = localStorage.getItem("loginUser");
    this.getLoginUser(user_id);
  }
};
</script>
<style scoped>
.postcreate {
  box-shadow: 0 0 1rem grey;
  border-radius: 0.1rem;
  box-shadow: 0 0 4px rgb(184, 184, 184);
  background-color: var(--box-bg-color);
  width: 100%;
  padding: 2rem;
  padding-top: 1rem;
  /* border: solid 1px #2388f5; */
}
.postcreate-header {
  display: flex;
  flex-direction: row;
  /* justify-content: space-between; */
  align-items: center;
  margin-top: 0.5rem;
  margin-bottom: 1rem;
}
#postcreate-header-logo {
  font-size: x-large;
  margin-left: 1rem;
}

#back-btn {
  font-size: x-large;
}
#back-btn:hover {
  cursor: pointer;
}

.postcreate-content {
  /* border: solid 1px orange; */
  height: stretch;
}

input {
  margin-top: 1rem;
  margin-bottom: 1rem;
  border: none;
  border-radius: 0.2rem;
  border-bottom: solid 1px rgb(200, 200, 200);
  background-color: var(--input-bg-color);
}
.label {
  display: flex;
  color: #2388f5;
}
.create-form {
  /* border: solid 1px red; */
  display: flex;
  flex-direction: column;
  width: 100%;
  height: 90%;
  margin-top: 1rem;
}
#title{
  margin-bottom: 0;
}
#category{
  width: 10rem;
  margin: 1rem 0 1rem 0 ;
  background-color: var(--input-bg-color);
}
#content {
  height: stretch;
  border: solid 1px rgb(194, 194, 194);
  border-radius: 0.2rem;
  resize: none;
  margin-top: 0.5rem;
  background-color: var(--input-bg-color);
}

#post-btn{
  background-color: #2388f5;
  border: none;
  width: 10rem;
}
#post-btn:hover{
  background-color: #207ada;
}
</style>
