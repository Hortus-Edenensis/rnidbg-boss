package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class IntegralRouteResult extends SearchResult {
    public static final Parcelable.Creator<IntegralRouteResult> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<WalkingRouteLine> f3804a;
    private List<IndoorRouteLine> b;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Parcelable.Creator<IntegralRouteResult> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public IntegralRouteResult createFromParcel(Parcel parcel) {
            return new IntegralRouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public IntegralRouteResult[] newArray(int i) {
            return new IntegralRouteResult[i];
        }
    }

    public IntegralRouteResult() {
    }

    public List<IndoorRouteLine> getIndoorRouteLines() {
        return this.b;
    }

    public List<WalkingRouteLine> getRouteLines() {
        return this.f3804a;
    }

    public void setIndoorRouteLines(List<IndoorRouteLine> list) {
        this.b = list;
    }

    public void setRouteLines(List<WalkingRouteLine> list) {
        this.f3804a = list;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeList(this.f3804a);
        parcel.writeTypedList(this.b);
    }

    public IntegralRouteResult(Parcel parcel) {
        super(parcel);
        ArrayList arrayList = new ArrayList();
        this.f3804a = arrayList;
        parcel.readList(arrayList, WalkingRouteLine.class.getClassLoader());
        ArrayList arrayList2 = new ArrayList();
        this.b = arrayList2;
        parcel.readList(arrayList2, IndoorRouteLine.class.getClassLoader());
    }
}
