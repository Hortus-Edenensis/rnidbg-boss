package com.tide.protocol.managers;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.text.TextUtils;
import com.tide.protocol.bridge.TideProtocolBridge;
import com.tide.protocol.host.IHostApp;
import com.tide.protocol.util.TdLogUtils;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ComponentManager {
    public static final String COMPONENT_CLASS_PATH = "COMPONENT_CLASS_PATH";
    public static final String PLUGIN_NAME = "PLUGIN_NAME";
    private static final String TAG = "ComponentManager";
    private IHostApp hostApp = (IHostApp) TideProtocolBridge.getService(IHostApp.class);
    private static final ComponentManager sInstance = new ComponentManager();
    private static final List<ComponentOccupier> COMPONENT_OCCUPIERS = new CopyOnWriteArrayList();

    /* JADX INFO: compiled from: SearchBox */
    public static class ComponentOccupier {
        public String hostClassName;
        public String pluginClassName;
        public String pluginName;
    }

    private ComponentManager() {
    }

    private Intent createProxyIntent(Context context, Class<?> cls, String str, String str2, Intent intent) {
        if (intent != null) {
            intent.setComponent(new ComponentName(context, cls));
        } else {
            intent = new Intent(context, cls);
        }
        intent.putExtra(PLUGIN_NAME, str);
        intent.putExtra(COMPONENT_CLASS_PATH, str2);
        return intent;
    }

    private Intent createProxyServiceIntent(Context context, Intent intent) {
        if (this.hostApp == null) {
            this.hostApp = (IHostApp) TideProtocolBridge.getService(IHostApp.class);
        }
        String str = TAG;
        TdLogUtils.log(str, "hostApp:" + this.hostApp);
        if (this.hostApp != null && intent != null) {
            String stringExtra = intent.getStringExtra(PLUGIN_NAME);
            String stringExtra2 = intent.getStringExtra(COMPONENT_CLASS_PATH);
            if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
                TdLogUtils.error(str, "Missing plugin name or component class path in Intent.");
            } else {
                String proxyServiceClass = this.hostApp.getProxyServiceClass(stringExtra, stringExtra2);
                TdLogUtils.log(str, "pluginServiceName:" + stringExtra2 + " proxyServiceName:" + proxyServiceClass);
                try {
                    Class<?> cls = Class.forName(proxyServiceClass);
                    TdLogUtils.log(str, "proxyServiceClz:" + cls);
                    intent.setComponent(new ComponentName(context, cls));
                    return intent;
                } catch (Throwable th) {
                    TdLogUtils.error(TAG, "startServiceWithPlugin error " + th.getMessage());
                }
            }
        }
        return null;
    }

    public static ComponentManager getInstance() {
        return sInstance;
    }

    public void addComponentOccupier(String str, String str2, String str3) {
        try {
            List<ComponentOccupier> list = COMPONENT_OCCUPIERS;
            if (list != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                ComponentOccupier componentOccupier = new ComponentOccupier();
                componentOccupier.pluginName = str;
                componentOccupier.hostClassName = str2;
                componentOccupier.pluginClassName = str3;
                list.add(componentOccupier);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean bindServiceWithPlugin(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        Intent intentCreateProxyServiceIntent = createProxyServiceIntent(context, intent);
        if (intentCreateProxyServiceIntent == null || context == null) {
            return false;
        }
        return context.bindService(intentCreateProxyServiceIntent, serviceConnection, i);
    }

    public ComponentOccupier getComponentOccupier(String str) {
        List<ComponentOccupier> list;
        if (!TextUtils.isEmpty(str) && (list = COMPONENT_OCCUPIERS) != null && !list.isEmpty()) {
            for (ComponentOccupier componentOccupier : list) {
                if (componentOccupier != null && TextUtils.equals(str, componentOccupier.hostClassName)) {
                    return componentOccupier;
                }
            }
        }
        return null;
    }

    public void startActivityFromOut(Context context, String str, String str2) {
        if (this.hostApp == null) {
            this.hostApp = (IHostApp) TideProtocolBridge.getService(IHostApp.class);
        }
        IHostApp iHostApp = this.hostApp;
        if (iHostApp != null) {
            try {
                context.startActivity(createProxyIntent(context, Class.forName(iHostApp.getProxyActivityClass(str, str2)), str, str2, null));
            } catch (Throwable th) {
                TdLogUtils.error(TAG, "ClassNotFoundException " + th.getMessage());
            }
        }
    }

    public void startActivityWithPlugin(Context context, Intent intent) {
        if (this.hostApp == null) {
            this.hostApp = (IHostApp) TideProtocolBridge.getService(IHostApp.class);
        }
        if (this.hostApp == null || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(PLUGIN_NAME);
        String stringExtra2 = intent.getStringExtra(COMPONENT_CLASS_PATH);
        if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
            TdLogUtils.error(TAG, "Missing plugin name or component class path in Intent.");
            return;
        }
        try {
            Intent intentCreateProxyIntent = createProxyIntent(context, Class.forName(this.hostApp.getProxyActivityClass(stringExtra, stringExtra2)), stringExtra, stringExtra2, intent);
            if (!(context instanceof Activity)) {
                intentCreateProxyIntent.addFlags(268435456);
            }
            context.startActivity(intentCreateProxyIntent);
        } catch (ClassNotFoundException e) {
            TdLogUtils.error(TAG, "ClassNotFoundException " + e.getMessage());
        }
    }

    public void startServiceWithPlugin(Context context, Intent intent) {
        Intent intentCreateProxyServiceIntent = createProxyServiceIntent(context, intent);
        if (intentCreateProxyServiceIntent == null || context == null) {
            return;
        }
        context.startService(intentCreateProxyServiceIntent);
    }
}
