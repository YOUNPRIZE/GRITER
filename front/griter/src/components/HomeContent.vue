<template>
  <main>
    <!-- dashboard -->
    <div class="dashboard">
      <div id="dashboard-title">
        <h5>DashBoard</h5>
        <router-link :to="{ name: 'PostsList' }">
          <box-icon type="solid" name="plus-square"></box-icon>
        </router-link>
      </div>
      <div class="line"></div>
      <div class="dashboard-content">
        <!-- 대시보드 미리보기 항목들 -->
        <div v-for="(post, index) in posts" :key="index" class="group-item">
            <router-link :to="{ name: 'PostsDetail', params: { post_id: post.post_id } }">
              <div class="dashboard-content-post">
                <div class="dashboard-content-post-left">
                  <div class="dashboard-content-post-title">
                    <span>{{ post.title }}</span>
                  </div>
                  <div class="dashboard-content-post-writerInfo">
                    <img src="" alt="" style="
                          width: 30px;
                          height: 30px;
                          border-radius: 100%;
                          border: solid 1px red;
                        " />
                    <span class="dashboard-content-post-writer">{{ post.nickname }}</span>
                  </div>
                </div>
                <div class="dashboard-content-post-right">
                  <span class="dashboard-content-post-created">{{ post.generated_date[0] }}.{{ post.generated_date[1]
                  }}.{{
  post.generated_date[2]
}}
                    {{ post.generated_date[3] }}:{{ post.generated_date[4] }}</span>
                  <div v-if="post.user_id === loginUser.user_id" class="dashboard-content-post-btn">
                    <button :value=post.post_id @click="editPost($event)">
                      <i class="bx bx-pencil"></i>
                    </button>
                    <button :value=post.post_id @click="showDeleteModal(post.post_id)">
                      <i class="bx bx-trash"></i>
                    </button>
                  </div>
                  <div v-else>
                  </div>
                </div>
              </div>
            </router-link>
          </div>
      </div>
    </div>
    <!-- user & calendar-->
    <div class="userAndCalendar">
      <div class="userInfo">
        <div id="userInfo-title">
          <h5>User</h5>
          <router-link :to="{ name: 'userInfo', params: { user_id: loginUser.user_id } }">
            <box-icon type="solid" name="plus-square"></box-icon>
          </router-link>
        </div>
        <div class="line"></div>
        <div class="userInfo-content">
          <img src id="profile-image" alt />
          <div class="userInfo-info">
            <!-- 아이디 -->
            <h5>{{ loginUser.nickname }}</h5>
            <!-- 팔로잉 -->
            <div class="userInfo-info-following">
              <h6>Following</h6>
              <h6>98</h6>
            </div>
            <!-- 팔로워 -->
            <div class="userInfo-info-follower">
              <h6>Follower</h6>
              <h6>86</h6>
            </div>
          </div>
        </div>
      </div>
      <div class="calendar">
        <div id="calendar-title">
          <h5>Calendar</h5>
          <router-link :to="{ name: 'calendar' }">
            <box-icon type="solid" name="plus-square"></box-icon>
          </router-link>
        </div>
        <div class="calendar-content">
          <!-- <v-calendar is-dark is-expanded :attributes="attributes"/> -->
          <v-calendar is-expanded :attributes="attributes" />
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
  data() {
    return {
      attributes: [
        {
          dot: true,
          dates: [
          ]
        }
      ],
      isDeleteModalOpen: false,
      deletePostId: "",
    };
  },
  computed: {
    ...mapState("userModule", ["loginUser"]),
    ...mapState("routineModule", ["routines"]),
    ...mapState("postModule", ["posts"]),
  },
  mounted() {
    const asdfasdf = JSON.stringify(this.routines);
    console.log(asdfasdf);
    const user_id = localStorage.getItem("loginUser");
    // dispatch 역할
    this.getLoginUser(user_id);
    this.getUserRoutines(user_id);

    const len = this.routines.length;
    for (let i = 0; i < len; i++) {
      this.attributes[0]["dates"].push(new Date(this.routines[i].date + 9 * 60 * 60 * 1000));
    }
  },
  methods: {
    ...mapActions("postModule", ["getPosts", "delete"]),
    ...mapActions("userModule", ["getLoginUser"]),
    ...mapActions("routineModule", ["getUserRoutines"]),
    addItemToAttributes(date) {
      this.attributes[0]["dates"].push(date);
    },
    // editPost(event) {
    //   // const post_id = event.target.value;

    // },
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
      router.go(0);
    }
  },
  created() {
    // 로그인하고 1회만 새로고침
    // console.log(self.name);
    if (self.name != "reload") {
      self.name = "reload";
      self.location.reload(true);
    } else self.name = "";
    this.getPosts();
  }
};
</script>

