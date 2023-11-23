<script setup>
import { ref, onMounted } from "vue";
import { useRouter } from "vue-router";
import { listComment } from "@/api/comment";
import BoardListItem from "@/components/board/item/BoardListItem.vue";
import CommentListItem from "./CommentListItem.vue";
const { articleno } = defineProps(["articleno"]);
const comments = ref([]);

const getCommentList = () => {
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
  <hr />
  <table
    class="table table-borderless align-middle table-light border border-dark-subtle table-sm"
  >
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
