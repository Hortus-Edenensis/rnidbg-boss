package defpackage;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.annotation.ColorInt;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.framework.R$color;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class wn6 extends JSONObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @ColorInt
    public int f21761a;

    public wn6(String str) throws JSONException {
        super(str);
        this.f21761a = c.b().getResources().getColor(R$color.color_lollipop_status_bar);
    }

    public static wn6 g(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new wn6(str);
            } catch (JSONException e) {
                ma3.d("style is not valid json string use default style");
                ma3.c(e);
            }
        }
        return new wn6();
    }

    public String a() {
        return optString("colorStyle", "#ffffff");
    }

    public int b() {
        try {
            return Color.parseColor(optString("windowColor"));
        } catch (Exception e) {
            ma3.d("windowColor is invalid color format");
            ma3.c(e);
            return this.f21761a;
        }
    }

    public String c() {
        return optString("windowStyle", "statusbar");
    }

    public boolean d() {
        return optBoolean("keepScreenOn", false);
    }

    public boolean e() {
        return optBoolean("isLandscape", false);
    }

    public boolean f() {
        return optBoolean("showFloatMenu", true);
    }

    public boolean h() {
        return optBoolean("showFloatIcon", false);
    }

    public wn6() {
        this.f21761a = c.b().getResources().getColor(R$color.color_lollipop_status_bar);
    }
}
