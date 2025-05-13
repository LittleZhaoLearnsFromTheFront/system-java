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
import com.ruoyi.system.domain.SysPruning;
import com.ruoyi.system.service.ISysPruningService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 整形修剪管理Controller
 * 
 * @author ruoyi
 * @date 2025-05-12
 */
@RestController
@RequestMapping("/system/pruning")
public class SysPruningController extends BaseController
{
    @Autowired
    private ISysPruningService sysPruningService;

    /**
     * 查询整形修剪管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:pruning:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysPruning sysPruning)
    {
        startPage();
        List<SysPruning> list = sysPruningService.selectSysPruningList(sysPruning);
        return getDataTable(list);
    }

    /**
     * 导出整形修剪管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:pruning:export')")
    @Log(title = "整形修剪管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysPruning sysPruning)
    {
        List<SysPruning> list = sysPruningService.selectSysPruningList(sysPruning);
        ExcelUtil<SysPruning> util = new ExcelUtil<SysPruning>(SysPruning.class);
        util.exportExcel(response, list, "整形修剪管理数据");
    }

    /**
     * 获取整形修剪管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:pruning:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(sysPruningService.selectSysPruningById(id));
    }

    /**
     * 新增整形修剪管理
     */
    @PreAuthorize("@ss.hasPermi('system:pruning:add')")
    @Log(title = "整形修剪管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysPruning sysPruning)
    {
        sysPruning.setCreateBy(getUsername());
        return toAjax(sysPruningService.insertSysPruning(sysPruning));
    }

    /**
     * 修改整形修剪管理
     */
    @PreAuthorize("@ss.hasPermi('system:pruning:edit')")
    @Log(title = "整形修剪管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysPruning sysPruning)
    {
        return toAjax(sysPruningService.updateSysPruning(sysPruning));
    }

    /**
     * 删除整形修剪管理
     */
    @PreAuthorize("@ss.hasPermi('system:pruning:remove')")
    @Log(title = "整形修剪管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysPruningService.deleteSysPruningByIds(ids));
    }
}
