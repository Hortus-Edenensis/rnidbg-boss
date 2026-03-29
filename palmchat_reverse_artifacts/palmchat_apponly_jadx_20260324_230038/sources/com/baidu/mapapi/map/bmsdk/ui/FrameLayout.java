package com.baidu.mapapi.map.bmsdk.ui;

import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.Overlay;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import com.baidu.platform.comapi.bmsdk.ui.BmBaseUI;
import com.baidu.platform.comapi.bmsdk.ui.BmFrameLayout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class FrameLayout extends GroupUI {
    private BmFrameLayout c;

    public FrameLayout() {
        BmFrameLayout bmFrameLayout = new BmFrameLayout();
        this.c = bmFrameLayout;
        bmFrameLayout.a(this);
    }

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

    public void setGravity(int i) {
        this.c.e(i);
    }

    public void setMargin(int i, int i2, int i3, int i4) {
        this.c.a(i, i2, i3, i4);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.c.b(i, i2, i3, i4);
    }

    public void updateAddView(BaseUI baseUI, Overlay overlay) {
        if (baseUI == null || overlay == null || overlay.getBmLayer() == null) {
            return;
        }
        this.c.a(baseUI.getBmBaseUI());
        overlay.getBmLayer().b();
    }

    public void updateBackground(BitmapDescriptor bitmapDescriptor, Overlay overlay) {
        if (bitmapDescriptor == null || overlay == null || overlay.getBmLayer() == null) {
            return;
        }
        this.c.a(new BmBitmapResource(bitmapDescriptor.getBitmap()));
        overlay.getBmLayer().b();
    }

    public void updateBackgroundColor(int i, Overlay overlay) {
        if (overlay == null || overlay.getBmLayer() == null) {
            return;
        }
        this.c.b(i);
        overlay.getBmLayer().b();
    }

    public void updateClickable(boolean z, Overlay overlay) {
        if (overlay == null || overlay.getBmLayer() == null) {
            return;
        }
        this.c.a(z);
        overlay.getBmLayer().b();
    }

    public void updateGravity(int i, Overlay overlay) {
        if (overlay == null || overlay.getBmLayer() == null) {
            return;
        }
        this.c.e(i);
        overlay.getBmLayer().b();
    }
}
