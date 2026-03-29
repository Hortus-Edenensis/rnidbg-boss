package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0019¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J/\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\u0013\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0004R\u001e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lq5;", "", "Landroid/os/Bundle;", "savedInstanceState", "", t.l, "c", "", "requestCode", "", "", "permissions", "", "grantResults", "d", "(I[Ljava/lang/String;[I)V", "resultCode", "Landroid/content/Intent;", "data", "a", "e", "", "Lqg4;", "Ljava/util/List;", "_waits", "Landroid/app/Activity;", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "zx-permission_release"}, k = 1, mv = {1, 4, 0})
public final class q5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public List<PermissionProc> _waits;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final Activity activity;

    public q5(Activity activity) {
        this.activity = activity;
    }

    public void a(int requestCode, int resultCode, Intent data) {
        e();
    }

    public void c() {
        List<PermissionProc> list = this._waits;
        if (list != null) {
            list.clear();
        }
    }

    public void d(int requestCode, String[] permissions, int[] grantResults) {
        ArrayList arrayList = new ArrayList();
        int length = permissions.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str = permissions[i];
            int i3 = i2 + 1;
            if (grantResults[i2] == 0) {
                arrayList.add(str);
            }
            i++;
            i2 = i3;
        }
        if (arrayList.isEmpty()) {
            return;
        }
        e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e() {
        Collection<?> collectionEmptyList;
        List<PermissionProc> list = this._waits;
        if (list == null || list.isEmpty()) {
            return;
        }
        List<PermissionProc> list2 = this._waits;
        if (list2 != null) {
            collectionEmptyList = new ArrayList<>();
            for (Object obj : list2) {
                List<String> listA = ((PermissionProc) obj).a();
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : listA) {
                    if (ContextCompat.checkSelfPermission(this.activity, (String) obj2) != 0) {
                        arrayList.add(obj2);
                    }
                }
                if (arrayList.isEmpty()) {
                    collectionEmptyList.add(obj);
                }
            }
        } else {
            collectionEmptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        List<PermissionProc> list3 = this._waits;
        if (list3 != null) {
            list3.removeAll(collectionEmptyList);
        }
        Iterator<T> it = collectionEmptyList.iterator();
        while (it.hasNext()) {
            ((PermissionProc) it.next()).b().invoke();
        }
    }

    public void b(Bundle savedInstanceState) {
    }
}
