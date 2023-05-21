<template>
  <div id="app">
    <div v-if="useNav">
      <aside-nav />
    </div>
    <router-view />
  </div>
</template>

<script>
import AsideNav from "@/components/common/AsideNav.vue";
import { mapMutations, mapState, } from "vuex";

export default {
  name: "app",
  data() {
    return {
      useNav: true,
      // nightmode: '',
    };
  },
  components: {
    AsideNav,
  },
  computed: {
    ...mapState(["nightmode"]),
  },
  methods:{
    ...mapMutations(["setMode"]),
  },
  beforeMount() {
    console.log("nightmode: " + this.$store.state.nightmode);
  },
  mounted() {
    console.log(this.$router.currentRoute.name);
    console.log(this.$store);
    if (
      this.$router.currentRoute.name == "login" ||
      this.$router.currentRoute.name == "register"
    ) {
      this.useNav = false;
      return;
    }
    console.log(this.useNav);
    const showNavbar = (navId, bodyId) => {
      const nav = document.getElementById(navId),
        bodypd = document.getElementById(bodyId);

      // Validate that all variables exist
      if (nav && bodypd) {
        bodypd.addEventListener("click", (e) => {
          console.log(e.target.className);
          console.log(this.$router.currentRoute.name);
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
    console.log(document.querySelector('body'));
    console.log(document.documentElement.getAttribute('nightmode'));
    if(this.$store.state.nightmode){
      document.querySelector('html').style.cssText = 'background-color: rgb(91, 91, 91) !important';
      document.querySelector('body').style.cssText = 'background-color: rgb(91, 91, 91) !important';
      document.querySelector('home').style.cssText = 'background-color: rgb(91, 91, 91) !important';
    }
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
  background-color: #F5F6F8;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}
</style>
