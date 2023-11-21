<script setup>
import { ref, watch, onMounted, provide } from "vue";
import ScheduleSideBar from "./ScheduleSideBar.vue";
import ScheduleMap from "./ScheduleMap.vue";
import SendButton from "./SendButton.vue";

// const { sido } = defineProps({
//   sido: Number,
// });

//const props = defineProps({ stations: Array, selectStation: Object });

const stations = ref([]);
const selectStation = ref([]);

</script>

<template>
  <div class="sch-container">
    <ScheduleSideBar class="item"></ScheduleSideBar>
    <ScheduleMap :stations ="stations" :selectStation="selectStation" class="item"></ScheduleMap>
  </div>
  <SendButton></SendButton>
</template>

<style scope>
.sch-container {
  display: flex;
  flex-direction: row;
  font-family: var();
}

.item:nth-child(1) {
  flex-grow: 1;
}

.item:nth-child(2) {
  flex-grow: 2;
}
</style>
