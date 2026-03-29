package com.zenmen.palmchat.groupchat;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.dating.bean.DatingGroupToolBeans;
import defpackage.ye2;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class GroupInfoItem implements ChatItem {
    public static final Parcelable.Creator<GroupInfoItem> CREATOR = new a();
    public static final int GROUP_EXTYPE_FAMILY = 2;
    public static final int GROUP_EXTYPE_NORMAL = 0;
    public static final int GROUP_EXTYPE_REDPACKET = 1;
    public static final int GROUP_TYPE_NORMAL = 0;
    public static final int GROUP_TYPE_SAVED = 1;
    public static final int PERM_ALL_MEMBER = 0;
    public static final int PERM_OWNER_AND_ADMIN = 1;
    private int accessSwitch;
    private int addFriendSwitch;
    private int addType;
    private int applyStatus;
    private int bizType;
    private String cardCode;
    private String cateName;
    private String categoryId;
    private String cover;
    private long createTimestamp;
    private String describe;
    private int diffuse;
    private String groupExInfo;
    private String groupHeadImgUrl;
    private String groupId;
    private String groupLocalName;
    private String groupName;
    private String groupOwner;
    private int groupState;
    private String groupTheme;
    private int groupType;
    private int inviteCheckSwitch;
    private int inviteSwitch;
    private int memberCount;
    private int merchantState;
    private int merchantType;
    private int permissionType;
    private String place;
    private int recmdSwitch;
    private String remarkName;
    private String rnumber;
    private int roleType;
    private int roomType;
    private int sessionConfig;
    private int showHisSwitch;
    private String[] tagNames;
    private String[] tags;
    private DatingGroupToolBeans tools;
    private String welContent;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Parcelable.Creator<GroupInfoItem> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public GroupInfoItem createFromParcel(Parcel parcel) {
            return new GroupInfoItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public GroupInfoItem[] newArray(int i) {
            return new GroupInfoItem[i];
        }
    }

    public GroupInfoItem() {
        this.roomType = 0;
        this.roleType = 3;
    }

    public static GroupInfoItem getItemFromCursor(Cursor cursor, ChatItem chatItem) {
        return getItemFromCursor(cursor, chatItem != null ? chatItem.getBizType() : 0);
    }

    public static GroupInfoItem parseFromNameCardString(String str) {
        GroupInfoItem groupInfoItem = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            GroupInfoItem groupInfoItem2 = new GroupInfoItem();
            try {
                JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("roomInfo");
                if (jSONObjectOptJSONObject != null) {
                    groupInfoItem2.groupId = jSONObjectOptJSONObject.getString("id");
                    groupInfoItem2.groupName = jSONObjectOptJSONObject.optString("name");
                    groupInfoItem2.groupHeadImgUrl = jSONObjectOptJSONObject.optString("headImgUrl");
                    groupInfoItem2.memberCount = jSONObjectOptJSONObject.optInt("memberCount");
                    if (TextUtils.isEmpty(groupInfoItem2.groupName)) {
                        groupInfoItem2.groupName = jSONObjectOptJSONObject.optString("defaultName");
                    }
                    groupInfoItem2.cardCode = jSONObjectOptJSONObject.optString("cardCode");
                    groupInfoItem2.describe = jSONObjectOptJSONObject.optString("describe");
                    groupInfoItem2.roomType = jSONObjectOptJSONObject.optInt("roomType");
                    groupInfoItem2.groupOwner = jSONObjectOptJSONObject.optString("owner", "");
                    groupInfoItem2.createTimestamp = jSONObjectOptJSONObject.optLong("createTimestamp", System.currentTimeMillis());
                    groupInfoItem2.place = jSONObjectOptJSONObject.optString("place", "");
                    groupInfoItem2.cover = jSONObjectOptJSONObject.optString("cover", "");
                }
                return groupInfoItem2;
            } catch (JSONException e) {
                e = e;
                groupInfoItem = groupInfoItem2;
                e.printStackTrace();
                return groupInfoItem;
            }
        } catch (JSONException e2) {
            e = e2;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAccessSwitch() {
        return this.accessSwitch;
    }

    public int getAddFriendSwitch() {
        return this.addFriendSwitch;
    }

    public int getAddType() {
        return this.addType;
    }

    public int getApplyStatus() {
        return this.applyStatus;
    }

    @Override // com.zenmen.palmchat.chat.ChatItem
    public int getBizType() {
        return this.bizType;
    }

    public String getCardCode() {
        return this.cardCode;
    }

    public String getCateForShow() {
        return this.cateName;
    }

    public String getCateName() {
        return this.cateName;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    @Override // com.zenmen.palmchat.chat.ChatItem
    public String getChatId() {
        return this.groupId;
    }

    @Override // com.zenmen.palmchat.chat.ChatItem
    public String getChatName() {
        return getNameForShow();
    }

    @Override // com.zenmen.palmchat.chat.ChatItem
    public int getChatType() {
        return 1;
    }

    public String getCover() {
        return this.cover;
    }

    public long getCreateTimestamp() {
        return this.createTimestamp;
    }

    public String getDescribe() {
        return "@#$%@WSX".equals(this.describe) ? "" : this.describe;
    }

    public int getDiffuse() {
        return this.diffuse;
    }

    public String getGroupExInfo() {
        return this.groupExInfo;
    }

    public int getGroupExtTypeFromExtension() {
        if (!TextUtils.isEmpty(this.groupExInfo)) {
            try {
                return new JSONObject(this.groupExInfo).optInt("extType");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public String getGroupHeadImgUrl() {
        return this.groupHeadImgUrl;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public String getGroupLocalName() {
        return this.groupLocalName;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String getGroupNameDisplay(String str) {
        return !TextUtils.isEmpty(this.groupName) ? AppContext.getContext().getString(R.string.request_group_display_name, this.groupName, str) : AppContext.getContext().getString(R.string.new_friend_request_message, str);
    }

    public String getGroupOwner() {
        return this.groupOwner;
    }

    public int getGroupState() {
        return this.groupState;
    }

    public String getGroupTheme() {
        return this.groupTheme;
    }

    public int getGroupType() {
        return this.groupType;
    }

    @Override // com.zenmen.palmchat.chat.ChatItem
    public String getIconURL() {
        return getGroupHeadImgUrl();
    }

    public int getInviteCheckSwitch() {
        return this.inviteCheckSwitch;
    }

    public int getInviteSwitch() {
        return this.inviteSwitch;
    }

    public int getMemberCount() {
        return this.memberCount;
    }

    public int getMerchantState() {
        return this.merchantState;
    }

    public int getMerchantType() {
        return this.merchantType;
    }

    public String getNameForShow() {
        return !TextUtils.isEmpty(this.groupName) ? this.groupName : this.groupLocalName;
    }

    public int getPermissionType() {
        return this.permissionType;
    }

    public String getPlace() {
        return this.place;
    }

    public int getRecmdSwitch() {
        return this.recmdSwitch;
    }

    public String getRemarkName() {
        return this.remarkName;
    }

    public String getRnumber() {
        return this.rnumber;
    }

    public int getRoleType() {
        return this.roleType;
    }

    public int getRoomType() {
        return this.roomType;
    }

    @Override // com.zenmen.palmchat.chat.ChatItem
    public int getSessionConfig() {
        return this.sessionConfig;
    }

    public int getShowHisSwitch() {
        return this.showHisSwitch;
    }

    public String[] getTagNames() {
        return this.tagNames;
    }

    public String[] getTags() {
        return this.tags;
    }

    public DatingGroupToolBeans getTools() {
        return this.tools;
    }

    public String getWelContent() {
        return this.welContent;
    }

    public void setAccessSwitch(int i) {
        this.accessSwitch = i;
    }

    public void setAddFriendSwitch(int i) {
        this.addFriendSwitch = i;
    }

    public void setAddType(int i) {
        this.addType = i;
    }

    public void setApplyStatus(int i) {
        this.applyStatus = i;
    }

    public void setBizType(int i) {
        this.bizType = i;
    }

    public void setCardCode(String str) {
        this.cardCode = str;
    }

    public void setCateName(String str) {
        this.cateName = str;
    }

    public void setCategoryId(String str) {
        this.categoryId = str;
    }

    public void setCover(String str) {
        this.cover = str;
    }

    public void setCreateTimestamp(long j) {
        this.createTimestamp = j;
    }

    public void setDescribe(String str) {
        this.describe = str;
    }

    public void setDiffuse(int i) {
        this.diffuse = i;
    }

    public void setGroupExInfo(String str) {
        this.groupExInfo = str;
    }

    public void setGroupHeadImgUrl(String str) {
        this.groupHeadImgUrl = str;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setGroupLocalName(String str) {
        this.groupLocalName = str;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setGroupOwner(String str) {
        this.groupOwner = str;
    }

    public void setGroupState(int i) {
        this.groupState = i;
    }

    public void setGroupTheme(String str) {
        this.groupTheme = str;
    }

    public void setGroupType(int i) {
        this.groupType = i;
    }

    public void setInviteCheckSwitch(int i) {
        this.inviteCheckSwitch = i;
    }

    public void setInviteSwitch(int i) {
        this.inviteSwitch = i;
    }

    public void setMemberCount(int i) {
        this.memberCount = i;
    }

    public void setMerchantState(int i) {
        this.merchantState = i;
    }

    public void setMerchantType(int i) {
        this.merchantType = i;
    }

    public void setPermissionType(int i) {
        this.permissionType = i;
    }

    public void setPlace(String str) {
        this.place = str;
    }

    public void setRecmdSwitch(int i) {
        this.recmdSwitch = i;
    }

    public void setRemarkName(String str) {
        this.remarkName = str;
    }

    public void setRnumber(String str) {
        this.rnumber = str;
    }

    public void setRoleType(int i) {
        this.roleType = i;
    }

    public void setRoomType(int i) {
        this.roomType = i;
    }

    public void setSessionConfig(int i) {
        this.sessionConfig = i;
    }

    public void setShowHisSwitch(int i) {
        this.showHisSwitch = i;
    }

    public void setTagNames(String[] strArr) {
        this.tagNames = strArr;
    }

    public void setTags(String[] strArr) {
        this.tags = strArr;
    }

    public void setTools(DatingGroupToolBeans datingGroupToolBeans) {
        this.tools = datingGroupToolBeans;
    }

    public void setWelContent(String str) {
        this.welContent = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.groupId);
        parcel.writeString(this.groupName);
        parcel.writeString(this.groupOwner);
        parcel.writeString(this.groupHeadImgUrl);
        parcel.writeString(this.groupLocalName);
        parcel.writeInt(this.groupType);
        parcel.writeInt(this.groupState);
        parcel.writeInt(this.sessionConfig);
        parcel.writeString(this.groupTheme);
        parcel.writeString(this.groupExInfo);
        parcel.writeInt(this.bizType);
        parcel.writeInt(this.memberCount);
        parcel.writeString(this.cardCode);
        parcel.writeInt(this.roomType);
        parcel.writeString(this.cover);
        parcel.writeString(this.place);
        parcel.writeString(this.describe);
        parcel.writeInt(this.diffuse);
        parcel.writeInt(this.recmdSwitch);
        parcel.writeInt(this.applyStatus);
        parcel.writeStringArray(this.tagNames);
        parcel.writeLong(this.createTimestamp);
        parcel.writeString(this.cateName);
        parcel.writeInt(this.roleType);
        parcel.writeInt(this.accessSwitch);
        parcel.writeString(this.rnumber);
        parcel.writeInt(this.addType);
        parcel.writeInt(this.inviteSwitch);
        parcel.writeInt(this.inviteCheckSwitch);
        parcel.writeString(this.remarkName);
        parcel.writeString(this.welContent);
        parcel.writeInt(this.showHisSwitch);
        parcel.writeInt(this.permissionType);
        parcel.writeInt(this.merchantType);
        parcel.writeInt(this.merchantState);
        parcel.writeInt(this.addFriendSwitch);
        parcel.writeStringArray(this.tags);
    }

    public static GroupInfoItem getItemFromCursor(Cursor cursor, int i) {
        if (cursor == null) {
            return null;
        }
        GroupInfoItem groupInfoItem = new GroupInfoItem();
        groupInfoItem.setGroupId(cursor.getString(cursor.getColumnIndex("group_id")));
        groupInfoItem.setGroupOwner(cursor.getString(cursor.getColumnIndex("owner")));
        groupInfoItem.setGroupName(cursor.getString(cursor.getColumnIndex("name")));
        groupInfoItem.setGroupHeadImgUrl(cursor.getString(cursor.getColumnIndex("headImgUrl")));
        groupInfoItem.setGroupType(cursor.getInt(cursor.getColumnIndex("type")));
        groupInfoItem.setGroupState(cursor.getInt(cursor.getColumnIndex("group_state")));
        groupInfoItem.setGroupLocalName(cursor.getString(cursor.getColumnIndex("local_name")));
        groupInfoItem.setMemberCount(cursor.getInt(cursor.getColumnIndex("group_member_count")));
        groupInfoItem.setSessionConfig(cursor.getInt(cursor.getColumnIndex("group_config")));
        groupInfoItem.setBizType(i);
        String string = cursor.getString(cursor.getColumnIndex("group_extra_info"));
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                groupInfoItem.setRoomType(jSONObject.optInt("roomType", 0));
                groupInfoItem.setCover(jSONObject.optString("cover", ""));
                groupInfoItem.setRecmdSwitch(jSONObject.optInt("recmdSwitch", 1));
                groupInfoItem.setAddFriendSwitch(jSONObject.optInt("addFriendSwitch", 1));
                groupInfoItem.setAccessSwitch(jSONObject.optInt("accessSwitch", 1));
                groupInfoItem.setDiffuse(jSONObject.optInt("diffuse", 0));
                groupInfoItem.setApplyStatus(jSONObject.optInt("applyStatus", 0));
                groupInfoItem.setRoleType(jSONObject.optInt("roleType", 3));
                groupInfoItem.setPlace(jSONObject.optString("place", ""));
                groupInfoItem.setRnumber(jSONObject.optString("rnumber", ""));
                groupInfoItem.setCateName(jSONObject.optString("cateName", ""));
                groupInfoItem.setDescribe(jSONObject.optString("describe", ""));
                groupInfoItem.setRemarkName(jSONObject.optString("remarkName", ""));
                groupInfoItem.setAddType(jSONObject.optInt("addType", ye2.f22183a));
                groupInfoItem.setInviteSwitch(jSONObject.optInt("inviteSwitch", ye2.b));
                groupInfoItem.setInviteCheckSwitch(jSONObject.optInt("inviteCheckSwitch", ye2.c));
                groupInfoItem.setPermissionType(jSONObject.optInt("permissionType", 0));
                groupInfoItem.setMerchantType(jSONObject.optInt("merchantType", 0));
                groupInfoItem.setMerchantState(jSONObject.optInt("merchantState", 0));
                groupInfoItem.setWelContent(jSONObject.optString(" welContent", ""));
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("tagNames");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    String[] strArr = new String[jSONArrayOptJSONArray.length()];
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        strArr[i2] = jSONArrayOptJSONArray.optString(i2);
                    }
                    groupInfoItem.setTagNames(strArr);
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("tags");
                if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                    String[] strArr2 = new String[jSONArrayOptJSONArray2.length()];
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                        JSONObject jSONObject2 = jSONArrayOptJSONArray2.getJSONObject(i3);
                        if (jSONObject2 != null && jSONObject2.has("tagName")) {
                            strArr2[i3] = jSONObject2.optString("tagName");
                        } else {
                            strArr2[i3] = "";
                        }
                    }
                    groupInfoItem.setTags(strArr2);
                }
                groupInfoItem.setCreateTimestamp(jSONObject.optLong("createTimestamp", 0L));
                groupInfoItem.setShowHisSwitch(jSONObject.optInt("showHisSwitch", 1));
                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("tools");
                if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                    DatingGroupToolBeans datingGroupToolBeans = new DatingGroupToolBeans();
                    for (int i4 = 0; i4 < jSONArrayOptJSONArray3.length(); i4++) {
                        JSONObject jSONObject3 = jSONArrayOptJSONArray3.getJSONObject(i4);
                        DatingGroupToolBeans.DatingGroupToolBean datingGroupToolBean = new DatingGroupToolBeans.DatingGroupToolBean();
                        String strOptString = jSONObject3.optString("id");
                        String strOptString2 = jSONObject3.optString("toolName");
                        String strOptString3 = jSONObject3.optString("icon");
                        String strOptString4 = jSONObject3.optString("toolPage");
                        int iOptInt = jSONObject3.optInt("isSystem", 0);
                        int iOptInt2 = jSONObject3.optInt("systemToolClass", 0);
                        datingGroupToolBean.setId(strOptString);
                        datingGroupToolBean.setToolName(strOptString2);
                        datingGroupToolBean.setIcon(strOptString3);
                        datingGroupToolBean.setToolPage(strOptString4);
                        datingGroupToolBean.setIsSystem(iOptInt);
                        datingGroupToolBean.setSystemToolClass(iOptInt2);
                        datingGroupToolBeans.addToolsBean(datingGroupToolBean);
                    }
                    groupInfoItem.setTools(datingGroupToolBeans);
                }
            } catch (Exception unused) {
            }
        }
        groupInfoItem.setGroupExInfo(string);
        groupInfoItem.setGroupTheme(cursor.getString(cursor.getColumnIndex("group_categoryId")));
        return groupInfoItem;
    }

    public GroupInfoItem(Parcel parcel) {
        this.roomType = 0;
        this.roleType = 3;
        this.groupId = parcel.readString();
        this.groupName = parcel.readString();
        this.groupOwner = parcel.readString();
        this.groupHeadImgUrl = parcel.readString();
        this.groupLocalName = parcel.readString();
        this.groupType = parcel.readInt();
        this.groupState = parcel.readInt();
        this.sessionConfig = parcel.readInt();
        this.groupTheme = parcel.readString();
        this.groupExInfo = parcel.readString();
        this.bizType = parcel.readInt();
        this.memberCount = parcel.readInt();
        this.cardCode = parcel.readString();
        this.roomType = parcel.readInt();
        this.cover = parcel.readString();
        this.place = parcel.readString();
        this.describe = parcel.readString();
        this.diffuse = parcel.readInt();
        this.recmdSwitch = parcel.readInt();
        this.applyStatus = parcel.readInt();
        this.tagNames = parcel.createStringArray();
        this.createTimestamp = parcel.readLong();
        this.cateName = parcel.readString();
        this.roleType = parcel.readInt();
        this.accessSwitch = parcel.readInt();
        this.rnumber = parcel.readString();
        this.addType = parcel.readInt();
        this.inviteSwitch = parcel.readInt();
        this.inviteCheckSwitch = parcel.readInt();
        this.remarkName = parcel.readString();
        this.welContent = parcel.readString();
        this.showHisSwitch = parcel.readInt();
        this.permissionType = parcel.readInt();
        this.merchantType = parcel.readInt();
        this.merchantState = parcel.readInt();
        this.addFriendSwitch = parcel.readInt();
        this.tags = parcel.createStringArray();
    }
}
