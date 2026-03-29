package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.ParserException;
import defpackage.c06;
import defpackage.gc4;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public abstract class TagPayloadReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c06 f5872a;

    /* JADX INFO: compiled from: SearchBox */
    public static final class UnsupportedFormatException extends ParserException {
        public UnsupportedFormatException(String str) {
            super(str, null, false, 1);
        }
    }

    public TagPayloadReader(c06 c06Var) {
        this.f5872a = c06Var;
    }

    public final boolean a(gc4 gc4Var, long j) throws ParserException {
        return b(gc4Var) && c(gc4Var, j);
    }

    public abstract boolean b(gc4 gc4Var) throws ParserException;

    public abstract boolean c(gc4 gc4Var, long j) throws ParserException;
}
