package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public interface SysUpdateObserver {
    void init(String str);

    void updateCuid(String str);

    void updateNetworkInfo(Context context);

    void updateNetworkProxy(Context context);

    void updatePhoneInfo(String str);

    void updateZid(String str);
}
