package com.huawei.openalliance.ad.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import com.huawei.hms.ads.fh;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class b {
    private static final String Code = "ActivityUtils";
    private static final int V = 5;

    public static String Code(Context context) {
        Activity activityV = V(context);
        if (activityV != null) {
            fh.Code(Code, "ana_tag  getActivityLocalClassName LocalClassName = %s", activityV.getLocalClassName());
            return activityV.getLocalClassName();
        }
        fh.Z(Code, "ana_tag  getActivityLocalClassName LocalClassName is null");
        return "";
    }

    private static Activity V(Context context) {
        if (context == null) {
            fh.Z(Code, "ana_tag getActivity context is null, return");
            return null;
        }
        int i = 0;
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            i++;
            if (i > 5) {
                fh.Z(Code, "ana_tag getActivity loop too much times, return");
                return null;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public static String Code(Object obj) {
        String str;
        if (obj == null) {
            str = "ana_tag getActivityName obj is null, return";
        } else {
            if (obj instanceof View) {
                return Code(((View) obj).getContext());
            }
            str = "ana_tag  getActivityName activityname is not view";
        }
        fh.Z(Code, str);
        return null;
    }
}
