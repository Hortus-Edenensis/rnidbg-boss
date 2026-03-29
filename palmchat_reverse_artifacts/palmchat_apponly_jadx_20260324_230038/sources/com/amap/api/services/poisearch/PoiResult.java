package com.amap.api.services.poisearch;

import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.poisearch.PoiSearch;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class PoiResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3177a;
    private ArrayList<PoiItem> b;
    private PoiSearch.Query c;
    private PoiSearch.SearchBound d;
    private List<String> e;
    private List<SuggestionCity> f;
    private int g;

    private PoiResult(PoiSearch.Query query, PoiSearch.SearchBound searchBound, List<String> list, List<SuggestionCity> list2, int i, int i2, ArrayList<PoiItem> arrayList) {
        this.b = new ArrayList<>();
        this.c = query;
        this.d = searchBound;
        this.e = list;
        this.f = list2;
        this.g = i;
        this.f3177a = a(i2);
        this.b = arrayList;
    }

    private int a(int i) {
        return ((i + r0) - 1) / this.g;
    }

    public static PoiResult createPagedResult(PoiSearch.Query query, PoiSearch.SearchBound searchBound, List<String> list, List<SuggestionCity> list2, int i, int i2, ArrayList<PoiItem> arrayList) {
        return new PoiResult(query, searchBound, list, list2, i, i2, arrayList);
    }

    public final PoiSearch.SearchBound getBound() {
        return this.d;
    }

    public final int getPageCount() {
        return this.f3177a;
    }

    public final ArrayList<PoiItem> getPois() {
        return this.b;
    }

    public final PoiSearch.Query getQuery() {
        return this.c;
    }

    public final List<SuggestionCity> getSearchSuggestionCitys() {
        return this.f;
    }

    public final List<String> getSearchSuggestionKeywords() {
        return this.e;
    }
}
