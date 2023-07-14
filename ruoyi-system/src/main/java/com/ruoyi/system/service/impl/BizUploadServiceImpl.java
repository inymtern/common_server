package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BizUploadMapper;
import com.ruoyi.system.domain.BizUpload;
import com.ruoyi.system.service.IBizUploadService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-14
 */
@Service
public class BizUploadServiceImpl implements IBizUploadService 
{
    @Autowired
    private BizUploadMapper bizUploadMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public BizUpload selectBizUploadById(Long id)
    {
        return bizUploadMapper.selectBizUploadById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param bizUpload 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<BizUpload> selectBizUploadList(BizUpload bizUpload)
    {
        return bizUploadMapper.selectBizUploadList(bizUpload);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param bizUpload 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertBizUpload(BizUpload bizUpload)
    {
        bizUpload.setCreateTime(DateUtils.getNowDate());
        return bizUploadMapper.insertBizUpload(bizUpload);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param bizUpload 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateBizUpload(BizUpload bizUpload)
    {
        return bizUploadMapper.updateBizUpload(bizUpload);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteBizUploadByIds(Long[] ids)
    {
        return bizUploadMapper.deleteBizUploadByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteBizUploadById(Long id)
    {
        return bizUploadMapper.deleteBizUploadById(id);
    }
}
