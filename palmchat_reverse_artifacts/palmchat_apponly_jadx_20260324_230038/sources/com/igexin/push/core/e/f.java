package com.igexin.push.core.e;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.igexin.push.core.ServiceManager;
import com.igexin.push.d.c;
import com.igexin.push.f.b.d;
import com.igexin.push.g.g;
import com.igexin.push.g.j;
import com.qq.gdt.action.ActionUtils;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class f implements a {
    private static final int A = 48;
    private static final int B = 49;
    private static final int C = 50;
    private static final int D = 51;
    private static final int E = 53;
    private static final int F = 54;
    private static final int G = 60;
    private static final int H = 61;
    private static final int I = 63;
    private static final int J = 64;
    private static final int K = 65;
    private static final int L = 66;
    private static final int M = 67;
    private static volatile f N = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7227a = "com.igexin.push.core.e.f";
    private static final int c = 1;
    private static final int d = 2;
    private static final int e = 3;
    private static final int f = 4;
    private static final int g = 6;
    private static final int h = 8;
    private static final int i = 12;
    private static final int j = 13;
    private static final int k = 14;
    private static final int l = 15;
    private static final int m = 16;
    private static final int n = 17;
    private static final int o = 18;
    private static final int p = 20;
    private static final int q = 21;
    private static final int r = 22;
    private static final int s = 23;
    private static final int t = 25;
    private static final int u = 30;
    private static final int v = 31;
    private static final int w = 32;
    private static final int x = 40;
    private static final int y = 46;
    private static final int z = 47;
    public boolean b;

    /* JADX INFO: renamed from: com.igexin.push.core.e.f$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass1 extends com.igexin.push.b.d {
        public AnonymousClass1() {
        }

        @Override // com.igexin.push.b.d
        public final void a_() throws Throwable {
            f.this.c(this.d);
            j.b();
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.core.e.f$12, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass12 extends com.igexin.push.b.d {
        public AnonymousClass12() {
        }

        @Override // com.igexin.push.b.d
        public final void a_() {
            f.a();
            f.b(this.d, 8, String.valueOf(com.igexin.push.core.e.R));
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.core.e.f$13, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass13 extends com.igexin.push.b.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7232a;

        public AnonymousClass13(String str) {
            this.f7232a = str;
        }

        @Override // com.igexin.push.b.d
        public final void a_() throws Exception {
            f.a();
            f.b(this.d, 3, this.f7232a);
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.core.e.f$17, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass17 extends com.igexin.push.b.d {
        public AnonymousClass17() {
        }

        @Override // com.igexin.push.b.d
        public final void a_() {
            f.a();
            f.b(this.d, 67, String.valueOf(com.igexin.push.core.e.J));
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.core.e.f$20, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass20 extends com.igexin.push.b.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7240a;
        final /* synthetic */ String b;

        public AnonymousClass20(String str, String str2) {
            this.f7240a = str;
            this.b = str2;
        }

        @Override // com.igexin.push.b.d
        public final void a_() throws Exception {
            if (!TextUtils.isEmpty(this.f7240a)) {
                f.a();
                f.b(this.d, 53, this.f7240a);
            }
            if (TextUtils.isEmpty(this.b)) {
                return;
            }
            f.a();
            f.b(this.d, 54, this.b);
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.core.e.f$21, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass21 extends com.igexin.push.b.d {
        public AnonymousClass21() {
        }

        @Override // com.igexin.push.b.d
        public final void a_() throws Exception {
            f.a();
            f.b(this.d, 60, String.valueOf(com.igexin.push.core.e.c));
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.core.e.f$25, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass25 extends com.igexin.push.b.d {
        public AnonymousClass25() {
        }

        @Override // com.igexin.push.b.d
        public final void a_() throws Exception {
            f.a();
            f.b(this.d, 64, String.valueOf(com.igexin.push.core.e.ax));
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.core.e.f$27, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass27 extends com.igexin.push.b.d {
        public AnonymousClass27() {
        }

        @Override // com.igexin.push.b.d
        public final void a_() throws Exception {
            f.a();
            f.a(this.d, 66, com.igexin.c.a.a.a.b(com.igexin.push.a.j.getBytes(), com.igexin.push.core.e.M));
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.core.e.f$28, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass28 extends com.igexin.push.b.d {
        public AnonymousClass28() {
        }

        @Override // com.igexin.push.b.d
        public final void a_() throws Exception {
            f.a();
            f.e(this.d);
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.core.e.f$3, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass3 extends com.igexin.push.b.d {
        public AnonymousClass3() {
        }

        @Override // com.igexin.push.b.d
        public final void a_() {
            f.a();
            f.b(this.d, 13, com.igexin.push.core.e.V);
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.core.e.f$31, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass31 extends com.igexin.push.b.d {
        public AnonymousClass31() {
        }

        @Override // com.igexin.push.b.d
        public final void a_() {
            f.a();
            f.b(this.d, 51, com.igexin.push.core.e.C);
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.core.e.f$5, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass5 extends com.igexin.push.b.d {
        public AnonymousClass5() {
        }

        @Override // com.igexin.push.b.d
        public final void a_() {
            f.a();
            f.b(this.d, 16, String.valueOf(com.igexin.push.core.e.X));
        }
    }

    private f() {
    }

    public static f a() {
        if (N == null) {
            synchronized (f.class) {
                if (N == null) {
                    N = new f();
                }
            }
        }
        return N;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0040 A[PHI: r10
      0x0040: PHI (r10v3 android.database.Cursor) = (r10v2 android.database.Cursor), (r10v4 android.database.Cursor) binds: [B:19:0x003e, B:12:0x0034] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0048  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(SQLiteDatabase sQLiteDatabase, int i2) throws Throwable {
        Cursor cursorQuery;
        ?? r1 = 0;
        try {
            try {
                cursorQuery = sQLiteDatabase.query(com.igexin.push.core.b.Z, new String[]{ActionUtils.PAYMENT_AMOUNT}, "id=".concat(String.valueOf(i2)), null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex(ActionUtils.PAYMENT_AMOUNT));
                            cursorQuery.close();
                            return string;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        com.igexin.c.a.c.a.a(e);
                        if (cursorQuery != null) {
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                r1 = sQLiteDatabase;
                if (r1 != 0) {
                    r1.close();
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (r1 != 0) {
            }
            throw th;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    public static void d() {
        try {
            String string = com.igexin.push.core.e.D;
            UUID uuidRandomUUID = UUID.randomUUID();
            if (TextUtils.isEmpty(string) || string.length() <= 8) {
                StringBuilder sb = new StringBuilder(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
                sb.append(com.igexin.c.b.a.b(com.igexin.push.core.e.g + uuidRandomUUID));
                string = sb.toString();
            }
            StringBuilder sb2 = new StringBuilder("A-");
            sb2.append(string);
            sb2.append("-");
            sb2.append(com.igexin.c.b.a.b(System.currentTimeMillis() + uuidRandomUUID + com.igexin.push.core.e.g));
            String string2 = sb2.toString();
            com.igexin.push.core.e.L = string2;
            if (string2.length() >= 64) {
                com.igexin.push.core.e.L = com.igexin.push.core.e.L.substring(0, 62);
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            StringBuilder sb3 = new StringBuilder("A-V");
            sb3.append(com.igexin.push.core.e.g);
            sb3.append("-");
            sb3.append(com.igexin.c.b.a.b(System.currentTimeMillis() + com.igexin.push.core.e.g));
            com.igexin.push.core.e.L = sb3.toString();
        }
    }

    public static /* synthetic */ void e() throws Throwable {
        j.b();
        String strD = j.d();
        if (strD == null || strD.length() <= 5) {
            j.f();
        }
    }

    private void f() {
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass1(), false, true);
    }

    private static void g() throws Throwable {
        j.b();
        String strD = j.d();
        if (strD == null || strD.length() <= 5) {
            j.f();
        }
    }

    private static void h() {
        String str = com.igexin.push.core.e.f7217a;
        com.igexin.c.a.c.a.a(f7227a + "| found a duplicate cid " + com.igexin.push.core.e.A, new Object[0]);
        com.igexin.push.core.e.L = null;
        d();
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) a().new AnonymousClass13(com.igexin.push.core.e.L), false, true);
        a().b();
        com.igexin.push.core.e.r = 0;
        com.igexin.push.f.b.e.g().f7341a = SystemClock.elapsedRealtime();
    }

    private void i() {
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass25(), false, true);
    }

    private void j() {
        if (TextUtils.isEmpty(g.c)) {
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass27(), true, false);
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass28(), true, false);
        }
    }

    private static void k(SQLiteDatabase sQLiteDatabase) throws Throwable {
        String strB = b(sQLiteDatabase, 3);
        if (!TextUtils.isEmpty(strB)) {
            if (strB.equals(com.igexin.push.core.b.m)) {
                strB = null;
            }
            com.igexin.push.core.e.L = strB;
        }
        String str = com.igexin.push.core.e.f7217a;
    }

    private static void l(SQLiteDatabase sQLiteDatabase) throws Throwable {
        byte[] bArrA = a(sQLiteDatabase, 1);
        if (bArrA != null) {
            try {
                String str = new String(bArrA);
                com.igexin.push.core.e.z = str.equals(com.igexin.push.core.b.m) ? 0L : Long.parseLong(str);
            } catch (Exception e2) {
                com.igexin.c.a.c.a.a(e2);
            }
            com.igexin.c.a.c.a.a(f7227a + "|db version changed, save session = " + com.igexin.push.core.e.z, new Object[0]);
        }
    }

    private static void m(SQLiteDatabase sQLiteDatabase) throws Throwable {
        byte[] bArrA = a(sQLiteDatabase, 20);
        if (bArrA != null) {
            String str = new String(bArrA);
            if (str.equals(com.igexin.push.core.b.m)) {
                str = null;
            }
            com.igexin.push.core.e.B = str;
            com.igexin.push.core.e.A = str;
            com.igexin.c.a.c.a.a(f7227a + "|db version changed, save cid = " + str, new Object[0]);
        }
    }

    private static void n(SQLiteDatabase sQLiteDatabase) throws Throwable {
        byte[] bArrA = a(sQLiteDatabase, 66);
        if (bArrA != null) {
            String str = new String(bArrA);
            if (TextUtils.isEmpty(str)) {
                com.igexin.c.a.c.a.a(f7227a, "readRedirectAes null");
                return;
            }
            g.c = str;
            com.igexin.c.a.c.a.b(f7227a, " readRedirectAes set success " + g.c);
        }
    }

    @Override // com.igexin.push.core.e.a
    public final void c(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, 1, com.igexin.c.a.a.a.b(String.valueOf(com.igexin.push.core.e.z).getBytes(), com.igexin.push.core.e.M));
        b(sQLiteDatabase, 4, String.valueOf(com.igexin.push.core.e.t));
        b(sQLiteDatabase, 8, String.valueOf(com.igexin.push.core.e.R));
        b(sQLiteDatabase, 32, String.valueOf(com.igexin.push.core.e.U));
        b(sQLiteDatabase, 3, com.igexin.push.core.e.L);
        b(sQLiteDatabase, 12, String.valueOf(com.igexin.push.core.e.T));
        a(sQLiteDatabase, 20, com.igexin.c.a.a.a.b(com.igexin.push.core.e.A.getBytes(), com.igexin.push.core.e.M));
        b(sQLiteDatabase, 2, com.igexin.push.core.e.H);
        a(sQLiteDatabase, 25, com.igexin.c.a.a.a.b(com.igexin.push.core.e.M.getBytes(), com.igexin.c.b.a.b(com.igexin.push.core.e.l.getPackageName())));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004b A[PHI: r2
      0x004b: PHI (r2v3 android.database.Cursor) = (r2v1 android.database.Cursor), (r2v4 android.database.Cursor) binds: [B:14:0x0049, B:8:0x0040] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void d(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = sQLiteDatabase.query(com.igexin.push.core.b.Z, new String[]{ActionUtils.PAYMENT_AMOUNT}, "id=?", new String[]{"25"}, null, null, null);
                if (cursorQuery != null && cursorQuery.moveToFirst()) {
                    com.igexin.push.core.e.M = new String(com.igexin.c.a.a.a.a(cursorQuery.getBlob(cursorQuery.getColumnIndex(ActionUtils.PAYMENT_AMOUNT)), com.igexin.c.b.a.b(ServiceManager.b.getPackageName())));
                }
            } catch (Exception e2) {
                com.igexin.c.a.c.a.a(e2);
                if (cursorQuery != null) {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            if (com.igexin.push.core.e.M == null) {
                String str = com.igexin.push.core.e.D;
                if (str == null) {
                    str = com.igexin.push.core.b.am;
                }
                com.igexin.push.core.e.M = com.igexin.c.b.a.b(str);
            }
            com.igexin.c.a.c.a.a(f7227a + "|storageKey = " + com.igexin.push.core.e.M, new Object[0]);
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    private void f(SQLiteDatabase sQLiteDatabase) throws Throwable {
        this.b = true;
        d(sQLiteDatabase);
        byte[] bArrA = a(sQLiteDatabase, 1);
        if (bArrA != null) {
            try {
                String str = new String(bArrA);
                com.igexin.push.core.e.z = str.equals(com.igexin.push.core.b.m) ? 0L : Long.parseLong(str);
            } catch (Exception e2) {
                com.igexin.c.a.c.a.a(e2);
            }
            com.igexin.c.a.c.a.a(f7227a + "|db version changed, save session = " + com.igexin.push.core.e.z, new Object[0]);
        }
        byte[] bArrA2 = a(sQLiteDatabase, 20);
        if (bArrA2 != null) {
            String str2 = new String(bArrA2);
            if (str2.equals(com.igexin.push.core.b.m)) {
                str2 = null;
            }
            com.igexin.push.core.e.B = str2;
            com.igexin.push.core.e.A = str2;
            com.igexin.c.a.c.a.a(f7227a + "|db version changed, save cid = " + str2, new Object[0]);
        }
        String strB = b(sQLiteDatabase, 3);
        if (!TextUtils.isEmpty(strB)) {
            if (strB.equals(com.igexin.push.core.b.m)) {
                strB = null;
            }
            com.igexin.push.core.e.L = strB;
        }
        String str3 = com.igexin.push.core.e.f7217a;
        String strB2 = b(sQLiteDatabase, 2);
        if (!TextUtils.isEmpty(strB2)) {
            if (strB2.equals(com.igexin.push.core.b.m)) {
                strB2 = null;
            }
            com.igexin.push.core.e.H = strB2;
        }
        String strB3 = b(sQLiteDatabase, 46);
        if (!TextUtils.isEmpty(strB3)) {
            if (strB3.equals(com.igexin.push.core.b.m)) {
                strB3 = null;
            }
            com.igexin.push.core.e.I = strB3;
        }
        String strB4 = b(sQLiteDatabase, 48);
        if (!TextUtils.isEmpty(strB4)) {
            if (strB4.equals(com.igexin.push.core.b.m)) {
                strB4 = null;
            }
            com.igexin.push.core.e.K = strB4;
        }
        String strB5 = b(sQLiteDatabase, 51);
        if (TextUtils.isEmpty(strB5) || strB5.length() == 13) {
            return;
        }
        com.igexin.push.core.e.C = strB5.equals(com.igexin.push.core.b.m) ? null : strB5;
    }

    private static void g(SQLiteDatabase sQLiteDatabase) throws Throwable {
        String strB = b(sQLiteDatabase, 2);
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        if (strB.equals(com.igexin.push.core.b.m)) {
            strB = null;
        }
        com.igexin.push.core.e.H = strB;
    }

    private static void h(SQLiteDatabase sQLiteDatabase) throws Throwable {
        String strB = b(sQLiteDatabase, 51);
        if (TextUtils.isEmpty(strB) || strB.length() == 13) {
            return;
        }
        if (strB.equals(com.igexin.push.core.b.m)) {
            strB = null;
        }
        com.igexin.push.core.e.C = strB;
    }

    private static void i(SQLiteDatabase sQLiteDatabase) throws Throwable {
        String strB = b(sQLiteDatabase, 46);
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        if (strB.equals(com.igexin.push.core.b.m)) {
            strB = null;
        }
        com.igexin.push.core.e.I = strB;
    }

    private static void j(SQLiteDatabase sQLiteDatabase) throws Throwable {
        String strB = b(sQLiteDatabase, 48);
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        if (strB.equals(com.igexin.push.core.b.m)) {
            strB = null;
        }
        com.igexin.push.core.e.K = strB;
    }

    @Override // com.igexin.push.core.e.a
    public final void a(SQLiteDatabase sQLiteDatabase) {
    }

    /* JADX WARN: Removed duplicated region for block: B:255:0x0411 A[PHI: r3 r5 r7 r13 r15
      0x0411: PHI (r3v3 int) = (r3v2 int), (r3v12 int) binds: [B:254:0x040f, B:244:0x03f0] A[DONT_GENERATE, DONT_INLINE]
      0x0411: PHI (r5v5 android.database.Cursor) = (r5v4 android.database.Cursor), (r5v8 android.database.Cursor) binds: [B:254:0x040f, B:244:0x03f0] A[DONT_GENERATE, DONT_INLINE]
      0x0411: PHI (r7v4 int) = (r7v3 int), (r7v12 int) binds: [B:254:0x040f, B:244:0x03f0] A[DONT_GENERATE, DONT_INLINE]
      0x0411: PHI (r13v3 int) = (r13v2 int), (r13v5 int) binds: [B:254:0x040f, B:244:0x03f0] A[DONT_GENERATE, DONT_INLINE]
      0x0411: PHI (r15v3 boolean) = (r15v2 boolean), (r15v5 boolean) binds: [B:254:0x040f, B:244:0x03f0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:258:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0450  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x048b  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0491  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x04a2  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x04b9  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x04e4  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0511  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0518  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0527  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x008f A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:356:0x03b9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0083 A[Catch: all -> 0x03df, TRY_LEAVE, TryCatch #7 {all -> 0x03df, blocks: (B:33:0x0074, B:35:0x007d, B:37:0x0083), top: B:351:0x0074 }] */
    /* JADX WARN: Removed duplicated region for block: B:407:0x0091 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:465:? A[RETURN, SYNTHETIC] */
    @Override // com.igexin.push.core.e.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(SQLiteDatabase sQLiteDatabase) throws Throwable {
        int i2;
        int i3;
        int i4;
        boolean z2;
        Cursor cursorQuery;
        String str;
        String strD;
        JSONObject jSONObjectC;
        String strOptString;
        String str2;
        String str3;
        String strC;
        int i5;
        byte[] blob;
        String string;
        d(sQLiteDatabase);
        Cursor cursor = null;
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                z2 = false;
                i4 = 1;
            } catch (Exception e2) {
                e = e2;
                i2 = 20;
                i3 = 2;
                i4 = 1;
                z2 = false;
            }
            try {
                cursorQuery = sQLiteDatabase.query(com.igexin.push.core.b.Z, new String[]{"id", ActionUtils.PAYMENT_AMOUNT}, null, null, null, null, "id");
            } catch (Exception e3) {
                e = e3;
                i2 = 20;
                i3 = 2;
                cursorQuery = null;
            }
            if (cursorQuery != null) {
                while (cursorQuery.moveToNext()) {
                    try {
                        i5 = cursorQuery.getInt(0);
                    } catch (Exception e4) {
                        e = e4;
                        i2 = 20;
                        i3 = 2;
                    }
                    if (i5 == 1 || i5 == 14) {
                        i2 = 20;
                        blob = cursorQuery.getBlob(1);
                        if (blob != null) {
                            blob = com.igexin.c.a.a.a.a(blob, com.igexin.push.core.e.M);
                        }
                        string = null;
                        if (blob != null || string != null) {
                            if (i5 != 1) {
                                i3 = 2;
                                if (i5 == 2) {
                                    if (string.equals(com.igexin.push.core.b.m)) {
                                        string = null;
                                    }
                                    com.igexin.push.core.e.H = string;
                                } else if (i5 == 3) {
                                    if (string.equals(com.igexin.push.core.b.m)) {
                                        string = null;
                                    }
                                    com.igexin.push.core.e.L = string;
                                } else if (i5 == 4) {
                                    com.igexin.push.core.e.t = string.equals(com.igexin.push.core.b.m) || Boolean.parseBoolean(string);
                                } else if (i5 == 6) {
                                    com.igexin.push.core.e.Q = string.equals(com.igexin.push.core.b.m) ? 0L : Long.parseLong(string);
                                } else if (i5 == 8) {
                                    com.igexin.push.core.e.R = string.equals(com.igexin.push.core.b.m) ? 0L : Long.parseLong(string);
                                } else if (i5 == 40) {
                                    boolean z3 = !string.equals(com.igexin.push.core.b.m) && Boolean.parseBoolean(string);
                                    c.b.f7311a.b = z3;
                                    com.igexin.c.a.c.a.a("ConnectModelCoordinator|init, current is polling mdl = ".concat(String.valueOf(z3)), new Object[0]);
                                    if (z3) {
                                        d.a.f7340a.g();
                                    }
                                } else if (i5 == 53) {
                                    if (com.igexin.push.core.b.m.equals(string)) {
                                        string = null;
                                    }
                                    com.igexin.push.core.e.aK = string;
                                } else if (i5 == 54) {
                                    if (com.igexin.push.core.b.m.equals(string)) {
                                        string = null;
                                    }
                                    com.igexin.push.core.e.aL = string;
                                } else if (i5 == 60) {
                                    com.igexin.push.core.e.c = string.equals(com.igexin.push.core.b.m) ? 0L : Long.parseLong(string);
                                } else {
                                    if (i5 != 61) {
                                        switch (i5) {
                                            case 12:
                                                com.igexin.push.core.e.T = string.equals(com.igexin.push.core.b.m) ? 0L : Long.parseLong(string);
                                                continue;
                                            case 13:
                                                if (string.equals(com.igexin.push.core.b.m)) {
                                                    string = null;
                                                }
                                                com.igexin.push.core.e.V = string;
                                                continue;
                                            case 14:
                                                com.igexin.push.core.e.an = new String(blob);
                                                continue;
                                            case 15:
                                                if (!string.equals(com.igexin.push.core.b.m)) {
                                                    com.igexin.push.core.e.W = Boolean.parseBoolean(string);
                                                } else {
                                                    continue;
                                                }
                                                break;
                                            case 16:
                                                com.igexin.push.core.e.X = string.equals(com.igexin.push.core.b.m) ? 0L : Long.parseLong(string);
                                                continue;
                                            case 17:
                                                if (string.equals(com.igexin.push.core.b.m)) {
                                                    string = null;
                                                }
                                                com.igexin.push.core.e.Z = string;
                                                continue;
                                            case 18:
                                                com.igexin.push.core.e.ab = string.equals(com.igexin.push.core.b.m) ? 0 : Integer.parseInt(string);
                                                continue;
                                            default:
                                                switch (i5) {
                                                    case 20:
                                                        String str4 = new String(blob);
                                                        if (str4.equals(com.igexin.push.core.b.m)) {
                                                            str4 = null;
                                                        }
                                                        com.igexin.push.core.e.B = str4;
                                                        com.igexin.push.core.e.A = str4;
                                                        continue;
                                                    case 21:
                                                        com.igexin.push.core.e.ao = string.equals(com.igexin.push.core.b.m) ? 0L : Long.parseLong(string);
                                                        continue;
                                                    case 22:
                                                        String str5 = new String(blob);
                                                        if (str5.equals(com.igexin.push.core.b.m)) {
                                                            str5 = null;
                                                        }
                                                        com.igexin.push.core.e.aq = str5;
                                                        com.igexin.c.a.c.a.a(f7227a + "|read last wf result = " + com.igexin.push.core.e.aq, new Object[0]);
                                                        continue;
                                                    case 23:
                                                        String str6 = new String(blob);
                                                        if (str6.equals(com.igexin.push.core.b.m)) {
                                                            str6 = null;
                                                        }
                                                        com.igexin.push.core.e.ap = str6;
                                                        com.igexin.c.a.c.a.a(f7227a + "|read last mobile result = " + com.igexin.push.core.e.ap, new Object[0]);
                                                        continue;
                                                        continue;
                                                    default:
                                                        switch (i5) {
                                                            case 30:
                                                                String str7 = new String(blob);
                                                                if (str7.equals(com.igexin.push.core.b.m)) {
                                                                    str7 = null;
                                                                }
                                                                com.igexin.push.core.e.as = str7;
                                                                com.igexin.c.a.c.a.a(f7227a + "|read last domainWfStatus = " + com.igexin.push.core.e.as, new Object[0]);
                                                                continue;
                                                            case 31:
                                                                String str8 = new String(blob);
                                                                if (str8.equals(com.igexin.push.core.b.m)) {
                                                                    str8 = null;
                                                                }
                                                                com.igexin.push.core.e.ar = str8;
                                                                com.igexin.c.a.c.a.a(f7227a + "|read last domainMobileStatus = " + com.igexin.push.core.e.ar, new Object[0]);
                                                                continue;
                                                            case 32:
                                                                com.igexin.push.core.e.U = string.equals(com.igexin.push.core.b.m) ? 0L : Long.parseLong(string);
                                                                continue;
                                                                continue;
                                                            default:
                                                                switch (i5) {
                                                                    case 46:
                                                                        if (string.equals(com.igexin.push.core.b.m)) {
                                                                            string = null;
                                                                        }
                                                                        com.igexin.push.core.e.I = string;
                                                                        continue;
                                                                    case 47:
                                                                        com.igexin.push.core.e.aA = string.equals(com.igexin.push.core.b.m) ? 0 : Integer.parseInt(string);
                                                                        continue;
                                                                    case 48:
                                                                        if (string.equals(com.igexin.push.core.b.m)) {
                                                                            string = null;
                                                                        }
                                                                        com.igexin.push.core.e.K = string;
                                                                        continue;
                                                                    case 49:
                                                                        String str9 = new String(blob);
                                                                        if (str9.equals(com.igexin.push.core.b.m)) {
                                                                            str9 = null;
                                                                        }
                                                                        com.igexin.push.core.e.at = str9;
                                                                        com.igexin.c.a.c.a.a(f7227a + "|read last wfRedirectCmList = " + com.igexin.push.core.e.at, new Object[0]);
                                                                        continue;
                                                                    case 50:
                                                                        String str10 = new String(blob);
                                                                        if (str10.equals(com.igexin.push.core.b.m)) {
                                                                            str10 = null;
                                                                        }
                                                                        com.igexin.push.core.e.au = str10;
                                                                        com.igexin.c.a.c.a.a(f7227a + "|read last mobileRedirectCmList = " + com.igexin.push.core.e.au, new Object[0]);
                                                                        continue;
                                                                    case 51:
                                                                        if (!string.equals(com.igexin.push.core.b.m) && string.length() != 13) {
                                                                            com.igexin.push.core.e.C = string;
                                                                        }
                                                                        String str11 = com.igexin.push.core.e.f7217a;
                                                                        continue;
                                                                        continue;
                                                                    default:
                                                                        switch (i5) {
                                                                            case 63:
                                                                                com.igexin.push.core.e.aw = com.igexin.push.core.b.m.equals(string) ? 0L : Long.parseLong(string);
                                                                                continue;
                                                                            case 64:
                                                                                com.igexin.push.core.e.ax = com.igexin.push.core.b.m.equals(string) ? 0L : Long.parseLong(string);
                                                                                continue;
                                                                            case 65:
                                                                                com.igexin.push.core.e.ay = com.igexin.push.core.b.m.equals(string) ? 0L : Long.parseLong(string);
                                                                                continue;
                                                                            case 66:
                                                                                String str12 = new String(blob);
                                                                                if (str12.equals(com.igexin.push.core.b.m)) {
                                                                                    str12 = "";
                                                                                }
                                                                                g.c = str12;
                                                                                com.igexin.c.a.c.a.b(f7227a, "read from db last redirectAes  = " + g.c);
                                                                                continue;
                                                                            case 67:
                                                                                try {
                                                                                    com.igexin.push.core.e.J = string.equals(com.igexin.push.core.b.m) ? -1 : Integer.parseInt(string);
                                                                                    continue;
                                                                                } catch (Exception e5) {
                                                                                    e = e5;
                                                                                }
                                                                                break;
                                                                            default:
                                                                                continue;
                                                                        }
                                                                        break;
                                                                }
                                                                break;
                                                        }
                                                        break;
                                                }
                                                break;
                                        }
                                        com.igexin.c.a.c.a.a(e);
                                        com.igexin.c.a.c.a.a(f7227a, e.toString());
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        if (com.igexin.push.core.e.z == 0) {
                                            long jE = j.e();
                                            if (jE != 0) {
                                                com.igexin.push.core.e.z = jE;
                                                a(sQLiteDatabase, i4, g.a(String.valueOf(jE).getBytes()));
                                            }
                                        }
                                        if (com.igexin.push.core.e.A == null && (strC = j.c()) != null) {
                                            com.igexin.push.core.e.B = strC;
                                            com.igexin.push.core.e.A = strC;
                                            a(sQLiteDatabase, i2, g.a(strC.getBytes()));
                                        }
                                        if (com.igexin.push.core.e.A == null) {
                                            long j2 = com.igexin.push.core.e.z;
                                            if (j2 != 0) {
                                                com.igexin.push.core.e.B = com.igexin.c.b.a.b(String.valueOf(j2));
                                                com.igexin.push.core.e.a(com.igexin.push.core.e.z);
                                                a(sQLiteDatabase, i2, g.a(com.igexin.push.core.e.A.getBytes()));
                                            }
                                        }
                                        if ("cfcd208495d565ef66e7dff9f98764da".equals(com.igexin.push.core.e.A) && ((str3 = com.igexin.push.core.e.A) == null || str3.matches("([a-f]|[0-9]){32}"))) {
                                            str = null;
                                        } else if (com.igexin.push.core.e.z == 0) {
                                            a().a(com.igexin.push.core.e.z);
                                            com.igexin.push.core.e.B = com.igexin.push.core.e.A;
                                            j.g();
                                            str = null;
                                        } else {
                                            str = null;
                                            com.igexin.push.core.e.B = null;
                                            com.igexin.push.core.e.A = com.igexin.push.core.b.m;
                                            com.igexin.push.core.e.z = 0L;
                                        }
                                        if (!TextUtils.isEmpty(com.igexin.push.core.e.an) || com.igexin.push.core.b.m.equals(com.igexin.push.core.e.an)) {
                                            String strA = com.igexin.c.b.a.a();
                                            com.igexin.push.core.e.an = strA;
                                            a(sQLiteDatabase, 14, g.a(strA.getBytes()));
                                        }
                                        strD = j.d();
                                        if (com.igexin.push.core.e.H == null && strD != null && strD.length() > 5) {
                                            com.igexin.push.core.e.H = strD;
                                            b(sQLiteDatabase, i3, strD);
                                        }
                                        if (com.igexin.push.core.e.L == null) {
                                            d();
                                            b(sQLiteDatabase, 3, com.igexin.push.core.e.L);
                                        }
                                        d dVarA = d.a(com.igexin.push.core.e.l);
                                        jSONObjectC = dVarA.c();
                                        strOptString = jSONObjectC.optString("token", str);
                                        if (strOptString != null && !strOptString.equals(com.igexin.push.core.e.I)) {
                                            com.igexin.push.core.e.I = strOptString;
                                            if (jSONObjectC.optBoolean("isForce")) {
                                                c("");
                                            }
                                            str2 = com.igexin.push.core.e.I;
                                            if (str2 != null) {
                                                b(str2);
                                                dVarA.a(new JSONObject());
                                            }
                                        }
                                        if (this.b) {
                                            return;
                                        }
                                        this.b = z2;
                                        if (!TextUtils.isEmpty(com.igexin.push.core.e.M)) {
                                            a(sQLiteDatabase, 25, com.igexin.c.a.a.a.b(com.igexin.push.core.e.M.getBytes(), com.igexin.c.b.a.b(com.igexin.push.core.e.l.getPackageName())));
                                        }
                                        long j3 = com.igexin.push.core.e.z;
                                        if (j3 != 0) {
                                            a(sQLiteDatabase, i4, g.a(String.valueOf(j3).getBytes()));
                                        }
                                        if (!TextUtils.isEmpty(com.igexin.push.core.e.A)) {
                                            a(sQLiteDatabase, i2, g.a(com.igexin.push.core.e.A.getBytes()));
                                        }
                                        if (!TextUtils.isEmpty(com.igexin.push.core.e.H) && com.igexin.push.core.e.H.length() > 5) {
                                            b(sQLiteDatabase, i3, com.igexin.push.core.e.H);
                                        }
                                        if (!TextUtils.isEmpty(com.igexin.push.core.e.L)) {
                                            b(sQLiteDatabase, 3, com.igexin.push.core.e.L);
                                        }
                                        if (!TextUtils.isEmpty(com.igexin.push.core.e.I)) {
                                            b(sQLiteDatabase, 46, com.igexin.push.core.e.I);
                                        }
                                        if (!TextUtils.isEmpty(com.igexin.push.core.e.C)) {
                                            b(sQLiteDatabase, 51, com.igexin.push.core.e.C);
                                        }
                                        if (TextUtils.isEmpty(com.igexin.push.core.e.K)) {
                                            return;
                                        }
                                        b(sQLiteDatabase, 48, com.igexin.push.core.e.K);
                                        return;
                                    }
                                    String str13 = new String(blob);
                                    if (str13.equals(com.igexin.push.core.b.m)) {
                                        str13 = null;
                                    }
                                    com.igexin.push.core.e.d = str13;
                                }
                            } else {
                                String str14 = new String(blob);
                                try {
                                    com.igexin.push.core.e.z = str14.equals(com.igexin.push.core.b.m) ? 0L : Long.parseLong(str14);
                                } catch (Exception unused) {
                                    com.igexin.c.a.c.a.a(f7227a, "session formate error! session : ".concat(str14));
                                    com.igexin.push.core.e.z = 0L;
                                }
                            }
                        }
                    } else {
                        i2 = 20;
                        if (i5 == 20 || i5 == 25 || i5 == 22 || i5 == 23 || i5 == 31 || i5 == 30 || i5 == 49 || i5 == 50 || i5 == 66 || i5 == 61) {
                            blob = cursorQuery.getBlob(1);
                            if (blob != null) {
                            }
                            string = null;
                            if (blob != null) {
                            }
                            if (i5 != 1) {
                            }
                        } else {
                            try {
                                string = cursorQuery.getString(1);
                                blob = null;
                                if (blob != null) {
                                }
                                if (i5 != 1) {
                                }
                            } catch (Throwable th2) {
                                com.igexin.c.a.c.a.a(th2);
                            }
                        }
                    }
                }
            }
            i2 = 20;
            i3 = 2;
            if (cursorQuery != null) {
            }
            if (com.igexin.push.core.e.z == 0) {
            }
            if (com.igexin.push.core.e.A == null) {
                com.igexin.push.core.e.B = strC;
                com.igexin.push.core.e.A = strC;
                a(sQLiteDatabase, i2, g.a(strC.getBytes()));
            }
            if (com.igexin.push.core.e.A == null) {
            }
            if ("cfcd208495d565ef66e7dff9f98764da".equals(com.igexin.push.core.e.A)) {
                if (com.igexin.push.core.e.z == 0) {
                }
            }
            if (!TextUtils.isEmpty(com.igexin.push.core.e.an)) {
                String strA2 = com.igexin.c.b.a.a();
                com.igexin.push.core.e.an = strA2;
                a(sQLiteDatabase, 14, g.a(strA2.getBytes()));
            }
            strD = j.d();
            if (com.igexin.push.core.e.H == null) {
                com.igexin.push.core.e.H = strD;
                b(sQLiteDatabase, i3, strD);
            }
            if (com.igexin.push.core.e.L == null) {
            }
            d dVarA2 = d.a(com.igexin.push.core.e.l);
            jSONObjectC = dVarA2.c();
            strOptString = jSONObjectC.optString("token", str);
            if (strOptString != null) {
                com.igexin.push.core.e.I = strOptString;
                if (jSONObjectC.optBoolean("isForce")) {
                }
                str2 = com.igexin.push.core.e.I;
                if (str2 != null) {
                }
            }
            if (this.b) {
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final boolean c() {
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.23
            @Override // com.igexin.push.b.d
            public final void a_() throws Throwable {
                f.a();
                f.b(this.d, 2, com.igexin.push.core.e.H);
                f.a(this.d, 1, f.f(String.valueOf(com.igexin.push.core.e.z)));
                f.a(this.d, 20, f.f(com.igexin.push.core.e.A));
                f.b(this.d, 3, com.igexin.push.core.e.L);
                f.e();
            }
        }, false, true);
    }

    public final void e(long j2) {
        if (com.igexin.push.core.e.ay != j2) {
            com.igexin.push.core.e.ay = j2;
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.26
                @Override // com.igexin.push.b.d
                public final void a_() throws Exception {
                    f.a();
                    f.b(this.d, 65, String.valueOf(com.igexin.push.core.e.ay));
                }
            }, false, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(SQLiteDatabase sQLiteDatabase, int i2, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(i2));
        contentValues.put(ActionUtils.PAYMENT_AMOUNT, str);
        sQLiteDatabase.replace(com.igexin.push.core.b.Z, null, contentValues);
    }

    private boolean c(int i2) {
        if (com.igexin.push.core.e.J == i2) {
            return false;
        }
        com.igexin.push.core.e.J = i2;
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass17(), false, true);
    }

    public static /* synthetic */ void e(SQLiteDatabase sQLiteDatabase) throws Throwable {
        byte[] bArrA = a(sQLiteDatabase, 66);
        if (bArrA != null) {
            String str = new String(bArrA);
            if (TextUtils.isEmpty(str)) {
                com.igexin.c.a.c.a.a(f7227a, "readRedirectAes null");
                return;
            }
            g.c = str;
            com.igexin.c.a.c.a.b(f7227a, " readRedirectAes set success " + g.c);
        }
    }

    private boolean f(long j2) {
        if (j2 == com.igexin.push.core.e.R) {
            return false;
        }
        com.igexin.push.core.e.R = j2;
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass12(), false, true);
    }

    private boolean g(long j2) {
        if (com.igexin.push.core.e.T == j2) {
            return false;
        }
        com.igexin.push.core.e.T = j2;
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.34
            @Override // com.igexin.push.b.d
            public final void a_() {
                f.a();
                f.b(this.d, 12, String.valueOf(com.igexin.push.core.e.T));
            }
        }, false, true);
        return true;
    }

    private boolean h(long j2) {
        if (com.igexin.push.core.e.X == j2) {
            return false;
        }
        com.igexin.push.core.e.X = j2;
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass5(), false, true);
    }

    private boolean i(long j2) {
        if (com.igexin.push.core.e.U == j2) {
            return false;
        }
        com.igexin.push.core.e.U = j2;
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.14
            @Override // com.igexin.push.b.d
            public final void a_() {
                f.a();
                f.b(this.d, 32, String.valueOf(com.igexin.push.core.e.U));
            }
        }, false, true);
    }

    private boolean j(long j2) {
        if (com.igexin.push.core.e.c == j2) {
            return false;
        }
        com.igexin.push.core.e.c = j2;
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass21(), false, true);
    }

    public final boolean d(long j2) {
        if (com.igexin.push.core.e.aw == j2) {
            return false;
        }
        com.igexin.push.core.e.aw = j2;
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.24
            @Override // com.igexin.push.b.d
            public final void a_() throws Exception {
                f.a();
                f.b(this.d, 63, String.valueOf(com.igexin.push.core.e.aw));
            }
        }, false, true);
    }

    public static void a(SQLiteDatabase sQLiteDatabase, int i2, byte[] bArr) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(i2));
        contentValues.put(ActionUtils.PAYMENT_AMOUNT, bArr);
        sQLiteDatabase.replace(com.igexin.push.core.b.Z, null, contentValues);
    }

    public static /* synthetic */ byte[] f(String str) {
        return g.a(str.getBytes());
    }

    private static byte[] g(String str) {
        return g.a(str.getBytes());
    }

    private boolean h(String str) {
        com.igexin.push.core.e.C = str;
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass31(), false, true);
    }

    private boolean i(String str) {
        if (str.equals(com.igexin.push.core.e.V)) {
            return false;
        }
        com.igexin.push.core.e.V = str;
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass3(), false, true);
        return true;
    }

    private boolean j(String str) {
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass13(str), false, true);
    }

    public final boolean b() {
        com.igexin.push.core.e.z = 0L;
        com.igexin.push.core.e.A = com.igexin.push.core.b.m;
        d();
        return c();
    }

    public final boolean c(long j2) {
        if (com.igexin.push.core.e.Q == j2) {
            return false;
        }
        com.igexin.push.core.e.Q = j2;
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.15
            @Override // com.igexin.push.b.d
            public final void a_() {
                if (this.d != null) {
                    f.a();
                    f.b(this.d, 6, String.valueOf(com.igexin.push.core.e.Q));
                }
            }
        }, false, true);
    }

    public final boolean d(String str) {
        if (str.equals(com.igexin.push.core.e.Z)) {
            return false;
        }
        com.igexin.push.core.e.Z = str;
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.6
            @Override // com.igexin.push.b.d
            public final void a_() {
                f.a();
                f.b(this.d, 17, String.valueOf(com.igexin.push.core.e.Z));
            }
        }, false, true);
    }

    public final boolean e(final String str) {
        com.igexin.push.core.e.d = str.equals(com.igexin.push.core.b.m) ? null : str;
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.22
            @Override // com.igexin.push.b.d
            public final void a_() throws Exception {
                f.a();
                f.a(this.d, 61, g.a(str.getBytes()));
            }
        }, false, true);
    }

    public final void a(boolean z2) {
        com.igexin.push.core.e.W = z2;
        com.igexin.c.a.c.a.a(z2);
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.4
            @Override // com.igexin.push.b.d
            public final void a_() {
                f.a();
                f.b(this.d, 15, String.valueOf(com.igexin.push.core.e.W));
            }
        }, false, true);
    }

    public final boolean b(int i2) {
        if (com.igexin.push.core.e.aA == i2) {
            return false;
        }
        com.igexin.push.core.e.aA = i2;
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.16
            @Override // com.igexin.push.b.d
            public final void a_() {
                f.a();
                f.b(this.d, 47, String.valueOf(com.igexin.push.core.e.aA));
            }
        }, false, true);
    }

    public final boolean c(String str) {
        com.igexin.push.core.e.K = str;
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.33
            @Override // com.igexin.push.b.d
            public final void a_() {
                f.a();
                f.b(this.d, 48, com.igexin.push.core.e.K);
            }
        }, false, true);
    }

    public final boolean a(int i2) {
        com.igexin.push.core.e.ab = i2;
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.7
            @Override // com.igexin.push.b.d
            public final void a_() {
                f.a();
                f.b(this.d, 18, String.valueOf(com.igexin.push.core.e.ab));
            }
        }, false, true);
    }

    public final boolean b(final long j2) {
        com.igexin.push.core.e.ao = j2;
        com.igexin.c.a.c.a.a(f7227a + "|save idc config failed time : " + j2, new Object[0]);
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.2
            @Override // com.igexin.push.b.d
            public final void a_() {
                f.a();
                f.b(this.d, 21, String.valueOf(j2));
            }
        }, false, true);
    }

    public final boolean c(final String str, final boolean z2) {
        if (str == null) {
            return false;
        }
        String str2 = str.equals(com.igexin.push.core.b.m) ? null : str;
        if (z2 && !TextUtils.equals(com.igexin.push.core.e.au, str)) {
            com.igexin.push.core.e.au = str2;
        } else {
            if (z2 || TextUtils.equals(com.igexin.push.core.e.at, str)) {
                return false;
            }
            com.igexin.push.core.e.at = str2;
        }
        com.igexin.c.a.c.a.a(f7227a + "|saveLastRedirectCmList isMobile = " + z2 + ", lastRedirectCmList = " + str, new Object[0]);
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.19
            @Override // com.igexin.push.b.d
            public final void a_() throws Exception {
                f.a();
                f.a(this.d, z2 ? 50 : 49, f.f(str));
            }
        }, false, true);
    }

    public final boolean a(long j2) {
        com.igexin.push.core.e.a(j2);
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.29
            @Override // com.igexin.push.b.d
            public final void a_() throws Throwable {
                f.a();
                f.a(this.d, 1, g.a(String.valueOf(com.igexin.push.core.e.z).getBytes()));
                f.a();
                f.a(this.d, 20, f.f(com.igexin.push.core.e.A));
                j.b();
            }
        }, false, true);
    }

    public final boolean b(String str) {
        com.igexin.push.core.e.I = str;
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.32
            @Override // com.igexin.push.b.d
            public final void a_() {
                f.a();
                f.b(this.d, 46, com.igexin.push.core.e.I);
            }
        }, false, true);
    }

    public final boolean a(String str) {
        com.igexin.push.core.e.H = str;
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.30
            @Override // com.igexin.push.b.d
            public final void a_() throws Throwable {
                f.a();
                f.b(this.d, 2, com.igexin.push.core.e.H);
                String strD = j.d();
                if (strD == null || strD.length() <= 5) {
                    j.f();
                }
            }
        }, false, true);
    }

    public final boolean b(final String str, boolean z2) {
        com.igexin.c.a.b.e eVarA;
        com.igexin.push.b.d dVar;
        if (str == null) {
            return false;
        }
        if (z2) {
            if (!str.equals(com.igexin.push.core.e.ap)) {
                com.igexin.push.core.e.ap = str.equals(com.igexin.push.core.b.m) ? null : str;
                eVarA = com.igexin.c.a.b.e.a();
                dVar = new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.10
                    @Override // com.igexin.push.b.d
                    public final void a_() throws Exception {
                        f.a();
                        f.a(this.d, 23, f.f(str));
                    }
                };
                return eVarA.a((com.igexin.c.a.d.f) dVar, false, true);
            }
            return false;
        }
        if (!str.equals(com.igexin.push.core.e.aq)) {
            com.igexin.push.core.e.aq = str.equals(com.igexin.push.core.b.m) ? null : str;
            eVarA = com.igexin.c.a.b.e.a();
            dVar = new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.11
                @Override // com.igexin.push.b.d
                public final void a_() throws Exception {
                    f.a();
                    f.a(this.d, 22, f.f(str));
                }
            };
            return eVarA.a((com.igexin.c.a.d.f) dVar, false, true);
        }
        return false;
    }

    private boolean a(String str, String str2) {
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass20(str, str2), false, true);
    }

    public final boolean b(final boolean z2) {
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.18
            @Override // com.igexin.push.b.d
            public final void a_() {
                f.a();
                f.b(this.d, 40, String.valueOf(z2));
            }
        }, false, true);
    }

    private boolean a(String str, String str2, long j2) {
        com.igexin.push.core.e.z = j2;
        if (TextUtils.isEmpty(com.igexin.push.core.e.H)) {
            com.igexin.push.core.e.H = str2;
        }
        com.igexin.push.core.e.A = str;
        return c();
    }

    public final boolean a(final String str, boolean z2) {
        com.igexin.c.a.b.e eVarA;
        com.igexin.push.b.d dVar;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (z2) {
            if (!str.equals(com.igexin.push.core.e.ar)) {
                com.igexin.push.core.e.ar = str.equals(com.igexin.push.core.b.m) ? null : str;
                eVarA = com.igexin.c.a.b.e.a();
                dVar = new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.8
                    @Override // com.igexin.push.b.d
                    public final void a_() throws Exception {
                        f.a();
                        f.a(this.d, 31, f.f(str));
                    }
                };
                return eVarA.a((com.igexin.c.a.d.f) dVar, false, true);
            }
            return false;
        }
        if (!str.equals(com.igexin.push.core.e.as)) {
            com.igexin.push.core.e.as = str.equals(com.igexin.push.core.b.m) ? null : str;
            eVarA = com.igexin.c.a.b.e.a();
            dVar = new com.igexin.push.b.d() { // from class: com.igexin.push.core.e.f.9
                @Override // com.igexin.push.b.d
                public final void a_() throws Exception {
                    f.a();
                    f.a(this.d, 30, f.f(str));
                }
            };
            return eVarA.a((com.igexin.c.a.d.f) dVar, false, true);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0046 A[PHI: r10
      0x0046: PHI (r10v4 android.database.Cursor) = (r10v3 android.database.Cursor), (r10v5 android.database.Cursor) binds: [B:19:0x0044, B:12:0x003a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(SQLiteDatabase sQLiteDatabase, int i2) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor = null;
        try {
            cursorQuery = sQLiteDatabase.query(com.igexin.push.core.b.Z, new String[]{ActionUtils.PAYMENT_AMOUNT}, "id=".concat(String.valueOf(i2)), null, null, null, null);
            if (cursorQuery != null) {
                try {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            byte[] bArrA = com.igexin.c.a.a.a.a(cursorQuery.getBlob(cursorQuery.getColumnIndex(ActionUtils.PAYMENT_AMOUNT)), com.igexin.push.core.e.M);
                            cursorQuery.close();
                            return bArrA;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        com.igexin.c.a.c.a.a(e);
                        if (cursorQuery != null) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
            }
            throw th;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }
}
