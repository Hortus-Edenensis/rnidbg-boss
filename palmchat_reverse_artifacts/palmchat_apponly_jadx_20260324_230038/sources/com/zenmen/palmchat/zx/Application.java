package com.zenmen.palmchat.zx;

import android.content.Context;
import defpackage.zj6;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0014¨\u0006\u0007"}, d2 = {"Lcom/zenmen/palmchat/zx/Application;", "Lcom/zenmen/palmchat/zx/core/Application;", "()V", "attachBaseContext", "", "base", "Landroid/content/Context;", "zx-framework_release"}, k = 1, mv = {1, 1, 16})
public abstract class Application extends com.zenmen.palmchat.zx.core.Application {
    @Override // com.zenmen.palmchat.zx.core.Application, androidx.multidex.MultiDexApplication, android.content.ContextWrapper
    public void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        zj6.a(base);
    }
}
