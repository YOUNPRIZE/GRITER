<template>
	<body>
		<div class="dashboard-container">
			<div class="dashboard-container-header">
				<h5>DashBoard</h5>
				<form action="">
					<div class="mb-3">
						<label for="search" class="form-label"><box-icon name='search'></box-icon></label>
						<input class="form-control" id="search" type="text" placeholder="Search">
					</div>
				</form>
			</div>
			<hr>
			<div class="dashboard-container-content">
				<button class="btn btn-primary" id="newPost">New Post</button>
			</div>
		</div>
	</body>
</template>

<script>
export default {
	name: 'PostsList',
	components: {
	}
}
</script>

<style>
.dashboard-container {
	display: flex;
	flex-direction: column;
	box-shadow: 0 0 5px rgb(190, 190, 190);
	background-color: white;
	padding: 2rem;
	width: 90vw;
	height: 84vh;
}

.dashboard-container-header {
	display: flex;
	flex-direction: row;
	justify-content: space-between;
}

hr {
	margin: 1rem;
	margin-left: 0;
	margin-right: 0;
}

#newPost {
	background-color: #2388F5;
	padding-left: 2rem;
	padding-right: 2rem;
}


</style>
