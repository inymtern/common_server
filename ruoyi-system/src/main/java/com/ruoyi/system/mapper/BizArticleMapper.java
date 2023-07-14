package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.BizArticle;
import org.apache.ibatis.annotations.Select;

/**
 * 文案Mapper接口
 * 
 * @author ruoyi
 * @date 2023-07-14
 */
public interface BizArticleMapper 
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
     * 删除文案
     * 
     * @param id 文案主键
     * @return 结果
     */
    public int deleteBizArticleById(Long id);

    /**
     * 批量删除文案
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBizArticleByIds(Long[] ids);

    @Select("select * from biz_article where is_use = 0 order by create_time desc limit 1")
    BizArticle getNotUseOne();
}
