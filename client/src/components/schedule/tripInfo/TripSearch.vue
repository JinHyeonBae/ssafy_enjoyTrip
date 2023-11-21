<script setup>
import { ref } from "vue"

const emit = defineEmits(['search'])
const content = ref("")
const getAttrListByContent = () =>{
    console.log(content.value)
    emit("search", content.value)
}

</script>

<template>
<span 
    class="input-group-text" id="inputGroup-sizing-default"
    >검색</span>
    <input
        type="text"
        class="form-control"
        aria-label="Sizing example input"
        aria-describedby="inputGroup-sizing-default"
        @change="getAttrListByContent"
        v-model="content"
      />
</template>



<style></style>