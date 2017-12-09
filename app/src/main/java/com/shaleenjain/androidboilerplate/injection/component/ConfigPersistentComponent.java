package com.shaleenjain.androidboilerplate.injection.component;

import dagger.Component;
import com.shaleenjain.androidboilerplate.injection.ConfigPersistent;
import com.shaleenjain.androidboilerplate.injection.module.ActivityModule;
import com.shaleenjain.androidboilerplate.ui.base.BaseActivity;

/**
 * A dagger component that will live during the lifecycle of an Activity but it won't
 * be destroy during configuration changes. Check {@link BaseActivity} to see how this components
 * survives configuration changes.
 * Use the {@link ConfigPersistent} scope to annotate dependencies that need to survive
 * configuration changes (for example Presenters).
 */
@ConfigPersistent
@Component(dependencies = ApplicationComponent.class)
public interface ConfigPersistentComponent {

    ActivityComponent activityComponent(ActivityModule activityModule);

}