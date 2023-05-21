<template>
  <div>
    <router-view />
  </div>
</template>

<script>
export default {
  name: "PostsView",
  data() {
    return {
      posts: [],
    };
  },
};
</script>

<style></style>
