package cn.hotel.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.hotel.bean.OrderForm;
import cn.hotel.bean.Room;

@Service
@Transactional
public class OrderFormService extends BaseService<OrderForm> {

    public void add() {
        OrderForm order = getBean();
        order.setCheckFlag(0);//未结算
        getSession().save(order);
    }

    /**
     *返回已结算过的订房 
     */
    public List<OrderForm> getAllSettledOrder() {
        return getAllOrder(1);
    }

    /**
     *返回未结算过的订房 
     */
    public List<OrderForm> getAllUnsettledOrder() {
        return getAllOrder(0);
    }

    /**
     * 获取所有订单，以生成顺序降序排列
     * @param flag              是否已结算   0:未结算，1:已结算
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private List<OrderForm> getAllOrder(int flag) {
        Criteria criteria = getSession().createCriteria(OrderForm.class);
        criteria.add(Restrictions.eq("checkFlag", flag));
        criteria.addOrder(Order.desc("id"));
        List list = criteria.list();
        return list == null ? new ArrayList<OrderForm>(0) : list;
    }

    public void delete() {
        OrderForm order = getBean();
        Object object = getSession().get(OrderForm.class, order.getId());
        if (object != null) {
            getSession().delete(object);
        }
    }

    public OrderForm findByRoomNo() {
        OrderForm order = getBean();
        Object obj = getSession().createQuery("from OrderForm o where o.roomno=?")//
                .setParameter(0, order.getRoomno()).uniqueResult();
        if (obj != null) {
            OrderForm ord = (OrderForm) obj;
            ord.setDiscount(order.getDiscount());
            return ord;
        }
        return order;
    }

    public OrderForm findAccounts() {
        OrderForm of = getBean();
        OrderForm order = (OrderForm) getSession()
                .createQuery("from OrderForm o where o.roomno=?")//
                .setParameter(0, of.getRoomno()).uniqueResult();
        if (order.getCheckFlag() == 1) {                                                                    //已结算过
            return order;
        }
        getSession().evict(order);                                                                              //取消同步
        order.setDiscount(of.getDiscount());                                                            //折扣
        Object obj = getSession().createQuery("from Room r where r.roomno=?")//
                .setParameter(0, order.getRoomno()).uniqueResult();
        Date indate = order.getIndate();                                                                    //入住时间
        Date checkdate = order.getCheckdate() == null ? new Date(
                new java.util.Date().getTime()) : order.getCheckdate();                    //离开时间
        order.setCheckdate(checkdate);                                                                    //设置离开时间
        long x = checkdate.getTime() - indate.getTime();
        int dayCount = (int) Math.ceil(x / (24 * 60 * 60 * 1000));                      //居住天数
        float price = 100;
        if (obj != null) {
            Room room = (Room) obj;
            price = room.getRoomprice();                                                                    //价格
        }
        float discount = order.getDiscount();                                                             //折扣
        order.setTotalMoney(price * dayCount);                                                       //应付
        order.setReduceMoney(price * dayCount * discount);                                  //优惠
        order.setRealMoney(order.getTotalMoney() - order.getReduceMoney());//实付=应付-优惠
        return order;
    }

    public Boolean settleAccounts() {
        OrderForm bean = getBean();
        OrderForm order = (OrderForm) getSession()
                .createQuery("from OrderForm o where o.roomno=?")//
                .setParameter(0, getBean().getRoomno()).uniqueResult();
        if (order.getCheckFlag() == 0) {
            order.setCheckFlag(1);//已结算
            order.setCheckdate(bean.getCheckdate());
            order.setDiscount(bean.getDiscount());
            order.setRealMoney(bean.getRealMoney());
            order.setReduceMoney(bean.getReduceMoney());
            order.setTotalMoney(bean.getTotalMoney());
            getSession().update(order);
            return true;
        }
        return false;
    }

    public OrderForm getSingleOrder() {
        Object order = getSession().createQuery("from OrderForm where id=? and checkFlag=0")//
                .setParameter(0, getBean().getId()).uniqueResult();
        if (order != null) {
            return (OrderForm) order;
        }
        return null;
    }
}
