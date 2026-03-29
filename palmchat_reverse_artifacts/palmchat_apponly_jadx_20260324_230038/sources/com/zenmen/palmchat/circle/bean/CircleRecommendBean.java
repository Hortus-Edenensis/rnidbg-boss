package com.zenmen.palmchat.circle.bean;

import androidx.annotation.Keep;
import com.zenmen.palmchat.circle.bridge.http.Response;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class CircleRecommendBean<T> extends Response<T> {
    public List<T> data;
    public String errorMsg;
    public int pageNo;
    public int pageSize;
    public int resultCode;
    public int totalSize;

    /* JADX INFO: compiled from: SearchBox */
    public static class CircleRecommendItem {
        public int activate;
        public int addType;
        public int applyStatus;
        public long category;
        public String cover;
        public long createTimestamp;
        public String describe;
        public int diffuse;
        public String headImgUrl;
        public long id;
        public int memberLimit;
        public int memberNum;
        public String name;
        public long nearby;
        public int openStatus;
        public long owner;
        public String place;
        public List<String> roomTags;
        public int roomType;
        public int status;
        public int type;
        public long updateTimestamp;
        public int version;

        public GroupInfoItem copyForGroupInfoItem() {
            GroupInfoItem groupInfoItem = new GroupInfoItem();
            groupInfoItem.setGroupId(String.valueOf(this.id));
            groupInfoItem.setGroupName(this.name);
            groupInfoItem.setGroupHeadImgUrl(this.headImgUrl);
            groupInfoItem.setDescribe(this.describe);
            groupInfoItem.setMemberCount(this.memberNum);
            groupInfoItem.setGroupOwner(String.valueOf(this.owner));
            groupInfoItem.setCreateTimestamp(this.createTimestamp);
            groupInfoItem.setPlace(this.place);
            groupInfoItem.setCover(this.cover);
            groupInfoItem.setRoomType(this.roomType);
            return groupInfoItem;
        }
    }

    @Override // com.zenmen.palmchat.circle.bridge.http.Response
    public T getData() {
        return null;
    }

    @Override // com.zenmen.palmchat.circle.bridge.http.Response
    public String getErrorMsg() {
        return this.errorMsg;
    }

    @Override // com.zenmen.palmchat.circle.bridge.http.Response
    public int getResultCode() {
        return this.resultCode;
    }

    @Override // com.zenmen.palmchat.circle.bridge.http.Response
    public void setData(T t) {
    }

    @Override // com.zenmen.palmchat.circle.bridge.http.Response
    public void setErrorMsg(String str) {
    }

    @Override // com.zenmen.palmchat.circle.bridge.http.Response
    public void setResultCode(int i) {
    }
}
