package com.ss.android.downloadlib.nr;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mapapi.SDKInitializer;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.l;
import com.ss.android.downloadlib.x.mv;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class u {
    private static final String u = "u";

    public static void nr(com.ss.android.downloadad.api.u.nr nrVar) {
        if (nrVar == null) {
            return;
        }
        String strIz = com.ss.android.socialbase.downloader.n.u.fx().nr("app_link_opt") == 1 ? nrVar.iz() : null;
        JSONObject jSONObjectU = com.ss.android.downloadlib.x.iz.u(new JSONObject(), nrVar);
        mv.u(jSONObjectU, "applink_source", "dialog_click_by_sdk");
        com.ss.android.downloadlib.b.u.u().nr("applink_click", jSONObjectU, nrVar);
        com.ss.android.downloadlib.addownload.nr.x xVarU = com.ss.android.downloadlib.x.a.u(strIz, nrVar);
        if (xVarU.getType() == 2) {
            if (!TextUtils.isEmpty(strIz)) {
                nr("dialog_by_url", xVarU, jSONObjectU, nrVar);
            }
            xVarU = com.ss.android.downloadlib.x.a.u(l.getContext(), nrVar.pn(), nrVar);
        }
        int type = xVarU.getType();
        if (type == 1) {
            nr("dialog_by_url", jSONObjectU, nrVar);
            return;
        }
        if (type == 3) {
            u("dialog_by_package", jSONObjectU, nrVar);
        } else if (type != 4) {
            com.ss.android.downloadlib.pn.fx.u().nr("AppLinkClickDialog default");
        } else {
            u("dialog_by_package", xVarU, jSONObjectU, nrVar);
        }
    }

    public static boolean u(@NonNull com.ss.android.downloadlib.addownload.nr.pn pnVar) {
        boolean z;
        DeepLink deepLink = pnVar.nr.getDeepLink();
        String openUrl = deepLink == null ? null : deepLink.getOpenUrl();
        JSONObject jSONObjectU = com.ss.android.downloadlib.x.iz.u(new JSONObject(), pnVar);
        mv.u(jSONObjectU, "applink_source", "click_by_sdk");
        com.ss.android.downloadlib.b.u.u().nr("applink_click", jSONObjectU, pnVar);
        com.ss.android.downloadlib.addownload.nr.x xVarU = com.ss.android.downloadlib.x.a.u(openUrl, pnVar);
        if (xVarU.getType() == 2) {
            if (!TextUtils.isEmpty(openUrl)) {
                nr("by_url", xVarU, jSONObjectU, pnVar);
            }
            xVarU = com.ss.android.downloadlib.x.a.u(l.getContext(), pnVar.nr.getPackageName(), pnVar);
        }
        boolean z2 = false;
        if (u(pnVar.u) && l.a().optInt("link_ad_click_event") == 1) {
            DownloadModel downloadModel = pnVar.nr;
            if (downloadModel instanceof AdDownloadModel) {
                ((AdDownloadModel) downloadModel).setFunnelType(4);
            }
            com.ss.android.downloadlib.b.u.u().u(pnVar.u, 0);
            z = true;
        } else {
            z = false;
        }
        int type = xVarU.getType();
        if (type == 1) {
            nr("by_url", jSONObjectU, pnVar);
        } else {
            if (type != 3) {
                if (type != 4) {
                    com.ss.android.downloadlib.pn.fx.u().nr("AppLinkClick default");
                } else {
                    u("by_package", xVarU, jSONObjectU, pnVar);
                }
                if (z2 && !z && ((com.ss.android.downloadlib.b.fx.u().nr() && !com.ss.android.downloadlib.b.fx.u().nr(pnVar.u, pnVar.nr.getLogExtra())) || com.ss.android.downloadlib.b.fx.u().fx())) {
                    com.ss.android.downloadlib.b.u.u().u(pnVar.u, 2);
                }
                return z2;
            }
            u("by_package", jSONObjectU, pnVar);
        }
        z2 = true;
        if (z2) {
            com.ss.android.downloadlib.b.u.u().u(pnVar.u, 2);
        }
        return z2;
    }

    public static void nr(String str, @NonNull final JSONObject jSONObject, @NonNull final com.ss.android.downloadad.api.u.u uVar) {
        mv.u(jSONObject, "applink_source", str);
        mv.u(jSONObject, "download_scene", Integer.valueOf(uVar.bq()));
        com.ss.android.downloadlib.b.u.u().nr("deeplink_url_open", jSONObject, uVar);
        str.hashCode();
        switch (str) {
            case "auto_by_url":
            case "by_url":
            case "notify_by_url":
            case "dialog_by_url":
                if ((l.a().optInt("check_applink_mode") & 1) != 0) {
                    mv.u(jSONObject, "check_applink_result_by_sdk", (Object) 1);
                    pn.u().u(new b() { // from class: com.ss.android.downloadlib.nr.u.2
                        @Override // com.ss.android.downloadlib.nr.b
                        public void u(boolean z) {
                            com.ss.android.downloadlib.b.u.u().nr(z ? "deeplink_success" : "deeplink_failed", jSONObject, uVar);
                            if (z) {
                                l.dw();
                                l.getContext();
                                uVar.dw();
                                uVar.q();
                                uVar.c();
                                uVar.pn();
                            }
                        }
                    });
                    break;
                } else {
                    l.nr();
                    l.getContext();
                    uVar.dw();
                    uVar.q();
                    uVar.c();
                    uVar.pn();
                    break;
                }
                break;
        }
    }

    public static void u(@NonNull com.ss.android.downloadad.api.u.nr nrVar) {
        String strIz = nrVar.iz();
        JSONObject jSONObjectU = com.ss.android.downloadlib.x.iz.u(new JSONObject(), nrVar);
        mv.u(jSONObjectU, "applink_source", "notify_click_by_sdk");
        com.ss.android.downloadlib.b.u.u().nr("applink_click", jSONObjectU, nrVar);
        com.ss.android.downloadlib.addownload.nr.x xVarU = com.ss.android.downloadlib.x.a.u(strIz, nrVar);
        if (xVarU.getType() == 2) {
            if (!TextUtils.isEmpty(strIz)) {
                nr("notify_by_url", xVarU, jSONObjectU, nrVar);
            }
            xVarU = com.ss.android.downloadlib.x.a.u(l.getContext(), nrVar.pn(), nrVar);
        }
        int type = xVarU.getType();
        if (type == 1) {
            nr("notify_by_url", jSONObjectU, nrVar);
            return;
        }
        if (type == 3) {
            u("notify_by_package", jSONObjectU, nrVar);
        } else if (type != 4) {
            com.ss.android.downloadlib.pn.fx.u().nr("AppLinkClickNotification default");
        } else {
            u("notify_by_package", xVarU, jSONObjectU, nrVar);
        }
    }

    public static void nr(String str, @NonNull com.ss.android.downloadlib.addownload.nr.x xVar, @NonNull JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.u.u uVar) {
        mv.u(jSONObject, "applink_source", str);
        mv.u(jSONObject, SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, Integer.valueOf(xVar.u()));
        mv.u(jSONObject, "download_scene", Integer.valueOf(uVar.bq()));
        com.ss.android.downloadlib.b.u.u().nr("deeplink_url_open_fail", jSONObject, uVar);
    }

    public static boolean u(String str, @NonNull com.ss.android.downloadad.api.u.nr nrVar) {
        if (!com.ss.android.downloadlib.addownload.a.nr(nrVar.oa())) {
            return false;
        }
        if (TextUtils.isEmpty(nrVar.iz()) && TextUtils.isEmpty(str)) {
            return false;
        }
        com.ss.android.socialbase.downloader.notification.nr.u().iz(nrVar.bg());
        JSONObject jSONObject = new JSONObject();
        com.ss.android.downloadlib.x.iz.u(jSONObject, nrVar);
        mv.u(jSONObject, "applink_source", "auto_click");
        com.ss.android.downloadlib.b.u.u().nr("applink_click", nrVar);
        com.ss.android.downloadlib.addownload.nr.x xVarU = com.ss.android.downloadlib.x.a.u(nrVar, nrVar.iz(), nrVar.pn());
        int type = xVarU.getType();
        if (type == 1) {
            nr("auto_by_url", jSONObject, nrVar);
            return true;
        }
        if (type == 2) {
            nr("auto_by_url", xVarU, jSONObject, nrVar);
            return false;
        }
        if (type == 3) {
            u("auto_by_package", jSONObject, nrVar);
            return true;
        }
        if (type != 4) {
            return false;
        }
        u("auto_by_package", xVarU, jSONObject, nrVar);
        return false;
    }

    public static void u(String str, @NonNull final JSONObject jSONObject, @NonNull final com.ss.android.downloadad.api.u.u uVar) {
        mv.u(jSONObject, "applink_source", str);
        mv.u(jSONObject, "download_scene", Integer.valueOf(uVar.bq()));
        com.ss.android.downloadlib.b.u.u().nr("deeplink_app_open", jSONObject, uVar);
        str.hashCode();
        switch (str) {
            case "notify_by_package":
            case "auto_by_package":
            case "by_package":
            case "dialog_by_package":
                if ((l.a().optInt("check_applink_mode") & 1) != 0) {
                    mv.u(jSONObject, "check_applink_result_by_sdk", (Object) 1);
                    pn.u().u(new b() { // from class: com.ss.android.downloadlib.nr.u.1
                        @Override // com.ss.android.downloadlib.nr.b
                        public void u(boolean z) {
                            com.ss.android.downloadlib.b.u.u().nr(z ? "deeplink_success" : "deeplink_failed", jSONObject, uVar);
                            if (z) {
                                l.dw();
                                l.getContext();
                                uVar.dw();
                                uVar.q();
                                uVar.c();
                                uVar.pn();
                            }
                        }
                    });
                    break;
                } else {
                    l.nr();
                    l.getContext();
                    uVar.dw();
                    uVar.q();
                    uVar.c();
                    uVar.pn();
                    break;
                }
                break;
        }
    }

    public static void u(String str, @NonNull com.ss.android.downloadlib.addownload.nr.x xVar, @NonNull JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.u.u uVar) {
        mv.u(jSONObject, "applink_source", str);
        mv.u(jSONObject, SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, Integer.valueOf(xVar.u()));
        mv.u(jSONObject, "download_scene", Integer.valueOf(uVar.bq()));
        com.ss.android.downloadlib.b.u.u().nr("deeplink_app_open_fail", jSONObject, uVar);
    }

    public static boolean u(@NonNull com.ss.android.downloadlib.addownload.nr.pn pnVar, int i) {
        JSONObject jSONObject = new JSONObject();
        mv.u(jSONObject, "download_scene", Integer.valueOf(pnVar.bq()));
        com.ss.android.downloadlib.b.u.u().nr("market_click_open", jSONObject, pnVar);
        com.ss.android.downloadlib.addownload.nr.x xVarU = com.ss.android.downloadlib.x.a.u(l.getContext(), pnVar, pnVar.nr.getPackageName());
        String strU = mv.u(xVarU.nr(), "open_market");
        int type = xVarU.getType();
        if (type == 5) {
            u(strU, jSONObject, pnVar, true);
        } else {
            if (type == 6) {
                mv.u(jSONObject, SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, Integer.valueOf(xVarU.u()));
                mv.u(jSONObject, "download_scene", Integer.valueOf(pnVar.bq()));
                com.ss.android.downloadlib.b.u.u().nr("market_open_failed", jSONObject, pnVar);
                return false;
            }
            if (type != 7) {
                return false;
            }
        }
        com.ss.android.downloadlib.b.u.u().u(pnVar.u, i);
        return true;
    }

    public static void u(final String str, @Nullable final JSONObject jSONObject, final com.ss.android.downloadlib.addownload.nr.pn pnVar, boolean z) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception e) {
                com.ss.android.downloadlib.pn.fx.u().u(e, "onMarketSuccess");
                return;
            }
        }
        mv.u(jSONObject, "applink_source", str);
        mv.u(jSONObject, "download_scene", Integer.valueOf(pnVar.bq()));
        if (z) {
            com.ss.android.downloadlib.b.u.u().nr("market_open_success", jSONObject, pnVar);
        }
        if ((l.a().optInt("check_applink_mode") & 4) != 0) {
            pn.u().nr(new b() { // from class: com.ss.android.downloadlib.nr.u.3
                @Override // com.ss.android.downloadlib.nr.b
                public void u(boolean z2) {
                    if (!z2 && !"open_market".equals(str)) {
                        u.u(com.ss.android.downloadlib.x.a.u(l.getContext(), Uri.parse(BaseConstants.MARKET_PREFIX + pnVar.pn())), pnVar, false);
                    }
                    com.ss.android.downloadlib.b.u.u().u(z2 ? "market_delay_success" : "market_delay_failed", jSONObject, pnVar);
                    if (z2) {
                        l.dw();
                        l.getContext();
                        pnVar.nr.getPackageName();
                    }
                }
            });
        } else {
            l.nr();
            l.getContext();
            pnVar.nr.getPackageName();
        }
        com.ss.android.downloadad.api.u.nr nrVarU = com.ss.android.downloadlib.addownload.nr.iz.u().u(pnVar.nr.getPackageName());
        if (nrVarU != null) {
            com.ss.android.downloadlib.x.l.u().u(u, "onMarketSuccess", "商店场景,缓存中已有NativeDownloadModel记录,进行复用");
        } else {
            com.ss.android.downloadlib.x.l.u().u(u, "onMarketSuccess", "商店场景,缓存中没有相应的NativeDownloadModel,需要新建");
            nrVarU = new com.ss.android.downloadad.api.u.nr(pnVar.nr, pnVar.fx, pnVar.b);
        }
        nrVarU.pn(2);
        nrVarU.iz(System.currentTimeMillis());
        nrVarU.n(4);
        nrVarU.a(2);
        com.ss.android.downloadlib.addownload.nr.iz.u().u(nrVarU);
        com.ss.android.downloadlib.x.l.u().u(u, "onMarketSuccess", "检测到跳商店成功事件,准备开始检测安装行为");
        com.ss.android.downloadlib.a.u().u(pnVar, nrVarU);
    }

    public static void u(com.ss.android.downloadlib.addownload.nr.x xVar, com.ss.android.downloadlib.addownload.nr.pn pnVar, boolean z) {
        String strU = mv.u(xVar.nr(), "open_market");
        JSONObject jSONObject = new JSONObject();
        mv.u(jSONObject, "ttdownloader_type", LiveConfigKey.BACKUP);
        int type = xVar.getType();
        if (type == 5) {
            u(strU, jSONObject, pnVar, z);
        } else {
            if (type != 6) {
                return;
            }
            mv.u(jSONObject, SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, Integer.valueOf(xVar.u()));
            mv.u(jSONObject, "download_scene", Integer.valueOf(pnVar.bq()));
            com.ss.android.downloadlib.b.u.u().nr("market_open_failed", jSONObject, pnVar);
        }
    }

    public static boolean u(long j) {
        return com.ss.android.downloadlib.addownload.nr.iz.u().b(j) == null;
    }
}
