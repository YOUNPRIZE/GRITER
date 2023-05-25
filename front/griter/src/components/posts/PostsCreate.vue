<template>
  <main>
    <div class="postcreate">
      <div class="postcreate-header">
        <i class="bx bx-arrow-back" id="back-btn" @click="moveList"></i>
        <span v-if="this.routerName === 'PostModify'" id="postcreate-header-logo"
          >Modify Post</span
        >
        <span v-else id="postcreate-header-logo">New Post</span>
      </div>
      <div class="line"></div>
      <div class="postcreate-content">
        <fieldset class="create-form">
          <div class="label">Title</div>
          <input
            v-if="this.routerName === 'PostModify'"
            type="text"
            id="title"
            v-model="post[0].title"
            class="form-control"
            required
            maxlength="50"
          />
          <input
            v-else
            type="text"
            id="title"
            v-model="title"
            class="form-control"
            placeholder="Enter title here"
            required
            maxlength="50"
          /><br />
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
            v-if="this.routerName === 'PostModify'"
            type="text"
            id="content"
            v-model="post[0].content"
            class="form-control"
            placeholder="Enter content here"
            required
          />
          <textarea
            v-else
            type="text"
            id="content"
            v-model="content"
            class="form-control"
            placeholder="Enter content here"
            required
          /><br />
          <div
            v-if="this.routerName === 'PostModify'"
            class="btn btn-primary"
            @click="update"
            id="post-btn"
          >
            UPDATE
          </div>
          <div v-else class="btn btn-primary" @click="create" id="post-btn">POST</div>
        </fieldset>
      </div>
    </div>
  </main>
</template>

<script>
import { mapActions, mapState } from "vuex";

export default {
  name: "createPost",
  data() {
    return {
      title: "",
      content: "",
      category: "",
      img: [],
      routerName: "",
    };
  },
  computed: {
    ...mapState("userModule", ["loginUser"]),
    ...mapState("postModule", ["post"]),
  },
  methods: {
    create() {
      const user_id = localStorage.getItem("loginUser");
      if (user_id.length > 0 && this.title.length > 0 && this.content.length > 0) {
        this.createPost({
          user_id: user_id,
          title: this.title,
          content: this.content,
          category: this.category,
        });
      } else {
        alert("필수항목을 모두 입력해주세요");
      }
    },
    moveList() {
      this.$router.push("/posts");
    },
    ...mapActions("userModule", ["getLoginUser"]),
    ...mapActions("postModule", ["createPost", "getPost", "updatePost"]),
    update() {
      const user_id = localStorage.getItem("loginUser");
      if (
        user_id.length > 0 &&
        this.post[0].title.length > 0 &&
        this.post[0].content.length > 0 &&
        this.post[0].category.length > 0
      ) {
        this.updatePost({
          post_id: this.post[0].post_id,
          user_id: user_id,
          title: this.post[0].title,
          content: this.post[0].content,
          category: this.post[0].category,
        });
      } else {
        alert("필수항목을 모두 입력해주세요");
      }
    },
  },
  created() {
    const user_id = localStorage.getItem("loginUser");
    this.getLoginUser(user_id);
    this.routerName = this.$router.currentRoute.name;
    if (this.routerName === "PostModify") {
      const post_id = this.$router.currentRoute.params.post_id;
      this.getPost(post_id);
    }
  },
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

.form-control:focus {
  background-color: var(--first-color);
}

#title {
  margin-bottom: 0;
}

#category {
  width: 10rem;
  margin: 1rem 0 1rem 0;
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

#post-btn {
  background-color: #2388f5;
  border: none;
  width: 10rem;
}

#post-btn:hover {
  background-color: #207ada;
}
</style>
