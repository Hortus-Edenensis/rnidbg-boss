package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.IgnoreBatteryVo;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.conversations.threadnotifyguide.IgnoreBatteryInfo;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class qq2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f20298a = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f20299a;
        public final /* synthetic */ IgnoreBatteryVo b;

        public a(Activity activity, IgnoreBatteryVo ignoreBatteryVo) {
            this.f20299a = activity;
            this.b = ignoreBatteryVo;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            qq2.c(this.f20299a);
            HashMap map = new HashMap();
            map.put("ui_type", this.b.popwinstyle == 2 ? "lx" : NotificationCompat.CATEGORY_SYSTEM);
            zn6.h("daily_selfalive_alert", "click", map);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f20300a;
        public final /* synthetic */ IgnoreBatteryVo b;

        public c(Activity activity, IgnoreBatteryVo ignoreBatteryVo) {
            this.f20300a = activity;
            this.b = ignoreBatteryVo;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            qq2.c(this.f20300a);
            HashMap map = new HashMap();
            map.put("ui_type", this.b.popwinstyle == 2 ? "lx" : NotificationCompat.CATEGORY_SYSTEM);
            zn6.h("daily_selfalive_alert", "click", map);
        }
    }

    public static IgnoreBatteryVo b(boolean z) {
        String strC = jo6.c("LX-44564", "A");
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(z ? DynamicConfig.Type.IGNOREBATTERY_THREAD : DynamicConfig.Type.IGNOREBATTERY_MSG);
        if (dynamicConfig == null || !dynamicConfig.isEnable()) {
            return null;
        }
        LogUtil.i("IgnoreBatteryGuideHelper", "config = " + dynamicConfig.getExtra() + "MANUFACTURER=" + Build.MANUFACTURER + " taichi=" + strC);
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(dynamicConfig.getExtra()).optJSONObject(strC);
            if (jSONObjectOptJSONObject != null) {
                return (IgnoreBatteryVo) az2.a(jSONObjectOptJSONObject.toString(), IgnoreBatteryVo.class);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.i("IgnoreBatteryGuideHelper", "config = " + e);
            return null;
        }
    }

    public static boolean c(Activity activity) {
        PowerManager powerManager = (PowerManager) activity.getSystemService("power");
        boolean z = false;
        if (Build.VERSION.SDK_INT < 23 || powerManager.isIgnoringBatteryOptimizations(activity.getPackageName())) {
            return false;
        }
        try {
            Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
            intent.setData(Uri.parse("package:" + activity.getPackageName()));
            activity.startActivityForResult(intent, 1688);
            z = true;
            zn6.c("daily_selfalivedc_alertshow", "view");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return z;
        }
    }

    public static boolean d(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (Build.VERSION.SDK_INT >= 23) {
            return powerManager.isIgnoringBatteryOptimizations(context.getPackageName());
        }
        return true;
    }

    public static /* synthetic */ void e(ChatItem chatItem, IgnoreBatteryVo ignoreBatteryVo) {
        MessageVo messageVoG = u0.g(chatItem);
        messageVoG.status = 2;
        messageVoG.mimeType = 10000;
        messageVoG.text = ignoreBatteryVo.chatGuideMsg;
        messageVoG.data1 = "1";
        HashMap map = new HashMap();
        map.put("actionTypes", "activity");
        map.put("actionBody", ignoreBatteryVo.chatGuideMsg + "，<a href='zenxin://activity?page=a0515'>立即开启>></a>");
        messageVoG.data2 = new JSONObject(map).toString();
        com.zenmen.palmchat.database.b.t(messageVoG);
    }

    public static IgnoreBatteryVo f(boolean z) {
        IgnoreBatteryVo ignoreBatteryVoB;
        String str;
        String strC = jo6.c("LX-44564", "A");
        if (strC != null && !strC.equals("A") && (ignoreBatteryVoB = b(z)) != null && (str = ignoreBatteryVoB.manufacturer) != null && (("all".equals(str) || ignoreBatteryVoB.manufacturer.contains(Build.MANUFACTURER.toLowerCase())) && 23 <= Build.VERSION.SDK_INT && !d(AppContext.getContext()))) {
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.NOTIFY_GUIDE;
            int i = 0;
            int iF = sPUtil.f(scene, "thread_power_guide_time", 0);
            long jI = sPUtil.i(scene, "thread_power_guide_interval", 0L);
            if (Math.abs(jI - ir5.b()) <= ((long) (ignoreBatteryVoB.popwinvalidtime * 24 * 60 * 60)) * 1000 || iF == 0) {
                i = iF;
            } else {
                sPUtil.t(scene, "thread_power_guide_time", 0);
            }
            if (i < ignoreBatteryVoB.popwinnumber && Math.abs(jI - ir5.b()) > ((long) (ignoreBatteryVoB.popwinrate * 24 * 60 * 60)) * 1000) {
                return ignoreBatteryVoB;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x006a, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static IgnoreBatteryInfo g(boolean z) {
        SPUtil sPUtil;
        SPUtil.SCENE scene;
        long jI;
        int iF;
        if (f20298a) {
            DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.IGNOREBATTERY);
            boolean z2 = true;
            if (f20298a) {
                dynamicConfig.setEnable(true);
                IgnoreBatteryInfo ignoreBatteryInfo = new IgnoreBatteryInfo();
                ignoreBatteryInfo.firstTime = 4;
                ignoreBatteryInfo.type = 3;
                ignoreBatteryInfo.texta = "";
                ignoreBatteryInfo.textb = "";
                ignoreBatteryInfo.system = 23;
                dynamicConfig.setExtra(az2.c(ignoreBatteryInfo));
            }
            if (dynamicConfig.isEnable()) {
                LogUtil.i("IgnoreBatteryGuideHelper", "config = " + dynamicConfig.getExtra());
                IgnoreBatteryInfo ignoreBatteryInfo2 = (IgnoreBatteryInfo) dynamicConfig.parseExtra(IgnoreBatteryInfo.class);
                if (ignoreBatteryInfo2 != null) {
                    if (z) {
                        if ((z2 || f20298a) && ignoreBatteryInfo2.system <= Build.VERSION.SDK_INT && !d(AppContext.getContext())) {
                            sPUtil = SPUtil.f14322a;
                            scene = SPUtil.SCENE.NOTIFY_GUIDE;
                            jI = sPUtil.i(scene, k86.a("key_new_user_register_time"), -1L);
                            if (jI == -1 || Math.abs(jI - ir5.b()) > ((long) (ignoreBatteryInfo2.firstTime * 24 * 60 * 60)) * 1000 || f20298a) {
                                iF = sPUtil.f(scene, "thread_power_guide_time", 0);
                                long jI2 = sPUtil.i(scene, "thread_power_guide_interval", 0L);
                                if ((iF >= ignoreBatteryInfo2.max && Math.abs(jI2 - ir5.b()) > ((long) (ignoreBatteryInfo2.interval * 60 * 60)) * 1000) || f20298a) {
                                    return ignoreBatteryInfo2;
                                }
                            }
                        }
                    } else if (z2) {
                        sPUtil = SPUtil.f14322a;
                        scene = SPUtil.SCENE.NOTIFY_GUIDE;
                        jI = sPUtil.i(scene, k86.a("key_new_user_register_time"), -1L);
                        if (jI == -1) {
                        }
                    } else {
                        sPUtil = SPUtil.f14322a;
                        scene = SPUtil.SCENE.NOTIFY_GUIDE;
                        jI = sPUtil.i(scene, k86.a("key_new_user_register_time"), -1L);
                        if (jI == -1) {
                            iF = sPUtil.f(scene, "thread_power_guide_time", 0);
                            long jI22 = sPUtil.i(scene, "thread_power_guide_interval", 0L);
                            if (iF >= ignoreBatteryInfo2.max) {
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public static void h(int i, int i2, Intent intent, int i3) {
        LogUtil.i("IgnoreBatteryGuideHelper", "onActivityResult" + i + " result =" + i2 + " data=" + intent);
        if (i == 1688) {
            boolean zD = d(AppContext.getContext());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", i3);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.uploadInfoImmediate(zD ? "bat4" : "bat5", null, null, jSONObject.toString());
            zn6.c(zD ? "daily_selfalivedc_alertclose" : "daily_selfalivedc_alertcancle", "click");
        }
    }

    public static void i(Activity activity) {
        LogUtil.i("IgnoreBatteryGuideHelper", "onMessageLinkClicked");
        boolean zD = d(activity);
        IgnoreBatteryVo ignoreBatteryVoB = b(false);
        String str = ignoreBatteryVoB != null ? ignoreBatteryVoB.chatGuideHasSetMsg : "已开启";
        if (zD) {
            sy5.f(activity, str, 1).g();
        } else {
            c(activity);
        }
        zn6.c("daily_selfalive_stamp", "click");
    }

    public static void j(final ChatItem chatItem) {
        final IgnoreBatteryVo ignoreBatteryVoF;
        LogUtil.i("IgnoreBatteryGuideHelper", "onThreadHasNewMessage" + chatItem);
        if (chatItem == null || (ignoreBatteryVoF = f(false)) == null) {
            return;
        }
        m();
        zn6.c("daily_selfalive_stamp", "insert");
        new g13(new Runnable() { // from class: pq2
            @Override // java.lang.Runnable
            public final void run() {
                qq2.e(chatItem, ignoreBatteryVoF);
            }
        }).start();
    }

    public static void k(Activity activity) {
        IgnoreBatteryVo ignoreBatteryVoF;
        LogUtil.i("IgnoreBatteryGuideHelper", "onThreadTabSelected" + activity);
        if (activity == null || (ignoreBatteryVoF = f(true)) == null) {
            return;
        }
        m();
        l(activity, ignoreBatteryVoF);
    }

    public static void l(Activity activity, IgnoreBatteryVo ignoreBatteryVo) {
        HashMap map = new HashMap();
        map.put("ui_type", ignoreBatteryVo.popwinstyle == 2 ? "lx" : NotificationCompat.CATEGORY_SYSTEM);
        zn6.h("daily_selfalive_alert", "view", map);
        if (ignoreBatteryVo.popwinstyle != 2) {
            new AlertDialog.Builder(activity).setMessage(ignoreBatteryVo.popwinmsg).setCancelable(false).setPositiveButton("去设置", new c(activity, ignoreBatteryVo)).setNegativeButton("取消", new b()).create().show();
            return;
        }
        MaterialDialog materialDialogE = new sd3(activity).k(ignoreBatteryVo.popwinmsg).P("去设置").L("取消").h(false).f(new a(activity, ignoreBatteryVo)).e();
        materialDialogE.setCanceledOnTouchOutside(false);
        materialDialogE.show();
    }

    public static void m() {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.NOTIFY_GUIDE;
        sPUtil.t(scene, "thread_power_guide_time", Integer.valueOf(sPUtil.f(scene, "thread_power_guide_time", 0) + 1));
        sPUtil.t(scene, "thread_power_guide_interval", Long.valueOf(ir5.b()));
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }
}
