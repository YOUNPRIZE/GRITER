<template>
  <main>
    <div class="routines">
      <label class="label-date" style="font-weight: bold;" for="date">운동 날짜</label>
      <b-form-datepicker id="date" v-model="date" class="mb-2"></b-form-datepicker>

      <b-form-group
        style="font-weight: bold; margin-top: 1.5rem;"
        class
        id="type"
        label="운동 부위 및 타입"
        label-for="routine-type"
      >
        <!-- <b-form-input id="input-2" v-model="form.name" placeholder="Enter name" required></b-form-input> -->
        <b-form-input id="routine-type" placeholder="ex) 유산소, 하체" required></b-form-input>
      </b-form-group>
      <b-form-group
        style="font-weight: bold;"
        id="workout"
        label="운동 종류"
        label-for="routine-workout"
      >
        <b-form-input id="routine-workout" placeholder="ex) 런닝, 스쿼트" required></b-form-input>
      </b-form-group>
      <b-form-group style="font-weight: bold;" id="time" label="운동 시간" label-for="routine-time">
        <b-form-input id="routine-time" placeholder="ex) 60 (분)"></b-form-input>
      </b-form-group>
      <b-form-group style="font-weight: bold;" id="sets" label="세트 수" label-for="routine-sets">
        <b-form-input id="routine-sets" placeholder="ex) 5 (세트)"></b-form-input>
      </b-form-group>
      <b-form-group style="font-weight: bold;" id="reps" label="횟수" label-for="routine-reps">
        <b-form-input id="routine-reps" placeholder="ex) 5 (회)"></b-form-input>
      </b-form-group>
      <b-form-group style="font-weight: bold;" id="weight" label="무게" label-for="routine-weight">
        <b-form-input id="routine-weight" placeholder="ex) 100 (KG)"></b-form-input>
      </b-form-group>

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
      date: new Date()
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

.routines {
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
}

.form-control {
  margin-bottom: 1.5rem;
}

.buttons {
  text-align: right;
}

.buttons button {
  margin-left: 0.2rem;
}
</style>
  