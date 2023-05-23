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
              <p v-for="attr in attributes" :key="attr.key" class="text-xs leading-tight rounded-sm p-1 mt-0 mb-1">{{
                attr.customData.title }}</p>
            </div>
          </div>
        </template>
      </v-calendar>
    </div>
  </main>
</template>

<script>
export default {
  data() {
    const month = new Date().getMonth();
    const year = new Date().getFullYear();
    return {
      masks: {
        weekdays: "WWW"
      },
      attributes: [
        {
          key: 1,
          customData: {
            title: "점심약속",
            class: "bg-red-600 text-black"
          },
          dates: new Date(year, month, 1)
        },
        {
          key: 2,
          customData: {
            title: "약속",
            class: "bg-red-600 text-black"
          },
          dates: new Date(year, month, 15)
        }
      ]
    };
  },
  methods: {}
};
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

.vc-container :nth-child(2) :nth-child(1) :nth-child(1) :nth-child(2) :nth-child(1) {
  height: 5rem;
}
</style>



<style scoped lang="postcss">
::-webkit-scrollbar {
  width: 0px;
}

::-webkit-scrollbar-track {
  display: none;
}

/deep/ .custom-calendar.vc-container {
  --day-border: 1px solid #b8c2cc;
  --day-border-highlight: 1px solid #b8c2cc;
  --day-width: 90px;
  --day-height: 90px;
  --weekday-bg: #f8fafc;
  --weekday-border: 1px solid #eaeaea;

  border-radius: 0;
  width: 100%;

  & .vc-header {
    background-color: #f1f5f8;
    padding: 10px 0;
  }

  & .vc-weeks {
    padding: 0;
  }

  & .vc-weekday {
    background-color: var(--weekday-bg);
    border-bottom: var(--weekday-border);
    border-top: var(--weekday-border);
    padding: 5px 0;
  }

  & .vc-day {
    padding: 0 5px 3px 5px;
    text-align: left;
    height: var(--day-height);
    min-width: var(--day-width);
    background-color: white;

    &.weekday-1,
    &.weekday-7 {
      background-color: #eff8ff;
    }

    &:not(.on-bottom) {
      border-bottom: var(--day-border);

      &.weekday-1 {
        border-bottom: var(--day-border-highlight);
      }
    }

    &:not(.on-right) {
      border-right: var(--day-border);
    }
  }

  & .vc-day-dots {
    margin-bottom: 5px;
  }
}
</style>
