<script setup>
import Datepicker from "vue3-datepicker";
import { ref, computed } from "vue";
import { useAttrStore } from "@/stores/schedule";

const store = useAttrStore();

const inputFormat = ref("yyyy-MM-dd");

const StartDateValueHandler = () => {
  const dateControl = document.querySelector('input[id="start"]');
  //const dateValue = startDate.value;
  console.log(dateControl.value);

  store.changeStartDate(dateControl.value);
};

const DestDateValueHandler = () => {
  const dateControl = document.querySelector('input[id="dest"]');

  store.changeDestDate(dateControl.value);
};
</script>

<template>
  <div class="calander mx-auto mt-2">
    <h3 class="mt-1">출발 일정</h3>
    <input
      id="start"
      type="date"
      data-placeholder="날짜 선택"
      value=""
      :on-change="StartDateValueHandler"
    />
    <h3 class="mt-5">도착 일정</h3>
    <input
      id="dest"
      type="date"
      data-placeholder="날짜 선택"
      aria-required="true"
      value=""
      :onChange="DestDateValueHandler"
    /><br />
    {{ store.getStartDate() }}<br />
    {{ store.getDestDate() }}<br />
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
  content: attr(data-placeholder);
  width: 100%;
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
