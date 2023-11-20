<script setup>
import { useRouter } from "vue-router";
import { ref, watch, onMounted, provide, inject } from "vue";
import { useAttrStore } from "@/stores/schedule";
import { storeSchedule } from "@/api/schedule";
const store = useAttrStore();
const title = ref("");
const memo = ref("");

const setSchedule = () => {
  //console.log(title.value);
  //console.log(memo.value);
  store.setTitle(title.value);
  store.setMemo(memo.value);

  const data = store.getAllDateAsJson();

  storeSchedule(
    data,
    async (response) => {
      console.log(response);
      if (response.status == 201) alert("계획이 성공적으로 등록되었습니다.");
    },
    (error) => {
      console.log("setSchedule : " + error);
      alert("계획이 등록되지 않았습니다.");
    }
  );

  console.log(data);
};
</script>

<template>
  <button
    id="wrapper"
    class="btn btn-primary"
    data-bs-target="#myModal"
    data-bs-toggle="modal"
    @click="goNext"
  >
    다음
  </button>

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
            <button
              type="button"
              data-bs-dismiss="modal"
              class="btn btn-primary"
              @click="setSchedule"
            >
              생성
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
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
