package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.SysFertilizationInventory;
import com.ruoyi.system.domain.SysPesticideInventory;
import com.ruoyi.system.service.ISysFertilizationInventoryService;
import com.ruoyi.system.service.ISysPesticideInventoryService;
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
import com.ruoyi.system.domain.SysPesticide;
import com.ruoyi.system.service.ISysPesticideService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 治理用药管理Controller
 * 
 * @author ruoyi
 * @date 2025-05-13
 */
@RestController
@RequestMapping("/system/pesticide")
public class SysPesticideController extends BaseController
{
    @Autowired
    private ISysPesticideService sysPesticideService;

    @Autowired
    private ISysPesticideInventoryService sysPesticideInventoryService;
    /**
     * 查询治理用药管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:pesticide:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysPesticide sysPesticide)
    {
        startPage();
        List<SysPesticide> list = sysPesticideService.selectSysPesticideList(sysPesticide);
        return getDataTable(list);
    }

    /**
     * 导出治理用药管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:pesticide:export')")
    @Log(title = "治理用药管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysPesticide sysPesticide)
    {
        List<SysPesticide> list = sysPesticideService.selectSysPesticideList(sysPesticide);
        ExcelUtil<SysPesticide> util = new ExcelUtil<SysPesticide>(SysPesticide.class);
        util.exportExcel(response, list, "治理用药管理数据");
    }

    /**
     * 获取治理用药管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:pesticide:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(sysPesticideService.selectSysPesticideById(id));
    }

    /**
     * 新增治理用药管理
     */
    @PreAuthorize("@ss.hasPermi('system:pesticide:add')")
    @Log(title = "治理用药管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysPesticide sysPesticide)
    {
        sysPesticide.setCreateBy(getUsername());
        SysPesticideInventory nowInventory=sysPesticideInventoryService.selectSysPesticideInventoryById(sysPesticide.getPesticideInventoryId());;
        if(nowInventory.getRemainingQuantity()<sysPesticide.getDosage()){
            return AjaxResult.error("库存不足");
        }
        nowInventory.setRemainingQuantity(nowInventory.getRemainingQuantity()-sysPesticide.getDosage());
        sysPesticideInventoryService.updateSysPesticideInventory(nowInventory);
        return toAjax(sysPesticideService.insertSysPesticide(sysPesticide));
    }

    /**
     * 修改治理用药管理
     */
    @PreAuthorize("@ss.hasPermi('system:pesticide:edit')")
    @Log(title = "治理用药管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysPesticide sysPesticide)
    {
        return toAjax(sysPesticideService.updateSysPesticide(sysPesticide));
    }

    /**
     * 删除治理用药管理
     */
    @PreAuthorize("@ss.hasPermi('system:pesticide:remove')")
    @Log(title = "治理用药管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysPesticideService.deleteSysPesticideByIds(ids));
    }
}
