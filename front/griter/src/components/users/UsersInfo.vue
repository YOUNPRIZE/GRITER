<template>
  <main>
    <div class="userinfo-left">
      <div class="userinfo">
        <div class="userinfo-head">
          <div class="userinfo-header">
            <span>User Information</span>
            <router-link to="/">
              <i class="bx bxs-edit" id="edit-btn"></i>
            </router-link>
          </div>
          <div class="line"></div>
        </div>
        <div class="userinfo-content">
          <img src="" alt="" style="height: 15rem; width: 15rem; border: solid 1px red; border-radius: 100%" />
          <div class="userinfo-content-info">
            <div class="userinfo-content-info-item">
              <span>Name</span>
              <span>{{ loginUser.name }}</span>
            </div>
            <div class="userinfo-content-info-item">
              <span>ID</span>
              <span>{{ loginUser.nickname }}</span>
            </div>
            <div class="userinfo-content-info-item">
              <span>Email</span>
              <span>{{ loginUser.email }}</span>
            </div>
            <div class="userinfo-content-info-item">
              <span>Gender</span>
              <span v-if="loginUser.gender == 'M'">Male</span>
              <span v-else>Female</span>
            </div>
          </div>
        </div>
      </div>
      <div class="userinfo-follow">
        <div class="userinfo-follow-header">
          <div class="userinfo-follow-header-select">
            <input type="radio" class="btn-check" name="options" id="select-followers" autocomplete="off"
              @click="toggleFollow" checked>
            <label class="btn btn-outline-primary" for="select-followers">Followers</label>
            <input type="radio" class="btn-check" name="options" id="select-follwing" autocomplete="off"
              @click="toggleFollow">
            <label class="btn btn-outline-primary" for="select-follwing">Following</label>
          </div>
        </div>
        <div v-if="showFollowers === true" class="followers">
          <div class="follows-header">
            <span class="followers-logo">Followers</span>
            <form action="" class="search-form">
              <div class="input-group mb-3">
                <span class="input-group-text"><box-icon name="search"></box-icon></span>
                <input class="form-control" id="search" type="text" placeholder="Search" @input="searchGroup1($event)" />
              </div>
            </form>
          </div>
          <div class="line"></div>
          <div class="followers-head">
            <span>Img</span>
            <span>Name</span>
            <span>ID</span>
            <span>Email</span>
          </div>
          <div class="line" style="height: 0.2rem; margin-bottom: 0"></div>
          <div v-for="(follower, index) in followers" :key="index" class="group-item-1" id="followers-content">
            <div id="followers-content-userInfo">
              <div class="followers-content-userInfo">
                <img src="" alt="" />
                <span>{{ follower.name }}</span>
                <span>{{ follower.nickname }}</span>
                <span>{{ follower.email }}</span>
              </div>
              <hr style="margin: 0; margin-top: 0.5rem" />
            </div>
          </div>
        </div>
        <div v-else class="following">
          <div class="follows-header">
            <span class="following-logo">Following</span>
            <form action="" class="search-form">
              <div class="input-group mb-3">
                <span class="input-group-text"><box-icon name="search"></box-icon></span>
                <input class="form-control" id="search" type="text" placeholder="Search" @input="searchGroup2($event)" />
              </div>
            </form>
          </div>
          <div class="line"></div>
          <div class="following-head">
            <span>Img</span>
            <span>Name</span>
            <span>ID</span>
            <span>Email</span>
          </div>
          <div class="line" style="height: 0.2rem; margin-bottom: 0;"></div>
          <div class="following-content">
            <div v-for="(follow, index) in following" :key="index" class="group-item-2" id="following-content">
              <div id="following-content-userInfo">
                <div class="following-content-userInfo">
                  <img src="" alt="" />
                  <span>{{ follow.name }}</span>
                  <span>{{ follow.nickname }}</span>
                  <span>{{ follow.email }}</span>
                </div>
                <hr style="margin: 0; margin-top: 0.5rem" />
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="myPost">
      <span>My Post</span>
      <div class="line"></div>
      <div class="myPost-content">
        <div v-for="(post, index) in posts" :key="index" class="group-item">
          <!-- link 좌표 바꿔야 됨 상세보기로, params도 받아와야 함-->
          <router-link :to="{ name: 'PostsDetail', params: { post_id: post.post_id } }">
            <div class="myPost-content-post">
              <div class="myPost-content-post-left">
                <div class="myPost-content-post-title">
                  <span>{{ post.title }}</span>
                </div>
                <div class="myPost-content-post-writerInfo">
                  <img src="" alt="" style="
                      width: 30px;
                      height: 30px;
                      border-radius: 100%;
                      border: solid 1px red;
                    " />
                  <span class="myPost-content-post-writer">{{ post.nickname }}</span>
                </div>
              </div>
              <div class="myPost-content-post-right">
                <span v-if="
                  JSON.stringify(post.generated_date) ===
                  JSON.stringify(post.modified_date)
                " class="myPost-content-post-created">{{ post.generated_date[0] }}.{{ post.generated_date[1] }}.{{
  post.generated_date[2]
}}
                  {{ post.generated_date[3] }}:{{ post.generated_date[4] }}:{{
                    post.generated_date[5]
                  }}</span>
                <span v-if="
                  JSON.stringify(post.generated_date) !==
                  JSON.stringify(post.modified_date)
                " class="myPost-content-post-created">{{ post.modified_date[0] }}.{{ post.modified_date[1] }}.{{
  post.modified_date[2]
}}
                  {{ post.modified_date[3] }}:{{ post.modified_date[4] }}:{{
                    post.modified_date[5]
                  }}(수정됨)</span>
                <div class="myPost-content-post-btn">
                  <div v-if="post.user_id === loginUser.user_id" class="dashboard-content-post-btn">
                    <button @click="goEditPost(post.post_id)">
                      <i class="bx bx-pencil"></i>
                    </button>
                    <button @click="showDeleteModal(post.post_id)">
                      <i class="bx bx-trash"></i>
                    </button>
                  </div>
                  <div v-else></div>
                </div>
              </div>
            </div>
          </router-link>
        </div>
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
import { mapState, mapActions } from "vuex";

