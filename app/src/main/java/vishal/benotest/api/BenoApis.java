package vishal.benotest.api;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import vishal.benotest.models.PropertyResponse;

/**
 * Created by Vishal Gaur
 */

public interface BenoApis {
    @GET("/bins/bs67u")
    Observable<Response<PropertyResponse>> getData();
}
