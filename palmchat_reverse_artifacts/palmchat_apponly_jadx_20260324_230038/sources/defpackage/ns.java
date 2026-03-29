package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.wft.caller.trans.EmptyActivity;
import com.wft.caller.trans.EnhActivity;
import com.wft.caller.trans.TransActivity;
import com.wft.caller.trans.TransProvider;
import com.wft.caller.trans.TransService;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.battery.BatterySaveConfig;
import com.zenmen.palmchat.daemon.IjkActivity;
import com.zenmen.palmchat.daemon.OneActivity;
import com.zenmen.palmchat.daemon.TbActivity;
import com.zenmen.palmchat.daemon.WakeActivity;
import com.zenmen.palmchat.daemon.XcvActivity;
import com.zenmen.palmchat.daemon.YuvActivity;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ns {
    public static ns b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BatterySaveConfig f19586a;

    public ns() {
        this.f19586a = new BatterySaveConfig();
        String strD = d("key_config", "");
        if (!TextUtils.isEmpty(strD)) {
            BatterySaveConfig batterySaveConfig = (BatterySaveConfig) az2.a(strD, BatterySaveConfig.class);
            if (batterySaveConfig != null) {
                this.f19586a = batterySaveConfig;
            }
        } else if (e("key_enable", false)) {
            this.f19586a.setGetuiSwitch(true);
            this.f19586a.setSelfSwitch(true);
            this.f19586a.setYbaoSwitch(true);
            this.f19586a.setWkSwitch(true);
            this.f19586a.setDcLogSwitch(true);
            this.f19586a.setReConnectPolicySwitch(true);
            this.f19586a.setMoveFrontSwitch(true);
            this.f19586a.setJiguangSwitch(true);
            this.f19586a.setMobSwitch(true);
        }
        Log.d("BatterySaveManager", "enable=" + this.f19586a.toString());
    }

    public static void a(Context context, List<Class> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    PackageManager packageManager = context.getPackageManager();
                    Iterator<Class> it = list.iterator();
                    while (it.hasNext()) {
                        ComponentName componentName = new ComponentName(context, (Class<?>) it.next());
                        packageManager.getComponentEnabledSetting(componentName);
                        packageManager.setComponentEnabledSetting(componentName, 2, 1);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static ns c() {
        if (b == null) {
            synchronized (ns.class) {
                if (b == null) {
                    b = new ns();
                }
            }
        }
        return b;
    }

    public BatterySaveConfig b() {
        return this.f19586a;
    }

    public final String d(String str, String str2) {
        return AppContext.getContext().getSharedPreferences("BatterySaveManager", 0).getString(str, str2);
    }

    public final boolean e(String str, boolean z) {
        return AppContext.getContext().getSharedPreferences("BatterySaveManager", 0).getBoolean(str, z);
    }

    public void f(Context context, BatterySaveConfig batterySaveConfig) {
        ArrayList arrayList = new ArrayList();
        if (batterySaveConfig.isWkSwitch()) {
            arrayList.add(WakeActivity.class);
            arrayList.add(IjkActivity.class);
            arrayList.add(OneActivity.class);
            arrayList.add(TbActivity.class);
            arrayList.add(XcvActivity.class);
            arrayList.add(YuvActivity.class);
            arrayList.add(ci6.class);
        }
        if (batterySaveConfig.isYbaoSwitch()) {
            arrayList.add(EmptyActivity.class);
            arrayList.add(EnhActivity.class);
            arrayList.add(TransActivity.class);
            arrayList.add(TransProvider.class);
            arrayList.add(TransService.class);
        }
        a(context, arrayList);
    }

    public void g(Context context) {
        String extra;
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.BATTERYSAVEMODE);
        if (dynamicConfig == null || !dynamicConfig.isEnable() || TextUtils.isEmpty(dynamicConfig.getExtra())) {
            extra = null;
        } else {
            extra = dynamicConfig.getExtra();
            LogUtil.i("BatterySaveManager", "isEnableImp extra=" + dynamicConfig.getExtra());
        }
        h("key_config", extra);
        long jB = ir5.b();
        BatterySaveConfig batterySaveConfig = (BatterySaveConfig) az2.a(extra, BatterySaveConfig.class);
        if (batterySaveConfig != null) {
            try {
                f(context, batterySaveConfig);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        LogUtil.i("BatterySaveManager", "updateOnAppOpen batterySaveConfig=" + batterySaveConfig + " pastTime = " + ir5.e(jB));
    }

    public final void h(String str, String str2) {
        SharedPreferences.Editor editorEdit = AppContext.getContext().getSharedPreferences("BatterySaveManager", 0).edit();
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }
}
