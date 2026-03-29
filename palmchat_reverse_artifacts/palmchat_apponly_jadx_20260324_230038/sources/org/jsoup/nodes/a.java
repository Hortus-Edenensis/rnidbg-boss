package org.jsoup.nodes;

import com.baidu.platform.comapi.map.MapController;
import defpackage.e96;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import kotlin.text.Typography;
import org.jsoup.SerializationException;
import org.jsoup.nodes.Document;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class a implements Map.Entry<String, String>, Cloneable {
    public static final String[] c = {"allowfullscreen", "async", "autofocus", "checked", "compact", "declare", MapController.DEFAULT_LAYER_TAG, "defer", "disabled", "formnovalidate", "hidden", "inert", "ismap", "itemscope", "multiple", "muted", "nohref", "noresize", "noshade", "novalidate", "nowrap", "open", "readonly", "required", "reversed", "seamless", "selected", "sortable", "truespeed", "typemustmatch"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f19829a;
    public String b;

    public a(String str, String str2) {
        e96.h(str);
        e96.j(str2);
        this.f19829a = str.trim();
        this.b = str2;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // java.util.Map.Entry
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public String getKey() {
        return this.f19829a;
    }

    @Override // java.util.Map.Entry
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public String getValue() {
        return this.b;
    }

    public String e() {
        StringBuilder sb = new StringBuilder();
        try {
            f(sb, new Document("").V0());
            return sb.toString();
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        String str = this.f19829a;
        if (str == null ? aVar.f19829a != null : !str.equals(aVar.f19829a)) {
            return false;
        }
        String str2 = this.b;
        String str3 = aVar.b;
        if (str2 != null) {
            if (str2.equals(str3)) {
                return true;
            }
        } else if (str3 == null) {
            return true;
        }
        return false;
    }

    public void f(Appendable appendable, Document.OutputSettings outputSettings) throws IOException {
        appendable.append(this.f19829a);
        if (j(outputSettings)) {
            return;
        }
        appendable.append("=\"");
        Entities.e(appendable, this.b, outputSettings, true, false, false);
        appendable.append(Typography.quote);
    }

    public boolean g() {
        return Arrays.binarySearch(c, this.f19829a) >= 0;
    }

    public void h(String str) {
        e96.h(str);
        this.f19829a = str.trim();
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        String str = this.f19829a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public String setValue(String str) {
        e96.j(str);
        String str2 = this.b;
        this.b = str;
        return str2;
    }

    public final boolean j(Document.OutputSettings outputSettings) {
        return ("".equals(this.b) || this.b.equalsIgnoreCase(this.f19829a)) && outputSettings.i() == Document.OutputSettings.Syntax.html && g();
    }

    public String toString() {
        return e();
    }
}
