package defpackage;

import com.zenmen.openapi.offline.request.FetchPkgInfo;
import com.zenmen.openapi.offline.request.OfflineResponseBean;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class x54 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static x54 f21883a;
    public static List<String> b;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements eo6<OfflineResponseBean> {
        public a() {
        }

        @Override // defpackage.eo6
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(OfflineResponseBean offlineResponseBean) {
            if (offlineResponseBean != null) {
                b64.b().f(offlineResponseBean.getPkgInfos());
            }
        }

        @Override // defpackage.eo6
        public void onError(Exception exc) {
            ma3.c(exc);
        }
    }

    static {
        ArrayList arrayList = new ArrayList(3);
        b = arrayList;
        arrayList.add("lxa2b298210f654d1d".toUpperCase());
        b.add("lx5daacb3f82714e98".toUpperCase());
        b.add("lxa0ac81fbec6548eb".toUpperCase());
    }

    public static x54 b() {
        if (f21883a == null) {
            synchronized (x54.class) {
                if (f21883a == null) {
                    f21883a = new x54();
                }
            }
        }
        return f21883a;
    }

    public void a(List<FetchPkgInfo> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        new y54("lxxyy", list, new a()).q();
    }
}
