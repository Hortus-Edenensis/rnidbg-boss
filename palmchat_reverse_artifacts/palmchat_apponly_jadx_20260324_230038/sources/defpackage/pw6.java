package defpackage;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class pw6 extends u17 {
    public String g;
    public String h;
    public String i;
    public int j;

    public pw6(@NonNull Context context) {
        super(context);
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = 0;
    }

    public String b() {
        return this.i;
    }

    @Override // defpackage.u17
    public int g() {
        return 1006;
    }

    public void k(String str) {
        this.i = str;
        e("eventID", str);
    }

    public void l(Map<String, String> map) {
        String string = l47.a(map).toString();
        this.g = string;
        e("logMap", string);
    }

    public String m() {
        return this.h;
    }

    public void n(String str) {
        this.h = str;
        e("logTag", str);
    }

    public String o() {
        return this.g;
    }

    public int p() {
        return this.j;
    }

    public String toString() {
        return " type is :" + g() + ", tag is :" + m() + ", eventID is :" + b() + ", map is :" + o();
    }

    public pw6(@NonNull Context context, String str, String str2, String str3) {
        super(context);
        this.g = "";
        this.j = 0;
        this.h = str2;
        this.i = str3;
        f(str);
        e("logTag", this.h);
        e("eventID", this.i);
    }
}
