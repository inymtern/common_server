package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.BizVideo;

/**
 * 视频管理Service接口
 * 
 * @author ruoyi
 * @date 2023-07-14
 */
public interface IBizVideoService 
{
    /**
     * 查询视频管理
     * 
     * @param id 视频管理主键
     * @return 视频管理
     */
    public BizVideo selectBizVideoById(Long id);

    /**
     * 查询视频管理列表
     * 
     * @param bizVideo 视频管理
     * @return 视频管理集合
     */
    public List<BizVideo> selectBizVideoList(BizVideo bizVideo);

    /**
     * 新增视频管理
     * 
     * @param bizVideo 视频管理
     * @return 结果
     */
    public int insertBizVideo(BizVideo bizVideo);

    /**
     * 修改视频管理
     * 
     * @param bizVideo 视频管理
     * @return 结果
     */
    public int updateBizVideo(BizVideo bizVideo);

    /**
     * 批量删除视频管理
     * 
     * @param ids 需要删除的视频管理主键集合
     * @return 结果
     */
    public int deleteBizVideoByIds(Long[] ids);

    /**
     * 删除视频管理信息
     * 
     * @param id 视频管理主键
     * @return 结果
     */
    public int deleteBizVideoById(Long id);
}
