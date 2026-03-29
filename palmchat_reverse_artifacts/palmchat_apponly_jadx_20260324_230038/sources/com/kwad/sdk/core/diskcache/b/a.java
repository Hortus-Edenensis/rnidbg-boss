package com.kwad.sdk.core.diskcache.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.be;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {
    private com.kwad.sdk.core.diskcache.a.a aHS;

    /* JADX INFO: renamed from: com.kwad.sdk.core.diskcache.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C0606a {
        static final a aHT = new a(0);
    }

    private a() {
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    public static a IJ() {
        return C0606a.aHT;
    }

    private boolean IK() {
        init(((f) ServiceProvider.get(f.class)).getContext());
        return this.aHS == null;
    }

    @Nullable
    private File dU(String str) {
        if (IK() || TextUtils.isEmpty(str)) {
            return null;
        }
        return b.a(this.aHS, str);
    }

    private synchronized void init(Context context) {
        if (this.aHS != null || context == null) {
            return;
        }
        try {
            this.aHS = com.kwad.sdk.core.diskcache.a.a.a(be.dQ(context), 1, 1, 209715200L);
        } catch (Throwable unused) {
        }
    }

    public final boolean a(String str, a.C0614a c0614a) {
        File fileDU;
        if (!IK() && !TextUtils.isEmpty(str)) {
            String strDV = c.dV(str);
            if (b.a(this.aHS, str, strDV, c0614a) && (fileDU = dU(strDV)) != null && fileDU.exists()) {
                return true;
            }
        }
        return false;
    }

    public final boolean b(String str, @NonNull String str2, a.C0614a c0614a) {
        File fileDU;
        if (!IK() && !TextUtils.isEmpty(str)) {
            String strDV = c.dV(str2);
            if (b.a(this.aHS, str, strDV, c0614a) && (fileDU = dU(strDV)) != null && fileDU.exists()) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final File cr(String str) {
        if (IK() || TextUtils.isEmpty(str)) {
            return null;
        }
        return dU(c.dV(str));
    }

    public final void dT(String str) {
        if (IK() || TextUtils.isEmpty(str)) {
            return;
        }
        b.a(this.aHS, str, c.dV(str));
    }

    public final void delete() {
        if (IK()) {
            return;
        }
        try {
            this.aHS.delete();
        } catch (IOException unused) {
        }
    }

    public final boolean remove(String str) {
        if (IK()) {
            return false;
        }
        try {
            ax.aA(str, "cacheKey is not allowed empty");
            return this.aHS.remove(c.dV(str));
        } catch (IOException unused) {
            return false;
        }
    }
}
