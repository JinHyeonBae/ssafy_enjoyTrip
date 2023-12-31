import { localAxios } from "@/util/http-commons";

const local = localAxios();
const url = "/tourlist";

async function getAttrations(param, success, fail) {
  const { sido, type, gugun, start, listsize, title } = param;
  console.log("param : " +sido + "," + start + "," + listsize);
  await local
    .get(
      `${url}/search?sidoCode=${sido}&gugunCode=${gugun}&contentTypeId=${type}&start=${start}&listsize=${listsize}&title=${title}`,
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

async function searchByTitle(param, success, fail) {
  console.log("param : " + param);
  const {title} = param;
  await local
    .post(`${url}/search-content?title=${title}`, JSON.stringify(param))
    .then(success)
    .catch(fail);
}

async function getUserSchedule(param, success, fail) {
  const {userId} = param;
  local.defaults.headers["userId"] = userId;
  await local
    .get(`${url}/get-schedule`, JSON.stringify(param))
    .then(success)
    .catch(fail);
}

async function deleteUserSchedule(param, success, fail) {
  const {userId, scheduleId} = param;
  
  local.defaults.headers.delete["param"] = JSON.stringify(param);
  
  await local
    .delete(`${url}`)
    .then(success)
    .catch(fail);
}




export { getAttrations, storeSchedule, getUserSchedule, deleteUserSchedule };
