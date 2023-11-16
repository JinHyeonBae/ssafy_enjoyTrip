<script setup>
import { useRoute, useRouter } from "vue-router";

const router = useRouter();
const { name } = defineProps({
  name: String,
});

const pushButton = () => {
  console.log("NAME : " + name);
  if (name == "일정 설정") router.push({ name: "trip-date" });
  else router.push({ name: "attraction-list" });
};
</script>

<template>
  <div
    class="shadow-sm nav-link py-3 border-bottom rounded-0 mb-2"
    title="Products"
    data-bs-toggle="tooltip"
    data-bs-placement="right"
    @click="pushButton"
  >
    {{ name }}
  </div>
</template>

<style scoped>
.nav-link:focus,
.nav-link:hover {
  -webkit-transform: scale(1.3);
  transform: scale(1.3);
  color: #85d5e4;
}
</style>
