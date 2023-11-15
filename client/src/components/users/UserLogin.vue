<script setup>
import { ref } from "vue";
import { storeToRefs } from "pinia";
import { useRouter } from "vue-router";
import { useMemberStore } from "@/stores/member";
import { useMenuStore } from "@/stores/menu";

const router = useRouter();

const memberStore = useMemberStore();

const { isLogin } = storeToRefs(memberStore);
const { userLogin, getUserInfo } = memberStore;
const { changeMenuState } = useMenuStore();

const loginUser = ref({
	userId: "",
	userPwd: "",
});

const login = async () => {
	console.log("login ing!!!! !!!");
	await userLogin(loginUser.value);
	let token = sessionStorage.getItem("accessToken");
	console.log("111. ", token);
	console.log("isLogin: ", isLogin);
	if (isLogin) {
		console.log("로그인 성공아닌가???");
		getUserInfo(token);
		changeMenuState();
	}
	router.push("/");
};
</script>

<template>
	<div
		class="container my-5 d-flex w-100 align-items-center justify-content-center"
		style="height: 50vh"
	>
		<!-- <div>	<div class="row justify-content-center">
				<h2 class="my-3 py-3 shadow-sm bg-light text-center">로그인</h2>
			</div> -->

		<form class="w-25">
			<div class="form-check mb-3 float-end">
				<input class="form-check-input" type="checkbox" />
				<label class="form-check-label" for="saveid"> 아이디저장 </label>
			</div>
			<div class="mb-3 text-start">
				<label for="userid" class="form-label">아이디</label>
				<input
					type="text"
					class="form-control bg-body-tertiary"
					v-model="loginUser.userId"
					placeholder=""
				/>
			</div>
			<div class="mb-3 text-start">
				<label for="userpwd" class="form-label">비밀번호</label>
				<input
					type="password"
					class="form-control bg-body-tertiary"
					v-model="loginUser.userPwd"
					@keyup.enter="login"
					placeholder=""
				/>
			</div>
			<div class="col-auto text-center">
				<button type="button" class="btn btn-primary w-100" @click="login">로그인</button>
				<!-- <button type="button" class="btn btn-outline-success ms-1 mb-3">회원가입</button> -->
			</div>
			<div class="my-2">
				아직 회원이 아니세요?
				<router-link :to="{ name: 'user-join' }"> 회원가입하기 </router-link>
			</div>
		</form>
	</div>
</template>

<style scoped></style>
