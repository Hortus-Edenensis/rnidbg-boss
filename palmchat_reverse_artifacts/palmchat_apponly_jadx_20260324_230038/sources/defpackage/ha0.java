package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.circle.bridge.http.BaseResponse;
import com.zenmen.palmchat.circle.label.bean.CircleLabel;
import com.zenmen.palmchat.circle.label.bean.CircleLabelResponse;
import com.zenmen.palmchat.circle.label.bean.RoomTag;
import com.zenmen.palmchat.circle.label.ui.CircleLabelActivity;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ha0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CircleLabelActivity f17899a;
    public final ga0 b = new ga0();
    public final boolean c;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends wi0<BaseResponse<CircleLabelResponse>> {
        public a() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse<CircleLabelResponse> baseResponse) {
            if (baseResponse == null || baseResponse.getResultCode() != 0) {
                if (ha0.this.f17899a != null) {
                    ha0.this.f17899a.hideBaseProgressBar();
                    ha0.this.f17899a.W1(baseResponse != null ? baseResponse.getErrorMsg() : "");
                    return;
                }
                return;
            }
            CircleLabelResponse data = baseResponse.getData();
            List<RoomTag> list = data.myTagList;
            List<RoomTag> list2 = data.sysTagList;
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (RoomTag roomTag : list) {
                    if (!TextUtils.isEmpty(roomTag.tagName)) {
                        arrayList.add(ha0.this.c ? fa0.b(roomTag.tagName.trim(), roomTag.tagId) : fa0.d(roomTag.tagName.trim(), roomTag.tagId));
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList();
            if (list2 != null) {
                for (RoomTag roomTag2 : list2) {
                    if (!TextUtils.isEmpty(roomTag2.tagName)) {
                        arrayList2.add(fa0.c(roomTag2.tagName.trim(), roomTag2.tagId));
                    }
                }
            }
            if (ha0.this.f17899a != null) {
                ha0.this.f17899a.hideBaseProgressBar();
                ha0.this.f17899a.R1(arrayList);
                ha0.this.f17899a.S1(arrayList2);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends wi0<BaseResponse> {
        public b() {
        }

        @Override // defpackage.wi0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BaseResponse baseResponse) {
            if (baseResponse == null || baseResponse.getResultCode() != 0) {
                if (ha0.this.f17899a != null) {
                    ha0.this.f17899a.hideBaseProgressBar();
                    ha0.this.f17899a.W1(baseResponse != null ? baseResponse.getErrorMsg() : "");
                    return;
                }
                return;
            }
            if (ha0.this.f17899a != null) {
                ha0.this.f17899a.hideBaseProgressBar();
                ha0.this.f17899a.T1();
            }
        }
    }

    public ha0(boolean z) {
        this.c = z;
    }

    public void c(CircleLabelActivity circleLabelActivity) {
        this.f17899a = circleLabelActivity;
    }

    public void d() {
        this.f17899a = null;
    }

    public void e(String str) {
        CircleLabelActivity circleLabelActivity = this.f17899a;
        if (circleLabelActivity != null) {
            circleLabelActivity.showBaseProgressBar();
        }
        this.b.a(str, new a());
    }

    public void f(String str, List<CircleLabel> list) {
        CircleLabelActivity circleLabelActivity = this.f17899a;
        if (circleLabelActivity != null) {
            circleLabelActivity.showBaseProgressBar();
        }
        ArrayList arrayList = new ArrayList();
        for (CircleLabel circleLabel : list) {
            RoomTag roomTag = new RoomTag();
            roomTag.tagName = circleLabel.labelName;
            arrayList.add(roomTag);
        }
        this.b.b(str, arrayList, new b());
    }
}
