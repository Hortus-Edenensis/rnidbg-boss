package com.tide.host.a;

import com.tide.protocol.config.TideWholeConfig;
import com.tide.protocol.host.model.PluginUpdateInfo;
import com.tide.protocol.util.TdLogUtils;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class l0 implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f10793a;
    public final /* synthetic */ m0 b;

    public l0(m0 m0Var, String str) {
        this.b = m0Var;
        this.f10793a = str;
    }

    @Override // com.tide.host.a.s
    public final void a(Object obj) {
        PluginUpdateInfo pluginUpdateInfo = (PluginUpdateInfo) obj;
        TdLogUtils.log("TdPluginServiceImp", "TdPluginServiceImp Response: " + pluginUpdateInfo);
        if (pluginUpdateInfo == null) {
            String str = this.f10793a;
            e0.a().onEvent("td_update_req_result", str, new s0(str, 0, 17001, -1, -1, -1, null).b);
            return;
        }
        int i = (pluginUpdateInfo.pluginCode > TideWholeConfig.getInstance().getPluginVersionCode(this.f10793a) || pluginUpdateInfo.updateForce) ? 1 : 0;
        TdLogUtils.log("shouldUpdate", "返回的版本号 " + pluginUpdateInfo.pluginCode + " 当前的版本号 " + TideWholeConfig.getInstance().getPluginVersionCode(this.f10793a));
        boolean z = pluginUpdateInfo.updateForce;
        String str2 = pluginUpdateInfo.pluginName;
        e0.a().onEvent("td_update_req_result", str2, new s0(str2, 1, -1, i, pluginUpdateInfo.pluginCode, z ? 1 : 0, null).b);
        if (i != 0) {
            StringBuilder sb = new StringBuilder();
            if (m.f10794a == null) {
                File file = new File(t0.b.getFilesDir(), ".tide_download");
                m.f10794a = file;
                if (!file.exists()) {
                    file.mkdirs();
                }
            }
            sb.append(m.f10794a.getPath());
            sb.append(File.separator);
            sb.append(pluginUpdateInfo.pluginName);
            this.b.downloadPlugin(pluginUpdateInfo, sb.toString());
        }
    }

    @Override // com.tide.host.a.s
    public final void a(int i, String str) {
        TdLogUtils.error("TdPluginServiceImp", "TdPluginServiceImp Error: " + str);
        int i2 = i == -1 ? 17002 : i;
        HashMap map = new HashMap();
        map.put("reason", i2 + " " + str);
        String str2 = this.f10793a;
        e0.a().onEvent("td_update_req_result", str2, new s0(str2, 0, i2, -1, -1, -1, map).b);
    }
}
