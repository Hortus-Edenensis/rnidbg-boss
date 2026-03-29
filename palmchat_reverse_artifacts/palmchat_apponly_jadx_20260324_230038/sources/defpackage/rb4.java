package defpackage;

import com.zenmen.palmchat.Vo.MessageVo;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class rb4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<MessageVo> f20434a;
    public boolean b;

    public rb4(List<MessageVo> list, boolean z) {
        this.f20434a = list;
        this.b = z;
    }

    public static rb4 a() {
        return new rb4(Collections.emptyList(), true);
    }
}
