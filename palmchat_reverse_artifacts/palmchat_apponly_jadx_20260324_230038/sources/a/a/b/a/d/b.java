package a.a.b.a.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.text.TextUtils;
import defpackage.pn;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a.a.b.a.c.a.b<String, String> f1080a;
    public static final b b = new b();

    public final synchronized a.a.b.a.c.a.b<String, String> a(Context context) {
        a.a.b.a.c.a.b<String, String> bVar;
        Intrinsics.checkNotNullParameter(context, "context");
        a.a.b.a.c.a.b<String, String> bVar2 = f1080a;
        if (bVar2 != null) {
            return bVar2;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("sp_name_app_unique_id", 0);
        String string = sharedPreferences.getString("app_unique_id", "NULL");
        boolean z = true;
        if (!Intrinsics.areEqual("NULL", string)) {
            a.a.b.a.c.a.b<String, String> bVar3 = new a.a.b.a.c.a.b<>(sharedPreferences.getString("app_unique_id_source", "NULL"), string);
            f1080a = bVar3;
            return bVar3;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        String str = a.f1079a;
        if (TextUtils.isEmpty(str)) {
            try {
                pn.d.a().b();
                String string2 = Settings.Secure.getString(context.getContentResolver(), "android_id");
                Intrinsics.checkNotNullExpressionValue(string2, "Settings.Secure.getStrin…ttings.Secure.ANDROID_ID)");
                try {
                    a.f1079a = string2;
                } catch (Exception unused) {
                }
                str = string2;
            } catch (Exception unused2) {
            }
        }
        if (str.length() <= 0) {
            z = false;
        }
        if (z) {
            bVar = new a.a.b.a.c.a.b<>("android_id", str);
        } else {
            String string3 = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string3, "UUID.randomUUID().toString()");
            String strReplace$default = StringsKt__StringsJVMKt.replace$default(string3, "-", "", false, 4, (Object) null);
            if (strReplace$default == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String strSubstring = strReplace$default.substring(0, 16);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            bVar = new a.a.b.a.c.a.b<>("random_id", strSubstring);
        }
        f1080a = bVar;
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        a.a.b.a.c.a.b<String, String> bVar4 = f1080a;
        SharedPreferences.Editor editorPutString = editorEdit.putString("app_unique_id_source", bVar4 != null ? bVar4.f1077a : null);
        a.a.b.a.c.a.b<String, String> bVar5 = f1080a;
        editorPutString.putString("app_unique_id", bVar5 != null ? bVar5.b : null).apply();
        return f1080a;
    }
}
