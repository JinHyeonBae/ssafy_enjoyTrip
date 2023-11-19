<script setup>
import { ref, watch, onMounted, provide, inject } from "vue";
import { useAttrStore } from "@/stores/schedule";
import { storeSchedule } from "@/api/schedule";

const store = useAttrStore();
const title = ref("");
const memo = ref("");

/*
	user_id varchar(200) NOT NULL,
    title varchar(50) NULL DEFAULT "나의 여행계획",
	memo varchar(255) NULL DEFAULT "",
    content text NULL,
    start_date date default (current_date),
    end_date date DEFAULT (current_date) 

*/

const setSchedule = () => {
  console.log(title.value);
  console.log(memo.value);
};
</script>

<template>
  <div class="py-2">
    <div class="modal" id="myModal">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">계획의 이름과 메모를 입력해보세요!</h5>
            <button
              type="button"
              class="btn-close"
              data-bs-dismiss="modal"
              aria-label="Close"
            ></button>
          </div>
          <div class="modal-body">
            <div class="mb-3">
              <label for="title" class="form-label">여행 계획 제목</label>
              <input
                type="text"
                v-model="title"
                class="form-control"
                id="title"
              />
            </div>
            <div class="mb-3">
              <label for="memo" class="form-label"
                >여행 계획에 대한 짤막한 글귀를 적어보세요.</label
              >
              <textarea
                class="form-control"
                id="exampleFormControlTextarea1"
                rows="3"
                v-model="memo"
              ></textarea>
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
            <button type="button" class="btn btn-primary" @click="setSchedule">
              생성
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped></style>
