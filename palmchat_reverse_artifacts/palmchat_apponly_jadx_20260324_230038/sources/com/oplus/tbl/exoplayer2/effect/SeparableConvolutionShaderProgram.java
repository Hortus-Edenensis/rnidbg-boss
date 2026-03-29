package com.oplus.tbl.exoplayer2.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import androidx.annotation.CallSuper;
import androidx.annotation.RequiresApi;
import com.oplus.tbl.exoplayer2.GlObjectsProvider;
import com.oplus.tbl.exoplayer2.GlTextureInfo;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.effect.GlShaderProgram;
import com.oplus.tbl.exoplayer2.effect.SeparableConvolutionShaderProgram;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.GlProgram;
import com.oplus.tbl.exoplayer2.util.GlUtil;
import com.oplus.tbl.exoplayer2.util.Size;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import defpackage.bc2;
import defpackage.dc2;
import defpackage.er3;
import java.io.IOException;
import java.nio.ShortBuffer;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@RequiresApi(26)
@UnstableApi
public class SeparableConvolutionShaderProgram implements GlShaderProgram {
    private static final int FP16_EXPONENT_BIAS = 15;
    private static final int FP16_EXPONENT_SHIFT = 10;
    private static final int FP16_SIGN_SHIFT = 15;
    private static final int FP32_EXPONENT_BIAS = 127;
    private static final int FP32_EXPONENT_SHIFT = 23;
    private static final int FP32_SHIFTED_EXPONENT_MASK = 255;
    private static final int FP32_SIGNIFICAND_MASK = 8388607;
    private static final int FP32_SIGN_SHIFT = 31;
    private static final String FRAGMENT_SHADER_PATH = "shaders/fragment_shader_separable_convolution_es2.glsl";
    private static final int FUNCTION_LUT_PADDING = 5;
    private static final int RASTER_SAMPLES_PER_TEXEL = 5;
    private static final String VERTEX_SHADER_PATH = "shaders/vertex_shader_transformation_es2.glsl";
    private final SeparableConvolution convolution;
    private float functionLutCenterX;
    private float functionLutDomainStart;
    private float functionLutTexelStep;
    private GlTextureInfo functionLutTexture;
    private float functionLutWidth;
    private final GlProgram glProgram;
    private Size intermediateSize;
    private GlTextureInfo intermediateTexture;
    private ConvolutionFunction1D lastConvolutionFunction;
    private Size lastInputSize;
    private Size outputSize;
    private GlTextureInfo outputTexture;
    private boolean outputTextureInUse;
    private final float scaleHeight;
    private final float scaleWidth;
    private final boolean useHdr;
    private GlShaderProgram.InputListener inputListener = new GlShaderProgram.InputListener() { // from class: com.oplus.tbl.exoplayer2.effect.SeparableConvolutionShaderProgram.1
        @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram.InputListener
        public /* synthetic */ void onFlush() {
            bc2.a(this);
        }

        @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram.InputListener
        public /* synthetic */ void onInputFrameProcessed(GlTextureInfo glTextureInfo) {
            bc2.b(this, glTextureInfo);
        }

        @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram.InputListener
        public /* synthetic */ void onReadyToAcceptInputFrame() {
            bc2.c(this);
        }
    };
    private GlShaderProgram.OutputListener outputListener = new GlShaderProgram.OutputListener() { // from class: com.oplus.tbl.exoplayer2.effect.SeparableConvolutionShaderProgram.2
        @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram.OutputListener
        public /* synthetic */ void onCurrentOutputStreamEnded() {
            dc2.a(this);
        }

        @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram.OutputListener
        public /* synthetic */ void onOutputFrameAvailable(GlTextureInfo glTextureInfo, long j) {
            dc2.b(this, glTextureInfo, j);
        }
    };
    private GlShaderProgram.ErrorListener errorListener = new GlShaderProgram.ErrorListener() { // from class: v55
        @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram.ErrorListener
        public final void onError(VideoFrameProcessingException videoFrameProcessingException) {
            SeparableConvolutionShaderProgram.lambda$new$0(videoFrameProcessingException);
        }
    };
    private Executor errorListenerExecutor = er3.a();

