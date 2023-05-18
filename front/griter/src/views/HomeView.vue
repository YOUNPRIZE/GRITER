<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <aside-nav />
    <HelloWorld msg="Welcome to Your Vue.js App"/>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import AsideNav from '@/components/common/AsideNav.vue'

export default {
  name: 'HomeView',
  components: {
    HelloWorld,
    AsideNav
  }
}
</script>
