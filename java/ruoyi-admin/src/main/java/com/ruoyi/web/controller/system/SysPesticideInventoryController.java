package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.SysFertilizationInventory;
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
import com.ruoyi.system.domain.SysPesticideInventory;
import com.ruoyi.system.service.ISysPesticideInventoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * pesticideInventoryController
 * 
 * @author ruoyi
 * @date 2025-05-13
 */
@RestController
@RequestMapping("/system/p/inventory")
public class SysPesticideInventoryController extends BaseController
{
    @Autowired
    private ISysPesticideInventoryService sysPesticideInventoryService;


    @GetMapping("/list/all")
    public AjaxResult listAll(SysPesticideInventory sysPesticideInventory){
        return success(sysPesticideInventoryService.selectSysPesticideInventoryList(sysPesticideInventory));
    }
    /**
     * 查询pesticideInventory列表
     */
    @PreAuthorize("@ss.hasPermi('system:inventory:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysPesticideInventory sysPesticideInventory)
    {
        startPage();
        List<SysPesticideInventory> list = sysPesticideInventoryService.selectSysPesticideInventoryList(sysPesticideInventory);
        return getDataTable(list);
    }

    /**
     * 导出pesticideInventory列表
     */
    @PreAuthorize("@ss.hasPermi('system:inventory:export')")
    @Log(title = "pesticideInventory", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysPesticideInventory sysPesticideInventory)
    {
        List<SysPesticideInventory> list = sysPesticideInventoryService.selectSysPesticideInventoryList(sysPesticideInventory);
        ExcelUtil<SysPesticideInventory> util = new ExcelUtil<SysPesticideInventory>(SysPesticideInventory.class);
        util.exportExcel(response, list, "pesticideInventory数据");
    }

    /**
     * 获取pesticideInventory详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:inventory:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(sysPesticideInventoryService.selectSysPesticideInventoryById(id));
    }

    /**
     * 新增pesticideInventory
     */
    @PreAuthorize("@ss.hasPermi('system:inventory:add')")
    @Log(title = "pesticideInventory", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysPesticideInventory sysPesticideInventory)
    {
        sysPesticideInventory.setCreateBy(getUsername());
        return toAjax(sysPesticideInventoryService.insertSysPesticideInventory(sysPesticideInventory));
    }

    /**
     * 修改pesticideInventory
     */
    @PreAuthorize("@ss.hasPermi('system:inventory:edit')")
    @Log(title = "pesticideInventory", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysPesticideInventory sysPesticideInventory)
    {
        return toAjax(sysPesticideInventoryService.updateSysPesticideInventory(sysPesticideInventory));
    }

    /**
     * 删除pesticideInventory
     */
    @PreAuthorize("@ss.hasPermi('system:inventory:remove')")
    @Log(title = "pesticideInventory", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysPesticideInventoryService.deleteSysPesticideInventoryByIds(ids));
    }
}
