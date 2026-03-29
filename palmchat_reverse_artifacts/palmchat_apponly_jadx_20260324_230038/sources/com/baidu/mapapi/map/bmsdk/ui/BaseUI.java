package com.baidu.mapapi.map.bmsdk.ui;

import com.baidu.platform.comapi.bmsdk.ui.BmBaseUI;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class BaseUI {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BmBaseUI f3724a;
    private String b;
    protected onBaseUIListener listener;

    /* JADX INFO: compiled from: SearchBox */
    public interface onBaseUIListener {
        void onBaseUIRemove(BaseUI baseUI);

        void onBaseUIUpdate(BaseUI baseUI);
    }

    public BmBaseUI getBmBaseUI() {
        return this.f3724a;
    }

    public String getClickAction() {
        return this.b;
    }

    public void remove() {
        onBaseUIListener onbaseuilistener = this.listener;
        if (onbaseuilistener != null) {
            onbaseuilistener.onBaseUIRemove(this);
        }
    }

    public void setClickAction(String str) {
        this.b = str;
    }

    public void setListener(onBaseUIListener onbaseuilistener) {
        this.listener = onbaseuilistener;
    }
}
