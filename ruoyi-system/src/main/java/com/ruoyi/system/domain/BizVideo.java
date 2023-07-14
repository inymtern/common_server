package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 视频管理对象 biz_video
 * 
 * @author ruoyi
 * @date 2023-07-14
 */
public class BizVideo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 视频位置 */
    @Excel(name = "视频位置")
    private String videoPath;

    /** 使用文案id */
    @Excel(name = "使用文案id")
    private Long articleId;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setVideoPath(String videoPath) 
    {
        this.videoPath = videoPath;
    }

    public String getVideoPath() 
    {
        return videoPath;
    }
    public void setArticleId(Long articleId) 
    {
        this.articleId = articleId;
    }

    public Long getArticleId() 
    {
        return articleId;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("videoPath", getVideoPath())
            .append("articleId", getArticleId())
            .append("title", getTitle())
            .append("createTime", getCreateTime())
            .toString();
    }
}
