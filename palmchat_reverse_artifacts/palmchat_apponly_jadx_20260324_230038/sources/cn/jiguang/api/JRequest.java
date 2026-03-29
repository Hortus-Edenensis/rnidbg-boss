package cn.jiguang.api;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public abstract class JRequest extends JProtocol {
    public JRequest(int i, int i2, long j) {
        super(true, i, i2, j);
    }

    public void setJuid(long j) {
        this.b.f(j);
    }

    public void setSid(int i) {
        this.b.h(i);
    }

    public JRequest(Object obj, ByteBuffer byteBuffer) {
        super(true, obj, byteBuffer);
    }
}
