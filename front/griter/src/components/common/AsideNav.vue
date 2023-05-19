<template>
  <aside id="body-pd">
    <div class="l-navbar" id="nav-bar">
      <nav class="nav" id="nav">
        <div>
          <router-link to="/">
            <div class="nav_logo">
              <span class="nav-logo">G</span>
              <span class="nav_logo-name">GRITER</span>
            </div>
          </router-link>
          <hr style="margin-left: 1rem;">
          <!-- 프로필 이미지 및 개인 이메일 정보 들어갈 칸-->
          <div class="nav_list">
            <router-link to="users">
              <div class="nav_link">
                <img src="" class="profile-img" alt="">
                <div class="login-info">
                  <span>Catbirdseat</span><br>
                  <span>catbirdseat@naver.com</span>
                </div>
              </div>
            </router-link>
            <hr style="margin-left: 1rem;">
            <router-link to="/">
              <div class="nav_link active">
                <i class="bx bx-home nav_icon"></i>
                <span class="nav_name">Home</span>
              </div>
            </router-link>
            <router-link to="posts">
              <div class="nav_link">
                <i class="bx bx-grid-alt nav_icon"></i>
                <span class="nav_name">Dashboard</span>
              </div>
            </router-link>
            <a href="#" class="nav_link">
              <i class="bx bx-calendar nav_icon"></i> <span class="nav_name">Calendar</span>
            </a>
            <a href="#" class="nav_link">
              <i class="bx bx-user nav_icon"></i>
              <span class="nav_name">MyPage</span>
            </a>
          </div>
        </div>
        <a href="#" class="nav_link">
          <i class="bx bx-log-out nav_icon"></i>
          <span class="nav_name">SignOut</span>
        </a>
      </nav>
    </div>
  </aside>
</template>

<script>
export default {
};
</script>

<style>
.nav_logo {
  color: #2388F5;
  font-size: x-large;
  margin-left: 0.1rem;
}

html {
  background-color: #F5F6F8;
}

.profile-img {
  width: 3rem;
  height: 3rem;
  border: solid red 1px;
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
  --first-color: #FFFFFF;
  --first-color-light: #afa5d9;
  --white-color: #2388F5;
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
  background-color: var(--first-color);
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
