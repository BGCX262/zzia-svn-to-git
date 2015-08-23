package cn.hotel.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 订单信息
 * @author tom
 *
 */

@Entity
@Table(name="ORDER_FORM")
public class OrderForm {
	@Id
	@GeneratedValue
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private String bookno;//订房编号
	private String customname;//顾客名称
	private String customid;//顾客身份证号
	private String roomno;//房间编号
	private java.sql.Date indate;//入住时间
	private int checkFlag;//是否已结算
	private java.sql.Date checkdate;//结算日期
	private float totalMoney;//结算总金额
	private float discount;//折扣优惠
	private float reduceMoney;//优惠金额
	private float realMoney;//实收金额
	private String memo;//附加信息

	public String getBookno() {
		return bookno;
	}

	public void setBookno(String bookno) {
		this.bookno = bookno;
	}

	public java.sql.Date getCheckdate() {
		return checkdate;
	}

	public void setCheckdate(java.sql.Date checkdate) {
		this.checkdate = checkdate;
	}

	public int getCheckFlag() {
		return checkFlag;
	}

	public void setCheckFlag(int checkFlag) {
		this.checkFlag = checkFlag;
	}

	public String getCustomid() {
		return customid;
	}

	public void setCustomid(String customid) {
		this.customid = customid;
	}

	public String getCustomname() {
		return customname;
	}

	public void setCustomname(String customname) {
		this.customname = customname;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public java.sql.Date getIndate() {
		return indate;
	}

	public void setIndate(java.sql.Date indate) {
		this.indate = indate;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public float getRealMoney() {
		return realMoney;
	}

	public void setRealMoney(float realMoney) {
		this.realMoney = realMoney;
	}

	public float getReduceMoney() {
		return reduceMoney;
	}

	public void setReduceMoney(float reduceMoney) {
		this.reduceMoney = reduceMoney;
	}

	public String getRoomno() {
		return roomno;
	}

	public void setRoomno(String roomno) {
		this.roomno = roomno;
	}

	public float getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(float totalMoney) {
		this.totalMoney = totalMoney;
	}

}
