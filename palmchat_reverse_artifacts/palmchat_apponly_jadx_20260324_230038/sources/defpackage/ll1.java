package defpackage;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class ll1 extends il1 {
    public final nl1 j;

    public ll1(boolean z, nl1 nl1Var) throws IOException {
        this.f18194a = z;
        this.j = nl1Var;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.b = nl1Var.g(byteBufferAllocate, 16L);
        this.c = nl1Var.j(byteBufferAllocate, 28L);
        this.d = nl1Var.j(byteBufferAllocate, 32L);
        this.e = nl1Var.g(byteBufferAllocate, 42L);
        this.f = nl1Var.g(byteBufferAllocate, 44L);
        this.g = nl1Var.g(byteBufferAllocate, 46L);
        this.h = nl1Var.g(byteBufferAllocate, 48L);
        this.i = nl1Var.g(byteBufferAllocate, 50L);
    }

    @Override // defpackage.il1
    public hl1 a(long j, int i) throws IOException {
        return new vi1(this.j, this, j, i);
    }

    @Override // defpackage.il1
    public jl1 b(long j) throws IOException {
        return new tn4(this.j, this, j);
    }

    @Override // defpackage.il1
    public kl1 c(int i) throws IOException {
        return new i45(this.j, this, i);
    }
}