<style>
main {
  /* border: solid green; */
  display: flex;
  flex-direction: row;
  height: 94vh;
  width: 95vw;
  padding: 2rem 2.5rem 4rem 1rem;
  /* padding-top: 2rem;
  padding-bottom: 4rem;
  padding-right: 2.5rem; */
  margin: 2rem;
}

#dashboard-title,
#userInfo-title {
  color: var(--font-color-2);
}

.line {
  width: 100%;
  height: 0.05rem;
  background-color: rgb(186, 186, 186);
}
</style>

<style scoped>
.dashboard,
.userInfo,
.calendar {
  border-radius: 0.1rem;
  box-shadow: 0 0 1rem rgb(184, 184, 184);
  background-color: var(--box-bg-color);
  width: 100%;
}

.dashboard {
  display: flex;
  flex-direction: column;
  min-width: 30rem;
}

.dashboard-content {
  display: flex;
  flex-direction: column;
  overflow: auto;
  padding-bottom: 2rem;
}

.dashboard-content::-webkit-scrollbar {
  width: 0.5rem;
}

.dashboard-content::-webkit-scrollbar-thumb {
  background-color: rgb(190, 190, 190);
  border-radius: 10px;
  background-clip: padding-box;
  border: 2px solid transparent;
}

.userInfo,
.calendar {
  width: 33rem;
  margin-left: 4rem;
}

.userInfo {
  margin-bottom: 2rem;
  height: 21rem;
}

#dashboard-title,
#userInfo-title,
#calendar-title {
  /* border: solid green; */
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  padding: 2rem;
  padding-bottom: 1rem;
}

.userInfo-content {
  /* border: solid green; */
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  align-items: center;
  margin: 1rem;
  padding-top: 1rem;
  padding-bottom: 2rem;
}

.userInfo-info {
  /* border: solid black; */
  width: 10rem;
  text-align: left;
}

#profile-image {
  border: solid 1px red;
  border-radius: 100%;
  width: 9rem;
  height: 9rem;
}

.userInfo-info-following,
.userInfo-info-follower {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  margin-top: 1rem;
}

hr {
  margin: 0;
  margin-left: 1rem;
  margin-right: 1rem;
}

.dashboard-content-post {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  color: var(--font-color-2);
  margin: 2rem 2rem 0 2rem;
  padding: 1rem;
  box-shadow: 0 0 5px rgb(185, 185, 185);
  border-radius: 2px;
  height: 7rem;
}

.dashboard-content-post-title {
  display: flex;
  margin-bottom: 0.5rem;
  align-items: flex-start;
  font-weight: bold;
}

.dashboard-content-post-left {
  /* border: solid 1px red; */
  display: flex;
  width: 85%;
  align-items: flex-start;
  flex-direction: column;
  justify-content: space-between;
}

.dashboard-content-post-writerInfo {
  display: flex;
  margin-top: 1rem;
}

.dashboard-content-post-writer {
  margin-left: 1rem;
}

.dashboard-content-post-right {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: flex-end;
}

#dashboard-btn {
  margin: 0 0.5rem 0 0.5rem;
  color: grey;
}

.dashboard-content-post-created {
  color: grey;
}

.dashboard-content-post-btn>button {
  border: none;
  background-color: transparent;
}
</style>
