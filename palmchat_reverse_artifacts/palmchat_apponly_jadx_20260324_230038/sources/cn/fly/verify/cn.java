package cn.fly.verify;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import cn.fly.verify.fl;
import cn.fly.verify.fq;
import cn.fly.verify.ga;
import com.lantern.auth.server.WkParams;
import com.oplus.tblplayer.processor.util.EffectConstants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class cn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static cn f2151a;
    private static volatile ga.a b;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a[] f2155a = new a[3];
        private long b;
        private HashMap<String, Object> c;

        private a(long j, HashMap<String, Object> map) {
            this.b = j;
            this.c = map;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static a b(long j, HashMap<String, Object> map) {
            a[] aVarArr = f2155a;
            synchronized (aVarArr) {
                for (int i = 0; i < 3; i++) {
                    a aVar = aVarArr[i];
                    if (aVar != null) {
                        aVar.b = j;
                        HashMap<String, Object> map2 = aVar.c;
                        if (map2 != null) {
                            map2.clear();
                        }
                        aVar.c = map;
                        aVarArr[i] = null;
                        return aVar;
                    }
                }
                return new a(j, map);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ea.a(ea.a(ea.b), new dz() { // from class: cn.fly.verify.cn.a.1
                    @Override // cn.fly.verify.dz
                    public boolean a(fs fsVar) {
                        fq.a(ax.g()).h().a(new fq.a() { // from class: cn.fly.verify.cn.a.1.1
                            @Override // cn.fly.verify.fq.a
                            public void a(fq.b bVar) throws Throwable {
                                b bVarB;
                                ContentValues contentValues = new ContentValues();
                                contentValues.put(ed.a("004i.didfKf"), String.valueOf(a.this.b));
                                if (a.this.c != null) {
                                    a.this.c.put(ed.a("006djj=dl$fLdk"), ef.a());
                                    a.this.c.put(ed.a("006djjj dlee"), fq.d.c());
                                    a.this.c.put(ed.a("006djj'dd.f-dj"), fq.d.f());
                                    long jLongValue = ((Long) by.a(ed.a("010Kfh)iQdj8difDeedkeidc"), 0L)).longValue();
                                    if (jLongValue != 0) {
                                        a.this.c.put(ed.a("010]fh0i-dj%dif0eedkeidc"), Long.valueOf(jLongValue));
                                    }
                                }
                                contentValues.put(ed.a("004Qdc.did"), Base64.encodeToString(fr.a(fr.c(fq.d.k()), fv.a(a.this.c).getBytes("utf-8")), 2));
                                ga.a(cn.b, contentValues);
                                long jLongValue2 = ((Long) by.a(ed.a("004^dc1f?dgXj"), 2L)).longValue();
                                if (ed.a("004e%ed1ef").equals(bVar.h())) {
                                    jLongValue2 = 120;
                                }
                                if (!by.c() || (bVarB = b.b()) == null) {
                                    return;
                                }
                                if (jLongValue2 <= 0) {
                                    bVarB.run();
                                } else {
                                    if (bq.a().a(jLongValue2, bVarB)) {
                                        return;
                                    }
                                    bVarB.c();
                                }
                            }
                        });
                        return false;
                    }
                });
            } finally {
                try {
                } finally {
                }
            }
        }

        private void a() {
            try {
                a[] aVarArr = f2155a;
                synchronized (aVarArr) {
                    for (int i = 0; i < 3; i++) {
                        if (aVarArr[i] == null) {
                            this.b = 0L;
                            HashMap<String, Object> map = this.c;
                            if (map != null) {
                                map.clear();
                            }
                            this.c = null;
                            aVarArr[i] = this;
                            return;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements Runnable {
        private static final b[] b = {new b()};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2158a = false;

        /* JADX INFO: Access modifiers changed from: private */
        public int a(SparseArray<String> sparseArray) {
            try {
                StringBuilder sb = new StringBuilder();
                int size = sparseArray.size();
                for (int i = 0; i < size; i++) {
                    if (sb.length() > 0) {
                        sb.append(", ");
                    }
                    sb.append('\'');
                    sb.append(sparseArray.valueAt(i));
                    sb.append('\'');
                }
                try {
                    return ga.a(cn.b, "time in (" + sb.toString() + ")", null);
                } catch (Throwable th) {
                    en.a().b(th);
                    return ga.a(cn.b, "time in (" + sb.toString() + ")", null);
                }
            } catch (Throwable th2) {
                en.a().b(th2);
                return 0;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b b() {
            b[] bVarArr = b;
            synchronized (bVarArr) {
                b bVar = bVarArr[0];
                if (bVar == null) {
                    return null;
                }
                bVarArr[0] = null;
                if (bVar.f2158a) {
                    bVar.f2158a = false;
                }
                return bVar;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            b[] bVarArr = b;
            synchronized (bVarArr) {
                if (bVarArr[0] == null) {
                    bVarArr[0] = this;
                }
            }
            this.f2158a = false;
        }

        @Override // java.lang.Runnable
        public void run() {
            fq.a(ax.g()).i().h().x().a(new fq.a() { // from class: cn.fly.verify.cn.b.1
                /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
                
                    cn.fly.verify.bq.a().c();
                 */
                @Override // cn.fly.verify.fq.a
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void a(fq.b bVar) {
                    try {
                        String[][] strArr = new String[50][];
                        b bVar2 = b.this;
                        while (true) {
                            int iA = bVar2.a(strArr);
                            if (iA <= 0) {
                                break;
                            }
                            SparseArray sparseArrayA = b.this.a(strArr, iA, bVar);
                            if (sparseArrayA.size() == 0 && b.this.f2158a) {
                                break;
                            }
                            if (sparseArrayA.size() > 0) {
                                b.this.a((SparseArray<String>) sparseArrayA);
                            }
                            if (iA < 50) {
                                break;
                            } else {
                                bVar2 = b.this;
                            }
                        }
                    } finally {
                        b.this.c();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int a(String[][] strArr) {
            long j;
            int i = 0;
            Cursor cursorA = null;
            try {
                cursorA = ga.a(cn.b, new String[]{ed.a("004i=didf.f"), ed.a("0040dc did")}, null, null, "time desc");
                if (cursorA == null) {
                    if (cursorA != null) {
                        try {
                            cursorA.close();
                        } catch (Throwable unused) {
                        }
                    }
                    return 0;
                }
                if (!cursorA.moveToFirst()) {
                    try {
                        cursorA.close();
                    } catch (Throwable unused2) {
                    }
                    return 0;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                int i2 = 0;
                try {
                    do {
                        try {
                            String[] strArr2 = {cursorA.getString(0), cursorA.getString(1)};
                            try {
                                j = Long.parseLong(strArr2[0]);
                            } catch (Throwable unused3) {
                                j = -1;
                            }
                            if (j <= jCurrentTimeMillis) {
                                strArr[i2] = strArr2;
                                i2++;
                            }
                            if (i2 < strArr.length) {
                            }
                            cursorA.close();
                            return i2;
                        } catch (Throwable th) {
                            th = th;
                            i = i2;
                        }
                    } while (cursorA.moveToNext());
                    cursorA.close();
                    return i2;
                } catch (Throwable unused4) {
                    return i2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                en.a().b(th);
                if (cursorA != null) {
                    try {
                        cursorA.close();
                    } catch (Throwable unused5) {
                    }
                }
                return i;
            } catch (Throwable th3) {
                if (cursorA != null) {
                    try {
                        cursorA.close();
                    } catch (Throwable unused6) {
                    }
                }
                throw th3;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SparseArray<String> a(String[][] strArr, int i, fq.b bVar) {
            HashMap<String, Object> map;
            ArrayList arrayList;
            SparseArray<String> sparseArray = new SparseArray<>();
            try {
                map = new HashMap<>();
                map.put(ed.a("004jgdi"), Integer.valueOf(fq.d.e()));
                map.put(ed.a("006IdcSfXdddiYcf"), bVar.i());
                map.put(ed.a("005,dfeddcQfg"), fq.d.j());
                map.put(ed.a("0047dcdgdidc"), dp.a((bd) null));
                map.put(ed.a("011efiZffeddjdlLiYdk'jf"), bVar.h());
                map.put(ed.a("015SdcAdid4eh1fi ffeddjdlekdkCjf"), Integer.valueOf(bVar.x()));
                arrayList = new ArrayList();
                byte[] bArrC = fr.c(fq.d.k());
                for (int i2 = 0; i2 < i; i2++) {
                    String[] strArr2 = strArr[i2];
                    try {
                        HashMap mapA = fv.a(new String(fr.b(bArrC, Base64.decode(strArr2[1], 2)), "utf-8").trim());
                        sparseArray.put(i2, strArr2[0]);
                        arrayList.add(mapA);
                    } catch (Throwable th) {
                        en.a().b(th);
                    }
                }
            } catch (Throwable th2) {
                en.a().b(th2);
            }
            if (arrayList.isEmpty()) {
                return new SparseArray<>();
            }
            map.put(ed.a("005[dcUdidWfh"), arrayList);
            map.put(ed.a("005i-eddl;fe"), bw.a().b());
            HashMap<String, String> map2 = new HashMap<>();
            map2.put(ed.a("013Tegfh@fQdjhkeidcTfei<di(i_dk"), bu.c());
            map2.put(ed.a("004Tdfeddidc"), er.a(ax.g()).d().ai());
            fl.a aVar = new fl.a();
            aVar.f2355a = 30000;
            aVar.b = 30000;
            if (!"200".equals(String.valueOf(fv.a((String) new fk(1024, "ceeef5035212dfe7c6a0acdc0ef35ce5b118aab916477037d7381f85c6b6176fcf57b1d1c3296af0bb1c483fe5e1eb0ce9eb2953b44e494ca60777a1b033cc07", "191737288d17e660c4b61440d5d14228a0bf9854499f9d68d8274db55d6d954489371ecf314f26bec236e58fac7fffa9b27bcf923e1229c4080d49f7758739e5bd6014383ed2a75ce1be9b0ab22f283c5c5e11216c5658ba444212b6270d629f2d615b8dfdec8545fb7d4f935b0cc10b6948ab4fc1cb1dd496a8f94b51e888dd", aVar).b(false, map2, map, dt.a().a("gclg") + "/v6/gcl", false)).get(ed.a("006Cfh-idiKdgfh"))))) {
                sparseArray.clear();
            }
            return sparseArray;
        }
    }

    private cn() {
        try {
            Context contextG = ax.g();
            String str = dx.f2209a;
            File fileA = fz.a(contextG, str, true);
            if (fileA.exists() && fileA.length() > 209715200) {
                fileA.delete();
                fileA = fz.a(ax.g(), str, true);
            }
            b = ga.a(fileA.getAbsolutePath(), ed.a("008HfkJdid)fjFfdj") + "_1");
            b.a(ed.a("004i'didf_f"), ed.a("004if6ec$i"), true);
            b.a(ed.a("004(dc$did"), ed.a("004ifEec:i"), true);
            b bVarB = b.b();
            if (bVarB != null) {
                bq.a().a(0L, EffectConstants.ROTATION_DEGREES_180, bVarB);
            }
        } catch (Throwable th) {
            en.a().b(th);
        }
    }

    public static synchronized cn a() {
        if (f2151a == null) {
            f2151a = new cn();
        }
        return f2151a;
    }

    public static String a(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] < ei.f().length()) {
                sb.append((char) (r2.charAt(iArr[i]) - 2));
            }
        }
        return sb.toString();
    }

    private static File b(Object... objArr) throws Throwable {
        int i;
        InputStream fileInputStream;
        File file;
        FileOutputStream fileOutputStream;
        ds dsVarA;
        String str = (String) objArr[0];
        String str2 = (String) objArr[1];
        String str3 = (String) objArr[4];
        String str4 = (String) objArr[5];
        InputStream inputStream = null;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            File file2 = new File(ax.g().getFilesDir(), ed.a("003)fh:cc"));
            byte[] bArr = (byte[]) objArr[2];
            try {
                i = Integer.parseInt(String.valueOf(objArr[3]));
            } catch (Throwable unused) {
                i = 0;
            }
            if (bArr == null || i <= 0 || bArr.length < i || !str.equals(fr.b(bArr, 0, i))) {
                File file3 = new File(file2, ed.a("008c8ed>e4effdfhRcc"));
                if (file3.exists() && str.equals(fr.a(file3))) {
                    fileInputStream = new FileInputStream(file3);
                } else {
                    ds.a().a(20);
                    file3.delete();
                    fileInputStream = null;
                }
            } else {
                fileInputStream = new ByteArrayInputStream(bArr, 0, i);
            }
            if (fileInputStream != null) {
                try {
                    file = new File(file2, String.valueOf(System.currentTimeMillis()));
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    File file4 = new File(file, file.getName() + ed.a("004JfdgcdiMj"));
                    try {
                        fileOutputStream = new FileOutputStream(file4);
                        try {
                            fr.a(str2, fileInputStream, fileOutputStream);
                            eg.a(fileInputStream, fileOutputStream);
                            try {
                                if (du.a().b()) {
                                    ds.a().a(14);
                                    bh.a(str, file4, str3, str4);
                                } else {
                                    ds.a().a(19);
                                }
                                try {
                                    fz.a(file);
                                } catch (Throwable th) {
                                    th = th;
                                    dsVarA = ds.a();
                                    dsVarA.a(4, th);
                                }
                            } catch (Throwable th2) {
                                try {
                                    ds.a().a(6, th2);
                                    try {
                                        fz.a(file);
                                    } catch (Throwable th3) {
                                        th = th3;
                                        dsVarA = ds.a();
                                        dsVarA.a(4, th);
                                    }
                                } finally {
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            eg.a(fileInputStream, fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = null;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    inputStream = fileInputStream;
                    eg.a(inputStream);
                    throw th;
                }
            } else {
                file = null;
                inputStream = fileInputStream;
            }
            eg.a(inputStream);
            return file;
        } catch (Throwable th7) {
            th = th7;
            eg.a(inputStream);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final String str, final File file, final boolean z, final String str2, final String str3, final String str4) {
        new Thread(new Runnable() { // from class: cn.fly.verify.cn.2
            @Override // java.lang.Runnable
            public void run() {
                Throwable th;
                int i;
                FileOutputStream fileOutputStream;
                try {
                    ByteArrayOutputStream byteArrayOutputStream = null;
                    if (z) {
                        try {
                            if (file.exists() && str3.equals(fr.a(file))) {
                                if (cn.b(str, 5, file.getAbsolutePath(), null, str4)) {
                                    return;
                                }
                                file.delete();
                                return;
                            }
                            int i2 = 6;
                            try {
                                if (file.exists()) {
                                    file.delete();
                                }
                                i = 7;
                                try {
                                    try {
                                        fileOutputStream = new FileOutputStream(file);
                                        try {
                                            fl.a aVar = new fl.a();
                                            aVar.f2355a = 60000;
                                            aVar.b = 15000;
                                            new fl().a(str2, fileOutputStream, aVar);
                                            eg.a(fileOutputStream);
                                            if (file.length() <= 0 || !TextUtils.equals(str3, fr.a(file))) {
                                                if (file.exists()) {
                                                    file.delete();
                                                    return;
                                                }
                                                return;
                                            } else {
                                                if (cn.b(str, 7, file.getAbsolutePath(), null, str4)) {
                                                    return;
                                                }
                                                file.delete();
                                                return;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            eg.a(fileOutputStream);
                                            if (file.length() > 0 && TextUtils.equals(str3, fr.a(file))) {
                                                if (!cn.b(str, 7, file.getAbsolutePath(), null, str4)) {
                                                    file.delete();
                                                }
                                                i2 = 7;
                                            } else if (file.exists()) {
                                                file.delete();
                                            }
                                            try {
                                                throw th;
                                            } catch (Throwable th3) {
                                                i = i2;
                                                th = th3;
                                            }
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    fileOutputStream = null;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                i = 6;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            i = 5;
                        }
                    } else {
                        if (file.exists()) {
                            file.delete();
                        }
                        try {
                            try {
                                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                                try {
                                    fl.a aVar2 = new fl.a();
                                    aVar2.f2355a = 60000;
                                    aVar2.b = 15000;
                                    new fl().a(str2, byteArrayOutputStream2, aVar2);
                                    eg.a(byteArrayOutputStream2);
                                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                                    if (byteArray.length <= 0 || !TextUtils.equals(str3, fr.d(byteArray))) {
                                        return;
                                    }
                                    try {
                                        cn.b(str, 9, null, byteArray, str4);
                                        return;
                                    } catch (Throwable th8) {
                                        th = th8;
                                        i = 9;
                                    }
                                } catch (Throwable th9) {
                                    th = th9;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    eg.a(byteArrayOutputStream);
                                    throw th;
                                }
                            } catch (Throwable th10) {
                                th = th10;
                                i = 8;
                            }
                        } catch (Throwable th11) {
                            th = th11;
                        }
                    }
                } catch (Throwable th12) {
                    th = th12;
                    i = 13;
                }
                dr.a().a(5, i, th, str);
                en.a().a(th);
            }
        }).start();
    }

    public void a(long j, HashMap<String, Object> map) {
        boolean zA = by.a();
        en.a().a("DH PD: " + map.get(ed.a("004i6dk:jf")) + ", to: " + zA, new Object[0]);
        if (zA) {
            ek.d.execute(a.b(j, map));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String str, int i, String str2, byte[] bArr, String str3) {
        try {
            Method method = null;
            boolean z = false;
            for (Method method2 : fb.class.getMethods()) {
                Annotation[] annotations = method2.getAnnotations();
                if (annotations != null) {
                    int length = annotations.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        Annotation annotation = annotations[i2];
                        if (annotation != null && annotation.annotationType() == fc.class) {
                            method = method2;
                            z = true;
                            break;
                        }
                        i2++;
                    }
                    if (z) {
                        break;
                    }
                }
            }
            if (bArr != null) {
                co.a(ax.g(), bArr, str3, method);
            } else {
                co.a(ax.g(), str2, str3, method);
            }
            return true;
        } catch (Throwable th) {
            try {
                dr.a().a(6, i, th, str);
                en.a().a(th);
            } catch (Throwable unused) {
            }
            return false;
        }
    }

    public static void a(final ArrayList<HashMap<String, Object>> arrayList, final ge<Void> geVar) throws Throwable {
        if (arrayList == null || arrayList.isEmpty()) {
            geVar.a(null);
        } else {
            fq.a(ax.g()).i().r().l().a(new fq.a() { // from class: cn.fly.verify.cn.1
                @Override // cn.fly.verify.fq.a
                public void a(fq.b bVar) {
                    try {
                        File file = new File(ax.g().getFilesDir(), ed.a("003Yfhfe6g"));
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        final ArrayList arrayList2 = new ArrayList();
                        for (HashMap map : arrayList) {
                            try {
                                Boolean bool = (Boolean) map.get(ed.a("002dUfh"));
                                boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
                                String str = (String) map.get(ed.a("002 ef$g"));
                                String str2 = (String) map.get("m");
                                String str3 = (String) map.get("args");
                                Object obj = map.get(ed.a("002Ddidc"));
                                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                                    String strA = dp.a((bd) null);
                                    HashMap map2 = new HashMap();
                                    map2.put(ed.a("004Tdcdgdidc"), strA);
                                    map2.put(ed.a("005iCeddl!fe"), bw.a().b());
                                    map2.put(ed.a("004Jdfeddidc"), er.a(ax.g()).d().ah());
                                    map2.put(ed.a("010TfhdcdlgjYf>djfhdied=e"), Integer.valueOf(ax.f2078a));
                                    map2.put(ed.a("006djjYdl?f:dk"), ef.a());
                                    map2.put(ed.a("009djjKej=fcSdjJfi"), ax.e());
                                    map2.put(ed.a("006;dceddfZdDdiDe"), ax.a().a());
                                    map2.put(ed.a("0103efeddj.cfPfj,iijIfh"), Boolean.valueOf(ax.b()));
                                    map2.put(ed.a("0095efeddj)cf?ei@j@ddhh"), Boolean.valueOf(ax.c()));
                                    map2.put(ed.a("004fcf4ec"), Long.valueOf(((Long) by.a(ed.a("004fcf2ec"), 5L)).longValue()));
                                    map2.put(ed.a("002c4dc"), (String) by.a(ed.a("002cFdc"), ed.a("006Dhehehfhfhfhf")));
                                    map2.put("usridt", bu.e());
                                    map2.put(ed.a("0029didc"), obj);
                                    if (!TextUtils.isEmpty(str3)) {
                                        map2.put("args", fv.a(str3));
                                    }
                                    map2.put(ed.a("008BdcKfUdddi6cfLeidc"), bVar.i());
                                    map2.put(WkParams.IMEI, null);
                                    map2.put("imsi", null);
                                    map2.put("sno", null);
                                    map2.put("ssno", null);
                                    map2.put("miui", bVar.r());
                                    map2.put(ed.a("0059dfeddc4fg"), fq.d.j());
                                    map2.put(ed.a("007'ef7dciKeddjdk"), fq.d.k());
                                    map2.put(ed.a("005;fedj!de2dc"), fq.d.l());
                                    map2.put(ed.a("005d0dcfhdidc"), bVar.l());
                                    map2.put(ed.a("006djjRdd1f:dj"), fq.d.f());
                                    map2.put("appVerCode", Integer.valueOf(fq.d.m()));
                                    map2.put(ed.a("011jdc4dlRdLeeVf(eh4d)df%f"), fq.d.c());
                                    map2.put(ed.a("005+fefhfhdidc"), null);
                                    map2.put("osint", Integer.valueOf(fq.d.g()));
                                    map2.put("osname", fq.d.h());
                                    map2.put("mdpName", el.class.getName());
                                    String strA2 = fv.a(map2);
                                    String strA3 = fk.a(str);
                                    if (!TextUtils.isEmpty(str2)) {
                                        File file2 = new File(file, str2);
                                        if (zBooleanValue) {
                                            arrayList2.add(file2.getAbsolutePath());
                                        }
                                        cn.b(String.valueOf(obj), file2, zBooleanValue, strA3, str2, strA2);
                                    }
                                }
                            } catch (Throwable th) {
                                dr.a().a(2, 50, th, fz.a(map.get(ed.a("002Hdidc")), -1) + "");
                            }
                        }
                        ft.a(file, new FileFilter() { // from class: cn.fly.verify.cn.1.1
                            @Override // java.io.FileFilter
                            public boolean accept(File file3) {
                                return !arrayList2.contains(file3.getAbsolutePath());
                            }
                        });
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
            });
        }
    }

    public static void a(Object... objArr) {
        try {
            try {
                ds.a().a(13);
                fz.a(b(objArr));
            } catch (Throwable th) {
                try {
                    ds.a().a(5, th);
                    fz.a((File) null);
                } catch (Throwable th2) {
                    try {
                        fz.a((File) null);
                    } catch (Throwable th3) {
                        ds.a().a(4, th3);
                    }
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            ds.a().a(4, th4);
        }
    }
}
