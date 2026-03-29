package com.kwad.sdk.utils.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.media3.muxer.MuxerUtil;
import com.kwad.sdk.utils.a.a;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import kotlin.UByte;
import kotlin.UShort;
import kotlin.jvm.internal.ByteCompanionObject;
import okio.Utf8;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class c {
    private static final int PAGE_SIZE;
    private static final int[] bgW = {0, 1, 4, 4, 8, 8};
    private static final byte[] bgX = new byte[0];
    private static final int bgY;
    private static final int bgZ;
    private static final int bha;
    private final String afW;
    private final Map<String, b> bhb;
    private FileChannel bhd;
    private FileChannel bhe;
    private RandomAccessFile bhf;
    private RandomAccessFile bhg;
    private MappedByteBuffer bhh;
    private MappedByteBuffer bhi;
    private com.kwad.sdk.utils.a.b bhj;
    private int bhk;
    private long bhl;
    private int bho;
    private int bhp;
    private int bhq;
    private boolean bhr;
    private String bhs;
    private int bht;
    private int bhv;
    private final String name;
    private final d bhc = com.kwad.sdk.utils.a.d.bhG;
    private final Map<String, a.b> bhm = new HashMap();
    private boolean bhn = false;
    private final ArrayList<e> bhu = new ArrayList<>();
    private boolean bhw = true;
    private final Executor bhx = new f();

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        static final C0637c bhA = new C0637c(11);
        static int bhz = 11;
        private final String afW;
        private b[] bhB;
        private int bhv = 0;
        private final String name;

        public a(String str, String str2) {
            if (str == null || str.isEmpty()) {
                throw new IllegalArgumentException("path is empty");
            }
            if (str2 == null || str2.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            if (!str.endsWith("/")) {
                str = str + '/';
            }
            this.afW = str;
            this.name = str2;
        }

        public final c UB() {
            String str = this.afW + this.name;
            c cVarHZ = C0637c.hZ(str);
            if (cVarHZ == null) {
                synchronized (a.class) {
                    cVarHZ = C0637c.hZ(str);
                    if (cVarHZ == null) {
                        cVarHZ = new c(this.afW, this.name, this.bhB, this.bhv);
                        C0637c.b(str, cVarHZ);
                    }
                }
            }
            Integer num = C0637c.bhF.get(str);
            if (num != null) {
                C0637c.bhF.put(str, Integer.valueOf(num.intValue() + 1));
            } else {
                C0637c.bhF.put(str, 1);
            }
            return cVarHZ;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b<T> {
        String UC();

        T f(byte[] bArr, int i, int i2);

        byte[] q(T t);
    }

    /* JADX INFO: renamed from: com.kwad.sdk.utils.a.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0637c {
        private static Map<String, c> bhC;
        private static List<String> bhD;
        private static int bhE;
        public static Map<String, Integer> bhF;

        public C0637c(int i) {
            int size = getSize(i);
            bhC = new ConcurrentHashMap(size);
            bhF = new HashMap(size);
            bhD = new CopyOnWriteArrayList();
            bhE = i;
        }

        public static void b(String str, c cVar) {
            if (bhC == null) {
                bhC = new ConcurrentHashMap(getSize(bhE));
            }
            if (bhD == null) {
                bhD = new CopyOnWriteArrayList();
            }
            if (bhC.containsKey(str)) {
                bhD.remove(str);
                bhD.add(str);
            } else {
                bhD.add(str);
            }
            bhC.put(str, cVar);
            if (bhC.size() > bhE) {
                Integer num = bhF.get(bhD.get(0));
                if (num != null && num.intValue() != 2) {
                    fB(bhE + 1);
                    return;
                }
                c cVar2 = bhC.get(bhD.get(0));
                if (cVar2 != null) {
                    cVar2.release();
                }
                bhC.remove(bhD.get(0));
                bhD.remove(0);
            }
        }

        private static void fB(int i) {
            com.kwad.sdk.utils.a.d.bhG.i("Ks_UnionKv", "reSize:" + i);
            bhE = i;
        }

        private static int getSize(int i) {
            return (int) ((i / 0.75f) + 1.0f);
        }

        public static c hZ(String str) {
            if (bhC == null) {
                bhC = new ConcurrentHashMap(getSize(bhE));
            }
            if (bhD == null) {
                bhD = new CopyOnWriteArrayList();
            }
            c cVar = bhC.get(str);
            if (cVar == null) {
                return null;
            }
            bhD.remove(str);
            bhD.add(str);
            return cVar;
        }

        public static void remove(String str) {
            List<String> list = bhD;
            if (list != null) {
                list.remove(str);
            }
            Map<String, c> map = bhC;
            if (map != null) {
                map.remove(str);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void a(String str, Exception exc);

        void e(String str, Throwable th);

        void i(String str, String str2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e implements Comparable<e> {
        int end;
        int start;

        public e(int i, int i2) {
            this.start = i;
            this.end = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(e eVar) {
            return this.start - eVar.start;
        }
    }

    static {
        int iUE = h.UE();
        PAGE_SIZE = iUE;
        bgY = iUE - 192;
        int iMax = Math.max(iUE << 1, 16384);
        bgZ = iMax;
        bha = iMax << 1;
    }

    public c(String str, String str2, b[] bVarArr, int i) {
        this.afW = str;
        this.name = str2;
        this.bhv = i;
        HashMap map = new HashMap();
        g gVar = g.bhN;
        map.put(gVar.UC(), gVar);
        if (bVarArr != null && bVarArr.length > 0) {
            for (b bVar : bVarArr) {
                String strUC = bVar.UC();
                if (map.containsKey(strUC)) {
                    hY("duplicate encoder tag:" + strUC);
                } else {
                    map.put(strUC, bVar);
                }
            }
        }
        this.bhb = map;
        synchronized (this.bhm) {
            com.kwad.sdk.utils.a.d.getExecutor().execute(new Runnable() { // from class: com.kwad.sdk.utils.a.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.Uj();
                }
            });
            while (!this.bhn) {
                try {
                    this.bhm.wait();
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    private int H(int i, int i2) {
        if (i2 > 536870912) {
            IllegalStateException illegalStateException = new IllegalStateException("data size out of limit");
            if (com.kwad.library.a.a.oy.booleanValue()) {
                throw illegalStateException;
            }
            s(illegalStateException);
        }
        int i3 = PAGE_SIZE;
        if (i2 <= i3) {
            return i3;
        }
        while (i < i2) {
            int i4 = bgZ;
            i = i <= i4 ? i << 1 : i + i4;
        }
        return i;
    }

    private void I(int i, int i2) {
        this.bht += i2 - i;
        ArrayList<e> arrayList = this.bhu;
        if (arrayList != null) {
            arrayList.add(new e(i, i2));
        }
    }

    private void UA() {
        this.bht = 0;
        ArrayList<e> arrayList = this.bhu;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Uj() {
        synchronized (this.bhm) {
            this.bhn = true;
            this.bhm.notify();
        }
        long jNanoTime = System.nanoTime();
        if (!Um() && this.bhv == 0) {
            Uk();
        }
        if (this.bhj == null) {
            this.bhj = new com.kwad.sdk.utils.a.b(PAGE_SIZE);
        }
        if (this.bhc != null) {
            info("loading finish, data len:" + this.bhk + ", get keys:" + this.bhm.size() + ", use time:" + ((System.nanoTime() - jNanoTime) / 1000000) + " ms");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x019b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void Uk() {
        boolean z;
        boolean z2;
        File file = new File(this.afW, this.name + ".kva");
        File file2 = new File(this.afW, this.name + ".kvb");
        try {
            if (h.ae(file) && h.ae(file2)) {
                this.bhf = new RandomAccessFile(file, "rw");
                this.bhg = new RandomAccessFile(file2, "rw");
                long length = this.bhf.length();
                long length2 = this.bhg.length();
                this.bhd = this.bhf.getChannel();
                this.bhe = this.bhg.getChannel();
                try {
                    MappedByteBuffer map = this.bhd.map(FileChannel.MapMode.READ_WRITE, 0L, length > 0 ? length : PAGE_SIZE);
                    this.bhh = map;
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    map.order(byteOrder);
                    MappedByteBuffer map2 = this.bhe.map(FileChannel.MapMode.READ_WRITE, 0L, length2 > 0 ? length2 : PAGE_SIZE);
                    this.bhi = map2;
                    map2.order(byteOrder);
                    this.bhj = new com.kwad.sdk.utils.a.b(this.bhh.capacity());
                    if (length == 0 && length2 == 0) {
                        this.bhk = 12;
                        return;
                    }
                    int i = this.bhh.getInt();
                    long j = this.bhh.getLong();
                    int i2 = this.bhi.getInt();
                    long j2 = this.bhi.getLong();
                    if (i < 0 || i > length - 12) {
                        z = false;
                    } else {
                        this.bhk = i + 12;
                        this.bhh.rewind();
                        this.bhh.get(this.bhj.bgV, 0, this.bhk);
                        if (j == this.bhj.G(12, i) && Un() == 0) {
                            this.bhl = j;
                            z = true;
                        }
                    }
                    if (z) {
                        if (length == length2 && Ul()) {
                            return;
                        }
                        g(new Exception("B file error"));
                        a(this.bhh, this.bhi, this.bhk);
                        return;
                    }
                    if (i2 < 0 || i2 > length2 - 12) {
                        z2 = false;
                    } else {
                        this.bhm.clear();
                        UA();
                        this.bhk = i2 + 12;
                        if (this.bhj.bgV.length != this.bhi.capacity()) {
                            this.bhj = new com.kwad.sdk.utils.a.b(this.bhi.capacity());
                        }
                        this.bhi.rewind();
                        this.bhi.get(this.bhj.bgV, 0, this.bhk);
                        if (j2 == this.bhj.G(12, i2) && Un() == 0) {
                            g(new Exception("A file error"));
                            a(this.bhi, this.bhh, this.bhk);
                            this.bhl = j2;
                            z2 = true;
                        }
                    }
                    if (z2) {
                        return;
                    }
                    hY("both files error");
                    Ut();
                    return;
                } catch (IOException e2) {
                    s(e2);
                    Us();
                    h(file, file2);
                    return;
                }
            }
            s(new Exception("open file failed"));
            Us();
        } catch (Throwable th) {
            s(th);
            Uu();
            Us();
        }
    }

    private boolean Ul() {
        com.kwad.sdk.utils.a.b bVar = new com.kwad.sdk.utils.a.b(this.bhk);
        MappedByteBuffer mappedByteBuffer = this.bhi;
        if (mappedByteBuffer != null) {
            mappedByteBuffer.rewind();
            this.bhi.get(bVar.bgV, 0, this.bhk);
        }
        com.kwad.sdk.utils.a.b bVar2 = this.bhj;
        if (bVar2 == null) {
            return true;
        }
        byte[] bArr = bVar2.bgV;
        byte[] bArr2 = bVar.bgV;
        for (int i = 0; i < this.bhk; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean Um() {
        File file = new File(this.afW, this.name + ".kvc");
        File file2 = new File(this.afW, this.name + ".tmp");
        boolean z = false;
        try {
            if (!file.exists()) {
                file = file2.exists() ? file2 : null;
            }
            if (file != null) {
                if (!ad(file)) {
                    Uu();
                    Ur();
                    return false;
                }
                if (this.bhv != 0) {
                    return false;
                }
                if (!a(this.bhj)) {
                    this.bhv = 1;
                    return false;
                }
                info("recover from c file");
                try {
                    Ur();
                    return true;
                } catch (Exception e2) {
                    e = e2;
                    z = true;
                    s(e);
                    return z;
                }
            }
            if (this.bhv == 0) {
                return false;
            }
            File file3 = new File(this.afW, this.name + ".kva");
            File file4 = new File(this.afW, this.name + ".kvb");
            if (!file3.exists() || !file4.exists()) {
                return false;
            }
            h(file3, file4);
            return false;
        } catch (Exception e3) {
            e = e3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x016f, code lost:
    
        throw new java.lang.Exception("parse dara failed");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int Un() {
        com.kwad.sdk.utils.a.b bVar = this.bhj;
        bVar.position = 12;
        while (true) {
            try {
                int i = bVar.position;
                int i2 = this.bhk;
                if (i >= i2) {
                    if (i == i2) {
                        return 0;
                    }
                    g(new Exception("parse dara failed"));
                    return -1;
                }
                byte b2 = bVar.get();
                byte b3 = (byte) (b2 & Utf8.REPLACEMENT_BYTE);
                if (b3 <= 0 || b3 > 8) {
                    break;
                }
                int i3 = bVar.get() & UByte.MAX_VALUE;
                if (b2 < 0) {
                    bVar.position += i3;
                    int i4 = b3 <= 5 ? bgW[b3] : bVar.getShort() & UShort.MAX_VALUE;
                    com.kwad.sdk.utils.a.b bVar2 = this.bhj;
                    int i5 = bVar2.position + i4;
                    bVar2.position = i5;
                    I(i, i5);
                } else {
                    String string = bVar.getString(i3);
                    int i6 = bVar.position;
                    boolean z = true;
                    if (b3 > 5) {
                        int i7 = 65535 & bVar.getShort();
                        if ((b2 & 64) == 0) {
                            z = false;
                        }
                        f(i7, z);
                        if (b3 == 6) {
                            this.bhm.put(string, new a.i(i, i6 + 2, z ? bVar.ft(i7) : bVar.getString(i7), i7, z));
                        } else if (b3 == 7) {
                            this.bhm.put(string, new a.C0636a(i, i6 + 2, z ? bVar.getString(i7) : bVar.getBytes(i7), i7, z));
                        } else if (z) {
                            this.bhm.put(string, new a.h(i, i6 + 2, bVar.getString(i7), i7, true));
                        } else {
                            int i8 = bVar.get() & UByte.MAX_VALUE;
                            String string2 = bVar.getString(i8);
                            b bVar3 = this.bhb.get(string2);
                            int i9 = i7 - (i8 + 1);
                            if (i9 < 0) {
                                throw new Exception("parse dara failed");
                            }
                            if (bVar3 != null) {
                                try {
                                    Object objF = bVar3.f(bVar.bgV, bVar.position, i9);
                                    if (objF != null) {
                                        this.bhm.put(string, new a.h(i, i6 + 2, objF, i7, false));
                                    }
                                } catch (Exception e2) {
                                    s(e2);
                                }
                            } else {
                                hY("object with tag: " + string2 + " without encoder");
                            }
                            bVar.position += i9;
                        }
                    } else if (b3 == 1) {
                        this.bhm.put(string, new a.c(i6, bVar.get() == 1));
                    } else if (b3 == 2) {
                        this.bhm.put(string, new a.f(i6, bVar.getInt()));
                    } else if (b3 == 3) {
                        this.bhm.put(string, new a.e(i6, bVar.getFloat()));
                    } else if (b3 != 4) {
                        this.bhm.put(string, new a.d(i6, bVar.getDouble()));
                    } else {
                        this.bhm.put(string, new a.g(i6, bVar.getLong()));
                    }
                }
            } catch (Exception e3) {
                g(e3);
                return -1;
            }
        }
    }

    private void Uo() {
        if (this.bhv == 0 || !this.bhw) {
            return;
        }
        Up();
    }

    private boolean Up() {
        int i = this.bhv;
        if (i == 1) {
            Executor executor = this.bhx;
            if (executor != null) {
                executor.execute(new Runnable() { // from class: com.kwad.sdk.utils.a.c.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.this.Uq();
                    }
                });
            }
        } else if (i == 2) {
            return Uq();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007b A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean Uq() {
        File file;
        try {
            file = new File(this.afW, this.name + ".tmp");
        } catch (Exception e2) {
            s(e2);
        }
        if (h.ae(file)) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.setLength(this.bhk);
            randomAccessFile.write(this.bhj.bgV, 0, this.bhk);
            randomAccessFile.close();
            File file2 = new File(this.afW, this.name + ".kvc");
            if (file2.exists() && !file2.delete()) {
                return false;
            }
            if (file.renameTo(file2)) {
                return true;
            }
            g(new Exception("rename failed"));
            return false;
        }
    }

    private void Ur() {
        try {
            h.h(new File(this.afW, this.name + ".kvc"));
            h.h(new File(this.afW, this.name + ".tmp"));
        } catch (Exception e2) {
            s(e2);
        }
    }

    private void Us() {
        this.bhv = 1;
        h.closeQuietly(this.bhd);
        h.closeQuietly(this.bhe);
        this.bhd = null;
        this.bhe = null;
        this.bhh = null;
        this.bhi = null;
    }

    private void Ut() {
        if (this.bhv == 0) {
            try {
                a(this.bhh);
                a(this.bhi);
            } catch (Throwable unused) {
                Us();
            }
        }
        Uu();
        h.h(new File(this.afW + this.name));
    }

    private void Uu() {
        this.bhk = 12;
        this.bhl = 0L;
        UA();
        this.bhm.clear();
        com.kwad.sdk.utils.a.b bVar = this.bhj;
        if (bVar == null || bVar.bgV.length != PAGE_SIZE) {
            this.bhj = new com.kwad.sdk.utils.a.b(PAGE_SIZE);
        } else {
            bVar.E(0, 0);
            this.bhj.f(4, 0L);
        }
    }

    private void Uv() {
        com.kwad.sdk.utils.a.b bVar;
        com.kwad.sdk.utils.a.b bVar2 = this.bhj;
        if (bVar2 != null) {
            this.bhl ^= bVar2.G(this.bho, this.bhp);
        }
        if (this.bhv == 0) {
            MappedByteBuffer mappedByteBuffer = this.bhh;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putInt(0, -1);
                b(this.bhh);
                this.bhh.putInt(0, this.bhk - 12);
            }
            MappedByteBuffer mappedByteBuffer2 = this.bhi;
            if (mappedByteBuffer2 != null) {
                b(mappedByteBuffer2);
            }
        } else {
            if (this.bhr && (bVar = this.bhj) != null) {
                bVar.E(0, this.bhk - 12);
            }
            com.kwad.sdk.utils.a.b bVar3 = this.bhj;
            if (bVar3 != null) {
                bVar3.f(4, this.bhl);
            }
        }
        this.bhr = false;
        this.bhq = 0;
        this.bhp = 0;
    }

    private int Uw() {
        int i = this.bhk;
        if (i <= 16384) {
            return 4096;
        }
        return i <= 65536 ? 8192 : 16384;
    }

    private void Ux() {
        fy(this.bhp);
        int i = this.bhk;
        this.bho = i;
        this.bhk = this.bhp + i;
        com.kwad.sdk.utils.a.b bVar = this.bhj;
        if (bVar != null) {
            bVar.position = i;
        }
        this.bhr = true;
    }

    private void Uy() {
        if (this.bht < (Uw() << 1)) {
            if (this.bhu.size() < (this.bhk < 16384 ? 80 : 160)) {
                return;
            }
        }
        fz(0);
    }

    private void Uz() {
        ArrayList<e> arrayList = this.bhu;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size() - 1;
        e eVar = this.bhu.get(size);
        while (size > 0) {
            size--;
            e eVar2 = this.bhu.get(size);
            if (eVar.start == eVar2.end) {
                eVar2.end = eVar.end;
                this.bhu.remove(size + 1);
            }
            eVar = eVar2;
        }
    }

    private boolean ad(File file) {
        long length = file.length();
        if (length != 0 && length <= 536870912) {
            int i = (int) length;
            int iH = H(PAGE_SIZE, i);
            com.kwad.sdk.utils.a.b bVar = this.bhj;
            if (bVar == null || bVar.bgV.length != iH) {
                bVar = new com.kwad.sdk.utils.a.b(new byte[iH]);
                this.bhj = bVar;
            } else {
                bVar.position = 0;
            }
            h.a(file, bVar.bgV, i);
            int i2 = bVar.getInt();
            long j = bVar.getLong();
            this.bhk = i2 + 12;
            if (i2 >= 0 && i2 <= i - 12 && j == bVar.G(12, i2) && Un() == 0) {
                this.bhl = j;
                return true;
            }
        }
        return false;
    }

    private static void f(int i, boolean z) {
        if (z) {
            if (i != 32) {
                throw new IllegalStateException("name size not match");
            }
        } else if (i < 0 || i >= 2048) {
            throw new IllegalStateException("value size out of bound");
        }
    }

    private void fA(int i) {
        int i2 = PAGE_SIZE;
        int iH = H(i2, i + i2);
        com.kwad.sdk.utils.a.b bVar = this.bhj;
        if (bVar != null) {
            byte[] bArr = bVar.bgV;
            if (iH >= bArr.length) {
                return;
            }
            byte[] bArr2 = new byte[iH];
            System.arraycopy(bArr, 0, bArr2, 0, this.bhk);
            this.bhj.bgV = bArr2;
        }
        if (this.bhv == 0) {
            try {
                long j = iH;
                this.bhd.truncate(j);
                MappedByteBuffer map = this.bhd.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                this.bhh = map;
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                map.order(byteOrder);
                this.bhe.truncate(j);
                MappedByteBuffer map2 = this.bhe.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                this.bhi = map2;
                map2.order(byteOrder);
            } catch (Throwable th) {
                s(new Exception("map failed", th));
                Us();
            }
        }
        info("truncate finish");
    }

    private static void fx(int i) {
        if (i > 255) {
            throw new IllegalArgumentException("key's length must less than 256");
        }
    }

    private void fy(int i) {
        if (this.bhj == null) {
            this.bhj = new com.kwad.sdk.utils.a.b(PAGE_SIZE);
        }
        int length = this.bhj.bgV.length;
        int i2 = this.bhk + i;
        if (i2 >= length) {
            int i3 = this.bht;
            if (i3 > i && i3 > Uw()) {
                fz(i);
                return;
            }
            int iH = H(length, i2);
            byte[] bArr = new byte[iH];
            System.arraycopy(this.bhj.bgV, 0, bArr, 0, this.bhk);
            this.bhj.bgV = bArr;
            if (this.bhv == 0) {
                try {
                    long j = iH;
                    MappedByteBuffer map = this.bhd.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                    this.bhh = map;
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    map.order(byteOrder);
                    MappedByteBuffer map2 = this.bhe.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                    this.bhi = map2;
                    map2.order(byteOrder);
                } catch (Throwable th) {
                    s(new Exception("map failed", th));
                    this.bhj.E(0, this.bhk - 12);
                    this.bhj.f(4, this.bhl);
                    Us();
                }
            }
        }
    }

    private void fz(int i) {
        int i2;
        ArrayList<e> arrayList = this.bhu;
        if (arrayList == null || this.bhj == null) {
            return;
        }
        Collections.sort(arrayList);
        Uz();
        e eVar = this.bhu.get(0);
        int i3 = eVar.start;
        int i4 = this.bhk;
        int i5 = i4 - this.bht;
        int i6 = i5 - 12;
        int i7 = i5 - i3;
        int i8 = i4 - i3;
        boolean z = i6 < i8 + i7;
        if (!z) {
            this.bhl ^= this.bhj.G(i3, i8);
        }
        int size = this.bhu.size();
        int i9 = size - 1;
        int i10 = this.bhk - this.bhu.get(i9).end;
        int[] iArr = new int[(i10 > 0 ? size : i9) << 1];
        int i11 = eVar.start;
        int i12 = eVar.end;
        for (int i13 = 1; i13 < size; i13++) {
            e eVar2 = this.bhu.get(i13);
            int i14 = eVar2.start - i12;
            byte[] bArr = this.bhj.bgV;
            System.arraycopy(bArr, i12, bArr, i11, i14);
            int i15 = (i13 - 1) << 1;
            iArr[i15] = i12;
            iArr[i15 + 1] = i12 - i11;
            i11 += i14;
            i12 = eVar2.end;
        }
        if (i10 > 0) {
            byte[] bArr2 = this.bhj.bgV;
            System.arraycopy(bArr2, i12, bArr2, i11, i10);
            int i16 = i9 << 1;
            iArr[i16] = i12;
            iArr[i16 + 1] = i12 - i11;
        }
        UA();
        if (z) {
            this.bhl = this.bhj.G(12, i6);
        } else {
            this.bhl ^= this.bhj.G(i3, i7);
        }
        this.bhk = i5;
        if (this.bhv == 0) {
            MappedByteBuffer mappedByteBuffer = this.bhh;
            if (mappedByteBuffer != null) {
                i2 = 0;
                mappedByteBuffer.putInt(0, -1);
                this.bhh.putLong(4, this.bhl);
                this.bhh.position(i3);
                this.bhh.put(this.bhj.bgV, i3, i7);
                this.bhh.putInt(0, i6);
            } else {
                i2 = 0;
            }
            MappedByteBuffer mappedByteBuffer2 = this.bhi;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putInt(i2, i6);
                this.bhi.putLong(4, this.bhl);
                this.bhi.position(i3);
                this.bhi.put(this.bhj.bgV, i3, i7);
            }
        } else {
            this.bhj.E(0, i6);
            this.bhj.f(4, this.bhl);
        }
        a(i3, iArr);
        int i17 = i5 + i;
        if (this.bhj.bgV.length - i17 > bha) {
            fA(i17);
        }
        info("gc finish");
    }

    private static long g(long j, int i) {
        int i2 = (i & 7) << 3;
        return (j >>> (64 - i2)) | (j << i2);
    }

    private void h(File file, File file2) {
        try {
            if (ad(file)) {
                return;
            }
        } catch (IOException e2) {
            g(e2);
        }
        Uu();
        try {
            if (ad(file2)) {
                return;
            }
        } catch (Exception e3) {
            g(e3);
        }
        Uu();
    }

    private static void hX(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("key is empty");
        }
    }

    private void hY(String str) {
        d dVar = this.bhc;
        if (dVar != null) {
            dVar.e(this.name, new Exception(str));
        }
    }

    private void info(String str) {
        d dVar = this.bhc;
        if (dVar != null) {
            dVar.i(this.name, str);
        }
    }

    private synchronized void putDouble(String str, double d2) {
        hX(str);
        a.d dVar = (a.d) this.bhm.get(str);
        if (dVar != null) {
            if (dVar.value != d2) {
                long jDoubleToRawLongBits = Double.doubleToRawLongBits(d2);
                long jDoubleToRawLongBits2 = Double.doubleToRawLongBits(dVar.value) ^ jDoubleToRawLongBits;
                dVar.value = d2;
                b(jDoubleToRawLongBits, jDoubleToRawLongBits2, dVar.offset);
                Uo();
            }
            return;
        }
        a(str, (byte) 5);
        com.kwad.sdk.utils.a.b bVar = this.bhj;
        if (bVar != null) {
            int i = bVar.position;
            bVar.bb(Double.doubleToRawLongBits(d2));
            Uv();
            Map<String, a.b> map = this.bhm;
            if (map != null) {
                map.put(str, new a.d(i, d2));
            }
        }
        Uo();
    }

    private synchronized void putFloat(String str, float f) {
        hX(str);
        a.e eVar = (a.e) this.bhm.get(str);
        if (eVar != null) {
            if (eVar.value != f) {
                int iFloatToRawIntBits = Float.floatToRawIntBits(f);
                long jFloatToRawIntBits = ((long) (Float.floatToRawIntBits(eVar.value) ^ iFloatToRawIntBits)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE;
                eVar.value = f;
                a(iFloatToRawIntBits, jFloatToRawIntBits, eVar.offset);
                Uo();
            }
            return;
        }
        a(str, (byte) 3);
        com.kwad.sdk.utils.a.b bVar = this.bhj;
        if (bVar != null) {
            int i = bVar.position;
            bVar.fq(Float.floatToRawIntBits(f));
            Uv();
            Map<String, a.b> map = this.bhm;
            if (map != null) {
                map.put(str, new a.e(i, f));
            }
        }
        Uo();
    }

    private synchronized void putStringSet(String str, Set<String> set) {
        if (set == null) {
            remove(str);
        } else {
            a(str, set, g.bhN);
        }
    }

    private void s(Throwable th) {
        d dVar = this.bhc;
        if (dVar != null) {
            dVar.e(this.name, th);
        }
    }

    private void u(String str, int i) {
        com.kwad.sdk.utils.a.b bVar = this.bhj;
        if (bVar == null) {
            return;
        }
        bVar.e((byte) i);
        if (i != str.length()) {
            this.bhj.hT(str);
            return;
        }
        com.kwad.sdk.utils.a.b bVar2 = this.bhj;
        a(str, 0, i, bVar2.bgV, bVar2.position);
        this.bhj.position += i;
    }

    private void updateBytes(int i, byte[] bArr) {
        int length = bArr.length;
        com.kwad.sdk.utils.a.b bVar = this.bhj;
        if (bVar != null) {
            this.bhl ^= bVar.G(i, length);
            com.kwad.sdk.utils.a.b bVar2 = this.bhj;
            bVar2.position = i;
            bVar2.k(bArr);
            this.bhl ^= this.bhj.G(i, length);
        }
        if (this.bhv != 0) {
            com.kwad.sdk.utils.a.b bVar3 = this.bhj;
            if (bVar3 != null) {
                bVar3.f(4, this.bhl);
                return;
            }
            return;
        }
        MappedByteBuffer mappedByteBuffer = this.bhh;
        if (mappedByteBuffer != null) {
            mappedByteBuffer.putInt(0, -1);
            this.bhh.putLong(4, this.bhl);
            this.bhh.position(i);
            this.bhh.put(bArr);
            this.bhh.putInt(0, this.bhk - 12);
        }
        MappedByteBuffer mappedByteBuffer2 = this.bhi;
        if (mappedByteBuffer2 != null) {
            mappedByteBuffer2.putLong(4, this.bhl);
            this.bhi.position(i);
            this.bhi.put(bArr);
        }
    }

    private void v(String str, int i) {
        com.kwad.sdk.utils.a.b bVar = this.bhj;
        if (bVar == null) {
            return;
        }
        bVar.a((short) i);
        if (i != str.length()) {
            this.bhj.hT(str);
        } else {
            com.kwad.sdk.utils.a.b bVar2 = this.bhj;
            a(str, 0, i, bVar2.bgV, bVar2.position);
        }
    }

    public final synchronized boolean contains(String str) {
        return this.bhm.containsKey(str);
    }

    public final synchronized Map<String, Object> getAll() {
        Object objValueOf;
        int size = this.bhm.size();
        if (size == 0) {
            return new HashMap();
        }
        HashMap map = new HashMap(((size * 4) / 3) + 1);
        for (Map.Entry<String, a.b> entry : this.bhm.entrySet()) {
            String key = entry.getKey();
            a.b value = entry.getValue();
            switch (value.Uh()) {
                case 1:
                    objValueOf = Boolean.valueOf(((a.c) value).value);
                    break;
                case 2:
                    objValueOf = Integer.valueOf(((a.f) value).value);
                    break;
                case 3:
                    objValueOf = Float.valueOf(((a.e) value).value);
                    break;
                case 4:
                    objValueOf = Long.valueOf(((a.g) value).value);
                    break;
                case 5:
                    objValueOf = Double.valueOf(((a.d) value).value);
                    break;
                case 6:
                    a.i iVar = (a.i) value;
                    objValueOf = iVar.bgT ? a(iVar) : iVar.value;
                    break;
                case 7:
                    a.C0636a c0636a = (a.C0636a) value;
                    objValueOf = c0636a.bgT ? a(c0636a) : c0636a.value;
                    break;
                case 8:
                    a.h hVar = (a.h) value;
                    objValueOf = hVar.bgT ? a(hVar) : ((a.h) value).value;
                    break;
                default:
                    objValueOf = null;
                    break;
            }
            map.put(key, objValueOf);
        }
        return map;
    }

    public final synchronized boolean getBoolean(String str, boolean z) {
        a.c cVar = (a.c) this.bhm.get(str);
        if (cVar == null) {
            return z;
        }
        return cVar.value;
    }

    public final synchronized int getInt(String str, int i) {
        a.f fVar = (a.f) this.bhm.get(str);
        if (fVar == null) {
            return i;
        }
        return fVar.value;
    }

    public final synchronized long getLong(String str, long j) {
        a.g gVar = (a.g) this.bhm.get(str);
        if (gVar == null) {
            return j;
        }
        return gVar.value;
    }

    public final synchronized String getString(String str, String str2) {
        a.i iVar = (a.i) this.bhm.get(str);
        if (iVar == null) {
            return str2;
        }
        if (iVar.bgT) {
            return a(iVar);
        }
        return (String) iVar.value;
    }

    public final void putAll(Map<String, Object> map) {
        a(map, (Map<Class, b>) null);
    }

    public final synchronized void putBoolean(String str, boolean z) {
        hX(str);
        a.c cVar = (a.c) this.bhm.get(str);
        if (cVar != null) {
            if (cVar.value != z) {
                cVar.value = z;
                a((byte) (z ? 1 : 0), cVar.offset);
                Uo();
            }
            return;
        }
        a(str, (byte) 1);
        com.kwad.sdk.utils.a.b bVar = this.bhj;
        if (bVar != null) {
            int i = bVar.position;
            bVar.e((byte) (z ? 1 : 0));
            Uv();
            Map<String, a.b> map = this.bhm;
            if (map != null) {
                map.put(str, new a.c(i, z));
            }
        }
        Uo();
    }

    public final synchronized void putInt(String str, int i) {
        hX(str);
        a.f fVar = (a.f) this.bhm.get(str);
        if (fVar != null) {
            int i2 = fVar.value;
            if (i2 != i) {
                long j = ((long) (i2 ^ i)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE;
                fVar.value = i;
                a(i, j, fVar.offset);
                Uo();
            }
            return;
        }
        a(str, (byte) 2);
        com.kwad.sdk.utils.a.b bVar = this.bhj;
        if (bVar != null) {
            int i3 = bVar.position;
            bVar.fq(i);
            Uv();
            Map<String, a.b> map = this.bhm;
            if (map != null) {
                map.put(str, new a.f(i3, i));
            }
        }
        Uo();
    }

    public final synchronized void putLong(String str, long j) {
        hX(str);
        a.g gVar = (a.g) this.bhm.get(str);
        if (gVar != null) {
            long j2 = gVar.value;
            if (j2 != j) {
                gVar.value = j;
                b(j, j ^ j2, gVar.offset);
                Uo();
            }
            return;
        }
        a(str, (byte) 4);
        com.kwad.sdk.utils.a.b bVar = this.bhj;
        if (bVar != null) {
            int i = bVar.position;
            bVar.bb(j);
            Uv();
            Map<String, a.b> map = this.bhm;
            if (map != null) {
                map.put(str, new a.g(i, j));
            }
        }
        Uo();
    }

    public final synchronized void putString(String str, String str2) {
        byte[] bArrHW;
        byte[] bArr;
        byte[] bArr2;
        hX(str);
        if (str2 == null) {
            remove(str);
            return;
        }
        a.i iVar = (a.i) this.bhm.get(str);
        if (str2.length() * 3 < 2048) {
            a(str, str2, iVar);
            return;
        }
        if (!str2.isEmpty()) {
            if (iVar == null && str2.length() < 2048) {
                int iHU = com.kwad.sdk.utils.a.b.hU(str2);
                bArr = new byte[iHU];
                if (iHU == str2.length()) {
                    a(str2, 0, iHU, bArr, 0);
                    bArr2 = bArr;
                } else {
                    bArrHW = com.kwad.sdk.utils.a.b.hW(str2);
                }
            } else if (iVar == null || iVar.bgT) {
                bArrHW = com.kwad.sdk.utils.a.b.hW(str2);
            } else {
                int iHU2 = com.kwad.sdk.utils.a.b.hU(str2);
                bArr = new byte[iHU2];
                if (iHU2 == str2.length()) {
                    a(str2, 0, iHU2, bArr, 0);
                    bArr2 = bArr;
                } else {
                    bArrHW = com.kwad.sdk.utils.a.b.hW(str2);
                }
            }
            a(str, str2, bArr2, iVar, (byte) 6);
        }
        bArrHW = bgX;
        bArr2 = bArrHW;
        a(str, str2, bArr2, iVar, (byte) 6);
    }

    public final void release() {
        h.closeQuietly(this.bhf);
        h.closeQuietly(this.bhg);
        h.closeQuietly(this.bhd);
        h.closeQuietly(this.bhe);
        this.bhd = null;
        this.bhe = null;
        this.bhh = null;
        this.bhi = null;
        String str = this.afW + this.name;
        int i = a.bhz;
        C0637c.remove(str);
    }

    public final synchronized void remove(String str) {
        a.b bVar = this.bhm.get(str);
        if (bVar != null) {
            this.bhm.remove(str);
            byte bUh = bVar.Uh();
            String str2 = null;
            if (bUh <= 5) {
                int iHU = com.kwad.sdk.utils.a.b.hU(str);
                int i = bVar.offset;
                a(bUh, i - (iHU + 2), i + bgW[bUh]);
            } else {
                a.j jVar = (a.j) bVar;
                a(bUh, jVar.start, jVar.offset + jVar.bgS);
                if (jVar.bgT) {
                    str2 = (String) jVar.value;
                }
            }
            byte b2 = (byte) (bUh | ByteCompanionObject.MIN_VALUE);
            if (this.bhv == 0) {
                MappedByteBuffer mappedByteBuffer = this.bhh;
                if (mappedByteBuffer != null) {
                    mappedByteBuffer.putLong(4, this.bhl);
                    this.bhh.put(this.bhq, b2);
                }
                MappedByteBuffer mappedByteBuffer2 = this.bhi;
                if (mappedByteBuffer2 != null) {
                    mappedByteBuffer2.putLong(4, this.bhl);
                    this.bhi.put(this.bhq, b2);
                }
            } else {
                com.kwad.sdk.utils.a.b bVar2 = this.bhj;
                if (bVar2 != null) {
                    bVar2.f(4, this.bhl);
                }
            }
            this.bhq = 0;
            if (str2 != null) {
                h.h(new File(this.afW + this.name, str2));
            }
            Uy();
            Uo();
        }
    }

    public final synchronized String toString() {
        return "FastKV: path:" + this.afW + " name:" + this.name;
    }

    private boolean a(com.kwad.sdk.utils.a.b bVar) {
        int length = bVar.bgV.length;
        File file = new File(this.afW, this.name + ".kva");
        File file2 = new File(this.afW, this.name + ".kvb");
        try {
            if (!h.ae(file) || !h.ae(file2)) {
                throw new Exception("open file failed");
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
            long j = length;
            randomAccessFile.setLength(j);
            randomAccessFile2.setLength(j);
            this.bhd = randomAccessFile.getChannel();
            this.bhe = randomAccessFile2.getChannel();
            MappedByteBuffer map = this.bhd.map(FileChannel.MapMode.READ_WRITE, 0L, j);
            this.bhh = map;
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            map.order(byteOrder);
            MappedByteBuffer map2 = this.bhe.map(FileChannel.MapMode.READ_WRITE, 0L, j);
            this.bhi = map2;
            map2.order(byteOrder);
            this.bhh.put(bVar.bgV, 0, this.bhk);
            this.bhi.put(bVar.bgV, 0, this.bhk);
            return true;
        } catch (Exception e2) {
            s(e2);
            return false;
        }
    }

    private synchronized void b(String str, byte[] bArr) {
        hX(str);
        if (bArr == null) {
            remove(str);
        } else {
            a(str, bArr, bArr, (a.C0636a) this.bhm.get(str), (byte) 7);
        }
    }

    private void g(Exception exc) {
        d dVar = this.bhc;
        if (dVar != null) {
            dVar.a(this.name, exc);
        }
    }

    private void b(MappedByteBuffer mappedByteBuffer) {
        if (mappedByteBuffer == null) {
            return;
        }
        if (this.bhr && mappedByteBuffer != this.bhh) {
            mappedByteBuffer.putInt(0, this.bhk - 12);
        }
        mappedByteBuffer.putLong(4, this.bhl);
        int i = this.bhq;
        if (i != 0) {
            mappedByteBuffer.put(i, this.bhj.bgV[i]);
        }
        if (this.bhp != 0) {
            mappedByteBuffer.position(this.bho);
            mappedByteBuffer.put(this.bhj.bgV, this.bho, this.bhp);
        }
    }

    private void b(long j, long j2, int i) {
        long jG = g(j2, i) ^ this.bhl;
        this.bhl = jG;
        if (this.bhv == 0) {
            MappedByteBuffer mappedByteBuffer = this.bhh;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, jG);
                this.bhh.putLong(i, j);
            }
            MappedByteBuffer mappedByteBuffer2 = this.bhi;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.bhl);
                this.bhi.putLong(i, j);
            }
        } else {
            com.kwad.sdk.utils.a.b bVar = this.bhj;
            if (bVar != null) {
                bVar.f(4, jG);
            }
        }
        com.kwad.sdk.utils.a.b bVar2 = this.bhj;
        if (bVar2 != null) {
            bVar2.f(i, j);
        }
    }

    private void a(MappedByteBuffer mappedByteBuffer, MappedByteBuffer mappedByteBuffer2, int i) {
        if (mappedByteBuffer.capacity() != mappedByteBuffer2.capacity()) {
            try {
                MappedByteBuffer map = (mappedByteBuffer2 == this.bhi ? this.bhe : this.bhd).map(FileChannel.MapMode.READ_WRITE, 0L, mappedByteBuffer.capacity());
                map.order(ByteOrder.LITTLE_ENDIAN);
                if (mappedByteBuffer2 == this.bhi) {
                    this.bhi = map;
                } else {
                    this.bhh = map;
                }
                mappedByteBuffer2 = map;
            } catch (Exception e2) {
                s(e2);
                Us();
                return;
            }
        }
        mappedByteBuffer.rewind();
        mappedByteBuffer2.rewind();
        mappedByteBuffer.limit(i);
        mappedByteBuffer2.put(mappedByteBuffer);
        mappedByteBuffer.limit(mappedByteBuffer.capacity());
    }

    private int b(String str, byte[] bArr, byte b2) {
        a(str, b2, bArr.length + 2);
        com.kwad.sdk.utils.a.b bVar = this.bhj;
        if (bVar == null) {
            return 0;
        }
        bVar.a((short) bArr.length);
        com.kwad.sdk.utils.a.b bVar2 = this.bhj;
        int i = bVar2.position;
        bVar2.k(bArr);
        return i;
    }

    private String a(a.i iVar) {
        byte[] bytes;
        try {
            byte[] bArrAf = h.af(new File(this.afW + this.name, (String) iVar.value));
            String str = new String(bArrAf);
            return (bArrAf == null || TextUtils.isEmpty(str) || (bytes = com.kwad.sdk.utils.a.b.j(bArrAf, com.kwad.sdk.utils.a.b.hU(str)).getBytes()) == null || bytes.length == 0) ? "" : new String(bytes, com.kwad.sdk.utils.a.b.UTF_8);
        } catch (Exception e2) {
            s(e2);
        }
        return "";
    }

    private byte[] a(a.C0636a c0636a) {
        try {
            byte[] bArrAf = h.af(new File(this.afW + this.name, (String) c0636a.value));
            return bArrAf != null ? bArrAf : bgX;
        } catch (Exception e2) {
            s(e2);
            return bgX;
        }
    }

    private Object a(a.h hVar) {
        try {
            byte[] bArrAf = h.af(new File(this.afW + this.name, (String) hVar.value));
            if (bArrAf != null) {
                int i = bArrAf[0] & UByte.MAX_VALUE;
                String str = new String(bArrAf, 1, i, com.kwad.sdk.utils.a.b.UTF_8);
                b bVar = this.bhb.get(str);
                if (bVar != null) {
                    int i2 = i + 1;
                    return bVar.f(bArrAf, i2, bArrAf.length - i2);
                }
                g(new Exception("No encoder for tag:" + str));
                return null;
            }
            g(new Exception("Read object data failed"));
            return null;
        } catch (Exception e2) {
            s(e2);
            return null;
        }
    }

    private synchronized <T> void a(String str, T t, b<T> bVar) {
        byte[] bArrQ;
        hX(str);
        if (bVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Encoder is null");
            if (!com.kwad.library.a.a.oy.booleanValue()) {
                s(illegalArgumentException);
                return;
            }
            throw illegalArgumentException;
        }
        String strUC = bVar.UC();
        if (!strUC.isEmpty() && strUC.length() <= 50) {
            if (!this.bhb.containsKey(strUC)) {
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Encoder hasn't been registered");
                if (!com.kwad.library.a.a.oy.booleanValue()) {
                    s(illegalArgumentException2);
                    return;
                }
                throw illegalArgumentException2;
            }
            if (t == null) {
                remove(str);
                return;
            }
            try {
                bArrQ = bVar.q(t);
            } catch (Exception e2) {
                s(e2);
                bArrQ = null;
            }
            if (bArrQ == null) {
                remove(str);
                return;
            }
            int iHU = com.kwad.sdk.utils.a.b.hU(strUC);
            com.kwad.sdk.utils.a.b bVar2 = new com.kwad.sdk.utils.a.b(iHU + 1 + bArrQ.length);
            bVar2.e((byte) iHU);
            bVar2.hT(strUC);
            bVar2.k(bArrQ);
            a(str, t, bVar2.bgV, (a.h) this.bhm.get(str), (byte) 8);
            return;
        }
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Invalid encoder tag:" + strUC);
        if (!com.kwad.library.a.a.oy.booleanValue()) {
            s(illegalArgumentException3);
            return;
        }
        throw illegalArgumentException3;
    }

    private synchronized void a(Map<String, Object> map, Map<Class, b> map2) {
        if (map == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key != null && !key.isEmpty()) {
                if (value instanceof String) {
                    putString(key, (String) value);
                } else if (value instanceof Boolean) {
                    putBoolean(key, ((Boolean) value).booleanValue());
                } else if (value instanceof Integer) {
                    putInt(key, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    putLong(key, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    putFloat(key, ((Float) value).floatValue());
                } else if (value instanceof Double) {
                    putDouble(key, ((Double) value).doubleValue());
                } else if (value instanceof Set) {
                    Set set = (Set) value;
                    if (!set.isEmpty() && (set.iterator().next() instanceof String)) {
                        putStringSet(key, (Set) value);
                    }
                } else if (value instanceof byte[]) {
                    b(key, (byte[]) value);
                } else {
                    g(new Exception("missing encoders"));
                }
            }
        }
    }

    private void a(MappedByteBuffer mappedByteBuffer) throws IOException {
        if (mappedByteBuffer == null) {
            return;
        }
        int iCapacity = mappedByteBuffer.capacity();
        int i = PAGE_SIZE;
        if (iCapacity != i) {
            FileChannel fileChannel = mappedByteBuffer == this.bhh ? this.bhd : this.bhe;
            if (fileChannel == null) {
                return;
            }
            fileChannel.truncate(i);
            MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, i);
            map.order(ByteOrder.LITTLE_ENDIAN);
            if (mappedByteBuffer == this.bhh) {
                this.bhh = map;
            } else {
                this.bhi = map;
            }
            mappedByteBuffer = map;
        }
        mappedByteBuffer.putInt(0, 0);
        mappedByteBuffer.putLong(4, 0L);
    }

    private void a(String str, byte b2) {
        a(str, b2, bgW[b2]);
    }

    private void a(String str, byte b2, int i) {
        int iHU = com.kwad.sdk.utils.a.b.hU(str);
        fx(iHU);
        this.bhp = iHU + 2 + i;
        Ux();
        com.kwad.sdk.utils.a.b bVar = this.bhj;
        if (bVar != null) {
            bVar.e(b2);
        }
        u(str, iHU);
    }

    private void a(byte b2, int i) {
        long jG = this.bhl ^ g(1L, i);
        this.bhl = jG;
        if (this.bhv == 0) {
            MappedByteBuffer mappedByteBuffer = this.bhh;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, jG);
                this.bhh.put(i, b2);
            }
            MappedByteBuffer mappedByteBuffer2 = this.bhi;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.bhl);
                this.bhi.put(i, b2);
            }
        } else {
            com.kwad.sdk.utils.a.b bVar = this.bhj;
            if (bVar != null) {
                bVar.f(4, jG);
            }
        }
        com.kwad.sdk.utils.a.b bVar2 = this.bhj;
        if (bVar2 != null) {
            bVar2.bgV[i] = b2;
        }
    }

    private void a(int i, long j, int i2) {
        long jG = g(j, i2) ^ this.bhl;
        this.bhl = jG;
        if (this.bhv == 0) {
            MappedByteBuffer mappedByteBuffer = this.bhh;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, jG);
                this.bhh.putInt(i2, i);
            }
            MappedByteBuffer mappedByteBuffer2 = this.bhi;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.bhl);
                this.bhi.putInt(i2, i);
            }
        } else {
            com.kwad.sdk.utils.a.b bVar = this.bhj;
            if (bVar != null) {
                bVar.f(4, jG);
            }
        }
        com.kwad.sdk.utils.a.b bVar2 = this.bhj;
        if (bVar2 != null) {
            bVar2.E(i2, i);
        }
    }

    private static void a(String str, int i, int i2, byte[] bArr, int i3) {
        int i4;
        if (i2 <= str.length() && i2 >= 0) {
            int i5 = 0;
            while (i5 < i2) {
                int i6 = i5 + 1;
                char cCharAt = str.charAt(i5);
                if (cCharAt < 128) {
                    i4 = i3 + 1;
                    bArr[i3] = (byte) (((byte) cCharAt) ^ 1);
                } else {
                    i4 = i3 + 1;
                    bArr[i3] = (byte) cCharAt;
                }
                i5 = i6;
                i3 = i4;
            }
        }
    }

    private void a(String str, String str2, a.i iVar) {
        int iHU = com.kwad.sdk.utils.a.b.hU(str2);
        if (iVar == null) {
            int iHU2 = com.kwad.sdk.utils.a.b.hU(str);
            fx(iHU2);
            int i = iHU2 + 4;
            this.bhp = i + iHU;
            Ux();
            com.kwad.sdk.utils.a.b bVar = this.bhj;
            if (bVar != null) {
                bVar.e((byte) 6);
            }
            u(str, iHU2);
            v(str2, iHU);
            Map<String, a.b> map = this.bhm;
            int i2 = this.bho;
            map.put(str, new a.i(i2, i2 + i, str2, iHU, false));
            Uv();
        } else {
            int i3 = iVar.offset;
            int i4 = i3 - iVar.start;
            int i5 = iVar.bgS;
            boolean z = false;
            if (i5 == iHU) {
                this.bhl ^= this.bhj.G(i3, i5);
                if (iHU == str2.length()) {
                    a(str2, 0, iHU, this.bhj.bgV, iVar.offset);
                } else {
                    com.kwad.sdk.utils.a.b bVar2 = this.bhj;
                    if (bVar2 != null) {
                        bVar2.position = iVar.offset;
                        bVar2.hT(str2);
                    }
                }
                this.bho = iVar.offset;
                this.bhp = iHU;
            } else {
                this.bhp = i4 + iHU;
                Ux();
                com.kwad.sdk.utils.a.b bVar3 = this.bhj;
                if (bVar3 != null) {
                    bVar3.e((byte) 6);
                }
                int i6 = i4 - 3;
                com.kwad.sdk.utils.a.b bVar4 = this.bhj;
                if (bVar4 != null) {
                    byte[] bArr = bVar4.bgV;
                    System.arraycopy(bArr, iVar.start + 1, bArr, bVar4.position, i6);
                }
                com.kwad.sdk.utils.a.b bVar5 = this.bhj;
                if (bVar5 != null) {
                    bVar5.position += i6;
                }
                v(str2, iHU);
                a((byte) 6, iVar.start, iVar.offset + iVar.bgS);
                str = iVar.bgT ? (String) iVar.value : null;
                iVar.bgT = false;
                int i7 = this.bho;
                iVar.start = i7;
                iVar.offset = i7 + i4;
                iVar.bgS = iHU;
                z = true;
            }
            iVar.value = str2;
            Uv();
            if (z) {
                Uy();
            }
            if (str != null) {
                h.h(new File(this.afW + this.name, str));
            }
        }
        Uo();
    }

    private void a(String str, Object obj, byte[] bArr, a.j jVar, byte b2) {
        if (jVar == null) {
            a(str, obj, bArr, b2);
        } else if (!jVar.bgT && jVar.bgS == bArr.length) {
            updateBytes(jVar.offset, bArr);
            jVar.value = obj;
        } else {
            a(str, obj, bArr, jVar);
        }
        Uo();
    }

    private void a(String str, Object obj, byte[] bArr, byte b2) {
        Object obj2;
        int length;
        a.b hVar;
        int iA = a(str, bArr, b2);
        if (iA != 0) {
            String str2 = this.bhs;
            boolean z = str2 != null;
            if (z) {
                this.bhs = null;
                obj2 = str2;
                length = 32;
            } else {
                obj2 = obj;
                length = bArr.length;
            }
            if (b2 == 6) {
                hVar = new a.i(this.bho, iA, (String) obj2, length, z);
            } else if (b2 == 7) {
                hVar = new a.C0636a(this.bho, iA, obj2, length, z);
            } else {
                hVar = new a.h(this.bho, iA, obj2, length, z);
            }
            this.bhm.put(str, hVar);
            Uv();
        }
    }

    private void a(String str, Object obj, byte[] bArr, @NonNull a.j jVar) {
        int iA = a(str, bArr, jVar.Uh());
        if (iA != 0) {
            String str2 = jVar.bgT ? (String) jVar.value : null;
            a(jVar.Uh(), jVar.start, jVar.offset + jVar.bgS);
            String str3 = this.bhs;
            boolean z = str3 != null;
            jVar.start = this.bho;
            jVar.offset = iA;
            jVar.bgT = z;
            if (z) {
                jVar.value = str3;
                jVar.bgS = 32;
                this.bhs = null;
            } else {
                jVar.value = obj;
                jVar.bgS = bArr.length;
            }
            Uv();
            Uy();
            if (str2 != null) {
                h.h(new File(this.afW + this.name, str2));
            }
        }
    }

    private int a(String str, byte[] bArr, byte b2) {
        this.bhs = null;
        if (bArr.length < 2048) {
            return b(str, bArr, b2);
        }
        info("large value, key: " + str + ", size: " + bArr.length);
        String strUD = h.UD();
        if (h.a(new File(this.afW + this.name, strUD), bArr)) {
            this.bhs = strUD;
            byte[] bArr2 = new byte[32];
            strUD.getBytes(0, 32, bArr2, 0);
            return b(str, bArr2, (byte) (b2 | 64));
        }
        hY("save large value failed");
        return 0;
    }

    private void a(byte b2, int i, int i2) {
        byte[] bArr;
        I(i, i2);
        byte b3 = (byte) (b2 | ByteCompanionObject.MIN_VALUE);
        com.kwad.sdk.utils.a.b bVar = this.bhj;
        if (bVar != null && (bArr = bVar.bgV) != null) {
            this.bhl = ((((long) (bArr[i] ^ b3)) & 255) << ((i & 7) << 3)) ^ this.bhl;
            bArr[i] = b3;
        }
        this.bhq = i;
    }

    private void a(int i, int[] iArr) {
        Map<String, a.b> map = this.bhm;
        if (map == null) {
            return;
        }
        for (a.b bVar : map.values()) {
            int i2 = bVar.offset;
            if (i2 > i) {
                int i3 = iArr[(h.binarySearch(iArr, i2) << 1) + 1];
                bVar.offset -= i3;
                if (bVar.Uh() >= 6) {
                    ((a.j) bVar).start -= i3;
                }
            }
        }
    }
}
