<script setup>
const { name } = defineProps({
  name: String,
});
</script>

<template>
  <div
    class="shadow-sm nav-link py-3 border-bottom rounded-0 mb-2"
    title="Products"
    data-bs-toggle="tooltip"
    data-bs-placement="right"
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
