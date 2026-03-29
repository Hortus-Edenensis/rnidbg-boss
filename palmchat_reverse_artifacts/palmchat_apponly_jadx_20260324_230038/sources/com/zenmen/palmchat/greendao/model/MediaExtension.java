package com.zenmen.palmchat.greendao.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class MediaExtension implements Parcelable {
    public static final Parcelable.Creator<MediaExtension> CREATOR = new Parcelable.Creator<MediaExtension>() { // from class: com.zenmen.palmchat.greendao.model.MediaExtension.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaExtension createFromParcel(Parcel parcel) {
            return new MediaExtension(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaExtension[] newArray(int i) {
            return new MediaExtension[i];
        }
    };
    public List<String> click;
    public List<String> exit;
    public List<String> inview;
    public String newsId;
    public Source source;
    public int uType;

    public MediaExtension(Parcel parcel) {
        this.uType = parcel.readInt();
        this.newsId = parcel.readString();
        this.click = parcel.createStringArrayList();
        this.inview = parcel.createStringArrayList();
        this.exit = parcel.createStringArrayList();
        this.source = (Source) parcel.readParcelable(Source.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.uType);
        parcel.writeString(this.newsId);
        parcel.writeStringList(this.click);
        parcel.writeStringList(this.inview);
        parcel.writeStringList(this.exit);
        parcel.writeParcelable(this.source, i);
    }
}
