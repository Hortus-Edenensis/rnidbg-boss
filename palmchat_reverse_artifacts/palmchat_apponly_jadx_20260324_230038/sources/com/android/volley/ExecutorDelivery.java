package com.android.volley;

import android.os.Handler;
import com.zenmen.palmchat.update.UpdateManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.hx3;
import defpackage.pw3;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class ExecutorDelivery implements ResponseDelivery {
    private final Executor mResponsePoster;

    /* JADX INFO: compiled from: SearchBox */
    public class ResponseDeliveryRunnable implements Runnable {
        private final Request mRequest;
        private final Response mResponse;
        private final Runnable mRunnable;

        public ResponseDeliveryRunnable(Request request, Response response, Runnable runnable) {
            this.mRequest = request;
            this.mResponse = response;
            this.mRunnable = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mRequest.isCanceled()) {
                this.mRequest.finish("canceled-at-delivery");
                return;
            }
            if (this.mResponse.isSuccess()) {
                this.mRequest.deliverResponse(this.mResponse.result);
            } else {
                this.mRequest.deliverError(this.mResponse.error);
            }
            if (this.mResponse.intermediate) {
                this.mRequest.addMarker("intermediate-response");
            } else {
                this.mRequest.finish("done");
            }
            Runnable runnable = this.mRunnable;
            if (runnable != null) {
                runnable.run();
            }
        }

        public boolean shouldRunByHandler() {
            Request request = this.mRequest;
            if (request == null) {
                return true;
            }
            try {
                Map<String, String> headers = request.getHeaders();
                if (headers == null || !headers.containsKey(Request.HEADER_RUN_IN_THREAD)) {
                    return true;
                }
                return !headers.get(Request.HEADER_RUN_IN_THREAD).equals("1");
            } catch (AuthFailureError e) {
                e.printStackTrace();
                return true;
            }
        }
    }

    public ExecutorDelivery(final Handler handler) {
        this.mResponsePoster = new Executor() { // from class: com.android.volley.ExecutorDelivery.1
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                if (!(runnable instanceof ResponseDeliveryRunnable) || ((ResponseDeliveryRunnable) runnable).shouldRunByHandler()) {
                    handler.post(runnable);
                } else {
                    runnable.run();
                }
            }
        };
    }

    private String getResponseResult(Response<?> response) {
        if (response == null) {
            return "";
        }
        try {
            return "" + response.result;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.android.volley.ResponseDelivery
    public void postError(Request<?> request, VolleyError volleyError) {
        StringBuilder sb = new StringBuilder();
        sb.append("postError url");
        sb.append(request != null ? request.getUrl() : null);
        sb.append(" error =");
        sb.append(volleyError);
        LogUtil.e("ExecutorDelivery", sb.toString());
        request.addMarker("post-error");
        this.mResponsePoster.execute(new ResponseDeliveryRunnable(request, Response.error(volleyError), null));
        if (volleyError != null) {
            if (volleyError instanceof CustomAuthFailureError) {
                if ("NONE".equals(hx3.e())) {
                    return;
                }
                LogUtil.i("ExecutorDelivery", LogUtil.LogType.LOG_TYPE_BACKGROUND_NETWORK, 3, new HashMap<String, Object>(volleyError, request) { // from class: com.android.volley.ExecutorDelivery.2
                    final /* synthetic */ VolleyError val$error;
                    final /* synthetic */ Request val$request;

                    {
                        this.val$error = volleyError;
                        this.val$request = request;
                        put("action", LogUtil.NETWORK_LOG);
                        put("status", "CustomAuthFailureError");
                        put("error", volleyError.getMessage());
                        put("url", request.getUrl());
                    }
                }, (Throwable) null);
            } else if (volleyError instanceof TimeoutError) {
                LogUtil.i("ExecutorDelivery", LogUtil.LogType.LOG_TYPE_BACKGROUND_NETWORK, 3, new HashMap<String, Object>(volleyError, request) { // from class: com.android.volley.ExecutorDelivery.3
                    final /* synthetic */ VolleyError val$error;
                    final /* synthetic */ Request val$request;

                    {
                        this.val$error = volleyError;
                        this.val$request = request;
                        put("action", LogUtil.NETWORK_LOG);
                        put("status", "TimeoutError");
                        put("error", volleyError.getMessage());
                        put("url", request.getUrl());
                    }
                }, (Throwable) null);
            }
        }
    }

    @Override // com.android.volley.ResponseDelivery
    public void postResponse(Request<?> request, Response<?> response) {
        postResponse(request, response, null);
    }

    @Override // com.android.volley.ResponseDelivery
    public void postResponse(Request<?> request, Response<?> response, Runnable runnable) {
        String responseResult = getResponseResult(response);
        LogUtil.i("ExecutorDelivery", "postResponse " + request.getUrl() + " response =" + responseResult);
        pw3.d(request.getUrl(), 200, responseResult);
        request.markDelivered();
        request.addMarker("post-response");
        this.mResponsePoster.execute(new ResponseDeliveryRunnable(request, response, runnable));
        UpdateManager.k.a(request.getUrl(), "" + responseResult);
    }

    public ExecutorDelivery(Executor executor) {
        this.mResponsePoster = executor;
    }
}
