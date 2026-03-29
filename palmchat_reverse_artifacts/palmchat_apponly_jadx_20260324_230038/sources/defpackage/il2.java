package defpackage;

import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public interface il2 {
    void onError(int i, String str);

    void onFinish(File file);

    void onPrepare();

    void onProgress(int i);

    void onStart(String str, String str2, int i);

    void onStop(int i);
}
