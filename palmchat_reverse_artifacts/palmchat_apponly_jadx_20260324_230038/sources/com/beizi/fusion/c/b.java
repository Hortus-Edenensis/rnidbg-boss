package com.beizi.fusion.c;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.beizi.fusion.BeiZiInitCallBack;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.events.EventCar;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.AppEventId;
import com.beizi.fusion.model.RequestInfo;
import com.beizi.fusion.model.ResponseInfo;
import com.beizi.fusion.tool.ad;
import com.beizi.fusion.tool.ae;
import com.beizi.fusion.tool.an;
import com.beizi.fusion.tool.ao;
import com.beizi.fusion.tool.n;
import com.beizi.fusion.tool.x;
import com.wifi.adsdk.entity.LxEventReplace;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f4608a = null;
    public static String b = "";
    private static String c = "AdManager";
    private static b d;
    private static String e;
    private static String j;
    private static String k;
    private Context f;
    private com.beizi.fusion.update.b h;
    private com.beizi.fusion.events.b i;
    private BeiZiInitCallBack t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean g = false;
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;
    private boolean r = true;
    private String s = "0";

    private void A() {
        try {
            com.beizi.fusion.update.b.a(this.f).b(5);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        BeiZiInitCallBack beiZiInitCallBack;
        if (!this.o) {
            n.a().a(this.f);
        }
        ResponseInfo.getInstance(this.f).init();
        if (!this.m) {
            this.i.f4666a.a(1);
            m();
        }
        g();
        if (!this.m) {
            if (this.i.f4666a.a() == 1) {
                this.i.f4666a.a(2);
            } else {
                Log.i("BeiZis", "init status error not kInitStatusBegin");
            }
        }
        if (BeiZis.isIsSyncInit() || (beiZiInitCallBack = this.t) == null) {
            return;
        }
        beiZiInitCallBack.success();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        try {
            new com.beizi.fusion.d.a.b(ad.b).a(this.f);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        try {
            if ("0".equals(ResponseInfo.getInstance(this.f).getSmFlag())) {
                int iIntValue = ((Integer) an.b(this.f, "SM_STATUS", 0)).intValue();
                int i = 1;
                if (iIntValue == 1) {
                    an.a(this.f, "SM_STATUS", (Object) 3);
                    an.a(this.f, "SM_STATUS_EXPIRE_TIME", (Object) Long.valueOf(System.currentTimeMillis()));
                    iIntValue = 3;
                }
                if (iIntValue == 0 || iIntValue == 2) {
                    an.a(this.f, "SM_STATUS", (Object) 1);
                } else {
                    i = iIntValue;
                }
                if (i != 3) {
                    if (com.beizi.fusion.sm.b.a.a(this.f)) {
                        com.beizi.fusion.sm.b.a.a(this.f, new com.beizi.fusion.sm.b.b() { // from class: com.beizi.fusion.c.b.3
                            @Override // com.beizi.fusion.sm.b.b
                            public void a(String str) {
                                Log.e(b.c, "code sm Oaid:" + str);
                                if (!TextUtils.isEmpty(str)) {
                                    an.a(b.this.f, LxEventReplace.__OAID__, (Object) str);
                                    an.a(b.this.f, "__SMOAID__", (Object) str);
                                    if (RequestInfo.getInstance(b.this.f).getDevInfo() != null) {
                                        if (ae.b() && BeiZis.isLimitPersonalAds()) {
                                            return;
                                        }
                                        RequestInfo.getInstance(b.this.f).getDevInfo().setOaid(str);
                                        RequestInfo.getInstance(b.this.f).getDevInfo().setSmOaid(str);
                                        return;
                                    }
                                    return;
                                }
                                if (Build.BRAND.equalsIgnoreCase("HONOR")) {
                                    String str2 = (String) an.b(b.this.f, "__HONOROAID__", "");
                                    if (TextUtils.isEmpty(str2)) {
                                        return;
                                    }
                                    an.a(b.this.f, LxEventReplace.__OAID__, (Object) str2);
                                    an.a(b.this.f, "__SMOAID__", (Object) str2);
                                    if (RequestInfo.getInstance(b.this.f).getDevInfo() != null && (!ae.b() || !BeiZis.isLimitPersonalAds())) {
                                        RequestInfo.getInstance(b.this.f).getDevInfo().setOaid(str2);
                                        RequestInfo.getInstance(b.this.f).getDevInfo().setSmOaid(str2);
                                    }
                                }
                                b.this.x();
                            }

                            @Override // com.beizi.fusion.sm.b.b
                            public void a(Exception exc) {
                                b.this.x();
                            }
                        });
                    }
                    an.a(this.f, "SM_STATUS", (Object) 2);
                } else {
                    Long l = (Long) an.b(this.f, "SM_STATUS_EXPIRE_TIME", Long.valueOf(Long.parseLong("0")));
                    if (l.longValue() == 0 || Long.valueOf(System.currentTimeMillis() - l.longValue()).longValue() <= 864000000) {
                        return;
                    }
                    an.a(this.f, "SM_STATUS", (Object) 0);
                    an.a(this.f, "SM_STATUS_EXPIRE_TIME", (Object) Long.valueOf(Long.parseLong("0")));
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        try {
            if (Build.BRAND.equalsIgnoreCase("HONOR")) {
                String str = (String) an.b(this.f, "__HONOROAID__", "");
                if (!TextUtils.isEmpty(str) && RequestInfo.getInstance(this.f).getDevInfo() != null) {
                    RequestInfo.getInstance(this.f).getDevInfo().setHonorOaid(str);
                }
                com.beizi.fusion.tool.e.b().c().execute(new Runnable() { // from class: com.beizi.fusion.c.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        String strA = com.beizi.fusion.sm.a.a.a(b.this.f);
                        Log.e(b.c, "code honor Oaid:" + strA);
                        if (!TextUtils.isEmpty(strA)) {
                            an.a(b.this.f, "__HONOROAID__", (Object) strA);
                        }
                        if (TextUtils.isEmpty(strA) || RequestInfo.getInstance(b.this.f).getDevInfo() == null) {
                            return;
                        }
                        RequestInfo.getInstance(b.this.f).getDevInfo().setHonorOaid(strA);
                    }
                });
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public com.beizi.fusion.events.b f() {
        return this.i;
    }

    public void g() {
        if (ae.b()) {
            if (BeiZis.isLimitPersonalAds()) {
                return;
            }
            if (BeiZis.getCustomController() != null && (BeiZis.getCustomController() == null || !BeiZis.getCustomController().isCanUseOaid())) {
                return;
            }
        }
        String str = (String) an.b(this.f, LxEventReplace.__OAID__, "");
        if (TextUtils.isEmpty(str) || RequestInfo.getInstance(this.f).getDevInfo() == null) {
            return;
        }
        RequestInfo.getInstance(this.f).getDevInfo().setOaid(str);
    }

    public void h() {
        if (this.u) {
            return;
        }
        this.u = true;
        if (ae.b()) {
            if (BeiZis.isLimitPersonalAds()) {
                return;
            }
            if (BeiZis.getCustomController() != null && (BeiZis.getCustomController() == null || !BeiZis.getCustomController().isCanUseOaid())) {
                return;
            }
        }
        com.beizi.fusion.tool.e.b().c().execute(new Runnable() { // from class: com.beizi.fusion.c.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.z();
                b.this.y();
            }
        });
    }

    public boolean i() {
        return this.m;
    }

    public boolean j() {
        return this.n;
    }

    public boolean k() {
        return this.q;
    }

    public void l() {
        h();
        if (this.m && this.g && this.f != null && this.i.f4666a.a() == 0) {
            this.i.f4666a.a(1);
            this.i.f4666a.a(2);
        }
    }

    public void m() {
        Context context = this.f;
        if (context != null && this.h == null) {
            if (ResponseInfo.getInstance(context).isInit()) {
                EventCar.getInstance(this.f).goRoad(new EventBean(b, "", "410.000", "", a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                EventCar.getInstance(this.f).goRoad(new EventBean(b, "", "410.200", "", a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
            } else {
                EventCar.getInstance(this.f).goRoad(new EventBean(b, "", "410.000", "", a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                EventCar.getInstance(this.f).goRoad(new EventBean(b, "", "410.500", "", a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
            }
            com.beizi.fusion.update.b bVarA = com.beizi.fusion.update.b.a(this.f);
            this.h = bVarA;
            bVarA.b(0);
        }
    }

    public boolean n() {
        return this.p;
    }

    public boolean o() {
        return (BeiZis.getCustomController() == null || !BeiZis.getCustomController().forbidSensor() || ResponseInfo.getInstance(this.f).isOpenSensor()) ? false : true;
    }

    public boolean p() {
        return BeiZis.getCustomController() == null || BeiZis.getCustomController().isCanUseAndroidId();
    }

    public String q() {
        return BeiZis.getCustomController() == null ? "" : BeiZis.getCustomController().getAndroidId();
    }

    public boolean r() {
        return this.r;
    }

    public String s() {
        return this.s;
    }

    public boolean t() {
        return this.v;
    }

    public boolean u() {
        return this.w;
    }

    public static b a() {
        if (d == null) {
            synchronized (b.class) {
                if (d == null) {
                    d = new b();
                }
            }
        }
        return d;
    }

    public String b() {
        return f4608a;
    }

    public String c() {
        return j;
    }

    public String d() {
        return k;
    }

    public Context e() {
        return this.f;
    }

    public String b(String str) {
        String appId;
        String spaceId;
        try {
            if (TextUtils.isEmpty(str) || this.f == null || !this.g) {
                return null;
            }
            h();
            AdSpacesBean adSpaceBean = ResponseInfo.getInstance(this.f).getAdSpaceBean(str);
            if (adSpaceBean == null) {
                A();
                return l.a(this.f, null, null);
            }
            List<AdSpacesBean.BuyerBean> buyer = adSpaceBean.getBuyer();
            if (buyer != null && !buyer.isEmpty()) {
                Iterator<AdSpacesBean.BuyerBean> it = buyer.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        appId = null;
                        spaceId = null;
                        break;
                    }
                    AdSpacesBean.BuyerBean next = it.next();
                    if (next != null && "S2S".equalsIgnoreCase(next.getBidType())) {
                        appId = next.getAppId();
                        spaceId = next.getSpaceId();
                        break;
                    }
                }
                if (!TextUtils.isEmpty(appId) && !TextUtils.isEmpty(spaceId)) {
                    return l.a(this.f, appId, spaceId);
                }
                A();
                return l.a(this.f, null, null);
            }
            A();
            return l.a(this.f, null, null);
        } catch (Exception e2) {
            e2.printStackTrace();
            return l.a(this.f, null, null);
        }
    }

    public b a(String str) {
        e = str;
        return d;
    }

    public void a(Context context, String str, String str2, String str3) {
        BeiZiInitCallBack beiZiInitCallBack;
        synchronized (b.class) {
            Log.e("BeiZis", "init start applicationCode：" + str);
            if (context != null) {
                if (!this.g) {
                    this.f = context.getApplicationContext();
                    String strA = ao.a();
                    b = strA;
                    EventBean eventBean = new EventBean(strA, "", "", "", str, "", "", String.valueOf(System.currentTimeMillis()), "");
                    this.i = new com.beizi.fusion.events.b(eventBean);
                    Log.d("BeiZis", "SDK_VERSION_MANAGER:5.2.2.0");
                    f4608a = str;
                    j = str2;
                    k = str3;
                    com.beizi.fusion.events.b bVar = this.i;
                    bVar.f4666a.addObserver(bVar);
                    this.i.a().a(eventBean);
                    AppEventId.getInstance(this.f).setAppStart();
                    AppEventId.getInstance(this.f).setAppSdkInit();
                    x.a().b(this.f);
                    if (this.i.f4666a.a() == 0) {
                        if (BeiZis.isIsSyncInit()) {
                            w();
                        } else {
                            com.beizi.fusion.tool.e.b().c().execute(new Runnable() { // from class: com.beizi.fusion.c.b.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    b.this.w();
                                }
                            });
                        }
                        this.g = true;
                    } else {
                        Log.i("BeiZis", "init status error not kInitStatusUnknown");
                    }
                } else if (!BeiZis.isIsSyncInit() && (beiZiInitCallBack = this.t) != null) {
                    beiZiInitCallBack.success();
                }
                Log.e("BeiZis", "init end");
            } else {
                throw new IllegalArgumentException("Context cannot be null.");
            }
        }
    }

    public void a(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        try {
            if (map.containsKey("forbid_config_network")) {
                Object obj = map.get("forbid_config_network");
                if (obj instanceof Boolean) {
                    this.m = ((Boolean) obj).booleanValue();
                }
            }
            if (map.containsKey("speed_first_strategy")) {
                Object obj2 = map.get("speed_first_strategy");
                if (obj2 instanceof Boolean) {
                    this.n = ((Boolean) obj2).booleanValue();
                }
            }
            if (map.containsKey("forbid_collect_crash")) {
                Object obj3 = map.get("forbid_collect_crash");
                if (obj3 instanceof Boolean) {
                    this.o = ((Boolean) obj3).booleanValue();
                }
            }
            if (map.containsKey("forbid_verify_window_focus")) {
                Object obj4 = map.get("forbid_verify_window_focus");
                if (obj4 instanceof Boolean) {
                    this.p = ((Boolean) obj4).booleanValue();
                }
            }
            if (map.containsKey("allow_use_app_status")) {
                Object obj5 = map.get("allow_use_app_status");
                if (obj5 instanceof Boolean) {
                    this.q = ((Boolean) obj5).booleanValue();
                }
            }
            if (map.containsKey("isCanUseSimOperator")) {
                Object obj6 = map.get("isCanUseSimOperator");
                if (obj6 instanceof Boolean) {
                    this.r = ((Boolean) obj6).booleanValue();
                }
            }
            if (map.containsKey("simOperator")) {
                Object obj7 = map.get("simOperator");
                if (obj7 instanceof String) {
                    this.s = (String) obj7;
                }
            }
            if (map.containsKey("open_location_frequency")) {
                Object obj8 = map.get("open_location_frequency");
                if (obj8 instanceof Boolean) {
                    this.v = ((Boolean) obj8).booleanValue();
                }
            }
            if (map.containsKey("limit_location_frequency")) {
                Object obj9 = map.get("limit_location_frequency");
                if (obj9 instanceof Boolean) {
                    this.w = ((Boolean) obj9).booleanValue();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(BeiZiInitCallBack beiZiInitCallBack) {
        this.t = beiZiInitCallBack;
    }
}
