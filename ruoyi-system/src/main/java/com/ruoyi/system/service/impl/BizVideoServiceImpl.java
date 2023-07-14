package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BizVideoMapper;
import com.ruoyi.system.domain.BizVideo;
import com.ruoyi.system.service.IBizVideoService;

/**
 * 视频管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-14
 */
@Service
public class BizVideoServiceImpl implements IBizVideoService 
{
    @Autowired
    private BizVideoMapper bizVideoMapper;

    /**
     * 查询视频管理
     * 
     * @param id 视频管理主键
     * @return 视频管理
     */
    @Override
    public BizVideo selectBizVideoById(Long id)
    {
        return bizVideoMapper.selectBizVideoById(id);
    }

    /**
     * 查询视频管理列表
     * 
     * @param bizVideo 视频管理
     * @return 视频管理
     */
    @Override
    public List<BizVideo> selectBizVideoList(BizVideo bizVideo)
    {
        return bizVideoMapper.selectBizVideoList(bizVideo);
    }

    /**
     * 新增视频管理
     * 
     * @param bizVideo 视频管理
     * @return 结果
     */
    @Override
    public int insertBizVideo(BizVideo bizVideo)
    {
        bizVideo.setCreateTime(DateUtils.getNowDate());
        return bizVideoMapper.insertBizVideo(bizVideo);
    }

    /**
     * 修改视频管理
     * 
     * @param bizVideo 视频管理
     * @return 结果
     */
    @Override
    public int updateBizVideo(BizVideo bizVideo)
    {
        return bizVideoMapper.updateBizVideo(bizVideo);
    }

    /**
     * 批量删除视频管理
     * 
     * @param ids 需要删除的视频管理主键
     * @return 结果
     */
    @Override
    public int deleteBizVideoByIds(Long[] ids)
    {
        return bizVideoMapper.deleteBizVideoByIds(ids);
    }

    /**
     * 删除视频管理信息
     * 
     * @param id 视频管理主键
     * @return 结果
     */
    @Override
    public int deleteBizVideoById(Long id)
    {
        return bizVideoMapper.deleteBizVideoById(id);
    }
}
