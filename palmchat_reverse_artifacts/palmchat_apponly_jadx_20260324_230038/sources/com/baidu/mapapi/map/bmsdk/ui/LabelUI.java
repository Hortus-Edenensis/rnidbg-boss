package com.baidu.mapapi.map.bmsdk.ui;

import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.TextStyle;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import com.baidu.platform.comapi.bmsdk.ui.BmBaseUI;
import com.baidu.platform.comapi.bmsdk.ui.BmLabelUI;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class LabelUI extends BaseUI {
    private BmLabelUI c;
    private TextStyle d;

    public LabelUI() {
        BmLabelUI bmLabelUI = new BmLabelUI();
        this.c = bmLabelUI;
        bmLabelUI.a(this);
    }

    @Override // com.baidu.mapapi.map.bmsdk.ui.BaseUI
    public BmBaseUI getBmBaseUI() {
        return this.c;
    }

    public TextStyle getStyle() {
        return this.d;
    }

    public String getText() {
        return this.c.b();
    }

    public void setBackground(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            return;
        }
        this.c.a(new BmBitmapResource(bitmapDescriptor.getBitmap()));
    }

    public void setBackgroundColor(int i) {
        this.c.b(i);
    }

    public void setClickable(boolean z) {
        this.c.a(z);
    }

    public void setGravity(UIGravity uIGravity) {
        this.c.e(uIGravity.getNumber());
    }

    public void setHeight(int i) {
        this.c.f(i);
    }

    public void setMargin(int i, int i2, int i3, int i4) {
        this.c.a(i, i2, i3, i4);
    }

    public void setMaxLines(int i) {
        this.c.j(i);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.c.b(i, i2, i3, i4);
    }

    public void setText(String str) {
        this.c.b(str);
    }

    public void setTextStyle(TextStyle textStyle) {
        if (textStyle != null) {
            this.d = textStyle;
            this.c.a(textStyle.getBmTextStyle());
        }
    }

    public void setWidth(int i) {
        this.c.i(i);
    }
}
