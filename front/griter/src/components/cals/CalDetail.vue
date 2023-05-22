<template>
  <main>
    <div class="dashboard-container">
      <b-calendar block locale="en-US"></b-calendar>
    </div>
  </main>
</template>

<script>
// import http from "@/util/http-common";

export default {
  name: "PostsList",
  data() {
    return {
      posts: []
    };
  },
  components: {},
  methods: {}
};
</script>

<style>
.search-form {
  /* border: solid red; */
  display: flex;
  flex-direction: column;
  height: 3rem;
}
</style>

<style scoped>
.dashboard-container {
  display: flex;
  flex-direction: column;
  box-shadow: 0 0 1rem rgb(190, 190, 190);
  background-color: var(--box-bg-color);
  padding: 1.5rem;
  width: 90vw;
  height: 84vh;
}

.b-calendar > div:nth-child(1) {
  border: solid green;
  display: flex;
  flex-direction: column;
  justify-content: stretch;
  height: 50rem !important;
}
</style>
