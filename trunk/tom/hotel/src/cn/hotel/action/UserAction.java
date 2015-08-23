package cn.hotel.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import cn.hotel.bean.User;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Namespace("/")
public class UserAction extends BaseAction<User> {
    @Actions({
            @Action(value = "login@UserAction", results = { @Result(name = "success", location = "/main.jsp") }),
            @Action(value = "/", results = { @Result(name = "success", location = "/main.jsp") }) })
    public String login() {
        try {
            User user = userService.login(bean.getUsername(), bean.getPassword());
            if (user == null) {

            } else {
                ActionContext.getContext().getSession().put("user", user);
            }
        } catch (Exception e) {
        }
        return SUCCESS;
    }

    @Action(value = "manage@UserAction", results = { @Result(name = "success", location = "/UserManage.jsp") })
    public String manage() {
        List<User> userList = userService.getAllUser();
        ActionContext.getContext().put("userList", userList);
        return SUCCESS;
    }

    @Action(value = "add@UserAction", results = { @Result(name = "success", type = "redirect", location = "/manage@UserAction") })
    public String add() {
        userService.setBean(getBean());
        userService.add();
        return SUCCESS;
    }

    @Action(value = "delete@UserAction", results = { @Result(name = "success", type = "redirect", location = "/manage@UserAction") })
    public String delete() {
        userService.setBean(getBean());
        userService.delete();
        return SUCCESS;
    }

    private String username;
    private String oldpassword;
    private String newpassword;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setOldpassword(String oldpassword) {
        this.oldpassword = oldpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    @Action(value = "changePassword@UserAction", results = { @Result(name = "success", location = "/ChangePassword.jsp") })
    public String changePassword() {
        Boolean result = userService.chagePassword(username, oldpassword, newpassword);
        ActionContext.getContext().put("info", "更新失败！");
        if (result) {
            ActionContext.getContext().put("info", "更新成功！");
        }
        return SUCCESS;
    }
}
