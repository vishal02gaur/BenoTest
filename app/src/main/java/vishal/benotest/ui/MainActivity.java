package vishal.benotest.ui;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import vishal.benotest.BaseActivity;
import vishal.benotest.R;
import vishal.benotest.SpacesItemDecoration;
import vishal.benotest.Utils;
import vishal.benotest.databinding.ActivityMainBinding;
import vishal.benotest.models.Property;

public class MainActivity extends BaseActivity {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private MainViewModel mainViewModel;

    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel.class);
        activityMainBinding.retry.setOnClickListener(v -> loadData());
        loadData();
    }

    private void loadData() {
        activityMainBinding.errorContainer.setVisibility(View.GONE);
        mainViewModel.loadData().observe(this, dataResponse -> {
            switch (dataResponse.status) {
                case LOADING:
                    Toast.makeText(this, "loading", Toast.LENGTH_SHORT).show();
                    break;
                case ERROR:
                    Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
                    error(dataResponse.message);
                    break;
                case SUCCESS:
                    setupList(dataResponse.data);
                    break;
            }
        });
    }

    private void error(String msg) {
        activityMainBinding.errorContainer.setVisibility(View.VISIBLE);
        activityMainBinding.errorMsg.setText(msg);
        if (!Utils.isNetworkAvailable(this)) {
            activityMainBinding.errorMsg.setText("Check Internet Connection");
        }
    }


    private void setupList(List<Property> list) {
        SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(20);
        activityMainBinding.propertyRv.setLayoutManager(new LinearLayoutManager(this));
        activityMainBinding.propertyRv.addItemDecoration(spacesItemDecoration);
        activityMainBinding.propertyRv.setAdapter(new PropertyAdapter(list));
    }

}