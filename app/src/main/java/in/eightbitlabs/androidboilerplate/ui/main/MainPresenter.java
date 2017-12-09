package in.eightbitlabs.androidboilerplate.ui.main;

import org.reactivestreams.Subscriber;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;
import in.eightbitlabs.androidboilerplate.data.DataManager;
import in.eightbitlabs.androidboilerplate.data.model.Ribot;
import in.eightbitlabs.androidboilerplate.injection.ConfigPersistent;
import in.eightbitlabs.androidboilerplate.ui.base.BasePresenter;
import in.eightbitlabs.androidboilerplate.util.RxUtil;

@ConfigPersistent
public class MainPresenter extends BasePresenter<MainMvpView> {

    private final DataManager mDataManager;
    private Disposable mDisposable;

    @Inject
    public MainPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(MainMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mDisposable != null) mDisposable.dispose();
    }

    public void loadRibots() {
        checkViewAttached();
        RxUtil.dispose(mDisposable);
        mDataManager.getRibots()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Ribot>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(@NonNull List<Ribot> ribots) {
                        if (ribots.isEmpty()) {
                            getMvpView().showRibotsEmpty();
                        } else {
                            getMvpView().showRibots(ribots);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Timber.e(e, "There was an error loading the ribots.");
                        getMvpView().showError();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void syncRibots() {
        checkViewAttached();
        getMvpView().showLoading();
        RxUtil.dispose(mDisposable);
        mDataManager.syncRibots()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Ribot>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(Ribot ribots) {
                        getMvpView().dismissLoading();
                    }

                    @Override
                    public void onError(Throwable e) {
                        getMvpView().dismissLoading();
                        Timber.e(e, "There was an error loading the ribots.");
                        getMvpView().showError();
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }
}
