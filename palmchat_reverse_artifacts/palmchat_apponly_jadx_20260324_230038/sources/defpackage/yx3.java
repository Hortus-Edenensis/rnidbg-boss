package defpackage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.drawable.NinePatchDrawable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class yx3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f22298a;
    public int b;
    public Bitmap c;
    public Resources d;
    public ArrayList<Integer> e = new ArrayList<>();
    public ArrayList<Integer> f = new ArrayList<>();

    public yx3(Resources resources, Bitmap bitmap) {
        this.f22298a = bitmap.getWidth();
        this.b = bitmap.getHeight();
        this.c = bitmap;
        this.d = resources;
    }

    public yx3 a(int i) {
        int i2 = (this.f22298a - i) / 2;
        this.e.add(Integer.valueOf(i2));
        this.e.add(Integer.valueOf(i2 + i));
        return this;
    }

    public yx3 b(int i) {
        int i2 = (this.b - i) / 2;
        this.f.add(Integer.valueOf(i2));
        this.f.add(Integer.valueOf(i2 + i));
        return this;
    }

    public NinePatchDrawable c() {
        NinePatch ninePatchE = e();
        if (ninePatchE != null) {
            return new NinePatchDrawable(this.d, ninePatchE);
        }
        return null;
    }

    public byte[] d() {
        if (this.e.size() == 0) {
            this.e.add(0);
            this.e.add(Integer.valueOf(this.f22298a));
        }
        if (this.f.size() == 0) {
            this.f.add(0);
            this.f.add(Integer.valueOf(this.b));
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate((this.e.size() + 8 + this.f.size() + 9) * 4).order(ByteOrder.nativeOrder());
        byteBufferOrder.put((byte) 1);
        byteBufferOrder.put((byte) this.e.size());
        byteBufferOrder.put((byte) this.f.size());
        byteBufferOrder.put((byte) 9);
        byteBufferOrder.putInt(0);
        byteBufferOrder.putInt(0);
        byteBufferOrder.putInt(0);
        byteBufferOrder.putInt(0);
        byteBufferOrder.putInt(0);
        byteBufferOrder.putInt(0);
        byteBufferOrder.putInt(0);
        Iterator<Integer> it = this.e.iterator();
        while (it.hasNext()) {
            byteBufferOrder.putInt(it.next().intValue());
        }
        Iterator<Integer> it2 = this.f.iterator();
        while (it2.hasNext()) {
            byteBufferOrder.putInt(it2.next().intValue());
        }
        for (int i = 0; i < 9; i++) {
            byteBufferOrder.putInt(1);
        }
        return byteBufferOrder.array();
    }

    public NinePatch e() {
        byte[] bArrD = d();
        if (this.c != null) {
            return new NinePatch(this.c, bArrD, null);
        }
        return null;
    }
}
