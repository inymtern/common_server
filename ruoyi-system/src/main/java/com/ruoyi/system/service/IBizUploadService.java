package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.BizUpload;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2023-07-14
 */
public interface IBizUploadService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public BizUpload selectBizUploadById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param bizUpload 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<BizUpload> selectBizUploadList(BizUpload bizUpload);

    /**
     * 新增【请填写功能名称】
     * 
     * @param bizUpload 【请填写功能名称】
     * @return 结果
     */
    public int insertBizUpload(BizUpload bizUpload);

    /**
     * 修改【请填写功能名称】
     * 
     * @param bizUpload 【请填写功能名称】
     * @return 结果
     */
    public int updateBizUpload(BizUpload bizUpload);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteBizUploadByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteBizUploadById(Long id);
}
