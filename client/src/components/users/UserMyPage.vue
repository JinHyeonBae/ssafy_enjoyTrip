<script setup>
import { storeToRefs } from "pinia";
import { useMemberStore } from "@/stores/member";
import { onMounted, ref } from "vue";
import { getUserSchedule } from "@/api/schedule";
const memberStore = useMemberStore();
const { userInfo } = storeToRefs(memberStore);

const scheduleList = ref([]);

onMounted(()=>{
  getUserSchedule({
    userId : "ssafy"
  },
  (response)=>{
    console.log("USERPAGE SCHEDULE response : ")
    console.log(response);
    scheduleList.value = response.data;
  },
  (error)=>{
    console.log("USERPAGE SCHEDULE ERROR : ")
    console.log(error);
  });
})


</script>

<template>
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-lg-10">
        <h2 class="my-3 py-3 shadow-sm bg-light text-center">
          <div>내정보</div>
        </h2>
      </div>
      <div class="col-lg-10">
        <div class="card mt-3 m-auto" style="max-width: 700px">
          <div class="row g-0">
            <div class="col-md-4">
              <img
                src="https://source.unsplash.com/random/250x250/?food"
                class="img-fluid rounded-start"
                alt="..."
              />
            </div>
            <div class="col-md-8">
              <div class="card-body text-start">
                <ul class="list-group list-group-flush">
                  <li class="list-group-item">{{ userInfo.userId }}</li>
                  <li class="list-group-item">{{ userInfo.userName }}</li>
                  <li class="list-group-item">
                    {{ userInfo.emailId }}@{{ userInfo.emailDomain }}
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
        <div>
          <button type="button" class="btn btn-outline-secondary mt-2">
            수정
          </button>
        </div>
      </div>
    </div>
    <div class="row justify-content-center">
    <div class="col-lg-10">
        <h2 class="my-3 py-3 shadow-sm bg-light text-center">
          <div>나의 여행 계획</div>
        </h2>
      </div>
      <div class="col-lg-10">
        <div class="card mt-3 m-auto" style="max-width: 700px" v-for="schedule in scheduleList">
          <div class="row g-0">
            <div class="col-md-4">
              <img
                src="https://source.unsplash.com/random/250x250/?food"
                class="img-fluid rounded-start"
                alt="..."
              />
            </div>
            <div class="col-md-8">
              <div class="card-body text-start">
                <ul class="list-group list-group-flush">
                  <li class="list-group-item">{{ schedule.title }}</li>
                  <li class="list-group-item">{{ schedule.content }}</li>
                  <li class="list-group-item">
                    여행 기간 : {{ schedule.start_date}} ~ {{ schedule.end_date }}
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
        <div>
          <button type="button" class="btn btn-outline-secondary mt-2">
            수정
          </button>
        </div>
      </div>
    </div>
  </div>

</template>

<style scoped></style>
