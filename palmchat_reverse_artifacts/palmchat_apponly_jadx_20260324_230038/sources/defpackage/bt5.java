package defpackage;

import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.heytap.mcssdk.constant.b;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.openalliance.ad.constant.az;
import com.huawei.openalliance.ad.constant.bh;
import com.kuaishou.weapon.p0.t;
import com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever;
import com.ss.android.download.api.constant.BaseConstants;
import com.tide.protocol.util.TdFileUtils;
import com.wifi.ad.core.config.EventParams;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class bt5 {
    public static final Map<String, bt5> k = new HashMap();
    public static final String[] l;
    public static final String[] m;
    public static final String[] n;
    public static final String[] o;
    public static final String[] p;
    public static final String[] q;
    public static final String[] r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1817a;
    public boolean b = true;
    public boolean c = true;
    public boolean d = true;
    public boolean e = true;
    public boolean f = false;
    public boolean g = false;
    public boolean h = false;
    public boolean i = false;
    public boolean j = false;

    static {
        String[] strArr = {"html", "head", "body", "frameset", "script", "noscript", "style", "meta", "link", "title", "frame", "noframes", "section", "nav", "aside", "hgroup", "header", "footer", "p", "h1", "h2", "h3", "h4", "h5", "h6", "ul", "ol", "pre", "div", "blockquote", "hr", "address", "figure", "figcaption", "form", "fieldset", "ins", "del", "s", CmcdConfiguration.KEY_DEADLINE, "dt", "dd", "li", "table", "caption", "thead", "tfoot", "tbody", "colgroup", "col", "tr", "th", TdFileUtils.PLUGIN_FILE, "video", "audio", "canvas", BaseConstants.MARKET_URI_AUTHORITY_DETAIL, "menu", "plaintext", EventParams.KEY_PARAM_TEMPLATE, "article", "main", "svg", "math"};
        l = strArr;
        m = new String[]{"object", "base", "font", "tt", "i", t.l, "u", "big", "small", "em", "strong", "dfn", "code", "samp", "kbd", "var", "cite", "abbr", "time", "acronym", "mark", "ruby", "rt", "rp", "a", bh.Code, "br", "wbr", "map", "q", "sub", "sup", "bdo", "iframe", "embed", "span", "input", "select", "textarea", "label", "button", "optgroup", "option", "legend", "datalist", "keygen", "output", "progress", "meter", "area", RemoteMessageConst.MessageBody.PARAM, az.at, FFmpegMediaMetadataRetriever.METADATA_KEY_TRACK, "summary", b.y, "device", "area", "basefont", "bgsound", "menuitem", RemoteMessageConst.MessageBody.PARAM, az.at, FFmpegMediaMetadataRetriever.METADATA_KEY_TRACK, "data", "bdi"};
        n = new String[]{"meta", "link", "base", "frame", bh.Code, "br", "wbr", "embed", "hr", "input", "keygen", "col", b.y, "device", "area", "basefont", "bgsound", "menuitem", RemoteMessageConst.MessageBody.PARAM, az.at, FFmpegMediaMetadataRetriever.METADATA_KEY_TRACK};
        o = new String[]{"title", "a", "p", "h1", "h2", "h3", "h4", "h5", "h6", "pre", "address", "li", "th", TdFileUtils.PLUGIN_FILE, "script", "style", "ins", "del", "s"};
        p = new String[]{"pre", "plaintext", "title", "textarea"};
        q = new String[]{"button", "fieldset", "input", "keygen", "object", "output", "select", "textarea"};
        r = new String[]{"input", "keygen", "object", "select", "textarea"};
        for (String str : strArr) {
            i(new bt5(str));
        }
        for (String str2 : m) {
            bt5 bt5Var = new bt5(str2);
            bt5Var.b = false;
            bt5Var.d = false;
            bt5Var.c = false;
            i(bt5Var);
        }
        for (String str3 : n) {
            bt5 bt5Var2 = k.get(str3);
            e96.j(bt5Var2);
            bt5Var2.d = false;
            bt5Var2.e = false;
            bt5Var2.f = true;
        }
        for (String str4 : o) {
            bt5 bt5Var3 = k.get(str4);
            e96.j(bt5Var3);
            bt5Var3.c = false;
        }
        for (String str5 : p) {
            bt5 bt5Var4 = k.get(str5);
            e96.j(bt5Var4);
            bt5Var4.h = true;
        }
        for (String str6 : q) {
            bt5 bt5Var5 = k.get(str6);
            e96.j(bt5Var5);
            bt5Var5.i = true;
        }
        for (String str7 : r) {
            bt5 bt5Var6 = k.get(str7);
            e96.j(bt5Var6);
            bt5Var6.j = true;
        }
    }

    public bt5(String str) {
        this.f1817a = str;
    }

    public static void i(bt5 bt5Var) {
        k.put(bt5Var.f1817a, bt5Var);
    }

    public static bt5 k(String str, kc4 kc4Var) {
        e96.j(str);
        Map<String, bt5> map = k;
        bt5 bt5Var = map.get(str);
        if (bt5Var != null) {
            return bt5Var;
        }
        String strB = kc4Var.b(str);
        e96.h(strB);
        bt5 bt5Var2 = map.get(strB);
        if (bt5Var2 != null) {
            return bt5Var2;
        }
        bt5 bt5Var3 = new bt5(strB);
        bt5Var3.b = false;
        bt5Var3.d = true;
        return bt5Var3;
    }

    public boolean a() {
        return this.c;
    }

    public String b() {
        return this.f1817a;
    }

    public boolean c() {
        return this.b;
    }

    public boolean d() {
        return this.f;
    }

    public boolean e() {
        return this.i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bt5)) {
            return false;
        }
        bt5 bt5Var = (bt5) obj;
        return this.f1817a.equals(bt5Var.f1817a) && this.d == bt5Var.d && this.e == bt5Var.e && this.f == bt5Var.f && this.c == bt5Var.c && this.b == bt5Var.b && this.h == bt5Var.h && this.g == bt5Var.g && this.i == bt5Var.i && this.j == bt5Var.j;
    }

    public boolean f() {
        return k.containsKey(this.f1817a);
    }

    public boolean g() {
        return this.f || this.g;
    }

    public boolean h() {
        return this.h;
    }

    public int hashCode() {
        return (((((((((((((((((this.f1817a.hashCode() * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0)) * 31) + (this.d ? 1 : 0)) * 31) + (this.e ? 1 : 0)) * 31) + (this.f ? 1 : 0)) * 31) + (this.g ? 1 : 0)) * 31) + (this.h ? 1 : 0)) * 31) + (this.i ? 1 : 0)) * 31) + (this.j ? 1 : 0);
    }

    public bt5 j() {
        this.g = true;
        return this;
    }

    public String toString() {
        return this.f1817a;
    }
}
