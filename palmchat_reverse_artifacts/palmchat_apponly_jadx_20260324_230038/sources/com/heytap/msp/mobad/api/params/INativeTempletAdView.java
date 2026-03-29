package com.heytap.msp.mobad.api.params;

import android.view.View;
import com.heytap.msp.mobad.api.ad.IBidding;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface INativeTempletAdView extends IBidding {
    public static final String TAG = "INativeTempletAdView";

    void destroy();

    View getAdView();

    String getBidId();

    void render();
}
