package com.littlebuddha.housekeeping.controller.livebroadcast;

import com.littlebuddha.housekeeping.common.result.AjaxResult;
import com.littlebuddha.housekeeping.entity.livebroadcast.Anchor;
import com.littlebuddha.housekeeping.service.livebroadcast.AnchorService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ck
 * @date 2020/7/15 17:21
 */
@Controller
@RequestMapping("/liveBroadCast/anchor")
public class AnchorController {

    @Autowired
    private AnchorService anchorService;

    @ModelAttribute
    public Anchor get(@RequestParam(required = false)String id){
        Anchor anchor = null;
        if (StringUtils.isNotBlank(id)){
            anchor = anchorService.get(id);
        }
        if (anchor == null){
            anchor = new Anchor();
        }
        return anchor;
    }

    @RequestMapping("/list")
    public String list(Anchor anchor, Model model){
        model.addAttribute("anchor",anchor);
        return "livebroadcast/anchorList";
    }

    @ResponseBody
    @RequestMapping("/data")
    public List<Anchor> data(Anchor anchor, Model model){
        List<Anchor> list = anchorService.findList(anchor);
        return list;
    }

    @RequestMapping("/form/{mode}")
    public String form(@PathVariable(name = "mode")String mode, Anchor anchor, Model model){
        model.addAttribute("anchor",anchor);
        model.addAttribute("mode",mode);
        return "livebroadcast/anchorForm";
    }

    @ResponseBody
    @RequestMapping("/save")
    public AjaxResult save(Anchor anchor){
        AjaxResult ajaxResult = new AjaxResult();
        int row = anchorService.save(anchor);
        if(row == 1) {
            ajaxResult.setStatus(200);
            ajaxResult.setMessage("操作成功！！！");
        }else {
            ajaxResult.setStatus(500);
            ajaxResult.setMessage("操作失败！！！");
        }
        return ajaxResult;
    }

    /**
     * 这只是一个逻辑删除
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteAll")
    public AjaxResult deleteAll(String ids) {
        AjaxResult ajaxResult = new AjaxResult();
        String idArray[] =ids.split(",");
        for(String id : idArray){
            anchorService.deleteByLogic(anchorService.get(id));
        }
        ajaxResult.setStatus(200);
        ajaxResult.setMessage("删除操作用户信息成功");
        return ajaxResult;
    }

    public AjaxResult dataExport(Anchor housekeeper){
        return null;
    }
}
