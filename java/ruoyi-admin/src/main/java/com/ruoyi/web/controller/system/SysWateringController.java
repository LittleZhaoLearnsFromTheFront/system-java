package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysWatering;
import com.ruoyi.system.service.ISysWateringService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 浇水管理Controller
 * 
 * @author hanxiao.zhao
 * @date 2025-05-11
 */
@RestController
@RequestMapping("/system/watering")
public class SysWateringController extends BaseController
{
    @Autowired
    private ISysWateringService sysWateringService;

    /**
     * 查询浇水管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:watering:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysWatering sysWatering)
    {
        startPage();
        List<SysWatering> list = sysWateringService.selectSysWateringList(sysWatering);
        return getDataTable(list);
    }

    /**
     * 导出浇水管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:watering:export')")
    @Log(title = "浇水管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysWatering sysWatering)
    {
        List<SysWatering> list = sysWateringService.selectSysWateringList(sysWatering);
        ExcelUtil<SysWatering> util = new ExcelUtil<SysWatering>(SysWatering.class);
        util.exportExcel(response, list, "浇水管理数据");
    }

    /**
     * 获取浇水管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:watering:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(sysWateringService.selectSysWateringById(id));
    }

    /**
     * 新增浇水管理
     */
    @PreAuthorize("@ss.hasPermi('system:watering:add')")
    @Log(title = "浇水管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysWatering sysWatering)
    {
        sysWatering.setCreateBy(getUsername());
        return toAjax(sysWateringService.insertSysWatering(sysWatering));
    }

    /**
     * 修改浇水管理
     */
    @PreAuthorize("@ss.hasPermi('system:watering:edit')")
    @Log(title = "浇水管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysWatering sysWatering)
    {
        return toAjax(sysWateringService.updateSysWatering(sysWatering));
    }

    /**
     * 删除浇水管理
     */
    @PreAuthorize("@ss.hasPermi('system:watering:remove')")
    @Log(title = "浇水管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysWateringService.deleteSysWateringByIds(ids));
    }
}
