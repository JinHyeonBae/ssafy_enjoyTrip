<script>
import { defineComponent } from "vue";
import { Carousel, Pagination, Slide } from "vue3-carousel";
import home_1 from "@/assets/img/main/Busan.jpg";
import home_2 from "@/assets/img/main/Geojetongyeong.jpg";
import home_3 from "@/assets/img/main/Gyeongju.jpg";
import home_4 from "@/assets/img/main/Incheon.jpg";
import home_5 from "@/assets/img/main/Jeju.jpg";
import home_6 from "@/assets/img/main/Pohang.jpg";
import home_7 from "@/assets/img/main/Yeosu.jpg";

import "vue3-carousel/dist/carousel.css";

export default defineComponent({
  name: "Autoplay",
  components: {
    Carousel,
    Slide,
    Pagination,
  },
  data() {
    return {
      slides: [home_1, home_2, home_3, home_4, home_5, home_6, home_7],
    };
  },
});
</script>
<template>
  <div class="wrapper">
    <Carousel :autoplay="3000" :wrap-around="true">
      <Slide v-for="slide in slides" :key="slide">
        <div class="carousel__item">
          <img
            class="slideImg"
            :src="slide"
            style="height: 400px; width: 2000px; object-fit: cover"
          />
        </div>
      </Slide>

      <template #addons>
        <Pagination />
      </template>
    </Carousel>
  </div>
</template>

<style>
.carousel__item {
  color: var(--vc-clr-white);
  font-size: 20px;
  border-radius: 8px;
  display: flex;
  justify-content: center;
  align-items: center;
}

.carousel__slide {
  padding: 10px;
}

.carousel__prev,
.carousel__next {
  box-sizing: content-box;
  border: 5px solid white;
}
.slideImg {
  max-height: 740px;
  max-width: 100%;
}
.wrapper {
  margin-top: 3vh;
}
</style>

<!-- <script>
import { Carousel, Slide } from "vue-carousel";
export default {
	components: {
		Carousel,
		Slide,
	},
};
</script>

<template>

	<carousel>
		<slide> Slide 1 Content </slide>
		<slide> Slide 2 Content </slide>
	</carousel>
</template>

<style scoped></style> -->
