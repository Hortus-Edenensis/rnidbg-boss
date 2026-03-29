package com.baidu.platform.comapi.bmsdk.ui;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class BmGroupUI extends BmBaseUI {
    private ArrayList<BmBaseUI> g;

    private BmGroupUI() {
        super(32, 0L);
        this.g = new ArrayList<>();
    }

    private static native boolean nativeAddView(long j, long j2, int i);

    private static native boolean nativeRemoveAllViews(long j);

    @Override // com.baidu.platform.comapi.bmsdk.ui.BmBaseUI
    public BmBaseUI a(long j) {
        if (this.nativeInstance == j) {
            return this;
        }
        Iterator<BmBaseUI> it = this.g.iterator();
        while (it.hasNext()) {
            BmBaseUI bmBaseUIA = it.next().a(j);
            if (bmBaseUIA != null) {
                return bmBaseUIA;
            }
        }
        return null;
    }

    public BmGroupUI(int i, long j) {
        super(i, j);
        this.g = new ArrayList<>();
    }

    public boolean a(BmBaseUI bmBaseUI) {
        return a(bmBaseUI, -1);
    }

    public boolean a(BmBaseUI bmBaseUI, int i) {
        if (bmBaseUI == null) {
            return false;
        }
        if (i >= 0 && i < this.g.size()) {
            this.g.add(i, bmBaseUI);
        } else {
            this.g.add(bmBaseUI);
        }
        return nativeAddView(getNativeInstance(), bmBaseUI.getNativeInstance(), i);
    }
}
