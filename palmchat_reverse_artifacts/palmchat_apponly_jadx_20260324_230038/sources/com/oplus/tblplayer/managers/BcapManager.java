package com.oplus.tblplayer.managers;

import android.content.Context;
import android.content.Intent;
import com.oplus.tbl.exoplayer2.Format;
import com.oplus.tbl.exoplayer2.metadata.Metadata;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tblplayer.utils.LogUtil;
import com.oplus.tblplayer.utils.MetadataFrameEntry;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class BcapManager {
    private static final String BCAP_AUDIO_EFFECT_PACKAGE_NAME = "com.oplus.audio.effectcenter";
    private static final String BCAP_VIDEO_ACTION = "android.Multimedia.AudioEffect.BinauralCapture_BROADCAST";
    private static final String BCAP_VIDEO_ACTION_TYPE = "BcapVideoActionType";
    private static final String TAG = "BcapManager";
    private static final int TYPE_BCAP_VIDEO_START = 1;
    private static final int TYPE_BCAP_VIDEO_STOP = 0;
    private Context appContext;
    private int bcapType;
    private MetadataFrameEntry bcp2Frame;
    Method enablePostEnhanceAudioMethod;
    Method feedProcessorWithAudioOnlyMethod;
    Method feedProcessorWithBcapAudioMethod;
    Method getBcapProcessorEabledMethod;
    Method getBcapProcessorMethod;
    Method getDroppedFramesAfterBcapResetMethod;
    Method initBcapProcessorIfNecessaryMethod;
    Method postProcessLatencyFramesMethod;
    Method resetBcapProcessorMethod;
    Method setDroppedFramesAfterBcapResetMethod;
    private final ArrayList bcp1Frames = new ArrayList();
    private long lastProcessedAudioPts = 0;
    private Format audioFormat = null;
    private boolean trimPlaybackLatency = true;
    private int postProcessLatencyFrames = 0;
    private int dropFrames = 0;
    Object bcapAudioProcessor = null;

    public BcapManager(Context context, int i) {
        this.appContext = context;
        this.bcapType = i;
    }

    private void applyBcpMetadata(ByteBuffer byteBuffer, long j, long j2) {
        StringBuilder sb;
        while (!this.bcp1Frames.isEmpty()) {
            MetadataFrameEntry metadataFrameEntry = (MetadataFrameEntry) this.bcp1Frames.get(0);
            if (metadataFrameEntry.getPts() < j) {
                sb = new StringBuilder();
                sb.append("drop bcp1 frame: ");
                sb.append(metadataFrameEntry.getPts());
                sb.append(" since peer audio frame has been rendered already");
            } else {
                if (metadataFrameEntry.getPts() == j) {
                    try {
                        this.feedProcessorWithBcapAudioMethod.invoke(this.bcapAudioProcessor, Assertions.checkNotNull(byteBuffer), Long.valueOf(j), (MetadataFrameEntry) this.bcp1Frames.remove(0), Long.valueOf(j2));
                        return;
                    } catch (Exception e) {
                        throw new IllegalStateException("Error in feedProcessorWithBcapAudioMethod invoke", e);
                    }
                }
                sb = new StringBuilder();
                sb.append("applyBcpMetadata, earliest bcp1 frame is: ");
                sb.append(metadataFrameEntry.getPts());
                sb.append(", current audio frame: ");
                sb.append(j);
            }
            LogUtil.w(TAG, sb.toString());
            this.bcp1Frames.remove(0);
        }
    }

    private long getFirstAvailableBcp1FramePts() {
        if (!this.bcp1Frames.isEmpty()) {
            return ((MetadataFrameEntry) this.bcp1Frames.get(0)).getPts();
        }
        LogUtil.e(TAG, "getFirstAvailableBcp1FramePts while there is no BCP1 frames");
        return -9223372036854775807L;
    }

    private long getLastAvailableBcp1FramePts() {
        if (this.bcp1Frames.isEmpty()) {
            LogUtil.e(TAG, "getLastAvailableBcp1FramePts while there is no BCP1 frames");
            return -9223372036854775807L;
        }
        return ((MetadataFrameEntry) this.bcp1Frames.get(r0.size() - 1)).getPts();
    }

    private void resetBcap() {
        this.lastProcessedAudioPts = 0L;
        this.dropFrames = 0;
        Object obj = this.bcapAudioProcessor;
        if (obj != null) {
            try {
                this.setDroppedFramesAfterBcapResetMethod.invoke(obj, 0);
                try {
                    this.resetBcapProcessorMethod.invoke(this.bcapAudioProcessor, new Object[0]);
                } catch (Exception e) {
                    throw new IllegalStateException("Error in resetBcapProcessorMethod invoke", e);
                }
            } catch (Exception e2) {
                throw new IllegalStateException("Error in setDroppedFramesAfterBcapResetMethod invoke", e2);
            }
        }
    }

    private void shouldSendBroadcast(String str, int i) {
        Assertions.checkNotNull(this.appContext);
        Intent intent = new Intent(str);
        intent.putExtra(BCAP_VIDEO_ACTION_TYPE, i);
        intent.setPackage(BCAP_AUDIO_EFFECT_PACKAGE_NAME);
        LogUtil.d(TAG, "Send broadcast intent: " + intent);
        this.appContext.sendBroadcast(intent);
    }

    public void OnMetadata(Metadata metadata) {
        Metadata.Entry entry = metadata.get(0);
        MetadataFrameEntry metadataFrameEntry = (MetadataFrameEntry) entry;
        if (metadataFrameEntry.getType() != 0) {
            if (metadataFrameEntry.getType() == 1) {
                this.bcp2Frame = metadataFrameEntry;
            }
        } else {
            if (!this.bcp1Frames.isEmpty() && metadataFrameEntry.getPts() < getLastAvailableBcp1FramePts()) {
                LogUtil.i(TAG, "onMetadata() BCP1 frame rewinds, clear cached metadata frames");
                this.bcp1Frames.clear();
            }
            this.bcp1Frames.add(entry);
        }
    }

    public void OnMetadataReset() {
        LogUtil.d(TAG, "OnMetadataReset: reset BCAP instance ");
        resetBcap();
    }

    public void enablePostEnhanceAudio(boolean z) {
        if (this.bcapAudioProcessor != null) {
            try {
                LogUtil.d(TAG, "enablePostEnhanceAudio: " + z);
                if (z) {
                    shouldSendBroadcast(BCAP_VIDEO_ACTION, 1);
                } else {
                    shouldSendBroadcast(BCAP_VIDEO_ACTION, 0);
                }
                this.enablePostEnhanceAudioMethod.invoke(this.bcapAudioProcessor, Boolean.valueOf(z));
            } catch (Exception e) {
                throw new IllegalStateException("Error in enablePostEnhanceAudioMethod invoke", e);
            }
        }
    }

    public Format getAudioFormat() {
        return this.audioFormat;
    }

    public int getBcapType() {
        return this.bcapType;
    }

    public void initBcapProcessorIfNecessary() {
        Object obj = this.bcapAudioProcessor;
        if (obj != null) {
            try {
                this.initBcapProcessorIfNecessaryMethod.invoke(obj, this.audioFormat, this.bcp2Frame);
            } catch (Exception e) {
                throw new IllegalStateException("Error in initBcapProcessorIfNecessaryMethod invoke", e);
            }
        }
    }

    public void initProcessorMethod() {
        try {
            Class<?> cls = Class.forName("com.oplus.tblplayer.ext.bcap.BcapAudioFrameProcessor");
            Class<?> cls2 = Boolean.TYPE;
            this.bcapAudioProcessor = cls.getConstructor(cls2).newInstance(Boolean.TRUE);
            this.initBcapProcessorIfNecessaryMethod = cls.getMethod("initBcapProcessorIfNecessary", Format.class, MetadataFrameEntry.class);
            this.getBcapProcessorMethod = cls.getMethod("getBcapProcessor", new Class[0]);
            this.resetBcapProcessorMethod = cls.getMethod("resetBcapProcessor", new Class[0]);
            Class<?> cls3 = Long.TYPE;
            this.feedProcessorWithAudioOnlyMethod = cls.getMethod("feedProcessorWithAudioOnly", ByteBuffer.class, cls3, cls3);
            this.feedProcessorWithBcapAudioMethod = cls.getMethod("feedProcessorWithBcapAudio", ByteBuffer.class, cls3, MetadataFrameEntry.class, cls3);
            this.enablePostEnhanceAudioMethod = cls.getMethod("enablePostEnhance", cls2);
            this.getBcapProcessorEabledMethod = cls.getMethod("getBcapProcessorEabled", new Class[0]);
            this.postProcessLatencyFramesMethod = cls.getMethod("postProcessLatencyFrames", new Class[0]);
            this.getDroppedFramesAfterBcapResetMethod = cls.getMethod("getDroppedFramesAfterBcapReset", new Class[0]);
            this.setDroppedFramesAfterBcapResetMethod = cls.getMethod("setDroppedFramesAfterBcapReset", Integer.TYPE);
            LogUtil.d(TAG, "Loaded and init BcapAudioFrameProcessor.");
        } catch (ClassNotFoundException unused) {
        } catch (Exception e) {
            throw new IllegalStateException("Error in instantiating bcap extension", e);
        }
    }

    public void onPositionReset(long j, boolean z) {
        LogUtil.i(TAG, "onPositionReset positionUs=" + j + " joining=" + z + ", reset BCAP state");
        resetBcap();
    }

    public boolean processOutputBcapBuffer(long j, ByteBuffer byteBuffer, long j2) {
        Object obj = this.bcapAudioProcessor;
        if (obj != null) {
            try {
                if (this.getBcapProcessorMethod.invoke(obj, new Object[0]) == null) {
                    LogUtil.d(TAG, "bcapProcessor is null");
                    return false;
                }
                if (this.bcp2Frame == null) {
                    LogUtil.d(TAG, "Audio frame pts=" + j + " but we haven't got bcp2 metadata, wait...");
                    return false;
                }
                LogUtil.d(TAG, "processOutputBuffer: lastProcessedAudioPts = " + this.lastProcessedAudioPts + ", bufferPresentationTimeUs = " + j);
                if (getLastAvailableBcp1FramePts() >= j && getFirstAvailableBcp1FramePts() <= j) {
                    applyBcpMetadata((ByteBuffer) Assertions.checkNotNull(byteBuffer), j, j2);
                    this.lastProcessedAudioPts = j;
                    if (this.trimPlaybackLatency) {
                        try {
                            this.postProcessLatencyFrames = ((Integer) this.postProcessLatencyFramesMethod.invoke(this.bcapAudioProcessor, new Object[0])).intValue();
                            try {
                                int iIntValue = ((Integer) this.getDroppedFramesAfterBcapResetMethod.invoke(this.bcapAudioProcessor, new Object[0])).intValue();
                                this.dropFrames = iIntValue;
                                if (iIntValue < this.postProcessLatencyFrames) {
                                    int i = iIntValue + 1;
                                    this.dropFrames = i;
                                    try {
                                        this.setDroppedFramesAfterBcapResetMethod.invoke(this.bcapAudioProcessor, Integer.valueOf(i));
                                        LogUtil.i(TAG, "processOutputBuffer: drop frame #" + this.dropFrames + " after reset BCAP library");
                                        byteBuffer.position(byteBuffer.limit());
                                    } catch (Exception e) {
                                        throw new IllegalStateException("Error in setDroppedFramesAfterBcapResetMethod invoke", e);
                                    }
                                }
                            } catch (Exception e2) {
                                throw new IllegalStateException("Error in getDroppedFramesAfterBcapResetMethod invoke", e2);
                            }
                        } catch (Exception e3) {
                            throw new IllegalStateException("Error in postProcessLatencyFramesMethod invoke", e3);
                        }
                    }
                } else if (j != this.lastProcessedAudioPts) {
                    LogUtil.w(TAG, "Output audio frame : " + j + " without BCAP process");
                    try {
                        this.feedProcessorWithAudioOnlyMethod.invoke(this.bcapAudioProcessor, Assertions.checkNotNull(byteBuffer), Long.valueOf(j), Long.valueOf(j2));
                        this.lastProcessedAudioPts = j;
                    } catch (Exception e4) {
                        throw new IllegalStateException("Error in feedProcessorWithAudioOnlyMethod invoke", e4);
                    }
                }
            } catch (Exception e5) {
                throw new IllegalStateException("Error in getBcapProcessorMethod invoke", e5);
            }
        }
        return true;
    }

    public void setAudioFormat(Format format) {
        this.audioFormat = format;
    }

    public void start() {
        shouldSendBroadcast(BCAP_VIDEO_ACTION, 1);
    }

    public void stop() {
        shouldSendBroadcast(BCAP_VIDEO_ACTION, 0);
    }
}
