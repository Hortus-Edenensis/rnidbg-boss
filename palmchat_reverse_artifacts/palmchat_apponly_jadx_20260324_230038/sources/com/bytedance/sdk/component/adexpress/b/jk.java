package com.bytedance.sdk.component.adexpress.b;

import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class jk {

    /* JADX INFO: compiled from: SearchBox */
    public enum u {
        HTML("text/html"),
        CSS("text/css"),
        JS("application/x-javascript"),
        IMAGE("image/*");

        private String pn;

        u(String str) {
            this.pn = str;
        }

        public String getType() {
            return this.pn;
        }
    }

    public static boolean nr(String str) {
        Uri uri;
        if (TextUtils.isEmpty(str) || (uri = Uri.parse(str)) == null) {
            return false;
        }
        String path = uri.getPath();
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        return path.endsWith(".gif");
    }

    public static u u(String str) {
        u uVar = u.IMAGE;
        if (!TextUtils.isEmpty(str)) {
            try {
                String path = Uri.parse(str).getPath();
                if (path != null) {
                    if (path.endsWith(".css")) {
                        uVar = u.CSS;
                    } else if (path.endsWith(".js")) {
                        uVar = u.JS;
                    } else if (!path.endsWith(".jpg") && !path.endsWith(".gif") && !path.endsWith(".png") && !path.endsWith(".jpeg") && !path.endsWith(".webp") && !path.endsWith(".bmp") && !path.endsWith(".ico") && path.endsWith(".html")) {
                        uVar = u.HTML;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return uVar;
    }
}
