package com.baidu.mapapi.search.aoi;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.AoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.igexin.push.core.b;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class AoiResult extends SearchResult {
    public static final Parcelable.Creator<AoiResult> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<AoiInfo> f3748a;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Parcelable.Creator<AoiResult> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AoiResult createFromParcel(Parcel parcel) {
            return new AoiResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AoiResult[] newArray(int i) {
            return new AoiResult[i];
        }
    }

    public AoiResult() {
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<AoiInfo> getAoiList() {
        return this.f3748a;
    }

    public void setAoiList(List<AoiInfo> list) {
        this.f3748a = list;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("AoiResult: ");
        List<AoiInfo> list = this.f3748a;
        if (list == null || list.isEmpty()) {
            stringBuffer.append(b.m);
        } else {
            for (int i = 0; i < this.f3748a.size(); i++) {
                stringBuffer.append(" ");
                stringBuffer.append(i);
                stringBuffer.append(" ");
                AoiInfo aoiInfo = this.f3748a.get(i);
                if (aoiInfo == null) {
                    stringBuffer.append(b.m);
                } else {
                    stringBuffer.append(aoiInfo.toString());
                }
            }
        }
        return stringBuffer.toString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f3748a);
    }

    public AoiResult(Parcel parcel) {
        this.f3748a = parcel.createTypedArrayList(AoiInfo.CREATOR);
    }
}
