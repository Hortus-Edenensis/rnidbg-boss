package com.oplus.tblplayer.ffmpeg;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class PCMConvertor {
    private long context;
    private final int inPcmEncoding;
    private ByteBuffer outBuffer;
    private final int outPcmEncoding = 2;

    public PCMConvertor(int i) {
        this.inPcmEncoding = i;
        this.context = pcmCreateContext(getSampleSize(i), getSampleSize(2));
    }

    public static int getSampleSize(int i) {
        if (i == 2) {
            return 2;
        }
        if (i == 3) {
            return 1;
        }
        if (i != 4) {
            if (i == 536870912) {
                return 3;
            }
            if (i != 805306368) {
                return 0;
            }
        }
        return 4;
    }

    public ByteBuffer convert(ByteBuffer byteBuffer) {
        int i = this.inPcmEncoding;
        if (i == this.outPcmEncoding) {
            return byteBuffer;
        }
        int sampleSize = getSampleSize(i);
        int iLimit = ((byteBuffer.limit() - byteBuffer.position()) / sampleSize) * getSampleSize(this.outPcmEncoding);
        ByteBuffer byteBuffer2 = this.outBuffer;
        if (byteBuffer2 == null || byteBuffer2.limit() < iLimit) {
            this.outBuffer = ByteBuffer.allocateDirect(iLimit).order(ByteOrder.nativeOrder());
        }
        int iPosition = byteBuffer.position();
        int iPcmConvert = pcmConvert(this.context, byteBuffer, byteBuffer.limit(), this.outBuffer, iLimit);
        byteBuffer.position(iPosition);
        this.outBuffer.limit(iPcmConvert);
        return this.outBuffer;
    }

    public void finalize() throws Throwable {
        super.finalize();
        pcmDestroyContext(this.context);
    }

    public int getInPcmEncoding() {
        return this.inPcmEncoding;
    }

    public int getOutPcmEncoding() {
        return this.outPcmEncoding;
    }

    public int getOutSampleSize() {
        return getSampleSize(this.outPcmEncoding);
    }

    public native int pcmConvert(long j, ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2);

    public native long pcmCreateContext(int i, int i2);

    public native void pcmDestroyContext(long j);
}
