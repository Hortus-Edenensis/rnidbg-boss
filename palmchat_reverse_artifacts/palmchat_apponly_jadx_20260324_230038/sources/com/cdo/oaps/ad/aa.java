package com.cdo.oaps.ad;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class aa {
    public static boolean a(Context context) {
        Intent launchIntentForPackage;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (launchIntentForPackage = packageManager.getLaunchIntentForPackage(af.b(context))) == null) {
                return false;
            }
            launchIntentForPackage.setFlags(270532608);
            context.startActivity(launchIntentForPackage);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean a(Context context, long j, boolean z, boolean z2, int i) {
        try {
            Uri uri = Uri.parse(a.c() + "market://ProductDetail?pid=" + j);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(uri);
            intent.setPackage(af.b(context));
            intent.putExtra("out_intent_from", i);
            intent.addFlags(335544320);
            intent.putExtra("extra.key.productdetail_start_with_download", z);
            intent.putExtra("go_back_to_launcher_app", z2);
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 32);
            if (listQueryIntentActivities == null || listQueryIntentActivities.size() <= 0) {
                return false;
            }
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean a(Context context, String str, String str2, int i) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(a.c() + "market://detail_search?keyword=" + str + "&packagename=" + str2));
            intent.addFlags(335544320);
            intent.setPackage(af.b(context));
            intent.putExtra("out_intent_from", i);
            if (intent.resolveActivity(context.getPackageManager()) == null) {
                return false;
            }
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean a(Context context, String str, boolean z, boolean z2, int i) {
        try {
            Uri uri = Uri.parse(a.c() + "market://details?packagename=" + str);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(uri);
            intent.setPackage(af.b(context));
            intent.putExtra("out_intent_from", i);
            intent.addFlags(335544320);
            intent.putExtra("extra.key.productdetail_start_with_download", z);
            intent.putExtra("go_back_to_launcher_app", z2);
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 32);
            if (listQueryIntentActivities == null || listQueryIntentActivities.size() <= 0) {
                return false;
            }
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
