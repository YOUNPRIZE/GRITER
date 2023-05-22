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
        <router-link to="/">
          <div class="dashboard-content-post">
            <div class="dashboard-content-post-left">
              <div class="dashboard-content-post-title">
                <span>제목 젬고 제목</span>
              </div>
              <div class="dashboard-content-post-writerInfo">
                <img src="" alt="" style="
                                width: 30px;
                                height: 30px;
                                border-radius: 100%;
                                border: solid 1px red;
                              " />
                <span class="dashboard-content-post-writer">catbirdseat</span>
              </div>
            </div>
            <div class="dashboard-content-post-right">
              <span class="dashboard-content-post-created">December, 23, 2022</span>
            </div>
          </div>
        </router-link>
        <router-link to="/">
          <div class="dashboard-content-post">
            <div class="dashboard-content-post-left">
              <div class="dashboard-content-post-title">
                <span>제목 젬고 제목</span>
              </div>
              <div class="dashboard-content-post-writerInfo">
                <img src="" alt="" style="
                                width: 30px;
                                height: 30px;
                                border-radius: 100%;
                                border: solid 1px red;
                              " />
                <span class="dashboard-content-post-writer">catbirdseat</span>
              </div>
            </div>
            <div class="dashboard-content-post-right">
              <span class="dashboard-content-post-created">December, 23, 2022</span>
            </div>
          </div>
        </router-link>
        <router-link to="/">
          <div class="dashboard-content-post">
            <div class="dashboard-content-post-left">
              <div class="dashboard-content-post-title">
                <span>제목 젬고 제목</span>
              </div>
              <div class="dashboard-content-post-writerInfo">
                <img src="" alt="" style="
                                width: 30px;
                                height: 30px;
                                border-radius: 100%;
                                border: solid 1px red;
                              " />
                <span class="dashboard-content-post-writer">catbirdseat</span>
              </div>
            </div>
            <div class="dashboard-content-post-right">
              <span class="dashboard-content-post-created">December, 23, 2022</span>
            </div>
          </div>
        </router-link>
        <router-link to="/">
          <div class="dashboard-content-post">
            <div class="dashboard-content-post-left">
              <div class="dashboard-content-post-title">
                <span>제목 젬고 제목</span>
              </div>
              <div class="dashboard-content-post-writerInfo">
                <img src="" alt="" style="
                                width: 30px;
                                height: 30px;
                                border-radius: 100%;
                                border: solid 1px red;
                              " />
                <span class="dashboard-content-post-writer">catbirdseat</span>
              </div>
            </div>
            <div class="dashboard-content-post-right">
              <span class="dashboard-content-post-created">December, 23, 2022</span>
            </div>
          </div>
        </router-link>
        <router-link to="/">
          <div class="dashboard-content-post">
            <div class="dashboard-content-post-left">
              <div class="dashboard-content-post-title">
                <span>제목 젬고 제목</span>
              </div>
              <div class="dashboard-content-post-writerInfo">
                <img src="" alt="" style="
                                width: 30px;
                                height: 30px;
                                border-radius: 100%;
                                border: solid 1px red;
                              " />
                <span class="dashboard-content-post-writer">catbirdseat</span>
              </div>
            </div>
            <div class="dashboard-content-post-right">
              <span class="dashboard-content-post-created">December, 23, 2022</span>
            </div>
          </div>
        </router-link>
        <router-link to="/">
          <div class="dashboard-content-post">
            <div class="dashboard-content-post-left">
              <div class="dashboard-content-post-title">
                <span>제목 젬고 제목</span>
              </div>
              <div class="dashboard-content-post-writerInfo">
                <img src="" alt="" style="
                                width: 30px;
                                height: 30px;
                                border-radius: 100%;
                                border: solid 1px red;
                              " />
                <span class="dashboard-content-post-writer">catbirdseat</span>
              </div>
            </div>
            <div class="dashboard-content-post-right">
              <span class="dashboard-content-post-created">December, 23, 2022</span>
            </div>
          </div>
        </router-link><router-link to="/">
          <div class="dashboard-content-post">
            <div class="dashboard-content-post-left">
              <div class="dashboard-content-post-title">
                <span>제목 젬고 제목</span>
              </div>
              <div class="dashboard-content-post-writerInfo">
                <img src="" alt="" style="
                                width: 30px;
                                height: 30px;
                                border-radius: 100%;
                                border: solid 1px red;
                              " />
                <span class="dashboard-content-post-writer">catbirdseat</span>
              </div>
            </div>
            <div class="dashboard-content-post-right">
              <span class="dashboard-content-post-created">December, 23, 2022</span>
            </div>
          </div>
        </router-link><router-link to="/">
          <div class="dashboard-content-post">
            <div class="dashboard-content-post-left">
              <div class="dashboard-content-post-title">
                <span>제목 젬고 제목</span>
              </div>
              <div class="dashboard-content-post-writerInfo">
                <img src="" alt="" style="
                                width: 30px;
                                height: 30px;
                                border-radius: 100%;
                                border: solid 1px red;
                              " />
                <span class="dashboard-content-post-writer">catbirdseat</span>
              </div>
            </div>
            <div class="dashboard-content-post-right">
              <span class="dashboard-content-post-created">December, 23, 2022</span>
            </div>
          </div>
        </router-link>
      </div>
    </div>
    <!-- user & calendar-->
    <div class="userAndCalendar">
      <div class="userInfo">
        <div id="userInfo-title">
          <h5>User</h5>
          <box-icon type="solid" name="plus-square" @click="moveToUserDetail"></box-icon>
        </div>
        <div class="line"></div>
        <div class="userInfo-content">
          <img src="" id="profile-image" alt="" />
          <div class="userInfo-info">
            <!-- 아이디 -->
            <h5>{{ currentUser.nickname }}</h5>
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
          <a href="#">
            <box-icon type="solid" name="plus-square"></box-icon>
          </a>
        </div>
        <div class="calendar-content"></div>
      </div>
    </div>
  </main>
</template>

<script>
import router from "@/router";
import { mapState, mapActions } from "vuex";
export default {
  computed: {
    ...mapState('userModule', { currentUser: 'loginUser' }),
  },
  methods: {
    ...mapActions('userModule', { getUser: 'getUser' }),
    moveToUserDetail() {
      const nickname = localStorage.getItem('loginUser');
      console.log(nickname);
      router.push({ name: 'userInfo', query: nickname });
    },
  },
  created() {
    // console.log(JSON.stringify(this.get()));
    const nickname = localStorage.getItem('loginUser');
    console.log(this.getUser(nickname));
    this.currentUser = this.getUser(nickname);

    // 로그인하고 1회만 새로고침
    console.log(self.name);
    if (self.name != "reload") {
      self.name = "reload";
      self.location.reload(true);
    } else self.name = "";
    // console.log(this.loginUser);
  },
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

.dashboard-content::-webkit-scrollbar,
.dashboard-content::-webkit-scrollbar {
  width: 0.5rem;
}

.dashboard-content::-webkit-scrollbar-thumb,
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
  height: 10rem;
}

.dashboard-content-post-title {
  margin-bottom: 2rem;
}

.dashboard-content-post-created {
  color: var(--font-color-3);
}
</style>
