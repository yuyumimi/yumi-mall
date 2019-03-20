package com.yumi.mall.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "cms_subject")
public class CmsSubject implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_id")
    private Long categoryId;

    private String title;

    /**
     * 专题主图
     */
    private String pic;

    /**
     * 关联产品数量
     */
    @Column(name = "product_count")
    private Integer productCount;

    @Column(name = "recommend_status")
    private Integer recommendStatus;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "collect_count")
    private Integer collectCount;

    @Column(name = "read_count")
    private Integer readCount;

    @Column(name = "comment_count")
    private Integer commentCount;

    /**
     * 画册图片用逗号分割
     */
    @Column(name = "album_pics")
    private String albumPics;

    private String description;

    /**
     * 显示状态：0->不显示；1->显示
     */
    @Column(name = "show_status")
    private Integer showStatus;

    /**
     * 转发数
     */
    @Column(name = "forward_count")
    private Integer forwardCount;

    /**
     * 专题分类名称
     */
    @Column(name = "category_name")
    private String categoryName;

    private String content;

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
     * @return category_id
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取专题主图
     *
     * @return pic - 专题主图
     */
    public String getPic() {
        return pic;
    }

    /**
     * 设置专题主图
     *
     * @param pic 专题主图
     */
    public void setPic(String pic) {
        this.pic = pic;
    }

    /**
     * 获取关联产品数量
     *
     * @return product_count - 关联产品数量
     */
    public Integer getProductCount() {
        return productCount;
    }

    /**
     * 设置关联产品数量
     *
     * @param productCount 关联产品数量
     */
    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    /**
     * @return recommend_status
     */
    public Integer getRecommendStatus() {
        return recommendStatus;
    }

    /**
     * @param recommendStatus
     */
    public void setRecommendStatus(Integer recommendStatus) {
        this.recommendStatus = recommendStatus;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return collect_count
     */
    public Integer getCollectCount() {
        return collectCount;
    }

    /**
     * @param collectCount
     */
    public void setCollectCount(Integer collectCount) {
        this.collectCount = collectCount;
    }

    /**
     * @return read_count
     */
    public Integer getReadCount() {
        return readCount;
    }

    /**
     * @param readCount
     */
    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    /**
     * @return comment_count
     */
    public Integer getCommentCount() {
        return commentCount;
    }

    /**
     * @param commentCount
     */
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * 获取画册图片用逗号分割
     *
     * @return album_pics - 画册图片用逗号分割
     */
    public String getAlbumPics() {
        return albumPics;
    }

    /**
     * 设置画册图片用逗号分割
     *
     * @param albumPics 画册图片用逗号分割
     */
    public void setAlbumPics(String albumPics) {
        this.albumPics = albumPics;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取显示状态：0->不显示；1->显示
     *
     * @return show_status - 显示状态：0->不显示；1->显示
     */
    public Integer getShowStatus() {
        return showStatus;
    }

    /**
     * 设置显示状态：0->不显示；1->显示
     *
     * @param showStatus 显示状态：0->不显示；1->显示
     */
    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    /**
     * 获取转发数
     *
     * @return forward_count - 转发数
     */
    public Integer getForwardCount() {
        return forwardCount;
    }

    /**
     * 设置转发数
     *
     * @param forwardCount 转发数
     */
    public void setForwardCount(Integer forwardCount) {
        this.forwardCount = forwardCount;
    }

    /**
     * 获取专题分类名称
     *
     * @return category_name - 专题分类名称
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 设置专题分类名称
     *
     * @param categoryName 专题分类名称
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", title=").append(title);
        sb.append(", pic=").append(pic);
        sb.append(", productCount=").append(productCount);
        sb.append(", recommendStatus=").append(recommendStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", collectCount=").append(collectCount);
        sb.append(", readCount=").append(readCount);
        sb.append(", commentCount=").append(commentCount);
        sb.append(", albumPics=").append(albumPics);
        sb.append(", description=").append(description);
        sb.append(", showStatus=").append(showStatus);
        sb.append(", forwardCount=").append(forwardCount);
        sb.append(", categoryName=").append(categoryName);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}