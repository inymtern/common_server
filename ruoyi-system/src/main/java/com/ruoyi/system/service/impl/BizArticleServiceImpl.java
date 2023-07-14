package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.Optional;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BizArticleMapper;
import com.ruoyi.system.domain.BizArticle;
import com.ruoyi.system.service.IBizArticleService;

/**
 * 文案Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-14
 */
@Service
public class BizArticleServiceImpl implements IBizArticleService 
{
    @Autowired
    private BizArticleMapper bizArticleMapper;

    /**
     * 查询文案
     * 
     * @param id 文案主键
     * @return 文案
     */
    @Override
    public BizArticle selectBizArticleById(Long id)
    {
        return bizArticleMapper.selectBizArticleById(id);
    }

    /**
     * 查询文案列表
     * 
     * @param bizArticle 文案
     * @return 文案
     */
    @Override
    public List<BizArticle> selectBizArticleList(BizArticle bizArticle)
    {
        return bizArticleMapper.selectBizArticleList(bizArticle);
    }

    /**
     * 新增文案
     * 
     * @param bizArticle 文案
     * @return 结果
     */
    @Override
    public int insertBizArticle(BizArticle bizArticle)
    {
        bizArticle.setCreateTime(DateUtils.getNowDate());
        return bizArticleMapper.insertBizArticle(bizArticle);
    }

    /**
     * 修改文案
     * 
     * @param bizArticle 文案
     * @return 结果
     */
    @Override
    public int updateBizArticle(BizArticle bizArticle)
    {
        return bizArticleMapper.updateBizArticle(bizArticle);
    }

    /**
     * 批量删除文案
     * 
     * @param ids 需要删除的文案主键
     * @return 结果
     */
    @Override
    public int deleteBizArticleByIds(Long[] ids)
    {
        return bizArticleMapper.deleteBizArticleByIds(ids);
    }

    /**
     * 删除文案信息
     * 
     * @param id 文案主键
     * @return 结果
     */
    @Override
    public int deleteBizArticleById(Long id)
    {
        return bizArticleMapper.deleteBizArticleById(id);
    }

    @Override
    public Optional<BizArticle> getOne() {
        BizArticle notUseOne = bizArticleMapper.getNotUseOne();
        return Optional.of(notUseOne);
    }
}
