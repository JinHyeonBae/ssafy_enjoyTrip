<script setup>
import { computed, ref, onMounted } from "vue";

// 여기는 props로 시도 코드를 받는다.
const props = defineProps({
  select: {
    type: Object,
    default: () => ({
      sido: "3",
      gugun: "",
      type: "",
      search: "",
    }),
  },
});

const emits = defineEmits(['changeGugun', 'changeType'])


const select = ref(props.select);

// 무조건 시도코드가 가능
const enabled = computed(() => !!select.value?.sido);

const gugunlist = ref([]);
const gugunInfo = ref("")
const typeInfo = ref("");

const typelist = [
  {code: "0", name: "전체"},
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

// 공공데이터 구군 코드 호출
async function fetchGuGunOption(areaCode) {
  const gugunUrl = `https://apis.data.go.kr/B551011/KorService1/areaCode1?serviceKey=${serviceKey}&MobileOS=ETC&MobileApp=AppTest&_type=json&areaCode=${areaCode}`;

  const response = await fetch(gugunUrl, {
    headers: {
      accept: "application/json",
    },
  });
  console.log("RESPONSE : ");
  const data = await response.json();
  //console.log(data);
  return data.response.body.items.item;
}

const changeGugun = (gugun) => {
  console.log("gugun :");
  console.log(gugun.target);
  emits("changeGugun", gugunInfo.value)
};

// 정상적으로 받아옴
const changeType = (t) => {
  emits("changeType", typeInfo.value)
  //emit("changeType", type);
  
};

onMounted(() => {
  
  // 공공데이터 포털에서 너무 많이 요청하면 막히므로 이 코드는 실제로 테스트할 때 연다.

  /*
  fetchGuGunOption(4) // props로 받아온 sido 코드를 넣는다.
    .then((response)=>{
      console.log("API : ")
      console.log(response)
      gugunlist.value = response;
      //{rnum: 1, code: '1', name: '남구'}
      gugunlist.value.unshift({rnum: 0, code: '0', name: '전체'})
  });
  */

  gugunlist.value.push({rnum: 1, code: '1', name: '남구'});
  gugunlist.value.push({rnum: 2, code: '2', name: '남구'});
  gugunlist.value.push({rnum: 3, code: '3', name: '남구'});
  gugunlist.value.push({rnum: 4, code: '4', name: '남구'});
  gugunlist.value.push({rnum: 5, code: '5', name: '남구'});
  
  
  //gugunlist.value = fetchGuGunOption(3);
  //console.log(fetchGuGunOption(3));
});
</script>

<template>
  <div class="select-container">
    <select
      class="form-select"
      aria-label="Default select example"
      v-model="gugunInfo"
      label="구군"
      @change="changeGugun"
      required
    >
    <option v-for="gugun in gugunlist" :value="gugun.rnum">
        {{ gugun.name }}
    </option>
  </select>

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
