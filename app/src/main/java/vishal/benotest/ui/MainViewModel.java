package vishal.benotest.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;
import vishal.benotest.api.FAResponse;
import vishal.benotest.api.NetworkClient;
import vishal.benotest.db.PropertyDao;
import vishal.benotest.models.Property;
import vishal.benotest.models.PropertyResponse;

/**
 * Created by Vishal Gaur on 6/20/2018.
 */

public class MainViewModel extends ViewModel {

    private PropertyDao propertyDao;
    private NetworkClient networkClient;

    private MutableLiveData<FAResponse<List<Property>>> listLiveData;

    @Inject
    MainViewModel(PropertyDao propertyDao, NetworkClient networkClient) {
        this.propertyDao = propertyDao;
        this.networkClient = networkClient;
    }

    public LiveData<FAResponse<List<Property>>> loadData() {
        if (listLiveData == null || listLiveData.getValue().status == FAResponse.Status.ERROR) {
            listLiveData = new MutableLiveData<>();
            listLiveData.postValue(FAResponse.loading(null));

            List<Property> propertyList = propertyDao.getAllProperty();

            if (propertyList.size() != 0) {
                listLiveData.postValue(FAResponse.success(propertyList, 20));
            } else {
                networkClient.createService()
                        .getData()
                        .subscribeOn(Schedulers.newThread())
                        .subscribe(new Observer<Response<PropertyResponse>>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(Response<PropertyResponse> response) {
                                if (response != null && response.body() != null) {
                                    if (response.code() == 200) {
                                        PropertyResponse propertyResponse = response.body();
                                        propertyDao.savePropertyList(propertyResponse.getPropertyListing());
                                        listLiveData.postValue(FAResponse.success(propertyResponse.getPropertyListing(), response.code()));
                                    } else
                                        listLiveData.postValue(FAResponse.error("Error while getting data from server.", null, -1));
                                } else
                                    listLiveData.postValue(FAResponse.error("Error while getting data from server.", null, -1));
                            }

                            @Override
                            public void onError(Throwable e) {
                                listLiveData.postValue(FAResponse.error("Error while getting data from server.", null, -1));
                            }

                            @Override
                            public void onComplete() {

                            }
                        });

            }
        }
        return listLiveData;
    }

}
