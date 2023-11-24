<script setup>
import { onMounted } from 'vue';

const props = defineProps({
  title: String,
  description : String
});


onMounted(()=>{
  
console.log(props.title);  
  console.log(props.description);
})

</script>

<template>
  <div class="modal">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title">{{ props.title }}</h5>
          <button
            type="button"
            class="btn-close"
            data-bs-dismiss="modal"
            aria-label="Close"
          ></button>
        </div>
        <div class="modal-body">
          <div class="mb-3">
            {{ props.description }}
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
