<template>
  <main>
    <div class="login-box">
      <div class="logo">GRITER</div>
      <form action="" class="register-form" enctype="multipart/form-data">
        <div class="register-form-input">
          <div class="label">Name</div>
          <input type="text" class="form-control" v-model="name" required />
          <div class="label">ID</div>
          <input type="text" class="form-control" v-model="nickname" required />
          <div class="label">Password</div>
          <input type="password" class="form-control" v-model="password" required />
          <div class="label">Email</div>
          <input type="email" class="form-control" v-model="email" required />
          <div class="label">Gender</div>
          <div class="gender-radiobox">
            <input
              type="radio"
              class="btn-check"
              name="options"
              id="option1"
              value="male"
              autocomplete="off"
              v-model="gender"
            />
            <label class="btn btn-outline-primary" for="option1" id="gender-select"
              >Male</label
            >
            <input
              type="radio"
              class="btn-check"
              name="options"
              id="option2"
              value="female"
              autocomplete="off"
              v-model="gender"
            />
            <label class="btn btn-outline-primary" for="option2" id="gender-select"
              >Female</label
            >
          </div>
          <div class="label">Profile Image</div>
          <input type="file" class="profileImage" @change="handleImageChange" />
        </div>
        <div class="buttons">
          <button class="btn btn-primary" id="submit-btn" @click="register">
            Submit
          </button>
          <button class="btn btn-outline-primary" @click="goToLogin" id="GoToLogIn-btn">
            Go To Log In
          </button>
        </div>
      </form>
    </div>
  </main>
</template>

<script>
import { mapActions, mapState } from "vuex";

export default {
  data() {
    return {
      name: "",
      nickname: "",
      password: "",
      email: "",
      gender: "",
      image: "",
      user_id: "",
    };
  },
  computed: {
    ...mapState("userModule", ["users"]),
  },
  methods: {
    ...mapActions("userModule", ["create", "getUsers"]),
    ...mapActions("imageModule", ["upload"]),
    handleImageChange() {
      const file = event.target.files[0];
      this.image = file;
      console.log(file);
    },
    goToLogin() {
      this.$router.push({ name: "login" });
    },
    register() {
      if (
        this.name.length > 0 &&
        this.nickname.length > 0 &&
        this.password.length > 0 &&
        this.email.length > 0 &&
        this.gender.length > 0
      ) {
        this.create({
          name: this.name,
          nickname: encodeURIComponent(this.nickname),
          password: this.password,
          email: this.email,
          gender: this.gender,
        });
        this.upload({
          nickname: encodeURIComponent(this.nickname),
          data: this.image,
        });
      } else {
        alert("필수값을 모두 입력해주세요.");
      }
    },
  },
};
</script>

<style scoped>
* {
  /* border: 1px solid #000; */
}

main {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.logo {
  color: #2388f5;
  font-size: 2rem;
  font-weight: bold;
}

.login-box {
  /* border: solid green; */
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  box-shadow: 0 0 1.5rem rgb(167, 167, 167);
  background-color: var(--box-bg-color);
  color: var(--font-color-2);
  padding: 4rem;
  height: 80vh;
  width: 35vw;
  min-width: 40rem;
}

.register-form {
  display: flex;
  flex-direction: column;
  width: 80%;
  margin-top: 1rem;
}

.register-form-input {
  /* border: solid red; */
  display: flex;
  flex-direction: column;
  align-items: left;
}

.label {
  display: flex;
  color: rgb(141, 141, 141);
}

input {
  margin-top: 1rem;
  margin-bottom: 1rem;
  border: none;
  border-bottom: solid 1px rgb(200, 200, 200);
  background-color: var(--input-bg-color);
}

.gender-radiobox {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}

.gender-radiobox > label {
  margin: 1rem;
  width: 10rem;
}

.buttons {
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
}

button {
  /* width: 10rem !important; */
  height: 2.5rem;
  margin: 2rem;
}
#gender-select {
  color: var(--font-color-3);
  border: solid 1px var(--font-color-3);
}

#submit-btn {
  box-shadow: 0 0 1rem rgb(141, 141, 141);
  background-color: #2388f5;
  border: none;
  width: 10rem !important;
}
#submit-btn:hover {
  background-color: #1b6fca;
}

#GoToLogIn-btn {
  border: solid 1px #2388f5;
  width: 10rem !important;
  color: var(--font-color-3);
}
#GoToLogIn-btn:hover {
  background-color: #2388f5;
}
</style>
