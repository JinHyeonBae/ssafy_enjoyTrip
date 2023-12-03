<script setup>
import { useRouter } from "vue-router";
import { ref } from "vue";
import { useMemberStore } from "@/stores/member";
import { useAttrStore } from "@/stores/schedule";
import { storeSchedule } from "@/api/schedule";
import { storeToRefs } from "pinia";
import router from "@/router";
const store = useAttrStore();
const title = ref("");
const memo = ref("");

const memberStore = useMemberStore();
const { userInfo } = storeToRefs(memberStore);
const isShow = ref(false);
//자신이 작성한 글만 수정 및 삭제 가능하도록 하는 코드

const setSchedule = () => {
  if (userInfo.value == null) {
    alert("로그인을 해야 접근할 수 있습니다.");
    router.replace({ name: "user-login" });
    return;
  }

  const data = store.getAttrData();
  data.memo = memo.value;
  data.title = title.value;

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
  border-color: #dfcdeb;
  background-color: #dfcdeb;

  color: white;
  height: 5rem;
  width: 5rem;
  text-align: center;
}
</style>
