package com.opos.mobad.activity.webview;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.mobad.ad.privacy.ComplianceInfo;
import com.opos.mobad.model.data.AdItemData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class WebDataHepler implements Parcelable {
    public static final Parcelable.Creator<WebDataHepler> CREATOR = new Parcelable.Creator<WebDataHepler>() { // from class: com.opos.mobad.activity.webview.WebDataHepler.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public WebDataHepler createFromParcel(Parcel parcel) {
            return new WebDataHepler(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public WebDataHepler[] newArray(int i) {
            return new WebDataHepler[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AdItemData f8477a;
    private String b;
    private String c;
    private String d;
    private String e;
    private int f;
    private boolean g;
    private boolean h;
    private ComplianceInfo i;
    private long j;

    public WebDataHepler(Parcel parcel) {
        this.j = -1L;
        this.f8477a = (AdItemData) parcel.readParcelable(AdItemData.class.getClassLoader());
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readInt();
        this.g = parcel.readInt() == 1;
        this.h = parcel.readInt() == 1;
        this.i = (ComplianceInfo) parcel.readParcelable(ComplianceInfo.class.getClassLoader());
        this.j = parcel.readLong();
    }

    public AdItemData a() {
        return this.f8477a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.e;
    }

    public int f() {
        return this.f;
    }

    public ComplianceInfo g() {
        return this.i;
    }

    public boolean h() {
        return this.g;
    }

    public boolean i() {
        return this.h;
    }

    public long j() {
        return this.j;
    }

    public String toString() {
        return "WebDataHepler{mPosId='" + this.b + "', mJsSign='" + this.c + "', mWebUrl='" + this.d + "', mVideoUrl='" + this.e + "', mActionType=" + this.f + ", mShowTitleBar=" + this.g + ", mFitsSystemWindows=" + this.h + ", mCurVideoPosition=" + this.j + ", mAdItemData=" + this.f8477a + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f8477a, i);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g ? 1 : 0);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeParcelable(this.i, i);
        parcel.writeLong(this.j);
    }

    public WebDataHepler(ComplianceInfo complianceInfo, int i) {
        this.j = -1L;
        this.i = complianceInfo;
        this.f = i;
    }

    public WebDataHepler(AdItemData adItemData, String str, String str2, String str3, String str4, int i) {
        this(adItemData, str, str2, str3, str4, i, true, true);
    }

    public WebDataHepler(AdItemData adItemData, String str, String str2, String str3, String str4, int i, boolean z, boolean z2) {
        this(adItemData, str, str2, str3, str4, i, z, z2, -1L);
    }

    public WebDataHepler(AdItemData adItemData, String str, String str2, String str3, String str4, int i, boolean z, boolean z2, long j) {
        this.f8477a = adItemData;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = i;
        this.g = z;
        this.h = z2;
        this.j = j;
    }
}
