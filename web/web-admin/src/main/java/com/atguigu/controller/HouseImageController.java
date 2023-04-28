package com.atguigu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.entity.HouseImage;
import com.atguigu.result.Result;
import com.atguigu.service.HouseImageService;
import com.atguigu.service.HouseService;
import com.atguigu.util.QiniuUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/houseImage")
public class HouseImageController {
    @Reference
    private HouseImageService houseImageService;

    @GetMapping("/uploadShow/{houseId}/{type}")
    public String UploadPage(Map map, @PathVariable("houseId") Long houseId, @PathVariable("type") Integer type) {
        map.put("houseId", houseId);
        map.put("type", type);
        return "house/upload";
    }

    @ResponseBody
    @PostMapping("/upload/{houseId}/{type}")
    public Result Upload(@PathVariable("houseId") Long houseId, @PathVariable("type") Integer type, @RequestParam("file") MultipartFile[] files) throws IOException {

        if (files != null) {
            for (MultipartFile file : files) {
                byte[] bytes = file.getBytes();
                String originalFilename = file.getOriginalFilename();
                String newFilename = UUID.randomUUID().toString() + originalFilename;
                QiniuUtils.upload2Qiniu(bytes, newFilename);
                HouseImage houseImage = new HouseImage();
                houseImage.setHouseId(houseId);
                houseImage.setType(type);
                houseImage.setImageName(newFilename);
                houseImage.setImageUrl("http://rtnppjdqy.hn-bkt.clouddn.com/" + newFilename);
                houseImageService.insert(houseImage);
            }
        }
        return Result.ok();
    }

    @RequestMapping("/delete/{houseId}/{id}")
    public String Delete(@PathVariable("houseId") Long houseId, @PathVariable("id") Long id) {
        houseImageService.delete(id);
        return "redirect:/house/" + houseId;
    }
}
