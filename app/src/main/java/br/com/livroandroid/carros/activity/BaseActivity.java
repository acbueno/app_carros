package br.com.livroandroid.carros.activity;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.api.GoogleApiClient;

import br.com.livroandroid.carros.R;
import livroandroid.lib.utils.NavDrawerUtil;

/**
 * Created by ander on 27/09/2018.
 */

public class BaseActivity extends livroandroid.lib.activity.BaseActivity {

    protected DrawerLayout drawerLayout;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    protected void setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

    protected void setupNavDrawer() {
        final ActionBar actionBar = getSupportActionBar();

        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        if (navigationView != null && drawerLayout != null) {

            setNavViewValues(navigationView, R.string.nav_drawer_username, R.string.nav_drawer_email, R.mipmap.ic_launcher);
            NavDrawerUtil.setHeaderValues(navigationView, R.id.containerNavDrawerListViewHeader, R.drawable.nav_drawer_header, R.drawable.ic_logo_user, R.string.nav_drawer_username, R.string.nav_drawer_email);
            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem menuItem) {
                    menuItem.setChecked(true);
                    drawerLayout.closeDrawers();
                    onNavDrawerItemSelected(menuItem);
                    return true;
                }
            });
        }
    }

    static void setNavViewValues(NavigationView navView, int nome, int email, int img) {
        View headerView = navView.getHeaderView(0);
        TextView tNome = (TextView) headerView.findViewById(R.id.tUserName);
        TextView tEmail = (TextView) headerView.findViewById(R.id.tUserEmail);
        ImageView imageView = (ImageView) headerView.findViewById(R.id.imgUserPhoto);
        tNome.setText(nome);
        tEmail.setText(email);
        imageView.setImageResource(img);
    }

    private void onNavDrawerItemSelected(MenuItem menuItem) {

        switch (menuItem.getItemId()) {

            case R.id.nav_item_carros_todos:
                toast("Clicou em carros");
                break;
            case R.id.nav_item_carros_classicos:
                toast("Clicou em carros classicos");
                break;
            case R.id.nav_item_carros_esportivos:
                toast("Clicou em carros esportivos");
                break;
            case R.id.nav_item_carros_luxo:
                toast("Clicou em carros luxo");
                break;
            case R.id.nav_item_site_livro:
                snack(drawerLayout, "Clicou em site livro");
                break;
            case R.id.nav_item_settings:
                toast("Clicou em configurações");
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:
                if (drawerLayout != null) {
                    openDrawer();
                    return true;
                }
        }
        return super.onOptionsItemSelected(item);
    }

    protected void openDrawer() {
        if (drawerLayout != null) {
            drawerLayout.openDrawer(GravityCompat.START);
        }
    }

    protected void closeDrawer() {
        if (drawerLayout != null) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }


}
