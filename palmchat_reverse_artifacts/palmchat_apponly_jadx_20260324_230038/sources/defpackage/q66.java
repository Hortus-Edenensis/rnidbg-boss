package defpackage;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.wifi.ad.core.WifiNestAd;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.helper.AdHelperDrawVideo;
import com.wifi.ad.core.helper.AdHelperH5Ad;
import com.wifi.ad.core.listener.DrawLoadListener;
import com.wifi.ad.core.spstrategy.SPCacheManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class q66 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f20188a = false;
    public static NestAdData b = null;
    public static int c = -1;
    public static boolean d = false;

    public static void b(Activity activity, String str) {
        if (p66.g() && p66.f() && !d) {
            d = true;
            ds0.a().b(new s66(2));
            d(activity, str, true);
            d = false;
        }
    }

    public static void c() {
        if (b6.d() && b != null) {
            SPCacheManager.INSTANCE.destroyOneAd(b);
        }
        b = null;
        f20188a = false;
        c = -1;
    }

    public static synchronized void d(Activity activity, String str, boolean z) {
        if (!f20188a && activity != null && b == null) {
            b = null;
            f20188a = true;
            LogUtil.d("UserDetailAd", "UserDetailAdControlV2L requestAd 开始请求广告 allowInsertAd " + z);
            HashMap map = new HashMap();
            String adRequestId = AdHelperH5Ad.INSTANCE.getAdRequestId();
            map.put("requestId", adRequestId);
            map.put("taiChiKey", "LX-44444");
            map.put("exp_group", p66.b());
            AdHelperDrawVideo adHelperDrawVideoCreateAdDrawVideo = WifiNestAd.INSTANCE.createAdDrawVideo();
            AdParams adParamsBuild = new AdParams.Builder().setExt(map).setScene(82).setAdUnitId("chiu87r8mead65eg7a2g").build();
            d66.e(adRequestId, str);
            adHelperDrawVideoCreateAdDrawVideo.getNativeDrawVideo(activity, adParamsBuild, new a(z, str));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements DrawLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f20189a;
        public final /* synthetic */ String b;

        public a(boolean z, String str) {
            this.f20189a = z;
            this.b = str;
        }

        @Override // com.wifi.ad.core.listener.DrawLoadListener, com.wifi.ad.core.listener.BaseListener
        public void onAdFailed(@NonNull String str, @NonNull String str2) {
            LogUtil.d("UserDetailAd", "UserDetailAdControlV2L requestAd 广告失败 onAdFailed s:" + str + " s1 " + str2);
            boolean unused = q66.f20188a = false;
            d66.d(str, str2, this.b);
        }

        @Override // com.wifi.ad.core.listener.DrawLoadListener, com.wifi.ad.core.listener.BaseListener
        public void onAdLoaded(@NonNull String str, @NonNull List<NestAdData> list) {
            LogUtil.d("UserDetailAd", "UserDetailAdControlV2L requestAd onAdLoaded 广告召回 allowInsertAd " + this.f20189a);
            if (list != null && list.size() > 0) {
                NestAdData nestAdData = list.get(0);
                q66.b = nestAdData;
                d66.c(nestAdData.getRequestId(), q66.b, this.b);
            }
            boolean unused = q66.f20188a = false;
            if (this.f20189a && p66.f()) {
                ds0.a().b(new s66(1));
            }
        }

        @Override // com.wifi.ad.core.listener.DrawLoadListener, com.wifi.ad.core.listener.BaseListener
        public void onStart() {
        }
    }
}
