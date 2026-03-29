package com.huawei.hms.ads;

import android.opengl.GLES20;
import java.nio.Buffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ed {
    private int C;
    private int D;
    private int F;
    private int L;
    private int S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6559a;
    private int b;
    private int c;
    private int d = 36197;
    private final float[] e = new float[9];
    private float[] f = {-0.00390625f, -0.00390625f, 0.0f, -0.00390625f, 0.00390625f, -0.00390625f, -0.00390625f, 0.0f, 0.0f, 0.0f, 0.00390625f, 0.0f, -0.00390625f, 0.00390625f, 0.0f, 0.00390625f, 0.00390625f, 0.00390625f};
    private float g;

    public ed() {
        int I = I();
        this.C = I;
        if (I == 0) {
            throw new IllegalStateException("fail to create program");
        }
        B();
        if (this.D >= 0) {
            Z();
            return;
        }
        this.D = -1;
        this.L = -1;
        this.f6559a = -1;
    }

    private void B() {
        int iGlGetAttribLocation = GLES20.glGetAttribLocation(this.C, "positionLocation");
        this.b = iGlGetAttribLocation;
        Code(iGlGetAttribLocation, "positionLocation");
        int iGlGetAttribLocation2 = GLES20.glGetAttribLocation(this.C, "textureCoordLocation");
        this.c = iGlGetAttribLocation2;
        Code(iGlGetAttribLocation2, "textureCoordLocation");
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.C, "matrixLocation");
        this.S = iGlGetUniformLocation;
        Code(iGlGetUniformLocation, "matrixLocation");
        int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(this.C, "texMatrixLocation");
        this.F = iGlGetUniformLocation2;
        Code(iGlGetUniformLocation2, "texMatrixLocation");
        this.D = GLES20.glGetUniformLocation(this.C, "coreLocation");
    }

    private void C() {
        int i = this.D;
        if (i >= 0) {
            GLES20.glUniform1fv(i, 9, this.e, 0);
            GLES20.glUniform2fv(this.L, 9, this.f, 0);
            GLES20.glUniform1f(this.f6559a, this.g);
        }
    }

    private static int Code(int i, int i2) {
        int iGlCreateProgram = GLES20.glCreateProgram();
        Code("create program");
        if (iGlCreateProgram == 0) {
            fh.I("TexProgram", "fail not create program");
        }
        GLES20.glAttachShader(iGlCreateProgram, i);
        Code("attach shader");
        GLES20.glAttachShader(iGlCreateProgram, i2);
        Code("attach shader");
        GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 1) {
            return iGlCreateProgram;
        }
        fh.I("TexProgram", "fail to link");
        GLES20.glDeleteProgram(iGlCreateProgram);
        return 0;
    }

    private static int I() {
        int iV;
        int iV2 = V(35633, "uniform mat4 matrixLocation; uniform mat4 texMatrixLocation; attribute vec4 positionLocation; attribute vec4 textureCoordLocation; varying vec2 textureCoordination; void main() { gl_Position = matrixLocation * positionLocation; textureCoordination = (texMatrixLocation * textureCoordLocation).xy;}");
        if (iV2 == 0 || (iV = V(35632, "#extension GL_OES_EGL_image_external : require\n precision mediump float; varying vec2 textureCoordination; uniform samplerExternalOES sTexture; void main() {gl_FragColor = texture2D(sTexture, textureCoordination);}")) == 0) {
            return 0;
        }
        return Code(iV2, iV);
    }

    private void Z() {
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.C, "textureOffsetLocation");
        this.L = iGlGetUniformLocation;
        Code(iGlGetUniformLocation, "textureOffsetLocation");
        int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(this.C, "colorAdjustLocation");
        this.f6559a = iGlGetUniformLocation2;
        Code(iGlGetUniformLocation2, "colorAdjustLocation");
        System.arraycopy(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f}, 0, this.e, 0, 9);
        this.g = 0.0f;
    }

    public int V() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        Code("fail to generate texture");
        int i = iArr[0];
        GLES20.glBindTexture(this.d, i);
        Code("fail to bind texture ");
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        Code("fail to create texture");
        return i;
    }

    private void I(ee eeVar) {
        GLES20.glEnableVertexAttribArray(this.b);
        Code("rv - 1");
        GLES20.glVertexAttribPointer(this.b, eeVar.B(), 5126, false, eeVar.C(), (Buffer) eeVar.V());
        Code("rv - 2");
        GLES20.glEnableVertexAttribArray(this.c);
        Code("rv - 3");
        GLES20.glVertexAttribPointer(this.c, 2, 5126, false, eeVar.L(), (Buffer) eeVar.F());
        Code("rv - 4");
    }

    private static int V(int i, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i);
        Code("create shader " + i);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        fh.I("TexProgram", "fail to compile shader: " + i + " " + GLES20.glGetShaderInfoLog(iGlCreateShader));
        GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }

    private void Z(ee eeVar) {
        GLES20.glDrawArrays(5, eeVar.I(), eeVar.Z());
        Code("pr4 - 1");
        GLES20.glDisableVertexAttribArray(this.b);
        GLES20.glDisableVertexAttribArray(this.c);
        GLES20.glBindTexture(this.d, 0);
        GLES20.glUseProgram(0);
    }

    public void Code() {
        try {
            GLES20.glDeleteProgram(this.C);
            this.C = -1;
        } catch (Throwable th) {
            fh.Code(5, "TexProgram", "release", th);
        }
    }

    public static void Code(int i, String str) {
        if (i >= 0) {
            return;
        }
        throw new IllegalStateException("program fail to find " + str);
    }

    private void V(ee eeVar) {
        GLES20.glUseProgram(this.C);
        Code("rtm - 1");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.d, eeVar.D());
        GLES20.glUniformMatrix4fv(this.S, 1, false, eeVar.Code(), 0);
        Code("rtm - 2");
        GLES20.glUniformMatrix4fv(this.F, 1, false, eeVar.S(), 0);
        Code("rtm - 3");
    }

    public void Code(ee eeVar) {
        Code("render - 1");
        V(eeVar);
        I(eeVar);
        C();
        Z(eeVar);
    }

    public static void Code(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError == 0) {
            return;
        }
        String str2 = str + " error: " + Integer.toHexString(iGlGetError);
        fh.I("TexProgram", str2);
        throw new IllegalStateException(str2);
    }
}
