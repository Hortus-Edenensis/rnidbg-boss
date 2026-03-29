package org.apache.cordova.jssdk;

import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.utils.log.LogUtil;
import dalvik.system.DexFile;
import defpackage.ba3;
import defpackage.ib3;
import defpackage.v93;
import defpackage.ve;
import defpackage.wl2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import org.apache.cordova.PluginResult;
import org.apache.cordova.jssdk.general.Action;
import org.apache.cordova.jssdk.general.ContactPlugin;
import org.apache.cordova.jssdk.general.PayPlugin;
import org.apache.cordova.jssdk.general.PlatformInfoPlugin;
import org.apache.cordova.jssdk.general.SquarePlugin;
import org.apache.cordova.jssdk.general.StoragePlugin;
import org.apache.cordova.jssdk.general.UtilPlugin;
import org.apache.cordova.jssdk.general.VipPlugin;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class GeneralPluginImpl extends wl2 {
    public static List<Class<? extends ib3>> getTargetPluginClass() {
        try {
            Enumeration<String> enumerationEntries = new DexFile(AppContext.getContext().getPackageResourcePath()).entries();
            while (enumerationEntries.hasMoreElements()) {
                enumerationEntries.nextElement();
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // defpackage.wl2
    public void executeAction(String str, String str2, v93 v93Var) {
        LogUtil.d("GeneralPluginImpl", "action:" + str + " args:" + str2);
        if (Action.ACTION_IS_API_SUPPORT.equals(str)) {
            try {
                int i = findExecPlugin(new JSONObject(str2).getString("checkActionName")) != null ? 1 : 0;
                JSONObject jSONObjectMakeNormalJsResult = CordovaUtils.makeNormalJsResult(PluginResult.Status.OK);
                jSONObjectMakeNormalJsResult.put("actionState", i);
                v93Var.a(jSONObjectMakeNormalJsResult);
                return;
            } catch (Exception unused) {
                v93Var.a(CordovaUtils.makeNormalJsResult(PluginResult.Status.JSON_EXCEPTION));
                return;
            }
        }
        ib3 ib3VarFindExecPlugin = findExecPlugin(str);
        if (ib3VarFindExecPlugin == null) {
            v93Var.a(CordovaUtils.makeNormalJsResult(PluginResult.Status.INVALID_ACTION));
            return;
        }
        try {
            ib3VarFindExecPlugin.exec(str, new JSONObject(str2), v93Var);
        } catch (JSONException e) {
            e.printStackTrace();
            v93Var.a(CordovaUtils.makeNormalJsResult(PluginResult.Status.JSON_EXCEPTION));
        }
    }

    @Override // defpackage.wl2
    public void initialize(ba3 ba3Var) {
        this.mCordovaInterface = ba3Var;
        registerSubPlugin();
    }

    @Override // defpackage.wl2
    public void registerSubPlugin() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(UtilPlugin.class);
        arrayList.add(PlatformInfoPlugin.class);
        arrayList.add(StoragePlugin.class);
        arrayList.add(org.apache.cordova.jssdk.general.LocationPlugin.class);
        arrayList.add(PayPlugin.class);
        arrayList.add(org.apache.cordova.jssdk.general.LocalApiPlugin.class);
        arrayList.add(SquarePlugin.class);
        arrayList.add(VipPlugin.class);
        arrayList.add(ContactPlugin.class);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                ib3 ib3Var = (ib3) ((Class) it.next()).newInstance();
                ib3Var.initialize(this.mCordovaInterface);
                this.mPlugins.add(ib3Var);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // defpackage.wl2
    public boolean routerToTargetPage(String str) {
        return ve.s(getCordovaInterface().getActivity(), str, false);
    }

    @Override // defpackage.wl2
    public void onDestroy() {
    }
}
