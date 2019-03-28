package com.yumi.mall.domain;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "cms_subject_category")
public class CmsSubjectCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /**
     * 类型 0轮播图 
     */
    private Integer type;

    /**
     * 专题位置 0为首页
     */
    private Integer position;

    /**
     * 分类图标
     */
    private String icon;

    /**
     * 专题数量
     */
    @Column(name = "subject_count")
    private Integer subjectCount;

    @Column(name = "show_status")
    private Integer showStatus;

    private Integer sort;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取类型 0轮播图 
     *
     * @return type - 类型 0轮播图 
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型 0轮播图 
     *
     * @param type 类型 0轮播图 
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取专题位置 0为首页
     *
     * @return position - 专题位置 0为首页
     */
    public Integer getPosition() {
        return position;
    }

    /**
     * 设置专题位置 0为首页
     *
     * @param position 专题位置 0为首页
     */
    public void setPosition(Integer position) {
        this.position = position;
    }

    /**
     * 获取分类图标
     *
     * @return icon - 分类图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置分类图标
     *
     * @param icon 分类图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取专题数量
     *
     * @return subject_count - 专题数量
     */
    public Integer getSubjectCount() {
        return subjectCount;
    }

    /**
     * 设置专题数量
     *
     * @param subjectCount 专题数量
     */
    public void setSubjectCount(Integer subjectCount) {
        this.subjectCount = subjectCount;
    }

    /**
     * @return show_status
     */
    public Integer getShowStatus() {
        return showStatus;
    }

    /**
     * @param showStatus
     */
    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    /**
     * @return sort
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * @param sort
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", type=").append(type);
        sb.append(", position=").append(position);
        sb.append(", icon=").append(icon);
        sb.append(", subjectCount=").append(subjectCount);
        sb.append(", showStatus=").append(showStatus);
        sb.append(", sort=").append(sort);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}