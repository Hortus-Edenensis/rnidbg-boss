package com.bytedance.sdk.openadsdk.n;

import com.bytedance.sdk.component.iz.h;
import com.bytedance.sdk.component.iz.l;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx implements h {
    private static int u;
    private boolean b;
    private long fx;
    private long nr = 0;
    private String pn;

    public fx() {
        u++;
        this.pn = "image_request_" + u;
    }

    private String u(String str, l lVar) {
        com.bytedance.sdk.component.iz.fx.u uVarT;
        if (str == null) {
            return str;
        }
        switch (str) {
            case "success":
                return "成功";
            case "raw_cache":
                return "查询RAW内存缓存";
            case "image_type":
                return "判断图片类型：";
            case "disk_cache":
                return "查询文件缓存";
            case "decode":
                return "解码";
            case "failed":
                if (!(lVar instanceof com.bytedance.sdk.component.iz.fx.fx) || (uVarT = ((com.bytedance.sdk.component.iz.fx.fx) lVar).t()) == null) {
                    return "失败";
                }
                Throwable thFx = uVarT.fx();
                StringBuilder sb = new StringBuilder("失败：code:");
                sb.append(uVarT.u());
                sb.append(", msg:");
                sb.append(uVarT.nr());
                sb.append(", exception:");
                sb.append(thFx != null ? thFx.getMessage() : "null \r\n");
                return sb.toString();
            case "check_duplicate":
                return "检查重复请求";
            case "memory_cache":
                return "查询Bitmap内存缓存";
            case "net_request":
                return "请求网络";
            case "generate_key":
                return "生成KEY:" + lVar.getMemoryCacheKey();
            case "cache_policy":
                return "查询缓存策略";
            default:
                return str;
        }
    }

    @Override // com.bytedance.sdk.component.iz.h
    public void onStepEnd(String str, l lVar) {
        this.fx += System.currentTimeMillis() - this.nr;
        u(str, lVar);
    }

    @Override // com.bytedance.sdk.component.iz.h
    public void onStepStart(String str, l lVar) {
        if (!this.b) {
            lVar.getUrl();
            lVar.getWidth();
            lVar.getHeight();
            this.b = true;
        }
        this.nr = System.currentTimeMillis();
        u(str, lVar);
    }
}
