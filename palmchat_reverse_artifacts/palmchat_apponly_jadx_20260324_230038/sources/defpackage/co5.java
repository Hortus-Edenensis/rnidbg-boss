package defpackage;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.conversations.threadsnew.ThreadsNewFragment;
import com.zenmen.palmchat.conversations.threadsnew.headerview.ThreadHeaderViewV5;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.paidservices.superexpose.bean.SuperExposeInfo;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class co5 implements bo5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f2494a;
    public ThreadsNewFragment b;
    public ThreadHeaderViewV5 c;
    public jo5 d;
    public ho5 e;
    public Handler f;
    public Activity g;
    public boolean h;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f2495a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        public a(int i, boolean z, boolean z2) {
            this.f2495a = i;
            this.b = z;
            this.c = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            co5.this.d.d(this.f2495a, co5.this.e.l(), co5.this.e.k(), this.b, this.c);
        }
    }

    public co5(Context context, ThreadsNewFragment threadsNewFragment, ThreadHeaderViewV5 threadHeaderViewV5) {
        this.f2494a = null;
        this.b = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        LogUtil.d("SuperExposeMsgTab", "SuperExposeMsgTabControl start");
        fo5.j(this);
        ds0.a().c(this);
        this.f2494a = context;
        this.b = threadsNewFragment;
        this.g = threadsNewFragment.getActivity();
        this.c = threadHeaderViewV5;
        this.f = new Handler(this.f2494a.getMainLooper());
        this.d = new jo5(this.f2494a, this.c, this);
        this.e = new ho5(this.f2494a, this);
    }

    @Override // defpackage.bo5
    public void a(LXBaseNetBean<SuperExposeInfo> lXBaseNetBean) {
        LogUtil.d("", "SuperExposeMsgTabViewT superExposeStatusChange result " + lXBaseNetBean);
        if (lXBaseNetBean != null) {
            this.e.t(lXBaseNetBean, true, false);
        }
    }

    @Override // defpackage.bo5
    public void b(int i, boolean z, boolean z2) {
        this.f.post(new a(i, z, z2));
    }

    @Override // defpackage.bo5
    public void c(int i) {
        if (this.g != null) {
            i("boost_message_promotion_purchaseClick", 1);
            com.zenmen.palmchat.paidservices.superexpose.a.b().g(this.g, 0, i, false);
        }
    }

    @Override // defpackage.bo5
    public void d(int i, int i2) {
        if (this.g != null) {
            i("boost_message_promotion_purchaseClick", 2);
            bj5.b().a().I(this.g, i, 0, i2, fo5.l);
        }
    }

    public void g(int i) {
        this.d.a(i);
    }

    public void h() {
        this.d.c();
        ds0.a().d(this);
    }

    public final void i(String str, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DeviceInfoUtil.UID_TAG, v4.e(this.f2494a));
            jSONObject.put("deviceId", ac1.h);
            jSONObject.put("orderStatus", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.g(str, jSONObject);
    }

    public void j(boolean z, boolean z2) {
        this.h = z;
        LogUtil.d("SuperExposeMsgTab", "SuperExposeMsgTabControl visibleShow show " + z);
        if (z) {
            hs3.e();
            this.e.q(z2);
        }
        this.d.e(z);
    }

    @qm5
    public void onSuperExposeEvent(xn5 xn5Var) {
        if (xn5Var != null && xn5Var.f22014a == 0 && this.h) {
            b05.d("收到onSuperExposeEvent通知");
            j(true, true);
        }
    }
}
