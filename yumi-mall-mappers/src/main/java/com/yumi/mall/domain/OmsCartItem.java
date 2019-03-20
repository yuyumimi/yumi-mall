package com.yumi.mall.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "oms_cart_item")
public class OmsCartItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_sku_id")
    private Long productSkuId;

    @Column(name = "member_id")
    private Long memberId;

    /**
     * 购买数量
     */
    private Integer quantity;

    /**
     * 添加到购物车的价格
     */
    private BigDecimal price;

    /**
     * 销售属性1
     */
    private String sp1;

    /**
     * 销售属性2
     */
    private String sp2;

    /**
     * 销售属性3
     */
    private String sp3;

    /**
     * 商品主图
     */
    @Column(name = "product_pic")
    private String productPic;

    /**
     * 商品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 商品副标题（卖点）
     */
    @Column(name = "product_sub_title")
    private String productSubTitle;

    /**
     * 商品sku条码
     */
    @Column(name = "product_sku_code")
    private String productSkuCode;

    /**
     * 会员昵称
     */
    @Column(name = "member_nickname")
    private String memberNickname;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 修改时间
     */
    @Column(name = "modify_date")
    private Date modifyDate;

    /**
     * 是否删除
     */
    @Column(name = "delete_status")
    private Integer deleteStatus;

    /**
     * 商品分类
     */
    @Column(name = "product_category_id")
    private Long productCategoryId;

    @Column(name = "product_brand")
    private String productBrand;

    @Column(name = "product_sn")
    private String productSn;

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
     * @return product_sku_id
     */
    public Long getProductSkuId() {
        return productSkuId;
    }

    /**
     * @param productSkuId
     */
    public void setProductSkuId(Long productSkuId) {
        this.productSkuId = productSkuId;
    }

    /**
     * @return member_id
     */
    public Long getMemberId() {
        return memberId;
    }

    /**
     * @param memberId
     */
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    /**
     * 获取购买数量
     *
     * @return quantity - 购买数量
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * 设置购买数量
     *
     * @param quantity 购买数量
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * 获取添加到购物车的价格
     *
     * @return price - 添加到购物车的价格
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置添加到购物车的价格
     *
     * @param price 添加到购物车的价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取销售属性1
     *
     * @return sp1 - 销售属性1
     */
    public String getSp1() {
        return sp1;
    }

    /**
     * 设置销售属性1
     *
     * @param sp1 销售属性1
     */
    public void setSp1(String sp1) {
        this.sp1 = sp1;
    }

    /**
     * 获取销售属性2
     *
     * @return sp2 - 销售属性2
     */
    public String getSp2() {
        return sp2;
    }

    /**
     * 设置销售属性2
     *
     * @param sp2 销售属性2
     */
    public void setSp2(String sp2) {
        this.sp2 = sp2;
    }

    /**
     * 获取销售属性3
     *
     * @return sp3 - 销售属性3
     */
    public String getSp3() {
        return sp3;
    }

    /**
     * 设置销售属性3
     *
     * @param sp3 销售属性3
     */
    public void setSp3(String sp3) {
        this.sp3 = sp3;
    }

    /**
     * 获取商品主图
     *
     * @return product_pic - 商品主图
     */
    public String getProductPic() {
        return productPic;
    }

    /**
     * 设置商品主图
     *
     * @param productPic 商品主图
     */
    public void setProductPic(String productPic) {
        this.productPic = productPic;
    }

    /**
     * 获取商品名称
     *
     * @return product_name - 商品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置商品名称
     *
     * @param productName 商品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取商品副标题（卖点）
     *
     * @return product_sub_title - 商品副标题（卖点）
     */
    public String getProductSubTitle() {
        return productSubTitle;
    }

    /**
     * 设置商品副标题（卖点）
     *
     * @param productSubTitle 商品副标题（卖点）
     */
    public void setProductSubTitle(String productSubTitle) {
        this.productSubTitle = productSubTitle;
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
     * 获取会员昵称
     *
     * @return member_nickname - 会员昵称
     */
    public String getMemberNickname() {
        return memberNickname;
    }

    /**
     * 设置会员昵称
     *
     * @param memberNickname 会员昵称
     */
    public void setMemberNickname(String memberNickname) {
        this.memberNickname = memberNickname;
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取修改时间
     *
     * @return modify_date - 修改时间
     */
    public Date getModifyDate() {
        return modifyDate;
    }

    /**
     * 设置修改时间
     *
     * @param modifyDate 修改时间
     */
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * 获取是否删除
     *
     * @return delete_status - 是否删除
     */
    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    /**
     * 设置是否删除
     *
     * @param deleteStatus 是否删除
     */
    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    /**
     * 获取商品分类
     *
     * @return product_category_id - 商品分类
     */
    public Long getProductCategoryId() {
        return productCategoryId;
    }

    /**
     * 设置商品分类
     *
     * @param productCategoryId 商品分类
     */
    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
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
        sb.append(", productId=").append(productId);
        sb.append(", productSkuId=").append(productSkuId);
        sb.append(", memberId=").append(memberId);
        sb.append(", quantity=").append(quantity);
        sb.append(", price=").append(price);
        sb.append(", sp1=").append(sp1);
        sb.append(", sp2=").append(sp2);
        sb.append(", sp3=").append(sp3);
        sb.append(", productPic=").append(productPic);
        sb.append(", productName=").append(productName);
        sb.append(", productSubTitle=").append(productSubTitle);
        sb.append(", productSkuCode=").append(productSkuCode);
        sb.append(", memberNickname=").append(memberNickname);
        sb.append(", createDate=").append(createDate);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", productCategoryId=").append(productCategoryId);
        sb.append(", productBrand=").append(productBrand);
        sb.append(", productSn=").append(productSn);
        sb.append(", productAttr=").append(productAttr);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}