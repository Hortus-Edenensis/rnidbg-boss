package com.getui.gtc.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.getui.gtc.entity.a;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class SdkInfo implements Parcelable {
    public static final Parcelable.Creator<SdkInfo> CREATOR = new Parcelable.Creator<SdkInfo>() { // from class: com.getui.gtc.api.SdkInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SdkInfo createFromParcel(Parcel parcel) {
            return new SdkInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SdkInfo[] newArray(int i) {
            return new SdkInfo[i];
        }
    };
    private String appid;
    private String cid;
    private String moduleName;
    private String psUrl;
    private List<a.C0343a> stubs;
    private String version;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {
        private String appid;
        private String cid;
        private String moduleName;
        private String psUrl;
        private List<a.C0343a> stubs = new ArrayList();
        private String version;

        public Builder addStub(String str, boolean z) {
            a.C0343a c0343a = new a.C0343a();
            c0343a.d = str;
            c0343a.j = z;
            this.stubs.add(c0343a);
            return this;
        }

        public Builder appid(String str) {
            this.appid = str;
            return this;
        }

        public SdkInfo build() {
            return new SdkInfo(this);
        }

        public Builder cid(String str) {
            this.cid = str;
            return this;
        }

        public Builder moduleName(String str) {
            this.moduleName = str;
            return this;
        }

        public Builder psUrl(String str) {
            this.psUrl = str;
            return this;
        }

        public Builder version(String str) {
            this.version = str;
            return this;
        }
    }

    public SdkInfo(Parcel parcel) {
        this.moduleName = parcel.readString();
        this.version = parcel.readString();
        this.appid = parcel.readString();
        this.cid = parcel.readString();
        this.psUrl = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.stubs = arrayList;
        parcel.readTypedList(arrayList, a.C0343a.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAppid() {
        return this.appid;
    }

    public String getCid() {
        return this.cid;
    }

    public String getModuleName() {
        return this.moduleName;
    }

    public String getPsUrl() {
        return this.psUrl;
    }

    public List<a.C0343a> getStubs() {
        return this.stubs;
    }

    public String getVersion() {
        return this.version;
    }

    public void setAppid(String str) {
        this.appid = str;
    }

    public void setCid(String str) {
        this.cid = str;
    }

    public void setModuleName(String str) {
        this.moduleName = str;
    }

    public void setPsUrl(String str) {
        this.psUrl = str;
    }

    public void setStubs(List<a.C0343a> list) {
        this.stubs = list;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.moduleName);
        parcel.writeString(this.version);
        parcel.writeString(this.appid);
        parcel.writeString(this.cid);
        parcel.writeString(this.psUrl);
        parcel.writeTypedList(this.stubs);
    }

    public SdkInfo(Builder builder) {
        this.moduleName = builder.moduleName;
        this.version = builder.version;
        this.appid = builder.appid;
        this.cid = builder.cid;
        this.psUrl = builder.psUrl;
        ArrayList arrayList = new ArrayList();
        this.stubs = arrayList;
        arrayList.addAll(builder.stubs);
    }
}
