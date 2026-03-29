package com.bytedance.pangle.plugin;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.b.nr;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.x;
import com.bytedance.sdk.openadsdk.api.iz;
import com.qiniu.android.collect.ReportItem;
import java.io.File;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class nr implements Runnable {
    private final String nr;
    private File u;

    public nr(String str, File file) {
        this.u = file;
        this.nr = str;
    }

    private com.bytedance.pangle.x.u.pn fx() {
        com.bytedance.pangle.fx.u uVarU;
        if (this.u == null) {
            return null;
        }
        try {
            File file = new File(this.u.getAbsolutePath() + "_unzip");
            if (file.exists()) {
                x.u(file);
                file.mkdirs();
            }
            x.nr(this.u.getAbsolutePath(), file.getAbsolutePath());
            File[] fileArrListFiles = file.listFiles();
            LinkedList linkedList = new LinkedList();
            File file2 = null;
            for (File file3 : fileArrListFiles) {
                if (file3.getName().equals("config.json")) {
                    file2 = file3;
                } else if (file3.getName().endsWith(".dex")) {
                    linkedList.add(file3);
                }
            }
            x.u(this.u);
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "PluginInstallRunnable Dex deleting downloadFile apkFile=" + this.u);
            this.u = file;
            if (linkedList.size() > 0 && file2 != null && file2.isFile() && (uVarU = com.bytedance.pangle.fx.nr.u(file2, linkedList)) != null) {
                return new com.bytedance.pangle.x.u.pn(uVarU);
            }
        } catch (Exception e) {
            iz.u(e);
        }
        return null;
    }

    private void nr() {
        int i = 3;
        while (i > 0) {
            i--;
            try {
                File file = new File(this.u.getAbsolutePath() + "_unzip");
                if (file.exists()) {
                    file.delete();
                    file.mkdirs();
                }
                x.nr(this.u.getAbsolutePath(), file.getAbsolutePath());
                File[] fileArrListFiles = file.listFiles();
                File file2 = this.u;
                if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                    file2 = fileArrListFiles[0];
                }
                File fileU = u(file2);
                if (fileU != null && fileU.exists() && fileU.isFile()) {
                    this.u = fileU;
                    ZeusLogger.d("Plugin install : unZip count : " + (3 - i));
                    return;
                }
            } catch (Exception e) {
                ZeusLogger.errReport(ZeusLogger.TAG_INIT, "Plugin install : unZip file failed !!!", e);
                iz.u(e);
            }
        }
    }

    private File u(File file) {
        if (file.exists() || file.getParent() == null) {
            return file;
        }
        File[] fileArrListFiles = new File(file.getParent()).listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return null;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.exists() && file2.getName().endsWith(com.huawei.hms.ads.dynamicloader.b.b)) {
                return file2;
            }
        }
        return file;
    }

    @Override // java.lang.Runnable
    public void run() {
        u();
    }

    private static void u(String str, int i, @NonNull String str2, int i2, long j, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt(ReportItem.RequestKeyStatusCode, com.bytedance.pangle.log.nr.u(Integer.valueOf(i)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.nr.u(str2));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.nr.u(Integer.valueOf(i2)));
            jSONObject3.putOpt("duration", Integer.valueOf(com.bytedance.pangle.log.nr.nr(Long.valueOf(j))));
            jSONObject2.putOpt("message", com.bytedance.pangle.log.nr.u(str3));
        } catch (JSONException e) {
            iz.u(e);
        }
        com.bytedance.pangle.b.nr.u().u(str, jSONObject, jSONObject3, jSONObject2);
    }

    public boolean u() {
        com.bytedance.pangle.x.u.pn pnVarU;
        File file = this.u;
        if (file != null && file.getName().endsWith(".dex.zip")) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            ZeusLogger.d("Plugin install : start unDexZip file ~~~~");
            pnVarU = fx();
            if (pnVarU != null) {
                u(com.bytedance.pangle.b.nr.x, nr.u.bg, this.nr, 0, SystemClock.elapsedRealtime() - jElapsedRealtime, "");
                ZeusLogger.d("Plugin install : finish install from unDexZip success ~~~~");
            } else {
                ZeusLogger.d("Plugin install : finish install from unDexZip fail ~~~~");
            }
        } else {
            if (x.nr(this.u)) {
                ZeusLogger.d("Plugin install : start unZip file ~~~~");
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                nr();
                u(com.bytedance.pangle.b.nr.x, nr.u.wq, this.nr, 0, SystemClock.elapsedRealtime() - jElapsedRealtime2, "");
                ZeusLogger.d("Plugin install : start install from unZip ~~~~");
            } else {
                ZeusLogger.d("Plugin install : start install without unZip ~~~~");
            }
            pnVarU = com.bytedance.pangle.x.u.b.u(this.u);
        }
        if (pnVarU == null) {
            ZeusPluginStateListener.postStateChange(this.nr, 7, " read local file package info failed !!! pluginPkg = " + this.nr + " mApkFile.exists = " + this.u.exists());
            StringBuilder sb = new StringBuilder("PluginInstallRunnable read local file package info failed !!! pluginPkg = ");
            sb.append(this.nr);
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, sb.toString());
            return false;
        }
        Plugin plugin = PluginManager.getInstance().getPlugin(pnVarU.u);
        if (plugin == null) {
            ZeusPluginStateListener.postStateChange(this.nr, 7, " plugin == null !!! pluginPkg = " + this.nr);
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstallRunnable cannot query valid plugin !!! packageName = " + pnVarU.u);
            return false;
        }
        boolean zInstall = plugin.install(this.u, pnVarU);
        if (zInstall) {
            ZeusPluginStateListener.postStateChange(pnVarU.u, 6, new Object[0]);
        } else {
            ZeusPluginStateListener.postStateChange(pnVarU.u, 7, "Internal error.");
        }
        return zInstall;
    }
}
