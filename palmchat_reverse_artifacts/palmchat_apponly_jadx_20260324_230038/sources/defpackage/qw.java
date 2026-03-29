package defpackage;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.common.collect.ImmutableSet;
import com.zenmen.palmchat.utils.EncryptUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class qw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, pw> f20333a;
    public final SparseArray<String> b;
    public final SparseBooleanArray c;
    public final SparseBooleanArray d;
    public c e;

    @Nullable
    public c f;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a implements c {
        public static final String[] e = {"id", "key", "metadata"};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final fv0 f20334a;
        public final SparseArray<pw> b = new SparseArray<>();
        public String c;
        public String d;

        public a(fv0 fv0Var) {
            this.f20334a = fv0Var;
        }

        public static void d(fv0 fv0Var, String str) throws DatabaseIOException {
            try {
                String strH = h(str);
                SQLiteDatabase writableDatabase = fv0Var.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    u96.c(writableDatabase, 1, str);
                    f(writableDatabase, strH);
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e2) {
                throw new DatabaseIOException(e2);
            }
        }

        public static void f(SQLiteDatabase sQLiteDatabase, String str) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        }

        public static String h(String str) {
            return "ExoPlayerCacheIndex" + str;
        }

        @Override // qw.c
        public void a(pw pwVar) {
            this.b.put(pwVar.f20116a, pwVar);
        }

        @Override // qw.c
        public void b(pw pwVar, boolean z) {
            if (z) {
                this.b.delete(pwVar.f20116a);
            } else {
                this.b.put(pwVar.f20116a, null);
            }
        }

        public final void c(SQLiteDatabase sQLiteDatabase, pw pwVar) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            qw.t(pwVar.c(), new DataOutputStream(byteArrayOutputStream));
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Integer.valueOf(pwVar.f20116a));
            contentValues.put("key", pwVar.b);
            contentValues.put("metadata", byteArray);
            sQLiteDatabase.replaceOrThrow((String) vh.e(this.d), null, contentValues);
        }

        @Override // qw.c
        public void delete() throws DatabaseIOException {
            d(this.f20334a, (String) vh.e(this.c));
        }

        public final void e(SQLiteDatabase sQLiteDatabase, int i) {
            sQLiteDatabase.delete((String) vh.e(this.d), "id = ?", new String[]{Integer.toString(i)});
        }

        @Override // qw.c
        public boolean exists() throws DatabaseIOException {
            try {
                return u96.b(this.f20334a.getReadableDatabase(), 1, (String) vh.e(this.c)) != -1;
            } catch (SQLException e2) {
                throw new DatabaseIOException(e2);
            }
        }

        public final Cursor g() {
            return this.f20334a.getReadableDatabase().query((String) vh.e(this.d), e, null, null, null, null, null);
        }

        public final void i(SQLiteDatabase sQLiteDatabase) throws DatabaseIOException {
            u96.d(sQLiteDatabase, 1, (String) vh.e(this.c), 1);
            f(sQLiteDatabase, (String) vh.e(this.d));
            sQLiteDatabase.execSQL("CREATE TABLE " + this.d + " (id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)");
        }

        @Override // qw.c
        public void initialize(long j) {
            String hexString = Long.toHexString(j);
            this.c = hexString;
            this.d = h(hexString);
        }

        @Override // qw.c
        public void load(HashMap<String, pw> map, SparseArray<String> sparseArray) throws IOException {
            vh.g(this.b.size() == 0);
            try {
                if (u96.b(this.f20334a.getReadableDatabase(), 1, (String) vh.e(this.c)) != 1) {
                    SQLiteDatabase writableDatabase = this.f20334a.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        i(writableDatabase);
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                }
                Cursor cursorG = g();
                while (cursorG.moveToNext()) {
                    try {
                        pw pwVar = new pw(cursorG.getInt(0), (String) vh.e(cursorG.getString(1)), qw.q(new DataInputStream(new ByteArrayInputStream(cursorG.getBlob(2)))));
                        map.put(pwVar.b, pwVar);
                        sparseArray.put(pwVar.f20116a, pwVar.b);
                    } finally {
                    }
                }
                cursorG.close();
            } catch (SQLiteException e2) {
                map.clear();
                sparseArray.clear();
                throw new DatabaseIOException(e2);
            }
        }

        @Override // qw.c
        public void storeFully(HashMap<String, pw> map) throws IOException {
            try {
                SQLiteDatabase writableDatabase = this.f20334a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    i(writableDatabase);
                    Iterator<pw> it = map.values().iterator();
                    while (it.hasNext()) {
                        c(writableDatabase, it.next());
                    }
                    writableDatabase.setTransactionSuccessful();
                    this.b.clear();
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e2) {
                throw new DatabaseIOException(e2);
            }
        }

        @Override // qw.c
        public void storeIncremental(HashMap<String, pw> map) throws IOException {
            if (this.b.size() == 0) {
                return;
            }
            try {
                SQLiteDatabase writableDatabase = this.f20334a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                for (int i = 0; i < this.b.size(); i++) {
                    try {
                        pw pwVarValueAt = this.b.valueAt(i);
                        if (pwVarValueAt == null) {
                            e(writableDatabase, this.b.keyAt(i));
                        } else {
                            c(writableDatabase, pwVarValueAt);
                        }
                    } finally {
                        writableDatabase.endTransaction();
                    }
                }
                writableDatabase.setTransactionSuccessful();
                this.b.clear();
            } catch (SQLException e2) {
                throw new DatabaseIOException(e2);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a(pw pwVar);

        void b(pw pwVar, boolean z);

        void delete() throws IOException;

        boolean exists() throws IOException;

        void initialize(long j);

        void load(HashMap<String, pw> map, SparseArray<String> sparseArray) throws IOException;

        void storeFully(HashMap<String, pw> map) throws IOException;

        void storeIncremental(HashMap<String, pw> map) throws IOException;
    }

    public qw(@Nullable fv0 fv0Var, @Nullable File file, @Nullable byte[] bArr, boolean z, boolean z2) {
        vh.g((fv0Var == null && file == null) ? false : true);
        this.f20333a = new HashMap<>();
        this.b = new SparseArray<>();
        this.c = new SparseBooleanArray();
        this.d = new SparseBooleanArray();
        a aVar = fv0Var != null ? new a(fv0Var) : null;
        b bVar = file != null ? new b(new File(file, "cached_content_index.exi"), bArr, z) : null;
        if (aVar == null || (bVar != null && z2)) {
            this.e = (c) g86.j(bVar);
            this.f = aVar;
        } else {
            this.e = aVar;
            this.f = bVar;
        }
    }

    @SuppressLint({"GetInstance"})
    public static Cipher i() throws NoSuchPaddingException, NoSuchAlgorithmException {
        if (g86.f17680a == 18) {
            try {
                return Cipher.getInstance("AES/CBC/PKCS5PADDING", "BC");
            } catch (Throwable unused) {
            }
        }
        return Cipher.getInstance("AES/CBC/PKCS5PADDING");
    }

    @VisibleForTesting
    public static int l(SparseArray<String> sparseArray) {
        int size = sparseArray.size();
        int i = 0;
        int iKeyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (iKeyAt >= 0) {
            return iKeyAt;
        }
        while (i < size && i == sparseArray.keyAt(i)) {
            i++;
        }
        return i;
    }

    public static boolean o(String str) {
        return str.startsWith("cached_content_index.exi");
    }

    public static e41 q(DataInputStream dataInputStream) throws IOException {
        int i = dataInputStream.readInt();
        HashMap map = new HashMap();
        for (int i2 = 0; i2 < i; i2++) {
            String utf = dataInputStream.readUTF();
            int i3 = dataInputStream.readInt();
            if (i3 < 0) {
                throw new IOException("Invalid value size: " + i3);
            }
            int iMin = Math.min(i3, BmLocated.ALIGN_RIGHT_BOTTOM);
            byte[] bArrCopyOf = g86.f;
            int i4 = 0;
            while (i4 != i3) {
                int i5 = i4 + iMin;
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, i5);
                dataInputStream.readFully(bArrCopyOf, i4, iMin);
                iMin = Math.min(i3 - i5, BmLocated.ALIGN_RIGHT_BOTTOM);
                i4 = i5;
            }
            map.put(utf, bArrCopyOf);
        }
        return new e41(map);
    }

    public static void t(e41 e41Var, DataOutputStream dataOutputStream) throws IOException {
        Set<Map.Entry<String, byte[]>> setD = e41Var.d();
        dataOutputStream.writeInt(setD.size());
        for (Map.Entry<String, byte[]> entry : setD) {
            dataOutputStream.writeUTF(entry.getKey());
            byte[] value = entry.getValue();
            dataOutputStream.writeInt(value.length);
            dataOutputStream.write(value);
        }
    }

    public final pw d(String str) {
        int iL = l(this.b);
        pw pwVar = new pw(iL, str);
        this.f20333a.put(str, pwVar);
        this.b.put(iL, str);
        this.d.put(iL, true);
        this.e.a(pwVar);
        return pwVar;
    }

    public void e(String str, mp0 mp0Var) {
        pw pwVarM = m(str);
        if (pwVarM.b(mp0Var)) {
            this.e.a(pwVarM);
        }
    }

    public int f(String str) {
        return m(str).f20116a;
    }

    @Nullable
    public pw g(String str) {
        return this.f20333a.get(str);
    }

    public Collection<pw> h() {
        return Collections.unmodifiableCollection(this.f20333a.values());
    }

    public lp0 j(String str) {
        pw pwVarG = g(str);
        return pwVarG != null ? pwVarG.c() : e41.c;
    }

    @Nullable
    public String k(int i) {
        return this.b.get(i);
    }

    public pw m(String str) {
        pw pwVar = this.f20333a.get(str);
        return pwVar == null ? d(str) : pwVar;
    }

    @WorkerThread
    public void n(long j) throws IOException {
        c cVar;
        this.e.initialize(j);
        c cVar2 = this.f;
        if (cVar2 != null) {
            cVar2.initialize(j);
        }
        if (this.e.exists() || (cVar = this.f) == null || !cVar.exists()) {
            this.e.load(this.f20333a, this.b);
        } else {
            this.f.load(this.f20333a, this.b);
            this.e.storeFully(this.f20333a);
        }
        c cVar3 = this.f;
        if (cVar3 != null) {
            cVar3.delete();
            this.f = null;
        }
    }

    public void p(String str) {
        pw pwVar = this.f20333a.get(str);
        if (pwVar != null && pwVar.f() && pwVar.h()) {
            this.f20333a.remove(str);
            int i = pwVar.f20116a;
            boolean z = this.d.get(i);
            this.e.b(pwVar, z);
            if (z) {
                this.b.remove(i);
                this.d.delete(i);
            } else {
                this.b.put(i, null);
                this.c.put(i, true);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void r() {
        o46 it = ImmutableSet.copyOf((Collection) this.f20333a.keySet()).iterator();
        while (it.hasNext()) {
            p((String) it.next());
        }
    }

    @WorkerThread
    public void s() throws IOException {
        this.e.storeIncremental(this.f20333a);
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            this.b.remove(this.c.keyAt(i));
        }
        this.c.clear();
        this.d.clear();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f20335a;

        @Nullable
        public final Cipher b;

        @Nullable
        public final SecretKeySpec c;

        @Nullable
        public final SecureRandom d;
        public final xi e;
        public boolean f;

        @Nullable
        public vx4 g;

        public b(File file, @Nullable byte[] bArr, boolean z) {
            Cipher cipherI;
            SecretKeySpec secretKeySpec;
            vh.g((bArr == null && z) ? false : true);
            if (bArr != null) {
                vh.a(bArr.length == 16);
                try {
                    cipherI = qw.i();
                    secretKeySpec = new SecretKeySpec(bArr, EncryptUtils.AES_ENCRYPT_ALGORITHM);
                } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
                    throw new IllegalStateException(e);
                }
            } else {
                vh.a(!z);
                cipherI = null;
                secretKeySpec = null;
            }
            this.f20335a = z;
            this.b = cipherI;
            this.c = secretKeySpec;
            this.d = z ? new SecureRandom() : null;
            this.e = new xi(file);
        }

        @Override // qw.c
        public void a(pw pwVar) {
            this.f = true;
        }

        @Override // qw.c
        public void b(pw pwVar, boolean z) {
            this.f = true;
        }

        public final int c(pw pwVar, int i) {
            int iHashCode = (pwVar.f20116a * 31) + pwVar.b.hashCode();
            if (i >= 2) {
                return (iHashCode * 31) + pwVar.c().hashCode();
            }
            long jA = ip0.a(pwVar.c());
            return (iHashCode * 31) + ((int) (jA ^ (jA >>> 32)));
        }

        public final pw d(int i, DataInputStream dataInputStream) throws IOException {
            e41 e41VarQ;
            int i2 = dataInputStream.readInt();
            String utf = dataInputStream.readUTF();
            if (i < 2) {
                long j = dataInputStream.readLong();
                mp0 mp0Var = new mp0();
                mp0.g(mp0Var, j);
                e41VarQ = e41.c.c(mp0Var);
            } else {
                e41VarQ = qw.q(dataInputStream);
            }
            return new pw(i2, utf, e41VarQ);
        }

        @Override // qw.c
        public void delete() {
            this.e.a();
        }

        public final boolean e(HashMap<String, pw> map, SparseArray<String> sparseArray) throws Throwable {
            BufferedInputStream bufferedInputStream;
            DataInputStream dataInputStream;
            if (!this.e.c()) {
                return true;
            }
            DataInputStream dataInputStream2 = null;
            try {
                bufferedInputStream = new BufferedInputStream(this.e.d());
                dataInputStream = new DataInputStream(bufferedInputStream);
            } catch (IOException unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                int i = dataInputStream.readInt();
                if (i >= 0 && i <= 2) {
                    if ((dataInputStream.readInt() & 1) != 0) {
                        if (this.b == null) {
                            g86.n(dataInputStream);
                            return false;
                        }
                        byte[] bArr = new byte[16];
                        dataInputStream.readFully(bArr);
                        try {
                            this.b.init(2, (Key) g86.j(this.c), new IvParameterSpec(bArr));
                            dataInputStream = new DataInputStream(new CipherInputStream(bufferedInputStream, this.b));
                        } catch (InvalidAlgorithmParameterException e) {
                            e = e;
                            throw new IllegalStateException(e);
                        } catch (InvalidKeyException e2) {
                            e = e2;
                            throw new IllegalStateException(e);
                        }
                    } else if (this.f20335a) {
                        this.f = true;
                    }
                    int i2 = dataInputStream.readInt();
                    int iC = 0;
                    for (int i3 = 0; i3 < i2; i3++) {
                        pw pwVarD = d(i, dataInputStream);
                        map.put(pwVarD.b, pwVarD);
                        sparseArray.put(pwVarD.f20116a, pwVarD.b);
                        iC += c(pwVarD, i);
                    }
                    int i4 = dataInputStream.readInt();
                    boolean z = dataInputStream.read() == -1;
                    if (i4 == iC && z) {
                        g86.n(dataInputStream);
                        return true;
                    }
                    g86.n(dataInputStream);
                    return false;
                }
                g86.n(dataInputStream);
                return false;
            } catch (IOException unused2) {
                dataInputStream2 = dataInputStream;
                if (dataInputStream2 != null) {
                    g86.n(dataInputStream2);
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                dataInputStream2 = dataInputStream;
                if (dataInputStream2 != null) {
                    g86.n(dataInputStream2);
                }
                throw th;
            }
        }

        @Override // qw.c
        public boolean exists() {
            return this.e.c();
        }

        public final void f(pw pwVar, DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeInt(pwVar.f20116a);
            dataOutputStream.writeUTF(pwVar.b);
            qw.t(pwVar.c(), dataOutputStream);
        }

        public final void g(HashMap<String, pw> map) throws Throwable {
            DataOutputStream dataOutputStream = null;
            try {
                OutputStream outputStreamF = this.e.f();
                vx4 vx4Var = this.g;
                if (vx4Var == null) {
                    this.g = new vx4(outputStreamF);
                } else {
                    vx4Var.a(outputStreamF);
                }
                vx4 vx4Var2 = this.g;
                DataOutputStream dataOutputStream2 = new DataOutputStream(vx4Var2);
                try {
                    dataOutputStream2.writeInt(2);
                    int iC = 0;
                    dataOutputStream2.writeInt(this.f20335a ? 1 : 0);
                    if (this.f20335a) {
                        byte[] bArr = new byte[16];
                        ((SecureRandom) g86.j(this.d)).nextBytes(bArr);
                        dataOutputStream2.write(bArr);
                        try {
                            ((Cipher) g86.j(this.b)).init(1, (Key) g86.j(this.c), new IvParameterSpec(bArr));
                            dataOutputStream2.flush();
                            dataOutputStream2 = new DataOutputStream(new CipherOutputStream(vx4Var2, this.b));
                        } catch (InvalidAlgorithmParameterException e) {
                            e = e;
                            throw new IllegalStateException(e);
                        } catch (InvalidKeyException e2) {
                            e = e2;
                            throw new IllegalStateException(e);
                        }
                    }
                    dataOutputStream2.writeInt(map.size());
                    for (pw pwVar : map.values()) {
                        f(pwVar, dataOutputStream2);
                        iC += c(pwVar, 2);
                    }
                    dataOutputStream2.writeInt(iC);
                    this.e.b(dataOutputStream2);
                    g86.n(null);
                } catch (Throwable th) {
                    th = th;
                    dataOutputStream = dataOutputStream2;
                    g86.n(dataOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        @Override // qw.c
        public void load(HashMap<String, pw> map, SparseArray<String> sparseArray) {
            vh.g(!this.f);
            if (e(map, sparseArray)) {
                return;
            }
            map.clear();
            sparseArray.clear();
            this.e.a();
        }

        @Override // qw.c
        public void storeFully(HashMap<String, pw> map) throws Throwable {
            g(map);
            this.f = false;
        }

        @Override // qw.c
        public void storeIncremental(HashMap<String, pw> map) throws Throwable {
            if (this.f) {
                storeFully(map);
            }
        }

        @Override // qw.c
        public void initialize(long j) {
        }
    }
}
