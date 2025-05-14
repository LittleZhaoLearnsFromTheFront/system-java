import request from '@/utils/request'

// 查询治理用药管理列表
export function listPesticide(query) {
  return request({
    url: '/system/pesticide/list',
    method: 'get',
    params: query
  })
}

// 查询治理用药管理详细
export function getPesticide(id) {
  return request({
    url: '/system/pesticide/' + id,
    method: 'get'
  })
}

// 新增治理用药管理
export function addPesticide(data) {
  return request({
    url: '/system/pesticide',
    method: 'post',
    data: data
  })
}

// 修改治理用药管理
export function updatePesticide(data) {
  return request({
    url: '/system/pesticide',
    method: 'put',
    data: data
  })
}

// 删除治理用药管理
export function delPesticide(id) {
  return request({
    url: '/system/pesticide/' + id,
    method: 'delete'
  })
}
