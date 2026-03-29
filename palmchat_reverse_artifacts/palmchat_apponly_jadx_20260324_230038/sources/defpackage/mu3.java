package defpackage;

import com.zenmen.square.mvp.model.bean.NearByResp;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class mu3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f19369a;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void h();
    }

    public mu3(a aVar) {
        this.f19369a = aVar;
    }

    @pm5(threadMode = ThreadMode.MAIN)
    public void receiveVipInvalidEvent(NearByResp nearByResp) {
        a aVar = this.f19369a;
        if (aVar == null || !nearByResp.needVip) {
            return;
        }
        aVar.h();
    }
}
