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
const isUseId = ref(false);

const comment = ref({
  articleNo: articleno,
  content: "",
  userId: "익명",
});
if (isLogin.value) {
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
  if (contentErrMsg.value) {
    alert(contentErrMsg.value);
  } else {
    registComment(
      comment.value,
      (response) => {
        console.log(response);
        let msg = "댓글등록 처리시 문제 발생했습니다.";
        if (response.status == 200) msg = "댓글등록이 완료되었습니다.";
        alert(msg);
        router.go();
      },
      (error) => console.log(error)
    );
  }
}
</script>

<template>
  <div class="d-flex justify-content-between p-0">
    <textarea
      class="form-control h-100"
      v-model="comment.content"
      rows="3"
      placeholder="댓글 작성하기"
    ></textarea>
    <button
      type="button"
      class="ms-1 btn btn-secondary h-100"
      @click="writeComment"
    >
      <svg
        xmlns="http://www.w3.org/2000/svg"
        width="16"
        height="16"
        fill="currentColor"
        class="bi bi-send-fill"
        viewBox="0 0 16 16"
      >
        <path
          d="M15.964.686a.5.5 0 0 0-.65-.65L.767 5.855H.766l-.452.18a.5.5 0 0 0-.082.887l.41.26.001.002 4.995 3.178 3.178 4.995.002.002.26.41a.5.5 0 0 0 .886-.083l6-15Zm-1.833 1.89L6.637 10.07l-.215-.338a.5.5 0 0 0-.154-.154l-.338-.215 7.494-7.494 1.178-.471-.47 1.178Z"
        />
      </svg>
    </button>
  </div>
  <div class="text-center mx-auto mt-4">
    <button
      type="button"
      class="btn btn-link mx-auto"
      style="text-decoration-line: none"
      @click="moveList"
    >
      글목록으로 돌아가기
      <svg
        xmlns="http://www.w3.org/2000/svg"
        width="16"
        height="16"
        fill="currentColor"
        class="bi bi-arrow-counterclockwise"
        viewBox="0 0 16 16"
      >
        <path
          fill-rule="evenodd"
          d="M8 3a5 5 0 1 1-4.546 2.914.5.5 0 0 0-.908-.417A6 6 0 1 0 8 2v1z"
        />
        <path
          d="M8 4.466V.534a.25.25 0 0 0-.41-.192L5.23 2.308a.25.25 0 0 0 0 .384l2.36 1.966A.25.25 0 0 0 8 4.466z"
        />
      </svg>
    </button>
  </div>
</template>

<style scoped></style>
