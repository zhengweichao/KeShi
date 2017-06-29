package com.weichao.keshi.net;


/**
 * 创建日期:2016/12/11 on 14:36
 * 描述:
 * 作者:郭士超
 * English name:Super丶C
 * QQ:1169380200
 */

public class MessageSend {
    public MessageSend(String id, String token, String data, final SuccessCallback successCallback, final FailCallback failCallback) {
       /* new NetConnection(Config.SERVER_URL, HttpMethod.POST, new NetConnection.SuccessCallback() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject obj = new JSONObject(result);
                    switch (obj.getString(Config.KEY_ERRMSG)) {
                        case Config.ERRMSG_OK:
                            if (successCallback != null) {
                                successCallback.onSuccess(obj.getString(Config.KEY_ERRMSG),obj.getString(Config.KEY_MSG));
                            }
                            break;
                        default:
                            if (failCallback != null) {
                                failCallback.onFail(obj.getString(Config.KEY_ERRMSG),obj.getString(Config.KEY_MSG));
                            }
                            break;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new NetConnection.FailCallback() {
            @Override
            public void onFail() {
                if (failCallback != null) {
                    failCallback.onFail(Config.ERRMSG_ERR, Config.ERRMSG_MSG);
                }
            }
        },Config.MESSAGE_SEND,
                Config.KEY_ID,id,
                Config.KEY_TOKEN,token,
                Config.KEY_DATA,data);*/
    }


    public static interface SuccessCallback {
        void onSuccess(String errmsg, String msg);
    }

    public static interface FailCallback {
        void onFail(String errmsg, String msg);
    }
}
