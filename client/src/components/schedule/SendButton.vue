<script setup></script>

<template>
  <button id="wrapper">다음</button>
</template>

<style scoped>
#wrapper {
  position: fixed; /* 이 부분을 고정 */
  left: 0.5rem;
  bottom: 0.5rem; /* 하단에 여백 없이 */
  z-index: 1000;

  border: 10px solid transparent; /* border 투명 */
  border-radius: 10rem;
  border-color: #85d5e4;
  background-color: #85d5e4;

  color: white;
  height: 5rem;
  width: 5rem;
  text-align: center;
}
</style>
