package com.oplus.tblplayer.utils;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.oplus.tbl.exoplayer2.util.LibraryLoaderListener;
import com.oplus.tblplayer.Constants;
import com.oplus.tblplayer.utils.LibraryLoaderDynamic;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class LibraryLoaderDynamic {
    private static final String TAG = "LibraryLoaderDynamic";
    private static final List<String> NATIVE_LIBRARIES_LOADED = Collections.synchronizedList(new ArrayList(3));
    private static final Handler HANDLER = new Handler(Looper.getMainLooper());
    private static LibraryLoaderListener sLibraryLoaderListener = null;

    public static File findSoDir(String str, String str2) {
        LogUtil.i(TAG, "We will find " + str2 + " in " + str);
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            return searchSoRecursively(file, str2);
        }
        LogUtil.w(TAG, "Root directory does not exist or is not a directory: " + str);
        return null;
    }

    public static String getArchitecture() {
        String str = Build.CPU_ABI;
        if (str == null || str.length() == 0) {
            str = Build.CPU_ABI2;
        }
        LogUtil.d(TAG, "getArchitecture: " + str);
        return str;
    }

    public static LibraryLoaderListener getLibraryLoaderListener() {
        LibraryLoaderListener libraryLoaderListener = sLibraryLoaderListener;
        if (libraryLoaderListener != null) {
            return libraryLoaderListener;
        }
        LogUtil.e(TAG, "LibraryLoaderListener is null please check!");
        return null;
    }

    public static List<String> getNativeLibrariesLoaded() {
        return NATIVE_LIBRARIES_LOADED;
    }

    public static boolean isLibraryFfmpegJNILoaded() {
        return NATIVE_LIBRARIES_LOADED.contains("libffmpegJNI.so");
    }

    public static boolean isLibraryFfmpegLoaded() {
        return NATIVE_LIBRARIES_LOADED.contains("libffmpeg.so");
    }

    public static boolean isLibraryPlatformJNILoaded() {
        return NATIVE_LIBRARIES_LOADED.contains("libPlatformJNI.so");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$loadSoDynamicFile$0(File file) {
        List<String> list = NATIVE_LIBRARIES_LOADED;
        synchronized (list) {
            LogUtil.d(TAG, "fileName is " + file.getName());
            if (!list.contains(file.getName())) {
                list.add(file.getName());
            }
        }
    }

    public static void loadResult(boolean z, String str) {
        LibraryLoaderListener libraryLoaderListener = sLibraryLoaderListener;
        if (libraryLoaderListener == null) {
            LogUtil.w(TAG, "Please set library load listener first.");
        } else if (z) {
            libraryLoaderListener.loadSuccess(str);
        } else {
            libraryLoaderListener.loadFailed(str);
        }
    }

    public static void loadSoDynamicFile(final File file) {
        String absolutePath;
        if (file != null && file.exists() && file.getName().endsWith(Constants.LIBRARY_SUFFIX)) {
            try {
                LogUtil.d(TAG, "loadDynamicSo: " + file.getAbsolutePath());
                System.load(file.getAbsolutePath());
                loadResult(true, file.getAbsolutePath());
                HANDLER.post(new Runnable() { // from class: e23
                    @Override // java.lang.Runnable
                    public final void run() {
                        LibraryLoaderDynamic.lambda$loadSoDynamicFile$0(file);
                    }
                });
                return;
            } catch (UnsatisfiedLinkError e) {
                LogUtil.e(TAG, "Dynamic library file maybe some wrong." + e.getMessage());
                absolutePath = file.getAbsolutePath();
            }
        } else {
            LogUtil.e(TAG, "File is null or does not exist");
            absolutePath = " ";
        }
        loadResult(false, absolutePath);
    }

    private static File searchSoRecursively(File file, String str) {
        File fileSearchSoRecursively;
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return null;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isFile() && file2.getName().equals(str)) {
                LogUtil.d(TAG, "Found so file: " + file2.getAbsolutePath());
                return file2;
            }
            if (file2.isDirectory() && (fileSearchSoRecursively = searchSoRecursively(file2, str)) != null) {
                return fileSearchSoRecursively;
            }
        }
        return null;
    }

    public static void setLibraryLoaderListener(LibraryLoaderListener libraryLoaderListener) {
        if (libraryLoaderListener == null) {
            LogUtil.d(TAG, "Loader listener is null!");
            return;
        }
        LogUtil.d(TAG, "set loader listener " + libraryLoaderListener);
        sLibraryLoaderListener = libraryLoaderListener;
    }
}
