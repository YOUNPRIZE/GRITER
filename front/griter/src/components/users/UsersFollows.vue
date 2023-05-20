<template>
  <body>
    <div class="followers">
      <span class="followers-logo">Followers</span>
      <hr />
      <div class="followers-content">
        <div>asdf</div>
        <div>asdf</div>
        <div>asdf</div>
        <div>asfd</div>
        <div>asdf</div>
        <div>asdf</div>
        <div>asdf</div>
        <div>asfd</div>
        <div>asdf</div>
        <div>asdf</div>
        <div>asdf</div>
        <div>asfd</div>
        <div>asdf</div>
        <div>asdf</div>
        <div>asdf</div>
        <div>asfd</div>
        <div>asdf</div>
        <div>asdf</div>
        <div>asdf</div>
        <div>asfd</div>
        <div>asdf</div>
        <div>asdf</div>
        <div>asdf</div>
        <div>asfd</div>
        <div>asdf</div>
        <div>asdf</div>
        <div>asdf</div>
        <div>asfd</div>
        <div>asdf</div>
        <div>asdf</div>
        <div>asdf</div>
        <div>asfd</div>
        <div>asdf</div>
        <div>asdf</div>
        <div>asdf</div>
        <div>asfd</div>
        <div>asdf</div>
        <div>asdf</div>
        <div>asdf</div>
        <div>asfd</div>
      </div>
    </div>
    <div class="following">
      <span class="following-logo">Following</span>
      <hr />
      <div class="following-content">
        <div>asdf</div>
        <div>asdf</div>
        <div>asdf</div>
        <div>asfd</div>
        <div>asdf</div>
        <div>asdf</div>
        <div>asdf</div>
        <div>asfd</div>
        <div>asdf</div>
        <div>asdf</div>
        <div>asdf</div>
        <div>asfd</div>
        <div>asdf</div>
        <div>asdf</div>
        <div>asdf</div>
        <div>asfd</div>
        <div>asdf</div>
        <div>asdf</div>
        <div>asdf</div>
        <div>asfd</div>
        <div>asdf</div>
        <div>asdf</div>
        <div>asdf</div>
        <div>asfd</div>
        <div>asdf</div>
        <div>asdf</div>
        <div>asdf</div>
        <div>asfd</div>
        <div>asdf</div>
        <div>asdf</div>
        <div>asdf</div>
        <div>asfd</div>
        <div>asdf</div>
        <div>asdf</div>
        <div>asdf</div>
        <div>asfd</div>
        <div>asdf</div>
        <div>asdf</div>
        <div>asdf</div>
        <div>asfd</div>
      </div>
    </div>
  </body>
</template>
<script>
export default {};
</script>
<style scoped>
body {
  display: flex;
  flex-direction: row;
  /* border: solid green; */
}

.followers,
.following {
  display: flex;
  flex-direction: column;
  box-shadow: 0 0 1rem rgb(190, 190, 190);
  border-radius: 0.3rem;
  width: 50%;
  min-width: 30rem;
  margin: 2rem;
  padding: 2rem;
  background-color: white;
}

.followers-logo,
.following-logo {
  font-size: xx-large;
  font-weight: 500;
  color: #2388f5;
}

.followers-content,
.following-content {
  display: flex;
  flex-direction: column;
  overflow: auto;
}
.followers-content::-webkit-scrollbar,
.following-content::-webkit-scrollbar {
  width: 0.5rem;
}
.followers-content::-webkit-scrollbar-thumb,
.following-content::-webkit-scrollbar-thumb {
  background-color: rgb(190, 190, 190);
  border-radius: 10px;
  background-clip: padding-box;
  border: 2px solid transparent;
}
</style>
