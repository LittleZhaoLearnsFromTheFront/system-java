package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.SysLand;
import com.ruoyi.system.domain.SysVariety;
import com.ruoyi.system.service.ISysVarietyService;
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
import com.ruoyi.system.domain.SysOrigin;
import com.ruoyi.system.service.ISysOriginService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 猕猴桃产地信息Controller
 * 
 * @author ruoyi
 * @date 2025-05-14
 */
@RestController
@RequestMapping("/system/origin")
public class SysOriginController extends BaseController
{
    @Autowired
    private ISysOriginService sysOriginService;

    @Autowired
    private ISysVarietyService sysVarietyService;
    @GetMapping("/list/all")
    public AjaxResult listAll(SysOrigin sysOrigin){
        return success(sysOriginService.selectSysOriginList(sysOrigin));
    }
    /**
     * 查询猕猴桃产地信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:origin:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysOrigin sysOrigin)
    {
        startPage();
        List<SysOrigin> list = sysOriginService.selectSysOriginList(sysOrigin);
        return getDataTable(list);
    }

    /**
     * 导出猕猴桃产地信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:origin:export')")
    @Log(title = "猕猴桃产地信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysOrigin sysOrigin)
    {
        List<SysOrigin> list = sysOriginService.selectSysOriginList(sysOrigin);
        ExcelUtil<SysOrigin> util = new ExcelUtil<SysOrigin>(SysOrigin.class);
        util.exportExcel(response, list, "猕猴桃产地信息数据");
    }

    /**
     * 获取猕猴桃产地信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:origin:query')")
    @GetMapping(value = "/{originId}")
    public AjaxResult getInfo(@PathVariable("originId") Long originId)
    {
        return success(sysOriginService.selectSysOriginByOriginId(originId));
    }

    /**
     * 新增猕猴桃产地信息
     */
    @PreAuthorize("@ss.hasPermi('system:origin:add')")
    @Log(title = "猕猴桃产地信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysOrigin sysOrigin)
    {
        return toAjax(sysOriginService.insertSysOrigin(sysOrigin));
    }

    /**
     * 修改猕猴桃产地信息
     */
    @PreAuthorize("@ss.hasPermi('system:origin:edit')")
    @Log(title = "猕猴桃产地信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysOrigin sysOrigin)
    {
        return toAjax(sysOriginService.updateSysOrigin(sysOrigin));
    }

    /**
     * 删除猕猴桃产地信息
     */
    @PreAuthorize("@ss.hasPermi('system:origin:remove')")
    @Log(title = "猕猴桃产地信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{originIds}")
    public AjaxResult remove(@PathVariable Long[] originIds)
    {
        for (Long originId : originIds){
            SysVariety sysVariety = new SysVariety();
            sysVariety.setOriginId(originId);
            List<SysVariety> sysVarieties = sysVarietyService.selectSysVarietyList(sysVariety);
            if (!sysVarieties.isEmpty()){
                return error("数据被应用，不允许删除");
            }
        }
        return toAjax(sysOriginService.deleteSysOriginByOriginIds(originIds));
    }
}
