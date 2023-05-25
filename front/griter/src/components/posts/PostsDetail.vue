<template>
  <main>
    <div class="postdetail">
      <div class="postdetail-header">
        <div class="postdetail-header-content">
          <div>
            <i class="bx bx-arrow-back" id="back-btn" @click="moveList"></i>
            <span id="postdetail-header-logo">Post</span>
          </div>
          <div>
            <div v-if="post[0].user_id === loginUser.user_id" class="dashboard-content-post-btn">
              <!--true일 때는 좋아요 상태이므로 버튼을 누르면 좋아요 해제-->
              <button v-if="isLiked" @click="unliked()">
                <i class="bx bxs-star"></i>
              </button>
              <!--false일 때는 좋아요가 아닌 상태이므로 버튼 누르면 좋아요-->
              <button v-else @click="liked()">
                <i class="bx bx-star"></i>
              </button>
              <button @click="goEditPost(post[0].post_id)">
                <i class="bx bx-pencil"></i>
              </button>
              <button @click="showPostDeleteModal(post[0].post_id)">
                <i class="bx bx-trash"></i>
              </button>
            </div>
            <div v-else class="dashboard-content-post-btn">
              <!--true일 때는 좋아요 상태이므로 버튼을 누르면 좋아요 해제-->
              <button v-if="isLiked == true" @click="unliked()">
                <i class="bx bxs-star"></i>
              </button>
              <!--false일 때는 좋아요가 아닌 상태이므로 버튼 누르면 좋아요-->
              <button v-else @click="liked()">
                <i class="bx bx-star"></i>
              </button>
            </div>
          </div>
        </div>
        <div class="line"></div>
      </div>
      <div class="postdetail-except-header">
        <div class="postdetail-mainbox">
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
                <img src alt />
                <span>{{ post[0].nickname }}</span>
              </div>
              <span>{{ post[0].category }}</span>
            </div>
            <div class="postdetail-main-generateddate">
              <span v-if="
                JSON.stringify(post[0].generated_date) ===
                JSON.stringify(post[0].modified_date)
              ">
                {{ post[0].generated_date[0] }}.{{ post[0].generated_date[1] }}.{{
                  post[0].generated_date[2]
                }}
                {{ post[0].generated_date[3] }}:{{ post[0].generated_date[4] }}
              </span>
              <span v-else>
                {{ post[0].modified_date[0] }}.{{ post[0].modified_date[1] }}.{{
                  post[0].modified_date[2]
                }}
                {{ post[0].modified_date[3] }}:{{ post[0].modified_date[4] }}(수정됨)
              </span>
              <div>
                <i class="bx bx-show"></i>
                <span>{{ post[0].view_cnt }}</span>
              </div>
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
            <div v-for="(comment, index) in comments" :key="index" class="group-item" id="all-comments">
              <div class="comment">
                <div id="comment-writer">{{ comment.nickname }}</div>
                <div v-if="editingCommentId !== comment.comment_id" id="comment-content">
                  <div :class="'comment-' + comment.comment_id">{{ comment.content }}</div>
                  <div v-if="comment.user_id === loginUser.user_id" id="comment-buttons">
                    <button @click="openCommentEdit(comment.comment_id, $event)">
                      <i class="bx bx-pencil"></i>
                    </button>
                    <button @click="showCommentDeleteModal(comment.comment_id)">
                      <i class="bx bx-trash"></i>
                    </button>
                  </div>
                  <!-- <div v-else>asdfasdf</div> -->
                </div>
                <div v-else-if="editingCommentId === comment.comment_id" id="comment-content">
                  <fieldset>
                    <div class="comment-content-editing">
                      <input type="text" class="form-control" id="comment-content-editing" :value="comment.content"
                        @keydown.enter="updateComment" />
                      <input type="hidden" id="comment-comment_id-editing" :value="comment.comment_id" />
                      <!-- <input type="hidden" id="comment-user_id-editing" :value="comment.user_id">
                      <input type="hidden" id="comment-post_id-editing" :value="comment.post_id">-->
                      <div class="comment-edit-buttons">
                        <button @click="updateComment">
                          <i class="bx bx-check"></i>
                        </button>
                        <button @click="closeCommentEdit">
                          <i class="bx bx-x"></i>
                        </button>
                      </div>
                    </div>
                  </fieldset>
                </div>
                <div id="comment-date">
                  <span v-if="
                    JSON.stringify(comment.generated_date) ===
                    JSON.stringify(comment.modified_date)
                  ">
                    {{ comment.generated_date[0] }}.{{ comment.generated_date[1] }}.{{
                      post[0].generated_date[2]
                    }}
                    {{ comment.generated_date[3] }}:{{ comment.generated_date[4] }}
                  </span>
                  <span v-else>
                    {{ comment.modified_date[0] }}.{{ comment.modified_date[1] }}.{{
                      comment.modified_date[2]
                    }}
                    {{ comment.modified_date[3] }}:{{ comment.modified_date[4] }}(수정됨)
                  </span>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="entercomment">
        <div class="line"></div>
        <fieldset class="input-group mb-3">
          <input type="text" class="form-control" placeholder="Enter comment here" aria-describedby="button-addon2"
            v-model="commentContent" name="content" id="content" required @keydown.enter="writeComment" />
          <button type="submit" class="btn btn-outline-primary" id="button-addon2" @click="writeComment">Write</button>
        </fieldset>
      </div>
    </div>
    <!-- 모달 -->
    <div v-if="isPostDeleteModalOpen" class="modal">
      <div class="modal-content">
        <h3>삭제 확인</h3>
        <p>정말로 삭제하시겠습니까?</p>
        <div class="modal-content-buttons">
          <button v-on:click="deletePost" class="btn btn-danger">예</button>
          <button v-on:click="closeDeleteModal" class="btn btn-primary">취소</button>
        </div>
      </div>
    </div>
    <!-- 모달 -->
    <div v-if="isCommentDeleteModalOpen" class="modal">
      <div class="modal-content">
        <h3>삭제 확인</h3>
        <p>정말로 삭제하시겠습니까?</p>
        <div class="modal-content-buttons">
          <button v-on:click="deleteComment" class="btn btn-danger">예</button>
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
      isPostDeleteModalOpen: false,
      isCommentDeleteModalOpen: false,
      deletePostId: "",
      deleteCommentId: "",
      editingCommentId: "",
      commentContent: "",
      isLiked: false
    };
  },
  computed: {
    ...mapState("postModule", ["post", "postLiked"]),
    ...mapState("commentModule", ["comments", "comment"]),
    ...mapState("userModule", ["loginUser"])
  },
  methods: {
    ...mapActions("postModule", ["getPost", "delete", "addViewCnt", "deletePostLike", "createPostLike", "getPostLikeByUser"]),
    ...mapActions("commentModule", ["getComments", "getComment", "createComment", "commentDelete", "update"]),
    ...mapActions("userModule", ["getLoginUser"]),
    moveList() {
      this.$router.push({ name: "PostsList" });
    },
    liked() {
      const param = {
        user_id: this.loginUser.user_id,
        post_id: this.post[0].post_id
      };
      this.createPostLike(param)
      this.updateData();
    },
    unliked() {
      const param = {
        user_id: this.loginUser.user_id,
        post_id: this.post[0].post_id
      };
      this.deletePostLike(param);
      this.updateData();
    },
    writeComment() {
      const newComment = {
        content: this.commentContent,
        parent_id: 0,
        user_id: this.loginUser.user_id,
        post_id: this.post[0].post_id
      };
      this.getComment(newComment);
      console.log(this.comment);
      this.createComment(this.comment);
      this.updateData();
    },
    goEditPost(editPostId) {
      event.preventDefault();
      router.push({ name: "PostModify", params: { post_id: editPostId } });
    },
    openCommentEdit(editCommentId) {
      this.editingCommentId = editCommentId;
    },
    closeCommentEdit() {
      this.editingCommentId = -1;
    },
    updateComment() {
      const newContent = document.getElementById('comment-content-editing').value;
      const newComment_id = document.getElementById('comment-comment_id-editing').value;
      this.update({
        content: newContent,
        comment_id: newComment_id,
      })
      this.closeCommentEdit();
      this.updateData();
    },
    showPostDeleteModal(deletePostId) {
      event.preventDefault();
      console.log(deletePostId);
      this.isPostDeleteModalOpen = true;
      this.deletePostId = deletePostId;
    },
    showCommentDeleteModal(deleteCommentId) {
      event.preventDefault();
      console.log(deleteCommentId);
      this.isCommentDeleteModalOpen = true;
      this.deleteCommentId = deleteCommentId;
    },
    closeDeleteModal() {
      this.isPostDeleteModalOpen = false;
      this.isCommentDeleteModalOpen = false;
      this.deletePostId = "";
      this.deleteCommentId = "";
    },
    deletePost() {
      console.log(this.deletePostId);
      this.delete(this.deletePostId);
      this.closeDeleteModal();
      setTimeout(() => {
        router.go(0);
      }, "10");
    },
    deleteComment() {
      console.log(this.deletePostId);
      this.commentDelete(this.deleteCommentId);
      this.closeDeleteModal();
      this.updateData();
    },
    updateData() {
      const post_id = this.$route.params.post_id;
      const userId = localStorage.getItem("loginUser");
      setTimeout(() => {
        clearInterval(interval);
      }, "50");
      let interval = setInterval(() => {
        this.getComments(post_id);
        this.getPostLikeByUser({ user_id: userId });
        let len = this.postLiked.length;
        this.isLiked = false;
        for (let i = 0; i < len; i++) {
          if (this.postLiked[i].post_id == post_id) {
            this.isLiked = true;
            break;
          }
        }
      }, "10");
    }
  },
  created() {
    const post_id = this.$route.params.post_id;
    const userId = localStorage.getItem("loginUser");
    this.updateData();
    this.getPostLikeByUser({ user_id: userId }).then(() => {
      let len = this.postLiked.length;
      for (let i = 0; i < len; i++) {
        if (this.postLiked[i].post_id == post_id) {
          this.isLiked = true;
          break;
        }
      }
      this.getPost(post_id);
      this.getComments(post_id);
      this.getLoginUser(userId);
      this.addViewCnt(post_id);
    });
  }
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
  /* overflow: auto; */
  /* border: solid 1px red; */
}

