package defpackage;

import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.wifi.ad.core.utils.WifiLog;
import com.zenmen.palmchat.c;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class so6 {
    public static volatile so6 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IWXAPI f20797a;
    public a b;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void onCodeBack(String str);

        void onError(String str);
    }

    public so6() {
        ds0.a().c(this);
        e();
    }

    public static so6 a() {
        if (c == null) {
            synchronized (so6.class) {
                if (c == null) {
                    c = new so6();
                }
            }
        }
        return c;
    }

    public IWXAPI b() {
        return this.f20797a;
    }

    public boolean c() {
        return this.f20797a.isWXAppInstalled();
    }

    public boolean d(String str, String str2) {
        WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
        req.userName = str;
        req.path = str2;
        req.miniprogramType = (!nl0.k() || nl0.h()) ? 2 : 0;
        return this.f20797a.sendReq(req);
    }

    public final void e() {
        IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(c.b(), "wxac389a401b5d4943");
        this.f20797a = iwxapiCreateWXAPI;
        iwxapiCreateWXAPI.registerApp("wxac389a401b5d4943");
    }

    public void f(a aVar) {
        try {
            WifiLog.d("sendAuth send req start");
            this.b = aVar;
            if (!c()) {
                sy5.f(c.b(), "未安装微信", 0).g();
                this.b.onError("wx isn't install");
                WifiLog.d("sendAuth send not install wx-app");
            } else {
                SendAuth.Req req = new SendAuth.Req();
                req.scope = "snsapi_userinfo";
                req.state = UUID.randomUUID().toString();
                this.f20797a.sendReq(req);
                WifiLog.d("sendAuth send req end ");
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.b.onError(e.getMessage());
            WifiLog.d("sendAuth send req error" + e.getMessage());
        }
    }

    @qm5
    public void onSendAuthResult(k55 k55Var) {
        a aVar;
        if (k55Var == null || (aVar = this.b) == null) {
            return;
        }
        aVar.onCodeBack(k55Var.a());
    }
}
