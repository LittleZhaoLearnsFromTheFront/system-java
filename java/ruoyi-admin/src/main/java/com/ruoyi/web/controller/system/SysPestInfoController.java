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
import com.ruoyi.system.domain.SysPestInfo;
import com.ruoyi.system.service.ISysPestInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 病虫害信息查询Controller
 * 
 * @author ruoyi
 * @date 2025-05-12
 */
@RestController
@RequestMapping("/system/info")
public class SysPestInfoController extends BaseController
{
    @Autowired
    private ISysPestInfoService sysPestInfoService;

    /**
     * 查询病虫害信息查询列表
     */
    @PreAuthorize("@ss.hasPermi('system:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysPestInfo sysPestInfo)
    {
        startPage();
        List<SysPestInfo> list = sysPestInfoService.selectSysPestInfoList(sysPestInfo);
        return getDataTable(list);
    }

    /**
     * 导出病虫害信息查询列表
     */
    @PreAuthorize("@ss.hasPermi('system:info:export')")
    @Log(title = "病虫害信息查询", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysPestInfo sysPestInfo)
    {
        List<SysPestInfo> list = sysPestInfoService.selectSysPestInfoList(sysPestInfo);
        ExcelUtil<SysPestInfo> util = new ExcelUtil<SysPestInfo>(SysPestInfo.class);
        util.exportExcel(response, list, "病虫害信息查询数据");
    }

    /**
     * 获取病虫害信息查询详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(sysPestInfoService.selectSysPestInfoById(id));
    }

    /**
     * 新增病虫害信息查询
     */
    @PreAuthorize("@ss.hasPermi('system:info:add')")
    @Log(title = "病虫害信息查询", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysPestInfo sysPestInfo)
    {
        sysPestInfo.setCreateBy(getUsername());
        return toAjax(sysPestInfoService.insertSysPestInfo(sysPestInfo));
    }

    /**
     * 修改病虫害信息查询
     */
    @PreAuthorize("@ss.hasPermi('system:info:edit')")
    @Log(title = "病虫害信息查询", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysPestInfo sysPestInfo)
    {
        return toAjax(sysPestInfoService.updateSysPestInfo(sysPestInfo));
    }

    /**
     * 删除病虫害信息查询
     */
    @PreAuthorize("@ss.hasPermi('system:info:remove')")
    @Log(title = "病虫害信息查询", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysPestInfoService.deleteSysPestInfoByIds(ids));
    }
}
