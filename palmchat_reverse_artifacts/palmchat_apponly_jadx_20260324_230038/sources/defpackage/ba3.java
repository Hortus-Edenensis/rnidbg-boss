package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.webkit.WebView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public interface ba3 {
    Activity getActivity();

    WebView getWebView();

    boolean hasPermission(String str);

    void requestPermission(ib3 ib3Var, int i, String str);

    void startActivityForResult(ib3 ib3Var, Intent intent, int i);
}
