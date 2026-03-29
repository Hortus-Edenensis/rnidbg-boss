package defpackage;

import com.huawei.openalliance.ad.constant.az;
import com.lantern.auth.server.WkParams;
import com.zenmen.palmchat.utils.MdidSdkConfigHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class mh {
    public static sw4 a(String str) {
        sw4 sw4Var = new sw4();
        sw4Var.f = str;
        sw4Var.b = new HashMap<>();
        HashMap<String, Object> map = new HashMap<>();
        sw4Var.f20862a = map;
        map.put("channelId", ac1.m);
        sw4Var.f20862a.put("did", ac1.o);
        sw4Var.f20862a.put("platform", ac1.c);
        sw4Var.f20862a.put(az.aW, ac1.f);
        sw4Var.f20862a.put(WkParams.IMEI, ac1.i);
        sw4Var.f20862a.put("mac", ac1.k);
        sw4Var.f20862a.put("dhid", ac1.y());
        sw4Var.f20862a.put("autoLogin", "0");
        String strV = ac1.v();
        sw4Var.f20862a.put("sdid", strV);
        LogUtil.i("SmidHelper", "login smid=" + strV);
        sw4Var.f20862a.put("oaid", MdidSdkConfigHelper.getInstance().getOAID());
        sw4Var.f20862a.put("oneId", "");
        if (ts0.o().K()) {
            sw4Var.f20862a.put("dfp", fm1.k().toString());
            sw4Var.f20862a.put("appList", ac1.s());
        }
        sw4Var.f20862a.put("appId", eb4.b());
        sw4Var.f20862a.put("ipInfo", vu2.c().d());
        sw4Var.f20862a.put("androidId", ac1.p);
        sw4Var.c = 1;
        sw4Var.h = true;
        return sw4Var;
    }
}
