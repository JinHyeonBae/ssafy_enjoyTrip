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
    drawLine();
  },
  { deep: true }
);

onMounted(() => {
  if (window.kakao && window.kakao.maps) {
    initMap();
  } else {
    const script = document.createElement("script");
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
  // // 마커 이미지를 생성합니다
    const imgSrc = "/src/assets/arrow.png";
  // 마커 이미지의 이미지 크기 입니다
    const imgSize = new kakao.maps.Size(40, 35);
    const markerImage = new kakao.maps.MarkerImage(imgSrc, imgSize);

  // 마커를 생성합니다
  markers.value = [];

  // 마커를 띄울 로직
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

  //drawLine();
};

const deleteMarkers = () => {
  if (markers.value.length >= 1) {
    markers.value.forEach((marker) => marker.setMap(null));
  }
};


const drawLine = () => {
  const moveLine = new kakao.maps.Polyline({
      strokeWeight: 3, // 선의 두께입니다 
      strokeColor: '#1E90FF', // 선의 색깔입니다
      strokeOpacity: 1, // 선의 불투명도입니다 0에서 1 사이값이며 0에 가까울수록 투명합니다
      strokeStyle: 'solid' // 선의 스타일입니다    
  });

// 마우스로 클릭한 위치입니다 

  if (positions.value.length > 1) {

      // // 지도 위에 선이 표시되고 있다면 지도에서 제거합니다
      // deleteClickLine();
      
      // // 지도 위에 커스텀오버레이가 표시되고 있다면 지도에서 제거합니다
      // deleteDistnce();

      // // 지도 위에 선을 그리기 위해 클릭한 지점과 해당 지점의 거리정보가 표시되고 있다면 지도에서 제거합니다
      // deleteCircleDot();

      // 클릭한 위치를 기준으로 선을 생성하고 지도위에 표시합니다
    
      //draw(clickLine, clickPosition);
      for(let i = 1; i < positions.value.length; i++){
        //let path = positions.value
        const pre = positions.value[i-1].latlng;
        const cur = positions.value[i].latlng
        
        let movepath = [pre, cur];
        moveLine.setPath(movepath);    
        moveLine.setMap(map);
      } 
      // 클릭한 지점에 대한 정보를 지도에 표시합니다
      //displayCircleDot(clickPosition, 0);
  }
};

/*
const draw = (clickLine, location) => {
  // 지도 마우스무브 이벤트가 발생했는데 선을 그리고있는 상태이면
  if (drawingFlag){
    
      // 마우스 커서의 현재 위치를 얻어옵니다 
      var mousePosition = location;

      // 마우스 클릭으로 그려진 선의 좌표 배열을 얻어옵니다
      var path = clickLine.getPath();
      
      // 마우스 클릭으로 그려진 마지막 좌표와 마우스 커서 위치의 좌표로 선을 표시합니다
      var movepath = [path[path.length-1], mousePosition];
      moveLine.setPath(movepath);    
      moveLine.setMap(map);
      
      var distance = Math.round(clickLine.getLength() + moveLine.getLength()), // 선의 총 거리를 계산합니다
          content = '<div class="dotOverlay distanceInfo">총거리 <span class="number">' + distance + '</span>m</div>'; // 커스텀오버레이에 추가될 내용입니다
      
      // 거리정보를 지도에 표시합니다
      showDistance(content, mousePosition);   
  }             
};                */

/*
let options = { // Drawing Manager를 생성할 때 사용할 옵션입니다
    map: map, // Drawing Manager로 그리기 요소를 그릴 map 객체입니다
    drawingMode: [ // drawing manager로 제공할 그리기 요소 모드입니다
        kakao.maps.drawing.OverlayType.MARKER,
        kakao.maps.drawing.OverlayType.POLYLINE,
        kakao.maps.drawing.OverlayType.RECTANGLE,
        kakao.maps.drawing.OverlayType.CIRCLE,
        kakao.maps.drawing.OverlayType.POLYGON
    ],
    // 사용자에게 제공할 그리기 가이드 툴팁입니다
    // 사용자에게 도형을 그릴때, 드래그할때, 수정할때 가이드 툴팁을 표시하도록 설정합니다
    guideTooltip: ['draw', 'drag', 'edit'], 
    markerOptions: { // 마커 옵션입니다 
        draggable: true, // 마커를 그리고 나서 드래그 가능하게 합니다 
        removable: true // 마커를 삭제 할 수 있도록 x 버튼이 표시됩니다  
    },
    polylineOptions: { // 선 옵션입니다
        draggable: true, // 그린 후 드래그가 가능하도록 설정합니다
        removable: true, // 그린 후 삭제 할 수 있도록 x 버튼이 표시됩니다
        editable: true, // 그린 후 수정할 수 있도록 설정합니다 
        strokeColor: '#39f', // 선 색
        hintStrokeStyle: 'dash', // 그리중 마우스를 따라다니는 보조선의 선 스타일
        hintStrokeOpacity: 0.5  // 그리중 마우스를 따라다니는 보조선의 투명도
    },
    rectangleOptions: {
        draggable: true,
        removable: true,
        editable: true,
        strokeColor: '#39f', // 외곽선 색
        fillColor: '#39f', // 채우기 색
        fillOpacity: 0.5 // 채우기색 투명도
    },
    circleOptions: {
        draggable: true,
        removable: true,
        editable: true,
        strokeColor: '#39f',
        fillColor: '#39f',
        fillOpacity: 0.5
    },
    polygonOptions: {
        draggable: true,
        removable: true,
        editable: true,
        strokeColor: '#39f',
        fillColor: '#39f',
        fillOpacity: 0.5,
        hintStrokeStyle: 'dash',
        hintStrokeOpacity: 0.5
    }
};*/


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
