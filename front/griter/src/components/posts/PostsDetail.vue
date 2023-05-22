<template>
  <main>
    <div class="postdetail">
      <div class="postdetail-header">
        <i class="bx bx-arrow-back" id="back-btn" @click="moveList"></i>
        <span id="postdetail-header-logo">Post</span>
      </div>
      <div class="postdetail-mainbox">
        <div class="line"></div>
        <div class="postdetail-main">
          <div class="postdetail-main-aside">
            <span class="detail-key">Title</span>
            <span class="detail-key">Writer</span>
            <span class="detail-key">Category</span>
            <span class="detail-key">Content</span>
          </div>
          <div class="postdetail-main-value">
            <span>{{ post[0].title }}</span>
            <div class="postdetail-main-value-writer">
              <img src="" alt="" />
              <span>{{ post[0].nickname }}</span>
            </div>
            <span>{{ post[0].category }}</span>
          </div>
          <div class="postdetail-main-generateddate">
            <span
              >{{ post[0].generated_date[0] }}.{{ post[0].generated_date[1] }}.{{
                post[0].generated_date[2]
              }}
              {{ post[0].generated_date[3] }}:{{ post[0].generated_date[4] }}</span
            >
          </div>
        </div>
        <div class="postdetail-content">
          <div class="content-box">
            <span>{{ post[0].content }}</span>
          </div>
        </div>
        <div class="line" style="margin-top: 1rem"></div>
      </div>
      <div class="postdetail-comments">
        <span class="detail-key">Comments</span>
        <div class="postdetail-comments-content">
          <div
            v-for="(comment, index) in comments"
            :key="index"
            class="group-item"
            id="all-comments"
          >
            <div class="comment">
              <div id="comment-writer">{{ comment.nickname }}</div>
              <div id="comment-content">{{ comment.content }}</div>
              <div
                v-if="
                  JSON.stringify(comment.generated_date) ===
                  JSON.stringify(comment.modified_date)
                "
                id="comment-date"
              >
                {{ comment.generated_date }}
              </div>
              <div v-else id="comment-date">{{ comment.modified_date }}(수정됨)</div>
            </div>
          </div>
        </div>
      </div>
      <div class="entercomment">
        <form action="" class="input-group mb-3">
          <input
            type="text"
            class="form-control"
            placeholder="Enter comment here"
            aria-label="Recipient's username"
            aria-describedby="button-addon2"
          />
          <button type="submit" class="btn btn-outline-primary" id="button-addon2">
            Write
          </button>
        </form>
      </div>
    </div>
  </main>
</template>

<script>
import { mapActions, mapState } from "vuex";
export default {
  computed: {
    ...mapState("postModule", ["post"]),
    ...mapState("commentModule", ["comments"]),
    ...mapState("userModule", ["loginUser"]),
  },
  methods: {
    moveList() {
      this.$router.go(-1);
    },
    ...mapActions("postModule", ["getPost"]),
    ...mapActions("commentModule", ["getComments"]),
    ...mapActions("userModule", ["getLoginUser"]),
  },
  created() {
    console.log(this.$route.params);
    const post_id = this.$route.params.post_id;
    console.log(post_id);
    this.getPost(post_id);
    this.getComments(post_id);
    // this.getLoginUser(this.post.user_id);
  },
};
</script>

<style scoped>
* {
  /* border: solid; */
}
.line {
  margin: 0.5rem 0 1rem 0;
}

.postdetail {
  display: flex;
  flex-direction: column;
  align-items: center;
  box-shadow: 0 0 1rem grey;
  border-radius: 0.1rem;
  box-shadow: 0 0 4px rgb(184, 184, 184);
  background-color: var(--box-bg-color);
  width: 100%;
  padding: 2rem;
  padding-top: 1rem;
  overflow: auto;
  /* border: solid 1px red; */
}
.postdetail-header {
  display: flex;
  flex-direction: row;
  /* justify-content: flex-start; */
  align-items: center;
  margin-top: 0.5rem;
  margin-bottom: 1rem;
  color: var(--font-color-2);
  width: 100%;
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

.postdetail-mainbox{
  width: 100%;
}

.postdetail-main {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  color: var(--font-color-2);
  width: 100%;
}
.postdetail-main-aside {
  /* border: solid 1px green; */
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  color: var(--font-color-3);
}
.postdetail-main-aside > span {
  margin-bottom: 1rem;
}
.postdetail-main-value {
  /* border: solid 1px red; */
  display: flex;
  flex-direction: column;
  width: 70%;
  align-items: flex-start;
  margin-left: 2rem;
}
.postdetail-main-value > span {
  margin-bottom: 1rem;
}
.postdetail-main-value-writer {
  display: flex;
  flex-direction: row;
  margin-bottom: 1rem;
}
.postdetail-main-generateddate {
  display: flex;
  flex-direction: row-reverse;
  /* border: solid 1px yellow; */
  width: 30%;
  color: grey;
}
.postdetail-content {
  border: solid 1px grey;
  border-radius: 0.2rem;
  min-height: 10rem;
  text-align: left;
  width: 100%;
}
.content-box {
  display: flex;
  padding: 0.5rem;
  height: auto;
  /* border: solid 1px red; */
}
.postdetail-comments {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  height: calc(100% - 30rem);
  width: 100%;
}

.postdetail-comments-content {
  /* border: solid 1px grey; */
  display: flex;
  flex-direction: column;
  overflow: auto;
  width: 100%;
  height: 100%;
  overflow: auto;
}
.comment {
  /* border: solid 1px green; */
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  box-shadow: 0 0 0.3rem rgb(183, 183, 183);
  margin: 1rem 0.5rem 0rem 0.5rem;
  padding: 0.5rem;
}

.comment > div {
  /* border: solid 1px red; */
}
#comment-writer {
  width: 15%;
}
#comment-content {
  width: 60%;
  display: flex;
}
#comment-date {
  width: 25%;
}

.postdetail::-webkit-scrollbar,
.postdetail-comments-content::-webkit-scrollbar {
  width: 0.5rem;
}

.postdetail::-webkit-scrollbar-thumb,
.postdetail-comments-content::-webkit-scrollbar-thumb {
  background-color: rgb(190, 190, 190);
  border-radius: 10px;
  background-clip: padding-box;
  border: 2px solid transparent;
}

.entercomment {
  width: 90%;
  margin-top: 1rem;
}
</style>
