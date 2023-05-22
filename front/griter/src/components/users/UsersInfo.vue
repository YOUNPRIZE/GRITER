<template>
  <main>
    <div class="userinfo">
      <div class="userinfo-header">
        <span>User Information</span>
        <router-link to="/">
          <i class="bx bxs-edit" id="edit-btn"></i>
        </router-link>
      </div>
      <div class="line"></div>
      <div class="userinfo-content">
        <img src="" alt="" style="height: 15rem; width: 15rem; border: solid 1px red; border-radius: 100%" />
        <div class="userinfo-content-info">
          <div class="userinfo-content-info-item">
            <span>Name</span>
            <span>{{ this.loginUser.name }}</span>
          </div>
          <div class="userinfo-content-info-item">
            <span>ID</span>
            <span>{{ loginUser.nickname }}</span>
          </div>
          <div class="userinfo-content-info-item">
            <span>Email</span>
            <span>{{ loginUser.email }}</span>
          </div>
          <div class="userinfo-content-info-item">
            <span>Gender</span>
            <span>{{ loginUser.gender }}</span>
          </div>
        </div>
      </div>
      <div class="line"></div>
      <div class="introduce">
        <span>About Me</span>
        <!-- 글자수 제한 걸어야 됨 -->
        <div class="introduce-content">
          sdfgsdfgdsfffffsdfgsdfgdsfgsdgsdfgsdfgsdfgsdfgdsfffffsdfgsdfgdsfgsdgsdfgsdfgsdfgsdfgdsfffffsdfgsdfgdsfgsdgsdfgsdfgsdfgsdfgdsfffffsdfgsdfgdsfgsdgsdfgsdfgsdfgsdfgdsfffffsdfgsdfgdsfgsdgsdfgsdfgsdfgsdfgdsfffffsdfgsdfgdsfgsdgsdfgsdfgsdfgsdfgdsfffffsdfgsdfgdsfgsdgsdfgsdfgsdfgsdfgdsfffffsdfgsd
          fgdsfgsdgsdfgsdfgsdfgsdfgdsfffffsdfgsdfgdsfgsdgsdfgsdfgsdfgsdfgdsfffffsdfgs
          dfgdsfgsdgsdfgsdfg
        </div>
      </div>
    </div>
    <div class="myPost">
      <span>My Post</span>
      <div class="line"></div>
      <div class="myPost-content">
        <!-- link 좌표 바꿔야 됨 상세보기로, params도 받아와야 함-->
        <router-link :to="{ name: 'PostsDetail', params: { post_id } }">
          <div class="myPost-content-post">
            <div class="myPost-content-post-left">
              <div class="myPost-content-post-title">
                <span>제목 젬고 제목</span>
              </div>
              <div class="myPost-content-post-writerInfo">
                <img src="" alt="" style="
                      width: 30px;
                      height: 30px;
                      border-radius: 100%;
                      border: solid 1px red;
                    " />
                <span class="myPost-content-post-writer">catbirdseat</span>
              </div>
            </div>
            <div class="myPost-content-post-right">
              <span class="myPost-content-post-created">December, 23, 2022</span>
              <div class="myPost-content-post-btn">
                <!-- link to 는 기능 확인을 위해 임시로 걸어놓은 것 수정해야됨 -->
                <router-link :to="{ name: 'login' }" id="myPost-btn">
                  <i class="bx bx-pencil"></i>
                </router-link>
                <router-link :to="{ name: 'follows' }" id="myPost-btn">
                  <i class="bx bx-trash"></i>
                </router-link>
              </div>
            </div>
          </div>
        </router-link>
        <!-- 아래는 다 지워야 됨-->
        <div class="myPost-content-post">
          <div class="myPost-content-post-left">
            <div class="myPost-content-post-title">
              <span>제목 젬고 제목</span>
            </div>
            <div class="myPost-content-post-writerInfo">
              <img src="" alt="" style="
                    width: 30px;
                    height: 30px;
                    border-radius: 100%;
                    border: solid 1px red;
                  " />
              <span class="myPost-content-post-writer">catbirdseat</span>
            </div>
          </div>
          <div class="myPost-content-post-right">
            <span class="myPost-content-post-created">December, 23, 2022</span>
          </div>
        </div>
        <div class="myPost-content-post">
          <div class="myPost-content-post-left">
            <div class="myPost-content-post-title">
              <span>제목 젬고 제목</span>
            </div>
            <div class="myPost-content-post-writerInfo">
              <img src="" alt="" style="
                    width: 30px;
                    height: 30px;
                    border-radius: 100%;
                    border: solid 1px red;
                  " />
              <span class="myPost-content-post-writer">catbirdseat</span>
            </div>
          </div>
          <div class="myPost-content-post-right">
            <span class="myPost-content-post-created">December, 23, 2022</span>
          </div>
        </div>
        <div class="myPost-content-post">
          <div class="myPost-content-post-left">
            <div class="myPost-content-post-title">
              <span>제목 젬고 제목</span>
            </div>
            <div class="myPost-content-post-writerInfo">
              <img src="" alt="" style="
                    width: 30px;
                    height: 30px;
                    border-radius: 100%;
                    border: solid 1px red;
                  " />
              <span class="myPost-content-post-writer">catbirdseat</span>
            </div>
          </div>
          <div class="myPost-content-post-right">
            <span class="myPost-content-post-created">December, 23, 2022</span>
          </div>
        </div>
        <div class="myPost-content-post">
          <div class="myPost-content-post-left">
            <div class="myPost-content-post-title">
              <span>제목 젬고 제목</span>
            </div>
            <div class="myPost-content-post-writerInfo">
              <img src="" alt="" style="
                    width: 30px;
                    height: 30px;
                    border-radius: 100%;
                    border: solid 1px red;
                  " />
              <span class="myPost-content-post-writer">catbirdseat</span>
            </div>
          </div>
          <div class="myPost-content-post-right">
            <span class="myPost-content-post-created">December, 23, 2022</span>
          </div>
        </div>
        <div class="myPost-content-post">
          <div class="myPost-content-post-left">
            <div class="myPost-content-post-title">
              <span>제목 젬고 제목</span>
            </div>
            <div class="myPost-content-post-writerInfo">
              <img src="" alt="" style="
                    width: 30px;
                    height: 30px;
                    border-radius: 100%;
                    border: solid 1px red;
                  " />
              <span class="myPost-content-post-writer">catbirdseat</span>
            </div>
          </div>
          <div class="myPost-content-post-right">
            <span class="myPost-content-post-created">December, 23, 2022</span>
          </div>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "UserInfo",
  computed: {
    ...mapState('userModule', ["loginUser"]),
  },
  created() {
    console.log(this.loginUser);
  },
  data() {
    return {
      postId: "asdf",
    };
  },
};
</script>

