package org.apache.cordova.jssdk;

import android.app.Activity;
import android.graphics.Bitmap;
import com.zenmen.openapi.webapp.WebViewFragment;
import com.zenmen.palmchat.AppContext;
import defpackage.ah;
import defpackage.an1;
import defpackage.ax2;
import defpackage.e84;
import defpackage.f84;
import defpackage.hc2;
import defpackage.jo6;
import defpackage.ka3;
import defpackage.ma3;
import defpackage.md2;
import java.util.concurrent.ExecutionException;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class LxCheckApiPlugin extends CordovaPlugin {
    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String str, String str2, final CallbackContext callbackContext) throws JSONException {
        final ah ahVarJ0;
        ma3.f("LxCheckApiPlugin execute " + str + " args:" + str2);
        if (str.equals("grantApp")) {
            new JSONObject(str2).optBoolean("debug", false);
            CordovaInterface cordovaInterface = this.cordova;
            if (cordovaInterface instanceof WebViewFragment) {
                ahVarJ0 = ((WebViewFragment) cordovaInterface).j0();
                if (ahVarJ0 != null) {
                    f84.e(ahVarJ0, "display");
                }
            } else {
                ahVarJ0 = null;
            }
            this.webView.pluginManager.grantApp(str2, new e84() { // from class: org.apache.cordova.jssdk.LxCheckApiPlugin.1
                @Override // defpackage.e84
                public void onCallback(int i, String str3, Object obj) {
                    ma3.f("LxCheckApiPlugin grantApp onCallback " + obj + i);
                    if (i != 1) {
                        ah ahVar = ahVarJ0;
                        if (ahVar != null) {
                            f84.e(ahVar, "confFail");
                        }
                        callbackContext.error(str3);
                        return;
                    }
                    ah ahVar2 = ahVarJ0;
                    if (ahVar2 != null) {
                        f84.e(ahVar2, "confSuc");
                    }
                    callbackContext.success((JSONObject) obj);
                    final Activity ownerActivity2 = LxCheckApiPlugin.this.cordova.getOwnerActivity2();
                    CordovaWebView cordovaWebView = LxCheckApiPlugin.this.webView;
                    final ka3.b appInfo = cordovaWebView.pluginManager.getAppInfo(cordovaWebView.loadedUrl);
                    if (appInfo == null) {
                        return;
                    }
                    if (jo6.C()) {
                        an1.c().l(appInfo);
                    }
                    if (ownerActivity2 instanceof md2) {
                        ax2.a().execute(new Runnable() { // from class: org.apache.cordova.jssdk.LxCheckApiPlugin.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                final Bitmap bitmap;
                                try {
                                    bitmap = hc2.a(AppContext.getContext()).asBitmap().load(appInfo.c).submit().get();
                                } catch (InterruptedException | ExecutionException e) {
                                    e.printStackTrace();
                                    bitmap = null;
                                }
                                ownerActivity2.runOnUiThread(new Runnable() { // from class: org.apache.cordova.jssdk.LxCheckApiPlugin.1.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Bitmap bitmap2 = bitmap;
                                        if (bitmap2 != null) {
                                            ((md2) ownerActivity2).onCallback(1, null, bitmap2);
                                        } else {
                                            ((md2) ownerActivity2).onCallback(0, null, null);
                                        }
                                    }
                                });
                            }
                        });
                    }
                }
            });
            return true;
        }
        if (!str.equals("lx_checkJsApi")) {
            return false;
        }
        ma3.a("LxCheckApiPlugin lx_checkApiList start ", new Object[0]);
        JSONObject jSONObjectCheckJsApi = this.webView.pluginManager.checkJsApi(new JSONArray(str2));
        ma3.a("LxCheckApiPlugin lx_checkApiList get reslut " + jSONObjectCheckJsApi, new Object[0]);
        callbackContext.success(jSONObjectCheckJsApi);
        return true;
    }
}
