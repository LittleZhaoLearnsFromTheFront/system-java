import request from '@/utils/request'

export function getOriginListAll() {
  return request({
    url: '/system/origin/list/all',
    method: 'get'
  })
}
// 查询猕猴桃产地信息列表
export function listOrigin(query) {
  return request({
    url: '/system/origin/list',
    method: 'get',
    params: query
  })
}

// 查询猕猴桃产地信息详细
export function getOrigin(originId) {
  return request({
    url: '/system/origin/' + originId,
    method: 'get'
  })
}

// 新增猕猴桃产地信息
export function addOrigin(data) {
  return request({
    url: '/system/origin',
    method: 'post',
    data: data
  })
}

// 修改猕猴桃产地信息
export function updateOrigin(data) {
  return request({
    url: '/system/origin',
    method: 'put',
    data: data
  })
}

// 删除猕猴桃产地信息
export function delOrigin(originId) {
  return request({
    url: '/system/origin/' + originId,
    method: 'delete'
  })
}
