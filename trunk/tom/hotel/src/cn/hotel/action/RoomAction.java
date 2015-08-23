package cn.hotel.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.hotel.bean.Room;

/**
 * 房间action
 * @author tom
 *
 */
@Controller
public class RoomAction extends BaseAction<Room> {
	private String roomTypeid;
	private String roomTypeName;
	private String priceFrom;
	private String priceTo;
	
	@Action(value = "add@RoomAction", results = { @Result(name = "success", location = "/RoomAdd.jsp") })
	public String add(){
		roomService.setBean(getBean());
		roomService.add(roomTypeid);
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("roomTypeList", roomTypeService.getAll());
		return SUCCESS;
	}
	
	@Action(value = "addUI@RoomAction", results = { @Result(name = "success", location = "/RoomAdd.jsp") })
	public String addUI(){
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("roomTypeList", roomTypeService.getAll());
		return SUCCESS;
	}
	
	@Action(value = "list@RoomAction", results = { @Result(name = "success", location = "/RoomManage.jsp") })
	public String list(){
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("roomList", roomService.getAll());
		request.put("roomTypeList", roomTypeService.getAll());
		return SUCCESS;
	}
	
	@Action(value = "query@RoomAction", results = { @Result(name = "success", location = "/RoomManage.jsp") })
	public String query(){
		List<Room> roomList = roomService.query(roomTypeid,roomTypeName,priceFrom,priceTo);
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("roomList", roomList);
		request.put("roomTypeList", roomTypeService.getAll());
		return SUCCESS;
	}
	
	@Action(value = "show@RoomAction", results = { @Result(name = "success", location = "/ShowRoom.jsp") })
	public String show(){
		roomService.setBean(getBean());
		Room room = roomService.show();
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("room",room);
		return SUCCESS;
	}

	public void setRoomTypeid(String roomTypeid) {
		this.roomTypeid = roomTypeid;
	}

	public void setRoomTypeName(String roomTypeName) {
		this.roomTypeName = roomTypeName;
	}

	public void setPriceFrom(String priceFrom) {
		this.priceFrom = priceFrom;
	}

	public void setPriceTo(String priceTo) {
		this.priceTo = priceTo;
	}
	
	
}
