package com.sm.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.sm.entity.Department;
import com.sm.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {
	
	private static Logger logger = Logger.getLogger(DepartmentController.class);

	@Autowired//这个注解就是spring可以自动帮你把bean里面引用的对象的setter/getter方法省略，它会自动帮你set/get。
	private DepartmentService departmentService;
	
	/**
	 * 查询所有部门
	 * @param map
	 * 
	 * @return
	 */
	@RequestMapping("/departmentList")
	public ModelAndView findAllDepartments(ModelAndView modelAndView) {
		modelAndView.setViewName("views/department/departmentList");//设置需要跳转到的页面
		List<Department> departmentList = departmentService.findAllDepartment();//查询所有部门
		modelAndView.addObject("departmentList", departmentList);//将查询出来的结果集(departmentList)返回到页面
		logger.info("departmentList=" + departmentList);
		return modelAndView;
	}
	/**
	 *跳转到部门新增页
	 * @param map
	 * @return
	 */
	@RequestMapping("/jumpSaveDepartment")
	public ModelAndView jumpSaveDepartment(){
		ModelAndView modelAndView = new ModelAndView("views/department/departmentSave");
		return modelAndView;
	}
	
	/**
	 * 新增部门
	 * @return
	 */
	@RequestMapping("/saveDepartment")
	public ModelAndView saveDepartment(Department department){
		ModelAndView andView = new ModelAndView();
		andView.setView(new RedirectView("departmentList"));
		departmentService.saveDepartment(department);
		return andView;
	}
	 
	/**
	 * 跳转到部门修改页
	 * @return
	 */
	@RequestMapping("jumpUpdateDepartment")
	public ModelAndView jumpUpdateDepartment(@RequestParam Integer toid){
		ModelAndView view = new ModelAndView();
		view.setViewName("views/department/departmentUpdate");
		Department department=departmentService.queryDepartmentById(toid);
		view.addObject("department", department);
		return view;
	}
	
	/**
	 * 部门修改页
	 * @return
	 */
    @RequestMapping(value="/updatedepartment", method = RequestMethod.POST)  
	public String updateDepartment(Department department){
		departmentService.updateDepartmentById(department);
		return "redirect:departmentList";
	}
	
	/**
	 * 删除部门
	 * @return
	 */
	
	@RequestMapping(value="deleteDepartment",method=RequestMethod.GET)
	public ModelAndView deleteDepartment(@RequestParam Integer toid){
		departmentService.deletDepartmentById(toid);
		return new ModelAndView("redirect:departmentList");
	}
	
}
