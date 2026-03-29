package com.huawei.hms.ads;

import android.content.Context;
import android.view.View;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface lt extends gc, gl {
    void B();

    void Code(int i);

    void Code(int i, int i2, String str, boolean z, Integer num);

    void Code(int i, boolean z);

    void Code(View view);

    void Code(lv lvVar, Integer num);

    void Code(mg mgVar);

    void Code(AdContentData adContentData);

    void Code(AdContentData adContentData, int i);

    void I(int i);

    boolean S();

    lv V(int i);

    Integer V(AdContentData adContentData);

    AdSlotParam getAdSlotParam();

    int getAdType();

    int getAudioFocusType();

    Context getContext();
}
