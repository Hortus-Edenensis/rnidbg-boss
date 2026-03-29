package com.efs.sdk.fluttersdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Environment;
import android.os.StatFs;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.config.GlobalInfoManager;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class FlutterConfigManager {
    private EfsReporter c;
    private Context i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5603a = "FlutterConfigManager";
    private final int b = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private boolean h = false;
    private boolean j = false;

    public FlutterConfigManager(Context context, EfsReporter efsReporter) {
        this.i = context;
        this.c = efsReporter;
        efsReporter.getAllSdkConfig(new String[]{"flutter_pv_sampling_rate", "flutter_pv_max_count", "flutter_dart_exception_state", "flutter_dart_exception_max_count"}, new IConfigCallback() { // from class: com.efs.sdk.fluttersdk.FlutterConfigManager.1
            @Override // com.efs.sdk.base.observer.IConfigCallback
            public final void onChange(Map<String, Object> map) {
                try {
                    Object obj = map.get("flutter_pv_sampling_rate");
                    if (obj != null) {
                        FlutterConfigManager.this.d = Integer.parseInt(obj.toString());
                        FlutterConfigManager flutterConfigManager = FlutterConfigManager.this;
                        flutterConfigManager.h = FlutterConfigManager.a(flutterConfigManager.d);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                try {
                    Object obj2 = map.get("flutter_pv_max_count");
                    if (obj2 != null) {
                        FlutterConfigManager.this.e = Integer.parseInt(obj2.toString());
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                try {
                    Object obj3 = map.get("flutter_dart_exception_state");
                    if (obj3 != null) {
                        FlutterConfigManager.this.f = Integer.parseInt(obj3.toString());
                    }
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
                try {
                    Object obj4 = map.get("flutter_dart_exception_max_count");
                    if (obj4 != null) {
                        FlutterConfigManager.this.g = Integer.parseInt(obj4.toString());
                    }
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
                FlutterConfigManager.b(FlutterConfigManager.this);
            }
        });
    }

    public Map<String, Object> getCloudConfig() {
        if (!this.j) {
            return null;
        }
        HashMap map = new HashMap();
        map.put("flutter_pv_max_count", Integer.valueOf(this.e));
        map.put("flutter_dart_exception_state", Integer.valueOf(this.f));
        map.put("flutter_dart_exception_max_count", Integer.valueOf(this.g));
        map.put("flutter_pv_sampling_hit", Boolean.valueOf(this.h));
        return map;
    }

    public Map<String, Object> getNativeParams() {
        HashMap map = null;
        if (!this.j) {
            return null;
        }
        try {
            HashMap map2 = new HashMap();
            try {
                Intent intentRegisterReceiver = this.i.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                map2.put("battery", Integer.valueOf(intentRegisterReceiver.getIntExtra("level", 0)));
                map2.put("temperature", Integer.valueOf(intentRegisterReceiver.getIntExtra("temperature", 0)));
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                map2.put("disk_ratio", String.format(Locale.getDefault(), "%.2f", Double.valueOf(((statFs.getAvailableBlocksLong() * r3) / (statFs.getBlockCountLong() * statFs.getBlockSizeLong())) * 100.0d)));
                map2.putAll(GlobalInfoManager.getInstance().getGlobalInfo().getGlobalInfoMap());
                map2.putAll(ControllerCenter.getGlobalEnvStruct().getPublicParamMap());
                return map2;
            } catch (Throwable unused) {
                map = map2;
                return map;
            }
        } catch (Throwable unused2) {
        }
    }

    public boolean isFlutterEnable() {
        return this.h;
    }

    public static /* synthetic */ boolean b(FlutterConfigManager flutterConfigManager) {
        flutterConfigManager.j = true;
        return true;
    }

    public static /* synthetic */ boolean a(int i) {
        if (SamplingWhiteListUtil.isHitWL()) {
            return true;
        }
        if (i != 0) {
            return i == 100 || new Random().nextInt(100) <= i;
        }
        return false;
    }
}
