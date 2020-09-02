package com.littlebuddha.housekeeping.mapper.livebroadcast;

import com.littlebuddha.housekeeping.entity.livebroadcast.LiveBroadCastingRoom;
import com.littlebuddha.housekeeping.mapper.other.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LiveBroadCastingRoomMapper extends BaseMapper<LiveBroadCastingRoom> {

    List<LiveBroadCastingRoom> findByCode(@Param(value = "code")String code);

    List<LiveBroadCastingRoom> getParentLiveBroadCastingRoom();
}
