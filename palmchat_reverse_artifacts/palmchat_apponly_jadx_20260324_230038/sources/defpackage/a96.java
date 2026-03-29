package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.t;
import com.umeng.umcrash.custommapping.UAPMCustomMapping;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0004\u001a\u00020\u00032\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000H\u0000\"\u001a\u0010\b\u001a\u00020\u00008\u0000X\u0080D¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007*\f\b\u0000\u0010\n\"\u00020\t2\u00020\t¨\u0006\u000b"}, d2 = {"", UAPMCustomMapping.STRING_PARAM_1, UAPMCustomMapping.STRING_PARAM_2, "", "a", "Ljava/lang/String;", t.l, "()Ljava/lang/String;", "TAG", "Landroid/webkit/WebView;", "SdkWebView", "app_release"}, k = 2, mv = {1, 8, 0})
public final class a96 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1181a = "palmchat.WebView2";

    public static final boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (TextUtils.equals(str, str2)) {
            return true;
        }
        try {
            Uri uri = Uri.parse(str);
            Intrinsics.checkNotNullExpressionValue(uri, "parse(s1)");
            Uri uri2 = Uri.parse(str2);
            Intrinsics.checkNotNullExpressionValue(uri2, "parse(s2)");
            String queryParameter = uri.getQueryParameter("newsId");
            String queryParameter2 = uri2.getQueryParameter("newsId");
            if (TextUtils.isEmpty(queryParameter)) {
                return false;
            }
            return TextUtils.equals(queryParameter, queryParameter2);
        } catch (Exception unused) {
            return false;
        }
    }

    public static final String b() {
        return f1181a;
    }
}
