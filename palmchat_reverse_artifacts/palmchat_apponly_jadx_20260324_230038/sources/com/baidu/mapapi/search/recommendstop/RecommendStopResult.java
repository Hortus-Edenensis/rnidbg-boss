package com.baidu.mapapi.search.recommendstop;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.RecommendStationStopInfo;
import com.baidu.mapapi.search.core.RecommendStopInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.igexin.push.core.b;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class RecommendStopResult extends SearchResult {
    public static final Parcelable.Creator<RecommendStopResult> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<RecommendStopInfo> f3793a;
    private List<RecommendStationStopInfo> b;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Parcelable.Creator<RecommendStopResult> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RecommendStopResult createFromParcel(Parcel parcel) {
            return new RecommendStopResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RecommendStopResult[] newArray(int i) {
            return new RecommendStopResult[i];
        }
    }

    public RecommendStopResult() {
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<RecommendStopInfo> getRecommendStopInfoList() {
        return this.f3793a;
    }

    public List<RecommendStationStopInfo> getStationInfoList() {
        return this.b;
    }

    public void setRecommendStopInfoList(List<RecommendStopInfo> list) {
        this.f3793a = list;
    }

    public void setStationInfoList(List<RecommendStationStopInfo> list) {
        this.b = list;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("RecommendStopResult: ");
        List<RecommendStopInfo> list = this.f3793a;
        if (list == null || list.isEmpty()) {
            stringBuffer.append(b.m);
        } else {
            for (int i = 0; i < this.f3793a.size(); i++) {
                stringBuffer.append(" ");
                stringBuffer.append(i);
                stringBuffer.append(" ");
                RecommendStopInfo recommendStopInfo = this.f3793a.get(i);
                if (recommendStopInfo == null) {
                    stringBuffer.append(b.m);
                } else {
                    stringBuffer.append(recommendStopInfo.toString());
                }
            }
        }
        return stringBuffer.toString();
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f3793a);
    }

    public RecommendStopResult(Parcel parcel) {
        super(parcel);
        this.f3793a = parcel.createTypedArrayList(RecommendStopInfo.CREATOR);
    }
}
