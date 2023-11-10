<script setup>
import { ref, watch } from "vue";
import { useRoute, useRouter } from "vue-router";
import { registComment } from "@/api/comment";
// getModifyArticle, modifyArticle
const { articleno } = defineProps(["articleno"]);
const router = useRouter();
// const route = useRoute();

const isUseId = ref(false);

const comment = ref({
	articleNo: articleno,
	content: "",
	userId: "",
});

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
	<div class="mb-3">
		<label for="userid" class="form-label">작성자 ID : </label>
		<input
			type="text"
			class="form-control"
			v-model="comment.userId"
			:disabled="isUseId"
			placeholder="작성자ID..."
		/>
	</div>

	<div class="mb-3">
		<label for="content" class="form-label">내용 : </label>
		<textarea class="form-control" v-model="comment.content" rows="5"></textarea>
	</div>
	<div class="col-auto text-center">
		<button type="button" class="btn btn-outline-primary mb-3" @click="writeComment">글작성</button>
		<button type="button" class="btn btn-outline-danger mb-3 ms-1" @click="moveList">
			목록으로이동...
		</button>
	</div>
</template>

<style scoped></style>
