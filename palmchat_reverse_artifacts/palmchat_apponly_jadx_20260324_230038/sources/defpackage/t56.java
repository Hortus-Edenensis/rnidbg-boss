package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.f;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.contacts.ContactActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.groupchat.GroupDetailActivity;
import com.zenmen.palmchat.groupchat.GroupInfoItem;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class t56 {
    public static void a(Context context, Uri uri) {
        Intent intent;
        Integer numValueOf;
        int i;
        String string = uri.toString();
        String scheme = uri.getScheme();
        String host = uri.getHost();
        if ("zenmen".equals(scheme) && "activity".equals(host)) {
            HashMap<String, String> mapE = zy4.e(string);
            String str = mapE.get("page");
            if (TextUtils.isEmpty(str)) {
            }
            intent = new Intent();
            str.hashCode();
            switch (str) {
                case "a0001":
                    if (!TeenagersModeManager.a().d()) {
                        context.startActivity(st2.c());
                        break;
                    } else {
                        zt5.c();
                        break;
                    }
                    break;
                case "a0002":
                    String str2 = mapE.get(DeviceInfoUtil.UID_TAG);
                    if (!TextUtils.isEmpty(str2)) {
                        ContactInfoItem contactInfoItem = new ContactInfoItem();
                        contactInfoItem.setUid(str2);
                        intent.setClass(context, m66.c());
                        intent.putExtra("user_item_info", contactInfoItem);
                        context.startActivity(intent);
                        break;
                    }
                    break;
                case "a0007":
                    String str3 = mapE.get("groupId");
                    if (!TextUtils.isEmpty(str3)) {
                        GroupInfoItem groupInfoItem = new GroupInfoItem();
                        groupInfoItem.setGroupId(str3);
                        intent.setClass(context, GroupDetailActivity.class);
                        intent.putExtra(f.K, groupInfoItem);
                        context.startActivity(intent);
                        break;
                    }
                    break;
                case "a0045":
                    nb3.j(context);
                    break;
                case "a0062":
                    n5.f(context, new Bundle());
                    break;
                case "a0080":
                    intent.setClass(context, ContactActivity.class);
                    k86.X(intent);
                    context.startActivity(intent);
                    break;
                case "a0211":
                    String str4 = mapE.get(DeviceInfoUtil.UID_TAG);
                    String str5 = mapE.get(bd.h);
                    String str6 = mapE.get("rid");
                    int iIntValue = (!mapE.containsKey("sourceType") || (numValueOf = Integer.valueOf(mapE.get("sourceType"))) == null) ? 44 : numValueOf.intValue();
                    Intent intent2 = new Intent(context, (Class<?>) m66.c());
                    ContactInfoItem contactInfoItem2 = new ContactInfoItem();
                    contactInfoItem2.setExid(str5);
                    contactInfoItem2.setUid(str4);
                    contactInfoItem2.setSourceType(iIntValue);
                    if (TextUtils.isEmpty(str6)) {
                        intent2.putExtra("from", 33);
                    } else {
                        intent2.putExtra("from", 7);
                        intent2.putExtra("rid", str6);
                    }
                    intent2.putExtra("user_item_info", contactInfoItem2);
                    intent2.putExtra(BaseActionBarActivity.EXTRA_KEY_NEED_BACK2MAINTAB, false);
                    context.startActivity(intent2);
                    break;
                case "a0411":
                    String str7 = mapE.get(bd.h);
                    String str8 = mapE.get("bizType");
                    if (TextUtils.isEmpty(str8)) {
                        i = 64;
                    } else {
                        try {
                            i = Integer.parseInt(str8) + 5000;
                        } catch (Exception unused) {
                            i = 64;
                        }
                    }
                    ap3.k((Activity) context, str7, i);
                    break;
            }
        }
    }
}
