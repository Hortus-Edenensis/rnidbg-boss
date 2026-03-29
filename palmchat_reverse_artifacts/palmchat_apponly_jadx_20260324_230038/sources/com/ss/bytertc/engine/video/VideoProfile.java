package com.ss.bytertc.engine.video;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.oplus.tblplayer.processor.util.EffectConstants;
import com.ss.android.ttvecamera.TECameraSettings;
import com.ss.bytertc.engine.VideoStreamDescription;
import com.ss.bytertc.engine.data.RTCData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class VideoProfile {
    private static SparseArray<VideoPreset> sVideoProfileMap;

    static {
        SparseArray<VideoPreset> sparseArray = new SparseArray<>();
        sVideoProfileMap = sparseArray;
        sparseArray.put(0, new VideoPreset(160, 120, 15, 65));
        sVideoProfileMap.put(2, new VideoPreset(120, 120, 15, 50));
        sVideoProfileMap.put(10, new VideoPreset(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME, EffectConstants.ROTATION_DEGREES_180, 15, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID));
        sVideoProfileMap.put(12, new VideoPreset(EffectConstants.ROTATION_DEGREES_180, EffectConstants.ROTATION_DEGREES_180, 15, 100));
        sVideoProfileMap.put(13, new VideoPreset(240, EffectConstants.ROTATION_DEGREES_180, 15, 120));
        sVideoProfileMap.put(14, new VideoPreset(240, EffectConstants.ROTATION_DEGREES_180, 15, 240));
        sVideoProfileMap.put(20, new VideoPreset(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME, 240, 15, 200));
        sVideoProfileMap.put(21, new VideoPreset(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME, 240, 15, 360));
        sVideoProfileMap.put(22, new VideoPreset(240, 240, 15, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID));
        sVideoProfileMap.put(23, new VideoPreset(424, 240, 15, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM));
        sVideoProfileMap.put(30, new VideoPreset(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, 360, 15, 600));
        sVideoProfileMap.put(32, new VideoPreset(360, 360, 15, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME));
        sVideoProfileMap.put(33, new VideoPreset(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, 360, 30, 600));
        sVideoProfileMap.put(34, new VideoPreset(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, 360, 15, 800));
        sVideoProfileMap.put(35, new VideoPreset(360, 360, 30, 400));
        sVideoProfileMap.put(36, new VideoPreset(TECameraSettings.FPS_480, 360, 15, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME));
        sVideoProfileMap.put(37, new VideoPreset(TECameraSettings.FPS_480, 360, 30, 490));
        sVideoProfileMap.put(40, new VideoPreset(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, TECameraSettings.FPS_480, 15, 500));
        sVideoProfileMap.put(42, new VideoPreset(TECameraSettings.FPS_480, TECameraSettings.FPS_480, 15, 400));
        sVideoProfileMap.put(43, new VideoPreset(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, TECameraSettings.FPS_480, 30, 750));
        sVideoProfileMap.put(45, new VideoPreset(TECameraSettings.FPS_480, TECameraSettings.FPS_480, 30, 600));
        sVideoProfileMap.put(46, new VideoPreset(848, TECameraSettings.FPS_480, 15, 1200));
        sVideoProfileMap.put(47, new VideoPreset(848, TECameraSettings.FPS_480, 30, 800));
        sVideoProfileMap.put(48, new VideoPreset(848, TECameraSettings.FPS_480, 30, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_ABR_SWITCH_COST));
        sVideoProfileMap.put(50, new VideoPreset(1280, 720, 15, 1130));
        sVideoProfileMap.put(52, new VideoPreset(1280, 720, 30, 1710));
        sVideoProfileMap.put(54, new VideoPreset(960, 720, 15, MediaPlayer.MEDIA_PLAYER_OPTION_COLOR_SPACE));
        sVideoProfileMap.put(55, new VideoPreset(960, 720, 30, 1380));
    }

    public static void addVideoVideoPreset(int i, VideoPreset videoPreset) {
        sVideoProfileMap.put(i, videoPreset);
    }

    public static VideoPreset getVideoVideoPreset() {
        int iIntValue = 0;
        int iIntValue2 = 0;
        int i = 0;
        int i2 = 0;
        for (VideoStreamDescription videoStreamDescription : RTCData.instance().getVideoStreamDescriptions()) {
            if (((Integer) videoStreamDescription.videoSize.first).intValue() > iIntValue) {
                iIntValue = ((Integer) videoStreamDescription.videoSize.first).intValue();
            }
            if (((Integer) videoStreamDescription.videoSize.second).intValue() > iIntValue2) {
                iIntValue2 = ((Integer) videoStreamDescription.videoSize.second).intValue();
            }
            int i3 = videoStreamDescription.frameRate;
            if (i3 > i) {
                i = i3;
            }
            int i4 = videoStreamDescription.maxKbps;
            if (i4 > i2) {
                i2 = i4;
            }
        }
        return new VideoPreset(iIntValue, iIntValue2, i, i2);
    }

    public static VideoPreset getVideoVideoPresetById(int i) {
        VideoPreset videoPreset = sVideoProfileMap.get(i);
        return videoPreset == null ? sVideoProfileMap.get(33) : videoPreset;
    }

    public static SparseArray<VideoPreset> getsVideoProfileMap() {
        return sVideoProfileMap;
    }
}
