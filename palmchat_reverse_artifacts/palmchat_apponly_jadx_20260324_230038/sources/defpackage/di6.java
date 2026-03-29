package defpackage;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.thirdwakeup.vo.AppInfo;
import com.zenmen.palmchat.thirdwakeup.vo.Config;
import com.zenmen.palmchat.thirdwakeup.vo.ExtraInfo;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class di6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f17057a = Boolean.FALSE;

    public static boolean a(Context context, AppInfo appInfo) {
        boolean z = false;
        if (appInfo != null && !TextUtils.isEmpty(appInfo.pkg) && !TextUtils.isEmpty(appInfo.compName) && appInfo.type == 1) {
            try {
                Intent intent = new Intent();
                if (!TextUtils.isEmpty(appInfo.compName)) {
                    intent.setComponent(new ComponentName(appInfo.pkg, appInfo.compName));
                }
                if (!TextUtils.isEmpty(appInfo.action)) {
                    intent.setAction(appInfo.action);
                }
                ArrayList<ExtraInfo> arrayList = appInfo.extraKeyList;
                if (arrayList != null && arrayList.size() > 0) {
                    for (ExtraInfo extraInfo : appInfo.extraKeyList) {
                        intent.putExtra(extraInfo.key, extraInfo.value);
                    }
                }
                if (context.startService(intent) != null) {
                    Iterator<ActivityManager.RunningServiceInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningServices(100).iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (it.next().service.getClassName().equalsIgnoreCase(appInfo.compName)) {
                            z = true;
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            JSONObject jSONObjectG = x63.g();
            try {
                jSONObjectG.put("pkg", appInfo.pkg);
                jSONObjectG.put("status", z);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            zn6.d("lx_client_app_20515", null, jSONObjectG.toString());
            LogUtil.i("WakeUpProcessor", "activateService result = " + z);
        }
        return z;
    }

    public static boolean b() {
        if (f17057a == null) {
            f17057a = Boolean.valueOf(SPUtil.f14322a.a(SPUtil.SCENE.APP_COMMON, "key_app_wakeup_third_app", false));
        }
        return f17057a.booleanValue();
    }

    public static void d(Context context) {
        Config config;
        if (b()) {
            DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.THIRDWAKEUP);
            if (dynamicConfig.isEnable()) {
                String extra = dynamicConfig.getExtra();
                LogUtil.i("WakeUpProcessor", "wakeUpThirdApp extra = " + extra);
                if (TextUtils.isEmpty(extra) || (config = (Config) az2.a(extra, Config.class)) == null || config.list == null) {
                    return;
                }
                SPUtil sPUtil = SPUtil.f14322a;
                SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
                if (Math.abs(sPUtil.i(scene, "key_app_third_wakeup", 0L) - ir5.b()) > ((long) (config.wakeUpIntervalHour * 60 * 60)) * 1000) {
                    sPUtil.t(scene, "key_app_third_wakeup", Long.valueOf(ir5.b()));
                    Iterator<AppInfo> it = config.list.iterator();
                    while (it.hasNext()) {
                        a(context, it.next());
                    }
                }
            }
        }
    }

    public static void c() {
    }
}
