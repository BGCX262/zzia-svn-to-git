package cn.hotel.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.hotel.bean.Room;
import cn.hotel.bean.RoomType;
import cn.hotel.util.Util;

@Service
@Transactional
public class RoomService extends BaseService<Room> {

    public void add(String roomtypeid) {
        Session session = getSession();
        RoomType roomType = (RoomType) session.get(RoomType.class,
                Integer.valueOf(roomtypeid));
        getBean().setRoomtype(roomType);
        getSession().save(getBean());
    }

    public List<Room> getAll() {
        return getAll(null);
    }

    /**
     *返回未结算过的房间 
     */
    public List<Room> getUnsettledRoom() {
        return getAll(0);
    }

    /**
     *返回已结算过的房间 
     */
    public List<Room> getSettledRoom() {
        return getAll(1);
    }

    /**
     * 返回符合条件的订房
     * 默认显示所有
     * @param flag         是否结算    0:未结算，1:已结算
     */
    @SuppressWarnings("unchecked")
    private List<Room> getAll(Integer flag) {
        Query query = getSession().createQuery("FROM Room");
        if (flag != null) {
            query = getSession()
                    .createQuery(
                            "from Room r where r.roomno in (from OrderForm o where o.checkFlag=?)");
            query.setParameter(0, flag);
        }
        return query.list();
    }

    @SuppressWarnings("unchecked")
    public List<Room> query(String roomTypeId, String roomTypeName, String priceFrom,
            String priceTo) {
        String sql = "from Room t ";
        String where = "";
        if (Util.notNull(roomTypeId)) {
            where += " t.roomtype.id =" + roomTypeId + " and ";
        }
        if (Util.notNull(roomTypeName)) {
            where += " t.roomtype.typeName like '%" + roomTypeName + "%'" + " and ";
        }
        if (Util.notNull(priceFrom)) {
            where += " t.roomprice >=" + priceFrom + " and ";
        }
        if (Util.notNull(priceTo)) {
            where += " t.roomprice <=" + priceTo + " and ";
        }
        if (Util.notNull(where)) {
            where = " where " + where.substring(0, where.length() - 5);
        }
        return getSession().createQuery(sql + where).list();
    }

    public Room show() {
        return (Room) getSession().get(Room.class, getBean().getId());
    }
}
