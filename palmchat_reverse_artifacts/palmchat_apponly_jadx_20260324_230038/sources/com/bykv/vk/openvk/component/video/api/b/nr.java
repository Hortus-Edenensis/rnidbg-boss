package com.bykv.vk.openvk.component.video.api.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public interface nr<T> extends com.bykv.vk.openvk.component.video.api.nr.u {

    /* JADX INFO: compiled from: SearchBox */
    public enum u {
        hideCloseBtn,
        alwayShowBackBtn,
        alwayShowMediaView,
        fixedSize,
        hideBackBtn,
        hideTopMoreBtn
    }

    View fx();

    void nr();

    void u();

    void u(int i);

    void u(Drawable drawable);

    void u(T t, WeakReference<Context> weakReference, boolean z);

    void u(boolean z);
}
