package com.opos.mobad.cmn.service.pkginstall;

import android.content.Context;
import android.content.IntentFilter;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f8740a = new byte[0];
    private static volatile d b;
    private SystemBR g;
    private Map<Integer, a> c = null;
    private Map<Integer, a> d = null;
    private Map<Integer, a> e = null;
    private volatile ExecutorService f = null;
    private boolean h = false;

    private d() {
        b();
    }

    private ExecutorService d() {
        ExecutorService executorServiceG = this.f;
        if (executorServiceG == null) {
            synchronized (f8740a) {
                executorServiceG = this.f;
                if (executorServiceG == null) {
                    executorServiceG = com.opos.cmn.an.i.a.g();
                    this.f = executorServiceG;
                }
            }
        }
        return executorServiceG;
    }

    private void e(Context context) {
        SystemBR systemBR;
        if (context == null || (systemBR = this.g) == null) {
            return;
        }
        context.unregisterReceiver(systemBR);
        this.g = null;
    }

    public int a(int i, a aVar) {
        String str;
        int iHashCode = -1;
        if (aVar != null) {
            try {
                iHashCode = aVar.hashCode();
                if (i == 0) {
                    this.c.put(Integer.valueOf(iHashCode), aVar);
                    str = "addISystemBRListener sPkgAddedBRListenerMap.size=" + this.c.size();
                } else if (i == 1) {
                    this.d.put(Integer.valueOf(iHashCode), aVar);
                    str = "addISystemBRListener sPkgReplacedBRListenerMap.size=" + this.d.size();
                } else if (i == 2) {
                    this.e.put(Integer.valueOf(iHashCode), aVar);
                    str = "addISystemBRListener sPkgRemovedBRListenerMap.size=" + this.e.size();
                }
                com.opos.cmn.an.f.a.b("SystemBRMgr", str);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("SystemBRMgr", "addISystemBRListener", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("SystemBRMgr", "addISystemBRListener systemEventId=" + i + ",listenerId=" + iHashCode);
        return iHashCode;
    }

    public static d a() {
        d dVar = b;
        if (dVar == null) {
            synchronized (f8740a) {
                dVar = b;
                if (dVar == null) {
                    dVar = new d();
                    b = dVar;
                }
            }
        }
        return dVar;
    }

    private void b() {
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
        this.e = new ConcurrentHashMap();
    }

    private void c() {
        this.c.clear();
        this.d.clear();
        this.e.clear();
    }

    private void d(Context context) {
        if (context != null) {
            if (this.g != null) {
                b(context);
            }
            this.g = new SystemBR();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
            intentFilter.addDataScheme("package");
            context.registerReceiver(this.g, intentFilter);
        }
    }

    public synchronized void b(Context context) {
        try {
            com.opos.cmn.an.f.a.b("SystemBRMgr", "unregister mHasRegistered=" + this.h);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("SystemBRMgr", "", (Throwable) e);
        }
        if (context != null && this.h) {
            e(context.getApplicationContext());
            this.h = false;
            com.opos.cmn.an.f.a.b("SystemBRMgr", "移除系统广播监听成功");
        }
    }

    public void c(Context context) {
        b(context);
        c();
    }

    public void a(int i, int i2) {
        String str;
        try {
            if (i != 0) {
                if (i != 1) {
                    if (i == 2 && this.e.containsKey(Integer.valueOf(i2))) {
                        this.e.remove(Integer.valueOf(i2));
                        str = "removeISystemBRListener sPkgRemovedBRListenerMap.size=" + this.e.size();
                        com.opos.cmn.an.f.a.b("SystemBRMgr", str);
                    }
                } else if (this.d.containsKey(Integer.valueOf(i2))) {
                    this.d.remove(Integer.valueOf(i2));
                    str = "removeISystemBRListener sPkgReplacedBRListenerMap.size=" + this.d.size();
                    com.opos.cmn.an.f.a.b("SystemBRMgr", str);
                }
            } else if (this.c.containsKey(Integer.valueOf(i2))) {
                this.c.remove(Integer.valueOf(i2));
                str = "removeISystemBRListener sPkgAddedBRListenerMap.size=" + this.c.size();
                com.opos.cmn.an.f.a.b("SystemBRMgr", str);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("SystemBRMgr", "removeISystemBRListener", (Throwable) e);
        }
        com.opos.cmn.an.f.a.b("SystemBRMgr", "removeISystemBRListener systemEventId=" + i + ",listenerId=" + i2);
    }

    public void a(final int i, final String str) {
        a(new Runnable() { // from class: com.opos.mobad.cmn.service.pkginstall.d.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    int i2 = i;
                    if (i2 == 0) {
                        d dVar = d.this;
                        dVar.a((Map<Integer, a>) dVar.c, str);
                    } else if (i2 == 1) {
                        d dVar2 = d.this;
                        dVar2.a((Map<Integer, a>) dVar2.d, str);
                    } else if (i2 == 2) {
                        d dVar3 = d.this;
                        dVar3.a((Map<Integer, a>) dVar3.e, str);
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("SystemBRMgr", "notifyBRListener", (Throwable) e);
                }
            }
        });
        com.opos.cmn.an.f.a.b("SystemBRMgr", "notifyBRListener systemEventId=" + i + ", pkgName=" + str);
    }

    public synchronized void a(Context context) {
        try {
            com.opos.cmn.an.f.a.b("SystemBRMgr", "register mHasRegistered=" + this.h);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("SystemBRMgr", "register", (Throwable) e);
        }
        if (context != null && !this.h) {
            d(context.getApplicationContext());
            this.h = true;
            com.opos.cmn.an.f.a.b("SystemBRMgr", "注册系统广播监听成功");
        }
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            try {
                d().execute(runnable);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("SystemBRMgr", "executeBRTask", (Throwable) e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<Integer, a> map, Object... objArr) {
        if (map != null) {
            try {
                if (map.isEmpty()) {
                    return;
                }
                Iterator<a> it = map.values().iterator();
                while (it.hasNext()) {
                    it.next().a(objArr);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("SystemBRMgr", "notifyBRListenerMap", (Throwable) e);
            }
        }
    }
}
