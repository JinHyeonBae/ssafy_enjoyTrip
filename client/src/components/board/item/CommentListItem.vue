<script setup>
import { useRoute, useRouter } from "vue-router";
import { ref, onMounted } from "vue";
import { deleteComment, modifyComment } from "@/api/comment";

import { storeToRefs } from "pinia";
import { useMemberStore } from "@/stores/member";
const memberStore = useMemberStore();
const { userInfo } = storeToRefs(memberStore);
const isShow = ref(false);

//자신이 단 댓글만 수정 및 삭제 가능하도록 하는 코드
const changeShow = () => {
  if (userInfo.value != null && userInfo.value.userId === comment.userId) {
    isShow.value = true;
  }
};

onMounted(() => {
  changeShow();
});

const { comment, articleno } = defineProps({
  comment: Object,
  articleno: String,
});
const { commentNo, userId } = comment;
const delcomment = ref({
  articleNo: articleno,
  commentNo: commentNo,
  userId: userId,
});

const router = useRouter();
const isModify = ref(false);
const inputValue = ref("");

function updateComment(commentno) {
  if (isModify.value == true) {
    const modifyContent = inputValue.value;
    modifyComment(
      {
        articleNo: Number(articleno),
        commentNo: comment.commentNo,
        content: modifyContent,
      },
      ({ data }) => {
        // console.log(data);
        router.go(0);
      },
      (error) => {
        console.log(error);
      }
    );
  }
  isModify.value = !isModify.value;
}

function onDeleteComment() {
  deleteComment(
    delcomment.value,
    (response) => {
      if (response.status == 200) router.go();
    },
    (error) => {
      console.log(error);
    }
  );
}
</script>

<template>
  <tr class="text-center">
    <td scope="row">
      <img
        class="avatar me-2 float-md-start bg-light p-2"
        src="https://raw.githubusercontent.com/twbs/icons/main/icons/person-fill.svg"
      />
    </td>
    <td>{{ comment.userId }}</td>
    <td v-if="isModify == false">
      {{ comment.content }}
    </td>
    <td v-else>
      <input v-model="inputValue" placeholder="수정할 내용을 입력해주세요" />
    </td>
    <td>{{ comment.registerTime }}</td>
    <td>
      <button
        v-if="isShow"
        type="button"
        class="btn btn-link text-secondary"
        @click="updateComment(comment.commentNo)"
      >
        <svg
          xmlns="http://www.w3.org/2000/svg"
          width="16"
          height="16"
          fill="currentColor"
          class="bi bi-gear-fill"
          viewBox="0 0 16 16"
        >
          <path
            d="M9.405 1.05c-.413-1.4-2.397-1.4-2.81 0l-.1.34a1.464 1.464 0 0 1-2.105.872l-.31-.17c-1.283-.698-2.686.705-1.987 1.987l.169.311c.446.82.023 1.841-.872 2.105l-.34.1c-1.4.413-1.4 2.397 0 2.81l.34.1a1.464 1.464 0 0 1 .872 2.105l-.17.31c-.698 1.283.705 2.686 1.987 1.987l.311-.169a1.464 1.464 0 0 1 2.105.872l.1.34c.413 1.4 2.397 1.4 2.81 0l.1-.34a1.464 1.464 0 0 1 2.105-.872l.31.17c1.283.698 2.686-.705 1.987-1.987l-.169-.311a1.464 1.464 0 0 1 .872-2.105l.34-.1c1.4-.413 1.4-2.397 0-2.81l-.34-.1a1.464 1.464 0 0 1-.872-2.105l.17-.31c.698-1.283-.705-2.686-1.987-1.987l-.311.169a1.464 1.464 0 0 1-2.105-.872l-.1-.34zM8 10.93a2.929 2.929 0 1 1 0-5.86 2.929 2.929 0 0 1 0 5.858z"
          />
        </svg>
      </button>
      <!-- 안보이는 버튼 -->
      <button v-else class="btn btn-light disabled"></button>
    </td>
    <td>
      <button
        v-if="isShow"
        type="button"
        class="btn btn-link text-danger p-0 m-0"
        @click="onDeleteComment"
      >
        <svg
          xmlns="http://www.w3.org/2000/svg"
          width="16"
          height="16"
          fill="currentColor"
          class="bi bi-dash-circle-fill p-0 m-0"
          viewBox="0 0 16 16"
        >
          <path
            d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM4.5 7.5a.5.5 0 0 0 0 1h7a.5.5 0 0 0 0-1h-7z"
          />
        </svg>
      </button>
      <!-- 안보이는 버튼 -->
      <button v-else class="btn btn-light disabled"></button>
    </td>
  </tr>
</template>

<style scoped>
a {
  text-decoration: none;
}
</style>

<style scoped>
a {
  text-decoration: none;
}
</style>
