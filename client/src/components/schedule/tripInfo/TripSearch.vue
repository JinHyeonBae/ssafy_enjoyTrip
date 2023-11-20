<script setup>
import { computed, ref, onMounted } from "vue";

const props = defineProps({
  select: {
    type: Object,
    default: () => ({
      sido: "",
      gugun: "",
      type: "",
      search: "",
    }),
  },
});

// const emit = defineEmits(["changeSido", "changeGugun", "changeType"]);

const select = ref(props.select);

// 무조건 시도코드가 가능
const enabled = computed(() => !!select.value?.sido);
const gugunlist = ref([]);
const typeInfo = ref("");

const typelist = [
  { code: "12", name: "관광지" },
  { code: "14", name: "문화시설" },
  { code: "15", name: "축제공연행사" },
  { code: "25", name: "여행코스" },
  { code: "28", name: "레포츠" },
  { code: "32", name: "숙박" },
  { code: "38", name: "쇼핑" },
  { code: "39", name: "음식점" },
];

// 공공데이터 서비스 키
const serviceKey = import.meta.env.VITE_OPEN_API_SERVICE_KEY;

// 지역코드
const areaUrl =
  "https://apis.data.go.kr/B551011/KorService1/areaCode1?serviceKey=" +
  serviceKey +
  "&numOfRows=20&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json";

// 공공데이터 시도 코드 호출
// async function fetchOption() {
//   const sidoUrl = `https://apis.data.go.kr/B551011/KorService1/areaCode1?serviceKey=${serviceKey}&MobileOS=ETC&MobileApp=AppTest&_type=json`;
//   const response = await fetch(sidoUrl);
//   const data = await response.json();
//   return data.response.body.items.item;
// }

// 데이터 왜 안 주나..ㅠㅠㅠ
// 공공데이터 구군 코드 호출
async function fetchGuGunOption(areaCode) {
  const gugunUrl = `https://apis.data.go.kr/B551011/KorService1/areaCode1?serviceKey=${serviceKey}&MobileOS=ETC&MobileApp=AppTest&_type=json`;

  const response = await fetch(gugunUrl, {
    headers: {
      Accept: "application / json",
    },
  });
  console.log("RESPONSE : ");
  console.log(response);
  const data = await response.json();
  console.log(data);
  return data.response.body.items.item;
}

const changeGugun = (gugun) => {
  console.log("gugun :");
  console.log(gugun.target);
  //emit("changeGugun", gugun);
};

// 정상적으로 받아옴
const changeType = (t) => {
  console.log(typeInfo.value);
  //emit("changeType", type);
};

// onMounted(() => {
//   gugunlist.value = fetch(areaUrl).then((data) => {
//     console.log(data.json());
//   });
//   //console.log(fetchGuGunOption(3));
//   console.log("GUGUN : ");
//   console.log(gugunlist.value);
// });
</script>

<template>
  <div class="select-container">
    <select
      class="form-select"
      aria-label="Default select example"
      :model-value="select.gugun"
      @update:modelValue="changeGugun"
      :items="gugunlist"
      item-title="name"
      item-value="code"
      :rules="[(v) => !!v || 'gugun is required']"
      label="구군"
      required
    ></select>

    <select
      class="form-select"
      aria-label="Default select example"
      label="관광지유형"
      v-model="typeInfo"
      required
      @change="changeType"
    >
      <option v-for="t in typelist" :value="t.code">
        {{ t.name }}
      </option>
    </select>
  </div>
</template>
<style scoped>
.search-container {
  display: flex;
  gap: 10px;
}

.select-container {
  width: 70vw;
  display: flex;
  gap: 10px;
  margin: auto;
  margin-top: 30px;
}

.select-container > select {
  flex: 1 1 300px;
}

.search-form {
  width: 70vw;
  display: flex;
  gap: 10px;
  margin: auto;
  margin-top: 30px;
}
</style>
