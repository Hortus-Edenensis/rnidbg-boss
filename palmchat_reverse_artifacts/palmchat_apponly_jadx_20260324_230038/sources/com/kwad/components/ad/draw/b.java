package com.kwad.components.ad.draw;

import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.utils.bz;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class b extends com.kwad.components.core.widget.a.b {
    private View mRootView;

    public b(@NonNull View view) {
        super(view, aF());
        this.mRootView = view;
    }

    private static int aF() {
        int iHx;
        try {
            iHx = ((int) e.Hx()) * 100;
        } catch (Throwable unused) {
        }
        if (iHx < 0 || iHx > 100) {
            return 70;
        }
        return iHx;
    }

    @Override // com.kwad.components.core.widget.a.b, com.kwad.components.core.widget.a.a
    public final boolean ae() {
        return bz.a(this.mRootView, 70, true);
    }
}
