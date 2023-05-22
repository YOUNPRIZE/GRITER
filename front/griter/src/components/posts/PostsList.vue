<template>
  <main>
    <div class="dashboard-container">
      <div class="dashboard-container-header">
        <h5>DashBoard</h5>
        <form action="" class="search-form">
          <div class="input-group mb-3">
            <span class="input-group-text"><box-icon name="search"></box-icon></span>
            <input class="form-control" id="search" type="text" placeholder="Search" @input="searchGroup($event)" />
          </div>
        </form>
      </div>
      <div class="dashboard-container-content">
        <div class="line"></div>
        <div class="dashboard-container-content-buttons">
          <!-- 여유되면 카테고리랑 부위 버튼 넣을 자리-->
          <div></div>
          <button class="btn btn-primary" id="newPost" @click="movePage">New Post</button>
        </div>
        <div class="dashboard-content">
          <div v-for="(post, index) in posts" :key="index" class="group-item">
            <router-link :to="`${post.post_id}`">
              <div class="dashboard-content-post">
                <div class="dashboard-content-post-left">
                  <div class="dashboard-content-post-title">
                    <span>{{ post.title }}</span>
                  </div>
                  <div class="dashboard-content-post-content">
                    {{ post.content }}
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
                  }}.{{ post.generated_date[2] }} {{ post.generated_date[3] }}:{{ post.generated_date[4] }}</span>
                  <div class="dashboard-content-post-btn">
                    <!-- link to 는 기능 확인을 위해 임시로 걸어놓은 것 수정해야됨 -->
                    <router-link :to="{ name: 'login' }" id="dashboard-btn">
                      <i class="bx bx-pencil"></i>
                    </router-link>
                    <router-link :to="{ name: 'follows' }" id="dashboard-btn">
                      <i class="bx bx-trash"></i>
                    </router-link>
                  </div>
                </div>
              </div>
            </router-link>
          </div>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
import { mapState, mapActions } from 'vuex';
export default {
  name: "PostsList",
  components: {},
  computed: {
    ...mapState('postModule', ['posts']),
  },
  methods: {
    movePage() {
      this.$router.push({ name: "PostCreate" });
    },
    ...mapActions('postModule', ['getPosts']),
    searchGroup(event) {
      // console.log(event.target.value);

      const len = this.posts.length;

      for (let i = 0; i < len; i++) {
        if (
          this.posts[i].title.includes(event.target.value) === false &&
          this.posts[i].content.includes(event.target.value) === false &&
          this.posts[i].nickname.includes(event.target.value) === false
        ) {
          document.querySelectorAll(".group-item")[i].style.display = "none";
        } else {
          document.querySelectorAll(".group-item")[i].style.display = "flex";
        }
      }
    },
  },
  created() {
    this.getPosts();
  }
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
* {
  /* border:solid 1px; */
}

.group-item {
  display: flex;
  flex-direction: column;
  /* border: solid 1px; */
}

.dashboard-container {
  display: flex;
  flex-direction: column;
  box-shadow: 0 0 1rem rgb(190, 190, 190);
  background-color: var(--box-bg-color);
  padding: 1.5rem;
  width: 90vw;
  height: 84vh;
}

.dashboard-container-content {
  display: flex;
  flex-direction: column;
  height: 90%;
}

.dashboard-container-header {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  color: var(--font-color-2);
}

#newPost {
  background-color: #2388f5;
  padding-left: 2rem;
  padding-right: 2rem;
}

#newPost:hover {
  background-color: #1056a1;
}

.dashboard-container-content-buttons {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

.line {
  width: 100%;
  margin: 1rem 0 1rem 0;
}

.dashboard-content {
  /* border: solid 1px; */
  display: flex;
  flex-direction: column;
  min-width: 50rem;
  border-radius: 0.1rem;
  width: stretch;
  height: stretch;
  overflow: auto;
  padding: 0.3rem;
  margin-top: 1rem;
}

.dashboard-content-post {
  display: flex;
  flex-direction: column;
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

.dashboard-content-post {
  /* border: solid 1px; */
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  color: var(--font-color-2);
  margin: 0 0 2rem 0;
  padding: 1rem;
  box-shadow: 0 0 5px rgb(185, 185, 185);
  border-radius: 2px;
  height: 10rem;
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

.dashboard-content-post-content {
  /* border: solid 1px pink; */
  width: 100%;
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
  text-align: left;
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
</style>
