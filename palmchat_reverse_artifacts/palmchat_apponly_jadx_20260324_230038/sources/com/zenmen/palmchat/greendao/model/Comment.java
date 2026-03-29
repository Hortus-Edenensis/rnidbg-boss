package com.zenmen.palmchat.greendao.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import defpackage.dn0;
import defpackage.v4;
import defpackage.xk2;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class Comment implements xk2<Comment>, Parcelable {
    public static final Parcelable.Creator<Comment> CREATOR = new Parcelable.Creator<Comment>() { // from class: com.zenmen.palmchat.greendao.model.Comment.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Comment createFromParcel(Parcel parcel) {
            return new Comment(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Comment[] newArray(int i) {
            return new Comment[i];
        }
    };
    public List<Comment> childComments;
    public int commentType;
    private String content;
    private Long createDt;
    public Integer deleted;
    private Long feedId;
    public Long feedUid;
    private String fromUid;
    private Long id;
    public long oneLevelCommentId;
    public Long toCommentId;
    private String toUid;
    private int type;
    public Long updateTime;

    /* JADX INFO: compiled from: SearchBox */
    public static class ChildComparator implements Comparator<Comment> {
        @Override // java.util.Comparator
        public int compare(Comment comment, Comment comment2) {
            return comment.createDt.compareTo(comment2.createDt);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class OneLevelComparator implements Comparator<Comment> {
        @Override // java.util.Comparator
        public int compare(Comment comment, Comment comment2) {
            if (comment.createDt.longValue() > comment2.createDt.longValue()) {
                return -1;
            }
            return comment.createDt.longValue() < comment2.createDt.longValue() ? 1 : 0;
        }
    }

    public Comment(Long l, Long l2, String str, String str2, String str3, Long l3, int i) {
        this.updateTime = 0L;
        this.childComments = new ArrayList();
        this.id = l;
        this.feedId = l2;
        this.content = str;
        this.fromUid = str2;
        this.toUid = str3;
        this.createDt = l3;
        this.type = i;
    }

    private String getNickNameFromUid(String str) {
        ContactInfoItem contactInfoItemA = dn0.a(str);
        if (contactInfoItemA != null) {
            return contactInfoItemA.getNameForShow();
        }
        return null;
    }

    public boolean canDelete() {
        return TextUtils.equals(this.fromUid, v4.e(c.b()));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCommentContent() {
        return this.content;
    }

    public String getCommentCreatorAvatar() {
        ContactInfoItem contactInfoItemA = dn0.a(this.fromUid);
        if (contactInfoItemA != null) {
            return contactInfoItemA.getIconURL();
        }
        return null;
    }

    @Override // defpackage.xk2
    public String getCommentCreatorName() {
        return getNickNameFromUid(this.fromUid);
    }

    public String getCommentUid() {
        return this.fromUid;
    }

    public String getContent() {
        return this.content;
    }

    public Long getCreateDt() {
        return this.createDt;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // defpackage.xk2
    public Comment getData() {
        return this;
    }

    public Integer getDeleted() {
        return this.deleted;
    }

    public Long getFeedId() {
        return this.feedId;
    }

    public Long getFeedUid() {
        return this.feedUid;
    }

    public String getFromUid() {
        return this.fromUid;
    }

    public Long getId() {
        return this.id;
    }

    @Override // defpackage.xk2
    public String getReplyerName() {
        return getNickNameFromUid(this.toUid);
    }

    public Long getToCommentId() {
        return this.toCommentId;
    }

    public String getToUid() {
        return this.toUid;
    }

    public int getType() {
        return this.type;
    }

    public Long getUpdateTime() {
        return this.updateTime;
    }

    public boolean isLike() {
        return TextUtils.isEmpty(this.content);
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setCreateDt(Long l) {
        this.createDt = l;
    }

    public void setDeleted(Integer num) {
        this.deleted = num;
    }

    public void setFeedId(Long l) {
        this.feedId = l;
    }

    public void setFeedUid(Long l) {
        this.feedUid = l;
    }

    public void setFromUid(String str) {
        this.fromUid = str;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setToCommentId(Long l) {
        this.toCommentId = l;
    }

    public void setToUid(String str) {
        this.toUid = str;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setUpdateTime(Long l) {
        this.updateTime = l;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (this.id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(this.id.longValue());
        }
        if (this.feedId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(this.feedId.longValue());
        }
        parcel.writeString(this.content);
        parcel.writeString(this.fromUid);
        parcel.writeString(this.toUid);
        if (this.createDt == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(this.createDt.longValue());
        }
        parcel.writeInt(this.type);
        if (this.updateTime == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(this.updateTime.longValue());
        }
        if (this.deleted == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.deleted.intValue());
        }
        if (this.toCommentId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(this.toCommentId.longValue());
        }
        if (this.feedUid == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(this.feedUid.longValue());
        }
        parcel.writeLong(this.oneLevelCommentId);
        parcel.writeInt(this.commentType);
        parcel.writeTypedList(this.childComments);
    }

    public Comment() {
        this.updateTime = 0L;
        this.childComments = new ArrayList();
    }

    public Comment(Parcel parcel) {
        this.updateTime = 0L;
        this.childComments = new ArrayList();
        if (parcel.readByte() == 0) {
            this.id = null;
        } else {
            this.id = Long.valueOf(parcel.readLong());
        }
        if (parcel.readByte() == 0) {
            this.feedId = null;
        } else {
            this.feedId = Long.valueOf(parcel.readLong());
        }
        this.content = parcel.readString();
        this.fromUid = parcel.readString();
        this.toUid = parcel.readString();
        if (parcel.readByte() == 0) {
            this.createDt = null;
        } else {
            this.createDt = Long.valueOf(parcel.readLong());
        }
        this.type = parcel.readInt();
        if (parcel.readByte() == 0) {
            this.updateTime = null;
        } else {
            this.updateTime = Long.valueOf(parcel.readLong());
        }
        if (parcel.readByte() == 0) {
            this.deleted = null;
        } else {
            this.deleted = Integer.valueOf(parcel.readInt());
        }
        if (parcel.readByte() == 0) {
            this.toCommentId = null;
        } else {
            this.toCommentId = Long.valueOf(parcel.readLong());
        }
        if (parcel.readByte() == 0) {
            this.feedUid = null;
        } else {
            this.feedUid = Long.valueOf(parcel.readLong());
        }
        this.oneLevelCommentId = parcel.readLong();
        this.commentType = parcel.readInt();
        this.childComments = parcel.createTypedArrayList(CREATOR);
    }
}
