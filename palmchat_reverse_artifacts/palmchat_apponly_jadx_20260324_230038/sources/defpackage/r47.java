package defpackage;

import android.content.Context;
import com.alipay.android.phone.mrpc.core.aa;
import com.alipay.android.phone.mrpc.core.h;
import com.alipay.android.phone.mrpc.core.w;
import com.alipay.tscenter.biz.rpc.deviceFp.BugTrackMessageService;
import com.alipay.tscenter.biz.rpc.report.general.DataReportService;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import com.oplus.tblplayer.monitor.ErrorCode;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class r47 implements iw6 {
    public static r47 d;
    public static DataReportResult e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public w f20389a;
    public BugTrackMessageService b;
    public DataReportService c;

    public r47(Context context, String str) {
        this.f20389a = null;
        this.b = null;
        this.c = null;
        aa aaVar = new aa();
        aaVar.a(str);
        h hVar = new h(context);
        this.f20389a = hVar;
        this.b = (BugTrackMessageService) hVar.a(BugTrackMessageService.class, aaVar);
        this.c = (DataReportService) this.f20389a.a(DataReportService.class, aaVar);
    }

    public static synchronized r47 b(Context context, String str) {
        if (d == null) {
            d = new r47(context, str);
        }
        return d;
    }

    @Override // defpackage.iw6
    public DataReportResult a(DataReportRequest dataReportRequest) throws InterruptedException {
        if (dataReportRequest == null) {
            return null;
        }
        if (this.c != null) {
            e = null;
            new Thread(new p17(this, dataReportRequest)).start();
            for (int i = ErrorCode.REASON_RD_VIDEO; e == null && i >= 0; i -= 50) {
                Thread.sleep(50L);
            }
        }
        return e;
    }

    @Override // defpackage.iw6
    public boolean logCollect(String str) {
        BugTrackMessageService bugTrackMessageService;
        String strLogCollect;
        if (xu6.c(str) || (bugTrackMessageService = this.b) == null) {
            return false;
        }
        try {
            strLogCollect = bugTrackMessageService.logCollect(xu6.j(str));
        } catch (Throwable unused) {
            strLogCollect = null;
        }
        if (xu6.c(strLogCollect)) {
            return false;
        }
        return ((Boolean) new JSONObject(strLogCollect).get("success")).booleanValue();
    }
}
