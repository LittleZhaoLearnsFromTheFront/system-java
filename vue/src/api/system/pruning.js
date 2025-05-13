import request from '@/utils/request'

// 查询整形修剪管理列表
export function listPruning(query) {
  return request({
    url: '/system/pruning/list',
    method: 'get',
    params: query
  })
}

// 查询整形修剪管理详细
export function getPruning(id) {
  return request({
    url: '/system/pruning/' + id,
    method: 'get'
  })
}

// 新增整形修剪管理
export function addPruning(data) {
  return request({
    url: '/system/pruning',
    method: 'post',
    data: data
  })
}

// 修改整形修剪管理
export function updatePruning(data) {
  return request({
    url: '/system/pruning',
    method: 'put',
    data: data
  })
}

// 删除整形修剪管理
export function delPruning(id) {
  return request({
    url: '/system/pruning/' + id,
    method: 'delete'
  })
}
