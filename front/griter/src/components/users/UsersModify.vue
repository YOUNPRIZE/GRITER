<template>
  <main>
    <div class="users">
      <div>
        <b-avatar size="50px" class="centered-avatar"></b-avatar>
      </div>
      <b-form-group
        style="font-weight: bold; margin-top: 1.5rem;"
        id="userId"
        label="아이디"
        label-for="user-id"
      >
        <b-form-input readonly v-model="specificUser.nickname" type="text" id="user-id" required></b-form-input>
      </b-form-group>
      <b-form @submit.stop.prevent>
        <label style="font-weight: bold;" for="text-password">비밀번호</label>
        <b-form-input
          v-model="specificUser.password"
          type="password"
          id="text-password"
          aria-describedby="password-help-block"
        ></b-form-input>

        <label style="font-weight: bold;" for="text-password2">비밀번호 확인</label>
        <b-form-input
          v-model="specificUser.passwordConfirmation"
          type="password"
          id="text-password2"
          aria-describedby="password-help-block"
        ></b-form-input>
      </b-form>
      <div v-if="isPasswordMismatch" style="color: red; margin-top: -1rem;">비밀번호가 일치하지 않습니다.</div>
      <b-form-group style="font-weight: bold;" id="name" label="이름" label-for="user-name">
        <b-form-input v-model="specificUser.name" type="text" id="user-name" required></b-form-input>
      </b-form-group>
      <b-form-group style="font-weight: bold;" id="email" label="이메일" label-for="user-email">
        <b-form-input v-model="specificUser.email" type="email" id="user-email" required readonly></b-form-input>
      </b-form-group>
      <b-form-group style="font-weight: bold;" id="gender" label="성별" label-for="user-gender">
        <b-form-input v-model="specificUser.gender" type="text" id="user-gender" required></b-form-input>
      </b-form-group>

      <div class="buttons">
        <b-button @click="updateUsr" class="update" variant="primary">수정</b-button>
        <router-link :to="{ name: 'userInfo' }">
          <b-button class="cancle" variant="secondary">취소</b-button>
        </router-link>
      </div>
    </div>
  </main>
</template>

<script>
import { mapState, mapActions } from "vuex";
export default {
  name: "UserModify",
  data() {
    return {
      isPasswordMismatch: false
    };
  },
  computed: {
    ...mapState("userModule", ["loginUser"]),
    specificUser() {
      return {
        email: this.loginUser.email,
        gender: this.loginUser.gender,
        name: this.loginUser.name,
        nickname: this.loginUser.nickname,
        password: this.loginUser.password,
        passwordConfirmation: "",
        user_id: Number(this.loginUser.user_id)
      };
    }
  },
  methods: {
    ...mapActions("userModule", ["updateUser"]),
    updateUsr() {
      console.log("Asdfasdf");
      if (
        this.specificUser.passwordConfirmation === "" ||
        this.specificUser.password !== this.specificUser.passwordConfirmation
      ) {
        this.isPasswordMismatch = true;
        return;
      }
      this.updateUser(this.specificUser);
    }
  },
  created() {
  }
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

.users {
  /* display: flex;
  flex-direction: column; */
  text-align: left;
  box-shadow: 0 0 1rem rgb(190, 190, 190);
  border-radius: 0.2rem;
  width: 30%;
  min-width: 40rem;
  margin: 2rem;
  padding: 2rem;
  background-color: var(--box-bg-color);
  overflow: auto;
}

.form-control {
  margin-bottom: 1.5rem;
}

.buttons {
  text-align: right;
}

.avatar-container {
  display: flex;
  align-items: center;
}

.input-container {
  flex: 1;
  margin-left: 1.5rem;
}

.buttons {
  margin-top: 2rem;
}

.buttons button {
  margin-left: 0.2rem;
}
</style>
  