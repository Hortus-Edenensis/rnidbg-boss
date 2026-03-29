package com.wifi.ad.core.spstrategy;

import android.os.Handler;
import android.os.Looper;
import com.wifi.ad.core.utils.WifiLog;
import java.util.TimerTask;
import kotlin.Metadata;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/wifi/ad/core/spstrategy/SPOneGroupLoadAd$requestGroupAds$task$1", "Ljava/util/TimerTask;", "run", "", "core_release"}, k = 1, mv = {1, 1, 16})
public final class SPOneGroupLoadAd$requestGroupAds$task$1 extends TimerTask {
    final /* synthetic */ SPOneGroupLoadAd this$0;

    public SPOneGroupLoadAd$requestGroupAds$task$1(SPOneGroupLoadAd sPOneGroupLoadAd) {
        this.this$0 = sPOneGroupLoadAd;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (WifiLog.isDebugMode) {
            WifiLog.d(this.this$0.groupTimeOutRequestId + " scene:" + this.this$0.groupTimeOutSceneId + " SPAD groupTimeoutRunnable start");
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.wifi.ad.core.spstrategy.SPOneGroupLoadAd$requestGroupAds$task$1$run$1
            @Override // java.lang.Runnable
            public final void run() throws JSONException {
                SPOneGroupLoadAd sPOneGroupLoadAd = this.this$0.this$0;
                sPOneGroupLoadAd.checkAllowCall(sPOneGroupLoadAd.groupTimeOutRequestId, this.this$0.this$0.groupTimeOutSceneId, false);
            }
        });
    }
}
