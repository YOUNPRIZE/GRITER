<template>
  <main>
    <div class="followers">
      <div class="follows-header">
        <span class="followers-logo">Followers</span>
        <form action="" class="search-form">
          <div class="input-group mb-3">
            <span class="input-group-text"><box-icon name="search"></box-icon></span>
            <input
              class="form-control"
              id="search"
              type="text"
              placeholder="Search"
              @input="searchGroup1($event)"
            />
          </div>
        </form>
      </div>
      <div class="line"></div>
      <div class="followers-head">
        <span>Img</span>
        <span>Name</span>
        <span>ID</span>
        <span>Email</span>
      </div>
      <div class="line" style="height: 0.2rem; margin-bottom: 0"></div>
      <div
        v-for="(follower, index) in followers"
        :key="index"
        class="group-item-1"
        id="followers-content"
      >
        <div id="followers-content-userInfo">
          <div class="followers-content-userInfo">
            <img src="" alt="" />
            <span>{{ follower.name }}</span>
            <span>{{ follower.nickname }}</span>
            <span>{{ follower.email }}</span>
          </div>
          <hr style="margin: 0; margin-top: 0.5rem" />
        </div>
      </div>
    </div>
    <div class="following">
      <div class="follows-header">
        <span class="following-logo">Following</span>
        <form action="" class="search-form">
          <div class="input-group mb-3">
            <span class="input-group-text"><box-icon name="search"></box-icon></span>
            <input
              class="form-control"
              id="search"
              type="text"
              placeholder="Search"
              @input="searchGroup2($event)"
            />
          </div>
        </form>
      </div>
      <div class="line"></div>
      <div class="following-head">
        <span>Img</span>
        <span>Name</span>
        <span>ID</span>
        <span>Email</span>
      </div>
      <div class="line" style="height: 0.2rem; margin-bottom: 0;"></div>
      <div class="following-content">
        <div
          v-for="(follow, index) in following"
          :key="index"
          class="group-item-2"
          id="following-content"
        >
          <div id="following-content-userInfo">
            <div class="following-content-userInfo">
              <img src="" alt="" />
              <span>{{ follow.name }}</span>
              <span>{{ follow.nickname }}</span>
              <span>{{ follow.email }}</span>
            </div>
            <hr style="margin: 0; margin-top: 0.5rem" />
          </div>
        </div>
      </div>
    </div>
  </main>
</template>
<script>
import { mapState, mapActions } from "vuex";

export default {
  computed: {
    ...mapState("followModule", ["followers", "following"]),
  },
  methods: {
    ...mapActions("followModule", ["callFollowers", "callFollowing"]),
    searchGroup1(event) {
      const len = this.followers.length;
      for (let i = 0; i < len; i++) {
        if (
          this.followers[i].name.includes(event.target.value) === false &&
          this.followers[i].nickname.includes(event.target.value) === false &&
          this.followers[i].email.includes(event.target.value) === false
        ) {
          document.querySelectorAll(".group-item-1")[i].style.display = "none";
        } else {
          document.querySelectorAll(".group-item-1")[i].style.display = "flex";
        }
      }
    },
    searchGroup2(event) {
      const len = this.following.length;
      for (let i = 0; i < len; i++) {
        if (
          this.following[i].name.includes(event.target.value) === false &&
          this.following[i].nickname.includes(event.target.value) === false &&
          this.following[i].email.includes(event.target.value) === false
        ) {
          document.querySelectorAll(".group-item-2")[i].style.display = "none";
        } else {
          document.querySelectorAll(".group-item-2")[i].style.display = "flex";
        }
      }
    },
  },
  created() {
    const id = localStorage.getItem("loginUser");
    console.log(id);
    this.callFollowers(id);
    this.callFollowing(id);
  },
};
</script>
<style scoped>
main {
  display: flex;
  flex-direction: row;
  /* border: solid green; */
}

.line {
  margin: 0.5rem 0 1rem 0;
}

.followers,
.following {
  display: flex;
  flex-direction: column;
  box-shadow: 0 0 1rem rgb(190, 190, 190);
  border-radius: 0.2rem;
  width: 50%;
  min-width: 40rem;
  margin: 2rem;
  padding: 2rem;
  background-color: var(--box-bg-color);
}

.follows-header {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  color: var(--font-color-2);
}

.followers-logo,
.following-logo {
  align-self: flex-start;
  font-size: x-large;
  font-weight: 500;
}

#followers-content,
#following-content {
  display: flex;
  flex-direction: column;
  overflow: auto;
}
#followers-content::-webkit-scrollbar,
#following-content::-webkit-scrollbar {
  width: 0.5rem;
}
#followers-content::-webkit-scrollbar-thumb,
#following-content::-webkit-scrollbar-thumb {
  background-color: rgb(190, 190, 190);
  border-radius: 10px;
  background-clip: padding-box;
  border: 2px solid transparent;
}

.followers-head,
.following-head,
.followers-content-userInfo,
.following-content-userInfo {
  /* border: solid 1px green; */
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}
.followers-head > span,
.following-head > span {
  /* border: solid 1px red; */
  font-weight: bold;
}

.followers-head > span:nth-child(1),
.following-head > span:nth-child(1),
.followers-content-userInfo > img,
.following-content-userInfo > img {
  width: 10%;
}
.followers-head > span:nth-child(2),
.following-head > span:nth-child(2),
.followers-content-userInfo > span:nth-child(2),
.following-content-userInfo > span:nth-child(2) {
  width: 23%;
}
.followers-head > span:nth-child(3),
.following-head > span:nth-child(3),
.followers-content-userInfo > span:nth-child(3),
.following-content-userInfo > span:nth-child(3) {
  width: 23%;
}
.followers-head > span:nth-child(4),
.following-head > span:nth-child(4),
.followers-content-userInfo > span:nth-child(4),
.following-content-userInfo > span:nth-child(4) {
  width: 44%;
}

#followers-content {
  /* border: solid 1px green; */
  display: flex;
  flex-direction: column;
}
.followers-content-userInfo,
.following-content-userInfo {
  /* padding: 1rem; */
  margin: 0.5rem 0 0.5rem 0;
  height: 3rem;
}
.followers-content-userInfo > *,
.following-content-userInfo > * {
  display: flex;
  flex-direction: column;
  justify-content: center;
}
</style>
