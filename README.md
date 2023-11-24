# Cosmopolitan
<!-- ## :dart: 우삼겹: 우리동네 맛집 삼겹줄 -->
<p align='center'>

</p>
<!-- 1d9GD-F2knr3Vmlr8i4U3MS1pUl6NN58C -->
<p align='center'>


<!-- https://github.com/Cosmopolitan777/Cosmopolitan/assets/127120819/ef5597c1-6383-4c63-bb26-f24e75d795e4 -->
![ezgif com-gif-maker](https://github.com/Cosmopolitan777/Cosmopolitan/assets/61008837/6cc3a915-0b28-4271-962c-84a475d37537)


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
- **회원정보수정 및 삭제 기능** - CRUD 사용
- **내 정보 페이지** - 유저 정보 및 여행 계획 조회
- **페이지 보안성 강화** - JWT 토큰으로 인증 강화

<details>
<summary>칵테일 데이터 크롤링</summary>
<div markdown="1">

 ![image](https://github.com/Cosmopolitan777/Cosmopolitan/assets/127190327/5230d85f-c10a-4dc8-b075-22e33f73f865)
![image](https://github.com/Cosmopolitan777/Cosmopolitan/assets/127190327/43bb5ef0-80db-4410-8015-2a947919a36b)

English Highball|11338|Alcoholic|Ordinary Drink|Highball glass|Brandy|Gin|Sweet Vermouth|Carbonated water|Lemon peel|null|null|null|null|null|null|null|null|null|null|3/4 oz |3/4 oz |3/4 oz |null|null|null|null|null|null|null|null|null|null|null|null|null|https://www.thecocktaildb.com/images/media/drink/dhvr7d1504519752.jpg|브랜디, 진, 스위트 베르무트를 하이볼 글래스에 얼음과 함께 붓습니다. 탄산수를 채웁니다. 레몬 껍질 트위스트를 넣고 저은 후 서빙합니다. (진저에일은 기호에 따라 탄산수로 대체 가능합니다.)
</div>
</details>

<details>
<summary>칵테일 추천 기능</summary>
<div markdown="1">

![스크린샷 2023-05-15 13 57 39](https://github.com/Cosmopolitan777/Cosmopolitan/assets/127120819/e2d248e8-1c52-4227-90d5-bb06db12e773)


![스크린샷 2023-05-15 13 57 58](https://github.com/Cosmopolitan777/Cosmopolitan/assets/127120819/3f41496d-ebbc-4b80-8b29-209c669b43e6)



</div>
</details>

<details>
<summary>카카오 로그인</summary>
<div markdown="1">

[screen-recording (11).webm](https://github.com/Cosmopolitan777/Cosmopolitan/assets/127120819/52cf0b01-c173-438e-bc7a-20c667146240)

</div>
</details>

## :arrows_counterclockwise: 서비스 흐름

### 메인 화면

![메인_화면](/uploads/36d345a7b2ba4259d70c4d01d826577c/메인_화면.gif)


### 여행 계획
![여행계획](/uploads/b4f6e5feef2d34df0acfc760485267cd/여행계획.gif)

<!-- <img width="800" alt="image" src="https://user-images.githubusercontent.com/61008837/227681564-b11c528d-f9c6-4740-a8e5-d5d68718ee13.png">
<img width="800" alt="image" src="https://user-images.githubusercontent.com/61008837/227681579-0b4730a5-43a9-4dfb-babd-50edd64c65fa.png">
<img width="800" alt="image" src="https://user-images.githubusercontent.com/61008837/227681589-afb888c6-e02d-46ec-85e0-8495d14221e2.png"> -->






<!-- <p align='center' width="800">https://user-images.githubusercontent.com/61008837/236637691-0bea1299-eb87-4318-8810-1b39b996f2c3.mp4</p> -->

<br/>

## :white_check_mark:프로젝트 구동 방법 
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


## :shipit: 팀원 소개

|                                                       배진현(팀장)                                                       |                                                                         최자영(팀원)                                                                         |                                                       김지효(팀원)                                                       |                                                       정유진(팀원)                                                       |                                                       홍의채(팀원)                                                       |
| :---------------------------------------------------------------------------------------------------------------------: | :---------------------------------------------------------------------------------------------------------------------------------------------------------: | :---------------------------------------------------------------------------------------------------------------------: | :---------------------------------------------------------------------------------------------------------------------: | :---------------------------------------------------------------------------------------------------------------------: |
| <img src="https://drive.google.com/uc?id=1C_DYRFIctedL9eR1-QuLfxDLXYqIguIG" alt="img" height="150px" width="150px" /> | <img src="https://drive.google.com/uc?id=1PCJHyAyF1aOM_ia3ywzc1cIl-vBpFaMb" alt="img" height="150px" width="150px" /> | <img src="https://drive.google.com/uc?id=1HrK9JMOcgm9W2OFGtRuKZmNyZkYf1Ixf" alt="img" height="150px" width="150px" /> | <img src="https://drive.google.com/uc?id=1d9GD-F2knr3Vmlr8i4U3MS1pUl6NN58C" alt="img" height="150px" width="150px" /> | <img src="https://drive.google.com/uc?id=1C7WAZmZf1IMHMKsrTi_KIqvrz1QT1v4O" alt="img" height="150px" width="150px" /> |
|                                      [coing-ye](https://github.com/coing-ye)                                     |                                                           [jayoung977](https://github.com/jayoung977)                                                           |                                            [ji-dawn](https://github.com/ji-dawn)                                            |                                  [8566uyu](https://github.com/8566uyu)       |                                  [UichaeHong](https://github.com/UichaeHong)       

