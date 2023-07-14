package com.ruoyi.web.controller.biz;

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
import com.ruoyi.system.domain.BizVideo;
import com.ruoyi.system.service.IBizVideoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 视频管理Controller
 * 
 * @author ruoyi
 * @date 2023-07-14
 */
@RestController
@RequestMapping("/system/video")
public class BizVideoController extends BaseController
{
    @Autowired
    private IBizVideoService bizVideoService;

    /**
     * 查询视频管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:video:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizVideo bizVideo)
    {
        startPage();
        List<BizVideo> list = bizVideoService.selectBizVideoList(bizVideo);
        return getDataTable(list);
    }

    /**
     * 导出视频管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:video:export')")
    @Log(title = "视频管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizVideo bizVideo)
    {
        List<BizVideo> list = bizVideoService.selectBizVideoList(bizVideo);
        ExcelUtil<BizVideo> util = new ExcelUtil<BizVideo>(BizVideo.class);
        util.exportExcel(response, list, "视频管理数据");
    }

    /**
     * 获取视频管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:video:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bizVideoService.selectBizVideoById(id));
    }

    /**
     * 新增视频管理
     */
    @PreAuthorize("@ss.hasPermi('system:video:add')")
    @Log(title = "视频管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizVideo bizVideo)
    {
        return toAjax(bizVideoService.insertBizVideo(bizVideo));
    }

    /**
     * 修改视频管理
     */
    @PreAuthorize("@ss.hasPermi('system:video:edit')")
    @Log(title = "视频管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizVideo bizVideo)
    {
        return toAjax(bizVideoService.updateBizVideo(bizVideo));
    }

    /**
     * 删除视频管理
     */
    @PreAuthorize("@ss.hasPermi('system:video:remove')")
    @Log(title = "视频管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bizVideoService.deleteBizVideoByIds(ids));
    }
}
