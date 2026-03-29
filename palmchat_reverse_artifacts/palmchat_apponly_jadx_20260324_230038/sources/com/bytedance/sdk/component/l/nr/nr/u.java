package com.bytedance.sdk.component.l.nr.nr;

import android.content.Context;
import com.bykv.vk.component.ttvideo.DataLoaderHelper;
import com.bykv.vk.component.ttvideo.IPreLoaderItemCallBackListener;
import com.bykv.vk.component.ttvideo.PreLoaderItemCallBackInfo;
import com.bykv.vk.component.ttvideo.PreloaderURLItem;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.bykv.vk.openvk.component.video.api.fx.iz;
import com.bykv.vk.openvk.component.video.api.pn.u;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements com.bykv.vk.openvk.component.video.api.pn.u {
    public static volatile int b;
    public static volatile int fx;
    public static volatile int nr;
    private static Object pn = new Object();
    public static volatile int u;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0020 A[PHI: r0
      0x0020: PHI (r0v2 long) = (r0v1 long), (r0v5 long) binds: [B:6:0x0013, B:8:0x001c] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.bykv.vk.openvk.component.video.api.pn.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u(Context context, final iz izVar, final u.InterfaceC0155u interfaceC0155u) {
        long j;
        long jIz = izVar.iz();
        if (izVar.mv()) {
            jIz = 2147483647L;
        }
        int iNr = izVar.nr();
        if (iNr > 0) {
            jIz = iNr;
            j = jIz >= izVar.l() ? 2147483647L : jIz;
        }
        DataLoaderHelper.DataLoaderCacheInfo cacheInfoByFilePath = TTVideoEngine.getCacheInfoByFilePath(izVar.o(), izVar.pn());
        int i = 0;
        if (cacheInfoByFilePath != null && (j != 2147483647L ? cacheInfoByFilePath.mCacheSizeFromZero >= j : !(cacheInfoByFilePath.mCacheSizeFromZero < izVar.l() && cacheInfoByFilePath.mCacheSizeFromZero < cacheInfoByFilePath.mMediaSize))) {
            i = 1;
        }
        izVar.a(i);
        PreloaderURLItem preloaderURLItem = new PreloaderURLItem(izVar.o(), null, j, new String[]{izVar.my()}, izVar.pn());
        preloaderURLItem.setCallBackListener(new IPreLoaderItemCallBackListener() { // from class: com.bytedance.sdk.component.l.nr.nr.u.1
            @Override // com.bykv.vk.component.ttvideo.IPreLoaderItemCallBackListener
            public void preloadItemInfo(PreLoaderItemCallBackInfo preLoaderItemCallBackInfo) {
                synchronized (u.pn) {
                    if (preLoaderItemCallBackInfo == null) {
                        return;
                    }
                    int key = preLoaderItemCallBackInfo.getKey();
                    izVar.o();
                    if (key == 2) {
                        u.InterfaceC0155u interfaceC0155u2 = interfaceC0155u;
                        if (interfaceC0155u2 != null) {
                            interfaceC0155u2.u(izVar, preLoaderItemCallBackInfo.getKey());
                        }
                        u.nr++;
                    } else if (key == 3) {
                        u.InterfaceC0155u interfaceC0155u3 = interfaceC0155u;
                        if (interfaceC0155u3 != null) {
                            interfaceC0155u3.u(izVar, preLoaderItemCallBackInfo.getKey(), "error");
                        }
                        u.fx++;
                    } else if (key == 5) {
                        u.InterfaceC0155u interfaceC0155u4 = interfaceC0155u;
                        if (interfaceC0155u4 != null) {
                            interfaceC0155u4.nr(izVar, preLoaderItemCallBackInfo.getKey());
                        }
                        u.b++;
                    }
                    int i2 = u.u;
                    int i3 = u.u;
                    int i4 = u.u;
                    int i5 = u.u;
                    int i6 = u.u;
                    int i7 = u.u;
                    int i8 = u.u;
                }
            }
        });
        izVar.o();
        izVar.my();
        izVar.s();
        izVar.iz();
        izVar.pn();
        synchronized (pn) {
            u++;
        }
        TTVideoEngine.addTask(preloaderURLItem);
        izVar.o();
    }
}
