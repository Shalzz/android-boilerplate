package in.eightbitlabs.androidboilerplate.injection.component;

import javax.inject.Singleton;

import dagger.Component;
import in.eightbitlabs.androidboilerplate.injection.module.ApplicationTestModule;

@Singleton
@Component(modules = ApplicationTestModule.class)
public interface TestComponent extends ApplicationComponent {

}
