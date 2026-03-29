package com.beizi.fusion.work;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.beizi.fusion.NativeUnifiedAdResponse;
import com.beizi.fusion.c.c;
import com.beizi.fusion.c.d;
import com.beizi.fusion.c.e;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.events.b;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.ChannelBidResult;
import com.beizi.fusion.model.EventItem;
import com.beizi.fusion.tool.aa;
import java.util.Map;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class a extends Observable implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected b f4818a;
    protected EventBean b;
    protected String c;
    protected d d;
    protected AdSpacesBean.BuyerBean e;
    protected AdSpacesBean.ForwardBean f;
    protected String h;
    protected String i;
    protected e g = null;
    protected com.beizi.fusion.e.a j = com.beizi.fusion.e.a.ADDEFAULT;
    private int n = 0;
    private int o = 0;
    private int p = 0;
    private int q = 0;
    private boolean r = false;
    private long s = 0;
    private boolean t = false;
    private boolean u = false;
    private boolean v = false;
    private boolean w = false;
    private TimerTask x = null;
    private Timer y = null;
    private long z = 0;
    private boolean A = false;
    private String B = "WATERFALL";
    private int C = 0;
    private boolean D = false;
    private boolean E = false;
    private String F = null;
    protected int k = 0;
    protected long l = 0;

    @SuppressLint({"HandlerLeak"})
    protected Handler m = new Handler(Looper.getMainLooper()) { // from class: com.beizi.fusion.work.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                d dVar = a.this.d;
                if (dVar == null || dVar.s() >= 1 || a.this.d.r() == 2) {
                    return;
                }
                a.this.k();
                return;
            }
            if (i == 2) {
                aa.b("BeiZis", "before handleAdClose");
                a.this.F();
                a.this.aa();
            } else if (i == 3 && message.obj != null) {
                a.this.a(message);
                a.this.ae();
                if (a.this.c()) {
                    return;
                }
                a.this.c(message.arg1);
            }
        }
    };
    private boolean G = false;
    private boolean H = false;

    private boolean ay() {
        b bVar = this.f4818a;
        return (bVar == null || bVar.c()) ? false : true;
    }

    private void az() {
        Timer timer;
        StringBuilder sb = new StringBuilder();
        sb.append("mAdLifeManager != null ? ");
        sb.append(this.d != null);
        aa.c("BeiZis", sb.toString());
        if (this.d != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("enter cancelExposureTaskIfNeed (System.currentTimeMillis() - mStartLoadTime) = ");
            sb2.append(System.currentTimeMillis() - this.z);
            sb2.append(",mAdLifeManager.getValidExposureTime() = ");
            sb2.append(this.d.u());
            sb2.append(",mExposureTimerTask != null ? ");
            sb2.append(this.x != null);
            sb2.append(",mExposureTimer != null ? ");
            sb2.append(this.y != null);
            aa.c("BeiZis", sb2.toString());
        }
        if (this.d == null || System.currentTimeMillis() - this.z >= this.d.u() || this.x == null || (timer = this.y) == null) {
            return;
        }
        timer.cancel();
        W();
    }

    public void A() {
        if (ay()) {
            af();
            if (y()) {
                K();
                a(3);
            }
            aa.c("BeiZis", "channel " + this.c + " reportAdLoadFail mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f4818a.g.a(this.c));
            if (b()) {
                return;
            }
            this.f4818a.g.a(this.c, 11);
        }
    }

    public void B() {
        if (this.f4818a != null) {
            aa.c("BeiZis", "channel " + this.c + " reportAdShow mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f4818a.g.a(this.c));
            this.f4818a.g.a(this.c, 5);
        }
    }

    public void C() {
        if (this.f4818a != null) {
            aa.c("BeiZis", "channel " + this.c + " reportAdExposure mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f4818a.g.a(this.c));
            this.f4818a.g.a(this.c, 6);
        }
    }

    public void D() {
        if (this.f4818a != null) {
            aa.c("BeiZis", "channel " + this.c + " reportAdClick mManagerObserver.mChannelResultStatus.getStatus(channel)  = " + this.f4818a.g.a(this.c));
            this.f4818a.g.a(this.c, 7);
        }
    }

    public void E() {
        if (this.f4818a != null) {
            aa.c("BeiZis", "channel " + this.c + " reportAdClickCallBack mManagerObserver.mChannelResultStatus.getStatus(channel)  = " + this.f4818a.g.a(this.c));
            this.f4818a.g.a(this.c, 17);
        }
    }

    public void F() {
        if (this.f4818a != null) {
            aa.c("BeiZis", "channel " + this.c + " reportAdClose mManagerObserver.mChannelResultStatus.getStatus(channel)  = " + this.f4818a.g.a(this.c));
            this.f4818a.g.a(this.c, 9);
        }
    }

    public void G() {
        if (this.f4818a != null) {
            aa.c("BeiZis", "channel " + this.c + " reportAdClickClose mManagerObserver.mChannelResultStatus.getStatus(channel)  = " + this.f4818a.g.a(this.c));
            this.f4818a.g.a(this.c, 8);
        }
    }

    public void H() {
        if (this.f4818a != null) {
            aa.c("BeiZis", "channel " + this.c + " reportAdClickCallBack mManagerObserver.mChannelResultStatus.getStatus(channel)  = " + this.f4818a.g.a(this.c));
            this.f4818a.g.a(this.c, 22);
        }
    }

    public void I() {
        if (this.f4818a != null) {
            aa.c("BeiZis", "channel " + this.c + " reportAdRewarded mManagerObserver.mChannelResultStatus.getStatus(channel)  = " + this.f4818a.g.a(this.c));
            this.f4818a.g.a(this.c, 12);
        }
    }

    public void J() {
        if (this.f4818a == null || this.E) {
            return;
        }
        aa.c("BeiZis", "channel " + this.c + " reportParticipateBid mManagerObserver.mBidChannelStatus.getStatus(channel)  = " + this.f4818a.k.a(this.c));
        this.E = true;
    }

    public void K() {
        if (this.f4818a != null) {
            aa.c("BeiZis", "channel " + this.c + " reportParticipateBid mManagerObserver.mBidChannelStatus.getStatus(channel)  = " + this.f4818a.k.a(this.c));
        }
    }

    public void L() {
        b bVar = this.f4818a;
        if (bVar != null) {
            bVar.h.a(this.c, 3);
            aa.a("BeiZis", "channel == ---reportComparisonSuccess---" + f());
        }
    }

    public void M() {
        b bVar = this.f4818a;
        if (bVar != null) {
            bVar.h.a(this.c, 8);
            aa.a("BeiZis", "channel == ---reportComparisonSendWinNotification---" + f());
        }
    }

    public void N() {
        b bVar = this.f4818a;
        if (bVar != null) {
            bVar.h.a(this.c, 9);
            aa.a("BeiZis", "channel == ---reportComparisonSendLossNotification---" + f());
        }
    }

    public void O() {
        b bVar = this.f4818a;
        if (bVar != null) {
            bVar.h.a(this.c, 1);
            this.f4818a.h.a(this.c, 4);
        }
    }

    public void P() {
        O();
    }

    public void Q() {
        b bVar = this.f4818a;
        if (bVar != null) {
            bVar.h.a(this.c, 4);
        }
    }

    public void R() {
        if (this.f4818a != null) {
            aa.c("BeiZis", "channel " + this.c + " reportChannelClickEnhance GrayPass mManagerObserver.mChannelClickEnhanceStatus.getStatus(channel)  = " + this.f4818a.i.a(this.c));
            this.f4818a.i.a(this.c, 1);
        }
    }

    public void S() {
        if (this.f4818a != null) {
            aa.c("BeiZis", "channel " + this.c + " reportChannelClickEnhance RandomPass mManagerObserver.mChannelClickEnhanceStatus.getStatus(channel)  = " + this.f4818a.i.a(this.c));
            this.f4818a.i.a(this.c, 2);
        }
    }

    public void T() {
        if (this.f4818a != null) {
            aa.c("BeiZis", "channel " + this.c + " reportChannelClickEnhance LayerPass mManagerObserver.mChannelClickEnhanceStatus.getStatus(channel)  = " + this.f4818a.i.a(this.c));
            this.f4818a.i.a(this.c, 3);
        }
    }

    public void U() {
        if (this.f4818a != null) {
            aa.c("BeiZis", "channel " + this.c + " reportChannelClickEnhance ReduceArea mManagerObserver.mChannelClickEnhanceStatus.getStatus(channel)  = " + this.f4818a.i.a(this.c));
            this.f4818a.i.a(this.c, 4);
        }
    }

    public void V() {
        if (this.f4818a != null) {
            aa.c("BeiZis", "channel " + this.c + " reportValidTimeExposure mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f4818a.g.a(this.c));
            this.f4818a.g.a(this.c, 13);
        }
    }

    public void W() {
        if (this.f4818a != null) {
            aa.c("BeiZis", "channel " + this.c + " reportNotEnoughExposureTime mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f4818a.g.a(this.c));
            this.f4818a.g.a(this.c, 14);
        }
    }

    public boolean X() {
        if (this.d != null) {
            aa.c("BeiZis", "adStatus = " + this.d.s());
        }
        d dVar = this.d;
        return dVar != null && dVar.s() < 1;
    }

    public boolean Y() {
        d dVar = this.d;
        return dVar != null && dVar.f() && (am() || ak());
    }

    public void Z() {
        if (this.g == null && this.d != null && ay()) {
            this.g = this.d.a(this);
        }
    }

    public void a(Activity activity) {
    }

    public void aa() {
        if ((this.t || this.d == null) && !b(f())) {
            return;
        }
        this.d.c(f());
        this.t = true;
        if (this.A) {
            az();
        }
    }

    public void ab() {
        if (this.d == null || !an()) {
            return;
        }
        d dVar = this.d;
        dVar.a("255.200", dVar.g(), new EventItem("255.200", String.valueOf(System.currentTimeMillis()), f(), this.i));
    }

    public void ac() {
        if (this.d == null || !an()) {
            return;
        }
        d dVar = this.d;
        dVar.a("280.300", dVar.g(), new EventItem("280.300", String.valueOf(System.currentTimeMillis()), f(), this.i));
    }

    public void ad() {
        if (this.d == null || !an()) {
            return;
        }
        d dVar = this.d;
        dVar.a("290.300", dVar.g(), new EventItem("290.300", String.valueOf(System.currentTimeMillis()), f(), this.i));
    }

    public void ae() {
        if (this.d == null || !an()) {
            return;
        }
        d dVar = this.d;
        dVar.a("280.500", dVar.g(), new EventItem("280.500", String.valueOf(System.currentTimeMillis()), f(), this.i));
    }

    public void af() {
        if (ah()) {
            b(3);
        }
    }

    public void ag() {
        if (p() != 3) {
            aa.a("BeiZisBid", "mWorker = " + this + ",set ad suc");
            b(2);
        }
    }

    public boolean ah() {
        return ai();
    }

    public boolean ai() {
        return "C2S".equalsIgnoreCase(g());
    }

    public boolean aj() {
        return "S2S".equalsIgnoreCase(g());
    }

    public boolean ak() {
        return aj() || ai();
    }

    public boolean al() {
        return "BPDI".equalsIgnoreCase(g());
    }

    public boolean am() {
        return an() || al();
    }

    public boolean an() {
        return "WATERFALL".equalsIgnoreCase(g());
    }

    public void ao() {
        b bVar = this.f4818a;
        if (bVar != null) {
            bVar.a().a(this.c, this.b);
        }
    }

    public void ap() {
        A();
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(10140);
        }
    }

    public int aq() {
        return this.k;
    }

    public void ar() {
        if (this.f4818a == null || !"C2S".equalsIgnoreCase(g())) {
            return;
        }
        aa.c("BeiZis", "channel " + this.c + " reportC2SPrice mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f4818a.g.a(this.c));
        this.f4818a.g.a(this.c, 20);
    }

    public NativeUnifiedAdResponse as() {
        return null;
    }

    public e at() {
        return this.g;
    }

    public void au() {
        this.l = System.currentTimeMillis() + 1000;
    }

    public Map av() {
        return null;
    }

    public String aw() {
        return null;
    }

    public JSONObject ax() {
        return null;
    }

    public void b(ChannelBidResult channelBidResult) {
    }

    public boolean c() {
        return this.D;
    }

    public abstract void d();

    public abstract void e();

    public abstract String f();

    public String g() {
        return this.B;
    }

    public abstract com.beizi.fusion.e.a h();

    public String i() {
        return null;
    }

    public AdSpacesBean.BuyerBean j() {
        return this.e;
    }

    public abstract void k();

    public void l() {
        Handler handler = this.m;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public View o() {
        return null;
    }

    public int p() {
        return this.p;
    }

    public void q() {
        L();
    }

    public void r() {
        d dVar = this.d;
        if (dVar != null) {
            this.f4818a = dVar.a();
        }
        AdSpacesBean.BuyerBean buyerBean = this.e;
        if (buyerBean != null) {
            this.c = buyerBean.getBuyerSpaceUuId();
        }
    }

    public void s() {
        b bVar = this.f4818a;
        if (bVar != null) {
            bVar.a().a(this.e, this.f);
        }
    }

    public void t() {
        if (this.f4818a != null) {
            aa.c("BeiZis", "channel " + this.c + " reportInitBegin mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f4818a.g.a(this.c));
            this.f4818a.g.a(this.c, 1);
        }
    }

    public void u() {
        if (this.f4818a != null) {
            aa.c("BeiZis", "channel " + this.c + " reportInitEnd mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f4818a.g.a(this.c));
            this.f4818a.g.a(this.c, 2);
        }
    }

    public void v() {
        if (this.f4818a != null) {
            aa.c("BeiZis", "channel " + this.c + " reportAdRequest mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f4818a.g.a(this.c));
            this.f4818a.g.a(this.c, 3);
        }
    }

    public boolean w() {
        return this.G;
    }

    public void x() {
        if (ay()) {
            if (ai()) {
                ar();
            }
            if (y()) {
                a(2);
                J();
            }
            z();
            aa.c("BeiZis", "channel " + this.c + " reportAdLoaded mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f4818a.g.a(this.c));
            if (b()) {
                return;
            }
            this.f4818a.g.a(this.c, 4);
        }
    }

    public boolean y() {
        return ah() && !w();
    }

    public void a(Context context) {
    }

    public void b(Map map) {
    }

    public void c(int i) {
        AdSpacesBean.BuyerBean buyerBean;
        if (this.j == com.beizi.fusion.e.a.ADLOAD && (buyerBean = this.e) != null && !TextUtils.isEmpty(buyerBean.getBuyerSpaceUuId()) && !TextUtils.isEmpty(this.d.v()) && this.e.getBuyerSpaceUuId().equals(this.d.v())) {
            this.j = com.beizi.fusion.e.a.ADFAIL;
            this.d.a(this.e.getBuyerSpaceUuId(), i);
            return;
        }
        this.j = com.beizi.fusion.e.a.ADFAIL;
        if (this.d == null || this.f == null) {
            return;
        }
        if (X()) {
            this.d.a(this.f.getComponent(), g(), true, i);
        } else {
            aa.b("BeiZis", "fail distribute direct fail");
            this.d.a(i);
        }
    }

    private boolean b(String str) {
        return false;
    }

    public void a(ChannelBidResult channelBidResult) {
    }

    public void a(Map map) {
    }

    public void b(int i) {
        this.p = i;
    }

    private boolean b() {
        return ah() && w();
    }

    public void a(String str) {
        this.B = str;
    }

    public void a(AdSpacesBean.ForwardBean forwardBean) {
        this.f = forwardBean;
    }

    public void a(AdSpacesBean.BuyerBean buyerBean) {
        this.e = buyerBean;
    }

    public void a(boolean z) {
        this.r = z;
    }

    public void a(long j) {
        this.s = j;
    }

    public void a(int i) {
        this.n = i;
    }

    @Override // com.beizi.fusion.c.c
    public void a() {
        if (h() != com.beizi.fusion.e.a.ADSHOW) {
            Q();
        }
    }

    public void a(Message message) {
        EventBean eventBean;
        if (this.f4818a == null || (eventBean = this.b) == null) {
            return;
        }
        eventBean.setError(String.valueOf(message.obj));
        this.b.setErrorCode(String.valueOf(message.arg1));
        ao();
        A();
        this.b.setError(null);
        this.b.setErrorCode(null);
        ao();
    }

    public void m() {
    }

    public void n() {
    }

    public void z() {
    }

    public void a(String str, int i) {
        if (ay()) {
            Message messageObtainMessage = this.m.obtainMessage(3, str);
            messageObtainMessage.arg1 = i;
            this.m.sendMessage(messageObtainMessage);
        }
    }

    public void a(double d) {
        if (d > 0.0d) {
            if ("BEIZI".equalsIgnoreCase(f())) {
                this.e.setAvgPrice(d);
                EventBean eventBean = this.b;
                if (eventBean != null) {
                    eventBean.setBeiZiPrice(String.valueOf(d));
                }
            }
            if (ak()) {
                this.e.setBidPrice(d);
                EventBean eventBean2 = this.b;
                if (eventBean2 != null) {
                    eventBean2.setBidPrice(String.valueOf(d));
                }
            }
            ao();
        }
    }
}
