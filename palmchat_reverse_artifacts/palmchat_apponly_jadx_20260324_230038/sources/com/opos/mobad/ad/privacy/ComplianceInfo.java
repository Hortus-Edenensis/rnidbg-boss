package com.opos.mobad.ad.privacy;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class ComplianceInfo implements Parcelable {
    public static final Parcelable.Creator<ComplianceInfo> CREATOR = new Parcelable.Creator<ComplianceInfo>() { // from class: com.opos.mobad.ad.privacy.ComplianceInfo.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ComplianceInfo createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            ComplianceInfo complianceInfo = new ComplianceInfo();
            complianceInfo.a(parcel.readString());
            complianceInfo.b(parcel.readString());
            complianceInfo.a(parcel.readHashMap(HashMap.class.getClassLoader()));
            complianceInfo.c(parcel.readString());
            return complianceInfo;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ComplianceInfo[] newArray(int i) {
            return new ComplianceInfo[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8538a;
    private String b;
    private String c;
    private Map<String, String> d;

    private ComplianceInfo() {
    }

    public String a() {
        return this.f8538a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public Map<String, String> d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ComplianceInfo{privacyUrl='" + this.f8538a + "', permissionUrl='" + this.b + "', appDescUrl='" + this.c + "', permissionMap=" + this.d + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8538a);
        parcel.writeString(this.b);
        parcel.writeMap(this.d);
        parcel.writeString(this.c);
    }

    public ComplianceInfo(String str, String str2, String str3) {
        this.f8538a = str;
        this.b = str2;
        this.c = str3;
    }

    public void a(String str) {
        this.f8538a = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.c = str;
    }

    public void a(HashMap<String, String> map) {
        this.d = map;
    }
}
