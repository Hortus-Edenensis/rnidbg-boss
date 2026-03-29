package defpackage;

import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.location.LocationClientOption;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.LocationScene;
import com.zenmen.palmchat.location.LxMapServiceRetryConfig;
import com.zenmen.palmchat.location.c;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class h53 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.zenmen.palmchat.location.a f17871a;
    public i53 b = null;

    /* JADX WARN: Removed duplicated region for block: B:7:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b(int i, LocationScene locationScene) {
        boolean z;
        LxMapServiceRetryConfig lxMapServiceRetryConfigC = c.c();
        boolean zD = c.d(locationScene);
        if (lxMapServiceRetryConfigC.isErrorCodeMatch(zD, i)) {
            z = Math.abs(SPUtil.f14322a.i(SPUtil.SCENE.APP_COMMON, "key_location_gaode_last_retry_time", 0L) - ir5.b()) > ((long) lxMapServiceRetryConfigC.getRequestInterval(zD)) * 1000;
        }
        LogUtil.i("LocationFailRetryHelper", "canRetry errorCode=" + i + " scene=" + locationScene + " result =" + z);
        return z;
    }

    public final boolean c() {
        if (this.f17871a != null) {
            return false;
        }
        com.zenmen.palmchat.location.a aVar = new com.zenmen.palmchat.location.a(com.zenmen.palmchat.c.b(), new LocationClientOption(), LocationScene.DEFAULT, true);
        this.f17871a = aVar;
        aVar.i(new a());
        return true;
    }

    public void d(LocationScene locationScene, i53 i53Var) {
        LogUtil.i("LocationFailRetryHelper", "retry start");
        SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, "key_location_gaode_last_retry_time", Long.valueOf(ir5.b()));
        this.b = i53Var;
        e(locationScene);
    }

    public final void e(LocationScene locationScene) {
        LogUtil.i("LocationFailRetryHelper", "start scene=" + locationScene + " " + this.f17871a);
        if (!c()) {
            this.f17871a.q();
        }
        this.f17871a.p(locationScene);
    }

    public void f() {
        LogUtil.i("LocationFailRetryHelper", "stop " + this.f17871a);
        com.zenmen.palmchat.location.a aVar = this.f17871a;
        if (aVar != null) {
            aVar.q();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements i53 {
        public a() {
        }

        @Override // defpackage.i53
        public void onLocationReceived(LocationEx locationEx, int i, String str) {
            LogUtil.i("LocationFailRetryHelper", "onLocationReceived location=" + locationEx + " errorCode=" + i + " errorInfo=" + str);
            if (h53.this.b != null) {
                h53.this.b.onLocationReceived(locationEx, i, str);
            }
        }

        @Override // defpackage.i53
        public void onRegeocodeSearched(String str) {
        }

        @Override // defpackage.i53
        public void onLocationSearchResultGot(int i, List<LocationEx> list, n53 n53Var) {
        }
    }
}
