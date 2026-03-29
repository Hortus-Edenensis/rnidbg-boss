package com.bytedance.pangle.service.u;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.n;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.pn;
import com.bytedance.sdk.openadsdk.api.iz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends pn.u {
    private static volatile u nr;
    private final HashMap<ComponentName, IBinder> fx = new HashMap<>();
    private final HashMap<ComponentName, nr> b = new HashMap<>();
    private final C0200u<Intent> pn = new C0200u<>();
    private final HashMap<ComponentName, com.bytedance.pangle.service.u> iz = new HashMap<>();
    private final HashSet<ComponentName> x = new HashSet<>();
    private final HashSet<ComponentName> n = new HashSet<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<Runnable> f5071a = new ArrayList();
    private final Handler u = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: SearchBox */
    public class nr extends HashSet<n> {
        public nr() {
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@Nullable Object obj) {
            if (super.contains(obj)) {
                return true;
            }
            if (!(obj instanceof n)) {
                return false;
            }
            Iterator<n> it = iterator();
            while (it.hasNext()) {
                try {
                } catch (RemoteException e) {
                    iz.u(e);
                }
                if (it.next().u() == ((n) obj).u()) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@Nullable Object obj) {
            n nVar;
            if (super.remove(obj)) {
                return true;
            }
            Iterator it = iterator();
            while (true) {
                if (!it.hasNext()) {
                    nVar = null;
                    break;
                }
                nVar = (n) it.next();
                try {
                } catch (RemoteException e) {
                    iz.u(e);
                }
                if (nVar.u() == ((n) obj).u()) {
                    break;
                }
            }
            return super.remove(nVar);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.pangle.service.u.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C0200u<T> extends HashMap<n, T> {
        public C0200u() {
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public boolean containsKey(@Nullable Object obj) {
            if (super.containsKey(obj)) {
                return true;
            }
            if (!(obj instanceof n)) {
                return false;
            }
            Iterator<n> it = keySet().iterator();
            while (it.hasNext()) {
                try {
                } catch (RemoteException e) {
                    iz.u(e);
                }
                if (it.next().u() == ((n) obj).u()) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        @Nullable
        public T remove(@Nullable Object obj) {
            n next;
            T t = (T) super.remove(obj);
            if (t != null) {
                return t;
            }
            Iterator<n> it = keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                try {
                } catch (RemoteException e) {
                    iz.u(e);
                }
                if (next.u() == ((n) obj).u()) {
                    break;
                }
            }
            return (T) super.remove(next);
        }
    }

    private u() {
    }

    private com.bytedance.pangle.service.u b(Intent intent, String str) {
        boolean zLoadPlugin;
        ComponentName component = intent.getComponent();
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        try {
            zLoadPlugin = Zeus.loadPlugin(str);
        } catch (Exception e) {
            e = e;
            zLoadPlugin = false;
        }
        try {
            com.bytedance.pangle.service.u uVar = (com.bytedance.pangle.service.u) plugin.mClassLoader.loadClass(component.getClassName()).newInstance();
            uVar.attach(plugin);
            return uVar;
        } catch (Exception e2) {
            e = e2;
            ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "newServiceInstance failed! loadPlugin = ".concat(String.valueOf(zLoadPlugin)), e);
            return null;
        }
    }

    @Override // com.bytedance.pangle.pn.u, android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    @Override // com.bytedance.pangle.pn
    public boolean bindService(final Intent intent, final n nVar, final int i, final String str) throws RemoteException {
        if (!Zeus.hasInit()) {
            this.f5071a.add(new Runnable() { // from class: com.bytedance.pangle.service.u.u.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        u.this.nr(intent, nVar, i, str);
                    } catch (RemoteException e) {
                        ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "pending bindService failed", e);
                    }
                }
            });
            return true;
        }
        Plugin plugin = Zeus.getPlugin(str);
        if (plugin.isLoaded()) {
            return u(intent, nVar, i, str);
        }
        if (Zeus.loadPlugin(str)) {
            u(intent, nVar, i, str);
            return true;
        }
        plugin.addBindServicePluginPendingTask(new Plugin.u() { // from class: com.bytedance.pangle.service.u.u.6
            @Override // com.bytedance.pangle.plugin.Plugin.u
            public void u(int i2) throws RemoteException {
                u.this.u(intent, nVar, i, str);
            }
        });
        return true;
    }

    public void fx() {
        for (Runnable runnable : this.f5071a) {
            if (runnable != null) {
                this.u.post(runnable);
            }
        }
        this.f5071a.clear();
    }

    @Override // com.bytedance.pangle.pn
    public ComponentName startService(final Intent intent, final String str) {
        if (Zeus.hasInit()) {
            Plugin plugin = Zeus.getPlugin(str);
            if (plugin.isLoaded()) {
                return u(intent, str);
            }
            plugin.addStartServicePluginPendingTask(new Plugin.u() { // from class: com.bytedance.pangle.service.u.u.2
                @Override // com.bytedance.pangle.plugin.Plugin.u
                public void u(int i) throws RemoteException {
                    u.this.u(intent, str);
                }
            });
        } else {
            this.f5071a.add(new Runnable() { // from class: com.bytedance.pangle.service.u.u.3
                @Override // java.lang.Runnable
                public void run() {
                    u.this.nr(intent, str);
                }
            });
        }
        return intent.getComponent();
    }

    @Override // com.bytedance.pangle.pn
    public boolean stopService(final Intent intent, String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            nr().u(intent.getComponent());
            return true;
        }
        this.u.post(new Runnable() { // from class: com.bytedance.pangle.service.u.u.4
            @Override // java.lang.Runnable
            public void run() {
                u.nr().u(intent.getComponent());
            }
        });
        return true;
    }

    @Override // com.bytedance.pangle.pn
    public void unbindService(final n nVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            u(nVar);
        } else {
            this.u.post(new Runnable() { // from class: com.bytedance.pangle.service.u.u.8
                @Override // java.lang.Runnable
                public void run() {
                    u.this.u(nVar);
                }
            });
        }
    }

    public static u nr() {
        if (nr == null) {
            synchronized (u.class) {
                if (nr == null) {
                    nr = new u();
                }
            }
        }
        return nr;
    }

    private com.bytedance.pangle.service.u fx(Intent intent, String str) {
        com.bytedance.pangle.service.u uVarB = b(intent, str);
        if (uVarB != null) {
            uVarB.onCreate();
        }
        return uVarB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ComponentName u(final Intent intent, final String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return nr(intent, str);
        }
        this.u.post(new Runnable() { // from class: com.bytedance.pangle.service.u.u.1
            @Override // java.lang.Runnable
            public void run() {
                u.this.nr(intent, str);
            }
        });
        return intent.getComponent();
    }

    private void fx(ComponentName componentName) {
        com.bytedance.pangle.service.u uVarRemove = this.iz.remove(componentName);
        this.n.remove(componentName);
        this.fx.remove(componentName);
        this.x.remove(componentName);
        if (uVarRemove != null) {
            uVarRemove.onDestroy();
        }
    }

    public synchronized boolean u(ComponentName componentName) {
        if (!this.iz.containsKey(componentName)) {
            return false;
        }
        this.n.add(componentName);
        return nr(componentName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ComponentName nr(Intent intent, String str) {
        ComponentName component = intent.getComponent();
        if (!this.iz.containsKey(component)) {
            com.bytedance.pangle.service.u uVarFx = fx(intent, str);
            if (uVarFx == null) {
                return component;
            }
            this.iz.put(component, uVarFx);
            this.x.add(component);
        }
        com.bytedance.pangle.service.u uVar = this.iz.get(component);
        if (uVar != null) {
            uVar.onStartCommand(intent, 0, 0);
        }
        return component;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u(final Intent intent, final n nVar, final int i, final String str) throws RemoteException {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return nr(intent, nVar, i, str);
        }
        this.u.post(new Runnable() { // from class: com.bytedance.pangle.service.u.u.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    u.this.nr(intent, nVar, i, str);
                } catch (RemoteException e) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "bindService failed", e);
                }
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void u(n nVar) {
        for (ComponentName componentName : this.b.keySet()) {
            nr nrVar = this.b.get(componentName);
            if (nrVar.contains(nVar)) {
                nrVar.remove(nVar);
                Intent intentRemove = this.pn.remove(nVar);
                if (nrVar.size() == 0) {
                    this.b.remove(componentName);
                    com.bytedance.pangle.service.u uVar = this.iz.get(componentName);
                    if (uVar != null) {
                        uVar.onUnbind(intentRemove);
                    }
                }
                nr(componentName);
                return;
            }
        }
    }

    private boolean nr(ComponentName componentName) {
        if (!this.x.contains(componentName)) {
            if (this.b.get(componentName) != null) {
                return false;
            }
            fx(componentName);
            return true;
        }
        if (!this.n.contains(componentName) || this.b.containsKey(componentName)) {
            return false;
        }
        fx(componentName);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean nr(Intent intent, n nVar, int i, String str) throws RemoteException {
        ComponentName component = intent.getComponent();
        if (!this.iz.containsKey(component)) {
            com.bytedance.pangle.service.u uVarFx = fx(intent, str);
            if (uVarFx == null) {
                return false;
            }
            this.iz.put(component, uVarFx);
        }
        com.bytedance.pangle.service.u uVar = this.iz.get(component);
        if (!this.fx.containsKey(component)) {
            this.fx.put(component, uVar.onBind(intent));
        }
        IBinder iBinder = this.fx.get(component);
        if (iBinder != null) {
            if (this.b.containsKey(component)) {
                if (!this.b.get(component).contains(nVar)) {
                    this.b.get(component).add(nVar);
                    this.pn.put(nVar, intent);
                    nVar.u(component, iBinder);
                }
            } else {
                nr nrVar = new nr();
                nrVar.add(nVar);
                this.b.put(component, nrVar);
                this.pn.put(nVar, intent);
                nVar.u(component, iBinder);
            }
        }
        return true;
    }
}
