package org.apache.cordova.jssdk;

import defpackage.bb3;
import defpackage.ja3;
import defpackage.ka3;
import defpackage.ma3;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class LxStoragePlugin extends CordovaPlugin {
    private String mPreferencesDirPath;
    Map<String, bb3> mPreferencesMap = new HashMap();

    private boolean clear(bb3 bb3Var) {
        return bb3Var.clear();
    }

    private boolean commit(bb3 bb3Var) {
        return bb3Var.commit();
    }

    private String genFilePath(String str) {
        return this.mPreferencesDirPath + File.separator + "pref" + str;
    }

    private JSONObject getObject(String str, bb3 bb3Var) {
        Object objB = bb3Var.b(str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str, objB);
        } catch (JSONException e) {
            ma3.c(e);
        }
        return jSONObject;
    }

    private JSONObject remove(String str, bb3 bb3Var) {
        Object objRemove = bb3Var.remove(str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str, objRemove);
        } catch (JSONException e) {
            ma3.c(e);
        }
        return jSONObject;
    }

    private boolean setStorage(String str, bb3 bb3Var) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                bb3Var.a(next, jSONObject.get(next));
            }
            return true;
        } catch (JSONException e) {
            ma3.c(e);
            return false;
        }
    }

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String str, String str2, CallbackContext callbackContext) throws JSONException {
        CordovaWebView cordovaWebView = this.webView;
        ka3.b appInfo = cordovaWebView.pluginManager.getAppInfo(cordovaWebView.loadedUrl);
        bb3 ja3Var = this.mPreferencesMap.get(appInfo.f21948a);
        if (ja3Var == null) {
            ja3Var = new ja3(genFilePath(appInfo.f21948a));
            this.mPreferencesMap.put(appInfo.f21948a, ja3Var);
        }
        if ("lx_setStorage".equals(str)) {
            if (setStorage(str2, ja3Var)) {
                callbackContext.success();
            } else {
                callbackContext.error("error");
            }
            return true;
        }
        if ("lx_getStorage".equals(str)) {
            callbackContext.success(getObject(CordovaUtils.removeQuotation(str2), ja3Var));
            return true;
        }
        if ("lx_removeStorage".equals(str)) {
            callbackContext.success(remove(CordovaUtils.removeQuotation(str2), ja3Var));
            return true;
        }
        if ("lx_clearStorage".equals(str)) {
            if (clear(ja3Var)) {
                callbackContext.success();
            } else {
                callbackContext.error("error");
            }
            return true;
        }
        if (!"lx_commitStorage".equals(str)) {
            return false;
        }
        if (commit(ja3Var)) {
            callbackContext.success();
        } else {
            callbackContext.error("error");
        }
        return true;
    }

    @Override // org.apache.cordova.CordovaPlugin
    public void pluginInitialize() {
        StringBuilder sb = new StringBuilder(this.webView.getContext().getFilesDir().getAbsolutePath());
        String str = File.separator;
        sb.append(str);
        sb.append("webapp");
        sb.append(str);
        sb.append("storage");
        this.mPreferencesDirPath = sb.toString();
        File file = new File(this.mPreferencesDirPath);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }
}
