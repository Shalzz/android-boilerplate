package in.eightbitlabs.androidboilerplate.injection.component;

import dagger.Subcomponent;
import in.eightbitlabs.androidboilerplate.injection.PerActivity;
import in.eightbitlabs.androidboilerplate.injection.module.ActivityModule;
import in.eightbitlabs.androidboilerplate.ui.main.MainActivity;

/**
 * This component inject dependencies to all Activities across the application
 */
@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
