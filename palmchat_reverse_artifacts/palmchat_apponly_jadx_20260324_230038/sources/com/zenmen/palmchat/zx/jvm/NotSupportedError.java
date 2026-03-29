package com.zenmen.palmchat.zx.jvm;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00072\u00060\u0001j\u0002`\u0002:\u0001\bB\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/zenmen/palmchat/zx/jvm/NotSupportedError;", "Ljava/lang/Error;", "Lkotlin/Error;", "", "message", "<init>", "(Ljava/lang/String;)V", "Companion", "a", "zx-jvm"}, k = 1, mv = {1, 4, 0})
public final class NotSupportedError extends Error {
    private static final long serialVersionUID = 1510408946931401898L;

    /* JADX WARN: Multi-variable type inference failed */
    public NotSupportedError() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public NotSupportedError(String str) {
        super(str);
    }

    public /* synthetic */ NotSupportedError(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "An operation is not supported." : str);
    }
}
