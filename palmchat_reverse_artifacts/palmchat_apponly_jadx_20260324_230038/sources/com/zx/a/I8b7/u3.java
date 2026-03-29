package com.zx.a.I8b7;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Base64;
import com.qq.gdt.action.ActionUtils;
import com.zenmen.palmchat.utils.EncryptUtils;
import com.zx.a.I8b7.l2;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class u3 extends c {
    public SQLiteDatabase b = null;

    @Override // com.zx.a.I8b7.c
    public String a() {
        return "CREATE TABLE IF NOT EXISTS zx_table (key integer primary key, value text)";
    }

    public void b(int i) {
        if (i != m3.r) {
            m3.r = i;
            m3.t = -1;
            a(14, m3.r + "", false);
            a(7, m3.t + "", false);
        }
    }

    @Override // com.zx.a.I8b7.c
    public String c() {
        return "zx_table";
    }

    public void d(int i) {
        if (i != m3.n) {
            m3.n = i;
            l2.a.f16824a.f16823a.a(3, m3.n + "", false);
            r2.a("syncId had changed refresh:" + i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003f A[DONT_GENERATE, PHI: r2
      0x003f: PHI (r2v2 android.database.Cursor) = (r2v1 android.database.Cursor), (r2v3 android.database.Cursor) binds: [B:12:0x003d, B:8:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int e() {
        Cursor cursorQuery = null;
        try {
            cursorQuery = b().query(c(), new String[]{"key", ActionUtils.PAYMENT_AMOUNT}, "key=20", null, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToNext()) {
                m3.s = Integer.parseInt(cursorQuery.getString(cursorQuery.getColumnIndex(ActionUtils.PAYMENT_AMOUNT)));
            }
        } catch (Throwable th) {
            try {
                r2.a(th);
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        if (cursorQuery != null) {
        }
        return m3.s;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003f A[DONT_GENERATE, PHI: r2
      0x003f: PHI (r2v2 android.database.Cursor) = (r2v1 android.database.Cursor), (r2v3 android.database.Cursor) binds: [B:12:0x003d, B:8:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int f() {
        Cursor cursorQuery = null;
        try {
            cursorQuery = b().query(c(), new String[]{"key", ActionUtils.PAYMENT_AMOUNT}, "key=14", null, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToNext()) {
                m3.r = Integer.parseInt(cursorQuery.getString(cursorQuery.getColumnIndex(ActionUtils.PAYMENT_AMOUNT)));
            }
        } catch (Throwable th) {
            try {
                r2.a(th);
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        if (cursorQuery != null) {
        }
        return m3.r;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0047 A[DONT_GENERATE, PHI: r1 r2
      0x0047: PHI (r1v3 android.database.Cursor) = (r1v2 android.database.Cursor), (r1v6 android.database.Cursor) binds: [B:16:0x0045, B:11:0x003d] A[DONT_GENERATE, DONT_INLINE]
      0x0047: PHI (r2v1 javax.crypto.spec.IvParameterSpec) = (r2v0 javax.crypto.spec.IvParameterSpec), (r2v4 javax.crypto.spec.IvParameterSpec) binds: [B:16:0x0045, B:11:0x003d] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public IvParameterSpec g() {
        Cursor cursorQuery;
        IvParameterSpec ivParameterSpec = null;
        try {
            cursorQuery = b().query(c(), new String[]{"key", ActionUtils.PAYMENT_AMOUNT}, "key=10", null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToNext()) {
                        ivParameterSpec = new IvParameterSpec(Base64.decode(cursorQuery.getString(cursorQuery.getColumnIndex(ActionUtils.PAYMENT_AMOUNT)), 0));
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        r2.a(th);
                    } finally {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
        if (cursorQuery != null) {
        }
        return ivParameterSpec;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003f A[DONT_GENERATE, PHI: r2
      0x003f: PHI (r2v2 android.database.Cursor) = (r2v1 android.database.Cursor), (r2v3 android.database.Cursor) binds: [B:12:0x003d, B:8:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int h() {
        Cursor cursorQuery = null;
        try {
            cursorQuery = b().query(c(), new String[]{"key", ActionUtils.PAYMENT_AMOUNT}, "key=7", null, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToNext()) {
                m3.t = Integer.parseInt(cursorQuery.getString(cursorQuery.getColumnIndex(ActionUtils.PAYMENT_AMOUNT)));
            }
        } catch (Throwable th) {
            try {
                r2.a(th);
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        if (cursorQuery != null) {
        }
        return m3.t;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004b A[DONT_GENERATE, PHI: r1 r2
      0x004b: PHI (r1v3 android.database.Cursor) = (r1v2 android.database.Cursor), (r1v6 android.database.Cursor) binds: [B:16:0x0049, B:11:0x0041] A[DONT_GENERATE, DONT_INLINE]
      0x004b: PHI (r2v1 javax.crypto.spec.SecretKeySpec) = (r2v0 javax.crypto.spec.SecretKeySpec), (r2v4 javax.crypto.spec.SecretKeySpec) binds: [B:16:0x0049, B:11:0x0041] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SecretKey i() {
        Cursor cursorQuery;
        SecretKeySpec secretKeySpec = null;
        try {
            cursorQuery = b().query(c(), new String[]{"key", ActionUtils.PAYMENT_AMOUNT}, "key=9", null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToNext()) {
                        byte[] bArrDecode = Base64.decode(cursorQuery.getString(cursorQuery.getColumnIndex(ActionUtils.PAYMENT_AMOUNT)), 0);
                        SecureRandom secureRandom = p.f16841a;
                        secretKeySpec = new SecretKeySpec(bArrDecode, EncryptUtils.AES_ENCRYPT_ALGORITHM);
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        r2.a(th);
                    } finally {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
        if (cursorQuery != null) {
        }
        return secretKeySpec;
    }

    @Override // com.zx.a.I8b7.c
    public void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        r2.a("ZXID数据库升级, drop zx_table表");
        try {
            sQLiteDatabase.execSQL("drop table if exists zx_table");
        } catch (Exception e) {
            r2.a(e);
        }
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS zx_table (key integer primary key, value text)");
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public void c(int i) {
        if (i != m3.t) {
            m3.t = i;
            a(7, m3.t + "", false);
        }
    }

    public void a(byte[] bArr) {
        String str = new String(Base64.encode(bArr, 0), StandardCharsets.UTF_8);
        a(9, str + "", false);
        r2.a("ZXID saveSecretKey secretStr:" + str);
    }

    public final void a(int i, String str, boolean z) {
        String str2;
        if (this.b == null) {
            this.b = d();
        }
        if (z) {
            try {
                str2 = new String(Base64.encode(p.b("AES/CBC/PKCS5Padding", m3.v, m3.w, str.getBytes()), 0), StandardCharsets.UTF_8);
            } catch (Exception e) {
                r2.b("ZXID updateDBValue valueID:" + i + ",value:" + str + ",error:" + e.toString());
                return;
            }
        } else {
            str2 = str;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("key", Integer.valueOf(i));
        contentValues.put(ActionUtils.PAYMENT_AMOUNT, str2);
        r2.a("replace resultId = " + this.b.replace("zx_table", null, contentValues));
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0060 A[DONT_GENERATE, PHI: r1 r3
      0x0060: PHI (r1v2 java.lang.String) = (r1v1 java.lang.String), (r1v4 java.lang.String) binds: [B:13:0x005e, B:9:0x0057] A[DONT_GENERATE, DONT_INLINE]
      0x0060: PHI (r3v2 android.database.Cursor) = (r3v1 android.database.Cursor), (r3v3 android.database.Cursor) binds: [B:13:0x005e, B:9:0x0057] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(int i) {
        String string = "";
        Cursor cursorQuery = null;
        try {
            cursorQuery = b().query(c(), new String[]{"key", ActionUtils.PAYMENT_AMOUNT}, "key=" + i, null, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToNext()) {
                string = cursorQuery.getString(cursorQuery.getColumnIndex(ActionUtils.PAYMENT_AMOUNT));
                string = new String(p.a("AES/CBC/PKCS5Padding", m3.v, m3.w, Base64.decode(string, 0)), StandardCharsets.UTF_8);
            }
        } catch (Throwable th) {
            try {
                r2.a(th);
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        if (cursorQuery != null) {
        }
        return string;
    }

    public final void a(String str, byte[] bArr) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        File file = new File(m3.f16830a.getFilesDir().getAbsolutePath() + File.separator + "zx-core-" + str + ".zip");
        if (file.createNewFile()) {
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            byte[] bArr2 = new byte[2048];
            while (true) {
                int i = byteArrayInputStream.read(bArr2);
                if (i != -1) {
                    fileOutputStream.write(bArr2, 0, i);
                } else {
                    fileOutputStream.close();
                    byteArrayInputStream.close();
                    return;
                }
            }
        } else {
            throw new IOException("zx createNewFile exception");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str) {
        Cursor cursor;
        Cursor cursorQuery;
        IvParameterSpec ivParameterSpecG;
        SecretKey secretKeyI;
        JSONObject jSONObjectA;
        try {
            ivParameterSpecG = g();
            secretKeyI = i();
            jSONObjectA = a(ivParameterSpecG, secretKeyI);
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
            if (jSONObjectA == null) {
                return;
            }
            String string = jSONObjectA.getString("mainVersion");
            String string2 = jSONObjectA.getString("checksum");
            if (TextUtils.equals(string, str)) {
                cursorQuery = b().query("zx_table", new String[]{"key", ActionUtils.PAYMENT_AMOUNT}, "key=17", null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToNext()) {
                            byte[] bArrA = p.a("AES/CBC/PKCS5Padding", secretKeyI, ivParameterSpecG, Base64.decode(cursorQuery.getString(cursorQuery.getColumnIndex(ActionUtils.PAYMENT_AMOUNT)), 0));
                            if (TextUtils.equals(string2, p.a("SHA256", bArrA))) {
                                a(str, bArrA);
                            } else {
                                throw new IOException("zx checksum1 exception");
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = cursorQuery;
                        r2.a(th);
                        if (cursor == null) {
                        }
                    }
                }
                if (cursorQuery == null) {
                    return;
                }
                cursorQuery.close();
            }
            return;
            r2.a(th);
            if (cursor == null) {
                cursorQuery = cursor;
                cursorQuery.close();
            }
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0054 A[DONT_GENERATE, PHI: r1
      0x0054: PHI (r1v3 android.database.Cursor) = (r1v2 android.database.Cursor), (r1v6 android.database.Cursor) binds: [B:17:0x0052, B:12:0x004a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject a(IvParameterSpec ivParameterSpec, SecretKey secretKey) {
        Cursor cursorQuery;
        try {
            cursorQuery = b().query("zx_table", new String[]{"key", ActionUtils.PAYMENT_AMOUNT}, "key=18", null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToNext()) {
                        JSONObject jSONObject = new JSONObject(new String(p.a("AES/CBC/PKCS5Padding", secretKey, ivParameterSpec, Base64.decode(cursorQuery.getString(cursorQuery.getColumnIndex(ActionUtils.PAYMENT_AMOUNT)), 0)), StandardCharsets.UTF_8));
                        cursorQuery.close();
                        return jSONObject;
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        r2.a(th);
                    } finally {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
        if (cursorQuery != null) {
        }
        return null;
    }
}
