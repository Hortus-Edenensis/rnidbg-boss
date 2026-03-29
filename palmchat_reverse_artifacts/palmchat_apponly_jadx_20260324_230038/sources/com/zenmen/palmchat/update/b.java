package com.zenmen.palmchat.update;

import android.content.Context;
import com.zenmen.palmchat.update.UpdateManager;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public interface b {

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(int i);

        void b(int i, UpdateInfo updateInfo);

        void c(int i, File file, UpdateInfo updateInfo);
    }

    void a(UpdateInfo updateInfo);

    void b(UpdateInfo updateInfo);

    void c(a aVar);

    void d(Context context, int i, UpdateManager.UpdateScene updateScene);
}
