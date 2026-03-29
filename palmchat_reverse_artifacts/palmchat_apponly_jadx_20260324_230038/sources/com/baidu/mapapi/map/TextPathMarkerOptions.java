package com.baidu.mapapi.map;

import android.graphics.Typeface;
import com.baidu.mapapi.model.LatLng;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class TextPathMarkerOptions extends OverlayOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3691a;
    private int b;
    private int c;
    private int d;
    private int e;
    private Typeface f;
    private List<LatLng> g;
    int h;

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        TextPathMarker textPathMarker = new TextPathMarker();
        List<LatLng> list = this.g;
        if (list == null || list.size() < 2) {
            throw new IllegalStateException("BDMapSDKException: when you add polyline, you must at least supply 2 points");
        }
        textPathMarker.g = this.f3691a;
        textPathMarker.l = this.c;
        textPathMarker.k = this.b;
        textPathMarker.m = this.d;
        textPathMarker.n = this.e;
        textPathMarker.o = this.f;
        textPathMarker.p = this.g;
        textPathMarker.c = this.h;
        return textPathMarker;
    }

    public List<LatLng> getPoints() {
        return this.g;
    }

    public String getText() {
        return this.f3691a;
    }

    public int getTextBorderColor() {
        return this.d;
    }

    public int getTextBorderWidth() {
        return this.e;
    }

    public int getTextColor() {
        return this.b;
    }

    public Typeface getTextFontOption() {
        return this.f;
    }

    public int getTextSize() {
        return this.c;
    }

    public int getZIndex() {
        return this.h;
    }

    public TextPathMarkerOptions points(List<LatLng> list) {
        this.g = list;
        return this;
    }

    public TextPathMarkerOptions text(String str) {
        this.f3691a = str;
        return this;
    }

    public TextPathMarkerOptions textBorderColor(int i) {
        this.d = i;
        return this;
    }

    public TextPathMarkerOptions textBorderWidth(int i) {
        this.e = i;
        return this;
    }

    public TextPathMarkerOptions textColor(int i) {
        this.b = i;
        return this;
    }

    public TextPathMarkerOptions textFontOption(Typeface typeface) {
        this.f = typeface;
        return this;
    }

    public TextPathMarkerOptions textSize(int i) {
        this.c = i;
        return this;
    }

    public TextPathMarkerOptions zIndex(int i) {
        this.h = i;
        return this;
    }
}
