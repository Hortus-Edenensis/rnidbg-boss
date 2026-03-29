package com.zenmen.palmchat.Vo;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ExpressionObject implements Parcelable {
    public static final Parcelable.Creator<ExpressionObject> CREATOR = new Parcelable.Creator<ExpressionObject>() { // from class: com.zenmen.palmchat.Vo.ExpressionObject.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ExpressionObject createFromParcel(Parcel parcel) {
            ExpressionObject expressionObject = new ExpressionObject();
            expressionObject._id = parcel.readInt();
            expressionObject.path = parcel.readString();
            expressionObject.coverPath = parcel.readString();
            expressionObject.index = parcel.readInt();
            expressionObject.type = parcel.readInt();
            expressionObject.description = parcel.readString();
            expressionObject.md5 = parcel.readString();
            expressionObject.thumbUrl = parcel.readString();
            expressionObject.url = parcel.readString();
            expressionObject.extension = parcel.readString();
            expressionObject.tag = parcel.readString();
            return expressionObject;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ExpressionObject[] newArray(int i) {
            return new ExpressionObject[i];
        }
    };
    public int _id;
    public String coverPath;
    public String description;
    public String extension;
    public int index;
    public boolean isSelect;
    public String md5;
    public String path;
    public String tag;
    public String thumbUrl;
    public int type;
    public String url;

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
        parcel.writeString(this.tag);
    }
}
