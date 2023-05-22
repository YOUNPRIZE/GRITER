<template>
  <main>
    <div class="dashboard-container">
      <v-calendar is-expanded />
    </div>
  </main>
</template>

<script>

export default {
  // name: "PostsList",
  // data() {

  //   const month = new Date().getMonth();
  //   const year = new Date().getFullYear();
  //   return {
  //     masks: {
  //       weekdays: 'WWW',
  //     },
  //     attributes: [
  //       {
  //         key: 1,
  //         customData: {
  //           title: 'Lunch with mom.',
  //           class: 'bg-red-600 text-white',
  //         },
  //         dates: new Date(year, month, 1),
  //       },
  //       {
  //         key: 2,
  //         customData: {
  //           title: 'Take Noah to basketball practice',
  //           class: 'bg-blue-500 text-white',
  //         },
  //         dates: new Date(year, month, 2),
  //       },
  //       {
  //         key: 3,
  //         customData: {
  //           title: "Noah's basketball game.",
  //           class: 'bg-blue-500 text-white',
  //         },
  //         dates: new Date(year, month, 5),
  //       },
  //       {
  //         key: 4,
  //         customData: {
  //           title: 'Take car to the shop',
  //           class: 'bg-indigo-500 text-white',
  //         },
  //         dates: new Date(year, month, 5),
  //       },
  //       {
  //         key: 4,
  //         customData: {
  //           title: 'Meeting with new client.',
  //           class: 'bg-teal-500 text-white',
  //         },
  //         dates: new Date(year, month, 7),
  //       },
  //       {
  //         key: 5,
  //         customData: {
  //           title: "Mia's gymnastics practice.",
  //           class: 'bg-pink-500 text-white',
  //         },
  //         dates: new Date(year, month, 11),
  //       },
  //       {
  //         key: 6,
  //         customData: {
  //           title: 'Cookout with friends.',
  //           class: 'bg-orange-500 text-white',
  //         },
  //         dates: { months: 5, ordinalWeekdays: { 2: 1 } },
  //       },
  //       {
  //         key: 7,
  //         customData: {
  //           title: "Mia's gymnastics recital.",
  //           class: 'bg-pink-500 text-white',
  //         },
  //         dates: new Date(year, month, 22),
  //       },
  //       {
  //         key: 8,
  //         customData: {
  //           title: 'Visit great grandma.',
  //           class: 'bg-red-600 text-white',
  //         },
  //         dates: new Date(year, month, 25),
  //       },
  //     ],
  //   };
  // },
  components: {},
  methods: {}
};
</script>

<style>
.search-form {
  /* border: solid red; */
  display: flex;
  flex-direction: column;
  height: 3rem;
}
</style>

<style scoped>
.dashboard-container {
  display: flex;
  flex-direction: column;
  box-shadow: 0 0 1rem rgb(190, 190, 190);
  background-color: var(--box-bg-color);
  padding: 1.5rem;
  width: 90vw;
  height: 84vh;
}
.vc-container :nth-child(2) :nth-child(1) :nth-child(1) :nth-child(2) :nth-child(1) {
  height: 5rem;
}
</style>

