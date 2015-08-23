package cn.hotel.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 房间信息
 * @author tom
 *
 */

@Entity
@Table(name="ROOM")
public class Room {
	@Id
	@GeneratedValue
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private String roomno;//房间编号
	@ManyToOne(fetch=FetchType.EAGER)
	private RoomType roomtype;//房间所属标准
	private String roomposition;//房间位置
	private float roomprice;//单价(按天计算)
	private String putup;//是否被定 
	private String roommemo;//备注信息

	public String getPutup() {
		return putup;
	}

	public void setPutup(String putup) {
		this.putup = putup;
	}

	public String getRoommemo() {
		return roommemo;
	}

	public void setRoommemo(String roommemo) {
		this.roommemo = roommemo;
	}

	public String getRoomno() {
		return roomno;
	}

	public void setRoomno(String roomno) {
		this.roomno = roomno;
	}

	public String getRoomposition() {
		return roomposition;
	}

	public void setRoomposition(String roomposition) {
		this.roomposition = roomposition;
	}

	public float getRoomprice() {
		return roomprice;
	}

	public void setRoomprice(float roomprice) {
		this.roomprice = roomprice;
	}
	
	public RoomType getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(RoomType roomtype) {
		this.roomtype = roomtype;
	}

}
