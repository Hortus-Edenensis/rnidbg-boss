package com.zenmen.palmchat.Vo;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import com.zenmen.palmchat.messaging.smack.DomainHelper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ThreadVo extends BaseVo {
    public static final Parcelable.Creator<ThreadVo> CREATOR = new Parcelable.Creator<ThreadVo>() { // from class: com.zenmen.palmchat.Vo.ThreadVo.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ThreadVo createFromParcel(Parcel parcel) {
            return new ThreadVo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ThreadVo[] newArray(int i) {
            return new ThreadVo[i];
        }
    };
    public long _id;
    public int active;
    public String background;
    public String bizExt;
    public int bizType;
    public int blackList;
    public int chatType;
    public int contactReady;
    public String contactRelate;
    public String draft;
    public String draftRemindUids;
    public long draftTimeStamp;
    public int focus;
    public int hasRemind;
    public String icon;
    public String lastUnreadMsgID;
    public long lastUnreadMsgTimeStamp;
    public String memberNickName;
    public String msgContent;
    public String msgMid;
    public int msgReadStatus;
    public String msgStatus;
    public long msgTimeStamp;
    public int msgType;
    public int noDisturb;
    public int priority;
    public String title;
    public int unReadCount;

    public ThreadVo() {
        this.msgType = 1;
        this.msgReadStatus = 1;
    }

    public static ThreadVo buildFromCursor(Cursor cursor) {
        ThreadVo threadVo = new ThreadVo();
        threadVo._id = cursor.getLong(cursor.getColumnIndex("_id"));
        threadVo.icon = cursor.getString(cursor.getColumnIndex("icon_url"));
        threadVo.title = cursor.getString(cursor.getColumnIndex("title"));
        threadVo.msgContent = cursor.getString(cursor.getColumnIndex("latest_message"));
        threadVo.msgType = cursor.getInt(cursor.getColumnIndex("latest_message_mime_type"));
        threadVo.msgTimeStamp = cursor.getInt(cursor.getColumnIndex("latest_message_time_stamp"));
        threadVo.contactRelate = DomainHelper.s(cursor.getString(cursor.getColumnIndex("contact_relate")));
        threadVo.chatType = cursor.getInt(cursor.getColumnIndex("chat_type"));
        threadVo.unReadCount = cursor.getInt(cursor.getColumnIndex("unread_message_count"));
        threadVo.background = cursor.getString(cursor.getColumnIndex("thread_background"));
        threadVo.noDisturb = cursor.getInt(cursor.getColumnIndex("thread_nodisturb"));
        threadVo.blackList = cursor.getInt(cursor.getColumnIndex("thread_blacklist"));
        threadVo.focus = cursor.getInt(cursor.getColumnIndex("thread_focus"));
        threadVo.active = cursor.getInt(cursor.getColumnIndex("thread_active"));
        threadVo.draft = cursor.getString(cursor.getColumnIndex("thread_draft"));
        threadVo.msgMid = cursor.getString(cursor.getColumnIndex("thread_message_mid"));
        threadVo.msgStatus = cursor.getString(cursor.getColumnIndex("thread_message_status"));
        threadVo.lastUnreadMsgTimeStamp = cursor.getLong(cursor.getColumnIndex("thread_latest_unread_message_time"));
        threadVo.lastUnreadMsgID = cursor.getString(cursor.getColumnIndex("thread_latest_unread_message_primary_key_id"));
        threadVo.priority = cursor.getInt(cursor.getColumnIndex("thread_priority"));
        threadVo.hasRemind = cursor.getInt(cursor.getColumnIndex("thread_has_remind"));
        threadVo.draftRemindUids = cursor.getString(cursor.getColumnIndex("thread_draft_remind_uids"));
        threadVo.msgReadStatus = cursor.getInt(cursor.getColumnIndex("latest_message_read"));
        threadVo.memberNickName = cursor.getString(cursor.getColumnIndex("thread_show_members_nick_name"));
        threadVo.draftTimeStamp = cursor.getLong(cursor.getColumnIndex("thread_draft_time"));
        threadVo.contactReady = cursor.getInt(cursor.getColumnIndex("thread_contact_ready"));
        threadVo.bizType = cursor.getInt(cursor.getColumnIndex("thread_biz_type"));
        threadVo.bizExt = cursor.getString(cursor.getColumnIndex("thread_biz_extension"));
        return threadVo;
    }

    @Override // com.zenmen.palmchat.Vo.BaseVo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.zenmen.palmchat.Vo.BaseVo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this._id);
        parcel.writeString(this.icon);
        parcel.writeString(this.title);
        parcel.writeString(this.msgContent);
        parcel.writeInt(this.msgType);
        parcel.writeLong(this.msgTimeStamp);
        parcel.writeString(this.contactRelate);
        parcel.writeInt(this.chatType);
        parcel.writeInt(this.unReadCount);
        parcel.writeString(this.background);
        parcel.writeInt(this.noDisturb);
        parcel.writeInt(this.blackList);
        parcel.writeInt(this.focus);
        parcel.writeInt(this.active);
        parcel.writeString(this.draft);
        parcel.writeString(this.msgMid);
        parcel.writeString(this.msgStatus);
        parcel.writeLong(this.lastUnreadMsgTimeStamp);
        parcel.writeString(this.lastUnreadMsgID);
        parcel.writeInt(this.priority);
        parcel.writeInt(this.hasRemind);
        parcel.writeString(this.draftRemindUids);
        parcel.writeInt(this.msgReadStatus);
        parcel.writeString(this.memberNickName);
        parcel.writeLong(this.draftTimeStamp);
        parcel.writeInt(this.contactReady);
        parcel.writeInt(this.bizType);
        parcel.writeString(this.bizExt);
    }

    public ThreadVo(Parcel parcel) {
        this.msgType = 1;
        this.msgReadStatus = 1;
        this._id = parcel.readLong();
        this.icon = parcel.readString();
        this.title = parcel.readString();
        this.msgContent = parcel.readString();
        this.msgType = parcel.readInt();
        this.msgTimeStamp = parcel.readLong();
        this.contactRelate = parcel.readString();
        this.chatType = parcel.readInt();
        this.unReadCount = parcel.readInt();
        this.background = parcel.readString();
        this.noDisturb = parcel.readInt();
        this.blackList = parcel.readInt();
        this.focus = parcel.readInt();
        this.active = parcel.readInt();
        this.draft = parcel.readString();
        this.msgMid = parcel.readString();
        this.msgStatus = parcel.readString();
        this.lastUnreadMsgTimeStamp = parcel.readLong();
        this.lastUnreadMsgID = parcel.readString();
        this.priority = parcel.readInt();
        this.hasRemind = parcel.readInt();
        this.draftRemindUids = parcel.readString();
        this.msgReadStatus = parcel.readInt();
        this.memberNickName = parcel.readString();
        this.draftTimeStamp = parcel.readLong();
        this.contactReady = parcel.readInt();
        this.bizType = parcel.readInt();
        this.bizExt = parcel.readString();
    }
}
