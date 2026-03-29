package defpackage;

import com.google.android.exoplayer2.m;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface fn5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final fn5 f17566a = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements fn5 {
        @Override // defpackage.fn5
        public boolean a(m mVar) {
            String str = mVar.l;
            return "text/vtt".equals(str) || "text/x-ssa".equals(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-subrip".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/cea-608".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/cea-708".equals(str) || "application/dvbsubs".equals(str) || "application/pgs".equals(str) || "text/x-exoplayer-cues".equals(str);
        }

        @Override // defpackage.fn5
        public en5 b(m mVar) {
            String str = mVar.l;
            if (str != null) {
                switch (str) {
                    case "application/dvbsubs":
                        return new ri1(mVar.n);
                    case "application/pgs":
                        return new th4();
                    case "application/x-mp4-vtt":
                        return new xr3();
                    case "text/vtt":
                        return new fk6();
                    case "application/x-quicktime-tx3g":
                        return new r26(mVar.n);
                    case "text/x-ssa":
                        return new ak5(mVar.n);
                    case "application/x-mp4-cea-608":
                    case "application/cea-608":
                        return new rz(str, mVar.E, 16000L);
                    case "text/x-exoplayer-cues":
                        return new pr1();
                    case "application/cea-708":
                        return new tz(mVar.E, mVar.n);
                    case "application/x-subrip":
                        return new nm5();
                    case "application/ttml+xml":
                        return new l26();
                }
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
        }
    }

    boolean a(m mVar);

    en5 b(m mVar);
}
