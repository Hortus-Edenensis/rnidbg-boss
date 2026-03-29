package com.zenmen.palmchat.widget.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.photoview.b;
import defpackage.a45;
import defpackage.jj0;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class a implements View.OnTouchListener, b.d, GestureDetector.OnDoubleTapListener, ViewTreeObserver.OnGlobalLayoutListener {
    public GestureDetector.OnDoubleTapListener g;
    public WeakReference<ImageView> i;
    public ViewTreeObserver j;
    public GestureDetector k;
    public com.zenmen.palmchat.widget.photoview.b l;
    public g r;
    public View.OnLongClickListener s;
    public int t;
    public int u;
    public int v;
    public int w;
    public d x;
    public boolean z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f16037a = false;
    public float b = 1.0f;
    public float c = 1.01f;
    public float d = 1.8f;
    public boolean e = true;
    public boolean f = true;
    public float h = 0.0f;
    public final Matrix m = new Matrix();
    public final Matrix n = new Matrix();
    public final Matrix o = new Matrix();
    public final RectF p = new RectF();
    public final float[] q = new float[9];
    public int y = 2;
    public ImageView.ScaleType A = ImageView.ScaleType.FIT_CENTER;
    public float B = 0.0f;

    /* JADX INFO: renamed from: com.zenmen.palmchat.widget.photoview.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C1147a extends GestureDetector.SimpleOnGestureListener {
        public C1147a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (a.this.s != null) {
                a.this.s.onLongClick((View) a.this.i.get());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16039a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f16039a = iArr;
            try {
                iArr[ImageView.ScaleType.MATRIX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16039a[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16039a[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16039a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f16039a[ImageView.ScaleType.FIT_XY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f16040a;
        public final float b;
        public final float c;
        public final float d;
        public float e;

        public c(float f, float f2, float f3, float f4) {
            this.c = f;
            this.d = f2;
            this.f16040a = f3;
            this.b = f4;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView imageViewP = a.this.p();
            if (imageViewP != null) {
                float f = imageViewP.getLayerType() != 1 ? 0.07f : 0.18f;
                if (this.c < this.d) {
                    this.e = f + 1.0f;
                } else {
                    this.e = 1.0f - f;
                }
                Matrix matrix = a.this.o;
                float f2 = this.e;
                matrix.postScale(f2, f2, this.f16040a, this.b);
                a.this.h();
                float fV = a.this.v();
                float f3 = this.e;
                if ((f3 > 1.0f && fV < this.d) || (f3 < 1.0f && this.d < fV)) {
                    jj0.a(imageViewP, this);
                    return;
                }
                float f4 = this.d / fV;
                a.this.o.postScale(f4, f4, this.f16040a, this.b);
                a.this.h();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a45 f16041a;
        public int b;
        public int c;

        public d(Context context) {
            this.f16041a = a45.f(context);
        }

        public void a() {
            LogUtil.d("PhotoViewAttacher", "Cancel Fling");
            this.f16041a.c(true);
        }

        public void b(int i, int i2, int i3, int i4) {
            int i5;
            int iRound;
            int i6;
            int iRound2;
            RectF rectFN = a.this.n();
            if (rectFN == null) {
                return;
            }
            int iRound3 = Math.round(-rectFN.left);
            float f = i;
            if (f < rectFN.width()) {
                iRound = Math.round(rectFN.width() - f);
                i5 = 0;
            } else {
                i5 = iRound3;
                iRound = i5;
            }
            int iRound4 = Math.round(-rectFN.top);
            float f2 = i2;
            if (f2 < rectFN.height()) {
                iRound2 = Math.round(rectFN.height() - f2);
                i6 = 0;
            } else {
                i6 = iRound4;
                iRound2 = i6;
            }
            this.b = iRound3;
            this.c = iRound4;
            LogUtil.d("PhotoViewAttacher", "fling. StartX:" + iRound3 + " StartY:" + iRound4 + " MaxX:" + iRound + " MaxY:" + iRound2);
            if (iRound3 == iRound && iRound4 == iRound2) {
                return;
            }
            this.f16041a.b(iRound3, iRound4, i3, i4, i5, iRound, i6, iRound2, 0, 0);
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView imageViewP = a.this.p();
            if (imageViewP == null || !this.f16041a.a()) {
                return;
            }
            int iD = this.f16041a.d();
            int iE = this.f16041a.e();
            LogUtil.d("PhotoViewAttacher", "fling run(). CurrentX:" + this.b + " CurrentY:" + this.c + " NewX:" + iD + " NewY:" + iE);
            a.this.o.postTranslate((float) (this.b - iD), (float) (this.c - iE));
            a aVar = a.this;
            aVar.F(aVar.m());
            this.b = iD;
            this.c = iE;
            jj0.a(imageViewP, this);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface g {
        void onViewTap(View view, float f, float f2);
    }

    public a(ImageView imageView) {
        this.i = new WeakReference<>(imageView);
        imageView.setOnTouchListener(this);
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        this.j = viewTreeObserver;
        viewTreeObserver.addOnGlobalLayoutListener(this);
        G(imageView);
        if (imageView.isInEditMode()) {
            return;
        }
        this.l = com.zenmen.palmchat.widget.photoview.b.b(imageView.getContext(), this);
        GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new C1147a());
        this.k = gestureDetector;
        gestureDetector.setOnDoubleTapListener(this);
        R(true);
    }

    public static boolean A(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        if (b.f16039a[scaleType.ordinal()] != 1) {
            return true;
        }
        throw new IllegalArgumentException(scaleType.name() + " is not supported in PhotoView");
    }

    public static void G(ImageView imageView) {
        if (imageView == null || (imageView instanceof PhotoView)) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
    }

    public static void k(float f2, float f3, float f4) {
        if (f2 >= f3) {
            throw new IllegalArgumentException("MinZoom should be less than MidZoom");
        }
        if (f3 >= f4) {
            throw new IllegalArgumentException("MidZoom should be less than MaxZoom");
        }
    }

    public static boolean y(ImageView imageView) {
        return (imageView == null || imageView.getDrawable() == null) ? false : true;
    }

    public void B() {
        LogUtil.d("PhotoViewAttacher", "onSizeChanged");
        onGlobalLayout();
    }

    public final void C() {
        this.o.reset();
        F(m());
        j();
    }

    public void D(boolean z) {
        this.e = z;
    }

    public void E(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.g = onDoubleTapListener;
    }

    public final void F(Matrix matrix) {
        ImageView imageViewP = p();
        if (imageViewP != null) {
            i();
            imageViewP.setImageMatrix(matrix);
        }
    }

    public void H(float f2) {
        try {
            k(this.b, this.c, f2);
            this.d = f2;
        } catch (IllegalArgumentException unused) {
        }
    }

    public void I(boolean z) {
        this.f = z;
    }

    public void J(float f2) {
        try {
            k(this.b, f2, this.d);
            this.c = f2;
        } catch (IllegalArgumentException unused) {
        }
    }

    public void K(float f2) {
        try {
            k(f2, this.c, this.d);
            this.b = f2;
        } catch (IllegalArgumentException unused) {
        }
    }

    public final void L(View.OnLongClickListener onLongClickListener) {
        this.s = onLongClickListener;
    }

    public final void O(g gVar) {
        this.r = gVar;
    }

    public void P(float f2) {
        this.h = f2;
    }

    public final void Q(ImageView.ScaleType scaleType) {
        if (!A(scaleType) || scaleType == this.A) {
            return;
        }
        this.A = scaleType;
        S();
    }

    public final void R(boolean z) {
        this.z = z;
        S();
    }

    public final void S() {
        ImageView imageViewP = p();
        if (imageViewP != null) {
            if (!this.z) {
                C();
            } else {
                G(imageViewP);
                T(imageViewP.getDrawable());
            }
        }
    }

    public final void T(Drawable drawable) {
        ImageView imageViewP = p();
        if (imageViewP == null || drawable == null) {
            return;
        }
        float width = imageViewP.getWidth();
        float height = imageViewP.getHeight();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.m.reset();
        float f2 = intrinsicWidth;
        float f3 = width / f2;
        float f4 = intrinsicHeight;
        float f5 = height / f4;
        ImageView.ScaleType scaleType = this.A;
        if (scaleType == ImageView.ScaleType.CENTER) {
            float f6 = this.h;
            if (f6 != 0.0f) {
                this.m.postScale(f6, f6);
                Matrix matrix = this.m;
                float f7 = this.h;
                matrix.postTranslate((width - (f2 * f7)) / 2.0f, (height - (f4 * f7)) / 2.0f);
            } else if (PhotoView.getPhotoViewScaleType(imageViewP, intrinsicWidth, intrinsicHeight) == 0) {
                this.m.postTranslate((width - f2) / 2.0f, 0.0f);
            } else if (PhotoView.getPhotoViewScaleType(imageViewP, intrinsicWidth, intrinsicHeight) == 1) {
                this.m.postTranslate(0.0f, (height - f4) / 2.0f);
            } else {
                this.m.postTranslate((width - f2) / 2.0f, (height - f4) / 2.0f);
            }
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float fMax = Math.max(f3, f5);
            this.m.postScale(fMax, fMax);
            this.m.postTranslate((width - (f2 * fMax)) / 2.0f, 0.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float fMin = Math.min(1.0f, Math.min(f3, f5));
            this.m.postScale(fMin, fMin);
            this.m.postTranslate((width - (f2 * fMin)) / 2.0f, (height - (f4 * fMin)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f2, f4);
            RectF rectF2 = new RectF(0.0f, 0.0f, width, height);
            int i = b.f16039a[this.A.ordinal()];
            if (i == 2) {
                this.m.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
            } else if (i == 3) {
                this.m.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
            } else if (i == 4) {
                this.m.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            } else if (i == 5) {
                this.m.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
            }
        }
        C();
        this.B = v();
    }

    public final void U(float f2, float f3, float f4) {
        ImageView imageViewP = p();
        if (imageViewP != null) {
            imageViewP.post(new c(v(), f2, f3, f4));
        }
    }

    public final boolean f() {
        return this.z;
    }

    public final void g() {
        d dVar = this.x;
        if (dVar != null) {
            dVar.a();
            this.x = null;
        }
    }

    public final void h() {
        j();
        F(m());
    }

    public final void i() {
        ImageView imageViewP = p();
        if (imageViewP != null && !(imageViewP instanceof PhotoView) && imageViewP.getScaleType() != ImageView.ScaleType.MATRIX) {
            throw new IllegalStateException("The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
        }
    }

    public final void j() {
        RectF rectFO;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        ImageView imageViewP = p();
        if (imageViewP == null || (rectFO = o(m())) == null) {
            return;
        }
        float fHeight = rectFO.height();
        float fWidth = rectFO.width();
        float height = imageViewP.getHeight();
        float f8 = 0.0f;
        if (fHeight <= height) {
            int i = b.f16039a[this.A.ordinal()];
            if (i != 2) {
                if (i != 3) {
                    height = (height - fHeight) / 2.0f;
                    f3 = rectFO.top;
                } else {
                    height -= fHeight;
                    f3 = rectFO.top;
                }
            } else {
                f2 = rectFO.top;
                f4 = -f2;
            }
        } else {
            f2 = rectFO.top;
            if (f2 > 0.0f) {
                f4 = -f2;
            } else {
                f3 = rectFO.bottom;
                f4 = f3 < height ? height - f3 : 0.0f;
            }
        }
        float width = imageViewP.getWidth();
        if (fWidth <= width) {
            int i2 = b.f16039a[this.A.ordinal()];
            if (i2 != 2) {
                if (i2 != 3) {
                    f6 = (width - fWidth) / 2.0f;
                    f7 = rectFO.left;
                } else {
                    f6 = width - fWidth;
                    f7 = rectFO.left;
                }
                f5 = f6 - f7;
            } else {
                f5 = -rectFO.left;
            }
            f8 = f5;
            this.y = 2;
        } else {
            float f9 = rectFO.left;
            if (f9 > 0.0f) {
                this.y = 0;
                f8 = -f9;
            } else {
                float f10 = rectFO.right;
                if (f10 < width) {
                    f8 = width - f10;
                    this.y = 1;
                } else {
                    this.y = -1;
                }
            }
        }
        this.o.postTranslate(f8, f4);
    }

    public final void l() {
        ViewTreeObserver viewTreeObserver;
        WeakReference<ImageView> weakReference = this.i;
        if (weakReference != null && weakReference.get() != null && (viewTreeObserver = this.i.get().getViewTreeObserver()) != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this);
        }
        this.j = null;
        this.r = null;
        this.i = null;
    }

    public Matrix m() {
        this.n.set(this.m);
        this.n.postConcat(this.o);
        return this.n;
    }

    public final RectF n() {
        j();
        return o(m());
    }

    public final RectF o(Matrix matrix) {
        Drawable drawable;
        ImageView imageViewP = p();
        if (imageViewP == null || (drawable = imageViewP.getDrawable()) == null) {
            return null;
        }
        this.p.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        matrix.mapRect(this.p);
        return this.p;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0028 A[Catch: ArrayIndexOutOfBoundsException -> 0x002b, TRY_LEAVE, TryCatch #0 {ArrayIndexOutOfBoundsException -> 0x002b, blocks: (B:7:0x000c, B:9:0x001e, B:11:0x0024, B:12:0x0028), top: B:15:0x000c }] */
    @Override // android.view.GestureDetector.OnDoubleTapListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onDoubleTap(MotionEvent motionEvent) {
        GestureDetector.OnDoubleTapListener onDoubleTapListener = this.g;
        if (onDoubleTapListener != null && onDoubleTapListener.onDoubleTap(motionEvent)) {
            return true;
        }
        try {
            float fV = v();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            float f2 = this.b;
            if (fV >= f2) {
                float f3 = this.d;
                if (fV < f3) {
                    U(f3, x, y);
                } else {
                    U(f2, x, y);
                }
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.zenmen.palmchat.widget.photoview.b.d
    public final void onDrag(float f2, float f3) {
        LogUtil.d("PhotoViewAttacher", String.format("onDrag: dx: %.2f. dy: %.2f", Float.valueOf(f2), Float.valueOf(f3)));
        ImageView imageViewP = p();
        if (imageViewP == null || !y(imageViewP)) {
            return;
        }
        this.o.postTranslate(f2, f3);
        h();
        if (!this.e || this.l.a()) {
            return;
        }
        int i = this.y;
        if (i == 2 || ((i == 0 && f2 >= 1.0f) || (i == 1 && f2 <= -1.0f))) {
            imageViewP.getParent().requestDisallowInterceptTouchEvent(false);
        }
    }

    @Override // com.zenmen.palmchat.widget.photoview.b.d
    public final void onFling(float f2, float f3, float f4, float f5) {
        LogUtil.d("PhotoViewAttacher", "onFling. sX: " + f2 + " sY: " + f3 + " Vx: " + f4 + " Vy: " + f5);
        ImageView imageViewP = p();
        if (y(imageViewP)) {
            d dVar = new d(imageViewP.getContext());
            this.x = dVar;
            dVar.b(imageViewP.getWidth(), imageViewP.getHeight(), (int) f4, (int) f5);
            imageViewP.post(this.x);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        ImageView imageViewP = p();
        if (imageViewP == null || !this.z) {
            return;
        }
        int top = imageViewP.getTop();
        int right = imageViewP.getRight();
        int bottom = imageViewP.getBottom();
        int left = imageViewP.getLeft();
        if (top == this.t && bottom == this.v && left == this.w && right == this.u) {
            return;
        }
        T(imageViewP.getDrawable());
        this.t = top;
        this.u = right;
        this.v = bottom;
        this.w = left;
    }

    @Override // com.zenmen.palmchat.widget.photoview.b.d
    public final void onScale(float f2, float f3, float f4) {
        LogUtil.d("PhotoViewAttacher", String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)));
        if (y(p())) {
            if (v() < s() || f2 < 1.0f) {
                this.o.postScale(f2, f2, f3, f4);
                h();
            }
        }
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        ImageView imageViewP = p();
        if (imageViewP == null) {
            return false;
        }
        g gVar = this.r;
        if (gVar != null) {
            gVar.onViewTap(imageViewP, motionEvent.getX(), motionEvent.getY());
        }
        GestureDetector.OnDoubleTapListener onDoubleTapListener = this.g;
        if (onDoubleTapListener == null) {
            return false;
        }
        onDoubleTapListener.onSingleTapConfirmed(motionEvent);
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        RectF rectFN;
        boolean z = false;
        if (!this.z) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            g();
        } else if (action == 1 || action == 3) {
            if (v() < this.b) {
                RectF rectFN2 = n();
                if (rectFN2 != null) {
                    view.post(new c(v(), this.b, rectFN2.centerX(), rectFN2.centerY()));
                    z = true;
                }
            } else if (v() > r() && this.f && (rectFN = n()) != null) {
                float fR = r() / v();
                this.o.postScale(fR, fR, rectFN.centerX(), rectFN.centerY());
                h();
                z = true;
            }
        }
        GestureDetector gestureDetector = this.k;
        if (gestureDetector != null && gestureDetector.onTouchEvent(motionEvent)) {
            z = true;
        }
        com.zenmen.palmchat.widget.photoview.b bVar = this.l;
        if (bVar == null || !bVar.c(motionEvent)) {
            return z;
        }
        return true;
    }

    public final ImageView p() {
        WeakReference<ImageView> weakReference = this.i;
        ImageView imageView = weakReference != null ? weakReference.get() : null;
        if (imageView == null) {
            l();
        }
        return imageView;
    }

    public float q() {
        return this.d;
    }

    public final float r() {
        return this.d * 1.6f;
    }

    public final float s() {
        return this.f ? r() * 5.0f : this.d;
    }

    public float t() {
        return this.c;
    }

    public float u() {
        return this.b;
    }

    public final float v() {
        return x(this.o, 0);
    }

    public final ImageView.ScaleType w() {
        return this.A;
    }

    public final float x(Matrix matrix, int i) {
        matrix.getValues(this.q);
        return this.q[i];
    }

    public boolean z() {
        return v() != this.B;
    }

    public final void M(e eVar) {
    }

    public final void N(f fVar) {
    }
}
