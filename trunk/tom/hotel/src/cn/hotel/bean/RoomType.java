package cn.hotel.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 房间类型
 * @author tom
 *
 */

@Entity
@Table(name="ROOM_TYPE")
public class RoomType {
	@Id
	@GeneratedValue
	private Integer id;
	private int typeId;//房间标准编号
	private String typeName;//房间标准名称
	private float area;//房间面积 
	private int bednum;//床位数量
	private String haircontion;//是否有空调
	private String htelephone;//是否有电话
	private String htelevion;//是否有电视
	private String htoilet;//是否有卫生间
	private float price;//住房单价

	public RoomType() {
		super();
		this.typeId = 0;
		this.typeName = "";
		this.area = 0.0f;
		this.bednum = 0;
		this.haircontion = "否";
		this.htelephone = "否";
		this.htelevion = "否";
		this.htoilet = "否";
		this.price = 0.0f;
	}

	public float getArea() {
		return area;
	}

	public void setArea(float area) {
		this.area = area;
	}

	public int getBednum() {
		return bednum;
	}

	public void setBednum(int bednum) {
		this.bednum = bednum;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHaircontion() {
		return haircontion;
	}

	public void setHaircontion(String haircontion) {
		this.haircontion = haircontion;
	}

	public String getHtelephone() {
		return htelephone;
	}

	public void setHtelephone(String htelephone) {
		this.htelephone = htelephone;
	}

	public String getHtelevion() {
		return htelevion;
	}

	public void setHtelevion(String htelevion) {
		this.htelevion = htelevion;
	}

	public String getHtoilet() {
		return htoilet;
	}

	public void setHtoilet(String htoilet) {
		this.htoilet = htoilet;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}
