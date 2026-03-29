package com.wifi.ad.core.sensitive;

import android.app.Activity;
import android.content.Context;
import androidx.core.content.ContextCompat;
import com.kuaishou.weapon.p0.g;
import com.ss.android.download.api.constant.BaseConstants;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.ad.core.utils.NestPermissionUtils;
import com.wifi.ad.core.utils.SharePreferenceUtils;
import com.wifi.ad.core.utils.WifiLog;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ \u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u0011¨\u0006\u0013"}, d2 = {"Lcom/wifi/ad/core/sensitive/NestInfoChecker;", "", "()V", "checkImEiRequestSituation", "", "activity", "Landroid/app/Activity;", "checkListener", "Lcom/wifi/ad/core/sensitive/NestInfoChecker$OnImEiRequestSituationListener;", "checkTimeMillisOut24", "", "key", "", "context", "Landroid/content/Context;", "checkTimeMillisOutTime", "time", "", "OnImEiRequestSituationListener", "core_release"}, k = 1, mv = {1, 1, 16})
public final class NestInfoChecker {
    public static final NestInfoChecker INSTANCE = new NestInfoChecker();

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/wifi/ad/core/sensitive/NestInfoChecker$OnImEiRequestSituationListener;", "", "onResult", "", "core_release"}, k = 1, mv = {1, 1, 16})
    public interface OnImEiRequestSituationListener {
        void onResult();
    }

    private NestInfoChecker() {
    }

    public final void checkImEiRequestSituation(Activity activity, final OnImEiRequestSituationListener checkListener) {
        if (ContextCompat.checkSelfPermission(activity, g.c) == 0) {
            WifiLog.d("NestInfoChecker checkImEiRequestSituation canReadPhoneState = true, request ad directly");
            checkListener.onResult();
        } else if (!checkTimeMillisOut24(WifiNestConst.ThirdConst.SP_FILE_LAST_IMEI_TIME, activity)) {
            WifiLog.d("NestInfoChecker checkImEiRequestSituation canReadPhoneState = false,imEiTimeMillisOut24h = false , request ad directly");
            checkListener.onResult();
        } else {
            WifiLog.d("NestInfoChecker checkImEiRequestSituation canReadPhoneState = false,imEiTimeMillisOut24h = true request permission before request ad");
            SharePreferenceUtils.INSTANCE.setLong(WifiNestConst.ThirdConst.SP_FILE_LAST_IMEI_TIME, System.currentTimeMillis(), activity);
            NestPermissionUtils.INSTANCE.requestPhoneStatePermission(activity, new NestPermissionUtils.OnPermissionResult() { // from class: com.wifi.ad.core.sensitive.NestInfoChecker.checkImEiRequestSituation.1
                @Override // com.wifi.ad.core.utils.NestPermissionUtils.OnPermissionResult
                public void onResult(boolean granted) {
                    checkListener.onResult();
                }
            });
        }
    }

    public final boolean checkTimeMillisOut24(String key, Context context) {
        long j = SharePreferenceUtils.INSTANCE.getLong(key, 0L, context);
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        StringBuilder sb = new StringBuilder();
        sb.append("NestInfoChecker checkTimeMillisOut24 key = ");
        sb.append(key);
        sb.append(" duration = ");
        sb.append(jCurrentTimeMillis);
        sb.append(' ');
        sb.append("lastTimeMillis = ");
        sb.append(j);
        sb.append(" currentTimeMills = ");
        sb.append(System.currentTimeMillis());
        sb.append(", out 24h = ");
        long j2 = BaseConstants.Time.DAY;
        sb.append(jCurrentTimeMillis > j2);
        WifiLog.d(sb.toString());
        return jCurrentTimeMillis > j2;
    }

    public final boolean checkTimeMillisOutTime(String key, Context context, long time) {
        long j = SharePreferenceUtils.INSTANCE.getLong(key, 0L, context);
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        StringBuilder sb = new StringBuilder();
        sb.append("NestInfoChecker checkTimeMillisOutTime key = ");
        sb.append(key);
        sb.append(" duration = ");
        sb.append(jCurrentTimeMillis);
        sb.append(' ');
        sb.append("lastTimeMillis = ");
        sb.append(j);
        sb.append(" currentTimeMills = ");
        sb.append(System.currentTimeMillis());
        sb.append(", out ");
        sb.append(time);
        sb.append(" = ");
        sb.append(jCurrentTimeMillis > ((long) BaseConstants.Time.DAY));
        WifiLog.d(sb.toString());
        return jCurrentTimeMillis > time;
    }
}
