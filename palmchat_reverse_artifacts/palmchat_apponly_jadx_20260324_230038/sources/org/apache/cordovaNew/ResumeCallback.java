package org.apache.cordovaNew;

import com.huawei.openalliance.ad.constant.az;
import java.util.ArrayList;
import org.apache.cordovaNew.PluginResult;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class ResumeCallback extends CallbackContext {
    private final String TAG;
    private PluginManager pluginManager;
    private String serviceName;

    public ResumeCallback(String str, PluginManager pluginManager) {
        super("resumecallback", null);
        this.TAG = "CordovaResumeCallback";
        this.serviceName = str;
        this.pluginManager = pluginManager;
    }

    @Override // org.apache.cordovaNew.CallbackContext
    public void sendPluginResult(PluginResult pluginResult) {
        synchronized (this) {
            if (this.finished) {
                LOG.w("CordovaResumeCallback", this.serviceName + " attempted to send a second callback to ResumeCallback\nResult was: " + pluginResult.getMessage());
                return;
            }
            this.finished = true;
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("pluginServiceName", this.serviceName);
                jSONObject2.put("pluginStatus", PluginResult.StatusMessages[pluginResult.getStatus()]);
                jSONObject.put("action", az.ag);
                jSONObject.put("pendingResult", jSONObject2);
            } catch (JSONException unused) {
                LOG.e("CordovaResumeCallback", "Unable to create resume object for Activity Result");
            }
            PluginResult.Status status = PluginResult.Status.OK;
            PluginResult pluginResult2 = new PluginResult(status, jSONObject);
            ArrayList arrayList = new ArrayList();
            arrayList.add(pluginResult2);
            arrayList.add(pluginResult);
            ((CoreAndroid) this.pluginManager.getPlugin(CoreAndroid.PLUGIN_NAME)).sendResumeEvent(new PluginResult(status, arrayList));
        }
    }
}
