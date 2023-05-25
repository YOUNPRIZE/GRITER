<template>
  <div id="app">
    <aside-nav v-if="useNav"/>
    <router-view />
  </div>
</template>

<script>
import AsideNav from "@/components/common/AsideNav.vue";
import { mapMutations, mapState } from "vuex";

export default {
  name: "app",
  data() {
    return {
      useNav: true,
    };
  },
  components: {
    AsideNav,
  },
  computed: {
    ...mapState('nightmodeModule', ["nightmode"]),
  },
  methods: {
    ...mapMutations('nightmodeModule', ["setMode"]),
  },
  beforeMount() {
  },
  mounted() {
    if (
      this.$router.currentRoute.name == "login" ||
      this.$router.currentRoute.name == "register"
    ) {
        this.useNav = false;
      return;
    }
    const showNavbar = (navId, bodyId) => {
      const nav = document.getElementById(navId),
        bodypd = document.getElementById(bodyId);

      // Validate that all variables exist
      if (nav && bodypd) {
        bodypd.addEventListener("click", (e) => {
          if (e.target.id === "nav-bar" || e.target.id === "nav") {
            // show navbar
            nav.classList.toggle("show");
            // add padding to body
            bodypd.classList.toggle("body-pd");
          }
        });
      }
    };
    showNavbar("nav-bar", "body-pd");
    /*===== LINK ACTIVE =====*/
    const linkColor = document.querySelectorAll(".nav_link");
    function colorLink() {
      if (linkColor) {
        linkColor.forEach((l) => l.classList.remove("active"));
        this.classList.add("active");
      }
    }
    linkColor.forEach((l) => l.addEventListener("click", colorLink));
    // Your code to run since DOM is loaded and ready
    const hideNavbar = (navId, bodyId) => {
      const nav = document.getElementById(navId),
        bodypd = document.getElementById(bodyId);

      document.addEventListener("click", () => {
        if (nav.className === "l-navbar show") {
          document.addEventListener("click", () => {
            // show navbar
            nav.classList.toggle("show");
            // add padding to body
            bodypd.classList.toggle("body-pd");
          });
        }
      });
    };
    hideNavbar("nav-bar", "body-pd");
  },
  created() {
    // const loginUser = sessionStorage.getItem("access-token");
    // if (this.$router.currentRoute.name !== 'login' && !loginUser) {
      // alert("로그인을 해주세요");
      // this.$router.push({ name: "login" });
    // }
    if (this.nightmode) {
      document.documentElement.setAttribute("nightmode", true);
    }
  },
};
</script>

<style>
:root {
  --first-color: #f5f6f8;
  --box-bg-color: white;
  --font-color: #2c3e50;
  --font-color-2: black;
  --font-color-3: #2388f5;
  --font-color-btn-1: #565656;
  --input-bg-color: white;
}

[nightmode="true"] {
  --first-color: #7c7c7c;
  --box-bg-color: #565656;
  --font-color: #7fbefd;
  --font-color-2: white;
  --font-color-3: #7fbefd;
  --font-color-btn-1: #b5b5b5;
  --input-bg-color: rgb(135, 135, 135);
}

html {
  height: 100%;
  background-color: var(--first-color);
}

body {
  background-color: var(--first-color);
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: var(--font-color);
  background-color: var(--first-color);
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

/* 모달 스타일링 */
.modal {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  /* height: 150vh; */
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  align-items: center;
  justify-content: center;
}

.modal-content {
  /* border: solid 2px green; */
  background-color: white;
  padding: 20px;
  border-radius: 0.3rem;
  width: 30%;
  min-width: 20rem;
  margin-bottom: 30%;
}

.modal-content-buttons>button {
  border: solid 1px;
  border-radius: 0.5rem;
  margin: 0 1rem 0 1rem;
  width: 5rem;
}
</style>
