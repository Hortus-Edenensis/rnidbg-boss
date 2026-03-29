package defpackage;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class ml1 extends il1 {
    public final nl1 j;

    public ml1(boolean z, nl1 nl1Var) throws IOException {
        this.f18194a = z;
        this.j = nl1Var;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.b = nl1Var.g(byteBufferAllocate, 16L);
        this.c = nl1Var.h(byteBufferAllocate, 32L);
        this.d = nl1Var.h(byteBufferAllocate, 40L);
        this.e = nl1Var.g(byteBufferAllocate, 54L);
        this.f = nl1Var.g(byteBufferAllocate, 56L);
        this.g = nl1Var.g(byteBufferAllocate, 58L);
        this.h = nl1Var.g(byteBufferAllocate, 60L);
        this.i = nl1Var.g(byteBufferAllocate, 62L);
    }

    @Override // defpackage.il1
    public hl1 a(long j, int i) throws IOException {
        return new wi1(this.j, this, j, i);
    }

    @Override // defpackage.il1
    public jl1 b(long j) throws IOException {
        return new un4(this.j, this, j);
    }

    @Override // defpackage.il1
    public kl1 c(int i) throws IOException {
        return new j45(this.j, this, i);
    }
}
