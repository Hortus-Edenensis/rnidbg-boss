package defpackage;

import com.zenmen.palmchat.video.recorder.gles.Drawable2d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class o25 extends Drawable2d {
    public FloatBuffer t;
    public float u;
    public boolean v;

    public o25(Drawable2d.Prefab prefab) {
        super(prefab);
        this.u = 1.0f;
        this.v = true;
    }

    @Override // com.zenmen.palmchat.video.recorder.gles.Drawable2d
    public FloatBuffer b() {
        if (this.v) {
            FloatBuffer floatBufferB = super.b();
            int iCapacity = floatBufferB.capacity();
            if (this.t == null) {
                ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(iCapacity * 4);
                byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
                this.t = byteBufferAllocateDirect.asFloatBuffer();
            }
            FloatBuffer floatBuffer = this.t;
            float f = this.u;
            for (int i = 0; i < iCapacity; i++) {
                floatBuffer.put(i, ((floatBufferB.get(i) - 0.5f) * f) + 0.5f);
            }
            this.v = false;
        }
        return this.t;
    }

    public void g(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            this.u = f;
            this.v = true;
        } else {
            throw new RuntimeException("invalid scale " + f);
        }
    }
}
