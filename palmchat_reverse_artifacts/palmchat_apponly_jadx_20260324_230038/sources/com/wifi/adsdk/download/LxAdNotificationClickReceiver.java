package com.wifi.adsdk.download;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.wifi.adsdk.utils.LxAdLog;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LxAdNotificationClickReceiver extends BroadcastReceiver {
    public static final String EXTRA_ACTION_DOWN_BTN_CLICK = "extra_action_down_btn_click";
    public static final String EXTRA_ACTION_DOWN_LAYOUT_CLICK = "extra_action_down_layout_click";
    public static final String EXTRA_CURRENTID = "current_id";
    public static final String EXTRA_DOWN_URL = "extra_down_url";
    public static final String EXTRA_NOTIFI_FROM = "notifiFrom";
    public static final String EXTRA_PKG_NAME = "extra_pkg_name";
    public static final String EXTRA_TITLE = "extra_title";
    public static final String FROM_SPLASH = "splashFrom";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            String stringExtra = intent.getStringExtra(EXTRA_PKG_NAME);
            String stringExtra2 = intent.getStringExtra(EXTRA_DOWN_URL);
            String stringExtra3 = intent.getStringExtra(EXTRA_TITLE);
            LxAdLog.d("LxAdNotificationClickReceiver splash onReceive action " + action + " pkgName " + stringExtra + " currentId " + intent.getIntExtra(EXTRA_CURRENTID, 0) + " from " + intent.getStringExtra(EXTRA_NOTIFI_FROM));
            if (EXTRA_ACTION_DOWN_BTN_CLICK.equals(action)) {
                LxAdDLManager.getInstance(context).startDownClick(LxAdDLManager.getInstance(context).getDownStatus(stringExtra), stringExtra2, stringExtra);
                return;
            }
            if (EXTRA_ACTION_DOWN_LAYOUT_CLICK.equals(action)) {
                try {
                    if (LxAdDLManager.getInstance(context).getDownStatus(stringExtra) == LxAdDLManager.STATUS_DOWNED) {
                        LxAdDLManager.getInstance(context).installDownClickReceiver(stringExtra2, stringExtra);
                        return;
                    }
                    Intent intent2 = new Intent(context, (Class<?>) LxAdDownDeleteActivity.class);
                    if (!(context instanceof Activity)) {
                        intent2.addFlags(268435456);
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pkgName", stringExtra);
                    jSONObject.put(LxAdDLManager.ITEM_PKGURL, stringExtra2);
                    jSONObject.put("title", stringExtra3);
                    intent2.putExtra(LxAdDLManager.TAG_ITEM_ALL, jSONObject.toString());
                    context.startActivity(intent2);
                } catch (Exception unused) {
                }
            }
        }
    }
}
