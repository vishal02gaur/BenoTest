package vishal.benotest.di.modules;


import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import vishal.benotest.di.builder.BenoViewModelFactory;
import vishal.benotest.ui.MainViewModel;

@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel bindMainViewModel(MainViewModel mainViewModel);


    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(BenoViewModelFactory factory);
}
