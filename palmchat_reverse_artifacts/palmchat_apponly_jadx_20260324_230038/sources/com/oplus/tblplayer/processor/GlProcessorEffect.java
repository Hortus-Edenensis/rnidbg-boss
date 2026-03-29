package com.oplus.tblplayer.processor;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.ColorInfo;
import com.oplus.tbl.exoplayer2.GlTextureInfo;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.effect.GlEffect;
import com.oplus.tbl.exoplayer2.effect.GlShaderProgram;
import com.oplus.tbl.exoplayer2.util.Size;
import defpackage.yb2;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class GlProcessorEffect implements GlEffect {
    private final Processor processor;

    /* JADX INFO: compiled from: SearchBox */
    public static class GlFrameInfo {

        @Nullable
        private final ColorInfo colorInfo;

        @NonNull
        private final GlTextureInfo textureInfo;

        public GlFrameInfo(@NonNull GlTextureInfo glTextureInfo, @Nullable ColorInfo colorInfo) {
            this.textureInfo = glTextureInfo;
            this.colorInfo = colorInfo;
        }

        @Nullable
        public ColorInfo getColorInfo() {
            return this.colorInfo;
        }

        public int getFrameBufferId() {
            return this.textureInfo.fboId;
        }

        public int getTextureHeight() {
            return this.textureInfo.height;
        }

        public int getTextureId() {
            return this.textureInfo.texId;
        }

        public int getTextureWidth() {
            return this.textureInfo.width;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface Processor {
        Size configureSize(int i, int i2) throws Exception;

        void configureWorkingColorInfo(ColorInfo colorInfo, ColorInfo colorInfo2) throws Exception;

        void init(Context context, boolean z) throws Exception;

        boolean isColorComponentsSupported(boolean z);

        void processTexture(GlFrameInfo glFrameInfo, GlFrameInfo glFrameInfo2, long j) throws Exception;

        @Deprecated
        void processTexture(List<GlFrameInfo> list, GlFrameInfo glFrameInfo, long j) throws Exception;

        void release() throws Exception;
    }

    public GlProcessorEffect(Processor processor) {
        this.processor = processor;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlEffect
    public /* synthetic */ boolean isNoOp(int i, int i2) {
        return yb2.a(this, i, i2);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlEffect
    @NonNull
    public GlShaderProgram toGlShaderProgram(@NonNull Context context, boolean z) throws VideoFrameProcessingException {
        return new GlProcessorShaderProgram(context, z, this.processor);
    }
}
