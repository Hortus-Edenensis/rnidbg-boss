package com.ss.bytertc.engine.live;

import com.bytedance.realx.base.CalledByNative;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class PushSingleStreamToCDNObserver {
    private Map<String, IPushSingleStreamToCDNObserver> mPushSingleStreamToCDNObserver = new HashMap();

    @CalledByNative
    public void onStreamPushEvent(ByteRTCStreamSinglePushEvent byteRTCStreamSinglePushEvent, String str, int i) {
        IPushSingleStreamToCDNObserver iPushSingleStreamToCDNObserver;
        Map<String, IPushSingleStreamToCDNObserver> map = this.mPushSingleStreamToCDNObserver;
        if (map == null || !map.containsKey(str) || (iPushSingleStreamToCDNObserver = this.mPushSingleStreamToCDNObserver.get(str)) == null) {
            return;
        }
        iPushSingleStreamToCDNObserver.onStreamPushEvent(byteRTCStreamSinglePushEvent, str, i);
    }

    public void setUserObserver(String str, IPushSingleStreamToCDNObserver iPushSingleStreamToCDNObserver) {
        if (this.mPushSingleStreamToCDNObserver == null) {
            this.mPushSingleStreamToCDNObserver = new HashMap();
        }
        if (iPushSingleStreamToCDNObserver == null || str == null) {
            return;
        }
        this.mPushSingleStreamToCDNObserver.put(str, iPushSingleStreamToCDNObserver);
    }
}
