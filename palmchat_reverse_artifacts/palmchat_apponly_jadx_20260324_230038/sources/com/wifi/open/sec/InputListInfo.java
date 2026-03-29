package com.wifi.open.sec;

import android.app.Application;
import android.content.Context;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.zenmen.palmchat.c;
import java.util.Iterator;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public final class InputListInfo {
    private static String method_350(Context context) {
        try {
            JSONArray jSONArray = new JSONArray();
            try {
                Iterator<InputMethodInfo> it = ((InputMethodManager) context.getSystemService("input_method")).getInputMethodList().iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().loadLabel(context.getPackageManager()));
                }
            } catch (Throwable unused) {
            }
            return jSONArray.toString();
        } catch (Throwable unused2) {
            return "-998";
        }
    }

    public final String getTag() {
        return "in";
    }

    public final String oni() {
        Application applicationB = c.b();
        if (applicationB == null) {
            return null;
        }
        return method_350(applicationB);
    }
}
