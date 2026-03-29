package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class wl2 {
    protected ba3 mCordovaInterface;
    protected List<ib3> mPlugins = new ArrayList();

    public abstract void executeAction(String str, String str2, v93 v93Var);

    public ib3 findExecPlugin(String str) {
        for (ib3 ib3Var : this.mPlugins) {
            if (ib3Var.canExec(str)) {
                return ib3Var;
            }
        }
        return null;
    }

    public ba3 getCordovaInterface() {
        return this.mCordovaInterface;
    }

    public abstract void initialize(ba3 ba3Var);

    public void onDestroy() {
        Iterator<ib3> it = this.mPlugins.iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
    }

    public abstract void registerSubPlugin();

    public abstract boolean routerToTargetPage(String str);
}
