package androidx.media3.effect;

import android.content.Context;
import android.util.SparseArray;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.FrameInfo;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.OnInputFrameProcessedListener;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.effect.GlShaderProgram;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class InputSwitcher {
    private TextureManager activeTextureManager;
    private final Context context;
    private GlShaderProgram downstreamShaderProgram;
    private final Executor errorListenerExecutor;
    private final boolean experimentalAdjustSurfaceTextureTransformationMatrix;
    private final GlObjectsProvider glObjectsProvider;
    private final SparseArray<Input> inputs;
    private final ColorInfo outputColorInfo;
    private final GlShaderProgram.ErrorListener samplingShaderProgramErrorListener;
    private final int sdrWorkingColorSpace;
    private final VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor;

    /* JADX INFO: compiled from: SearchBox */
    public static final class GatedChainingListenerWrapper implements GlShaderProgram.OutputListener, GlShaderProgram.InputListener {
        private final ChainingGlShaderProgramListener chainingGlShaderProgramListener;
        private boolean isActive;

        public GatedChainingListenerWrapper(GlObjectsProvider glObjectsProvider, GlShaderProgram glShaderProgram, GlShaderProgram glShaderProgram2, VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor) {
            this.chainingGlShaderProgramListener = new ChainingGlShaderProgramListener(glObjectsProvider, glShaderProgram, glShaderProgram2, videoFrameProcessingTaskExecutor);
        }

        @Override // androidx.media3.effect.GlShaderProgram.OutputListener
        public synchronized void onCurrentOutputStreamEnded() {
            if (this.isActive) {
                this.chainingGlShaderProgramListener.onCurrentOutputStreamEnded();
            }
        }

        @Override // androidx.media3.effect.GlShaderProgram.InputListener
        public synchronized void onFlush() {
            if (this.isActive) {
                this.chainingGlShaderProgramListener.onFlush();
            }
        }

        @Override // androidx.media3.effect.GlShaderProgram.InputListener
        public void onInputFrameProcessed(GlTextureInfo glTextureInfo) {
            if (this.isActive) {
                this.chainingGlShaderProgramListener.onInputFrameProcessed(glTextureInfo);
            }
        }

        @Override // androidx.media3.effect.GlShaderProgram.OutputListener
        public synchronized void onOutputFrameAvailable(GlTextureInfo glTextureInfo, long j) {
            if (this.isActive) {
                this.chainingGlShaderProgramListener.onOutputFrameAvailable(glTextureInfo, j);
            }
        }

        @Override // androidx.media3.effect.GlShaderProgram.InputListener
        public void onReadyToAcceptInputFrame() {
            if (this.isActive) {
                this.chainingGlShaderProgramListener.onReadyToAcceptInputFrame();
            }
        }

        public void setActive(boolean z) {
            this.isActive = z;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class Input {
        private GatedChainingListenerWrapper gatedChainingListenerWrapper;
        private boolean released;
        private ExternalShaderProgram samplingGlShaderProgram;
        public final TextureManager textureManager;

        public Input(TextureManager textureManager) {
            this.textureManager = textureManager;
        }

        @Nullable
        public ExternalShaderProgram getSamplingGlShaderProgram() {
            return this.samplingGlShaderProgram;
        }

        public void release() throws VideoFrameProcessingException {
            if (this.released) {
                return;
            }
            this.released = true;
            this.textureManager.release();
            ExternalShaderProgram externalShaderProgram = this.samplingGlShaderProgram;
            if (externalShaderProgram != null) {
                externalShaderProgram.release();
            }
        }

        public void setActive(boolean z) {
            GatedChainingListenerWrapper gatedChainingListenerWrapper = this.gatedChainingListenerWrapper;
            if (gatedChainingListenerWrapper == null) {
                return;
            }
            gatedChainingListenerWrapper.setActive(z);
        }

        public void setChainingListener(GatedChainingListenerWrapper gatedChainingListenerWrapper) {
            this.gatedChainingListenerWrapper = gatedChainingListenerWrapper;
            ((ExternalShaderProgram) Assertions.checkNotNull(this.samplingGlShaderProgram)).setOutputListener(gatedChainingListenerWrapper);
        }

        public void setSamplingGlShaderProgram(ExternalShaderProgram externalShaderProgram) throws VideoFrameProcessingException {
            ExternalShaderProgram externalShaderProgram2 = this.samplingGlShaderProgram;
            if (externalShaderProgram2 != null) {
                externalShaderProgram2.release();
            }
            this.samplingGlShaderProgram = externalShaderProgram;
            this.textureManager.setSamplingGlShaderProgram(externalShaderProgram);
            externalShaderProgram.setInputListener(this.textureManager);
        }
    }

    public InputSwitcher(Context context, ColorInfo colorInfo, GlObjectsProvider glObjectsProvider, VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor, Executor executor, GlShaderProgram.ErrorListener errorListener, int i, boolean z, boolean z2, boolean z3) throws VideoFrameProcessingException {
        this.context = context;
        this.outputColorInfo = colorInfo;
        this.glObjectsProvider = glObjectsProvider;
        this.videoFrameProcessingTaskExecutor = videoFrameProcessingTaskExecutor;
        this.errorListenerExecutor = executor;
        this.samplingShaderProgramErrorListener = errorListener;
        SparseArray<Input> sparseArray = new SparseArray<>();
        this.inputs = sparseArray;
        this.sdrWorkingColorSpace = i;
        this.experimentalAdjustSurfaceTextureTransformationMatrix = z2;
        Input input = new Input(new ExternalTextureManager(glObjectsProvider, videoFrameProcessingTaskExecutor, z, z2));
        sparseArray.put(1, input);
        sparseArray.put(4, input);
        sparseArray.put(2, new Input(new BitmapTextureManager(glObjectsProvider, videoFrameProcessingTaskExecutor, z3)));
        sparseArray.put(3, new Input(new TexIdTextureManager(glObjectsProvider, videoFrameProcessingTaskExecutor)));
    }

    private DefaultShaderProgram createSamplingShaderProgram(ColorInfo colorInfo, int i) throws VideoFrameProcessingException {
        DefaultShaderProgram defaultShaderProgramCreateWithExternalSampler;
        if (i == 1) {
            defaultShaderProgramCreateWithExternalSampler = DefaultShaderProgram.createWithExternalSampler(this.context, colorInfo, this.outputColorInfo, this.sdrWorkingColorSpace, this.experimentalAdjustSurfaceTextureTransformationMatrix);
        } else if (i == 2 || i == 3) {
            defaultShaderProgramCreateWithExternalSampler = DefaultShaderProgram.createWithInternalSampler(this.context, colorInfo, this.outputColorInfo, this.sdrWorkingColorSpace, i);
        } else {
            if (i != 4) {
                throw new VideoFrameProcessingException("Unsupported input type " + i);
            }
            defaultShaderProgramCreateWithExternalSampler = DefaultShaderProgram.createWithExternalSampler(this.context, colorInfo, this.outputColorInfo, this.sdrWorkingColorSpace, this.experimentalAdjustSurfaceTextureTransformationMatrix);
        }
        defaultShaderProgramCreateWithExternalSampler.setErrorListener(this.errorListenerExecutor, this.samplingShaderProgramErrorListener);
        return defaultShaderProgramCreateWithExternalSampler;
    }

    public TextureManager activeTextureManager() {
        return (TextureManager) Assertions.checkStateNotNull(this.activeTextureManager);
    }

    public Surface getInputSurface() {
        Assertions.checkState(Util.contains(this.inputs, 1));
        return this.inputs.get(1).textureManager.getInputSurface();
    }

    public boolean hasActiveInput() {
        return this.activeTextureManager != null;
    }

    public void release() throws VideoFrameProcessingException {
        for (int i = 0; i < this.inputs.size(); i++) {
            SparseArray<Input> sparseArray = this.inputs;
            sparseArray.get(sparseArray.keyAt(i)).release();
        }
    }

    public void setDownstreamShaderProgram(GlShaderProgram glShaderProgram) {
        this.downstreamShaderProgram = glShaderProgram;
    }

    public void setInputDefaultBufferSize(int i, int i2) {
        Assertions.checkState(Util.contains(this.inputs, 1));
        this.inputs.get(1).textureManager.setDefaultBufferSize(i, i2);
    }

    public void setOnInputFrameProcessedListener(OnInputFrameProcessedListener onInputFrameProcessedListener) {
        Assertions.checkState(Util.contains(this.inputs, 3));
        this.inputs.get(3).textureManager.setOnInputFrameProcessedListener(onInputFrameProcessedListener);
    }

    public void signalEndOfCurrentInputStream() {
        ((TextureManager) Assertions.checkNotNull(this.activeTextureManager)).signalEndOfCurrentInputStream();
    }

    public void switchToInput(int i, FrameInfo frameInfo) throws VideoFrameProcessingException {
        Assertions.checkStateNotNull(this.downstreamShaderProgram);
        Assertions.checkState(Util.contains(this.inputs, i), "Input type not registered: " + i);
        for (int i2 = 0; i2 < this.inputs.size(); i2++) {
            SparseArray<Input> sparseArray = this.inputs;
            sparseArray.get(sparseArray.keyAt(i2)).setActive(false);
        }
        Input input = this.inputs.get(i);
        input.setSamplingGlShaderProgram(createSamplingShaderProgram((ColorInfo) Assertions.checkNotNull(frameInfo.format.colorInfo), i));
        input.setChainingListener(new GatedChainingListenerWrapper(this.glObjectsProvider, (GlShaderProgram) Assertions.checkNotNull(input.getSamplingGlShaderProgram()), this.downstreamShaderProgram, this.videoFrameProcessingTaskExecutor));
        input.setActive(true);
        this.downstreamShaderProgram.setInputListener((GlShaderProgram.InputListener) Assertions.checkNotNull(input.gatedChainingListenerWrapper));
        TextureManager textureManager = input.textureManager;
        this.activeTextureManager = textureManager;
        ((TextureManager) Assertions.checkNotNull(textureManager)).setInputFrameInfo(frameInfo, i == 4);
    }
}
