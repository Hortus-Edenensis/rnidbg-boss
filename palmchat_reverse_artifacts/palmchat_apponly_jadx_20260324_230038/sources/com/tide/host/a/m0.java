package com.tide.host.a;

import android.text.TextUtils;
import com.tide.protocol.config.TideWholeConfig;
import com.tide.protocol.host.model.PluginUpdateInfo;
import com.tide.protocol.service.IPluginUpdate;
import com.tide.protocol.util.TdLogUtils;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class m0 implements IPluginUpdate {
    @Override // com.tide.protocol.service.IPluginUpdate
    public final void checkUpdate(String str) {
        if (TextUtils.isEmpty(str)) {
            TdLogUtils.error("TdPluginServiceImp", "checkUpdate pluginName is empty");
            return;
        }
        y yVar = new y(str, new l0(this, str));
        e0.a().onEvent("td_update_req", str, new d0(str).b);
        new k(str, yVar.f10805a, TideWholeConfig.getInstance(), yVar.b).a(new x(yVar));
    }

    @Override // com.tide.protocol.service.IPluginUpdate
    public final void downloadPlugin(PluginUpdateInfo pluginUpdateInfo, String str) {
        if (pluginUpdateInfo == null || TextUtils.isEmpty(str)) {
            TdLogUtils.error("TdPluginServiceImp", "downloadPlugin pluginUpdateInfo or  savePath is empty");
            return;
        }
        String str2 = pluginUpdateInfo.pluginName;
        e0.a().onEvent("td_download_start", str2, new f0(pluginUpdateInfo.pluginCode, str2, pluginUpdateInfo.downloadUrl, null).b);
        long jCurrentTimeMillis = System.currentTimeMillis();
        File file = new File(str);
        if (file.exists() && !file.delete()) {
            TdLogUtils.error("TdPluginServiceImp", "downloadPlugin saveFile delete fail maybe multi thread dealing with this file");
            String str3 = pluginUpdateInfo.pluginName;
            f0 f0Var = new f0(pluginUpdateInfo.pluginCode, str3, pluginUpdateInfo.downloadUrl, null);
            f0Var.a("duration", 0L);
            f0Var.a("result", 0);
            f0Var.a("code", 18003);
            e0.a().onEvent("td_download_result", str3, f0Var.b);
            return;
        }
        i iVarA = l.a(pluginUpdateInfo.downloadUrl, str);
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (iVarA.b) {
            String str4 = pluginUpdateInfo.pluginName;
            f0 f0Var2 = new f0(pluginUpdateInfo.pluginCode, str4, pluginUpdateInfo.downloadUrl, null);
            f0Var2.a("duration", Long.valueOf(jCurrentTimeMillis2));
            f0Var2.a("result", 1);
            f0Var2.a("code", -1);
            e0.a().onEvent("td_download_result", str4, f0Var2.b);
            j0.a().a(pluginUpdateInfo, str);
            return;
        }
        HashMap map = new HashMap();
        map.put("reason", iVarA.c + " " + iVarA.f10790a);
        String str5 = pluginUpdateInfo.pluginName;
        f0 f0Var3 = new f0(pluginUpdateInfo.pluginCode, str5, pluginUpdateInfo.downloadUrl, map);
        f0Var3.a("duration", Long.valueOf(jCurrentTimeMillis2));
        f0Var3.a("result", 0);
        f0Var3.a("code", 18001);
        e0.a().onEvent("td_download_result", str5, f0Var3.b);
    }
}
