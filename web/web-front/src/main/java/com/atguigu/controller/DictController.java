package com.atguigu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.entity.Dict;
import com.atguigu.result.Result;
import com.atguigu.service.DictService;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dict")
public class DictController extends BaseController {
    @Reference
    private DictService dictService;

    @GetMapping("/findListByDictCode/{dictCode}")
    public Result findListByDictCode(@PathVariable("dictCode") String dictCode) {
        List<Dict> dictByCode = dictService.getDictByCode(dictCode);

        return Result.ok(dictByCode);
    }

    @GetMapping("findListByParentId/{areaId}")
    public Result findListByParId(@PathVariable("areaId") Long areaID) {

        System.out.println("11111111111");
        List<Dict> dictList = dictService.findListByParentId(areaID);
        return Result.ok(dictList);
    }

}
