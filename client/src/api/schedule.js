import { localAxios } from "@/util/http-commons";

const local = localAxios();
const url = "/tourlist";

async function getAttrations(param, success, fail) {
  const { sido, type, gugun, start, listsize } = param;
  console.log("param : " + start + "," + listsize);
  await local
    .get(
      `${url}/search?sidoCode=${sido}&gugunCode=${gugun}&contentTypeId=${type}&start=${start}&listsize=${listsize}`,
      param
    )
    .then(success)
    .catch(fail);
}

async function storeSchedule(param, success, fail) {
  console.log("param : " + param);
  await local
    .post(`${url}/store-schedule`, JSON.stringify(param))
    .then(success)
    .catch(fail);
}


async function getAttrationsByFilter(param, success, fail) {
  const { sido, gugun, type, start, listsize } = param;
  console.log("param : " + start + "," + listsize);
  await local
    .get(
      `${url}/search?sidoCode=${sido}&gugunCode=${gugun}&contentTypeId=${type}&start=${start}&listsize=${listsize}`,
      param
    )
    .then(success)
    .catch(fail);
}

// async function findById(userid, success, fail) {
//   local.defaults.headers["Authorization"] =
//     sessionStorage.getItem("accessToken");
//   await local.get(`/user/info/${userid}`).then(success).catch(fail);
// }

// async function tokenRegeneration(user, success, fail) {
//   local.defaults.headers["refreshToken"] =
//     sessionStorage.getItem("refreshToken"); //axios header에 refresh-token 셋팅
//   await local.post(`/user/refresh`, user).then(success).catch(fail);
// }

// async function logout(userid, success, fail) {
//   await local.get(`/user/logout/${userid}`).then(success).catch(fail);
// }

export { getAttrations, storeSchedule };
