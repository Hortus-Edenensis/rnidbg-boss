package com.google.android.exoplayer2.upstream.cache;

import android.os.ConditionVariable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.cache.Cache;
import defpackage.cd5;
import defpackage.dw;
import defpackage.ew;
import defpackage.fv0;
import defpackage.ip0;
import defpackage.lp0;
import defpackage.mp0;
import defpackage.nw;
import defpackage.pw;
import defpackage.qw;
import defpackage.vh;
import defpackage.y53;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class c implements Cache {
    public static final HashSet<File> l = new HashSet<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f6019a;
    public final b b;
    public final qw c;

    @Nullable
    public final ew d;
    public final HashMap<String, ArrayList<Cache.a>> e;
    public final Random f;
    public final boolean g;
    public long h;
    public long i;
    public boolean j;
    public Cache.CacheException k;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConditionVariable f6020a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, ConditionVariable conditionVariable) {
            super(str);
            this.f6020a = conditionVariable;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            synchronized (c.this) {
                this.f6020a.open();
                c.this.k();
                c.this.b.onCacheInitialized();
            }
        }
    }

    public c(File file, b bVar, fv0 fv0Var) {
        this(file, bVar, fv0Var, null, false, false);
    }

    public static void h(File file) throws Cache.CacheException {
        if (file.mkdirs() || file.isDirectory()) {
            return;
        }
        String str = "Failed to create cache directory: " + file;
        y53.c("SimpleCache", str);
        throw new Cache.CacheException(str);
    }

    public static long i(File file) throws IOException {
        long jNextLong = new SecureRandom().nextLong();
        long jAbs = jNextLong == Long.MIN_VALUE ? 0L : Math.abs(jNextLong);
        File file2 = new File(file, Long.toString(jAbs, 16) + ".uid");
        if (file2.createNewFile()) {
            return jAbs;
        }
        throw new IOException("Failed to create UID file: " + file2);
    }

    public static long m(File[] fileArr) {
        int length = fileArr.length;
        for (int i = 0; i < length; i++) {
            File file = fileArr[i];
            String name = file.getName();
            if (name.endsWith(".uid")) {
                try {
                    return r(name);
                } catch (NumberFormatException unused) {
                    y53.c("SimpleCache", "Malformed UID file: " + file);
                    file.delete();
                }
            }
        }
        return -1L;
    }

    public static synchronized boolean n(File file) {
        return l.add(file.getAbsoluteFile());
    }

    public static long r(String str) {
        return Long.parseLong(str.substring(0, str.indexOf(46)), 16);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void a(nw nwVar) {
        vh.g(!this.j);
        s(nwVar);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void b(nw nwVar) {
        vh.g(!this.j);
        pw pwVar = (pw) vh.e(this.c.g(nwVar.f19628a));
        pwVar.l(nwVar.b);
        this.c.p(pwVar.b);
        notifyAll();
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void c(String str, mp0 mp0Var) throws Cache.CacheException {
        vh.g(!this.j);
        g();
        this.c.e(str, mp0Var);
        try {
            this.c.s();
        } catch (IOException e) {
            throw new Cache.CacheException(e);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void commitFile(File file, long j) throws Cache.CacheException {
        boolean z = true;
        vh.g(!this.j);
        if (file.exists()) {
            if (j == 0) {
                file.delete();
                return;
            }
            cd5 cd5Var = (cd5) vh.e(cd5.f(file, j, this.c));
            pw pwVar = (pw) vh.e(this.c.g(cd5Var.f19628a));
            vh.g(pwVar.g(cd5Var.b, cd5Var.c));
            long jA = ip0.a(pwVar.c());
            if (jA != -1) {
                if (cd5Var.b + cd5Var.c > jA) {
                    z = false;
                }
                vh.g(z);
            }
            if (this.d == null) {
                f(cd5Var);
                this.c.s();
                notifyAll();
                return;
            }
            try {
                this.d.h(file.getName(), cd5Var.c, cd5Var.f);
                f(cd5Var);
                try {
                    this.c.s();
                    notifyAll();
                    return;
                } catch (IOException e) {
                    throw new Cache.CacheException(e);
                }
            } catch (IOException e2) {
                throw new Cache.CacheException(e2);
            }
        }
    }

    public final void f(cd5 cd5Var) {
        this.c.m(cd5Var.f19628a).a(cd5Var);
        this.i += cd5Var.c;
        o(cd5Var);
    }

    public synchronized void g() throws Cache.CacheException {
        Cache.CacheException cacheException = this.k;
        if (cacheException != null) {
            throw cacheException;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized lp0 getContentMetadata(String str) {
        vh.g(!this.j);
        return this.c.j(str);
    }

    public final cd5 j(String str, long j, long j2) {
        cd5 cd5VarD;
        pw pwVarG = this.c.g(str);
        if (pwVarG == null) {
            return cd5.g(str, j, j2);
        }
        while (true) {
            cd5VarD = pwVarG.d(j, j2);
            if (!cd5VarD.d || cd5VarD.e.length() == cd5VarD.c) {
                break;
            }
            t();
        }
        return cd5VarD;
    }

    public final void k() {
        if (!this.f6019a.exists()) {
            try {
                h(this.f6019a);
            } catch (Cache.CacheException e) {
                this.k = e;
                return;
            }
        }
        File[] fileArrListFiles = this.f6019a.listFiles();
        if (fileArrListFiles == null) {
            String str = "Failed to list cache directory files: " + this.f6019a;
            y53.c("SimpleCache", str);
            this.k = new Cache.CacheException(str);
            return;
        }
        long jM = m(fileArrListFiles);
        this.h = jM;
        if (jM == -1) {
            try {
                this.h = i(this.f6019a);
            } catch (IOException e2) {
                String str2 = "Failed to create cache UID: " + this.f6019a;
                y53.d("SimpleCache", str2, e2);
                this.k = new Cache.CacheException(str2, e2);
                return;
            }
        }
        try {
            this.c.n(this.h);
            ew ewVar = this.d;
            if (ewVar != null) {
                ewVar.e(this.h);
                Map<String, dw> mapB = this.d.b();
                l(this.f6019a, true, fileArrListFiles, mapB);
                this.d.g(mapB.keySet());
            } else {
                l(this.f6019a, true, fileArrListFiles, null);
            }
            this.c.r();
            try {
                this.c.s();
            } catch (IOException e3) {
                y53.d("SimpleCache", "Storing index file failed", e3);
            }
        } catch (IOException e4) {
            String str3 = "Failed to initialize cache indices: " + this.f6019a;
            y53.d("SimpleCache", str3, e4);
            this.k = new Cache.CacheException(str3, e4);
        }
    }

    public final void l(File file, boolean z, @Nullable File[] fileArr, @Nullable Map<String, dw> map) {
        long j;
        long j2;
        if (fileArr == null || fileArr.length == 0) {
            if (z) {
                return;
            }
            file.delete();
            return;
        }
        for (File file2 : fileArr) {
            String name = file2.getName();
            if (z && name.indexOf(46) == -1) {
                l(file2, false, file2.listFiles(), map);
            } else if (!z || (!qw.o(name) && !name.endsWith(".uid"))) {
                dw dwVarRemove = map != null ? map.remove(name) : null;
                if (dwVarRemove != null) {
                    j2 = dwVarRemove.f17144a;
                    j = dwVarRemove.b;
                } else {
                    j = -9223372036854775807L;
                    j2 = -1;
                }
                cd5 cd5VarE = cd5.e(file2, j2, j, this.c);
                if (cd5VarE != null) {
                    f(cd5VarE);
                } else {
                    file2.delete();
                }
            }
        }
    }

    public final void o(cd5 cd5Var) {
        ArrayList<Cache.a> arrayList = this.e.get(cd5Var.f19628a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).c(this, cd5Var);
            }
        }
        this.b.c(this, cd5Var);
    }

    public final void p(nw nwVar) {
        ArrayList<Cache.a> arrayList = this.e.get(nwVar.f19628a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).d(this, nwVar);
            }
        }
        this.b.d(this, nwVar);
    }

    public final void q(cd5 cd5Var, nw nwVar) {
        ArrayList<Cache.a> arrayList = this.e.get(cd5Var.f19628a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).a(this, cd5Var, nwVar);
            }
        }
        this.b.a(this, cd5Var, nwVar);
    }

    public final void s(nw nwVar) {
        pw pwVarG = this.c.g(nwVar.f19628a);
        if (pwVarG == null || !pwVarG.j(nwVar)) {
            return;
        }
        this.i -= nwVar.c;
        if (this.d != null) {
            String name = nwVar.e.getName();
            try {
                this.d.f(name);
            } catch (IOException unused) {
                y53.i("SimpleCache", "Failed to remove file index entry for: " + name);
            }
        }
        this.c.p(pwVarG.b);
        p(nwVar);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized File startFile(String str, long j, long j2) throws Cache.CacheException {
        pw pwVarG;
        File file;
        vh.g(!this.j);
        g();
        pwVarG = this.c.g(str);
        vh.e(pwVarG);
        vh.g(pwVarG.g(j, j2));
        if (!this.f6019a.exists()) {
            h(this.f6019a);
            t();
        }
        this.b.b(this, str, j, j2);
        file = new File(this.f6019a, Integer.toString(this.f.nextInt(10)));
        if (!file.exists()) {
            h(file);
        }
        return cd5.i(file, pwVarG.f20116a, j, System.currentTimeMillis());
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized nw startReadWrite(String str, long j, long j2) throws InterruptedException, Cache.CacheException {
        nw nwVarStartReadWriteNonBlocking;
        vh.g(!this.j);
        g();
        while (true) {
            nwVarStartReadWriteNonBlocking = startReadWriteNonBlocking(str, j, j2);
            if (nwVarStartReadWriteNonBlocking == null) {
                wait();
            }
        }
        return nwVarStartReadWriteNonBlocking;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    @Nullable
    public synchronized nw startReadWriteNonBlocking(String str, long j, long j2) throws Cache.CacheException {
        vh.g(!this.j);
        g();
        cd5 cd5VarJ = j(str, j, j2);
        if (cd5VarJ.d) {
            return u(str, cd5VarJ);
        }
        if (this.c.m(str).i(j, cd5VarJ.c)) {
            return cd5VarJ;
        }
        return null;
    }

    public final void t() {
        ArrayList arrayList = new ArrayList();
        Iterator<pw> it = this.c.h().iterator();
        while (it.hasNext()) {
            for (cd5 cd5Var : it.next().e()) {
                if (cd5Var.e.length() != cd5Var.c) {
                    arrayList.add(cd5Var);
                }
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            s((nw) arrayList.get(i));
        }
    }

    public final cd5 u(String str, cd5 cd5Var) {
        boolean z;
        if (!this.g) {
            return cd5Var;
        }
        String name = ((File) vh.e(cd5Var.e)).getName();
        long j = cd5Var.c;
        long jCurrentTimeMillis = System.currentTimeMillis();
        ew ewVar = this.d;
        if (ewVar != null) {
            try {
                ewVar.h(name, j, jCurrentTimeMillis);
            } catch (IOException unused) {
                y53.i("SimpleCache", "Failed to update index with new touch timestamp.");
            }
            z = false;
        } else {
            z = true;
        }
        cd5 cd5VarK = this.c.g(str).k(cd5Var, jCurrentTimeMillis, z);
        q(cd5Var, cd5VarK);
        return cd5VarK;
    }

    public c(File file, b bVar, @Nullable fv0 fv0Var, @Nullable byte[] bArr, boolean z, boolean z2) {
        this(file, bVar, new qw(fv0Var, file, bArr, z, z2), (fv0Var == null || z2) ? null : new ew(fv0Var));
    }

    public c(File file, b bVar, qw qwVar, @Nullable ew ewVar) {
        if (n(file)) {
            this.f6019a = file;
            this.b = bVar;
            this.c = qwVar;
            this.d = ewVar;
            this.e = new HashMap<>();
            this.f = new Random();
            this.g = bVar.requiresCacheSpanTouches();
            this.h = -1L;
            ConditionVariable conditionVariable = new ConditionVariable();
            new a("ExoPlayer:SimpleCacheInit", conditionVariable).start();
            conditionVariable.block();
            return;
        }
        throw new IllegalStateException("Another SimpleCache instance uses the folder: " + file);
    }
}
