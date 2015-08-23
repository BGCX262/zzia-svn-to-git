package cn.hotel.action;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import cn.hotel.service.OrderFormService;
import cn.hotel.service.RoomService;
import cn.hotel.service.RoomTypeService;
import cn.hotel.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@SuppressWarnings({ "unchecked", "rawtypes" })
public class BaseAction<T> extends ActionSupport {
    T bean;
    @Resource
    UserService userService;
    @Resource
    RoomService roomService;
    @Resource
    RoomTypeService roomTypeService;
    @Resource
    OrderFormService orderFormService;

    public T getBean() {
        if (bean == null) {
            try {
                Class cls = (Class) ((ParameterizedType) getClass()
                        .getGenericSuperclass()).getActualTypeArguments()[0];
                bean = (T) cls.newInstance();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return bean;
    }

    public void setBean(T bean) {
        this.bean = bean;
    }

}
