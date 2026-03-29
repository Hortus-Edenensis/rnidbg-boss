package com.opos.mobad.ad;

import android.app.Activity;
import com.opos.mobad.ad.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public interface m extends com.opos.mobad.ad.b {

    /* JADX INFO: compiled from: SearchBox */
    public interface a extends b.a, b {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void onAdClick(long j);

        void onAdShow(String str);
    }

    void a(Activity activity);
}
