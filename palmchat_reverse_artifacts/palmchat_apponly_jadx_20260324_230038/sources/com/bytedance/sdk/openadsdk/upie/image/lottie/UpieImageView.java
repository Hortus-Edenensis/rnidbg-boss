package com.bytedance.sdk.openadsdk.upie.image.lottie;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bykv.vk.openvk.component.video.api.fx.fx;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.a;
import com.bytedance.adsdk.lottie.b;
import com.bytedance.adsdk.lottie.bq;
import com.bytedance.sdk.openadsdk.upie.nr;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class UpieImageView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5435a;
    private String b;
    private volatile LottieAnimationView fx;
    private final Map<String, Bitmap> iz;
    private u jk;
    private int n;
    private ImageView nr;
    private Bitmap pn;
    private long t;
    private final Context u;
    private final Map<String, Integer> x;

    public UpieImageView(Context context, com.bytedance.sdk.openadsdk.upie.u uVar, u uVar2) {
        super(context);
        this.iz = new HashMap();
        this.x = new HashMap();
        this.n = 0;
        this.f5435a = 0;
        this.u = context;
        this.jk = uVar2;
        u(uVar, uVar2);
    }

    public static /* synthetic */ int fx(UpieImageView upieImageView) {
        int i = upieImageView.f5435a;
        upieImageView.f5435a = i + 1;
        return i;
    }

    public static /* synthetic */ int n(UpieImageView upieImageView) {
        int i = upieImageView.n;
        upieImageView.n = i + 1;
        return i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.fx == null || this.b == null) {
            return;
        }
        this.fx.u();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.fx != null) {
            this.fx.iz();
        }
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != null) {
            if (this.fx != null) {
                this.fx.setScaleType(scaleType);
                return;
            }
            ImageView imageView = this.nr;
            if (imageView != null) {
                imageView.setScaleType(scaleType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(final String str) {
        if (TextUtils.isEmpty(str)) {
            new fx(60008, 10002, "广告主图url为空");
        } else {
            nr.u().nr(str, new nr.u<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.4
                @Override // com.bytedance.sdk.openadsdk.upie.nr.u
                public void u(Bitmap bitmap) {
                    UpieImageView.this.pn = bitmap;
                    final Bitmap bitmapU = com.bytedance.sdk.component.adexpress.b.nr.u(UpieImageView.this.u, UpieImageView.this.pn, 25);
                    com.bytedance.sdk.openadsdk.upie.u.nr.nr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (UpieImageView.this.fx != null) {
                                UpieImageView.this.fx.invalidate();
                            }
                            UpieImageView.this.nr.setImageBitmap(UpieImageView.this.pn);
                            UpieImageView.this.nr.setScaleType(ImageView.ScaleType.FIT_CENTER);
                            if (bitmapU != null) {
                                UpieImageView.this.nr.setBackground(new BitmapDrawable(bitmapU));
                            }
                        }
                    });
                }

                @Override // com.bytedance.sdk.openadsdk.upie.nr.u
                public void u(int i, String str2) {
                    UpieImageView.n(UpieImageView.this);
                    if (UpieImageView.this.n <= 3) {
                        UpieImageView.this.nr(str);
                    } else {
                        new fx(60008, 10003, "广告主图url加载失败");
                    }
                }
            });
        }
    }

    public synchronized void u(final com.bytedance.sdk.openadsdk.upie.u uVar, u uVar2) {
        if (uVar == null) {
            return;
        }
        if (this.fx != null) {
            return;
        }
        this.jk = uVar2;
        final String strFx = uVar.fx();
        String strU = uVar.u();
        if (!TextUtils.isEmpty(strU)) {
            this.fx = new LottieAnimationView(this.u);
            this.fx.setRepeatCount(-1);
            this.fx.setRepeatMode(1);
            this.fx.setClickable(false);
            this.fx.setImageAssetDelegate(new b() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.1
                @Override // com.bytedance.adsdk.lottie.b
                public Bitmap u(a aVar) {
                    if (aVar != null) {
                        String strMv = aVar.mv();
                        if (!TextUtils.isEmpty(strMv)) {
                            if (strMv.startsWith("${") && strMv.endsWith("}")) {
                                strMv = com.bytedance.sdk.openadsdk.upie.u.u.u(strMv, uVar.x());
                                if (TextUtils.isEmpty(strMv)) {
                                    return null;
                                }
                                if (TextUtils.equals(strFx, strMv)) {
                                    Bitmap bitmap = UpieImageView.this.pn;
                                    if (bitmap != null && (bitmap.getWidth() != aVar.u() || bitmap.getHeight() != aVar.nr())) {
                                        UpieImageView.this.pn = Bitmap.createScaledBitmap(bitmap, aVar.u(), aVar.nr(), false);
                                    }
                                    return UpieImageView.this.pn;
                                }
                            }
                            Bitmap bitmap2 = (Bitmap) UpieImageView.this.iz.get(strMv);
                            if (bitmap2 != null) {
                                return bitmap2;
                            }
                            UpieImageView.this.u(strMv, aVar.u(), aVar.nr());
                        }
                    }
                    return null;
                }
            });
            this.fx.setTextDelegate(new bq(this.fx) { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.2
                @Override // com.bytedance.adsdk.lottie.bq
                public String u(String str) {
                    return com.bytedance.sdk.openadsdk.upie.u.u.u(str, uVar.x());
                }
            });
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        ImageView imageView = new ImageView(this.u);
        this.nr = imageView;
        addView(imageView, layoutParams);
        if (this.fx != null) {
            addView(this.fx, layoutParams);
        }
        this.t = SystemClock.elapsedRealtime();
        u(strU);
        nr(strFx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final String str) {
        if (TextUtils.isEmpty(str)) {
            u(10000, "lottieJsonUrl为空");
        } else {
            com.bytedance.sdk.openadsdk.upie.u.nr.fx(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.3
                @Override // java.lang.Runnable
                public void run() {
                    String strU = nr.u().u(str);
                    if (TextUtils.isEmpty(strU)) {
                        nr.u().u(str, new nr.u<String>() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.3.1
                            @Override // com.bytedance.sdk.openadsdk.upie.nr.u
                            public void u(String str2) {
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                UpieImageView.this.u(str2, str);
                            }

                            @Override // com.bytedance.sdk.openadsdk.upie.nr.u
                            public void u(int i, String str2) {
                                if (i == 10006) {
                                    UpieImageView.this.u(i, str2);
                                    return;
                                }
                                UpieImageView.fx(UpieImageView.this);
                                if (UpieImageView.this.f5435a > 3) {
                                    UpieImageView.this.u(i, str2);
                                } else {
                                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                    UpieImageView.this.u(str);
                                }
                            }
                        });
                    } else {
                        UpieImageView.this.u(strU, str);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final String str, final int i, final int i2) {
        Integer num = this.x.get(str);
        if (num == null || num.intValue() != 1) {
            this.x.put(str, 1);
            nr.u().u(this.u, str, new nr.u<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.5
                @Override // com.bytedance.sdk.openadsdk.upie.nr.u
                public void u(Bitmap bitmap) {
                    if (bitmap != null) {
                        if (bitmap.getWidth() != i || bitmap.getHeight() != i2) {
                            bitmap = Bitmap.createScaledBitmap(bitmap, i, i2, false);
                        }
                        UpieImageView.this.iz.put(str, bitmap);
                        com.bytedance.sdk.openadsdk.upie.u.nr.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (UpieImageView.this.fx != null) {
                                    UpieImageView.this.fx.invalidate();
                                }
                            }
                        });
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.upie.nr.u
                public void u(int i3, String str2) {
                    UpieImageView.this.x.put(str, 2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i, String str) {
        u uVar = this.jk;
        if (uVar != null) {
            uVar.u(i, str);
        }
        com.bytedance.sdk.openadsdk.upie.u.nr.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.6
            @Override // java.lang.Runnable
            public void run() {
                if (UpieImageView.this.fx != null) {
                    UpieImageView upieImageView = UpieImageView.this;
                    upieImageView.removeView(upieImageView.fx);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(long j) {
        if (this.jk != null) {
            HashMap map = new HashMap();
            map.put("duration", Long.valueOf(j - this.t));
            this.jk.u(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final String str, final String str2) {
        this.b = str;
        com.bytedance.sdk.openadsdk.upie.u.nr.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (UpieImageView.this.fx != null) {
                    UpieImageView.this.fx.u(str, str2);
                    UpieImageView.this.fx.u(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.7.1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            UpieImageView.this.fx.nr(this);
                            UpieImageView.this.u(SystemClock.elapsedRealtime());
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
                    UpieImageView.this.fx.u();
                }
            }
        });
    }
}
