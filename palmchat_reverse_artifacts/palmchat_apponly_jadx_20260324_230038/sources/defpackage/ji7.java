package defpackage;

import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class ji7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f18420a = false;
    public int b = -1;
    public String c = null;
    public ValueSet d = null;

    /* JADX INFO: compiled from: SearchBox */
    public static final class b implements Result {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f18421a;
        public final int b;
        public final String c;
        public final ValueSet d;

        @Override // com.bykv.vk.openvk.api.proto.Result
        public int code() {
            return this.b;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public boolean isSuccess() {
            return this.f18421a;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public String message() {
            return this.c;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public ValueSet values() {
            return this.d;
        }

        public b(boolean z, int i, String str, ValueSet valueSet) {
            this.f18421a = z;
            this.b = i;
            this.c = str;
            this.d = valueSet;
        }
    }

    public static final ji7 b() {
        return new ji7();
    }

    public Result a() {
        boolean z = this.f18420a;
        int i = this.b;
        String str = this.c;
        ValueSet valueSetA = this.d;
        if (valueSetA == null) {
            valueSetA = wc7.b().a();
        }
        return new b(z, i, str, valueSetA);
    }

    public ji7 c(int i) {
        this.b = i;
        return this;
    }

    public ji7 d(ValueSet valueSet) {
        this.d = valueSet;
        return this;
    }

    public ji7 e(String str) {
        this.c = str;
        return this;
    }

    public ji7 f(boolean z) {
        this.f18420a = z;
        return this;
    }
}
