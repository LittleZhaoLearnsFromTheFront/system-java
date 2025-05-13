package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.SysLand;
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
import com.ruoyi.system.domain.SysFertilizationInventory;
import com.ruoyi.system.service.ISysFertilizationInventoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 肥料库存管理Controller
 * 
 * @author ruoyi
 * @date 2025-05-12
 */
@RestController
@RequestMapping("/system/inventory")
public class SysFertilizationInventoryController extends BaseController
{
    @Autowired
    private ISysFertilizationInventoryService sysFertilizationInventoryService;

    @GetMapping("/list/all")
    public AjaxResult listAll(SysFertilizationInventory sysFertilizationInventory){
        return success(sysFertilizationInventoryService.selectSysFertilizationInventoryList(sysFertilizationInventory));
    }

    /**
     * 查询肥料库存管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:inventory:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysFertilizationInventory sysFertilizationInventory)
    {
        startPage();
        List<SysFertilizationInventory> list = sysFertilizationInventoryService.selectSysFertilizationInventoryList(sysFertilizationInventory);
        return getDataTable(list);
    }

    /**
     * 导出肥料库存管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:inventory:export')")
    @Log(title = "肥料库存管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysFertilizationInventory sysFertilizationInventory)
    {
        List<SysFertilizationInventory> list = sysFertilizationInventoryService.selectSysFertilizationInventoryList(sysFertilizationInventory);
        ExcelUtil<SysFertilizationInventory> util = new ExcelUtil<SysFertilizationInventory>(SysFertilizationInventory.class);
        util.exportExcel(response, list, "肥料库存管理数据");
    }

    /**
     * 获取肥料库存管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:inventory:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(sysFertilizationInventoryService.selectSysFertilizationInventoryById(id));
    }

    /**
     * 新增肥料库存管理
     */
    @PreAuthorize("@ss.hasPermi('system:inventory:add')")
    @Log(title = "肥料库存管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysFertilizationInventory sysFertilizationInventory)
    {
        sysFertilizationInventory.setCreateBy(getUsername());
        return toAjax(sysFertilizationInventoryService.insertSysFertilizationInventory(sysFertilizationInventory));
    }

    /**
     * 修改肥料库存管理
     */
    @PreAuthorize("@ss.hasPermi('system:inventory:edit')")
    @Log(title = "肥料库存管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysFertilizationInventory sysFertilizationInventory)
    {
        return toAjax(sysFertilizationInventoryService.updateSysFertilizationInventory(sysFertilizationInventory));
    }

    /**
     * 删除肥料库存管理
     */
    @PreAuthorize("@ss.hasPermi('system:inventory:remove')")
    @Log(title = "肥料库存管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysFertilizationInventoryService.deleteSysFertilizationInventoryByIds(ids));
    }
}
