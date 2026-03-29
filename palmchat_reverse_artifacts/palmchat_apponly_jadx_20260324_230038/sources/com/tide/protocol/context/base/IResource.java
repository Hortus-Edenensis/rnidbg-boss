package com.tide.protocol.context.base;

import android.content.res.AssetManager;
import android.content.res.Resources;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface IResource {
    AssetManager getAssets();

    Resources getResources();

    Resources.Theme getTheme();
}
