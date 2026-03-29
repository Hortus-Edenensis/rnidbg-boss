package com.amap.api.maps2d.model;

import android.graphics.Typeface;
import com.amap.api.col.p0002sl.as;
import com.amap.api.interfaces.IText;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class Text {
    public static final int ALIGN_BOTTOM = 5;
    public static final int ALIGN_CENTER_HORIZONTAL = 3;
    public static final int ALIGN_CENTER_VERTICAL = 6;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;
    public static final int ALIGN_TOP = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IText f3112a;

    public Text(as asVar) {
        this.f3112a = asVar;
    }

    public final int getAlignX() {
        return this.f3112a.getAlignX();
    }

    public final int getAlignY() {
        return this.f3112a.getAlignY();
    }

    public final int getBackgroundColor() {
        return this.f3112a.getBackgroundColor();
    }

    public final int getFontColor() {
        return this.f3112a.getFonrColor();
    }

    public final int getFontSize() {
        return this.f3112a.getFontSize();
    }

    public final Object getObject() {
        return this.f3112a.getObject();
    }

    public final LatLng getPosition() {
        return this.f3112a.getPosition();
    }

    public final float getRotate() {
        return this.f3112a.getRotate();
    }

    public final String getText() {
        return this.f3112a.getText();
    }

    public final Typeface getTypeface() {
        return this.f3112a.getTypeface();
    }

    public final float getZIndex() {
        return this.f3112a.getZIndex();
    }

    public final boolean isVisible() {
        return this.f3112a.isVisible();
    }

    public final void remove() {
        this.f3112a.remove();
    }

    public final void setAlign(int i, int i2) {
        this.f3112a.setAlign(i, i2);
    }

    public final void setBackgroundColor(int i) {
        this.f3112a.setBackgroundColor(i);
    }

    public final void setFontColor(int i) {
        this.f3112a.setFontColor(i);
    }

    public final void setFontSize(int i) {
        this.f3112a.setFontSize(i);
    }

    public final void setObject(Object obj) {
        this.f3112a.setObject(obj);
    }

    public final void setPosition(LatLng latLng) {
        this.f3112a.setPosition(latLng);
    }

    public final void setRotate(float f) {
        this.f3112a.setRotate(f);
    }

    public final void setText(String str) {
        this.f3112a.setText(str);
    }

    public final void setTypeface(Typeface typeface) {
        this.f3112a.setTypeface(typeface);
    }

    public final void setVisible(boolean z) {
        this.f3112a.setVisible(z);
    }

    public final void setZIndex(float f) {
        this.f3112a.setZIndex(f);
    }
}
