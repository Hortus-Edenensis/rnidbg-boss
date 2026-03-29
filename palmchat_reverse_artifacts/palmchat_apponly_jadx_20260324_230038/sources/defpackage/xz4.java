package defpackage;

import android.graphics.Canvas;
import android.widget.ImageView;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0019¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010\u0006\u001a\f\u0012\b\u0012\u00060\u0005R\u00020\u00000\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\n\u001a\u00020\t2\u0010\u0010\b\u001a\f\u0012\b\u0012\u00060\u0005R\u00020\u00000\u0004H\u0000¢\u0006\u0004\b\n\u0010\u000bJ \u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0017\u0010\u0015\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0018\u001a\f\u0012\b\u0012\u00060\u0005R\u00020\u00000\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001c¨\u0006 "}, d2 = {"Lxz4;", "", "", "frameIndex", "", "Lxz4$a;", "e", "(I)Ljava/util/List;", "sprites", "", "d", "(Ljava/util/List;)V", "Landroid/graphics/Canvas;", "canvas", "Landroid/widget/ImageView$ScaleType;", "scaleType", "a", "Lk15;", "Lk15;", t.l, "()Lk15;", "scaleInfo", "Llk4;", "Llk4;", "spritePool", "Lm15;", "c", "Lm15;", "()Lm15;", "videoItem", "<init>", "(Lm15;)V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
public class xz4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final k15 scaleInfo = new k15();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final lk4<a> spritePool;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final m15 videoItem;

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0004\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0006R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u0018\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0012¨\u0006\u001b"}, d2 = {"Lxz4$a;", "", "", "a", "Ljava/lang/String;", "get_matteKey", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "_matteKey", t.l, "get_imageKey", "e", "_imageKey", "Lq15;", "c", "Lq15;", "get_frameEntity", "()Lq15;", "d", "(Lq15;)V", "_frameEntity", "matteKey", "imageKey", "frameEntity", "<init>", "(Lxz4;Ljava/lang/String;Ljava/lang/String;Lq15;)V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        public String _matteKey;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public String _imageKey;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        public q15 _frameEntity;

        public a(String str, String str2, q15 q15Var) {
            this._matteKey = str;
            this._imageKey = str2;
            this._frameEntity = q15Var;
        }

        public final q15 a() {
            q15 q15Var = this._frameEntity;
            if (q15Var == null) {
                Intrinsics.throwNpe();
            }
            return q15Var;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final String get_imageKey() {
            return this._imageKey;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final String get_matteKey() {
            return this._matteKey;
        }

        public final void d(q15 q15Var) {
            this._frameEntity = q15Var;
        }

        public final void e(String str) {
            this._imageKey = str;
        }

        public final void f(String str) {
            this._matteKey = str;
        }

        public /* synthetic */ a(xz4 xz4Var, String str, String str2, q15 q15Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : q15Var);
        }
    }

    public xz4(m15 m15Var) {
        this.videoItem = m15Var;
        this.spritePool = new lk4<>(Math.max(1, m15Var.q().size()));
    }

    public void a(Canvas canvas, int frameIndex, ImageView.ScaleType scaleType) {
        this.scaleInfo.f(canvas.getWidth(), canvas.getHeight(), (float) this.videoItem.getVideoSize().getWidth(), (float) this.videoItem.getVideoSize().getHeight(), scaleType);
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final k15 getScaleInfo() {
        return this.scaleInfo;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final m15 getVideoItem() {
        return this.videoItem;
    }

    public final void d(List<a> sprites) {
        Iterator<T> it = sprites.iterator();
        while (it.hasNext()) {
            this.spritePool.c((a) it.next());
        }
    }

    public final List<a> e(int frameIndex) {
        String imageKey;
        List<p15> listQ = this.videoItem.q();
        ArrayList arrayList = new ArrayList();
        for (p15 p15Var : listQ) {
            a aVarA = null;
            if (frameIndex >= 0 && frameIndex < p15Var.a().size() && (imageKey = p15Var.getImageKey()) != null && (StringsKt__StringsJVMKt.endsWith$default(imageKey, ".matte", false, 2, null) || p15Var.a().get(frameIndex).getAlpha() > 0.0d)) {
                aVarA = this.spritePool.a();
                if (aVarA == null) {
                    aVarA = new a(this, null, null, null, 7, null);
                }
                aVarA.f(p15Var.getMatteKey());
                aVarA.e(p15Var.getImageKey());
                aVarA.d(p15Var.a().get(frameIndex));
            }
            if (aVarA != null) {
                arrayList.add(aVarA);
            }
        }
        return arrayList;
    }
}
