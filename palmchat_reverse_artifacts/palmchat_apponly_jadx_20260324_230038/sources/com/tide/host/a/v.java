package com.tide.host.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tide.host.a.v;
import com.tide.protocol.config.TideWholeConfig;
import com.tide.protocol.context.base.IResource;
import com.tide.protocol.host.IPluginLoader;
import com.tide.protocol.host.IPluginManager;
import com.tide.protocol.host.model.PluginEvent;
import com.tide.protocol.host.model.PluginEventType;
import com.tide.protocol.host.model.PluginState;
import com.tide.protocol.plugin.base.ITideApplication;
import com.tide.protocol.transfer.TideEventBus;
import com.tide.protocol.util.TdLogUtils;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.concurrent.ConcurrentMap;
import j$.util.function.Function$CC;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class v implements IPluginManager {
    public static volatile v d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f10802a = new ConcurrentHashMap();
    public final ConcurrentHashMap b = new ConcurrentHashMap();
    public final Context c;

    public v(Context context) {
        this.c = context.getApplicationContext();
    }

    public static /* synthetic */ Lock b(String str) {
        return new ReentrantLock();
    }

    @Override // com.tide.protocol.host.IPluginManager
    public final IPluginLoader getPluginLoader(String str) {
        return (IPluginLoader) this.f10802a.get(str);
    }

    @Override // com.tide.protocol.host.IPluginManager
    public final void initPlugin(String str) {
        Lock lockA = a(str);
        lockA.lock();
        try {
            IPluginLoader iPluginLoader = (IPluginLoader) this.f10802a.get(str);
            if (iPluginLoader == null) {
                TdLogUtils.error("PluginManager", "Plugin loader not found for: " + str);
                TideEventBus.publish(new PluginEvent(PluginEventType.RUN_FAILED, str));
                return;
            }
            if (iPluginLoader.getPluginState() == PluginState.LOADED) {
                a(iPluginLoader);
                if (iPluginLoader.getPluginState() == PluginState.RUNNING) {
                    TdLogUtils.log("PluginManager", "Plugin initialized successfully");
                    TideEventBus.publish(new PluginEvent(PluginEventType.RUN_SUCCESS, str));
                } else {
                    TdLogUtils.error("PluginManager", "Failed to initialize plugin");
                }
            } else {
                TdLogUtils.error("Plugin is cannot be initialized: cause its state is " + iPluginLoader.getPluginState());
            }
        } finally {
            lockA.unlock();
        }
    }

    @Override // com.tide.protocol.host.IPluginManager
    public final void preloadPlugin(final String str, final String str2) {
        IPluginLoader iPluginLoader;
        if (TextUtils.isEmpty(str)) {
            TideEventBus.publish(new PluginEvent(PluginEventType.LOAD_FAILED, str));
            return;
        }
        Lock lockA = a(str);
        lockA.lock();
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                iPluginLoader = (IPluginLoader) ConcurrentMap.EL.computeIfAbsent(this.f10802a, str, new Function() { // from class: wl7
                    @Override // java.util.function.Function
                    public /* synthetic */ Function andThen(Function function) {
                        return Function$CC.$default$andThen(this, function);
                    }

                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.f21747a.a(str2, str, (String) obj);
                    }

                    public /* synthetic */ Function compose(Function function) {
                        return Function$CC.$default$compose(this, function);
                    }
                });
            } else {
                synchronized (this.f10802a) {
                    IPluginLoader uVar = (IPluginLoader) this.f10802a.get(str);
                    if (uVar == null) {
                        uVar = new u(this.c, str2, str);
                        this.f10802a.put(str, uVar);
                    }
                    iPluginLoader = uVar;
                }
            }
            if (iPluginLoader.getPluginState() == PluginState.NOT_LOADED || iPluginLoader.getPluginState() == PluginState.LOAD_FAILED) {
                iPluginLoader.preLoadPlugin();
                if (iPluginLoader.getPluginState() == PluginState.LOADED) {
                    TdLogUtils.log("PluginManager", "Plugin loaded successfully.");
                    TideEventBus.publish(new PluginEvent(PluginEventType.LOAD_SUCCESS, str));
                } else {
                    TdLogUtils.error("PluginManager", "Failed to load plugin.");
                }
            } else {
                TdLogUtils.error("PluginManager", "Plugin has a state before preload " + iPluginLoader.getPluginState());
            }
        } catch (Throwable th) {
            try {
                TideEventBus.publish(new PluginEvent(PluginEventType.LOAD_FAILED, str));
                TdLogUtils.error(th.getMessage());
            } finally {
                lockA.unlock();
            }
        }
    }

    public final Lock a(String str) {
        Lock reentrantLock;
        if (Build.VERSION.SDK_INT >= 24) {
            return (Lock) ConcurrentMap.EL.computeIfAbsent(this.b, str, new Function() { // from class: xl7
                @Override // java.util.function.Function
                public /* synthetic */ Function andThen(Function function) {
                    return Function$CC.$default$andThen(this, function);
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return v.b((String) obj);
                }

                public /* synthetic */ Function compose(Function function) {
                    return Function$CC.$default$compose(this, function);
                }
            });
        }
        synchronized (this.b) {
            reentrantLock = (Lock) this.b.get(str);
            if (reentrantLock == null) {
                reentrantLock = new ReentrantLock();
                this.b.put(str, reentrantLock);
            }
        }
        return reentrantLock;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ IPluginLoader a(String str, String str2, String str3) {
        return new u(this.c, str, str2);
    }

    public final void a(IPluginLoader iPluginLoader) {
        String pluginName;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            pluginName = iPluginLoader.getPluginName();
            try {
                e0.a().onEvent("td_run_start", pluginName, new o0(pluginName, TideWholeConfig.getInstance().getPluginFrom(pluginName), null).b);
                ITideApplication iTideApplicationInitPlugin = iPluginLoader.initPlugin();
                IResource resourceManager = iPluginLoader.getResourceManager();
                if (iTideApplicationInitPlugin != null && resourceManager != null) {
                    iTideApplicationInitPlugin.onCreate(this.c, resourceManager);
                    String pluginName2 = iPluginLoader.getPluginName();
                    long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                    o0 o0Var = new o0(pluginName2, TideWholeConfig.getInstance().getPluginFrom(pluginName2), null);
                    o0Var.a("duration", Long.valueOf(jCurrentTimeMillis2));
                    o0Var.a("result", 1);
                    o0Var.a("code", -1);
                    e0.a().onEvent("td_run_result", pluginName2, o0Var.b);
                    e0.a().onEvent("td_plugin_init_result", pluginName2, new k0(pluginName2, TideWholeConfig.getInstance().getPluginFrom(pluginName2), System.currentTimeMillis() - (pluginName2 != null ? TideWholeConfig.getInstance().getPluginStartTime(pluginName2) : 0L), 1, -1).b);
                    return;
                }
                a("initializePlugin fail cause coreApp or resource is null", iPluginLoader.getPluginName(), jCurrentTimeMillis, 16001);
            } catch (Throwable th) {
                th = th;
                th.printStackTrace();
                iPluginLoader.setPluginState(PluginState.RUNNING_FAILED);
                a(th.getMessage(), pluginName, jCurrentTimeMillis, 16003);
            }
        } catch (Throwable th2) {
            th = th2;
            pluginName = "";
        }
    }

    public static void a(String str, String str2, long j, int i) {
        HashMap map;
        TideEventBus.publish(new PluginEvent(PluginEventType.RUN_FAILED, str2));
        TdLogUtils.error("reportFailure:" + str);
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        if (TextUtils.isEmpty(str)) {
            map = new HashMap();
            map.put("reason", str);
        } else {
            map = null;
        }
        o0 o0Var = new o0(str2, TideWholeConfig.getInstance().getPluginFrom(str2), map);
        o0Var.a("duration", Long.valueOf(jCurrentTimeMillis));
        o0Var.a("result", 0);
        o0Var.a("code", Integer.valueOf(i));
        e0.a().onEvent("td_run_result", str2, o0Var.b);
        e0.a().onEvent("td_plugin_init_result", str2, new k0(str2, TideWholeConfig.getInstance().getPluginFrom(str2), System.currentTimeMillis() - (str2 != null ? TideWholeConfig.getInstance().getPluginStartTime(str2) : 0L), 0, i).b);
    }
}
