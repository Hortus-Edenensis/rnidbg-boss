package com.bytedance.sdk.component.fx.nr.u.u;

import com.bytedance.sdk.component.fx.u.bg;
import com.bytedance.sdk.component.fx.u.l;
import com.bytedance.sdk.component.fx.u.sx;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements Closeable, Flushable {
    static final /* synthetic */ boolean mv = true;
    static final Pattern u = Pattern.compile("[a-z0-9_-]{1,120}");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f5138a;
    final int b;
    private long bg;
    private long bq;
    private final Runnable c;
    private final Executor dw;
    final File fx;
    final LinkedHashMap<String, nr> iz;
    boolean jk;
    private final File k;
    boolean l;
    private final File my;
    boolean n;
    final com.bytedance.sdk.component.fx.nr.u.iz.u nr;
    private final int o;
    com.bytedance.sdk.component.fx.u.b pn;
    private final File s;
    private long sx;
    boolean t;
    int x;

    /* JADX INFO: compiled from: SearchBox */
    public final class fx implements Closeable {
        private final bg[] b;
        private final long fx;
        private final String nr;
        final /* synthetic */ b u;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (bg bgVar : this.b) {
                com.bytedance.sdk.component.fx.nr.u.fx.u(bgVar);
            }
        }

        public u u() throws IOException {
            return this.u.u(this.nr, this.fx);
        }
    }

    private synchronized void a() {
        if (b()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void iz() throws IOException {
        com.bytedance.sdk.component.fx.u.pn pnVarU = l.u(this.nr.u(this.s));
        try {
            String strMy = pnVarU.my();
            String strMy2 = pnVarU.my();
            String strMy3 = pnVarU.my();
            String strMy4 = pnVarU.my();
            String strMy5 = pnVarU.my();
            if (!"libcore.io.DiskLruCache".equals(strMy) || !"1".equals(strMy2) || !Integer.toString(this.o).equals(strMy3) || !Integer.toString(this.b).equals(strMy4) || !"".equals(strMy5)) {
                throw new IOException("unexpected journal header: [" + strMy + ", " + strMy2 + ", " + strMy4 + ", " + strMy5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    u(pnVarU.my());
                    i++;
                } catch (EOFException unused) {
                    this.x = i - this.iz.size();
                    if (pnVarU.pn()) {
                        this.pn = x();
                    } else {
                        nr();
                    }
                    com.bytedance.sdk.component.fx.nr.u.fx.u(pnVarU);
                    return;
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.fx.nr.u.fx.u(pnVarU);
            throw th;
        }
    }

    private void n() throws IOException {
        this.nr.delete(this.k);
        Iterator<nr> it = this.iz.values().iterator();
        while (it.hasNext()) {
            nr next = it.next();
            int i = 0;
            if (next.iz == null) {
                while (i < this.b) {
                    this.bg += next.nr[i];
                    i++;
                }
            } else {
                next.iz = null;
                while (i < this.b) {
                    this.nr.delete(next.fx[i]);
                    this.nr.delete(next.b[i]);
                    i++;
                }
                it.remove();
            }
        }
    }

    private com.bytedance.sdk.component.fx.u.b x() throws FileNotFoundException {
        return l.u(new pn(this.nr.fx(this.s)) { // from class: com.bytedance.sdk.component.fx.nr.u.u.b.1
            static final /* synthetic */ boolean u = true;

            @Override // com.bytedance.sdk.component.fx.nr.u.u.pn
            public void u(IOException iOException) {
                if (!u && !Thread.holdsLock(b.this)) {
                    throw new AssertionError();
                }
                b.this.n = true;
            }
        });
    }

    public synchronized boolean b() {
        return this.jk;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.f5138a && !this.jk) {
            for (nr nrVar : (nr[]) this.iz.values().toArray(new nr[this.iz.size()])) {
                u uVar = nrVar.iz;
                if (uVar != null) {
                    uVar.fx();
                }
            }
            pn();
            this.pn.close();
            this.pn = null;
            this.jk = true;
            return;
        }
        this.jk = true;
    }

    public void delete() throws IOException {
        close();
        this.nr.iz(this.fx);
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.f5138a) {
            a();
            pn();
            this.pn.flush();
        }
    }

    public boolean fx() {
        int i = this.x;
        return i >= 2000 && i >= this.iz.size();
    }

    public synchronized void nr() throws IOException {
        com.bytedance.sdk.component.fx.u.b bVar = this.pn;
        if (bVar != null) {
            bVar.close();
        }
        com.bytedance.sdk.component.fx.u.b bVarU = l.u(this.nr.nr(this.k));
        try {
            bVarU.nr("libcore.io.DiskLruCache").a(10);
            bVarU.nr("1").a(10);
            bVarU.l(this.o).a(10);
            bVarU.l(this.b).a(10);
            bVarU.a(10);
            for (nr nrVar : this.iz.values()) {
                if (nrVar.iz != null) {
                    bVarU.nr("DIRTY").a(32);
                    bVarU.nr(nrVar.u);
                    bVarU.a(10);
                } else {
                    bVarU.nr("CLEAN").a(32);
                    bVarU.nr(nrVar.u);
                    nrVar.u(bVarU);
                    bVarU.a(10);
                }
            }
            bVarU.close();
            if (this.nr.b(this.s)) {
                this.nr.u(this.s, this.my);
            }
            this.nr.u(this.k, this.s);
            this.nr.delete(this.my);
            this.pn = x();
            this.n = false;
            this.l = false;
        } catch (Throwable th) {
            bVarU.close();
            throw th;
        }
    }

    public void pn() throws IOException {
        while (this.bg > this.sx) {
            u(this.iz.values().iterator().next());
        }
        this.t = false;
    }

    public synchronized void u() throws IOException {
        if (!mv && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (this.f5138a) {
            return;
        }
        if (this.nr.b(this.my)) {
            if (this.nr.b(this.s)) {
                this.nr.delete(this.my);
            } else {
                this.nr.u(this.my, this.s);
            }
        }
        if (this.nr.b(this.s)) {
            try {
                iz();
                n();
                this.f5138a = true;
                return;
            } catch (IOException e) {
                com.bytedance.sdk.component.fx.nr.u.x.pn.nr().u(5, "DiskLruCache " + this.fx + " is corrupt: " + e.getMessage() + ", removing", e);
                try {
                    delete();
                    this.jk = false;
                    nr();
                    this.f5138a = true;
                } catch (Throwable th) {
                    this.jk = false;
                    throw th;
                }
            }
        }
        nr();
        this.f5138a = true;
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class u {
        private boolean b;
        final boolean[] nr;
        final nr u;

        public u(nr nrVar) {
            this.u = nrVar;
            this.nr = nrVar.pn ? null : new boolean[b.this.b];
        }

        public void fx() throws IOException {
            synchronized (b.this) {
                if (this.b) {
                    throw new IllegalStateException();
                }
                if (this.u.iz == this) {
                    b.this.u(this, false);
                }
                this.b = true;
            }
        }

        public void nr() throws IOException {
            synchronized (b.this) {
                if (this.b) {
                    throw new IllegalStateException();
                }
                if (this.u.iz == this) {
                    b.this.u(this, true);
                }
                this.b = true;
            }
        }

        public void u() {
            if (this.u.iz != this) {
                return;
            }
            int i = 0;
            while (true) {
                b bVar = b.this;
                if (i >= bVar.b) {
                    this.u.iz = null;
                    return;
                } else {
                    try {
                        bVar.nr.delete(this.u.b[i]);
                    } catch (IOException unused) {
                    }
                    i++;
                }
            }
        }

        public sx u(int i) {
            synchronized (b.this) {
                if (!this.b) {
                    nr nrVar = this.u;
                    if (nrVar.iz != this) {
                        return l.u();
                    }
                    if (!nrVar.pn) {
                        this.nr[i] = true;
                    }
                    try {
                        return new pn(b.this.nr.nr(nrVar.b[i])) { // from class: com.bytedance.sdk.component.fx.nr.u.u.b.u.1
                            @Override // com.bytedance.sdk.component.fx.nr.u.u.pn
                            public void u(IOException iOException) {
                                synchronized (b.this) {
                                    u.this.u();
                                }
                            }
                        };
                    } catch (FileNotFoundException unused) {
                        return l.u();
                    }
                }
                throw new IllegalStateException();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class nr {
        final File[] b;
        final File[] fx;
        u iz;
        final long[] nr;
        boolean pn;
        final String u;
        long x;

        public nr(String str) {
            this.u = str;
            int i = b.this.b;
            this.nr = new long[i];
            this.fx = new File[i];
            this.b = new File[i];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i2 = 0; i2 < b.this.b; i2++) {
                sb.append(i2);
                this.fx[i2] = new File(b.this.fx, sb.toString());
                sb.append(".tmp");
                this.b[i2] = new File(b.this.fx, sb.toString());
                sb.setLength(length);
            }
        }

        private IOException nr(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public void u(String[] strArr) throws IOException {
            if (strArr.length != b.this.b) {
                throw nr(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.nr[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw nr(strArr);
                }
            }
        }

        public void u(com.bytedance.sdk.component.fx.u.b bVar) throws IOException {
            for (long j : this.nr) {
                bVar.a(32).l(j);
            }
        }
    }

    private void u(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf != -1) {
            int i = iIndexOf + 1;
            int iIndexOf2 = str.indexOf(32, i);
            if (iIndexOf2 == -1) {
                strSubstring = str.substring(i);
                if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                    this.iz.remove(strSubstring);
                    return;
                }
            } else {
                strSubstring = str.substring(i, iIndexOf2);
            }
            nr nrVar = this.iz.get(strSubstring);
            if (nrVar == null) {
                nrVar = new nr(strSubstring);
                this.iz.put(strSubstring, nrVar);
            }
            if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
                String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
                nrVar.pn = true;
                nrVar.iz = null;
                nrVar.u(strArrSplit);
                return;
            }
            if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
                nrVar.iz = new u(nrVar);
                return;
            } else {
                if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith("READ")) {
                    throw new IOException("unexpected journal line: ".concat(str));
                }
                return;
            }
        }
        throw new IOException("unexpected journal line: ".concat(str));
    }

    private void nr(String str) {
        if (u.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    public synchronized u u(String str, long j) throws IOException {
        u();
        a();
        nr(str);
        nr nrVar = this.iz.get(str);
        if (j != -1 && (nrVar == null || nrVar.x != j)) {
            return null;
        }
        if (nrVar != null && nrVar.iz != null) {
            return null;
        }
        if (!this.t && !this.l) {
            this.pn.nr("DIRTY").a(32).nr(str).a(10);
            this.pn.flush();
            if (this.n) {
                return null;
            }
            if (nrVar == null) {
                nrVar = new nr(str);
                this.iz.put(str, nrVar);
            }
            u uVar = new u(nrVar);
            nrVar.iz = uVar;
            return uVar;
        }
        this.dw.execute(this.c);
        return null;
    }

    public synchronized void u(u uVar, boolean z) throws IOException {
        nr nrVar = uVar.u;
        if (nrVar.iz == uVar) {
            if (z && !nrVar.pn) {
                for (int i = 0; i < this.b; i++) {
                    if (uVar.nr[i]) {
                        if (!this.nr.b(nrVar.b[i])) {
                            uVar.fx();
                            return;
                        }
                    } else {
                        uVar.fx();
                        throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i)));
                    }
                }
            }
            for (int i2 = 0; i2 < this.b; i2++) {
                File file = nrVar.b[i2];
                if (z) {
                    if (this.nr.b(file)) {
                        File file2 = nrVar.fx[i2];
                        this.nr.u(file, file2);
                        long j = nrVar.nr[i2];
                        long jPn = this.nr.pn(file2);
                        nrVar.nr[i2] = jPn;
                        this.bg = (this.bg - j) + jPn;
                    }
                } else {
                    this.nr.delete(file);
                }
            }
            this.x++;
            nrVar.iz = null;
            if (nrVar.pn | z) {
                nrVar.pn = true;
                this.pn.nr("CLEAN").a(32);
                this.pn.nr(nrVar.u);
                nrVar.u(this.pn);
                this.pn.a(10);
                if (z) {
                    long j2 = this.bq;
                    this.bq = 1 + j2;
                    nrVar.x = j2;
                }
            } else {
                this.iz.remove(nrVar.u);
                this.pn.nr("REMOVE").a(32);
                this.pn.nr(nrVar.u);
                this.pn.a(10);
            }
            this.pn.flush();
            if (this.bg > this.sx || fx()) {
                this.dw.execute(this.c);
            }
            return;
        }
        throw new IllegalStateException();
    }

    public boolean u(nr nrVar) throws IOException {
        u uVar = nrVar.iz;
        if (uVar != null) {
            uVar.u();
        }
        for (int i = 0; i < this.b; i++) {
            this.nr.delete(nrVar.fx[i]);
            long j = this.bg;
            long[] jArr = nrVar.nr;
            this.bg = j - jArr[i];
            jArr[i] = 0;
        }
        this.x++;
        this.pn.nr("REMOVE").a(32).nr(nrVar.u).a(10);
        this.iz.remove(nrVar.u);
        if (fx()) {
            this.dw.execute(this.c);
        }
        return true;
    }
}
