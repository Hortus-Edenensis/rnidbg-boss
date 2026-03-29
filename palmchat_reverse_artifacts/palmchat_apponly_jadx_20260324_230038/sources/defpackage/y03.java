package defpackage;

import android.os.RemoteException;
import android.util.Pair;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.Vo.ParcelPair;
import com.zenmen.palmchat.Vo.SyncKeys;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.media.AudioDownloader;
import com.zenmen.palmchat.messaging.MessagingService;
import com.zenmen.palmchat.messaging.b;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.fn2;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class y03 extends fn2.a {
    public y03() {
        LogUtil.i("LXMsgServiceStub", "LXMsgServiceStub");
        b.d().c().p(false, "LXMsgServiceStub init");
    }

    @Override // defpackage.fn2
    public void A() throws RemoteException {
        b.d().e().K();
    }

    @Override // defpackage.fn2
    public void E() throws RemoteException {
        b.d().c().r();
    }

    @Override // defpackage.fn2
    public void G() throws RemoteException {
        AccountUtils.v(c.b());
    }

    @Override // defpackage.fn2
    public void M(String str, String str2, String str3, String str4) throws RemoteException {
        AccountUtils.f(c.b(), str, str2, str3, str4);
    }

    @Override // defpackage.fn2
    public ParcelPair h() throws RemoteException {
        ParcelPair parcelPair;
        UnsatisfiedLinkError e;
        Pair<byte[], byte[]> secretKeys;
        try {
            secretKeys = MessagingService.getSecretKeys();
        } catch (UnsatisfiedLinkError e2) {
            parcelPair = null;
            e = e2;
        }
        if (secretKeys == null) {
            return null;
        }
        parcelPair = new ParcelPair();
        try {
            parcelPair.first = (byte[]) secretKeys.first;
            parcelPair.second = (byte[]) secretKeys.second;
        } catch (UnsatisfiedLinkError e3) {
            e = e3;
            e.printStackTrace();
        }
        return parcelPair;
        e.printStackTrace();
        return parcelPair;
    }

    @Override // defpackage.fn2
    public void i(String str, String str2) throws RemoteException {
        MessagingService.setSecretKeys(str, str2);
    }

    @Override // defpackage.fn2
    public boolean isConnected() throws RemoteException {
        return b.d().c().l();
    }

    @Override // defpackage.fn2
    public void j() throws RemoteException {
        throw null;
    }

    @Override // defpackage.fn2
    public boolean k(boolean z, boolean z2, SyncKeys syncKeys) throws RemoteException {
        return iq5.d().h(z, z2, -1L, syncKeys == null ? null : syncKeys.keys);
    }

    @Override // defpackage.fn2
    public void l(MessageVo messageVo) throws RemoteException {
        AudioDownloader.getInstance().downloadAudioFileByMessageId(messageVo, true);
    }

    @Override // defpackage.fn2
    public void n(String str, String str2) throws RemoteException {
        AccountUtils.B(c.b(), str, str2);
    }

    @Override // defpackage.fn2
    public boolean o(boolean z, boolean z2, List<String> list) throws RemoteException {
        return false;
    }

    @Override // defpackage.fn2
    public void q() throws RemoteException {
        b.d().c().f();
    }

    @Override // defpackage.fn2
    public void r(MessageVo messageVo) throws RemoteException {
        b.d().e().N(messageVo);
    }

    @Override // defpackage.fn2
    public void s(String str) throws RemoteException {
        b.d().e().C(str);
    }

    @Override // defpackage.fn2
    public boolean w() throws RemoteException {
        return b.d().c().k();
    }

    @Override // defpackage.fn2
    public void x(long j) throws RemoteException {
        b.d().c().z(j);
    }

    @Override // defpackage.fn2
    public void J() throws RemoteException {
    }

    @Override // defpackage.fn2
    public void p() throws RemoteException {
    }

    @Override // defpackage.fn2
    public void F(String str) throws RemoteException {
    }
}
