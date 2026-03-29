package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class tj6 {
    public static Intent a(Context context, String str, boolean z, boolean z2) {
        Intent intent = new Intent(context, (Class<?>) CordovaWebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("web_url", str);
        bundle.putBoolean("hide_toolbar", z);
        bundle.putBoolean("hide_progressbar", z);
        bundle.putBoolean("extra_use_light_status_bar", z2);
        bundle.putBoolean("web_show_right_menu", false);
        intent.putExtras(bundle);
        return intent;
    }

    public static Intent b(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) CordovaWebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("web_url", str);
        bundle.putBoolean("extra_key_full_window", false);
        bundle.putBoolean("web_show_right_menu", false);
        intent.putExtras(bundle);
        return intent;
    }
}
