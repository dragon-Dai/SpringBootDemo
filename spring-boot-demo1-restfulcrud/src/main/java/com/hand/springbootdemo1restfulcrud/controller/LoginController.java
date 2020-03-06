package com.hand.springbootdemo1restfulcrud.controller;

import com.hand.springbootdemo1restfulcrud.entity.Employee;
import com.hand.springbootdemo1restfulcrud.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    private final EmployeeService employeeService;

    public LoginController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(value = "/user/login")
//    @RequestMapping(value =  "user/login" , method= RequestMethod.POST )
    public String login(@RequestParam("username") String username,     //@RequestParam注解的参数没有提交会报错
                        @RequestParam("password") String password,
                        Map<String, Object> error, HttpSession session) {
        System.out.println(username + "," + password);
        if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)) {
            Employee employee = new Employee();
            employee.setUsername(username);
            employee.setPassword(password);
            List<Employee> employees = employeeService.login(employee);
            System.out.println(employees);
            if(employees != null && employees.size()==1){
                session.setAttribute("user", username);
                //登陆成功
                //防止表单重复提交：使用重定向
                return "redirect:/main.html";
            }else{
                error.put("message", "用户名或密码错误");
                return "login";
            }
        } else {
            error.put("message", "用户名或密码不能为空");
            return "login";
        }
    }

    @GetMapping(value = "/user/logout")
    public String logout(HttpSession session ){
        session.removeAttribute("user");
        return "redirect:/index.html";
    }
}
