<script setup>
import { ref, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import { detailArticle, deleteArticle } from "@/api/board";
import { storeToRefs } from "pinia";
import { useMemberStore } from "@/stores/member";
import CommentList from "@/components/board/item/CommentList.vue";
import CommentFormItem from "@/components/board/item/CommentFormItem.vue";
const route = useRoute();
const router = useRouter();
const { articleno } = route.params;
const article = ref({});

const memberStore = useMemberStore();
const { userInfo } = storeToRefs(memberStore);
const isShow = ref(false);
//자신이 작성한 글만 수정 및 삭제 가능하도록 하는 코드
const changeShow = (userId) => {
  if (userInfo.value != null && userInfo.value.userId === userId) {
    isShow.value = true;
  }
};

onMounted(() => {
  getArticle();
});
const exfname = "20231120_12532f69-cb62-49af-99b4-176dd25f805b.png";
const getArticle = () => {
  console.log(articleno + "번글 얻으러 가자!!!");
  // API 호출
  detailArticle(
    articleno,
    ({ data }) => {
      article.value = data;
      changeShow(article.value.userId);
    },
    (error) => {
      console.log(error);
    }
  );
};

function moveModify() {
  router.push({ name: "article-modify", params: { articleno } });
}
function moveList() {
  router.push({ name: "article-list" });
}

function onDeleteArticle() {
  console.log(articleno + "번글 삭제하러 가자!!!");
  deleteArticle(
    articleno,
    (response) => {
      if (response.status == 200) moveList();
    },
    (error) => {
      console.log(error);
    }
  );
}
</script>

<template>
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-lg-10 text-start">
        <div class="col-md-8">
          <div class="clearfix align-content-center">
            <img
              class="avatar me-2 float-md-start bg-light p-2"
              src="https://raw.githubusercontent.com/twbs/icons/main/icons/person-fill.svg"
            />
            <p>
              <span class="fw-bold">{{ article.userId }}</span> <br />
              <span class="text-secondary fw-light">
                {{ article.registerTime }} | 조회 : {{ article.hit }}
              </span>
            </p>
          </div>
        </div>
        <div class="row d-flex justify-content-center">
          <div class="divider mb-3"></div>
          <h4 class="text-secondary">{{ article.subject }}</h4>
          <hr />
          <div class="text-secondary">
            {{ article.content }}
          </div>
          <div class="w-100 image_container row d-flex justify-content-center">
            <img
              class="m-3 col-auto"
              v-for="(file, index) in article.fileInfos"
              :key="index"
              :src="`http://localhost:80/vue/board/display/${file.saveFile}`"
              style="height: 200px; width: 300px; object-fit: cover"
            />
          </div>
          <div class="divider mt-3 mb-3"></div>
          <div class="d-flex justify-content-end">
            <button
              v-if="isShow"
              type="button"
              class="btn btn-link mb-3 ms-1 text-secondary"
              @click="moveModify"
              style="text-decoration-line: none"
            >
              글수정
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="13"
                height="13"
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
            <button
              v-if="isShow"
              type="button"
              style="text-decoration-line: none"
              class="text-danger btn btn-link mb-3 ms-1"
              @click="onDeleteArticle"
            >
              글삭제
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="13"
                height="13"
                fill="currentColor"
                class="bi bi-dash-circle-fill"
                viewBox="0 0 16 16"
              >
                <path
                  d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM4.5 7.5a.5.5 0 0 0 0 1h7a.5.5 0 0 0 0-1h-7z"
                />
              </svg>
            </button>
            <!-- 안보이는 버튼 -->
            <button v-else class="btn btn-light disabled"></button>
          </div>
          <CommentList :articleno="`${articleno}`" />
          <CommentFormItem :articleno="`${articleno}`" />
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped></style>
