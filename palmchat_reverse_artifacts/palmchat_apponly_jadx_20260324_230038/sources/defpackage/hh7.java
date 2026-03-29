package defpackage;

import com.igexin.push.core.b;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class hh7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Writer f17969a;
    public final List<a> b = new ArrayList();

    /* JADX INFO: compiled from: SearchBox */
    public enum a {
        EMPTY_ARRAY,
        NONEMPTY_ARRAY,
        EMPTY_OBJECT,
        DANGLING_KEY,
        NONEMPTY_OBJECT,
        NULL
    }

    public hh7(Writer writer) {
        this.f17969a = writer;
    }

    public static void h(JSONArray jSONArray, Writer writer) throws JSONException, IOException {
        new hh7(writer).g(jSONArray);
        writer.flush();
    }

    public static void j(JSONObject jSONObject, Writer writer) throws JSONException, IOException {
        new hh7(writer).i(jSONObject);
        writer.flush();
    }

    public hh7 a() {
        return d(a.EMPTY_ARRAY, "[");
    }

    public hh7 b(Object obj) throws JSONException, IOException {
        Writer writer;
        String strNumberToString;
        if (obj instanceof JSONArray) {
            g((JSONArray) obj);
            return this;
        }
        if (obj instanceof JSONObject) {
            i((JSONObject) obj);
            return this;
        }
        q();
        if (obj == null || obj == JSONObject.NULL) {
            this.f17969a.write(b.m);
        } else {
            if (obj instanceof Boolean) {
                writer = this.f17969a;
                strNumberToString = String.valueOf(obj);
            } else if (obj instanceof Number) {
                writer = this.f17969a;
                strNumberToString = JSONObject.numberToString((Number) obj);
            } else {
                l(obj.toString());
            }
            writer.write(strNumberToString);
        }
        return this;
    }

    public hh7 c(String str) throws JSONException, IOException {
        p();
        l(str);
        return this;
    }

    public hh7 d(a aVar, String str) throws JSONException, IOException {
        q();
        this.b.add(aVar);
        this.f17969a.write(str);
        return this;
    }

    public hh7 e(a aVar, a aVar2, String str) throws IOException {
        o();
        this.b.remove(r1.size() - 1);
        this.f17969a.write(str);
        return this;
    }

    public final void f(a aVar) {
        this.b.set(r0.size() - 1, aVar);
    }

    public final void g(JSONArray jSONArray) throws JSONException, IOException {
        a();
        for (int i = 0; i < jSONArray.length(); i++) {
            b(jSONArray.get(i));
        }
        k();
    }

    public final void i(JSONObject jSONObject) throws JSONException {
        m();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            c(next).b(jSONObject.get(next));
        }
        n();
    }

    public hh7 k() {
        return e(a.EMPTY_ARRAY, a.NONEMPTY_ARRAY, "]");
    }

    public final void l(String str) throws IOException {
        Writer writer;
        String str2;
        this.f17969a.write("\"");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\f') {
                writer = this.f17969a;
                str2 = "\\f";
            } else if (cCharAt != '\r') {
                if (cCharAt == '\"' || cCharAt == '/' || cCharAt == '\\') {
                    this.f17969a.write(92);
                } else {
                    switch (cCharAt) {
                        case '\b':
                            writer = this.f17969a;
                            str2 = "\\b";
                            break;
                        case '\t':
                            writer = this.f17969a;
                            str2 = "\\t";
                            break;
                        case '\n':
                            writer = this.f17969a;
                            str2 = "\\n";
                            break;
                        default:
                            if (cCharAt <= 31) {
                                this.f17969a.write(String.format("\\u%04x", Integer.valueOf(cCharAt)));
                            }
                            break;
                    }
                }
                this.f17969a.write(cCharAt);
            } else {
                writer = this.f17969a;
                str2 = "\\r";
            }
            writer.write(str2);
        }
        this.f17969a.write("\"");
    }

    public hh7 m() {
        return d(a.EMPTY_OBJECT, "{");
    }

    public hh7 n() {
        return e(a.EMPTY_OBJECT, a.NONEMPTY_OBJECT, "}");
    }

    public final a o() {
        return this.b.get(r0.size() - 1);
    }

    public final void p() throws JSONException, IOException {
        a aVarO = o();
        if (aVarO == a.NONEMPTY_OBJECT) {
            this.f17969a.write(44);
        } else if (aVarO != a.EMPTY_OBJECT) {
            throw new JSONException("Nesting problem");
        }
        f(a.DANGLING_KEY);
    }

    public final void q() throws JSONException, IOException {
        a aVar;
        if (this.b.isEmpty()) {
            return;
        }
        a aVarO = o();
        if (aVarO == a.EMPTY_ARRAY) {
            aVar = a.NONEMPTY_ARRAY;
        } else if (aVarO == a.NONEMPTY_ARRAY) {
            this.f17969a.write(44);
            return;
        } else if (aVarO != a.DANGLING_KEY) {
            if (aVarO != a.NULL) {
                throw new JSONException("Nesting problem");
            }
            return;
        } else {
            this.f17969a.write(":");
            aVar = a.NONEMPTY_OBJECT;
        }
        f(aVar);
    }

    public String toString() {
        return "";
    }
}
