package es.ulpgc.eite.cleancode.visitcanary.cover;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.visitcanary.app.CatalogMediator;
import es.ulpgc.eite.cleancode.visitcanary.data.CatalogRepository;

public class CoverPresenter implements CoverContract.Presenter {

    public static String TAG = CoverPresenter.class.getSimpleName();

    private WeakReference<CoverContract.View> view;
    private CoverState state;
    private CoverContract.Model model;
    private CatalogMediator mediator;

    public CoverPresenter(CatalogMediator mediator) {
        this.mediator = mediator;
        state = mediator.getCoverState();
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new CoverState();
        }

        // call the model and update the state
        state.titulo = model.getTitulo();
        state.comenzar=model.getComenzar();

        // use passed state if is necessary

    }

    @Override
    public void ButtonCliked() {
        view.get().navigateToNextScreen();
    }

    @Override
    public void onRestart() {
        // Log.e(TAG, "onRestart()");

        // update the model if is necessary
        model.onRestartScreen(state.titulo,state.comenzar);
    }

    @Override
    public void onResume() {
        // Log.e(TAG, "onResume()");

        // use passed state if is necessary
        // call the model and update the state
        //state.data = model.getStoredData();

        // update the view
        view.get().onDataUpdated(state);
        view.get().activateButton();

    }

    @Override
    public void onBackPressed() {
        // Log.e(TAG, "onBackPressed()");
    }

    @Override
    public void onPause() {
        // Log.e(TAG, "onPause()");
    }

    @Override
    public void onDestroy() {
        // Log.e(TAG, "onDestroy()");
    }


//    private void passStateToNextScreen(CoverToNextState state) {
//        mediator.setNextCoverScreenState(state);
//    }
//
//    private void passStateToPreviousScreen(CoverToPreviousState state) {
//        mediator.setPreviousCoverScreenState(state);
//    }



    @Override
    public void injectView(WeakReference<CoverContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(CoverContract.Model model) {
        this.model = model;
    }

}
