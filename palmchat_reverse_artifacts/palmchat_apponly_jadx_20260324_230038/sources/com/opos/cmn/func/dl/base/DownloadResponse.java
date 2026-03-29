package com.opos.cmn.func.dl.base;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class DownloadResponse implements Parcelable {
    public static final Parcelable.Creator<DownloadResponse> CREATOR = new Parcelable.Creator<DownloadResponse>() { // from class: com.opos.cmn.func.dl.base.DownloadResponse.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final DownloadResponse createFromParcel(Parcel parcel) {
            return new DownloadResponse(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final DownloadResponse[] newArray(int i) {
            return new DownloadResponse[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7957a;
    public long b;
    public long c;
    public long d;
    public long e;

    public DownloadResponse() {
        this.f7957a = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "StatusResponse{status=" + this.f7957a + ", startLen=" + this.b + ", downloadedLen=" + this.c + ", totalLen=" + this.d + ", speed=" + this.e + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7957a);
        parcel.writeLong(this.b);
        parcel.writeLong(this.c);
        parcel.writeLong(this.d);
        parcel.writeLong(this.e);
    }

    private DownloadResponse(Parcel parcel) {
        this.f7957a = 0;
        this.f7957a = parcel.readInt();
        this.b = parcel.readLong();
        this.c = parcel.readLong();
        this.d = parcel.readLong();
        this.e = parcel.readLong();
    }
}
