package com.yumi.mall.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "ums_member_level")
public class UmsMemberLevel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "growth_point")
    private Integer growthPoint;

    /**
     * 是否为默认等级：0->不是；1->是
     */
    @Column(name = "default_status")
    private Integer defaultStatus;

    /**
     * 免运费标准
     */
    @Column(name = "free_freight_point")
    private BigDecimal freeFreightPoint;

    /**
     * 每次评价获取的成长值
     */
    @Column(name = "comment_growth_point")
    private Integer commentGrowthPoint;

    /**
     * 是否有免邮特权
     */
    @Column(name = "priviledge_free_freight")
    private Integer priviledgeFreeFreight;

    /**
     * 是否有签到特权
     */
    @Column(name = "priviledge_sign_in")
    private Integer priviledgeSignIn;

    /**
     * 是否有评论获奖励特权
     */
    @Column(name = "priviledge_comment")
    private Integer priviledgeComment;

    /**
     * 是否有专享活动特权
     */
    @Column(name = "priviledge_promotion")
    private Integer priviledgePromotion;

    /**
     * 是否有会员价格特权
     */
    @Column(name = "priviledge_member_price")
    private Integer priviledgeMemberPrice;

    /**
     * 是否有生日特权
     */
    @Column(name = "priviledge_birthday")
    private Integer priviledgeBirthday;

    private String note;

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
     * @return growth_point
     */
    public Integer getGrowthPoint() {
        return growthPoint;
    }

    /**
     * @param growthPoint
     */
    public void setGrowthPoint(Integer growthPoint) {
        this.growthPoint = growthPoint;
    }

    /**
     * 获取是否为默认等级：0->不是；1->是
     *
     * @return default_status - 是否为默认等级：0->不是；1->是
     */
    public Integer getDefaultStatus() {
        return defaultStatus;
    }

    /**
     * 设置是否为默认等级：0->不是；1->是
     *
     * @param defaultStatus 是否为默认等级：0->不是；1->是
     */
    public void setDefaultStatus(Integer defaultStatus) {
        this.defaultStatus = defaultStatus;
    }

    /**
     * 获取免运费标准
     *
     * @return free_freight_point - 免运费标准
     */
    public BigDecimal getFreeFreightPoint() {
        return freeFreightPoint;
    }

    /**
     * 设置免运费标准
     *
     * @param freeFreightPoint 免运费标准
     */
    public void setFreeFreightPoint(BigDecimal freeFreightPoint) {
        this.freeFreightPoint = freeFreightPoint;
    }

    /**
     * 获取每次评价获取的成长值
     *
     * @return comment_growth_point - 每次评价获取的成长值
     */
    public Integer getCommentGrowthPoint() {
        return commentGrowthPoint;
    }

    /**
     * 设置每次评价获取的成长值
     *
     * @param commentGrowthPoint 每次评价获取的成长值
     */
    public void setCommentGrowthPoint(Integer commentGrowthPoint) {
        this.commentGrowthPoint = commentGrowthPoint;
    }

    /**
     * 获取是否有免邮特权
     *
     * @return priviledge_free_freight - 是否有免邮特权
     */
    public Integer getPriviledgeFreeFreight() {
        return priviledgeFreeFreight;
    }

    /**
     * 设置是否有免邮特权
     *
     * @param priviledgeFreeFreight 是否有免邮特权
     */
    public void setPriviledgeFreeFreight(Integer priviledgeFreeFreight) {
        this.priviledgeFreeFreight = priviledgeFreeFreight;
    }

    /**
     * 获取是否有签到特权
     *
     * @return priviledge_sign_in - 是否有签到特权
     */
    public Integer getPriviledgeSignIn() {
        return priviledgeSignIn;
    }

    /**
     * 设置是否有签到特权
     *
     * @param priviledgeSignIn 是否有签到特权
     */
    public void setPriviledgeSignIn(Integer priviledgeSignIn) {
        this.priviledgeSignIn = priviledgeSignIn;
    }

    /**
     * 获取是否有评论获奖励特权
     *
     * @return priviledge_comment - 是否有评论获奖励特权
     */
    public Integer getPriviledgeComment() {
        return priviledgeComment;
    }

    /**
     * 设置是否有评论获奖励特权
     *
     * @param priviledgeComment 是否有评论获奖励特权
     */
    public void setPriviledgeComment(Integer priviledgeComment) {
        this.priviledgeComment = priviledgeComment;
    }

    /**
     * 获取是否有专享活动特权
     *
     * @return priviledge_promotion - 是否有专享活动特权
     */
    public Integer getPriviledgePromotion() {
        return priviledgePromotion;
    }

    /**
     * 设置是否有专享活动特权
     *
     * @param priviledgePromotion 是否有专享活动特权
     */
    public void setPriviledgePromotion(Integer priviledgePromotion) {
        this.priviledgePromotion = priviledgePromotion;
    }

    /**
     * 获取是否有会员价格特权
     *
     * @return priviledge_member_price - 是否有会员价格特权
     */
    public Integer getPriviledgeMemberPrice() {
        return priviledgeMemberPrice;
    }

    /**
     * 设置是否有会员价格特权
     *
     * @param priviledgeMemberPrice 是否有会员价格特权
     */
    public void setPriviledgeMemberPrice(Integer priviledgeMemberPrice) {
        this.priviledgeMemberPrice = priviledgeMemberPrice;
    }

    /**
     * 获取是否有生日特权
     *
     * @return priviledge_birthday - 是否有生日特权
     */
    public Integer getPriviledgeBirthday() {
        return priviledgeBirthday;
    }

    /**
     * 设置是否有生日特权
     *
     * @param priviledgeBirthday 是否有生日特权
     */
    public void setPriviledgeBirthday(Integer priviledgeBirthday) {
        this.priviledgeBirthday = priviledgeBirthday;
    }

    /**
     * @return note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note
     */
    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", growthPoint=").append(growthPoint);
        sb.append(", defaultStatus=").append(defaultStatus);
        sb.append(", freeFreightPoint=").append(freeFreightPoint);
        sb.append(", commentGrowthPoint=").append(commentGrowthPoint);
        sb.append(", priviledgeFreeFreight=").append(priviledgeFreeFreight);
        sb.append(", priviledgeSignIn=").append(priviledgeSignIn);
        sb.append(", priviledgeComment=").append(priviledgeComment);
        sb.append(", priviledgePromotion=").append(priviledgePromotion);
        sb.append(", priviledgeMemberPrice=").append(priviledgeMemberPrice);
        sb.append(", priviledgeBirthday=").append(priviledgeBirthday);
        sb.append(", note=").append(note);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}