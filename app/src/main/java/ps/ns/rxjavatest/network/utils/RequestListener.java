package ps.ns.rxjavatest.network.utils;

public interface RequestListener<T> {
    void onSuccess(T data);

    void onFail(String message, int code);
}
