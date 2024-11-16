package com.polstat.inventarisasi.rpc;

public class JsonRpcResponse {
    private String Jsonrpc;
    private Object result;
    private Object error;
    private String id;

    public JsonRpcResponse(Object result, String id) {
        this.Jsonrpc = "2.0";
        this.result = result;
        this.id = id;
    }

    public String getJsonrpc() {
        return Jsonrpc;
    }

    public void setJsonrpc(String jsonrpc) {
        Jsonrpc = jsonrpc;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
