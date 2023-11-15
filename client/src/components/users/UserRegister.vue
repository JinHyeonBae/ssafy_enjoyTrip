<script setup></script>

<template>
	<div
		class="container my-5 d-flex w-100 align-items-center justify-content-center"
		style="height: 50vh"
	>
		<form>
			<div class="mb-3">
				<label for="username" class="form-label d-flex flex-row">이름</label>
				<input type="text" class="form-control bg-body-tertiary" />
			</div>
			<div class="mb-3">
				<label for="userid" class="form-label d-flex flex-row">아이디</label>
				<input type="text" class="form-control bg-body-tertiary" />
			</div>
			<div class="mb-3">
				<label for="userpwd" class="form-label d-flex flex-row">비밀번호</label>
				<input type="text" class="form-control bg-body-tertiary" />
			</div>
			<div class="mb-3">
				<label for="pwdcheck" class="form-label d-flex flex-row">비밀번호확인</label>
				<input type="text" class="form-control bg-body-tertiary" id="pwdcheck" />
			</div>
			<div class="mb-3">
				<label for="emailid" class="form-label d-flex flex-row">이메일</label>
				<div class="input-group">
					<input type="text" class="form-control bg-body-tertiary" />
					<span class="input-group-text bg-white">@</span>
					<select class="form-select bg-body-tertiary" aria-label="이메일 도메인 선택">
						<option selected>선택</option>
						<option value="ssafy.com">싸피</option>
						<option value="google.com">구글</option>
						<option value="naver.com">네이버</option>
						<option value="kakao.com">카카오</option>
					</select>
				</div>
			</div>
			<div class="col-auto text-center">
				<button type="button" class="btn btn-primary w-100">회원가입</button>
			</div>
		</form>
	</div>
</template>

<style scoped></style>
