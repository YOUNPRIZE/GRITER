<template>
  <aside id="body-pd">
    <div class="l-navbar" id="nav-bar">
      <nav class="nav" id="nav">
        <div>
          <router-link :to="{ name: 'home' }">
            <div class="nav_logo">
              <span class="nav-logo">G</span>
              <span class="nav_logo-name">GRITER</span>
            </div>
          </router-link>
          <hr style="margin-left: 1rem" />
          <!-- 프로필 이미지 및 개인 이메일 정보 들어갈 칸-->
          <div class="nav_list">
            <div class="nav_link" @click="goMyPage">
              <img v-if="loginUser.gender === 'M'" src="../../assets/man.png" class="profile-img" alt="" style="border: solid 2px black;"/>
              <img v-else src="../../assets/woman.png" class="profile-img" alt="" style="border: solid 2px black;"/>
              <div class="login-info">
                <span>Catbirdseat</span><br />
                <span>catbirdseat@naver.com</span>
              </div>
            </div>
            <hr style="margin-left: 1rem" />
            <router-link :to="{ name: 'home' }">
              <div class="nav_link">
                <i class="bx bx-home nav_icon"></i>
                <span class="nav_name">Home</span>
              </div>
            </router-link>
            <router-link :to="{ name: 'PostsList' }">
              <div class="nav_link">
                <i class="bx bx-grid-alt nav_icon"></i>
                <span class="nav_name">Dashboard</span>
              </div>
            </router-link>
            <router-link :to="{ name: 'calendar' }">
              <div class="nav_link">
                <i class="bx bx-calendar nav_icon"></i>
                <span class="nav_name">Calendar</span>
              </div>
            </router-link>
            <router-link :to="{ name: 'searchUser' }">
              <div class="nav_link">
                <i class="bx bxs-contact nav_icon"></i>
                <span class="nav_name">Relations</span>
              </div>
            </router-link>
          </div>
          <hr style="margin-left: 1rem" />
          <div class="nav_link" id="logout-btn" @click="logout">
            <i class="bx bx-log-out nav_icon"></i>
            <span class="nav_name">LogOut</span>
          </div>
        </div>
        <div class="nav_link" id="dark-mode">
          <i class="bx bxs-moon nav_icon"></i>
          <span>DarkMode</span>
          <div class="form-check form-switch">
            <input class="form-check-input" type="checkbox" role="switch" id="nightmode" @click="changeMode" />
          </div>
        </div>
      </nav>
    </div>
  </aside>
</template>

<script>
import router from "@/router";
import { mapState, mapActions } from "vuex";

export default {
  name: "AsideNav",
  computed: {
    ...mapState("nightmodeModule", { currentMode: "nightmode" }),
    ...mapState("userModule", ["loginUser"]),
  },
  methods: {
    ...mapActions("nightmodeModule", ["callModeSet"]),
    ...mapActions("userModule", ["getLoginUser"]),
    nightmode() {
      this.currentMode;
    },
    changeMode() {
      this.callModeSet();
      document.documentElement.setAttribute("nightmode", this.nightmode());
      setTimeout(() => this.$router.go(0), 500);
    },
    logout() {
      sessionStorage.removeItem("access-token");
      localStorage.removeItem("loginUser");
      localStorage.removeItem("vuex");
      router.push({ name: "login" });
      setTimeout(() => {
        router.go(0)
      }, "0");
    },
    goMyPage() {
      if (router.currentRoute.name !== "myPage") {
        router.push({ name: "myPage" });
        setTimeout(() => this.$router.go(0), "0");
      }
    },
  },
  mounted() {
    if (this.currentMode) {
      document.getElementById("nightmode").checked = true;
    }
  },
  created() {
    // const routerName = router.currentRoute.name;
    // if(routerName === 'login'){
    //   // document.getElementById('body-pd').style.display = 'none';
    // }
    const user_id = localStorage.getItem("loginUser");
    this.getLoginUser(user_id);
  },
};
</script>

<style>
#dark-mode {
  display: flex;
}

.nav_logo {
  color: #2388f5;
  font-size: x-large;
  margin-left: 0.1rem;
}

html {
  background-color: #f5f6f8;
  /* 나중에 없애야됨  */
  color: rgb(91, 91, 91);
}

.profile-img {
  width: 3rem;
  height: 3rem;
  /* border: solid red 1px; */
  border-radius: 100%;
  margin-left: -0.8rem;
}

.login-info {
  text-align: left;
  color: black;
  font-weight: lighter;
}

.login-info>span:first-child {
  font-weight: bolder;
}

@import url("https://fonts.googleapis.com/css2?family=Nunito:wght@400;600;700&display=swap");

:root {
  --nav-width: 68px;
  --first-color-light: #afa5d9;
  --white-color: #2388f5;
  --body-font: "Nunito", sans-serif;
  --normal-font-size: 1rem;
  --z-fixed: 100;
}

*,
::before,
::after {
  box-sizing: border-box;
}

aside {
  position: relative;
  margin: var(--header-height) 0 0 0;
  /* padding: 0 1rem; */
  font-family: var(--body-font);
  font-size: var(--normal-font-size);
  transition: 0.5s;
}

a {
  text-decoration: none;
}

.l-navbar {
  position: fixed;
  top: 0;
  left: -30%;
  width: var(--nav-width);
  height: 100vh;
  background-color: var(--box-bg-color);
  /* padding: 0.5rem 1rem 0 0; */
  transition: 0.5s;
  z-index: var(--z-fixed);
  /* border: solid blue; */
  box-shadow: 0 0 5px rgb(184, 184, 184);
}

.nav {
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  overflow: hidden;
  margin-top: -2rem;
}

.nav_logo,
.nav_link {
  display: grid;
  grid-template-columns: max-content max-content;
  align-items: center;
  column-gap: 1rem;
  padding: 0.5rem 0 0.5rem 1.5rem;
}

.nav_link {
  position: relative;
  color: var(--first-color-light);
  margin-top: 1rem;
  margin-bottom: 1.5rem;
  transition: 0.3s;
}

.nav_link:hover {
  color: var(--white-color);
  cursor: pointer;
}

.nav_icon {
  font-size: 1.25rem;
}

.show {
  left: 0;
}

.active {
  color: var(--white-color);
}

.active::before {
  content: "";
  position: absolute;
  left: 0;
  width: 2px;
  height: 32px;
  background-color: var(--white-color);
}

#logout-btn:hover {
  cursor: pointer;
}

.height-100 {
  height: 100vh;
}

@media screen and (min-width: 100px) {
  body {
    padding-left: 4rem;
  }

  .l-navbar {
    left: 0;
    padding: 0.5rem 0.5rem 0 0;
  }

  .show {
    width: calc(var(--nav-width) + 200px);
  }
}
</style>
