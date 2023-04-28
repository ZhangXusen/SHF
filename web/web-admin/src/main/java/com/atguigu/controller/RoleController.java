package com.atguigu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.entity.Role;
import com.atguigu.service.PermissionService;
import com.atguigu.service.RoleService;

import java.util.Enumeration;
import java.util.List;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.TreeMap;


@Controller
@RequestMapping(value = "/role")
public class RoleController extends BaseController {
    @Reference
    private RoleService roleService;
    @Reference
    private PermissionService permissionService;

    private final static String PAGE_INDEX = "role/index";

    /*普通首页*/
    /*@RequestMapping()
    public String index(Map map) {
        List<Role> RoleList = roleService.findAll();
        map.put("list", RoleList);
        System.out.println("111");
        return PAGE_INDEX;
    }*/
    /*带分页的首页*/
    @RequestMapping()
    public String index(Map map, HttpServletRequest req) {
        Map<String, Object> filters = getFilters(req);
        map.put("filters", filters);
        PageInfo<Role> pageInfo = roleService.findPage(filters);
        map.put("page", pageInfo);
        return "role/index";
    }

    /**
     * 封装页面提交的分页参数及搜索条件
     *
     * @param request
     * @return
     */
    protected Map<String, Object> getFilters(HttpServletRequest request) {
        Enumeration<String> paramNames = request.getParameterNames();
        Map<String, Object> filters = new TreeMap();
        while (paramNames != null && paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();
            String[] values = request.getParameterValues(paramName);
            if (values != null && values.length != 0) {
                if (values.length > 1) {
                    filters.put(paramName, values);
                } else {
                    filters.put(paramName, values[0]);
                }
            }
        }
        if (!filters.containsKey("pageNum")) {
            filters.put("pageNum", 1);
        }
        if (!filters.containsKey("pageSize")) {
            filters.put("pageSize", 3);
        }

        return filters;
    }

    @GetMapping("/create")
    public String create() {
        return "role/create";
    }

    @PostMapping("/save")
    public String insert(Role role, HttpServletRequest req) {
        roleService.insert(role);
        return "common/successPage";
    }

    @PreAuthorize("hasAuthority('Delete')")
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        roleService.delete(id);
        return "redirect:role";
    }

    @RequestMapping("/edit/{id}")
    public String goEdit(@PathVariable Long id, ModelMap map) {
        Role role = roleService.getById(id);
        map.put("role", role);
        return "role/edit";
    }

    @RequestMapping("/update")
    public String update(Role role) {
        roleService.update(role);
        return "common/successPage";
    }

    @RequestMapping("/assignShow/{id}")
    public String GoAssign(@PathVariable("id") Long id, ModelMap modelMap) {
        modelMap.addAttribute("roleId", id);
        List<Map<String, Object>> zNodes = permissionService.findPerByRoleId(id);
        modelMap.addAttribute("zNodes", zNodes);
        return "role/assignShow";
    }

    @RequestMapping("/assignPermission")
    public String assignPer(@RequestParam("roleId") Long roleId, @RequestParam("permissionIds") Long[] permissionIds) {

        permissionService.assignPer(roleId, permissionIds);
        return "common/successPage";
    }
}
