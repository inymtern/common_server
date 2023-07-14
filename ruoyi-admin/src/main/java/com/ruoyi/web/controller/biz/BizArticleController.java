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
import com.ruoyi.system.domain.BizArticle;
import com.ruoyi.system.service.IBizArticleService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 文案Controller
 * 
 * @author ruoyi
 * @date 2023-07-14
 */
@RestController
@RequestMapping("/system/article")
public class BizArticleController extends BaseController
{
    @Autowired
    private IBizArticleService bizArticleService;

    /**
     * 查询文案列表
     */
    @PreAuthorize("@ss.hasPermi('system:article:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizArticle bizArticle)
    {
        startPage();
        List<BizArticle> list = bizArticleService.selectBizArticleList(bizArticle);
        return getDataTable(list);
    }

    /**
     * 导出文案列表
     */
    @PreAuthorize("@ss.hasPermi('system:article:export')")
    @Log(title = "文案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BizArticle bizArticle)
    {
        List<BizArticle> list = bizArticleService.selectBizArticleList(bizArticle);
        ExcelUtil<BizArticle> util = new ExcelUtil<BizArticle>(BizArticle.class);
        util.exportExcel(response, list, "文案数据");
    }

    /**
     * 获取文案详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:article:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bizArticleService.selectBizArticleById(id));
    }

    /**
     * 新增文案
     */
    @PreAuthorize("@ss.hasPermi('system:article:add')")
    @Log(title = "文案", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizArticle bizArticle)
    {
        return toAjax(bizArticleService.insertBizArticle(bizArticle));
    }

    /**
     * 修改文案
     */
    @PreAuthorize("@ss.hasPermi('system:article:edit')")
    @Log(title = "文案", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizArticle bizArticle)
    {
        return toAjax(bizArticleService.updateBizArticle(bizArticle));
    }

    /**
     * 删除文案
     */
    @PreAuthorize("@ss.hasPermi('system:article:remove')")
    @Log(title = "文案", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bizArticleService.deleteBizArticleByIds(ids));
    }
}
