<script setup>
import { ref, onMounted } from "vue";
import { useRouter } from "vue-router";
import { listComment } from "@/api/comment";

import BoardListItem from "@/components/board/item/BoardListItem.vue";
import CommentListItem from "./CommentListItem.vue";
const { articleno } = defineProps(["articleno"]);
const comments = ref([]);

const getCommentList = () => {
	console.log("서버에서 댓글목록 얻어오자!!!");
	console.log("articleno: ", articleno);
	// API 호출
	listComment(
		articleno,
		({ data }) => {
			// console.log(data.comment);
			comments.value = data.comment;
		},
		(error) => {
			console.log(error);
		}
	);
};

onMounted(() => {
	getCommentList();
});
</script>

<template>
	<table class="table table-hover">
		<thead>
			<tr class="text-center">
				<th scope="col">댓글번호</th>
				<th scope="col">댓글내용</th>
				<th scope="col">작성자</th>
				<th scope="col">작성날짜</th>
				<th scope="col">수정</th>
				<th scope="col">삭제</th>
			</tr>
		</thead>
		<tbody>
			<CommentListItem
				v-for="comment in comments"
				:key="comment.commentNo"
				:comment="comment"
				:articleno="`${articleno}`"
			></CommentListItem>
		</tbody>
	</table>
</template>

<style scoped></style>
