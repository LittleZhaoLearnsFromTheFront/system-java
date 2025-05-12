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
import com.ruoyi.system.domain.SysLand;
import com.ruoyi.system.service.ISysLandService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 土地Controller
 * 
 * @author ruoyi
 * @date 2025-05-11
 */
@RestController
@RequestMapping("/system/land")
public class SysLandController extends BaseController
{
    @Autowired
    private ISysLandService sysLandService;

    @GetMapping("/list/all")
    public AjaxResult listAll(SysLand sysLand){
        return success(sysLandService.selectSysLandList(sysLand));
    }

    /**
     * 查询土地列表
     */
    @PreAuthorize("@ss.hasPermi('system:land:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysLand sysLand)
    {
        startPage();
        List<SysLand> list = sysLandService.selectSysLandList(sysLand);
        return getDataTable(list);
    }

    /**
     * 导出土地列表
     */
    @PreAuthorize("@ss.hasPermi('system:land:export')")
    @Log(title = "土地", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysLand sysLand)
    {
        List<SysLand> list = sysLandService.selectSysLandList(sysLand);
        ExcelUtil<SysLand> util = new ExcelUtil<SysLand>(SysLand.class);
        util.exportExcel(response, list, "土地数据");
    }

    /**
     * 获取土地详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:land:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(sysLandService.selectSysLandById(id));
    }

    /**
     * 新增土地
     */
    @PreAuthorize("@ss.hasPermi('system:land:add')")
    @Log(title = "土地", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysLand sysLand)
    {
        return toAjax(sysLandService.insertSysLand(sysLand));
    }

    /**
     * 修改土地
     */
    @PreAuthorize("@ss.hasPermi('system:land:edit')")
    @Log(title = "土地", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysLand sysLand)
    {
        return toAjax(sysLandService.updateSysLand(sysLand));
    }

    /**
     * 删除土地
     */
    @PreAuthorize("@ss.hasPermi('system:land:remove')")
    @Log(title = "土地", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysLandService.deleteSysLandByIds(ids));
    }
}
