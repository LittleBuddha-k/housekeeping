package com.littlebuddha.housekeeping.service.livebroadcast;

import com.littlebuddha.housekeeping.entity.livebroadcast.Anchor;
import com.littlebuddha.housekeeping.entity.livebroadcast.LiveBroadCastingRoom;
import com.littlebuddha.housekeeping.mapper.livebroadcast.AnchorMapper;
import com.littlebuddha.housekeeping.mapper.livebroadcast.LiveBroadCastingRoomMapper;
import com.littlebuddha.housekeeping.service.other.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnchorService extends BaseService<Anchor,AnchorMapper> {
    @Autowired
    private LiveBroadCastingRoomMapper liveBroadCastTypeMapper;

    @Override
    public List<Anchor> findList(Anchor entity) {
        List<Anchor> anchorList = super.findList(entity);
        List<LiveBroadCastingRoom> liveBroadCastingRoomList = liveBroadCastTypeMapper.findList(new LiveBroadCastingRoom());
        for (Anchor anchor : anchorList) {
            for (LiveBroadCastingRoom liveBroadCastingRoom : liveBroadCastingRoomList) {
                if(anchor.getLiveBroadCastingRoom().getId().equals(liveBroadCastingRoom.getId())){
                    anchor.setLiveBroadCastingRoom(liveBroadCastingRoom);
                }
            }
        }
        return anchorList;
    }
}
