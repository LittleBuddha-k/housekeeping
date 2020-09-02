package com.littlebuddha.housekeeping.controller.livebroadcast;

import com.littlebuddha.housekeeping.common.result.AjaxResult;
import com.littlebuddha.housekeeping.entity.livebroadcast.Anchor;
import com.littlebuddha.housekeeping.entity.livebroadcast.LiveBroadCastingRoom;
import com.littlebuddha.housekeeping.service.livebroadcast.LiveBroadCastingRoomService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 直播分类控制器类
 * @author ck
 * @date 2020/7/27 11:09
 */
@Controller
@RequestMapping("/liveBroadCast/liveBroadCastingRoom")
public class LiveBroadCastingRoomController {

    @Autowired
    private LiveBroadCastingRoomService liveBroadCastTypeService;

    @ModelAttribute
    public LiveBroadCastingRoom get(@RequestParam(required = false)String id){
        LiveBroadCastingRoom liveBroadCastType = null;
        if (StringUtils.isNotBlank(id)){
            liveBroadCastType = liveBroadCastTypeService.get(id);
        }
        if (liveBroadCastType == null){
            liveBroadCastType = new LiveBroadCastingRoom();
        }
        return liveBroadCastType;
    }

    @RequiresPermissions("housekeeping:liveBroadCastType:list")
    @RequestMapping("/list")
    public String list(LiveBroadCastingRoom liveBroadCastType, Model model){
        model.addAttribute("liveBroadCastType",liveBroadCastType);
        return "livebroadcast/liveBroadCastingRoomList";
    }

    @ResponseBody
    @RequestMapping("/data")
    public List<LiveBroadCastingRoom> data(LiveBroadCastingRoom liveBroadCastType, Model model){
        List<LiveBroadCastingRoom> list = liveBroadCastTypeService.findList(liveBroadCastType);
        return list;
    }

    @RequestMapping("/form/{mode}")
    public String form(@PathVariable(name = "mode")String mode, LiveBroadCastingRoom liveBroadCastType, Model model){
        model.addAttribute("liveBroadCastType",liveBroadCastType);
        model.addAttribute("mode",mode);
        return "livebroadcast/liveBroadCastingRoomForm";
    }

    @RequestMapping("/roomInfo")
    public String liveBroadcastingRoom(Anchor anchor, Model model){
        return "livebroadcast/liveBroadCastingRoomInfo";
    }

    @ResponseBody
    @RequestMapping("/save")
    public AjaxResult save(LiveBroadCastingRoom liveBroadCastType){
        AjaxResult ajaxResult = new AjaxResult();
        int row = liveBroadCastTypeService.save(liveBroadCastType);
        if(row == 1) {
            ajaxResult.setStatus(200);
            ajaxResult.setMessage("操作成功！！！");
        }else {
            ajaxResult.setStatus(500);
            ajaxResult.setMessage("操作失败！！！");
        }
        return ajaxResult;
    }

    @ResponseBody
    @RequestMapping("/delete")
    public void delete(){

    }
}
