package vishal.benotest.di.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import vishal.benotest.BenoApplication;
import vishal.benotest.di.builder.ActivityBuilder;
import vishal.benotest.di.modules.AppModule;
import vishal.benotest.di.modules.ServiceBuilderModule;

/**
 * Author : Vishal Gaur
 * Email  : vishal02gaur@gmail.com
 */
@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class,ServiceBuilderModule.class})
public interface AppComponent {
    void inject(BenoApplication myApplication);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

}
