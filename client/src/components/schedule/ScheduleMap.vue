<script setup>
import { ref, watch, onMounted, computed } from "vue";
import { useAttrStore } from "@/stores/schedule";

let map;
const positions = ref([]);
const markers = ref([]);

const store = useAttrStore();

// 선택한 부분을 말하는 것 같다..ㅠㅠㅠㅠ흑흑
//const props = defineProps({ stations: Array, selectStation: Object });
const stations = ref([]);

stations.value = store.getAttrList
// 클릭한 곳에 지도의 중심을 이동시키는 메서드 (이게 있어야 지도에서 더블클릭 후 움직임이 가능해짐)
// watch(
//   () => selectStation.value,
//   () => {
//     // 이동할 위도 경도 위치를 생성합니다
//     console.log()
//     var moveLatLon = new kakao.maps.LatLng(
//       selectStation.lat,
//       selectStation.lng
//     );

//     // 지도 중심을 부드럽게 이동시킵니다
//     // 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
//     map.panTo(moveLatLon);
//   },
//   { deep: true } // 깊은 감시
// );

watch(
  () => stations.value,
  () => {
    positions.value = [];
    stations.value.forEach((station) => {
      let obj = {};
      obj.latlng = new kakao.maps.LatLng(station.lat, station.lng);
    
      obj.title = station.statNm;
      positions.value.push(obj);
      map.panTo(obj.latlng);
    });
    loadMarkers();
  },
  { deep: true }
);

onMounted(() => {
  console.log("HELLO THIS IS MAP PART")
  if (window.kakao && window.kakao.maps) {
    console.log("THIS IS INITMAP")
    initMap();
  } else {
    const script = document.createElement("script");
    console.log("MAP이 없어요!")
    // autoload = false는 꼭 설정해주자!
    script.src = `//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=${
      import.meta.env.VITE_KAKAO_MAP_SERVICE_KEY
    }&libraries=services,clusterer`;
    /* global kakao */
    script.onload = () => kakao.maps.load(() => initMap());
    document.head.appendChild(script);
  }
});

const initMap = () => {
  const container = document.getElementById("map");
  const options = {
    center: new kakao.maps.LatLng(33.450701, 126.570667),
    level: 3,
  };
  map = new kakao.maps.Map(container, options);

  //loadMarkers();
};

const loadMarkers = () => {
  // 현재 표시되어있는 marker들이 있다면 map에 등록된 marker를 제거한다.
  deleteMarkers();
  console.log("WHY??1")
  // // 마커 이미지를 생성합니다
    const imgSrc = "/src/assets/ssafy_logo.png";
  // 마커 이미지의 이미지 크기 입니다
    const imgSize = new kakao.maps.Size(24, 35);
    const markerImage = new kakao.maps.MarkerImage(imgSrc, imgSize);

  // 마커를 생성합니다
  markers.value = [];

  // 마커를 띄울 로직
  console.log(positions.value.length)
  if(positions.value.length > 0){
    positions.value.forEach((position) => {
      const marker = new kakao.maps.Marker({
        map: map, // 마커를 표시할 지도
        position: position.latlng, // 마커를 표시할 위치
        title: position.title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됨.
        clickable: true, // // 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
        image: markerImage, // 마커의 이미지
      });

      console.log(marker)
      markers.value.push(marker);
    })
  };

  // 4. 지도를 이동시켜주기
  // 배열.reduce( (누적값, 현재값, 인덱스, 요소)=>{ return 결과값}, 초기값);
  // 마커들의 범위를 지정해서, 모든 마커가 지도에 한 번에 들어올 수 있도록 한다.
  const bounds = positions.value.reduce(
    (bounds, position) => bounds.extend(position.latlng),
    new kakao.maps.LatLngBounds()
  );

  map.setBounds(bounds);
};

const deleteMarkers = () => {
  if (markers.value.length > 0) {
    markers.value.forEach((marker) => marker.setMap(null));
  }
};
</script>

<template>
    <div id="map"></div>
</template>

<style scoped>


#map {
  width: 100%;
  overflow-x: unset;
  height: 100vh;
  z-index: 3;
}
</style>
