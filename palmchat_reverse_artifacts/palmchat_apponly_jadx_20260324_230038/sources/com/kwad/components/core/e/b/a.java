package com.kwad.components.core.e.b;

import com.huawei.hms.framework.common.ContainerUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: com.kwad.components.core.e.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0536a {
        private static final c Pd = c.a(new int[]{7, 8, 4, 2, 0, 3, 6, 9, 1, 8});
    }

    public static long al(String str) {
        return ph().am(str);
    }

    private static c ph() {
        return C0536a.Pd;
    }

    public static String y(long j) {
        String strZ = ph().z(j);
        return strZ.endsWith(ContainerUtils.KEY_VALUE_DELIMITER) ? strZ.replace(ContainerUtils.KEY_VALUE_DELIMITER, "") : strZ;
    }
}
