package defpackage;

import android.widget.ImageView;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&J.\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\b\u0010\u000b\u001a\u00020\tH\u0002R\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0018\u0010\u0011R\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\r\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\"\u0010$\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010 \u001a\u0004\b\f\u0010!\"\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lk15;", "", "", "canvasWidth", "canvasHeight", "videoWidth", "videoHeight", "Landroid/widget/ImageView$ScaleType;", "scaleType", "", "f", "g", "a", "F", "d", "()F", "setTranFx", "(F)V", "tranFx", t.l, "e", "setTranFy", "tranFy", "c", "setScaleFx", "scaleFx", "setScaleFy", "scaleFy", "getRatio", "setRatio", "ratio", "", "Z", "()Z", "setRatioX", "(Z)V", "ratioX", "<init>", "()V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
public final class k15 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public float tranFx;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public float tranFy;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public float scaleFx = 1.0f;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public float scaleFy = 1.0f;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public float ratio = 1.0f;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public boolean ratioX;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final boolean getRatioX() {
        return this.ratioX;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final float getScaleFx() {
        return this.scaleFx;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final float getScaleFy() {
        return this.scaleFy;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final float getTranFx() {
        return this.tranFx;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final float getTranFy() {
        return this.tranFy;
    }

    public final void f(float canvasWidth, float canvasHeight, float videoWidth, float videoHeight, ImageView.ScaleType scaleType) {
        if (canvasWidth == 0.0f || canvasHeight == 0.0f || videoWidth == 0.0f || videoHeight == 0.0f) {
            return;
        }
        g();
        float f = (canvasWidth - videoWidth) / 2.0f;
        float f2 = (canvasHeight - videoHeight) / 2.0f;
        float f3 = videoWidth / videoHeight;
        float f4 = canvasWidth / canvasHeight;
        float f5 = canvasHeight / videoHeight;
        float f6 = canvasWidth / videoWidth;
        switch (j15.$EnumSwitchMapping$0[scaleType.ordinal()]) {
            case 1:
                this.tranFx = f;
                this.tranFy = f2;
                break;
            case 2:
                if (f3 <= f4) {
                    this.ratio = f6;
                    this.ratioX = true;
                    this.scaleFx = f6;
                    this.scaleFy = f6;
                    this.tranFy = (canvasHeight - (videoHeight * f6)) / 2.0f;
                } else {
                    this.ratio = f5;
                    this.ratioX = false;
                    this.scaleFx = f5;
                    this.scaleFy = f5;
                    this.tranFx = (canvasWidth - (videoWidth * f5)) / 2.0f;
                }
                break;
            case 3:
                if (videoWidth < canvasWidth && videoHeight < canvasHeight) {
                    this.tranFx = f;
                    this.tranFy = f2;
                } else if (f3 <= f4) {
                    this.ratio = f5;
                    this.ratioX = false;
                    this.scaleFx = f5;
                    this.scaleFy = f5;
                    this.tranFx = (canvasWidth - (videoWidth * f5)) / 2.0f;
                } else {
                    this.ratio = f6;
                    this.ratioX = true;
                    this.scaleFx = f6;
                    this.scaleFy = f6;
                    this.tranFy = (canvasHeight - (videoHeight * f6)) / 2.0f;
                }
                break;
            case 4:
                if (f3 <= f4) {
                    this.ratio = f5;
                    this.ratioX = false;
                    this.scaleFx = f5;
                    this.scaleFy = f5;
                    this.tranFx = (canvasWidth - (videoWidth * f5)) / 2.0f;
                } else {
                    this.ratio = f6;
                    this.ratioX = true;
                    this.scaleFx = f6;
                    this.scaleFy = f6;
                    this.tranFy = (canvasHeight - (videoHeight * f6)) / 2.0f;
                }
                break;
            case 5:
                if (f3 <= f4) {
                    this.ratio = f5;
                    this.ratioX = false;
                    this.scaleFx = f5;
                    this.scaleFy = f5;
                } else {
                    this.ratio = f6;
                    this.ratioX = true;
                    this.scaleFx = f6;
                    this.scaleFy = f6;
                }
                break;
            case 6:
                if (f3 <= f4) {
                    this.ratio = f5;
                    this.ratioX = false;
                    this.scaleFx = f5;
                    this.scaleFy = f5;
                    this.tranFx = canvasWidth - (videoWidth * f5);
                } else {
                    this.ratio = f6;
                    this.ratioX = true;
                    this.scaleFx = f6;
                    this.scaleFy = f6;
                    this.tranFy = canvasHeight - (videoHeight * f6);
                }
                break;
            case 7:
                this.ratio = Math.max(f6, f5);
                this.ratioX = f6 > f5;
                this.scaleFx = f6;
                this.scaleFy = f5;
                break;
            default:
                this.ratio = f6;
                this.ratioX = true;
                this.scaleFx = f6;
                this.scaleFy = f6;
                break;
        }
    }

    public final void g() {
        this.tranFx = 0.0f;
        this.tranFy = 0.0f;
        this.scaleFx = 1.0f;
        this.scaleFy = 1.0f;
        this.ratio = 1.0f;
        this.ratioX = false;
    }
}
