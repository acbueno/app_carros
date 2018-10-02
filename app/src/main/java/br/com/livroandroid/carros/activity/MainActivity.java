package br.com.livroandroid.carros.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import br.com.livroandroid.carros.R;
import br.com.livroandroid.carros.fragments.AboutDialog;
import br.com.livroandroid.carros.fragments.CarrosFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();
        setupNavDrawer();
        //inicializa o layout principal com o fragment dos carros
        replaceFragramet(CarrosFragment.newInstance(R.string.carros));
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.action_about){
            AboutDialog.showAbout(getSupportFragmentManager());
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