export default {
  name: "UserInfo",
  data() {
    return {
      isDeleteModalOpen: false,
      deletePostId: "",
      showFollowers: true,
    };
  },
  computed: {
    ...mapState("userModule", ["loginUser"]),
    ...mapState("postModule", ["posts"]),
    ...mapState("followModule", ["followers", "following"]),
  },
  methods: {
    ...mapActions("userModule", ["getLoginUser"]),
    ...mapActions("postModule", ["getPostsByUserId"]),
    goEditPost(editPostId) {
      event.preventDefault();
      router.push({ name: "PostModify", params: { post_id: editPostId } });
    },
    showDeleteModal(deletePostId) {
      event.preventDefault();
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
      router.go(0);
    },
    ...mapActions("followModule", ["callFollowers", "callFollowing"]),
    searchGroup1(event) {
      const len = this.followers.length;
      for (let i = 0; i < len; i++) {
        if (
          this.followers[i].name.includes(event.target.value) === false &&
          this.followers[i].nickname.includes(event.target.value) === false &&
          this.followers[i].email.includes(event.target.value) === false
        ) {
          document.querySelectorAll(".group-item-1")[i].style.display = "none";
        } else {
          document.querySelectorAll(".group-item-1")[i].style.display = "flex";
        }
      }
    },
    searchGroup2(event) {
      const len = this.following.length;
      for (let i = 0; i < len; i++) {
        if (
          this.following[i].name.includes(event.target.value) === false &&
          this.following[i].nickname.includes(event.target.value) === false &&
          this.following[i].email.includes(event.target.value) === false
        ) {
          document.querySelectorAll(".group-item-2")[i].style.display = "none";
        } else {
          document.querySelectorAll(".group-item-2")[i].style.display = "flex";
        }
      }
    },
    toggleFollow() {
      this.showFollowers = !this.showFollowers;
    }
  },
  created() {
    const user_id = localStorage.getItem("loginUser");
    this.getLoginUser(user_id);
    this.getPostsByUserId(user_id);
    this.callFollowers(user_id);
    this.callFollowing(user_id);
  },
};
</script>

<style scoped>
main {
  display: flex;
  flex-direction: row;
  /* justify-content: space-around; */
  /* border: solid 2px black; */
  width: 94vw;
  padding: 0;
  padding-bottom: 1rem;
}

.userinfo-left {
  /* border: solid 5px green; */
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 100%;
  margin-left: 1.5rem;
}

.userinfo,
.myPost {
  /* border: solid 1px red; */
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  padding: 2rem;
  box-shadow: 0 0 1rem rgb(177, 177, 177);
  /* height: 85vh;
  width: 40vw; */
  min-width: 50rem;
  background-color: var(--box-bg-color);
}

.userinfo {
  /* border: solid 1px red; */
  height: 45%;
  height: fit-content;
}

.myPost {
  /* border: solid 1px orange; */
  padding-bottom: 0;
  width: 50%;
  margin-left: 2rem;
}

.userinfo-header,
.myPost>span:nth-child(1) {
  font-size: x-large;
  font-weight: 600;
  margin-bottom: 1rem;
  color: var(--font-color-2);
}

.userinfo-head {
  display: flex;
  flex-direction: column;
  width: 100%;
}

.userinfo-header {
  /* border: solid; */
  display: flex;
  flex-direction: row;
  width: stretch;
  justify-content: space-between;
  align-items: center;
}

#edit-btn {
  color: grey;
}

