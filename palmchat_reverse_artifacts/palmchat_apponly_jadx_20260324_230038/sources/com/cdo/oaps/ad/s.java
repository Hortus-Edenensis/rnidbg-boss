package com.cdo.oaps.ad;

import android.content.Context;
import com.cdo.oaps.ad.Launcher;
import com.cdo.oaps.ad.wrapper.ResourceWrapper;
import com.cdo.oaps.ad.wrapper.SearchWrapper;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class s {
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

    private static boolean b(Context context, Map<String, Object> map) {
        OapsWrapper oapsWrapperWrapper = OapsWrapper.wrapper(map);
        if (oapsWrapperWrapper.getPath().equals(Launcher.Path.DETAIL)) {
            ResourceWrapper resourceWrapperWrapper = ResourceWrapper.wrapper(oapsWrapperWrapper.getParams());
            if (u.a(context, a.b(a.f5443a), 1)) {
                long id = resourceWrapperWrapper.getId();
                String pkgName = resourceWrapperWrapper.getPkgName();
                boolean autoDown = resourceWrapperWrapper.getAutoDown();
                boolean zEquals = "1".equals(resourceWrapperWrapper.getGoBack());
                int iA = a(resourceWrapperWrapper.getEnterId());
                if (id > 0) {
                    return q.a(context, id, autoDown, zEquals, iA);
                }
                if (!r.a(pkgName)) {
                    return q.a(context, pkgName, autoDown, zEquals, iA);
                }
            }
        }
        if (oapsWrapperWrapper.getPath().equals(Launcher.Path.SEARCH)) {
            SearchWrapper searchWrapperWrapper = SearchWrapper.wrapper(oapsWrapperWrapper.getParams());
            if (u.a(context, a.b(a.f5443a), 1)) {
                return q.a(context, searchWrapperWrapper.getKeyword(), searchWrapperWrapper.getPkgName(), a(searchWrapperWrapper.getEnterId()));
            }
        }
        if (oapsWrapperWrapper.getPath().equals(Launcher.Path.HOME) && u.a(context, a.b(a.f5443a), 1)) {
            return q.a(context);
        }
        return false;
    }

    public static boolean a(Context context, String str) {
        if (u.a(context, a.b(a.f5443a), 2000000)) {
            return true;
        }
        if (u.a(context, a.b(a.f5443a), 1)) {
            for (String str2 : u.c) {
                if (str2.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean a(Context context, Map<String, Object> map) {
        return b(context, map);
    }
}
