package org.imooc.controller.content;

import org.imooc.dto.AdDtoTwo;
import org.imooc.service.AdTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈威
 */
@Controller
@RequestMapping(value = "/ad")
public class AdTwoController {

    @Autowired
    private AdTwoService adTwoService;

    @RequestMapping(value = "/add")
    @ResponseBody
    public Map<String,Object> insertAd(AdDtoTwo adDtoTwo, ModelMap modelMap){
        Map map = new HashMap<>();
        boolean b = adTwoService.insertAd(adDtoTwo);
        if (b){
          map.put("code",1);
          map.put("msg","新增成功");
        }
        else{
            map.put("code",0);
            map.put("msg","新增失败");
        }
        return map;
    }

}
