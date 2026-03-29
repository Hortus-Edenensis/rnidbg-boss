package com.kwad.sdk.crash;

import com.lantern.auth.server.WkParams;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class d {
    public static final double aTF = Runtime.getRuntime().maxMemory();
    public static final Pattern aTG = Pattern.compile("/data/user");
    public static final Pattern aTH = Pattern.compile("/data");
    public static final Pattern aTI = Pattern.compile("/data/data/(.*)/data/.*");
    public static final Pattern aTJ = Pattern.compile("/data/user/.*/(.*)/data/.*");
    public static int aTK = 10;
    public static String aTL = WkParams.SESSIONID;
}
