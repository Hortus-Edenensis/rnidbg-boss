package defpackage;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class j45 extends kl1 {
    public j45(nl1 nl1Var, il1 il1Var, int i) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(il1Var.f18194a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f18717a = nl1Var.j(byteBufferAllocate, il1Var.d + ((long) (i * il1Var.g)) + 44);
    }
}
