import "./assets/main.css";

import { createApp } from "vue";
import { createPinia } from "pinia";
import piniaPluginPersistedstate from "pinia-plugin-persistedstate";
import InfiniteLoading from "v3-infinite-loading"; // 무한 스크롤링을 위한 라이브러리
import "v3-infinite-loading/lib/style.css";

import App from "./App.vue";
import router from "./router";

import "bootstrap";

const app = createApp(App);
const pinia = createPinia();

pinia.use(piniaPluginPersistedstate);

app.use(pinia);
// app.use(createPinia().use(piniaPluginPersistedstate));
app.use(router);

app.component("infinite-loading", InfiniteLoading); //컴포넌트 등록

app.mount("#app");
