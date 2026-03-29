package com.oplus.tblplayer;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.Util;
import com.oplus.tblplayer.android.TBLAndroidPlayer;
import com.oplus.tblplayer.config.Globals;
import com.oplus.tblplayer.config.GlobalsConfig;
import com.oplus.tblplayer.config.PlayerConfiguration;
import com.oplus.tblplayer.remote.TBLRemotePlayer;
import com.oplus.tblplayer.utils.LogUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class TBLPlayerManager {
    private static final Constructor<? extends IMediaPlayer> ANDROID_PLAYER_WRAPPER_CONSTRUCTOR;
    private static final Constructor<? extends IMediaPlayer> IJKPLAYER_WRAPPER_CONSTRUCTOR;
    private static final String TAG = "TBLPlayerManager";
    public static final int TBL_PLAYER_TYPE_ANDROID = 3;
    public static final int TBL_PLAYER_TYPE_EXO = 0;
    public static final int TBL_PLAYER_TYPE_IJK = 2;
    public static final int TBL_PLAYER_TYPE_REMOTE = 1;

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlayerType {
    }

    static {
        Constructor<? extends IMediaPlayer> constructor;
        Constructor<? extends IMediaPlayer> constructor2 = null;
        try {
            constructor = Class.forName("com.oplus.tblplayer.ijk.TBLIjkPlayerWrapper").asSubclass(IMediaPlayer.class).getConstructor(Context.class);
        } catch (ClassNotFoundException unused) {
            constructor = null;
        } catch (Exception e) {
            throw new RuntimeException("Error instantiating TBLIjkPlayerWrapper class", e);
        }
        IJKPLAYER_WRAPPER_CONSTRUCTOR = constructor;
        try {
            constructor2 = TBLAndroidPlayer.class.asSubclass(IMediaPlayer.class).getConstructor(Context.class);
        } catch (ClassNotFoundException unused2) {
        } catch (Exception e2) {
            throw new RuntimeException("Error instantiating TBLAndroidPlayer class", e2);
        }
        ANDROID_PLAYER_WRAPPER_CONSTRUCTOR = constructor2;
    }

    public static IMediaPlayer createPlayer(Context context) {
        return createPlayer(context, PlayerConfiguration.DEFAULT);
    }

    private static IMediaPlayer createPlayerInternal(Context context, int i, PlayerConfiguration playerConfiguration) {
        IMediaPlayer tBLExoPlayer;
        IMediaPlayer iMediaPlayerNewInstance;
        String str;
        Globals.maybeInitialize(context, null);
        LogUtil.i(TAG, "TBLPlayer [1.7.5002PRO], [" + Util.DEVICE_DEBUG_INFO + "]");
        if (i == 0) {
            if (playerConfiguration == null) {
                playerConfiguration = PlayerConfiguration.DEFAULT;
            }
            tBLExoPlayer = new TBLExoPlayer(context, (PlayerConfiguration) Assertions.checkNotNull(playerConfiguration));
            LogUtil.dfmt(TAG, "create TBLExoPlayer with extractor: %s, with codec: %s.", LogUtil.getExtractorTypeString(playerConfiguration.extractorMode), LogUtil.getRendererTypeString(playerConfiguration.rendererMode));
        } else {
            if (i != 1) {
                if (i == 2) {
                    Constructor<? extends IMediaPlayer> constructor = IJKPLAYER_WRAPPER_CONSTRUCTOR;
                    if (constructor == null) {
                        throw new RuntimeException("Must implementation module library wrapper player.");
                    }
                    try {
                        iMediaPlayerNewInstance = constructor.newInstance(context);
                        str = "create TBLIjkPlayerWrapper";
                    } catch (Exception e) {
                        throw new RuntimeException("Error instantiating TBLIjkPlayerWrapper class", e);
                    }
                } else {
                    if (i != 3) {
                        throw new UnsupportedOperationException("Unsupported player type.");
                    }
                    Constructor<? extends IMediaPlayer> constructor2 = ANDROID_PLAYER_WRAPPER_CONSTRUCTOR;
                    if (constructor2 == null) {
                        throw new RuntimeException("Must implementation module library wrapper player.");
                    }
                    try {
                        iMediaPlayerNewInstance = constructor2.newInstance(context);
                        str = "create TBLAndroidPlayer";
                    } catch (Exception e2) {
                        throw new RuntimeException("Error instantiating TBLAndroidPlayer class", e2);
                    }
                }
                LogUtil.d(TAG, str);
                return iMediaPlayerNewInstance;
            }
            tBLExoPlayer = new TBLRemotePlayer(context);
            LogUtil.d(TAG, "create TBLRemotePlayer");
        }
        return tBLExoPlayer;
    }

    public static void initGlobals(@NonNull Context context, @Nullable GlobalsConfig globalsConfig) {
        Globals.maybeInitialize(context.getApplicationContext(), globalsConfig);
    }

    public static IMediaPlayer createPlayer(Context context, int i) {
        return createPlayer(context, i, 0);
    }

    public static IMediaPlayer createPlayer(Context context, int i, int i2) {
        return createPlayer(context, i, i2, 0);
    }

    public static IMediaPlayer createPlayer(Context context, int i, int i2, int i3) {
        return createPlayer(context, i, i2, i3, false);
    }

    public static IMediaPlayer createPlayer(Context context, int i, int i2, int i3, boolean z) {
        return createPlayerInternal(context, i, new PlayerConfiguration.Builder().setRendererMode(i2).setExtractorMode(i3).setHighPerformanceEnabled(z).build());
    }

    public static IMediaPlayer createPlayer(Context context, int i, PlayerConfiguration playerConfiguration) {
        return createPlayerInternal(context, i, playerConfiguration);
    }

    public static IMediaPlayer createPlayer(Context context, PlayerConfiguration playerConfiguration) {
        return createPlayer(context, 0, playerConfiguration);
    }
}
