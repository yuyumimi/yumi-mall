package com.yumi.mall.order.dao;

import com.yumi.mall.order.dto.*;
import com.yumi.mall.domain.OmsOrder;
import com.yumi.mall.order.dto.OmsOrderDetail;
import com.yumi.mall.order.dto.OmsOrderQueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单自定义查询Dao
 * Created by yumi on 2019/3/12.
 */
public interface OmsOrderDao {
    /**
     * 条件查询订单
     */
    List<OmsOrder> getList(@Param("queryParam") OmsOrderQueryParam queryParam);
    /**
     * 批量发货
     */
    int delivery(@Param("list") List<OmsOrderDeliveryParam> deliveryParamList);
    /**
     * 获取订单详情
     */
    OmsOrderDetail getDetail(@Param("id") Long id);
}
