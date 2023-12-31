import { localAxios, fileAxios } from "@/util/http-commons";

const local = localAxios(); //axios instance
const file = fileAxios();
const url = "/board";

function listArticle(param, success, fail) {
  local.get(`${url}`, { params: param }).then(success).catch(fail);
}

function latestArticles(success, fail) {
  local.get(`${url}/latest`).then(success).catch(fail);
}

async function detailArticle(articleno, success, fail) {
  await local.get(`${url}/${articleno}`).then(success).catch(fail);
}

async function registArticle(formData, success, fail) {
  console.log("boardjs article", formData);
  await file.post(`${url}`, formData).then(success).catch(fail);
}

function getModifyArticle(articleno, success, fail) {
  local.get(`${url}/modify/${articleno}`).then(success).catch(fail);
}

function modifyArticle(article, success, fail) {
  local.put(`${url}`, JSON.stringify(article)).then(success).catch(fail);
}

function deleteArticle(articleno, success, fail) {
  local.delete(`${url}/${articleno}`).then(success).catch(fail);
}

export {
  listArticle,
  latestArticles,
  detailArticle,
  registArticle,
  getModifyArticle,
  modifyArticle,
  deleteArticle,
};
