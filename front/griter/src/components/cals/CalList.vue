<template>
  <main>
    <div class="calendar-container">
      <div id="calendar-title">
        <h3>Calendar</h3>
        <div class="addButtons">
          <router-link :to="{ name: 'DietsCreate' }">
            <img src="../../assets/red35.png" />
            <span>Add Diets</span>
          </router-link>
          <router-link :to="{ name: 'RoutinesCreate' }">
            <img src="../../assets/blue35.png" />
            <span>Add Routines</span>
          </router-link>
        </div>
      </div>
      <v-calendar is-expanded class="is-dark custom-calendar max-w-full" id="cal" :masks="masks" :attributes="attributes"
        disable-page-swipe>
        <template v-slot:day-content="{ day, attributes }">
          <div class="flex flex-col h-full z-10 overflow-hidden">
            <span class="day-label text-sm text-gray-900">{{ day.day }}</span>
            <div class="flex-grow overflow-y-auto overflow-x-auto">
              <!-- <p
                @click="movetoRoutineDetail(attr.customData.id)"
                v-for="attr in attributes"
                :key="attr.key"
                class="text-xs leading-tight rounded-sm p-1 mt-0 mb-1"
                :class="attr.customData.class"
              >{{ attr.customData.title }}</p>-->
              <template v-for="attr in attributes">
                <p @click="movetoRoutineDetail(attr.customData.id)" :key="attr.key"
                  v-if="attr.customData.class === 'griter-workout'"
                  class="text-xs leading-tight rounded-sm p-1 mt-0 mb-1 griter-workout">{{ attr.customData.title }}</p>
                <p @click="movetoDietDetail(attr.customData.id)" :key="attr.key"
                  v-if="attr.customData.class === 'griter-diet'"
                  class="text-xs leading-tight rounded-sm p-1 mt-0 mb-1 griter-diet">{{ attr.customData.title }}</p>
              </template>
            </div>
          </div>
        </template>
      </v-calendar>
    </div>

    <!-- {{ attributes }} -->
  </main>
</template>

<script>
import { mapState, mapActions } from "vuex";
import router from "@/router";
export default {
  data() {
    return {
      masks: {
        weekdays: "WWW"
      },
      attributes: []
    };
  },
  computed: {
    ...mapState("userModule", ["loginUser"]),
    ...mapState("routineModule", ["routines"]),
    ...mapState("dietModule", ["diets"])
  },
  mounted() {
    const tempRoutines = JSON.stringify(this.routines);
    tempRoutines;
    const tempDiets = JSON.stringify(this.diets);
    tempDiets;
  },
  methods: {
    ...mapActions("userModule", ["getLoginUser"]),
    ...mapActions("routineModule", ["getUserRoutines"]),
    ...mapActions("dietModule", ["getUserDiets"]),
    movetoRoutineDetail(params) {
      router.push({ name: "RoutinesDetail", params: { routine_id: params } });
    },
    movetoDietDetail(params) {
      router.push({ name: "DietsDetail", params: { diet_id: params } });
    },
    updateData() {
      const user_id = localStorage.getItem("loginUser");

      setTimeout(() => {
        clearInterval(interval);
      }, "100");

      let interval = setInterval(() => {
        this.getLoginUser(user_id)
          .then(() => {
            // 로그인한 사용자 정보 가져오기 완료
            this.getUserRoutines(user_id);
          })
          .then(() => {
            // 사용자 루틴 정보 가져오기 완료
            const len = this.routines.length;
            for (let i = 1; i <= len; i++) {
              this.attributes.push({
                key: i,
                customData: {
                  title: this.routines[i - 1].exercise,
                  class: "griter-workout",
                  id: this.routines[i - 1].routine_id
                },
                dates: new Date(this.routines[i - 1].date)
              });
            }
            this.getUserDiets(user_id);
          })
          .then(() => {
            // 사용자 식단 정보 가져오기 완료
            const len2 = this.diets.length;
            for (
              let i = this.routines.length + 1;
              i <= this.routines.length + len2;
              i++
            ) {
              this.attributes.push({
                key: i,
                customData: {
                  title: this.diets[i - this.routines.length - 1].kind,
                  class: "griter-diet",
                  id: this.diets[i - this.routines.length - 1].diet_id
                },
                dates: new Date(this.diets[i - this.routines.length - 1].date)
              });
            }
          });
      }, "5");
    }
  },
  created() {
    this.updateData();
    // const user_id = localStorage.getItem("loginUser");
    // this.getLoginUser(user_id)
    //   .then(() => {
    //     // 로그인한 사용자 정보 가져오기 완료
    //     this.getUserRoutines(user_id);
    //   })
    //   .then(() => {
    //     // 사용자 루틴 정보 가져오기 완료
    //     const len = this.routines.length;
    //     for (let i = 1; i <= len; i++) {
    //       this.attributes.push({
    //         key: i,
    //         customData: {
    //           title: this.routines[i - 1].exercise,
    //           class: "griter-workout",
    //           id: this.routines[i - 1].routine_id
    //         },
    //         dates: new Date(this.routines[i - 1].date)
    //       });
    //     }
    //     this.getUserDiets(user_id);
    //   })
    //   .then(() => {
    //     // 사용자 식단 정보 가져오기 완료
    //     const len2 = this.diets.length;
    //     for (
    //       let i = this.routines.length + 1;
    //       i <= this.routines.length + len2;
    //       i++
    //     ) {
    //       this.attributes.push({
    //         key: i,
    //         customData: {
    //           title: this.diets[i - this.routines.length - 1].kind,
    //           class: "griter-diet",
    //           id: this.diets[i - this.routines.length - 1].diet_id
    //         },
    //         dates: new Date(this.diets[i - this.routines.length - 1].date)
    //       });
    //     }
    //   });
  }
};
</script>

