package com.yumi.mall.order.dao;

import com.yumi.mall.domain.OmsOrderOperateHistory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单操作记录自定义Dao
 * Created by yumi on 2019/3/12.
 */
public interface OmsOrderOperateHistoryDao {
    int insertList(@Param("list") List<OmsOrderOperateHistory> orderOperateHistoryList);
}
