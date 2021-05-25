package es.ulpgc.eite.cleancode.visitcanary.cover;

public class CoverModel implements CoverContract.Model {

    public static String TAG = CoverModel.class.getSimpleName();

    private String comenzar,titulo;

    public CoverModel(String comenzar, String titulo) {
        this.titulo=titulo;
        this.comenzar=comenzar;
    }

    @Override
    public String getTitulo() {
        // Log.e(TAG, "getStoredData()");
        return titulo;
    }
    @Override
    public String getComenzar() {
        // Log.e(TAG, "getStoredData()");
        return comenzar;
    }

    @Override
    public void onRestartScreen(String titulo,String comenzar) {
        // Log.e(TAG, "onRestartScreen()");
        this.comenzar=comenzar;
        this.titulo=titulo;
    }

    @Override
    public void onDataFromNextScreen(String data) {
        // Log.e(TAG, "onDataFromNextScreen()");
    }

}