<style scoped>
* {
  /* border: solid; */
}

main {
  display: flex;
  flex-direction: row;
}

.userinfo,
.myPost {
  /* border: solid 1px red; */
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  padding: 2rem;
  box-shadow: 0 0 1rem rgb(177, 177, 177);
  height: 85vh;
  width: 40vw;
  min-width: 50rem;
  margin: 2rem;
  margin-top: 0rem;
  background-color: var(--box-bg-color);
}

.myPost {
  padding-bottom: 0;
}

.userinfo-header,
.myPost>span:nth-child(1) {
  font-size: x-large;
  font-weight: 600;
  margin-bottom: 1rem;
  color: var(--font-color-2);
}

.userinfo-header {
  /* border: solid; */
  display: flex;
  flex-direction: row;
  width: stretch;
  justify-content: space-between;
  align-items: center;
}

#edit-btn {
  color: grey;
}

.userinfo-content {
  /* border: solid 1px green; */
  display: flex;
  flex-direction: row;
  align-items: center;
  width: 100%;
  justify-content: space-around;
  margin: 1.5rem 0 1.5rem 0;
}

.userinfo-content-info {
  /* border: solid 1px orange; */
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  height: 80%;
  width: 20rem;
}

.userinfo-content-info-item {
  /* border: solid 1px black; */
  display: flex;
  flex-direction: row;
}

.userinfo-content-info-item>span:nth-child(1) {
  /* border: solid 1px red; */
  font-weight: bold;
  width: 40%;
  text-align: left;
}

.userinfo-content-info-item>span:nth-child(2) {
  /* border: solid 1px green; */
  margin-left: 2rem;
  width: 100%;
  text-align: left;
}

.introduce {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  margin: 2rem 0 2rem 0;
  width: 100%;
  height: 100%;
}

.introduce>span:nth-child(1) {
  font-size: large;
  font-weight: bold;
}

.introduce-content {
  display: flex;
  border: solid 0.1rem rgb(178, 178, 178);
  border-radius: 0.2rem;
  padding: 0.5rem;
  text-align: left;
  word-break: break-all;
  word-wrap: break-word;
  width: 100%;
  /* 아래 두개 같은 역할 하는듯*/
  /* flex: 1 1 auto; */
  height: stretch;
}

.myPost-content {
  /* border: solid; */
  display: flex;
  flex-direction: column;
  min-width: 30rem;
  border-radius: 0.1rem;
  width: 100%;
  height: stretch;
  overflow: auto;
}

.myPost-content-post {
  display: flex;
  flex-direction: column;
  padding-bottom: 2rem;
}

.myPost-content::-webkit-scrollbar,
.myPost-content::-webkit-scrollbar {
  width: 0.5rem;
}

.myPost-content::-webkit-scrollbar-thumb,
.myPost-content::-webkit-scrollbar-thumb {
  background-color: rgb(190, 190, 190);
  border-radius: 10px;
  background-clip: padding-box;
  border: 2px solid transparent;
}

.myPost-content-post {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  color: var(--font-color-2);
  margin: 2rem 2rem 0 2rem;
  padding: 1rem;
  box-shadow: 0 0 5px rgb(185, 185, 185);
  border-radius: 2px;
  height: 8rem;
}

.myPost-content-post-title {
  margin-bottom: 2rem;
}

.myPost-content-post-left {
  /* border: solid; */
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}

.myPost-content-post-right {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: flex-end;
}

#myPost-btn {
  margin: 0 0.5rem 0 0.5rem;
  color: grey;
}

.myPost-content-post-created {
  color: grey;
}

/* @media (prefers-color-scheme: dark){
  .userinfo{
    background-color: black;
  }
} */
</style>
