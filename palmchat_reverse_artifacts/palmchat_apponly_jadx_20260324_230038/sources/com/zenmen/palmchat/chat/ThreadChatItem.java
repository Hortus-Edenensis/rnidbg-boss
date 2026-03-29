package com.zenmen.palmchat.chat;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.messaging.smack.DomainHelper;
import defpackage.il5;
import defpackage.zd2;
import defpackage.zr0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ThreadChatItem implements ChatItem {
    public static final Parcelable.Creator<ThreadChatItem> CREATOR = new a();
    public int activeStatus;
    public String bizExtension;
    public int bizType;
    public String chatMateRoomId;
    public int chatType;
    public String draft;
    public long draftDate;
    public boolean hasRemind;
    public boolean hasUnreadGiftMessage;
    public String iconUrl;
    public int id;
    public boolean isBlackList;
    public boolean isChatMateMsgListItem;
    public boolean isContactReady;
    public boolean isInviteTruthChat;
    public boolean isNoDisturb;
    public boolean isRiskThreadGroup;
    public int isSuperGreetings;
    public long lastMessageDate;
    public String lastMsg;
    public String lastMsgMid;
    public int lastMsgType;
    public int pinGiftMessage;
    public boolean read;
    public String relativeContact;
    public String remindIds;
    public long roomDeadline;
    public boolean showMembersNickName;
    public String title;
    public int unReadCount;
    public int groupExtType = 0;
    public int priority = 0;
    public int messageStatus = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Parcelable.Creator<ThreadChatItem> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ThreadChatItem createFromParcel(Parcel parcel) {
            return new ThreadChatItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ThreadChatItem[] newArray(int i) {
            return new ThreadChatItem[i];
        }
    }

    public ThreadChatItem(Parcel parcel) {
        this.id = parcel.readInt();
        this.chatType = parcel.readInt();
        this.relativeContact = parcel.readString();
        this.iconUrl = parcel.readString();
        this.title = parcel.readString();
        this.bizType = parcel.readInt();
        this.remindIds = parcel.readString();
        this.lastMsgMid = parcel.readString();
        this.lastMsg = parcel.readString();
        this.lastMsgType = parcel.readInt();
        this.unReadCount = parcel.readInt();
        this.isContactReady = parcel.readByte() != 0;
        this.lastMessageDate = parcel.readLong();
        this.draftDate = parcel.readLong();
        this.draft = parcel.readString();
        this.activeStatus = parcel.readInt();
    }

    public static ThreadChatItem parseCursor(Cursor cursor) {
        ThreadChatItem threadChatItem = new ThreadChatItem();
        if (cursor != null) {
            threadChatItem.id = cursor.getInt(cursor.getColumnIndex("_id"));
            threadChatItem.chatType = cursor.getInt(cursor.getColumnIndex("chat_type"));
            threadChatItem.relativeContact = DomainHelper.s(cursor.getString(cursor.getColumnIndex("contact_relate")));
            threadChatItem.iconUrl = cursor.getString(cursor.getColumnIndex("icon_url"));
            threadChatItem.title = cursor.getString(cursor.getColumnIndex("title"));
            threadChatItem.bizType = cursor.getInt(cursor.getColumnIndex("thread_biz_type"));
            threadChatItem.remindIds = cursor.getString(cursor.getColumnIndex("thread_draft_remind_uids"));
            threadChatItem.lastMsgMid = cursor.getString(cursor.getColumnIndex("thread_message_mid"));
            threadChatItem.lastMsg = cursor.getString(cursor.getColumnIndex("latest_message"));
            threadChatItem.lastMsgType = cursor.getInt(cursor.getColumnIndex("latest_message_mime_type"));
            threadChatItem.unReadCount = cursor.getInt(cursor.getColumnIndex("unread_message_count"));
            threadChatItem.isContactReady = cursor.getInt(cursor.getColumnIndex("thread_contact_ready")) == 1;
            threadChatItem.lastMessageDate = cursor.getLong(cursor.getColumnIndex("latest_message_time_stamp"));
            threadChatItem.draftDate = cursor.getLong(cursor.getColumnIndex("thread_draft_time"));
            threadChatItem.draft = cursor.getString(cursor.getColumnIndex("thread_draft"));
            threadChatItem.isNoDisturb = cursor.getInt(cursor.getColumnIndex("thread_nodisturb")) == 1;
            threadChatItem.priority = cursor.getInt(cursor.getColumnIndex("thread_priority"));
            threadChatItem.messageStatus = cursor.getInt(cursor.getColumnIndex("thread_message_status"));
            threadChatItem.hasRemind = cursor.getInt(cursor.getColumnIndex("thread_has_remind")) != 0;
            threadChatItem.hasUnreadGiftMessage = zr0.a(cursor, "has_unread_gift_message") == 1;
            threadChatItem.read = cursor.getInt(cursor.getColumnIndex("latest_message_read")) == 1;
            threadChatItem.bizExtension = cursor.getString(cursor.getColumnIndex("thread_biz_extension"));
            threadChatItem.isSuperGreetings = cursor.getInt(cursor.getColumnIndex("is_super_greetings"));
            threadChatItem.showMembersNickName = cursor.getInt(cursor.getColumnIndex("thread_show_members_nick_name")) == 1;
            threadChatItem.isBlackList = cursor.getInt(cursor.getColumnIndex("thread_blacklist")) > 0;
            threadChatItem.activeStatus = cursor.getInt(cursor.getColumnIndex("thread_active"));
            threadChatItem.pinGiftMessage = zr0.a(cursor, "pin_gift_message");
            threadChatItem.groupExtType = zd2.a(threadChatItem.getChatId());
        }
        return threadChatItem;
    }

    public ChatItem convert2ContactOrGroupChatInfo() {
        int i = this.chatType;
        if (i == 0) {
            ContactInfoItem contactInfoItem = new ContactInfoItem();
            contactInfoItem.setUid(this.relativeContact);
            contactInfoItem.setNickName(this.title);
            contactInfoItem.setIconURL(this.iconUrl);
            contactInfoItem.setBizType(this.bizType);
            return contactInfoItem;
        }
        if (i != 1) {
            return null;
        }
        GroupInfoItem groupInfoItem = new GroupInfoItem();
        groupInfoItem.setGroupId(this.relativeContact);
        groupInfoItem.setGroupName(this.title);
        groupInfoItem.setGroupHeadImgUrl(this.iconUrl);
        groupInfoItem.setBizType(this.bizType);
        return groupInfoItem;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equal(ThreadChatItem threadChatItem) {
        return threadChatItem != null && this.id == threadChatItem.id && this.chatType == threadChatItem.chatType && il5.d(this.relativeContact, threadChatItem.relativeContact) && il5.d(this.iconUrl, threadChatItem.iconUrl) && il5.d(this.title, threadChatItem.title) && this.bizType == threadChatItem.bizType && il5.d(this.remindIds, threadChatItem.remindIds) && il5.d(this.lastMsgMid, threadChatItem.lastMsgMid) && il5.d(this.lastMsg, threadChatItem.lastMsg) && this.lastMsgType == threadChatItem.lastMsgType && this.unReadCount == threadChatItem.unReadCount && this.isContactReady == threadChatItem.isContactReady && this.lastMessageDate == threadChatItem.lastMessageDate && this.draftDate == threadChatItem.draftDate && il5.d(this.draft, threadChatItem.draft);
    }

    @Override // com.zenmen.palmchat.chat.ChatItem
    public int getBizType() {
        return this.bizType;
    }

    @Override // com.zenmen.palmchat.chat.ChatItem
    public String getChatId() {
        return this.relativeContact;
    }

    @Override // com.zenmen.palmchat.chat.ChatItem
    public String getChatName() {
        return this.title;
    }

    @Override // com.zenmen.palmchat.chat.ChatItem
    public int getChatType() {
        return this.chatType;
    }

    @Override // com.zenmen.palmchat.chat.ChatItem
    public String getIconURL() {
        return this.iconUrl;
    }

    public String getRemindIds() {
        return this.remindIds;
    }

    @Override // com.zenmen.palmchat.chat.ChatItem
    public int getSessionConfig() {
        return 0;
    }

    public void setBizType(int i) {
        this.bizType = i;
    }

    public void setRemindIds(String str) {
        this.remindIds = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeInt(this.chatType);
        parcel.writeString(this.relativeContact);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.title);
        parcel.writeInt(this.bizType);
        parcel.writeString(this.remindIds);
        parcel.writeString(this.lastMsgMid);
        parcel.writeString(this.lastMsg);
        parcel.writeInt(this.lastMsgType);
        parcel.writeInt(this.unReadCount);
        parcel.writeByte(this.isContactReady ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.lastMessageDate);
        parcel.writeLong(this.draftDate);
        parcel.writeString(this.draft);
        parcel.writeInt(this.activeStatus);
    }

    public ThreadChatItem() {
    }
}
