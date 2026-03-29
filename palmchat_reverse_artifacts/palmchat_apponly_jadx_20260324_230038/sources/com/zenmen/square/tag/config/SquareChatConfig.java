package com.zenmen.square.tag.config;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.zenmen.palmchat.framework.R$string;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Keep
public class SquareChatConfig {
    public String squareName;
    public String userHomeName;

    public String getSquareChatText(Context context) {
        if (TextUtils.isEmpty(this.squareName)) {
            this.squareName = context.getString(R$string.square_default_chat_text);
        }
        return this.squareName;
    }

    public String getUserHomeChatText(Context context) {
        if (TextUtils.isEmpty(this.userHomeName)) {
            this.userHomeName = context.getString(R$string.square_default_chat_user);
        }
        return this.userHomeName;
    }
}
