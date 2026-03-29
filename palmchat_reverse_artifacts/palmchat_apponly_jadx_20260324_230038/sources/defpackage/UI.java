package defpackage;

import android.content.Context;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.app.LoaderManager;
import com.huawei.openalliance.ad.constant.bq;
import com.kuaishou.weapon.p0.t;
import com.zenmen.palmchat.zx.compat.LoaderImp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: s43, reason: from Kotlin metadata */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a[\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010\u001a[\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\f¢\u0006\u0004\b\u0011\u0010\u0010\u001a<\u0010\u0016\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u00012\u000e\u0010\u0014\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u00132\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\u001a<\u0010\u0017\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u00012\u000e\u0010\u0014\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u00132\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\u001a\u001b\u0010\u0018\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"UI", ExifInterface.GPS_DIRECTION_TRUE, "ui", "Landroid/content/Context;", "context", "Landroidx/loader/app/LoaderManager;", "Lcom/zenmen/palmchat/zx/compat/LoaderManager;", "lm", "", "id", "Landroid/os/Bundle;", "args", "Lpm2;", bq.f.L, "Lcom/zenmen/palmchat/zx/compat/LoaderImp;", t.l, "(Ljava/lang/Object;Landroid/content/Context;Landroidx/loader/app/LoaderManager;ILandroid/os/Bundle;Lpm2;)Lcom/zenmen/palmchat/zx/compat/LoaderImp;", "d", "Landroidx/fragment/app/FragmentActivity;", "Lcom/zenmen/palmchat/zx/compat/FragmentActivity;", "fa", "", "c", "e", "a", "(Ljava/lang/Object;)V", "zx-compat_release"}, k = 2, mv = {1, 4, 0})
public final class UI {
    public static final <UI> void a(UI ui) {
        r43 r43Var;
        if (!(ui instanceof rm2) || (r43Var = ((rm2) ui).get__sw_loaders__()) == null) {
            return;
        }
        r43Var.b();
    }

    public static final <UI, T> LoaderImp<T> b(UI ui, Context context, LoaderManager loaderManager, int i, Bundle bundle, pm2<T> pm2Var) {
        LoaderImp<T> loaderImp = new LoaderImp<>(i, context, pm2Var);
        loaderManager.initLoader(i, bundle, loaderImp);
        if (ui instanceof rm2) {
            rm2 rm2Var = (rm2) ui;
            if (rm2Var.get__sw_loaders__() == null) {
                rm2Var.a0(new r43());
            }
            r43 r43Var = rm2Var.get__sw_loaders__();
            if (r43Var == null) {
                Intrinsics.throwNpe();
            }
            r43Var.a().put(Integer.valueOf(i), loaderImp);
        }
        return loaderImp;
    }

    public static final <T> void c(FragmentActivity fragmentActivity, int i, Bundle bundle, pm2<T> pm2Var) {
        if (fragmentActivity != null) {
            LoaderManager supportLoaderManager = fragmentActivity.getSupportLoaderManager();
            Intrinsics.checkExpressionValueIsNotNull(supportLoaderManager, "fa.supportLoaderManager");
            b(fragmentActivity, fragmentActivity, supportLoaderManager, i, bundle, pm2Var);
        }
    }

    public static final <UI, T> LoaderImp<T> d(UI ui, Context context, LoaderManager loaderManager, int i, Bundle bundle, pm2<T> pm2Var) {
        LoaderImp<T> loaderImp = new LoaderImp<>(i, context, pm2Var);
        loaderManager.restartLoader(i, bundle, loaderImp);
        if (ui instanceof rm2) {
            rm2 rm2Var = (rm2) ui;
            if (rm2Var.get__sw_loaders__() == null) {
                rm2Var.a0(new r43());
            }
            r43 r43Var = rm2Var.get__sw_loaders__();
            if (r43Var == null) {
                Intrinsics.throwNpe();
            }
            r43Var.a().put(Integer.valueOf(i), loaderImp);
        }
        return loaderImp;
    }

    public static final <T> void e(FragmentActivity fragmentActivity, int i, Bundle bundle, pm2<T> pm2Var) {
        if (fragmentActivity != null) {
            LoaderManager supportLoaderManager = fragmentActivity.getSupportLoaderManager();
            Intrinsics.checkExpressionValueIsNotNull(supportLoaderManager, "fa.supportLoaderManager");
            d(fragmentActivity, fragmentActivity, supportLoaderManager, i, bundle, pm2Var);
        }
    }
}
