package defpackage;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class tn4 extends jl1 {
    public tn4(nl1 nl1Var, il1 il1Var, long j) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(il1Var.f18194a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = il1Var.c + (j * ((long) il1Var.e));
        this.f18431a = nl1Var.j(byteBufferAllocate, j2);
        this.b = nl1Var.j(byteBufferAllocate, 4 + j2);
        this.c = nl1Var.j(byteBufferAllocate, 8 + j2);
        this.d = nl1Var.j(byteBufferAllocate, j2 + 20);
    }
}
