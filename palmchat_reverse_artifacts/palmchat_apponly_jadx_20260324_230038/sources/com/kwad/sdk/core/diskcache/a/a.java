package com.kwad.sdk.core.diskcache.a;

import com.kwad.sdk.utils.w;
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
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a implements Closeable {
    private final File aHp;
    private final File aHq;
    private final File aHr;
    private final File aHs;
    private final int aHt;
    private int aHu;
    private final int aHv;
    private Writer aHx;
    private int aHz;
    private long maxSize;
    static final Pattern aHo = Pattern.compile("[a-z0-9_-]{1,64}");
    private static final OutputStream aHD = new OutputStream() { // from class: com.kwad.sdk.core.diskcache.a.a.3
        @Override // java.io.OutputStream
        public final void write(int i) {
        }
    };
    private long size = 0;
    private int aHw = 0;
    private final LinkedHashMap<String, b> aHy = new LinkedHashMap<>(0, 0.75f, true);
    private long aHA = 0;
    final ThreadPoolExecutor aHB = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.sdk.core.diskcache.a.a.1
        private final AtomicInteger poolNumber = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ksad-DiskLruCache-" + this.poolNumber.getAndIncrement());
        }
    });
    private final Callable<Void> aHC = new Callable<Void>() { // from class: com.kwad.sdk.core.diskcache.a.a.2
        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: Iz, reason: merged with bridge method [inline-methods] */
        public Void call() {
            synchronized (a.this) {
                if (a.this.aHx == null) {
                    return null;
                }
                a.this.trimToSize();
                a.this.IF();
                if (a.this.IE()) {
                    a.this.IC();
                    a.a(a.this, 0);
                }
                return null;
            }
        }
    };

    /* JADX INFO: renamed from: com.kwad.sdk.core.diskcache.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public final class C0604a {
        private final b aHF;
        private final boolean[] aHG;
        private boolean aHH;
        private boolean aHI;

        /* JADX INFO: renamed from: com.kwad.sdk.core.diskcache.a.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C0605a extends FilterOutputStream {
            public /* synthetic */ C0605a(C0604a c0604a, OutputStream outputStream, byte b) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    C0604a.b(C0604a.this, true);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    C0604a.b(C0604a.this, true);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException unused) {
                    C0604a.b(C0604a.this, true);
                }
            }

            private C0605a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException unused) {
                    C0604a.b(C0604a.this, true);
                }
            }
        }

        public /* synthetic */ C0604a(a aVar, b bVar, byte b) {
            this(bVar);
        }

        public static /* synthetic */ boolean b(C0604a c0604a, boolean z) {
            c0604a.aHH = true;
            return true;
        }

        public final void abort() {
            a.this.a(this, false);
        }

        public final void commit() {
            if (this.aHH) {
                a.this.a(this, false);
                a.this.remove(this.aHF.key);
            } else {
                a.this.a(this, true);
            }
            this.aHI = true;
        }

        public final OutputStream dK(int i) {
            FileOutputStream fileOutputStream;
            C0605a c0605a;
            synchronized (a.this) {
                if (this.aHF.aHM != this) {
                    throw new IllegalStateException();
                }
                byte b = 0;
                if (!this.aHF.aHL) {
                    this.aHG[0] = true;
                }
                File fileDM = this.aHF.dM(0);
                try {
                    fileOutputStream = new FileOutputStream(fileDM);
                } catch (FileNotFoundException unused) {
                    a.this.aHp.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(fileDM);
                    } catch (FileNotFoundException unused2) {
                        return a.aHD;
                    }
                }
                c0605a = new C0605a(this, fileOutputStream, b);
            }
            return c0605a;
        }

        private C0604a(b bVar) {
            this.aHF = bVar;
            this.aHG = bVar.aHL ? null : new boolean[a.this.aHv];
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class b {
        private final long[] aHK;
        private boolean aHL;
        private C0604a aHM;
        private long aHN;
        private final String key;

        public /* synthetic */ b(a aVar, String str, byte b) {
            this(str);
        }

        public final String IH() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.aHK) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        public final File dL(int i) {
            return new File(a.this.aHp, this.key + i);
        }

        public final File dM(int i) {
            return new File(a.this.aHp, this.key + i + ".tmp");
        }

        private b(String str) {
            this.key = str;
            this.aHK = new long[a.this.aHv];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) throws IOException {
            if (strArr.length != a.this.aHv) {
                throw c(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.aHK[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw c(strArr);
                }
            }
        }

        private static IOException c(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public static /* synthetic */ boolean a(b bVar, boolean z) {
            bVar.aHL = true;
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class c implements Closeable {
        private final long[] aHK;
        private final long aHN;
        private File[] aHO;
        private final InputStream[] aHP;
        private final String key;

        public /* synthetic */ c(a aVar, String str, long j, File[] fileArr, InputStream[] inputStreamArr, long[] jArr, byte b) {
            this(str, j, fileArr, inputStreamArr, jArr);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (InputStream inputStream : this.aHP) {
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            }
        }

        public final File dN(int i) {
            return this.aHO[0];
        }

        private c(String str, long j, File[] fileArr, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.aHN = j;
            this.aHO = fileArr;
            this.aHP = inputStreamArr;
            this.aHK = jArr;
        }
    }

    private a(File file, int i, int i2, long j, int i3) {
        this.aHp = file;
        this.aHt = i;
        this.aHq = new File(file, "journal");
        this.aHr = new File(file, "journal.tmp");
        this.aHs = new File(file, "journal.bkp");
        this.aHv = i2;
        this.maxSize = j;
        this.aHu = i3;
    }

    private void IA() {
        com.kwad.sdk.core.diskcache.a.b bVar = new com.kwad.sdk.core.diskcache.a.b(new FileInputStream(this.aHq), com.kwad.sdk.crash.utils.a.US_ASCII);
        try {
            String line = bVar.readLine();
            String line2 = bVar.readLine();
            String line3 = bVar.readLine();
            String line4 = bVar.readLine();
            String line5 = bVar.readLine();
            if (!"libcore.io.DiskLruCache".equals(line) || !"1".equals(line2) || !Integer.toString(this.aHt).equals(line3) || !Integer.toString(this.aHv).equals(line4) || !"".equals(line5)) {
                throw new IOException("unexpected journal header: [" + line + ", " + line2 + ", " + line4 + ", " + line5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    dP(bVar.readLine());
                    i++;
                } catch (EOFException unused) {
                    this.aHz = i - this.aHy.size();
                    com.kwad.sdk.crash.utils.b.closeQuietly(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.crash.utils.b.closeQuietly(bVar);
            throw th;
        }
    }

    private void IB() throws IOException {
        p(this.aHr);
        Iterator<b> it = this.aHy.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            int i = 0;
            if (next.aHM == null) {
                while (i < this.aHv) {
                    this.size += next.aHK[i];
                    this.aHw++;
                    i++;
                }
            } else {
                next.aHM = null;
                while (i < this.aHv) {
                    p(next.dL(i));
                    p(next.dM(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void IC() {
        Writer writer = this.aHx;
        if (writer != null) {
            com.kwad.sdk.crash.utils.b.closeQuietly(writer);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aHr), com.kwad.sdk.crash.utils.a.US_ASCII));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.aHt));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.aHv));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (b bVar : this.aHy.values()) {
                if (bVar.aHM != null) {
                    bufferedWriter.write("DIRTY " + bVar.key + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + bVar.key + bVar.IH() + '\n');
                }
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedWriter);
            if (this.aHq.exists()) {
                a(this.aHq, this.aHs, true);
            }
            a(this.aHr, this.aHq, false);
            this.aHs.delete();
            this.aHx = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aHq, true), com.kwad.sdk.crash.utils.a.US_ASCII));
        } catch (Throwable th) {
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedWriter);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean IE() {
        int i = this.aHz;
        return i >= 2000 && i >= this.aHy.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IF() {
        while (this.aHw > this.aHu) {
            remove(this.aHy.entrySet().iterator().next().getKey());
        }
    }

    public static /* synthetic */ int a(a aVar, int i) {
        aVar.aHz = 0;
        return 0;
    }

    private void checkNotClosed() {
        if (this.aHx == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void dP(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.aHy.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        b bVar = this.aHy.get(strSubstring);
        byte b2 = 0;
        if (bVar == null) {
            bVar = new b(this, strSubstring, b2);
            this.aHy.put(strSubstring, bVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            b.a(bVar, true);
            bVar.aHM = null;
            bVar.b(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            bVar.aHM = new C0604a(this, bVar, b2);
        } else {
            if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith("READ")) {
                return;
            }
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private static void dS(String str) {
        if (aHo.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
    }

    private static void p(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() {
        while (this.size > this.maxSize) {
            remove(this.aHy.entrySet().iterator().next().getKey());
        }
    }

    public final synchronized int ID() {
        return this.aHu;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.aHx == null) {
            return;
        }
        for (b bVar : new ArrayList(this.aHy.values())) {
            if (bVar.aHM != null) {
                bVar.aHM.abort();
            }
        }
        trimToSize();
        IF();
        com.kwad.sdk.crash.utils.b.closeQuietly(this.aHx);
        this.aHx = null;
    }

    public final synchronized c dQ(String str) {
        InputStream inputStream;
        if (this.aHx == null) {
            return null;
        }
        dS(str);
        b bVar = this.aHy.get(str);
        if (bVar == null) {
            return null;
        }
        if (!bVar.aHL) {
            return null;
        }
        int i = this.aHv;
        File[] fileArr = new File[i];
        InputStream[] inputStreamArr = new InputStream[i];
        for (int i2 = 0; i2 < this.aHv; i2++) {
            try {
                File fileDL = bVar.dL(i2);
                fileArr[i2] = fileDL;
                inputStreamArr[i2] = new FileInputStream(fileDL);
            } catch (FileNotFoundException unused) {
                for (int i3 = 0; i3 < this.aHv && (inputStream = inputStreamArr[i3]) != null; i3++) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                }
                return null;
            }
        }
        this.aHz++;
        this.aHx.append((CharSequence) ("READ " + str + '\n'));
        if (IE()) {
            this.aHB.submit(this.aHC);
        }
        return new c(this, str, bVar.aHN, fileArr, inputStreamArr, bVar.aHK, (byte) 0);
    }

    public final C0604a dR(String str) {
        return e(str, -1L);
    }

    public final void delete() {
        close();
        w.deleteContents(this.aHp);
    }

    public final synchronized void flush() {
        checkNotClosed();
        trimToSize();
        IF();
        this.aHx.flush();
    }

    public final File getDirectory() {
        return this.aHp;
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    public final synchronized boolean remove(String str) {
        checkNotClosed();
        dS(str);
        b bVar = this.aHy.get(str);
        if (bVar != null && bVar.aHM == null) {
            for (int i = 0; i < this.aHv; i++) {
                File fileDL = bVar.dL(i);
                if (fileDL.exists() && !fileDL.delete()) {
                    throw new IOException("failed to delete " + fileDL);
                }
                this.size -= bVar.aHK[i];
                this.aHw--;
                bVar.aHK[i] = 0;
            }
            this.aHz++;
            this.aHx.append((CharSequence) ("REMOVE " + str + '\n'));
            this.aHy.remove(str);
            if (IE()) {
                this.aHB.submit(this.aHC);
            }
            return true;
        }
        return false;
    }

    private synchronized C0604a e(String str, long j) {
        checkNotClosed();
        dS(str);
        b bVar = this.aHy.get(str);
        byte b2 = 0;
        if (bVar == null) {
            bVar = new b(this, str, b2);
            this.aHy.put(str, bVar);
        } else if (bVar.aHM != null) {
            return null;
        }
        C0604a c0604a = new C0604a(this, bVar, b2);
        bVar.aHM = c0604a;
        this.aHx.write("DIRTY " + str + '\n');
        this.aHx.flush();
        return c0604a;
    }

    public static a a(File file, int i, int i2, long j) {
        return a(file, 1, 1, 209715200L, Integer.MAX_VALUE);
    }

    public static a a(File file, int i, int i2, long j, int i3) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i3 <= 0) {
            throw new IllegalArgumentException("maxFileCount <= 0");
        }
        if (i2 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            a aVar = new a(file, i, i2, j, i3);
            if (aVar.aHq.exists()) {
                try {
                    aVar.IA();
                    aVar.IB();
                    aVar.aHx = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aVar.aHq, true), com.kwad.sdk.crash.utils.a.US_ASCII));
                    return aVar;
                } catch (IOException e) {
                    System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                    aVar.delete();
                }
            }
            file.mkdirs();
            a aVar2 = new a(file, i, i2, j, i3);
            aVar2.IC();
            return aVar2;
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    private static void a(File file, File file2, boolean z) throws IOException {
        if (z) {
            p(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(C0604a c0604a, boolean z) {
        b bVar = c0604a.aHF;
        if (bVar.aHM == c0604a) {
            if (z && !bVar.aHL) {
                for (int i = 0; i < this.aHv; i++) {
                    if (c0604a.aHG[i]) {
                        if (!bVar.dM(i).exists()) {
                            c0604a.abort();
                            return;
                        }
                    } else {
                        c0604a.abort();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                }
            }
            for (int i2 = 0; i2 < this.aHv; i2++) {
                File fileDM = bVar.dM(i2);
                if (z) {
                    if (fileDM.exists()) {
                        File fileDL = bVar.dL(i2);
                        fileDM.renameTo(fileDL);
                        long j = bVar.aHK[i2];
                        long length = fileDL.length();
                        bVar.aHK[i2] = length;
                        this.size = (this.size - j) + length;
                        this.aHw++;
                    }
                } else {
                    p(fileDM);
                }
            }
            this.aHz++;
            bVar.aHM = null;
            if (!(bVar.aHL | z)) {
                this.aHy.remove(bVar.key);
                this.aHx.write("REMOVE " + bVar.key + '\n');
            } else {
                b.a(bVar, true);
                this.aHx.write("CLEAN " + bVar.key + bVar.IH() + '\n');
                if (z) {
                    long j2 = this.aHA;
                    this.aHA = 1 + j2;
                    bVar.aHN = j2;
                }
            }
            this.aHx.flush();
            if (this.size > this.maxSize || this.aHw > this.aHu || IE()) {
                this.aHB.submit(this.aHC);
            }
            return;
        }
        throw new IllegalStateException();
    }
}
