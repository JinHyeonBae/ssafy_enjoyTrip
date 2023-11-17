import { computed, ref } from "vue";
import { defineStore } from "pinia";

export const useAttrStore = defineStore("attrStore", () => {
  //   const attrList = ref([{ name: "", attractionList: [], startDate: "" }]);

  const name = ref("");
  const selectedAttrList = ref([]);
  const startDate = ref("");
  const destDate = ref("");

  const getDataAll = computed(() => selectedAttrList.value);
  // 저장
  const addToAttrList = (attrItem) => {
    selectedAttrList.value.push(attrItem);
  };

  const changeStartDate = (start) => {
    console.log("STARTDATE :" + start);
    startDate.value = start;
  };

  const changeDestDate = (dest) => {
    console.log("destDATE :" + dest);
    destDate.value = dest;
  };

  const getStartDate = () => {
    return startDate.value;
  };

  const getDestDate = () => {
    return destDate.value;
  };

  const getFullDate = () => {
    return startDate.value + " ~ " + destDate.value;
  };

  //   const changeMenuState = () => {
  //     menuList.value = menuList.value.map((item) => ({
  //       ...item,
  //       show: !item.show,
  //     }));
  //   };
  return {
    selectedAttrList,
    startDate,
    destDate,
    getDataAll,
    addToAttrList,
    changeStartDate,
    changeDestDate,
    getStartDate,
    getDestDate,
    getFullDate,
  };
});
