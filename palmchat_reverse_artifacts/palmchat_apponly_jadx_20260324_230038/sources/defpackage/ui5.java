package defpackage;

import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.square.bean.SquareGuideTieziDialogBean;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ui5 {

    /* JADX INFO: compiled from: SearchBox */
    public class a extends go2<LXBaseNetBean<SquareGuideTieziDialogBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LocationEx f21219a;
        public final /* synthetic */ String b;
        public final /* synthetic */ b c;

        public a(LocationEx locationEx, String str, b bVar) {
            this.f21219a = locationEx;
            this.b = str;
            this.c = bVar;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            map.put("latitude", Double.valueOf(this.f21219a.getLatitude()));
            map.put("longitude", Double.valueOf(this.f21219a.getLongitude()));
            return sw4.b(1, this.b, map);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<SquareGuideTieziDialogBean> lXBaseNetBean, Exception exc) {
            b bVar;
            if (z && lXBaseNetBean.isSuccess() && (bVar = this.c) != null) {
                bVar.a(lXBaseNetBean.data);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(SquareGuideTieziDialogBean squareGuideTieziDialogBean);
    }

    public void a(LocationEx locationEx, b bVar) {
        zw4.e(new a(locationEx, nl0.z + "/square.post.feed.guide.popup.v1", bVar));
    }
}
