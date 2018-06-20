package vishal.benotest.di.modules;

import android.app.Application;
import android.app.DatePickerDialog;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import vishal.benotest.AppExecutors;
import vishal.benotest.api.NetworkClient;
import vishal.benotest.db.Database;

/**
 * Author : Vishal Gaur
 * Email  : vishal02gaur@gmail.com
 * Date   : 24/3/18
 */
@Module(includes = ViewModelModule.class)
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }


    @Singleton
    @Provides
    NetworkClient providesNetworkClient() {
        return new NetworkClient();
    }

    @Singleton
    @Provides
    Database providesDatabaseManager(Application context) {
        return new Database(context);
    }

    @Singleton
    @Provides
    AppExecutors providesAppExecutors() {
        return new AppExecutors();
    }


}
