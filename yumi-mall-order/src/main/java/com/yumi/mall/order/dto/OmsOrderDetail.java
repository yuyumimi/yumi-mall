package com.yumi.mall.order.dto;

import com.yumi.mall.domain.OmsOrder;
import com.yumi.mall.domain.OmsOrderItem;
import com.yumi.mall.domain.OmsOrderOperateHistory;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 订单详情信息
 * Created by yumi on 2019/3/11.
 */
public class OmsOrderDetail extends OmsOrder {
    @Getter
    @Setter
    private List<OmsOrderItem> orderItemList;
    @Getter
    @Setter
    private List<OmsOrderOperateHistory> historyList;
}
