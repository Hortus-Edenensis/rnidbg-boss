package com.bytedance.adsdk.nr.nr.b;

import com.oplus.tblplayer.Constants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public enum fx implements pn {
    QUESTION(Constants.STRING_VALUE_UNSET, 0),
    COLON(":", 0),
    DOUBLE_AMP("&&", 1),
    DOUBLE_BAR("||", 1),
    EQ("==", 2),
    GT(">", 2),
    LT("<", 2),
    LT_EQ("<=", 2),
    GT_EQ(">=", 2),
    NOT_EQ("!=", 2),
    PLUS("+", 3),
    MINUS("-", 3),
    MULTI("*", 4),
    DIVISION("/", 4),
    MOD("%", 4);

    private final int bg;
    private final String sx;
    private static final Map<String, fx> my = new HashMap(128);
    private static final Set<fx> o = new HashSet();

    static {
        for (fx fxVar : values()) {
            my.put(fxVar.u(), fxVar);
            o.add(fxVar);
        }
    }

    fx(String str, int i) {
        this.sx = str;
        this.bg = i;
    }

    public static fx u(String str) {
        return my.get(str);
    }

    public int nr() {
        return this.bg;
    }

    public static boolean u(pn pnVar) {
        return pnVar instanceof fx;
    }

    public String u() {
        return this.sx;
    }
}
