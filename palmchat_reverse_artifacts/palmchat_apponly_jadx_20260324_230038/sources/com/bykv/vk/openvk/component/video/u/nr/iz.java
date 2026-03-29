package com.bykv.vk.openvk.component.video.u.nr;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class iz {
    public final u fx;
    public final List<nr> nr;
    public final fx u;

    /* JADX INFO: compiled from: SearchBox */
    public static final class fx {
        final String fx;
        final String nr;
        final String u;

        public String toString() {
            return "RequestLine{method='" + this.u + "', path='" + this.nr + "', version='" + this.fx + "'}";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class nr {
        public final String nr;
        public final String u;

        public nr(String str, String str2) {
            this.u = str;
            this.nr = str2;
        }

        public String toString() {
            return "Header{name='" + this.u + "', value='" + this.nr + "'}";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class u {
        final int b;
        final String fx;
        final List<String> iz;
        final String nr;
        final int pn;
        final int u;

        public String toString() {
            return "Extra{flag=" + this.u + ", rawKey='" + this.nr + "', key='" + this.fx + "', from=" + this.b + ", to=" + this.pn + ", urls=" + this.iz + '}';
        }
    }

    public String toString() {
        return "Request{requestLine=" + this.u + ", headers=" + this.nr + ", extra=" + this.fx + '}';
    }
}
