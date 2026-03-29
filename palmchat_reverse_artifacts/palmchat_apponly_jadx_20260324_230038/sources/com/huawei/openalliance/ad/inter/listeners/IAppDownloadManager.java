package com.huawei.openalliance.ad.inter.listeners;

import android.content.Context;
import android.view.View;
import com.huawei.openalliance.ad.download.app.AppStatus;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@com.huawei.openalliance.ad.annotations.b
public interface IAppDownloadManager {
    public static final int I = 0;
    public static final int V = 100;

    int B(Context context, com.huawei.openalliance.ad.inter.data.d dVar);

    void C(Context context, com.huawei.openalliance.ad.inter.data.d dVar);

    int Code(Context context, View view, com.huawei.openalliance.ad.inter.data.d dVar);

    int Code(Context context, com.huawei.openalliance.ad.inter.data.d dVar);

    void Code(int i);

    void Code(Integer num);

    void Code(boolean z);

    int F(Context context, com.huawei.openalliance.ad.inter.data.d dVar);

    AppStatus S(Context context, com.huawei.openalliance.ad.inter.data.d dVar);

    int Z(Context context, com.huawei.openalliance.ad.inter.data.d dVar);
}
