package com.atguigu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.entity.Community;
import com.atguigu.entity.Dict;
import com.atguigu.service.CommunityService;
import com.atguigu.service.DictService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/community")
public class CommunityController extends BaseController {
    @Reference
    private CommunityService communityService;

    @Reference
    private DictService dictService;

    @RequestMapping()
    public String index(Map map, HttpServletRequest req) {
        Map<String, Object> filter = getFilters(req);
        map.put("filters", filter);
        PageInfo<Community> page = communityService.findPage(filter);
        map.put("page", page);
        List<Dict> areaList = dictService.getDictByCode("beijing");
        map.put("areaList", areaList);
        return "community/index";
    }


    @GetMapping("/create")
    public String toCreate(Map map) {
        List<Dict> areaList = dictService.getDictByCode("beijing");
        map.put("areaList", areaList);
        return "community/create";
    }

    //保存
    @PostMapping("/save")
    public String Save(Community community) {
        communityService.insert(community);
        return "common/successPage";
    }

    //修改
    @RequestMapping("/edit/{id}")
    public String Update(
            @PathVariable("id") Long id,
            Map map
    ) {
        List<Dict> dict = dictService.getDictByCode("beijing");
        map.put("areaList", dict);
        Community community = communityService.getById(id);
        map.put("community", community);
        return "community/edit";
    }

    @PostMapping(value = "/update")
    public String update(Community community) {

        communityService.update(community);

        return "common/successPage";
    }

    //删除
    @RequestMapping("/delete/{id}")
    public String Delete(
            @PathVariable("id") Long id
    ) {
        communityService.delete(id);
        return "redirect:/community";
    }
}
