package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysWatering;

/**
 * 浇水管理Mapper接口
 * 
 * @author hanxiao.zhao
 * @date 2025-05-11
 */
public interface SysWateringMapper 
{
    /**
     * 查询浇水管理
     * 
     * @param id 浇水管理主键
     * @return 浇水管理
     */
    public SysWatering selectSysWateringById(Long id);

    /**
     * 查询浇水管理列表
     * 
     * @param sysWatering 浇水管理
     * @return 浇水管理集合
     */
    public List<SysWatering> selectSysWateringList(SysWatering sysWatering);

    /**
     * 新增浇水管理
     * SysWateringMapper
     * @param sysWatering 浇水管理
     * @return 结果
     */
    public int insertSysWatering(SysWatering sysWatering);

    /**
     * 修改浇水管理
     * 
     * @param sysWatering 浇水管理
     * @return 结果
     */
    public int updateSysWatering(SysWatering sysWatering);

    /**
     * 删除浇水管理
     * 
     * @param id 浇水管理主键
     * @return 结果
     */
    public int deleteSysWateringById(Long id);

    /**
     * 批量删除浇水管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysWateringByIds(Long[] ids);
}
