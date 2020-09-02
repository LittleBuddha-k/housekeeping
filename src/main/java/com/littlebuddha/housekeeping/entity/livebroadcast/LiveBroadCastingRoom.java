package com.littlebuddha.housekeeping.entity.livebroadcast;

import com.littlebuddha.housekeeping.entity.other.DataEntity;

/**
 * 直播分类实体
 * @author ck
 * @date 2020/7/27 10:04
 */
public class LiveBroadCastingRoom extends DataEntity<LiveBroadCastingRoom> {

    private String roomName;
    private String liveTypeName;//直播类型名称
    private String code;//编码
    private String hasChildren;//是否有子节
    private String parentCode;//父级编码
    private String parentCodes;//所有父级编码

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getLiveTypeName() {
        return liveTypeName;
    }

    public void setLiveTypeName(String liveTypeName) {
        this.liveTypeName = liveTypeName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(String hasChildren) {
        this.hasChildren = hasChildren;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getParentCodes() {
        return parentCodes;
    }

    public void setParentCodes(String parentCodes) {
        this.parentCodes = parentCodes;
    }
}
