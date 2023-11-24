<script setup>
import Datepicker from "vue3-datepicker";
import { ref, computed } from "vue";
import { useAttrStore } from "@/stores/schedule";

const store = useAttrStore();
const today = ref("");

const StartDateValueHandler = () => {
  const dateControl = document.querySelector('input[id="start"]');
  store.changeStartDate(dateControl.value);
};

const DestDateValueHandler = () => {
  const dateControl = document.querySelector('input[id="dest"]');
  store.changeDestDate(dateControl.value);
};

const getToday = () => {
  let d = new Date();

  let year = d.getFullYear(); // 년도
  let month = d.getMonth() + 1; // 월
  let date = d.getDate(); // 날짜
  let day = d.getDay(); // 요일

  return year + "-" + month + "-" + date;

  today.value = year + "-" + month + "-" + date;
};

const getNxtDay = () => {
  let d = new Date();

  let year = d.getFullYear(); // 년도
  let month = d.getMonth() + 1; // 월
  let date = d.getDate(); // 날짜
  let day = d.getDay(); // 요일

  return year + "-" + month + "-" + (date + 1);
}

</script>

<template>
  <div class="calander mx-auto mt-2">
    <h3 class="mt-1">출발 일정</h3>
    <input
      id="start"
      type="date"
      aria-required="true"
      placeholder="출발 일정"
      class="ps-5 pe-5"
      :min="getToday()"
      :onChange="StartDateValueHandler"
    />
    <h3 class="mt-5">종료 일정</h3>
    <input
      id="dest"
      type="date"
      aria-required="true"
      placeholder="종료 일정"
      :min="getNxtDay()"
      class="ps-5 pe-5"
      :onChange="DestDateValueHandler"
    /><br />
  </div>
</template>

<style scoped>
.calander {
}
input[type="date"]::-webkit-calendar-picker-indicator,
input[type="date"]::-webkit-inner-spin-button {
  display: none;
  appearance: none;
}

input[type="date"]::before {
  width: 100vw;
}

input[type="date"]::-webkit-calendar-picker-indicator {
  color: rgba(0, 0, 0, 0);
  opacity: 1;
  display: block;

  width: 30px;
  height: 25px;
  border-width: thin;
}
</style>
