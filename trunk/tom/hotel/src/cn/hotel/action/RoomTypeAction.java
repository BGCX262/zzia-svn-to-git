package cn.hotel.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.hotel.bean.Room;
import cn.hotel.bean.RoomType;

/**
 * 房间类型action
 * @author tom
 *
 */
@Controller
public class RoomTypeAction extends BaseAction<RoomType> {
	private String roomTypeName;
	private String priceFrom;
	private String priceTo;
	
	@Action(value = "add@RoomTypeAction", results = { @Result(name = "success", location = "/RoomTypeAdd.jsp") })
	public String add(){
		roomTypeService.setBean(getBean());
		roomTypeService.add();
		return SUCCESS;
	}
	
	@Action(value = "addUI@RoomTypeAction", results = { @Result(name = "success", location = "/RoomTypeAdd.jsp") })
	public String addUI(){
		return SUCCESS;
	}
	
	@Action(value = "list@RoomTypeAction", results = { @Result(name = "success", location = "/RoomTypeManage.jsp") })
	public String list(){
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("roomTypeList", roomTypeService.getAll());
		return SUCCESS;
	}
	
	@Action(value = "delete@RoomTypeAction", results = { @Result(name = "success", location = "/RoomTypeManage.jsp") })
	public String delete(){
		try {
			roomTypeService.setBean(getBean());
			roomTypeService.delete();
			Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
			request.put("roomTypeList", roomTypeService.getAll());
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}

	@Action(value = "query@RoomTypeAction", results = { @Result(name = "success", location = "/RoomTypeManage.jsp") })
	public String query(){
		List<RoomType> roomTypeList = roomTypeService.query(roomTypeName,priceFrom,priceTo);
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("roomTypeList", roomTypeList);
		return SUCCESS;
	}
	
	@Action(value = "show@RoomTypeAction", results = { @Result(name = "success", location = "/ShowRoomType.jsp") })
	public String show(){
		roomTypeService.setBean(getBean());
		RoomType roomType = roomTypeService.show();
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("roomType",roomType);
		return SUCCESS;
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
