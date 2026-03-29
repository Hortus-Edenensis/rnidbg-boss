package com.oplus.tblplayer.managers;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.oplus.tblplayer.Constants;
import com.oplus.tblplayer.IMediaPlayer;
import com.oplus.tblplayer.utils.CommonUtil;
import com.oplus.tblplayer.utils.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class SlowMotionManager {
    public static int INVALID_FPS = -1;
    private static final int SLOW_MOTION_INTERNAL_MS = 10;
    private static final int SLOW_MOTION_STATUS_NEED_STOP = 1;
    private static final int SLOW_MOTION_STATUS_RUNNING = 0;
    private static final int SLOW_MOTION_STATUS_STOPPED = 2;
    private static final String TAG = "SlowMotionManager";
    private IMediaPlayer player;
    private long realDuration;
    private float realFps;
    private long slowDuration;
    private int slowFps;
    private float timesOfSlows;
    private SlowMotionInfo[] slowIfs = new SlowMotionInfo[2];
    private int slowInfoLen = 0;
    private boolean isHsr = false;
    private boolean isSlow = false;
    private int status = 2;
    private Handler handler = new Handler(getLooper());
    private Runnable updatePlaybackRateAction = new Runnable() { // from class: df5
        @Override // java.lang.Runnable
        public final void run() {
            this.f17039a.updatePlaybackRateTask();
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public static class SlowMotionInfo {
        private long end;
        private long slowEnd;
        private long slowStart;
        private long start;

        public SlowMotionInfo() {
        }

        public SlowMotionInfo(long j, long j2, long j3, float f) {
            this.start = j;
            this.end = j2;
            long j4 = j3 + j;
            this.slowStart = j4;
            this.slowEnd = (long) (j4 + ((j2 - j) * f));
        }

        public long getDiff(long j, boolean z) {
            if (!z) {
                long j2 = this.slowStart;
                if (j < j2) {
                    return 0L;
                }
                return (j <= j2 || j > this.slowEnd) ? this.slowEnd - j2 : j - j2;
            }
            long j3 = this.start;
            if (j <= j3) {
                return 0L;
            }
            long j4 = this.end;
            return j <= j4 ? j - j3 : j4 - j3;
        }

        public long getEnd() {
            return this.end;
        }

        public long getSlowEnd() {
            return this.slowEnd;
        }

        public long getSlowStart() {
            return this.slowStart;
        }

        public long getStart() {
            return this.start;
        }

        public boolean isInside(long j, boolean z) {
            return z ? j >= this.start && j < this.end : j >= this.slowStart && j < this.slowEnd;
        }
    }

    public SlowMotionManager(IMediaPlayer iMediaPlayer, int i, float f) {
        this.slowFps = i;
        this.realFps = f;
        this.player = iMediaPlayer;
    }

    public static SlowMotionManager create(Context context, IMediaPlayer iMediaPlayer, String str, float f, int i, long j) {
        if (CommonUtil.isSlowMotionHsr(str) && i > 0 && j > 0) {
            SlowMotionManager slowMotionManager = new SlowMotionManager(iMediaPlayer, i, f);
            if (slowMotionManager.parseHsrInfo(str, j)) {
                return slowMotionManager;
            }
            return null;
        }
        LogUtil.e(TAG, "title = " + str + ", realFps = " + f + ", duration = " + j);
        return null;
    }

    private boolean needToSlow(long j, boolean z) {
        for (int i = 0; i < this.slowInfoLen; i++) {
            if (this.slowIfs[i].isInside(j, z)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlaybackRateTask() {
        if (this.status == 2) {
            LogUtil.d(TAG, "need to stop slow");
            this.player.setVolume(1.0f);
            this.player.setPlaybackRate(1.0f);
            return;
        }
        long currentPosition = this.player.getCurrentPosition();
        if (!this.isSlow && needToSlow(currentPosition, false)) {
            LogUtil.d(TAG, "need to slow, pos: " + currentPosition);
            this.player.setVolume(0.0f);
            this.player.setPlaybackRate(1.0f / this.timesOfSlows);
            this.isSlow = true;
        } else if (this.isSlow && !needToSlow(currentPosition, false)) {
            LogUtil.d(TAG, "need to real, pos: " + currentPosition);
            this.player.setVolume(1.0f);
            this.player.setPlaybackRate(1.0f);
            this.isSlow = false;
        }
        this.handler.postDelayed(this.updatePlaybackRateAction, 10L);
    }

    public long adaptPosition(long j, boolean z) {
        long j2;
        if (!this.isHsr) {
            return j;
        }
        if (z && j >= this.slowDuration) {
            return this.realDuration;
        }
        if (!z && j >= this.realDuration) {
            return this.slowDuration;
        }
        long diff = 0;
        for (int i = 0; i < this.slowInfoLen; i++) {
            diff += this.slowIfs[i].getDiff(j, !z);
        }
        float f = j;
        float f2 = diff;
        if (z) {
            long j3 = (long) (f - (f2 * (1.0f - (1.0f / this.timesOfSlows))));
            j2 = this.realDuration;
            if (j3 < j2) {
                return j3;
            }
        } else {
            long j4 = (long) (f + (f2 * (this.timesOfSlows - 1.0f)));
            j2 = this.slowDuration;
            if (j4 < j2) {
                return j4;
            }
        }
        return j2;
    }

    public Looper getLooper() {
        Looper looperMyLooper = Looper.myLooper();
        return looperMyLooper != null ? looperMyLooper : Looper.getMainLooper();
    }

    public boolean parseHsrInfo(String str, long j) {
        if (this.realFps == INVALID_FPS) {
            String strSubstring = str.substring(str.indexOf(Constants.SLOW_MOTION_HSR_HEAD), str.indexOf(":"));
            LogUtil.d(TAG, "parseHsrInfo: hsrPrefixTitle = " + strSubstring);
            String strSubstring2 = strSubstring.substring(16);
            this.realFps = (float) Integer.parseInt(strSubstring2);
            LogUtil.d(TAG, "Parse fps form title is " + strSubstring2 + ", realFps: " + this.realFps);
        }
        this.timesOfSlows = this.realFps / this.slowFps;
        LogUtil.d(TAG, "timesOfSlows: " + this.timesOfSlows);
        String[] strArrSplit = str.substring(str.indexOf(":") + 1).split(",");
        long[] jArr = new long[4];
        for (int i = 0; i < strArrSplit.length && i < 4; i++) {
            LogUtil.d(TAG, "sHsrInfo[" + i + "]: " + strArrSplit[i]);
            jArr[i] = Long.parseLong(strArrSplit[i]);
        }
        long j2 = jArr[0];
        if (j2 >= 0 && j2 < j) {
            long j3 = jArr[1];
            if (j3 > j2) {
                long jMin = Math.min(j3, j);
                SlowMotionInfo[] slowMotionInfoArr = this.slowIfs;
                int i2 = this.slowInfoLen;
                this.slowInfoLen = i2 + 1;
                slowMotionInfoArr[i2] = new SlowMotionInfo(j2, jMin, 0L, this.timesOfSlows);
            }
        }
        long j4 = jArr[2];
        if (j4 >= jArr[1] && j4 < j) {
            long j5 = jArr[3];
            if (j5 > j4) {
                long jMin2 = Math.min(j5, j);
                SlowMotionInfo[] slowMotionInfoArr2 = this.slowIfs;
                int i3 = this.slowInfoLen;
                this.slowInfoLen = i3 + 1;
                slowMotionInfoArr2[i3] = new SlowMotionInfo(j4, jMin2, ((slowMotionInfoArr2[0].getSlowEnd() - this.slowIfs[0].getSlowStart()) - this.slowIfs[0].getEnd()) + this.slowIfs[0].getStart(), this.timesOfSlows);
            }
        }
        LogUtil.d(TAG, "slowInfoLen: " + this.slowInfoLen);
        this.realDuration = j;
        this.slowDuration = j;
        for (int i4 = 0; i4 < this.slowInfoLen; i4++) {
            this.slowDuration += ((this.slowIfs[i4].getSlowEnd() - this.slowIfs[i4].getSlowStart()) - this.slowIfs[i4].getEnd()) + this.slowIfs[i4].getStart();
        }
        LogUtil.d(TAG, "realDuration: " + this.realDuration + ", slowDuration: " + this.slowDuration);
        boolean z = this.slowInfoLen > 0;
        this.isHsr = z;
        return z;
    }

    public void resetSlowMotionInfo() {
        this.slowIfs = null;
        this.isHsr = false;
        this.isSlow = false;
        this.slowInfoLen = 0;
        this.status = 2;
        this.slowFps = 30;
        this.realFps = 30.0f;
    }

    public void start() {
        if (this.isHsr) {
            int i = this.status;
            this.status = 0;
            if (i != 2) {
                return;
            }
            this.handler.postDelayed(this.updatePlaybackRateAction, 10L);
        }
    }

    public void stop() {
        if (this.isHsr) {
            resetSlowMotionInfo();
        }
    }
}
