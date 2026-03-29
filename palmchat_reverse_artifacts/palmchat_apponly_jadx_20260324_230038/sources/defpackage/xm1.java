package defpackage;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.oplus.tblplayer.processor.util.EffectConstants;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class xm1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f22002a = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
    public static final int[][] b = {new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, 144, 134, 240, 92, MediaPlayer.MEDIA_PLAYER_ADAPTIVE_WORK_AROUND_MODE}, new int[]{28, 24, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SOLOPLAY, 166, 223, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 116, 255, 110, 61}, new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 138, 205, 12, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY, 168, 39, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_ERROR, 60, 97, 120}, new int[]{41, 153, 158, 91, 61, 42, MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO, 213, 97, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD, 100, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE}, new int[]{156, 97, 192, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF, 95, 9, 157, 119, 138, 45, 18, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS, 83, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SOLOPLAY}, new int[]{83, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 100, 39, 188, 75, 66, 61, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE, 213, 109, 129, 94, MediaPlayer.MEDIA_PLAYER_ADAPTIVE_WORK_AROUND_MODE, 225, 48, 90, 188}, new int[]{15, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_SIZE, 9, 233, 71, 168, 2, 188, 160, 153, 145, 253, 79, 108, 82, 27, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS, 172}, new int[]{52, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME, 88, 205, 109, 39, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HURRY_THRESHOLD, 21, 155, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR, 223, 155, 21, 5, 172, MediaPlayer.MEDIA_PLAYER_ADAPTIVE_WORK_AROUND_MODE, 124, 12, MediaPlayer.MEDIA_PLAYER_OPTION_ASYNC_INIT_CODEC, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO, 96, 50, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT}, new int[]{211, MediaPlayer.MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR, 43, 97, 71, 96, 103, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE, 37, 151, 170, 53, 75, 34, MediaPlayer.MEDIA_PLAYER_OPTION_TT_HLS_DRM_TOKEN, 121, 17, 138, 110, 213, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, 136, 120, 151, 233, 168, 93, 255}, new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_ERROR, 127, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE, 218, 130, 250, 162, MediaPlayer.MEDIA_PLAYER_OPTION_ASYNC_INIT_CODEC, 102, 120, 84, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR, 80, MediaPlayer.MEDIA_PLAYER_OPTION_SET_DEFAULT_CODEC_ID, 229, 18, 2, 4, 68, 33, 101, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME, 95, 119, 115, 44, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO, 59, 25, 225, 98, 81, 112}, new int[]{77, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME, 31, 19, 38, 22, 153, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT, 105, 122, 2, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_ERROR, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE, 8, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 95, 100, 9, 167, 105, 214, 111, 57, 121, 21, 1, 253, 57, 54, 101, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 202, 69, 50, 150, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_LOW_THRESHOLD, 226, 5, 9, 5}, new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_ERROR, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA, 172, 223, 96, 32, 117, 22, 238, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START, 238, MediaPlayer.MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR, 205, 188, 237, 87, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED, 106, 16, 147, 118, 23, 37, 90, 170, 205, 131, 88, 120, 100, 66, 138, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS, 240, 82, 44, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HURRY_THRESHOLD, 87, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME, 147, 160, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 69, 213, 92, 253, 225, 19}, new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 9, 223, 238, 12, 17, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM, 208, 100, 29, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 170, MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT, 192, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY, 235, 150, 159, 36, 223, 38, 200, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA, 54, 228, MediaPlayer.MEDIA_PLAYER_OPTION_LAZY_SEEK, 218, 234, 117, 203, 29, 232, 144, 238, 22, 150, 201, 117, 62, 207, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_REAL_TIME, 13, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_ERROR, 127, 67, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT, 28, 155, 43, 203, 107, 233, 53, MediaPlayer.MEDIA_PLAYER_OPTION_SEEK_END_ENABLE, 46}, new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE, 93, 169, 50, 144, 210, 39, 118, 202, 188, 201, 189, MediaPlayer.MEDIA_PLAYER_OPTION_SEEK_END_ENABLE, 108, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE, 37, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SOLOPLAY, 112, 134, MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_ERROR, 63, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME, 250, 106, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SOLOPLAY, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_ERROR, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 64, 114, 71, 161, 44, 147, 6, 27, 218, 51, 63, 87, 10, 40, 130, 188, 17, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPENED_TIME, 31, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HURRY_THRESHOLD, 170, 4, 107, 232, 7, 94, 166, 224, 124, 86, 47, 11, 204}, new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM, 228, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_SWITCH_COUNT, 89, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR, 149, 159, 56, 89, 33, 147, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_SIZE, 154, 36, 73, 127, 213, 136, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, EffectConstants.ROTATION_DEGREES_180, 234, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 158, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_LOW_THRESHOLD, 68, 122, 93, 213, 15, 160, 227, 236, 66, 139, 153, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SOLOPLAY, 202, 167, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, 25, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM, 232, 96, 210, MediaPlayer.MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR, 136, 223, 239, MediaPlayer.MEDIA_PLAYER_OPTION_ASYNC_INIT_CODEC, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE, 59, 52, 172, 25, 49, 232, 211, 189, 64, 54, 108, 153, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA, 63, 96, 103, 82, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS}};
    public static final int[] c = new int[256];
    public static final int[] d = new int[255];

    static {
        int i = 1;
        for (int i2 = 0; i2 < 255; i2++) {
            d[i2] = i;
            c[i] = i2;
            i <<= 1;
            if (i >= 256) {
                i ^= 301;
            }
        }
    }

    public static String a(CharSequence charSequence, int i) {
        return b(charSequence, 0, charSequence.length(), i);
    }

    public static String b(CharSequence charSequence, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6 = 0;
        while (true) {
            int[] iArr = f22002a;
            if (i6 >= iArr.length) {
                i6 = -1;
                break;
            }
            if (iArr[i6] == i3) {
                break;
            }
            i6++;
        }
        if (i6 < 0) {
            throw new IllegalArgumentException("Illegal number of error correction codewords specified: " + i3);
        }
        int[] iArr2 = b[i6];
        char[] cArr = new char[i3];
        for (int i7 = 0; i7 < i3; i7++) {
            cArr[i7] = 0;
        }
        for (int i8 = i; i8 < i + i2; i8++) {
            int i9 = i3 - 1;
            int iCharAt = cArr[i9] ^ charSequence.charAt(i8);
            while (i9 > 0) {
                if (iCharAt == 0 || (i5 = iArr2[i9]) == 0) {
                    cArr[i9] = cArr[i9 - 1];
                } else {
                    char c2 = cArr[i9 - 1];
                    int[] iArr3 = d;
                    int[] iArr4 = c;
                    cArr[i9] = (char) (iArr3[(iArr4[iCharAt] + iArr4[i5]) % 255] ^ c2);
                }
                i9--;
            }
            if (iCharAt == 0 || (i4 = iArr2[0]) == 0) {
                cArr[0] = 0;
            } else {
                int[] iArr5 = d;
                int[] iArr6 = c;
                cArr[0] = (char) iArr5[(iArr6[iCharAt] + iArr6[i4]) % 255];
            }
        }
        char[] cArr2 = new char[i3];
        for (int i10 = 0; i10 < i3; i10++) {
            cArr2[i10] = cArr[(i3 - i10) - 1];
        }
        return String.valueOf(cArr2);
    }

    public static String c(String str, zp5 zp5Var) {
        if (str.length() != zp5Var.a()) {
            throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
        }
        StringBuilder sb = new StringBuilder(zp5Var.a() + zp5Var.c());
        sb.append(str);
        int iF = zp5Var.f();
        if (iF == 1) {
            sb.append(a(str, zp5Var.c()));
        } else {
            sb.setLength(sb.capacity());
            int[] iArr = new int[iF];
            int[] iArr2 = new int[iF];
            int[] iArr3 = new int[iF];
            int i = 0;
            while (i < iF) {
                int i2 = i + 1;
                iArr[i] = zp5Var.b(i2);
                iArr2[i] = zp5Var.d(i2);
                iArr3[i] = 0;
                if (i > 0) {
                    iArr3[i] = iArr3[i - 1] + iArr[i];
                }
                i = i2;
            }
            for (int i3 = 0; i3 < iF; i3++) {
                StringBuilder sb2 = new StringBuilder(iArr[i3]);
                for (int i4 = i3; i4 < zp5Var.a(); i4 += iF) {
                    sb2.append(str.charAt(i4));
                }
                String strA = a(sb2.toString(), iArr2[i3]);
                int i5 = i3;
                int i6 = 0;
                while (i5 < iArr2[i3] * iF) {
                    sb.setCharAt(zp5Var.a() + i5, strA.charAt(i6));
                    i5 += iF;
                    i6++;
                }
            }
        }
        return sb.toString();
    }
}
