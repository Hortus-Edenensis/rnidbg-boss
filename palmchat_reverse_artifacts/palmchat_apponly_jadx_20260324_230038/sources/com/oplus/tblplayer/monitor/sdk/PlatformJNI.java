package com.oplus.tblplayer.monitor.sdk;

import com.oplus.tbl.exoplayer2.util.LibraryLoader;
import com.oplus.tblplayer.Constants;
import com.oplus.tblplayer.utils.LibraryLoaderDynamic;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class PlatformJNI {
    private static final LibraryLoader LOADER = new LibraryLoader(Constants.LIBRARY_PLATFORM_JNI);

    public PlatformJNI() {
        isAvailable();
    }

    public static boolean isAvailable() {
        LibraryLoader libraryLoader = LOADER;
        libraryLoader.setLibraryLoadListener(LibraryLoaderDynamic.getLibraryLoaderListener());
        return LibraryLoaderDynamic.isLibraryPlatformJNILoaded() || libraryLoader.isAvailable();
    }

    private native int nativeGetSysHz();

    public int getSysHz() {
        return nativeGetSysHz();
    }
}
