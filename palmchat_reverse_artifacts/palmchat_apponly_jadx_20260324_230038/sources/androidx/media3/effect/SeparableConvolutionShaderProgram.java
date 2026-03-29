package androidx.media3.effect;

import android.content.Context;
import android.opengl.GLES20;
import androidx.annotation.CallSuper;
import androidx.media3.common.C;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlProgram;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.effect.ConvolutionFunction1D;
import androidx.media3.effect.GlShaderProgram;
import androidx.media3.effect.SeparableConvolutionShaderProgram;
import defpackage.cc2;
import defpackage.ec2;
import defpackage.er3;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public class SeparableConvolutionShaderProgram implements GlShaderProgram {
    private static final String FRAGMENT_SHADER_PATH = "shaders/fragment_shader_separable_convolution_es2.glsl";
    private static final int FUNCTION_LUT_PADDING = 5;
    private static final int RASTER_SAMPLES_PER_TEXEL = 5;
    private static final String VERTEX_SHADER_PATH = "shaders/vertex_shader_transformation_es2.glsl";
    private final ConvolutionFunction1D.Provider convolutionFunction1DProvider;
    private GlShaderProgram.ErrorListener errorListener;
    private Executor errorListenerExecutor;
    private float functionLutCenterX;
    private float functionLutDomainStart;
    private float functionLutTexelStep;
    private GlTextureInfo functionLutTexture;
    private float functionLutWidth;
    private final GlProgram glProgram;
    private GlShaderProgram.InputListener inputListener;
    private Size intermediateSize;
    private GlTextureInfo intermediateTexture;
    private ConvolutionFunction1D lastConvolutionFunction;
    private Size lastInputSize;
    private GlShaderProgram.OutputListener outputListener;
    private Size outputSize;
    private GlTextureInfo outputTexture;
    private boolean outputTextureInUse;
    private final boolean useHdr;

    /* JADX INFO: compiled from: SearchBox */
    public static final class SeparableConvolutionWrapper implements ConvolutionFunction1D.Provider {
        private final float scaleHeight;
        private final float scaleWidth;
        private final SeparableConvolution separableConvolution;

        public SeparableConvolutionWrapper(SeparableConvolution separableConvolution, float f, float f2) {
            this.separableConvolution = separableConvolution;
            this.scaleWidth = f;
            this.scaleHeight = f2;
        }

        @Override // androidx.media3.effect.ConvolutionFunction1D.Provider
        public Size configure(Size size) {
            return new Size((int) (size.getWidth() * this.scaleWidth), (int) (size.getHeight() * this.scaleHeight));
        }

        @Override // androidx.media3.effect.ConvolutionFunction1D.Provider
        public ConvolutionFunction1D getConvolution(long j) {
            return this.separableConvolution.getConvolution(j);
        }
    }

    public SeparableConvolutionShaderProgram(Context context, boolean z, SeparableConvolution separableConvolution, float f, float f2) throws VideoFrameProcessingException {
        this(context, z, new SeparableConvolutionWrapper(separableConvolution, f, f2));
    }

    private GlTextureInfo configurePixelTexture(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, Size size) throws GlUtil.GlException {
        if (size.getWidth() == glTextureInfo.width && size.getHeight() == glTextureInfo.height) {
            return glTextureInfo;
        }
        glTextureInfo.release();
        return glObjectsProvider.createBuffersForTexture(GlUtil.createTexture(size.getWidth(), size.getHeight(), this.useHdr), size.getWidth(), size.getHeight());
    }

    private void ensureTexturesAreConfigured(GlObjectsProvider glObjectsProvider, Size size, long j) throws GlUtil.GlException {
        this.outputSize = this.convolutionFunction1DProvider.configure(size);
        ConvolutionFunction1D convolution = this.convolutionFunction1DProvider.getConvolution(j);
        if (!convolution.equals(this.lastConvolutionFunction)) {
            updateFunctionTexture(convolution);
            this.lastConvolutionFunction = convolution;
        }
        if (size.equals(this.lastInputSize)) {
            return;
        }
        this.glProgram.setBufferAttribute("aFramePosition", GlUtil.getNormalizedCoordinateBounds(), 4);
        float[] fArrCreate4x4IdentityMatrix = GlUtil.create4x4IdentityMatrix();
        this.glProgram.setFloatsUniform("uTransformationMatrix", fArrCreate4x4IdentityMatrix);
        this.glProgram.setFloatsUniform("uTexTransformationMatrix", fArrCreate4x4IdentityMatrix);
        Size size2 = new Size(this.outputSize.getWidth(), size.getHeight());
        this.intermediateSize = size2;
        this.intermediateTexture = configurePixelTexture(glObjectsProvider, this.intermediateTexture, size2);
        this.outputTexture = configurePixelTexture(glObjectsProvider, this.outputTexture, this.outputSize);
        this.lastInputSize = size;
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

    private void updateFunctionTexture(ConvolutionFunction1D convolutionFunction1D) throws GlUtil.GlException {
        int iCeil = (int) Math.ceil((convolutionFunction1D.width() * 5.0f) + 10.0f);
        float f = iCeil;
        this.functionLutTexelStep = 1.0f / (f / 5.0f);
        FloatBuffer floatBufferAllocate = FloatBuffer.allocate(iCeil);
        float fDomainStart = convolutionFunction1D.domainStart();
        int i = 0;
        int i2 = 0;
        while (i < iCeil) {
            int i3 = i - 5;
            floatBufferAllocate.put(i2, (i3 < 0 || i > iCeil + (-5)) ? 0.0f : convolutionFunction1D.value((i3 * 0.2f) + fDomainStart));
            i++;
            i2++;
        }
        this.functionLutCenterX = (-(fDomainStart - 1.1f)) / (0.2f * f);
        this.functionLutDomainStart = convolutionFunction1D.domainStart();
        this.functionLutWidth = convolutionFunction1D.width();
        GlTextureInfo glTextureInfo = this.functionLutTexture;
        if (glTextureInfo == GlTextureInfo.UNSET || glTextureInfo.width != iCeil) {
            glTextureInfo.release();
            this.functionLutTexture = new GlTextureInfo(GlUtil.generateTexture(), -1, -1, iCeil, 1);
        }
        GlUtil.bindTexture(3553, this.functionLutTexture.texId, C.TEXTURE_MIN_FILTER_LINEAR);
        GLES20.glTexImage2D(3553, 0, 33325, iCeil, 1, 0, 6403, 5126, floatBufferAllocate);
        GlUtil.checkGlError();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public final void flush() {
        this.outputTextureInUse = false;
        this.inputListener.onFlush();
        this.inputListener.onReadyToAcceptInputFrame();
    }

    @Override // androidx.media3.effect.GlShaderProgram
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
            this.errorListenerExecutor.execute(new Runnable() { // from class: u55
                @Override // java.lang.Runnable
                public final void run() {
                    this.f21140a.lambda$queueInputFrame$1(e, j);
                }
            });
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
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

    @Override // androidx.media3.effect.GlShaderProgram
    public final void releaseOutputFrame(GlTextureInfo glTextureInfo) {
        this.outputTextureInUse = false;
        this.inputListener.onReadyToAcceptInputFrame();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public final void setErrorListener(Executor executor, GlShaderProgram.ErrorListener errorListener) {
        this.errorListenerExecutor = executor;
        this.errorListener = errorListener;
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public final void setInputListener(GlShaderProgram.InputListener inputListener) {
        this.inputListener = inputListener;
        if (this.outputTextureInUse) {
            return;
        }
        inputListener.onReadyToAcceptInputFrame();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public final void setOutputListener(GlShaderProgram.OutputListener outputListener) {
        this.outputListener = outputListener;
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public final void signalEndOfCurrentInputStream() {
        this.outputListener.onCurrentOutputStreamEnded();
    }

    public SeparableConvolutionShaderProgram(Context context, boolean z, ConvolutionFunction1D.Provider provider) throws VideoFrameProcessingException {
        this.useHdr = z;
        this.convolutionFunction1DProvider = provider;
        this.inputListener = new GlShaderProgram.InputListener() { // from class: androidx.media3.effect.SeparableConvolutionShaderProgram.1
            @Override // androidx.media3.effect.GlShaderProgram.InputListener
            public /* synthetic */ void onFlush() {
                cc2.a(this);
            }

            @Override // androidx.media3.effect.GlShaderProgram.InputListener
            public /* synthetic */ void onInputFrameProcessed(GlTextureInfo glTextureInfo) {
                cc2.b(this, glTextureInfo);
            }

            @Override // androidx.media3.effect.GlShaderProgram.InputListener
            public /* synthetic */ void onReadyToAcceptInputFrame() {
                cc2.c(this);
            }
        };
        this.outputListener = new GlShaderProgram.OutputListener() { // from class: androidx.media3.effect.SeparableConvolutionShaderProgram.2
            @Override // androidx.media3.effect.GlShaderProgram.OutputListener
            public /* synthetic */ void onCurrentOutputStreamEnded() {
                ec2.a(this);
            }

            @Override // androidx.media3.effect.GlShaderProgram.OutputListener
            public /* synthetic */ void onOutputFrameAvailable(GlTextureInfo glTextureInfo, long j) {
                ec2.b(this, glTextureInfo, j);
            }
        };
        this.errorListener = new GlShaderProgram.ErrorListener() { // from class: w55
            @Override // androidx.media3.effect.GlShaderProgram.ErrorListener
            public final void onError(VideoFrameProcessingException videoFrameProcessingException) {
                SeparableConvolutionShaderProgram.lambda$new$0(videoFrameProcessingException);
            }
        };
        this.errorListenerExecutor = er3.a();
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

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0(VideoFrameProcessingException videoFrameProcessingException) {
    }

    public void onBlurRendered(GlTextureInfo glTextureInfo) throws GlUtil.GlException {
    }
}
