package com.opos.exoplayer.core.text;

import com.opos.exoplayer.core.Format;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f8341a = new a();

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements e {
        @Override // com.opos.exoplayer.core.text.e
        public boolean a(Format format) {
            String str = format.f;
            return "text/vtt".equals(str) || "text/x-ssa".equals(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-subrip".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/cea-608".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/cea-708".equals(str) || "application/dvbsubs".equals(str) || "application/pgs".equals(str);
        }

        @Override // com.opos.exoplayer.core.text.e
        public c b(Format format) {
            String str = format.f;
            str.hashCode();
            switch (str) {
                case "application/dvbsubs":
                    return new com.opos.exoplayer.core.text.b.a(format.h);
                case "application/pgs":
                    return new com.opos.exoplayer.core.text.c.a();
                case "application/x-mp4-vtt":
                    return new com.opos.exoplayer.core.text.webvtt.a();
                case "text/vtt":
                    return new com.opos.exoplayer.core.text.webvtt.d();
                case "application/x-quicktime-tx3g":
                    return new com.opos.exoplayer.core.text.f.a(format.h);
                case "text/x-ssa":
                    return new com.opos.exoplayer.core.text.d.a(format.h);
                case "application/x-mp4-cea-608":
                case "application/cea-608":
                    return new com.opos.exoplayer.core.text.a.a(format.f, format.z);
                case "application/cea-708":
                    return new com.opos.exoplayer.core.text.a.b(format.z);
                case "application/x-subrip":
                    return new com.opos.exoplayer.core.text.e.a();
                case "application/ttml+xml":
                    return new com.opos.exoplayer.core.text.ttml.a();
                default:
                    throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
            }
        }
    }

    boolean a(Format format);

    c b(Format format);
}
