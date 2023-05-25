<template>
  <main>
    <div class="routines">
      <label class="label-date" style="font-weight: bold;" for="date">운동 날짜</label>
      <b-form-datepicker id="date" v-model="specificRoutine.date" class="mb-2"></b-form-datepicker>

      <b-form-group
        style="font-weight: bold; margin-top: 1.5rem;"
        id="type"
        label="운동 부위 및 타입"
        label-for="routine-type"
      >
        <!-- <b-form-input id="input-2" v-model="form.name" placeholder="Enter name" required></b-form-input> -->
        <b-form-input
          type="text"
          id="routine-type"
          v-model="routine.type"
          placeholder="ex) 유산소, 하체"
          required
        ></b-form-input>
      </b-form-group>
      <b-form-group
        style="font-weight: bold;"
        id="workout"
        label="운동 종류"
        label-for="routine-workout"
      >
        <b-form-input
          type="text"
          id="routine-workout"
          v-model="specificRoutine.exercise"
          placeholder="ex) 런닝, 스쿼트"
          required
        ></b-form-input>
      </b-form-group>
      <b-form-group style="font-weight: bold;" id="time" label="운동 시간" label-for="routine-time">
        <b-form-input
          type="number"
          id="routine-time"
          v-model="routine.time"
          placeholder="ex) 60 (분)"
        ></b-form-input>
      </b-form-group>
      <b-form-group style="font-weight: bold;" id="sets" label="세트 수" label-for="routine-sets">
        <b-form-input
          type="number"
          id="routine-sets"
          v-model="routine.sets"
          placeholder="ex) 5 (세트)"
        ></b-form-input>
      </b-form-group>
      <b-form-group style="font-weight: bold;" id="reps" label="횟수" label-for="routine-reps">
        <b-form-input
          type="number"
          id="routine-reps"
          v-model="routine.reps"
          placeholder="ex) 5 (회)"
        ></b-form-input>
      </b-form-group>
      <b-form-group style="font-weight: bold;" id="weight" label="무게" label-for="routine-weight">
        <b-form-input
          type="number"
          id="routine-weight"
          v-model="routine.weight"
          placeholder="ex) 100 (KG)"
        ></b-form-input>
      </b-form-group>

      <div class="buttons">
        <b-button @click="updateRtn()" class="update" variant="primary">수정</b-button>
        <b-button @click="deleteRtn()" class="delete" variant="danger">삭제</b-button>
        <router-link :to="{ name: 'calendar' }">
          <b-button class="cancle" variant="secondary">취소</b-button>
        </router-link>
      </div>
    </div>
  </main>
</template>

<script>
import { mapState, mapActions } from "vuex";
export default {
  data() {
    return {
      // thisRoutine: {
      //   date: '',
      //   type: '',
      //   exercise: '',
      //   time: '',
      //   sets: '',
      //   reps: '',
      //   weight: '',
      // }
    };
  },
  computed: {
    // const routine_id = window.location.href.substring(window.location.href.lastIndexOf("/") + 1),
    ...mapState("routineModule", ["routine"]),
    specificRoutine() {
      return {
        date: new Date(this.routine.date),
        type: this.routine.type,
        exercise: this.routine.exercise,
        time: Number(this.routine.time),
        sets: Number(this.routine.sets),
        reps: Number(this.routine.reps),
        weight: Number(this.routine.weight),
        user_id: this.routine.user_id,
        routine_id: Number(
          window.location.href.substring(
            window.location.href.lastIndexOf("/") + 1
          )
        )
      };
    }
  },
  methods: {
    ...mapActions("routineModule", [
      "getRoutine",
      "updateRoutine",
      "deleteRoutine"
    ]),
    updateRtn() {
      this.updateRoutine(this.specificRoutine);
    },
    deleteRtn() {
      this.deleteRoutine(this.specificRoutine.routine_id);
    }
  },
  created() {
    const routine_id = window.location.href.substring(
      window.location.href.lastIndexOf("/") + 1
    );
    this.getRoutine(routine_id);
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
  overflow: auto;
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
  