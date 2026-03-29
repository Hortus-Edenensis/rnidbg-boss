package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Parcelable;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class lb implements la {
    private static final String Code = "MoreShareProcessor";
    private static final String I = "text/plain";
    private static final String V = "text/plain";
    private static final String Z = "";
    private String B;

    private List<Intent> Code(List<ResolveInfo> list, List<String> list2) {
        if (list2 == null || list2.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : list) {
            if (list2.contains(resolveInfo.activityInfo.packageName)) {
                fh.Code(Code, "%s Not showing", resolveInfo.activityInfo.packageName);
            } else {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType(HTTP.PLAIN_TEXT_TYPE);
                intent.putExtra("android.intent.extra.TEXT", this.B);
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                intent.setClassName(activityInfo.packageName, activityInfo.name);
                arrayList.add(intent);
            }
        }
        return arrayList;
    }

    @Override // com.huawei.hms.ads.la
    @RequiresApi(api = 23)
    public void Code(Activity activity, le leVar, lg lgVar) {
        if (activity == null || activity.getApplicationContext() == null) {
            return;
        }
        Context applicationContext = activity.getApplicationContext();
        StringBuilder sb = new StringBuilder();
        sb.append(leVar.I() == null ? "" : leVar.I());
        sb.append(leVar.Z() != null ? leVar.Z() : "");
        this.B = sb.toString();
        Intent intent = new Intent("android.intent.action.SEND");
        String strV = HTTP.PLAIN_TEXT_TYPE;
        intent.setType(HTTP.PLAIN_TEXT_TYPE);
        List<Intent> listCode = Code(applicationContext.getPackageManager().queryIntentActivities(intent, 131072), lgVar.Z());
        Intent intentRemove = listCode.remove(0);
        if (leVar.V() != null) {
            strV = leVar.V();
        }
        Intent intentCreateChooser = Intent.createChooser(intentRemove, strV);
        intentCreateChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) listCode.toArray(new Parcelable[0]));
        intentCreateChooser.setFlags(268435456);
        applicationContext.startActivity(intentCreateChooser);
    }

    @Override // com.huawei.hms.ads.la
    public boolean Code() {
        return true;
    }
}
