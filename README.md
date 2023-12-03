# 🚎 룰루랄라 투어
![트립_1분원테이크](https://github.com/JinHyeonBae/ssafy_enjoyTrip/assets/47708313/89969892-ecc1-4481-a8ac-fd0da0504b9e)
<!-- ## :dart: 우삼겹: 우리동네 맛집 삼겹줄 -->
<p align='center'>

</p>
<!-- 1d9GD-F2knr3Vmlr8i4U3MS1pUl6NN58C -->
<p align='center'>


<!-- https://github.com/Cosmopolitan777/Cosmopolitan/assets/127120819/ef5597c1-6383-4c63-bb26-f24e75d795e4 -->
![트립_1분원테이크](/uploads/1b97afcd261a1e7dee543e3ae8abec4f/트립_1분원테이크.gif)
<!-- https://github.com/Cosmopolitan777/Cosmopolitan/assets/127120819/595033d0-becd-4563-94b5-76929039107b -->

 
</p>

<!-- ## :mag_right: 기획 배경
-- 칵테일 레시피를 공유하는 서비스 -->
<!-- - 자치구별로 한눈에 맛집을 확인
- 맛집을 추천받고 또 추천도 할 수 있는 서비스 -->

## :star: 서비스 소개  
### 여행지 계획 서비스
<!-- ### 생생한 후기를 확인할 수 있습니다.
> -  -->

## :open_file_folder: 주요 기능
- **메인 화면** - 전체 및 시도별 설명, 검색 기능
- **커뮤니티** - 게시글 생성, 게시글 내용 조회 및 삭제
- **게시판 페이지** - 게시글 생성, 게시글 내용 조회 및 삭제
- **로그인, 회원가입** - CRUD 기능 구현
- **여행 계획 페이지** - 여행지 리스트 조회 및 여행지 필터링, 카카오맵을 활용한 마커, 선을 렌더링 
- **회원정보 수정 및 삭제 기능** - CRUD 사용
- **내 정보 페이지** - 유저 정보 및 여행 계획 조회
- **페이지 보안성 강화** - JWT 토큰으로 인증 강화



## :arrows_counterclockwise: 서비스 흐름

### 메인 화면
![main](https://github.com/JinHyeonBae/ssafy_enjoyTrip/assets/47708313/557933b3-63d5-46f1-beb8-cb6a0cb6413d)
![메인 화면](https://github.com/JinHyeonBae/ssafy_enjoyTrip/assets/47708313/b690d6d6-b99c-44da-a8e9-f30eb84d0a0a)


### 게시판 조회, 수정, 삭제
![게시판자성수정삭제조회](https://github.com/JinHyeonBae/ssafy_enjoyTrip/assets/47708313/92314ebf-f8af-4d64-974a-4dd194890453)
### 댓글 조회, 수정, 삭제
![댓글작성수정삭제조회](https://github.com/JinHyeonBae/ssafy_enjoyTrip/assets/47708313/dc3e049a-cf1a-4ad6-9ed5-f652b7cd26bc)

### 여행 계획 페이지
![여행지생성라스트](https://github.com/JinHyeonBae/ssafy_enjoyTrip/assets/47708313/413975d2-46c6-45d8-ae9a-e234d9771e8a)
![여행 검색](https://github.com/JinHyeonBae/ssafy_enjoyTrip/assets/47708313/b5a472e7-1aa4-41f1-80ff-da92139d9a3e)


<!-- <img width="800" alt="image" src="https://user-images.githubusercontent.com/61008837/227681564-b11c528d-f9c6-4740-a8e5-d5d68718ee13.png">
<img width="800" alt="image" src="https://user-images.githubusercontent.com/61008837/227681579-0b4730a5-43a9-4dfb-babd-50edd64c65fa.png">
<img width="800" alt="image" src="https://user-images.githubusercontent.com/61008837/227681589-afb888c6-e02d-46ec-85e0-8495d14221e2.png"> -->



<!-- <p align='center' width="800">https://user-images.githubusercontent.com/61008837/236637691-0bea1299-eb87-4318-8810-1b39b996f2c3.mp4</p> -->

<br/>

## :white_check_mark: 프로젝트 구동 방법 
### git clone
```
git clone https://lab.ssafy.com/wjsrnr20/enjoytrip-vue-seoul-15.git
```
### client

```
cd client
npm i
npm run dev
```

### server
```
cd server
mvn compile
mvn install
mvn package
java -jar ./target/vue-api-0.0.1-SNAPSHOT.jar
```

## :speech_balloon: 보완점
- 선택한 여행지에서 삭제 시 맵에서 선 삭제가 되지 않는 문제


