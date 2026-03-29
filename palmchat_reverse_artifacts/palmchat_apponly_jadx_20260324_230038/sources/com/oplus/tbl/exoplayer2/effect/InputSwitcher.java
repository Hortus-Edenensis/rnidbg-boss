package com.oplus.tbl.exoplayer2.effect;

import android.content.Context;
import android.util.SparseArray;
import android.view.Surface;
import androidx.annotation.OptIn;
import com.oplus.tbl.exoplayer2.ColorInfo;
import com.oplus.tbl.exoplayer2.FrameInfo;
import com.oplus.tbl.exoplayer2.GlObjectsProvider;
import com.oplus.tbl.exoplayer2.GlTextureInfo;
import com.oplus.tbl.exoplayer2.OnInputFrameProcessedListener;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.effect.GlShaderProgram;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import com.oplus.tbl.exoplayer2.util.Util;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class InputSwitcher {
    private TextureManager activeTextureManager;
    private final Context context;
    private GlShaderProgram downstreamShaderProgram;
    private final Executor errorListenerExecutor;
    private final GlObjectsProvider glObjectsProvider;
    private final SparseArray<Input> inputs;
    private final ColorInfo outputColorInfo;
    private final GlShaderProgram.ErrorListener samplingShaderProgramErrorListener;
    private final int sdrWorkingColorSpace;
    private final VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor;

    /* JADX INFO: compiled from: SearchBox */
    @UnstableApi
    public static final class GatedChainingListenerWrapper implements GlShaderProgram.InputListener, GlShaderProgram.OutputListener {
        private final ChainingGlShaderProgramListener chainingGlShaderProgramListener;
        private boolean isActive;

        @OptIn(markerClass = {UnstableApi.class})
        public GatedChainingListenerWrapper(GlObjectsProvider glObjectsProvider, GlShaderProgram glShaderProgram, GlShaderProgram glShaderProgram2, VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor) {
            this.chainingGlShaderProgramListener = new ChainingGlShaderProgramListener(glObjectsProvider, glShaderProgram, glShaderProgram2, videoFrameProcessingTaskExecutor);
        }

        @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram.OutputListener
        public synchronized void onCurrentOutputStreamEnded() {
            if (this.isActive) {
                this.chainingGlShaderProgramListener.onCurrentOutputStreamEnded();
            }
        }

        @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram.InputListener
        public synchronized void onFlush() {
            if (this.isActive) {
                this.chainingGlShaderProgramListener.onFlush();
            }
        }

        @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram.InputListener
        @OptIn(markerClass = {UnstableApi.class})
        public void onInputFrameProcessed(GlTextureInfo glTextureInfo) {
            if (this.isActive) {
                this.chainingGlShaderProgramListener.onInputFrameProcessed(glTextureInfo);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram.OutputListener
        public synchronized void onOutputFrameAvailable(GlTextureInfo glTextureInfo, long j) {
            if (this.isActive) {
                this.chainingGlShaderProgramListener.onOutputFrameAvailable(glTextureInfo, j);
            }
        }

        @Override // com.oplus.tbl.exoplayer2.effect.GlShaderProgram.InputListener
        @OptIn(markerClass = {UnstableApi.class})
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
        private ColorInfo inputColorInfo;
        private ExternalShaderProgram samplingGlShaderProgram;
        public final TextureManager textureManager;

        public Input(TextureManager textureManager) {
            this.textureManager = textureManager;
        }

        public ColorInfo getInputColorInfo() {
            return this.inputColorInfo;
        }

        public ExternalShaderProgram getSamplingGlShaderProgram() {
            return this.samplingGlShaderProgram;
        }

        @OptIn(markerClass = {UnstableApi.class})
        public void release() throws VideoFrameProcessingException {
            this.textureManager.release();
            ExternalShaderProgram externalShaderProgram = this.samplingGlShaderProgram;
            if (externalShaderProgram != null) {
                externalShaderProgram.release();
            }
        }

        @OptIn(markerClass = {UnstableApi.class})
        public void setActive(boolean z) {
            GatedChainingListenerWrapper gatedChainingListenerWrapper = this.gatedChainingListenerWrapper;
            if (gatedChainingListenerWrapper == null) {
                return;
            }
            gatedChainingListenerWrapper.setActive(z);
        }

        @OptIn(markerClass = {UnstableApi.class})
        public void setChainingListener(GatedChainingListenerWrapper gatedChainingListenerWrapper) {
            this.gatedChainingListenerWrapper = gatedChainingListenerWrapper;
            ((ExternalShaderProgram) Assertions.checkNotNull(this.samplingGlShaderProgram)).setOutputListener(gatedChainingListenerWrapper);
        }

        public void setInputColorInfo(ColorInfo colorInfo) {
            this.inputColorInfo = colorInfo;
        }

        @OptIn(markerClass = {UnstableApi.class})
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

    @OptIn(markerClass = {UnstableApi.class})
    public InputSwitcher(Context context, ColorInfo colorInfo, GlObjectsProvider glObjectsProvider, VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor, Executor executor, GlShaderProgram.ErrorListener errorListener, int i) throws VideoFrameProcessingException {
        this.context = context;
        this.outputColorInfo = colorInfo;
        this.glObjectsProvider = glObjectsProvider;
        this.videoFrameProcessingTaskExecutor = videoFrameProcessingTaskExecutor;
        this.errorListenerExecutor = executor;
        this.samplingShaderProgramErrorListener = errorListener;
        SparseArray<Input> sparseArray = new SparseArray<>();
        this.inputs = sparseArray;
        this.sdrWorkingColorSpace = i;
        sparseArray.put(1, new Input(new ExternalTextureManager(glObjectsProvider, videoFrameProcessingTaskExecutor)));
        sparseArray.put(2, new Input(new BitmapTextureManager(glObjectsProvider, videoFrameProcessingTaskExecutor)));
        sparseArray.put(3, new Input(new TexIdTextureManager(glObjectsProvider, videoFrameProcessingTaskExecutor)));
    }

    @OptIn(markerClass = {UnstableApi.class})
    private DefaultShaderProgram createSamplingShaderProgram(ColorInfo colorInfo, int i) throws VideoFrameProcessingException {
        DefaultShaderProgram defaultShaderProgramCreateWithExternalSampler;
        if (i != 1) {
            if (i == 2) {
                Assertions.checkState(!ColorInfo.isTransferHdr(colorInfo));
                colorInfo = ColorInfo.SRGB_BT709_FULL;
            } else {
                if (i != 3) {
                    throw new VideoFrameProcessingException("Unsupported input type " + i);
                }
                Assertions.checkState(colorInfo.colorTransfer != 2);
            }
            defaultShaderProgramCreateWithExternalSampler = DefaultShaderProgram.createWithInternalSampler(this.context, colorInfo, this.outputColorInfo, this.sdrWorkingColorSpace, i);
        } else {
            defaultShaderProgramCreateWithExternalSampler = DefaultShaderProgram.createWithExternalSampler(this.context, colorInfo, this.outputColorInfo, this.sdrWorkingColorSpace);
        }
        defaultShaderProgramCreateWithExternalSampler.setErrorListener(this.errorListenerExecutor, this.samplingShaderProgramErrorListener);
        return defaultShaderProgramCreateWithExternalSampler;
    }

    public TextureManager activeTextureManager() {
        return (TextureManager) Assertions.checkStateNotNull(this.activeTextureManager);
    }

    @OptIn(markerClass = {UnstableApi.class})
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

    @OptIn(markerClass = {UnstableApi.class})
    public void setInputDefaultBufferSize(int i, int i2) {
        Assertions.checkState(Util.contains(this.inputs, 1));
        this.inputs.get(1).textureManager.setDefaultBufferSize(i, i2);
    }

    @OptIn(markerClass = {UnstableApi.class})
    public void setOnInputFrameProcessedListener(OnInputFrameProcessedListener onInputFrameProcessedListener) {
        Assertions.checkState(Util.contains(this.inputs, 3));
        this.inputs.get(3).textureManager.setOnInputFrameProcessedListener(onInputFrameProcessedListener);
    }

    public void signalEndOfInputStream() {
        ((TextureManager) Assertions.checkNotNull(this.activeTextureManager)).signalEndOfCurrentInputStream();
    }

    @OptIn(markerClass = {UnstableApi.class})
    public void switchToInput(int i, FrameInfo frameInfo) throws VideoFrameProcessingException {
        Assertions.checkStateNotNull(this.downstreamShaderProgram);
        Assertions.checkState(Util.contains(this.inputs, i), "Input type not registered: " + i);
        for (int i2 = 0; i2 < this.inputs.size(); i2++) {
            int iKeyAt = this.inputs.keyAt(i2);
            Input input = this.inputs.get(iKeyAt);
            if (iKeyAt == i) {
                if (input.getInputColorInfo() == null || !frameInfo.colorInfo.equals(input.getInputColorInfo())) {
                    input.setSamplingGlShaderProgram(createSamplingShaderProgram(frameInfo.colorInfo, i));
                    input.setInputColorInfo(frameInfo.colorInfo);
                }
                input.setChainingListener(new GatedChainingListenerWrapper(this.glObjectsProvider, (GlShaderProgram) Assertions.checkNotNull(input.getSamplingGlShaderProgram()), this.downstreamShaderProgram, this.videoFrameProcessingTaskExecutor));
                input.setActive(true);
                this.downstreamShaderProgram.setInputListener((GlShaderProgram.InputListener) Assertions.checkNotNull(input.gatedChainingListenerWrapper));
                this.activeTextureManager = input.textureManager;
            } else {
                input.setActive(false);
            }
        }
        ((TextureManager) Assertions.checkNotNull(this.activeTextureManager)).setInputFrameInfo(frameInfo);
    }
}
