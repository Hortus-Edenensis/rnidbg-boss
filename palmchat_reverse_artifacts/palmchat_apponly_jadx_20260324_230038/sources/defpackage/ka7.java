package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import androidx.annotation.NonNull;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ka7 implements k47 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f18611a = new String(Base64.decode("Y29tLm5lYXJtZS5zdGF0aXN0aWNzLnJvbQ==", 0), StandardCharsets.UTF_8);
    public static final String b = new String(Base64.decode("Y29tLm5lYXJtZS5zdGF0aXN0aWNzLnJvbS5zZXJ2aWNlLlJlY2VpdmVyU2VydmljZQ==", 0), StandardCharsets.UTF_8);

    public static /* synthetic */ String e(Context context) {
        return "add Task failed: bean or context is null. context=" + context;
    }

    public static /* synthetic */ String f(Exception exc) {
        return "startService exception=" + exc;
    }

    @Override // defpackage.k47
    public void a(@NonNull final Context context, @NonNull u17 u17Var) {
        if (u17Var == null || context == null) {
            n87.e("ServiceRecorder", new la7() { // from class: r97
                @Override // defpackage.la7
                public final Object get() {
                    return ka7.e(context);
                }
            });
            return;
        }
        try {
            context.startService(d(u17Var));
        } catch (Exception e) {
            n87.c("ServiceRecorder", new la7() { // from class: s97
                @Override // defpackage.la7
                public final Object get() {
                    return ka7.f(e);
                }
            });
        }
    }

    public final Intent d(u17 u17Var) {
        Serializable serializable;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(f18611a, b));
        for (Map.Entry<String, Object> entry : u17Var.h().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                intent.putExtra(key, (String) value);
            } else {
                if (value instanceof Integer) {
                    serializable = (Integer) value;
                } else if (value instanceof Long) {
                    serializable = (Long) value;
                } else if (value instanceof Boolean) {
                    serializable = (Boolean) value;
                }
                intent.putExtra(key, serializable);
            }
        }
        return intent;
    }
}
