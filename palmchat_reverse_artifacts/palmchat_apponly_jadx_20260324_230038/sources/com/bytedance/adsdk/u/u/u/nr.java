package com.bytedance.adsdk.u.u.u;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.bytedance.adsdk.u.u.u.a;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class nr extends a<com.bytedance.adsdk.u.u.nr.u, com.bytedance.adsdk.u.u.nr.nr> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint f5023a;
    private final u jk;
    private int n;
    private com.bytedance.adsdk.u.u.nr.nr x;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        ByteBuffer fx;
        Rect nr;
        byte u;

        private u() {
            this.nr = new Rect();
        }
    }

    public nr(com.bytedance.adsdk.u.u.fx.nr nrVar, a.u uVar) {
        super(nrVar, uVar);
        Paint paint = new Paint();
        this.f5023a = paint;
        this.jk = new u();
        paint.setAntiAlias(true);
    }

    @Override // com.bytedance.adsdk.u.u.u.a
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.u.u.nr.nr b() {
        if (this.x == null) {
            this.x = new com.bytedance.adsdk.u.u.nr.nr();
        }
        return this.x;
    }

    @Override // com.bytedance.adsdk.u.u.u.a
    public void fx() {
        this.jk.fx = null;
        this.x = null;
    }

    @Override // com.bytedance.adsdk.u.u.u.a
    public int nr() {
        return this.n;
    }

    @Override // com.bytedance.adsdk.u.u.u.a
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.u.u.nr.u fx(com.bytedance.adsdk.u.u.nr.iz izVar) {
        return new com.bytedance.adsdk.u.u.nr.u(izVar);
    }

    @Override // com.bytedance.adsdk.u.u.u.a
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public Rect nr(com.bytedance.adsdk.u.u.nr.u uVar) throws IOException {
        List<pn> listU = b.u(uVar);
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[0];
        Iterator<pn> it = listU.iterator();
        fx fxVar = null;
        boolean z = false;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            pn next = it.next();
            if (next instanceof com.bytedance.adsdk.u.u.u.u) {
                this.n = ((com.bytedance.adsdk.u.u.u.u) next).fx;
                z = true;
            } else if (next instanceof iz) {
                fxVar = new fx(uVar, (iz) next);
                fxVar.pn = arrayList;
                fxVar.fx = bArr;
                this.u.add(fxVar);
            } else if (next instanceof x) {
                if (fxVar != null) {
                    fxVar.b.add(next);
                }
            } else if (next instanceof jk) {
                if (!z) {
                    mv mvVar = new mv(uVar);
                    mvVar.n = i;
                    mvVar.f5022a = i2;
                    this.u.add(mvVar);
                    this.n = 1;
                    break;
                }
                if (fxVar != null) {
                    fxVar.b.add(next);
                }
            } else if (next instanceof l) {
                l lVar = (l) next;
                i = lVar.nr;
                i2 = lVar.fx;
                bArr = lVar.n;
            } else if (!(next instanceof t)) {
                arrayList.add(next);
            }
        }
        int i3 = i * i2;
        int i4 = this.fx;
        this.pn = ByteBuffer.allocate(((i3 / (i4 * i4)) + 1) * 4);
        u uVar2 = this.jk;
        int i5 = this.fx;
        uVar2.fx = ByteBuffer.allocate(((i3 / (i5 * i5)) + 1) * 4);
        return new Rect(0, 0, i, i2);
    }

    @Override // com.bytedance.adsdk.u.u.u.a
    public void u(n<com.bytedance.adsdk.u.u.nr.u, com.bytedance.adsdk.u.u.nr.nr> nVar) {
        if (nVar == null || this.iz == null) {
            return;
        }
        try {
            Bitmap bitmapU = u(this.iz.width() / this.fx, this.iz.height() / this.fx);
            Canvas canvas = this.b.get(bitmapU);
            if (canvas == null) {
                canvas = new Canvas(bitmapU);
                this.b.put(bitmapU, canvas);
            }
            Canvas canvas2 = canvas;
            if (nVar instanceof fx) {
                this.pn.rewind();
                bitmapU.copyPixelsFromBuffer(this.pn);
                if (this.nr == 0) {
                    canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                } else {
                    canvas2.save();
                    canvas2.clipRect(this.jk.nr);
                    u uVar = this.jk;
                    byte b = uVar.u;
                    if (b == 1) {
                        canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                    } else if (b == 2) {
                        uVar.fx.rewind();
                        bitmapU.copyPixelsFromBuffer(this.jk.fx);
                    }
                    canvas2.restore();
                }
                if (((fx) nVar).nr == 2) {
                    u uVar2 = this.jk;
                    if (uVar2.u != 2) {
                        uVar2.fx.rewind();
                        bitmapU.copyPixelsToBuffer(this.jk.fx);
                    }
                }
                this.jk.u = ((fx) nVar).nr;
                canvas2.save();
                if (((fx) nVar).u == 0) {
                    int i = nVar.jk;
                    int i2 = this.fx;
                    int i3 = nVar.t;
                    canvas2.clipRect(i / i2, i3 / i2, (i + nVar.n) / i2, (i3 + nVar.f5022a) / i2);
                    canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                }
                Rect rect = this.jk.nr;
                int i4 = nVar.jk;
                int i5 = this.fx;
                int i6 = nVar.t;
                rect.set(i4 / i5, i6 / i5, (i4 + nVar.n) / i5, (i6 + nVar.f5022a) / i5);
                canvas2.restore();
            }
            Bitmap bitmapU2 = u(nVar.n, nVar.f5022a);
            u(nVar.u(canvas2, this.f5023a, this.fx, bitmapU2, b()));
            u(bitmapU2);
            this.pn.rewind();
            bitmapU.copyPixelsToBuffer(this.pn);
            u(bitmapU);
        } catch (Exception unused) {
        }
    }
}
