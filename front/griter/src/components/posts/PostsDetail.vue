<template>
  <main>
    <div class="postdetail">
      <div class="postdetail-header">
        <div>
          <i class="bx bx-arrow-back" id="back-btn" @click="moveList"></i>
          <span id="postdetail-header-logo">Post</span>
        </div>
        <div
          v-if="post[0].user_id === loginUser.user_id"
          class="dashboard-content-post-btn"
        >
          <button @click="goEditPost(post[0].post_id)">
            <i class="bx bx-pencil"></i>
          </button>
          <button @click="showDeleteModal(post[0].post_id)">
            <i class="bx bx-trash"></i>
          </button>
        </div>
        <div v-else></div>
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
              v-if="
                JSON.stringify(post[0].generated_date) ===
                JSON.stringify(post[0].modified_date)
              "
              >{{ post[0].generated_date[0] }}.{{ post[0].generated_date[1] }}.{{
                post[0].generated_date[2]
              }}
              {{ post[0].generated_date[3] }}:{{ post[0].generated_date[4] }}</span
            >
            <span v-else
              >{{ post[0].modified_date[0] }}.{{ post[0].modified_date[1] }}.{{
                post[0].modified_date[2]
              }}
              {{ post[0].modified_date[3] }}:{{ post[0].modified_date[4] }}(수정됨)</span
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
        <fieldset class="input-group mb-3">
          <input
            type="text"
            class="form-control"
            placeholder="Enter comment here"
            aria-describedby="button-addon2"
            v-model="commentContent"
            name="content"
            id="content"
            required
            @keydown.enter="writeComment"
          />
          <button
            type="submit"
            class="btn btn-outline-primary"
            id="button-addon2"
            @click="writeComment"
          >
            Write
          </button>
        </fieldset>
      </div>
    </div>
    <!-- 모달 -->
    <div v-if="isDeleteModalOpen" class="modal">
      <div class="modal-content">
        <h3>삭제 확인</h3>
        <p>정말로 삭제하시겠습니까?</p>
        <div class="modal-content-buttons">
          <button v-on:click="deletePost" class="btn btn-danger">예</button>
          <button v-on:click="closeDeleteModal" class="btn btn-primary">취소</button>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
import router from "@/router";
import { mapActions, mapState } from "vuex";
export default {
  data() {
    return {
      isDeleteModalOpen: false,
      deletePostId: "",
      commentContent: "",
    };
  },
  computed: {
    ...mapState("postModule", ["post"]),
    ...mapState("commentModule", ["comments", "comment"]),
    ...mapState("userModule", ["loginUser"]),
  },
  methods: {
    ...mapActions("postModule", ["getPost", "delete"]),
    ...mapActions("commentModule", ["getComments", "getComment", "createComment"]),
    ...mapActions("userModule", ["getLoginUser"]),
    moveList() {
      this.$router.push({ name: "PostsList" });
    },
    writeComment() {
      // alert(this.content);
      // alert(this.loginUser.user_id);
      // alert(this.post[0].post_id);
      const newComment = {
        content: this.commentContent,
        parent_id: 0,
        user_id: this.loginUser.user_id,
        post_id: this.post[0].post_id,
      };
      this.getComment(newComment);
      console.log(this.comment);
      this.createComment(this.comment);
    },
    goEditPost(editPostId) {
      event.preventDefault()
      router.push({name: 'PostModify', params: {post_id: editPostId}});
    },
    showDeleteModal(deletePostId) {
      event.preventDefault()
      console.log(deletePostId);
      this.isDeleteModalOpen = true;
      this.deletePostId = deletePostId;
    },
    closeDeleteModal() {
      this.isDeleteModalOpen = false;
      this.deletePostId = "";
    },
    deletePost() {
      console.log(this.deletePostId);
      this.delete(this.deletePostId);
      this.closeDeleteModal();
      setTimeout(() => {
        router.go(0);
      }, "10")
    }
  },
  created() {
    // console.log(this.$route.params);
    const post_id = this.$route.params.post_id;
    // console.log(post_id);
    this.getPost(post_id);
    this.getComments(post_id);
    const userId = localStorage.getItem("loginUser");
    this.getLoginUser(userId);
  },
};
</script>

<style scoped>
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
  justify-content: space-between;
  align-items: center;
  margin-top: 0.5rem;
  margin-bottom: 1rem;
  color: var(--font-color-2);
  width: 100%;
  /* border: solid red; */
}

.detail-key {
  color: var(--font-color-3);
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

.postdetail-mainbox {
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
  color: var(--font-color-2);
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
  padding-bottom: 1.5rem;
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

#comment-writer {
  width: 15%;
}

#comment-content {
  width: 60%;
  display: flex;
  color: var(--font-color-2);
}

#comment-date {
  width: 25%;
  color: var(--font-color-2);
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

.form-control {
  background-color: var(--box-bg-color);
  color: var(--font-color-2);
}

.form-control::placeholder {
  color: var(--font-color-2);
}

.form-control:focus {
  background-color: var(--first-color);
}

#button-addon2 {
  border: solid 1px var(--font-color-3);
  color: var(--font-color-3);
}

#button-addon2:hover {
  background-color: var(--first-color);
}

.dashboard-content-post-btn > button {
  border: none ;
  background-color: transparent;
  font-size: x-large;
  color: var(--font-color-btn-1);
}
</style>
