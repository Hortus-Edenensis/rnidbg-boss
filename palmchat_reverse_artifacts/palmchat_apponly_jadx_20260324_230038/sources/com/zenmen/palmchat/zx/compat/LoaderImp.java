package com.zenmen.palmchat.zx.compat;

import android.content.Context;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.huawei.openalliance.ad.constant.bq;
import com.huawei.openalliance.ad.constant.dc;
import com.kuaishou.weapon.p0.t;
import defpackage.d61;
import defpackage.pm2;
import defpackage.qm2;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0012\u0012\u0004\u0012\u00028\u00000\u0002j\b\u0012\u0004\u0012\u00028\u0000`\u00032\u00020\u0004B%\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010!\u001a\u00020\u001c\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\"¢\u0006\u0004\b(\u0010)J*\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00028\u00000\tj\b\u0012\u0004\u0012\u00028\u0000`\n2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J/\u0010\u000f\u001a\u00020\u000e2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00028\u00000\tj\b\u0012\u0004\u0012\u00028\u0000`\n2\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0011\u001a\u00020\u000e2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00028\u00000\tj\b\u0012\u0004\u0012\u00028\u0000`\nH\u0016R\"\u0010\u0018\u001a\u00020\u00128\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0013\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010!\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\"8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/zenmen/palmchat/zx/compat/LoaderImp;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/loader/app/LoaderManager$LoaderCallbacks;", "Lcom/zenmen/palmchat/zx/compat/LoaderManager_LoaderCallbacks;", "Lqm2;", "", "id", "Landroid/os/Bundle;", "args", "Landroidx/loader/content/Loader;", "Lcom/zenmen/palmchat/zx/compat/Loader;", "onCreateLoader", "loader", "data", "", "onLoadFinished", "(Landroidx/loader/content/Loader;Ljava/lang/Object;)V", "onLoaderReset", "", "a", "Z", t.l, "()Z", "(Z)V", dc.F, "I", "getId", "()I", "Landroid/content/Context;", "c", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lpm2;", "d", "Lpm2;", "getCallback", "()Lpm2;", bq.f.L, "<init>", "(ILandroid/content/Context;Lpm2;)V", "zx-compat_release"}, k = 1, mv = {1, 4, 0})
public final class LoaderImp<T> implements LoaderManager.LoaderCallbacks<T>, qm2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public boolean skip;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final int id;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final Context context;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final pm2<T> callback;

    public LoaderImp(int i, Context context, pm2<T> pm2Var) {
        this.id = i;
        this.context = context;
        this.callback = pm2Var;
    }

    @Override // defpackage.qm2
    public void a(boolean z) {
        this.skip = z;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public boolean getSkip() {
        return this.skip;
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public Loader<T> onCreateLoader(int id, Bundle args) {
        Loader<T> loaderOnCreateLoader = this.callback.onCreateLoader(id, args);
        return loaderOnCreateLoader != null ? loaderOnCreateLoader : new d61(this.context);
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public void onLoadFinished(Loader<T> loader, T data) {
        if (loader instanceof d61) {
            return;
        }
        if (getSkip()) {
            a(false);
        } else {
            this.callback.onLoadFinished(loader, data);
        }
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<T> loader) {
        if (loader instanceof d61) {
            return;
        }
        this.callback.onLoaderReset(loader);
    }
}
