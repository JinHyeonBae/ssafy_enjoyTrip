<script setup>
import AttractionItem from "./AttractionItem.vue";
import InfiniteLoading from "v3-infinite-loading";
import "v3-infinite-loading/lib/style.css";

import TripFilter from "@/components/schedule/tripInfo/TripFilter.vue";
import TripSearch from "@/components/schedule/tripInfo/TripSearch.vue";

import { ref, watch, onMounted } from "vue";
import { getAttrations } from "@/api/schedule";
import { useAttrStore } from "@/stores/schedule"

const store = useAttrStore();

let attrList = ref([]);
let page = 1;

const sido = ref(store.getSidoCode())
const gugunCode = ref("");
const typeInfo = ref("");
const title = ref("")

// 구군을 선택했을 때! 
const changeGugun = (gugun) =>{
  gugunCode.value = gugun;
  getAttrInfo();
}

// type을 선택했을 때!
const changeType = (type) =>{
  typeInfo.value = type;
  getAttrInfo();
}

const search = (t)=>{
  title.value = t;
  getAttrInfo()
}

// 필터링 후 서버에 데이터 요청하는 부분
const getAttrInfo = ()=> {
  const size = 100;
  const start = 1 * size - size;

  getAttrations(
      {
        sido: sido.value,
        gugun : gugunCode.value,
        type : typeInfo.value,
        start: start,
        listsize: size,
        title : title.value
      },
      ({data})=>{
        console.log("response : ")
        //console.log(response);
        console.log(data)
        attrList.value = data
      },
      (error)=>{
        console.log("error")
        console.log(error)
      }
  )
}


// 무한 스크롤용 API
const load = async ($state) => {
  console.log("loading...");
  console.log("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!지금 서버로 보낸다!!!")
  const size = import.meta.env.VITE_ATTR_LIST_SIZE;
  const start = page * size - size;

  // props로 들어온 코드는 들어가야한다.
  try {
    getAttrations(
      {
        sido: sido.value,
        gugun : gugunCode.value,
        type : typeInfo.value,
        start: start,
        listsize: size,
        title : title.value
      },
      ({ data }) => {
        //console.log("ATTRLIST : " + response.data);
        console.log("서버에서 리스트 모두를 받아온다 : ")
        console.log(data)
        const json = data;
        console.log($state)
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
        @change-gugun="changeGugun" 
        @change-type="changeType">
      </TripFilter>
      <TripSearch @search="search">
      </TripSearch>
    </div>
    <div class="attr-list">
      <div v-for="(attraction, index) in attrList">
        <div id="attr-item">
          <AttractionItem
            :attraction="attraction.title"
            :startDate="attraction.startDate"
            :destDate="attraction.destDate"
            :description="attraction.overview"
            :index="index"
            :lat="attraction.latitude"
            :lng="attraction.longitude"
          />
        </div>
      </div>
    <infinite-loading @infinite="load"></infinite-loading>
    </div>
  </div>
</template>

<style scoped>
.attr {
  display: flex;
  flex-direction: column;
  width: auto;
}
.input-group{
  
}
.attr-list {
  flex-flow: 2;
}


</style>
