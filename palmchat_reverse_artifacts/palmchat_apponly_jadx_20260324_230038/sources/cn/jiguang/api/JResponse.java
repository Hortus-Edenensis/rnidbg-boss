package cn.jiguang.api;

import cn.jiguang.api.utils.ByteBufferUtils;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public abstract class JResponse extends JProtocol {
    public int d;

    public JResponse(int i, int i2, long j, long j2, int i3, String str) {
        super(false, i, i2, j, -1, j2);
        this.d = i3;
    }

    @Override // cn.jiguang.api.JProtocol
    public void b() {
        if (a()) {
            this.d = ByteBufferUtils.getShort(this.c, this);
        }
    }

    @Override // cn.jiguang.api.JProtocol
    public void d() {
        int i = this.d;
        if (i >= 0) {
            e(i);
        }
    }

    @Override // cn.jiguang.api.JProtocol
    public String toString() {
        return "JResponse{code=" + this.d + '}';
    }

    public JResponse(Object obj, ByteBuffer byteBuffer) {
        super(false, obj, byteBuffer);
    }

    public JResponse(ByteBuffer byteBuffer, byte[] bArr) {
        super(false, byteBuffer, bArr);
    }
}
