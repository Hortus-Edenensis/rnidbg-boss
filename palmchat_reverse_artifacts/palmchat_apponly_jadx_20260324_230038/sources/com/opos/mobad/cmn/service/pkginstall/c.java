package com.opos.mobad.cmn.service.pkginstall;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.View;
import android.widget.Toast;
import com.heytap.msp.mobad.api.R;
import com.opos.cmn.module.ui.c.c.e;
import com.opos.cmn.module.ui.c.c.f;
import com.opos.mobad.cmn.func.b.g;
import com.opos.mobad.cmn.service.b.a;
import com.opos.mobad.model.data.AdItemData;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class c implements com.opos.cmn.module.ui.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f8732a = new byte[0];
    private static volatile c b;
    private final Context c;
    private LruCache<String, Set<b>> e;
    private LruCache<String, List<com.opos.mobad.cmn.service.pkginstall.b>> f;
    private e i;
    private int d = -1;
    private a.InterfaceC0731a g = null;
    private boolean h = true;
    private final Handler j = new Handler(Looper.getMainLooper()) { // from class: com.opos.mobad.cmn.service.pkginstall.c.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null) {
                try {
                    String str = (String) message.obj;
                    int i = message.what;
                    if (i == 0) {
                        c.this.b(str);
                        return;
                    }
                    if (i != 1) {
                        if (i != 2) {
                            return;
                        }
                        c.this.a(str, (int[]) null);
                    } else {
                        if (!c.this.h() || !g.j()) {
                            com.opos.cmn.an.f.a.b("PkgInstallMgr", "show Toast but lack of conditions to show");
                            return;
                        }
                        Bundle data = message.getData();
                        if (data != null) {
                            boolean z = data.getBoolean("gbClick");
                            if (c.this.i == null) {
                                c cVar = c.this;
                                cVar.i = new f(cVar.c.getApplicationContext(), c.this);
                            }
                            c.this.i.a(str, z, new Object[0]);
                        }
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("PkgInstallMgr", "handleMessage", (Throwable) e);
                }
            }
        }
    };
    private final com.opos.mobad.cmn.service.pkginstall.a k = new com.opos.mobad.cmn.service.pkginstall.a() { // from class: com.opos.mobad.cmn.service.pkginstall.c.3
        @Override // com.opos.mobad.cmn.service.pkginstall.a
        public void a(Object... objArr) {
            Object obj;
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("PKG_ADDED_BR_LISTENER onReceive objects=");
                sb.append(objArr != null ? objArr : com.igexin.push.core.b.m);
                com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
                if (objArr == null || objArr.length <= 0 || (obj = objArr[0]) == null) {
                    return;
                }
                String str = (String) obj;
                com.opos.cmn.an.f.a.a("PkgInstallMgr", "收到系统广播通知，包名 " + str + " 安装成功");
                c.this.g(str);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("PkgInstallMgr", "onReceive", (Throwable) e);
            }
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(AdItemData adItemData, String str);

        void b(AdItemData adItemData, String str);

        void c(AdItemData adItemData, String str);
    }

    private c(Context context) {
        this.c = context.getApplicationContext();
        b();
    }

    private void b() {
        com.opos.cmn.an.f.a.b("PkgInstallMgr", "init");
        try {
            if (this.f == null) {
                this.f = new LruCache<>(50);
            }
            if (this.e == null) {
                this.e = new LruCache<>(20);
            }
            c();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "init", (Throwable) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Set<b> f(String str) {
        Set<b> hashSet;
        try {
            hashSet = this.e.get(str) != null ? this.e.get(str) : new HashSet<>();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "getListenerMap", (Throwable) e);
            hashSet = null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getListenerMap pkgName=");
        sb.append(str);
        sb.append(",listenerMap.size=");
        sb.append(hashSet != null ? Integer.valueOf(hashSet.size()) : com.igexin.push.core.b.m);
        com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
        return hashSet;
    }

    private void g() {
        com.opos.cmn.an.f.a.b("PkgInstallMgr", "unregisterPkgInstallBR id=" + this.d);
        if (-1 != this.d) {
            com.opos.cmn.an.f.a.b("PkgInstallMgr", "really unregisterPkgInstallBR!!!");
            d.a().a(0, this.d);
            this.d = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean h() {
        boolean z = false;
        try {
            if (com.opos.cmn.an.c.c.b() < 19) {
                if (com.opos.cmn.an.h.d.a.a(this.c, "android.permission.SYSTEM_ALERT_WINDOW")) {
                    z = true;
                }
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "hasAlertWindowPermission", (Throwable) e);
        }
        com.opos.cmn.an.f.a.b("PkgInstallMgr", "hasAlertWindowPermission=" + z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        com.opos.cmn.an.f.a.b("PkgInstallMgr", "App 切到前台");
        this.h = true;
        LruCache<String, Set<b>> lruCache = this.e;
        if (lruCache == null || lruCache.size() <= 0) {
            g();
            return;
        }
        com.opos.cmn.an.f.a.b("PkgInstallMgr", "当前有下载行为，重新注册系统广播监听");
        d.a().a(this.c);
        com.opos.cmn.an.f.a.b("PkgInstallMgr", "开始手动检测是否有下载行为完成");
        for (Map.Entry<String, Set<b>> entry : this.e.snapshot().entrySet()) {
            if (com.opos.cmn.an.h.d.a.d(this.c, entry.getKey())) {
                g(entry.getKey());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        com.opos.cmn.an.f.a.b("PkgInstallMgr", "App 切到后台");
        this.h = false;
        d.a().b(this.c);
    }

    private int k(String str) {
        List<com.opos.mobad.cmn.service.pkginstall.b> listE;
        try {
            if (com.opos.cmn.an.d.b.a(str) || (listE = e(str)) == null || listE.isEmpty() || listE.get(0) == null) {
                return 0;
            }
            return listE.get(0).b.i().get(0).A();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "getInstallCompleteAction", (Throwable) e);
            return 0;
        }
    }

    private String l(String str) {
        List<com.opos.mobad.cmn.service.pkginstall.b> listE;
        String strQ = "";
        try {
            if (!com.opos.cmn.an.d.b.a(str) && (listE = e(str)) != null && !listE.isEmpty() && listE.get(0) != null) {
                strQ = listE.get(0).b.i().get(0).q();
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "getDeepLinkUrl", (Throwable) e);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getDeepLinkUrl pkgName=");
        String str2 = com.igexin.push.core.b.m;
        if (str == null) {
            str = com.igexin.push.core.b.m;
        }
        sb.append(str);
        sb.append(",result=");
        if (strQ != null) {
            str2 = strQ;
        }
        sb.append(str2);
        com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
        return strQ;
    }

    private String m(String str) {
        List<com.opos.mobad.cmn.service.pkginstall.b> listE;
        String strD = "";
        try {
            if (!com.opos.cmn.an.d.b.a(str) && (listE = e(str)) != null && !listE.isEmpty() && listE.get(0) != null) {
                strD = g.d(listE.get(0).b.al());
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "getClickTraceId", (Throwable) e);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getClickTraceId pkgName=");
        String str2 = com.igexin.push.core.b.m;
        if (str == null) {
            str = com.igexin.push.core.b.m;
        }
        sb.append(str);
        sb.append(",result=");
        if (strD != null) {
            str2 = strD;
        }
        sb.append(str2);
        com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
        return strD;
    }

    private void n(final String str) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("notifyInstallCompletedEvent pkgName=");
            sb.append(str != null ? str : com.igexin.push.core.b.m);
            com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
            this.j.post(new Runnable() { // from class: com.opos.mobad.cmn.service.pkginstall.c.6
                @Override // java.lang.Runnable
                public void run() {
                    Set<b> setF;
                    if (com.opos.cmn.an.d.b.a(str) || (setF = c.this.f(str)) == null || setF.size() <= 0) {
                        return;
                    }
                    for (b bVar : setF) {
                        com.opos.cmn.an.f.a.b("PkgInstallMgr", "notifyInstallCompletedEvent getListenerMap =" + bVar);
                        if (bVar != null) {
                            List listE = c.this.e(str);
                            if (listE == null || listE.size() <= 0 || listE.get(0) == null) {
                                com.opos.cmn.an.f.a.b("PkgInstallMgr", "notify but data empty");
                            } else {
                                com.opos.cmn.an.f.a.b("PkgInstallMgr", "notifyInstallCompletedEvent listener = " + bVar);
                                bVar.a(((com.opos.mobad.cmn.service.pkginstall.b) listE.get(0)).b, str);
                            }
                        }
                    }
                }
            });
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "notifyInstallCompletedEvent", (Throwable) e);
        }
    }

    public static c a(Context context) {
        c cVar = b;
        if (cVar == null) {
            synchronized (f8732a) {
                cVar = b;
                if (cVar == null) {
                    cVar = new c(context);
                    b = cVar;
                }
            }
        }
        return cVar;
    }

    private void c() {
        if (this.g == null) {
            this.g = new a.InterfaceC0731a() { // from class: com.opos.mobad.cmn.service.pkginstall.c.1
                @Override // com.opos.mobad.cmn.service.b.a.InterfaceC0731a
                public void a() {
                    c.this.i();
                }

                @Override // com.opos.mobad.cmn.service.b.a.InterfaceC0731a
                public void b() {
                    c.this.j();
                }
            };
        }
        com.opos.mobad.cmn.service.b.a.a().a(this.g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.opos.mobad.cmn.service.pkginstall.b> e(String str) {
        List<com.opos.mobad.cmn.service.pkginstall.b> copyOnWriteArrayList;
        Exception e;
        try {
            copyOnWriteArrayList = this.f.get(str);
            if (copyOnWriteArrayList == null) {
                try {
                    copyOnWriteArrayList = new CopyOnWriteArrayList();
                } catch (Exception e2) {
                    e = e2;
                    com.opos.cmn.an.f.a.a("PkgInstallMgr", "getAdItemDataList", (Throwable) e);
                }
            }
        } catch (Exception e3) {
            copyOnWriteArrayList = null;
            e = e3;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getAdItemDataList pkgName=");
        sb.append(str);
        sb.append(",adItemDataList.size=");
        sb.append(copyOnWriteArrayList != null ? Integer.valueOf(copyOnWriteArrayList.size()) : com.igexin.push.core.b.m);
        com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
        return copyOnWriteArrayList;
    }

    private void f() {
        com.opos.cmn.an.f.a.b("PkgInstallMgr", "registerPkgInstallBR id=" + this.d);
        if (-1 == this.d) {
            com.opos.cmn.an.f.a.b("PkgInstallMgr", "准备开始下载，注册监听");
            if (this.h) {
                d.a().a(this.c);
            }
            this.d = d.a().a(0, this.k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str) {
        if (d(str)) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "检测到 " + str + " 安装成功，通知处理业务逻辑");
            try {
                if (!com.opos.cmn.an.d.b.a(str)) {
                    j(str);
                    n(str);
                    if (com.opos.cmn.an.h.a.a.b(this.c)) {
                        i(str);
                    } else {
                        b(str);
                    }
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("PkgInstallMgr", "handleInstallCompleteAction", (Throwable) e);
            }
        }
    }

    private boolean h(String str) {
        boolean zC = false;
        try {
            List<com.opos.mobad.cmn.service.pkginstall.b> listE = e(str);
            if (listE != null && !listE.isEmpty() && listE.get(0) != null) {
                zC = listE.get(0).b.i().get(0).C();
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "isGbClickToast", (Throwable) e);
        }
        com.opos.cmn.an.f.a.b("PkgInstallMgr", "isGbClickToast pkgName=" + str + ",result=" + zC);
        return zC;
    }

    private void i(final String str) {
        try {
            if (!com.opos.cmn.an.d.b.a(str)) {
                int iK = k(str);
                Message messageObtainMessage = this.j.obtainMessage(iK);
                messageObtainMessage.obj = str;
                Bundle bundle = new Bundle();
                bundle.putBoolean("gbClick", h(str));
                messageObtainMessage.setData(bundle);
                if (2 == iK) {
                    this.j.post(new Runnable() { // from class: com.opos.mobad.cmn.service.pkginstall.c.4
                        @Override // java.lang.Runnable
                        public void run() {
                            String string = c.this.c.getResources().getString(R.string.opos_mob_install_success_tips);
                            Toast.makeText(c.this.c.getApplicationContext(), g.a(c.this.c, str) + string, 0).show();
                        }
                    });
                    this.j.sendMessageDelayed(messageObtainMessage, 2000L);
                } else {
                    this.j.sendMessage(messageObtainMessage);
                }
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "sendReminderMessage", (Throwable) e);
        }
    }

    private void j(String str) {
        List<com.opos.mobad.cmn.service.pkginstall.b> listE;
        try {
            if (com.opos.cmn.an.d.b.a(str) || (listE = e(str)) == null || listE.isEmpty()) {
                return;
            }
            for (int i = 0; i < listE.size(); i++) {
                if (listE.get(i) != null) {
                    com.opos.mobad.cmn.service.pkginstall.b bVar = listE.get(i);
                    com.opos.mobad.b bVar2 = bVar.f8731a;
                    AdItemData adItemData = bVar.b;
                    com.opos.mobad.cmn.func.b.e.a(bVar2, adItemData, adItemData.i().get(0));
                }
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "", (Throwable) e);
        }
    }

    @Override // com.opos.cmn.module.ui.c.a
    public void b(View view, int[] iArr, String str, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("onToastClose pkgName=");
        sb.append(str != null ? str : com.igexin.push.core.b.m);
        sb.append(",objects=");
        Object obj = objArr;
        if (objArr == null) {
            obj = com.igexin.push.core.b.m;
        }
        sb.append(obj);
        com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
        try {
            e eVar = this.i;
            if (eVar != null) {
                eVar.a();
            }
            b(str);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "onToastClose", (Throwable) e);
        }
    }

    private void c(String str) {
        try {
            if (!com.opos.cmn.an.d.b.a(str) && this.f.get(str) != null) {
                this.f.remove(str);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("PkgInstallMgr", "removeAdItemDataList", e);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("removeAdItemDataList pkgName=");
        if (str == null) {
            str = com.igexin.push.core.b.m;
        }
        sb.append(str);
        sb.append(",sAdItemDataCache.size=");
        sb.append(this.f.size());
        com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
    }

    private void d() {
        if (this.e.size() <= 0) {
            com.opos.cmn.an.f.a.b("PkgInstallMgr", "当前没有下载行为，尝试移除系统广播监听");
            g();
            d.a().b(this.c);
        }
    }

    private void e() {
        this.f.evictAll();
        this.e.evictAll();
    }

    public void a() {
        com.opos.cmn.an.f.a.b("PkgInstallMgr", com.alipay.sdk.m.x.d.z);
        try {
            g();
            e();
            e eVar = this.i;
            if (eVar != null) {
                eVar.b();
            }
            d.a().c(this.c);
            if (this.g != null) {
                com.opos.mobad.cmn.service.b.a.a().b(this.g);
                this.g = null;
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", com.alipay.sdk.m.x.d.z, (Throwable) e);
        }
    }

    private void c(String str, b bVar) {
        Set<b> setF;
        try {
            if (!com.opos.cmn.an.d.b.a(str) && bVar != null && (setF = f(str)) != null) {
                if (setF.size() > 0) {
                    for (b bVar2 : setF) {
                        if (bVar2 != null && bVar2.equals(bVar)) {
                            com.opos.cmn.an.f.a.b("PkgInstallMgr", "addListener but has contain");
                            return;
                        }
                    }
                }
                setF.add(bVar);
                com.opos.cmn.an.f.a.b("PkgInstallMgr", "addListener pkgName=" + str + ",listenerList.size=" + setF.size());
                this.e.put(str, setF);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "addListener", (Throwable) e);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("addListener pkgName=");
        if (str == null) {
            str = com.igexin.push.core.b.m;
        }
        sb.append(str);
        sb.append(",listener=");
        Object obj = bVar;
        if (bVar == null) {
            obj = com.igexin.push.core.b.m;
        }
        sb.append(obj);
        sb.append(",sListenerMap.size=");
        sb.append(this.e.size());
        com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
    }

    private boolean d(String str) {
        boolean z = false;
        try {
            if (!com.opos.cmn.an.d.b.a(str)) {
                if (this.f.get(str) != null) {
                    z = true;
                }
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "isContainPkgName", (Throwable) e);
        }
        com.opos.cmn.an.f.a.b("PkgInstallMgr", "isContainPkgName result=" + z);
        return z;
    }

    @Override // com.opos.cmn.module.ui.c.a
    public void a(View view, String str, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("onToastShow pkgName=");
        if (str == null) {
            str = com.igexin.push.core.b.m;
        }
        sb.append(str);
        sb.append(",objects=");
        Object obj = objArr;
        if (objArr == null) {
            obj = com.igexin.push.core.b.m;
        }
        sb.append(obj);
        com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        c(str);
        a(str);
    }

    @Override // com.opos.cmn.module.ui.c.a
    public void a(View view, int[] iArr, String str, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("onToastClick pkgName=");
        sb.append(str != null ? str : com.igexin.push.core.b.m);
        sb.append(",objects=");
        Object obj = objArr;
        if (objArr == null) {
            obj = com.igexin.push.core.b.m;
        }
        sb.append(obj);
        com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
        try {
            a(str, iArr);
            e eVar = this.i;
            if (eVar != null) {
                eVar.a();
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "onToastClick", (Throwable) e);
        }
    }

    private void b(String str, com.opos.mobad.b bVar, AdItemData adItemData) {
        List<com.opos.mobad.cmn.service.pkginstall.b> listE;
        try {
            if (!com.opos.cmn.an.d.b.a(str) && adItemData != null && bVar != null && (listE = e(str)) != null && !a(listE, adItemData)) {
                listE.add(0, new com.opos.mobad.cmn.service.pkginstall.b(bVar, adItemData));
                this.f.put(str, listE);
                com.opos.cmn.an.f.a.b("PkgInstallMgr", "addAdItemData pkgName=" + str + ",adItemDataList.size=" + listE.size());
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "addAdItemData", (Throwable) e);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("addAdItemData pkgName=");
        if (str == null) {
            str = com.igexin.push.core.b.m;
        }
        sb.append(str);
        sb.append(",sAdItemDataCache.size=");
        sb.append(this.f.size());
        sb.append(",adItemData=");
        Object obj = adItemData;
        if (adItemData == null) {
            obj = com.igexin.push.core.b.m;
        }
        sb.append(obj);
        com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
    }

    public void a(b bVar) {
        if (bVar == null) {
            return;
        }
        try {
            Map<String, Set<b>> mapSnapshot = this.e.snapshot();
            if (mapSnapshot == null) {
                return;
            }
            for (Map.Entry<String, Set<b>> entry : mapSnapshot.entrySet()) {
                Set<b> value = entry.getValue();
                if (value != null) {
                    value.remove(bVar);
                    if (value.isEmpty()) {
                        this.e.remove(entry.getKey());
                    }
                }
            }
            com.opos.cmn.an.f.a.b("PkgInstallMgr", "removeListener sListenerMap.size=" + this.e.size());
            d();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("PkgInstallMgr", "removeListener", e);
        }
    }

    public void b(String str, b bVar) {
        if (bVar == null) {
            return;
        }
        try {
            Set<b> set = this.e.get(str);
            if (set == null) {
                return;
            }
            set.remove(bVar);
            if (set.isEmpty()) {
                this.e.remove(str);
            }
            com.opos.cmn.an.f.a.b("PkgInstallMgr", "removeListener pkgName=" + str + ", sListenerMap.size=" + this.e.size());
            d();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("PkgInstallMgr", "removeListener", e);
        }
    }

    private void a(String str) {
        try {
            if (!com.opos.cmn.an.d.b.a(str)) {
                this.e.remove(str);
            }
            com.opos.cmn.an.f.a.b("PkgInstallMgr", "removeListenerList pkgName=" + str + ", sListenerMap.size=" + this.e.size());
            d();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("PkgInstallMgr", "removeListenerList", e);
        }
    }

    public void a(String str, com.opos.mobad.b bVar, b bVar2, AdItemData adItemData) {
        if (bVar != null && bVar2 != null && adItemData != null) {
            try {
                if (!com.opos.cmn.an.d.b.a(str)) {
                    f();
                    c(str, bVar2);
                    b(str, bVar.c(), adItemData);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("PkgInstallMgr", "addPkgInstallBRListener", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("PkgInstallMgr", "addPkgInstallBRListener downloadPkgName=", str, "Listener=", bVar2, "adItemData=", adItemData);
    }

    public void a(String str, com.opos.mobad.b bVar, AdItemData adItemData) {
        if (bVar != null && adItemData != null) {
            try {
                if (!com.opos.cmn.an.d.b.a(str)) {
                    f();
                    b(str, bVar.c(), adItemData);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("PkgInstallMgr", "addPkgInstallBRListener", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("PkgInstallMgr", "addPkgInstallBRListener downloadPkgName=", str, "adItemData=", adItemData);
    }

    private void a(final String str, final a aVar) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("notifyLaunchEvent pkgName=");
            sb.append(str != null ? str : com.igexin.push.core.b.m);
            com.opos.cmn.an.f.a.b("PkgInstallMgr", sb.toString());
            this.j.post(new Runnable() { // from class: com.opos.mobad.cmn.service.pkginstall.c.7
                @Override // java.lang.Runnable
                public void run() {
                    Set<b> setF;
                    if (!com.opos.cmn.an.d.b.a(str) && (setF = c.this.f(str)) != null && setF.size() > 0) {
                        for (b bVar : setF) {
                            if (bVar != null) {
                                List listE = c.this.e(str);
                                if (listE == null || listE.size() <= 0 || listE.get(0) == null) {
                                    com.opos.cmn.an.f.a.b("PkgInstallMgr", "notify but data empty");
                                } else {
                                    bVar.b(((com.opos.mobad.cmn.service.pkginstall.b) listE.get(0)).b, str);
                                }
                            }
                        }
                    }
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                }
            });
        } catch (Exception e) {
            if (aVar != null) {
                aVar.a();
            }
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "notifyLaunchEvent", (Throwable) e);
        }
    }

    public void a(String str, b bVar) {
        if (bVar != null) {
            try {
                if (!com.opos.cmn.an.d.b.a(str)) {
                    f();
                    c(str, bVar);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("PkgInstallMgr", "addPkgInstallBRListener", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("PkgInstallMgr", "addPkgInstallBRListener downloadPkgName=" + str + ",Listener=" + bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, int[] iArr) {
        try {
            if (com.opos.cmn.an.d.b.a(str)) {
                return;
            }
            String strL = l(str);
            String strM = m(str);
            boolean z = true;
            if (!TextUtils.isEmpty(strL) && g.b(this.c, strL, g.a(com.opos.mobad.cmn.service.a.a().b(), strM))) {
                a(str, iArr, true, true, strM);
            } else if (g.a(this.c, str, g.a(com.opos.mobad.cmn.service.a.a().b(), strM))) {
                a(str, iArr, false, true, strM);
            } else {
                z = false;
            }
            if (z) {
                a(str, new a() { // from class: com.opos.mobad.cmn.service.pkginstall.c.5
                    @Override // com.opos.mobad.cmn.service.pkginstall.c.a
                    public void a() {
                        c.this.b(str);
                    }
                });
            } else {
                b(str);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("PkgInstallMgr", "handleLaunchAppPageEvent", (Throwable) e);
        }
    }

    private void a(String str, int[] iArr, boolean z, boolean z2, String str2) {
        com.opos.mobad.cmn.service.pkginstall.b bVar;
        List<com.opos.mobad.cmn.service.pkginstall.b> listE = e(str);
        if (listE == null || listE.isEmpty()) {
            return;
        }
        for (int i = 0; i < listE.size(); i++) {
            if (listE.get(i) != null && (bVar = listE.get(i)) != null) {
                AdItemData adItemData = bVar.b;
                HashMap map = new HashMap();
                com.opos.mobad.cmn.func.b.a.a.b(map, str2);
                com.opos.mobad.b bVar2 = bVar.f8731a;
                if (z) {
                    com.opos.mobad.cmn.func.b.e.c(bVar2, adItemData.g(), adItemData, adItemData.i().get(0), z2, iArr, map);
                } else {
                    com.opos.mobad.cmn.func.b.e.a(bVar2, adItemData, adItemData.i().get(0), z2, iArr, map);
                }
            }
        }
    }

    private boolean a(List<com.opos.mobad.cmn.service.pkginstall.b> list, AdItemData adItemData) {
        if (list.size() <= 0) {
            return false;
        }
        Iterator<com.opos.mobad.cmn.service.pkginstall.b> it = list.iterator();
        while (it.hasNext()) {
            AdItemData adItemData2 = it.next().b;
            if (adItemData2 != null && !TextUtils.isEmpty(adItemData2.i().get(0).X()) && !TextUtils.isEmpty(adItemData.i().get(0).X()) && adItemData2.i().get(0).X().equals(adItemData.i().get(0).X())) {
                com.opos.cmn.an.f.a.b("PkgInstallMgr", "addAdItemData but has contain ,traceId = " + adItemData2.i().get(0).X());
                return true;
            }
        }
        return false;
    }
}
