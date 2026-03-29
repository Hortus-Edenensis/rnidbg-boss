package com.baidu.mapapi.map;

import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class TextOptions extends OverlayOptions {
    public static final int ALIGN_BOTTOM = 16;
    public static final int ALIGN_CENTER_HORIZONTAL = 4;
    public static final int ALIGN_CENTER_VERTICAL = 32;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;
    public static final int ALIGN_TOP = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3690a;
    private LatLng b;
    private int c;
    private float k;
    boolean m;
    Point s;
    int u;
    Bundle w;
    private int d = -16777216;
    private int e = 12;
    private Typeface f = Typeface.DEFAULT;
    private float g = 0.5f;
    private float h = 0.5f;
    private int i = 4;
    private int j = 32;
    private boolean l = true;
    int n = 0;
    int o = 0;
    float p = 1.0f;
    float q = 1.0f;
    int r = Integer.MAX_VALUE;
    boolean t = false;
    boolean v = true;

    public TextOptions align(int i, int i2) {
        this.i = i;
        this.j = i2;
        return this;
    }

    public TextOptions anchor(float f, float f2) {
        if (f >= 0.0f && f <= 1.0f && f2 >= 0.0f && f2 <= 1.0f) {
            this.g = f;
            this.h = f2;
        }
        return this;
    }

    public TextOptions bgColor(int i) {
        this.c = i;
        return this;
    }

    public TextOptions extraInfo(Bundle bundle) {
        this.w = bundle;
        return this;
    }

    public TextOptions fixedScreenPosition(Point point) {
        this.s = point;
        this.t = true;
        return this;
    }

    public TextOptions fontColor(int i) {
        this.d = i;
        return this;
    }

    public TextOptions fontSize(int i) {
        this.e = i;
        return this;
    }

    public float getAlignX() {
        return this.i;
    }

    public float getAlignY() {
        return this.j;
    }

    public int getBgColor() {
        return this.c;
    }

    public Bundle getExtraInfo() {
        return this.w;
    }

    public int getFontColor() {
        return this.d;
    }

    public int getFontSize() {
        return this.e;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        Text text = new Text();
        text.d = this.v;
        text.c = this.u;
        text.e = this.w;
        text.i = this.f3690a;
        text.j = this.b;
        text.k = this.c;
        text.l = this.d;
        text.m = this.e;
        text.n = this.f;
        text.r = this.i;
        text.s = this.j;
        text.q = this.h;
        text.p = this.g;
        text.t = this.k;
        text.v = this.l;
        text.y = this.m;
        text.A = this.o;
        text.z = this.n;
        text.B = this.p;
        text.C = this.q;
        text.E = this.r;
        boolean z = this.t;
        text.G = z;
        if (z) {
            text.F = this.s;
        }
        return text;
    }

    public LatLng getPosition() {
        return this.b;
    }

    public int getPriority() {
        return this.r;
    }

    public float getRotate() {
        return this.k;
    }

    public String getText() {
        return this.f3690a;
    }

    public Typeface getTypeface() {
        return this.f;
    }

    public int getZIndex() {
        return this.u;
    }

    public boolean isPerspective() {
        return this.m;
    }

    public boolean isVisible() {
        return this.v;
    }

    public TextOptions perspective(boolean z) {
        this.m = z;
        return this;
    }

    public TextOptions position(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: position can not be null");
        }
        this.b = latLng;
        return this;
    }

    public TextOptions priority(int i) {
        this.r = i;
        return this;
    }

    public TextOptions rotate(float f) {
        this.k = f;
        return this;
    }

    public TextOptions scaleX(float f) {
        if (f < 0.0f) {
            return this;
        }
        this.p = f;
        return this;
    }

    public TextOptions scaleY(float f) {
        if (f < 0.0f) {
            return this;
        }
        this.q = f;
        return this;
    }

    public TextOptions setClickable(boolean z) {
        this.l = z;
        return this;
    }

    public TextOptions text(String str) {
        if (str == null || str.equals("")) {
            throw new IllegalArgumentException("BDMapSDKException: text can not be null or empty");
        }
        this.f3690a = str;
        return this;
    }

    public TextOptions typeface(Typeface typeface) {
        this.f = typeface;
        return this;
    }

    public TextOptions visible(boolean z) {
        this.v = z;
        return this;
    }

    public TextOptions xOffset(int i) {
        this.o = i;
        return this;
    }

    public TextOptions yOffset(int i) {
        this.n = i;
        return this;
    }

    public TextOptions zIndex(int i) {
        this.u = i;
        return this;
    }
}
