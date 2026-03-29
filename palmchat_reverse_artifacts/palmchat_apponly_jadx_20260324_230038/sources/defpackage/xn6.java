package defpackage;

import android.graphics.Rect;
import android.opengl.GLES20;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public abstract class xn6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Surface f22015a;
    public boolean b;
    public byte[] c = new byte[128];

    public xn6(ok1 ok1Var, Surface surface, boolean z) {
        this.f22015a = surface;
        this.b = z;
    }

    public static xn6 a(ok1 ok1Var, Surface surface, SurfaceHolder surfaceHolder, boolean z) {
        return new fl1(ok1Var, surface, z);
    }

    public final void b(ByteBuffer byteBuffer, int i, int i2, int i3) {
        byte[] bArrArray = byteBuffer.array();
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i - i3;
            int i6 = i * i4 * 4;
            int i7 = ((i5 - 1) * 4) + i6;
            for (int i8 = 0; i8 < i3; i8++) {
                byte[] bArr = this.c;
                int i9 = i8 * 4;
                bArr[i9] = bArrArray[i7];
                bArr[i9 + 1] = bArrArray[i7 + 1];
                bArr[i9 + 2] = bArrArray[i7 + 2];
                bArr[i9 + 3] = bArrArray[i7 + 3];
            }
            System.arraycopy(this.c, 0, bArrArray, (i5 * 4) + i6, i3 * 4);
        }
    }

    public void c(ByteBuffer byteBuffer, Rect rect) {
        int i;
        int i2;
        if (!f()) {
            throw new RuntimeException("Expected EGL context/surface is not current");
        }
        int i3 = rect.right - rect.left;
        int i4 = rect.bottom - rect.top;
        int iE = e();
        int iD = d();
        if (iD != i4) {
            i3 = ((i3 + 15) >> 4) << 4;
            i4 = ((i4 + 15) >> 4) << 4;
            int i5 = (iD - rect.top) - i4;
            int i6 = (iE - rect.left) - i3;
            Log.i("Grafika", "fullSizeWidth  = " + iE + "fullSizeheight = " + iD);
            Log.i("Grafika", "transfer to width = " + i3 + " height = " + i4 + "topOffset = " + i5 + "leftOffset = " + i6);
            i = i6;
            i2 = i5;
        } else {
            i = 0;
            i2 = 0;
        }
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        GLES20.glReadPixels(i, i2, i3, i4, 6408, 5121, byteBuffer);
        gc2.a("glReadPixels");
        j(byteBuffer, i3, i4, 0);
        Log.d("scaledimage", "taken:" + (System.currentTimeMillis() - System.currentTimeMillis()) + "ms");
        byteBuffer.rewind();
    }

    public abstract int d();

    public abstract int e();

    public abstract boolean f();

    public abstract void g();

    public void h() {
        i();
        Surface surface = this.f22015a;
        if (surface != null) {
            if (this.b) {
                surface.release();
            }
            this.f22015a = null;
        }
    }

    public abstract void i();

    public void j(ByteBuffer byteBuffer, int i, int i2, int i3) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (i3 != 0) {
            b(byteBuffer, i, i2, i3);
        }
        int i4 = i * 4;
        byte[] bArr = new byte[i4];
        int i5 = 0;
        while (true) {
            int i6 = i5 + 1;
            if (i5 >= i2 / 2) {
                byteBuffer.rewind();
                Log.d("Grafika", "reverseBuf took " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
                return;
            }
            byteBuffer.get(bArr);
            System.arraycopy(byteBuffer.array(), byteBuffer.limit() - byteBuffer.position(), byteBuffer.array(), byteBuffer.position() - i4, i4);
            System.arraycopy(bArr, 0, byteBuffer.array(), byteBuffer.limit() - byteBuffer.position(), i4);
            i5 = i6;
        }
    }

    public abstract boolean k();
}
