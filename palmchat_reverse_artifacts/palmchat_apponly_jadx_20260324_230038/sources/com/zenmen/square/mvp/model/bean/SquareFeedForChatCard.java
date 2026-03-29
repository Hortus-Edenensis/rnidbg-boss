package com.zenmen.square.mvp.model.bean;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.umeng.analytics.pro.bd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareFeedForChatCard implements Parcelable {
    public static final Parcelable.Creator<SquareFeedForChatCard> CREATOR = new Parcelable.Creator<SquareFeedForChatCard>() { // from class: com.zenmen.square.mvp.model.bean.SquareFeedForChatCard.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SquareFeedForChatCard createFromParcel(Parcel parcel) {
            return new SquareFeedForChatCard(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SquareFeedForChatCard[] newArray(int i) {
            return new SquareFeedForChatCard[i];
        }
    };
    public String content;
    public double distance;
    public String exid;
    public int feedType;
    public long id;
    public String location;
    public List<MediaForChatCard> mediaList;

    public SquareFeedForChatCard() {
    }

    public static SquareFeedForChatCard parse(SquareFeed squareFeed) {
        if (squareFeed == null) {
            return null;
        }
        SquareFeedForChatCard squareFeedForChatCard = new SquareFeedForChatCard();
        squareFeedForChatCard.exid = squareFeed.exid;
        squareFeedForChatCard.feedType = squareFeed.feedType;
        squareFeedForChatCard.id = squareFeed.id;
        squareFeedForChatCard.content = squareFeed.content;
        squareFeedForChatCard.location = squareFeed.location;
        squareFeedForChatCard.distance = squareFeed.distance;
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
            squareFeedForChatCard.mediaList = arrayList;
        }
        return squareFeedForChatCard;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String genDeepLinkUrl() {
        return Uri.parse("zenxin://activity").buildUpon().appendQueryParameter("page", this.feedType == 1 ? "a0412" : "a0408").appendQueryParameter(bd.h, this.exid).appendQueryParameter("feedId", this.id + "").appendQueryParameter("feedType", this.feedType + "").appendQueryParameter("from", "8").build().toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.exid);
        parcel.writeInt(this.feedType);
        parcel.writeLong(this.id);
        parcel.writeString(this.content);
        parcel.writeString(this.location);
        parcel.writeDouble(this.distance);
        parcel.writeTypedList(this.mediaList);
    }

    public SquareFeedForChatCard(Parcel parcel) {
        this.exid = parcel.readString();
        this.feedType = parcel.readInt();
        this.id = parcel.readLong();
        this.content = parcel.readString();
        this.location = parcel.readString();
        this.distance = parcel.readDouble();
        this.mediaList = parcel.createTypedArrayList(MediaForChatCard.CREATOR);
    }
}
