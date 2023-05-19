<template>
	<div>
		<router-view @create-post="createPost" :posts="posts" />
	</div>
</template>

<script>
export default {
	name: "PostsView",
	data() {
		return {
			posts: [],
		};
	},
	methods: {
		createPost(){
			
		}
	}
}
</script>

<style></style>