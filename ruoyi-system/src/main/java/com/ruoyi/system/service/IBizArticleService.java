package com.ruoyi.system.service;

import java.util.List;
import java.util.Optional;

import com.ruoyi.system.domain.BizArticle;

/**
 * 文案Service接口
 * 
 * @author ruoyi
 * @date 2023-07-14
 */
public interface IBizArticleService 
{
    /**
     * 查询文案
     * 
     * @param id 文案主键
     * @return 文案
     */
    public BizArticle selectBizArticleById(Long id);

    /**
     * 查询文案列表
     * 
     * @param bizArticle 文案
     * @return 文案集合
     */
    public List<BizArticle> selectBizArticleList(BizArticle bizArticle);

    /**
     * 新增文案
     * 
     * @param bizArticle 文案
     * @return 结果
     */
    public int insertBizArticle(BizArticle bizArticle);

    /**
     * 修改文案
     * 
     * @param bizArticle 文案
     * @return 结果
     */
    public int updateBizArticle(BizArticle bizArticle);

    /**
     * 批量删除文案
     * 
     * @param ids 需要删除的文案主键集合
     * @return 结果
     */
    public int deleteBizArticleByIds(Long[] ids);

    /**
     * 删除文案信息
     * 
     * @param id 文案主键
     * @return 结果
     */
    public int deleteBizArticleById(Long id);

    Optional<BizArticle> getOne();
}
