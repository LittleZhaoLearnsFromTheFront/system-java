import request from '@/utils/request'

// 查询施肥列表
export function listFertilization(query) {
  return request({
    url: '/system/fertilization/list',
    method: 'get',
    params: query
  })
}

// 查询施肥详细
export function getFertilization(id) {
  return request({
    url: '/system/fertilization/' + id,
    method: 'get'
  })
}

// 新增施肥
export function addFertilization(data) {
  return request({
    url: '/system/fertilization',
    method: 'post',
    data: data
  })
}

// 修改施肥
export function updateFertilization(data) {
  return request({
    url: '/system/fertilization',
    method: 'put',
    data: data
  })
}

// 删除施肥
export function delFertilization(id) {
  return request({
    url: '/system/fertilization/' + id,
    method: 'delete'
  })
}
