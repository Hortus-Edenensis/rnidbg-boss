package org.apache.cordova;

import android.util.Log;
import java.security.SecureRandom;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class CordovaBridge {
    private static final String LOG_TAG = "CordovaBridge";
    private String appContentUrlPrefix;
    private volatile int expectedBridgeSecret = -1;
    private NativeToJsMessageQueue jsMessageQueue;
    private String loadedUrl;
    private PluginManager pluginManager;

    public CordovaBridge(PluginManager pluginManager, NativeToJsMessageQueue nativeToJsMessageQueue, String str) {
        this.pluginManager = pluginManager;
        this.jsMessageQueue = nativeToJsMessageQueue;
        this.appContentUrlPrefix = "content://" + str + ".";
    }

    private boolean verifySecret(String str, int i) throws IllegalAccessException {
        if (this.jsMessageQueue.isBridgeEnabled()) {
            if (this.expectedBridgeSecret >= 0 && i == this.expectedBridgeSecret) {
                return true;
            }
            Log.e(LOG_TAG, "Bridge access attempt with wrong secret token, possibly from malicious code. Disabling exec() bridge!");
            clearBridgeSecret();
            throw new IllegalAccessException();
        }
        if (i == -1) {
            Log.d(LOG_TAG, str + " call made before bridge was enabled.");
            return false;
        }
        Log.d(LOG_TAG, "Ignoring " + str + " from previous page load.");
        return false;
    }

    public void clearBridgeSecret() {
        this.expectedBridgeSecret = -1;
    }

    public int generateBridgeSecret() {
        this.expectedBridgeSecret = new SecureRandom().nextInt(Integer.MAX_VALUE);
        return this.expectedBridgeSecret;
    }

    public NativeToJsMessageQueue getMessageQueue() {
        return this.jsMessageQueue;
    }

    public String jsExec(int i, String str, String str2, String str3, String str4) throws JSONException, IllegalAccessException {
        String strPopAndEncode;
        if (!verifySecret("exec()", i)) {
            return null;
        }
        if (str4 == null) {
            return "@Null arguments.";
        }
        this.jsMessageQueue.setPaused(true);
        try {
            CordovaResourceApi.jsThread = Thread.currentThread();
            this.pluginManager.exec(str, str2, str3, str4);
            strPopAndEncode = this.jsMessageQueue.popAndEncode(false);
        } finally {
            try {
            } finally {
            }
        }
        return strPopAndEncode;
    }

    public String jsRetrieveJsMessages(int i, boolean z) throws IllegalAccessException {
        if (verifySecret("retrieveJsMessages()", i)) {
            return this.jsMessageQueue.popAndEncode(z);
        }
        return null;
    }

    public void jsSetNativeToJsBridgeMode(int i, int i2) throws IllegalAccessException {
        if (verifySecret("setNativeToJsBridgeMode()", i)) {
            this.jsMessageQueue.setBridgeMode(i2);
        }
    }

    public String promptOnJsPrompt(String str, String str2, String str3) {
        if (str3 != null && str3.length() > 3 && str3.startsWith("gap:")) {
            try {
                JSONArray jSONArray = new JSONArray(str3.substring(4));
                String strJsExec = jsExec(jSONArray.getInt(0), jSONArray.getString(1), jSONArray.getString(2), jSONArray.getString(3), str2);
                return strJsExec == null ? "" : strJsExec;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return "";
            } catch (JSONException e2) {
                e2.printStackTrace();
                return "";
            }
        }
        if (str3 != null && str3.startsWith("gap_bridge_mode:")) {
            try {
                jsSetNativeToJsBridgeMode(Integer.parseInt(str3.substring(16)), Integer.parseInt(str2));
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            } catch (NumberFormatException e4) {
                e4.printStackTrace();
            }
            return "";
        }
        if (str3 != null && str3.startsWith("gap_poll:")) {
            try {
                String strJsRetrieveJsMessages = jsRetrieveJsMessages(Integer.parseInt(str3.substring(9)), "1".equals(str2));
                return strJsRetrieveJsMessages == null ? "" : strJsRetrieveJsMessages;
            } catch (IllegalAccessException e5) {
                e5.printStackTrace();
                return "";
            }
        }
        if (str3 == null || !str3.startsWith("gap_init:")) {
            return null;
        }
        if (!str.startsWith("file:") && !str.startsWith(this.appContentUrlPrefix) && (!str.startsWith(HttpHost.DEFAULT_SCHEME_NAME) || !this.loadedUrl.startsWith(str))) {
            Log.e(LOG_TAG, "gap_init called from restricted origin: " + str);
            return "";
        }
        this.jsMessageQueue.setBridgeMode(Integer.parseInt(str3.substring(9)));
        return "" + generateBridgeSecret();
    }

    public void reset(String str) {
        this.jsMessageQueue.reset();
        clearBridgeSecret();
        this.loadedUrl = str;
    }
}
