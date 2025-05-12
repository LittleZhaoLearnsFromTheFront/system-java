import request from '@/utils/request'

// 查询土地列表
export function listLand(query) {
  return request({
    url: '/system/land/list',
    method: 'get',
    params: query
  })
}

// 查询土地详细
export function getLand(id) {
  return request({
    url: '/system/land/' + id,
    method: 'get'
  })
}

// 新增土地
export function addLand(data) {
  return request({
    url: '/system/land',
    method: 'post',
    data: data
  })
}

// 修改土地
export function updateLand(data) {
  return request({
    url: '/system/land',
    method: 'put',
    data: data
  })
}

// 删除土地
export function delLand(id) {
  return request({
    url: '/system/land/' + id,
    method: 'delete'
  })
}

export function getLandListAll() {
  return request({
    url: '/system/land/list/all',
    method: 'get'
  })
}
