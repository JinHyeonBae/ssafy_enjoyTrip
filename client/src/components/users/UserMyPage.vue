<script setup>
import { storeToRefs } from "pinia";
import { useMemberStore } from "@/stores/member";
import { onMounted, ref } from "vue";
import { getUserSchedule } from "@/api/schedule";
const memberStore = useMemberStore();
const { userInfo } = storeToRefs(memberStore);

const scheduleList = ref([]);

const moveUserModify = () => {};

onMounted(() => {
	getUserSchedule(
		{
			userId: "ssafy",
		},
		(response) => {
			console.log("USERPAGE SCHEDULE response : ");
			console.log(response);
			scheduleList.value = response.data;
		},
		(error) => {
			console.log("USERPAGE SCHEDULE ERROR : ");
			console.log(error);
		}
	);
});
</script>

<template>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-lg-10">
				<div class="card mt-3 m-auto" style="max-width: 700px">
					<div class="row g-0">
						<div class="col-md-4 position-relative">
							<img
								src="https://source.unsplash.com/random/250x250/?food"
								class="img-fluid rounded-circle w-50 position-absolute top-50 start-50 translate-middle"
								alt="..."
							/>
						</div>
						<div class="col-md-8">
							<div class="card-body text-start">
								<ul class="list-group list-group-flush">
									<li class="list-group-item">아이디: {{ userInfo.userId }}</li>
									<li class="list-group-item">닉네임: {{ userInfo.userName }}</li>
									<li class="list-group-item">
										이메일: {{ userInfo.emailId }}@{{ userInfo.emailDomain }}
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div>
					<button
						@click="moveUserModify"
						type="button"
						class="btn btn-link mt-2"
						style="text-decoration-line: none"
					>
						프로필 관리하러가기
						<svg
							xmlns="http://www.w3.org/2000/svg"
							width="13"
							height="13"
							fill="currentColor"
							class="bi bi-gear-fill"
							viewBox="0 0 16 16"
						>
							<path
								d="M9.405 1.05c-.413-1.4-2.397-1.4-2.81 0l-.1.34a1.464 1.464 0 0 1-2.105.872l-.31-.17c-1.283-.698-2.686.705-1.987 1.987l.169.311c.446.82.023 1.841-.872 2.105l-.34.1c-1.4.413-1.4 2.397 0 2.81l.34.1a1.464 1.464 0 0 1 .872 2.105l-.17.31c-.698 1.283.705 2.686 1.987 1.987l.311-.169a1.464 1.464 0 0 1 2.105.872l.1.34c.413 1.4 2.397 1.4 2.81 0l.1-.34a1.464 1.464 0 0 1 2.105-.872l.31.17c1.283.698 2.686-.705 1.987-1.987l-.169-.311a1.464 1.464 0 0 1 .872-2.105l.34-.1c1.4-.413 1.4-2.397 0-2.81l-.34-.1a1.464 1.464 0 0 1-.872-2.105l.17-.31c.698-1.283-.705-2.686-1.987-1.987l-.311.169a1.464 1.464 0 0 1-2.105-.872l-.1-.34zM8 10.93a2.929 2.929 0 1 1 0-5.86 2.929 2.929 0 0 1 0 5.858z"
							/>
						</svg>
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
										여행 기간 : {{ schedule.start_date }} ~ {{ schedule.end_date }}
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div>
					<button type="button" class="btn btn-outline-secondary mt-2">수정</button>
				</div>
			</div>
		</div>
	</div>
</template>

<style scoped></style>
