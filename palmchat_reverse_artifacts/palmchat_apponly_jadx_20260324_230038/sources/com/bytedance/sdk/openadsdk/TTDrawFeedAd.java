package com.bytedance.sdk.openadsdk;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public interface TTDrawFeedAd extends TTFeedAd {

    /* JADX INFO: compiled from: SearchBox */
    public interface DrawVideoListener {
        void onClick();

        void onClickRetry();
    }

    void setCanInterruptVideoPlay(boolean z);

    void setDrawVideoListener(DrawVideoListener drawVideoListener);

    void setPauseIcon(Bitmap bitmap, int i);
}
