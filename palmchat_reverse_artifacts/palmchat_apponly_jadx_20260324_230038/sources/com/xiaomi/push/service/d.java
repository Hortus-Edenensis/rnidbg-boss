package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import android.os.SystemClock;
import android.service.notification.StatusBarNotification;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<a> f11751a = new CopyOnWriteArrayList();

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f11752a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long f977a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f978a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Notification.Action[] f979a;

        public a(String str, long j, int i, Notification.Action[] actionArr) {
            this.f978a = str;
            this.f977a = j;
            this.f11752a = i;
            this.f979a = actionArr;
        }
    }

    public static void a(Context context, StatusBarNotification statusBarNotification, int i) {
        if (!com.xiaomi.push.j.m651a(context) || i <= 0 || statusBarNotification == null) {
            return;
        }
        a(new a(statusBarNotification.getKey(), SystemClock.elapsedRealtime(), i, ag.m714a(statusBarNotification.getNotification())));
    }

    private static void a(a aVar) {
        f11751a.add(aVar);
        a();
    }

    private static void a() {
        for (int size = f11751a.size() - 1; size >= 0; size--) {
            a aVar = f11751a.get(size);
            if (SystemClock.elapsedRealtime() - aVar.f977a > 5000) {
                f11751a.remove(aVar);
            }
        }
        if (f11751a.size() > 10) {
            f11751a.remove(0);
        }
    }
}
