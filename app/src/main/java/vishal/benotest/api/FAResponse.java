package vishal.benotest.api;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import static vishal.benotest.api.FAResponse.Status.ERROR;
import static vishal.benotest.api.FAResponse.Status.LOADING;
import static vishal.benotest.api.FAResponse.Status.SUCCESS;

/**
 * A generic class that holds a value with its loading status.
 *
 * @param <T>
 */
public class FAResponse<T> {

    @NonNull
    public final Status status;

    @Nullable
    public final String message;

    @Nullable
    public final T data;

    public int statusCode;

    public FAResponse(@NonNull Status status, @Nullable T data, @Nullable String message, int statusCode) {
        this.status = status;
        this.data = data;
        this.message = message;
        this.statusCode = statusCode;
    }

    public static <T> FAResponse<T> success(@Nullable T data, int statudCode) {
        return new FAResponse<>(SUCCESS, data, null, statudCode);
    }

    public static <T> FAResponse<T> error(String msg, @Nullable T data, int statudCode) {
        return new FAResponse<>(ERROR, data, msg, statudCode);
    }

    public static <T> FAResponse<T> loading(@Nullable T data) {
        return new FAResponse<>(LOADING, data, null, -1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FAResponse<?> resource = (FAResponse<?>) o;

        if (status != resource.status) {
            return false;
        }
        if (message != null ? !message.equals(resource.message) : resource.message != null) {
            return false;
        }
        return data != null ? data.equals(resource.data) : resource.data == null;
    }

    @Override
    public int hashCode() {
        int result = status.hashCode();
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FAResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * Status of a resource that is provided to the UI.
     * <p>
     * These are usually created by the Repository classes where they return
     * {@code LiveData<FAResponse<T>>} to pass back the latest data to the UI with its fetch status.
     */
   public enum Status {
        SUCCESS,
        ERROR,
        LOADING
    }

}

