package com.yumi.mall.order.controller;

import com.yumi.mall.domain.OmsOrder;
import com.yumi.mall.order.dto.*;
import com.yumi.mall.order.service.OmsOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 订单管理Controller
 * Created by yumi on 2019/3/11.
 */
@Controller
@Api(tags = "OmsOrderController", description = "订单管理")
@RequestMapping("/order")
public class OmsOrderController {
    @Autowired
    private OmsOrderService orderService;

    @ApiOperation("查询订单")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(OmsOrderQueryParam queryParam,
                       @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                       @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<OmsOrder> orderList = orderService.list(queryParam, pageSize, pageNum);
        return new CommonResult().pageSuccess(orderList);
    }

    @ApiOperation("批量发货")
    @RequestMapping(value = "/update/delivery", method = RequestMethod.POST)
    @ResponseBody
    public Object delivery(@RequestBody List<OmsOrderDeliveryParam> deliveryParamList) {
        int count = orderService.delivery(deliveryParamList);
        if (count > 0) {
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("批量关闭订单")
    @RequestMapping(value = "/update/close", method = RequestMethod.POST)
    @ResponseBody
    public Object close(@RequestParam("ids") List<Long> ids, @RequestParam String note) {
        int count = orderService.close(ids,note);
        if (count > 0) {
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("批量删除订单")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Object delete(@RequestParam("ids") List<Long> ids) {
        int count = orderService.delete(ids);
        if (count > 0) {
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("获取订单详情:订单信息、商品信息、操作记录")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object detail(@PathVariable Long id) {
        OmsOrderDetail orderDetailResult = orderService.detail(id);
        return new CommonResult().success(orderDetailResult);
    }

    @ApiOperation("修改收货人信息")
    @RequestMapping(value = "/update/receiverInfo", method = RequestMethod.POST)
    @ResponseBody
    public Object updateReceiverInfo(@RequestBody OmsReceiverInfoParam receiverInfoParam) {
        int count = orderService.updateReceiverInfo(receiverInfoParam);
        if (count > 0) {
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("修改订单费用信息")
    @RequestMapping(value = "/update/moneyInfo", method = RequestMethod.POST)
    @ResponseBody
    public Object updateReceiverInfo(@RequestBody OmsMoneyInfoParam moneyInfoParam) {
        int count = orderService.updateMoneyInfo(moneyInfoParam);
        if (count > 0) {
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("备注订单")
    @RequestMapping(value = "/update/note", method = RequestMethod.POST)
    @ResponseBody
    public Object updateNote(@RequestParam("id") Long id,
                             @RequestParam("note") String note,
                             @RequestParam("status") Integer status) {
        int count = orderService.updateNote(id,note,status);
        if (count > 0) {
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    //前台接口

//    @ApiOperation("根据购物车信息生成确认单信息")
//    @RequestMapping(value = "/generateConfirmOrder",method = RequestMethod.POST)
//    @ResponseBody
//    public Object generateConfirmOrder(){
//        ConfirmOrderResult confirmOrderResult = portalOrderService.generateConfirmOrder();
//        return new CommonResult().success(confirmOrderResult);
//    }
//
//    @ApiOperation("根据购物车信息生成订单")
//    @RequestMapping(value = "/generateOrder",method = RequestMethod.POST)
//    @ResponseBody
//    public Object generateOrder(@RequestBody OrderParam orderParam){
//        return portalOrderService.generateOrder(orderParam);
//    }
//    @ApiOperation("支付成功的回调")
//    @RequestMapping(value = "/paySuccess",method = RequestMethod.POST)
//    @ResponseBody
//    public Object paySuccess(@RequestParam Long orderId){
//        return portalOrderService.paySuccess(orderId);
//    }
//
//    @ApiOperation("自动取消超时订单")
//    @RequestMapping(value = "/cancelTimeOutOrder",method = RequestMethod.POST)
//    @ResponseBody
//    public Object cancelTimeOutOrder(){
//        return portalOrderService.cancelTimeOutOrder();
//    }
//
//    @ApiOperation("取消单个超时订单")
//    @RequestMapping(value = "/cancelOrder",method = RequestMethod.POST)
//    @ResponseBody
//    public Object cancelOrder(Long orderId){
//        portalOrderService.sendDelayMessageCancelOrder(orderId);
//        return new CommonResult().success(null);
//    }




}
