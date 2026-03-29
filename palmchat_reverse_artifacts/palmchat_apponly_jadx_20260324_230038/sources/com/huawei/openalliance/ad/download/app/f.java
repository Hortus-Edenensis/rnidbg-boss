package com.huawei.openalliance.ad.download.app;

import android.content.Context;
import com.huawei.hms.ads.base.R;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.r;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class f {
    public static void Code(Context context, long j, r.a aVar) {
        r.Code(context, context.getString(R.string.hiad_reminder_app_over_size, Long.valueOf(j)), context.getString(R.string.hiad_download_app_via_mobile_data), context.getString(R.string.hiad_continue_download_new), context.getString(R.string.hiad_dialog_cancel), aVar);
    }

    public static void V(Context context, long j, r.a aVar) {
        r.Code(context, context.getString(R.string.hiad_dialog_title_tip), com.huawei.openalliance.ad.utils.k.Code(context, R.string.hiad_download_use_mobile_network, "hiad_download_use_mobile_network", bc.Code(context, j)), context.getString(R.string.hiad_continue_download_new), context.getString(R.string.hiad_dialog_cancel), aVar);
    }

    public static void Code(Context context, boolean z, r.a aVar) {
        r.Code(context, "", context.getString(z ? R.string.hiad_confirm_restore_app : R.string.hiad_confirm_download_app), context.getString(R.string.hiad_download_install), context.getString(R.string.hiad_dialog_cancel), aVar);
    }
}
