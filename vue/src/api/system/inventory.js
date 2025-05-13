import request from '@/utils/request'

// 查询肥料库存管理列表
export function getInventoryAll(query) {
  return request({
    url: '/system/inventory/list/all',
    method: 'get',
    params: query
  })
}

// 查询肥料库存管理列表
export function listInventory(query) {
  return request({
    url: '/system/inventory/list',
    method: 'get',
    params: query
  })
}

// 查询肥料库存管理详细
export function getInventory(id) {
  return request({
    url: '/system/inventory/' + id,
    method: 'get'
  })
}

// 新增肥料库存管理
export function addInventory(data) {
  return request({
    url: '/system/inventory',
    method: 'post',
    data: data
  })
}

// 修改肥料库存管理
export function updateInventory(data) {
  return request({
    url: '/system/inventory',
    method: 'put',
    data: data
  })
}

// 删除肥料库存管理
export function delInventory(id) {
  return request({
    url: '/system/inventory/' + id,
    method: 'delete'
  })
}
