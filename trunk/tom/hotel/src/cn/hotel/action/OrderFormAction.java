package cn.hotel.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.hotel.bean.OrderForm;

import com.opensymphony.xwork2.ActionContext;

public class OrderFormAction extends BaseAction<OrderForm> {
    private Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 只显示未被订的房间
     */
    @Action(value = "addUI@OrderFormAction", results = { @Result(name = "success", location = "/BookInAdd.jsp") })
    public String addUI() {
        ActionContext.getContext().put("rooms", roomService.getUnsettledRoom());
        return SUCCESS;
    }

    /**
     * 登记客房信息
     */
    @Action(value = "addOrder@OrderFormAction", results = {
            @Result(name = "success", type = "redirect", location = "/list@OrderFormAction"),
            @Result(name = "input", location = "/BookInAdd.jsp") })
    public String addOrder() {
        orderFormService.setBean(getBean());
        orderFormService.add();
        return SUCCESS;
    }

    /**
     * 显示未结算过的订房
     */
    @Action(value = "list@OrderFormAction", results = { @Result(name = "success", location = "/BookInManage.jsp") })
    public String list() {
        //房间编号
        ActionContext.getContext().put("rooms", roomService.getUnsettledRoom());
        List<OrderForm> orderList = orderFormService.getAllUnsettledOrder();
        ActionContext.getContext().put("orders", orderList);
        return SUCCESS;
    }

    /**
     * 显示结算过的订房
     */
    @Action(value = "bookSignOutManage@OrderFormAction", results = @Result(name = "success", location = "/BookSignOutManage.jsp"))
    public String bookSignOutManage() {
        List<OrderForm> orderList = orderFormService.getAllSettledOrder();
        ActionContext.getContext().put("orders", orderList);
        return SUCCESS;
    }

    /**
     * 查询单个未结算过的订房
     */
    @Action(value = "singleOrder@OrderFormAction", results = { @Result(name = "success", location = "/showOrder.jsp") })
    public String singleOrder() {
        orderFormService.setBean(getBean());
        OrderForm order = orderFormService.getSingleOrder();
        ActionContext.getContext().put("order", order);
        return SUCCESS;
    }

    /**
     *结算订房 
     */
    @Action(value = "settleAccounts@OrderFormAction", results = { @Result(name = "success", type = "chain", location = "BookSignOutUI@OrderFormAction") })
    public String settleAccounts() {
        orderFormService.setBean(getBean());
        String resinfo = "结算失败，可能已经结算过";
        try {
            Boolean ret = orderFormService.settleAccounts();
            if (ret)
                resinfo = "结算成功";
        } catch (Exception e) {
            log.error(e.toString());
        }
        ActionContext.getContext().put("resinfo", resinfo);
        return SUCCESS;
    }

    /**
     *删除订房(不区分是否结算过) 
     */
    @Action(value = "delete@OrderFormAction", results = { @Result(name = "success", type = "redirect", location = "list@OrderFormAction") })
    public String delete() {
        orderFormService.setBean(getBean());
        orderFormService.delete();
        return SUCCESS;
    }

    /**
     * 只显示未结算过的房间
     *结算视图 
     */
    @Action(value = "BookSignOutUI@OrderFormAction", results = @Result(name = "success", location = "/BookSignOut.jsp"))
    public String BookSignOutUI() {
        ActionContext.getContext().put("rooms", roomService.getUnsettledRoom());
        return SUCCESS;
    }

    /**
     *准备结算信息
     */
    @Action(value = "findAccounts@OrderFormAction", results = @Result(name = "success", type = "chain", location = "BookSignOutUI@OrderFormAction"))
    public String findAccounts() {
        orderFormService.setBean(getBean());
        try {
            OrderForm order = orderFormService.findAccounts();
            ActionContext.getContext().put("order", order);
        } catch (Exception e) {
            log.error(e.toString());
        }
        return SUCCESS;
    }

    /**
     * 查询未结算过的订房
     */
    @Action(value = "findByRoomNo@OrderFormAction", results = @Result(name = "success", location = "/BookInManage.jsp"))
    public String findByRoomNo() {
        orderFormService.setBean(getBean());
        //房间编号
        ActionContext.getContext().put("rooms", roomService.getUnsettledRoom());
        final OrderForm singleOrder = orderFormService.findByRoomNo();
        ActionContext.getContext().put("orders", new ArrayList<OrderForm>() {
            {
                add(singleOrder);
            }
        });
        return SUCCESS;
    }
}
