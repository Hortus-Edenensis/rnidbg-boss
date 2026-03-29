package com.zenmen.palmchat.zx.jvm;

import com.huawei.hms.framework.common.ContainerUtils;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/zenmen/palmchat/zx/jvm/COMPARATOR;", "", "", "symbol", "Ljava/lang/String;", "getSymbol", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "a", "EQUAL", "GREATER", "LESS", "GREATER_AND_EQUAL", "LESS_AND_EQUAL", "UNEUQAL", "zx-jvm"}, k = 1, mv = {1, 4, 0})
public enum COMPARATOR {
    EQUAL(ContainerUtils.KEY_VALUE_DELIMITER),
    GREATER(">"),
    LESS("<"),
    GREATER_AND_EQUAL(">="),
    LESS_AND_EQUAL("<="),
    UNEUQAL("!=");

    private final String symbol;

    COMPARATOR(String str) {
        this.symbol = str;
    }

    public final String getSymbol() {
        return this.symbol;
    }
}
