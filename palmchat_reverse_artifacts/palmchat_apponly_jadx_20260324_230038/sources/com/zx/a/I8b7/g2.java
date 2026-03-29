package com.zx.a.I8b7;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.cdo.oaps.ad.Launcher;
import com.zx.a.I8b7.v3;
import com.zx.a.I8b7.y;
import com.zx.sdk.api.Callback;
import com.zx.sdk.api.PermissionCallback;
import com.zx.sdk.api.SAIDCallback;
import com.zx.sdk.api.ZXApi;
import com.zx.sdk.api.ZXIDChangedListener;
import com.zx.sdk.api.ZXIDListener;
import org.apache.cordova.jssdk.general.Action;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class g2 implements ZXApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16798a;

    public g2(String str) throws IllegalStateException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalStateException("ZX_APPID not found");
        }
        this.f16798a = str;
    }

    @Override // com.zx.sdk.api.ZXApi
    public void addZXIDChangedListener(ZXIDChangedListener zXIDChangedListener) {
        try {
            y.b.f16887a.a(this.f16798a, "addZXIDChangedListener", "");
            x2 x2VarB = x2.b();
            String str = this.f16798a;
            x2VarB.getClass();
            v3.f.f16875a.f16874a.execute(new e3(x2VarB, str, zXIDChangedListener));
        } catch (Throwable th) {
            g3.a(th, f3.a("ZXManager.registerListener(listener) failed: "));
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public void allowPermissionDialog(boolean z) {
        try {
            y.b.f16887a.a(this.f16798a, "allowPermissionDialog", "enable=" + z);
            x2 x2VarB = x2.b();
            x2VarB.getClass();
            v3.f.f16875a.f16874a.execute(new c3(x2VarB, z));
        } catch (Throwable th) {
            g3.a(th, f3.a("ZXManager.allowPermissionDialog failed: "));
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public void checkPermission(Activity activity, PermissionCallback permissionCallback) {
        try {
            y.b.f16887a.a(this.f16798a, Action.ACTION_CHECK_PERMISSION, "");
            if (permissionCallback == null) {
                return;
            }
            x2 x2VarB = x2.b();
            x2VarB.getClass();
            v3.f.f16875a.f16874a.execute(new w2(x2VarB, permissionCallback, activity));
        } catch (Throwable th) {
            r.b(th.getMessage());
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public void getAuthToken(Callback callback) {
        try {
            y.b.f16887a.a(this.f16798a, "getAuthToken", "");
            if (callback == null) {
                return;
            }
            x2 x2VarB = x2.b();
            String str = this.f16798a;
            x2VarB.getClass();
            v3.f.f16875a.f16874a.execute(new a3(x2VarB, str, callback));
        } catch (Throwable th) {
            r.b(th.getMessage());
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public void getOpenID(Callback callback, Context context) {
        try {
            y.b.f16887a.a(this.f16798a, "getOpenID", "");
            if (callback != null) {
                x2 x2VarB = x2.b();
                x2VarB.getClass();
                v3.f.f16875a.c.execute(new t2(x2VarB, context, callback));
            }
        } catch (Throwable th) {
            if (callback != null) {
                callback.onFailed(10000, th.getMessage());
            }
            g3.a(th, f3.a("ZXManager.getOpenID(cb) failed: "));
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public void getSAID(String str, String str2, String str3, String str4, String str5, SAIDCallback sAIDCallback) {
        try {
            y.b.f16887a.a(this.f16798a, "getUAID", "");
            if (sAIDCallback != null) {
                x2 x2VarB = x2.b();
                String str6 = this.f16798a;
                x2VarB.getClass();
                v3.f.f16875a.f16874a.execute(new y2(x2VarB, str6, str, str2, str3, str4, str5, sAIDCallback));
            }
        } catch (Throwable th) {
            g3.a(th, f3.a("ZXManager getSAID onFailed:"));
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public void getTag(Callback callback) {
        try {
            y.b.f16887a.a(this.f16798a, "getTag", "");
            if (callback == null) {
                return;
            }
            x2 x2VarB = x2.b();
            String str = this.f16798a;
            x2VarB.getClass();
            v3.f.f16875a.f16874a.execute(new z2(x2VarB, str, callback));
        } catch (Throwable th) {
            r.b(th.getMessage());
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public String getVersion() {
        y.b.f16887a.a(this.f16798a, "getVersion", "");
        return "3.3.4.43514";
    }

    @Override // com.zx.sdk.api.ZXApi
    public void getZXID(ZXIDListener zXIDListener) {
        try {
            y.b.f16887a.a(this.f16798a, "getZXID", "");
            if (zXIDListener != null) {
                x2 x2VarB = x2.b();
                String str = this.f16798a;
                x2VarB.getClass();
                v3.f.f16875a.f16874a.execute(new s2(x2VarB, str, zXIDListener));
            }
        } catch (Throwable th) {
            if (zXIDListener != null) {
                zXIDListener.onFailed(10000, th.getMessage());
            }
            g3.a(th, f3.a("ZXManager.getZXID(zxidListener) failed: "));
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public void init(Context context) {
        try {
            y.b.f16887a.a(this.f16798a, "init", "");
            x2.a(context);
        } catch (Throwable th) {
            r.b("ZXManager.init failed:" + th);
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public String invoke(String str, String str2) {
        try {
            y.b.f16887a.a(this.f16798a, Launcher.Method.INVOKE_CALLBACK, "method=" + str + "&argument" + str2);
            return x2.b().a(str, str2);
        } catch (Throwable th) {
            g3.a(th, f3.a("ZXManager.invoke failed: "));
            return null;
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public boolean isAllowPermissionDialog() {
        try {
            y.b.f16887a.a(this.f16798a, "isAllowPermissionDialog", "");
            x2.b().getClass();
            return m3.s == 1;
        } catch (Throwable th) {
            g3.a(th, f3.a("ZXManager.isAllowPermissionDialog failed: "));
            return false;
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public boolean isEnable() {
        try {
            y.b.f16887a.a(this.f16798a, "isEnable", "");
            x2.b().getClass();
            return m3.r == 1;
        } catch (Throwable th) {
            g3.a(th, f3.a("ZXManager.isEnable failed: "));
            return false;
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public void setDebug(boolean z) {
        try {
            y.b.f16887a.a(this.f16798a, "setDebug", "isDebug=" + z);
            x2 x2VarB = x2.b();
            x2VarB.getClass();
            v3.f.f16875a.f16874a.execute(new d3(x2VarB, z));
        } catch (Throwable th) {
            r.b(th.getMessage());
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public void setEnable(boolean z) {
        try {
            y.b.f16887a.a(this.f16798a, "setEnable", "enable=" + z);
            x2 x2VarB = x2.b();
            x2VarB.getClass();
            v3.f.f16875a.f16874a.execute(new b3(x2VarB, z));
        } catch (Throwable th) {
            g3.a(th, f3.a("ZXManager.setEnable failed: "));
        }
    }
}
