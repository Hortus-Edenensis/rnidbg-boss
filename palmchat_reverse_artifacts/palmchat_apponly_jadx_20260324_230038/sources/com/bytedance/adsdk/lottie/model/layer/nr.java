package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bykv.vk.openvk.component.video.api.u;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.bq;
import com.bytedance.sdk.component.utils.k;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class nr extends x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f4990a;
    private com.bykv.vk.openvk.component.video.u.b.b jk;
    private final Runnable k;
    private TextureView l;
    private LottieAnimationView mv;
    private float n;
    private final Handler s;
    private volatile boolean t;

    /* JADX WARN: Removed duplicated region for block: B:15:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public nr(com.bytedance.adsdk.lottie.n nVar, n nVar2, final Context context) {
        JSONObject jSONObject;
        super(nVar, nVar2);
        this.n = -1.0f;
        this.f4990a = -1.0f;
        this.s = new Handler(Looper.getMainLooper());
        this.k = new Runnable() { // from class: com.bytedance.adsdk.lottie.model.layer.nr.4
            @Override // java.lang.Runnable
            public void run() {
                if (nr.this.mv != null) {
                    nr.this.mv.invalidate();
                }
                nr.this.s.postDelayed(nr.this.k, 40L);
            }
        };
        if (((x) this).x == null || nVar == null || context == null) {
            return;
        }
        LottieAnimationView lottieAnimationViewNr = nVar.nr();
        this.mv = lottieAnimationViewNr;
        if (lottieAnimationViewNr == null) {
            return;
        }
        float fU = com.bytedance.adsdk.lottie.pn.a.u();
        this.n = (int) (((x) this).x.u() * fU);
        this.f4990a = (int) (((x) this).x.nr() * fU);
        bq bqVarKj = nVar.kj();
        if (bqVarKj != null) {
            String strU = bqVarKj.u(((x) this).x.mv());
            if (TextUtils.isEmpty(strU)) {
                jSONObject = null;
            } else {
                try {
                    jSONObject = new JSONObject(strU);
                } catch (JSONException unused) {
                    jSONObject = null;
                }
            }
        }
        if (jSONObject != null) {
            final String strOptString = jSONObject.optString("file_hash");
            final String strOptString2 = jSONObject.optString(WfConstant.EXTRA_KEY_VIDEO_URL);
            jSONObject.optString(WfConstant.EXTRA_KEY_VIDEO_DURATION);
            jSONObject.optString("resolution");
            if (TextUtils.isEmpty(strOptString2)) {
                return;
            }
            TextureView textureView = new TextureView(context);
            this.l = textureView;
            textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.bytedance.adsdk.lottie.model.layer.nr.1
                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                    nr.this.u(strOptString2, strOptString, context, surfaceTexture);
                    nr.this.o();
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                    nr.this.s();
                    surfaceTexture.release();
                    nr.this.my();
                    return true;
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                }
            });
            this.mv.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.adsdk.lottie.model.layer.nr.2
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    if (nr.this.mv == view) {
                        if (nr.this.nr()) {
                            nr.this.mv.removeOnAttachStateChangeListener(this);
                        } else {
                            nr.this.u(new Runnable() { // from class: com.bytedance.adsdk.lottie.model.layer.nr.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    nr.this.k();
                                }
                            });
                        }
                    }
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                    if (nr.this.mv == view) {
                        nr.this.u(new Runnable() { // from class: com.bytedance.adsdk.lottie.model.layer.nr.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                ViewParent parent = nr.this.l.getParent();
                                if (parent instanceof ViewGroup) {
                                    ((ViewGroup) parent).removeView(nr.this.l);
                                }
                            }
                        });
                    }
                }
            });
            k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        ViewParent parent = this.l.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.l);
        }
        ViewParent parent2 = this.mv.getParent();
        if (parent2 instanceof ViewGroup) {
            this.l.setTranslationX(2.1474836E9f);
            ((ViewGroup) parent2).addView(this.l);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void my() {
        this.s.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        my();
        if (this.mv != null) {
            this.s.postDelayed(this.k, 40L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (this.jk != null) {
            if (this.t) {
                this.jk.b();
            }
            this.jk.pn();
            this.jk = null;
        }
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.x, com.bytedance.adsdk.lottie.model.layer.fx
    public void nr(Canvas canvas, Matrix matrix, int i) {
        if (this.n <= 0.0f || this.l == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        u(i);
        float fN = n();
        u(this.l, (int) this.n, (int) this.f4990a);
        this.l.setAlpha(fN);
        this.l.draw(canvas);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str, String str2, Context context, SurfaceTexture surfaceTexture) {
        s();
        com.bykv.vk.openvk.component.video.u.b.b bVar = new com.bykv.vk.openvk.component.video.u.b.b("uttie");
        this.jk = bVar;
        bVar.u(surfaceTexture);
        this.jk.u(new u.InterfaceC0156u() { // from class: com.bytedance.adsdk.lottie.model.layer.nr.3
            @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
            public void nr(com.bykv.vk.openvk.component.video.api.u uVar, int i) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
            public void u(com.bykv.vk.openvk.component.video.api.u uVar) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
            public void nr(com.bykv.vk.openvk.component.video.api.u uVar) {
                nr.this.t = true;
                uVar.fx(true);
            }

            @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
            public void u(com.bykv.vk.openvk.component.video.api.u uVar, int i) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
            public void u(com.bykv.vk.openvk.component.video.api.u uVar, int i, int i2) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
            public void u(com.bykv.vk.openvk.component.video.api.u uVar, int i, int i2, int i3) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
            public void u(com.bykv.vk.openvk.component.video.api.u uVar, long j) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
            public void u(com.bykv.vk.openvk.component.video.api.u uVar, long j, long j2) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
            public void u(com.bykv.vk.openvk.component.video.api.u uVar, JSONObject jSONObject, String str3) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
            public void u(com.bykv.vk.openvk.component.video.api.u uVar, boolean z) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
            public void u(com.bykv.vk.openvk.component.video.api.u uVar, com.bykv.vk.openvk.component.video.api.fx.fx fxVar) {
                k.nr("uttie-video", fxVar.u() + ":" + fxVar.nr() + ":" + fxVar.fx());
            }

            @Override // com.bykv.vk.openvk.component.video.api.u.InterfaceC0156u
            public void fx(com.bykv.vk.openvk.component.video.api.u uVar) {
            }
        });
        com.bykv.vk.openvk.component.video.api.fx.b bVar2 = new com.bykv.vk.openvk.component.video.api.fx.b();
        bVar2.fx(str);
        bVar2.pn(str2);
        this.jk.u(new com.bykv.vk.openvk.component.video.api.fx.iz(com.bytedance.adsdk.lottie.pn.nr.nr(context), bVar2, null, 0, 0));
        this.jk.u(true);
        this.jk.u(true, 0L, true);
    }

    private static void u(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }
}
