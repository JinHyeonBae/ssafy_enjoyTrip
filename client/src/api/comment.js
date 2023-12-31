import { localAxios } from "@/util/http-commons";

const local = localAxios(); //axios instance
const url = "/comment";

function listComment(articleno, success, fail) {
  local.get(`${url}/${articleno}`).then(success).catch(fail);
}

function registComment(comment, success, fail) {
  local.post(`${url}`, JSON.stringify(comment)).then(success).catch(fail);
}

function modifyComment(comment, success, fail) {
  local.put(`${url}`, JSON.stringify(comment)).then(success).catch(fail);
}

function deleteComment(comment, success, fail) {
  console.log("comment!!!!", comment);
  local.defaults.headers.delete["comment"] = JSON.stringify(comment);
  console.log(comment);
  local.delete(`${url}`).then(success).catch(fail);
}

export { listComment, registComment, modifyComment, deleteComment };
