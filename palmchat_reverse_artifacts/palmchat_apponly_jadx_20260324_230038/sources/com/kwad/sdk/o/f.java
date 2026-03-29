package com.kwad.sdk.o;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.u;
import com.kwad.sdk.utils.z;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class f {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Resources auh;
    private Resources biQ;
    private i biR;
    private boolean biS;
    private ClassLoader biT;
    private boolean biU;
    private final AtomicBoolean mHasInit;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        private static final f biV = new f(0);
    }

    public /* synthetic */ f(byte b) {
        this();
    }

    private boolean Dv() {
        boolean zCT = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).CT();
        if (!this.biU || zCT) {
            return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Dv();
        }
        return false;
    }

    private static boolean Dw() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Dw();
    }

    public static f UK() {
        return a.biV;
    }

    private boolean UM() {
        Context contextRe = ServiceProvider.Re();
        if (m.ez(contextRe)) {
            this.auh = contextRe.getResources();
            return true;
        }
        ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new IllegalArgumentException("KSPlugin unwrapContextIfNeed fail"));
        return false;
    }

    private boolean UN() {
        Context contextRe;
        Object objA;
        try {
            contextRe = ServiceProvider.Re();
        } catch (Throwable th) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
        }
        if (!m.ez(contextRe)) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new IllegalArgumentException("KSPlugin unwrapContextIfNeed fail"));
            return false;
        }
        Class<?> cls = Class.forName("com.kwad.sdk.api.loader.Loader", false, getClass().getClassLoader());
        Resources resourcesA = null;
        Object objInvoke = cls.getDeclaredMethod("get", new Class[0]).invoke(null, new Object[0]);
        for (Field field : cls.getDeclaredFields()) {
            if (field.getType() != IKsAdSDK.class && field.getType() != Context.class && field.getType() != AtomicBoolean.class && (objA = z.a(field, objInvoke)) != null) {
                for (Field field2 : objA.getClass().getDeclaredFields()) {
                    if (field2.getType() == Resources.class) {
                        field2.setAccessible(true);
                        String strX = com.kwad.sdk.o.a.x(contextRe, u.bg(contextRe));
                        if (TextUtils.isEmpty(strX)) {
                            com.kwad.sdk.core.d.c.d("KSDY/KSPlugin", "find dynamicFile failed");
                        } else {
                            resourcesA = com.kwad.library.b.b.b.a(contextRe, contextRe.getResources(), strX);
                            com.kwad.sdk.core.d.c.d("KSDY/KSPlugin", "use merge res ");
                        }
                        if (resourcesA == null) {
                            resourcesA = (Resources) field2.get(objA);
                        }
                        Resources resources = contextRe.getResources();
                        i iVar = new i(resourcesA, resources);
                        z.a(field2, objA, iVar);
                        this.auh = resources;
                        this.biQ = resourcesA;
                        this.biR = iVar;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean Tn() {
        return this.mHasInit.get();
    }

    public final boolean UL() {
        return this.biU;
    }

    public final ClassLoader getClassLoader() {
        return this.biT;
    }

    public final Resources getResources() {
        boolean zCT = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).CT();
        com.kwad.sdk.core.d.c.d("KSDY/KSPlugin", "getResources mIsInnerDexMode: " + this.biU + ", mHostResources: " + this.auh + ", isExternal: " + zCT);
        return (!this.biU || zCT) ? this.biR : this.auh;
    }

    public final void init() {
        if (this.mHasInit.get()) {
            return;
        }
        try {
            if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).CT()) {
                if (Dv() && UN()) {
                    this.biT = getClass().getClassLoader();
                    j.cx(Dw());
                    com.kwad.sdk.core.d.c.d("KSDY/KSPlugin", toString());
                    this.biS = true;
                } else {
                    this.biS = false;
                }
            } else if (this.biU) {
                j.cx(true);
                UM();
                this.biT = getClass().getClassLoader();
                this.biS = true;
            }
        } catch (Throwable th) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
        }
        this.mHasInit.set(true);
    }

    @NonNull
    public String toString() {
        return "KSPlugin{mHostResources=" + this.auh + ", mResResources=" + this.biQ + ", mPluginResources=" + this.biR + ", mEnable=" + this.biS + '}';
    }

    private f() {
        this.mHasInit = new AtomicBoolean(false);
        this.biU = com.kwad.framework.a.a.apj.booleanValue();
    }
}
