package com.tide.host.a;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.tide.protocol.context.base.IResource;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class a0 implements IResource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AssetManager f10782a;
    public Resources b;
    public Resources.Theme c;

    public a0(Context context) {
    }

    @Override // com.tide.protocol.context.base.IResource
    public final AssetManager getAssets() {
        return this.f10782a;
    }

    @Override // com.tide.protocol.context.base.IResource
    public final Resources getResources() {
        return this.b;
    }

    @Override // com.tide.protocol.context.base.IResource
    public final Resources.Theme getTheme() {
        return this.c;
    }
}
