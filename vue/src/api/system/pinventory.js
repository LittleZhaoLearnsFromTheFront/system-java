import request from '@/utils/request'


export function getInventoryAll(query) {
  return request({
    url: '/system/p/inventory/list/all',
    method: 'get',
    params: query
  })
}
// 查询pesticideInventory列表
export function listInventory(query) {
  return request({
    url: '/system/p/inventory/list',
    method: 'get',
    params: query
  })
}

// 查询pesticideInventory详细
export function getInventory(id) {
  return request({
    url: '/system/p/inventory/' + id,
    method: 'get'
  })
}

// 新增pesticideInventory
export function addInventory(data) {
  return request({
    url: '/system/p/inventory',
    method: 'post',
    data: data
  })
}

// 修改pesticideInventory
export function updateInventory(data) {
  return request({
    url: '/system/p/inventory',
    method: 'put',
    data: data
  })
}

// 删除pesticideInventory
export function delInventory(id) {
  return request({
    url: '/system/p/inventory/' + id,
    method: 'delete'
  })
}
