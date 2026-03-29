package defpackage;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.media.SoundPool;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kuaishou.weapon.p0.t;
import com.qq.gdt.action.ActionUtils;
import java.util.Iterator;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u00100\u001a\u00020-¢\u0006\u0004\b1\u00102J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004R*\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f8\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00068\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010$\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0017\u0010,\u001a\u00020)8\u0006¢\u0006\f\n\u0004\b\u0014\u0010*\u001a\u0004\b&\u0010+R\u0017\u00100\u001a\u00020-8\u0006¢\u0006\f\n\u0004\b\u001a\u0010.\u001a\u0004\b\u001e\u0010/¨\u00063"}, d2 = {"Ly05;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/Canvas;", "canvas", "", MediationConstant.RIT_TYPE_DRAW, "", "alpha", "setAlpha", "getOpacity", "Landroid/graphics/ColorFilter;", "colorFilter", "setColorFilter", "h", "a", "", ActionUtils.PAYMENT_AMOUNT, "Z", "getCleared", "()Z", "e", "(Z)V", "cleared", t.l, "I", "()I", "f", "(I)V", "currentFrame", "Landroid/widget/ImageView$ScaleType;", "c", "Landroid/widget/ImageView$ScaleType;", "getScaleType", "()Landroid/widget/ImageView$ScaleType;", "g", "(Landroid/widget/ImageView$ScaleType;)V", "scaleType", "Lw05;", "d", "Lw05;", "drawer", "Lm15;", "Lm15;", "()Lm15;", "videoItem", "Lz05;", "Lz05;", "()Lz05;", "dynamicItem", "<init>", "(Lm15;Lz05;)V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
public final class y05 extends Drawable {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public int currentFrame;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final w05 drawer;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final m15 videoItem;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final z05 dynamicItem;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public boolean cleared = true;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public ImageView.ScaleType scaleType = ImageView.ScaleType.MATRIX;

    public y05(m15 m15Var, z05 z05Var) {
        this.videoItem = m15Var;
        this.dynamicItem = z05Var;
        this.drawer = new w05(m15Var, z05Var);
    }

    public final void a() {
        for (r05 r05Var : this.videoItem.l()) {
            Integer playID = r05Var.getPlayID();
            if (playID != null) {
                int iIntValue = playID.intValue();
                l15 l15Var = l15.e;
                if (l15Var.b()) {
                    l15Var.e(iIntValue);
                } else {
                    SoundPool soundPool = this.videoItem.getSoundPool();
                    if (soundPool != null) {
                        soundPool.stop(iIntValue);
                    }
                }
            }
            r05Var.e(null);
        }
        this.videoItem.b();
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final int getCurrentFrame() {
        return this.currentFrame;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final z05 getDynamicItem() {
        return this.dynamicItem;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final m15 getVideoItem() {
        return this.videoItem;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.cleared || canvas == null) {
            return;
        }
        this.drawer.a(canvas, this.currentFrame, this.scaleType);
    }

    public final void e(boolean z) {
        if (this.cleared == z) {
            return;
        }
        this.cleared = z;
        invalidateSelf();
    }

    public final void f(int i) {
        if (this.currentFrame == i) {
            return;
        }
        this.currentFrame = i;
        invalidateSelf();
    }

    public final void g(ImageView.ScaleType scaleType) {
        this.scaleType = scaleType;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public final void h() {
        Iterator<T> it = this.videoItem.l().iterator();
        while (it.hasNext()) {
            Integer playID = ((r05) it.next()).getPlayID();
            if (playID != null) {
                int iIntValue = playID.intValue();
                l15 l15Var = l15.e;
                if (l15Var.b()) {
                    l15Var.e(iIntValue);
                } else {
                    SoundPool soundPool = this.videoItem.getSoundPool();
                    if (soundPool != null) {
                        soundPool.stop(iIntValue);
                    }
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
