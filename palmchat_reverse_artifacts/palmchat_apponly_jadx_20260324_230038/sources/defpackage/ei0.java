package defpackage;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.webkit.WebView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ei0 {
    public static String a(WebView webView, String str) {
        if (webView == null || webView.getSettings() == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(webView.getSettings().getUserAgentString());
        sb.append(" " + str);
        String strC = nl0.c();
        if (strC.equals("release") && ac1.m.equals(ac1.r)) {
            strC = "pre";
        }
        sb.append(" uitype/");
        sb.append("green");
        sb.append(" serverType/");
        sb.append(strC);
        sb.append(" uiVersion/");
        sb.append(5);
        sb.append(" density/");
        sb.append(webView.getContext().getResources().getDisplayMetrics().density);
        sb.append(" statusBarHeight/");
        sb.append(me1.h(webView.getContext()));
        sb.append(" statusBarPx/");
        sb.append(me1.h(webView.getContext()));
        try {
            PackageInfo packageInfo = webView.getContext().getPackageManager().getPackageInfo(webView.getContext().getPackageName(), 0);
            sb.append(" appVerCode/");
            sb.append(packageInfo.versionCode);
            sb.append(" appVerName/");
            sb.append(packageInfo.versionName);
        } catch (PackageManager.NameNotFoundException e) {
            ma3.c(e);
        }
        sb.append(" osVer/");
        sb.append(Build.VERSION.SDK_INT);
        sb.append(" channelId/");
        sb.append(ac1.m);
        return sb.toString();
    }
}
