package com.zenmen.palmchat.circle.bean;

import android.content.Context;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.R;
import defpackage.sd3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleDialogFactory {
    public static MaterialDialog buildDialogByContent(Context context, String str) {
        return new sd3(context).k(str).m(R.color.materia_content_text_color).O(R.string.circle_ok).e();
    }

    public static MaterialDialog buildDialogByContent(Context context, String str, MaterialDialog.e eVar) {
        return new sd3(context).k(str).f(eVar).m(R.color.materia_content_text_color).O(R.string.circle_ok).e();
    }
}
