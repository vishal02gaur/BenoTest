package vishal.benotest.di.builder;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import vishal.benotest.ui.MainActivity;

/**
 * Author : Vishal Gaur
 * Email  : vishal02gaur@gmail.com
 */

@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();

}

