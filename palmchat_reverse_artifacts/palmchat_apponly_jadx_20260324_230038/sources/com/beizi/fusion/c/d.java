package com.beizi.fusion.c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.beizi.fusion.AdListener;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.InterstitialAdListener;
import com.beizi.fusion.NativeAdListener;
import com.beizi.fusion.NativeUnifiedAdListener;
import com.beizi.fusion.RewardedVideoAdListener;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.ChannelBidResult;
import com.beizi.fusion.model.EventItem;
import com.beizi.fusion.model.Manager;
import com.beizi.fusion.model.ResponseInfo;
import com.beizi.fusion.tool.aa;
import com.beizi.fusion.tool.an;
import com.beizi.fusion.tool.ao;
import com.beizi.fusion.tool.ap;
import com.beizi.fusion.tool.m;
import com.beizi.fusion.tool.s;
import com.beizi.fusion.tool.z;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.kwad.sdk.api.model.AdnName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class d implements com.beizi.fusion.c.a, Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static Context f4613a = null;
    private static boolean r = false;
    private com.beizi.fusion.events.b F;
    private long G;
    private List<AdSpacesBean.BuyerBean> H;
    private z J;
    private a K;
    private boolean L;
    private long U;
    private Map<String, Object> V;
    private String X;
    protected Context b;
    protected EventBean c;
    protected ViewGroup d;
    protected String e;
    protected long f;
    protected View g;
    protected com.beizi.fusion.a h;
    protected com.beizi.fusion.work.a i;
    protected String m;
    private d t;
    private AdSpacesBean u;
    private long x;
    protected Map<String, com.beizi.fusion.work.a> j = new Hashtable();
    protected ArrayList<c> k = new ArrayList<>();
    protected boolean l = false;
    private boolean s = false;
    private long v = 500;
    private long w = 100;
    private volatile int y = 0;
    private int z = 0;
    private int A = 0;
    private int B = 1;
    private int C = 2;
    private Timer D = null;
    private boolean E = false;
    private boolean I = false;
    private boolean M = false;
    private AdSpacesBean N = null;
    private com.beizi.fusion.events.a O = null;
    protected boolean n = false;
    private int P = 0;
    private int Q = 1;
    private int R = 2;
    protected boolean o = false;
    private boolean S = false;
    private boolean T = false;
    protected com.beizi.fusion.work.a p = null;

    @SuppressLint({"HandlerLeak"})
    protected Handler q = new Handler(Looper.getMainLooper()) { // from class: com.beizi.fusion.c.d.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                Log.d("BeiZis", "bid time out");
                d dVar = d.this;
                dVar.z = dVar.B;
                d dVar2 = d.this;
                if (dVar2.i != null) {
                    dVar2.b(2);
                    return;
                }
                return;
            }
            if (i != 2) {
                if (i != 3) {
                    return;
                }
                d.this.F();
                com.beizi.fusion.events.b bVarF = b.a().f();
                d.this.F = new com.beizi.fusion.events.b(new EventBean(b.b, "", "", "", b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                d dVar3 = d.this;
                dVar3.O = dVar3.F.a();
                d dVar4 = d.this;
                dVar4.c = dVar4.F.b();
                d.this.G();
                d.this.O.a(d.this.c);
                d.this.J();
                if (bVarF == null || bVarF.f4666a.a() != 2 || d.this.F.b.a() != 0) {
                    d.this.a(10000);
                    return;
                }
                d.this.F.b.a(1);
                if (d.this.F.b.a() != 1) {
                    d.this.F.b.a(-2);
                    d.this.a("kGetLocalConfigStatusInternalError");
                    return;
                }
                d.this.F.b.a(2);
                d dVar5 = d.this;
                dVar5.u = com.beizi.fusion.b.a.a(dVar5.b, dVar5.m, dVar5.d());
                if (d.this.u != null) {
                    d.this.a(AVMDLDataLoader.KeyIsEnableEventInfo);
                    return;
                }
                Log.d("BeiZis", "update spaceBean is null and return fail");
                if (d.this.F.b.a() != 2) {
                    d.this.F.b.a(-2);
                    d.this.a("kGetLocalConfigStatusInternalError");
                    return;
                }
                int iA = com.beizi.fusion.b.a.a();
                if (iA == 1) {
                    d.this.F.b.a(4);
                    d.this.a(10001);
                    return;
                } else if (iA == 2) {
                    d.this.F.b.a(5);
                    d.this.a(10100);
                    return;
                } else if (iA != 3) {
                    d.this.a(AVMDLDataLoader.KeyIsEnableEventInfo);
                    return;
                } else {
                    d.this.F.b.a(6);
                    d.this.a(10110);
                    return;
                }
            }
            Log.d("BeiZis", "========update inner outTime==========:" + System.currentTimeMillis());
            d dVar6 = d.this;
            dVar6.z = dVar6.C;
            if (d.this.F != null) {
                d.this.F.a(true);
            }
            if (d.this.F == null) {
                return;
            }
            d dVar7 = d.this;
            com.beizi.fusion.work.a aVar = dVar7.i;
            if (aVar == null) {
                dVar7.a(AVMDLDataLoader.KeyIsEnableEventInfo);
                Map<String, com.beizi.fusion.work.a> mapQ = d.this.q();
                if (mapQ != null) {
                    for (com.beizi.fusion.work.a aVar2 : mapQ.values()) {
                        AdSpacesBean.BuyerBean buyerBeanJ = aVar2.j();
                        if (buyerBeanJ != null) {
                            d.this.b(aVar2, 2);
                            aa.a("BeiZis", "AdRequest timeout channel = " + buyerBeanJ.getId() + ",mManagerObserver.mChannelResultStatus.getStatus(channel) = " + d.this.F.g.a(buyerBeanJ.getBuyerSpaceUuId()));
                            if (d.this.F.g.a(buyerBeanJ.getBuyerSpaceUuId()) < 4) {
                                d.this.F.g.a(buyerBeanJ.getBuyerSpaceUuId(), -1);
                            }
                        }
                    }
                    return;
                }
                return;
            }
            aVar.q();
            d dVar8 = d.this;
            dVar8.a(dVar8.i.f(), d.this.i.o());
            if ("4".equals(d.this.d())) {
                d dVar9 = d.this;
                if (!dVar9.n) {
                    dVar9.i.e();
                    d.this.n = true;
                }
            }
            Map<String, com.beizi.fusion.work.a> mapQ2 = d.this.q();
            if (mapQ2 != null) {
                for (com.beizi.fusion.work.a aVar3 : mapQ2.values()) {
                    AdSpacesBean.BuyerBean buyerBeanJ2 = aVar3.j();
                    AdSpacesBean.BuyerBean buyerBeanJ3 = d.this.i.j();
                    if (buyerBeanJ2 != null && buyerBeanJ3 != null && (TextUtils.isEmpty(buyerBeanJ2.getBuyerSpaceUuId()) || TextUtils.isEmpty(buyerBeanJ3.getBuyerSpaceUuId()) || !buyerBeanJ2.getBuyerSpaceUuId().equals(buyerBeanJ3.getBuyerSpaceUuId()))) {
                        d.this.b(aVar3, 2);
                        aa.a("BeiZis", "AdRequest timeout channel = " + buyerBeanJ2.getId() + ",mManagerObserver.mChannelResultStatus.getStatus(channel) = " + d.this.F.g.a(buyerBeanJ2.getBuyerSpaceUuId()));
                        if (aVar3.h() == com.beizi.fusion.e.a.ADDEFAULT) {
                            d.this.F.g.a(buyerBeanJ2.getBuyerSpaceUuId(), -1);
                        }
                    }
                }
            }
        }
    };
    private TimerTask W = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            try {
                String action = intent.getAction();
                int intExtra = intent.getIntExtra("updateResult", 0);
                d.this.L = true;
                if (TextUtils.equals(action, "com.ad.action.UPDATE_CONFIG_SUCCESS")) {
                    if (intExtra == 1) {
                        if (d.this.D != null) {
                            d.this.D.cancel();
                            d.this.D = null;
                        }
                        d dVar = d.this;
                        dVar.a(dVar.d);
                    } else if (intExtra == 0 && d.this.M) {
                        if (d.this.D != null) {
                            d.this.D.cancel();
                            d.this.D = null;
                        }
                        d dVar2 = d.this;
                        dVar2.a(dVar2.d);
                    }
                }
                d.this.F();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public d(Context context, String str, com.beizi.fusion.a aVar, long j) {
        if (context == null) {
            ap.b("Illegal Argument: context is null");
        } else {
            this.b = context;
            f4613a = context.getApplicationContext();
            if (!(this.b instanceof Activity)) {
                ap.b("Illegal Argument: context is not Activity context");
            }
        }
        this.m = str;
        this.h = aVar;
        this.f = j;
        this.t = this;
        if (f4613a != null || aVar == null) {
            return;
        }
        a(10132);
    }

    private void B() {
        Handler handler = this.q;
        if (handler != null) {
            handler.removeMessages(1);
        }
        Timer timer = this.D;
        if (timer != null) {
            timer.cancel();
            this.D = null;
        }
    }

    private void C() {
        Handler handler = this.q;
        if (handler != null) {
            handler.removeMessages(2);
        }
        Timer timer = this.D;
        if (timer != null) {
            timer.cancel();
            this.D = null;
        }
    }

    private void D() {
        if (this.J != null) {
            return;
        }
        this.J = z.a(f4613a);
        IntentFilter intentFilter = new IntentFilter("com.ad.action.UPDATE_CONFIG_SUCCESS");
        a aVar = new a();
        this.K = aVar;
        this.J.a(aVar, intentFilter);
    }

    private void E() {
        try {
            if (this.L) {
                return;
            }
            D();
            com.beizi.fusion.update.b.a(f4613a).b(5);
            if (this.D == null) {
                this.D = new Timer();
            }
            if (this.W == null) {
                this.W = new TimerTask() { // from class: com.beizi.fusion.c.d.2
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        try {
                            Log.d("BeiZis", "========update outTime==========:" + System.currentTimeMillis());
                            Handler handler = d.this.q;
                            if (handler != null) {
                                handler.sendEmptyMessage(3);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
            }
            if (this.D == null || this.W == null) {
                return;
            }
            long jMin = this.f;
            if (jMin > 2000) {
                jMin = 2000;
            }
            long j = this.x;
            if (j > 0) {
                jMin = Math.min(jMin, j);
            }
            this.D.schedule(this.W, jMin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        a aVar;
        try {
            z zVar = this.J;
            if (zVar == null || (aVar = this.K) == null) {
                return;
            }
            zVar.a(aVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        EventBean eventBean = this.c;
        if (eventBean != null) {
            eventBean.setReqId(this.e);
            c();
            this.c.setAppId(b.a().b());
            this.c.setSpaceId(this.m);
            this.c.setReserveTime(String.valueOf(this.f));
        }
    }

    private boolean H() {
        AdSpacesBean adSpacesBean = this.u;
        if (adSpacesBean == null) {
            return false;
        }
        if (adSpacesBean.getBid() != null) {
            this.v = r0.getReserveFRWTime();
            this.w = r0.getReserveTime();
            this.x = r0.getTimeOut();
            if (b.a().j() && this.x <= 0) {
                this.x = 800L;
            }
        }
        Log.d("BeiZis", this.f + ":mUsableTime=====" + this.v + "=====mLastTime:" + this.w);
        long j = this.f;
        if (j <= this.w) {
            a(10120);
            this.F.b.a(7);
            return true;
        }
        if (j > this.v) {
            T();
        } else {
            this.z = this.B;
        }
        U();
        return false;
    }

    private void I() {
        s.b(f4613a, this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        com.beizi.fusion.events.b bVar = this.F;
        if (bVar != null) {
            bVar.b.addObserver(bVar);
            com.beizi.fusion.events.b bVar2 = this.F;
            bVar2.c.addObserver(bVar2);
            com.beizi.fusion.events.b bVar3 = this.F;
            bVar3.d.addObserver(bVar3);
            com.beizi.fusion.events.b bVar4 = this.F;
            bVar4.e.addObserver(bVar4);
            com.beizi.fusion.events.b bVar5 = this.F;
            bVar5.f.addObserver(bVar5);
            com.beizi.fusion.events.b bVar6 = this.F;
            bVar6.g.addObserver(bVar6);
            com.beizi.fusion.events.b bVar7 = this.F;
            bVar7.h.addObserver(bVar7);
            com.beizi.fusion.events.b bVar8 = this.F;
            bVar8.i.addObserver(bVar8);
            com.beizi.fusion.events.b bVar9 = this.F;
            bVar9.j.addObserver(bVar9);
            com.beizi.fusion.events.b bVar10 = this.F;
            bVar10.k.addObserver(bVar10);
        }
    }

    private void K() {
        String str;
        AdSpacesBean adSpacesBean = this.u;
        if (adSpacesBean != null) {
            String adType = adSpacesBean.getAdType();
            adType.hashCode();
            switch (adType) {
                case "NATIVE":
                    str = "5";
                    break;
                case "SPLASH":
                    str = "2";
                    break;
                case "INTERSTITIAL":
                    str = "3";
                    break;
                case "REWARDEDVIDEO":
                    str = "1";
                    break;
                case "DRAWFLOW":
                    str = "7";
                    break;
                case "INTERACTIVECARD":
                    str = BaseWrapper.ENTER_ID_GAME_CENTER;
                    break;
                case "FULLSCREENVIDEO":
                    str = "6";
                    break;
                case "REGIONALNATIVE":
                    str = BaseWrapper.ENTER_ID_MARKET;
                    break;
                case "BANNER":
                    str = "4";
                    break;
                default:
                    str = null;
                    break;
            }
            EventBean eventBean = this.c;
            if (eventBean != null) {
                eventBean.setAdType(str);
            }
        }
    }

    private boolean L() {
        if (!this.T) {
            return false;
        }
        com.beizi.fusion.work.a aVar = this.p;
        if (aVar != null) {
            return aVar != null && aVar.h() == com.beizi.fusion.e.a.ADDEFAULT;
        }
        return true;
    }

    private boolean M() {
        Iterator<com.beizi.fusion.work.a> it = q().values().iterator();
        while (it.hasNext()) {
            if (it.next().h() == com.beizi.fusion.e.a.ADDEFAULT) {
                return true;
            }
        }
        return false;
    }

    private synchronized void N() {
        this.k.clear();
    }

    private void O() {
        com.beizi.fusion.events.b bVar = this.F;
        if (bVar == null || bVar.j.a() != 0) {
            return;
        }
        this.F.j.a(1);
    }

    private void P() {
        if (this.F != null) {
            aa.b("BeiZis", "mManagerObserver.mManagerResultStatus.getStatus() = " + this.F.j.a());
        }
        com.beizi.fusion.events.b bVar = this.F;
        if (bVar != null) {
            if (bVar.j.a() == 1 || this.F.j.a() == 2 || this.F.j.a() == 3) {
                this.F.j.a(3);
            }
        }
    }

    private void Q() {
        if (this.F != null) {
            aa.b("BeiZis", "mManagerObserver.mManagerResultStatus.getStatus() = " + this.F.j.a());
        }
        com.beizi.fusion.events.b bVar = this.F;
        if (bVar != null) {
            if (bVar.j.a() == 3 || this.F.j.a() == 1 || this.F.j.a() == 2) {
                this.F.j.a(4);
            }
        }
    }

    private void R() {
        try {
            if (this.i == null) {
                return;
            }
            com.beizi.fusion.work.a aVarS = S();
            ChannelBidResult channelBidResult = new ChannelBidResult();
            if (aVarS != null) {
                channelBidResult.setEcpm(e(aVarS));
                channelBidResult.setChannelName(aVarS.f());
                channelBidResult.setBidType(aVarS.g());
            } else {
                channelBidResult.setEcpm(e(this.i));
                channelBidResult.setChannelName(this.i.f());
                channelBidResult.setBidType(this.i.g());
            }
            this.i.a(channelBidResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private com.beizi.fusion.work.a S() {
        Map<String, com.beizi.fusion.work.a> mapQ;
        AdSpacesBean.BuyerBean buyerBeanJ;
        try {
            AdSpacesBean.BuyerBean buyerBeanJ2 = this.i.j();
            if (buyerBeanJ2 == null || (mapQ = q()) == null || mapQ.size() <= 0) {
                return null;
            }
            com.beizi.fusion.work.a aVar = null;
            for (com.beizi.fusion.work.a aVar2 : mapQ.values()) {
                if (aVar2 != null && (buyerBeanJ = aVar2.j()) != null && (TextUtils.isEmpty(buyerBeanJ.getBuyerSpaceUuId()) || TextUtils.isEmpty(buyerBeanJ2.getBuyerSpaceUuId()) || !buyerBeanJ.getBuyerSpaceUuId().equals(buyerBeanJ2.getBuyerSpaceUuId()))) {
                    if (aVar2.h() == com.beizi.fusion.e.a.ADLOAD) {
                        aa.a("BeiZis", "handleSendWinNotice ---getSecondAdWorker---" + aVar2.h() + "---" + aVar2.f() + ";getPrice:" + e(aVar2));
                        if (aVar == null || e(aVar2) > e(aVar)) {
                            aVar = aVar2;
                        }
                    }
                }
            }
            return aVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void T() {
        if (this.q != null) {
            long jMin = this.f - this.v;
            long j = this.x;
            if (j > 0) {
                jMin = Math.min(jMin, j - 50);
            }
            if (jMin <= 0) {
                jMin = 100;
            }
            this.q.sendEmptyMessageDelayed(1, jMin);
        }
    }

    private void U() {
        if (this.q != null) {
            long jMin = this.f - this.w;
            long j = this.x;
            if (j > 0) {
                jMin = Math.min(jMin, j);
            }
            if (jMin <= 0) {
                jMin = 1000;
            }
            this.q.sendEmptyMessageDelayed(2, jMin);
        }
    }

    private boolean j(String str) {
        return false;
    }

    public Map<String, Object> A() {
        return this.V;
    }

    public abstract com.beizi.fusion.work.a a(AdSpacesBean.ForwardBean forwardBean, String str, AdSpacesBean.BuyerBean buyerBean, List<AdSpacesBean.RenderViewBean> list, com.beizi.fusion.work.a aVar);

    public abstract void c();

    public void k() {
        com.beizi.fusion.a aVar = this.h;
        if (aVar == null || !(aVar instanceof RewardedVideoAdListener)) {
            return;
        }
        ((RewardedVideoAdListener) aVar).onRewardedVideoCacheSuccess();
    }

    public void l() {
        com.beizi.fusion.a aVar = this.h;
        if (aVar == null || !(aVar instanceof RewardedVideoAdListener)) {
            return;
        }
        ((RewardedVideoAdListener) aVar).onRewardedVideoPlayError();
    }

    public void m() {
        this.o = true;
        B();
        C();
        com.beizi.fusion.work.a aVar = this.i;
        if (aVar != null) {
            aVar.l();
        }
        if (this.P != this.Q) {
            this.h = null;
        }
        Map<String, com.beizi.fusion.work.a> map = this.j;
        if (map != null) {
            map.clear();
        }
        ArrayList<c> arrayList = this.k;
        if (arrayList != null) {
            arrayList.clear();
        }
        if (this.t != null) {
            this.t = null;
        }
        F();
        b();
    }

    public void n() {
        com.beizi.fusion.work.a aVar = this.i;
        if (aVar != null) {
            aVar.m();
        }
    }

    public void o() {
        com.beizi.fusion.events.b bVar = this.F;
        if (bVar != null) {
            if (bVar.j.a() == 1 || this.F.j.a() == 3 || this.F.j.a() == 4) {
                this.F.j.a(2);
            }
        }
    }

    public void p() {
        com.beizi.fusion.events.b bVar = this.F;
        if (bVar != null) {
            if (bVar.j.a() == 0 || this.F.j.a() == 1) {
                this.F.j.a(5);
            }
        }
    }

    public Map<String, com.beizi.fusion.work.a> q() {
        return this.j;
    }

    public int r() {
        return this.z;
    }

    public int s() {
        return this.y;
    }

    public boolean t() {
        return r;
    }

    public int u() {
        AdSpacesBean adSpacesBean = this.u;
        if (adSpacesBean == null || adSpacesBean.getEventStrategy() == null) {
            return Integer.MAX_VALUE;
        }
        AdSpacesBean.EventStrategyBean eventStrategy = this.u.getEventStrategy();
        if (eventStrategy.getValidTimeShow() >= 0) {
            return eventStrategy.getValidTimeShow();
        }
        return Integer.MAX_VALUE;
    }

    public String v() {
        AdSpacesBean.BuyerBean buyerBeanJ;
        com.beizi.fusion.work.a aVar = this.i;
        if (aVar == null || (buyerBeanJ = aVar.j()) == null || TextUtils.isEmpty(buyerBeanJ.getBuyerSpaceUuId())) {
            return null;
        }
        return buyerBeanJ.getBuyerSpaceUuId();
    }

    public String w() {
        com.beizi.fusion.work.a aVar = this.i;
        if (aVar == null) {
            return null;
        }
        return aVar.aw();
    }

    public long x() {
        return this.U;
    }

    public String y() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("requestUuid", this.e);
            a(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String z() {
        return this.X;
    }

    private boolean h(String str) {
        return str.equals("HPFRW");
    }

    private String i(String str) {
        aa.a("BeiZis", "enter convertSelfChannel buyerId = " + str);
        return ao.b().equals(str) ? "BEIZI" : str;
    }

    public void c(String str) {
        if (this.P == this.Q) {
            this.P = this.R;
        }
        com.beizi.fusion.a aVar = this.h;
        if (aVar != null) {
            if (aVar instanceof AdListener) {
                ((AdListener) aVar).onAdClosed();
            } else if (aVar instanceof RewardedVideoAdListener) {
                ((RewardedVideoAdListener) aVar).onRewardedVideoAdClosed();
            } else if (aVar instanceof NativeAdListener) {
                ((NativeAdListener) aVar).onAdClosed();
            } else if (aVar instanceof InterstitialAdListener) {
                ((InterstitialAdListener) aVar).onAdClosed();
            } else if (aVar instanceof com.beizi.fusion.b) {
                ((com.beizi.fusion.b) aVar).c();
            }
        }
        Q();
    }

    public String d() {
        EventBean eventBean = this.c;
        if (eventBean != null) {
            return eventBean.getAdType();
        }
        return null;
    }

    public void e() {
        this.F.d.a(3);
        a(10140);
    }

    public boolean f() {
        return (s() == 2 || s() == 3) ? false : true;
    }

    public String g() {
        return this.m;
    }

    private double f(com.beizi.fusion.work.a aVar) {
        AdSpacesBean.BuyerBean buyerBeanJ;
        if (aVar == null || (buyerBeanJ = aVar.j()) == null) {
            return 0.0d;
        }
        return buyerBeanJ.getBidPrice();
    }

    public void b() {
        com.beizi.fusion.events.b bVar = this.F;
        if (bVar != null) {
            bVar.b.deleteObservers();
            this.F.c.deleteObservers();
            this.F.d.deleteObservers();
            this.F.e.deleteObservers();
            this.F.f.deleteObservers();
            this.F.g.deleteObservers();
            this.F.h.deleteObservers();
            this.F.i.deleteObservers();
            this.F.j.deleteObservers();
            this.F.k.deleteObservers();
        }
    }

    public void g(String str) {
        this.X = str;
    }

    public synchronized void h() {
        Iterator<c> it = this.k.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        N();
    }

    public void j() {
        com.beizi.fusion.a aVar = this.h;
        if (aVar == null || !(aVar instanceof RewardedVideoAdListener)) {
            return;
        }
        ((RewardedVideoAdListener) aVar).onRewardedVideoComplete();
    }

    private void d(Map<String, com.beizi.fusion.work.a> map) {
        if (map != null && map.size() != 0) {
            for (com.beizi.fusion.work.a aVar : map.values()) {
                aVar.d();
                aVar.a(true);
            }
            return;
        }
        e();
    }

    private double e(com.beizi.fusion.work.a aVar) {
        if (aVar == null || aVar.j() == null) {
            return 0.0d;
        }
        AdSpacesBean.BuyerBean buyerBeanJ = aVar.j();
        if (!c(aVar) && !b(aVar)) {
            return buyerBeanJ.getAvgPrice();
        }
        if (buyerBeanJ.getBidPrice() > 0.0d) {
            return buyerBeanJ.getBidPrice();
        }
        return buyerBeanJ.getAvgPrice();
    }

    private void k(String str) {
        com.beizi.fusion.events.b bVar = this.F;
        if (bVar != null) {
            bVar.h.a(str, 3);
        }
    }

    @NonNull
    private e l(String str) {
        k(str);
        return e.SUCCESS;
    }

    public void i() {
        com.beizi.fusion.a aVar = this.h;
        if (aVar == null || !(aVar instanceof RewardedVideoAdListener)) {
            return;
        }
        ((RewardedVideoAdListener) aVar).onRewarded();
    }

    public void f(String str) {
        com.beizi.fusion.events.b bVar = this.F;
        if (bVar != null) {
            bVar.h.a(str, 4);
        }
    }

    private boolean d(com.beizi.fusion.work.a aVar) {
        if (aVar == null) {
            return false;
        }
        for (com.beizi.fusion.work.a aVar2 : q().values()) {
            AdSpacesBean.BuyerBean buyerBeanJ = aVar2.j();
            AdSpacesBean.BuyerBean buyerBeanJ2 = aVar.j();
            if (buyerBeanJ != null && buyerBeanJ2 != null && (TextUtils.isEmpty(buyerBeanJ.getBuyerSpaceUuId()) || TextUtils.isEmpty(buyerBeanJ2.getBuyerSpaceUuId()) || !buyerBeanJ.getBuyerSpaceUuId().equals(buyerBeanJ2.getBuyerSpaceUuId()))) {
                if (!b(aVar2) && !c(aVar2)) {
                    aa.c("BeiZis", "worker.getAdStatus():" + aVar2.h() + ":" + aVar2.f());
                    if (aVar2.h() != com.beizi.fusion.e.a.ADFAIL && e(aVar2) > e(aVar)) {
                        return false;
                    }
                } else {
                    double dF = f(aVar2);
                    if (aVar2.h() == com.beizi.fusion.e.a.ADDEFAULT || dF > e(aVar)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public com.beizi.fusion.events.b a() {
        return this.F;
    }

    public void a(ViewGroup viewGroup) {
        AdSpacesBean.ComponentBean component;
        List<AdSpacesBean.BuyerBean> buyer;
        AdSpacesBean.BidComponent bidComponent;
        List<AdSpacesBean> adSpaces;
        AdSpacesBean adSpacesBean;
        if (this.I || this.b == null || f4613a == null) {
            return;
        }
        this.U = System.currentTimeMillis();
        b.a().l();
        b.a().m();
        this.d = viewGroup;
        this.G = System.currentTimeMillis();
        this.e = ao.a();
        com.beizi.fusion.events.b bVarF = b.a().f();
        com.beizi.fusion.events.b bVar = new com.beizi.fusion.events.b(new EventBean(b.b, "", "", "", b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
        this.F = bVar;
        this.O = bVar.a();
        this.c = this.F.b();
        G();
        this.O.a(this.c);
        J();
        if (!BeiZis.isIsSyncInit() && ((bVarF == null || bVarF.f4666a.a() != 2) && !this.S)) {
            ResponseInfo.getInstance(f4613a).init();
            this.S = true;
        }
        if (bVarF != null) {
            aa.b("BeiZis", "mInitObserver.mInitStatus.getStatus() = " + bVarF.f4666a.a() + ",mManagerObserver.mGetLocalConfigStatus.getStatus() = " + this.F.b.a());
        }
        if ((bVarF != null && bVarF.f4666a.a() == 2 && this.F.b.a() == 0) || this.S) {
            this.F.b.a(1);
            if (this.F.b.a() == 1) {
                this.F.b.a(2);
                AdSpacesBean adSpacesBeanA = com.beizi.fusion.b.a.a(this.b, this.m, d());
                this.u = adSpacesBeanA;
                if (adSpacesBeanA != null) {
                    EventBean eventBean = this.c;
                    if (eventBean != null) {
                        eventBean.setPlatformFilterSsid(adSpacesBeanA.getFilterSsid());
                        this.c.setComponentSsid(this.u.getComponentSsid());
                        this.c.setBzComponentSsid(this.u.getBzComponentSsid());
                        K();
                    }
                    ResponseInfo responseInfo = ResponseInfo.getInstance(f4613a);
                    Manager manager = responseInfo.getManager();
                    if (manager == null || (adSpaces = manager.getAdSpaces()) == null || adSpaces.size() <= 0 || (adSpacesBean = adSpaces.get(0)) == null) {
                        component = null;
                        buyer = null;
                        bidComponent = null;
                    } else {
                        component = adSpacesBean.getComponent();
                        bidComponent = adSpacesBean.getBidComponent();
                        buyer = adSpacesBean.getBuyer();
                    }
                    if ((component != null || bidComponent != null) && buyer != null && buyer.size() > 0) {
                        long maxValidTime = responseInfo.getMaxValidTime();
                        if (maxValidTime == 0) {
                            maxValidTime = 2592000000L;
                        }
                        if (System.currentTimeMillis() - ((Long) an.b(f4613a, "lastUpdateTime", Long.valueOf(new Date(0L).getTime()))).longValue() <= maxValidTime) {
                            this.M = false;
                            this.I = true;
                            if (this.F.b.a() == 2) {
                                this.F.b.a(3);
                                if (H()) {
                                    return;
                                }
                                I();
                                if (this.F.c()) {
                                    this.F.b.a(-1);
                                    return;
                                } else {
                                    a(this.u);
                                    return;
                                }
                            }
                            return;
                        }
                        this.I = false;
                        this.M = true;
                        E();
                        return;
                    }
                    this.I = false;
                    E();
                    return;
                }
                Log.d("BeiZis", "spaceBean is null and return fail mUpdateConfigSuccess:" + this.L);
                if (this.L) {
                    if (this.F.b.a() == 2) {
                        int iA = com.beizi.fusion.b.a.a();
                        if (iA == 1) {
                            this.F.b.a(4);
                            a(10001);
                            return;
                        } else if (iA == 2) {
                            this.F.b.a(5);
                            a(10100);
                            return;
                        } else {
                            if (iA == 3) {
                                this.F.b.a(6);
                                a(10110);
                                return;
                            }
                            return;
                        }
                    }
                    this.F.b.a(-2);
                    a("kGetLocalConfigStatusInternalError");
                    return;
                }
                Log.e("BeiZis", "startUpdateConfig");
                this.I = false;
                E();
                return;
            }
            this.F.b.a(-2);
            a("kGetLocalConfigStatusInternalError");
            return;
        }
        if (this.L) {
            this.I = false;
            E();
        } else {
            a(10000);
        }
    }

    public void e(String str) {
        com.beizi.fusion.events.b bVar = this.F;
        if (bVar != null) {
            bVar.h.a(str, 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.beizi.fusion.work.a aVar, int i) {
        try {
            if (b(aVar) || c(aVar)) {
                ChannelBidResult channelBidResult = new ChannelBidResult();
                com.beizi.fusion.work.a aVar2 = this.i;
                if (aVar2 != null) {
                    channelBidResult.setBidType(aVar2.g());
                    channelBidResult.setChannelName(this.i.f());
                    channelBidResult.setReason(i);
                    channelBidResult.setEcpm(e(this.i));
                } else {
                    channelBidResult.setEcpm(0.0d);
                    channelBidResult.setChannelName(AdnName.OTHER);
                    channelBidResult.setBidType(AdnName.OTHER);
                    channelBidResult.setReason(i);
                }
                aVar.b(channelBidResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @NonNull
    private e m(String str) {
        f(str);
        return e.FAIL;
    }

    public boolean c(com.beizi.fusion.work.a aVar) {
        return "C2S".equalsIgnoreCase(aVar.g());
    }

    public void c(Map<String, Object> map) {
        this.V = map;
    }

    public void d(String str) {
        com.beizi.fusion.a aVar = this.h;
        if (aVar != null) {
            if (aVar instanceof AdListener) {
                ((AdListener) aVar).onAdClicked();
            } else if (aVar instanceof RewardedVideoAdListener) {
                ((RewardedVideoAdListener) aVar).onRewardedVideoClick();
            } else if (aVar instanceof NativeAdListener) {
                ((NativeAdListener) aVar).onAdClick();
            } else if (aVar instanceof InterstitialAdListener) {
                ((InterstitialAdListener) aVar).onAdClick();
            } else if (aVar instanceof NativeUnifiedAdListener) {
                ((NativeUnifiedAdListener) aVar).onAdClick();
            } else if (aVar instanceof com.beizi.fusion.b) {
                ((com.beizi.fusion.b) aVar).b();
            }
        }
        P();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        a(this.i, i);
        this.i.q();
        a(this.i.f(), this.i.o());
        if (!"4".equals(d()) || this.n) {
            return;
        }
        this.i.e();
        this.n = true;
    }

    public void b(String str) {
        if (this.y < 2 || j(str)) {
            if (this.P == 0) {
                this.P = this.Q;
            }
            Log.d("BeiZis", "AdShow:" + str);
            this.y = 2;
            com.beizi.fusion.a aVar = this.h;
            if (aVar != null) {
                if (aVar instanceof AdListener) {
                    ((AdListener) aVar).onAdShown();
                } else if (aVar instanceof RewardedVideoAdListener) {
                    ((RewardedVideoAdListener) aVar).onRewardedVideoAdShown();
                } else if (aVar instanceof NativeAdListener) {
                    ((NativeAdListener) aVar).onAdShown();
                } else if (aVar instanceof InterstitialAdListener) {
                    ((InterstitialAdListener) aVar).onAdShown();
                } else if (aVar instanceof NativeUnifiedAdListener) {
                    ((NativeUnifiedAdListener) aVar).onAdShown();
                } else if (aVar instanceof com.beizi.fusion.b) {
                    ((com.beizi.fusion.b) aVar).a();
                }
            }
            o();
            h();
        }
    }

    public void b(String str, View view) {
        com.beizi.fusion.a aVar = this.h;
        if (aVar != null && view != null && (aVar instanceof NativeAdListener)) {
            ((NativeAdListener) aVar).onAdClosed(view);
        }
        Q();
    }

    public boolean b(com.beizi.fusion.work.a aVar) {
        return "S2S".equalsIgnoreCase(aVar.g());
    }

    public void b(Map map) {
        if (map == null) {
            return;
        }
        try {
            com.beizi.fusion.work.a aVar = this.i;
            if (aVar != null) {
                aVar.b(map);
                return;
            }
            Map<String, com.beizi.fusion.work.a> mapQ = q();
            if (mapQ != null && mapQ.size() != 0) {
                for (com.beizi.fusion.work.a aVar2 : mapQ.values()) {
                    if (aVar2 != null && aVar2.f().equalsIgnoreCase("BEIZI")) {
                        aVar2.b(map);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
    }

    @Override // com.beizi.fusion.c.a
    public void a(String str) {
        aa.c("BeiZis", "enter handleAdRequestStatusError error is " + str);
        a(10131);
    }

    public void a(String str, final String str2, final EventItem eventItem) {
        if (Arrays.asList(m.f4740a).contains(str)) {
            s.a(str2, eventItem);
            com.beizi.fusion.tool.e.b().c().execute(new Runnable() { // from class: com.beizi.fusion.c.d.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.beizi.fusion.a.b.a(d.this.b).a(str2, eventItem);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void a(AdSpacesBean adSpacesBean) {
        if (this.F.b.a() == 3 && this.F.c.a() == 0) {
            this.F.c.a(1);
            this.j.clear();
            AdSpacesBean.FilterBean filter = adSpacesBean.getFilter();
            this.H = adSpacesBean.getBuyer();
            com.beizi.fusion.e.b.a(this.b, this.f, filter, this.F, g(), null, null, this);
            if (this.F.c.a() == 2) {
                if (this.F.c()) {
                    this.F.c.a(-1);
                    return;
                }
                a("200.000", this.m, new EventItem("200.000", String.valueOf(System.currentTimeMillis()), null, null));
                this.N = adSpacesBean;
                aa.c("BeiZis", "normal request");
                a(this.N.getComponent(), false);
                return;
            }
            a(this.F.c.a(), 6, "platform error = ");
            Log.d("BeiZis", "AdDispenses AdFilter fail:" + com.beizi.fusion.events.a.a(this.F.c));
            a(10130);
            return;
        }
        this.F.c.a(-2);
        a("kPlatformFilterStatusInternalError");
    }

    public void a(AdSpacesBean.ComponentBean componentBean, boolean z) {
        aa.a("BeiZis", "enter auctionAndRequestAd");
        if (this.u == null) {
            return;
        }
        List<AdSpacesBean.BuyerBean> list = this.H;
        if (list != null && list.size() != 0) {
            if (s() >= 1) {
                aa.a("BeiZis", "auctionAndRequestAd ad aleady callback");
                return;
            }
            if (!z) {
                this.F.d.a(1);
            }
            List<AdSpacesBean.ForwardBean> listA = a(componentBean, this.H, z);
            if (!z) {
                this.F.d.a(2);
            }
            ArrayList arrayList = new ArrayList();
            if (listA != null && listA.size() > 0) {
                for (AdSpacesBean.ForwardBean forwardBean : listA) {
                    if (a(forwardBean.getBuyerId(), this.H, forwardBean.getBuyerSpaceUuId()) != null) {
                        arrayList.add(forwardBean);
                    }
                }
            }
            d(a(arrayList));
            return;
        }
        aa.a("BeiZis", "auctionAndRequestAd mBuyerBeanList == null ");
    }

    private List<AdSpacesBean.ForwardBean> a(AdSpacesBean.ComponentBean componentBean, List<AdSpacesBean.BuyerBean> list, boolean z) {
        List<AdSpacesBean.ForwardBean> listA;
        AdSpacesBean adSpacesBean;
        ArrayList arrayList = new ArrayList();
        if (!z && (adSpacesBean = this.u) != null && adSpacesBean.getBid() != null && this.u.getBidComponent() != null && this.u.getBidComponent().getBidList() != null && this.u.getBidComponent().getBidList().size() > 0) {
            arrayList.addAll(this.u.getBidComponent().getBidList());
        }
        if (this.u != null && componentBean != null && (listA = com.beizi.fusion.e.b.a(componentBean, list, g())) != null && listA.size() > 0) {
            arrayList.addAll(listA);
        }
        return arrayList;
    }

    public Map<String, com.beizi.fusion.work.a> a(List<AdSpacesBean.ForwardBean> list) throws CloneNotSupportedException {
        AdSpacesBean.BuyerBean buyerBeanM44clone;
        if (list == null || list.size() == 0) {
            return null;
        }
        aa.a("BeiZis", "generateWorkers forwardBeans.size() = " + list.size());
        Hashtable hashtable = new Hashtable();
        for (int i = 0; i < list.size(); i++) {
            AdSpacesBean.ForwardBean forwardBean = list.get(i);
            if (forwardBean != null) {
                String buyerId = forwardBean.getBuyerId();
                String buyerSpaceUuId = forwardBean.getBuyerSpaceUuId();
                AdSpacesBean.BuyerBean buyerBeanA = a(buyerId, this.H, forwardBean.getBuyerSpaceUuId());
                if (buyerBeanA != null) {
                    try {
                        buyerBeanM44clone = buyerBeanA.m44clone();
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                        buyerBeanM44clone = null;
                    }
                    if (buyerBeanM44clone != null) {
                        this.O.a(buyerBeanM44clone, forwardBean);
                        this.F.e.a(buyerSpaceUuId, 1);
                        if (a(forwardBean, buyerBeanM44clone, buyerSpaceUuId)) {
                            com.beizi.fusion.work.a aVarA = a(forwardBean, buyerId, buyerBeanM44clone, buyerBeanM44clone.getRenderView(), null);
                            if (aVarA != null) {
                                aVarA.a(forwardBean.getSleepTime());
                                aVarA.a(forwardBean);
                                aVarA.a(buyerBeanM44clone);
                                aVarA.a(buyerBeanM44clone.getBidType());
                                a(buyerId, buyerSpaceUuId, aVarA);
                                hashtable.put(i(buyerId) + buyerSpaceUuId, aVarA);
                                aa.a("BeiZis", "generateWorkers put new " + buyerId + " worker into workerList");
                            }
                        }
                    }
                }
            }
        }
        return hashtable;
    }

    private boolean a(AdSpacesBean.ForwardBean forwardBean, AdSpacesBean.BuyerBean buyerBean, String str) {
        this.F.e.a(str, 2);
        if (buyerBean != null) {
            try {
                long jLongValue = ((Long) an.b(this.b, "complain_config_" + buyerBean.getSpaceId(), 0L)).longValue();
                AdSpacesBean.ComplainBean complain = buyerBean.getComplain();
                if (complain != null) {
                    if (System.currentTimeMillis() - jLongValue < complain.getDuration()) {
                        this.F.e.a(str, 10);
                        return false;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        com.beizi.fusion.e.b.a(this.b, this.f, buyerBean.getFilter(), this.F, g(), buyerBean.getBuyerSpaceUuId(), buyerBean.getSpaceId(), this);
        if (this.F.e.a(str) == 3) {
            if (this.F.c()) {
                this.F.e.a(str, -1);
                return false;
            }
            if (a(forwardBean, buyerBean) != 2) {
                return false;
            }
            this.F.e.a(str, 3);
            return true;
        }
        a(this.F.e.a(str), 7, "channel error = ");
        Log.d("BeiZis", "AdDispense buyerBean AdFilter fail:" + com.beizi.fusion.events.a.a(str, this.F.e));
        return false;
    }

    public e a(com.beizi.fusion.work.a aVar) {
        AdSpacesBean.BuyerBean buyerBeanJ = aVar.j();
        if (buyerBeanJ == null) {
            return null;
        }
        String id = buyerBeanJ.getId();
        String buyerSpaceUuId = buyerBeanJ.getBuyerSpaceUuId();
        String zone = buyerBeanJ.getZone();
        aa.a("BeiZis", "enter comparePrices compareWorker:" + aVar.f() + ",mCurrentHighestWorker:" + this.i);
        if (j(aVar.f())) {
            return a(buyerSpaceUuId, aVar, id);
        }
        com.beizi.fusion.events.b bVar = this.F;
        if (bVar != null) {
            bVar.h.a(buyerSpaceUuId, 1);
        }
        if (this.y >= 1) {
            b(aVar, 1);
            return m(buyerSpaceUuId);
        }
        if (L()) {
            return a(buyerSpaceUuId, aVar);
        }
        boolean zH = h(zone);
        boolean zD = d(aVar);
        StringBuilder sb = new StringBuilder();
        sb.append("channel == mTimeStage = ");
        sb.append(this.z == this.B);
        sb.append(";isNeedComparePrices = ");
        sb.append(zH);
        sb.append(",isHighestPrice:");
        sb.append(zD);
        sb.append(";mCurrentHighestWorker:");
        sb.append(this.i);
        aa.a("BeiZis", sb.toString());
        if (this.z == this.A && zH && !zD) {
            double dE = e(aVar);
            double dE2 = e(this.i);
            if (this.i != null && dE <= dE2) {
                b(aVar, 1);
                if (d(this.i)) {
                    b(1);
                }
                return m(buyerSpaceUuId);
            }
            return a(buyerSpaceUuId, aVar);
        }
        return a(buyerSpaceUuId, aVar, id);
    }

    private void a(com.beizi.fusion.work.a aVar, int i) {
        if (aVar == null) {
            return;
        }
        for (com.beizi.fusion.work.a aVar2 : q().values()) {
            AdSpacesBean.BuyerBean buyerBeanJ = aVar2.j();
            AdSpacesBean.BuyerBean buyerBeanJ2 = aVar.j();
            if (buyerBeanJ != null && buyerBeanJ2 != null && (TextUtils.isEmpty(buyerBeanJ.getBuyerSpaceUuId()) || TextUtils.isEmpty(buyerBeanJ2.getBuyerSpaceUuId()) || !buyerBeanJ.getBuyerSpaceUuId().equals(buyerBeanJ2.getBuyerSpaceUuId()))) {
                b(aVar2, i);
                if (aVar2.at() == e.TO_DETERMINE) {
                    f(buyerBeanJ.getBuyerSpaceUuId());
                } else if (aVar2.h() == com.beizi.fusion.e.a.ADDEFAULT) {
                    e(buyerBeanJ.getBuyerSpaceUuId());
                }
            }
        }
    }

    private void a(String str, String str2, com.beizi.fusion.work.a aVar) {
        this.j.put(i(str) + "_" + str2, aVar);
    }

    @Nullable
    public AdSpacesBean.BuyerBean a(String str, List<AdSpacesBean.BuyerBean> list, String str2) {
        return com.beizi.fusion.e.b.a(str, list, str2);
    }

    public void a(int i, int i2, String str) {
        if (i != i2 || s.c(this.m) == null) {
            return;
        }
        s.d(str + s.c(this.m).toString());
    }

    private int a(AdSpacesBean.ForwardBean forwardBean, AdSpacesBean.BuyerBean buyerBean) {
        if (forwardBean == null || buyerBean == null) {
            return 0;
        }
        String buyerSpaceUuId = buyerBean.getBuyerSpaceUuId();
        if (this.F.e.a(buyerSpaceUuId) == 3) {
            this.F.f.a(buyerSpaceUuId, 1);
            if (this.F.f.a(buyerSpaceUuId) == 1) {
                if (this.f <= (forwardBean.getSleepTime() + System.currentTimeMillis()) - this.G) {
                    this.F.f.a(buyerSpaceUuId, 4);
                    return 4;
                }
                if (this.F.j.a() == 2) {
                    this.F.f.a(buyerSpaceUuId, 6);
                    return 6;
                }
                aa.a("BeiZis", "mUsableTime = " + this.f + " forwardBean.getSleepTime() + System.currentTimeMillis() - mEnterRequestMethodTime = " + ((forwardBean.getSleepTime() + System.currentTimeMillis()) - this.G) + ",forwardBean.getSleepTime() = " + forwardBean.getSleepTime());
                if (this.F.c()) {
                    this.F.f.a(buyerSpaceUuId, -1);
                    return -1;
                }
                this.F.f.a(buyerSpaceUuId, 2);
                return 2;
            }
        }
        this.F.f.a(buyerSpaceUuId, -2);
        return -2;
    }

    public void a(AdSpacesBean.ComponentBean componentBean, String str, boolean z, int i) {
        if (componentBean != null && (TextUtils.isEmpty(str) || (!"C2S".equalsIgnoreCase(str) && !"S2S".equalsIgnoreCase(str)))) {
            a(componentBean, true);
            return;
        }
        com.beizi.fusion.work.a aVar = this.i;
        if (aVar != null && d(aVar)) {
            b(1);
        } else {
            a(i);
        }
    }

    public void a(String str, View view) {
        Log.d("BeiZis", "AdLoaded:" + str);
        if (this.l) {
            return;
        }
        R();
        a(this.i, 1);
        this.l = true;
        this.y = 1;
        B();
        C();
        com.beizi.fusion.a aVar = this.h;
        if (aVar != null) {
            if (aVar instanceof AdListener) {
                ((AdListener) aVar).onAdLoaded();
            } else if (aVar instanceof RewardedVideoAdListener) {
                ((RewardedVideoAdListener) aVar).onRewardedVideoAdLoaded();
            } else if (aVar instanceof InterstitialAdListener) {
                ((InterstitialAdListener) aVar).onAdLoaded();
            } else if (aVar instanceof NativeAdListener) {
                if (view != null) {
                    com.beizi.fusion.work.a aVar2 = this.i;
                    if (aVar2 != null && aVar2.aq() == 1) {
                        ((NativeAdListener) this.h).onAdLoaded(null);
                    } else {
                        com.beizi.fusion.work.a aVar3 = this.i;
                        if (aVar3 != null && aVar3.o() != null) {
                            ((NativeAdListener) this.h).onAdLoaded(this.i.o());
                        } else {
                            e();
                        }
                    }
                } else {
                    e();
                }
            } else if (aVar instanceof NativeUnifiedAdListener) {
                ((NativeUnifiedAdListener) aVar).onAdLoaded(this.i.as());
            }
        }
        O();
        r = true;
    }

    public void a(String str, int i) {
        com.beizi.fusion.a aVar = this.h;
        if (aVar != null) {
            if (aVar instanceof AdListener) {
                ((AdListener) aVar).onAdFailedToLoad(i);
            } else if (aVar instanceof RewardedVideoAdListener) {
                ((RewardedVideoAdListener) aVar).onRewardedVideoAdFailedToLoad(i);
            } else if (aVar instanceof NativeAdListener) {
                ((NativeAdListener) aVar).onAdFailed(i);
            } else if (aVar instanceof InterstitialAdListener) {
                ((InterstitialAdListener) aVar).onAdFailed(i);
            } else if (aVar instanceof NativeUnifiedAdListener) {
                ((NativeUnifiedAdListener) aVar).onAdFailed(i);
            } else if (aVar instanceof com.beizi.fusion.b) {
                ((com.beizi.fusion.b) aVar).a(i);
            }
        }
        B();
        C();
        this.y = 3;
        p();
        r = true;
    }

    public void a(int i) {
        if (i != 10140) {
            if (this.y >= 1) {
                return;
            }
            if (i != 9999 && (L() || M())) {
                return;
            }
        }
        if (b.a().j() && i == 9999) {
            i = 3;
        }
        com.beizi.fusion.a aVar = this.h;
        if (aVar != null) {
            if (aVar instanceof AdListener) {
                ((AdListener) aVar).onAdFailedToLoad(i);
            } else if (aVar instanceof RewardedVideoAdListener) {
                ((RewardedVideoAdListener) aVar).onRewardedVideoAdFailedToLoad(i);
            } else if (aVar instanceof NativeAdListener) {
                ((NativeAdListener) aVar).onAdFailed(i);
            } else if (aVar instanceof InterstitialAdListener) {
                ((InterstitialAdListener) aVar).onAdFailed(i);
            } else if (aVar instanceof NativeUnifiedAdListener) {
                ((NativeUnifiedAdListener) aVar).onAdFailed(i);
            } else if (aVar instanceof com.beizi.fusion.b) {
                ((com.beizi.fusion.b) aVar).a(i);
            }
        }
        B();
        C();
        this.y = 3;
        p();
        r = true;
    }

    public void a(long j) {
        com.beizi.fusion.a aVar = this.h;
        if (aVar == null || !(aVar instanceof AdListener)) {
            return;
        }
        ((AdListener) aVar).onAdTick(j);
    }

    @NonNull
    private e a(String str, com.beizi.fusion.work.a aVar) {
        aa.a("BeiZis", "comparePrices handleCompeteToDetermine worker:" + aVar.f());
        this.i = aVar;
        this.F.h.a(str, 2);
        C();
        return e.TO_DETERMINE;
    }

    @NonNull
    private e a(String str, com.beizi.fusion.work.a aVar, String str2) {
        if (!this.E) {
            a(aVar, str2);
            B();
            C();
            return l(str);
        }
        b(aVar, 1);
        return m(str);
    }

    private void a(com.beizi.fusion.work.a aVar, String str) {
        this.E = true;
        aa.a("BeiZis", "---handleCompeteSuccess---" + str + "---" + e(aVar));
        this.i = aVar;
        a(aVar, 1);
    }

    public void a(com.beizi.fusion.a aVar) {
        this.h = aVar;
    }

    public void a(boolean z) {
        this.s = z;
    }

    public void a(Map map) {
        com.beizi.fusion.work.a aVar = this.i;
        if (aVar == null || map == null) {
            return;
        }
        aVar.a(map);
    }

    private void a(JSONObject jSONObject) {
        Map<String, Object> map;
        JSONObject jSONObjectAx;
        if (jSONObject == null) {
            return;
        }
        try {
            if (this.i == null || (map = this.V) == null || !map.containsKey("materialInfo") || (jSONObjectAx = this.i.ax()) == null || !jSONObjectAx.has("materialInfo")) {
                return;
            }
            jSONObject.put("materialInfo", jSONObjectAx.optJSONObject("materialInfo"));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
