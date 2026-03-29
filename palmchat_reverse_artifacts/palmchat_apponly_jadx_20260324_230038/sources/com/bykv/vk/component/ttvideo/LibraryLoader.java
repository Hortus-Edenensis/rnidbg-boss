package com.bykv.vk.component.ttvideo;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.gi.iz;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class LibraryLoader {
    private static final String TAG = "LibraryLoader";
    private static Loader sLoader;

    /* JADX INFO: compiled from: SearchBox */
    public interface Loader {
        void loadLibrary(String str) throws Exception;

        void loadLibraryFromPath(String str) throws Exception;
    }

    public static void loadLibrary(String str) throws Exception {
        Loader loader = sLoader;
        if (TextUtils.isEmpty(str)) {
            throw new Exception("Invalid library name.");
        }
        if (loader != null) {
            loader.loadLibrary(str);
        } else {
            iz.u(str);
        }
    }

    public static void loadLibraryFromPath(String str) throws Exception {
        Loader loader = sLoader;
        if (TextUtils.isEmpty(str)) {
            throw new Exception("Invalid library name.");
        }
        File file = new File(str);
        if (!file.exists()) {
            throw new Exception("Not found library '" + str + "' file.");
        }
        if (loader == null) {
            System.load(file.getAbsolutePath());
        } else {
            file.getAbsolutePath();
            loader.loadLibraryFromPath(file.getAbsolutePath());
        }
    }

    public static void setupLibraryLoader(Loader loader) {
        sLoader = loader;
    }
}
