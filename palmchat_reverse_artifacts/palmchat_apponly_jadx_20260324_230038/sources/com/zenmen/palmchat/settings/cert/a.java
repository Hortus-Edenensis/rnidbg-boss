package com.zenmen.palmchat.settings.cert;

import android.app.Activity;
import android.util.Log;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.settings.cert.bean.CertVo;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.an1;
import defpackage.az2;
import defpackage.go2;
import defpackage.l50;
import defpackage.ot4;
import defpackage.pm5;
import defpackage.sw4;
import defpackage.ve;
import defpackage.vm0;
import defpackage.zw4;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static a c = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<b> f15295a;
    public boolean b = false;

    /* JADX INFO: renamed from: com.zenmen.palmchat.settings.cert.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C1105a extends go2<LXBaseNetBean<CertVo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f15296a;

        public C1105a(b bVar) {
            this.f15296a = bVar;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, vm0.h1, new HashMap());
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<CertVo> lXBaseNetBean, Exception exc) {
            Log.e("performRequestAsync", "onResult=" + az2.c(lXBaseNetBean));
            if (!z || lXBaseNetBean == null || !lXBaseNetBean.isSuccess()) {
                this.f15296a.onResult(false);
                return;
            }
            CertVo certVo = lXBaseNetBean.data;
            if (certVo == null || certVo.realName != 1) {
                this.f15296a.onResult(false);
            } else {
                this.f15296a.onResult(true);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void onResult(boolean z);
    }

    public static a a() {
        return c;
    }

    public void b(b bVar) {
        zw4.e(new C1105a(bVar));
    }

    public final void c() {
        if (this.b) {
            return;
        }
        this.b = true;
        try {
            an1.c().p(this);
        } catch (Exception unused) {
        }
    }

    public void d(Activity activity, b bVar) {
        try {
            activity.getWindow().getDecorView().setTag(R.id.tag_activity_realname_callback, bVar);
        } catch (Throwable th) {
            LogUtil.i("CertManager", "bind fail", th);
        }
        ve.s(activity, "zenxin://activity?page=a0052&pkgId=lwsyv2&urlExtra=%23%2Fverified%3Fstatus%3D0%26from%3D1", false);
        if (bVar != null) {
            this.f15295a = new WeakReference<>(bVar);
            c();
        }
    }

    @pm5(threadMode = ThreadMode.MAIN)
    public void onRealNameResultEvent(ot4 ot4Var) {
        WeakReference<b> weakReference;
        LogUtil.i("CertManager", "onRealNameResultEvent RealNameResultEvent= " + ot4Var + " certCallbackWeakReference=" + this.f15295a);
        if (l50.a() || (weakReference = this.f15295a) == null) {
            return;
        }
        b bVar = weakReference.get();
        LogUtil.i("CertManager", "callback = " + bVar);
        if (bVar == null) {
            return;
        }
        LogUtil.i("CertManager", "onResult resp= " + ot4Var.f19873a);
        bVar.onResult(ot4Var.f19873a == 0);
        this.f15295a = null;
    }
}