.postdetail-header {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
  margin-top: 0.5rem;
  margin-bottom: 1rem;
  color: var(--font-color-2);
  width: 100%;
  /* border: solid red; */
}

.postdetail-header-content {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  margin-top: 0.5rem;
  margin-bottom: 1rem;
  color: var(--font-color-2);
  width: 100%;
}

.postdetail-except-header {
  /* border: solid 1px green; */
  display: flex;
  flex-direction: column;
  align-items: center;
  padding-right: 1rem;
  width: 100%;
  height: 100%;
  overflow: auto;
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
  /* border: solid 1px brown; */
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

.postdetail-main-aside>span {
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

.postdetail-main-value>span {
  margin-bottom: 1rem;
}

.postdetail-main-value-writer {
  display: flex;
  flex-direction: row;
  margin-bottom: 1rem;
}

.postdetail-main-generateddate {
  /* display: flex;
  flex-direction: row-reverse;
  width: 30%;
  color: grey; */
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: flex-end;
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
  /* height: calc(100% - 30rem); */
  width: 100%;
}

.postdetail-comments-content {
  /* border: solid 1px grey; */
  display: flex;
  flex-direction: column;
  width: 100%;
  height: 30rem;
  overflow: auto;
  padding-bottom: 1.5rem;
}

.comment {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  align-items: center;
  box-shadow: 0 0 0.3rem rgb(183, 183, 183);
  margin: 1rem 0.5rem 0rem 0.5rem;
  padding: 0.5rem;
  /* border: solid 1px red; */
}

#comment-writer {
  width: 15%;
}

#comment-content {
  width: 55%;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  color: var(--font-color-2);
  /* border: solid 1px red; */
}

#comment-buttons {
  display: flex;
  width: 10%;
}

#comment-date {
  width: 20%;
  color: var(--font-color-2);
}

.comment-content-editing {
  display: flex;
  justify-content: space-between;
  align-items: center;
  /* border: solid 1px green; */
}

fieldset {
  /* border: solid 1px brown; */
  width: stretch;
}

.postdetail-except-header::-webkit-scrollbar,
.postdetail-comments-content::-webkit-scrollbar {
  width: 0.5rem;
}

.postdetail-except-header::-webkit-scrollbar-thumb,
.postdetail-comments-content::-webkit-scrollbar-thumb {
  background-color: rgb(190, 190, 190);
  border-radius: 10px;
  background-clip: padding-box;
  border: 2px solid transparent;
}

.entercomment {
  width: 100%;
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

.dashboard-content-post-btn {
  display: flex;
}

.dashboard-content-post-btn>button {
  border: none;
  background-color: transparent;
  font-size: x-large;
  color: var(--font-color-btn-1);
}

.comment-edit-buttons {
  display: flex;
  margin-left: 2rem;
}

#comment-buttons>button,
.comment-edit-buttons>button {
  border: none;
  background-color: transparent;
}
</style>
