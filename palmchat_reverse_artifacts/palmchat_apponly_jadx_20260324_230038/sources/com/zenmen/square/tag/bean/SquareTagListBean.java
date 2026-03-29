package com.zenmen.square.tag.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareTagListBean implements Parcelable {
    public static final Parcelable.Creator<SquareTagListBean> CREATOR = new Parcelable.Creator<SquareTagListBean>() { // from class: com.zenmen.square.tag.bean.SquareTagListBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SquareTagListBean createFromParcel(Parcel parcel) {
            return new SquareTagListBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SquareTagListBean[] newArray(int i) {
            return new SquareTagListBean[i];
        }
    };
    private int showTagLimit;
    private List<SquareTagBean> tagList;

    public SquareTagListBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getShowTagLimit() {
        return this.showTagLimit;
    }

    public List<SquareTagBean> getTagList() {
        return this.tagList;
    }

    public void setShowTagLimit(int i) {
        this.showTagLimit = i;
    }

    public void setTagList(List<SquareTagBean> list) {
        this.tagList = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.showTagLimit);
        parcel.writeTypedList(this.tagList);
    }

    public SquareTagListBean(Parcel parcel) {
        this.showTagLimit = parcel.readInt();
        this.tagList = parcel.createTypedArrayList(SquareTagBean.CREATOR);
    }
}
