package defpackage;

import com.zenmen.palmchat.location.LocationEx;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public interface i53 {
    void onLocationReceived(LocationEx locationEx, int i, String str);

    void onLocationSearchResultGot(int i, List<LocationEx> list, n53 n53Var);

    void onRegeocodeSearched(String str);
}
