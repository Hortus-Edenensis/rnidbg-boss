package defpackage;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class vi1 extends hl1 {
    public vi1(nl1 nl1Var, il1 il1Var, long j, int i) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(il1Var.f18194a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = j + ((long) (i * 8));
        this.f17990a = nl1Var.j(byteBufferAllocate, j2);
        this.b = nl1Var.j(byteBufferAllocate, j2 + 4);
    }
}
