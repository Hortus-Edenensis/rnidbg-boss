package com.huawei.hms.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.huawei.openalliance.ad.beans.inner.AnalysisEventReport;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class fc {
    private static final String Code = "ActivityLifecycleListener";
    private fd I;
    private boolean V = false;

    public fc(fd fdVar) {
        this.I = fdVar;
    }

    private AdContentData I() {
        fd fdVar = this.I;
        if (fdVar != null) {
            return fdVar.getContentRecord();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(Activity activity, String str) {
        Context contextZ;
        AdContentData adContentDataI;
        String str2;
        if (Code() && I(activity, str)) {
            if ((I() == null || com.huawei.openalliance.ad.utils.bc.Code(I().i())) && Z() != null) {
                contextZ = Z();
                adContentDataI = I();
                str2 = "Failed to open the landing page after the app is canceled";
            } else {
                new kl(Z(), I(), false, new HashMap(0)).Code();
                contextZ = Z();
                adContentDataI = I();
                str2 = "Succeed to open the landing page after the app is canceled";
            }
            Code(contextZ, adContentDataI, str2);
        }
    }

    private Context Z() {
        fd fdVar = this.I;
        if (fdVar != null) {
            return fdVar.getActivityContext();
        }
        return null;
    }

    public void Code(Activity activity) {
        if (activity == null || com.huawei.openalliance.ad.utils.bc.Code(activity.getClass().getCanonicalName())) {
            return;
        }
        final String canonicalName = activity.getClass().getCanonicalName();
        if (Build.VERSION.SDK_INT >= 29) {
            activity.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.huawei.hms.ads.fc.1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity2) {
                    try {
                        fc.this.V(activity2, canonicalName);
                    } catch (Throwable th) {
                        fh.Z(fc.Code, "onActivityResumed err: %s", th.getClass().getSimpleName());
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity2) {
                    try {
                        fc.this.Code(activity2, canonicalName);
                    } catch (Throwable th) {
                        fh.Z(fc.Code, "onActivityStopped err: %s", th.getClass().getSimpleName());
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity2) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity2) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity2) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity2, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity2, Bundle bundle) {
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(Activity activity, String str) {
        this.V = V() && I(activity, str);
    }

    private boolean I(Activity activity, String str) {
        return (activity == null || com.huawei.openalliance.ad.utils.bc.Code(str) || !str.equals(activity.getClass().getCanonicalName())) ? false : true;
    }

    private void Code(Context context, AdContentData adContentData, String str) {
        if (context == null) {
            return;
        }
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        analysisEventReport.V(com.huawei.openalliance.ad.beans.inner.a.b);
        analysisEventReport.I(context.getClass().getCanonicalName());
        analysisEventReport.Z(str);
        new db().Code(context, analysisEventReport, adContentData);
    }

    private boolean V() {
        fd fdVar = this.I;
        return fdVar != null && fdVar.Code();
    }

    private boolean Code() {
        return !this.V && V();
    }
}
