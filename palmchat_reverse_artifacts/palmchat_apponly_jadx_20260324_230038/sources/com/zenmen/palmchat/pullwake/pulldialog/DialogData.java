package com.zenmen.palmchat.pullwake.pulldialog;

import androidx.annotation.Keep;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class DialogData {
    public List<DialogItemData> list;

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class DialogItemData implements Serializable {
        public String btnName;
        public String icon;
        public String nickName;
        public String title;
        public String turnUrl;
    }
}
