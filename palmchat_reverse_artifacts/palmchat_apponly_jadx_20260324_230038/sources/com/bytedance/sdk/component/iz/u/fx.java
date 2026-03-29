package com.bytedance.sdk.component.iz.u;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.sdk.component.jk.b.b;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    private static final TimeUnit u = TimeUnit.SECONDS;

    public static ExecutorService u() {
        b bVar = new b(1, 2, 30L, u, new LinkedBlockingQueue(), new u(MapController.DEFAULT_LAYER_TAG));
        bVar.allowCoreThreadTimeOut(true);
        return bVar;
    }
}
