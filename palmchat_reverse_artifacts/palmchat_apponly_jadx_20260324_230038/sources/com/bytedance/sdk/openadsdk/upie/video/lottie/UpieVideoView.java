package com.bytedance.sdk.openadsdk.upie.video.lottie;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bykv.vk.openvk.component.video.api.renderview.SSRenderTextureView;
import com.bykv.vk.openvk.component.video.api.renderview.nr;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.a;
import com.bytedance.adsdk.lottie.b;
import com.bytedance.adsdk.lottie.bq;
import com.bytedance.adsdk.lottie.dw;
import com.bytedance.sdk.openadsdk.upie.nr;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class UpieVideoView extends FrameLayout implements com.bykv.vk.openvk.component.video.api.renderview.nr {
    private final Map<String, Integer> b;
    private final Map<String, Bitmap> fx;
    private final Runnable iz;
    private final LottieAnimationView nr;
    private final Handler pn;
    private final com.bykv.vk.openvk.component.video.api.renderview.nr u;
    private nr.u x;

    public UpieVideoView(final Context context, final com.bytedance.sdk.openadsdk.upie.u uVar) {
        super(context);
        this.fx = new HashMap();
        this.b = new HashMap();
        this.pn = new Handler(Looper.getMainLooper());
        this.iz = new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (UpieVideoView.this.nr != null && UpieVideoView.this.nr.pn()) {
                    UpieVideoView.this.nr.invalidate();
                }
                UpieVideoView.this.pn.postDelayed(UpieVideoView.this.iz, 40L);
            }
        };
        SSRenderTextureView sSRenderTextureView = new SSRenderTextureView(context);
        this.u = sSRenderTextureView;
        addView(sSRenderTextureView.getView());
        sSRenderTextureView.getView().setTranslationX(2.1474836E9f);
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        this.nr = lottieAnimationView;
        lottieAnimationView.setImageAssetDelegate(new b() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.1
            /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
            
                if (r1.startsWith(org.apache.http.HttpHost.DEFAULT_SCHEME_NAME) != false) goto L17;
             */
            @Override // com.bytedance.adsdk.lottie.b
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Bitmap u(a aVar) {
                if (aVar != null) {
                    String strMv = aVar.mv();
                    if (!TextUtils.isEmpty(strMv)) {
                        if (strMv.startsWith("${") && strMv.endsWith("}")) {
                            com.bytedance.sdk.openadsdk.upie.u uVar2 = uVar;
                            if (uVar2 != null) {
                                strMv = com.bytedance.sdk.openadsdk.upie.u.u.u(strMv, uVar2.x());
                                if (!TextUtils.isEmpty(strMv)) {
                                }
                            }
                            return null;
                        }
                        Bitmap bitmap = (Bitmap) UpieVideoView.this.fx.get(strMv);
                        if (bitmap != null) {
                            return bitmap;
                        }
                        UpieVideoView.this.u(context, strMv, aVar.u(), aVar.nr());
                    }
                }
                return null;
            }
        });
        lottieAnimationView.setTextDelegate(new bq(lottieAnimationView) { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.2
            @Override // com.bytedance.adsdk.lottie.bq
            public String u(String str) {
                com.bytedance.sdk.openadsdk.upie.u uVar2 = uVar;
                return com.bytedance.sdk.openadsdk.upie.u.u.u(str, uVar2 != null ? uVar2.x() : null);
            }
        });
        lottieAnimationView.setViewDelegate(new dw() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.3
            @Override // com.bytedance.adsdk.lottie.dw
            public View u(String str, Map<String, Object> map) {
                if ("videoview:".equals(str)) {
                    return UpieVideoView.this.u.getView();
                }
                return null;
            }
        });
        lottieAnimationView.setRepeatMode(1);
        lottieAnimationView.setRepeatCount(-1);
        lottieAnimationView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        lottieAnimationView.setClickable(false);
        lottieAnimationView.u(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (UpieVideoView.this.nr != null) {
                    UpieVideoView.this.nr.nr(this);
                }
                UpieVideoView.this.b();
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
        lottieAnimationView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.5
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (UpieVideoView.this.nr == view) {
                    UpieVideoView.this.fx();
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
            }
        });
        addView(lottieAnimationView, new FrameLayout.LayoutParams(-1, -2));
    }

    public SurfaceHolder getHolder() {
        return null;
    }

    public LottieAnimationView getLottieAnimationView() {
        return this.nr;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        LottieAnimationView lottieAnimationView = this.nr;
        if (lottieAnimationView != null) {
            lottieAnimationView.invalidate();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public void setWindowVisibilityChangedListener(nr.u uVar) {
        this.x = uVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        fx();
        if (this.nr != null) {
            this.pn.postDelayed(this.iz, 40L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx() {
        this.pn.removeCallbacksAndMessages(null);
    }

    public void nr() {
        com.bytedance.sdk.openadsdk.upie.u.nr.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                UpieVideoView.this.fx();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Context context, final String str, final int i, final int i2) {
        Integer num = this.b.get(str);
        if (num == null || num.intValue() != 1) {
            this.b.put(str, 1);
            com.bytedance.sdk.openadsdk.upie.nr.u().u(context, str, new nr.u<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.7
                @Override // com.bytedance.sdk.openadsdk.upie.nr.u
                public void u(Bitmap bitmap) {
                    if (bitmap != null) {
                        if (bitmap.getWidth() != i || bitmap.getHeight() != i2) {
                            bitmap = Bitmap.createScaledBitmap(bitmap, i, i2, false);
                        }
                        UpieVideoView.this.fx.put(str, bitmap);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.upie.nr.u
                public void u(int i3, String str2) {
                    UpieVideoView.this.b.put(str, 2);
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.nr
    public void u(com.bykv.vk.openvk.component.video.api.renderview.u uVar) {
        com.bykv.vk.openvk.component.video.api.renderview.nr nrVar = this.u;
        if (nrVar != null) {
            nrVar.u(uVar);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.nr
    public void u(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    public void u() {
        com.bytedance.sdk.openadsdk.upie.u.nr.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                UpieVideoView.this.b();
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.nr
    public View getView() {
        return this;
    }
}
