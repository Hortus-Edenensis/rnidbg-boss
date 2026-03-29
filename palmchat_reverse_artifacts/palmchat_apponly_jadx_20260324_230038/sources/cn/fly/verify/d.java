package cn.fly.verify;

import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Boolean f2169a;
    private static byte[] b;
    private static ArrayList<HashMap<String, Object>> c;
    private static ExecutorService d = Executors.newSingleThreadExecutor();

    private static ArrayList<HashMap<String, Object>> f() {
        try {
            String strE = aq.e();
            if (TextUtils.isEmpty(strE)) {
                return null;
            }
            String[] strArrSplit = strE.split("&&");
            if (strArrSplit.length != 2) {
                aq.b((String) null);
                return null;
            }
            String str = strArrSplit[0];
            return (ArrayList) new fu().a(an.b(as.c(str), strArrSplit[1]).trim(), ArrayList.class);
        } catch (Throwable th) {
            f.a().a(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean g() {
        Boolean bool;
        if (f2169a == null) {
            File file = new File(ax.g().getFilesDir(), ".preverfy_xhs");
            if (file.exists()) {
                bool = Boolean.FALSE;
            } else {
                try {
                    file.createNewFile();
                } catch (IOException unused) {
                }
                bool = Boolean.TRUE;
            }
            f2169a = bool;
        }
        return f2169a.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h() {
        if (c == null) {
            ArrayList<HashMap<String, Object>> arrayListF = f();
            c = arrayListF;
            if (arrayListF == null) {
                c = new ArrayList<>();
            }
        }
    }

    private static byte[] i() {
        if (b == null) {
            try {
                b = an.a();
            } catch (Throwable th) {
                f.a().a(th);
            }
        }
        return b;
    }

    public static ExecutorService a() {
        return d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HashMap<String, Object> b(c cVar, boolean z) {
        cVar.a(z);
        return h.a().a(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(ArrayList<HashMap<String, Object>> arrayList) {
        try {
            String strA = new fu().a(arrayList);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            String[] strArrA = an.a(i(), strA);
            aq.b(strArrA[0] + "&&" + strArrA[1]);
        } catch (Throwable th) {
            f.a().a(th);
            aq.b((String) null);
        }
    }

    public static void a(final c cVar) {
        d.execute(new Runnable() { // from class: cn.fly.verify.d.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    HashMap<String, Object> map = new HashMap<>();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(d.b(cVar, d.g()));
                    map.put("list", arrayList);
                    try {
                        j.a(false).a(map, i.a(4) + "api/log");
                        f.a().a("forceUploadLog: " + cVar.c() + "," + cVar.d());
                    } catch (Throwable th) {
                        f.a().a(th);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static void b() {
        d.execute(new Runnable() { // from class: cn.fly.verify.d.1
            @Override // java.lang.Runnable
            public void run() {
                List listSubList;
                try {
                    int iM = ai.a().m();
                    if (iM != 1) {
                        f.a().a("cancel upload, logSwitch: " + iM);
                        return;
                    }
                    d.h();
                    if (d.c.isEmpty()) {
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    int size = d.c.size();
                    f.a().a("upload check total size: " + size);
                    if (size > 100) {
                        int i = size - 1;
                        listSubList = d.c.subList(i - 100, i);
                    } else {
                        listSubList = d.c;
                    }
                    arrayList.addAll(listSubList);
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("list", arrayList);
                    try {
                        j.a(false).a(map, i.a(4) + "api/log");
                        if (size > 100) {
                            d.c.removeAll(arrayList);
                            d.c(d.c);
                            f.a().a("upload size: " + arrayList.size() + ", remain size: " + d.c.size());
                        } else {
                            ArrayList unused = d.c = null;
                            aq.b((String) null);
                        }
                    } catch (Throwable th) {
                        f.a().a(th);
                    }
                } catch (Throwable th2) {
                    f.a().a(th2);
                }
            }
        });
    }

    public static void b(final c cVar) {
        d.execute(new Runnable() { // from class: cn.fly.verify.d.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (aq.f()) {
                        f.a().a("del log");
                        d.a(new e(g.LOG).b("delLog"));
                    }
                    if (ai.a().m() != -1) {
                        d.h();
                        d.c.add(d.b(cVar, d.g()));
                        d.c(d.c);
                    }
                } catch (Throwable th) {
                    f.a().a(th);
                }
            }
        });
    }
}
