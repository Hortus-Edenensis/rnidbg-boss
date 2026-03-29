package com.oplus.tbl.exoplayer2.util;

import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class LibraryLoader {
    private static final String TAG = "LibraryLoader";
    private boolean isAvailable;
    private boolean loadAttempted;
    private LibraryLoaderListener mLibraryLoaderListener = new LibraryLoaderListener() { // from class: com.oplus.tbl.exoplayer2.util.LibraryLoader.1
        @Override // com.oplus.tbl.exoplayer2.util.LibraryLoaderListener
        public void loadFailed(String str) {
            Log.w(LibraryLoader.TAG, "Failed to load " + str);
        }

        @Override // com.oplus.tbl.exoplayer2.util.LibraryLoaderListener
        public void loadSuccess(String str) {
            Log.d(LibraryLoader.TAG, "Success to load " + str);
        }
    };
    private String[] nativeLibraries;

    public LibraryLoader(String... strArr) {
        this.nativeLibraries = strArr;
    }

    public synchronized boolean isAvailable() {
        if (this.loadAttempted) {
            return this.isAvailable;
        }
        this.loadAttempted = true;
        try {
            for (String str : this.nativeLibraries) {
                System.loadLibrary(str);
                this.mLibraryLoaderListener.loadSuccess(str);
            }
            this.isAvailable = true;
        } catch (UnsatisfiedLinkError unused) {
            this.mLibraryLoaderListener.loadFailed(Arrays.toString(this.nativeLibraries));
        }
        return this.isAvailable;
    }

    public synchronized void setLibraries(String... strArr) {
        Assertions.checkState(!this.loadAttempted, "Cannot set libraries after loading");
        this.nativeLibraries = strArr;
    }

    public synchronized void setLibraryLoadListener(LibraryLoaderListener libraryLoaderListener) {
        if (libraryLoaderListener != null) {
            this.mLibraryLoaderListener = libraryLoaderListener;
        }
    }
}
