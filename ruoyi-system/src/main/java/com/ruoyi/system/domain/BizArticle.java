package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 文案对象 biz_article
 * 
 * @author ruoyi
 * @date 2023-07-14
 */
public class BizArticle extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 内容 */
    @Excel(name = "内容")
    private String text;

    /** 是否使用过 */
    @Excel(name = "是否使用过")
    private Long isUse;

    /** 口令 */
    @Excel(name = "口令")
    private String keyStr;

    /** 使用时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "使用时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date useTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setText(String text) 
    {
        this.text = text;
    }

    public String getText() 
    {
        return text;
    }
    public void setIsUse(Long isUse) 
    {
        this.isUse = isUse;
    }

    public Long getIsUse() 
    {
        return isUse;
    }
    public void setKeyStr(String keyStr) 
    {
        this.keyStr = keyStr;
    }

    public String getKeyStr() 
    {
        return keyStr;
    }
    public void setUseTime(Date useTime) 
    {
        this.useTime = useTime;
    }

    public Date getUseTime() 
    {
        return useTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("text", getText())
            .append("isUse", getIsUse())
            .append("keyStr", getKeyStr())
            .append("useTime", getUseTime())
            .append("createTime", getCreateTime())
            .toString();
    }
}
