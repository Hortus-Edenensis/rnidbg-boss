package com.bytedance.sdk.component.iz.fx.u.u;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class u implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f5147a;
    private final File b;
    private final File iz;
    private final int jk;
    private Writer l;
    private final int n;
    final ExecutorService nr;
    private final File pn;
    private int s;
    private final File x;
    static final Pattern u = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final OutputStream fx = new OutputStream() { // from class: com.bytedance.sdk.component.iz.fx.u.u.u.2
        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
        }
    };
    private long t = 0;
    private final LinkedHashMap<String, nr> mv = new LinkedHashMap<>(0, 0.75f, true);
    private long k = -1;
    private long my = 0;
    private final Callable<Void> o = new Callable<Void>() { // from class: com.bytedance.sdk.component.iz.fx.u.u.u.1
        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (u.this) {
                if (u.this.l == null) {
                    return null;
                }
                u.this.x();
                if (u.this.pn()) {
                    u.this.b();
                    u.this.s = 0;
                }
                return null;
            }
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public final class fx implements Closeable {
        private final InputStream[] b;
        private final long fx;
        private final String nr;
        private final long[] pn;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.b) {
                com.bytedance.sdk.component.iz.fx.fx.nr.u(inputStream);
            }
        }

        public InputStream u(int i) {
            return this.b[i];
        }

        private fx(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.nr = str;
            this.fx = j;
            this.b = inputStreamArr;
            this.pn = jArr;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class nr {
        private boolean b;
        private final long[] fx;
        private long iz;
        private final String nr;
        private C0219u pn;

        private nr(String str) {
            this.nr = str;
            this.fx = new long[u.this.jk];
        }

        private IOException nr(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File nr(int i) {
            return new File(u.this.b, this.nr + "." + i + ".tmp");
        }

        public String u() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j : this.fx) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u(String[] strArr) throws IOException {
            if (strArr.length == u.this.jk) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.fx[i] = Long.parseLong(strArr[i]);
                    } catch (NumberFormatException unused) {
                        throw nr(strArr);
                    }
                }
                return;
            }
            throw nr(strArr);
        }

        public File u(int i) {
            return new File(u.this.b, this.nr + "." + i);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.iz.fx.u.u.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public final class C0219u {
        private boolean b;
        private final boolean[] fx;
        private final nr nr;
        private boolean pn;

        /* JADX INFO: renamed from: com.bytedance.sdk.component.iz.fx.u.u.u$u$u, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C0220u extends FilterOutputStream {
            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    C0219u.this.b = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    C0219u.this.b = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException unused) {
                    C0219u.this.b = true;
                }
            }

            private C0220u(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException unused) {
                    C0219u.this.b = true;
                }
            }
        }

        private C0219u(nr nrVar) {
            this.nr = nrVar;
            this.fx = nrVar.b ? null : new boolean[u.this.jk];
        }

        public void nr() throws IOException {
            u.this.u(this, false);
        }

        public OutputStream u(int i) throws IOException {
            FileOutputStream fileOutputStream;
            C0220u c0220u;
            if (i < 0 || i >= u.this.jk) {
                throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + u.this.jk);
            }
            synchronized (u.this) {
                if (this.nr.pn == this) {
                    if (!this.nr.b) {
                        this.fx[i] = true;
                    }
                    File fileNr = this.nr.nr(i);
                    try {
                        fileOutputStream = new FileOutputStream(fileNr);
                    } catch (FileNotFoundException unused) {
                        u.this.b.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(fileNr);
                        } catch (FileNotFoundException unused2) {
                            return u.fx;
                        }
                    }
                    c0220u = new C0220u(fileOutputStream);
                } else {
                    throw new IllegalStateException();
                }
            }
            return c0220u;
        }

        public void u() throws IOException {
            if (this.b) {
                u.this.u(this, false);
                u.this.fx(this.nr.nr);
            } else {
                u.this.u(this, true);
            }
            this.pn = true;
        }
    }

    private u(File file, int i, int i2, long j, ExecutorService executorService) {
        this.b = file;
        this.n = i;
        this.pn = new File(file, "journal");
        this.iz = new File(file, "journal.tmp");
        this.x = new File(file, "journal.bkp");
        this.jk = i2;
        this.f5147a = j;
        this.nr = executorService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() throws IOException {
        long j = this.f5147a;
        long j2 = this.k;
        if (j2 >= 0) {
            j = j2;
        }
        while (this.t > j) {
            fx(this.mv.entrySet().iterator().next().getKey());
        }
        this.k = -1L;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.l == null) {
            return;
        }
        for (nr nrVar : new ArrayList(this.mv.values())) {
            if (nrVar.pn != null) {
                nrVar.pn.nr();
            }
        }
        x();
        this.l.close();
        this.l = null;
    }

    public void delete() throws IOException {
        close();
        b.u(this.b);
    }

    private void b(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.mv.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        nr nrVar = this.mv.get(strSubstring);
        if (nrVar == null) {
            nrVar = new nr(strSubstring);
            this.mv.put(strSubstring, nrVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            nrVar.b = true;
            nrVar.pn = null;
            nrVar.u(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            nrVar.pn = new C0219u(nrVar);
        } else if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
    }

    private void fx() throws IOException {
        u(this.iz);
        Iterator<nr> it = this.mv.values().iterator();
        while (it.hasNext()) {
            nr next = it.next();
            int i = 0;
            if (next.pn == null) {
                while (i < this.jk) {
                    this.t += next.fx[i];
                    i++;
                }
            } else {
                next.pn = null;
                while (i < this.jk) {
                    u(next.u(i));
                    u(next.nr(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    private void iz() {
        if (this.l == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void nr() throws IOException {
        com.bytedance.sdk.component.iz.fx.u.u.fx fxVar = new com.bytedance.sdk.component.iz.fx.u.u.fx(new FileInputStream(this.pn), b.u);
        try {
            String strU = fxVar.u();
            String strU2 = fxVar.u();
            String strU3 = fxVar.u();
            String strU4 = fxVar.u();
            String strU5 = fxVar.u();
            if (!"libcore.io.DiskLruCache".equals(strU) || !"1".equals(strU2) || !Integer.toString(this.n).equals(strU3) || !Integer.toString(this.jk).equals(strU4) || !"".equals(strU5)) {
                throw new IOException("unexpected journal header: [" + strU + ", " + strU2 + ", " + strU4 + ", " + strU5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    b(fxVar.u());
                    i++;
                } catch (EOFException unused) {
                    this.s = i - this.mv.size();
                    if (fxVar.nr()) {
                        b();
                    } else {
                        this.l = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.pn, true), b.u));
                    }
                    com.bytedance.sdk.component.iz.fx.fx.nr.u(fxVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.iz.fx.fx.nr.u(fxVar);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pn() {
        int i = this.s;
        return i >= 2000 && i >= this.mv.size();
    }

    private void pn(String str) {
        if (u.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    public static u u(File file, int i, int i2, long j, ExecutorService executorService) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    u(file2, file3, false);
                }
            }
            u uVar = new u(file, i, i2, j, executorService);
            if (uVar.pn.exists()) {
                try {
                    uVar.nr();
                    uVar.fx();
                    return uVar;
                } catch (IOException e) {
                    e.getMessage();
                    uVar.delete();
                }
            }
            file.mkdirs();
            u uVar2 = new u(file, i, i2, j, executorService);
            uVar2.b();
            return uVar2;
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    public synchronized boolean fx(String str) throws IOException {
        iz();
        pn(str);
        nr nrVar = this.mv.get(str);
        if (nrVar != null && nrVar.pn == null) {
            for (int i = 0; i < this.jk; i++) {
                File fileU = nrVar.u(i);
                if (fileU.exists() && !fileU.delete()) {
                    throw new IOException("failed to delete ".concat(String.valueOf(fileU)));
                }
                this.t -= nrVar.fx[i];
                nrVar.fx[i] = 0;
            }
            this.s++;
            this.l.append((CharSequence) ("REMOVE " + str + '\n'));
            this.mv.remove(str);
            if (pn()) {
                this.nr.submit(this.o);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b() throws IOException {
        Writer writer = this.l;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.iz), b.u));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.n));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.jk));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (nr nrVar : this.mv.values()) {
                if (nrVar.pn != null) {
                    bufferedWriter.write("DIRTY " + nrVar.nr + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + nrVar.nr + nrVar.u() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.pn.exists()) {
                u(this.pn, this.x, true);
            }
            u(this.iz, this.pn, false);
            this.x.delete();
            this.l = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.pn, true), b.u));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    private static void u(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public C0219u nr(String str) throws IOException {
        return u(str, -1L);
    }

    private static void u(File file, File file2, boolean z) throws IOException {
        if (z) {
            u(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public synchronized fx u(String str) throws IOException {
        InputStream inputStream;
        iz();
        pn(str);
        nr nrVar = this.mv.get(str);
        if (nrVar == null) {
            return null;
        }
        if (!nrVar.b) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.jk];
        for (int i = 0; i < this.jk; i++) {
            try {
                inputStreamArr[i] = new FileInputStream(nrVar.u(i));
            } catch (FileNotFoundException unused) {
                for (int i2 = 0; i2 < this.jk && (inputStream = inputStreamArr[i2]) != null; i2++) {
                    com.bytedance.sdk.component.iz.fx.fx.nr.u(inputStream);
                }
                return null;
            }
        }
        this.s++;
        this.l.append((CharSequence) ("READ " + str + '\n'));
        if (pn()) {
            this.nr.submit(this.o);
        }
        return new fx(str, nrVar.iz, inputStreamArr, nrVar.fx);
    }

    private synchronized C0219u u(String str, long j) throws IOException {
        iz();
        pn(str);
        nr nrVar = this.mv.get(str);
        if (j != -1 && (nrVar == null || nrVar.iz != j)) {
            return null;
        }
        if (nrVar != null) {
            if (nrVar.pn != null) {
                return null;
            }
        } else {
            nrVar = new nr(str);
            this.mv.put(str, nrVar);
        }
        C0219u c0219u = new C0219u(nrVar);
        nrVar.pn = c0219u;
        this.l.write("DIRTY " + str + '\n');
        this.l.flush();
        return c0219u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void u(C0219u c0219u, boolean z) throws IOException {
        nr nrVar = c0219u.nr;
        if (nrVar.pn == c0219u) {
            if (z && !nrVar.b) {
                for (int i = 0; i < this.jk; i++) {
                    if (c0219u.fx[i]) {
                        if (!nrVar.nr(i).exists()) {
                            c0219u.nr();
                            return;
                        }
                    } else {
                        c0219u.nr();
                        throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i)));
                    }
                }
            }
            for (int i2 = 0; i2 < this.jk; i2++) {
                File fileNr = nrVar.nr(i2);
                if (z) {
                    if (fileNr.exists()) {
                        File fileU = nrVar.u(i2);
                        fileNr.renameTo(fileU);
                        long j = nrVar.fx[i2];
                        long length = fileU.length();
                        nrVar.fx[i2] = length;
                        this.t = (this.t - j) + length;
                    }
                } else {
                    u(fileNr);
                }
            }
            this.s++;
            nrVar.pn = null;
            if (!(nrVar.b | z)) {
                this.mv.remove(nrVar.nr);
                this.l.write("REMOVE " + nrVar.nr + '\n');
            } else {
                nrVar.b = true;
                this.l.write("CLEAN " + nrVar.nr + nrVar.u() + '\n');
                if (z) {
                    long j2 = this.my;
                    this.my = 1 + j2;
                    nrVar.iz = j2;
                }
            }
            this.l.flush();
            if (this.t > this.f5147a || pn()) {
                this.nr.submit(this.o);
            }
            return;
        }
        throw new IllegalStateException();
    }

    public synchronized void u() throws IOException {
        iz();
        x();
        this.l.flush();
    }

    public void u(long j) {
        this.k = j;
        this.nr.submit(this.o);
    }
}