<style scoped>

.addButtons{
  display: flex;
  flex-direction: column;
  text-align: left;
  /* color: black; */
}
.addButtons span {
  color: black;
  margin-left: 0.5rem;
}
.calendar-container {
  display: flex;
  flex-direction: column;
  box-shadow: 0 0 1rem rgb(190, 190, 190);
  background-color: var(--box-bg-color);
  padding: 1.5rem;
  width: 90vw;
  overflow: auto;
  height: 84vh;
}

p.griter-workout {
  background-color: #2388f5;
  color: white;
}

p.griter-diet {
  background-color: #fa5252;
  color: white;
}

#calendar-title {
  /* border: solid green; */
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  /* padding: 1rem; */
  padding-left: 1rem;
  padding-right: 1rem;
  padding-bottom: 1rem;
}

/* Add the dark mode styles */
.custom-calendar.is-dark .vc-container .vc-header {
  background-color: #1a202c;
  color: white;
}

.custom-calendar.is-dark .vc-container .vc-weekday {
  background-color: #2d3748;
  color: white;
}

.custom-calendar.is-dark .vc-container .vc-day {
  background-color: #2d3748;
  color: white;
}

.custom-calendar.is-dark .vc-container .vc-day.weekday-1,
.custom-calendar.is-dark .vc-container .vc-day.weekday-7 {
  background-color: #4a5568;
}

.custom-calendar.is-dark .vc-container .vc-day-dots {
  /* Custom dark mode day dots styles... */
}
</style>

<style>
.scrollbar {
  width: 0px;
}

.scrollbar-track {
  display: none;
}

.custom-calendar.vc-container {
  border-radius: 0;
  width: 100%;
}

.custom-calendar.vc-container .vc-header {
  background-color: #f1f5f8;
  padding: 10px 0;
}

.custom-calendar.vc-container .vc-weeks {
  padding: 0;
}

.custom-calendar.vc-container .vc-weekday {
  background-color: #f8fafc;
  border-bottom: 1px solid #eaeaea;
  border-top: 1px solid #eaeaea;
  padding: 5px 0;
}

.custom-calendar.vc-container .vc-day {
  padding: 0 5px 3px 5px;
  text-align: left;
  min-height: 90px;
  min-width: 90px;
  overflow: auto;
  background-color: white;
}

.custom-calendar.vc-container .vc-day.weekday-1,
.custom-calendar.vc-container .vc-day.weekday-7 {
  background-color: #eff8ff;
}

.custom-calendar.vc-container .vc-day:not(.on-bottom) {
  border-bottom: 1px solid #b8c2cc;
}

.custom-calendar.vc-container .vc-day:not(.on-bottom).weekday-1 {
  border-bottom: 1px solid #b8c2cc;
}

.custom-calendar.vc-container .vc-day:not(.on-right) {
  border-right: 1px solid #b8c2cc;
}

.custom-calendar.vc-container .vc-day-dots {
  margin-bottom: 5px;
}
</style>