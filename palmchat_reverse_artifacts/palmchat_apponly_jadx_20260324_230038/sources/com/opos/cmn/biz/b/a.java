package com.opos.cmn.biz.b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.opos.cmn.biz.a.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {
    public static final boolean a(Context context, String str, com.opos.cmn.an.d.a aVar) {
        Bundle bundleB;
        if (context == null) {
            com.opos.cmn.an.f.a.c("InteractionTools", "executeBrowser with null context");
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.c("InteractionTools", "executeBrowserWeb with null url");
            return false;
        }
        String strB = c.b(context);
        if (TextUtils.isEmpty(strB)) {
            com.opos.cmn.an.f.a.c("InteractionTools", "browserPkgName:" + strB);
            return false;
        }
        try {
            com.opos.cmn.an.f.a.a("InteractionTools", "executeBrowserWeb url:" + str);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            intent.setClassName(strB, "com.android.browser.BrowserActivity");
            intent.addFlags(268435456);
            if (aVar != null) {
                Bundle bundleB2 = com.opos.cmn.an.d.a.b(aVar.a());
                com.opos.cmn.an.f.a.a("InteractionTools", "executeBrowserWeb intentBundle:", bundleB2);
                if (bundleB2 != null) {
                    intent.putExtras(bundleB2);
                }
            }
            if (aVar != null) {
                bundleB = com.opos.cmn.an.d.a.b(aVar.b());
                com.opos.cmn.an.f.a.a("InteractionTools", "executeBrowserWeb optionsBundle:", bundleB);
            } else {
                bundleB = null;
            }
            if (bundleB != null) {
                context.startActivity(intent, bundleB);
            } else {
                context.startActivity(intent);
            }
            return true;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("InteractionTools", "executeBrowserWeb fail", e);
            return false;
        }
    }
}
