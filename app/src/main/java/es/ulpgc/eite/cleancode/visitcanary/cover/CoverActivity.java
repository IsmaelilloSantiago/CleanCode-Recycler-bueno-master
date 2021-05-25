package es.ulpgc.eite.cleancode.visitcanary.cover;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import es.ulpgc.eite.cleancode.visitcanary.R;
import es.ulpgc.eite.cleancode.visitcanary.categories.CategoryListActivity;

public class CoverActivity
        extends AppCompatActivity implements CoverContract.View {

    public static String TAG = CoverActivity.class.getSimpleName();

    private CoverContract.Presenter presenter;
    private Button comenzar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cover);
        comenzar=findViewById(R.id.comenzarButton);
    /*
    if(savedInstanceState == null) {
      AppMediator.resetInstance();
    }
    */

        // do the setup
        CoverScreen.configure(this);


        if (savedInstanceState == null) {
            presenter.onStart();

        } else {
            presenter.onRestart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.onResume();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        presenter.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();

        presenter.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.onDestroy();
    }

    @Override
    public void onDataUpdated(CoverViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data

        ((TextView) findViewById(R.id.textView)).setText(viewModel.titulo);

       comenzar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               presenter.ButtonCliked();
           }
       });

    }


    @Override
    public void navigateToNextScreen() {
        Intent intent = new Intent(this, CategoryListActivity.class);
        startActivity(intent);
    }

    @Override
    public void activateButton() {



    }

    @Override
    public void injectPresenter(CoverContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
