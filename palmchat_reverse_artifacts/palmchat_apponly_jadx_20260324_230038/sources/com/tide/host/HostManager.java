package com.tide.host;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.oplus.tblplayer.misc.MediaInfo;
import com.tide.host.a.g;
import com.tide.host.a.j0;
import com.tide.host.a.o;
import com.tide.host.a.p;
import com.tide.host.a.p0;
import com.tide.host.a.q;
import com.tide.host.a.q0;
import com.tide.host.a.t0;
import com.tide.host.a.u0;
import com.tide.host.a.v0;
import com.tide.protocol.bridge.TideProtocolBridge;
import com.tide.protocol.config.ITideHostConfig;
import com.tide.protocol.config.TideWholeConfig;
import com.tide.protocol.context.ITideActivity;
import com.tide.protocol.context.ITideService;
import com.tide.protocol.host.IHostApp;
import com.tide.protocol.host.IPluginLoader;
import com.tide.protocol.host.base.IHostBase;
import com.tide.protocol.host.model.PluginEvent;
import com.tide.protocol.host.model.PluginEventType;
import com.tide.protocol.host.model.PluginInfo;
import com.tide.protocol.host.model.PluginState;
import com.tide.protocol.managers.ComponentManager;
import com.tide.protocol.transfer.TideEventBus;
import com.tide.protocol.util.TdLogUtils;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class HostManager implements IHostBase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IHostApp f10781a;

    public HostManager(t0 t0Var) {
        this.f10781a = t0Var;
        TideProtocolBridge.putService(IHostApp.class, t0Var);
    }

    public static HostManager getInstance() {
        return p.f10797a;
    }

    @Override // com.tide.protocol.host.base.IHostBase
    public PluginState getPluginStatus(String str) {
        IHostApp iHostApp = this.f10781a;
        if (iHostApp == null || iHostApp.getPluginManager() == null) {
            return PluginState.NOT_LOADED;
        }
        IPluginLoader pluginLoader = this.f10781a.getPluginManager().getPluginLoader(str);
        return pluginLoader == null ? PluginState.NOT_LOADED : pluginLoader.getPluginState();
    }

    @Override // com.tide.protocol.host.base.IHostBase
    public void initPlugin(String str) {
        IHostApp iHostApp = this.f10781a;
        if (iHostApp == null) {
            TideEventBus.publish(new PluginEvent(PluginEventType.RUN_FAILED, str));
        } else {
            iHostApp.initPlugin(str);
        }
    }

    @Override // com.tide.protocol.host.base.IHostBase
    public void installToRunPlugin(final Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            TdLogUtils.error("HostManager", context == null ? "context is null" : "pluginName is null");
        } else {
            a(str, new q() { // from class: xi2
                @Override // com.tide.host.a.q
                public final void a(PluginInfo pluginInfo) {
                    this.f21967a.a(context, pluginInfo);
                }
            }, context);
        }
    }

    @Override // com.tide.protocol.host.base.IHostBase
    public ITideActivity loadPluginActivity(Context context, String str, String str2) {
        IHostApp iHostApp = this.f10781a;
        if (iHostApp != null) {
            return iHostApp.loadPluginActivity(context, str, str2);
        }
        TdLogUtils.error("HostManager", "tideHostApp is null,cannot load Activity");
        return null;
    }

    @Override // com.tide.protocol.host.base.IHostBase
    public ITideService loadPluginService(Context context, String str) {
        if (this.f10781a == null) {
            TdLogUtils.error("HostManager", "tideHostApp is null,cannot load Activity");
            return null;
        }
        ComponentManager.ComponentOccupier componentOccupier = ComponentManager.getInstance().getComponentOccupier(str);
        if (componentOccupier == null) {
            return null;
        }
        return this.f10781a.loadPluginService(context, componentOccupier.pluginName, componentOccupier.pluginClassName);
    }

    @Override // com.tide.protocol.host.base.IHostBase
    public void preload(final Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            String str2 = context == null ? "context is null" : "pluginName is null";
            TdLogUtils.error("HostManager", str2);
            throw new NullPointerException(str2);
        }
        if (t0.b == null) {
            t0.b = context.getApplicationContext();
        }
        a(str, new q() { // from class: vi2
            @Override // com.tide.host.a.q
            public final void a(PluginInfo pluginInfo) {
                this.f21450a.b(context, pluginInfo);
            }
        }, t0.b);
    }

    @Override // com.tide.protocol.host.base.IHostBase
    public void setHostConfig(ITideHostConfig iTideHostConfig) {
        IHostApp iHostApp = this.f10781a;
        if (iHostApp == null) {
            TdLogUtils.error("HostManager", "tideHostApp is null");
        } else {
            iHostApp.setHostConfig(iTideHostConfig);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Context context, PluginInfo pluginInfo) {
        this.f10781a.installToRunPlugin(context, pluginInfo.getPluginName(), pluginInfo.getPluginPath());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Context context, PluginInfo pluginInfo) {
        this.f10781a.preload(context, pluginInfo.getPluginName(), pluginInfo.getPluginPath());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0066 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(String str, q qVar, Context context) {
        String str2;
        int i;
        PluginInfo pluginInfoA;
        try {
            str2 = t0.b.getPackageManager().getPackageInfo(t0.b.getPackageName(), 0).versionName;
        } catch (Throwable unused) {
            str2 = MediaInfo.RENDERER_TYPE_UNKNOWN;
        }
        try {
            i = t0.b.getPackageManager().getPackageInfo(t0.b.getPackageName(), 0).versionCode;
        } catch (Throwable unused2) {
            i = -1;
        }
        String packageName = t0.b.getPackageName();
        String str3 = Build.BRAND;
        new TideWholeConfig.Builder().appVersion(str2).appVersionCode(i).packageName(packageName).vendor(str3).osVersion(g.a()).build();
        o oVar = new o(this, str, qVar);
        j0 j0VarA = j0.a();
        synchronized (j0VarA) {
            pluginInfoA = null;
            if (context != null) {
                if (!TextUtils.isEmpty(str)) {
                    PluginInfo pluginInfoA2 = j0VarA.a(str);
                    if (pluginInfoA2 == null) {
                        String string = "";
                        if (!p0.a(context, "plugin_info")) {
                            string = context.getSharedPreferences(str, 0).getString("plugin_info", "");
                        }
                        if (!TextUtils.isEmpty(string)) {
                            pluginInfoA = q0.a(string);
                        }
                    } else {
                        pluginInfoA = pluginInfoA2;
                    }
                    j0VarA.a(pluginInfoA);
                }
            }
        }
        j0.a().a(context, str, pluginInfoA, oVar);
    }

    public final void a(final String str, final q qVar, final Context context) {
        Runnable runnable = new Runnable() { // from class: wi2
            @Override // java.lang.Runnable
            public final void run() {
                this.f21720a.b(str, qVar, context);
            }
        };
        AtomicInteger atomicInteger = v0.b;
        u0.f10801a.f10803a.execute(runnable);
    }
}
