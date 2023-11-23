import { localAxios } from "@/util/http-commons";

const local = localAxios();

async function userConfirm(param, success, fail) {
  console.log("param", param);
  await local.post(`/user/login`, param).then(success).catch(fail);
  console.log("userConfirm ok");
}

async function userJoin(user, success, fail) {
  await local.post(`/user/join`, user).then(success).catch(fail);
}

async function userCheckId(userid, success, fail) {
  await local.get(`/user/check/${userid}`).then(success).catch(fail);
}

async function userGetInfo(userid, success, fail) {
  await local.get(`/user//${userid}`).then(success).catch(fail);
}

async function userModify(user, success, fail) {
  await local.put(`/user/modify`, user).then(success).catch(fail);
}

async function userDelete(userid, success, fail) {
  await local.delete(`/user/${userid}`).then(success).catch(fail);
}

async function findById(userid, success, fail) {
  local.defaults.headers["Authorization"] =
    sessionStorage.getItem("accessToken");
  // localStorage.getItem("accessToken");
  await local.get(`/user/info/${userid}`).then(success).catch(fail);
}

async function tokenRegeneration(user, success, fail) {
  local.defaults.headers["refreshToken"] =
    sessionStorage.getItem("refreshToken"); //axios header에 refresh-token 셋팅
  // localStorage.getItem("refreshToken"); //axios header에 refresh-token 셋팅
  await local.post(`/user/refresh`, user).then(success).catch(fail);
}

async function logout(userid, success, fail) {
  await local.get(`/user/logout/${userid}`).then(success).catch(fail);
}

export {
  userConfirm,
  userJoin,
  userCheckId,
  userGetInfo,
  userModify,
  userDelete,
  findById,
  tokenRegeneration,
  logout,
};
