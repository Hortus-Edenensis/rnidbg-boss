package com.zenmen.palmchat.paidservices.superexpose;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.paidservices.superexpose.bean.Fredata;
import com.zenmen.palmchat.paidservices.superexpose.bean.SuperExposeDialogInfo;
import com.zenmen.palmchat.paidservices.superexpose.bean.SuperExposeInfo;
import com.zenmen.palmchat.paidservices.superexpose.dialog.SuperBuyDialogBaseActivity;
import com.zenmen.palmchat.paidservices.superexpose.dialog.SuperExposeDialogView;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ap3;
import defpackage.az2;
import defpackage.b05;
import defpackage.cd1;
import defpackage.dn0;
import defpackage.fo5;
import defpackage.go2;
import defpackage.ir5;
import defpackage.nl0;
import defpackage.sw4;
import defpackage.v4;
import defpackage.zw4;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a {
    public static a b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f14798a;

    /* JADX INFO: renamed from: com.zenmen.palmchat.paidservices.superexpose.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C1084a extends go2<LXBaseNetBean<Fredata>> {
        public C1084a() {
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, nl0.z + "/lbs.square.super.show.card.popup.v4", new HashMap()).f(false);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<Fredata> lXBaseNetBean, Exception exc) {
            LogUtil.i("performRequestAsync", "requestQuidConfig info onResult=" + az2.c(lXBaseNetBean));
            if (z && lXBaseNetBean.isSuccess()) {
                cd1.e(lXBaseNetBean.data);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends go2<LXBaseNetBean<SuperExposeDialogInfo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f14800a;

        public b(f fVar) {
            this.f14800a = fVar;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            ContactInfoItem contactInfoItemA;
            HashMap map = new HashMap();
            String strE = v4.e(com.zenmen.palmchat.c.b());
            if (!TextUtils.isEmpty(strE) && (contactInfoItemA = dn0.a(strE)) != null) {
                map.put("gender", Integer.valueOf(contactInfoItemA.getGender()));
            }
            LocationEx locationExI = com.zenmen.palmchat.location.d.g().i(86400000L);
            if (locationExI != null) {
                map.put("latitude", locationExI.getLatitude() + "");
                map.put("longitude", locationExI.getLongitude() + "");
                map.put("cityCode", locationExI.getCityCode() + "");
            }
            return sw4.b(1, ap3.c(), map).f(false);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x002e A[Catch: Exception -> 0x0036, TryCatch #0 {Exception -> 0x0036, blocks: (B:4:0x001c, B:6:0x0020, B:8:0x0024, B:10:0x002a, B:11:0x002e, B:13:0x0032), top: B:21:0x001c }] */
        @Override // defpackage.io2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResult(boolean z, LXBaseNetBean<SuperExposeDialogInfo> lXBaseNetBean, Exception exc) {
            SuperExposeDialogInfo superExposeDialogInfo;
            LogUtil.i("performRequestAsync", "requestSuperExposeDialogInfo info onResult=" + az2.c(lXBaseNetBean));
            if (lXBaseNetBean != null) {
                try {
                    if (lXBaseNetBean.resultCode != 0 || (superExposeDialogInfo = lXBaseNetBean.data) == null) {
                        f fVar = this.f14800a;
                        if (fVar != null) {
                            fVar.onFail(exc);
                        }
                    } else {
                        SuperExposeDialogInfo superExposeDialogInfo2 = superExposeDialogInfo;
                        f fVar2 = this.f14800a;
                        if (fVar2 != null) {
                            fVar2.a(superExposeDialogInfo2);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    f fVar3 = this.f14800a;
                    if (fVar3 != null) {
                        fVar3.onFail(e);
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends go2<LXBaseNetBean<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f14801a;

        public c(g gVar) {
            this.f14801a = gVar;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            map.put("freeScene", 2);
            map.put("freeSubScene", 2);
            map.put("num", 1);
            return sw4.b(1, nl0.z + "/lbs.square.super.show.receive.card.v7", map).f(true);
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0028 A[Catch: Exception -> 0x0030, TryCatch #0 {Exception -> 0x0030, blocks: (B:4:0x001c, B:6:0x0020, B:8:0x0024, B:9:0x0028, B:11:0x002c), top: B:19:0x001c }] */
        @Override // defpackage.io2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResult(boolean z, LXBaseNetBean<String> lXBaseNetBean, Exception exc) {
            LogUtil.i("performRequestAsync", "requestSuperExposeDialogInfo info onResult=" + az2.c(lXBaseNetBean));
            if (lXBaseNetBean != null) {
                try {
                    if (lXBaseNetBean.resultCode == 0) {
                        g gVar = this.f14801a;
                        if (gVar != null) {
                            gVar.onSuccess();
                        }
                    } else {
                        g gVar2 = this.f14801a;
                        if (gVar2 != null) {
                            gVar2.onFail(exc);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    g gVar3 = this.f14801a;
                    if (gVar3 != null) {
                        gVar3.onFail(e);
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends go2<LXBaseNetBean<SuperExposeInfo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f14802a;
        public final /* synthetic */ e b;

        public d(boolean z, e eVar) {
            this.f14802a = z;
            this.b = eVar;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            ContactInfoItem contactInfoItemA;
            HashMap map = new HashMap();
            String strE = v4.e(com.zenmen.palmchat.c.b());
            if (!TextUtils.isEmpty(strE) && (contactInfoItemA = dn0.a(strE)) != null) {
                map.put("gender", Integer.valueOf(contactInfoItemA.getGender()));
            }
            LocationEx locationExI = com.zenmen.palmchat.location.d.g().i(86400000L);
            if (locationExI != null) {
                map.put("latitude", locationExI.getLatitude() + "");
                map.put("longitude", locationExI.getLongitude() + "");
            }
            map.put("requestTab", 2);
            b05.d("SuperExposeHelper===>requestSuperExposeInfo() requestTab=2");
            if (this.f14802a) {
                map.put("scene", 2);
            } else {
                map.put("scene", 1);
            }
            return sw4.b(1, ap3.d(), map).f(false);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<SuperExposeInfo> lXBaseNetBean, Exception exc) {
            SuperExposeInfo superExposeInfo;
            LogUtil.i("performRequestAsync", "getExpose info onResult=" + az2.c(lXBaseNetBean));
            try {
                a.this.f14798a = false;
                fo5.g = lXBaseNetBean;
                if (lXBaseNetBean == null || lXBaseNetBean.resultCode != 0 || (superExposeInfo = lXBaseNetBean.data) == null) {
                    e eVar = this.b;
                    if (eVar != null) {
                        eVar.onFail(exc);
                    }
                } else {
                    SuperExposeInfo superExposeInfo2 = superExposeInfo;
                    com.zenmen.palmchat.paidservices.superexpose.b.x = superExposeInfo2.superShowType;
                    fo5.f17568a = superExposeInfo2.status;
                    LogUtil.i("", "getExpose 271 exposeStatus =" + fo5.f17568a);
                    e eVar2 = this.b;
                    if (eVar2 != null) {
                        eVar2.a(superExposeInfo2);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                e eVar3 = this.b;
                if (eVar3 != null) {
                    eVar3.onFail(e);
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
        void a(SuperExposeInfo superExposeInfo);

        void onFail(Exception exc);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
        void a(SuperExposeDialogInfo superExposeDialogInfo);

        void onFail(Exception exc);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface g {
        void onFail(Exception exc);

        void onSuccess();
    }

    public static a b() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    public void c() {
        cd1.b();
        LogUtil.i("SuperExposeHelper", "requestQuidConfig");
        zw4.e(new C1084a());
    }

    public void d(f fVar) {
        zw4.e(new b(fVar));
    }

    public void e(g gVar) {
        zw4.e(new c(gVar));
    }

    public void f(e eVar, boolean z, boolean z2) {
        if (this.f14798a) {
            return;
        }
        this.f14798a = true;
        if (!z2 && !z) {
            long jCurrentTimeMillis = System.currentTimeMillis() - fo5.e;
            long j = fo5.d;
            if (j == -1 || jCurrentTimeMillis < j) {
                this.f14798a = false;
                LogUtil.d("", "mRequestStatusLastTime requestSuperExposeInfo time not allow");
                return;
            }
            fo5.e = System.currentTimeMillis();
        }
        LogUtil.d("", "mRequestStatusLastTime requestSuperExposeInfo fromTimeTask " + z2 + " isBaoGuang " + z);
        zw4.e(new d(z, eVar));
    }

    public void g(Activity activity, int i, int i2, boolean z) {
        i(activity, i, i2, z, 0);
    }

    public void h(Activity activity, int i, int i2, boolean z) {
        if (activity != null) {
            try {
                Intent intent = new Intent(activity, (Class<?>) SuperBuyDialogBaseActivity.class);
                intent.putExtra("dscene", i);
                intent.putExtra("dfrom", i2);
                intent.putExtra("isFromDeepLink", z);
                activity.startActivity(intent);
            } catch (Exception unused) {
            }
        }
    }

    public void i(Activity activity, int i, int i2, boolean z, int i3) {
        j();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        SuperExposeDialogView superExposeDialogView = new SuperExposeDialogView(activity, R.style.SuperExposeDialogViewStyle);
        superExposeDialogView.F0(i, i2, z, i3);
        superExposeDialogView.v(0.9f);
        superExposeDialogView.x(2);
        superExposeDialogView.show();
        if (SuperExposeDialogView.z0(i2)) {
            String strE = v4.e(com.zenmen.palmchat.c.b());
            if (TextUtils.isEmpty(strE)) {
                return;
            }
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
            sPUtil.t(scene, "key_showsuperexposedialog_time" + strE, Long.valueOf(sPUtil.i(scene, "key_showsuperexposedialog_time" + strE, 0L) + 1));
        }
    }

    public final void j() {
        SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, "key_super_expose_buy_dialog_time", Long.valueOf(ir5.b()));
    }
}
