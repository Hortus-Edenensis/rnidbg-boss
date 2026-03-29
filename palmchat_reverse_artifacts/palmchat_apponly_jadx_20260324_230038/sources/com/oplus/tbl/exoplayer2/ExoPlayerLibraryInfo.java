package com.oplus.tbl.exoplayer2;

import android.os.Build;
import java.util.HashSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class ExoPlayerLibraryInfo {
    public static final boolean ASSERTIONS_ENABLED = true;
    public static final boolean GL_ASSERTIONS_ENABLED = false;
    public static final String TAG = "ExoPlayer";
    public static final boolean TRACE_ENABLED = true;
    public static final String VERSION = "2.13.2";
    public static final int VERSION_INT = 2013002;
    public static final String VERSION_SLASHY = "ExoPlayerLib/2.13.2";

    @Deprecated
    public static final String DEFAULT_USER_AGENT = "ExoPlayerLib/2.13.2 (Linux; Android " + Build.VERSION.RELEASE + ") " + VERSION_SLASHY;
    private static final HashSet<String> registeredModules = new HashSet<>();
    private static String registeredModulesString = "goog.exo.core";

    private ExoPlayerLibraryInfo() {
    }

    public static synchronized void registerModule(String str) {
        if (registeredModules.add(str)) {
            registeredModulesString += ", " + str;
        }
    }

    public static synchronized String registeredModules() {
        return registeredModulesString;
    }
}
