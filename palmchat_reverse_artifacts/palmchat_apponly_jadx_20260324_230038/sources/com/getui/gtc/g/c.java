package com.getui.gtc.g;

import android.text.TextUtils;
import com.getui.gtc.api.SdkInfo;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.util.ScheduleQueue;
import com.getui.gtc.e.c;
import com.getui.gtc.entity.a;
import com.getui.gtc.f.c;
import com.getui.gtc.f.e;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f5781a;
    String b;
    final Map<String, a.C0343a> c;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f5787a = new c(0);
    }

    private c() {
        this.c = new HashMap();
        try {
            this.f5781a = GtcProvider.context().getFilesDir().getAbsolutePath();
            File file = new File(this.f5781a);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.b = this.f5781a + File.separator + "libs";
            File file2 = new File(this.b);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            HashSet<String> hashSet = new HashSet(c.a.f5766a.f5765a.n);
            for (String str : hashSet) {
                if (a(str)) {
                    c.a.f5766a.f5765a.f(str);
                    com.getui.gtc.i.c.a.a("remove: ".concat(String.valueOf(hashSet)));
                }
            }
            com.getui.gtc.dyc.b.a.a(GtcProvider.context(), new e() { // from class: com.getui.gtc.g.c.1
                @Override // com.getui.gtc.f.e
                public final void a(String str2) {
                }

                @Override // com.getui.gtc.f.e
                public final void a(Map<String, String> map, Map<String, String> map2) {
                    if (map == null || map2 == null) {
                        return;
                    }
                    com.getui.gtc.entity.a aVarA = com.getui.gtc.entity.a.a(map2);
                    com.getui.gtc.entity.a aVarA2 = com.getui.gtc.entity.a.a(map);
                    if (aVarA2 != null) {
                        int size = aVarA2.f5769a.size();
                        HashSet hashSet2 = new HashSet();
                        for (int i = 0; i < size; i++) {
                            a.C0343a c0343aA = aVarA2.a(i);
                            if (aVarA == null || aVarA.b(c0343aA.f5770a) == null || !aVarA.b(c0343aA.f5770a).b.equalsIgnoreCase(c0343aA.b) || !aVarA.b(c0343aA.f5770a).c.equalsIgnoreCase(c0343aA.c)) {
                                hashSet2.add(c0343aA.c);
                            }
                        }
                        com.getui.gtc.i.c.a.a("wait remove: ".concat(String.valueOf(hashSet2)));
                        c.a.f5766a.f5765a.a(hashSet2);
                    }
                    if (aVarA != null) {
                        int size2 = aVarA.f5769a.size();
                        for (int i2 = 0; i2 < size2; i2++) {
                            a.C0343a c0343aA2 = aVarA.a(i2);
                            if (!c.this.a(c0343aA2)) {
                                try {
                                    com.getui.gtc.h.b.a(c0343aA2, c.this.b + File.separator + c0343aA2.c);
                                } catch (Exception e) {
                                    com.getui.gtc.i.c.a.b(e);
                                }
                            }
                        }
                    }
                }
            }.c);
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.c(th);
        }
    }

    private void b(SdkInfo sdkInfo) {
        List<a.C0343a> stubs = sdkInfo.getStubs();
        for (int i = 0; i < stubs.size(); i++) {
            final a.C0343a c0343a = stubs.get(i);
            if (!b(c0343a)) {
                this.c.put(c0343a.d, c0343a);
                if (c0343a.j) {
                    b.a(GtcProvider.context(), null, null, c0343a.d, sdkInfo.getAppid(), sdkInfo.getCid(), new com.getui.gtc.g.a.b() { // from class: com.getui.gtc.g.c.2
                        @Override // com.getui.gtc.g.a.b
                        public final void a(boolean z) {
                            if (z) {
                                return;
                            }
                            c.this.c.remove(c0343a.d);
                        }
                    });
                } else {
                    try {
                        b.a(GtcProvider.context(), c0343a.d, sdkInfo.getAppid(), sdkInfo.getCid());
                    } catch (Throwable th) {
                        this.c.remove(c0343a.d);
                        com.getui.gtc.i.c.a.b("local gtcFile failed: ".concat(String.valueOf(th)));
                    }
                }
            }
        }
    }

    private com.getui.gtc.entity.a c(final SdkInfo sdkInfo) {
        Map<String, String> mapA = com.getui.gtc.f.c.a(sdkInfo, new c.a() { // from class: com.getui.gtc.g.c.3
            @Override // com.getui.gtc.f.c.a
            public final void a(Map<String, String> map) {
                c.this.a(sdkInfo, com.getui.gtc.entity.a.a(map));
            }
        });
        if (mapA == null) {
            return null;
        }
        return com.getui.gtc.entity.a.a(mapA);
    }

    public final String a(SdkInfo sdkInfo, a.C0343a c0343a) {
        com.getui.gtc.entity.a aVarA;
        a.C0343a c0343aB;
        File file = new File(this.b + File.separator + c0343a.c);
        if (a(c0343a)) {
            return file.getAbsolutePath();
        }
        try {
            Map<String, String> mapA = com.getui.gtc.dyc.b.a.a(GtcProvider.context(), sdkInfo.getModuleName());
            if (mapA == null || (aVarA = com.getui.gtc.entity.a.a(mapA)) == null || (c0343aB = aVarA.b(c0343a.f5770a)) == null || !c0343aB.e.equals(c0343a.e)) {
                return null;
            }
            com.getui.gtc.h.b.a(c0343a, file.getAbsolutePath());
            if (com.getui.gtc.i.b.a.a(file.getAbsolutePath()).equals(c0343a.e)) {
                return file.getAbsolutePath();
            }
            com.getui.gtc.i.b.a.a(file);
            throw new Exception("The net gtcFile save failed or has a wrong checksum");
        } catch (Exception e) {
            com.getui.gtc.i.c.a.b(e);
            return null;
        }
    }

    public /* synthetic */ c(byte b) {
        this();
    }

    private boolean b(a.C0343a c0343a) {
        return this.c.containsKey(c0343a.d);
    }

    private static boolean c(a.C0343a c0343a) {
        c0343a.d.endsWith(".gws.stub.PushExtension");
        return false;
    }

    public final void a(SdkInfo sdkInfo) {
        b(sdkInfo);
        a(sdkInfo, c(sdkInfo));
    }

    public final void a(final SdkInfo sdkInfo, com.getui.gtc.entity.a aVar) {
        if (aVar == null) {
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList();
        for (int i = 0; i < aVar.f5769a.size(); i++) {
            final a.C0343a c0343aA = aVar.a(i);
            if (!aVar.b && c(c0343aA)) {
                com.getui.gtc.i.c.a.a("no push, no gws");
            } else if (!b(c0343aA)) {
                final long jA = c.a.f5766a.b.a(c0343aA.f5770a);
                if ((c0343aA.g <= 0 || jA <= 0 || System.currentTimeMillis() - jA <= c0343aA.g) && (jA <= 0 || !c0343aA.i)) {
                    this.c.put(c0343aA.d, c0343aA);
                    ScheduleQueue.getInstance().addSchedule(new Runnable() { // from class: com.getui.gtc.g.c.4
                        @Override // java.lang.Runnable
                        public final void run() throws Throwable {
                            String strA = c.this.a(sdkInfo, c0343aA);
                            if (strA == null) {
                                c.this.c.remove(c0343aA.d);
                                return;
                            }
                            File file = new File(strA);
                            final File file2 = new File(strA + com.getui.gtc.c.a.b);
                            com.getui.gtc.i.a.a.a(file, file2, c0343aA.f);
                            if (c0343aA.j) {
                                b.a(GtcProvider.context(), file2.getAbsolutePath(), c.this.f5781a, c0343aA.d, sdkInfo.getAppid(), sdkInfo.getCid(), new com.getui.gtc.g.a.b() { // from class: com.getui.gtc.g.c.4.1
                                    @Override // com.getui.gtc.g.a.b
                                    public final void a(boolean z) {
                                        com.getui.gtc.i.b.a.a(file2);
                                        if (!z) {
                                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                            c.this.c.remove(c0343aA.d);
                                        } else if (jA == 0) {
                                            c.a.f5766a.b.a(c0343aA.f5770a, System.currentTimeMillis());
                                        }
                                    }
                                });
                                return;
                            }
                            try {
                                b.a(GtcProvider.context(), file2.getAbsolutePath(), c.this.f5781a, c0343aA.d, sdkInfo.getAppid(), sdkInfo.getCid());
                                if (jA == 0) {
                                    c.a.f5766a.b.a(c0343aA.f5770a, System.currentTimeMillis());
                                }
                            } catch (Throwable th) {
                                try {
                                    c.this.c.remove(c0343aA.d);
                                    com.getui.gtc.i.c.a.b("net gtcFile filed: ".concat(String.valueOf(th)));
                                } finally {
                                    com.getui.gtc.i.b.a.a(file2);
                                }
                            }
                        }
                    });
                } else {
                    arrayList.add(Integer.valueOf(i));
                }
            }
        }
        for (Integer num : arrayList) {
            a(aVar.a(num.intValue()).c);
            aVar.c(num.intValue());
        }
    }

    public final boolean a(a.C0343a c0343a) {
        File file = new File(this.b + File.separator + c0343a.c);
        if (file.exists() && file.isFile()) {
            return com.getui.gtc.i.b.a.a(file.getAbsolutePath()).equals(c0343a.e);
        }
        return false;
    }

    public final boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            com.getui.gtc.i.b.a.a(this.f5781a, str);
            String strA = com.getui.gtc.g.a.a(str);
            if (TextUtils.isEmpty(strA)) {
                return true;
            }
            com.getui.gtc.i.b.a.a(new File(this.f5781a + "/" + strA));
            return true;
        } catch (Exception e) {
            com.getui.gtc.i.c.a.c(e);
            return false;
        }
    }
}
