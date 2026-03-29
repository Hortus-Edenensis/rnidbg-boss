package com.bytedance.pangle.fx;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginDecodeCallback;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.b.nr;
import com.bytedance.pangle.jk;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.b;
import com.bytedance.pangle.pn.fx;
import com.bytedance.pangle.util.a;
import com.bytedance.pangle.util.mv;
import com.bytedance.pangle.util.n;
import com.bytedance.pangle.util.x;
import com.bytedance.sdk.openadsdk.api.iz;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class nr {
    private static String nr(String str) {
        return (str == null || !str.endsWith(":")) ? str : str.substring(0, str.length() - 1);
    }

    public static int u(String str) {
        String strU;
        File[] fileArrT;
        int i = -1;
        if (TextUtils.isEmpty(str) || (strU = fx.u(str)) == null) {
            return -1;
        }
        File[] fileArrListFiles = new File(strU).listFiles(new FileFilter() { // from class: com.bytedance.pangle.fx.nr.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return file != null && file.getName().matches("^version-(\\d+)$");
            }
        });
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file : fileArrListFiles) {
                int i2 = Integer.parseInt(file.getName().split("-")[1]);
                if (i2 > i && mv.u().b(str, i2) && (fileArrT = fx.t(str, i2)) != null && fileArrT.length > 0) {
                    i = i2;
                }
            }
        }
        return i;
    }

    public static void u(final String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strU = fx.u(str);
        if (TextUtils.isEmpty(strU)) {
            return;
        }
        final String strConcat = "version-".concat(String.valueOf(i));
        new File(strU).listFiles(new FileFilter() { // from class: com.bytedance.pangle.fx.nr.2
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                if (file != null && !strConcat.equals(file.getName())) {
                    x.u(file.getAbsolutePath());
                    if (file.getName().matches("^version-(\\d+)$")) {
                        mv.u().nr(str, Integer.parseInt(file.getName().split("-")[1]), false);
                    }
                }
                return false;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0088 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008d A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static u u(File file, List<File> list) throws JSONException, IOException {
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        if (file != null && list != null && list.size() > 0) {
            try {
                StringBuilder sb = new StringBuilder();
                fileInputStream = new FileInputStream(file);
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream);
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader);
                        while (true) {
                            try {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                sb.append(line);
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils parse dex config fail throw error ".concat(String.valueOf(th)));
                                    return null;
                                } finally {
                                    if (fileInputStream != null) {
                                        fileInputStream.close();
                                    }
                                    if (inputStreamReader != null) {
                                        inputStreamReader.close();
                                    }
                                    if (bufferedReader != 0) {
                                        bufferedReader.close();
                                    }
                                }
                            }
                        }
                        ZeusPluginDecodeCallback zeusPluginDecodeCallbackB = jk.u().b();
                        if (zeusPluginDecodeCallbackB != null) {
                            String strDecode = zeusPluginDecodeCallbackB.decode(sb.toString());
                            if (!TextUtils.isEmpty(strDecode)) {
                                JSONObject jSONObject = new JSONObject(strDecode);
                                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils parse dex config json success");
                                u uVarU = u.u(jSONObject, file, list);
                                fileInputStream.close();
                                inputStreamReader.close();
                                bufferedReader.close();
                                return uVarU;
                            }
                            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils parse dex config fail decode content is empty");
                        } else {
                            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils parse dex config fail decode callback is null");
                        }
                        fileInputStream.close();
                        inputStreamReader.close();
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = 0;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStreamReader = null;
                    bufferedReader = inputStreamReader;
                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils parse dex config fail throw error ".concat(String.valueOf(th)));
                    return null;
                }
            } catch (Throwable th4) {
                th = th4;
                fileInputStream = null;
                inputStreamReader = null;
            }
        }
        return null;
    }

    public static boolean u(u uVar, long j) {
        List<File> listB;
        File filePn;
        if (uVar != null) {
            listB = uVar.b();
            filePn = uVar.pn();
        } else {
            listB = null;
            filePn = null;
        }
        if (filePn != null && listB != null && listB.size() > 0) {
            int iFx = uVar.fx();
            String strNr = uVar.nr();
            ZeusPluginStateListener.postStateChange(strNr, 11, new Object[0]);
            com.bytedance.pangle.plugin.fx.u(com.bytedance.pangle.b.nr.b, nr.u.sx, strNr, iFx, -1L, null);
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex start packageName = " + strNr + " version is " + iFx);
            String strT = mv.u().t(strNr);
            if (!TextUtils.isEmpty(strT) && u(strT) >= iFx) {
                com.bytedance.pangle.plugin.fx.u(com.bytedance.pangle.b.nr.pn, nr.u.bq, strNr, iFx, -1L, "dex installed version more than download version can no install new dex zip");
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils ".concat("dex installed version more than download version can no install new dex zip"));
                return false;
            }
            String strX = TextUtils.isEmpty(uVar.x()) ? strNr : uVar.x();
            if (!fx.jk(strX, iFx)) {
                try {
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex no dir need install packageName=" + strNr + " version=" + iFx);
                    for (File file : listB) {
                        if (file.getName().endsWith(".dex")) {
                            String strU = fx.u(strX, iFx, file.getName());
                            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex = " + file.getName());
                            n.u(file.getAbsolutePath(), strU);
                        }
                    }
                    if (filePn.getName().endsWith(".json")) {
                        String strL = fx.l(strX, iFx);
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex config = " + filePn.getName());
                        n.u(filePn.getAbsolutePath(), strL);
                    }
                    if (fx.jk(strX, iFx)) {
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex success packageName = " + strNr + " version = " + iFx);
                        ZeusPluginStateListener.postStateChange(strNr, 12, new Object[0]);
                        com.bytedance.pangle.plugin.fx.u(com.bytedance.pangle.b.nr.pn, nr.u.bg, strNr, iFx, SystemClock.elapsedRealtime() - j, "install success");
                        mv.u().nr(strX, iFx, true);
                        if (!TextUtils.isEmpty(uVar.x())) {
                            mv.u().fx(strNr, strX);
                            mv.u().b(strNr, strT);
                        }
                        return true;
                    }
                    com.bytedance.pangle.plugin.fx.u(com.bytedance.pangle.b.nr.pn, nr.u.bq, strNr, iFx, -1L, "install dir not exists");
                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils ".concat("install dir not exists"));
                } catch (Exception e) {
                    com.bytedance.pangle.plugin.fx.u(com.bytedance.pangle.b.nr.pn, nr.u.bq, strNr, iFx, -1L, "throw exception: ".concat(String.valueOf(e)));
                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex fail throw exception");
                    iz.u(e);
                }
            } else {
                com.bytedance.pangle.plugin.fx.u(com.bytedance.pangle.b.nr.pn, nr.u.bg, strNr, iFx, SystemClock.elapsedRealtime() - j, "install success 已经安装完成");
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex already install packageName = " + strNr + " version = " + iFx);
                return true;
            }
        } else {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex fail config is null");
        }
        return false;
    }

    public static boolean u(Plugin plugin, StringBuilder sb) {
        try {
            if (plugin == null) {
                sb.append("loadDexPlugin fail, plugin == null;");
                return false;
            }
            if (!plugin.isInstalled()) {
                sb.append("loadDexPlugin fail, plugin is not installed");
                return false;
            }
            if (!(plugin instanceof com.bytedance.pangle.plugin.u)) {
                sb.append("loadDexPlugin fail, plugin must be dexPlugin");
                return false;
            }
            String strT = mv.u().t(plugin.mPkgName);
            if (TextUtils.isEmpty(strT)) {
                strT = plugin.mPkgName;
            }
            int iU = u(strT);
            if (iU == -1) {
                sb.append("loadDexPlugin fail, get Plugin version is -1");
                return false;
            }
            File[] fileArrT = fx.t(strT, iU);
            if (fileArrT != null && fileArrT.length != 0) {
                String strL = fx.l(strT, iU);
                if (TextUtils.isEmpty(strL)) {
                    sb.append("loadDexPlugin fail, configFileString is empty");
                    return false;
                }
                File file = new File(strL);
                if (file.exists() && file.isFile()) {
                    u uVarU = u(file, (List<File>) Arrays.asList(fileArrT));
                    ((com.bytedance.pangle.plugin.u) plugin).u(uVarU);
                    if (uVarU == null) {
                        sb.append("loadDexPlugin fail, config is null");
                        return false;
                    }
                    if (!uVarU.u()) {
                        sb.append("loadDexPlugin fail, check dex fail");
                        return false;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    for (File file2 : fileArrT) {
                        if (file2.isFile()) {
                            sb2.append(file2.getAbsolutePath());
                            sb2.append(":");
                        }
                    }
                    String strNr = nr(sb2.toString());
                    if (TextUtils.isEmpty(strNr)) {
                        sb.append("loadDexPlugin fail, dexPath is empty");
                        return false;
                    }
                    Map<String, JSONObject> mapPn = jk.u().pn();
                    if (mapPn != null && mapPn.size() != 0) {
                        JSONObject jSONObject = mapPn.get(plugin.mPkgName);
                        if (jSONObject != null && jSONObject.has("hostPackageName")) {
                            String strOptString = jSONObject.optString("hostPackageName");
                            if (TextUtils.isEmpty(strOptString)) {
                                sb.append("loadDexPlugin fail, hostPackageName is empty");
                                return false;
                            }
                            Plugin plugin2 = Zeus.getPlugin(strOptString);
                            if (plugin2 != null) {
                                if (a.t()) {
                                    sb.append("loadDexPlugin addDexPath success dexPath=".concat(String.valueOf(strNr)));
                                    return b.u(plugin2.mClassLoader, strNr);
                                }
                                if (plugin2.mClassLoader != null) {
                                    ArrayList arrayList = new ArrayList(1);
                                    arrayList.add(new PluginClassLoader(strNr, null, null, null));
                                    sb.append("loadDexPlugin setOtherPluginClassLoader success dexPath=");
                                    sb.append(strNr);
                                    plugin2.mClassLoader.setOtherPluginClassLoader(arrayList);
                                    return true;
                                }
                                sb.append("loadDexPlugin fail classLoader is null");
                                return false;
                            }
                            sb.append("loadDexPlugin fail, hostPlugin is null hostPackageName=");
                            sb.append(strOptString);
                            return false;
                        }
                        sb.append("loadDexPlugin fail, dex config can not get hostPackageName");
                        return false;
                    }
                    sb.append("loadDexPlugin fail, getPackageDexManager is empty");
                    return false;
                }
                sb.append("loadDexPlugin fail, config file is not exists or is not file");
                return false;
            }
            sb.append("loadDexPlugin fail, get dex files is null or length is 0");
            return false;
        } catch (Throwable th) {
            sb.append("loadDexPlugin fail, throw error ");
            sb.append(th);
            return false;
        }
    }
}
