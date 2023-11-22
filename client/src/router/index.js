import { createRouter, createWebHistory } from "vue-router";
import TheMainView from "../views/TheMainView.vue";
// import TheBoardView from "../views/TheBoardView.vue";
import TheElectricChargingStation from "@/views/TheElectricChargingStation.vue";
import ScheduleHome from "@/components/schedule/ScheduleHome.vue";
const router = createRouter({
	history: createWebHistory(import.meta.env.BASE_URL),
	routes: [
		{
			path: "/",
			name: "main",
			component: TheMainView,
		},
		{
			path: "/estations",
			name: "estations",
			component: TheElectricChargingStation,
		},
		{
			path: "/user",
			name: "user",
			component: () => import("@/views/TheUserView.vue"),
			children: [
				{
					path: "login",
					name: "user-login",
					component: () => import("@/components/users/UserLogin.vue"),
				},
				{
					path: "join",
					name: "user-join",
					component: () => import("@/components/users/UserRegister.vue"),
				},
				// {
				// 	path: "join",
				// 	name: "user-join/:type",
				// 	component: () => import("@/components/users/UserRegister.vue"),
				// },
				{
					path: "mypage",
					name: "user-mypage",
					component: () => import("@/components/users/UserMyPage.vue"),
				},
				// {
				//   path: "modify/:userid",
				//   name: "user-modify",
				//   component: () => import("@/components/users/UserModify.vue"),
				// },
			],
		},
		{
			path: "/board",
			name: "board",
			// component: TheBoardView,
			// route level code-splitting
			// this generates a separate chunk (About.[hash].js) for this route
			// which is lazy-loaded when the route is visited.
			component: () => import("../views/TheBoardView.vue"),
			redirect: { name: "article-list" },
			children: [
				{
					path: "list",
					name: "article-list",
					component: () => import("@/components/board/BoardList.vue"),
				},
				{
					path: "view/:articleno",
					name: "article-view",
					component: () => import("@/components/board/BoardDetail.vue"),
				},
				{
					path: "write",
					name: "article-write",
					component: () => import("@/components/board/BoardWrite.vue"),
				},
				{
					path: "modify/:articleno",
					name: "article-modify",
					component: () => import("@/components/board/BoardModify.vue"),
				},
			],
		},
		{
			path: "/schedule",
			name: "schedule",
			props: true,
			redirect: { name: "trip-date" },
			component: ScheduleHome,
			children: [
				{
					path: "list",
					name: "attraction-list",
					props: true,
					component: () => import("@/components/schedule/AttractionList.vue"),
				},
				{
					path: "date",
					name: "trip-date",
					component: () => import("@/components/schedule/TripDate.vue"),
				},
				{
					path: "add-to-list",
					name: "add-schedule",
					component: () => import("@/components/schedule/AddAttractionModal.vue"),
				},
			],
		},
	],
	//페이지 이동시 맨위로 스크롤
	scrollBehavior() {
		return { top: 0 };
	},
});

export default router;
