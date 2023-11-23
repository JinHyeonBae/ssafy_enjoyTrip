import { computed, ref } from "vue";
import { defineStore } from "pinia";

export const useAttrStore = defineStore("attrStore", () => {

  const userId = ref("ssafy");

  const title = ref("");
  const memo = ref("");
  const startDate = ref("");
  const destDate = ref("");
  const selectedAttrList = ref([]);

  const sido = ref("");
  const gugun = ref("");
  const typeInfo = ref("");
  const lat = ref(0);
  const lng = ref(0);

  const getAttrList = computed(()=> selectedAttrList.value);
  
  const getFilteredAttrList = () => {
    selectedAttrList.value = selectedAttrList.value.filter((item, index)=>{
      return selectedAttrList.value.indexOf(item) === index;
    })
  }
  // 저장
  const addToAttrList = (item) => {
    console.log("ADDTOLIST");
    console.log(item)
    let check = false;
    selectedAttrList.value.forEach((attr)=>{
      // console.log("----------------------------------")
      // console.log("ATTR INDEX");
      // console.log(attr.index);
      // console.log("item INDEX");
      // console.log(item.index);
      // console.log("----------------------------------")
      if(attr.index == item.index){
        check = true;
        return;
      }
    })
    if(check) return;

    selectedAttrList.value.push(item);
  };

  const removeToAttrList = (attr) => {
    return selectedAttrList.value.filter((item, index)=>{
      return item.index !== attr.index;
    })
  }

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

  const setSidoCode = (s) => {
    sido.value = s;
  }

  const setGugunCode = (g) => {
    gugun.value = g;
  };

  const setTypeInfo = (i) => {
    typeInfo.value = i;
  };

  const getStartDate = () => {
    return startDate.value;
  };

  const getDestDate = () => {
    return destDate.value;
  };

  const getSidoCode = () => {
    return sido.value;
  }

  const getLat = () => {
    return lat.value;
  }

  const getLng = () => {
    return lng.value;
  }

  //   const changeMenuState = () => {
  //     menuList.value = menuList.value.map((item) => ({
  //       ...item,
  //       show: !item.show,
  //     }));
  //   };


  const getTitles = () => {
    const indexes = ref("");
    selectedAttrList.value.forEach((item) => {
      indexes.value += item.title+"-";
    });
    return indexes.value;
  };

  const getFullDate = () => {
    console.log(startDate.value + "-" + destDate.value);
    return startDate.value + "-" + destDate.value;
  };

  const getAttrData = () => {
    return {
      user_id: userId.value,
      title: title.value,
      memo: memo.value,
      sido : sido.value,
      gugun : gugun.value,
      typeInfo : typeInfo.value,
      start_date: startDate.value,
      end_date: destDate.value,
      content: getTitles(),
    };
  };

  const getMapData = () =>{
    return {
      user_id: userId.value,
      title: title.value,
      memo: memo.value,
      content: getTitles(),
      lag : lat.value,
      lng : lng.value
    }
  }

  return {
    selectedAttrList,
    startDate,
    destDate,
    getAttrList,
    getFullDate,
    getFilteredAttrList,
    getMapData,
    getSidoCode,
    addToAttrList,
    removeToAttrList,
    changeStartDate,
    changeDestDate,
    getStartDate,
    getDestDate,
    getAttrData,
    getLng,
    getLat,
    setTitle,
    setMemo,
    setSidoCode,
    setGugunCode,
    setTypeInfo,
  };
},
// { 
//   persist: { storage: sessionStorage } 
// });
);
// export default mapCursorStore = defineStore("cursorStore", ()=>{

//   const stations = ref([]);
//   const selectedStations = ref([])

//   const getStations = ()=>{
//     return stations.value;
//   }

//   const getSelectionStations = ()=>{
//     return stations.value;
//   }

//   const setStation = (station) => {
//     stations.value.push(station);
//   }

//   const setSelectedStation = (station) => {
//     stations.value.push(station);
//   }

  

//   return {

//   }

// })