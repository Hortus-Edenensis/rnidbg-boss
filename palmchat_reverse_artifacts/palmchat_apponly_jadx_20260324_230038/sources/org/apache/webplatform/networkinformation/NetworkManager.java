package org.apache.webplatform.networkinformation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.igexin.sdk.PushConsts;
import java.util.Locale;
import org.apache.cordovaNew.CallbackContext;
import org.apache.cordovaNew.CordovaInterface;
import org.apache.cordovaNew.CordovaPlugin;
import org.apache.cordovaNew.CordovaWebView;
import org.apache.cordovaNew.LOG;
import org.apache.cordovaNew.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class NetworkManager extends CordovaPlugin {
    public static final String CDMA = "cdma";
    public static final String CELLULAR = "cellular";
    public static final String EDGE = "edge";
    public static final String EHRPD = "ehrpd";
    public static final String FOUR_G = "4g";
    public static final String GPRS = "gprs";
    public static final String GSM = "gsm";
    public static final String HSDPA = "hsdpa";
    public static final String HSPA = "hspa";
    public static final String HSPA_PLUS = "hspa+";
    public static final String HSUPA = "hsupa";
    private static final String LOG_TAG = "NetworkManager";
    public static final String LTE = "lte";
    public static final String MOBILE = "mobile";
    public static int NOT_REACHABLE = 0;
    public static final String ONEXRTT = "1xrtt";
    public static int REACHABLE_VIA_CARRIER_DATA_NETWORK = 1;
    public static int REACHABLE_VIA_WIFI_NETWORK = 2;
    public static final String THREE_G = "3g";
    public static final String TWO_G = "2g";
    public static final String TYPE_2G = "2g";
    public static final String TYPE_3G = "3g";
    public static final String TYPE_4G = "4g";
    public static final String TYPE_ETHERNET = "ethernet";
    public static final String TYPE_ETHERNET_SHORT = "eth";
    public static final String TYPE_NONE = "none";
    public static final String TYPE_UNKNOWN = "unknown";
    public static final String TYPE_WIFI = "wifi";
    public static final String UMB = "umb";
    public static final String UMTS = "umts";
    public static final String WIFI = "wifi";
    public static final String WIMAX = "wimax";
    private CallbackContext connectionCallbackContext;
    private JSONObject lastInfo = null;
    BroadcastReceiver receiver;
    ConnectivityManager sockMan;

    private JSONObject getConnectionInfo(NetworkInfo networkInfo) {
        String type;
        String extraInfo;
        type = "none";
        if (networkInfo != null) {
            type = networkInfo.isConnected() ? getType(networkInfo) : "none";
            extraInfo = networkInfo.getExtraInfo();
        } else {
            extraInfo = "";
        }
        LOG.d(LOG_TAG, "Connection Type: " + type);
        LOG.d(LOG_TAG, "Connection Extra Info: " + extraInfo);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", type);
            jSONObject.put(MediationConstant.KEY_EXTRA_INFO, extraInfo);
        } catch (JSONException e) {
            LOG.d(LOG_TAG, e.getLocalizedMessage());
        }
        return jSONObject;
    }

    private String getType(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return "none";
        }
        String typeName = networkInfo.getTypeName();
        Locale locale = Locale.US;
        String lowerCase = typeName.toLowerCase(locale);
        LOG.d(LOG_TAG, "toLower : " + lowerCase.toLowerCase());
        LOG.d(LOG_TAG, "wifi : wifi");
        if (lowerCase.equals("wifi")) {
            return "wifi";
        }
        if (lowerCase.toLowerCase().equals(TYPE_ETHERNET) || lowerCase.toLowerCase().startsWith(TYPE_ETHERNET_SHORT)) {
            return TYPE_ETHERNET;
        }
        if (!lowerCase.equals("mobile") && !lowerCase.equals(CELLULAR)) {
            return "unknown";
        }
        String lowerCase2 = networkInfo.getSubtypeName().toLowerCase(locale);
        String str = "2g";
        if (!lowerCase2.equals(GSM) && !lowerCase2.equals(GPRS) && !lowerCase2.equals(EDGE) && !lowerCase2.equals("2g")) {
            str = "3g";
            if (!lowerCase2.startsWith(CDMA) && !lowerCase2.equals(UMTS) && !lowerCase2.equals(ONEXRTT) && !lowerCase2.equals(EHRPD) && !lowerCase2.equals(HSUPA) && !lowerCase2.equals(HSDPA) && !lowerCase2.equals(HSPA) && !lowerCase2.equals("3g")) {
                str = "4g";
                if (!lowerCase2.equals(LTE) && !lowerCase2.equals(UMB) && !lowerCase2.equals(HSPA_PLUS) && !lowerCase2.equals("4g")) {
                    return "unknown";
                }
            }
        }
        return str;
    }

    private void sendUpdate(String str) {
        if (this.connectionCallbackContext != null) {
            PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, str);
            pluginResult.setKeepCallback(true);
            this.connectionCallbackContext.sendPluginResult(pluginResult);
        }
        this.webView.postMessage("networkconnection", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateConnectionInfo(NetworkInfo networkInfo) {
        String string;
        JSONObject connectionInfo = getConnectionInfo(networkInfo);
        if (connectionInfo.equals(this.lastInfo)) {
            return;
        }
        try {
            string = connectionInfo.get("type").toString();
        } catch (JSONException e) {
            LOG.d(LOG_TAG, e.getLocalizedMessage());
            string = "";
        }
        sendUpdate(string);
        this.lastInfo = connectionInfo;
    }

    @Override // org.apache.cordovaNew.CordovaPlugin
    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) {
        String string;
        if (!str.equals("getConnectionInfo")) {
            return false;
        }
        this.connectionCallbackContext = callbackContext;
        try {
            string = getConnectionInfo(this.sockMan.getActiveNetworkInfo()).get("type").toString();
        } catch (JSONException e) {
            LOG.d(LOG_TAG, e.getLocalizedMessage());
            string = "";
        }
        PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, string);
        pluginResult.setKeepCallback(true);
        callbackContext.sendPluginResult(pluginResult);
        return true;
    }

    @Override // org.apache.cordovaNew.CordovaPlugin
    public void initialize(CordovaInterface cordovaInterface, CordovaWebView cordovaWebView) {
        super.initialize(cordovaInterface, cordovaWebView);
        this.sockMan = (ConnectivityManager) cordovaInterface.getActivity().getSystemService("connectivity");
        this.connectionCallbackContext = null;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
        if (this.receiver == null) {
            this.receiver = new BroadcastReceiver() { // from class: org.apache.webplatform.networkinformation.NetworkManager.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    NetworkManager networkManager = NetworkManager.this;
                    if (networkManager.webView != null) {
                        networkManager.updateConnectionInfo(networkManager.sockMan.getActiveNetworkInfo());
                    }
                }
            };
            cordovaWebView.getContext().registerReceiver(this.receiver, intentFilter);
        }
    }

    @Override // org.apache.cordovaNew.CordovaPlugin
    public void onDestroy() {
        if (this.receiver != null) {
            try {
                try {
                    this.webView.getContext().unregisterReceiver(this.receiver);
                } catch (Exception e) {
                    LOG.e(LOG_TAG, "Error unregistering network receiver: " + e.getMessage(), e);
                }
            } finally {
                this.receiver = null;
            }
        }
    }
}
