package cn.ming.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.ming.bean.User;
import cn.ming.service.TestService;

@Controller
public class TestController {
    @Resource
    private TestService service;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("acc.");
    }

    @ResponseBody
    @RequestMapping("/all")
    public String getAll() {
        List<User> listAll = service.getAll();
        System.out.println(listAll.toString());
        return listAll.toString();
    }

    @RequestMapping("/del/{id}")
    public String delUser(@PathVariable("id") Integer userId) {
        service.delUser(userId);
        return "redirect:all";
    }

    @RequestMapping("/update")
    public String updateUser(User user) {
        service.updateUser(user);
        return "redirect:all";
    }

    @ResponseBody
    @RequestMapping("/getById/{userId}")
    public String getById(@PathVariable("userId") Integer id) {
        User user = service.getById(id);
        return user.toString();
    }

    @RequestMapping("/save")
    public String saveUser(User user) {
        service.saveUser(user);
        return "redirect:all";
    }

    @RequestMapping("/welcome")
    public ModelAndView welcome() {
        System.out.println("vm............................................");
        User model = new User();
        model.setPassword("xwtec111");
        model.setUsername("xwtec");
        return new ModelAndView("welcome", "user", model);
    }

    @RequestMapping("/demo")
    public void demo() {}
}
