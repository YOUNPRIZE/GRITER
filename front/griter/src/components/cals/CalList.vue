<template>
  <main>
    <div class="calendar-container">
      <div id="calendar-title">
        <h3>Calendar</h3>

        <router-link :to="{ name: 'RoutinesDetail' }">
          <button>Detail</button>
        </router-link>
        <router-link :to="{ name: 'DietsCreate' }">
          <button>DietCreate</button>
        </router-link>
        <router-link :to="{ name: 'RoutinesCreate' }">
          <box-icon type="solid" name="plus-square"></box-icon>
        </router-link>
      </div>
      <v-calendar is-expanded class="custom-calendar max-w-full" :masks="masks" :attributes="attributes"
        disable-page-swipe>
        <template v-slot:day-content="{ day, attributes }">
          <div class="flex flex-col h-full z-10 overflow-hidden">
            <span class="day-label text-sm text-gray-900">{{ day.day }}</span>
            <div class="flex-grow overflow-y-auto overflow-x-auto">
              <p v-for="attr in attributes" :key="attr.key"
                class="text-xs leading-tight rounded-sm p-1 mt-0 mb-1">{{
                  attr.title }}
              </p>
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
export default {
  data() {
    // const month = new Date().getMonth();
    // const year = new Date().getFullYear();
    return {
      masks: {
        weekdays: "WWW"
      },
      attributes: [
        // {
        //   key: 1,
        //   customData: {
        //     title: "점심약속",
        //     class: "bg-red-600 text-black"
        //   },
        //   dates: new Date(year, month, 1)
        // },
        // {
        //   key: 2,
        //   customData: {
        //     title: "약속",
        //     class: "bg-red-600 text-black"
        //   },
        //   dates: new Date(year, month, 15)
        // }
      ]
    };
  },
  computed: {
    ...mapState("userModule", ["loginUser"]),
    ...mapState("routineModule", ["routines"])
  },
  mounted() {
    const tempRoutines = JSON.stringify(this.routines);
    console.log(tempRoutines);
  },
  methods: {
    ...mapActions("userModule", ["getLoginUser"]),
    ...mapActions("routineModule", ["getUserRoutines"]),
    addItemToAttributes(date) {
      this.attributes[0]["dates"].push(date);
    }
  },
  created() {
const user_id = localStorage.getItem("loginUser");
    // dispatch 역할
    this.getLoginUser(user_id);
    // 로그인하고 1회만 새로고침
    // console.log(self.name);
    if (self.name != "reload") {
      self.name = "reload";
      self.location.reload(true);
    } else self.name = "";

    this.getUserRoutines(user_id);

    const len = this.routines.length;
    for (let i = 0; i < len; i++) {
      // this.attributes[0]["dates"].push(new Date(this.routines[i].date + 9 * 60 * 60 * 1000).toUTCString());
      this.attributes.push({"key" : i, "title" : this.routines[i].exercise , "dates" : new Date(this.routines[i].date + 9 * 60 * 60 * 1000)});
    }
  },
}
</script>

<style scoped>
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

#calendar-title {
  /* border: solid green; */
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  padding: 1rem;
  padding-bottom: 1rem;
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
}</style>