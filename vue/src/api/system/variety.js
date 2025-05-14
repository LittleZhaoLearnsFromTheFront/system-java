import request from '@/utils/request'

// 查询猕猴桃种类信息列表
export function listVariety(query) {
  return request({
    url: '/system/variety/list',
    method: 'get',
    params: query
  })
}

// 查询猕猴桃种类信息详细
export function getVariety(varietyId) {
  return request({
    url: '/system/variety/' + varietyId,
    method: 'get'
  })
}

// 新增猕猴桃种类信息
export function addVariety(data) {
  return request({
    url: '/system/variety',
    method: 'post',
    data: data
  })
}

// 修改猕猴桃种类信息
export function updateVariety(data) {
  return request({
    url: '/system/variety',
    method: 'put',
    data: data
  })
}

// 删除猕猴桃种类信息
export function delVariety(varietyId) {
  return request({
    url: '/system/variety/' + varietyId,
    method: 'delete'
  })
}
