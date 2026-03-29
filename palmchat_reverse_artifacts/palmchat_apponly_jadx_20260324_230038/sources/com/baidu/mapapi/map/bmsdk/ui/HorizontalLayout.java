package com.baidu.mapapi.map.bmsdk.ui;

import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import com.baidu.platform.comapi.bmsdk.ui.BmBaseUI;
import com.baidu.platform.comapi.bmsdk.ui.BmHorizontalLayout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class HorizontalLayout extends GroupUI {
    private final BmHorizontalLayout c = new BmHorizontalLayout();

    @Override // com.baidu.mapapi.map.bmsdk.ui.GroupUI
    public void addView(BaseUI baseUI) {
        if (baseUI == null) {
            return;
        }
        this.c.a(baseUI.getBmBaseUI());
    }

    @Override // com.baidu.mapapi.map.bmsdk.ui.GroupUI, com.baidu.mapapi.map.bmsdk.ui.BaseUI
    public BmBaseUI getBmBaseUI() {
        return this.c;
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

    public void setMargin(int i, int i2, int i3, int i4) {
        this.c.a(i, i2, i3, i4);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.c.b(i, i2, i3, i4);
    }
}
