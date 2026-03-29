package com.opos.mobad.ui.feedback;

import android.widget.Toast;
import com.opos.cmn.module.ui.WebViewActivity;
import com.opos.mobad.ui.feedback.b.c;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class FeedBackWebViewActivity extends WebViewActivity {
    private static WeakReference<c> b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10255a = "以后将减少此类推荐";

    public static void a(c cVar) {
        if (cVar == null) {
            return;
        }
        b = new WeakReference<>(cVar);
    }

    @Override // com.opos.cmn.module.ui.WebViewActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "以后将减少此类推荐", 1).show();
        WeakReference<c> weakReference = b;
        c cVar = weakReference != null ? weakReference.get() : null;
        if (cVar != null) {
            try {
                cVar.b();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.d("FeedBackWebViewActivity", "onContinuePlay error when exit WebView", e);
            }
        }
        com.opos.cmn.an.f.a.b("FeedBackWebViewActivity", "onDestroy");
    }
}
