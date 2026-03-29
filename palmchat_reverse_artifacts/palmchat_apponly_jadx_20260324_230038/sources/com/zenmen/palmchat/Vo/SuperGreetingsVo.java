package com.zenmen.palmchat.Vo;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class SuperGreetingsVo implements Parcelable {
    public static final Parcelable.Creator<SuperGreetingsVo> CREATOR = new Parcelable.Creator<SuperGreetingsVo>() { // from class: com.zenmen.palmchat.Vo.SuperGreetingsVo.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SuperGreetingsVo createFromParcel(Parcel parcel) {
            return new SuperGreetingsVo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public SuperGreetingsVo[] newArray(int i) {
            return new SuperGreetingsVo[i];
        }
    };
    public boolean isSuperGreetings;

    public SuperGreetingsVo(boolean z) {
        this.isSuperGreetings = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.isSuperGreetings ? (byte) 1 : (byte) 0);
    }

    public SuperGreetingsVo(Parcel parcel) {
        this.isSuperGreetings = parcel.readByte() != 0;
    }
}
