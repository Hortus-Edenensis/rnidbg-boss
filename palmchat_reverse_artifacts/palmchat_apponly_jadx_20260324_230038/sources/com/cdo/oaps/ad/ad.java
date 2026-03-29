package com.cdo.oaps.ad;

import android.content.Context;
import com.cdo.oaps.ad.Launcher;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.cdo.oaps.ad.wrapper.PreDownWrapper;
import com.cdo.oaps.ad.wrapper.ResourceWrapper;
import com.cdo.oaps.ad.wrapper.SearchWrapper;
import com.cdo.oaps.ad.wrapper.WebWrapper;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f5444a = 0;
    private static final int b = 1;

    private static int a(String str) {
        if ("4".equals(str)) {
            return 1607;
        }
        if ("6".equals(str)) {
            return 1609;
        }
        if ("8".equals(str)) {
            return 1611;
        }
        if ("7".equals(str)) {
            return 1610;
        }
        return "5".equals(str) ? 1608 : 1607;
    }

    public static boolean b(Context context, Map<String, Object> map) {
        return a(context, map, 1);
    }

    public static String a(Context context, BaseWrapper baseWrapper) {
        boolean zEquals = "1".equals(baseWrapper.getGoBack());
        String enterId = baseWrapper.getEnterId();
        String enterModule = baseWrapper.getEnterModule();
        return af.a(context, 4600) ? z.a(context, enterId, enterModule, zEquals) : af.a(context, 4550) ? t.a(context, enterId, enterModule, zEquals) : "";
    }

    public static String a(Context context, PreDownWrapper preDownWrapper) {
        if (!af.a(context, 4600)) {
            return "";
        }
        long id = preDownWrapper.getId();
        String pkgName = preDownWrapper.getPkgName();
        int type = preDownWrapper.getType();
        String enterId = preDownWrapper.getEnterId();
        return z.a(context, id, pkgName, type == 0 ? 0 : 1, enterId, preDownWrapper.getEnterModule(), preDownWrapper.getEnterModule2(), a(enterId));
    }

    public static String a(Context context, ResourceWrapper resourceWrapper) {
        long id = resourceWrapper.getId();
        String pkgName = resourceWrapper.getPkgName();
        boolean autoDown = resourceWrapper.getAutoDown();
        boolean zEquals = "1".equals(resourceWrapper.getGoBack());
        String enterId = resourceWrapper.getEnterId();
        String enterModule = resourceWrapper.getEnterModule();
        String enterModule2 = resourceWrapper.getEnterModule2();
        int iA = a(enterId);
        return af.a(context, 4600) ? z.a(context, id, pkgName, autoDown, zEquals, enterId, enterModule, enterModule2, iA, resourceWrapper.getExtModule()) : af.a(context, 4550) ? t.a(context, id, pkgName, autoDown, zEquals, enterId, enterModule, iA, enterModule2) : "";
    }

    public static String a(Context context, SearchWrapper searchWrapper) {
        String keyword = searchWrapper.getKeyword();
        String pkgName = searchWrapper.getPkgName();
        boolean autoDown = searchWrapper.getAutoDown();
        boolean zEquals = "1".equals(searchWrapper.getGoBack());
        String enterId = searchWrapper.getEnterId();
        String enterModule = searchWrapper.getEnterModule();
        String enterModule2 = searchWrapper.getEnterModule2();
        int iA = a(enterId);
        return af.a(context, 4600) ? z.a(context, keyword, pkgName, autoDown, zEquals, enterId, enterModule, enterModule2, iA) : af.a(context, 4550) ? t.a(context, keyword, pkgName, autoDown, zEquals, enterId, enterModule, enterModule2, iA) : "";
    }

    public static String a(Context context, WebWrapper webWrapper) {
        boolean zEquals = "1".equals(webWrapper.getGoBack());
        String url = webWrapper.getUrl();
        String enterId = webWrapper.getEnterId();
        String enterModule = webWrapper.getEnterModule();
        String enterModule2 = webWrapper.getEnterModule2();
        int iA = a(enterId);
        return af.a(context, 4600) ? z.a(context, url, zEquals, enterId, enterModule, enterModule2, iA, webWrapper.getExtModule()) : af.a(context, 4550) ? t.a(context, url, zEquals, enterId, enterModule, iA, enterModule2) : "";
    }

    public static boolean a(Context context, String str) {
        if (af.a(context, 5100)) {
            return true;
        }
        if (af.a(context, 4600)) {
            for (String str2 : af.h) {
                if (str2.equals(str)) {
                    return true;
                }
            }
        } else if (af.a(context, 4550)) {
            for (String str3 : af.g) {
                if (str3.equals(str)) {
                    return true;
                }
            }
        } else if (af.a(context, 390)) {
            for (String str4 : af.f) {
                if (str4.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean a(Context context, Map<String, Object> map) {
        return a(context, map, 0);
    }

    private static boolean a(Context context, Map<String, Object> map, int i) {
        OapsWrapper oapsWrapperWrapper = OapsWrapper.wrapper(map);
        if (oapsWrapperWrapper.getPath().equals(Launcher.Path.DETAIL)) {
            ResourceWrapper resourceWrapperWrapper = ResourceWrapper.wrapper(oapsWrapperWrapper.getParams());
            String strA = a(context, resourceWrapperWrapper);
            if (i != 0 ? ab.b(context, strA) : ab.a(context, strA)) {
                return true;
            }
            if (af.a(context, 390)) {
                long id = resourceWrapperWrapper.getId();
                String pkgName = resourceWrapperWrapper.getPkgName();
                boolean autoDown = resourceWrapperWrapper.getAutoDown();
                boolean zEquals = "1".equals(resourceWrapperWrapper.getGoBack());
                int iA = a(resourceWrapperWrapper.getEnterId());
                if (id > 0) {
                    return aa.a(context, id, autoDown, zEquals, iA);
                }
                if (!ab.a(pkgName)) {
                    return aa.a(context, pkgName, autoDown, zEquals, iA);
                }
            }
        }
        if (oapsWrapperWrapper.getPath().equals(Launcher.Path.SEARCH)) {
            SearchWrapper searchWrapperWrapper = SearchWrapper.wrapper(oapsWrapperWrapper.getParams());
            String strA2 = a(context, searchWrapperWrapper);
            if (i != 0 ? ab.b(context, strA2) : ab.a(context, strA2)) {
                return true;
            }
            if (af.a(context, 390)) {
                return aa.a(context, searchWrapperWrapper.getKeyword(), searchWrapperWrapper.getPkgName(), a(searchWrapperWrapper.getEnterId()));
            }
        }
        if (oapsWrapperWrapper.getPath().equals(Launcher.Path.HOME)) {
            String strA3 = a(context, BaseWrapper.wrapper(oapsWrapperWrapper.getParams()));
            if (i != 0 ? ab.b(context, strA3) : ab.a(context, strA3)) {
                return true;
            }
            if (af.a(context, 390)) {
                return aa.a(context);
            }
        }
        if (oapsWrapperWrapper.getPath().equals(Launcher.Path.PREDOWN)) {
            PreDownWrapper preDownWrapperWrapper = PreDownWrapper.wrapper(oapsWrapperWrapper.getParams());
            String strA4 = a(context, preDownWrapperWrapper);
            if (ab.a(strA4) || i != 0 ? ab.b(context, strA4) : ab.a(context, strA4)) {
                return true;
            }
            if (af.a(context, 4550)) {
                long id2 = preDownWrapperWrapper.getId();
                String pkgName2 = preDownWrapperWrapper.getPkgName();
                int type = preDownWrapperWrapper.getType();
                String enterId = preDownWrapperWrapper.getEnterId();
                if (t.a(context, id2, pkgName2, preDownWrapperWrapper.getEnterModule(), a(enterId), enterId, preDownWrapperWrapper.getEnterModule2(), a.b(type == 0 ? "Y29tLm9wcG8ubWFya2V0LnNlcnZpY2UucHJlX2Rvd25sb2FkLnN0YXJ0" : "Y29tLm9wcG8ubWFya2V0LnNlcnZpY2UucHJlX2Rvd25sb2FkLmNhbmNlbA=="))) {
                    return true;
                }
            }
        }
        if (!oapsWrapperWrapper.getPath().equals(Launcher.Path.WEB)) {
            return false;
        }
        String strA5 = a(context, WebWrapper.wrapper(oapsWrapperWrapper.getParams()));
        if (ab.a(strA5) || i != 0) {
            if (!ab.b(context, strA5)) {
                return false;
            }
        } else if (!ab.a(context, strA5)) {
            return false;
        }
        return true;
    }
}
