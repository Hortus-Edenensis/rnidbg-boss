package defpackage;

import com.igexin.push.core.b;
import java.util.Iterator;
import kotlin.text.Typography;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public abstract class eq implements ya1 {
    @Override // defpackage.ya1
    public ya1 a(String str) {
        d(str);
        return this;
    }

    @Override // defpackage.ya1
    public ya1 b(Object obj) {
        if (obj == null) {
            d(b.m);
        } else if (obj instanceof String) {
            j((String) obj);
        } else if (obj instanceof Character) {
            c(Typography.quote);
            i(((Character) obj).charValue());
            c(Typography.quote);
        } else if (obj instanceof Short) {
            c(Typography.less);
            d(h(obj));
            d("s>");
        } else if (obj instanceof Long) {
            c(Typography.less);
            d(h(obj));
            d("L>");
        } else if (obj instanceof Float) {
            c(Typography.less);
            d(h(obj));
            d("F>");
        } else if (obj.getClass().isArray()) {
            g("[", ", ", "]", new ph(obj));
        } else {
            c(Typography.less);
            d(h(obj));
            c(Typography.greater);
        }
        return this;
    }

    public abstract void c(char c);

    public abstract void d(String str);

    public ya1 e(f55 f55Var) {
        f55Var.describeTo(this);
        return this;
    }

    public final ya1 f(String str, String str2, String str3, Iterator<? extends f55> it) {
        d(str);
        boolean z = false;
        while (it.hasNext()) {
            if (z) {
                d(str2);
            }
            e(it.next());
            z = true;
        }
        d(str3);
        return this;
    }

    public final <T> ya1 g(String str, String str2, String str3, Iterator<T> it) {
        return f(str, str2, str3, new h55(it));
    }

    public final String h(Object obj) {
        try {
            return String.valueOf(obj);
        } catch (Exception unused) {
            return obj.getClass().getName() + "@" + Integer.toHexString(obj.hashCode());
        }
    }

    public final void i(char c) {
        if (c == '\t') {
            d("\\t");
            return;
        }
        if (c == '\n') {
            d("\\n");
            return;
        }
        if (c == '\r') {
            d("\\r");
        } else if (c != '\"') {
            c(c);
        } else {
            d("\\\"");
        }
    }

    public final void j(String str) {
        c(Typography.quote);
        for (int i = 0; i < str.length(); i++) {
            i(str.charAt(i));
        }
        c(Typography.quote);
    }
}
