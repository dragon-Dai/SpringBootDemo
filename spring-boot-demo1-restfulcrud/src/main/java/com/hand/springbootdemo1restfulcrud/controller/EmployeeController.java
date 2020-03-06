package com.hand.springbootdemo1restfulcrud.controller;

import com.hand.springbootdemo1restfulcrud.dao.DepartmentDao;
import com.hand.springbootdemo1restfulcrud.dao.EmployeeDao;
import com.hand.springbootdemo1restfulcrud.entity.Department;
import com.hand.springbootdemo1restfulcrud.entity.Employee;
import com.hand.springbootdemo1restfulcrud.service.DepartmenService;
import com.hand.springbootdemo1restfulcrud.service.EmployeeService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;

@Controller
public class EmployeeController {
//public class EmployeeController extends BaseController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    private final EmployeeService employeeService;
    private final DepartmenService departmenService;

    public EmployeeController(EmployeeService employeeService, DepartmenService departmenService) {
        this.employeeService = employeeService;
        this.departmenService = departmenService;
    }

    @GetMapping(value = "/emps")    //查询所有员工返回列表页面
    public String list(Model model) {
//        Collection<Employee> employees = employeeDao.getAll();
        Collection<Employee> employees = employeeService.selectAll();
        System.out.println(employees);
        //放在请求域中,进行共享
        model.addAttribute("employees", employees);
        return "emp/list";
    }

    /**
     * 来到员工添加页面
     *
     * @param model : 请求域
     * @return
     */
    @GetMapping(value = "/emp")
    public String toAddPage(Model model) {
        //页面显示所有的部门列表
//        Collection<Department> departments = departmentDao.getDepartments();
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/add";
    }

    //springMVC自动将请求参数和入参对象的属性绑定---对象的属性和请求参数名需要对应
    @PostMapping(value = "/emp")
    public String addEmp(Employee employee, Model model) {
        //保存员工
//        employeeDao.save(employee);
        System.out.println("添加员工："+employee);
        Integer add = employeeService.create(employee);
        if(add != null && add == 1){
            model.addAttribute("addEmpMessage", "添加成功");
            //redirct:(表示重定向到一个地址)  '/':代表当前项目路径
            //forward:(表示转发到一个地址)
            return "redirect:/emps";
        }
        model.addAttribute("addEmpMessage", "添加失败");
        return "redirect:/emps";
    }

    /**
     * 来到修改页面，查询出当前员工，在页面回写
     *
     * @param id    ： 路径参数（使用@PathVariable获取）
     * @param model : 请求域
     * @return 修改页面(添加页面)
     */
    @GetMapping(value = "/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeService.selectOneById(id);
        System.out.println("employee:"+employee);
        model.addAttribute("emp", employee);

        //页面显示所有的部门列表
//        Collection<Department> departments = departmentDao.getDepartments();
        Collection<Department> departments = departmenService.selectAll();

        System.out.println("departments:"+departments);
        model.addAttribute("departments", departments);

        return "emp/add";
    }

    /**
     * 修改员工
     *
     * @param employee 自动封装参数
     * @return
     */
    @PutMapping(value = "/emp")
//    @ResponseBody
    public String updateEmp(Employee employee) {
        System.out.println("更新："+employee);
//        employeeDao.save(employee);
        employeeService.update(employee);
        return "redirect:/emps";
//        return "修改成功";
    }

    /**
     * 员工删除
     *
     * @param id : 删除的员工id
     * @return
     */
    @DeleteMapping(value = "/emp/{id}")
//    @ResponseBody
    public String deleteEmp(@PathVariable("id") Integer id, Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("删除员工：id="+id);
        employeeDao.delete(id);
        Integer deleteRes = employeeService.deleteById(id);
//        if(deleteRes != null && deleteRes == 1){
//            model.addAttribute("message", "删除成功");
//            request.getRequestDispatcher("/emps").forward(request,response);
//            return "redirect:/emps";
//        }
//        model.addAttribute("message", "删除失败");
//        request.getRequestDispatcher("/emps").forward(request,response);
        return "redirect:/emps";
    }
}
