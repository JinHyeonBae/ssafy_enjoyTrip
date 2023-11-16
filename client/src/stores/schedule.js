import { computed, ref } from "vue";
import { defineStore } from "pinia";

export const useAttrStore = defineStore("attrStore", () => {
  //   const attrList = ref([{ name: "", attractionList: [], startDate: "" }]);

  const name = ref("");
  const attrList = ref([]);
  const startDate = ref("");
  const destDate = ref("");

  computed(() => console.log(store.startDate));

  // 저장
  const addAttrList = () => {
    attrList.value.push({ attrItem });
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

  //   const changeMenuState = () => {
  //     menuList.value = menuList.value.map((item) => ({
  //       ...item,
  //       show: !item.show,
  //     }));
  //   };
  return {
    attrList,
    startDate,
    destDate,
    addAttrList,
    changeStartDate,
    changeDestDate,
    getStartDate,
    getDestDate,
  };
});
