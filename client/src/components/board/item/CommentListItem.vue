<script setup>
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
		<th scope="row">{{ comment.commentNo }}</th>
		<td class="text-start">
			{{ comment.content }}
		</td>
		<td>{{ comment.userId }}</td>
		<td>
			<button type="button" class="btn btn-outline-success mb-3">
				<!--@click="updateComment"-->
				글수정
			</button>
		</td>
		<td>
			<button type="button" class="btn btn-outline-danger mb-3 ms-1" @click="onDeleteComment">
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
