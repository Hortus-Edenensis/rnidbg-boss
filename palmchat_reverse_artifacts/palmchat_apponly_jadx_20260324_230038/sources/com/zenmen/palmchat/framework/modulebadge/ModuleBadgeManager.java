package com.zenmen.palmchat.framework.modulebadge;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ModuleBadgeManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static com.zenmen.palmchat.framework.modulebadge.a f13978a;

    /* JADX INFO: compiled from: SearchBox */
    public enum Module {
        NEARBYGROUP("nearbyGroup"),
        TEST("test");

        public String value;

        Module(String str) {
            this.value = str;
        }
    }

    public static com.zenmen.palmchat.framework.modulebadge.a a() {
        return f13978a;
    }

    public static Module b(String str) {
        if (str != null) {
            for (Module module : Module.values()) {
                if (str.equals(module.value)) {
                    return module;
                }
            }
        }
        return null;
    }

    public static void c(com.zenmen.palmchat.framework.modulebadge.a aVar) {
        f13978a = aVar;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f13979a;
        public int b;

        public a(int i, int i2) {
            this.f13979a = i;
            this.b = i2;
        }

        public a() {
        }
    }
}
