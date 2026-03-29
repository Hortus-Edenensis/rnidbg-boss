package com.tide.host.a;

import android.content.Context;
import com.tide.protocol.config.ITideHostConfig;
import com.tide.protocol.config.TideWholeConfig;
import com.tide.protocol.context.ITideActivity;
import com.tide.protocol.context.ITideService;
import com.tide.protocol.host.IHostApp;
import com.tide.protocol.host.IPluginLoader;
import com.tide.protocol.host.IPluginManager;
import com.tide.protocol.host.model.PluginEvent;
import com.tide.protocol.host.model.PluginEventType;
import com.tide.protocol.plugin.ITideComponentFactory;
import com.tide.protocol.plugin.base.ITideApplication;
import com.tide.protocol.transfer.TideEventBus;
import com.tide.protocol.util.TdLogUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class t0 implements IHostApp {
    public static Context b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public v f10799a;

    @Override // com.tide.protocol.host.IHostApp
    public final IPluginManager getPluginManager() {
        return this.f10799a;
    }

    @Override // com.tide.protocol.host.IHostApp
    public final String getProxyActivityClass(String str, String str2) {
        v vVar = this.f10799a;
        if (vVar == null) {
            TdLogUtils.error("pluginManager is null");
            return "";
        }
        IPluginLoader pluginLoader = vVar.getPluginLoader(str);
        return (pluginLoader == null || pluginLoader.getCoreApp() == null) ? "" : pluginLoader.getCoreApp().getProxyActivityClassName(str2);
    }

    @Override // com.tide.protocol.host.IHostApp
    public final String getProxyServiceClass(String str, String str2) {
        v vVar = this.f10799a;
        if (vVar == null) {
            TdLogUtils.error("pluginManager is null");
            return "";
        }
        IPluginLoader pluginLoader = vVar.getPluginLoader(str);
        return (pluginLoader == null || pluginLoader.getCoreApp() == null) ? "" : pluginLoader.getCoreApp().getProxyServiceClassName(str2);
    }

    @Override // com.tide.protocol.host.IHostApp
    public final void initPlugin(String str) {
        v vVar = this.f10799a;
        if (vVar != null) {
            vVar.initPlugin(str);
        } else {
            TideEventBus.publish(new PluginEvent(PluginEventType.RUN_FAILED, str));
            TdLogUtils.error("TideHostApp", "plugin can not init,pluginManager is null,You need preload before init");
        }
    }

    @Override // com.tide.protocol.host.IHostApp
    public final void installToRunPlugin(Context context, String str, String str2) {
        preload(context, str, str2);
        initPlugin(str);
    }

    @Override // com.tide.protocol.host.IHostApp
    public final ITideActivity loadPluginActivity(Context context, String str, String str2) {
        v vVar = this.f10799a;
        if (vVar == null) {
            TdLogUtils.error("TideHostApp", "pluginManager is null");
            return null;
        }
        IPluginLoader pluginLoader = vVar.getPluginLoader(str);
        if (pluginLoader == null) {
            TdLogUtils.error("TideHostApp", "pluginLoader is null");
            return null;
        }
        ITideApplication coreApp = pluginLoader.getCoreApp();
        if (coreApp == null) {
            TdLogUtils.error("TideHostApp", "coreApp is null");
            return null;
        }
        ITideComponentFactory componentFactory = coreApp.getComponentFactory();
        if (componentFactory == null) {
            TdLogUtils.error("TideHostApp", "ITideComponentFactory is null");
            return null;
        }
        try {
            return componentFactory.instantiateActivity(str2);
        } catch (Throwable th) {
            TdLogUtils.error("TideHostApp", "loadPluginActivity: " + th.getMessage());
            return null;
        }
    }

    @Override // com.tide.protocol.host.IHostApp
    public final ITideService loadPluginService(Context context, String str, String str2) {
        v vVar = this.f10799a;
        if (vVar == null) {
            TdLogUtils.error("TideHostApp", "pluginManager is null");
            return null;
        }
        IPluginLoader pluginLoader = vVar.getPluginLoader(str);
        if (pluginLoader == null) {
            TdLogUtils.error("TideHostApp", "pluginLoader is null");
            return null;
        }
        ITideApplication coreApp = pluginLoader.getCoreApp();
        if (coreApp == null) {
            TdLogUtils.error("TideHostApp", "coreApp is null");
            return null;
        }
        ITideComponentFactory componentFactory = coreApp.getComponentFactory();
        if (componentFactory == null) {
            TdLogUtils.error("TideHostApp", "ITideComponentFactory is null");
            return null;
        }
        try {
            return componentFactory.instantiateService(str2);
        } catch (Throwable th) {
            TdLogUtils.error("TideHostApp", "loadPluginService: " + th.getMessage());
            return null;
        }
    }

    @Override // com.tide.protocol.host.IHostApp
    public final void preload(Context context, String str, String str2) {
        TideEventBus.publish(new PluginEvent(PluginEventType.LOAD_START, str));
        if (context == null && b == null) {
            TdLogUtils.error("TideHostApp", "preload error cause context is null");
            TideEventBus.publish(new PluginEvent(PluginEventType.LOAD_FAILED, str));
            return;
        }
        if (b == null && context != null) {
            b = context.getApplicationContext();
        }
        if (this.f10799a == null) {
            Context context2 = b;
            if (v.d == null) {
                synchronized (v.class) {
                    if (v.d == null) {
                        v.d = new v(context2);
                    }
                }
            }
            this.f10799a = v.d;
        }
        this.f10799a.preloadPlugin(str, str2);
    }

    @Override // com.tide.protocol.host.IHostApp
    public final void setHostConfig(ITideHostConfig iTideHostConfig) {
        if (iTideHostConfig != null) {
            TideWholeConfig.getInstance().setTideHostConfig(iTideHostConfig);
        }
    }
}
