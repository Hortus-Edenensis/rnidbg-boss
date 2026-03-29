package com.amap.api.services.poisearch;

import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.poisearch.PoiSearchV2;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class PoiResultV2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3178a;
    private ArrayList<PoiItemV2> b;
    private PoiSearchV2.Query c;
    private PoiSearchV2.SearchBound d;

    private PoiResultV2(PoiSearchV2.Query query, PoiSearchV2.SearchBound searchBound, int i, ArrayList<PoiItemV2> arrayList) {
        new ArrayList();
        this.c = query;
        this.d = searchBound;
        this.f3178a = i;
        this.b = arrayList;
    }

    public static PoiResultV2 createPagedResult(PoiSearchV2.Query query, PoiSearchV2.SearchBound searchBound, int i, ArrayList<PoiItemV2> arrayList) {
        return new PoiResultV2(query, searchBound, i, arrayList);
    }

    public PoiSearchV2.SearchBound getBound() {
        return this.d;
    }

    public int getCount() {
        return this.f3178a;
    }

    public ArrayList<PoiItemV2> getPois() {
        return this.b;
    }

    public PoiSearchV2.Query getQuery() {
        return this.c;
    }
}
