package com.opos.cmn.func.dl.base;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import j$.util.Objects;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class DownloadRequest implements Parcelable {
    public static final Parcelable.Creator<DownloadRequest> CREATOR = new Parcelable.Creator<DownloadRequest>() { // from class: com.opos.cmn.func.dl.base.DownloadRequest.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final DownloadRequest createFromParcel(Parcel parcel) {
            return new DownloadRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final DownloadRequest[] newArray(int i) {
            return new DownloadRequest[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7955a;
    public final String b;
    public String c;
    public final int d;
    public final String e;
    public final int f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final Map<String, String> j;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f7956a;
        private String b;
        private String c;
        private String d;
        private int e;
        private String f;
        private int g;
        private boolean h;
        private boolean i;
        private Map<String, String> j;

        public a(String str) {
            this.b = str;
        }

        public a a(String str) {
            this.f = str;
            return this;
        }

        public a b(String str) {
            this.c = str;
            return this;
        }

        public a c(String str) {
            this.d = str;
            return this;
        }

        public a a(boolean z) {
            this.i = z;
            return this;
        }

        public a b(boolean z) {
            this.h = z;
            return this;
        }

        public a c(boolean z) {
            this.f7956a = z;
            return this;
        }

        public DownloadRequest a(Context context) {
            if (TextUtils.isEmpty(this.b) || context == null) {
                throw new IllegalArgumentException("download url or context should not be null");
            }
            if (TextUtils.isEmpty(this.c)) {
                this.c = context.getExternalCacheDir().getAbsolutePath();
            }
            this.g = com.opos.cmn.func.dl.base.i.a.a(this.b, this.c);
            return new DownloadRequest(this);
        }
    }

    private DownloadRequest(Parcel parcel) {
        this.f7955a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readInt();
        this.e = parcel.readString();
        this.f = parcel.readInt();
        this.g = parcel.readByte() != 0;
        this.h = parcel.readByte() != 0;
        this.i = parcel.readByte() != 0;
        this.j = parcel.readHashMap(Map.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            DownloadRequest downloadRequest = (DownloadRequest) obj;
            if (Objects.equals(this.f7955a, downloadRequest.f7955a) && Objects.equals(this.b, downloadRequest.b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.f7955a, this.b);
    }

    public String toString() {
        return "DownloadRequest{url='" + this.f7955a + "', dirPath='" + this.b + "', fileName='" + this.c + "', priority=" + this.d + ", md5='" + this.e + "', downloadId=" + this.f + ", autoRetry=" + this.g + ", downloadIfExist=" + this.h + ", allowMobileDownload=" + this.i + ", headerMap=" + this.j + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7955a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeInt(this.d);
        parcel.writeString(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.h ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
        parcel.writeMap(this.j);
    }

    private DownloadRequest(a aVar) {
        this.f7955a = aVar.b;
        this.b = aVar.c;
        this.c = aVar.d;
        this.d = aVar.e;
        this.e = aVar.f;
        this.g = aVar.f7956a;
        this.h = aVar.h;
        this.f = aVar.g;
        this.i = aVar.i;
        this.j = aVar.j;
    }
}