.userinfo-content {
  /* border: solid 1px green; */
  display: flex;
  flex-direction: row;
  align-items: center;
  width: 100%;
  justify-content: space-around;
  margin: 1rem 0 0 0;
}

.userinfo-content-info {
  display: flex;
  flex-direction: column;
  /* border: solid 1px orange; */
  justify-content: space-evenly;
  height: 100%;
  width: 20rem;
}

.userinfo-content-info-item {
  /* border: solid 1px black; */
  display: flex;
  flex-direction: row;
}

.userinfo-content-info-item>span:nth-child(1) {
  /* border: solid 1px red; */
  font-weight: bold;
  width: 40%;
  text-align: left;
}

.userinfo-content-info-item>span:nth-child(2) {
  /* border: solid 1px green; */
  margin-left: 2rem;
  width: 100%;
  text-align: left;
}

.myPost-content {
  /* border: solid black; */
  display: flex;
  flex-direction: column;
  min-width: 30rem;
  border-radius: 0.1rem;
  width: 100%;
  height: stretch;
  overflow: auto;
  padding: 0 0 2rem 0;
}

.myPost-content-post {
  display: flex;
  flex-direction: column;
  padding-bottom: 2rem;
}

.myPost-content::-webkit-scrollbar,
.myPost-content::-webkit-scrollbar {
  width: 0.5rem;
}

.myPost-content::-webkit-scrollbar-thumb,
.myPost-content::-webkit-scrollbar-thumb {
  background-color: rgb(190, 190, 190);
  border-radius: 10px;
  background-clip: padding-box;
  border: 2px solid transparent;
}

.myPost-content-post {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  color: var(--font-color-2);
  margin: 2rem 2rem 0 2rem;
  padding: 1rem;
  box-shadow: 0 0 5px rgb(185, 185, 185);
  border-radius: 2px;
  height: 8rem;
}

.myPost-content-post-title {
  margin-bottom: 2rem;
}

.myPost-content-post-left {
  /* border: solid; */
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: flex-start;
}

.myPost-content-post-right {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: flex-end;
}

#myPost-btn {
  margin: 0 0.5rem 0 0.5rem;
  color: grey;
}

.myPost-content-post-created {
  color: grey;
}

.dashboard-content-post-btn>button {
  border: none;
  background-color: transparent;
  color: var(--font-color-btn-1);
}

.userinfo-follow {
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  align-items: center;
  /* height: calc(100% - 5rem); */
  box-shadow: 0 0 1rem rgb(190, 190, 190);
  border-radius: 0.2rem;
  width: 100%;
  height: stretch;
  min-width: 20rem;
  margin-top: 2rem;
  padding: 2rem;
  background-color: var(--box-bg-color);
  /* border: solid 1px red; */
}

.followers,
.following {
  width: 100%;
  height: 100%;
}

.follows-header {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  color: var(--font-color-2);
}

.followers-logo,
.following-logo {
  align-self: flex-start;
  font-size: x-large;
  font-weight: 500;
}

#followers-content,
#following-content {
  display: flex;
  flex-direction: column;
  overflow: auto;
}

#followers-content::-webkit-scrollbar,
#following-content::-webkit-scrollbar {
  width: 0.5rem;
}

#followers-content::-webkit-scrollbar-thumb,
#following-content::-webkit-scrollbar-thumb {
  background-color: rgb(190, 190, 190);
  border-radius: 10px;
  background-clip: padding-box;
  border: 2px solid transparent;
}

.followers-head,
.following-head,
.followers-content-userInfo,
.following-content-userInfo {
  /* border: solid 1px green; */
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}

.followers-head>span,
.following-head>span {
  /* border: solid 1px red; */
  font-weight: bold;
}

.followers-head>span:nth-child(1),
.following-head>span:nth-child(1),
.followers-content-userInfo>img,
.following-content-userInfo>img {
  width: 10%;
}

.followers-head>span:nth-child(2),
.following-head>span:nth-child(2),
.followers-content-userInfo>span:nth-child(2),
.following-content-userInfo>span:nth-child(2) {
  width: 23%;
}

.followers-head>span:nth-child(3),
.following-head>span:nth-child(3),
.followers-content-userInfo>span:nth-child(3),
.following-content-userInfo>span:nth-child(3) {
  width: 23%;
}

.followers-head>span:nth-child(4),
.following-head>span:nth-child(4),
.followers-content-userInfo>span:nth-child(4),
.following-content-userInfo>span:nth-child(4) {
  width: 44%;
}

#followers-content {
  /* border: solid 1px green; */
  display: flex;
  flex-direction: column;
}

.followers-content-userInfo,
.following-content-userInfo {
  /* padding: 1rem; */
  margin: 0.5rem 0 0.5rem 0;
  height: 3rem;
}

.followers-content-userInfo>*,
.following-content-userInfo>* {
  display: flex;
  flex-direction: column;
  justify-content: center;
}
</style>
