package com.littlebuddha.housekeeping.service.livebroadcast;

import com.littlebuddha.housekeeping.entity.livebroadcast.LiveBroadCastingRoom;
import com.littlebuddha.housekeeping.mapper.livebroadcast.LiveBroadCastingRoomMapper;
import com.littlebuddha.housekeeping.service.other.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 直播分类服务层
 * @author ck
 * @date 2020/7/27 10:55
 */
@Service
public class LiveBroadCastingRoomService extends BaseService<LiveBroadCastingRoom, LiveBroadCastingRoomMapper> {

    @Autowired
    private LiveBroadCastingRoomMapper liveBroadCastingRoomMapper;

    @Override
    public LiveBroadCastingRoom get(String id) {
        return super.get(id);
    }

    @Override
    public List<LiveBroadCastingRoom> findList(LiveBroadCastingRoom entity) {
        return super.findList(entity);
    }

    @Override
    public List<LiveBroadCastingRoom> findAllList(LiveBroadCastingRoom entity) {
        return super.findAllList(entity);
    }

    @Override
    public int save(LiveBroadCastingRoom entity) {
        return super.save(entity);
    }

    @Override
    public void deleteByLogic(LiveBroadCastingRoom entity) {
        super.deleteByLogic(entity);
    }

    public List<LiveBroadCastingRoom> getParentLiveBroadCastingRoom() {
        List<LiveBroadCastingRoom> parentLiveBroadCastingRoom= liveBroadCastingRoomMapper.getParentLiveBroadCastingRoom();
        return parentLiveBroadCastingRoom;
    }
}
