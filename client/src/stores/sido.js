import { ref } from "vue";
import { defineStore } from "pinia";
import seoul from "@/assets/img/sido/1_seoul.jpg";
import incheon from "@/assets/img/sido/2_incheon.jpg";
import daejeon from "@/assets/img/sido/3_daejeon.jpg";
import daegu from "@/assets/img/sido/4_daegu.jpg";
import gwangju from "@/assets/img/sido/5_gwangju.jpg";
import busan from "@/assets/img/sido/6_busan.jpg";
import ulsan from "@/assets/img/sido/7_ulsan.jpg";
import sejong from "@/assets/img/sido/8_sejong.jpg";
import gyeonggido from "@/assets/img/sido/31_gyeonggi-do.jpg";
import Gangwondo from "@/assets/img/sido/32_Gangwondo.jpg";
import chungbuk from "@/assets/img/sido/33_chungbuk.jpg";
import chungnam from "@/assets/img/sido/34_chungnam.jpg";
import kyungbuk from "@/assets/img/sido/35_kyungbuk.jpg";
import kyungnam from "@/assets/img/sido/36_kyungnam.jpg";
import jeolbuk from "@/assets/img/sido/37_jeolbuk.jpg";
import jeolnam from "@/assets/img/sido/38_jeolnam.jpg";
import jeju from "@/assets/img/sido/39_jeju.jpg";

