package com.zenmen.palmchat.chat;

import android.app.Activity;
import com.zenmen.palmchat.chat.d;
import com.zenmen.palmchat.chat.f;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import defpackage.bn2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static h f12863a;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements d.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f12864a;

        public a(f fVar) {
            this.f12864a = fVar;
        }

        @Override // com.zenmen.palmchat.chat.d.g
        public void a(int i) {
            this.f12864a.a(i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements f.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f12865a;

        public b(f fVar) {
            this.f12865a = fVar;
        }

        @Override // com.zenmen.palmchat.chat.f.h
        public void a(int i) {
            this.f12865a.a(i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements d.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f12866a;

        public c(f fVar) {
            this.f12866a = fVar;
        }

        @Override // com.zenmen.palmchat.chat.d.g
        public void a(int i) {
            this.f12866a.a(i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements f.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f12867a;

        public d(f fVar) {
            this.f12867a = fVar;
        }

        @Override // com.zenmen.palmchat.chat.f.h
        public void a(int i) {
            this.f12867a.a(i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
        void a(int i);
    }

    public static void b(Activity activity, MediaItem mediaItem, long j, long j2, f fVar) {
        if (AndroidVideoEditSwitchConfig.shouldUseNewSDK()) {
            com.zenmen.palmchat.chat.f.n(activity, mediaItem, j, j2, new d(fVar));
        } else {
            com.zenmen.palmchat.chat.d.h(activity, mediaItem, j, j2, new c(fVar));
        }
    }

    public static void c(Activity activity, MediaItem mediaItem, f fVar) {
        if (AndroidVideoEditSwitchConfig.shouldUseNewSDK()) {
            com.zenmen.palmchat.chat.f.o(activity, mediaItem, new b(fVar));
        } else {
            com.zenmen.palmchat.chat.d.i(activity, mediaItem, new a(fVar));
        }
    }

    public static h d() {
        if (f12863a == null) {
            synchronized (h.class) {
                if (f12863a == null) {
                    f12863a = new h();
                }
            }
        }
        return f12863a;
    }

    public static String e(String str) {
        return !AndroidVideoEditSwitchConfig.shouldUseNewSDK() ? com.zenmen.palmchat.chat.d.k(str) : com.zenmen.palmchat.chat.f.q(str);
    }

    public static boolean f(String str) {
        return !AndroidVideoEditSwitchConfig.shouldUseNewSDK() ? com.zenmen.palmchat.chat.d.l(str) : com.zenmen.palmchat.chat.f.r(str);
    }

    public static boolean g(String str) {
        return !AndroidVideoEditSwitchConfig.shouldUseNewSDK() ? com.zenmen.palmchat.chat.d.m(str) : com.zenmen.palmchat.chat.f.t(str);
    }

    public static void h(Activity activity, int i) {
        if (AndroidVideoEditSwitchConfig.shouldUseNewSDK()) {
            com.zenmen.palmchat.chat.f.z(activity, i);
        } else {
            com.zenmen.palmchat.chat.d.o(activity, i);
        }
    }

    public void a(e eVar, bn2.d dVar, boolean z) {
        if (AndroidVideoEditSwitchConfig.shouldUseNewSDK()) {
            com.zenmen.palmchat.chat.f.p().l(new f.C0981f(eVar.f12868a, eVar.b, eVar.c, eVar.d), dVar, z);
        } else {
            com.zenmen.palmchat.chat.d.j().g(new d.e(eVar.f12868a, eVar.b, eVar.c, eVar.d), dVar, z);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12868a;
        public boolean b;
        public String c;
        public String d;

        public e(String str) {
            this.f12868a = str;
        }

        public e(String str, boolean z, String str2, String str3) {
            this.f12868a = str;
            this.b = z;
            this.c = str2;
            this.d = str3;
        }
    }
}
