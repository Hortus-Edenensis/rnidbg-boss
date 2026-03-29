package com.zenmen.palmchat.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.wifi.ad.core.config.EventParams;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.update.UpdateManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.dw3;
import defpackage.k86;
import defpackage.pu3;
import defpackage.t66;
import defpackage.tk5;
import defpackage.uu3;
import defpackage.x6;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class AdSplaseActivity extends BaseActivityWithoutCheckAccount {
    public static final String t = "AdSplaseActivity";
    public static boolean u = false;
    public String q = "";
    public String r = "";
    public FrameLayout s;

    public static void B1(Context context, String str, String str2) {
        try {
            Intent intent = new Intent(context, (Class<?>) AdSplaseActivity.class);
            k86.X(intent);
            intent.putExtra(EventParams.KEY_INVENTORYID, str);
            intent.putExtra("type", str2);
            context.startActivity(intent);
        } catch (Exception e) {
            LogUtil.e(t, "invite failed.", e);
        }
    }

    public final void A1() {
        try {
            WindowManager windowManager = (WindowManager) getSystemService("window");
            Field declaredField = windowManager.getClass().getDeclaredField("mGlobal");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(windowManager);
            String str = t;
            LogUtil.i(str, "======closeMyDialogs: global=" + obj);
            Field declaredField2 = obj.getClass().getDeclaredField("mViews");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            LogUtil.i(str, "======closeMyDialogs: views=" + obj2);
            if (obj2 instanceof List) {
                View decorView = getWindow().getDecorView();
                for (Object obj3 : (List) obj2) {
                    String str2 = t;
                    LogUtil.i(str2, "======closeMyDialogs: view=" + obj3);
                    if (obj3 != decorView && (obj3 instanceof View)) {
                        Context context = ((View) obj3).getContext();
                        if (context instanceof ContextThemeWrapper) {
                            context = ((ContextThemeWrapper) context).getBaseContext();
                        }
                        if (context == this) {
                            LogUtil.i(str2, "======closeMyDialogs: target=" + obj3);
                            Field declaredField3 = obj3.getClass().getDeclaredField("mWindow");
                            declaredField3.setAccessible(true);
                            Object obj4 = declaredField3.get(obj3);
                            LogUtil.i(str2, "======closeMyDialogs: window=" + obj4);
                            if (obj4 instanceof Window) {
                                Method declaredMethod = Window.class.getDeclaredMethod("destroy", new Class[0]);
                                declaredMethod.setAccessible(true);
                                declaredMethod.invoke(obj4, new Object[0]);
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            LogUtil.e(t, "======closeMyDialogs: failed.", th);
        }
    }

    public final void C1() {
        getWindow().getDecorView().setSystemUiVisibility(1792);
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, android.app.Activity
    public void finish() {
        try {
            A1();
            super.finish();
            UpdateManager.G().R();
        } catch (Exception unused) {
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        pu3.f(this.r, this.q, 0, 0, 0, 0, -1000);
        if ("A".equalsIgnoreCase(t66.h().e("LX-59679", "A"))) {
            super.onBackPressed();
        }
    }

    @Override // com.zenmen.palmchat.login.BaseActivityWithoutCheckAccount, com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            }
            super.onCreate(bundle);
            setContentView(R.layout.view_open_for_adsplash);
            this.s = (FrameLayout) findViewById(R.id.ad_splash_view);
            tk5.a(this);
            if (getIntent() != null) {
                this.r = getIntent().getStringExtra(EventParams.KEY_INVENTORYID);
                this.q = getIntent().getStringExtra("type");
            }
            dw3.r(x6.a().b(), this, this.s, this.r, this.q);
        } catch (Exception e) {
            LogUtil.d("", "AdSplaseActivityww Exception start " + e.toString());
            try {
                Field declaredField = Activity.class.getDeclaredField("mCalled");
                declaredField.setAccessible(true);
                declaredField.setBoolean(this, true);
                LogUtil.d("", "AdSplaseActivityww call start true ");
            } catch (Exception e2) {
                LogUtil.d("", "AdSplaseActivityww Exception sss " + e2.toString());
            }
            finish();
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        try {
            super.onDestroy();
            u = false;
            LogUtil.d("ClearAd", "clearCacheAd AdSplaseActivity adDestroy");
            dw3.l(this);
            FrameLayout frameLayout = this.s;
            if (frameLayout != null) {
                frameLayout.removeAllViews();
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        try {
            super.onPause();
            u = false;
            uu3.g();
        } catch (Exception unused) {
            finish();
        }
    }

    @Override // com.zenmen.palmchat.BaseActionBarActivity, com.zenmen.palmchat.framework.FrameworkBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        try {
            super.onResume();
            u = true;
            uu3.h();
        } catch (Exception unused) {
            finish();
        }
    }

    @Override // com.zenmen.palmchat.framework.FrameworkBaseActivity
    public void setStatusBarColor() {
        C1();
    }
}
