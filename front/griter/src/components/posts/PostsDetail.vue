<template>
  <main>
    <div class="postdetail">
      <div class="postdetail-header">
        <i class="bx bx-arrow-back" id="back-btn" @click="moveList"></i>
        <span id="postdetail-header-logo">Post</span>
      </div>
      <div class="line"></div>
      <div class="postdetail-main">
        <div class="postdetail-main-aside">
          <span class="detail-key">Title</span>
          <span class="detail-key">Writer</span>
          <span class="detail-key">Category</span>
          <span class="detail-key">Content</span>
        </div>
        <div class="postdetail-main-value">
          <span>{{ post.title }}</span>
          <div class="postdetail-main-value-writer">
            <img src="" alt="" />
            <!-- <span>{{ post.writer }}</span> -->
          </div>
          <span>{{ post.category }}</span>
        </div>
        <div class="postdetail-main-generateddate">
          <span>{{ post.generated_date }}</span>
        </div>
      </div>
      <div class="postdetail-content">
        <span>{{ post.content }}</span>
        <!-- <textarea>{{ content }}</textarea> -->
      </div>
      <div class="line" style="margin-top: 1rem;"></div>
      <div class="postdetail-comments">
        <span class="detail-key">Comments</span>
        <div class="postdetail-comments-content"></div>
      </div>
      <div class="entercomment">
        <form action="">
          <input type="text" />
          <button type="submit">Write</button>
        </form>
      </div>
    </div>
  </main>
</template>

<script>
import { mapActions, mapState } from "vuex";
export default {
  computed: {
    ...mapState('postModule', ["post"]),
  },
  created() {
    console.log(this.$route.params);
    const post_id = this.$route.params.post_id;
    console.log(post_id);
    this.getPost(post_id);
  },
  methods: {
    moveList() {
      this.$router.go(-1);
    },
    ...mapActions('postModule', ['getPost']),
  },
};
</script>

<style scoped>
* {
  /* border: solid; */
}
.line{
  margin: 0.5rem 0 1rem 0;
}

.postdetail {
  box-shadow: 0 0 1rem grey;
  border-radius: 0.1rem;
  box-shadow: 0 0 4px rgb(184, 184, 184);
  background-color: var(--box-bg-color);
  width: 100%;
  padding: 2rem;
  padding-top: 1rem;
}
.postdetail-header {
  display: flex;
  flex-direction: row;
  /* justify-content: flex-start; */
  align-items: center;
  margin-top: 0.5rem;
  margin-bottom: 1rem;
  color: var(--font-color-2);
}

#postdetail-header-logo {
  font-size: x-large;
  margin-left: 1rem;
}
#back-btn {
  font-size: x-large;
}
#back-btn:hover {
  cursor: pointer;
}

.postdetail-main {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  color: var(--font-color-2);
}
.postdetail-main-aside {
  /* border: solid 1px green; */
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  color: var(--font-color-3);
}
.postdetail-main-aside>span{
  margin-bottom: 1rem;
}
.postdetail-main-value {
  /* border: solid 1px red; */
  display: flex;
  flex-direction: column;
  width: 80%;
  align-items: flex-start;
}
.postdetail-main-value>span{
  margin-bottom: 1rem;
}
.postdetail-main-value-writer{
  display: flex;
  flex-direction: row;
  margin-bottom: 1rem;
}
.postdetail-main-generateddate{
  display: flex;
  flex-direction: row-reverse;
  /* border: solid 1px yellow; */
  width: 10%;
  color: grey
}
.postdetail-content {
  border: solid 1px grey;
  border-radius: 0.2rem;
  min-height: 10rem;
  text-align: left;
}

.postdetail-comments {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
}

.postdetail-comments-content{
  border: solid 1px grey;
  display: flex;
  flex-direction: column;
  overflow: auto;
}
</style>
