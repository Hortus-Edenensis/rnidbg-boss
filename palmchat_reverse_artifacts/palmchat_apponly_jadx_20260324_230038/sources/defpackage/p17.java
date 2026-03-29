package defpackage;

import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class p17 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DataReportRequest f19921a;
    public final /* synthetic */ r47 b;

    public p17(r47 r47Var, DataReportRequest dataReportRequest) {
        this.b = r47Var;
        this.f19921a = dataReportRequest;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            DataReportResult unused = r47.e = this.b.c.reportData(this.f19921a);
        } catch (Throwable th) {
            DataReportResult unused2 = r47.e = new DataReportResult();
            r47.e.success = false;
            r47.e.resultCode = "static data rpc upload error, " + xu6.a(th);
            xu6.a(th);
        }
    }
}
