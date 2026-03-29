package com.zenmen.palmchat.Vo;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class GuideInfoForChatCard implements Parcelable {
    public static final Parcelable.Creator<GuideInfoForChatCard> CREATOR = new Parcelable.Creator<GuideInfoForChatCard>() { // from class: com.zenmen.palmchat.Vo.GuideInfoForChatCard.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public GuideInfoForChatCard createFromParcel(Parcel parcel) {
            return new GuideInfoForChatCard(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public GuideInfoForChatCard[] newArray(int i) {
            return new GuideInfoForChatCard[i];
        }
    };
    public String content;
    public Ext ext;
    public ArrayList<String> icon;
    public int styleType;
    public String title;
    public int turnType;
    public String turnUrl;
    public String type;

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class Ext implements Parcelable {
        public static final Parcelable.Creator<Ext> CREATOR = new Parcelable.Creator<Ext>() { // from class: com.zenmen.palmchat.Vo.GuideInfoForChatCard.Ext.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Ext createFromParcel(Parcel parcel) {
                return new Ext(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Ext[] newArray(int i) {
                return new Ext[i];
            }
        };
        public String feedContent;
        public long feedId;

        public Ext(Parcel parcel) {
            this.feedId = 0L;
            this.feedContent = parcel.readString();
            this.feedId = parcel.readLong();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.feedContent);
            parcel.writeLong(this.feedId);
        }
    }

    public GuideInfoForChatCard() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.styleType);
        parcel.writeString(this.type);
        parcel.writeString(this.content);
        parcel.writeInt(this.turnType);
        parcel.writeString(this.turnUrl);
        parcel.writeStringList(this.icon);
        parcel.writeString(this.title);
        parcel.writeParcelable(this.ext, i);
    }

    public GuideInfoForChatCard(Parcel parcel) {
        this.styleType = parcel.readInt();
        this.type = parcel.readString();
        this.content = parcel.readString();
        this.turnType = parcel.readInt();
        this.turnUrl = parcel.readString();
        this.icon = parcel.createStringArrayList();
        this.title = parcel.readString();
        this.ext = (Ext) parcel.readParcelable(Ext.class.getClassLoader());
    }
}
