<template>
  <main>
    <div class="diets">
      <label class="label-date" style="font-weight: bold;" for="date">날짜</label>
      <b-form-datepicker id="date" v-model="diet.date" class="mb-2"></b-form-datepicker>

      <b-form-group
        style="font-weight: bold; margin-top: 1.5rem;"
        id="type"
        label="식사 종류"
        label-for="diet-type"
      >
        <!-- <b-form-input id="input-2" v-model="form.name" placeholder="Enter name" required></b-form-input> -->
        <b-form-input id="diet-type" v-model="diet.meal" placeholder="ex) 간식, 저녁" required></b-form-input>
      </b-form-group>
      <b-form-group style="font-weight: bold;" id="kind" label="음식 종류" label-for="diet-kind">
        <b-form-input id="diet-kind" v-model="diet.kind" placeholder="ex) 닭가슴살, 고구마" required></b-form-input>
      </b-form-group>
      <b-form-group style="font-weight: bold;" id="gram" label="섭취량" label-for="diet-gram">
        <b-form-input id="diet-gram" v-model="diet.gram" placeholder="ex) 200 (g)"></b-form-input>
      </b-form-group>
      <b-form-group
        style="font-weight: bold;"
        id="calories"
        label="섭취 칼로리"
        label-for="diet-calories"
      >
        <b-form-input id="diet-calories" v-model="diet.calories" placeholder="ex) 513 (kcal)"></b-form-input>
      </b-form-group>

      <!-- <b-form-file v-model="file" class="mt-3" plain></b-form-file> -->
      <!-- 이미지 사용하면 주석 해제하기. -->

      <div class="buttons">
        <b-button class="register" variant="primary">등록</b-button>
        <router-link :to="{ name: 'calendar' }">
          <b-button class="cancle" variant="secondary">취소</b-button>
        </router-link>
      </div>
    </div>
  </main>
</template>

<script>
export default {
  data() {
    return {
      diet: {
        date: new Date(),
        meal: "",
        kind: "",
        gram: "",
        calories: ""
      }
      // file: null, // 이미지 사용하면 주석 해제 하기.
    };
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

.diets {
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
  margin-top: 8rem;
}

.buttons button {
  margin-left: 0.2rem;
}
</style>
  