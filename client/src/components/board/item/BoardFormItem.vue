<script setup>
import { ref, watch } from "vue";
import { useRoute, useRouter } from "vue-router";
import { registArticle, getModifyArticle, modifyArticle } from "@/api/board";
const router = useRouter();
const route = useRoute();

const props = defineProps({ type: String });

const isUseId = ref(false);

const article = ref({
	articleNo: 0,
	subject: "",
	content: "",
	userId: "",
	userName: "",
	hit: 0,
	registerTime: "",

});
const files = ref({
	fileInfos: ""
})

if (props.type === "modify") {
	let { articleno } = route.params;
	console.log(articleno + "번글 얻어와서 수정할거야");
	getModifyArticle(
		articleno,
		({ data }) => {
			article.value = data;
			isUseId.value = true;
		},
		(error) => {
			console.log(error);
		}
	);
	isUseId.value = true;
}

const subjectErrMsg = ref("");
const contentErrMsg = ref("");
watch(
	() => article.value.subject,
	(value) => {
		let len = value.length;
		if (len == 0 || len > 30) {
			subjectErrMsg.value = "제목을 확인해 주세요!!!";
		} else subjectErrMsg.value = "";
	},
	{ immediate: true } //감시 기능 , watch의 특성: 변화를 바로 감지함
	//처음 들어오자마자 한번 실행하고 감시해라
);
watch(
	() => article.value.content,
	(value) => {
		let len = value.length;
		if (len == 0 || len > 500) {
			contentErrMsg.value = "내용을 확인해 주세요!!!";
		} else contentErrMsg.value = "";
	},
	{ immediate: true }
);

function onSubmit() {
	// event.preventDefault();

	if (subjectErrMsg.value) {
		alert(subjectErrMsg.value);
	} else if (contentErrMsg.value) {
		alert(contentErrMsg.value);
	} else {
		props.type === "regist" ? writeArticle() : updateArticle();
	}
}
function writeArticle() {
	console.log("글등록하자!!", article.value);
	const formData = new FormData();
	formData.append("article",new Blob([JSON.stringify(article.value)], { type: 'application/json' })
);

	for (let i = 0; i < files.value.fileInfos.length; i++) {
		formData.append("upfile", files.value.fileInfos[i]);
	}
	console.log("formData!!!");
	let entries = formData.entries();
	for (const pair of entries) {
		console.log(pair[0] + ", " + pair[1]);
	}

	registArticle(
		formData,
		(response) => {
			let msg = "글등록 처리시 문제 발생했습니다.";
			if (response.status == 201) msg = "글등록이 완료되었습니다.";
			alert(msg);
			moveList();
		},
		(error) => console.log(error)
	);
}

function updateArticle() {
	console.log(article.value.articleNo + "번글 수정하자!!", article.value);
	modifyArticle(
		article.value,
		(response) => {
			let msg = "글수정 처리시 문제 발생했습니다.";
			if (response.status == 200) msg = "글정보 수정이 완료되었습니다.";
			alert(msg);
			moveList();
		},
		(error) => console.log(error)
	);
}

function moveList() {
	router.push({ name: "article-list" });
}
const previewImages = ref([]);

const upload = (event) => {
	if (event.target.files.length > 5) {
		alert("사진은 최대 5개 까지 첨부가능합니다.");
	} else {
		//file째로(뷰에 찍히는 정보대로) 저장
		files.value.fileInfos = event.target.files;
		for (const file of event.target.files) {
			//프리뷰
			const reader = new FileReader();
			reader.onload = (e) => {
				previewImages.value.push(e.target.result);
			};
			reader.readAsDataURL(file);
		}
	}
	// 사용자가 올린 이미지
	console.log(event.target.files);

};
</script>

<template>
	<form @submit.prevent="onSubmit">
		<div class="mb-3">
			<label for="userid" class="form-label">작성자 ID : </label>
			<input
				type="text"
				class="form-control"
				v-model="article.userId"
				:disabled="isUseId"
				placeholder="작성자ID..."
			/>
		</div>
		<div class="mb-3">
			<label for="subject" class="form-label">제목 : </label>
			<input type="text" class="form-control" v-model="article.subject" placeholder="제목..." />
		</div>
		<div class="mb-3">
			<label for="content" class="form-label">내용 : </label>
			<textarea class="form-control" v-model="article.content" rows="10"></textarea>
		</div>
		<div class="mb-3">
			<input id="input-file" type="file" accept="image/*" @change="upload" multiple="multiple" />
		</div>
		<div class="w-100 image_container row d-flex justify-content-center">
			<img
				class="m-3 col-auto"
				v-for="(previewImage, index) in previewImages"
				:key="index"
				:src="previewImage"
				style="height: 200px; width: 300px; object-fit: cover"
			/>
		</div>
		<div class="col-auto text-center">
			<button type="submit" class="btn btn-outline-primary mb-3" v-if="type === 'regist'">
				글작성
			</button>
			<button type="submit" class="btn btn-outline-success mb-3" v-else>글수정</button>
			<button type="button" class="btn btn-outline-danger mb-3 ms-1" @click="moveList">
				목록으로이동...
			</button>
		</div>
	</form>
</template>

<style scoped></style>