    public SeparableConvolutionShaderProgram(Context context, boolean z, SeparableConvolution separableConvolution, float f, float f2) throws VideoFrameProcessingException {
        this.useHdr = z;
        this.convolution = separableConvolution;
        this.scaleWidth = f;
        this.scaleHeight = f2;
        GlTextureInfo glTextureInfo = GlTextureInfo.UNSET;
        this.functionLutTexture = glTextureInfo;
        this.intermediateTexture = glTextureInfo;
        this.outputTexture = glTextureInfo;
        Size size = Size.ZERO;
        this.lastInputSize = size;
        this.intermediateSize = size;
        this.outputSize = size;
        this.lastConvolutionFunction = null;
        try {
            this.glProgram = new GlProgram(context, VERTEX_SHADER_PATH, FRAGMENT_SHADER_PATH);
        } catch (GlUtil.GlException | IOException e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    private Size configure(Size size) {
        this.glProgram.setBufferAttribute("aFramePosition", GlUtil.getNormalizedCoordinateBounds(), 4);
        float[] fArrCreate4x4IdentityMatrix = GlUtil.create4x4IdentityMatrix();
        this.glProgram.setFloatsUniform("uTransformationMatrix", fArrCreate4x4IdentityMatrix);
        this.glProgram.setFloatsUniform("uTexTransformationMatrix", fArrCreate4x4IdentityMatrix);
        return new Size((int) (size.getWidth() * this.scaleWidth), (int) (size.getHeight() * this.scaleHeight));
    }

    private GlTextureInfo configurePixelTexture(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, Size size) throws GlUtil.GlException {
        if (size.getWidth() == glTextureInfo.width && size.getHeight() == glTextureInfo.height) {
            return glTextureInfo;
        }
        glTextureInfo.release();
        return glObjectsProvider.createBuffersForTexture(GlUtil.createTexture(size.getWidth(), size.getHeight(), this.useHdr), size.getWidth(), size.getHeight());
    }

    private void ensureTexturesAreConfigured(GlObjectsProvider glObjectsProvider, Size size, long j) throws GlUtil.GlException {
        ConvolutionFunction1D convolution = this.convolution.getConvolution(j);
        if (!convolution.equals(this.lastConvolutionFunction)) {
            updateFunctionTexture(glObjectsProvider, convolution);
            this.lastConvolutionFunction = convolution;
        }
        if (size.equals(this.lastInputSize)) {
            return;
        }
        this.outputSize = configure(size);
        Size size2 = new Size(this.outputSize.getWidth(), size.getHeight());
        this.intermediateSize = size2;
        this.intermediateTexture = configurePixelTexture(glObjectsProvider, this.intermediateTexture, size2);
        this.outputTexture = configurePixelTexture(glObjectsProvider, this.outputTexture, this.outputSize);
        this.lastInputSize = size;
    }

    private static short fp16FromFloat(float f) {
        int iFloatToRawIntBits = Float.floatToRawIntBits(f);
        int i = iFloatToRawIntBits >>> 31;
        int i2 = (iFloatToRawIntBits >>> 23) & 255;
        int i3 = iFloatToRawIntBits & FP32_SIGNIFICAND_MASK;
        int i4 = 31;
        int i5 = 0;
        if (i2 != 255) {
            int i6 = (i2 - 127) + 15;
            if (i6 < 31) {
                if (i6 <= 0) {
                    if (i6 >= -10) {
                        int i7 = i3 | 8388608;
                        int i8 = 14 - i6;
                        int i9 = i7 >>> i8;
                        if ((i7 & ((1 << i8) - 1)) + (i9 & 1) > (1 << (i8 - 1))) {
                            i9++;
                        }
                        i5 = i9;
                    }
                    i4 = 0;
                } else {
                    i5 = i3 >>> 13;
                    if ((i3 & 8191) + (i5 & 1) > 4096) {
                        i5++;
                    }
                    i4 = i6;
                }
            }
        } else if (i3 != 0) {
            i5 = 512;
        }
        return (short) ((i << 15) | ((i4 << 10) + i5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$queueInputFrame$1(GlUtil.GlException glException, long j) {
        this.errorListener.onError(VideoFrameProcessingException.from(glException, j));
    }

    private void renderHorizontal(GlTextureInfo glTextureInfo) throws GlUtil.GlException {
        GlTextureInfo glTextureInfo2 = this.intermediateTexture;
        GlUtil.focusFramebufferUsingCurrentContext(glTextureInfo2.fboId, glTextureInfo2.width, glTextureInfo2.height);
        GlUtil.clearFocusedBuffers();
        renderOnePass(glTextureInfo.texId, true);
    }

    private void renderOnePass(int i, boolean z) throws GlUtil.GlException {
        int width = z ? this.lastInputSize.getWidth() : this.intermediateSize.getHeight();
        this.glProgram.use();
        this.glProgram.setSamplerTexIdUniform("uTexSampler", i, 0);
        this.glProgram.setIntUniform("uIsHorizontal", z ? 1 : 0);
        float f = width;
        this.glProgram.setFloatUniform("uSourceTexelSize", 1.0f / f);
        this.glProgram.setFloatUniform("uSourceFullSize", f);
        this.glProgram.setFloatUniform("uConvStartTexels", this.functionLutDomainStart);
        this.glProgram.setFloatUniform("uConvWidthTexels", this.functionLutWidth);
        this.glProgram.setFloatUniform("uFunctionLookupStepSize", this.functionLutTexelStep);
        this.glProgram.setFloatsUniform("uFunctionLookupCenter", new float[]{this.functionLutCenterX, 0.5f});
        this.glProgram.setSamplerTexIdUniform("uFunctionLookupSampler", this.functionLutTexture.texId, 1);
        this.glProgram.bindAttributesAndUniforms();
        GLES20.glDrawArrays(5, 0, 4);
        GlUtil.checkGlError();
    }

    private void renderVertical() throws GlUtil.GlException {
        GlTextureInfo glTextureInfo = this.outputTexture;
        GlUtil.focusFramebufferUsingCurrentContext(glTextureInfo.fboId, glTextureInfo.width, glTextureInfo.height);
        GlUtil.clearFocusedBuffers();
        renderOnePass(this.intermediateTexture.texId, false);
    }

    private void updateFunctionTexture(GlObjectsProvider glObjectsProvider, ConvolutionFunction1D convolutionFunction1D) throws GlUtil.GlException {
        int iCeil = (int) Math.ceil((convolutionFunction1D.width() * 5.0f) + 10.0f);
        float f = iCeil;
        this.functionLutTexelStep = 1.0f / (f / 5.0f);
        ShortBuffer shortBufferAllocate = ShortBuffer.allocate(iCeil * 4);
        float fDomainStart = convolutionFunction1D.domainStart();
        int i = 0;
        int i2 = 0;
        while (i < iCeil) {
            int i3 = i - 5;
            short sFp16FromFloat = fp16FromFloat((i3 < 0 || i > iCeil + (-5)) ? 0.0f : convolutionFunction1D.value((i3 * 0.2f) + fDomainStart));
            int i4 = i2 + 1;
            shortBufferAllocate.put(i2, sFp16FromFloat);
            int i5 = i4 + 1;
            shortBufferAllocate.put(i4, sFp16FromFloat);
            int i6 = i5 + 1;
            shortBufferAllocate.put(i5, sFp16FromFloat);
            i2 = i6 + 1;
            shortBufferAllocate.put(i6, fp16FromFloat(1.0f));
            i++;
        }
        this.functionLutCenterX = (-(fDomainStart - 1.1f)) / (0.2f * f);
        this.functionLutDomainStart = convolutionFunction1D.domainStart();
        this.functionLutWidth = convolutionFunction1D.width();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iCeil, 1, Bitmap.Config.RGBA_F16);
        bitmapCreateBitmap.copyPixelsFromBuffer(shortBufferAllocate);
        GlTextureInfo glTextureInfo = this.functionLutTexture;
        if (glTextureInfo == GlTextureInfo.UNSET || glTextureInfo.width != iCeil) {
            glTextureInfo.release();
            this.functionLutTexture = glObjectsProvider.createBuffersForTexture(GlUtil.createTexture(iCeil, 1, true), iCeil, 1);
        }
        GLUtils.texImage2D(3553, 0, bitmapCreateBitmap, 0);
        GlUtil.checkGlError();
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public final void flush() {
        this.outputTextureInUse = false;
        this.inputListener.onFlush();
        this.inputListener.onReadyToAcceptInputFrame();
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public final void queueInputFrame(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, final long j) {
        Assertions.checkState(!this.outputTextureInUse, "The shader program does not currently accept input frames. Release prior output frames first.");
        try {
            ensureTexturesAreConfigured(glObjectsProvider, new Size(glTextureInfo.width, glTextureInfo.height), j);
            this.outputTextureInUse = true;
            renderHorizontal(glTextureInfo);
            renderVertical();
            onBlurRendered(glTextureInfo);
            GLES20.glDrawArrays(5, 0, 4);
            GlUtil.checkGlError();
            this.inputListener.onInputFrameProcessed(glTextureInfo);
            this.outputListener.onOutputFrameAvailable(this.outputTexture, j);
        } catch (GlUtil.GlException e) {
            this.errorListenerExecutor.execute(new Runnable() { // from class: t55
                @Override // java.lang.Runnable
                public final void run() {
                    this.f20907a.lambda$queueInputFrame$1(e, j);
                }
            });
        }
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    @CallSuper
    public void release() throws VideoFrameProcessingException {
        try {
            this.outputTexture.release();
            this.intermediateTexture.release();
            this.functionLutTexture.release();
            this.glProgram.delete();
        } catch (GlUtil.GlException e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public final void releaseOutputFrame(GlTextureInfo glTextureInfo) {
        this.outputTextureInUse = false;
        this.inputListener.onReadyToAcceptInputFrame();
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public final void setErrorListener(Executor executor, GlShaderProgram.ErrorListener errorListener) {
        this.errorListenerExecutor = executor;
        this.errorListener = errorListener;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public final void setInputListener(GlShaderProgram.InputListener inputListener) {
        this.inputListener = inputListener;
        if (this.outputTextureInUse) {
            return;
        }
        inputListener.onReadyToAcceptInputFrame();
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public final void setOutputListener(GlShaderProgram.OutputListener outputListener) {
        this.outputListener = outputListener;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram
    public final void signalEndOfCurrentInputStream() {
        this.outputListener.onCurrentOutputStreamEnded();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0(VideoFrameProcessingException videoFrameProcessingException) {
    }

    public void onBlurRendered(GlTextureInfo glTextureInfo) throws GlUtil.GlException {
    }
}
