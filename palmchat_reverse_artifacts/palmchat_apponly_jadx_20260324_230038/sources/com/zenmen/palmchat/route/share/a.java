package com.zenmen.palmchat.route.share;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Spannable;
import android.text.TextUtils;
import com.litesuits.async.AsyncTask;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.utils.ShareLinkBean;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.pf2;
import defpackage.tp2;
import defpackage.w56;
import defpackage.xt;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a {

    /* JADX INFO: renamed from: com.zenmen.palmchat.route.share.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C1100a extends AsyncTask<ShareLinkBean, Void, ShareLinkBean> {
        public final /* synthetic */ e m;

        public C1100a(e eVar) {
            this.m = eVar;
        }

        @Override // com.litesuits.async.AsyncTask
        public void o() {
            super.o();
            e eVar = this.m;
            if (eVar != null) {
                eVar.onStart();
            }
        }

        @Override // com.litesuits.async.AsyncTask
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public ShareLinkBean g(ShareLinkBean... shareLinkBeanArr) {
            ShareLinkBean shareLinkBean = shareLinkBeanArr[0];
            String[] strArrL = tp2.l(shareLinkBean.getUrl());
            String url = strArrL[0];
            if (TextUtils.isEmpty(url)) {
                url = shareLinkBean.getUrl();
            }
            String str = strArrL[1];
            String icon = shareLinkBean.getIcon();
            String title = shareLinkBean.getTitle();
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(icon)) {
                    icon = tp2.e(str, url);
                }
                if (TextUtils.isEmpty(title) || pf2.c(url)) {
                    title = tp2.j(str, url);
                    if (TextUtils.isEmpty(title)) {
                        title = shareLinkBean.getContent();
                    }
                }
            }
            if (TextUtils.isEmpty(shareLinkBean.getContent())) {
                shareLinkBean.setContent(tp2.c(str));
                if (TextUtils.isEmpty(shareLinkBean.getContent())) {
                    shareLinkBean.setContent(url);
                }
            }
            if (TextUtils.isEmpty(title)) {
                title = shareLinkBean.getContent();
            }
            tp2.c cVarB = tp2.b(url);
            if (TextUtils.isEmpty(title) && cVarB != null) {
                title = cVarB.b;
            }
            if (TextUtils.isEmpty(icon) && cVarB != null) {
                icon = cVarB.c;
            }
            shareLinkBean.setUrl(url);
            shareLinkBean.setIcon(icon);
            shareLinkBean.setTitle(title);
            a.m(icon, url);
            return shareLinkBean;
        }

        @Override // com.litesuits.async.AsyncTask
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public void n(ShareLinkBean shareLinkBean) {
            e eVar = this.m;
            if (eVar != null) {
                eVar.a(shareLinkBean);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends AsyncTask<ShareLinkBean, Void, ShareLinkBean> {
        public final /* synthetic */ ShareLinkBean m;
        public final /* synthetic */ e n;

        public b(ShareLinkBean shareLinkBean, e eVar) {
            this.m = shareLinkBean;
            this.n = eVar;
        }

        @Override // com.litesuits.async.AsyncTask
        public void o() {
            super.o();
            LogUtil.i("ShareHelper", "getLink onPreExecute" + this.m);
            e eVar = this.n;
            if (eVar != null) {
                eVar.onStart();
            }
        }

        @Override // com.litesuits.async.AsyncTask
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public ShareLinkBean g(ShareLinkBean... shareLinkBeanArr) {
            return a.f(shareLinkBeanArr[0]);
        }

        @Override // com.litesuits.async.AsyncTask
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public void n(ShareLinkBean shareLinkBean) {
            e eVar = this.n;
            if (eVar != null) {
                eVar.a(shareLinkBean);
            }
            LogUtil.i("ShareHelper", "getLink onPostExecute" + shareLinkBean);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends AsyncTask<ShareLinkBean, Void, ShareLinkBean> {
        public final /* synthetic */ e m;

        public c(e eVar) {
            this.m = eVar;
        }

        @Override // com.litesuits.async.AsyncTask
        public void o() {
            super.o();
            e eVar = this.m;
            if (eVar != null) {
                eVar.onStart();
            }
        }

        @Override // com.litesuits.async.AsyncTask
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public ShareLinkBean g(ShareLinkBean... shareLinkBeanArr) {
            ShareLinkBean shareLinkBean = shareLinkBeanArr[0];
            String[] strArrN = tp2.n(shareLinkBean.getUrl(), true, false);
            String str = strArrN[0];
            String strE = tp2.e(strArrN[1], str);
            shareLinkBean.setUrl(str);
            shareLinkBean.setIcon(strE);
            a.m(strE, str);
            return shareLinkBean;
        }

        @Override // com.litesuits.async.AsyncTask
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public void n(ShareLinkBean shareLinkBean) {
            e eVar = this.m;
            if (eVar != null) {
                eVar.a(shareLinkBean);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15093a;

        public d(String str) {
            this.f15093a = str;
            put("action", "getLinkIcon");
            put("detail", str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
        void a(ShareLinkBean shareLinkBean);

        void onStart();
    }

    public static String b(String str) {
        String str2;
        LogUtil.d("ShareHelper", str);
        Matcher matcher = Pattern.compile("[a-zA-z]+:\\/\\/[^\\s]*", 2).matcher(str);
        ArrayList<String> arrayList = new ArrayList();
        while (matcher.find()) {
            arrayList.add(matcher.group(0));
        }
        if (arrayList.size() < 1) {
            return "";
        }
        if (arrayList.size() == 1) {
            str2 = (String) arrayList.get(0);
            if (str2.contains("www.163.com/newsapp")) {
                String strG = g(str);
                if (!TextUtils.isEmpty(strG)) {
                    return strG;
                }
            }
        } else {
            str2 = (String) arrayList.get(0);
            for (String str3 : arrayList) {
                if (!str.contains("www.163.com/newsapp")) {
                    return str3;
                }
            }
        }
        return str2;
    }

    public static AsyncTask c(ShareLinkBean shareLinkBean, e eVar) {
        b bVar = new b(shareLinkBean, eVar);
        bVar.h(shareLinkBean);
        return bVar;
    }

    public static AsyncTask d(ShareLinkBean shareLinkBean, e eVar) {
        C1100a c1100a = new C1100a(eVar);
        c1100a.h(shareLinkBean);
        return c1100a;
    }

    public static AsyncTask e(ShareLinkBean shareLinkBean, e eVar) {
        c cVar = new c(eVar);
        cVar.h(shareLinkBean);
        return cVar;
    }

    public static ShareLinkBean f(ShareLinkBean shareLinkBean) {
        String[] strArrM = tp2.m(shareLinkBean.getUrl(), true);
        String str = strArrM[0];
        String str2 = strArrM[1];
        if (TextUtils.isEmpty(tp2.e(str2, str)) && TextUtils.isEmpty(tp2.j(str2, str))) {
            String[] strArrN = tp2.n(shareLinkBean.getUrl(), true, false);
            str = strArrN[0];
            str2 = strArrN[1];
        }
        String icon = shareLinkBean.getIcon();
        String title = shareLinkBean.getTitle();
        if (!TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(icon)) {
                icon = tp2.e(str2, str);
            }
            if (TextUtils.isEmpty(title) || pf2.c(str)) {
                title = tp2.j(str2, str);
            }
        }
        if (TextUtils.isEmpty(title)) {
            title = shareLinkBean.getContent();
        }
        tp2.c cVarB = tp2.b(str);
        if (TextUtils.isEmpty(title) && cVarB != null) {
            title = cVarB.b;
        }
        if (TextUtils.isEmpty(icon) && cVarB != null) {
            icon = cVarB.c;
        }
        shareLinkBean.setUrl(str);
        shareLinkBean.setIcon(icon);
        shareLinkBean.setTitle(title);
        m(icon, str);
        return shareLinkBean;
    }

    public static String g(String str) {
        Matcher matcher = Pattern.compile("\\n[\\d\\w]+\\n", 2).matcher(str);
        if (!matcher.find()) {
            return null;
        }
        return "https://c.m.163.com/news/a/" + matcher.group(0).trim() + ".html?spss=newsapp";
    }

    public static ShareLinkBean h(Intent intent) {
        ShareLinkBean shareLinkBean = new ShareLinkBean();
        String stringExtra = intent.getStringExtra("android.intent.extra.TEXT");
        String stringExtra2 = intent.getStringExtra("android.intent.extra.SUBJECT");
        String stringExtra3 = intent.getStringExtra("android.intent.extra.shortcut.ICON");
        String stringExtra4 = intent.getStringExtra("extra_url");
        if (TextUtils.isEmpty(stringExtra4)) {
            stringExtra4 = k(stringExtra);
        }
        shareLinkBean.setTitle(stringExtra2);
        shareLinkBean.setIcon(stringExtra3);
        shareLinkBean.setUrl(stringExtra4);
        shareLinkBean.setContent(stringExtra);
        return shareLinkBean;
    }

    public static String i(Intent intent) {
        Bundle extras;
        Object obj;
        String stringExtra = intent.getStringExtra("android.intent.extra.TEXT");
        return (!TextUtils.isEmpty(stringExtra) || (extras = intent.getExtras()) == null || (obj = extras.get("android.intent.extra.TEXT")) == null) ? stringExtra : obj instanceof String ? (String) obj : obj instanceof Spannable ? ((Spannable) obj).toString() : stringExtra;
    }

    public static byte j(Intent intent) {
        String action = intent.getAction();
        String type = intent.getType();
        if ("android.intent.action.SEND".equals(action) && type != null) {
            Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
            if (type.startsWith("text/")) {
                if (n(intent)) {
                    return (byte) 5;
                }
                return o(intent);
            }
            if ("message/rfc822".equals(type)) {
                return (byte) 1;
            }
            return (xt.t(w56.d(AppContext.getContext(), uri)) || xt.s(uri)) ? (byte) 3 : (byte) 5;
        }
        if (!"android.intent.action.SEND_MULTIPLE".equals(action) || type == null) {
            return intent.getByteExtra("extra_share_type", (byte) 0);
        }
        ArrayList<Uri> parcelableArrayListExtra = intent.getParcelableArrayListExtra("android.intent.extra.STREAM");
        if (parcelableArrayListExtra != null) {
            for (Uri uri2 : parcelableArrayListExtra) {
                if (!xt.t(w56.d(AppContext.getContext(), uri2)) && !xt.s(uri2)) {
                    return (byte) 6;
                }
            }
        }
        return (byte) 4;
    }

    public static String k(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return p(b(str));
    }

    public static boolean l(Intent intent) {
        if (intent != null) {
            return (TextUtils.isEmpty(intent.getAction()) || TextUtils.isEmpty(intent.getType())) ? false : true;
        }
        return false;
    }

    public static void m(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            LogUtil.i("ShareHelper", LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new d(str2), (Throwable) null);
        }
    }

    public static boolean n(Intent intent) {
        Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
        return (uri == null || TextUtils.isEmpty(String.valueOf(uri))) ? false : true;
    }

    public static byte o(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.TEXT");
        if (TextUtils.isEmpty(stringExtra)) {
            return (byte) 1;
        }
        String stringExtra2 = intent.getStringExtra("android.intent.extra.SUBJECT");
        String stringExtra3 = intent.getStringExtra("android.intent.extra.shortcut.ICON");
        String stringExtra4 = intent.getStringExtra("extra_url");
        if (TextUtils.isEmpty(stringExtra4)) {
            stringExtra4 = k(stringExtra);
        }
        if (TextUtils.isEmpty(stringExtra2)) {
            TextUtils.isEmpty(stringExtra3);
        }
        if (TextUtils.isEmpty(stringExtra4)) {
            return (byte) 1;
        }
        try {
            new URL(stringExtra4);
            return (byte) 2;
        } catch (Exception unused) {
            return (byte) 1;
        }
    }

    public static String p(String str) {
        return TextUtils.isEmpty(str) ? str : str.replaceAll("[一-龥]", "");
    }
}
