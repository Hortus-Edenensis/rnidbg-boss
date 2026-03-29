package defpackage;

import android.content.Context;
import android.view.View;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.chat.viewadapter.SimpleChatViewAdapter;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ls0 extends SimpleChatViewAdapter {
    public dl2 i;

    @Override // defpackage.o40
    public int a() {
        return this.i.a();
    }

    @Override // defpackage.o40
    public View b(Context context, MessageVo messageVo) {
        return this.i.b(context, messageVo);
    }

    @Override // defpackage.o40
    public if6 c(View view) {
        ms0 ms0Var = new ms0(view);
        ms0Var.h(this.i.c(view));
        return ms0Var;
    }

    @Override // defpackage.o40
    public int getViewTypeCount() {
        return this.i.getViewTypeCount();
    }

    @Override // defpackage.o40
    public <T extends if6> void l(T t, MessageVo messageVo) {
        this.i.e(((ms0) t).g(), messageVo);
    }

    @Override // defpackage.o40
    public int m(boolean z, int i, MessageVo messageVo) {
        return this.i.d(z, i);
    }

    public void w(dl2 dl2Var) {
        this.i = dl2Var;
    }
}
