import { computed, ref } from "vue";
import { defineStore } from "pinia";

export const useAttrStore = defineStore("attrStore", () => {
  //   const attrList = ref([{ name: "", attractionList: [], startDate: "" }]);
  const userId = ref("ssafy");
  const title = ref("");
  const memo = ref("");
  const selectedAttrList = ref([]);
  const startDate = ref("");
  const destDate = ref("");

  const getDataAll = computed(() => selectedAttrList.value);
  // 저장
  const addToAttrList = (item) => {
    selectedAttrList.value.push(item);
  };

  const changeStartDate = (start) => {
    startDate.value = start;
  };

  const changeDestDate = (dest) => {
    destDate.value = dest;
  };

  const setTitle = (t) => {
    title.value = t;
  };

  const setMemo = (m) => {
    memo.value = m;
  };

  const getStartDate = () => {
    return startDate.value;
  };

  const getDestDate = () => {
    return destDate.value;
  };

  //   const changeMenuState = () => {
  //     menuList.value = menuList.value.map((item) => ({
  //       ...item,
  //       show: !item.show,
  //     }));
  //   };

  const getIndexes = () => {
    const indexes = ref("");
    selectedAttrList.value.forEach((item) => {
      indexes.value += item.index;
    });

    return indexes.value;
  };

  const getFullDate = () => {
    console.log(startDate.value + "-" + destDate.value);
    return startDate.value + "-" + destDate.value;
  };

  const getAllDateAsJson = () => {
    return {
      user_id: userId.value,
      title: title.value,
      memo: memo.value,
      start_date: startDate.value,
      end_date: destDate.value,
      content: getIndexes(),
    };
  };

  return {
    selectedAttrList,
    startDate,
    destDate,
    getDataAll,
    getFullDate,
    addToAttrList,
    changeStartDate,
    changeDestDate,
    getStartDate,
    getDestDate,
    getAllDateAsJson,
    setTitle,
    setMemo,
  };
});
