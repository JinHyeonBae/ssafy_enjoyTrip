<script setup>
import { ref, watch } from "vue";
import { useRoute, useRouter } from "vue-router";
import { registComment } from "@/api/comment";
import { storeToRefs } from "pinia";
import { useMemberStore } from "@/stores/member";

// getModifyArticle, modifyArticle
const { articleno } = defineProps(["articleno"]);
const router = useRouter();
// const route = useRoute();

const memberStore = useMemberStore();
const { isLogin, userInfo } = storeToRefs(memberStore);
console.log("isLogin:", isLogin.value);
const isUseId = ref(false);

const comment = ref({
  articleNo: articleno,
  content: "",
  userId: "익명",
});
if (isLogin.value) {
  console.log(userInfo.value.userId);
  comment.value.userId = userInfo.value.userId;
}

function moveList() {
  router.push({ name: "article-list" });
}
const contentErrMsg = ref("");

watch(
  () => comment.value.content,
  (value) => {
    let len = value.length;
    if (len == 0 || len > 500) {
      contentErrMsg.value = "내용을 확인해 주세요!!!";
    } else contentErrMsg.value = "";
  },
  { immediate: true }
);

function writeComment() {
  console.log("글등록하자!!", comment.value);
  if (contentErrMsg.value) {
    alert(contentErrMsg.value);
  } else {
    registComment(
      comment.value,
      (response) => {
        console.log(response);
        let msg = "글등록 처리시 문제 발생했습니다.";
        if (response.status == 200) msg = "글등록이 완료되었습니다.";
        alert(msg);
        router.go();
      },
      (error) => console.log(error)
    );
  }
}
</script>

<template>
  <!-- <div class="mb-3">
		<label for="userid" class="form-label">작성자 ID : </label>
		<input
			type="text"
			class="form-control"
			v-model="comment.userId"
			:disabled="isUseId"
			placeholder="작성자ID..."
		/>
	</div> -->

  <div
    class="row mb-3 w-100 d-flex justify-content-end p-0"
    style="height: 100px"
  >
    <textarea
      class="col form-control h-100"
      v-model="comment.content"
      rows="3"
      placeholder="댓글 작성하기"
    ></textarea>
    <button
      type="button"
      class="col-auto btn btn-outline-primary mb-3 h-100"
      @click="writeComment"
    >
      글작성
    </button>
  </div>
  <div class="col-auto text-center mx-auto">
    <button
      type="button"
      class="btn btn-outline-primary mx-auto"
      @click="moveList"
    >
      글목록
    </button>
  </div>
</template>

<style scoped></style>
