import request from '@/utils/request'

// 查询浇水管理列表
export function listWatering(query) {
  return request({
    url: '/system/watering/list',
    method: 'get',
    params: query
  })
}

// 查询浇水管理详细
export function getWatering(id) {
  return request({
    url: '/system/watering/' + id,
    method: 'get'
  })
}

// 新增浇水管理
export function addWatering(data) {
  return request({
    url: '/system/watering',
    method: 'post',
    data: data
  })
}

// 修改浇水管理
export function updateWatering(data) {
  return request({
    url: '/system/watering',
    method: 'put',
    data: data
  })
}

// 删除浇水管理
export function delWatering(id) {
  return request({
    url: '/system/watering/' + id,
    method: 'delete'
  })
}
