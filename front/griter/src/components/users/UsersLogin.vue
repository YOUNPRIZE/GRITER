<template>
  <main>
    <div class="login-box">
      <div class="logo">GRITER</div>
      <form action="" class="login-form">
        <div class="login-form-input">
          <div class="label">ID</div>
          <!-- <input type="text" class="id" required/> -->
          <input type="text" class="id" v-model="user.nickname" required/>
          <div class="label">Password</div>
          <!-- <input type="password" class="password" required/> -->
          <input type="password" class="password" v-model="user.password" required/>
        </div>
        <div class="buttons">
          <button @click="login" class="btn btn-primary" id="login-btn">Login</button>
          <router-link to="register">
            <button class="btn btn-outline-primary" id="signUp-btn">Sign up</button>
          </router-link>
        </div>
      </form>
    </div>
  </main>
</template>

<script>
export default {
  name: "UsersLogin",
  data() {
    return {
      user : {
        nickname : "",
        password : "",
      }
    }
  },
  methods: {
    login(){
      this.$store.dispatch('userLogin', this.user)
      this.$router.push({name:''})
    }
  }
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
  background-color: #ffffff;
  padding: 4rem;
  height: 80vh;
  width: 35vw;
  min-width: 30rem;
}

.login-form {
  display: flex;
  flex-direction: column;
  width: 80%;
  margin-top: 5rem;
}

.login-form-input {
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
  margin-bottom: 3rem;
  border: none;
  border-bottom: solid 1px rgb(200, 200, 200);
}

.buttons {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

button {
  width: 10rem;
  height: 2.5rem;
  margin-bottom: 2rem;
}

#login-btn {
  box-shadow: 0 0 5px rgb(141, 141, 141);
  background-color: #2388f5;
}
#login-btn:hover{
  background-color: #1b6fca;
}

#signUp-btn{
  border: solid 1px #2388f5;
}
#signUp-btn:hover{
  background-color: #2388f5;
}
</style>
