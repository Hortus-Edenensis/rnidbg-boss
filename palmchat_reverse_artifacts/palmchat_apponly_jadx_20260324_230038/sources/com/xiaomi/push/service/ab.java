package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import com.xiaomi.push.dv;
import com.xiaomi.push.hb;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public abstract class ab {
    public abstract dv a(Context context, int i, String str, Map<String, String> map);

    public abstract void a(hb hbVar, Map<String, String> map, int i, Notification notification);

    public abstract void a(String str);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public abstract boolean m694a(Context context, int i, String str, Map<String, String> map);

    public abstract boolean a(Map<String, String> map, int i, Notification notification);
}
