package defpackage;

import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.listener.DislikeListener;
import com.wifi.ad.core.spstrategy.SPCacheManager;
import com.wifi.ad.core.utils.WifiLog;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class cb1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1940a;
    public NestAdData b;
    public NestAdData c;
    public boolean d;
    public b e;
    public a f;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements NestAdData.AdInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public NestAdData.AdInteractionListener f1941a = null;

        public void a() {
            if (b6.d()) {
                this.f1941a = null;
            }
        }

        public void b(NestAdData.AdInteractionListener adInteractionListener) {
            this.f1941a = adInteractionListener;
        }

        @Override // com.wifi.ad.core.data.NestAdData.AdInteractionListener
        public void onAdClicked(NestAdData nestAdData) {
            NestAdData.AdInteractionListener adInteractionListener = this.f1941a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClicked(nestAdData);
            }
        }

        @Override // com.wifi.ad.core.data.NestAdData.AdInteractionListener
        public void onAdExposed(NestAdData nestAdData) {
            NestAdData.AdInteractionListener adInteractionListener = this.f1941a;
            if (adInteractionListener != null) {
                adInteractionListener.onAdExposed(nestAdData);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements DislikeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public DislikeListener f1942a = null;

        public void a() {
            if (b6.d()) {
                this.f1942a = null;
            }
        }

        public void b(DislikeListener dislikeListener) {
            this.f1942a = dislikeListener;
        }

        @Override // com.wifi.ad.core.listener.DislikeListener
        public void onDislikeClicked(NestAdData nestAdData, String str) {
            WifiLog.d("AdUIHelper onDislikeClicked1: " + this.f1942a);
            DislikeListener dislikeListener = this.f1942a;
            if (dislikeListener != null) {
                dislikeListener.onDislikeClicked(nestAdData, str);
            }
        }
    }

    public cb1(String str, NestAdData nestAdData, boolean z) {
        this.f1940a = str;
        this.b = nestAdData;
        this.c = nestAdData;
        this.d = z;
    }

    public NestAdData a() {
        NestAdData nestAdDataChangeCheckMaxAd;
        return (!this.b.getAdSPStrategy() || (nestAdDataChangeCheckMaxAd = SPCacheManager.INSTANCE.changeCheckMaxAd(this.b)) == null) ? this.b : nestAdDataChangeCheckMaxAd;
    }

    public void b() {
        if (b6.d()) {
            LogUtil.d("ClearAd", "clearCacheAd DetailAdDataWrapper destroy ");
            b bVar = this.e;
            if (bVar != null) {
                bVar.a();
                this.e = null;
            }
            a aVar = this.f;
            if (aVar != null) {
                aVar.a();
                this.f = null;
            }
            NestAdData nestAdData = this.b;
            if (nestAdData != null) {
                SPCacheManager.INSTANCE.destroyOneAd(nestAdData);
                this.b = null;
            }
            NestAdData nestAdData2 = this.c;
            if (nestAdData2 != null) {
                SPCacheManager.INSTANCE.destroyOneAd(nestAdData2);
                this.c = null;
            }
        }
    }
}
