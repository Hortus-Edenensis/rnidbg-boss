package cn.fly.verify;

import android.os.Message;
import android.text.TextUtils;
import cn.fly.verify.fq;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class dr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f2193a = ed.a("004OfddcfhFg");
    private static dr b;
    private fk c;
    private String f;
    private SimpleDateFormat d = new SimpleDateFormat(ed.a("025.dkdkdkdkhkhchchkdcdciffjfjJkKdfdf-k9fhfhfdejejejifgc"));
    private HashMap<String, Object> e = new HashMap<>();
    private String g = ed.a("008TfhfedjdhUed2dfEf");
    private Runnable h = new gh() { // from class: cn.fly.verify.dr.1
        @Override // cn.fly.verify.gh
        public void a() {
            if (by.c()) {
                dr.this.b();
            }
        }
    };

    private dr() {
        this.f = null;
        this.f = UUID.randomUUID().toString();
    }

    public static synchronized dr a() {
        if (b == null) {
            b = new dr();
        }
        return b;
    }

    private void c() {
        if (this.c == null) {
            this.c = new fk(1024, "ab0a0a6473d1891d388773574764b239d4ad80cb2fd3a83d81d03901c1548c13fee7c9692c326e6682b239d4c5d0021d1b607642c47ec29f10b0602908c3e6c9", "23c3c8cb41c47dd288cc7f4c218fbc7c839a34e0a0d1b2130e87b7914936b120a2d6570ee7ac66282328d50f2acfd82f2259957c89baea32547758db05de9cd7c6822304c8e45742f24bbbe41c1e12f09e18c6fab4d078065f2e5aaed94c900c66e8bbf8a120eefa7bd1fb52114d529250084f5f6f369ed4ce9645978dd30c51");
        }
    }

    private File d() {
        return new File(fz.h(ax.g()), f2193a);
    }

    private String a(Throwable th) {
        if (th == null) {
            return "";
        }
        Throwable cause = th;
        while (true) {
            StringWriter stringWriter = null;
            if (cause != null) {
                try {
                    if (cause instanceof UnknownHostException) {
                        eg.a(null);
                        return "";
                    }
                    cause = cause.getCause();
                } catch (Throwable th2) {
                    th = th2;
                }
            } else {
                StringWriter stringWriter2 = new StringWriter();
                try {
                    PrintWriter printWriter = new PrintWriter(stringWriter2);
                    th.printStackTrace(printWriter);
                    printWriter.flush();
                    String string = stringWriter2.toString();
                    eg.a(stringWriter2);
                    return string;
                } catch (Throwable th3) {
                    th = th3;
                    stringWriter = stringWriter2;
                }
            }
            th = th2;
            try {
                if (th instanceof OutOfMemoryError) {
                    String strA = ed.a("023Iee!fi6ej9idc+dlekdjVdcfFejWi djdiSe)eeifededdf");
                    eg.a(stringWriter);
                    return strA;
                }
                String message = th.getMessage();
                eg.a(stringWriter);
                return message;
            } catch (Throwable th4) {
                eg.a(stringWriter);
                throw th4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        boolean zA;
        File[] fileArrListFiles;
        if (this.e.size() > 0) {
            zA = a(this.e);
            if (!zA) {
                c(this.e);
            }
            this.e.clear();
        } else {
            zA = true;
        }
        if (zA) {
            File fileD = d();
            if (!fileD.exists() || !fileD.isDirectory() || (fileArrListFiles = fileD.listFiles()) == null || fileArrListFiles.length <= 0) {
                return;
            }
            for (File file : fileArrListFiles) {
                if (a((HashMap<String, Object>) fz.a(file.getAbsolutePath())) && !file.delete()) {
                    file.delete();
                }
            }
        }
    }

    private void c(HashMap<String, Object> map) {
        File[] fileArrListFiles;
        try {
            File fileD = d();
            if (!fileD.exists() || !fileD.isDirectory()) {
                fileD.delete();
                fileD.mkdirs();
            }
            StringBuilder sb = new StringBuilder();
            String str = f2193a;
            sb.append(str);
            sb.append("_");
            int i = 0;
            sb.append(0);
            File file = new File(fileD, sb.toString());
            if (file.exists() && (fileArrListFiles = fileD.listFiles()) != null && fileArrListFiles.length > 0) {
                file = new File(fileD, str + "_0");
                while (file.exists()) {
                    i++;
                    file = new File(fileD, f2193a + "_" + i);
                }
            }
            fz.a(file.getPath(), (Object) map);
        } catch (Throwable th) {
            en.a().a(th);
        }
    }

    private boolean b(HashMap<String, Object> map) throws Throwable {
        if (map == null || map.isEmpty()) {
            return true;
        }
        HashMap<String, Object> mapD = ef.d();
        mapD.put(ed.a("006fNdjdjeddjfh"), map);
        c();
        HashMap map2 = (HashMap) this.c.b(false, av.a(), mapD, dt.a().a("dtc") + "/v2/sdrl", true);
        return map2 == null || map2.isEmpty();
    }

    public synchronized void a(int i, int i2, String str, String str2) {
        a(i, i2, null, str, str2);
    }

    public synchronized void a(int i, int i2, Throwable th, String str) {
        a(i, i2, th, null, str);
    }

    private synchronized void a(int i, int i2, Throwable th, String str, String str2) {
        if (th == null) {
            en.a().a(str, new Object[0]);
        } else {
            en.a().a(th);
        }
        if (dp.a()) {
            return;
        }
        final Message message = new Message();
        message.what = 1;
        message.arg1 = 1;
        Object[] objArr = new Object[5];
        objArr[0] = Long.valueOf(System.currentTimeMillis());
        Object obj = th;
        if (th == null) {
            obj = str;
        }
        objArr[1] = obj;
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = str2;
        message.obj = objArr;
        ek.d.execute(new gh() { // from class: cn.fly.verify.dr.2
            @Override // cn.fly.verify.gh
            public void a() {
                dr.this.a(message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        if (this.e.size() > 10) {
            c(this.e);
            this.e.clear();
        }
        Object[] objArr = (Object[]) message.obj;
        this.e.put(ed.a("0027fhdc"), this.f);
        ArrayList arrayList = (ArrayList) this.e.get(ed.a("004g]difh-i"));
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        HashMap map = new HashMap();
        map.put(ed.a("002ci"), objArr[0]);
        Object obj = objArr[1];
        String strA = obj instanceof Throwable ? a((Throwable) obj) : String.valueOf(obj);
        if (!TextUtils.isEmpty(strA)) {
            strA = strA.replaceAll("\r\n\t", " ").replaceAll("\n\t", " ").replaceAll("\n", " ");
        }
        map.put(ed.a("002(dfee"), "[" + this.d.format(objArr[0]) + "][" + objArr[2] + "][" + objArr[3] + "][" + objArr[4] + "] " + strA);
        map.put(ed.a("002fi"), objArr[2]);
        map.put(ed.a("002j)ed"), objArr[3]);
        map.put(this.g, objArr[4]);
        arrayList.add(map);
        this.e.put(ed.a("004gGdifhGi"), arrayList);
        if (dp.a()) {
            return;
        }
        fq.a(ax.g()).a(new fq.a() { // from class: cn.fly.verify.dr.3
            @Override // cn.fly.verify.fq.a
            public void a(fq.b bVar) {
                bq.a().c(10L, dr.this.h);
            }
        });
    }

    private boolean a(HashMap<String, Object> map) {
        try {
            return b(map);
        } catch (Throwable th) {
            en.a().a(th);
            try {
                return b(map);
            } catch (Throwable th2) {
                en.a().a(th2);
                return false;
            }
        }
    }
}
