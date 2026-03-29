package com.beizi.fusion.update;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.c.l;
import com.beizi.fusion.model.GlobalConfig;
import com.beizi.fusion.model.IncentiveConfig;
import com.beizi.fusion.model.ResponseInfo;
import com.beizi.fusion.tool.an;
import com.beizi.fusion.tool.t;
import com.beizi.fusion.tool.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4759a;
    private boolean b = true;

    public a(Context context, String str) {
        if (str == null) {
            return;
        }
        this.f4759a = context;
        a(str);
    }

    private void a(String str) {
        try {
            String strB = com.beizi.fusion.tool.b.b(y.a(), str);
            if (TextUtils.isEmpty(strB)) {
                this.b = false;
                return;
            }
            String strB2 = t.b(strB);
            if (!TextUtils.isEmpty(strB2) && !strB2.equalsIgnoreCase(com.igexin.push.core.b.m)) {
                String str2 = (String) an.b(this.f4759a, "globalConfig", "");
                if (TextUtils.isEmpty(str2)) {
                    an.a(this.f4759a, "globalConfig", (Object) com.beizi.fusion.tool.b.a(y.a(), strB2));
                }
                String strB3 = com.beizi.fusion.tool.b.b(y.a(), str2);
                GlobalConfig globalConfigObjectFromData = GlobalConfig.objectFromData(strB2);
                GlobalConfig globalConfigObjectFromData2 = GlobalConfig.objectFromData(strB3);
                if (globalConfigObjectFromData != null) {
                    ResponseInfo.getInstance(this.f4759a).setGlobalConfig(globalConfigObjectFromData);
                    if (!TextUtils.isEmpty(globalConfigObjectFromData.getConfigVersion())) {
                        if (globalConfigObjectFromData2 != null) {
                            globalConfigObjectFromData2.setConfigVersion(globalConfigObjectFromData.getConfigVersion());
                        }
                        if (ResponseInfo.getInstance(this.f4759a).getManager() == null) {
                            ResponseInfo.getInstance(this.f4759a).setConfigVersion(globalConfigObjectFromData.getConfigVersion());
                        }
                    }
                    if (globalConfigObjectFromData.getExpireTime() > 0) {
                        if (globalConfigObjectFromData2 != null) {
                            globalConfigObjectFromData2.setExpireTime(globalConfigObjectFromData.getExpireTime());
                        }
                        ResponseInfo.getInstance(this.f4759a).setExpireTime(globalConfigObjectFromData.getExpireTime());
                    }
                    if (globalConfigObjectFromData.getMaxValidTime() > 0) {
                        if (globalConfigObjectFromData2 != null) {
                            globalConfigObjectFromData2.setMaxValidTime(globalConfigObjectFromData.getMaxValidTime());
                        }
                        ResponseInfo.getInstance(this.f4759a).setMaxValidTime(globalConfigObjectFromData.getMaxValidTime());
                    }
                    if (globalConfigObjectFromData.getConfigurator() != null) {
                        if (globalConfigObjectFromData2 != null) {
                            globalConfigObjectFromData2.setConfigurator(globalConfigObjectFromData.getConfigurator());
                        }
                        if (ResponseInfo.getInstance(this.f4759a).getManager() == null) {
                            ResponseInfo.getInstance(this.f4759a).setConfigurator(globalConfigObjectFromData.getConfigurator());
                        }
                    }
                    if (globalConfigObjectFromData.getMessenger() != null) {
                        if (globalConfigObjectFromData2 != null) {
                            globalConfigObjectFromData2.setMessenger(globalConfigObjectFromData.getMessenger());
                        }
                        if (ResponseInfo.getInstance(this.f4759a).getManager() == null) {
                            ResponseInfo.getInstance(this.f4759a).setMessenger(globalConfigObjectFromData.getMessenger());
                        }
                    }
                    if (globalConfigObjectFromData.getManager() != null) {
                        if (globalConfigObjectFromData2 != null) {
                            globalConfigObjectFromData2.setManager(globalConfigObjectFromData.getManager());
                        }
                        if (ResponseInfo.getInstance(this.f4759a).getManager() == null) {
                            ResponseInfo.getInstance(this.f4759a).setManager(globalConfigObjectFromData.getManager());
                        }
                    }
                    if (globalConfigObjectFromData.getTaskConfig() != null) {
                        if (globalConfigObjectFromData2 != null) {
                            globalConfigObjectFromData2.setTaskConfig(globalConfigObjectFromData.getTaskConfig());
                        }
                        ResponseInfo.getInstance(this.f4759a).setTaskConfig(globalConfigObjectFromData.getTaskConfig());
                    }
                    if (globalConfigObjectFromData.getAdPlusConfig() != null) {
                        if (globalConfigObjectFromData2 != null) {
                            globalConfigObjectFromData2.setAdPlusConfig(globalConfigObjectFromData.getAdPlusConfig());
                        }
                        ResponseInfo.getInstance(this.f4759a).setAdPlusConfig(globalConfigObjectFromData.getAdPlusConfig());
                        l.a(this.f4759a);
                    }
                    IncentiveConfig incentiveConfig = globalConfigObjectFromData.getIncentiveConfig();
                    if (incentiveConfig != null) {
                        if (globalConfigObjectFromData2 != null) {
                            globalConfigObjectFromData2.setIncentiveConfig(incentiveConfig);
                        }
                        ResponseInfo.getInstance(this.f4759a).setIncentiveConfig(incentiveConfig);
                    }
                    if (!TextUtils.isEmpty(globalConfigObjectFromData.getCrashUrl())) {
                        if (globalConfigObjectFromData2 != null) {
                            globalConfigObjectFromData2.setCrashUrl(globalConfigObjectFromData.getCrashUrl());
                        }
                        ResponseInfo.getInstance(this.f4759a).setCrashUrl(globalConfigObjectFromData.getCrashUrl());
                    }
                    String strObjectToJson = GlobalConfig.objectToJson(globalConfigObjectFromData2);
                    if (TextUtils.isEmpty(strObjectToJson)) {
                        return;
                    }
                    an.a(this.f4759a, "globalConfig", (Object) com.beizi.fusion.tool.b.a(y.a(), strObjectToJson));
                    return;
                }
                return;
            }
            this.b = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean a() {
        return this.b;
    }
}
