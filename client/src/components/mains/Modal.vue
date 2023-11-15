<script setup>
import home_1 from "@/assets/img/main/Busan.jpg";
</script>

<template>
	<div
		class="modal fade"
		id="exampleModal"
		tabindex="-1"
		aria-labelledby="exampleModalLabel"
		aria-hidden="true"
	>
		<div class="modal-dialog modal-dialog-centered modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="exampleModalLabel">Busan</h1>

					<button
						type="button"
						class="btn-close"
						data-bs-dismiss="modal"
						aria-label="Close"
					></button>
				</div>
				<div class="row modal-body">
					<div class="col">
						<div>
							부산광역시는 대한민국 남동부에 위치한 광역시이다. 대한민국의 제2의 도시이자 최대의
							해양 도시이며, 부산항을 중심으로 해상 무역과 물류 산업이 발달하였다. 일본과는
							대한해협을 사이에 두고 마주하고 있다.
						</div>
					</div>
					<div class="col d-flex justify-content-center">
						<img
							:src="home_1"
							class="rounded-3"
							style="width: 350px; height: 200px; object-fit: cover"
							alt="..."
						/>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
					<button type="button" class="btn btn-primary">일정만들기</button>
				</div>
			</div>
		</div>
	</div>
</template>

<style scoped></style>
