package com.zenmen.palmchat.video.recorder.gles;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.util.Log;
import androidx.media3.common.C;
import defpackage.gc2;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class Texture2dProgram {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ProgramType f15811a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public ArrayList<FloatBuffer> n = new ArrayList<>();
    public ArrayList<ShortBuffer> o = new ArrayList<>();
    public ArrayList<Integer> p = new ArrayList<>();
    public final float[] q = {-0.25f, 0.25f, 0.0f, 0.0f, 0.0f, -0.25f, -0.25f, 0.0f, 0.0f, 1.0f, 0.25f, -0.25f, 0.0f, 1.0f, 1.0f, 0.25f, 0.25f, 0.0f, 1.0f, 0.0f};
    public final short[] r = {0, 1, 2, 0, 2, 3};
    public float[] s = new float[9];
    public float[] t;
    public float u;

    /* JADX INFO: compiled from: SearchBox */
    public enum ProgramType {
        TEXTURE_2D,
        TEXTURE_EXT,
        TEXTURE_EXT_BW,
        TEXTURE_EXT_NIGHT,
        TEXTURE_EXT_CHROMA_KEY,
        TEXTURE_EXT_SQUEEZE,
        TEXTURE_EXT_TWIRL,
        TEXTURE_EXT_TUNNEL,
        TEXTURE_EXT_BULGE,
        TEXTURE_EXT_DENT,
        TEXTURE_EXT_FISHEYE,
        TEXTURE_EXT_STRETCH,
        TEXTURE_EXT_MIRROR,
        TEXTURE_EXT_FILT,
        TEXTURE_EXT_MUTIL_TEXTURE
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15812a;

        static {
            int[] iArr = new int[ProgramType.values().length];
            f15812a = iArr;
            try {
                iArr[ProgramType.TEXTURE_2D.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15812a[ProgramType.TEXTURE_EXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15812a[ProgramType.TEXTURE_EXT_BW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15812a[ProgramType.TEXTURE_EXT_NIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f15812a[ProgramType.TEXTURE_EXT_CHROMA_KEY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f15812a[ProgramType.TEXTURE_EXT_SQUEEZE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f15812a[ProgramType.TEXTURE_EXT_TWIRL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f15812a[ProgramType.TEXTURE_EXT_TUNNEL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f15812a[ProgramType.TEXTURE_EXT_BULGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f15812a[ProgramType.TEXTURE_EXT_FISHEYE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f15812a[ProgramType.TEXTURE_EXT_DENT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f15812a[ProgramType.TEXTURE_EXT_MIRROR.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f15812a[ProgramType.TEXTURE_EXT_STRETCH.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f15812a[ProgramType.TEXTURE_EXT_FILT.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f15812a[ProgramType.TEXTURE_EXT_MUTIL_TEXTURE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    public Texture2dProgram(ProgramType programType) {
        FileInputStream fileInputStream;
        this.l = -1;
        this.m = -1;
        this.f15811a = programType;
        switch (a.f15812a[programType.ordinal()]) {
            case 1:
                this.j = 3553;
                this.b = gc2.d("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nuniform int flag;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
                break;
            case 2:
                this.j = 36197;
                this.b = gc2.d("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nuniform int flag;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvec3 target = vec3(0.3,0.3,0.3); \nvoid main() {\n    float uT = 1.2; \n    vec4 color = texture2D(sTexture, vTextureCoord);\n     gl_FragColor = vec4(mix(target,color.rgb, 1.1), 1.0 );\n}\n");
                break;
            case 3:
                this.j = 36197;
                this.b = gc2.d("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nuniform int flag;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    vec4 tc = texture2D(sTexture, vTextureCoord);\n    float color = tc.r * 0.3 + tc.g * 0.59 + tc.b * 0.11;\n    gl_FragColor = vec4(color, color, color, 1.0);\n}\n");
                break;
            case 4:
                this.j = 36197;
                this.b = gc2.d("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nuniform int flag;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    vec4 tc = texture2D(sTexture, vTextureCoord);\n    float color = ((tc.r * 0.3 + tc.g * 0.59 + tc.b * 0.11) - 0.5 * 1.5) + 0.8;\n    gl_FragColor = vec4(color, color + 0.15, color, 1.0);\n}\n");
                break;
            case 5:
                this.j = 36197;
                this.b = gc2.d("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nuniform int flag;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    vec4 tc = texture2D(sTexture, vTextureCoord);\n    float color = ((tc.r * 0.3 + tc.g * 0.59 + tc.b * 0.11) - 0.5 * 1.5) + 0.8;\n    if(tc.g > 0.6 && tc.b < 0.6 && tc.r < 0.6){ \n        gl_FragColor = vec4(0, 0, 0, 0.0);\n    }else{ \n        gl_FragColor = texture2D(sTexture, vTextureCoord);\n    }\n}\n");
                break;
            case 6:
                this.j = 36197;
                this.b = gc2.d("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nuniform int flag;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform vec2 uPosition;\nvoid main() {\n    vec2 texCoord = vTextureCoord.xy;\n    vec2 normCoord = 2.0 * texCoord - 1.0;\n    float r = length(normCoord); // to polar coords \n    float phi = atan(normCoord.y + uPosition.y, normCoord.x + uPosition.x); // to polar coords \n    r = pow(r, 1.0/1.8) * 0.8;\n    normCoord.x = r * cos(phi); \n    normCoord.y = r * sin(phi); \n    texCoord = normCoord / 2.0 + 0.5;\n    gl_FragColor = texture2D(sTexture, texCoord);\n}\n");
                break;
            case 7:
                this.j = 36197;
                this.b = gc2.d("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nuniform int flag;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform vec2 uPosition;\nvoid main() {\n    vec2 texCoord = vTextureCoord.xy;\n    vec2 normCoord = 2.0 * texCoord - 1.0;\n    float r = length(normCoord); // to polar coords \n    float phi = atan(normCoord.y + uPosition.y, normCoord.x + uPosition.x); // to polar coords \n    phi = phi + (1.0 - smoothstep(-0.5, 0.5, r)) * 4.0;\n    normCoord.x = r * cos(phi); \n    normCoord.y = r * sin(phi); \n    texCoord = normCoord / 2.0 + 0.5;\n    gl_FragColor = texture2D(sTexture, texCoord);\n}\n");
                break;
            case 8:
                this.j = 36197;
                this.b = gc2.d("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nuniform int flag;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform vec2 uPosition;\nvoid main() {\n    vec2 texCoord = vTextureCoord.xy;\n    vec2 normCoord = 2.0 * texCoord - 1.0;\n    float r = length(normCoord); // to polar coords \n    float phi = atan(normCoord.y + uPosition.y, normCoord.x + uPosition.x); // to polar coords \n    if (r > 0.5) r = 0.5;\n    normCoord.x = r * cos(phi); \n    normCoord.y = r * sin(phi); \n    texCoord = normCoord / 2.0 + 0.5;\n    gl_FragColor = texture2D(sTexture, texCoord);\n}\n");
                break;
            case 9:
                this.j = 36197;
                this.b = gc2.d("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nuniform int flag;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform vec2 uPosition;\nvoid main() {\n    vec2 texCoord = vTextureCoord.xy;\n    vec2 normCoord = 2.0 * texCoord - 1.0;\n    float r = length(normCoord); // to polar coords \n    float phi = atan(normCoord.y + uPosition.y, normCoord.x + uPosition.x); // to polar coords \n    r = r * smoothstep(-0.1, 0.5, r);\n    normCoord.x = r * cos(phi); \n    normCoord.y = r * sin(phi); \n    texCoord = normCoord / 2.0 + 0.5;\n    gl_FragColor = texture2D(sTexture, texCoord);\n}\n");
                break;
            case 10:
                this.j = 36197;
                this.b = gc2.d("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nuniform int flag;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform vec2 uPosition;\nvoid main() {\n    vec2 texCoord = vTextureCoord.xy;\n    vec2 normCoord = 2.0 * texCoord - 1.0;\n    float r = length(normCoord); // to polar coords \n    float phi = atan(normCoord.y + uPosition.y, normCoord.x + uPosition.x); // to polar coords \n    r = r * r / sqrt(2.0);\n    normCoord.x = r * cos(phi); \n    normCoord.y = r * sin(phi); \n    texCoord = normCoord / 2.0 + 0.5;\n    gl_FragColor = texture2D(sTexture, texCoord);\n}\n");
                break;
            case 11:
                this.j = 36197;
                this.b = gc2.d("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nuniform int flag;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform vec2 uPosition;\nvoid main() {\n    vec2 texCoord = vTextureCoord.xy;\n    vec2 normCoord = 2.0 * texCoord - 1.0;\n    float r = length(normCoord); // to polar coords \n    float phi = atan(normCoord.y + uPosition.y, normCoord.x + uPosition.x); // to polar coords \n    r = 2.0 * r - r * smoothstep(0.0, 0.7, r);\n    normCoord.x = r * cos(phi); \n    normCoord.y = r * sin(phi); \n    texCoord = normCoord / 2.0 + 0.5;\n    gl_FragColor = texture2D(sTexture, texCoord);\n}\n");
                break;
            case 12:
                this.j = 36197;
                this.b = gc2.d("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nuniform int flag;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform vec2 uPosition;\nvoid main() {\n    vec2 texCoord = vTextureCoord.xy;\n    vec2 normCoord = 2.0 * texCoord - 1.0;\n    normCoord.x = normCoord.x * sign(normCoord.x + uPosition.x);\n    texCoord = normCoord / 2.0 + 0.5;\n    gl_FragColor = texture2D(sTexture, texCoord);\n}\n");
                break;
            case 13:
                this.j = 36197;
                this.b = gc2.d("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nuniform int flag;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform vec2 uPosition;\nvoid main() {\n    vec2 texCoord = vTextureCoord.xy;\n    vec2 normCoord = 2.0 * texCoord - 1.0;\n    vec2 s = sign(normCoord + uPosition);\n    normCoord = abs(normCoord);\n    normCoord = 0.5 * normCoord + 0.5 * smoothstep(0.25, 0.5, normCoord) * normCoord;\n    normCoord = s * normCoord;\n    texCoord = normCoord / 2.0 + 0.5;\n    gl_FragColor = texture2D(sTexture, texCoord);\n}\n");
                break;
            case 14:
                this.j = 36197;
                this.b = gc2.d("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nuniform int flag;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\n#define KERNEL_SIZE 9\nprecision highp float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform float uKernel[KERNEL_SIZE];\nuniform vec2 uTexOffset[KERNEL_SIZE];\nuniform float uColorAdjust;\nvoid main() {\n    int i = 0;\n    vec4 sum = vec4(0.0);\n    for (i = 0; i < KERNEL_SIZE; i++) {\n            vec4 texc = texture2D(sTexture, vTextureCoord + uTexOffset[i]);\n            sum += texc * uKernel[i];\n    }\n    sum += uColorAdjust;\n    gl_FragColor = sum;\n}\n");
                break;
            case 15:
                this.j = 36197;
                this.b = gc2.d("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nuniform int flag;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform sampler2D faceTexture; \nuniform int flag;\nvoid main() {\n    bool vflag = bool(flag);     if(vflag){  \n      gl_FragColor = texture2D(faceTexture, vTextureCoord); \n     }else { \n       gl_FragColor = texture2D(sTexture, vTextureCoord); \n     } \n}\n");
                break;
            default:
                throw new RuntimeException("Unhandled type " + programType);
        }
        if (this.b == 0) {
            throw new RuntimeException("Unable to create program");
        }
        Log.d("Texture2dProgram", "Created program " + this.b + " (" + programType + ")");
        int iGlGetAttribLocation = GLES20.glGetAttribLocation(this.b, "aPosition");
        this.h = iGlGetAttribLocation;
        gc2.b(iGlGetAttribLocation, "aPosition");
        int iGlGetAttribLocation2 = GLES20.glGetAttribLocation(this.b, "aTextureCoord");
        this.i = iGlGetAttribLocation2;
        gc2.b(iGlGetAttribLocation2, "aTextureCoord");
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.b, "uMVPMatrix");
        this.c = iGlGetUniformLocation;
        gc2.b(iGlGetUniformLocation, "uMVPMatrix");
        int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(this.b, "uTexMatrix");
        this.d = iGlGetUniformLocation2;
        gc2.b(iGlGetUniformLocation2, "uTexMatrix");
        int iGlGetUniformLocation3 = GLES20.glGetUniformLocation(this.b, "uKernel");
        this.e = iGlGetUniformLocation3;
        if (iGlGetUniformLocation3 < 0) {
            this.e = -1;
            this.f = -1;
            this.g = -1;
        } else {
            int iGlGetUniformLocation4 = GLES20.glGetUniformLocation(this.b, "uTexOffset");
            this.f = iGlGetUniformLocation4;
            gc2.b(iGlGetUniformLocation4, "uTexOffset");
            int iGlGetUniformLocation5 = GLES20.glGetUniformLocation(this.b, "uColorAdjust");
            this.g = iGlGetUniformLocation5;
            gc2.b(iGlGetUniformLocation5, "uColorAdjust");
            e(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f}, 0.0f);
            f(256, 256);
        }
        int iGlGetUniformLocation6 = GLES20.glGetUniformLocation(this.b, "flag");
        this.k = iGlGetUniformLocation6;
        if (iGlGetUniformLocation6 >= 0) {
            this.l = GLES20.glGetUniformLocation(this.b, "faceTexture");
            try {
                fileInputStream = new FileInputStream("/sdcard/lightmap.png");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                fileInputStream = null;
            }
            this.m = c(BitmapFactory.decodeStream(fileInputStream));
        }
    }

    public int a() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        gc2.a("glGenTextures");
        int i = iArr[0];
        GLES20.glBindTexture(this.j, i);
        gc2.a("glBindTexture " + i);
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        gc2.a("glTexParameter");
        return i;
    }

    public void b(float[] fArr, FloatBuffer floatBuffer, int i, int i2, int i3, int i4, float[] fArr2, FloatBuffer floatBuffer2, int i5, int i6) {
        gc2.a("draw start");
        GLES20.glUseProgram(this.b);
        gc2.a("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.j, i5);
        GLES20.glUniformMatrix4fv(this.c, 1, false, fArr, 0);
        gc2.a("glUniformMatrix4fv");
        GLES20.glUniformMatrix4fv(this.d, 1, false, fArr2, 0);
        gc2.a("glUniformMatrix4fv");
        GLES20.glEnableVertexAttribArray(this.h);
        gc2.a("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.h, i3, 5126, false, i4, (Buffer) floatBuffer);
        gc2.a("glVertexAttribPointer");
        GLES20.glEnableVertexAttribArray(this.i);
        gc2.a("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.i, 2, 5126, false, i6, (Buffer) floatBuffer2);
        gc2.a("glVertexAttribPointer");
        int i7 = this.k;
        if (i7 >= 0) {
            GLES20.glUniform1i(i7, 0);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, this.m);
            GLES20.glUniform1i(this.l, 1);
        }
        int i8 = this.e;
        if (i8 >= 0) {
            GLES20.glUniform1fv(i8, 9, this.s, 0);
            GLES20.glUniform2fv(this.f, 9, this.t, 0);
            GLES20.glUniform1f(this.g, this.u);
        }
        GLES20.glDrawArrays(5, i, i2);
        GLES20.glFlush();
        int i9 = this.k;
        if (i9 >= 0) {
            GLES20.glUniform1i(i9, 1);
            GLES20.glBlendFunc(1, 771);
            GLES20.glEnable(3042);
            int size = this.n.size();
            for (int i10 = 0; i10 < size; i10++) {
                FloatBuffer floatBuffer3 = this.n.get(i10);
                ShortBuffer shortBuffer = this.o.get(i10);
                int iIntValue = this.p.get(i10).intValue();
                floatBuffer3.position(0);
                GLES20.glVertexAttribPointer(this.h, 3, 5126, false, 20, (Buffer) floatBuffer3);
                floatBuffer3.position(3);
                GLES20.glVertexAttribPointer(this.i, 2, 5126, false, 20, (Buffer) floatBuffer3);
                shortBuffer.position(0);
                GLES20.glBindTexture(3553, iIntValue);
                GLES20.glUniform1i(this.l, 1);
                GLES20.glDrawElements(4, 6, 5123, shortBuffer);
            }
        }
        GLES20.glDisableVertexAttribArray(this.h);
        GLES20.glDisableVertexAttribArray(this.i);
        GLES20.glBindTexture(this.j, 0);
        GLES20.glUseProgram(0);
    }

    public int c(Bitmap bitmap) {
        int[] iArr = new int[1];
        byte[] bArr = new byte[bitmap.getWidth() * bitmap.getHeight() * 4];
        for (int i = 0; i < bitmap.getHeight(); i++) {
            for (int i2 = 0; i2 < bitmap.getWidth(); i2++) {
                int pixel = bitmap.getPixel(i2, i);
                bArr[(((bitmap.getWidth() * i) + i2) * 4) + 3] = (byte) ((pixel >> 24) & 255);
                bArr[(((bitmap.getWidth() * i) + i2) * 4) + 0] = (byte) ((pixel >> 16) & 255);
                bArr[(((bitmap.getWidth() * i) + i2) * 4) + 1] = (byte) ((pixel >> 8) & 255);
                bArr[(((bitmap.getWidth() * i) + i2) * 4) + 2] = (byte) ((pixel >> 0) & 255);
            }
        }
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(bitmap.getWidth() * bitmap.getHeight() * 4);
        byteBufferAllocateDirect.put(bArr).position(0);
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexImage2D(3553, 0, 6408, bitmap.getWidth(), bitmap.getHeight(), 0, 6408, 5121, byteBufferAllocateDirect);
        GLES20.glTexParameteri(3553, 10241, C.TEXTURE_MIN_FILTER_LINEAR);
        GLES20.glTexParameteri(3553, 10240, C.TEXTURE_MIN_FILTER_LINEAR);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        return iArr[0];
    }

    public void d() {
        Log.d("Texture2dProgram", "deleting program " + this.b);
        GLES20.glDeleteProgram(this.b);
        this.b = -1;
    }

    public void e(float[] fArr, float f) {
        if (fArr.length == 9) {
            System.arraycopy(fArr, 0, this.s, 0, 9);
            this.u = f;
            return;
        }
        throw new IllegalArgumentException("Kernel size is " + fArr.length + " vs. 9");
    }

    public void f(int i, int i2) {
        float f = 1.0f / i;
        float f2 = 1.0f / i2;
        float f3 = -f;
        float f4 = -f2;
        this.t = new float[]{f3, f4, 0.0f, f4, f, f4, f3, 0.0f, 0.0f, 0.0f, f, 0.0f, f3, f2, 0.0f, f2, f, f2};
    }
}
