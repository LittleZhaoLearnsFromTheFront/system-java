package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.SysFertilizationInventory;
import com.ruoyi.system.service.ISysFertilizationInventoryService;
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
import com.ruoyi.system.domain.SysFertilization;
import com.ruoyi.system.service.ISysFertilizationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 施肥Controller
 * 
 * @author ruoyi
 * @date 2025-05-11
 */
@RestController
@RequestMapping("/system/fertilization")
public class SysFertilizationController extends BaseController
{
    @Autowired
    private ISysFertilizationService sysFertilizationService;

    @Autowired
    private ISysFertilizationInventoryService sysFertilizationInventoryService;

    /**
     * 查询施肥列表
     */
    @PreAuthorize("@ss.hasPermi('system:fertilization:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysFertilization sysFertilization)
    {
        startPage();
        List<SysFertilization> list = sysFertilizationService.selectSysFertilizationList(sysFertilization);
        return getDataTable(list);
    }

    /**
     * 导出施肥列表
     */
    @PreAuthorize("@ss.hasPermi('system:fertilization:export')")
    @Log(title = "施肥", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysFertilization sysFertilization)
    {
        List<SysFertilization> list = sysFertilizationService.selectSysFertilizationList(sysFertilization);
        ExcelUtil<SysFertilization> util = new ExcelUtil<SysFertilization>(SysFertilization.class);
        util.exportExcel(response, list, "施肥数据");
    }

    /**
     * 获取施肥详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:fertilization:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(sysFertilizationService.selectSysFertilizationById(id));
    }

    /**
     * 新增施肥
     */
    @PreAuthorize("@ss.hasPermi('system:fertilization:add')")
    @Log(title = "施肥", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysFertilization sysFertilization)
    {
        sysFertilization.setCreateBy(getUsername());
        SysFertilizationInventory nowInventory=sysFertilizationInventoryService.selectSysFertilizationInventoryById(sysFertilization.getFertilizationInventoryId());;
        if(nowInventory.getRemainingQuantity()<sysFertilization.getDosage()){
            return AjaxResult.error("库存不足");
        }
        nowInventory.setRemainingQuantity(nowInventory.getRemainingQuantity()-sysFertilization.getDosage());
        sysFertilizationInventoryService.updateSysFertilizationInventory(nowInventory);
        return toAjax(sysFertilizationService.insertSysFertilization(sysFertilization));
    }

    /**
     * 修改施肥
     */
    @PreAuthorize("@ss.hasPermi('system:fertilization:edit')")
    @Log(title = "施肥", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysFertilization sysFertilization)
    {
        return toAjax(sysFertilizationService.updateSysFertilization(sysFertilization));
    }

    /**
     * 删除施肥
     */
    @PreAuthorize("@ss.hasPermi('system:fertilization:remove')")
    @Log(title = "施肥", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysFertilizationService.deleteSysFertilizationByIds(ids));
    }
}
