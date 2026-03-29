package com.opos.exoplayer.core.metadata;

import com.opos.exoplayer.core.Format;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f8255a = new a();

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements c {
        @Override // com.opos.exoplayer.core.metadata.c
        public boolean a(Format format) {
            String str = format.f;
            return "application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str);
        }

        @Override // com.opos.exoplayer.core.metadata.c
        public com.opos.exoplayer.core.metadata.a b(Format format) {
            String str = format.f;
            str.hashCode();
            switch (str) {
                case "application/id3":
                    return new com.opos.exoplayer.core.metadata.id3.a();
                case "application/x-emsg":
                    return new com.opos.exoplayer.core.metadata.emsg.a();
                case "application/x-scte35":
                    return new com.opos.exoplayer.core.metadata.scte35.a();
                default:
                    throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
            }
        }
    }

    boolean a(Format format);

    com.opos.exoplayer.core.metadata.a b(Format format);
}
