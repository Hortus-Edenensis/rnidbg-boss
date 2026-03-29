package com.huawei.hms.ads;

import android.view.View;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface lv extends gc, gl, me {
    void B();

    boolean C();

    void Code(int i);

    void Code(int i, int i2);

    void Code(int i, int i2, int i3);

    void Code(View view, Integer num);

    void Code(hb hbVar);

    void D();

    void F();

    void I(int i);

    void V();

    void Z();

    ft getAdMediator();

    void setAdContent(AdContentData adContentData);

    void setAdMediator(ft ftVar);

    void setAudioFocusType(int i);
}
