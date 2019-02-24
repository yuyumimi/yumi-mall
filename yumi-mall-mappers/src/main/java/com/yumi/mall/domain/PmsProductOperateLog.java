package com.yumi.mall.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "pms_product_operate_log")
public class PmsProductOperateLog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "price_old")
    private BigDecimal priceOld;

    @Column(name = "price_new")
    private BigDecimal priceNew;

    @Column(name = "sale_price_old")
    private BigDecimal salePriceOld;

    @Column(name = "sale_price_new")
    private BigDecimal salePriceNew;

    /**
     * 赠送的积分
     */
    @Column(name = "gift_point_old")
    private Integer giftPointOld;

    @Column(name = "gift_point_new")
    private Integer giftPointNew;

    @Column(name = "use_point_limit_old")
    private Integer usePointLimitOld;

    @Column(name = "use_point_limit_new")
    private Integer usePointLimitNew;

    /**
     * 操作人
     */
    @Column(name = "operate_man")
    private String operateMan;

    @Column(name = "create_time")
    private Date createTime;

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
     * @return product_id
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * @param productId
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * @return price_old
     */
    public BigDecimal getPriceOld() {
        return priceOld;
    }

    /**
     * @param priceOld
     */
    public void setPriceOld(BigDecimal priceOld) {
        this.priceOld = priceOld;
    }

    /**
     * @return price_new
     */
    public BigDecimal getPriceNew() {
        return priceNew;
    }

    /**
     * @param priceNew
     */
    public void setPriceNew(BigDecimal priceNew) {
        this.priceNew = priceNew;
    }

    /**
     * @return sale_price_old
     */
    public BigDecimal getSalePriceOld() {
        return salePriceOld;
    }

    /**
     * @param salePriceOld
     */
    public void setSalePriceOld(BigDecimal salePriceOld) {
        this.salePriceOld = salePriceOld;
    }

    /**
     * @return sale_price_new
     */
    public BigDecimal getSalePriceNew() {
        return salePriceNew;
    }

    /**
     * @param salePriceNew
     */
    public void setSalePriceNew(BigDecimal salePriceNew) {
        this.salePriceNew = salePriceNew;
    }

    /**
     * 获取赠送的积分
     *
     * @return gift_point_old - 赠送的积分
     */
    public Integer getGiftPointOld() {
        return giftPointOld;
    }

    /**
     * 设置赠送的积分
     *
     * @param giftPointOld 赠送的积分
     */
    public void setGiftPointOld(Integer giftPointOld) {
        this.giftPointOld = giftPointOld;
    }

    /**
     * @return gift_point_new
     */
    public Integer getGiftPointNew() {
        return giftPointNew;
    }

    /**
     * @param giftPointNew
     */
    public void setGiftPointNew(Integer giftPointNew) {
        this.giftPointNew = giftPointNew;
    }

    /**
     * @return use_point_limit_old
     */
    public Integer getUsePointLimitOld() {
        return usePointLimitOld;
    }

    /**
     * @param usePointLimitOld
     */
    public void setUsePointLimitOld(Integer usePointLimitOld) {
        this.usePointLimitOld = usePointLimitOld;
    }

    /**
     * @return use_point_limit_new
     */
    public Integer getUsePointLimitNew() {
        return usePointLimitNew;
    }

    /**
     * @param usePointLimitNew
     */
    public void setUsePointLimitNew(Integer usePointLimitNew) {
        this.usePointLimitNew = usePointLimitNew;
    }

    /**
     * 获取操作人
     *
     * @return operate_man - 操作人
     */
    public String getOperateMan() {
        return operateMan;
    }

    /**
     * 设置操作人
     *
     * @param operateMan 操作人
     */
    public void setOperateMan(String operateMan) {
        this.operateMan = operateMan;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productId=").append(productId);
        sb.append(", priceOld=").append(priceOld);
        sb.append(", priceNew=").append(priceNew);
        sb.append(", salePriceOld=").append(salePriceOld);
        sb.append(", salePriceNew=").append(salePriceNew);
        sb.append(", giftPointOld=").append(giftPointOld);
        sb.append(", giftPointNew=").append(giftPointNew);
        sb.append(", usePointLimitOld=").append(usePointLimitOld);
        sb.append(", usePointLimitNew=").append(usePointLimitNew);
        sb.append(", operateMan=").append(operateMan);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}