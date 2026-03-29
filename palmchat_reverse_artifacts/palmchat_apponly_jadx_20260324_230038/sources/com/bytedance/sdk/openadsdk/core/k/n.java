package com.bytedance.sdk.openadsdk.core.k;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.y.gi;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class n {
    private static String iz;
    private static volatile String pn;
    private GLSurfaceView u;
    private static AtomicBoolean x = new AtomicBoolean();
    private static AtomicInteger n = new AtomicInteger();
    private AtomicBoolean b = new AtomicBoolean();
    private Handler nr = jk.u();
    private Handler fx = jk.nr();

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u(GLSurfaceView gLSurfaceView);
    }

    public static String u() {
        if (!TextUtils.isEmpty(pn)) {
            return pn;
        }
        String strFx = com.bytedance.sdk.openadsdk.core.fx.b.u().fx("dev20", Long.MAX_VALUE);
        pn = strFx;
        if (!TextUtils.isEmpty(strFx)) {
            return pn;
        }
        if (!TextUtils.isEmpty(iz)) {
            return iz;
        }
        String strFx2 = com.bytedance.sdk.openadsdk.core.fx.b.u().fx("dev21", Long.MAX_VALUE);
        iz = strFx2;
        if (!TextUtils.isEmpty(strFx2)) {
            return iz;
        }
        if (n.addAndGet(1) >= 3) {
            return iz;
        }
        String strNr = gi.nr("ro.board.gpu");
        iz = strNr;
        if (TextUtils.isEmpty(strNr)) {
            iz = gi.nr("ro.hardware.egl");
        }
        if (!TextUtils.isEmpty(iz)) {
            com.bytedance.sdk.openadsdk.core.fx.b.u().b("dev21", iz);
        }
        return iz;
    }

    public static void u(View view) {
        if (TextUtils.isEmpty(pn) && (view instanceof ViewGroup) && dw.nr().xw() && x.compareAndSet(false, true)) {
            String strFx = com.bytedance.sdk.openadsdk.core.fx.b.u().fx("dev20", Long.MAX_VALUE);
            if (!TextUtils.isEmpty(strFx)) {
                pn = strFx;
            } else {
                new n().u((ViewGroup) view, new x() { // from class: com.bytedance.sdk.openadsdk.core.k.n.1
                    @Override // com.bytedance.sdk.openadsdk.core.k.x
                    public void u(String str) {
                        String unused = n.pn = str;
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        com.bytedance.sdk.openadsdk.core.fx.b.u().b("dev20", n.pn);
                    }
                });
            }
        }
    }

    public void u(final ViewGroup viewGroup, final x xVar) {
        Handler handler = this.fx;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.k.n.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Context context = viewGroup.getContext();
                        n.this.u = new GLSurfaceView(context);
                        n.this.u.setAlpha(0.0f);
                        n.this.u.setLayoutParams(new FrameLayout.LayoutParams(1, 1));
                        viewGroup.addView(n.this.u);
                        n nVar = n.this;
                        nVar.u(viewGroup, nVar.u, xVar, new u() { // from class: com.bytedance.sdk.openadsdk.core.k.n.2.1
                            @Override // com.bytedance.sdk.openadsdk.core.k.n.u
                            public void u(GLSurfaceView gLSurfaceView) {
                                n.this.u(gLSurfaceView);
                            }
                        });
                    } catch (Throwable th) {
                        k.nr("gpuInfo", th.getMessage());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final GLSurfaceView gLSurfaceView) {
        Handler handler = this.fx;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.k.n.3
                @Override // java.lang.Runnable
                public void run() {
                    ViewParent parent = gLSurfaceView.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(gLSurfaceView);
                    }
                    n.this.u = null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(ViewGroup viewGroup, final GLSurfaceView gLSurfaceView, final x xVar, final u uVar) {
        final String[] strArr = new String[1];
        final Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.k.n.4
            @Override // java.lang.Runnable
            public void run() {
                x xVar2;
                n.this.b.set(true);
                try {
                    gLSurfaceView.onPause();
                    String str = strArr[0];
                    if (str != null && (xVar2 = xVar) != null) {
                        xVar2.u(str);
                    }
                    u uVar2 = uVar;
                    if (uVar2 != null) {
                        uVar2.u(gLSurfaceView);
                    }
                } catch (Throwable th) {
                    k.nr("gpuInfo2", th.getMessage());
                }
            }
        };
        try {
            gLSurfaceView.setEGLContextClientVersion(2);
            gLSurfaceView.setRenderer(new GLSurfaceView.Renderer() { // from class: com.bytedance.sdk.openadsdk.core.k.n.5
                @Override // android.opengl.GLSurfaceView.Renderer
                public void onDrawFrame(GL10 gl10) {
                    gLSurfaceView.setRenderMode(0);
                }

                @Override // android.opengl.GLSurfaceView.Renderer
                public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
                    strArr[0] = GLES20.glGetString(7937);
                    Handler handler = n.this.nr;
                    if (handler == null || n.this.b.get()) {
                        return;
                    }
                    handler.removeCallbacks(runnable);
                    handler.post(runnable);
                }

                @Override // android.opengl.GLSurfaceView.Renderer
                public void onSurfaceChanged(GL10 gl10, int i, int i2) {
                }
            });
            gLSurfaceView.setRenderMode(0);
            Handler handler = this.nr;
            if (handler != null) {
                handler.postDelayed(runnable, 2000L);
            }
        } catch (Throwable th) {
            k.nr("gpuInfo1", th.getMessage());
        }
    }
}
