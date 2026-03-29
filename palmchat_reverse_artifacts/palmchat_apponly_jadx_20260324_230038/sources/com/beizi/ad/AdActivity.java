package com.beizi.ad;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Menu;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import com.beizi.ad.internal.e.u;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class AdActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f4321a = false;
    static Class b = AdActivity.class;
    private a c;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();

        void b();

        void c();

        WebView d();
    }

    public static Class a() {
        return b;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            String stringExtra = getIntent().getStringExtra("ACTIVITY_TYPE");
            boolean booleanExtra = getIntent().getBooleanExtra("ACTIVITY_CAN_JUMP", false);
            boolean booleanExtra2 = getIntent().getBooleanExtra("ACTIVITY_CAN_DOWNLOAD", false);
            String stringExtra2 = getIntent().getStringExtra("deeplinkUrl");
            int intExtra = getIntent().getIntExtra("webDeepLink", 0);
            if (TextUtils.isEmpty(stringExtra)) {
                finish();
            } else if ("BROWSER".equals(stringExtra)) {
                com.beizi.ad.internal.activity.a aVar = new com.beizi.ad.internal.activity.a(this, booleanExtra, booleanExtra2, stringExtra2, intExtra);
                this.c = aVar;
                aVar.a();
            } else if ("DOWNLOADBROWSER".equals(stringExtra)) {
                com.beizi.ad.internal.activity.a aVar2 = new com.beizi.ad.internal.activity.a(this, booleanExtra, booleanExtra2, stringExtra2, intExtra);
                this.c = aVar2;
                aVar2.a();
                new Thread(new Runnable() { // from class: com.beizi.ad.AdActivity.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i = 0;
                        while (i != 3) {
                            i++;
                            if (AdActivity.f4321a) {
                                AdActivity.f4321a = false;
                                AdActivity.this.finish();
                                i = 3;
                            }
                            SystemClock.sleep(500L);
                        }
                    }
                }).start();
            }
            CookieSyncManager.createInstance(this);
            CookieSyncManager cookieSyncManager = CookieSyncManager.getInstance();
            if (cookieSyncManager != null) {
                cookieSyncManager.startSync();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.c();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onPause() {
        a aVar = this.c;
        if (aVar != null) {
            u.c(aVar.d());
        }
        CookieSyncManager cookieSyncManager = CookieSyncManager.getInstance();
        if (cookieSyncManager != null) {
            cookieSyncManager.stopSync();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        a aVar = this.c;
        if (aVar != null) {
            u.b(aVar.d());
        }
        CookieSyncManager cookieSyncManager = CookieSyncManager.getInstance();
        if (cookieSyncManager != null) {
            cookieSyncManager.startSync();
        }
        super.onResume();
    }
}
