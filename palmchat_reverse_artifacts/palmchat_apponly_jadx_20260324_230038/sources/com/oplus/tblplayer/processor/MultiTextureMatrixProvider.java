package com.oplus.tblplayer.processor;

import android.graphics.Matrix;
import android.util.Pair;
import androidx.media3.exoplayer.MediaPeriodQueue;
import com.oplus.tbl.exoplayer2.util.Util;
import com.oplus.tblplayer.processor.HomoMatrixTransformation;
import com.oplus.tblplayer.utils.AssertUtil;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class MultiTextureMatrixProvider implements HomoMatrixTransformation.SamplerTextureMatrixProvider {
    private static final long DEFAULT_TIME_DIFFERENCE_US = 5000;
    private final long mExoPresentationTimeOffsetUs = MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US;
    private final long mFirstTimestamp;
    private final boolean mIsAscending;
    private final long mLastTimestamp;
    private final List<Pair<Long, float[]>> mTextureMatrixList;

    public MultiTextureMatrixProvider(List<Pair<Long, float[]>> list) {
        long jLongValue;
        this.mTextureMatrixList = list;
        if (list == null || list.isEmpty()) {
            this.mIsAscending = true;
            jLongValue = -9223372036854775807L;
            this.mFirstTimestamp = -9223372036854775807L;
        } else {
            Pair pair = (Pair) Util.castNonNull(list.get(0));
            Pair pair2 = (Pair) Util.castNonNull(list.get(list.size() - 1));
            boolean z = ((Long) pair.first).longValue() <= ((Long) pair2.first).longValue();
            this.mIsAscending = z;
            this.mFirstTimestamp = ((Long) (z ? pair.first : pair2.first)).longValue();
            jLongValue = ((Long) (z ? pair2.first : pair.first)).longValue();
        }
        this.mLastTimestamp = jLongValue;
    }

    public Pair<Long, float[]> findPair(long j) {
        List<Pair<Long, float[]>> list = this.mTextureMatrixList;
        if (list != null && !list.isEmpty()) {
            long j2 = this.mFirstTimestamp;
            if (j2 != -9223372036854775807L) {
                long j3 = this.mLastTimestamp;
                if (j3 != -9223372036854775807L && j >= j2 - 5000 && j <= j3 + 5000) {
                    if (this.mIsAscending) {
                        for (Pair<Long, float[]> pair : this.mTextureMatrixList) {
                            if (Math.abs(((Long) pair.first).longValue() - j) <= 5000) {
                                return pair;
                            }
                        }
                    } else {
                        for (int size = this.mTextureMatrixList.size() - 1; size >= 0; size--) {
                            Pair<Long, float[]> pair2 = this.mTextureMatrixList.get(size);
                            if (Math.abs(((Long) pair2.first).longValue() - j) <= 5000) {
                                return pair2;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public long getFirstTimestamp() {
        return this.mFirstTimestamp;
    }

    public long getLastTimestamp() {
        return this.mLastTimestamp;
    }

    @Override // com.oplus.tblplayer.processor.HomoMatrixTransformation.SamplerTextureMatrixProvider
    public Matrix getMatrix(long j) {
        if (j > MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US) {
            j -= MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US;
        }
        Pair pair = (Pair) AssertUtil.checkNotNull(findPair(j));
        if (pair == null) {
            return null;
        }
        float[] fArr = (float[]) pair.second;
        Matrix matrix = new Matrix();
        matrix.setValues(fArr);
        return matrix;
    }

    public boolean shouldApplyTextureMatrix(long j) {
        return findPair(j) != null;
    }
}
