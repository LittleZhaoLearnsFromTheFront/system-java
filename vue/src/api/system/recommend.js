import request from '@/utils/request'

export function getRecommendList(data) {
    return request({
        url: '/api/recommend',
        method: 'post',
        data: data
    })
}