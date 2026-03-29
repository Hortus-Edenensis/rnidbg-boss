package com.ss.android.socialbase.appdownloader.pn;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AppOpsManager;
import android.app.FragmentManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.appdownloader.a;
import com.ss.android.socialbase.appdownloader.fx.k;
import com.ss.android.socialbase.appdownloader.view.DownloadHandleNotificationActivity;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b {
    private static AlertDialog b = null;
    private static com.ss.android.socialbase.appdownloader.view.u fx = null;
    private static List<k> nr = new ArrayList();
    private static final String u = "b";

    private static boolean nr() {
        Context contextOa = com.ss.android.socialbase.downloader.downloader.fx.oa();
        NotificationManager notificationManager = (NotificationManager) contextOa.getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 24) {
            return notificationManager.areNotificationsEnabled();
        }
        AppOpsManager appOpsManager = (AppOpsManager) contextOa.getSystemService("appops");
        ApplicationInfo applicationInfo = contextOa.getApplicationInfo();
        String packageName = contextOa.getApplicationContext().getPackageName();
        int i = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }

    public static boolean u() {
        try {
            return nr();
        } catch (Throwable unused) {
            return true;
        }
    }

    public static synchronized void u(boolean z) {
        try {
            AlertDialog alertDialog = b;
            if (alertDialog != null) {
                alertDialog.cancel();
                b = null;
            }
            for (k kVar : nr) {
                if (kVar != null) {
                    if (z) {
                        kVar.u();
                    } else {
                        kVar.nr();
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized void u(@NonNull final Activity activity, @NonNull final k kVar) {
        if (kVar == null) {
            return;
        }
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    int iU = a.u(com.ss.android.socialbase.downloader.downloader.fx.oa(), "tt_appdownloader_notification_request_title");
                    int iU2 = a.u(com.ss.android.socialbase.downloader.downloader.fx.oa(), "tt_appdownloader_notification_request_message");
                    int iU3 = a.u(com.ss.android.socialbase.downloader.downloader.fx.oa(), "tt_appdownloader_notification_request_btn_yes");
                    int iU4 = a.u(com.ss.android.socialbase.downloader.downloader.fx.oa(), "tt_appdownloader_notification_request_btn_no");
                    nr.add(kVar);
                    AlertDialog alertDialog = b;
                    if (alertDialog == null || !alertDialog.isShowing()) {
                        b = new AlertDialog.Builder(activity).setTitle(iU).setMessage(iU2).setPositiveButton(iU3, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.pn.b.3
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                b.nr(activity, kVar);
                                dialogInterface.cancel();
                                AlertDialog unused = b.b = null;
                            }
                        }).setNegativeButton(iU4, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.pn.b.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                b.u(false);
                            }
                        }).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.ss.android.socialbase.appdownloader.pn.b.1
                            @Override // android.content.DialogInterface.OnKeyListener
                            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                                if (i != 4) {
                                    return false;
                                }
                                if (keyEvent.getAction() == 1) {
                                    b.u(false);
                                }
                                return true;
                            }
                        }).setCancelable(false).show();
                    }
                    return;
                }
            } catch (Throwable unused) {
                u(false);
                return;
            }
        }
        kVar.nr();
    }

    public static void nr(@NonNull Activity activity, @NonNull k kVar) {
        if (activity != null) {
            try {
                try {
                    if (!activity.isFinishing()) {
                        FragmentManager fragmentManager = activity.getFragmentManager();
                        String str = u;
                        com.ss.android.socialbase.appdownloader.view.u uVar = (com.ss.android.socialbase.appdownloader.view.u) fragmentManager.findFragmentByTag(str);
                        fx = uVar;
                        if (uVar == null) {
                            fx = new com.ss.android.socialbase.appdownloader.view.u();
                            fragmentManager.beginTransaction().add(fx, str).commitAllowingStateLoss();
                            try {
                                fragmentManager.executePendingTransactions();
                            } catch (Throwable unused) {
                            }
                        }
                        fx.u();
                        return;
                    }
                } catch (Throwable unused2) {
                    kVar.u();
                    return;
                }
            } catch (Throwable unused3) {
                return;
            }
        }
        kVar.u();
    }

    public static void u(int i) {
        if (Build.VERSION.SDK_INT < 33 || com.ss.android.socialbase.downloader.n.u.u(i).nr("enable_target_34") <= 0 || u()) {
            return;
        }
        Context contextOa = com.ss.android.socialbase.downloader.downloader.fx.oa();
        try {
            Intent intent = new Intent(contextOa, (Class<?>) DownloadHandleNotificationActivity.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_REQUEST_PERMISSION");
            intent.addFlags(268435456);
            contextOa.startActivity(intent);
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.fx.u.pn(u, "requestNotificationPermissionError2:".concat(String.valueOf(th)));
        }
    }
}
