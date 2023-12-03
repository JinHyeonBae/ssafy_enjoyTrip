<script setup>
const { latestArticle } = defineProps({ latestArticle: Object });
</script>

<template>
  <div class="card" style="width: 18rem; height: 22rem">
    <img
      :src="`http://localhost:80/vue/board/display/${latestArticle.saveFile}`"
      class="card-img-top h-50"
      alt="..."
    />
    <div class="card-body position-relative">
      <h5 class="card-title" style="text-align: center">
        {{ latestArticle.subject.substring(0, 15) }}
      </h5>
      <p class="card-text" style="text-align: center">
        {{ latestArticle.content.substring(0, 40) + "..." }}
      </p>
      <router-link
        :to="{
          name: 'article-view',
          params: { articleno: latestArticle.articleNo },
        }"
        class="position-absolute bottom-10 start-50 translate-middle-x btn d-flex justify-content-center"
        style="background-color: #dee2e6"
      >
        글 보러가기 &nbsp;<svg
          xmlns="http://www.w3.org/2000/svg"
          width="22"
          height="22"
          fill="currentColor"
          class="bi bi-arrow-up-right"
          viewBox="0 0 16 16"
        >
          <path
            fill-rule="evenodd"
            d="M14 2.5a.5.5 0 0 0-.5-.5h-6a.5.5 0 0 0 0 1h4.793L2.146 13.146a.5.5 0 0 0 .708.708L13 3.707V8.5a.5.5 0 0 0 1 0v-6z"
          />
        </svg>
      </router-link>
    </div>
  </div>
</template>

<style scoped></style>
