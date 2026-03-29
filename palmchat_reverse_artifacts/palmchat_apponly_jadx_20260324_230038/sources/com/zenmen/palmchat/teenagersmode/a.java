package com.zenmen.palmchat.teenagersmode;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.a0;
import defpackage.c0;
import defpackage.go2;
import defpackage.k86;
import defpackage.nl0;
import defpackage.rb3;
import defpackage.ry5;
import defpackage.sw4;
import defpackage.zw4;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: com.zenmen.palmchat.teenagersmode.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C1112a extends go2<LXBaseNetBean<CheckServerPwdResult>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15431a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Activity d;
        public final /* synthetic */ Runnable e;

        /* JADX INFO: renamed from: com.zenmen.palmchat.teenagersmode.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1113a implements c0 {
            public C1113a() {
            }

            @Override // defpackage.c0
            public void a(int i, Intent intent) {
                LogUtil.i("TeenagerPwdHelper", "switchMode resultCode" + i);
                if (i == -1) {
                    C1112a.this.e.run();
                }
            }
        }

        /* JADX INFO: renamed from: com.zenmen.palmchat.teenagersmode.a$a$b */
        /* JADX INFO: compiled from: SearchBox */
        public class b implements c0 {
            public b() {
            }

            @Override // defpackage.c0
            public void a(int i, Intent intent) {
                LogUtil.i("TeenagerPwdHelper", "switchMode resultCode" + i);
                if (i == -1) {
                    C1112a.this.e.run();
                }
            }
        }

        public C1112a(String str, HashMap map, boolean z, Activity activity, Runnable runnable) {
            this.f15431a = str;
            this.b = map;
            this.c = z;
            this.d = activity;
            this.e = runnable;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, this.f15431a, this.b);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<CheckServerPwdResult> lXBaseNetBean, Exception exc) {
            CheckServerPwdResult checkServerPwdResult;
            if (!z || (checkServerPwdResult = lXBaseNetBean.data) == null) {
                return;
            }
            if (!this.c) {
                if (checkServerPwdResult.status == 1 && !a.this.f()) {
                    this.e.run();
                    return;
                }
                Activity activity = this.d;
                if (activity == null || activity.isFinishing() || this.d.isDestroyed()) {
                    return;
                }
                a0.d(this.d).e(a.e(this.d)).b(new b());
                return;
            }
            if (checkServerPwdResult.status != 1 || a.this.f()) {
                if (a.this.f()) {
                    a aVar = a.this;
                    aVar.h(this.d, aVar.c(), null);
                }
                this.e.run();
                return;
            }
            Activity activity2 = this.d;
            if (activity2 == null || activity2.isFinishing() || this.d.isDestroyed()) {
                return;
            }
            a0.d(this.d).e(a.d(this.d)).b(new C1113a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends go2<LXBaseNetBean<CheckServerPwdResult>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15434a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ e c;

        public b(String str, HashMap map, e eVar) {
            this.f15434a = str;
            this.b = map;
            this.c = eVar;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, this.f15434a, this.b).f(true);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<CheckServerPwdResult> lXBaseNetBean, Exception exc) {
            CheckServerPwdResult checkServerPwdResult;
            if (!z || (checkServerPwdResult = lXBaseNetBean.data) == null) {
                return;
            }
            if (checkServerPwdResult.status != 0) {
                if (TextUtils.isEmpty(checkServerPwdResult.message)) {
                    return;
                }
                ry5.a(lXBaseNetBean.data.message);
            } else {
                if (a.this.f()) {
                    SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, k86.a("key_teenager_pwd"), "");
                }
                e eVar = this.c;
                if (eVar != null) {
                    eVar.call();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends go2<LXBaseNetBean<CheckServerPwdResult>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15435a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ d c;

        public c(String str, HashMap map, d dVar) {
            this.f15435a = str;
            this.b = map;
            this.c = dVar;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, this.f15435a, this.b).f(true);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<CheckServerPwdResult> lXBaseNetBean, Exception exc) {
            CheckServerPwdResult checkServerPwdResult;
            d dVar;
            if (!z || (checkServerPwdResult = lXBaseNetBean.data) == null || (dVar = this.c) == null) {
                return;
            }
            if (checkServerPwdResult.status == 0) {
                dVar.success();
            } else {
                dVar.a();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void a();

        void success();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
        void call();
    }

    public static Intent d(Activity activity) {
        return new Intent(activity, (Class<?>) TeenagersModeSetPasswordActivity.class);
    }

    public static Intent e(Activity activity) {
        return new Intent(activity, (Class<?>) VerifyPwdActivity.class);
    }

    public void a(Activity activity, boolean z, Runnable runnable) {
        HashMap map = new HashMap();
        map.put(DeviceInfoUtil.UID_TAG, AccountUtils.p(activity));
        zw4.e(new C1112a(nl0.z + "/cash.teen.confirm.v1", map, z, activity, runnable));
    }

    public void b(Context context, String str, d dVar) {
        HashMap map = new HashMap();
        map.put(DeviceInfoUtil.UID_TAG, AccountUtils.p(context));
        map.put("keyCode", rb3.c(str));
        zw4.e(new c(nl0.z + "/cash.teen.verify.v1", map, dVar));
    }

    public String c() {
        return SPUtil.f14322a.n(SPUtil.SCENE.APP_COMMON, k86.a("key_teenager_pwd"), "");
    }

    public boolean f() {
        return !TextUtils.isEmpty(c());
    }

    public void g(String str) {
        SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, k86.a("key_teenager_pwd"), str);
    }

    public void h(Context context, String str, e eVar) {
        HashMap map = new HashMap();
        map.put(DeviceInfoUtil.UID_TAG, AccountUtils.p(context));
        map.put("keyCode", rb3.c(str));
        zw4.e(new b(nl0.z + "/cash.teen.update.v1", map, eVar));
    }
}
