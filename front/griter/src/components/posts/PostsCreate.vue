<template>
  <main>
    <fieldset class="text-center">
      <label for="title">제목</label>
      <input type="text" id="title" v-model="title" class="view" /><br />
      <label for="content">내용</label>
      <input type="text" id="content" v-model="content" class="view" /><br />
      <label for="category">카테고리</label>
      <input type="text" id="category" v-model="category" class="view" /><br />
      <button class="btn" @click="createPost">등록</button>
      <button @click="moveList">목록</button>
    </fieldset>
  </main>
</template>

<script>
export default {
  name: "createPost",
  data() {
    return {
      post_id: 0,
      user_id: "",
      title: "",
      content: "",
      generated_date: "",
      modified_date: "",
      view_cnt: 0,
      like_cnt: 0,
      category: "",
      img: [],
    };
  },
  methods: {
    createPost() {
      // 로컬 스토리지 말고 서버에 저장해야됨
      const postsList = localStorage.getItem("postsList");
      let newPosts = {
        posts: [],
      };
      if (postsList) {
        newPosts = JSON.parse(postsList);
      }

      newPosts.posts.push({
        post_id: 0,
        user_id: this.user_id,
        title: this.title,
        content: this.content,
        generated_date: this.generated_date,
        modified_date: this.modified_date,
        view_cnt: this.view_cnt,
        like_cnt: this.like_cnt,
        category: this.category,
        img: this.img,
      });

      localStorage.setItem("postsList", JSON.stringify(newPosts));
      alert("등록 완료");
      this.$router.push("/posts");
    },
    moveList() {
      this.$router.push("/posts");
    },
  },
};
</script>
<style></style>
