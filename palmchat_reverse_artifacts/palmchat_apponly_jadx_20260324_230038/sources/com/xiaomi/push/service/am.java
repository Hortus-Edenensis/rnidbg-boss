package com.xiaomi.push.service;

import android.content.Context;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class am {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static am f11718a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ConcurrentHashMap<String, HashMap<String, b>> f926a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private List<a> f927a = new ArrayList();

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Context f928a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        Messenger f930a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private XMPushService f932a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public h f935a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f936a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f938a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public String f939b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        c f934a = c.unbind;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f11719a = 0;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private final CopyOnWriteArrayList<a> f937a = new CopyOnWriteArrayList<>();
        c b = null;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private boolean f940b = false;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private XMPushService.c f931a = new XMPushService.c(this);

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        IBinder.DeathRecipient f929a = null;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        final C0927b f933a = new C0927b();

        /* JADX INFO: compiled from: SearchBox */
        public interface a {
            void a(c cVar, c cVar2, int i);
        }

        /* JADX INFO: renamed from: com.xiaomi.push.service.am$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C0927b extends XMPushService.j {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            String f941a;
            int b;

            /* JADX INFO: renamed from: b, reason: collision with other field name */
            String f942b;
            int c;

            public C0927b() {
                super(0);
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "notify job";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* JADX INFO: renamed from: a */
            public void mo403a() {
                if (b.this.a(this.b, this.c, this.f942b)) {
                    b.this.a(this.b, this.c, this.f941a, this.f942b);
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.b(" ignore notify client :" + b.this.g);
            }

            public XMPushService.j a(int i, int i2, String str, String str2) {
                this.b = i;
                this.c = i2;
                this.f942b = str2;
                this.f941a = str;
                return this;
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c implements IBinder.DeathRecipient {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final Messenger f11722a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            final b f943a;

            public c(b bVar, Messenger messenger) {
                this.f943a = bVar;
                this.f11722a = messenger;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                com.xiaomi.channel.commonutils.logger.b.b("peer died, chid = " + this.f943a.g);
                int i = 0;
                b.this.f932a.a(new XMPushService.j(i) { // from class: com.xiaomi.push.service.am.b.c.1
                    @Override // com.xiaomi.push.service.XMPushService.j
                    public String a() {
                        return "clear peer job";
                    }

                    @Override // com.xiaomi.push.service.XMPushService.j
                    /* JADX INFO: renamed from: a */
                    public void mo403a() {
                        c cVar = c.this;
                        if (cVar.f11722a == cVar.f943a.f930a) {
                            com.xiaomi.channel.commonutils.logger.b.b("clean peer, chid = " + c.this.f943a.g);
                            c.this.f943a.f930a = null;
                        }
                    }
                }, 0L);
                if ("9".equals(this.f943a.g) && "com.xiaomi.xmsf".equals(b.this.f932a.getPackageName())) {
                    b.this.f932a.a(new XMPushService.j(i) { // from class: com.xiaomi.push.service.am.b.c.2
                        @Override // com.xiaomi.push.service.XMPushService.j
                        public String a() {
                            return "check peer job";
                        }

                        @Override // com.xiaomi.push.service.XMPushService.j
                        /* JADX INFO: renamed from: a */
                        public void mo403a() {
                            am amVarA = am.a();
                            b bVar = c.this.f943a;
                            if (amVarA.a(bVar.g, bVar.f939b).f930a == null) {
                                XMPushService xMPushService = b.this.f932a;
                                b bVar2 = c.this.f943a;
                                xMPushService.a(bVar2.g, bVar2.f939b, 2, null, null);
                            }
                        }
                    }, 60000L);
                }
            }
        }

        public b() {
        }

        private boolean b(int i, int i2, String str) {
            if (i == 1) {
                return (this.f934a == c.binded || !this.f932a.m692c() || i2 == 21 || (i2 == 7 && "wait".equals(str))) ? false : true;
            }
            if (i == 2) {
                return this.f932a.m692c();
            }
            if (i != 3) {
                return false;
            }
            return !"wait".equals(str);
        }

        public String a(int i) {
            return i != 1 ? i != 2 ? i != 3 ? "unknown" : "KICK" : "CLOSE" : "OPEN";
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public void m723a() {
            try {
                Messenger messenger = this.f930a;
                if (messenger != null && this.f929a != null) {
                    messenger.getBinder().unlinkToDeath(this.f929a, 0);
                }
            } catch (Exception unused) {
            }
            this.b = null;
        }

        public void b(a aVar) {
            this.f937a.remove(aVar);
        }

        public b(XMPushService xMPushService) {
            this.f932a = xMPushService;
            a(new a() { // from class: com.xiaomi.push.service.am.b.1
                @Override // com.xiaomi.push.service.am.b.a
                public void a(c cVar, c cVar2, int i) {
                    if (cVar2 == c.binding) {
                        b.this.f932a.a(b.this.f931a, 60000L);
                    } else {
                        b.this.f932a.b(b.this.f931a);
                    }
                }
            });
        }

        public void a(Messenger messenger) {
            m723a();
            try {
                if (messenger != null) {
                    this.f930a = messenger;
                    this.f940b = true;
                    this.f929a = new c(this, messenger);
                    messenger.getBinder().linkToDeath(this.f929a, 0);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.b("peer linked with old sdk chid = " + this.g);
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.b("peer linkToDeath err: " + e.getMessage());
                this.f930a = null;
                this.f940b = false;
            }
        }

        public void a(c cVar, int i, int i2, String str, String str2) {
            boolean z;
            for (a aVar : this.f937a) {
                if (aVar != null) {
                    aVar.a(this.f934a, cVar, i2);
                }
            }
            c cVar2 = this.f934a;
            int i3 = 0;
            if (cVar2 != cVar) {
                com.xiaomi.channel.commonutils.logger.b.m74a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", cVar2, cVar, a(i), an.a(i2), str, str2, this.g));
                this.f934a = cVar;
            }
            if (this.f935a == null) {
                com.xiaomi.channel.commonutils.logger.b.d("status changed while the client dispatcher is missing");
                return;
            }
            if (cVar == c.binding) {
                return;
            }
            if (this.b != null && (z = this.f940b)) {
                i3 = (this.f930a == null || !z) ? 10100 : 1000;
            }
            this.f932a.b(this.f933a);
            if (b(i, i2, str2)) {
                a(i, i2, str, str2);
            } else {
                this.f932a.a(this.f933a.a(i, i2, str, str2), i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, int i2, String str, String str2) {
            c cVar = this.f934a;
            this.b = cVar;
            if (i == 2) {
                this.f935a.a(this.f928a, this, i2);
                return;
            }
            if (i == 3) {
                this.f935a.a(this.f928a, this, str2, str);
                return;
            }
            if (i == 1) {
                boolean z = cVar == c.binded;
                if (!z && "wait".equals(str2)) {
                    this.f11719a++;
                } else if (z) {
                    this.f11719a = 0;
                    if (this.f930a != null) {
                        try {
                            this.f930a.send(Message.obtain(null, 16, this.f932a.f873a));
                        } catch (RemoteException unused) {
                        }
                    }
                }
                this.f935a.a(this.f932a, this, z, i2, str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(int i, int i2, String str) {
            boolean z;
            c cVar = this.b;
            if (cVar == null || !(z = this.f940b)) {
                return true;
            }
            if (cVar == this.f934a) {
                com.xiaomi.channel.commonutils.logger.b.b(" status recovered, don't notify client:" + this.g);
                return false;
            }
            if (this.f930a != null && z) {
                com.xiaomi.channel.commonutils.logger.b.b("Peer alive notify status to client:" + this.g);
                return true;
            }
            com.xiaomi.channel.commonutils.logger.b.b("peer died, ignore notify " + this.g);
            return false;
        }

        public void a(a aVar) {
            this.f937a.add(aVar);
        }

        public long a() {
            return (((long) ((Math.random() * 20.0d) - 10.0d)) + ((long) ((this.f11719a + 1) * 15))) * 1000;
        }

        public static String a(String str) {
            int iLastIndexOf;
            return (TextUtils.isEmpty(str) || (iLastIndexOf = str.lastIndexOf("/")) == -1) ? "" : str.substring(iLastIndexOf + 1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum c {
        unbind,
        binding,
        binded
    }

    private am() {
    }

    public static synchronized am a() {
        if (f11718a == null) {
            f11718a = new am();
        }
        return f11718a;
    }

    public synchronized void b() {
        this.f927a.clear();
    }

    public synchronized void a(b bVar) {
        HashMap<String, b> map = this.f926a.get(bVar.g);
        if (map == null) {
            map = new HashMap<>();
            this.f926a.put(bVar.g, map);
        }
        map.put(a(bVar.f939b), bVar);
        com.xiaomi.channel.commonutils.logger.b.m74a("add active client. " + bVar.f936a);
        Iterator<a> it = this.f927a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized void m721a(String str, String str2) {
        HashMap<String, b> map = this.f926a.get(str);
        if (map != null) {
            b bVar = map.get(a(str2));
            if (bVar != null) {
                bVar.m723a();
            }
            map.remove(a(str2));
            if (map.isEmpty()) {
                this.f926a.remove(str);
            }
        }
        Iterator<a> it = this.f927a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized void m720a(String str) {
        HashMap<String, b> map = this.f926a.get(str);
        if (map != null) {
            Iterator<b> it = map.values().iterator();
            while (it.hasNext()) {
                it.next().m723a();
            }
            map.clear();
            this.f926a.remove(str);
        }
        Iterator<a> it2 = this.f927a.iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized List<String> m718a(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<HashMap<String, b>> it = this.f926a.values().iterator();
        while (it.hasNext()) {
            for (b bVar : it.next().values()) {
                if (str.equals(bVar.f936a)) {
                    arrayList.add(bVar.g);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized ArrayList<b> m716a() {
        ArrayList<b> arrayList;
        arrayList = new ArrayList<>();
        Iterator<HashMap<String, b>> it = this.f926a.values().iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().values());
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized Collection<b> m717a(String str) {
        if (!this.f926a.containsKey(str)) {
            return new ArrayList();
        }
        return ((HashMap) this.f926a.get(str).clone()).values();
    }

    public synchronized b a(String str, String str2) {
        HashMap<String, b> map = this.f926a.get(str);
        if (map == null) {
            return null;
        }
        return map.get(a(str2));
    }

    public synchronized void a(Context context, int i) {
        Iterator<HashMap<String, b>> it = this.f926a.values().iterator();
        while (it.hasNext()) {
            Iterator<b> it2 = it.next().values().iterator();
            while (it2.hasNext()) {
                it2.next().a(c.unbind, 2, i, (String) null, (String) null);
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized int m715a() {
        return this.f926a.size();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized void m719a() {
        Iterator<b> it = m716a().iterator();
        while (it.hasNext()) {
            it.next().m723a();
        }
        this.f926a.clear();
    }

    public synchronized void a(Context context) {
        Iterator<HashMap<String, b>> it = this.f926a.values().iterator();
        while (it.hasNext()) {
            Iterator<b> it2 = it.next().values().iterator();
            while (it2.hasNext()) {
                it2.next().a(c.unbind, 1, 3, (String) null, (String) null);
            }
        }
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int iIndexOf = str.indexOf("@");
        return iIndexOf > 0 ? str.substring(0, iIndexOf) : str;
    }

    public synchronized void a(a aVar) {
        this.f927a.add(aVar);
    }
}
