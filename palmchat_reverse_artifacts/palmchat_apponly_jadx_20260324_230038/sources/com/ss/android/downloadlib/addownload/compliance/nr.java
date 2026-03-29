package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.ss.android.download.api.config.bg;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.l;
import com.ss.android.downloadlib.x.fx;
import com.ss.android.downloadlib.x.mv;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class nr {
    private SoftReference<Activity> u;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private static nr u = new nr();
    }

    public void nr(long j) {
        com.ss.android.downloadlib.addownload.pn pnVarU = com.ss.android.downloadlib.n.u().u(com.ss.android.downloadlib.addownload.nr.iz.u().pn(j).nr.getDownloadUrl());
        if (pnVarU != null) {
            pnVarU.u(true, true);
        } else {
            x.u(11, j);
            com.ss.android.downloadlib.pn.fx.u().nr("startDownload handler null");
        }
    }

    private nr() {
    }

    public static nr u() {
        return u.u;
    }

    public void u(long j) {
        TTDelegateActivity.u(j);
    }

    public boolean u(DownloadModel downloadModel) {
        if (!downloadModel.isAd() || l.a().optInt("ad_lp_show_app_dialog") == 0) {
            return false;
        }
        String webUrl = downloadModel.getDeepLink() == null ? null : downloadModel.getDeepLink().getWebUrl();
        return (TextUtils.isEmpty(webUrl) || Pattern.compile(l.a().optString("ad_allow_web_url_regex", ".+(www.chengzijianzhan.com|www.toutiaopage.com/tetris/page|ad.toutiao.com/tetris/page).+")).matcher(webUrl).matches()) ? false : true;
    }

    public Activity nr() {
        Activity activity = this.u.get();
        this.u = null;
        return activity;
    }

    public boolean u(@NonNull com.ss.android.downloadlib.addownload.nr.pn pnVar) {
        long jU;
        long j;
        if (!TextUtils.isEmpty(pnVar.nr.getLogExtra())) {
            try {
                jU = mv.u(new JSONObject(pnVar.nr.getLogExtra()), "convert_id");
            } catch (Exception unused) {
                jU = 0;
            }
            if (jU <= 0) {
                x.u(3, pnVar);
            }
            j = jU;
        } else {
            x.u(9, pnVar);
            com.ss.android.downloadlib.pn.fx.u().u("requestAppInfo getLogExtra null");
            j = 0;
        }
        final long j2 = pnVar.u;
        com.ss.android.downloadlib.addownload.nr.nr nrVarU = fx.u().u(j, j2);
        if (nrVarU != null) {
            b.u().u(nrVarU.u(), j2, nrVarU.b);
            u(nrVarU.u());
            x.u("lp_app_dialog_try_show", pnVar);
            return true;
        }
        StringBuilder sb = new StringBuilder();
        if (j > 0) {
            sb.append("convert_id=");
            sb.append(j);
        }
        if (!TextUtils.isEmpty(pnVar.nr.getPackageName())) {
            if (sb.length() > 0) {
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb.append("package_name=");
            sb.append(pnVar.nr.getPackageName());
        }
        if (sb.length() <= 0) {
            x.u(6, pnVar);
            return false;
        }
        final long j3 = j;
        com.ss.android.downloadlib.x.fx.u((fx.u<String, R>) new fx.u<String, Boolean>() { // from class: com.ss.android.downloadlib.addownload.compliance.nr.2
            @Override // com.ss.android.downloadlib.x.fx.u
            public Boolean u(String str) {
                final boolean[] zArr = {false};
                l.b().u("GET", str, new HashMap(), new bg() { // from class: com.ss.android.downloadlib.addownload.compliance.nr.2.1
                    @Override // com.ss.android.download.api.config.bg
                    public void u(String str2) {
                        boolean[] zArr2 = zArr;
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        zArr2[0] = nr.this.u(j3, j2, str2);
                    }

                    @Override // com.ss.android.download.api.config.bg
                    public void u(Throwable th) {
                        x.u(2, j2);
                        zArr[0] = false;
                    }
                });
                return Boolean.valueOf(zArr[0]);
            }
        }, "https://apps.oceanengine.com/customer/api/app/pkg_info?" + sb.toString()).u(new fx.u<Boolean, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.nr.1
            @Override // com.ss.android.downloadlib.x.fx.u
            public Object u(Boolean bool) {
                if (!bool.booleanValue()) {
                    nr.this.nr(j2);
                    return null;
                }
                nr.this.u(com.ss.android.downloadlib.addownload.nr.nr.u(j3, j2));
                x.nr("lp_app_dialog_try_show", j2);
                return null;
            }
        }).u();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u(long j, long j2, String str) {
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("package");
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() != 0) {
                com.ss.android.downloadlib.addownload.nr.nr nrVar = new com.ss.android.downloadlib.addownload.nr.nr();
                nrVar.u = j;
                nrVar.nr = j2;
                nrVar.b = jSONObjectOptJSONObject.optString("icon_url");
                nrVar.pn = jSONObjectOptJSONObject.optString("app_name");
                nrVar.fx = jSONObjectOptJSONObject.optString("package_name");
                nrVar.iz = jSONObjectOptJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
                nrVar.x = jSONObjectOptJSONObject.optString(WfConstant.EXTRA_KEY_DEVELOPER_NAME);
                nrVar.f10589a = jSONObjectOptJSONObject.optString("policy_url");
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("permissions");
                if (jSONArrayOptJSONArray != null) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObject = (JSONObject) jSONArrayOptJSONArray.get(i);
                        nrVar.n.add(new Pair<>(jSONObject.optString("permission_name"), jSONObject.optString("permission_desc")));
                    }
                }
                fx.u().u(nrVar);
                b.u().u(nrVar.u(), j2, nrVar.b);
                return true;
            }
            x.u(7, j2);
            return false;
        } catch (Exception e) {
            com.ss.android.downloadlib.pn.fx.u().u(e, "AdLpComplianceManager parseResponse");
            x.u(7, j2);
            return false;
        }
    }

    public void u(Activity activity) {
        this.u = new SoftReference<>(activity);
    }
}
