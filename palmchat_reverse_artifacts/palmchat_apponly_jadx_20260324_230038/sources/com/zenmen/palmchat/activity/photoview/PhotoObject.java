package com.zenmen.palmchat.activity.photoview;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class PhotoObject implements Parcelable {
    public static final Parcelable.Creator<PhotoObject> CREATOR = new a();
    public int _id;
    public String coverPath;
    public String description;
    public String extension;
    public int index;
    public boolean isOriImage;
    public boolean isSelect;
    public String md5;
    public String path;
    public String thumbUrl;
    public int type;
    public String url;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Parcelable.Creator<PhotoObject> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PhotoObject createFromParcel(Parcel parcel) {
            PhotoObject photoObject = new PhotoObject();
            photoObject._id = parcel.readInt();
            photoObject.path = parcel.readString();
            photoObject.coverPath = parcel.readString();
            photoObject.index = parcel.readInt();
            photoObject.type = parcel.readInt();
            photoObject.description = parcel.readString();
            photoObject.md5 = parcel.readString();
            photoObject.thumbUrl = parcel.readString();
            photoObject.url = parcel.readString();
            photoObject.extension = parcel.readString();
            return photoObject;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public PhotoObject[] newArray(int i) {
            return new PhotoObject[i];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this._id);
        parcel.writeString(this.path);
        parcel.writeString(this.coverPath);
        parcel.writeInt(this.index);
        parcel.writeInt(this.type);
        parcel.writeString(this.description);
        parcel.writeString(this.md5);
        parcel.writeString(this.thumbUrl);
        parcel.writeString(this.url);
        parcel.writeString(this.extension);
    }
}
