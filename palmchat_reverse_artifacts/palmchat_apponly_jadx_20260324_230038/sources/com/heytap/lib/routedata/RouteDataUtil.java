package com.heytap.lib.routedata;

import android.os.Build;
import android.util.Base64;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: renamed from: com.heytap.lib.a.a, reason: from Kotlin metadata */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007J\u001e\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\f"}, d2 = {"Lcom/heytap/lib/routedata/RouteDataUtil;", "", "()V", "getRouteData", "", "appVersion", "region", "adg", "aug", "parseRouteData", "", "stringLine", "lib_routedata_release"}, k = 1, mv = {1, 1, 15})
public final class RouteDataUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RouteDataUtil f6330a = new RouteDataUtil();

    private RouteDataUtil() {
    }

    @JvmStatic
    public static final String a(String str, String str2, String str3, String str4) {
        String str5 = "1\u0001" + str3 + "\u0001" + str + "\u0001" + Build.MODEL + "\u0001" + Build.BRAND + "\u0001" + str2 + "\u0001" + str4;
        Charset charset = Charsets.UTF_8;
        if (str5 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = str5.getBytes(charset);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        byte[] bArrEncode = Base64.encode(bytes, 2);
        Intrinsics.checkExpressionValueIsNotNull(bArrEncode, "Base64.encode(routeData.…EFAULT or Base64.NO_WRAP)");
        return new String(bArrEncode, charset);
    }
}
