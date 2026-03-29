package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.az;
import com.huawei.hms.ads.jsb.inner.data.AppDownloadInfo;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import j$.util.DesugarCollections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class aw extends au {
    private static final String Z = "JsbOnAgReserveStatusChange";

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements com.huawei.openalliance.ad.download.f {
        private static final byte[] Code = new byte[0];
        private static a V;
        private String I;
        private Map<String, RemoteCallResultCallback<String>> Z = DesugarCollections.synchronizedMap(new az.c(5));

        private a(Context context) {
            fh.V("jsb", "ReserveStatusListener init");
            com.huawei.openalliance.ad.download.app.b.Code(context).Code(this);
        }

        public static a Code(Context context) {
            a aVar;
            synchronized (Code) {
                if (V == null) {
                    V = new a(context);
                }
                aVar = V;
            }
            return aVar;
        }

        public void Code(RemoteCallResultCallback<String> remoteCallResultCallback, String str, String str2) {
            this.Z.put(str2, remoteCallResultCallback);
            this.I = str;
        }

        @Override // com.huawei.openalliance.ad.download.f
        public void Code(String str, int i) {
            Map<String, RemoteCallResultCallback<String>> map = this.Z;
            if (map == null || map.size() <= 0) {
                return;
            }
            Iterator<RemoteCallResultCallback<String>> it = this.Z.values().iterator();
            while (it.hasNext()) {
                ah.Code(it.next(), this.I, 1000, com.huawei.openalliance.ad.utils.ad.V(new AppDownloadInfo(str, i)), false);
            }
        }
    }

    public aw() {
        super(ak.f);
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        a.Code(context).Code(remoteCallResultCallback, this.Code, this.I);
    }
}
