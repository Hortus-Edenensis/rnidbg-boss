package com.zenmen.palmchat.refund;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class RefundData {
    public static final int STATUS_EFFECT_DONE = 2;
    public static final int STATUS_IN_EFFECT = 1;
    public static final int STATUS_TIME_OUT = 7;
    public static final int STATUS_TO_BE_USED = 0;
    public static final String TAG_CLOCK = "expires";
    public static final String TAG_TEXT = "text";
    public static final String TAG_TYPE = "status";
    public int bizType;
    public int id;
    public int status = 1;
    public int expires = 10000;
    public String text = "";
    public boolean play = false;
    public boolean showEnevlop = true;
    public int type = 0;

    @NonNull
    public String toString() {
        return " status " + this.status + " expires " + this.expires + " text " + this.text + " play " + this.play + " showEnevlop " + this.showEnevlop;
    }
}
