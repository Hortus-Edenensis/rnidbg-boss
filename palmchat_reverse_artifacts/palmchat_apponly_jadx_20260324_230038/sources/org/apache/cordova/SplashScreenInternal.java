package org.apache.cordova;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.view.Display;
import android.widget.LinearLayout;
import com.huawei.openalliance.ad.constant.bq;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class SplashScreenInternal extends CordovaPlugin {
    private static final String LOG_TAG = "SplashScreenInternal";
    private static boolean firstShow = true;
    private static ProgressDialog spinnerDialog;
    private static Dialog splashDialog;

    private void loadSpinner() {
        String string = this.webView.canGoBack() ? this.preferences.getString("LoadingDialog", null) : this.preferences.getString("LoadingPageDialog", null);
        if (string != null) {
            String strSubstring = "";
            if (string.length() > 0) {
                int iIndexOf = string.indexOf(44);
                if (iIndexOf > 0) {
                    strSubstring = string.substring(0, iIndexOf);
                    string = string.substring(iIndexOf + 1);
                }
            } else {
                string = "Loading Application...";
            }
            spinnerStart(strSubstring, string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSplashScreen() {
        this.cordova.getActivity().runOnUiThread(new Runnable() { // from class: org.apache.cordova.SplashScreenInternal.4
            @Override // java.lang.Runnable
            public void run() {
                if (SplashScreenInternal.splashDialog == null || !SplashScreenInternal.splashDialog.isShowing()) {
                    return;
                }
                SplashScreenInternal.splashDialog.dismiss();
                SplashScreenInternal.splashDialog = null;
            }
        });
    }

    private void showSplashScreen(final boolean z) {
        final int integer = this.preferences.getInteger("SplashScreenDelay", 3000);
        final int integer2 = this.preferences.getInteger("SplashDrawableId", 0);
        Dialog dialog = splashDialog;
        if ((dialog == null || !dialog.isShowing()) && integer2 != 0) {
            if (integer > 0 || !z) {
                this.cordova.getActivity().runOnUiThread(new Runnable() { // from class: org.apache.cordova.SplashScreenInternal.5
                    @Override // java.lang.Runnable
                    public void run() {
                        Display defaultDisplay = SplashScreenInternal.this.cordova.getActivity().getWindowManager().getDefaultDisplay();
                        Context context = SplashScreenInternal.this.webView.getContext();
                        LinearLayout linearLayout = new LinearLayout(context);
                        linearLayout.setMinimumHeight(defaultDisplay.getHeight());
                        linearLayout.setMinimumWidth(defaultDisplay.getWidth());
                        linearLayout.setOrientation(1);
                        linearLayout.setBackgroundColor(SplashScreenInternal.this.preferences.getInteger("backgroundColor", -16777216));
                        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 0.0f));
                        linearLayout.setBackgroundResource(integer2);
                        SplashScreenInternal.splashDialog = new Dialog(context, android.R.style.Theme.Translucent.NoTitleBar);
                        if ((SplashScreenInternal.this.cordova.getActivity().getWindow().getAttributes().flags & 1024) == 1024) {
                            SplashScreenInternal.splashDialog.getWindow().setFlags(1024, 1024);
                        }
                        SplashScreenInternal.splashDialog.setContentView(linearLayout);
                        SplashScreenInternal.splashDialog.setCancelable(false);
                        SplashScreenInternal.splashDialog.show();
                        if (z) {
                            new Handler().postDelayed(new Runnable() { // from class: org.apache.cordova.SplashScreenInternal.5.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    SplashScreenInternal.this.removeSplashScreen();
                                }
                            }, integer);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void spinnerStart(final String str, final String str2) {
        this.cordova.getActivity().runOnUiThread(new Runnable() { // from class: org.apache.cordova.SplashScreenInternal.6
            @Override // java.lang.Runnable
            public void run() {
                SplashScreenInternal.this.spinnerStop();
                SplashScreenInternal.spinnerDialog = ProgressDialog.show(SplashScreenInternal.this.webView.getContext(), str, str2, true, true, new DialogInterface.OnCancelListener() { // from class: org.apache.cordova.SplashScreenInternal.6.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        SplashScreenInternal.spinnerDialog = null;
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void spinnerStop() {
        this.cordova.getActivity().runOnUiThread(new Runnable() { // from class: org.apache.cordova.SplashScreenInternal.7
            @Override // java.lang.Runnable
            public void run() {
                if (SplashScreenInternal.spinnerDialog == null || !SplashScreenInternal.spinnerDialog.isShowing()) {
                    return;
                }
                SplashScreenInternal.spinnerDialog.dismiss();
                SplashScreenInternal.spinnerDialog = null;
            }
        });
    }

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) throws JSONException {
        if (str.equals("hide")) {
            this.cordova.getActivity().runOnUiThread(new Runnable() { // from class: org.apache.cordova.SplashScreenInternal.1
                @Override // java.lang.Runnable
                public void run() {
                    SplashScreenInternal.this.webView.postMessage("splashscreen", "hide");
                }
            });
        } else if (str.equals(bq.b.V)) {
            this.cordova.getActivity().runOnUiThread(new Runnable() { // from class: org.apache.cordova.SplashScreenInternal.2
                @Override // java.lang.Runnable
                public void run() {
                    SplashScreenInternal.this.webView.postMessage("splashscreen", bq.b.V);
                }
            });
        } else {
            if (!str.equals("spinnerStart")) {
                return false;
            }
            final String string = jSONArray.getString(0);
            final String string2 = jSONArray.getString(1);
            this.cordova.getActivity().runOnUiThread(new Runnable() { // from class: org.apache.cordova.SplashScreenInternal.3
                @Override // java.lang.Runnable
                public void run() {
                    SplashScreenInternal.this.spinnerStart(string, string2);
                }
            });
        }
        callbackContext.success();
        return true;
    }

    @Override // org.apache.cordova.CordovaPlugin
    public void onDestroy() {
        removeSplashScreen();
        firstShow = true;
    }

    @Override // org.apache.cordova.CordovaPlugin
    public Object onMessage(String str, Object obj) {
        if ("splashscreen".equals(str)) {
            if ("hide".equals(obj.toString())) {
                removeSplashScreen();
                return null;
            }
            showSplashScreen(false);
            return null;
        }
        if (!"spinner".equals(str)) {
            if (!"onReceivedError".equals(str)) {
                return null;
            }
            spinnerStop();
            return null;
        }
        if (!"stop".equals(obj.toString())) {
            return null;
        }
        spinnerStop();
        this.webView.setVisibility(0);
        return null;
    }

    @Override // org.apache.cordova.CordovaPlugin
    public void onPause(boolean z) {
        removeSplashScreen();
    }

    @Override // org.apache.cordova.CordovaPlugin
    public void pluginInitialize() {
        String string;
        if (firstShow) {
            this.webView.setVisibility(4);
            if (this.preferences.getInteger("SplashDrawableId", 0) == 0 && (string = this.preferences.getString("SplashScreen", null)) != null) {
                int identifier = this.cordova.getActivity().getResources().getIdentifier(string, "drawable", this.cordova.getActivity().getClass().getPackage().getName());
                if (identifier == 0) {
                    identifier = this.cordova.getActivity().getResources().getIdentifier(string, "drawable", this.cordova.getActivity().getPackageName());
                }
                this.preferences.set("SplashDrawableId", identifier);
            }
            firstShow = false;
            loadSpinner();
            showSplashScreen(true);
        }
    }
}
