package com.yumi.mall.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sms_home_advertise")
public class SmsHomeAdvertise implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /**
     * 轮播位置：0->PC首页轮播；1->app首页轮播
     */
    private Integer type;

    private String pic;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    /**
     * 上下线状态：0->下线；1->上线
     */
    private Integer status;

    /**
     * 点击数
     */
    @Column(name = "click_count")
    private Integer clickCount;

    /**
     * 下单数
     */
    @Column(name = "order_count")
    private Integer orderCount;

    /**
     * 链接地址
     */
    private String url;

    /**
     * 备注
     */
    private String note;

    /**
     * 排序
     */
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
     * 获取轮播位置：0->PC首页轮播；1->app首页轮播
     *
     * @return type - 轮播位置：0->PC首页轮播；1->app首页轮播
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置轮播位置：0->PC首页轮播；1->app首页轮播
     *
     * @param type 轮播位置：0->PC首页轮播；1->app首页轮播
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return pic
     */
    public String getPic() {
        return pic;
    }

    /**
     * @param pic
     */
    public void setPic(String pic) {
        this.pic = pic;
    }

    /**
     * @return start_time
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * @param startTime
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * @return end_time
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endTime
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取上下线状态：0->下线；1->上线
     *
     * @return status - 上下线状态：0->下线；1->上线
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置上下线状态：0->下线；1->上线
     *
     * @param status 上下线状态：0->下线；1->上线
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取点击数
     *
     * @return click_count - 点击数
     */
    public Integer getClickCount() {
        return clickCount;
    }

    /**
     * 设置点击数
     *
     * @param clickCount 点击数
     */
    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    /**
     * 获取下单数
     *
     * @return order_count - 下单数
     */
    public Integer getOrderCount() {
        return orderCount;
    }

    /**
     * 设置下单数
     *
     * @param orderCount 下单数
     */
    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    /**
     * 获取链接地址
     *
     * @return url - 链接地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置链接地址
     *
     * @param url 链接地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取备注
     *
     * @return note - 备注
     */
    public String getNote() {
        return note;
    }

    /**
     * 设置备注
     *
     * @param note 备注
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
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
        sb.append(", pic=").append(pic);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", status=").append(status);
        sb.append(", clickCount=").append(clickCount);
        sb.append(", orderCount=").append(orderCount);
        sb.append(", url=").append(url);
        sb.append(", note=").append(note);
        sb.append(", sort=").append(sort);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}