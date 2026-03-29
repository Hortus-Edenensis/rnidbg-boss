package defpackage;

import com.zenmen.square.mvp.model.bean.SquareFeedEvent;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class xt1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f22045a;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void Y0(SquareFeedEvent squareFeedEvent);
    }

    public xt1(a aVar) {
        this.f22045a = aVar;
    }

    @pm5(threadMode = ThreadMode.MAIN)
    public void receiveSquareFeedEvent(SquareFeedEvent squareFeedEvent) {
        a aVar = this.f22045a;
        if (aVar != null) {
            aVar.Y0(squareFeedEvent);
        }
    }
}