export const useSidoStore = defineStore("sidoStore", () => {
	const sidoImages = ref([
		{
			name: "전체",
			code: "0",
			description:
			"한국, 남한은 동아시아의 한반도 군사 분계선 남부에 위치한 국가이다. 현정체제는 대한민국 제6공화국이다. 대한민국의 국기는 대한민국 국기법에 따라 태극기이며, 국가는 관습상 애국가, 국화는 관습상 무궁화이다. 공용어는 한국어와 한국 수어이다. 수도는 서울이다. 인구는 2023년을 기준으로 약 5,174만 명으로, 전체 인구 중 절반이(약 2,624만 명) 수도권에 살고 있다.",
			image: "./src/assets/img/sido/0_korea.jpg",
		},
		{
			name: "서울",
			code: "1",
			description:
				"대한민국의 수도인 서울은 현대적인 고층 빌딩, 첨단 기술의 지하철, 대중문화와 사찰, 고궁, 노점상이 공존하는 대도시입니다. 주목할 만한 명소로는 곡선으로 이루어진 외관과 옥상 공원을 특징으로 하는 초현대적 디자인의 컨벤션 홀인 동대문디자인플라자, 한때 7,000여 칸의 방이 자리하던 경복궁, 회화나무와 소나무 고목이 있는 조계사가 있습니다.",
			image: "./src/assets/img/sido/1_seoul.jpg",
		},
		{
			name: "인천",
			code: "2",
			description:
				"인천광역시는 대한민국 북서부에 있는 광역시입니다. 서쪽으로 서해, 동쪽으로 서울특별시 강서구, 경기도 부천시, 남동쪽으로 시흥시, 북쪽으로 김포시와 접합니다. 인천항과 인천국제공항을 중심으로 제조업과 물류와 산업이 발달했습니다. ",
			image: "./src/assets/img/sido/2_incheon.jpg",
		},
		{
			name: "대전",
			code: "3",
			description:
				"대전광역시는 대한민국의 중앙부에 있는 광역시입니다. 경부고속철도, 경부선, 호남선 철도가 분기하고, 경부고속도로와 호남고속도로지선, 통영대전고속도로, 서산영덕고속도로 등 주요 고속도로가 연결되는 교통의 중심입니다.",
			image: "./src/assets/img/sido/3_daejeon.jpg",
		},
		{
			name: "대구",
			code: "4",
			description:
				"대구광역시는 대한민국의 동남부 내륙에 위치한 광역시입니다. 동쪽으로 경상북도 경산시, 영천시, 청송군, 서쪽으로 구미시, 고령군, 성주군, 칠곡군, 북쪽으로 의성군, 남쪽으로 청도군, 경상남도 창녕군과 인접합니다. 조선시대에는 경상감영 소재지로서 영남 지방의 중심지였습니다.",
			image: "./src/assets/img/sido/4_daegu.jpg",
		},
		{
			name: "광주",
			code: "5",
			description:
				"광주광역시는 대한민국의 남서부에 있는 광역시입니다. 남동쪽으로 전라남도 화순군, 북동쪽으로 전라남도 담양군, 서쪽으로 전라남도 함평군, 서남쪽으로 전라남도 나주시, 북쪽으로 전라남도 장성군과 접합니다. 시청 소재지는 서구 치평동이고, 행정 구역은 5구 95동입니다.",
			image: "./src/assets/img/sido/5_gwangju.jpg",
		},
		{
			name: "부산",
			code: "6",
			description:
				"부산광역시는 대한민국 남동부에 위치한 광역시입니다. 대한민국의 제2의 도시이자 최대의 해양 도시이며, 부산항을 중심으로 해상 무역과 물류 산업이 발달했습니다. 일본과는 대한해협을 사이에 두고 마주하고 있습니다. 시청 소재지는 연제구 연산동이며, 행정구역은 15구 1군입니다.",
			image: "./src/assets/img/sido/6_busan.jpg",
		},
		{
			name: "울산",
			code: "7",
			description:
				"울산광역시는 대한민국 남동부에 있는 광역시입니다. 서쪽으로 밀양시, 양산시, 청도군, 북쪽으로 경주시, 남쪽으로 부산광역시 기장군과 접합니다. 태화강이 울산광역시를 통과하여 동해로 흐르며, 동해안에 울산항과 방어진항, 온산항이 위치합니다. ",
			image: "./src/assets/img/sido/7_ulsan.jpg",
		},
		{
			name: "세종특별자치시",
			code: "8",
			description:
				"세종특별자치시는 대한민국의 정부기관이 산재한 정부세종청사와 행정중심복합도시 기능을 수행하는 특별자치시입니다. 국토 균형발전의 가치를 실현하고 서울의 과밀화를 해결하기 위해서 계획 및 건설 되었습니다.",
			image: "./src/assets/img/sido/8_sejong.jpg",
		},
		{
			name: "경기도",
			code: "31",
			description:
				"경기도는 대한민국의 북서부에 있는 도입니다. 수도권의 서울특별시와 인천광역시를 둘러싸고 있고, 동쪽으로는 강원특별자치도, 서쪽으로 황해, 남쪽으로는 충청남도 및 충청북도와 접하고 있습니다. ",
			image: "./src/assets/img/sido/31_gyeonggi-do.jpg",
		},
		{
			name: "강원도",
			code: "32",
			description:
				"강원특별자치도는 대한민국의 북동부에 있는 특별자치도입니다. 동쪽은 동해, 서쪽은 경기도, 남쪽은 충청북도·경상북도와 접하며, 북쪽은 조선민주주의인민공화국의 강원도와 경계를 이루고 있습니다. ",
			image: "./src/assets/img/sido/32_Gangwondo.jpg",
		},
		{
			name: "충청북도",
			code: "33",
			description:
				"충청북도는 대한민국의 중부에 위치하는 도입니다. 대한민국의 도 중에서 유일하게 바다와 접하지 않는 내륙도입니다. 서쪽으로 대전광역시, 세종특별자치시, 충청남도, 동쪽으로 경상북도, 남쪽으로 전라북도, 북쪽으로 경기도, 강원특별자치도와 접합니다. ",
			image: "./src/assets/img/sido/33_chungbuk.jpg",
		},
		{
			name: "충청남도",
			code: "34",
			description:
				"충청남도는 대한민국의 중부에 위치하는 도입니다. 동쪽으로 대전광역시, 세종특별자치시, 충청북도, 남쪽으로 전라북도, 북쪽으로 경기도와 접합니다.",
			image: "./src/assets/img/sido/34_chungnam.jpg",
		},
		{
			name: "경상북도",
			code: "35",
			description:
				"경상북도는 대한민국 남동부에 있는 도입니다. 동쪽으로는 동해, 서쪽으로는 전라북도·충청북도, 남쪽으로는 대구광역시를 둘러싸며 울산광역시·경상남도와 접하고, 북쪽으로는 강원특별자치도와 경계를 이룹니다. 행정구역은 10시 12군입니다.",
			image: "./src/assets/img/sido/35_kyungbuk.jpg",
		},
		{
			name: "경상남도",
			code: "36",
			description:
				"경상남도는 대한민국 남동부에 있는 도입니다. 남쪽으로는 남해, 동쪽으로는 부산광역시· 울산광역시, 서쪽으로는 전라남도·전라북도와 경계를 이루고, 북쪽으로는 대구광역시·경상북도와 접합니다. 행정구역은 8시 10군이며, 대한민국의 행정 구역 중 관할 면적이 네 번째로 넓습니다",
			image: "./src/assets/img/sido/36_kyungnam.jpg",
		},
		{
			name: "전라북도",
			code: "37",
			description:
				"전라북도는 대한민국의 남서부에 있는 도입니다. 서쪽으로 황해에 면하고, 동쪽으로는 소백산맥을 경계로 경상남도·경상북도, 남쪽으로 전라남도, 북쪽으로는 충청남도·충청북도와 경계를 이룹니다.",
			image: "./src/assets/img/sido/37_jeolbuk.jpg",
		},
		{
			name: "전라남도",
			code: "38",
			description:
				"전라남도는 대한민국의 남서부에 있는 도입니다. 광주광역시를 둘러싸며, 서쪽으로 황해에 면하고, 북쪽으로 전라북도, 동쪽으로는 소백산맥의 지리산과 섬진강을 경계로 경상남도, 남쪽으로는 남해를 경계로 제주특별자치도가 있습니다.",
			image: "./src/assets/img/sido/38_jeolnam.jpg",
		},
		{
			name: "제주도",
			code: "39",
			description:
				"제주특별자치도는 대한민국의 제주도와 부속 섬들을 관할하는 특별자치도입니다. 대한민국에서 가장 큰 섬인 제주도 본섬을 비롯하여 마라도, 우도, 추자군도 등을 포함한 유인도 8개, 무인도 55개로 구성되어 있습니다.",
			image: "./src/assets/img/sido/39_jeju.jpg",
		},
	]);

	const sido = ref(sidoImages.value);

	const initSido = () => {
		sido.value = sidoImages.value;
	}

	const searchByTitle = (title) =>{
		sido.value = sidoImages.value.filter((item)=>{
			return item.name.includes(title);
		})
	}

	const init = () =>{

	}

	return { sidoImages, searchByTitle, initSido, sido };
});
