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
import com.ruoyi.system.domain.SysVariety;
import com.ruoyi.system.service.ISysVarietyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 猕猴桃种类信息Controller
 * 
 * @author ruoyi
 * @date 2025-05-13
 */
@RestController
@RequestMapping("/system/variety")
public class SysVarietyController extends BaseController
{
    @Autowired
    private ISysVarietyService sysVarietyService;

    /**
     * 查询猕猴桃种类信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:variety:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysVariety sysVariety)
    {
        startPage();
        List<SysVariety> list = sysVarietyService.selectSysVarietyList(sysVariety);
        return getDataTable(list);
    }

    /**
     * 导出猕猴桃种类信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:variety:export')")
    @Log(title = "猕猴桃种类信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysVariety sysVariety)
    {
        List<SysVariety> list = sysVarietyService.selectSysVarietyList(sysVariety);
        ExcelUtil<SysVariety> util = new ExcelUtil<SysVariety>(SysVariety.class);
        util.exportExcel(response, list, "猕猴桃种类信息数据");
    }

    /**
     * 获取猕猴桃种类信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:variety:query')")
    @GetMapping(value = "/{varietyId}")
    public AjaxResult getInfo(@PathVariable("varietyId") Long varietyId)
    {
        return success(sysVarietyService.selectSysVarietyByVarietyId(varietyId));
    }

    /**
     * 新增猕猴桃种类信息
     */
    @PreAuthorize("@ss.hasPermi('system:variety:add')")
    @Log(title = "猕猴桃种类信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysVariety sysVariety)
    {
        return toAjax(sysVarietyService.insertSysVariety(sysVariety));
    }

    /**
     * 修改猕猴桃种类信息
     */
    @PreAuthorize("@ss.hasPermi('system:variety:edit')")
    @Log(title = "猕猴桃种类信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysVariety sysVariety)
    {
        return toAjax(sysVarietyService.updateSysVariety(sysVariety));
    }

    /**
     * 删除猕猴桃种类信息
     */
    @PreAuthorize("@ss.hasPermi('system:variety:remove')")
    @Log(title = "猕猴桃种类信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{varietyIds}")
    public AjaxResult remove(@PathVariable Long[] varietyIds)
    {
        return toAjax(sysVarietyService.deleteSysVarietyByVarietyIds(varietyIds));
    }
}
