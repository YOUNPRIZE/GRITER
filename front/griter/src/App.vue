<template>
  <div id="app">
    <aside-nav />
    <router-view />
  </div>
</template>


<script>
import AsideNav from '@/components/common/AsideNav.vue'

export default {
  name: "app",
  components: {
    AsideNav,
  },
  mounted() {
    const showNavbar = (navId, bodyId) => {
      const nav = document.getElementById(navId),
        bodypd = document.getElementById(bodyId);

      // Validate that all variables exist
      if (nav && bodypd) {
        bodypd.addEventListener("click", (e) => {
          console.log(e.target.class);
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
        if (nav.className === 'l-navbar show') {
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
};
</script>

<style>
html {
  height: 100%;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}


nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}
</style>
