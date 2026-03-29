package org.apache.cordova;

import android.net.Uri;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class FileSelectHelper {
    private static Uri[] currentSelectUri;

    public static Uri[] getCurrentFilePath() {
        return currentSelectUri;
    }

    public static void onFileSelected(Uri[] uriArr) {
        currentSelectUri = uriArr;
    }
}
