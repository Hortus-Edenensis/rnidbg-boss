package com.zenmen.palmchat.groupchat;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.umeng.analytics.pro.bt;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.contacts.bean.ContactExtBean;
import defpackage.az2;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class GroupMemberInfoItem implements ChatItem, Parcelable {
    public static final Parcelable.Creator<GroupMemberInfoItem> CREATOR = new a();
    private String account;
    private String allPinyin;
    private String displayName;
    private String exId;
    private ContactExtBean ext;
    private String firstPinyin;
    private String groupId;
    private String iconURL;
    private int isOwner;
    private int muteStatus;
    private String nickName;
    private String remarkAllPinyin;
    private String remarkFirstPinyin;
    private String remarkName;
    private int roleType = 3;
    private String roomRemark;
    private int state;
    private String uid;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Parcelable.Creator<GroupMemberInfoItem> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public GroupMemberInfoItem createFromParcel(Parcel parcel) {
            GroupMemberInfoItem groupMemberInfoItem = new GroupMemberInfoItem();
            groupMemberInfoItem.setGroupId(parcel.readString());
            groupMemberInfoItem.setUid(parcel.readString());
            groupMemberInfoItem.setExId(parcel.readString());
            groupMemberInfoItem.setNickName(parcel.readString());
            groupMemberInfoItem.setAllPinyin(parcel.readString());
            groupMemberInfoItem.setFirstPinyin(parcel.readString());
            groupMemberInfoItem.setRemarkName(parcel.readString());
            groupMemberInfoItem.setRemarkAllPinyin(parcel.readString());
            groupMemberInfoItem.setRemarkFirstPinyin(parcel.readString());
            groupMemberInfoItem.setDisplayName(parcel.readString());
            groupMemberInfoItem.setIconURL(parcel.readString());
            groupMemberInfoItem.setIsOwner(parcel.readInt());
            groupMemberInfoItem.setState(parcel.readInt());
            groupMemberInfoItem.setAccount(parcel.readString());
            groupMemberInfoItem.setRoleType(parcel.readInt());
            groupMemberInfoItem.setMuteStatus(parcel.readInt());
            groupMemberInfoItem.setRoomRemark(parcel.readString());
            groupMemberInfoItem.setExt((ContactExtBean) parcel.readParcelable(ContactExtBean.class.getClassLoader()));
            return groupMemberInfoItem;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public GroupMemberInfoItem[] newArray(int i) {
            return new GroupMemberInfoItem[i];
        }
    }

    public static GroupMemberInfoItem buildFromCursor(Cursor cursor) {
        GroupMemberInfoItem groupMemberInfoItem = new GroupMemberInfoItem();
        if (cursor != null) {
            groupMemberInfoItem.groupId = cursor.getString(cursor.getColumnIndex("group_id"));
            groupMemberInfoItem.uid = cursor.getString(cursor.getColumnIndex("name"));
            groupMemberInfoItem.exId = cursor.getString(cursor.getColumnIndex("extra_data2"));
            groupMemberInfoItem.nickName = cursor.getString(cursor.getColumnIndex("nick_name"));
            groupMemberInfoItem.displayName = cursor.getString(cursor.getColumnIndex(bt.s));
            groupMemberInfoItem.remarkName = cursor.getString(cursor.getColumnIndex("remark_name"));
            groupMemberInfoItem.iconURL = cursor.getString(cursor.getColumnIndex("head_icon_url"));
            groupMemberInfoItem.isOwner = cursor.getInt(cursor.getColumnIndex("is_owner"));
            groupMemberInfoItem.state = cursor.getInt(cursor.getColumnIndex("group_member_state"));
            groupMemberInfoItem.setAllPinyin(cursor.getString(cursor.getColumnIndex("nick_name_all_pinyin")));
            groupMemberInfoItem.setFirstPinyin(cursor.getString(cursor.getColumnIndex("nick_name_first_pinyin")));
            groupMemberInfoItem.setRemarkName(cursor.getString(cursor.getColumnIndex("remark_name")));
            groupMemberInfoItem.setRemarkAllPinyin(cursor.getString(cursor.getColumnIndex("remark_name_all_pinyin")));
            groupMemberInfoItem.setRemarkFirstPinyin(cursor.getString(cursor.getColumnIndex("remark_name_first_pinyin")));
            groupMemberInfoItem.setDisplayName(cursor.getString(cursor.getColumnIndex(bt.s)));
            groupMemberInfoItem.setAccount(cursor.getString(cursor.getColumnIndex("extra_data1")));
            String string = cursor.getString(cursor.getColumnIndex("extra_data3"));
            if (!TextUtils.isEmpty(string)) {
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    groupMemberInfoItem.setRoleType(jSONObject.optInt("roleType", 3));
                    groupMemberInfoItem.setMuteStatus(jSONObject.optInt("muteStatus", 0));
                    groupMemberInfoItem.setRoomRemark(jSONObject.optString("roomRemark", ""));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            groupMemberInfoItem.setExt((ContactExtBean) az2.a(cursor.getString(cursor.getColumnIndex("extra_json")), ContactExtBean.class));
        }
        return groupMemberInfoItem;
    }

    public static int checkUpdateGroupMemberOnReset(GroupMemberInfoItem groupMemberInfoItem, ContentValues contentValues) {
        if (groupMemberInfoItem == null) {
            return 0;
        }
        Integer asInteger = contentValues.getAsInteger("group_member_state");
        Integer numValueOf = Integer.valueOf(groupMemberInfoItem.state);
        if (asInteger != null && !asInteger.equals(numValueOf)) {
            return 2;
        }
        String asString = contentValues.getAsString("extra_data2");
        String str = groupMemberInfoItem.exId;
        if (asString != null && !asString.equals(str)) {
            return 1;
        }
        String asString2 = contentValues.getAsString("nick_name");
        String str2 = groupMemberInfoItem.nickName;
        if (asString2 != null && !asString2.equals(str2)) {
            return 1;
        }
        String asString3 = contentValues.getAsString(bt.s);
        String str3 = groupMemberInfoItem.displayName;
        if (asString3 != null && !asString3.equals(str3)) {
            return 1;
        }
        String asString4 = contentValues.getAsString("head_icon_url");
        String str4 = groupMemberInfoItem.iconURL;
        if (asString4 != null && !asString4.equals(str4)) {
            return 1;
        }
        Integer asInteger2 = contentValues.getAsInteger("is_owner");
        Integer numValueOf2 = Integer.valueOf(groupMemberInfoItem.isOwner);
        if (asInteger2 != null && !asInteger2.equals(numValueOf2)) {
            return 1;
        }
        String asString5 = contentValues.getAsString("remark_name");
        String str5 = groupMemberInfoItem.remarkName;
        if (asString5 != null && !asString5.equals(str5)) {
            return 1;
        }
        String asString6 = contentValues.getAsString("extra_json");
        String strC = az2.c(groupMemberInfoItem.getExt());
        if (asString6 != null && !asString6.equals(strC)) {
            return 1;
        }
        String asString7 = contentValues.getAsString("extra_data3");
        int roleType = groupMemberInfoItem.getRoleType();
        int muteStatus = groupMemberInfoItem.getMuteStatus();
        String roomRemark = groupMemberInfoItem.getRoomRemark();
        if (asString7 == null) {
            return 0;
        }
        try {
            JSONObject jSONObject = new JSONObject(asString7);
            if (roleType != jSONObject.optInt("roleType", -1) || muteStatus != jSONObject.optInt("muteStatus", -1)) {
                return 1;
            }
            String strOptString = jSONObject.optString("roomRemark", "");
            if (roomRemark != null) {
                return !roomRemark.equals(strOptString) ? 1 : 0;
            }
            return 0;
        } catch (JSONException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAccount() {
        return this.account;
    }

    public String getAllPinyin() {
        return this.allPinyin;
    }

    @Override // com.zenmen.palmchat.chat.ChatItem
    public int getBizType() {
        return 0;
    }

    @Override // com.zenmen.palmchat.chat.ChatItem
    public String getChatId() {
        return this.uid;
    }

    @Override // com.zenmen.palmchat.chat.ChatItem
    public String getChatName() {
        return !TextUtils.isEmpty(this.remarkName) ? this.remarkName : !TextUtils.isEmpty(this.displayName) ? this.displayName : this.nickName;
    }

    @Override // com.zenmen.palmchat.chat.ChatItem
    public int getChatType() {
        return 1;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getExId() {
        return this.exId;
    }

    public ContactExtBean getExt() {
        return this.ext;
    }

    public String getFirstPinyin() {
        return this.firstPinyin;
    }

    public String getGroupId() {
        return this.groupId;
    }

    @Override // com.zenmen.palmchat.chat.ChatItem
    public String getIconURL() {
        return this.iconURL;
    }

    public int getIsOwner() {
        return this.isOwner;
    }

    public int getMuteStatus() {
        return this.muteStatus;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getRemarkAllPinyin() {
        return this.remarkAllPinyin;
    }

    public String getRemarkFirstPinyin() {
        return this.remarkFirstPinyin;
    }

    public String getRemarkName() {
        return this.remarkName;
    }

    public int getRoleType() {
        return this.roleType;
    }

    public String getRoomRemark() {
        return this.roomRemark;
    }

    @Override // com.zenmen.palmchat.chat.ChatItem
    public int getSessionConfig() {
        return 0;
    }

    public int getState() {
        return this.state;
    }

    public String getUid() {
        return this.uid;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setAllPinyin(String str) {
        this.allPinyin = str;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setExId(String str) {
        this.exId = str;
    }

    public void setExt(ContactExtBean contactExtBean) {
        this.ext = contactExtBean;
    }

    public void setFirstPinyin(String str) {
        this.firstPinyin = str;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setIconURL(String str) {
        this.iconURL = str;
    }

    public void setIsOwner(int i) {
        this.isOwner = i;
    }

    public void setMuteStatus(int i) {
        this.muteStatus = i;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setRemarkAllPinyin(String str) {
        this.remarkAllPinyin = str;
    }

    public void setRemarkFirstPinyin(String str) {
        this.remarkFirstPinyin = str;
    }

    public void setRemarkName(String str) {
        this.remarkName = str;
    }

    public void setRoleType(int i) {
        this.roleType = i;
    }

    public void setRoomRemark(String str) {
        this.roomRemark = str;
    }

    public void setState(int i) {
        this.state = i;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.groupId);
        parcel.writeString(this.uid);
        parcel.writeString(this.exId);
        parcel.writeString(this.nickName);
        parcel.writeString(this.allPinyin);
        parcel.writeString(this.firstPinyin);
        parcel.writeString(this.remarkName);
        parcel.writeString(this.remarkAllPinyin);
        parcel.writeString(this.remarkFirstPinyin);
        parcel.writeString(this.displayName);
        parcel.writeString(this.iconURL);
        parcel.writeInt(this.isOwner);
        parcel.writeInt(this.state);
        parcel.writeString(this.account);
        parcel.writeInt(this.roleType);
        parcel.writeInt(this.muteStatus);
        parcel.writeString(this.roomRemark);
        parcel.writeParcelable(this.ext, 0);
    }
}
