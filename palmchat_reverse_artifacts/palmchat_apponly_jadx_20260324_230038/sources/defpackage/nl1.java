package defpackage;

import androidx.media3.muxer.MuxerUtil;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.UByte;
import kotlin.UShort;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class nl1 implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19554a = 1179403647;
    public final FileChannel b;

    public nl1(File file) throws FileNotFoundException {
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException("File is null or does not exist");
        }
        this.b = new FileInputStream(file).getChannel();
    }

    public final long a(il1 il1Var, long j, long j2) throws IOException {
        for (long j3 = 0; j3 < j; j3++) {
            jl1 jl1VarB = il1Var.b(j3);
            if (jl1VarB.f18431a == 1) {
                long j4 = jl1VarB.c;
                if (j4 <= j2 && j2 <= jl1VarB.d + j4) {
                    return (j2 - j4) + jl1VarB.b;
                }
            }
        }
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    public il1 c() throws IOException {
        this.b.position(0L);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        if (j(byteBufferAllocate, 0L) != 1179403647) {
            throw new IllegalArgumentException("Invalid ELF Magic!");
        }
        short sF = f(byteBufferAllocate, 4L);
        boolean z = f(byteBufferAllocate, 5L) == 2;
        if (sF == 1) {
            return new ll1(z, this);
        }
        if (sF == 2) {
            return new ml1(z, this);
        }
        throw new IllegalStateException("Invalid class type!");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.b.close();
    }

    public List<String> d() throws IOException {
        long j;
        this.b.position(0L);
        ArrayList arrayList = new ArrayList();
        il1 il1VarC = c();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(il1VarC.f18194a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = il1VarC.f;
        int i = 0;
        if (j2 == WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            j2 = il1VarC.c(0).f18717a;
        }
        long j3 = 0;
        while (true) {
            if (j3 >= j2) {
                j = 0;
                break;
            }
            jl1 jl1VarB = il1VarC.b(j3);
            if (jl1VarB.f18431a == 2) {
                j = jl1VarB.b;
                break;
            }
            j3++;
        }
        if (j == 0) {
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        long j4 = 0;
        while (true) {
            hl1 hl1VarA = il1VarC.a(j, i);
            long j5 = j;
            long j6 = hl1VarA.f17990a;
            if (j6 == 1) {
                arrayList2.add(Long.valueOf(hl1VarA.b));
            } else if (j6 == 5) {
                j4 = hl1VarA.b;
            }
            i++;
            if (hl1VarA.f17990a == 0) {
                break;
            }
            j = j5;
        }
        if (j4 == 0) {
            throw new IllegalStateException("String table offset not found!");
        }
        long jA = a(il1VarC, j2, j4);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.add(i(byteBufferAllocate, ((Long) it.next()).longValue() + jA));
        }
        return arrayList;
    }

    public void e(ByteBuffer byteBuffer, long j, int i) throws IOException {
        byteBuffer.position(0);
        byteBuffer.limit(i);
        long j2 = 0;
        while (j2 < i) {
            int i2 = this.b.read(byteBuffer, j + j2);
            if (i2 == -1) {
                throw new EOFException();
            }
            j2 += (long) i2;
        }
        byteBuffer.position(0);
    }

    public short f(ByteBuffer byteBuffer, long j) throws IOException {
        e(byteBuffer, j, 1);
        return (short) (byteBuffer.get() & UByte.MAX_VALUE);
    }

    public int g(ByteBuffer byteBuffer, long j) throws IOException {
        e(byteBuffer, j, 2);
        return byteBuffer.getShort() & UShort.MAX_VALUE;
    }

    public long h(ByteBuffer byteBuffer, long j) throws IOException {
        e(byteBuffer, j, 8);
        return byteBuffer.getLong();
    }

    public String i(ByteBuffer byteBuffer, long j) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j2 = 1 + j;
            short sF = f(byteBuffer, j);
            if (sF == 0) {
                return sb.toString();
            }
            sb.append((char) sF);
            j = j2;
        }
    }

    public long j(ByteBuffer byteBuffer, long j) throws IOException {
        e(byteBuffer, j, 4);
        return ((long) byteBuffer.getInt()) & MuxerUtil.UNSIGNED_INT_MAX_VALUE;
    }
}
