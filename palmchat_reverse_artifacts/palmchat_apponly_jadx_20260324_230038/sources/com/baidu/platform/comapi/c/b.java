package com.baidu.platform.comapi.c;

import com.baidu.mapapi.map.MapLanguage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f4129a;

    private b() {
        super("map_language");
    }

    public static b c() {
        if (f4129a != null) {
            return f4129a;
        }
        synchronized (b.class) {
            if (f4129a != null) {
                return f4129a;
            }
            f4129a = new b();
            return f4129a;
        }
    }

    public void a(MapLanguage mapLanguage) {
        if (mapLanguage == null) {
            return;
        }
        writeInt(mapLanguage.ordinal());
    }

    public MapLanguage b() {
        MapLanguage mapLanguage = MapLanguage.CHINESE;
        int i = readInt(mapLanguage.ordinal());
        if (mapLanguage.ordinal() == i) {
            return mapLanguage;
        }
        MapLanguage mapLanguage2 = MapLanguage.ENGLISH;
        if (mapLanguage2.ordinal() == i) {
            return mapLanguage2;
        }
        throw new IllegalArgumentException();
    }

    public void a() {
        remove();
    }
}
