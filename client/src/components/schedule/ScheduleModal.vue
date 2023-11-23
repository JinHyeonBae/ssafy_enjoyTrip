<script setup>
const { attraction } = defineProps({
  attraction: Object,
});

console.log(attraction);
// const router = useRouter();

// const moveToSchedule = () => {
// 	router.push({
// 		name: "schedule",
// 		state: {
// 			dataObj: { sido: Number(sidoCode) },
// 		},
// 	});
// };
</script>

<template>
  <div class="modal" id="scheduleModal">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title">{{ attraction.title }}</h5>
          <button
            type="button"
            class="btn-close"
            data-bs-dismiss="modal"
            aria-label="Close"
          ></button>
        </div>
        <div class="modal-body">
          <div class="mb-3">
            {{ attraction.overview }}
          </div>
        </div>
        <div class="modal-footer">
          <button
            type="button"
            class="btn btn-secondary"
            data-bs-dismiss="modal"
          >
            취소
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped></style>
