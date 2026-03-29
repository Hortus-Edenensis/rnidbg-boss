package com.oplus.tblplayer.misc;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class TimedText implements Parcelable {
    public static final Parcelable.Creator<TimedText> CREATOR = new Parcelable.Creator<TimedText>() { // from class: com.oplus.tblplayer.misc.TimedText.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TimedText createFromParcel(Parcel parcel) {
            return new TimedText(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TimedText[] newArray(int i) {
            return new TimedText[i];
        }
    };
    private Rect mTextBounds;
    private String mTextChars;

    public TimedText(Rect rect, String str) {
        this.mTextBounds = rect;
        this.mTextChars = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Rect getBounds() {
        return this.mTextBounds;
    }

    public String getText() {
        return this.mTextChars;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mTextBounds, i);
        parcel.writeString(this.mTextChars);
    }

    public TimedText(Parcel parcel) {
        this.mTextBounds = null;
        this.mTextChars = null;
        this.mTextBounds = (Rect) parcel.readParcelable(Rect.class.getClassLoader());
        this.mTextChars = parcel.readString();
    }
}
