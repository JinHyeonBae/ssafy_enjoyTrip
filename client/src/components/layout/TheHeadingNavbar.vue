<script setup>
import { useMenuStore } from "@/stores/menu";
import { useMemberStore } from "@/stores/member";
import { storeToRefs } from "pinia";

const menuStore = useMenuStore();
const memberStore = useMemberStore();

// 반응형을 유지하면서 스토어에서 속성을 추출하려면, storeToRefs()를 사용
// https://pinia.vuejs.kr/core-concepts/
const { menuList } = storeToRefs(menuStore);
const { changeMenuState } = menuStore;

const { userInfo } = storeToRefs(memberStore);
const { userLogout } = memberStore;

const logout = () => {
  console.log("로그아웃!!!!");
  changeMenuState();
  userLogout(userInfo.value.userId);
};
</script>
<!-- bg-body-tertiary -->
<template>
  <nav
    class="navbar navbar-expand-lg sticky-top"
    style="background-color: #f8f5fa"
  >
    <div class="container">
      <router-link :to="{ name: 'main' }" class="navbar-brand">
        <b
          >룰루랄라투어

          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="16"
            height="16"
            fill="currentColor"
            class="bi bi-truck-front-fill"
            viewBox="0 0 16 16"
          >
            <path
              d="M3.5 0A2.5 2.5 0 0 0 1 2.5v9c0 .818.393 1.544 1 2v2a.5.5 0 0 0 .5.5h2a.5.5 0 0 0 .5-.5V14h6v1.5a.5.5 0 0 0 .5.5h2a.5.5 0 0 0 .5-.5v-2c.607-.456 1-1.182 1-2v-9A2.5 2.5 0 0 0 12.5 0h-9ZM3 3a1 1 0 0 1 1-1h8a1 1 0 0 1 1 1v3.9c0 .625-.562 1.092-1.17.994C10.925 7.747 9.208 7.5 8 7.5c-1.208 0-2.925.247-3.83.394A1.008 1.008 0 0 1 3 6.9V3Zm1 9a1 1 0 1 1 0-2 1 1 0 0 1 0 2Zm8 0a1 1 0 1 1 0-2 1 1 0 0 1 0 2Zm-5-2h2a1 1 0 1 1 0 2H7a1 1 0 1 1 0-2Z"
            />
          </svg>
        </b>
      </router-link>
      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarScroll"
        aria-controls="navbarScroll"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarScroll">
        <ul
          class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll"
          style="--bs-scroll-height: 100px"
        >
          <li class="nav-item dropdown">
            <a
              class="nav-link dropdown-toggle"
              href="#"
              role="button"
              data-bs-toggle="dropdown"
              aria-expanded="false"
            >
              HELP DESK
            </a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="#">공지사항</a></li>
              <li><a class="dropdown-item" href="#">FAQ</a></li>
            </ul>
          </li>
          <li class="nav-item">
            <router-link :to="{ name: 'board' }" class="nav-link"
              >커뮤니티</router-link
            >
          </li>
        </ul>

        <ul
          class="navbar-nav ms-auto my-2 my-lg-0 navbar-nav-scroll"
          style="--bs-scroll-height: 100px"
        >
          <template v-for="menu in menuList" :key="menu.routeName">
            <template v-if="menu.show">
              <template v-if="menu.routeName === 'user-logout'">
                <li class="nav-item">
                  <router-link
                    to="/"
                    @click.prevent="logout"
                    class="nav-link"
                    >{{ menu.name }}</router-link
                  >
                </li>
              </template>
              <template v-else>
                <li class="nav-item">
                  <router-link
                    :to="{ name: menu.routeName }"
                    class="nav-link"
                    >{{ menu.name }}</router-link
                  >
                </li>
              </template>
            </template>
          </template>
        </ul>
      </div>
    </div>
  </nav>
</template>

<style scoped></style>
