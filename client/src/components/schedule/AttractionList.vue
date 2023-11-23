<script setup>
import AttractionItem from "./AttractionItem.vue";
import InfiniteLoading from "v3-infinite-loading";
import "v3-infinite-loading/lib/style.css";

import TripFilter from "@/components/schedule/tripInfo/TripFilter.vue";
import TripSearch from "@/components/schedule/tripInfo/TripSearch.vue";

import { ref, watch, onMounted } from "vue";
import { getAttrations } from "@/api/schedule";
import { useAttrStore } from "@/stores/schedule";
import { storeToRefs } from "pinia";
import ScheduleModal from "./ScheduleModal.vue";

const store = useAttrStore();
const { startDate, destDate } = storeToRefs(store);
let attrList = ref([]);
let page = 1;

const sido = ref(store.getSidoCode());
const gugunCode = ref("");
const typeInfo = ref("");
const title = ref("");

const addItem = (item) => {
  console.log(item);
  store.addToAttrList(item);
};

const changeSido = (sido) => {
  store.setSidoCode(sido);
  getAttrInfo();
};

// 구군을 선택했을 때!
const changeGugun = (gugun) => {
  store.setGugunCode(gugun);
  gugunCode.value = gugun;
  getAttrInfo();
};

// type을 선택했을 때!
const changeType = (type) => {
  store.setTypeInfo(type);
  typeInfo.value = type;
  getAttrInfo();
};

const search = (t) => {
  title.value = t;
  getAttrInfo();
};

// 필터링 후 서버에 데이터 요청하는 부분
const getAttrInfo = () => {
  const size = 10;
  const start = 1 * size - size;
  console.log("getAttrInfo :");
  console.log(sido.value);
  getAttrations(
    {
      sido: store.getSidoCode() === undefined ? 0 : store.getSidoCode(),
      gugun: gugunCode.value,
      type: typeInfo.value,
      start: start,
      listsize: size,
      title: title.value,
    },
    ({ data }) => {
      attrList.value = data;
    },
    (error) => {
      console.log("error");
      console.log(error);
    }
  );
};

// 무한 스크롤용 API
const load = async ($state) => {
  console.log(
    "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!지금 서버로 보낸다!!!"
  );
  const size = import.meta.env.VITE_ATTR_LIST_SIZE;
  const start = page * size - size;

  // props로 들어온 코드는 들어가야한다.
  try {
    getAttrations(
      {
        sido: sido.value === undefined ? 0 : sido.value,
        gugun: gugunCode.value,
        type: typeInfo.value,
        start: start,
        listsize: size,
        title: title.value,
      },
      ({ data }) => {
        //console.log("ATTRLIST : " + response.data);
        console.log("서버에서 리스트 모두를 받아온다 : ");
        console.log(data);
        const json = data;
        console.log($state);
        if (json.length < 10) $state.complete();
        else {
          attrList.value.push(...json);
          $state.loaded();
        }
        page++;
      },
      (error) => {
        console.log(error);
      }
    );
  } catch (error) {
    $state.error();
  }
};
</script>

<template>
  <div class="attr">
    <div class="input-group mb-3">
      <TripFilter
        :sido="sido"
        @change-sido="changeSido"
        @change-gugun="changeGugun"
        @change-type="changeType"
      >
      </TripFilter>
      <TripSearch @search="search"> </TripSearch>
    </div>
    <div class="attr-list">
      <div v-for="attraction in attrList">
        <AttractionItem :attraction="attraction" @add-item="addItem" />
      </div>
    </div>
    <infinite-loading @infinite="load"></infinite-loading>
  </div>
</template>

<style scoped>
.attr {
  height: 80vh;
  display: flex;
  flex-direction: column;
  width: auto;

  overflow-y: scroll;
}
.input-group {
}
.attr-list {
  flex-flow: 2;
}
</style>
