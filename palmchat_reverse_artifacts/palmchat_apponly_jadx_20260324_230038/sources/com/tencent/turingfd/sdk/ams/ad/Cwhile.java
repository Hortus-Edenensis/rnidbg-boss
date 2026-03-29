package com.tencent.turingfd.sdk.ams.ad;

import android.util.JsonWriter;
import androidx.core.app.NotificationCompat;
import com.huawei.openalliance.ad.constant.x;
import com.tencent.turingfd.sdk.ams.ad.Nucleus;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.while, reason: invalid class name */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Cwhile {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f10780a = 0;

    static {
        new HashSet();
        new HashSet();
    }

    public static String a() {
        String strA = Kiwifruit.f.a("s_h");
        if (strA == null || strA.isEmpty()) {
            return "";
        }
        HashSet<String> hashSet = new HashSet(Arrays.asList(strA.split(x.aQ)));
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            jsonWriter.beginObject();
            for (String str : hashSet) {
                jsonWriter.name(str);
                Nucleus.Cif cifB = Casaba.b(str);
                jsonWriter.beginObject();
                jsonWriter.name("std");
                jsonWriter.value(cifB.f10727a);
                jsonWriter.name(NotificationCompat.CATEGORY_ERROR);
                jsonWriter.value(cifB.b);
                jsonWriter.endObject();
            }
            jsonWriter.endObject();
            return stringWriter.toString();
        } catch (IOException unused) {
            return "";
        }
    }
}
