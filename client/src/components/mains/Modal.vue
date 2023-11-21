<script setup>
import home_1 from "@/assets/img/main/Busan.jpg";
defineProps({ modalId: String, sidoImage: Object });
</script>

<template>
	<div
		class="modal fade"
		:id="modalId"
		tabindex="-1"
		aria-labelledby="exampleModalLabel"
		aria-hidden="true"
	>
		<div class="modal-dialog modal-dialog-centered modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="exampleModalLabel">{{ sidoImage.name }}</h1>

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
							{{ sidoImage.description }}
						</div>
					</div>
					<div class="col d-flex justify-content-center">
						<img
							:src="sidoImage.image"
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
