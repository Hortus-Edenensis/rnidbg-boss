package com.opos.mobad.cmn.func;

import android.content.Context;
import android.view.View;
import com.opos.mobad.ad.privacy.ComplianceInfo;
import com.opos.mobad.ad.privacy.b;
import com.opos.mobad.model.data.AdItemData;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();

        void a(View view);
    }

    public static ComplianceInfo a(AdItemData adItemData) {
        if (adItemData == null || adItemData.U() == null) {
            return null;
        }
        return new ComplianceInfo(adItemData.U().b, adItemData.U().f9081a, adItemData.U().f);
    }

    public static void a(final Context context, List<View> list, final a aVar, List<View> list2, final a aVar2, List<View> list3, final a aVar3, final com.opos.mobad.ad.privacy.b bVar, final ComplianceInfo complianceInfo) {
        if (complianceInfo == null || bVar == null) {
            com.opos.cmn.an.f.a.b("PrivacyTool", "bind but return " + complianceInfo + "," + bVar);
            return;
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.opos.mobad.cmn.func.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a aVar4 = aVar;
                if (aVar4 != null) {
                    aVar4.a(view);
                }
                bVar.a(context, 0, complianceInfo, new b.a() { // from class: com.opos.mobad.cmn.func.b.1.1
                    @Override // com.opos.mobad.ad.privacy.b.a
                    public void a() {
                        a aVar5 = aVar;
                        if (aVar5 != null) {
                            aVar5.a();
                        }
                    }
                });
            }
        };
        for (View view : list) {
            com.opos.cmn.an.f.a.b("PrivacyTool", "set privacy listener " + view);
            if (view != null) {
                view.setOnClickListener(onClickListener);
            }
        }
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.opos.mobad.cmn.func.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a aVar4 = aVar2;
                if (aVar4 != null) {
                    aVar4.a(view2);
                }
                bVar.a(context, 1, complianceInfo, new b.a() { // from class: com.opos.mobad.cmn.func.b.2.1
                    @Override // com.opos.mobad.ad.privacy.b.a
                    public void a() {
                        a aVar5 = aVar2;
                        if (aVar5 != null) {
                            aVar5.a();
                        }
                    }
                });
            }
        };
        for (View view2 : list2) {
            com.opos.cmn.an.f.a.b("PrivacyTool", "set permission listener " + view2);
            if (view2 != null) {
                view2.setOnClickListener(onClickListener2);
            }
        }
        if (list3 != null) {
            View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.opos.mobad.cmn.func.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    a aVar4 = aVar3;
                    if (aVar4 != null) {
                        aVar4.a(view3);
                    }
                    bVar.a(context, 2, complianceInfo, new b.a() { // from class: com.opos.mobad.cmn.func.b.3.1
                        @Override // com.opos.mobad.ad.privacy.b.a
                        public void a() {
                            a aVar5 = aVar3;
                            if (aVar5 != null) {
                                aVar5.a();
                            }
                        }
                    });
                }
            };
            for (View view3 : list3) {
                com.opos.cmn.an.f.a.b("PrivacyTool", "set privacy listener " + view3);
                if (view3 != null) {
                    view3.setOnClickListener(onClickListener3);
                }
            }
        }
    }
}
