package com.atguigu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.entity.Dict;
import com.atguigu.result.Result;
import com.atguigu.service.DictService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

import java.util.List;

@Controller
@RequestMapping("/dict")
public class DictController extends BaseController {
    @Reference
    private DictService dictService;

    @RequestMapping()
    public String index() {
        return "dict/index";
    }

    @ResponseBody
    @RequestMapping("/findZnodes")
    public Result findZnodes(
            @RequestParam(value = "id", defaultValue = "0")
            Long id
    ) {
        List<Map<String, Object>> zNodes = dictService.findZnodes(id);
        return Result.ok(zNodes);
    }

    @ResponseBody
    @RequestMapping("/findListByParentId/{areaId}")
    public Result findListByParentId(
            @PathVariable("areaId") Long areaId
    ) {

        List<Dict> dictList = dictService.findListByParentId(areaId);
        return Result.ok(dictList);
    }
}
