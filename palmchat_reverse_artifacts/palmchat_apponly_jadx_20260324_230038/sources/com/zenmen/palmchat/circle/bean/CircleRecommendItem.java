package com.zenmen.palmchat.circle.bean;

import androidx.annotation.Keep;
import com.zenmen.palmchat.circle.label.bean.RoomTag;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class CircleRecommendItem {
    public int activate;
    public int addType;
    public int applyStatus;
    public String cateName;
    public long category;
    public int checkTotalNum;
    public String cover;
    public long createTimestamp;
    public String describe;
    public int diffuse;
    public String displayDistance;
    public int hasJoined;
    public String headImgUrl;
    public long id;
    public int memberLimit;
    public int memberNum;
    public List<Object> members;
    public String name;
    public long nearby;
    public int openStatus;
    public long owner;
    public String place;
    public String rnumber;
    public List<String> roomTags;
    public int roomType;
    public int status;
    public List<RoomTag> tagList;
    public int type;
    public long updateTimestamp;
    public int version;

    public GroupInfoItem copyForGroupInfoItem() {
        GroupInfoItem groupInfoItem = new GroupInfoItem();
        groupInfoItem.setGroupId(String.valueOf(this.id));
        groupInfoItem.setGroupName(this.name);
        groupInfoItem.setGroupHeadImgUrl(this.headImgUrl);
        groupInfoItem.setDescribe(this.describe);
        List<Object> list = this.members;
        if (list == null || list.isEmpty()) {
            groupInfoItem.setMemberCount(this.memberNum);
        } else {
            groupInfoItem.setMemberCount(this.members.size());
        }
        groupInfoItem.setGroupOwner(String.valueOf(this.owner));
        groupInfoItem.setCreateTimestamp(this.createTimestamp);
        groupInfoItem.setPlace(this.place);
        groupInfoItem.setCover(this.cover);
        groupInfoItem.setRoomType(this.roomType);
        groupInfoItem.setAddType(this.addType);
        groupInfoItem.setRnumber(this.rnumber);
        groupInfoItem.setCateName(this.cateName);
        List<RoomTag> list2 = this.tagList;
        if (list2 != null && !list2.isEmpty()) {
            String[] strArr = new String[this.tagList.size()];
            for (int i = 0; i < this.tagList.size(); i++) {
                strArr[i] = this.tagList.get(i).tagName;
            }
            groupInfoItem.setTags(strArr);
        }
        return groupInfoItem;
    }
}
