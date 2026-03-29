package com.heytap.msp.mobad.api.params;

import android.content.Context;
import com.heytap.msp.mobad.api.listener.INativeAdvanceMediaListener;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class BaseNativeAdvanceData implements INativeAdvanceData {
    protected int widthRate = 0;
    protected int heightRate = 0;

    @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
    public void bindMediaView(Context context, MediaView mediaView, INativeAdvanceMediaListener iNativeAdvanceMediaListener) {
        int i = this.widthRate;
        int i2 = this.heightRate;
        if (i * i2 > 0) {
            mediaView.setWidthHeightRate(i, i2);
        }
    }
}
