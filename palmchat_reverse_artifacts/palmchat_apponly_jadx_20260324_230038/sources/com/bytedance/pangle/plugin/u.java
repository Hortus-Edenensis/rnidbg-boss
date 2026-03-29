package com.bytedance.pangle.plugin;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.mv;
import com.bytedance.pangle.util.x;
import com.bytedance.sdk.openadsdk.api.iz;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends Plugin {
    private com.bytedance.pangle.fx.u u;

    public u(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    private void fx() {
        String strT = mv.u().t(this.mPkgName);
        if (TextUtils.isEmpty(strT)) {
            return;
        }
        String strU = com.bytedance.pangle.pn.fx.u(strT);
        x.u(strU);
        mv.u().l(this.mPkgName);
        ZeusLogger.w(ZeusLogger.TAG_INIT, "DexPlugin deleteA_PackageName dir=".concat(String.valueOf(strU)));
    }

    private void nr() {
        List<String> listMv = mv.u().mv(this.mPkgName);
        if (listMv == null || listMv.size() <= 0) {
            return;
        }
        for (String str : listMv) {
            if (!TextUtils.isEmpty(str)) {
                int iU = com.bytedance.pangle.fx.nr.u(str);
                if (iU != -1) {
                    mv.u().nr(str, iU, false);
                }
                x.u(com.bytedance.pangle.pn.fx.u(str));
            }
        }
        mv.u().s(this.mPkgName);
        ZeusLogger.w(ZeusLogger.TAG_INIT, "DexPlugin deleteAliasLastTimePackageName list=".concat(String.valueOf(listMv)));
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    public void deleteIfNeeded() {
        if (com.bytedance.pangle.pn.b.nr(Zeus.getAppApplication()) && mv.u().a(this.mPkgName)) {
            mv.u().n(this.mPkgName);
            String strU = com.bytedance.pangle.pn.fx.u(this.mPkgName);
            x.u(strU);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "DexPlugin deleteIfNeeded " + this.mPkgName + " dir=" + strU);
            nr();
            fx();
        }
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    public JSONObject getJsonConfig() {
        com.bytedance.pangle.fx.u uVar = this.u;
        if (uVar == null) {
            return null;
        }
        return uVar.iz();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0052 A[Catch: Exception -> 0x005a, all -> 0x00d8, TRY_LEAVE, TryCatch #0 {Exception -> 0x005a, blocks: (B:20:0x0044, B:22:0x0047, B:23:0x0052), top: B:52:0x0044, outer: #1 }] */
    @Override // com.bytedance.pangle.plugin.Plugin
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void init() {
        com.bytedance.pangle.fx.u uVar;
        if (this.mInitialized) {
            return;
        }
        synchronized (this.initializeLock) {
            if (this.mInitialized) {
                return;
            }
            if (com.bytedance.pangle.pn.b.nr(Zeus.getAppApplication())) {
                deleteIfNeeded();
                String strT = mv.u().t(this.mPkgName);
                if (TextUtils.isEmpty(strT)) {
                    strT = this.mPkgName;
                }
                int iU = com.bytedance.pangle.fx.nr.u(strT);
                if (iU != -1) {
                    File[] fileArrT = com.bytedance.pangle.pn.fx.t(strT, iU);
                    File file = new File(com.bytedance.pangle.pn.fx.l(strT, iU));
                    if (fileArrT != null) {
                        try {
                            if (fileArrT.length > 0) {
                                this.u = com.bytedance.pangle.fx.nr.u(file, (List<File>) Arrays.asList(fileArrT));
                            } else {
                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin initDexPlugins unDexZip fail throw exception");
                            }
                        } catch (Exception e) {
                            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin initDexPlugins fail throw exception ".concat(String.valueOf(e)));
                            iz.u(e);
                        }
                        if (fileArrT != null && fileArrT.length > 0 && file.isFile() && (uVar = this.u) != null && uVar.u()) {
                            updateToInstalled(iU);
                        } else {
                            iU = 0;
                        }
                        u(iU);
                        ZeusLogger.i(ZeusLogger.TAG_INIT, "DexPlugin initDexPlugins result=".concat(String.valueOf(this)));
                        mv.u().u(this.mPkgName);
                        mv.u().b(this.mPkgName);
                        mv.u().u(this.mPkgName, com.bytedance.pangle.util.nr.u(Zeus.getAppApplication()));
                        mv.u().u(this.mPkgName, this.mApiVersionCode);
                    }
                }
                u();
            } else {
                updateInstallStateFromMainProcess();
            }
            this.mInitialized = true;
        }
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    public boolean install(File file, com.bytedance.pangle.x.u.pn pnVar) {
        boolean zU = false;
        if (pnVar != null) {
            try {
                com.bytedance.pangle.fx.u uVar = pnVar.fx;
                if (uVar != null) {
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin thread name=" + Thread.currentThread().getName() + " install dex from config " + uVar);
                    String strNr = uVar.nr();
                    int iFx = uVar.fx();
                    synchronized (this.installLock) {
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin synchronized begin, packageName=" + strNr + " plugin=" + this);
                        boolean zU2 = uVar.u();
                        if (zU2 && (zU = com.bytedance.pangle.fx.nr.u(uVar, SystemClock.elapsedRealtime()))) {
                            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin markPluginInstalled, packageName=" + strNr + " version=" + iFx);
                        }
                        synchronized (this) {
                            if (!zU2) {
                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin Dex invalid " + strNr + ":" + iFx);
                            } else if (this.mLifeCycle == 3) {
                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin Dex LIFE_LOADED " + strNr + ":" + this.mVersionCode);
                            } else if (zU) {
                                updateToInstalled(iFx);
                                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin Dex INSTALLED_SUCCESS " + strNr + ":" + iFx);
                            } else {
                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin Dex INSTALL_FAILED " + strNr + ":" + iFx);
                            }
                            x.u(file);
                            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin Dex deleting unDexZip pkgName=" + strNr + " version=" + iFx + " apkFile=" + file);
                        }
                    }
                }
            } catch (Throwable th) {
                ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "DexPlugin DEX ZIP IMPOSSIBLE!!!", th);
            }
        }
        return zU;
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    public String toString() {
        return "DexPlugin{pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", life=" + this.mLifeCycle + '}';
    }

    public void u(com.bytedance.pangle.fx.u uVar) {
        this.u = uVar;
    }

    private void u(int i) {
        if (com.bytedance.pangle.pn.b.nr(Zeus.getAppApplication())) {
            nr();
            String strT = mv.u().t(this.mPkgName);
            if (TextUtils.isEmpty(strT)) {
                com.bytedance.pangle.fx.nr.u(this.mPkgName, i);
            } else {
                com.bytedance.pangle.fx.nr.u(strT, i);
            }
        }
    }

    public void u() {
        String strU = com.bytedance.pangle.pn.fx.u(this.mPkgName);
        if (TextUtils.isEmpty(strU)) {
            return;
        }
        File[] fileArrListFiles = new File(strU).listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            ZeusLogger.d(ZeusLogger.TAG_LOAD, "DexPlugin clear install file, packageName=" + this.mPkgName + " no children files,need delete dir=" + strU);
            x.u(strU);
        }
    }
}
