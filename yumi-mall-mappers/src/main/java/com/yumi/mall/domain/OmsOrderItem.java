package com.yumi.mall.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "oms_order_item")
public class OmsOrderItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 订单id
     */
    @Column(name = "order_id")
    private Long orderId;

    /**
     * 订单编号
     */
    @Column(name = "order_sn")
    private String orderSn;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_pic")
    private String productPic;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_brand")
    private String productBrand;

    @Column(name = "product_sn")
    private String productSn;

    /**
     * 销售价格
     */
    @Column(name = "product_price")
    private BigDecimal productPrice;

    /**
     * 购买数量
     */
    @Column(name = "product_quantity")
    private Integer productQuantity;

    /**
     * 商品sku编号
     */
    @Column(name = "product_sku_id")
    private Long productSkuId;

    /**
     * 商品sku条码
     */
    @Column(name = "product_sku_code")
    private String productSkuCode;

    /**
     * 商品分类id
     */
    @Column(name = "product_category_id")
    private Long productCategoryId;

    /**
     * 商品的销售属性
     */
    private String sp1;

    private String sp2;

    private String sp3;

    /**
     * 商品促销名称
     */
    @Column(name = "promotion_name")
    private String promotionName;

    /**
     * 商品促销分解金额
     */
    @Column(name = "promotion_amount")
    private BigDecimal promotionAmount;

    /**
     * 优惠券优惠分解金额
     */
    @Column(name = "coupon_amount")
    private BigDecimal couponAmount;

    /**
     * 积分优惠分解金额
     */
    @Column(name = "integration_amount")
    private BigDecimal integrationAmount;

    /**
     * 该商品经过优惠后的分解金额
     */
    @Column(name = "real_amount")
    private BigDecimal realAmount;

    @Column(name = "gift_integration")
    private Integer giftIntegration;

    @Column(name = "gift_growth")
    private Integer giftGrowth;

    /**
     * 商品销售属性:[{"key":"颜色","value":"颜色"},{"key":"容量","value":"4G"}]
     */
    @Column(name = "product_attr")
    private String productAttr;

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
     * 获取订单id
     *
     * @return order_id - 订单id
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * 设置订单id
     *
     * @param orderId 订单id
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取订单编号
     *
     * @return order_sn - 订单编号
     */
    public String getOrderSn() {
        return orderSn;
    }

    /**
     * 设置订单编号
     *
     * @param orderSn 订单编号
     */
    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
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
     * @return product_pic
     */
    public String getProductPic() {
        return productPic;
    }

    /**
     * @param productPic
     */
    public void setProductPic(String productPic) {
        this.productPic = productPic;
    }

    /**
     * @return product_name
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return product_brand
     */
    public String getProductBrand() {
        return productBrand;
    }

    /**
     * @param productBrand
     */
    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    /**
     * @return product_sn
     */
    public String getProductSn() {
        return productSn;
    }

    /**
     * @param productSn
     */
    public void setProductSn(String productSn) {
        this.productSn = productSn;
    }

    /**
     * 获取销售价格
     *
     * @return product_price - 销售价格
     */
    public BigDecimal getProductPrice() {
        return productPrice;
    }

    /**
     * 设置销售价格
     *
     * @param productPrice 销售价格
     */
    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * 获取购买数量
     *
     * @return product_quantity - 购买数量
     */
    public Integer getProductQuantity() {
        return productQuantity;
    }

    /**
     * 设置购买数量
     *
     * @param productQuantity 购买数量
     */
    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    /**
     * 获取商品sku编号
     *
     * @return product_sku_id - 商品sku编号
     */
    public Long getProductSkuId() {
        return productSkuId;
    }

    /**
     * 设置商品sku编号
     *
     * @param productSkuId 商品sku编号
     */
    public void setProductSkuId(Long productSkuId) {
        this.productSkuId = productSkuId;
    }

    /**
     * 获取商品sku条码
     *
     * @return product_sku_code - 商品sku条码
     */
    public String getProductSkuCode() {
        return productSkuCode;
    }

    /**
     * 设置商品sku条码
     *
     * @param productSkuCode 商品sku条码
     */
    public void setProductSkuCode(String productSkuCode) {
        this.productSkuCode = productSkuCode;
    }

    /**
     * 获取商品分类id
     *
     * @return product_category_id - 商品分类id
     */
    public Long getProductCategoryId() {
        return productCategoryId;
    }

    /**
     * 设置商品分类id
     *
     * @param productCategoryId 商品分类id
     */
    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    /**
     * 获取商品的销售属性
     *
     * @return sp1 - 商品的销售属性
     */
    public String getSp1() {
        return sp1;
    }

    /**
     * 设置商品的销售属性
     *
     * @param sp1 商品的销售属性
     */
    public void setSp1(String sp1) {
        this.sp1 = sp1;
    }

    /**
     * @return sp2
     */
    public String getSp2() {
        return sp2;
    }

    /**
     * @param sp2
     */
    public void setSp2(String sp2) {
        this.sp2 = sp2;
    }

    /**
     * @return sp3
     */
    public String getSp3() {
        return sp3;
    }

    /**
     * @param sp3
     */
    public void setSp3(String sp3) {
        this.sp3 = sp3;
    }

    /**
     * 获取商品促销名称
     *
     * @return promotion_name - 商品促销名称
     */
    public String getPromotionName() {
        return promotionName;
    }

    /**
     * 设置商品促销名称
     *
     * @param promotionName 商品促销名称
     */
    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    /**
     * 获取商品促销分解金额
     *
     * @return promotion_amount - 商品促销分解金额
     */
    public BigDecimal getPromotionAmount() {
        return promotionAmount;
    }

    /**
     * 设置商品促销分解金额
     *
     * @param promotionAmount 商品促销分解金额
     */
    public void setPromotionAmount(BigDecimal promotionAmount) {
        this.promotionAmount = promotionAmount;
    }

    /**
     * 获取优惠券优惠分解金额
     *
     * @return coupon_amount - 优惠券优惠分解金额
     */
    public BigDecimal getCouponAmount() {
        return couponAmount;
    }

    /**
     * 设置优惠券优惠分解金额
     *
     * @param couponAmount 优惠券优惠分解金额
     */
    public void setCouponAmount(BigDecimal couponAmount) {
        this.couponAmount = couponAmount;
    }

    /**
     * 获取积分优惠分解金额
     *
     * @return integration_amount - 积分优惠分解金额
     */
    public BigDecimal getIntegrationAmount() {
        return integrationAmount;
    }

    /**
     * 设置积分优惠分解金额
     *
     * @param integrationAmount 积分优惠分解金额
     */
    public void setIntegrationAmount(BigDecimal integrationAmount) {
        this.integrationAmount = integrationAmount;
    }

    /**
     * 获取该商品经过优惠后的分解金额
     *
     * @return real_amount - 该商品经过优惠后的分解金额
     */
    public BigDecimal getRealAmount() {
        return realAmount;
    }

    /**
     * 设置该商品经过优惠后的分解金额
     *
     * @param realAmount 该商品经过优惠后的分解金额
     */
    public void setRealAmount(BigDecimal realAmount) {
        this.realAmount = realAmount;
    }

    /**
     * @return gift_integration
     */
    public Integer getGiftIntegration() {
        return giftIntegration;
    }

    /**
     * @param giftIntegration
     */
    public void setGiftIntegration(Integer giftIntegration) {
        this.giftIntegration = giftIntegration;
    }

    /**
     * @return gift_growth
     */
    public Integer getGiftGrowth() {
        return giftGrowth;
    }

    /**
     * @param giftGrowth
     */
    public void setGiftGrowth(Integer giftGrowth) {
        this.giftGrowth = giftGrowth;
    }

    /**
     * 获取商品销售属性:[{"key":"颜色","value":"颜色"},{"key":"容量","value":"4G"}]
     *
     * @return product_attr - 商品销售属性:[{"key":"颜色","value":"颜色"},{"key":"容量","value":"4G"}]
     */
    public String getProductAttr() {
        return productAttr;
    }

    /**
     * 设置商品销售属性:[{"key":"颜色","value":"颜色"},{"key":"容量","value":"4G"}]
     *
     * @param productAttr 商品销售属性:[{"key":"颜色","value":"颜色"},{"key":"容量","value":"4G"}]
     */
    public void setProductAttr(String productAttr) {
        this.productAttr = productAttr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderId=").append(orderId);
        sb.append(", orderSn=").append(orderSn);
        sb.append(", productId=").append(productId);
        sb.append(", productPic=").append(productPic);
        sb.append(", productName=").append(productName);
        sb.append(", productBrand=").append(productBrand);
        sb.append(", productSn=").append(productSn);
        sb.append(", productPrice=").append(productPrice);
        sb.append(", productQuantity=").append(productQuantity);
        sb.append(", productSkuId=").append(productSkuId);
        sb.append(", productSkuCode=").append(productSkuCode);
        sb.append(", productCategoryId=").append(productCategoryId);
        sb.append(", sp1=").append(sp1);
        sb.append(", sp2=").append(sp2);
        sb.append(", sp3=").append(sp3);
        sb.append(", promotionName=").append(promotionName);
        sb.append(", promotionAmount=").append(promotionAmount);
        sb.append(", couponAmount=").append(couponAmount);
        sb.append(", integrationAmount=").append(integrationAmount);
        sb.append(", realAmount=").append(realAmount);
        sb.append(", giftIntegration=").append(giftIntegration);
        sb.append(", giftGrowth=").append(giftGrowth);
        sb.append(", productAttr=").append(productAttr);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}