package cn.hotel.service;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.hotel.bean.RoomType;
import cn.hotel.util.Util;

@Service
@Transactional
public class RoomTypeService extends BaseService<RoomType> {

    public void add() {
        getSession().save(getBean());
    }

    @SuppressWarnings("unchecked")
    public List<RoomType> getAll() {
        return getSession().createQuery("from RoomType").list();
    }

	public void delete() {
		Session session = getSession();
		SQLQuery sqlQuery = session.createSQLQuery("delete from Room where roomtype_id = " + getBean().getId());
		sqlQuery.executeUpdate();
		session.delete(getBean());
	}

	public List<RoomType> query(String roomTypeName, String priceFrom,
			String priceTo) {
		String sql = "from RoomType t ";
		String where = "";
		if (Util.notNull(roomTypeName)) {
			where += " t.typeName like '%"+roomTypeName +"%'"+ " and ";
		}
		if (Util.notNull(priceFrom)) {
			where += " t.price >="+priceFrom+ " and ";
		}
		if (Util.notNull(priceTo)) {
			where += " t.price <="+priceTo+ " and ";
		}
		if (Util.notNull(where)) {
			where = " where " + where.substring(0,where.length()-5);
		}
		return getSession().createQuery(sql + where).list();
	}

	public RoomType show() {
		return (RoomType) getSession().get(RoomType.class, getBean().getId());
	}

}
