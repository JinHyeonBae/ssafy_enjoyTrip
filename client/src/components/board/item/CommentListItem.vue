<script setup>
import { useRoute, useRouter } from "vue-router";
import { ref } from "vue";
import { deleteComment, modifyComment } from "@/api/comment";
import { createPinia } from "pinia";

const { comment, articleno } = defineProps({ comment: Object, articleno: String });
// function updateComment() {
// 	// API 호출
// }
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
        console.log(data);
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
	console.log(comment.commentNo + "번 댓글 삭제하러 가자!!!", articleno + "," + comment.userId);
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
console.log("comment:", comment);
</script>



<template>
	<tr class="text-center">
	  <th scope="row">
		{{ comment.commentNo }}
	  </th>
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
		  type="button"
		  class="btn btn-outline-success mb-3"
		  @click="updateComment(comment.commentNo)"
		>
		  글수정
		</button>
	  </td>
	  <td>
		<button
		  type="button"
		  class="btn btn-outline-danger mb-3 ms-1"
		  @click="onDeleteComment"
		>
		  글삭제
		</button>
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
