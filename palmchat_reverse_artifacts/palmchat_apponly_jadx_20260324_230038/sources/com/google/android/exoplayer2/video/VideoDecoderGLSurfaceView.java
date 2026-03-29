package com.google.android.exoplayer2.video;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.GlUtil;
import com.google.android.exoplayer2.util.b;
import defpackage.cb6;
import defpackage.db6;
import defpackage.vh;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class VideoDecoderGLSurfaceView extends GLSurfaceView implements db6 {
    private static final String TAG = "VideoDecoderGLSV";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f6040a = 0;
    private final a renderer;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a implements GLSurfaceView.Renderer {
        public static final float[] k = {1.164f, 1.164f, 1.164f, 0.0f, -0.392f, 2.017f, 1.596f, -0.813f, 0.0f};
        public static final float[] l = {1.164f, 1.164f, 1.164f, 0.0f, -0.213f, 2.112f, 1.793f, -0.533f, 0.0f};
        public static final float[] m = {1.168f, 1.168f, 1.168f, 0.0f, -0.188f, 2.148f, 1.683f, -0.652f, 0.0f};
        public static final String[] n = {"y_tex", "u_tex", "v_tex"};
        public static final FloatBuffer o = GlUtil.e(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final GLSurfaceView f6041a;
        public final int[] b = new int[3];
        public final int[] c = new int[3];
        public final int[] d = new int[3];
        public final int[] e = new int[3];
        public final AtomicReference<cb6> f = new AtomicReference<>();
        public final FloatBuffer[] g = new FloatBuffer[3];
        public b h;
        public int i;
        public cb6 j;

        public a(GLSurfaceView gLSurfaceView) {
            this.f6041a = gLSurfaceView;
            for (int i = 0; i < 3; i++) {
                int[] iArr = this.d;
                this.e[i] = -1;
                iArr[i] = -1;
            }
        }

        public void a(cb6 cb6Var) {
            cb6 andSet = this.f.getAndSet(cb6Var);
            if (andSet != null) {
                andSet.l();
            }
            this.f6041a.requestRender();
        }

        public final void b() {
            try {
                GLES20.glGenTextures(3, this.b, 0);
                for (int i = 0; i < 3; i++) {
                    GLES20.glUniform1i(this.h.j(n[i]), i);
                    GLES20.glActiveTexture(33984 + i);
                    GlUtil.a(3553, this.b[i]);
                }
                GlUtil.b();
            } catch (GlUtil.GlException e) {
                Log.e(VideoDecoderGLSurfaceView.TAG, "Failed to set up the textures", e);
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            cb6 andSet = this.f.getAndSet(null);
            if (andSet == null && this.j == null) {
                return;
            }
            if (andSet != null) {
                cb6 cb6Var = this.j;
                if (cb6Var != null) {
                    cb6Var.l();
                }
                this.j = andSet;
            }
            cb6 cb6Var2 = (cb6) vh.e(this.j);
            float[] fArr = l;
            int i = cb6Var2.h;
            if (i == 1) {
                fArr = k;
            } else if (i == 3) {
                fArr = m;
            }
            GLES20.glUniformMatrix3fv(this.i, 1, false, fArr, 0);
            int[] iArr = (int[]) vh.e(cb6Var2.g);
            ByteBuffer[] byteBufferArr = (ByteBuffer[]) vh.e(cb6Var2.f);
            int i2 = 0;
            while (i2 < 3) {
                int i3 = i2 == 0 ? cb6Var2.e : (cb6Var2.e + 1) / 2;
                GLES20.glActiveTexture(33984 + i2);
                GLES20.glBindTexture(3553, this.b[i2]);
                GLES20.glPixelStorei(3317, 1);
                GLES20.glTexImage2D(3553, 0, 6409, iArr[i2], i3, 0, 6409, 5121, byteBufferArr[i2]);
                i2++;
            }
            int i4 = cb6Var2.d;
            int i5 = (i4 + 1) / 2;
            int[] iArr2 = {i4, i5, i5};
            for (int i6 = 0; i6 < 3; i6++) {
                if (this.d[i6] != iArr2[i6] || this.e[i6] != iArr[i6]) {
                    vh.g(iArr[i6] != 0);
                    float f = iArr2[i6] / iArr[i6];
                    this.g[i6] = GlUtil.e(new float[]{0.0f, 0.0f, 0.0f, 1.0f, f, 0.0f, f, 1.0f});
                    GLES20.glVertexAttribPointer(this.c[i6], 2, 5126, false, 0, (Buffer) this.g[i6]);
                    this.d[i6] = iArr2[i6];
                    this.e[i6] = iArr[i6];
                }
            }
            GLES20.glClear(16384);
            GLES20.glDrawArrays(5, 0, 4);
            try {
                GlUtil.b();
            } catch (GlUtil.GlException e) {
                Log.e(VideoDecoderGLSurfaceView.TAG, "Failed to draw a frame", e);
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            GLES20.glViewport(0, 0, i, i2);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            try {
                b bVar = new b("varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n", "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n");
                this.h = bVar;
                GLES20.glVertexAttribPointer(bVar.e("in_pos"), 2, 5126, false, 0, (Buffer) o);
                this.c[0] = this.h.e("in_tc_y");
                this.c[1] = this.h.e("in_tc_u");
                this.c[2] = this.h.e("in_tc_v");
                this.i = this.h.j("mColorConversion");
                GlUtil.b();
                b();
                GlUtil.b();
            } catch (GlUtil.GlException e) {
                Log.e(VideoDecoderGLSurfaceView.TAG, "Failed to set up the textures and program", e);
            }
        }
    }

    public VideoDecoderGLSurfaceView(Context context) {
        this(context, null);
    }

    public void setOutputBuffer(cb6 cb6Var) {
        this.renderer.a(cb6Var);
    }

    public VideoDecoderGLSurfaceView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a aVar = new a(this);
        this.renderer = aVar;
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(2);
        setRenderer(aVar);
        setRenderMode(0);
    }

    @Deprecated
    public db6 getVideoDecoderOutputBufferRenderer() {
        return this;
    }
}
