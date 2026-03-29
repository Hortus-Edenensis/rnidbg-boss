package com.vivo.push.d.a;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.vivo.push.restructure.request.a.a.b;
import com.vivo.push.util.t;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class c implements b.a<b> {
    private static b b(com.vivo.push.restructure.request.a.a.a aVar) {
        try {
            return new b(aVar);
        } catch (Exception e) {
            t.a(AVMDLDataLoader.KeyIsLiveLoaderP2pEnable, e.getMessage());
            return null;
        }
    }

    @Override // com.vivo.push.restructure.request.a.a.b.a
    public final /* synthetic */ b a(com.vivo.push.restructure.request.a.a.a aVar) {
        return b(aVar);
    }
}
