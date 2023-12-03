<script setup>
import { ref, watch } from "vue";
import { userCheckId, userJoin } from "@/api/user";
import { useRouter } from "vue-router";
const router = useRouter();
const user = ref({
	emailDomain: "",
	emailId: "",
	joinDate: "",
	refreshToken: "",
	userId: "",
	userName: "",
	userPwd: "",
});
const errorMemId = ref();
const errorMessage = ref("");
const checkIdValid = () => {
	// 아이디 형식 검사
	const validateId = /^[A-Za-z0-9]{4,12}$/;

	if (!validateId.test(user.value.userId) || !user.value.userId) {
		errorMemId.value = true;
		errorMessage.value = "영문 대소문자와 숫자 4~12자리로 입력해야합니다.";
		return;
	}
	errorMemId.value = false;
};

watch(
	() => user.value.userId,
	(newValue, oldValue) => {
		checkIdValid();
		if (!errorMemId.value) {
			userCheckId(
				user.value.userId,
				({ data }) => {
					//1이면 있는 아이디(아이디 중복) 0이면 없는 아이디
					if (data === 1) {
						errorMemId.value = true;
						errorMessage.value = "이미 사용 중인 아이디입니다.";
					}
				},
				(error) => console.log(error)
			);
		}
	},
	{ immediate: true }
);

const register = () => {
	console.log(user.value);
	userJoin(
		user.value,
		(response) => {
			let msg = "회원가입 처리시 문제가 발생했습니다.";
			if (response.status == 200) msg = "회원가입이 완료되었습니다.";
			alert(msg);
			router.push({ name: "user-login" });
		},
		(error) => console.log(error)
	);
};
</script>

<template>
	<div
		class="container my-5 d-flex w-100 align-items-center justify-content-center"
		style="height: 50vh"
	>
		<form @submit.prevent="onSubmit">
			<div class="mb-3">
				<label for="username" class="form-label d-flex flex-row">이름</label>
				<input type="text" class="form-control bg-body-tertiary" v-model="user.userName" />
			</div>
			<div class="mb-3">
				<label for="userid" class="form-label d-flex flex-row">아이디</label>
				<input type="text" class="form-control bg-body-tertiary" v-model="user.userId" />
				<small v-if="errorMemId" class="input-error text-danger">
					{{ errorMessage }}
				</small>
				<small v-else class="text-success">유효한 아이디 입니다.</small>
			</div>

			<div class="mb-3">
				<label for="userpwd" class="form-label d-flex flex-row">비밀번호</label>
				<input type="password" class="form-control bg-body-tertiary" v-model="user.userPwd" />
			</div>

			<div class="mb-3">
				<label for="emailid" class="form-label d-flex flex-row">이메일</label>
				<div class="input-group">
					<input type="text" class="form-control bg-body-tertiary" v-model="user.emailId" />
					<span class="input-group-text bg-white">@</span>
					<select
						v-model="user.emailDomain"
						class="form-select bg-body-tertiary"
						aria-label="이메일 도메인 선택"
					>
						<option selected>선택</option>
						<option value="ssafy.com">싸피</option>
						<option value="google.com">구글</option>
						<option value="naver.com">네이버</option>
						<option value="kakao.com">카카오</option>
					</select>
				</div>
			</div>
			<div class="col-auto text-center">
				<button type="button" class="btn btn-primary w-100" @click="register">회원가입</button>
			</div>
		</form>
	</div>
</template>

<style scoped></style>
