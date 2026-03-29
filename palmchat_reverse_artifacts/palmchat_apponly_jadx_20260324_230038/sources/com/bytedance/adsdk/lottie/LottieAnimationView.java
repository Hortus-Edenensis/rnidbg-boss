package com.bytedance.adsdk.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.baidu.mapapi.map.WeightedLatLng;
import com.bytedance.adsdk.lottie.iz;
import com.bytedance.component.sdk.annotation.FloatRange;
import com.bytedance.component.sdk.annotation.MainThread;
import com.bytedance.component.sdk.annotation.RawRes;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class LottieAnimationView extends ImageView {
    private static final jk<Throwable> nr = new jk<Throwable>() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.1
        @Override // com.bytedance.adsdk.lottie.jk
        public void u(Throwable th) {
            if (com.bytedance.adsdk.lottie.pn.a.u(th)) {
                com.bytedance.adsdk.lottie.pn.pn.u("Unable to load composition.", th);
            } else {
                com.bytedance.adsdk.lottie.pn.pn.u("Unable to parse composition:", th);
            }
        }
    };
    private static final String u = "LottieAnimationView";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @RawRes
    private int f4978a;
    private final jk<Throwable> b;
    private int bf;
    private int bg;
    private Handler bq;
    private volatile int c;
    private int d;
    private long dw;
    private final jk<iz> fx;
    private int gi;
    private int h;
    private int iz;
    private JSONArray ja;
    private boolean jk;
    private mv<iz> k;
    private List<com.bytedance.adsdk.lottie.model.layer.iz> kj;
    private boolean l;
    private final Set<b> mv;
    private iz my;
    private String n;
    private final Handler o;
    private nr pb;
    private jk<Throwable> pn;
    private final Runnable q;
    private com.bytedance.adsdk.lottie.model.layer.iz qq;
    private String rh;
    private final Set<Object> s;
    private final Handler sx;
    private boolean t;
    private final Runnable wq;
    private final n x;
    private u xg;
    private int z;

    /* JADX INFO: renamed from: com.bytedance.adsdk.lottie.LottieAnimationView$6, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] u;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            u = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                u[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                u[ImageView.ScaleType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                u[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum b {
        SET_ANIMATION,
        SET_PROGRESS,
        SET_REPEAT_MODE,
        SET_REPEAT_COUNT,
        SET_IMAGE_ASSETS,
        PLAY_OPTION
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class fx extends View.BaseSavedState {
        public static final Parcelable.Creator<fx> CREATOR = new Parcelable.Creator<fx>() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.fx.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public fx createFromParcel(Parcel parcel) {
                return new fx(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public fx[] newArray(int i) {
                return new fx[i];
            }
        };
        boolean b;
        float fx;
        int iz;
        int nr;
        String pn;
        String u;
        int x;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.u);
            parcel.writeFloat(this.fx);
            parcel.writeInt(this.b ? 1 : 0);
            parcel.writeString(this.pn);
            parcel.writeInt(this.iz);
            parcel.writeInt(this.x);
        }

        public fx(Parcelable parcelable) {
            super(parcelable);
        }

        private fx(Parcel parcel) {
            super(parcel);
            this.u = parcel.readString();
            this.fx = parcel.readFloat();
            this.b = parcel.readInt() == 1;
            this.pn = parcel.readString();
            this.iz = parcel.readInt();
            this.x = parcel.readInt();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface nr {
        void u(String str, JSONArray jSONArray);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void nr(Map<String, Object> map);

        void u(Map<String, Object> map);
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.fx = new jk<iz>() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.7
            @Override // com.bytedance.adsdk.lottie.jk
            public void u(iz izVar) {
                LottieAnimationView.this.setComposition(izVar);
            }
        };
        this.b = new jk<Throwable>() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.8
            @Override // com.bytedance.adsdk.lottie.jk
            public void u(Throwable th) {
                if (LottieAnimationView.this.iz != 0) {
                    LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                    lottieAnimationView.setImageResource(lottieAnimationView.iz);
                }
                (LottieAnimationView.this.pn == null ? LottieAnimationView.nr : LottieAnimationView.this.pn).u(th);
            }
        };
        this.iz = 0;
        this.x = new n(this);
        this.jk = false;
        this.t = false;
        this.l = true;
        this.mv = new HashSet();
        this.s = new HashSet();
        this.o = new Handler(Looper.getMainLooper());
        this.sx = new Handler(Looper.getMainLooper());
        this.bg = 0;
        this.dw = 0L;
        this.c = 0;
        this.q = new Runnable() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.4
            @Override // java.lang.Runnable
            public void run() {
                LottieAnimationView.this.my();
                if (LottieAnimationView.this.c == 0) {
                    return;
                }
                if (LottieAnimationView.this.isShown()) {
                    if (LottieAnimationView.this.c == 1) {
                        LottieAnimationView.this.c = 2;
                        LottieAnimationView.this.sx();
                        return;
                    }
                    return;
                }
                if (LottieAnimationView.this.c == 2) {
                    LottieAnimationView.this.c = 1;
                    LottieAnimationView.this.bg();
                }
            }
        };
        this.wq = new Runnable() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.5
            @Override // java.lang.Runnable
            public void run() {
                int unused = LottieAnimationView.this.z;
                int unused2 = LottieAnimationView.this.gi;
                if (LottieAnimationView.this.z > LottieAnimationView.this.gi) {
                    LottieAnimationView.dw(LottieAnimationView.this);
                    LottieAnimationView.this.bq();
                    LottieAnimationView.this.invalidate();
                    LottieAnimationView.this.sx();
                    return;
                }
                LottieAnimationView.this.c = 0;
                LottieAnimationView.this.o();
                if (LottieAnimationView.this.d < 0 || LottieAnimationView.this.h < 0) {
                    int unused3 = LottieAnimationView.this.d;
                    int unused4 = LottieAnimationView.this.h;
                } else {
                    int unused5 = LottieAnimationView.this.d;
                    LottieAnimationView.this.nr();
                    LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                    lottieAnimationView.setFrame(lottieAnimationView.d);
                    LottieAnimationView.this.u(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.5.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            if (LottieAnimationView.this.getFrame() < LottieAnimationView.this.h - 1 || LottieAnimationView.this.getFrame() >= LottieAnimationView.this.h + 2) {
                                return;
                            }
                            int unused6 = LottieAnimationView.this.h;
                            LottieAnimationView.this.nr(this);
                            LottieAnimationView.this.x();
                        }
                    });
                }
                if ((!TextUtils.isEmpty(LottieAnimationView.this.rh) || (LottieAnimationView.this.ja != null && LottieAnimationView.this.ja.length() > 0)) && LottieAnimationView.this.pb != null) {
                    LottieAnimationView.this.pb.u(LottieAnimationView.this.rh, LottieAnimationView.this.ja);
                }
            }
        };
        a();
    }

    public static /* synthetic */ int dw(LottieAnimationView lottieAnimationView) {
        int i = lottieAnimationView.z;
        lottieAnimationView.z = i - 1;
        return i;
    }

    private iz.u getArea() {
        iz izVarGi;
        n nVar = this.x;
        if (nVar == null || (izVarGi = nVar.gi()) == null) {
            return null;
        }
        return izVarGi.jk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public iz.nr getGlobalConfig() {
        iz izVarGi;
        n nVar = this.x;
        if (nVar == null || (izVarGi = nVar.gi()) == null) {
            return null;
        }
        return izVarGi.l();
    }

    private iz.fx getGlobalEvent() {
        iz izVarGi;
        n nVar = this.x;
        if (nVar == null || (izVarGi = nVar.gi()) == null) {
            return null;
        }
        return izVarGi.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPlayDelayedELExpressTimeS() {
        iz izVarGi;
        n nVar = this.x;
        if (nVar == null || (izVarGi = nVar.gi()) == null) {
            return null;
        }
        return izVarGi.a();
    }

    public static /* synthetic */ int pn(LottieAnimationView lottieAnimationView) {
        int i = lottieAnimationView.bg;
        lottieAnimationView.bg = i + 1;
        return i;
    }

    private void setCompositionTask(mv<iz> mvVar) {
        this.mv.add(b.SET_ANIMATION);
        dw();
        s();
        this.k = mvVar.u(this.fx).fx(this.b);
    }

    public boolean getClipToCompositionBounds() {
        return this.x.b();
    }

    public iz getComposition() {
        return this.my;
    }

    public long getDuration() {
        iz izVar = this.my;
        if (izVar != null) {
            return (long) izVar.pn();
        }
        return 0L;
    }

    public int getFrame() {
        return this.x.bq();
    }

    public String getImageAssetsFolder() {
        return this.x.pn();
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.x.iz();
    }

    public float getMaxFrame() {
        return this.x.my();
    }

    public float getMinFrame() {
        return this.x.k();
    }

    public sx getPerformanceTracker() {
        return this.x.a();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.x.rh();
    }

    public bg getRenderMode() {
        return this.x.x();
    }

    public int getRepeatCount() {
        return this.x.c();
    }

    public int getRepeatMode() {
        return this.x.dw();
    }

    public float getSpeed() {
        return this.x.o();
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        Drawable drawable = getDrawable();
        if ((drawable instanceof n) && ((n) drawable).x() == bg.SOFTWARE) {
            this.x.invalidateSelf();
        }
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        n nVar = this.x;
        if (drawable2 == nVar) {
            super.invalidateDrawable(nVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode() || !this.t) {
            return;
        }
        this.x.l();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bg();
        o();
        Handler handler = this.bq;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        b();
        fx();
        iz();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        int i;
        if (!(parcelable instanceof fx)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        fx fxVar = (fx) parcelable;
        super.onRestoreInstanceState(fxVar.getSuperState());
        this.n = fxVar.u;
        Set<b> set = this.mv;
        b bVar = b.SET_ANIMATION;
        if (!set.contains(bVar) && !TextUtils.isEmpty(this.n)) {
            setAnimation(this.n);
        }
        this.f4978a = fxVar.nr;
        if (!this.mv.contains(bVar) && (i = this.f4978a) != 0) {
            setAnimation(i);
        }
        if (!this.mv.contains(b.SET_PROGRESS)) {
            u(fxVar.fx, false);
        }
        if (!this.mv.contains(b.PLAY_OPTION) && fxVar.b) {
            u();
        }
        if (!this.mv.contains(b.SET_IMAGE_ASSETS)) {
            setImageAssetsFolder(fxVar.pn);
        }
        if (!this.mv.contains(b.SET_REPEAT_MODE)) {
            setRepeatMode(fxVar.iz);
        }
        if (this.mv.contains(b.SET_REPEAT_COUNT)) {
            return;
        }
        setRepeatCount(fxVar.x);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        fx fxVar = new fx(super.onSaveInstanceState());
        fxVar.u = this.n;
        fxVar.nr = this.f4978a;
        fxVar.fx = this.x.rh();
        fxVar.b = this.x.qq();
        fxVar.pn = this.x.pn();
        fxVar.iz = this.x.dw();
        fxVar.x = this.x.c();
        return fxVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
    
        if (r3 <= (r2 + r0.n)) goto L17;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int[][] iArr;
        iz.u area = getArea();
        if (area != null) {
            if (area.pn == -1.0f) {
                u(area);
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            float f = area.pn;
            if (x >= f && x <= f + area.x) {
                float f2 = area.iz;
                if (y >= f2) {
                }
            }
            getWidth();
            getHeight();
            return false;
        }
        com.bytedance.adsdk.lottie.model.layer.fx fxVarU = u(motionEvent);
        if (fxVarU == null) {
            if (getGlobalConfig() == null || getGlobalConfig().u != 1) {
                return super.onTouchEvent(motionEvent);
            }
            return false;
        }
        String strT = fxVarU.t();
        if (fxVarU instanceof com.bytedance.adsdk.lottie.model.layer.b) {
            if (getGlobalConfig() == null || getGlobalConfig().u != 1) {
                return super.onTouchEvent(motionEvent);
            }
            return false;
        }
        if (strT != null && strT.startsWith("CSJCLOSE")) {
            bg();
        }
        a aVarU = u(fxVarU.x());
        if (aVarU != null && motionEvent.getAction() == 1) {
            u(strT, aVarU.x(), aVarU.a());
            int[][] iArrN = aVarU.n();
            if (iArrN != null) {
                u(iArrN);
            } else if (getGlobalEvent() != null && (iArr = getGlobalEvent().nr) != null) {
                u(iArr);
            }
        }
        if (strT != null && strT.startsWith("CSJNTP")) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setAnimation(@RawRes int i) {
        this.f4978a = i;
        this.n = null;
        setCompositionTask(u(i));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        u(str, (String) null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.l ? x.u(getContext(), str) : x.u(getContext(), str, (String) null));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.x.pn(z);
    }

    public void setCacheComposition(boolean z) {
        this.l = z;
    }

    public void setClipToCompositionBounds(boolean z) {
        this.x.u(z);
    }

    public void setComposition(iz izVar) {
        boolean z = pn.u;
        this.x.setCallback(this);
        this.my = izVar;
        this.jk = true;
        boolean zU = this.x.u(izVar, getContext().getApplicationContext());
        this.jk = false;
        if (getDrawable() != this.x || zU) {
            if (!zU) {
                c();
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator<Object> it = this.s.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public void setDefaultFontFileExtension(String str) {
        this.x.x(str);
    }

    public void setFailureListener(jk<Throwable> jkVar) {
        this.pn = jkVar;
    }

    public void setFallbackResource(int i) {
        this.iz = i;
    }

    public void setFontAssetDelegate(com.bytedance.adsdk.lottie.fx fxVar) {
        this.x.u(fxVar);
    }

    public void setFontMap(Map<String, Typeface> map) {
        this.x.u(map);
    }

    public void setFrame(int i) {
        this.x.fx(i);
    }

    public void setIgnoreDisabledSystemAnimations(boolean z) {
        this.x.x(z);
    }

    public void setImageAssetDelegate(com.bytedance.adsdk.lottie.b bVar) {
        this.x.u(bVar);
    }

    public void setImageAssetsFolder(String str) {
        this.x.u(str);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        s();
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        s();
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        s();
        super.setImageResource(i);
    }

    public void setLottieAnimListener(u uVar) {
        this.xg = uVar;
    }

    public void setLottieClicklistener(nr nrVar) {
        this.pb = nrVar;
    }

    public void setMaintainOriginalImageBounds(boolean z) {
        this.x.nr(z);
    }

    public void setMaxFrame(int i) {
        this.x.nr(i);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY) float f) {
        this.x.nr(f);
    }

    public void setMinAndMaxFrame(String str) {
        this.x.b(str);
    }

    public void setMinFrame(int i) {
        this.x.u(i);
    }

    public void setMinProgress(float f) {
        this.x.u(f);
    }

    public void setOutlineMasksAndMattes(boolean z) {
        this.x.b(z);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.x.fx(z);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY) float f) {
        u(f, true);
    }

    public void setRenderMode(bg bgVar) {
        this.x.u(bgVar);
    }

    public void setRepeatCount(int i) {
        this.mv.add(b.SET_REPEAT_COUNT);
        this.x.pn(i);
    }

    public void setRepeatMode(int i) {
        this.mv.add(b.SET_REPEAT_MODE);
        this.x.b(i);
    }

    public void setSafeMode(boolean z) {
        this.x.iz(z);
    }

    public void setSpeed(float f) {
        this.x.fx(f);
    }

    public void setTextDelegate(bq bqVar) {
        this.x.u(bqVar);
    }

    public void setUseCompositionFrameRate(boolean z) {
        this.x.n(z);
    }

    public void setViewDelegate(dw dwVar) {
        this.x.u(dwVar);
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        n nVar;
        if (!this.jk && drawable == (nVar = this.x) && nVar.q()) {
            x();
        } else if (!this.jk && (drawable instanceof n)) {
            n nVar2 = (n) drawable;
            if (nVar2.q()) {
                nVar2.h();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    private void a() {
        setSaveEnabled(false);
        this.l = true;
        setFallbackResource(0);
        setImageAssetsFolder("");
        u(0.0f, false);
        u(false, getContext().getApplicationContext());
        setIgnoreDisabledSystemAnimations(false);
        this.x.u(Boolean.valueOf(com.bytedance.adsdk.lottie.pn.a.u(getContext()) != 0.0f));
        jk();
        t();
        mv();
    }

    private void b(Matrix matrix, float f, float f2, float f3, float f4) {
        if (f3 >= f || f4 >= f2) {
            if (f3 / f4 >= f / f2) {
                float f5 = f / f3;
                matrix.preScale(f5, f5);
                matrix.postTranslate(0.0f, (f2 - (f4 * f5)) / 2.0f);
                return;
            } else {
                float f6 = f2 / f4;
                matrix.preScale(f6, f6);
                matrix.postTranslate((f - (f3 * f6)) / 2.0f, 0.0f);
                return;
            }
        }
        if (f3 / f4 >= f / f2) {
            float f7 = f / f3;
            matrix.preScale(f7, f7);
            matrix.postTranslate(0.0f, (f2 - (f4 * f7)) / 2.0f);
        } else {
            float f8 = f2 / f4;
            matrix.preScale(f8, f8);
            matrix.postTranslate((f - (f3 * f8)) / 2.0f, 0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bg() {
        this.o.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bq() {
        String[] strArrSplit;
        if (this.kj == null) {
            com.bytedance.adsdk.lottie.model.layer.iz izVar = this.qq;
            if (izVar != null) {
                if (this.bf == 1) {
                    izVar.u(nr(this.z));
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(this.z);
                izVar.u(sb.toString());
                return;
            }
            return;
        }
        String strNr = nr(this.z);
        if (TextUtils.isEmpty(strNr) || (strArrSplit = strNr.split(":")) == null || strArrSplit.length != 3) {
            return;
        }
        for (int i = 0; i < 3; i++) {
            com.bytedance.adsdk.lottie.model.layer.iz izVar2 = this.kj.get(i);
            if (izVar2 != null) {
                izVar2.u(strArrSplit[i]);
            }
        }
    }

    private void c() {
        boolean zPn = pn();
        setImageDrawable(null);
        setImageDrawable(this.x);
        if (zPn) {
            this.x.s();
        }
    }

    private void dw() {
        this.my = null;
        this.x.t();
    }

    private void fx(Matrix matrix, float f, float f2, float f3, float f4) {
        matrix.postTranslate((f - f3) / 2.0f, (f2 - f4) / 2.0f);
    }

    private void jk() {
        u(new Animator.AnimatorListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.9
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LottieAnimationView.this.nr(this);
                LottieAnimationView.this.k();
                LottieAnimationView.this.l();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        n nVar;
        final int i;
        int i2;
        int i3;
        int i4;
        final int i5;
        int i6;
        com.bytedance.adsdk.lottie.model.layer.iz izVarFx;
        if (this.my == null || (nVar = this.x) == null) {
            return;
        }
        bq bqVarKj = nVar.kj();
        final iz.b bVarN = this.my.n();
        if (bVarN == null || bqVarKj == null || (i = bVarN.u) < 0) {
            return;
        }
        int[] iArr = bVarN.pn;
        if (iArr == null || iArr.length < 2) {
            i2 = -1;
            i3 = -1;
        } else {
            i3 = iArr[0];
            i2 = iArr[1];
        }
        String strU = bqVarKj.u(bVarN.fx);
        String strU2 = bqVarKj.u(bVarN.b);
        try {
            i4 = Integer.parseInt(strU);
        } catch (NumberFormatException unused) {
            i4 = -1;
        }
        try {
            i6 = Integer.parseInt(strU2);
            i5 = i4;
        } catch (NumberFormatException unused2) {
            i5 = i4;
            i6 = -1;
        }
        if (bVarN.f4982a == 2 && bVarN.jk != null) {
            this.kj = new ArrayList(3);
            for (String str : bVarN.jk) {
                if (!TextUtils.isEmpty(str) && (izVarFx = fx(str)) != null) {
                    this.kj.add(izVarFx);
                }
            }
            if (this.kj.size() != 3) {
                this.kj.size();
                return;
            }
        }
        if (!TextUtils.isEmpty(bVarN.nr)) {
            this.qq = fx(bVarN.nr);
        }
        if (this.kj == null && this.qq == null) {
            return;
        }
        this.bf = bVarN.f4982a;
        this.rh = bVarN.iz;
        this.ja = bVarN.x;
        this.z = i5;
        this.gi = i5 - i6;
        this.d = i3;
        this.h = i2;
        bq();
        final int i7 = i6;
        u(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (LottieAnimationView.this.getFrame() < i - 1 || LottieAnimationView.this.getFrame() >= i + 2) {
                    return;
                }
                LottieAnimationView.this.getFrame();
                LottieAnimationView.this.nr(this);
                if (i5 >= 0 && i7 >= 0) {
                    LottieAnimationView.this.c = 2;
                    if (bVarN.n == 1) {
                        LottieAnimationView.this.my();
                    }
                    LottieAnimationView.this.sx();
                }
                LottieAnimationView.this.x();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        final iz.nr globalConfig = getGlobalConfig();
        if (globalConfig == null || globalConfig.pn <= 0) {
            return;
        }
        if (TextUtils.isEmpty(globalConfig.iz) && globalConfig.x == null) {
            return;
        }
        int maxFrame = globalConfig.pn;
        if (maxFrame > getMaxFrame()) {
            maxFrame = (int) getMaxFrame();
        }
        final float maxFrame2 = maxFrame / getMaxFrame();
        u(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (!(animatedValue instanceof Float) || ((Float) animatedValue).floatValue() < maxFrame2) {
                    return;
                }
                LottieAnimationView.this.nr(this);
                if (LottieAnimationView.this.pb != null) {
                    nr nrVar = LottieAnimationView.this.pb;
                    iz.nr nrVar2 = globalConfig;
                    nrVar.u(nrVar2.iz, nrVar2.x);
                }
            }
        });
    }

    private void mv() {
        u(new Animator.AnimatorListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                bq bqVarKj;
                final long jElapsedRealtime = SystemClock.elapsedRealtime() - LottieAnimationView.this.dw;
                LottieAnimationView.this.nr(this);
                String playDelayedELExpressTimeS = LottieAnimationView.this.getPlayDelayedELExpressTimeS();
                if (!TextUtils.isEmpty(playDelayedELExpressTimeS) && (bqVarKj = LottieAnimationView.this.x.kj()) != null) {
                    try {
                        int i = Integer.parseInt(bqVarKj.u(playDelayedELExpressTimeS)) * 1000;
                        if (LottieAnimationView.this.dw > 0) {
                            long jElapsedRealtime2 = (LottieAnimationView.this.dw + ((long) i)) - SystemClock.elapsedRealtime();
                            if (jElapsedRealtime2 > 0) {
                                LottieAnimationView.this.x();
                                LottieAnimationView.this.setVisibility(8);
                                if (LottieAnimationView.this.bq == null) {
                                    LottieAnimationView.this.bq = new Handler(Looper.getMainLooper());
                                }
                                LottieAnimationView.this.bq.removeCallbacksAndMessages(null);
                                LottieAnimationView.this.bq.postDelayed(new Runnable() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.12.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        LottieAnimationView.this.setVisibility(0);
                                        LottieAnimationView.this.u();
                                        LottieAnimationView.this.u(jElapsedRealtime);
                                    }
                                }, jElapsedRealtime2);
                                return;
                            }
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
                LottieAnimationView.this.u(jElapsedRealtime);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void my() {
        o();
        this.sx.postDelayed(this.q, 500L);
    }

    private void nr(RectF rectF, RectF rectF2) {
        float width = getWidth();
        float height = getHeight();
        float fWidth = this.x.getBounds().width();
        float fHeight = this.x.getBounds().height();
        if (width == 0.0f || height == 0.0f || fWidth == 0.0f || fHeight == 0.0f) {
            return;
        }
        Matrix matrix = new Matrix();
        int i = AnonymousClass6.u[getScaleType().ordinal()];
        if (i == 1) {
            u(matrix, width, height, fWidth, fHeight);
        } else if (i == 2) {
            nr(matrix, width, height, fWidth, fHeight);
        } else if (i == 3) {
            fx(matrix, width, height, fWidth, fHeight);
        } else if (i == 4) {
            b(matrix, width, height, fWidth, fHeight);
        }
        matrix.mapRect(rectF, rectF2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.sx.removeCallbacksAndMessages(null);
    }

    private void s() {
        mv<iz> mvVar = this.k;
        if (mvVar != null) {
            mvVar.nr(this.fx);
            this.k.b(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sx() {
        bg();
        this.o.postDelayed(this.wq, 1000L);
    }

    private void t() {
        u(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Map<String, Object> map;
                int i;
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (!(animatedValue instanceof Float) || ((Float) animatedValue).floatValue() < 0.98f) {
                    return;
                }
                LottieAnimationView.pn(LottieAnimationView.this);
                iz.nr globalConfig = LottieAnimationView.this.getGlobalConfig();
                if (globalConfig != null && (i = globalConfig.b) > 0 && i > LottieAnimationView.this.bg) {
                    LottieAnimationView.this.k();
                    LottieAnimationView.this.u();
                    LottieAnimationView.this.setProgress(0.0f);
                    return;
                }
                LottieAnimationView.this.nr(this);
                if (LottieAnimationView.this.xg != null) {
                    if (globalConfig == null || (map = globalConfig.fx) == null) {
                        map = null;
                    }
                    LottieAnimationView.this.xg.nr(map);
                }
            }
        });
    }

    @MainThread
    public void iz() {
        this.mv.add(b.PLAY_OPTION);
        this.x.d();
    }

    public boolean pn() {
        return this.x.q();
    }

    public void setMaxFrame(String str) {
        this.x.fx(str);
    }

    public void setMinFrame(String str) {
        this.x.nr(str);
    }

    @MainThread
    public void x() {
        this.t = false;
        this.x.h();
    }

    private com.bytedance.adsdk.lottie.model.layer.iz fx(String str) {
        com.bytedance.adsdk.lottie.model.layer.b bVarFx;
        n nVar = this.x;
        if (nVar == null || (bVarFx = nVar.fx()) == null) {
            return null;
        }
        return u(bVarFx, str);
    }

    public void setAnimation(String str) {
        this.n = str;
        this.f4978a = 0;
        setCompositionTask(nr(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(long j) {
        Map<String, Object> map;
        iz.nr globalConfig = getGlobalConfig();
        if (this.xg != null) {
            HashMap map2 = new HashMap();
            map2.put("duration", Long.valueOf(j));
            if (globalConfig != null && (map = globalConfig.nr) != null && !map.isEmpty()) {
                map2.putAll(globalConfig.nr);
            }
            this.xg.u(map2);
        }
    }

    public void fx() {
        this.x.sx();
    }

    public void b() {
        this.x.bg();
    }

    private a u(String str) {
        n nVar;
        iz izVarGi;
        Map<String, a> mapO;
        if (TextUtils.isEmpty(str) || (nVar = this.x) == null || (izVarGi = nVar.gi()) == null || (mapO = izVarGi.o()) == null) {
            return null;
        }
        return mapO.get(str);
    }

    private void nr(Matrix matrix, float f, float f2, float f3, float f4) {
        if (f3 < f && f4 < f2) {
            matrix.postTranslate((f - f3) / 2.0f, (f2 - f4) / 2.0f);
            return;
        }
        if (f3 / f4 >= f / f2) {
            float f5 = f / f3;
            matrix.preScale(f5, f5);
            matrix.postTranslate(0.0f, (f2 - (f4 * f5)) / 2.0f);
        } else {
            float f6 = f2 / f4;
            matrix.preScale(f6, f6);
            matrix.postTranslate((f - (f3 * f6)) / 2.0f, 0.0f);
        }
    }

    private void u(int[][] iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        try {
            int[] iArr2 = iArr[0];
            int i = iArr2[0];
            final int i2 = iArr2[1];
            if (i < 0 || i2 < 0) {
                return;
            }
            bg();
            u();
            setFrame(i);
            u(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.13
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (LottieAnimationView.this.getFrame() < i2 - 1 || LottieAnimationView.this.getFrame() >= i2 + 2) {
                        return;
                    }
                    LottieAnimationView.this.getFrame();
                    LottieAnimationView.this.nr(this);
                    LottieAnimationView.this.x();
                }
            });
        } catch (Throwable unused) {
        }
    }

    private mv<iz> nr(final String str) {
        if (isInEditMode()) {
            return new mv<>(new Callable<l<iz>>() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public l<iz> call() throws Exception {
                    return LottieAnimationView.this.l ? x.fx(LottieAnimationView.this.getContext(), str) : x.fx(LottieAnimationView.this.getContext(), str, null);
                }
            }, true);
        }
        return this.l ? x.nr(getContext(), str) : x.nr(getContext(), str, (String) null);
    }

    private String nr(int i) {
        int i2 = i / 3600;
        int i3 = i % 3600;
        int i4 = i3 / 60;
        int i5 = i3 % 60;
        StringBuilder sb = new StringBuilder();
        if (i2 < 10) {
            sb.append("0");
        }
        sb.append(i2);
        sb.append(":");
        if (i4 < 10) {
            sb.append("0");
        }
        sb.append(i4);
        sb.append(":");
        if (i5 < 10) {
            sb.append("0");
        }
        sb.append(i5);
        return sb.toString();
    }

    private void u(String str, String str2, JSONArray jSONArray) {
        nr nrVar;
        iz.fx globalEvent = getGlobalEvent();
        if (globalEvent != null && str != null) {
            if (TextUtils.isEmpty(str2) && !str.contains("CSJNO")) {
                str2 = globalEvent.u;
            }
            if ((jSONArray == null || jSONArray.length() <= 0) && !str.contains("CSJLELNO")) {
                jSONArray = globalEvent.fx;
            }
        }
        if ((!TextUtils.isEmpty(str2) || (jSONArray != null && jSONArray.length() > 0)) && (nrVar = this.pb) != null) {
            nrVar.u(str2, jSONArray);
        }
    }

    private void u(iz.u uVar) {
        uVar.pn = com.bytedance.adsdk.lottie.pn.a.u("x", uVar.u, getWidth());
        uVar.iz = com.bytedance.adsdk.lottie.pn.a.u("y", uVar.nr, getHeight());
        uVar.x = com.bytedance.adsdk.lottie.pn.a.u((String) null, uVar.fx, getWidth());
        uVar.n = com.bytedance.adsdk.lottie.pn.a.u((String) null, uVar.b, getHeight());
    }

    @MainThread
    public void nr() {
        this.mv.add(b.PLAY_OPTION);
        this.x.s();
    }

    private com.bytedance.adsdk.lottie.model.layer.fx u(MotionEvent motionEvent) {
        com.bytedance.adsdk.lottie.model.layer.b bVarFx;
        n nVar = this.x;
        if (nVar == null || (bVarFx = nVar.fx()) == null) {
            return null;
        }
        return u(bVarFx, motionEvent);
    }

    public void nr(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.x.nr(animatorUpdateListener);
    }

    public void nr(Animator.AnimatorListener animatorListener) {
        this.x.nr(animatorListener);
    }

    private com.bytedance.adsdk.lottie.model.layer.fx u(com.bytedance.adsdk.lottie.model.layer.b bVar, MotionEvent motionEvent) {
        com.bytedance.adsdk.lottie.model.layer.fx fxVarU;
        for (com.bytedance.adsdk.lottie.model.layer.fx fxVar : bVar.s()) {
            if (fxVar instanceof com.bytedance.adsdk.lottie.model.layer.b) {
                if (fxVar.jk() && fxVar.n() > 0.0f) {
                    RectF rectF = new RectF();
                    fxVar.u(rectF, fxVar.iz(), true);
                    if (rectF.width() >= 3.0f && rectF.height() >= 3.0f && (fxVarU = u((com.bytedance.adsdk.lottie.model.layer.b) fxVar, motionEvent)) != null) {
                        return fxVarU;
                    }
                }
            } else if (fxVar.jk() && fxVar.n() > 0.0f) {
                RectF rectF2 = new RectF();
                n nVar = this.x;
                if (nVar != null && nVar.n()) {
                    fxVar.u(rectF2, fxVar.iz(), true);
                    RectF rectFJa = this.x.ja();
                    if (rectFJa != null) {
                        u(rectF2, rectFJa);
                    }
                } else {
                    RectF rectF3 = new RectF();
                    fxVar.u(rectF3, fxVar.iz(), true);
                    nr(rectF2, rectF3);
                }
                if (u(motionEvent, rectF2)) {
                    return fxVar;
                }
            }
        }
        return null;
    }

    private boolean u(MotionEvent motionEvent, RectF rectF) {
        if (motionEvent != null && rectF != null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (x >= rectF.left && x <= rectF.right && y >= rectF.top && y <= rectF.bottom) {
                return true;
            }
        }
        return false;
    }

    private void u(RectF rectF, RectF rectF2) {
        float width = getWidth();
        float height = getHeight();
        float fWidth = rectF2.width();
        float fHeight = rectF2.height();
        if (width == 0.0f || height == 0.0f || fWidth == 0.0f || fHeight == 0.0f) {
            return;
        }
        Matrix matrix = new Matrix();
        int i = AnonymousClass6.u[getScaleType().ordinal()];
        if (i == 1) {
            u(matrix, width, height, fWidth, fHeight);
        } else if (i == 2) {
            nr(matrix, width, height, fWidth, fHeight);
        } else if (i == 3) {
            fx(matrix, width, height, fWidth, fHeight);
        } else if (i == 4) {
            b(matrix, width, height, fWidth, fHeight);
        }
        matrix.mapRect(rectF);
    }

    private void u(Matrix matrix, float f, float f2, float f3, float f4) {
        if (f3 / f4 >= f / f2) {
            float f5 = f2 / f4;
            matrix.preScale(f5, f5);
            matrix.postTranslate(-(((f3 * f5) - f) / 2.0f), 0.0f);
        } else {
            float f6 = f / f3;
            matrix.preScale(f6, f6);
            matrix.postTranslate(0.0f, -(((f4 * f6) - f2) / 2.0f));
        }
    }

    public void u(boolean z, Context context) {
        this.x.u(z, context);
    }

    private mv<iz> u(@RawRes final int i) {
        if (isInEditMode()) {
            return new mv<>(new Callable<l<iz>>() { // from class: com.bytedance.adsdk.lottie.LottieAnimationView.14
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public l<iz> call() throws Exception {
                    return LottieAnimationView.this.l ? x.nr(LottieAnimationView.this.getContext(), i) : x.nr(LottieAnimationView.this.getContext(), i, (String) null);
                }
            }, true);
        }
        return this.l ? x.u(getContext(), i) : x.u(getContext(), i, (String) null);
    }

    public void u(String str, String str2) {
        u(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void u(InputStream inputStream, String str) {
        setCompositionTask(x.u(inputStream, str));
    }

    private com.bytedance.adsdk.lottie.model.layer.iz u(com.bytedance.adsdk.lottie.model.layer.b bVar, String str) {
        for (com.bytedance.adsdk.lottie.model.layer.fx fxVar : bVar.s()) {
            if (fxVar instanceof com.bytedance.adsdk.lottie.model.layer.b) {
                com.bytedance.adsdk.lottie.model.layer.iz izVarU = u((com.bytedance.adsdk.lottie.model.layer.b) fxVar, str);
                if (izVarU != null) {
                    return izVarU;
                }
            } else if (TextUtils.equals(str, fxVar.t()) && (fxVar instanceof com.bytedance.adsdk.lottie.model.layer.iz)) {
                return (com.bytedance.adsdk.lottie.model.layer.iz) fxVar;
            }
        }
        return null;
    }

    @MainThread
    public void u() {
        if (this.dw == 0) {
            this.dw = SystemClock.elapsedRealtime();
        }
        this.mv.add(b.PLAY_OPTION);
        this.x.l();
    }

    public void u(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.x.u(animatorUpdateListener);
    }

    public void u(Animator.AnimatorListener animatorListener) {
        this.x.u(animatorListener);
    }

    @Deprecated
    public void u(boolean z) {
        this.x.pn(z ? -1 : 0);
    }

    public Bitmap u(String str, Bitmap bitmap) {
        return this.x.u(str, bitmap);
    }

    private void u(@FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY) float f, boolean z) {
        if (z) {
            this.mv.add(b.SET_PROGRESS);
        }
        this.x.b(f);
    }
}
