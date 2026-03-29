package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.Vo.MessageVo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class v06 {
    public static int a(MessageVo messageVo) {
        String str = messageVo.data1;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return Integer.parseInt(str);
    }
}
