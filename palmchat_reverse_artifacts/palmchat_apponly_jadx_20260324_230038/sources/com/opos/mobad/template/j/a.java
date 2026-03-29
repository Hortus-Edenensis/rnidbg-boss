package com.opos.mobad.template.j;

import android.view.View;
import com.opos.mobad.template.a;
import com.opos.mobad.template.cmn.baseview.e;
import com.opos.mobad.template.cmn.baseview.f;
import com.opos.mobad.template.cmn.p;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class a implements com.opos.mobad.template.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f10164a;
    protected a.InterfaceC0778a e;
    private long i;
    private p b = new p() { // from class: com.opos.mobad.template.j.a.2
        @Override // com.opos.mobad.template.cmn.p
        public void b(View view, int[] iArr) {
            if (a.this.i()) {
                a.this.h(view, iArr);
                return;
            }
            com.opos.cmn.an.f.a.b("TemplateState", "mOnExtClickListener = isShowing " + a.this.i() + "," + a.this.d.a());
        }
    };
    private f c = new f() { // from class: com.opos.mobad.template.j.a.3
        @Override // com.opos.mobad.template.cmn.baseview.f
        public void a(View view, int i, boolean z) {
            com.opos.cmn.an.f.a.a("TemplateState", "onMockEventIntercepted->clickMockEvent:" + i + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
            a.this.a(view, i, z);
        }
    };
    private p g = new p() { // from class: com.opos.mobad.template.j.a.4
        @Override // com.opos.mobad.template.cmn.p
        public void b(View view, int[] iArr) {
            if (a.this.i()) {
                a.this.a(view, iArr);
                return;
            }
            com.opos.cmn.an.f.a.b("TemplateState", "mOnCloseClickListener = isShowing " + a.this.i() + "," + a.this.d.a());
        }
    };
    private p h = new p() { // from class: com.opos.mobad.template.j.a.5
        @Override // com.opos.mobad.template.cmn.p
        public void b(View view, int[] iArr) {
            if (a.this.i()) {
                a.this.g(view, iArr);
                return;
            }
            com.opos.cmn.an.f.a.b("TemplateState", "mOnBtnClickListener = isShowing " + a.this.i() + "," + a.this.d.a());
        }
    };
    protected boolean f = false;
    protected C0801a d = j();

    /* JADX INFO: renamed from: com.opos.mobad.template.j.a$16, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass16 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f10174a;

        public AnonymousClass16(Map map) {
            this.f10174a = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.d.a() < 3) {
                a.this.d.a(3, new Callable<Boolean>() { // from class: com.opos.mobad.template.j.a.16.1
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Boolean call() throws Exception {
                        com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.j.a.16.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass16 anonymousClass16 = AnonymousClass16.this;
                                a.InterfaceC0778a interfaceC0778a = a.this.e;
                                if (interfaceC0778a != null) {
                                    interfaceC0778a.a(anonymousClass16.f10174a);
                                }
                            }
                        });
                        return Boolean.TRUE;
                    }
                });
                return;
            }
            com.opos.cmn.an.f.a.b("TemplateState", "current state has showing ,no need to onShow = " + a.this.d.a());
        }
    }

    /* JADX INFO: renamed from: com.opos.mobad.template.j.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0801a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Map<Integer, Set<Integer>> f10188a;
        private AtomicInteger b;

        /* JADX INFO: renamed from: com.opos.mobad.template.j.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C0802a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f10189a;
            private Map<Integer, Set<Integer>> b = new HashMap();

            public C0802a(int i) {
                this.f10189a = i;
            }

            public C0802a a(int i, int i2) {
                Set<Integer> hashSet = this.b.get(Integer.valueOf(i));
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    this.b.put(Integer.valueOf(i), hashSet);
                }
                hashSet.add(Integer.valueOf(i2));
                return this;
            }

            public C0802a a(int i, int... iArr) {
                if (iArr == null) {
                    return this;
                }
                Set<Integer> hashSet = this.b.get(Integer.valueOf(i));
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    this.b.put(Integer.valueOf(i), hashSet);
                }
                for (int i2 : iArr) {
                    hashSet.add(Integer.valueOf(i2));
                }
                return this;
            }

            public C0801a a() {
                return new C0801a(this.f10189a, this.b);
            }
        }

        public C0801a(int i, Map<Integer, Set<Integer>> map) {
            this.b = new AtomicInteger(i);
            a(map);
        }

        public int a() {
            return this.b.get();
        }

        private int a(int i, int i2, Callable<Boolean> callable) {
            try {
                if (!callable.call().booleanValue()) {
                    a("execute fail");
                    return i;
                }
                if (!this.b.compareAndSet(i, i2)) {
                    a("unexpected fail");
                    b();
                }
                return i2;
            } catch (Exception e) {
                a("call exception :" + e);
                return i;
            }
        }

        public int a(int i, Callable<Boolean> callable) {
            StringBuilder sb;
            String str;
            a("changeToStateBy:" + i + ", callable = " + callable + ", mCurrentState:" + this.b.get());
            int i2 = this.b.get();
            if (i2 == i) {
                sb = new StringBuilder();
                str = "changeToStateBy but now target:";
            } else {
                if (a(i2, i)) {
                    if (callable != null) {
                        return a(i2, i, callable);
                    }
                    if (!this.b.compareAndSet(i2, i)) {
                        b();
                    }
                    return i;
                }
                sb = new StringBuilder();
                str = "changeToStateBy but target is not enable:";
            }
            sb.append(str);
            sb.append(i);
            a(sb.toString());
            return i2;
        }

        private static final void a(String str) {
            com.opos.cmn.an.f.a.b("TemplateStateController", str);
        }

        private void a(Map<Integer, Set<Integer>> map) {
            if (map == null || map.isEmpty()) {
                return;
            }
            this.f10188a = new HashMap();
            for (Integer num : map.keySet()) {
                Set<Integer> set = map.get(num);
                if (set != null && !set.isEmpty()) {
                    this.f10188a.put(num, new HashSet(map.get(num)));
                }
            }
        }

        private boolean a(int i, int i2) {
            String str;
            Map<Integer, Set<Integer>> map = this.f10188a;
            if (map == null) {
                str = "checkEnable but mController = null";
            } else if (!map.containsKey(Integer.valueOf(i))) {
                str = "checkEnable but error current state:" + i;
            } else {
                if (this.f10188a.get(Integer.valueOf(i)).contains(Integer.valueOf(i2))) {
                    return true;
                }
                str = "checkEnable but error next state:" + i + ",to:" + i2;
            }
            a(str);
            return false;
        }

        private void b() {
        }
    }

    public a(int i) {
        this.f10164a = i;
    }

    public static final C0801a j() {
        return new C0801a.C0802a(0).a(0, 2, 1, 8).a(1, 8).a(2, 3, 8).a(3, 4, 5, 8).a(4, 7, 6, 1, 8).a(5, 7, 6, 1, 8).a(7, 4, 5, 8).a(6, 5, 8).a();
    }

    public void c(final long j, final long j2) {
        com.opos.cmn.an.f.a.b("TemplateState", "onProgress = " + j + "," + j2 + "," + this.d.a());
        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.j.a.8
            @Override // java.lang.Runnable
            public void run() {
                int iA = a.this.d.a();
                if (iA == 4 || iA == 5) {
                    a aVar = a.this;
                    if (aVar.f) {
                        aVar.d(j, aVar.i);
                        return;
                    }
                    aVar.i = j2;
                    a aVar2 = a.this;
                    aVar2.f = true;
                    aVar2.d(0L, aVar2.i);
                }
            }
        });
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        this.d.a(8, new Callable<Boolean>() { // from class: com.opos.mobad.template.j.a.6
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                a.this.h();
                a.this.e = null;
                return Boolean.TRUE;
            }
        });
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        return this.f10164a;
    }

    public void f(View view, int[] iArr) {
        a.InterfaceC0778a interfaceC0778a;
        if (this.d.a() == 8 || (interfaceC0778a = this.e) == null) {
            return;
        }
        interfaceC0778a.d(view, iArr);
    }

    public abstract boolean f();

    public void g(View view, int[] iArr) {
        a.InterfaceC0778a interfaceC0778a;
        if (this.d.a() == 8 || (interfaceC0778a = this.e) == null) {
            return;
        }
        interfaceC0778a.g(view, iArr);
    }

    public abstract boolean g();

    public abstract void h();

    public void h(View view, int[] iArr) {
        a.InterfaceC0778a interfaceC0778a;
        if (this.d.a() == 8 || (interfaceC0778a = this.e) == null) {
            return;
        }
        interfaceC0778a.h(view, iArr);
    }

    public void i(View view, int[] iArr) {
        a.InterfaceC0778a interfaceC0778a;
        if (this.d.a() == 8 || (interfaceC0778a = this.e) == null) {
            return;
        }
        interfaceC0778a.f(view, iArr);
    }

    public void k() {
        this.d.a(4, new Callable<Boolean>() { // from class: com.opos.mobad.template.j.a.12
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                return Boolean.valueOf(a.this.f());
            }
        });
    }

    public void l() {
        this.d.a(7, new Callable<Boolean>() { // from class: com.opos.mobad.template.j.a.13
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                return Boolean.valueOf(a.this.g());
            }
        });
    }

    public void m() {
        a((Callable) null);
    }

    public int n() {
        return this.d.a();
    }

    public void o() {
        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.j.a.10
            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                a.InterfaceC0778a interfaceC0778a = aVar.e;
                if (interfaceC0778a != null) {
                    interfaceC0778a.a(aVar.i, a.this.i);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final long j, final long j2) {
        com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.j.a.9
            @Override // java.lang.Runnable
            public void run() {
                a.InterfaceC0778a interfaceC0778a;
                if (a.this.n() == 8 || (interfaceC0778a = a.this.e) == null) {
                    return;
                }
                interfaceC0778a.d(j, j2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        return n() >= 3 && n() < 8;
    }

    @Override // com.opos.mobad.template.a
    public void a() {
        this.d.a(6, new Callable<Boolean>() { // from class: com.opos.mobad.template.j.a.11
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                return Boolean.valueOf(a.this.g());
            }
        });
    }

    @Override // com.opos.mobad.template.a
    public void b() {
        this.d.a(5, new Callable<Boolean>() { // from class: com.opos.mobad.template.j.a.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                return Boolean.valueOf(a.this.f());
            }
        });
    }

    public void c(View view, int[] iArr) {
        a.InterfaceC0778a interfaceC0778a;
        if (this.d.a() == 8 || (interfaceC0778a = this.e) == null) {
            return;
        }
        interfaceC0778a.j(view, iArr);
    }

    public void e(View view, int[] iArr) {
        a.InterfaceC0778a interfaceC0778a;
        if (this.d.a() == 8 || (interfaceC0778a = this.e) == null) {
            return;
        }
        interfaceC0778a.b(view, iArr);
    }

    public void j(View view, int[] iArr) {
        a.InterfaceC0778a interfaceC0778a;
        if (this.d.a() == 8 || (interfaceC0778a = this.e) == null) {
            return;
        }
        interfaceC0778a.a(view, iArr);
    }

    public void k(View view, int[] iArr) {
        a.InterfaceC0778a interfaceC0778a;
        if (this.d.a() == 8 || (interfaceC0778a = this.e) == null) {
            return;
        }
        interfaceC0778a.l(view, iArr);
    }

    public void l(View view, int[] iArr) {
        if (i()) {
            d(view, iArr);
            return;
        }
        com.opos.cmn.an.f.a.b("TemplateState", "onPermissionClickWithState = isShowing " + i() + "," + this.d.a());
    }

    public void m(View view, int[] iArr) {
        if (i()) {
            e(view, iArr);
            return;
        }
        com.opos.cmn.an.f.a.b("TemplateState", "onPrivacyClickWithState = isShowing " + i() + "," + this.d.a());
    }

    public void n(View view, int[] iArr) {
        if (i()) {
            f(view, iArr);
            return;
        }
        com.opos.cmn.an.f.a.b("TemplateState", "onIntroduceClickWithState = isShowing " + i() + "," + this.d.a());
    }

    public void a(final int i) {
        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.j.a.14
            @Override // java.lang.Runnable
            public void run() {
                a.this.d.a(1, new Callable<Boolean>() { // from class: com.opos.mobad.template.j.a.14.1
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Boolean call() throws Exception {
                        AnonymousClass14 anonymousClass14 = AnonymousClass14.this;
                        a.InterfaceC0778a interfaceC0778a = a.this.e;
                        if (interfaceC0778a != null) {
                            interfaceC0778a.a(i);
                        }
                        return Boolean.TRUE;
                    }
                });
            }
        });
    }

    public void b(int i) {
        a.InterfaceC0778a interfaceC0778a;
        if (this.d.a() == 8 || (interfaceC0778a = this.e) == null) {
            return;
        }
        interfaceC0778a.c(i);
    }

    public void c(final Map<String, String> map) {
        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.j.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.d.a(1, new Callable<Boolean>() { // from class: com.opos.mobad.template.j.a.7.1
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Boolean call() throws Exception {
                        AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                        a.InterfaceC0778a interfaceC0778a = a.this.e;
                        if (interfaceC0778a != null) {
                            interfaceC0778a.b(map);
                        }
                        return Boolean.TRUE;
                    }
                });
            }
        });
    }

    public void d(View view, int[] iArr) {
        a.InterfaceC0778a interfaceC0778a;
        if (this.d.a() == 8 || (interfaceC0778a = this.e) == null) {
            return;
        }
        interfaceC0778a.c(view, iArr);
    }

    public void a(int i, int[] iArr) {
        a.InterfaceC0778a interfaceC0778a;
        if (this.d.a() == 8 || (interfaceC0778a = this.e) == null) {
            return;
        }
        interfaceC0778a.a(i, iArr);
    }

    public void b(long j, long j2) {
        a.InterfaceC0778a interfaceC0778a;
        if (this.d.a() == 8 || (interfaceC0778a = this.e) == null) {
            return;
        }
        interfaceC0778a.b(j, j2);
    }

    public void a(long j, long j2) {
        a.InterfaceC0778a interfaceC0778a;
        if (this.d.a() == 8 || (interfaceC0778a = this.e) == null) {
            return;
        }
        interfaceC0778a.c(j, j2);
    }

    public void b(View view) {
        if (this.d.a() == 8) {
            return;
        }
        p.a(view, this.h);
    }

    public void a(View view) {
        if (this.d.a() == 8) {
            return;
        }
        p.a(view, this.b);
    }

    public void b(View view, int[] iArr) {
        a.InterfaceC0778a interfaceC0778a;
        if (this.d.a() == 8 || (interfaceC0778a = this.e) == null) {
            return;
        }
        interfaceC0778a.i(view, iArr);
    }

    public void a(View view, int i, boolean z) {
        a.InterfaceC0778a interfaceC0778a;
        com.opos.cmn.an.f.a.a("TemplateState", "onMockEventIntercepted->clickMockEvent:" + i + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
        if (this.d.a() == 8 || (interfaceC0778a = this.e) == null) {
            return;
        }
        interfaceC0778a.a(view, i, z);
    }

    public void b(final Map<String, String> map) {
        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.j.a.17
            @Override // java.lang.Runnable
            public void run() {
                com.opos.cmn.an.f.a.b("TemplateState", "onShowFocus = " + map);
                a.InterfaceC0778a interfaceC0778a = a.this.e;
                if (interfaceC0778a != null) {
                    interfaceC0778a.a(map);
                }
            }
        });
    }

    public void a(final View view, final int[] iArr) {
        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.j.a.18
            @Override // java.lang.Runnable
            public void run() {
                a.InterfaceC0778a interfaceC0778a = a.this.e;
                if (interfaceC0778a != null) {
                    interfaceC0778a.e(view, iArr);
                }
            }
        });
    }

    public void b(int[] iArr) {
        a.InterfaceC0778a interfaceC0778a;
        if (this.d.a() == 8 || (interfaceC0778a = this.e) == null) {
            return;
        }
        interfaceC0778a.a(iArr);
    }

    public void a(View view, int[] iArr, boolean z) {
        a.InterfaceC0778a interfaceC0778a;
        if (this.d.a() == 8 || (interfaceC0778a = this.e) == null) {
            return;
        }
        interfaceC0778a.a(view, iArr, z);
    }

    @Override // com.opos.mobad.template.a
    public void a(a.InterfaceC0778a interfaceC0778a) {
        this.e = interfaceC0778a;
    }

    public void a(a.b bVar, Map<String, String> map) {
        a.InterfaceC0778a interfaceC0778a;
        if (this.d.a() == 8 || (interfaceC0778a = this.e) == null) {
            return;
        }
        interfaceC0778a.a(bVar, map);
    }

    public void a(e eVar) {
        if (this.d.a() == 8 || eVar == null) {
            return;
        }
        eVar.a(this.c);
    }

    public void a(Map<String, String> map) {
        com.opos.mobad.d.c.c.c(new AnonymousClass16(map));
    }

    public void a(final Callable callable) {
        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.j.a.15
            @Override // java.lang.Runnable
            public void run() {
                a.this.d.a(2, new Callable<Boolean>() { // from class: com.opos.mobad.template.j.a.15.1
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Boolean call() throws Exception {
                        a.InterfaceC0778a interfaceC0778a = a.this.e;
                        if (interfaceC0778a != null) {
                            interfaceC0778a.f();
                        }
                        Callable callable2 = callable;
                        if (callable2 != null) {
                            callable2.call();
                        }
                        return Boolean.TRUE;
                    }
                });
            }
        });
    }

    public void a(int[] iArr) {
        a.InterfaceC0778a interfaceC0778a;
        if (this.d.a() == 8 || (interfaceC0778a = this.e) == null) {
            return;
        }
        interfaceC0778a.b(iArr);
    }
}
