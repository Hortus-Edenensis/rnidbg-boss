package com.zenmen.square.mvp.model.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.zenmen.palmchat.c;
import defpackage.v4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareFeedShareCard implements Parcelable {
    public static final Parcelable.Creator<SquareFeedShareCard> CREATOR = new Parcelable.Creator<SquareFeedShareCard>() { // from class: com.zenmen.square.mvp.model.bean.SquareFeedShareCard.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SquareFeedShareCard createFromParcel(Parcel parcel) {
            return new SquareFeedShareCard(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SquareFeedShareCard[] newArray(int i) {
            return new SquareFeedShareCard[i];
        }
    };
    public String content;
    public int deleted;
    public int feedType;
    public long id;
    public String location;
    public List<MediaForChatCard> mediaList;
    public String uid;

    public SquareFeedShareCard() {
    }

    public static SquareFeedShareCard parse(SquareFeed squareFeed) {
        if (squareFeed == null) {
            return null;
        }
        SquareFeedShareCard squareFeedShareCard = new SquareFeedShareCard();
        squareFeedShareCard.uid = v4.e(c.b());
        squareFeedShareCard.feedType = squareFeed.feedType;
        squareFeedShareCard.id = squareFeed.id;
        squareFeedShareCard.content = squareFeed.content;
        squareFeedShareCard.location = squareFeed.location;
        squareFeedShareCard.deleted = squareFeed.deleted;
        List<Media> list = squareFeed.mediaList;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            Iterator<Media> it = squareFeed.mediaList.iterator();
            while (it.hasNext()) {
                MediaForChatCard mediaForChatCard = MediaForChatCard.parse(it.next());
                if (mediaForChatCard != null) {
                    arrayList.add(mediaForChatCard);
                }
            }
            squareFeedShareCard.mediaList = arrayList;
        }
        return squareFeedShareCard;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.uid);
        parcel.writeInt(this.feedType);
        parcel.writeLong(this.id);
        parcel.writeString(this.content);
        parcel.writeString(this.location);
        parcel.writeTypedList(this.mediaList);
        parcel.writeInt(this.deleted);
    }

    public SquareFeedShareCard(Parcel parcel) {
        this.uid = parcel.readString();
        this.feedType = parcel.readInt();
        this.id = parcel.readLong();
        this.content = parcel.readString();
        this.location = parcel.readString();
        this.mediaList = parcel.createTypedArrayList(MediaForChatCard.CREATOR);
        this.deleted = parcel.readInt();
    }
}
