package com.ss.android.socialbase.appdownloader.pn;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.appdownloader.a;
import com.ss.android.socialbase.appdownloader.pn;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.jk.iz;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class u extends com.ss.android.socialbase.downloader.notification.u {
    private String b;
    private final Resources fx;
    private String iz;
    private final Context nr;
    private String pn;

    public u(Context context, int i, String str, String str2, String str3, String str4) {
        super(i, str);
        this.pn = str2;
        this.b = str3;
        this.iz = str4;
        Context applicationContext = context.getApplicationContext();
        this.nr = applicationContext;
        this.fx = applicationContext.getResources();
    }

    private RemoteViews a() {
        RemoteViews remoteViews = new RemoteViews(this.nr.getPackageName(), pn.u());
        try {
            if (com.ss.android.socialbase.appdownloader.fx.u(this.nr)) {
                remoteViews.setInt(pn.iz(), "setBackgroundColor", this.nr.getResources().getColor(pn.sx()));
            }
        } catch (Throwable unused) {
        }
        return remoteViews;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:13:0x0044
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    private androidx.core.app.NotificationCompat.Builder jk() {
        /*
            r3 = this;
            com.ss.android.socialbase.appdownloader.b r0 = com.ss.android.socialbase.appdownloader.b.t()
            java.lang.String r0 = r0.jk()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r1 >= r2) goto L16
            androidx.core.app.NotificationCompat$Builder r0 = new androidx.core.app.NotificationCompat$Builder
            android.content.Context r1 = r3.nr
            r0.<init>(r1)
            goto L4b
        L16:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L22
            android.content.Context r0 = r3.nr
            java.lang.String r0 = com.ss.android.socialbase.appdownloader.fx.nr(r0)
        L22:
            com.ss.android.socialbase.appdownloader.b r1 = com.ss.android.socialbase.appdownloader.b.t()     // Catch: java.lang.NoSuchMethodError -> L44
            com.ss.android.socialbase.appdownloader.fx.s r1 = r1.s()     // Catch: java.lang.NoSuchMethodError -> L44
            if (r1 == 0) goto L3b
            com.ss.android.socialbase.appdownloader.b r1 = com.ss.android.socialbase.appdownloader.b.t()     // Catch: java.lang.NoSuchMethodError -> L44
            com.ss.android.socialbase.appdownloader.fx.s r1 = r1.s()     // Catch: java.lang.NoSuchMethodError -> L44
            android.content.Context r2 = r3.nr     // Catch: java.lang.NoSuchMethodError -> L44
            androidx.core.app.NotificationCompat$Builder r0 = r1.u(r2, r0)     // Catch: java.lang.NoSuchMethodError -> L44
            goto L4b
        L3b:
            androidx.core.app.NotificationCompat$Builder r1 = new androidx.core.app.NotificationCompat$Builder     // Catch: java.lang.NoSuchMethodError -> L44
            android.content.Context r2 = r3.nr     // Catch: java.lang.NoSuchMethodError -> L44
            r1.<init>(r2, r0)     // Catch: java.lang.NoSuchMethodError -> L44
            r0 = r1
            goto L4b
        L44:
            androidx.core.app.NotificationCompat$Builder r0 = new androidx.core.app.NotificationCompat$Builder
            android.content.Context r1 = r3.nr
            r0.<init>(r1)
        L4b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.pn.u.jk():androidx.core.app.NotificationCompat$Builder");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:160:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0464  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x04c2  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0235  */
    /* JADX WARN: Type inference failed for: r10v13, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Notification nr(BaseException baseException, boolean z) {
        boolean z2;
        long j;
        int i;
        NotificationCompat.Builder builder;
        String string;
        String string2;
        String str;
        String str2;
        BaseException baseException2;
        String string3;
        String str3;
        String string4;
        int iT;
        int iNr;
        String str4;
        int iNr2;
        boolean z3;
        ?? r10;
        int iPn = pn();
        int iU = com.ss.android.socialbase.appdownloader.fx.u(iPn);
        if (iU == 0) {
            return null;
        }
        NotificationCompat.Builder builderJk = jk();
        builderJk.setWhen(iz());
        int iU2 = u();
        com.ss.android.socialbase.downloader.n.u uVarU = com.ss.android.socialbase.downloader.n.u.u(iU2);
        if (Build.VERSION.SDK_INT >= 24 && uVarU.u("set_notification_group", 0) == 1) {
            builderJk.setGroup("com.ss.android.socialbase.APP_DOWNLOADER");
            builderJk.setGroupSummary(false);
        }
        int iQ = pn.q();
        if (iQ != 0) {
            builderJk.setSmallIcon(iQ);
            z2 = false;
        } else {
            z2 = true;
        }
        builderJk.setStyle(new NotificationCompat.DecoratedCustomViewStyle());
        int iU3 = u(iU, iU2);
        if (z2 && iU3 != 0) {
            builderJk.setSmallIcon(iU3);
        }
        String str5 = "android.ss.intent.action.DOWNLOAD_CLICK_CONTENT";
        if (iU == 1 || iU == 4 || iU == 2) {
            builderJk.setContentIntent(u("android.ss.intent.action.DOWNLOAD_CLICK_CONTENT", iU, iU2));
            builderJk.setAutoCancel(false);
        } else if (iU == 3) {
            builderJk.setAutoCancel(true);
            if (iPn != -1 && iPn != -4) {
                if (iPn == -3 && uVarU.u("notification_click_install_auto_cancel", 1) == 0) {
                    builderJk.setAutoCancel(false);
                }
                str5 = "android.ss.intent.action.DOWNLOAD_OPEN";
            }
            builderJk.setContentIntent(u(str5, iU, iU2));
            builderJk.setDeleteIntent(u("android.ss.intent.action.DOWNLOAD_HIDE", iU, iU2));
        }
        long jNr = nr();
        long jFx = fx();
        if (jFx > 0) {
            j = jNr;
            i = (int) ((100 * jNr) / jFx);
        } else {
            j = jNr;
            i = 0;
        }
        String strB = b();
        if (TextUtils.isEmpty(strB)) {
            strB = this.fx.getString(a.nr("tt_appdownloader_download_unknown_title"));
        }
        RemoteViews remoteViewsA = a();
        int iT2 = pn.t();
        if (com.ss.android.socialbase.downloader.n.u.u(iU2).nr("notification_opt_2") != 1) {
            remoteViewsA.setOnClickPendingIntent(iT2, u("android.ss.intent.action.DOWNLOAD_CLICK_BTN", iU, iU2));
        }
        if (com.ss.android.socialbase.downloader.n.u.u(iU2).nr("enable_notification_ui") > 0) {
            remoteViewsA.setInt(iT2, "setBackgroundResource", pn.bg());
            remoteViewsA.setTextColor(iT2, -1);
        }
        remoteViewsA.setTextViewText(pn.mv(), strB);
        int iU4 = u(iU2);
        remoteViewsA.setViewVisibility(iU4, 0);
        remoteViewsA.setProgressBar(iU4, 100, i, z);
        int iL = pn.l();
        if (iU3 != 0) {
            remoteViewsA.setImageViewResource(iL, iU3);
        }
        if (com.ss.android.socialbase.downloader.n.u.u(iU2).nr("enable_notification_ui") > 0) {
            Bitmap bitmapU = fx.u().u(iU2);
            if (bitmapU != null) {
                remoteViewsA.setInt(iL, "setBackgroundColor", 0);
                remoteViewsA.setImageViewBitmap(iL, bitmapU);
            } else {
                remoteViewsA.setInt(iL, "setBackgroundResource", pn.bg());
            }
        }
        if (iU == 1 || iU == 4) {
            builder = builderJk;
            String str6 = com.ss.android.socialbase.appdownloader.fx.u(j) + "/" + com.ss.android.socialbase.appdownloader.fx.u(jFx);
            string = this.nr.getResources().getString(iU == 1 ? pn() == 11 ? a.nr("tt_appdownloader_notification_waiting_download_complete_handler") : a.nr("tt_appdownloader_notification_downloading") : a.nr("tt_appdownloader_notification_prepare"));
            string2 = this.nr.getResources().getString(a.nr("tt_appdownloader_notification_download_pause"));
            remoteViewsA.setViewVisibility(u(iU2), 0);
            remoteViewsA.setViewVisibility(pn.a(), 8);
            remoteViewsA.setViewVisibility(pn.jk(), 0);
            int iT3 = pn.t();
            if (com.ss.android.socialbase.appdownloader.fx.u(this.iz)) {
                remoteViewsA.setViewVisibility(iT3, 8);
            } else {
                remoteViewsA.setViewVisibility(iT3, 0);
            }
            if (uVarU.nr("enable_notification_ui") >= 2) {
                remoteViewsA.setViewVisibility(iT3, 8);
            }
            str = str6;
        } else if (iU == 2) {
            str = com.ss.android.socialbase.appdownloader.fx.u(j) + "/" + com.ss.android.socialbase.appdownloader.fx.u(jFx);
            string = this.nr.getResources().getString(a.nr("tt_appdownloader_notification_pausing"));
            string2 = this.nr.getResources().getString(a.nr("tt_appdownloader_notification_download_resume"));
            if (uVarU.nr("notification_opt_2") != 1) {
                z3 = false;
                z3 = false;
                remoteViewsA.setViewVisibility(pn.jk(), 0);
                int iU5 = u(iU2);
                if (uVarU.nr("enable_notification_ui") >= 2) {
                    remoteViewsA.setViewVisibility(iU5, 0);
                } else {
                    remoteViewsA.setViewVisibility(iU5, 8);
                }
            } else if (i >= uVarU.u("noti_progress_show_th", 70)) {
                z3 = false;
                remoteViewsA.setViewVisibility(u(iU2), 0);
                remoteViewsA.setViewVisibility(pn.jk(), 0);
            } else {
                r10 = 0;
                remoteViewsA.setViewVisibility(u(iU2), 8);
                remoteViewsA.setViewVisibility(pn.jk(), 8);
                remoteViewsA.setViewVisibility(pn.a(), 0);
                remoteViewsA.setViewVisibility(pn.k(), 8);
                string = this.fx.getString(a.nr("tt_appdownloader_notification_download_continue"));
                iT = pn.t();
                if (com.ss.android.socialbase.appdownloader.fx.u(this.iz)) {
                    remoteViewsA.setViewVisibility(iT, r10);
                    if (uVarU.nr("enable_notification_ui") >= 2) {
                        str = com.ss.android.socialbase.appdownloader.fx.u(j, (boolean) r10) + "/" + com.ss.android.socialbase.appdownloader.fx.u(jFx, (boolean) r10);
                    }
                    builder = builderJk;
                } else {
                    builder = builderJk;
                    remoteViewsA.setViewVisibility(iT, 8);
                }
            }
            remoteViewsA.setViewVisibility(pn.a(), 8);
            r10 = z3;
            iT = pn.t();
            if (com.ss.android.socialbase.appdownloader.fx.u(this.iz)) {
            }
        } else {
            long j2 = j;
            if (iU == 3) {
                DownloadInfo downloadInfo = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.fx.oa()).getDownloadInfo(iU2);
                String str7 = "";
                if (pn() == -1 || pn() == -4) {
                    if (uVarU.nr("enable_notification_ui") >= 2 && pn() == -1 && (iz.a(baseException) || iz.n(baseException))) {
                        str2 = com.ss.android.socialbase.appdownloader.fx.u(j2) + "/" + com.ss.android.socialbase.appdownloader.fx.u(jFx);
                    } else {
                        str2 = str7;
                    }
                    remoteViewsA.setViewVisibility(pn.k(), 8);
                    baseException2 = baseException;
                    if (baseException2 != null) {
                        str7 = str2;
                        if (baseException.getErrorCode() == 1006) {
                            string3 = this.nr.getResources().getString(a.nr("tt_appdownloader_notification_download_space_failed"));
                        }
                        str3 = string3;
                        string4 = this.nr.getResources().getString(a.nr("tt_appdownloader_notification_download_restart"));
                        remoteViewsA.setViewVisibility(pn.t(), 8);
                        if (uVarU.nr("enable_notification_ui") >= 2 || pn() != -1) {
                            builder = builderJk;
                            string = str3;
                            string2 = string4;
                            remoteViewsA.setViewVisibility(u(iU2), 8);
                            remoteViewsA.setViewVisibility(pn.a(), 0);
                            remoteViewsA.setViewVisibility(pn.jk(), 8);
                            if (uVarU.nr("enable_notification_ui") < 2 && pn() == -1 && (iz.a(baseException) || iz.n(baseException))) {
                                remoteViewsA.setViewVisibility(u(iU2), 0);
                                remoteViewsA.setViewVisibility(pn.a(), 8);
                                remoteViewsA.setViewVisibility(pn.jk(), 0);
                                int iT4 = pn.t();
                                if (iz.nr(baseException2, downloadInfo)) {
                                    remoteViewsA.setViewVisibility(iT4, 0);
                                    str = com.ss.android.socialbase.appdownloader.fx.u(j2, false) + "/" + com.ss.android.socialbase.appdownloader.fx.u(jFx, false);
                                } else {
                                    iT = iT4;
                                    str = str7;
                                    remoteViewsA.setViewVisibility(iT, 8);
                                }
                            } else {
                                str = str7;
                            }
                        } else if (iz.a(baseException)) {
                            if (iz.nr(baseException2, downloadInfo)) {
                                string = this.nr.getResources().getString(a.nr("tt_appdownloader_notification_no_wifi_and_in_net"));
                                string2 = this.nr.getResources().getString(a.nr("tt_appdownloader_notification_download_resume"));
                                builder = builderJk;
                            } else {
                                builder = builderJk;
                                string = this.nr.getResources().getString(a.nr("tt_appdownloader_notification_no_internet_error"));
                                string2 = string4;
                            }
                            remoteViewsA.setViewVisibility(u(iU2), 8);
                            remoteViewsA.setViewVisibility(pn.a(), 0);
                            remoteViewsA.setViewVisibility(pn.jk(), 8);
                            if (uVarU.nr("enable_notification_ui") < 2) {
                                str = str7;
                            }
                        } else {
                            if (iz.n(baseException)) {
                                builder = builderJk;
                                string = this.nr.getResources().getString(a.nr("tt_appdownloader_notification_insufficient_space_error"), com.ss.android.socialbase.appdownloader.fx.nr(jFx - j2));
                            }
                            string2 = string4;
                            remoteViewsA.setViewVisibility(u(iU2), 8);
                            remoteViewsA.setViewVisibility(pn.a(), 0);
                            remoteViewsA.setViewVisibility(pn.jk(), 8);
                            if (uVarU.nr("enable_notification_ui") < 2) {
                            }
                        }
                    } else {
                        str7 = str2;
                    }
                    if (u(baseException2, uVarU, downloadInfo)) {
                        string3 = this.nr.getResources().getString(downloadInfo != null && downloadInfo.isOnlyWifi() ? a.nr("tt_appdownloader_notification_download_waiting_wifi") : a.nr("tt_appdownloader_notification_download_waiting_net"));
                    } else {
                        string3 = this.nr.getResources().getString(a.nr("tt_appdownloader_notification_download_failed"));
                    }
                    str3 = string3;
                    string4 = this.nr.getResources().getString(a.nr("tt_appdownloader_notification_download_restart"));
                    remoteViewsA.setViewVisibility(pn.t(), 8);
                    if (uVarU.nr("enable_notification_ui") >= 2) {
                        builder = builderJk;
                        string = str3;
                        string2 = string4;
                        remoteViewsA.setViewVisibility(u(iU2), 8);
                        remoteViewsA.setViewVisibility(pn.a(), 0);
                        remoteViewsA.setViewVisibility(pn.jk(), 8);
                        if (uVarU.nr("enable_notification_ui") < 2) {
                        }
                    }
                } else if (pn() == -3) {
                    String strU = com.ss.android.socialbase.appdownloader.fx.u(jFx);
                    if (downloadInfo == null || TextUtils.isEmpty(downloadInfo.getMimeType()) || !downloadInfo.getMimeType().equals(AdBaseConstants.MIME_APK)) {
                        iNr = a.nr("tt_appdownloader_notification_download_complete_without_install");
                        if (com.ss.android.socialbase.downloader.downloader.b.u().mv(iU2) != null) {
                            iNr = a.nr("tt_appdownloader_notification_download_complete_open");
                        }
                        str4 = strU;
                        iNr2 = 0;
                    } else {
                        if (com.ss.android.socialbase.appdownloader.fx.u(this.nr, downloadInfo, false)) {
                            iNr = a.nr("tt_appdownloader_notification_install_finished_open");
                            iNr2 = a.nr("tt_appdownloader_notification_download_open");
                        } else {
                            iNr = a.nr("tt_appdownloader_notification_download_complete_with_install");
                            iNr2 = a.nr("tt_appdownloader_notification_download_install");
                        }
                        str4 = strU;
                    }
                    String string5 = this.fx.getString(iNr);
                    builderJk.setContentText(string5);
                    String string6 = iNr2 != 0 ? this.fx.getString(iNr2) : str7;
                    if (uVarU.nr("notification_opt_2") == 1) {
                        remoteViewsA.setTextViewText(pn.t(), string6);
                        remoteViewsA.setViewVisibility(pn.k(), 8);
                    } else {
                        remoteViewsA.setViewVisibility(pn.t(), 8);
                    }
                    builder = builderJk;
                    string2 = string6;
                    str7 = str4;
                    string = string5;
                    baseException2 = baseException;
                    remoteViewsA.setViewVisibility(u(iU2), 8);
                    remoteViewsA.setViewVisibility(pn.a(), 0);
                    remoteViewsA.setViewVisibility(pn.jk(), 8);
                    if (uVarU.nr("enable_notification_ui") < 2) {
                    }
                } else {
                    baseException2 = baseException;
                    builder = builderJk;
                    string2 = str7;
                    string = string2;
                    remoteViewsA.setViewVisibility(u(iU2), 8);
                    remoteViewsA.setViewVisibility(pn.a(), 0);
                    remoteViewsA.setViewVisibility(pn.jk(), 8);
                    if (uVarU.nr("enable_notification_ui") < 2) {
                    }
                }
            } else {
                builder = builderJk;
                str = "";
                string2 = str;
                string = string2;
            }
        }
        remoteViewsA.setTextViewText(pn.s(), str);
        remoteViewsA.setTextViewText(pn.my(), string);
        remoteViewsA.setTextViewText(pn.k(), str);
        remoteViewsA.setTextViewText(pn.o(), string);
        int iT5 = pn.t();
        if (TextUtils.isEmpty(string2)) {
            remoteViewsA.setViewVisibility(iT5, 8);
        } else {
            remoteViewsA.setTextViewText(iT5, string2);
        }
        Notification notificationBuild = builder.build();
        notificationBuild.contentView = remoteViewsA;
        return notificationBuild;
    }

    @Override // com.ss.android.socialbase.downloader.notification.u
    public void u(DownloadInfo downloadInfo) {
        super.u(downloadInfo);
        this.pn = downloadInfo.getSavePath();
        this.b = downloadInfo.getName();
        this.iz = downloadInfo.getExtra();
    }

    @Override // com.ss.android.socialbase.downloader.notification.u
    public void u(BaseException baseException, boolean z) {
        if (this.nr == null) {
            return;
        }
        try {
            com.ss.android.socialbase.appdownloader.fx.fx fxVarU = com.ss.android.socialbase.appdownloader.b.t().u();
            if (fxVarU != null) {
                this.u = u(fxVarU, baseException, z);
            } else {
                this.u = nr(baseException, z);
            }
            u(this.u);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x020e A[PHI: r6 r21 r22
      0x020e: PHI (r6v14 com.ss.android.socialbase.downloader.exception.BaseException) = 
      (r6v10 com.ss.android.socialbase.downloader.exception.BaseException)
      (r6v10 com.ss.android.socialbase.downloader.exception.BaseException)
      (r6v10 com.ss.android.socialbase.downloader.exception.BaseException)
      (r6v24 com.ss.android.socialbase.downloader.exception.BaseException)
     binds: [B:97:0x029c, B:99:0x029f, B:100:0x02a1, B:70:0x0201] A[DONT_GENERATE, DONT_INLINE]
      0x020e: PHI (r21v8 com.ss.android.socialbase.downloader.n.u) = 
      (r21v6 com.ss.android.socialbase.downloader.n.u)
      (r21v6 com.ss.android.socialbase.downloader.n.u)
      (r21v6 com.ss.android.socialbase.downloader.n.u)
      (r21v12 com.ss.android.socialbase.downloader.n.u)
     binds: [B:97:0x029c, B:99:0x029f, B:100:0x02a1, B:70:0x0201] A[DONT_GENERATE, DONT_INLINE]
      0x020e: PHI (r22v5 java.lang.Object) = (r22v2 java.lang.Object), (r22v2 java.lang.Object), (r22v2 java.lang.Object), (r22v7 java.lang.Object) binds: [B:97:0x029c, B:99:0x029f, B:100:0x02a1, B:70:0x0201] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Notification u(com.ss.android.socialbase.appdownloader.fx.fx fxVar, BaseException baseException, boolean z) {
        com.ss.android.socialbase.downloader.n.u uVar;
        int i;
        u uVar2;
        BaseException baseException2;
        Object obj;
        Object obj2;
        int iPn = pn();
        int iU = com.ss.android.socialbase.appdownloader.fx.u(iPn);
        if (iU == 0) {
            return null;
        }
        HashMap map = new HashMap();
        map.put("click_type", Integer.valueOf(iU));
        int iU2 = u();
        map.put("click_download_id", Integer.valueOf(iU2));
        com.ss.android.socialbase.downloader.n.u uVarU = com.ss.android.socialbase.downloader.n.u.u(iU2);
        long jNr = nr();
        long jFx = fx();
        int i2 = jFx > 0 ? (int) ((100 * jNr) / jFx) : 0;
        String strB = b();
        int iNr = uVarU.nr("notification_opt_2");
        map.put("notification_opt_2", Integer.valueOf(iNr));
        if (iNr != 1) {
            map.put("action_click_btn", "android.ss.intent.action.DOWNLOAD_CLICK_BTN");
        }
        int iNr2 = uVarU.nr("enable_notification_ui");
        map.put("enable_notification_ui", Integer.valueOf(iNr2));
        map.put("show_title", strB);
        map.put("percent", Integer.valueOf(i2));
        map.put("indeterminate", Boolean.valueOf(z));
        map.put("notification_type", Integer.valueOf(iU));
        String strJk = com.ss.android.socialbase.appdownloader.b.t().jk();
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26 && TextUtils.isEmpty(strJk)) {
            strJk = com.ss.android.socialbase.appdownloader.fx.nr(this.nr);
        }
        map.put("channel_id", strJk);
        map.put("download_status", Integer.valueOf(iPn));
        map.put("first_time", Long.valueOf(iz()));
        if (i3 >= 24 && uVarU.u("set_notification_group", 0) == 1) {
            map.put("notification_group", "com.ss.android.socialbase.APP_DOWNLOADER");
        }
        map.put("csj_enable_target_34", Boolean.valueOf(i3 >= 31 && com.ss.android.socialbase.downloader.n.u.u(iU2).nr("enable_target_34") > 0));
        if (iNr2 > 0) {
            map.put("bitmap", fx.u().u(iU2));
        }
        if (iU == 1 || iU == 4) {
            uVar = uVarU;
            map.put("download_size", com.ss.android.socialbase.appdownloader.fx.u(jNr) + "/" + com.ss.android.socialbase.appdownloader.fx.u(jFx));
            i = iU;
            if (i == 1) {
                map.put("download_status", Integer.valueOf(pn()));
            }
            uVar2 = this;
            map.put("is_bind_app", Boolean.valueOf(com.ss.android.socialbase.appdownloader.fx.u(uVar2.iz)));
        } else if (iU == 2) {
            map.put("download_size", com.ss.android.socialbase.appdownloader.fx.u(jNr) + "/" + com.ss.android.socialbase.appdownloader.fx.u(jFx));
            if (iNr == 1) {
                map.put("progress_70", Integer.valueOf(uVarU.u("noti_progress_show_th", 70)));
            }
            map.put("is_bind_app", Boolean.valueOf(com.ss.android.socialbase.appdownloader.fx.u(this.iz)));
            if (!com.ss.android.socialbase.appdownloader.fx.u(this.iz) && iNr2 >= 2) {
                map.put("download_size", com.ss.android.socialbase.appdownloader.fx.u(jNr, false) + "/" + com.ss.android.socialbase.appdownloader.fx.u(jFx, false));
            }
            uVar = uVarU;
            uVar2 = this;
            i = iU;
        } else if (iU == 3) {
            DownloadInfo downloadInfo = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.fx.oa()).getDownloadInfo(iU2);
            int iPn2 = pn();
            map.put("download_status", Integer.valueOf(iPn2));
            if (iPn2 == -1 || iPn2 == -4) {
                uVar = uVarU;
                boolean zA = iz.a(baseException);
                boolean zN = iz.n(baseException);
                map.put("is_network_error", Boolean.valueOf(zA));
                map.put("is_insufficient_space_error", Boolean.valueOf(zN));
                if (iNr2 >= 2 && iPn2 == -1 && (zA || zN)) {
                    map.put("download_size", com.ss.android.socialbase.appdownloader.fx.u(jNr) + "/" + com.ss.android.socialbase.appdownloader.fx.u(jFx));
                }
                baseException2 = baseException;
                if (baseException2 != null) {
                    obj = "download_size";
                    if (baseException.getErrorCode() == 1006) {
                        map.put("is_error_code_insufficient_space_error", Boolean.TRUE);
                    }
                    if (iNr2 < 2 && iPn2 == -1 && zA) {
                        obj2 = "is_wait_wifi_and_in_net";
                        map.put(obj2, Boolean.valueOf(iz.nr(baseException2, downloadInfo)));
                    } else {
                        obj2 = "is_wait_wifi_and_in_net";
                    }
                    boolean zA2 = iz.a(baseException);
                    boolean zN2 = iz.n(baseException);
                    map.put("is_network_error", Boolean.valueOf(zA2));
                    map.put("is_insufficient_space_error", Boolean.valueOf(zN2));
                    if (iNr2 >= 2 && iPn2 == -1 && (zA2 || zN2)) {
                        boolean zNr = iz.nr(baseException2, downloadInfo);
                        map.put(obj2, Boolean.valueOf(zNr));
                        if (zNr) {
                            map.put(obj, com.ss.android.socialbase.appdownloader.fx.u(jNr, false) + "/" + com.ss.android.socialbase.appdownloader.fx.u(jFx, false));
                        }
                        uVar2 = this;
                        i = iU;
                    } else {
                        uVar2 = this;
                        i = iU;
                    }
                } else {
                    obj = "download_size";
                }
                if (u(baseException2, uVar, downloadInfo)) {
                    uVar = uVar;
                    map.put("is_need_show_wait_net_text", Boolean.TRUE);
                    map.put("is_wait_wifi", Boolean.valueOf(downloadInfo != null && downloadInfo.isOnlyWifi()));
                } else {
                    uVar = uVar;
                }
                if (iNr2 < 2) {
                    obj2 = "is_wait_wifi_and_in_net";
                    boolean zA22 = iz.a(baseException);
                    boolean zN22 = iz.n(baseException);
                    map.put("is_network_error", Boolean.valueOf(zA22));
                    map.put("is_insufficient_space_error", Boolean.valueOf(zN22));
                    if (iNr2 >= 2) {
                        uVar2 = this;
                        i = iU;
                    }
                }
            } else if (iPn2 == -3) {
                map.put("download_size", com.ss.android.socialbase.appdownloader.fx.u(jFx));
                if (downloadInfo == null || TextUtils.isEmpty(downloadInfo.getMimeType())) {
                    uVar = uVarU;
                } else {
                    uVar = uVarU;
                    boolean z2 = downloadInfo.getMimeType().equals(AdBaseConstants.MIME_APK);
                    map.put("is_mime_apk", Boolean.valueOf(z2));
                    map.put("is_apk_installed", Boolean.valueOf(com.ss.android.socialbase.appdownloader.fx.u(this.nr, downloadInfo, false)));
                    map.put("is_have_notification_click_callback", Boolean.valueOf(com.ss.android.socialbase.downloader.downloader.b.u().mv(iU2) == null));
                    baseException2 = baseException;
                    obj = "download_size";
                    obj2 = "is_wait_wifi_and_in_net";
                    boolean zA222 = iz.a(baseException);
                    boolean zN222 = iz.n(baseException);
                    map.put("is_network_error", Boolean.valueOf(zA222));
                    map.put("is_insufficient_space_error", Boolean.valueOf(zN222));
                    if (iNr2 >= 2) {
                    }
                }
                map.put("is_mime_apk", Boolean.valueOf(z2));
                map.put("is_apk_installed", Boolean.valueOf(com.ss.android.socialbase.appdownloader.fx.u(this.nr, downloadInfo, false)));
                map.put("is_have_notification_click_callback", Boolean.valueOf(com.ss.android.socialbase.downloader.downloader.b.u().mv(iU2) == null));
                baseException2 = baseException;
                obj = "download_size";
                obj2 = "is_wait_wifi_and_in_net";
                boolean zA2222 = iz.a(baseException);
                boolean zN2222 = iz.n(baseException);
                map.put("is_network_error", Boolean.valueOf(zA2222));
                map.put("is_insufficient_space_error", Boolean.valueOf(zN2222));
                if (iNr2 >= 2) {
                }
            } else {
                uVar = uVarU;
                obj = "download_size";
                obj2 = "is_wait_wifi_and_in_net";
                baseException2 = baseException;
                boolean zA22222 = iz.a(baseException);
                boolean zN22222 = iz.n(baseException);
                map.put("is_network_error", Boolean.valueOf(zA22222));
                map.put("is_insufficient_space_error", Boolean.valueOf(zN22222));
                if (iNr2 >= 2) {
                }
            }
        } else {
            uVar = uVarU;
            i = iU;
            uVar2 = this;
        }
        String str = "android.ss.intent.action.DOWNLOAD_CLICK_CONTENT";
        if (i == 1 || i == 4 || i == 2) {
            map.put("action_apa", "android.ss.intent.action.DOWNLOAD_CLICK_CONTENT");
        } else if (i == 3) {
            if (iPn != -1 && iPn != -4) {
                if (iPn == -3) {
                    map.put("auto_cancel", Boolean.valueOf(uVar.u("notification_click_install_auto_cancel", 1) == 0));
                }
                str = "android.ss.intent.action.DOWNLOAD_OPEN";
            }
            map.put("action_complete", str);
            map.put("action_hide", "android.ss.intent.action.DOWNLOAD_HIDE");
        }
        Notification notification = (Notification) fxVar.u(map).get("notification");
        uVar2.u = notification;
        return notification;
    }

    private boolean u(BaseException baseException, com.ss.android.socialbase.downloader.n.u uVar, DownloadInfo downloadInfo) {
        return baseException != null && (baseException.getErrorCode() == 1013 || baseException.getErrorCode() == 1049) && downloadInfo != null && AdBaseConstants.MIME_APK.contains(downloadInfo.getMimeType()) && uVar.u("notification_text_opt", 0) == 1;
    }

    private int u(int i, int i2) {
        if (com.ss.android.socialbase.downloader.n.u.u(i2).nr("notification_opt_2") == 1) {
            return pn.c();
        }
        if (i == 1 || i == 4) {
            return pn.bq();
        }
        if (i == 2) {
            return pn.dw();
        }
        if (i == 3) {
            return pn.c();
        }
        return 0;
    }

    private PendingIntent u(String str, int i, int i2) {
        Pair<Intent, Boolean> pairNr = com.ss.android.socialbase.appdownloader.b.nr(this.nr, i2);
        Intent intent = (Intent) pairNr.first;
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i2);
        intent.putExtra("extra_click_download_type", i);
        intent.putExtra("extra_from_notification", true);
        return com.ss.android.socialbase.appdownloader.b.u(this.nr, pairNr, i2);
    }

    private int u(int i) {
        if (com.ss.android.socialbase.downloader.n.u.u(i).nr("enable_notification_ui") > 0) {
            return pn.n();
        }
        return pn.x();
    }
}
