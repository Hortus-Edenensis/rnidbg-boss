package defpackage;

import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.openalliance.ad.constant.az;
import com.huawei.openalliance.ad.constant.bh;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import com.ss.android.download.api.constant.BaseConstants;
import com.tide.protocol.util.TdFileUtils;
import defpackage.vy5;
import java.util.ArrayList;
import org.jsoup.nodes.Document;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public abstract class bj2 {
    private static final /* synthetic */ bj2[] $VALUES;
    public static final bj2 AfterAfterBody;
    public static final bj2 AfterAfterFrameset;
    public static final bj2 AfterBody;
    public static final bj2 AfterFrameset;
    public static final bj2 AfterHead;
    public static final bj2 BeforeHead;
    public static final bj2 BeforeHtml;
    public static final bj2 ForeignContent;
    public static final bj2 InBody;
    public static final bj2 InCaption;
    public static final bj2 InCell;
    public static final bj2 InColumnGroup;
    public static final bj2 InFrameset;
    public static final bj2 InHead;
    public static final bj2 InHeadNoscript;
    public static final bj2 InRow;
    public static final bj2 InSelect;
    public static final bj2 InSelectInTable;
    public static final bj2 InTable;
    public static final bj2 InTableBody;
    public static final bj2 InTableText;
    public static final bj2 Initial;
    public static final bj2 Text;
    private static String nullString;

    /* JADX INFO: compiled from: SearchBox */
    public enum k extends bj2 {
        public k(String str, int i) {
            super(str, i, null);
        }

        @Override // defpackage.bj2
        public boolean process(vy5 vy5Var, aj2 aj2Var) {
            if (bj2.isWhitespace(vy5Var)) {
                return true;
            }
            if (vy5Var.g()) {
                aj2Var.N(vy5Var.b());
            } else {
                if (!vy5Var.h()) {
                    aj2Var.C0(bj2.BeforeHtml);
                    return aj2Var.e(vy5Var);
                }
                vy5.d dVarC = vy5Var.c();
                aj2Var.w().Z(new org.jsoup.nodes.e(aj2Var.h.b(dVarC.o()), dVarC.p(), dVarC.q(), aj2Var.v()));
                if (dVarC.r()) {
                    aj2Var.w().X0(Document.QuirksMode.quirks);
                }
                aj2Var.C0(bj2.BeforeHtml);
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1733a;

        static {
            int[] iArr = new int[vy5.i.values().length];
            f1733a = iArr;
            try {
                iArr[vy5.i.Comment.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1733a[vy5.i.Doctype.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1733a[vy5.i.StartTag.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1733a[vy5.i.EndTag.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1733a[vy5.i.Character.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1733a[vy5.i.EOF.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String[] f1734a = {"base", "basefont", "bgsound", com.heytap.mcssdk.constant.b.y, "link", "meta", "noframes", "script", "style", "title"};
        public static final String[] b = {"address", "article", "aside", "blockquote", "center", BaseConstants.MARKET_URI_AUTHORITY_DETAIL, MapBundleKey.MapObjKey.OBJ_DIR, "div", CmcdConfiguration.KEY_DEADLINE, "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "menu", "nav", "ol", "p", "section", "summary", "ul"};
        public static final String[] c = {"h1", "h2", "h3", "h4", "h5", "h6"};
        public static final String[] d = {"pre", "listing"};
        public static final String[] e = {"address", "div", "p"};
        public static final String[] f = {"dd", "dt"};
        public static final String[] g = {com.kuaishou.weapon.p0.t.l, "big", "code", "em", "font", "i", "s", "small", "strike", "strong", "tt", "u"};
        public static final String[] h = {"applet", "marquee", "object"};
        public static final String[] i = {"area", "br", "embed", bh.Code, "keygen", "wbr"};
        public static final String[] j = {RemoteMessageConst.MessageBody.PARAM, az.at, FFmpegMediaMetadataRetriever.METADATA_KEY_TRACK};
        public static final String[] k = {"name", "action", "prompt"};
        public static final String[] l = {"optgroup", "option"};
        public static final String[] m = {"rp", "rt"};
        public static final String[] n = {"caption", "col", "colgroup", "frame", "head", "tbody", TdFileUtils.PLUGIN_FILE, "tfoot", "th", "thead", "tr"};
        public static final String[] o = {"address", "article", "aside", "blockquote", "button", "center", BaseConstants.MARKET_URI_AUTHORITY_DETAIL, MapBundleKey.MapObjKey.OBJ_DIR, "div", CmcdConfiguration.KEY_DEADLINE, "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "listing", "menu", "nav", "ol", "pre", "section", "summary", "ul"};
        public static final String[] p = {"a", com.kuaishou.weapon.p0.t.l, "big", "code", "em", "font", "i", "nobr", "s", "small", "strike", "strong", "tt", "u"};
        public static final String[] q = {"table", "tbody", "tfoot", "thead", "tr"};
    }

    static {
        k kVar = new k("Initial", 0);
        Initial = kVar;
        bj2 bj2Var = new bj2("BeforeHtml", 1) { // from class: bj2.q
            {
                k kVar2 = null;
            }

            private boolean anythingElse(vy5 vy5Var, aj2 aj2Var) {
                aj2Var.V("html");
                aj2Var.C0(bj2.BeforeHead);
                return aj2Var.e(vy5Var);
            }

            @Override // defpackage.bj2
            public boolean process(vy5 vy5Var, aj2 aj2Var) {
                if (vy5Var.h()) {
                    aj2Var.p(this);
                    return false;
                }
                if (vy5Var.g()) {
                    aj2Var.N(vy5Var.b());
                } else {
                    if (bj2.isWhitespace(vy5Var)) {
                        return true;
                    }
                    if (!vy5Var.k() || !vy5Var.e().C().equals("html")) {
                        if (vy5Var.j() && jl5.b(vy5Var.d().C(), "head", "body", "html", "br")) {
                            return anythingElse(vy5Var, aj2Var);
                        }
                        if (!vy5Var.j()) {
                            return anythingElse(vy5Var, aj2Var);
                        }
                        aj2Var.p(this);
                        return false;
                    }
                    aj2Var.L(vy5Var.e());
                    aj2Var.C0(bj2.BeforeHead);
                }
                return true;
            }
        };
        BeforeHtml = bj2Var;
        bj2 bj2Var2 = new bj2("BeforeHead", 2) { // from class: bj2.r
            {
                k kVar2 = null;
            }

            @Override // defpackage.bj2
            public boolean process(vy5 vy5Var, aj2 aj2Var) {
                if (bj2.isWhitespace(vy5Var)) {
                    return true;
                }
                if (vy5Var.g()) {
                    aj2Var.N(vy5Var.b());
                } else {
                    if (vy5Var.h()) {
                        aj2Var.p(this);
                        return false;
                    }
                    if (vy5Var.k() && vy5Var.e().C().equals("html")) {
                        return bj2.InBody.process(vy5Var, aj2Var);
                    }
                    if (!vy5Var.k() || !vy5Var.e().C().equals("head")) {
                        if (vy5Var.j() && jl5.b(vy5Var.d().C(), "head", "body", "html", "br")) {
                            aj2Var.g("head");
                            return aj2Var.e(vy5Var);
                        }
                        if (vy5Var.j()) {
                            aj2Var.p(this);
                            return false;
                        }
                        aj2Var.g("head");
                        return aj2Var.e(vy5Var);
                    }
                    aj2Var.A0(aj2Var.L(vy5Var.e()));
                    aj2Var.C0(bj2.InHead);
                }
                return true;
            }
        };
        BeforeHead = bj2Var2;
        bj2 bj2Var3 = new bj2("InHead", 3) { // from class: bj2.s
            {
                k kVar2 = null;
            }

            private boolean anythingElse(vy5 vy5Var, n16 n16Var) {
                n16Var.f("head");
                return n16Var.e(vy5Var);
            }

            @Override // defpackage.bj2
            public boolean process(vy5 vy5Var, aj2 aj2Var) {
                if (bj2.isWhitespace(vy5Var)) {
                    aj2Var.M(vy5Var.a());
                    return true;
                }
                int i2 = p.f1733a[vy5Var.f21560a.ordinal()];
                if (i2 == 1) {
                    aj2Var.N(vy5Var.b());
                } else {
                    if (i2 == 2) {
                        aj2Var.p(this);
                        return false;
                    }
                    if (i2 == 3) {
                        vy5.g gVarE = vy5Var.e();
                        String strC = gVarE.C();
                        if (strC.equals("html")) {
                            return bj2.InBody.process(vy5Var, aj2Var);
                        }
                        if (jl5.b(strC, "base", "basefont", "bgsound", com.heytap.mcssdk.constant.b.y, "link")) {
                            org.jsoup.nodes.f fVarP = aj2Var.P(gVarE);
                            if (strC.equals("base") && fVarP.u("href")) {
                                aj2Var.e0(fVarP);
                            }
                        } else if (strC.equals("meta")) {
                            aj2Var.P(gVarE);
                        } else if (strC.equals("title")) {
                            bj2.handleRcData(gVarE, aj2Var);
                        } else if (jl5.b(strC, "noframes", "style")) {
                            bj2.handleRawtext(gVarE, aj2Var);
                        } else if (strC.equals("noscript")) {
                            aj2Var.L(gVarE);
                            aj2Var.C0(bj2.InHeadNoscript);
                        } else {
                            if (!strC.equals("script")) {
                                if (!strC.equals("head")) {
                                    return anythingElse(vy5Var, aj2Var);
                                }
                                aj2Var.p(this);
                                return false;
                            }
                            aj2Var.b.v(zy5.ScriptData);
                            aj2Var.d0();
                            aj2Var.C0(bj2.Text);
                            aj2Var.L(gVarE);
                        }
                    } else {
                        if (i2 != 4) {
                            return anythingElse(vy5Var, aj2Var);
                        }
                        String strC2 = vy5Var.d().C();
                        if (!strC2.equals("head")) {
                            if (jl5.b(strC2, "body", "html", "br")) {
                                return anythingElse(vy5Var, aj2Var);
                            }
                            aj2Var.p(this);
                            return false;
                        }
                        aj2Var.j0();
                        aj2Var.C0(bj2.AfterHead);
                    }
                }
                return true;
            }
        };
        InHead = bj2Var3;
        bj2 bj2Var4 = new bj2("InHeadNoscript", 4) { // from class: bj2.t
            {
                k kVar2 = null;
            }

            private boolean anythingElse(vy5 vy5Var, aj2 aj2Var) {
                aj2Var.p(this);
                aj2Var.M(new vy5.b().o(vy5Var.toString()));
                return true;
            }

            @Override // defpackage.bj2
            public boolean process(vy5 vy5Var, aj2 aj2Var) {
                if (vy5Var.h()) {
                    aj2Var.p(this);
                    return true;
                }
                if (vy5Var.k() && vy5Var.e().C().equals("html")) {
                    return aj2Var.n0(vy5Var, bj2.InBody);
                }
                if (vy5Var.j() && vy5Var.d().C().equals("noscript")) {
                    aj2Var.j0();
                    aj2Var.C0(bj2.InHead);
                    return true;
                }
                if (bj2.isWhitespace(vy5Var) || vy5Var.g() || (vy5Var.k() && jl5.b(vy5Var.e().C(), "basefont", "bgsound", "link", "meta", "noframes", "style"))) {
                    return aj2Var.n0(vy5Var, bj2.InHead);
                }
                if (vy5Var.j() && vy5Var.d().C().equals("br")) {
                    return anythingElse(vy5Var, aj2Var);
                }
                if ((!vy5Var.k() || !jl5.b(vy5Var.e().C(), "head", "noscript")) && !vy5Var.j()) {
                    return anythingElse(vy5Var, aj2Var);
                }
                aj2Var.p(this);
                return false;
            }
        };
        InHeadNoscript = bj2Var4;
        bj2 bj2Var5 = new bj2("AfterHead", 5) { // from class: bj2.u
            {
                k kVar2 = null;
            }

            private boolean anythingElse(vy5 vy5Var, aj2 aj2Var) {
                aj2Var.g("body");
                aj2Var.q(true);
                return aj2Var.e(vy5Var);
            }

            @Override // defpackage.bj2
            public boolean process(vy5 vy5Var, aj2 aj2Var) {
                if (bj2.isWhitespace(vy5Var)) {
                    aj2Var.M(vy5Var.a());
                    return true;
                }
                if (vy5Var.g()) {
                    aj2Var.N(vy5Var.b());
                    return true;
                }
                if (vy5Var.h()) {
                    aj2Var.p(this);
                    return true;
                }
                if (!vy5Var.k()) {
                    if (!vy5Var.j()) {
                        anythingElse(vy5Var, aj2Var);
                        return true;
                    }
                    if (jl5.b(vy5Var.d().C(), "body", "html")) {
                        anythingElse(vy5Var, aj2Var);
                        return true;
                    }
                    aj2Var.p(this);
                    return false;
                }
                vy5.g gVarE = vy5Var.e();
                String strC = gVarE.C();
                if (strC.equals("html")) {
                    return aj2Var.n0(vy5Var, bj2.InBody);
                }
                if (strC.equals("body")) {
                    aj2Var.L(gVarE);
                    aj2Var.q(false);
                    aj2Var.C0(bj2.InBody);
                    return true;
                }
                if (strC.equals("frameset")) {
                    aj2Var.L(gVarE);
                    aj2Var.C0(bj2.InFrameset);
                    return true;
                }
                if (!jl5.b(strC, "base", "basefont", "bgsound", "link", "meta", "noframes", "script", "style", "title")) {
                    if (strC.equals("head")) {
                        aj2Var.p(this);
                        return false;
                    }
                    anythingElse(vy5Var, aj2Var);
                    return true;
                }
                aj2Var.p(this);
                org.jsoup.nodes.f fVarZ = aj2Var.z();
                aj2Var.o0(fVarZ);
                aj2Var.n0(vy5Var, bj2.InHead);
                aj2Var.s0(fVarZ);
                return true;
            }
        };
        AfterHead = bj2Var5;
        bj2 bj2Var6 = new bj2("InBody", 6) { // from class: bj2.v
            {
                k kVar2 = null;
            }

            /* JADX WARN: Code restructure failed: missing block: B:15:0x004a, code lost:
            
                return true;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean anyOtherEndTag(vy5 vy5Var, aj2 aj2Var) {
                String strC = vy5Var.d().C();
                ArrayList<org.jsoup.nodes.f> arrayListB = aj2Var.B();
                int size = arrayListB.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    org.jsoup.nodes.f fVar = arrayListB.get(size);
                    if (fVar.x().equals(strC)) {
                        aj2Var.t(strC);
                        if (!strC.equals(aj2Var.a().x())) {
                            aj2Var.p(this);
                        }
                        aj2Var.l0(strC);
                    } else {
                        if (aj2Var.b0(fVar)) {
                            aj2Var.p(this);
                            return false;
                        }
                        size--;
                    }
                }
            }

            @Override // defpackage.bj2
            public boolean process(vy5 vy5Var, aj2 aj2Var) {
                org.jsoup.nodes.f fVar;
                int i2 = p.f1733a[vy5Var.f21560a.ordinal()];
                boolean z = true;
                if (i2 == 1) {
                    aj2Var.N(vy5Var.b());
                } else {
                    if (i2 == 2) {
                        aj2Var.p(this);
                        return false;
                    }
                    if (i2 == 3) {
                        vy5.g gVarE = vy5Var.e();
                        String strC = gVarE.C();
                        if (strC.equals("a")) {
                            if (aj2Var.u("a") != null) {
                                aj2Var.p(this);
                                aj2Var.f("a");
                                org.jsoup.nodes.f fVarY = aj2Var.y("a");
                                if (fVarY != null) {
                                    aj2Var.r0(fVarY);
                                    aj2Var.s0(fVarY);
                                }
                            }
                            aj2Var.q0();
                            aj2Var.p0(aj2Var.L(gVarE));
                        } else if (jl5.c(strC, y.i)) {
                            aj2Var.q0();
                            aj2Var.P(gVarE);
                            aj2Var.q(false);
                        } else if (jl5.c(strC, y.b)) {
                            if (aj2Var.C("p")) {
                                aj2Var.f("p");
                            }
                            aj2Var.L(gVarE);
                        } else if (strC.equals("span")) {
                            aj2Var.q0();
                            aj2Var.L(gVarE);
                        } else if (strC.equals("li")) {
                            aj2Var.q(false);
                            ArrayList<org.jsoup.nodes.f> arrayListB = aj2Var.B();
                            int size = arrayListB.size() - 1;
                            while (true) {
                                if (size <= 0) {
                                    break;
                                }
                                org.jsoup.nodes.f fVar2 = arrayListB.get(size);
                                if (fVar2.x().equals("li")) {
                                    aj2Var.f("li");
                                    break;
                                }
                                if (aj2Var.b0(fVar2) && !jl5.c(fVar2.x(), y.e)) {
                                    break;
                                }
                                size--;
                            }
                            if (aj2Var.C("p")) {
                                aj2Var.f("p");
                            }
                            aj2Var.L(gVarE);
                        } else if (strC.equals("html")) {
                            aj2Var.p(this);
                            org.jsoup.nodes.f fVar3 = aj2Var.B().get(0);
                            for (org.jsoup.nodes.a aVar : gVarE.x()) {
                                if (!fVar3.u(aVar.getKey())) {
                                    fVar3.h().l(aVar);
                                }
                            }
                        } else {
                            if (jl5.c(strC, y.f1734a)) {
                                return aj2Var.n0(vy5Var, bj2.InHead);
                            }
                            if (strC.equals("body")) {
                                aj2Var.p(this);
                                ArrayList<org.jsoup.nodes.f> arrayListB2 = aj2Var.B();
                                if (arrayListB2.size() == 1 || (arrayListB2.size() > 2 && !arrayListB2.get(1).x().equals("body"))) {
                                    return false;
                                }
                                aj2Var.q(false);
                                org.jsoup.nodes.f fVar4 = arrayListB2.get(1);
                                for (org.jsoup.nodes.a aVar2 : gVarE.x()) {
                                    if (!fVar4.u(aVar2.getKey())) {
                                        fVar4.h().l(aVar2);
                                    }
                                }
                            } else if (strC.equals("frameset")) {
                                aj2Var.p(this);
                                ArrayList<org.jsoup.nodes.f> arrayListB3 = aj2Var.B();
                                if (arrayListB3.size() == 1 || ((arrayListB3.size() > 2 && !arrayListB3.get(1).x().equals("body")) || !aj2Var.r())) {
                                    return false;
                                }
                                org.jsoup.nodes.f fVar5 = arrayListB3.get(1);
                                if (fVar5.D() != null) {
                                    fVar5.G();
                                }
                                for (int i3 = 1; arrayListB3.size() > i3; i3 = 1) {
                                    arrayListB3.remove(arrayListB3.size() - i3);
                                }
                                aj2Var.L(gVarE);
                                aj2Var.C0(bj2.InFrameset);
                            } else if (jl5.c(strC, y.c)) {
                                if (aj2Var.C("p")) {
                                    aj2Var.f("p");
                                }
                                if (jl5.c(aj2Var.a().x(), y.c)) {
                                    aj2Var.p(this);
                                    aj2Var.j0();
                                }
                                aj2Var.L(gVarE);
                            } else if (jl5.c(strC, y.d)) {
                                if (aj2Var.C("p")) {
                                    aj2Var.f("p");
                                }
                                aj2Var.L(gVarE);
                                aj2Var.q(false);
                            } else {
                                if (strC.equals("form")) {
                                    if (aj2Var.x() != null) {
                                        aj2Var.p(this);
                                        return false;
                                    }
                                    if (aj2Var.C("p")) {
                                        aj2Var.f("p");
                                    }
                                    aj2Var.Q(gVarE, true);
                                    return true;
                                }
                                if (jl5.c(strC, y.f)) {
                                    aj2Var.q(false);
                                    ArrayList<org.jsoup.nodes.f> arrayListB4 = aj2Var.B();
                                    int size2 = arrayListB4.size() - 1;
                                    while (true) {
                                        if (size2 <= 0) {
                                            break;
                                        }
                                        org.jsoup.nodes.f fVar6 = arrayListB4.get(size2);
                                        if (jl5.c(fVar6.x(), y.f)) {
                                            aj2Var.f(fVar6.x());
                                            break;
                                        }
                                        if (aj2Var.b0(fVar6) && !jl5.c(fVar6.x(), y.e)) {
                                            break;
                                        }
                                        size2--;
                                    }
                                    if (aj2Var.C("p")) {
                                        aj2Var.f("p");
                                    }
                                    aj2Var.L(gVarE);
                                } else if (strC.equals("plaintext")) {
                                    if (aj2Var.C("p")) {
                                        aj2Var.f("p");
                                    }
                                    aj2Var.L(gVarE);
                                    aj2Var.b.v(zy5.PLAINTEXT);
                                } else if (strC.equals("button")) {
                                    if (aj2Var.C("button")) {
                                        aj2Var.p(this);
                                        aj2Var.f("button");
                                        aj2Var.e(gVarE);
                                    } else {
                                        aj2Var.q0();
                                        aj2Var.L(gVarE);
                                        aj2Var.q(false);
                                    }
                                } else if (jl5.c(strC, y.g)) {
                                    aj2Var.q0();
                                    aj2Var.p0(aj2Var.L(gVarE));
                                } else if (strC.equals("nobr")) {
                                    aj2Var.q0();
                                    if (aj2Var.E("nobr")) {
                                        aj2Var.p(this);
                                        aj2Var.f("nobr");
                                        aj2Var.q0();
                                    }
                                    aj2Var.p0(aj2Var.L(gVarE));
                                } else if (jl5.c(strC, y.h)) {
                                    aj2Var.q0();
                                    aj2Var.L(gVarE);
                                    aj2Var.S();
                                    aj2Var.q(false);
                                } else if (strC.equals("table")) {
                                    if (aj2Var.w().W0() != Document.QuirksMode.quirks && aj2Var.C("p")) {
                                        aj2Var.f("p");
                                    }
                                    aj2Var.L(gVarE);
                                    aj2Var.q(false);
                                    aj2Var.C0(bj2.InTable);
                                } else if (strC.equals("input")) {
                                    aj2Var.q0();
                                    if (!aj2Var.P(gVarE).f("type").equalsIgnoreCase("hidden")) {
                                        aj2Var.q(false);
                                    }
                                } else if (jl5.c(strC, y.j)) {
                                    aj2Var.P(gVarE);
                                } else if (strC.equals("hr")) {
                                    if (aj2Var.C("p")) {
                                        aj2Var.f("p");
                                    }
                                    aj2Var.P(gVarE);
                                    aj2Var.q(false);
                                } else if (strC.equals("image")) {
                                    if (aj2Var.y("svg") == null) {
                                        return aj2Var.e(gVarE.z(bh.Code));
                                    }
                                    aj2Var.L(gVarE);
                                } else if (strC.equals("isindex")) {
                                    aj2Var.p(this);
                                    if (aj2Var.x() != null) {
                                        return false;
                                    }
                                    aj2Var.b.a();
                                    aj2Var.g("form");
                                    if (gVarE.j.g("action")) {
                                        aj2Var.x().c0("action", gVarE.j.e("action"));
                                    }
                                    aj2Var.g("hr");
                                    aj2Var.g("label");
                                    aj2Var.e(new vy5.b().o(gVarE.j.g("prompt") ? gVarE.j.e("prompt") : "This is a searchable index. Enter search keywords: "));
                                    org.jsoup.nodes.b bVar = new org.jsoup.nodes.b();
                                    for (org.jsoup.nodes.a aVar3 : gVarE.j) {
                                        if (!jl5.c(aVar3.getKey(), y.k)) {
                                            bVar.l(aVar3);
                                        }
                                    }
                                    bVar.k("name", "isindex");
                                    aj2Var.h("input", bVar);
                                    aj2Var.f("label");
                                    aj2Var.g("hr");
                                    aj2Var.f("form");
                                } else if (strC.equals("textarea")) {
                                    aj2Var.L(gVarE);
                                    aj2Var.b.v(zy5.Rcdata);
                                    aj2Var.d0();
                                    aj2Var.q(false);
                                    aj2Var.C0(bj2.Text);
                                } else if (strC.equals("xmp")) {
                                    if (aj2Var.C("p")) {
                                        aj2Var.f("p");
                                    }
                                    aj2Var.q0();
                                    aj2Var.q(false);
                                    bj2.handleRawtext(gVarE, aj2Var);
                                } else if (strC.equals("iframe")) {
                                    aj2Var.q(false);
                                    bj2.handleRawtext(gVarE, aj2Var);
                                } else if (strC.equals("noembed")) {
                                    bj2.handleRawtext(gVarE, aj2Var);
                                } else if (strC.equals("select")) {
                                    aj2Var.q0();
                                    aj2Var.L(gVarE);
                                    aj2Var.q(false);
                                    bj2 bj2VarB0 = aj2Var.B0();
                                    if (bj2VarB0.equals(bj2.InTable) || bj2VarB0.equals(bj2.InCaption) || bj2VarB0.equals(bj2.InTableBody) || bj2VarB0.equals(bj2.InRow) || bj2VarB0.equals(bj2.InCell)) {
                                        aj2Var.C0(bj2.InSelectInTable);
                                    } else {
                                        aj2Var.C0(bj2.InSelect);
                                    }
                                } else if (jl5.c(strC, y.l)) {
                                    if (aj2Var.a().x().equals("option")) {
                                        aj2Var.f("option");
                                    }
                                    aj2Var.q0();
                                    aj2Var.L(gVarE);
                                } else if (jl5.c(strC, y.m)) {
                                    if (aj2Var.E("ruby")) {
                                        aj2Var.s();
                                        if (!aj2Var.a().x().equals("ruby")) {
                                            aj2Var.p(this);
                                            aj2Var.k0("ruby");
                                        }
                                        aj2Var.L(gVarE);
                                    }
                                } else if (strC.equals("math") || strC.equals("svg")) {
                                    aj2Var.q0();
                                    aj2Var.L(gVarE);
                                    aj2Var.b.a();
                                } else {
                                    if (jl5.c(strC, y.n)) {
                                        aj2Var.p(this);
                                        return false;
                                    }
                                    aj2Var.q0();
                                    aj2Var.L(gVarE);
                                }
                            }
                        }
                    } else if (i2 == 4) {
                        vy5.f fVarD = vy5Var.d();
                        String strC2 = fVarD.C();
                        if (jl5.c(strC2, y.p)) {
                            int i4 = 0;
                            while (i4 < 8) {
                                org.jsoup.nodes.f fVarU = aj2Var.u(strC2);
                                if (fVarU == null) {
                                    return anyOtherEndTag(vy5Var, aj2Var);
                                }
                                if (!aj2Var.g0(fVarU)) {
                                    aj2Var.p(this);
                                    aj2Var.r0(fVarU);
                                    return z;
                                }
                                if (!aj2Var.E(fVarU.x())) {
                                    aj2Var.p(this);
                                    return false;
                                }
                                if (aj2Var.a() != fVarU) {
                                    aj2Var.p(this);
                                }
                                ArrayList<org.jsoup.nodes.f> arrayListB5 = aj2Var.B();
                                int size3 = arrayListB5.size();
                                org.jsoup.nodes.f fVar7 = null;
                                boolean z2 = false;
                                for (int i5 = 0; i5 < size3 && i5 < 64; i5++) {
                                    fVar = arrayListB5.get(i5);
                                    if (fVar != fVarU) {
                                        if (z2 && aj2Var.b0(fVar)) {
                                            break;
                                        }
                                    } else {
                                        fVar7 = arrayListB5.get(i5 - 1);
                                        z2 = true;
                                    }
                                }
                                fVar = null;
                                if (fVar == null) {
                                    aj2Var.l0(fVarU.x());
                                    aj2Var.r0(fVarU);
                                    return z;
                                }
                                org.jsoup.nodes.f fVarJ = fVar;
                                org.jsoup.nodes.f fVar8 = fVarJ;
                                for (int i6 = 0; i6 < 3; i6++) {
                                    if (aj2Var.g0(fVarJ)) {
                                        fVarJ = aj2Var.j(fVarJ);
                                    }
                                    if (!aj2Var.Z(fVarJ)) {
                                        aj2Var.s0(fVarJ);
                                    } else {
                                        if (fVarJ == fVarU) {
                                            break;
                                        }
                                        org.jsoup.nodes.f fVar9 = new org.jsoup.nodes.f(bt5.k(fVarJ.x(), kc4.d), aj2Var.v());
                                        aj2Var.u0(fVarJ, fVar9);
                                        aj2Var.w0(fVarJ, fVar9);
                                        if (fVar8.D() != null) {
                                            fVar8.G();
                                        }
                                        fVar9.Z(fVar8);
                                        fVarJ = fVar9;
                                        fVar8 = fVarJ;
                                    }
                                }
                                if (jl5.c(fVar7.x(), y.q)) {
                                    if (fVar8.D() != null) {
                                        fVar8.G();
                                    }
                                    aj2Var.R(fVar8);
                                } else {
                                    if (fVar8.D() != null) {
                                        fVar8.G();
                                    }
                                    fVar7.Z(fVar8);
                                }
                                org.jsoup.nodes.f fVar10 = new org.jsoup.nodes.f(fVarU.J0(), aj2Var.v());
                                fVar10.h().a(fVarU.h());
                                for (org.jsoup.nodes.g gVar : (org.jsoup.nodes.g[]) fVar.n().toArray(new org.jsoup.nodes.g[fVar.m()])) {
                                    fVar10.Z(gVar);
                                }
                                fVar.Z(fVar10);
                                aj2Var.r0(fVarU);
                                aj2Var.s0(fVarU);
                                aj2Var.U(fVar, fVar10);
                                i4++;
                                z = true;
                            }
                        } else if (jl5.c(strC2, y.o)) {
                            if (!aj2Var.E(strC2)) {
                                aj2Var.p(this);
                                return false;
                            }
                            aj2Var.s();
                            if (!aj2Var.a().x().equals(strC2)) {
                                aj2Var.p(this);
                            }
                            aj2Var.l0(strC2);
                        } else {
                            if (strC2.equals("span")) {
                                return anyOtherEndTag(vy5Var, aj2Var);
                            }
                            if (strC2.equals("li")) {
                                if (!aj2Var.D(strC2)) {
                                    aj2Var.p(this);
                                    return false;
                                }
                                aj2Var.t(strC2);
                                if (!aj2Var.a().x().equals(strC2)) {
                                    aj2Var.p(this);
                                }
                                aj2Var.l0(strC2);
                            } else if (strC2.equals("body")) {
                                if (!aj2Var.E("body")) {
                                    aj2Var.p(this);
                                    return false;
                                }
                                aj2Var.C0(bj2.AfterBody);
                            } else if (strC2.equals("html")) {
                                if (aj2Var.f("body")) {
                                    return aj2Var.e(fVarD);
                                }
                            } else if (strC2.equals("form")) {
                                z02 z02VarX = aj2Var.x();
                                aj2Var.y0(null);
                                if (z02VarX == null || !aj2Var.E(strC2)) {
                                    aj2Var.p(this);
                                    return false;
                                }
                                aj2Var.s();
                                if (!aj2Var.a().x().equals(strC2)) {
                                    aj2Var.p(this);
                                }
                                aj2Var.s0(z02VarX);
                            } else if (strC2.equals("p")) {
                                if (!aj2Var.C(strC2)) {
                                    aj2Var.p(this);
                                    aj2Var.g(strC2);
                                    return aj2Var.e(fVarD);
                                }
                                aj2Var.t(strC2);
                                if (!aj2Var.a().x().equals(strC2)) {
                                    aj2Var.p(this);
                                }
                                aj2Var.l0(strC2);
                            } else if (jl5.c(strC2, y.f)) {
                                if (!aj2Var.E(strC2)) {
                                    aj2Var.p(this);
                                    return false;
                                }
                                aj2Var.t(strC2);
                                if (!aj2Var.a().x().equals(strC2)) {
                                    aj2Var.p(this);
                                }
                                aj2Var.l0(strC2);
                            } else if (jl5.c(strC2, y.c)) {
                                if (!aj2Var.G(y.c)) {
                                    aj2Var.p(this);
                                    return false;
                                }
                                aj2Var.t(strC2);
                                if (!aj2Var.a().x().equals(strC2)) {
                                    aj2Var.p(this);
                                }
                                aj2Var.m0(y.c);
                            } else {
                                if (strC2.equals("sarcasm")) {
                                    return anyOtherEndTag(vy5Var, aj2Var);
                                }
                                if (!jl5.c(strC2, y.h)) {
                                    if (!strC2.equals("br")) {
                                        return anyOtherEndTag(vy5Var, aj2Var);
                                    }
                                    aj2Var.p(this);
                                    aj2Var.g("br");
                                    return false;
                                }
                                if (!aj2Var.E("name")) {
                                    if (!aj2Var.E(strC2)) {
                                        aj2Var.p(this);
                                        return false;
                                    }
                                    aj2Var.s();
                                    if (!aj2Var.a().x().equals(strC2)) {
                                        aj2Var.p(this);
                                    }
                                    aj2Var.l0(strC2);
                                    aj2Var.k();
                                }
                            }
                        }
                    } else if (i2 == 5) {
                        vy5.b bVarA = vy5Var.a();
                        if (bVarA.p().equals(bj2.nullString)) {
                            aj2Var.p(this);
                            return false;
                        }
                        if (aj2Var.r() && bj2.isWhitespace(bVarA)) {
                            aj2Var.q0();
                            aj2Var.M(bVarA);
                        } else {
                            aj2Var.q0();
                            aj2Var.M(bVarA);
                            aj2Var.q(false);
                        }
                    }
                }
                return true;
            }
        };
        InBody = bj2Var6;
        bj2 bj2Var7 = new bj2("Text", 7) { // from class: bj2.w
            {
                k kVar2 = null;
            }

            @Override // defpackage.bj2
            public boolean process(vy5 vy5Var, aj2 aj2Var) {
                if (vy5Var.f()) {
                    aj2Var.M(vy5Var.a());
                    return true;
                }
                if (vy5Var.i()) {
                    aj2Var.p(this);
                    aj2Var.j0();
                    aj2Var.C0(aj2Var.h0());
                    return aj2Var.e(vy5Var);
                }
                if (!vy5Var.j()) {
                    return true;
                }
                aj2Var.j0();
                aj2Var.C0(aj2Var.h0());
                return true;
            }
        };
        Text = bj2Var7;
        bj2 bj2Var8 = new bj2("InTable", 8) { // from class: bj2.x
            {
                k kVar2 = null;
            }

            public boolean anythingElse(vy5 vy5Var, aj2 aj2Var) {
                aj2Var.p(this);
                if (!jl5.b(aj2Var.a().x(), "table", "tbody", "tfoot", "thead", "tr")) {
                    return aj2Var.n0(vy5Var, bj2.InBody);
                }
                aj2Var.z0(true);
                boolean zN0 = aj2Var.n0(vy5Var, bj2.InBody);
                aj2Var.z0(false);
                return zN0;
            }

            @Override // defpackage.bj2
            public boolean process(vy5 vy5Var, aj2 aj2Var) {
                if (vy5Var.f()) {
                    aj2Var.f0();
                    aj2Var.d0();
                    aj2Var.C0(bj2.InTableText);
                    return aj2Var.e(vy5Var);
                }
                if (vy5Var.g()) {
                    aj2Var.N(vy5Var.b());
                    return true;
                }
                if (vy5Var.h()) {
                    aj2Var.p(this);
                    return false;
                }
                if (!vy5Var.k()) {
                    if (!vy5Var.j()) {
                        if (!vy5Var.i()) {
                            return anythingElse(vy5Var, aj2Var);
                        }
                        if (aj2Var.a().x().equals("html")) {
                            aj2Var.p(this);
                        }
                        return true;
                    }
                    String strC = vy5Var.d().C();
                    if (!strC.equals("table")) {
                        if (!jl5.b(strC, "body", "caption", "col", "colgroup", "html", "tbody", TdFileUtils.PLUGIN_FILE, "tfoot", "th", "thead", "tr")) {
                            return anythingElse(vy5Var, aj2Var);
                        }
                        aj2Var.p(this);
                        return false;
                    }
                    if (!aj2Var.K(strC)) {
                        aj2Var.p(this);
                        return false;
                    }
                    aj2Var.l0("table");
                    aj2Var.x0();
                    return true;
                }
                vy5.g gVarE = vy5Var.e();
                String strC2 = gVarE.C();
                if (strC2.equals("caption")) {
                    aj2Var.n();
                    aj2Var.S();
                    aj2Var.L(gVarE);
                    aj2Var.C0(bj2.InCaption);
                } else if (strC2.equals("colgroup")) {
                    aj2Var.n();
                    aj2Var.L(gVarE);
                    aj2Var.C0(bj2.InColumnGroup);
                } else {
                    if (strC2.equals("col")) {
                        aj2Var.g("colgroup");
                        return aj2Var.e(vy5Var);
                    }
                    if (jl5.b(strC2, "tbody", "tfoot", "thead")) {
                        aj2Var.n();
                        aj2Var.L(gVarE);
                        aj2Var.C0(bj2.InTableBody);
                    } else {
                        if (jl5.b(strC2, TdFileUtils.PLUGIN_FILE, "th", "tr")) {
                            aj2Var.g("tbody");
                            return aj2Var.e(vy5Var);
                        }
                        if (strC2.equals("table")) {
                            aj2Var.p(this);
                            if (aj2Var.f("table")) {
                                return aj2Var.e(vy5Var);
                            }
                        } else {
                            if (jl5.b(strC2, "style", "script")) {
                                return aj2Var.n0(vy5Var, bj2.InHead);
                            }
                            if (strC2.equals("input")) {
                                if (!gVarE.j.e("type").equalsIgnoreCase("hidden")) {
                                    return anythingElse(vy5Var, aj2Var);
                                }
                                aj2Var.P(gVarE);
                            } else {
                                if (!strC2.equals("form")) {
                                    return anythingElse(vy5Var, aj2Var);
                                }
                                aj2Var.p(this);
                                if (aj2Var.x() != null) {
                                    return false;
                                }
                                aj2Var.Q(gVarE, false);
                            }
                        }
                    }
                }
                return true;
            }
        };
        InTable = bj2Var8;
        bj2 bj2Var9 = new bj2("InTableText", 9) { // from class: bj2.a
            {
                k kVar2 = null;
            }

            @Override // defpackage.bj2
            public boolean process(vy5 vy5Var, aj2 aj2Var) {
                if (p.f1733a[vy5Var.f21560a.ordinal()] == 5) {
                    vy5.b bVarA = vy5Var.a();
                    if (bVarA.p().equals(bj2.nullString)) {
                        aj2Var.p(this);
                        return false;
                    }
                    aj2Var.A().add(bVarA.p());
                    return true;
                }
                if (aj2Var.A().size() > 0) {
                    for (String str : aj2Var.A()) {
                        if (bj2.isWhitespace(str)) {
                            aj2Var.M(new vy5.b().o(str));
                        } else {
                            aj2Var.p(this);
                            if (jl5.b(aj2Var.a().x(), "table", "tbody", "tfoot", "thead", "tr")) {
                                aj2Var.z0(true);
                                aj2Var.n0(new vy5.b().o(str), bj2.InBody);
                                aj2Var.z0(false);
                            } else {
                                aj2Var.n0(new vy5.b().o(str), bj2.InBody);
                            }
                        }
                    }
                    aj2Var.f0();
                }
                aj2Var.C0(aj2Var.h0());
                return aj2Var.e(vy5Var);
            }
        };
        InTableText = bj2Var9;
        bj2 bj2Var10 = new bj2("InCaption", 10) { // from class: bj2.b
            {
                k kVar2 = null;
            }

            @Override // defpackage.bj2
            public boolean process(vy5 vy5Var, aj2 aj2Var) {
                if (vy5Var.j() && vy5Var.d().C().equals("caption")) {
                    if (!aj2Var.K(vy5Var.d().C())) {
                        aj2Var.p(this);
                        return false;
                    }
                    aj2Var.s();
                    if (!aj2Var.a().x().equals("caption")) {
                        aj2Var.p(this);
                    }
                    aj2Var.l0("caption");
                    aj2Var.k();
                    aj2Var.C0(bj2.InTable);
                    return true;
                }
                if ((vy5Var.k() && jl5.b(vy5Var.e().C(), "caption", "col", "colgroup", "tbody", TdFileUtils.PLUGIN_FILE, "tfoot", "th", "thead", "tr")) || (vy5Var.j() && vy5Var.d().C().equals("table"))) {
                    aj2Var.p(this);
                    if (aj2Var.f("caption")) {
                        return aj2Var.e(vy5Var);
                    }
                    return true;
                }
                if (!vy5Var.j() || !jl5.b(vy5Var.d().C(), "body", "col", "colgroup", "html", "tbody", TdFileUtils.PLUGIN_FILE, "tfoot", "th", "thead", "tr")) {
                    return aj2Var.n0(vy5Var, bj2.InBody);
                }
                aj2Var.p(this);
                return false;
            }
        };
        InCaption = bj2Var10;
        bj2 bj2Var11 = new bj2("InColumnGroup", 11) { // from class: bj2.c
            {
                k kVar2 = null;
            }

            private boolean anythingElse(vy5 vy5Var, n16 n16Var) {
                if (n16Var.f("colgroup")) {
                    return n16Var.e(vy5Var);
                }
                return true;
            }

            @Override // defpackage.bj2
            public boolean process(vy5 vy5Var, aj2 aj2Var) {
                if (bj2.isWhitespace(vy5Var)) {
                    aj2Var.M(vy5Var.a());
                    return true;
                }
                int i2 = p.f1733a[vy5Var.f21560a.ordinal()];
                if (i2 == 1) {
                    aj2Var.N(vy5Var.b());
                } else if (i2 == 2) {
                    aj2Var.p(this);
                } else if (i2 == 3) {
                    vy5.g gVarE = vy5Var.e();
                    String strC = gVarE.C();
                    if (strC.equals("html")) {
                        return aj2Var.n0(vy5Var, bj2.InBody);
                    }
                    if (!strC.equals("col")) {
                        return anythingElse(vy5Var, aj2Var);
                    }
                    aj2Var.P(gVarE);
                } else {
                    if (i2 != 4) {
                        if (i2 != 6) {
                            return anythingElse(vy5Var, aj2Var);
                        }
                        if (aj2Var.a().x().equals("html")) {
                            return true;
                        }
                        return anythingElse(vy5Var, aj2Var);
                    }
                    if (!vy5Var.d().C().equals("colgroup")) {
                        return anythingElse(vy5Var, aj2Var);
                    }
                    if (aj2Var.a().x().equals("html")) {
                        aj2Var.p(this);
                        return false;
                    }
                    aj2Var.j0();
                    aj2Var.C0(bj2.InTable);
                }
                return true;
            }
        };
        InColumnGroup = bj2Var11;
        bj2 bj2Var12 = new bj2("InTableBody", 12) { // from class: bj2.d
            {
                k kVar2 = null;
            }

            private boolean anythingElse(vy5 vy5Var, aj2 aj2Var) {
                return aj2Var.n0(vy5Var, bj2.InTable);
            }

            private boolean exitTableBody(vy5 vy5Var, aj2 aj2Var) {
                if (!aj2Var.K("tbody") && !aj2Var.K("thead") && !aj2Var.E("tfoot")) {
                    aj2Var.p(this);
                    return false;
                }
                aj2Var.m();
                aj2Var.f(aj2Var.a().x());
                return aj2Var.e(vy5Var);
            }

            @Override // defpackage.bj2
            public boolean process(vy5 vy5Var, aj2 aj2Var) {
                int i2 = p.f1733a[vy5Var.f21560a.ordinal()];
                if (i2 == 3) {
                    vy5.g gVarE = vy5Var.e();
                    String strC = gVarE.C();
                    if (strC.equals("tr")) {
                        aj2Var.m();
                        aj2Var.L(gVarE);
                        aj2Var.C0(bj2.InRow);
                        return true;
                    }
                    if (!jl5.b(strC, "th", TdFileUtils.PLUGIN_FILE)) {
                        return jl5.b(strC, "caption", "col", "colgroup", "tbody", "tfoot", "thead") ? exitTableBody(vy5Var, aj2Var) : anythingElse(vy5Var, aj2Var);
                    }
                    aj2Var.p(this);
                    aj2Var.g("tr");
                    return aj2Var.e(gVarE);
                }
                if (i2 != 4) {
                    return anythingElse(vy5Var, aj2Var);
                }
                String strC2 = vy5Var.d().C();
                if (!jl5.b(strC2, "tbody", "tfoot", "thead")) {
                    if (strC2.equals("table")) {
                        return exitTableBody(vy5Var, aj2Var);
                    }
                    if (!jl5.b(strC2, "body", "caption", "col", "colgroup", "html", TdFileUtils.PLUGIN_FILE, "th", "tr")) {
                        return anythingElse(vy5Var, aj2Var);
                    }
                    aj2Var.p(this);
                    return false;
                }
                if (!aj2Var.K(strC2)) {
                    aj2Var.p(this);
                    return false;
                }
                aj2Var.m();
                aj2Var.j0();
                aj2Var.C0(bj2.InTable);
                return true;
            }
        };
        InTableBody = bj2Var12;
        bj2 bj2Var13 = new bj2("InRow", 13) { // from class: bj2.e
            {
                k kVar2 = null;
            }

            private boolean anythingElse(vy5 vy5Var, aj2 aj2Var) {
                return aj2Var.n0(vy5Var, bj2.InTable);
            }

            private boolean handleMissingTr(vy5 vy5Var, n16 n16Var) {
                if (n16Var.f("tr")) {
                    return n16Var.e(vy5Var);
                }
                return false;
            }

            @Override // defpackage.bj2
            public boolean process(vy5 vy5Var, aj2 aj2Var) {
                if (vy5Var.k()) {
                    vy5.g gVarE = vy5Var.e();
                    String strC = gVarE.C();
                    if (!jl5.b(strC, "th", TdFileUtils.PLUGIN_FILE)) {
                        return jl5.b(strC, "caption", "col", "colgroup", "tbody", "tfoot", "thead", "tr") ? handleMissingTr(vy5Var, aj2Var) : anythingElse(vy5Var, aj2Var);
                    }
                    aj2Var.o();
                    aj2Var.L(gVarE);
                    aj2Var.C0(bj2.InCell);
                    aj2Var.S();
                    return true;
                }
                if (!vy5Var.j()) {
                    return anythingElse(vy5Var, aj2Var);
                }
                String strC2 = vy5Var.d().C();
                if (strC2.equals("tr")) {
                    if (!aj2Var.K(strC2)) {
                        aj2Var.p(this);
                        return false;
                    }
                    aj2Var.o();
                    aj2Var.j0();
                    aj2Var.C0(bj2.InTableBody);
                    return true;
                }
                if (strC2.equals("table")) {
                    return handleMissingTr(vy5Var, aj2Var);
                }
                if (!jl5.b(strC2, "tbody", "tfoot", "thead")) {
                    if (!jl5.b(strC2, "body", "caption", "col", "colgroup", "html", TdFileUtils.PLUGIN_FILE, "th")) {
                        return anythingElse(vy5Var, aj2Var);
                    }
                    aj2Var.p(this);
                    return false;
                }
                if (aj2Var.K(strC2)) {
                    aj2Var.f("tr");
                    return aj2Var.e(vy5Var);
                }
                aj2Var.p(this);
                return false;
            }
        };
        InRow = bj2Var13;
        bj2 bj2Var14 = new bj2("InCell", 14) { // from class: bj2.f
            {
                k kVar2 = null;
            }

            private boolean anythingElse(vy5 vy5Var, aj2 aj2Var) {
                return aj2Var.n0(vy5Var, bj2.InBody);
            }

            private void closeCell(aj2 aj2Var) {
                if (aj2Var.K(TdFileUtils.PLUGIN_FILE)) {
                    aj2Var.f(TdFileUtils.PLUGIN_FILE);
                } else {
                    aj2Var.f("th");
                }
            }

            @Override // defpackage.bj2
            public boolean process(vy5 vy5Var, aj2 aj2Var) {
                if (!vy5Var.j()) {
                    if (!vy5Var.k() || !jl5.b(vy5Var.e().C(), "caption", "col", "colgroup", "tbody", TdFileUtils.PLUGIN_FILE, "tfoot", "th", "thead", "tr")) {
                        return anythingElse(vy5Var, aj2Var);
                    }
                    if (aj2Var.K(TdFileUtils.PLUGIN_FILE) || aj2Var.K("th")) {
                        closeCell(aj2Var);
                        return aj2Var.e(vy5Var);
                    }
                    aj2Var.p(this);
                    return false;
                }
                String strC = vy5Var.d().C();
                if (!jl5.b(strC, TdFileUtils.PLUGIN_FILE, "th")) {
                    if (jl5.b(strC, "body", "caption", "col", "colgroup", "html")) {
                        aj2Var.p(this);
                        return false;
                    }
                    if (!jl5.b(strC, "table", "tbody", "tfoot", "thead", "tr")) {
                        return anythingElse(vy5Var, aj2Var);
                    }
                    if (aj2Var.K(strC)) {
                        closeCell(aj2Var);
                        return aj2Var.e(vy5Var);
                    }
                    aj2Var.p(this);
                    return false;
                }
                if (!aj2Var.K(strC)) {
                    aj2Var.p(this);
                    aj2Var.C0(bj2.InRow);
                    return false;
                }
                aj2Var.s();
                if (!aj2Var.a().x().equals(strC)) {
                    aj2Var.p(this);
                }
                aj2Var.l0(strC);
                aj2Var.k();
                aj2Var.C0(bj2.InRow);
                return true;
            }
        };
        InCell = bj2Var14;
        bj2 bj2Var15 = new bj2("InSelect", 15) { // from class: bj2.g
            {
                k kVar2 = null;
            }

            private boolean anythingElse(vy5 vy5Var, aj2 aj2Var) {
                aj2Var.p(this);
                return false;
            }

            @Override // defpackage.bj2
            public boolean process(vy5 vy5Var, aj2 aj2Var) {
                switch (p.f1733a[vy5Var.f21560a.ordinal()]) {
                    case 1:
                        aj2Var.N(vy5Var.b());
                        return true;
                    case 2:
                        aj2Var.p(this);
                        return false;
                    case 3:
                        vy5.g gVarE = vy5Var.e();
                        String strC = gVarE.C();
                        if (strC.equals("html")) {
                            return aj2Var.n0(gVarE, bj2.InBody);
                        }
                        if (strC.equals("option")) {
                            aj2Var.f("option");
                            aj2Var.L(gVarE);
                            return true;
                        }
                        if (strC.equals("optgroup")) {
                            if (aj2Var.a().x().equals("option")) {
                                aj2Var.f("option");
                            } else if (aj2Var.a().x().equals("optgroup")) {
                                aj2Var.f("optgroup");
                            }
                            aj2Var.L(gVarE);
                            return true;
                        }
                        if (strC.equals("select")) {
                            aj2Var.p(this);
                            return aj2Var.f("select");
                        }
                        if (!jl5.b(strC, "input", "keygen", "textarea")) {
                            return strC.equals("script") ? aj2Var.n0(vy5Var, bj2.InHead) : anythingElse(vy5Var, aj2Var);
                        }
                        aj2Var.p(this);
                        if (!aj2Var.H("select")) {
                            return false;
                        }
                        aj2Var.f("select");
                        return aj2Var.e(gVarE);
                    case 4:
                        String strC2 = vy5Var.d().C();
                        if (strC2.equals("optgroup")) {
                            if (aj2Var.a().x().equals("option") && aj2Var.j(aj2Var.a()) != null && aj2Var.j(aj2Var.a()).x().equals("optgroup")) {
                                aj2Var.f("option");
                            }
                            if (aj2Var.a().x().equals("optgroup")) {
                                aj2Var.j0();
                                return true;
                            }
                            aj2Var.p(this);
                            return true;
                        }
                        if (strC2.equals("option")) {
                            if (aj2Var.a().x().equals("option")) {
                                aj2Var.j0();
                                return true;
                            }
                            aj2Var.p(this);
                            return true;
                        }
                        if (!strC2.equals("select")) {
                            return anythingElse(vy5Var, aj2Var);
                        }
                        if (!aj2Var.H(strC2)) {
                            aj2Var.p(this);
                            return false;
                        }
                        aj2Var.l0(strC2);
                        aj2Var.x0();
                        return true;
                    case 5:
                        vy5.b bVarA = vy5Var.a();
                        if (bVarA.p().equals(bj2.nullString)) {
                            aj2Var.p(this);
                            return false;
                        }
                        aj2Var.M(bVarA);
                        return true;
                    case 6:
                        if (aj2Var.a().x().equals("html")) {
                            return true;
                        }
                        aj2Var.p(this);
                        return true;
                    default:
                        return anythingElse(vy5Var, aj2Var);
                }
            }
        };
        InSelect = bj2Var15;
        bj2 bj2Var16 = new bj2("InSelectInTable", 16) { // from class: bj2.h
            {
                k kVar2 = null;
            }

            @Override // defpackage.bj2
            public boolean process(vy5 vy5Var, aj2 aj2Var) {
                if (vy5Var.k() && jl5.b(vy5Var.e().C(), "caption", "table", "tbody", "tfoot", "thead", "tr", TdFileUtils.PLUGIN_FILE, "th")) {
                    aj2Var.p(this);
                    aj2Var.f("select");
                    return aj2Var.e(vy5Var);
                }
                if (!vy5Var.j() || !jl5.b(vy5Var.d().C(), "caption", "table", "tbody", "tfoot", "thead", "tr", TdFileUtils.PLUGIN_FILE, "th")) {
                    return aj2Var.n0(vy5Var, bj2.InSelect);
                }
                aj2Var.p(this);
                if (!aj2Var.K(vy5Var.d().C())) {
                    return false;
                }
                aj2Var.f("select");
                return aj2Var.e(vy5Var);
            }
        };
        InSelectInTable = bj2Var16;
        bj2 bj2Var17 = new bj2("AfterBody", 17) { // from class: bj2.i
            {
                k kVar2 = null;
            }

            @Override // defpackage.bj2
            public boolean process(vy5 vy5Var, aj2 aj2Var) {
                if (bj2.isWhitespace(vy5Var)) {
                    return aj2Var.n0(vy5Var, bj2.InBody);
                }
                if (vy5Var.g()) {
                    aj2Var.N(vy5Var.b());
                    return true;
                }
                if (vy5Var.h()) {
                    aj2Var.p(this);
                    return false;
                }
                if (vy5Var.k() && vy5Var.e().C().equals("html")) {
                    return aj2Var.n0(vy5Var, bj2.InBody);
                }
                if (vy5Var.j() && vy5Var.d().C().equals("html")) {
                    if (aj2Var.Y()) {
                        aj2Var.p(this);
                        return false;
                    }
                    aj2Var.C0(bj2.AfterAfterBody);
                    return true;
                }
                if (vy5Var.i()) {
                    return true;
                }
                aj2Var.p(this);
                aj2Var.C0(bj2.InBody);
                return aj2Var.e(vy5Var);
            }
        };
        AfterBody = bj2Var17;
        bj2 bj2Var18 = new bj2("InFrameset", 18) { // from class: bj2.j
            {
                k kVar2 = null;
            }

            @Override // defpackage.bj2
            public boolean process(vy5 vy5Var, aj2 aj2Var) {
                if (bj2.isWhitespace(vy5Var)) {
                    aj2Var.M(vy5Var.a());
                } else if (vy5Var.g()) {
                    aj2Var.N(vy5Var.b());
                } else {
                    if (vy5Var.h()) {
                        aj2Var.p(this);
                        return false;
                    }
                    if (vy5Var.k()) {
                        vy5.g gVarE = vy5Var.e();
                        String strC = gVarE.C();
                        if (strC.equals("html")) {
                            return aj2Var.n0(gVarE, bj2.InBody);
                        }
                        if (strC.equals("frameset")) {
                            aj2Var.L(gVarE);
                        } else {
                            if (!strC.equals("frame")) {
                                if (strC.equals("noframes")) {
                                    return aj2Var.n0(gVarE, bj2.InHead);
                                }
                                aj2Var.p(this);
                                return false;
                            }
                            aj2Var.P(gVarE);
                        }
                    } else if (vy5Var.j() && vy5Var.d().C().equals("frameset")) {
                        if (aj2Var.a().x().equals("html")) {
                            aj2Var.p(this);
                            return false;
                        }
                        aj2Var.j0();
                        if (!aj2Var.Y() && !aj2Var.a().x().equals("frameset")) {
                            aj2Var.C0(bj2.AfterFrameset);
                        }
                    } else {
                        if (!vy5Var.i()) {
                            aj2Var.p(this);
                            return false;
                        }
                        if (!aj2Var.a().x().equals("html")) {
                            aj2Var.p(this);
                        }
                    }
                }
                return true;
            }
        };
        InFrameset = bj2Var18;
        bj2 bj2Var19 = new bj2("AfterFrameset", 19) { // from class: bj2.l
            {
                k kVar2 = null;
            }

            @Override // defpackage.bj2
            public boolean process(vy5 vy5Var, aj2 aj2Var) {
                if (bj2.isWhitespace(vy5Var)) {
                    aj2Var.M(vy5Var.a());
                    return true;
                }
                if (vy5Var.g()) {
                    aj2Var.N(vy5Var.b());
                    return true;
                }
                if (vy5Var.h()) {
                    aj2Var.p(this);
                    return false;
                }
                if (vy5Var.k() && vy5Var.e().C().equals("html")) {
                    return aj2Var.n0(vy5Var, bj2.InBody);
                }
                if (vy5Var.j() && vy5Var.d().C().equals("html")) {
                    aj2Var.C0(bj2.AfterAfterFrameset);
                    return true;
                }
                if (vy5Var.k() && vy5Var.e().C().equals("noframes")) {
                    return aj2Var.n0(vy5Var, bj2.InHead);
                }
                if (vy5Var.i()) {
                    return true;
                }
                aj2Var.p(this);
                return false;
            }
        };
        AfterFrameset = bj2Var19;
        bj2 bj2Var20 = new bj2("AfterAfterBody", 20) { // from class: bj2.m
            {
                k kVar2 = null;
            }

            @Override // defpackage.bj2
            public boolean process(vy5 vy5Var, aj2 aj2Var) {
                if (vy5Var.g()) {
                    aj2Var.N(vy5Var.b());
                    return true;
                }
                if (vy5Var.h() || bj2.isWhitespace(vy5Var) || (vy5Var.k() && vy5Var.e().C().equals("html"))) {
                    return aj2Var.n0(vy5Var, bj2.InBody);
                }
                if (vy5Var.i()) {
                    return true;
                }
                aj2Var.p(this);
                aj2Var.C0(bj2.InBody);
                return aj2Var.e(vy5Var);
            }
        };
        AfterAfterBody = bj2Var20;
        bj2 bj2Var21 = new bj2("AfterAfterFrameset", 21) { // from class: bj2.n
            {
                k kVar2 = null;
            }

            @Override // defpackage.bj2
            public boolean process(vy5 vy5Var, aj2 aj2Var) {
                if (vy5Var.g()) {
                    aj2Var.N(vy5Var.b());
                    return true;
                }
                if (vy5Var.h() || bj2.isWhitespace(vy5Var) || (vy5Var.k() && vy5Var.e().C().equals("html"))) {
                    return aj2Var.n0(vy5Var, bj2.InBody);
                }
                if (vy5Var.i()) {
                    return true;
                }
                if (vy5Var.k() && vy5Var.e().C().equals("noframes")) {
                    return aj2Var.n0(vy5Var, bj2.InHead);
                }
                aj2Var.p(this);
                return false;
            }
        };
        AfterAfterFrameset = bj2Var21;
        bj2 bj2Var22 = new bj2("ForeignContent", 22) { // from class: bj2.o
            {
                k kVar2 = null;
            }

            @Override // defpackage.bj2
            public boolean process(vy5 vy5Var, aj2 aj2Var) {
                return true;
            }
        };
        ForeignContent = bj2Var22;
        $VALUES = new bj2[]{kVar, bj2Var, bj2Var2, bj2Var3, bj2Var4, bj2Var5, bj2Var6, bj2Var7, bj2Var8, bj2Var9, bj2Var10, bj2Var11, bj2Var12, bj2Var13, bj2Var14, bj2Var15, bj2Var16, bj2Var17, bj2Var18, bj2Var19, bj2Var20, bj2Var21, bj2Var22};
        nullString = String.valueOf((char) 0);
    }

    private bj2(String str, int i2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleRawtext(vy5.g gVar, aj2 aj2Var) {
        aj2Var.L(gVar);
        aj2Var.b.v(zy5.Rawtext);
        aj2Var.d0();
        aj2Var.C0(Text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleRcData(vy5.g gVar, aj2 aj2Var) {
        aj2Var.L(gVar);
        aj2Var.b.v(zy5.Rcdata);
        aj2Var.d0();
        aj2Var.C0(Text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isWhitespace(vy5 vy5Var) {
        if (vy5Var.f()) {
            return isWhitespace(vy5Var.a().p());
        }
        return false;
    }

    public static bj2 valueOf(String str) {
        return (bj2) Enum.valueOf(bj2.class, str);
    }

    public static bj2[] values() {
        return (bj2[]) $VALUES.clone();
    }

    public abstract boolean process(vy5 vy5Var, aj2 aj2Var);

    public /* synthetic */ bj2(String str, int i2, k kVar) {
        this(str, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isWhitespace(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (!jl5.f(str.charAt(i2))) {
                return false;
            }
        }
        return true;
    }
}
