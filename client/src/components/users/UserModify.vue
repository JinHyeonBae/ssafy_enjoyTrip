<script setup>
import { ref, watch, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import { userGetInfo, userModify, userDelete } from "@/api/user";

const route = useRoute();
const router = useRouter();

const { userid } = route.params;

const user = ref({
  emailDomain: "",
  emailId: "",
  joinDate: "",
  refreshToken: "",
  userId: "",
  userName: "",
  userPwd: "",
});

const modify = () => {
  console.log("user:", user.value);
  userModify(
    user.value,
    (response) => {
      let msg = "회원 정보 수정시 문제가 발생했습니다.";
      if (response.status == 200) msg = "회원 정보 수정이 완료되었습니다.";
      alert(msg);
      router.go();
    },
    (error) => console.log(error)
  );
};

onMounted(() => {
  userGetInfo(
    userid,
    ({ data }) => {
      console.log(data);
      user.value = data;
    },
    (error) => {
      console.log(error);
    }
  );
});
</script>

<template>
  <div
    class="container my-5 d-flex w-100 align-items-center justify-content-center"
    style="height: 50vh"
  >
    <form @submit.prevent="onSubmit">
      <div class="mb-3">
        <label for="userid" class="form-label d-flex flex-row">아이디</label>
        <input
          type="text"
          class="form-control bg-body-secondary"
          v-model="user.userId"
          readonly
        />
      </div>
      <div class="mb-3">
        <label for="username" class="form-label d-flex flex-row">이름</label>
        <input
          type="text"
          class="form-control bg-body-tertiary"
          v-model="user.userName"
        />
      </div>

      <div class="mb-3">
        <label for="userpwd" class="form-label d-flex flex-row">비밀번호</label>
        <input
          type="password"
          class="form-control bg-body-tertiary fst-italic"
          v-model="user.userPwd"
          placeholder="새로운 비밀번호 입력"
        />
      </div>

      <div class="mb-3">
        <label for="emailid" class="form-label d-flex flex-row">이메일</label>
        <div class="input-group">
          <input
            type="text"
            class="form-control bg-body-tertiary"
            v-model="user.emailId"
          />
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
        <button type="button" class="btn btn-primary w-100" @click="modify">
          회원 정보 수정
        </button>
      </div>
    </form>
  </div>
</template>

<style scoped></style>
