package com.bytedance.pangle.x;

import android.os.RemoteException;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.b;
import com.bytedance.pangle.fx;
import com.bytedance.pangle.jk;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.plugin.PluginManager;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends fx.u {
    private static volatile u u;

    public static u nr() {
        if (u == null) {
            synchronized (u.class) {
                if (u == null) {
                    u = new u();
                }
            }
        }
        return u;
    }

    @Override // com.bytedance.pangle.fx
    public boolean u(String str) {
        return PluginManager.getInstance().checkPluginInstalled(str);
    }

    @Override // com.bytedance.pangle.fx
    public boolean u(String str, String str2) {
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_PLUGIN_INSTALL, "start install pkg:" + str + ", path:" + str2);
        return PluginManager.getInstance().syncInstall(str, new File(str2));
    }

    @Override // com.bytedance.pangle.fx
    public void u(int i, b bVar) throws RemoteException {
        Zeus.registerPluginStateListener(new fx(bVar, i));
    }

    @Override // com.bytedance.pangle.fx
    public void u(int i) throws RemoteException {
        ZeusPluginStateListener next;
        List<ZeusPluginStateListener> listFx = jk.u().fx();
        Iterator<ZeusPluginStateListener> it = listFx.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if ((next instanceof fx) && ((fx) next).u() == i) {
                break;
            }
        }
        if (next != null) {
            listFx.remove(next);
        }
    }

    @Override // com.bytedance.pangle.fx
    public int nr(String str) {
        return PluginManager.getInstance().getPlugin(str).getVersion();
    }
}
