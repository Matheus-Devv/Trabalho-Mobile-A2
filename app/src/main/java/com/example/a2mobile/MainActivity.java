package com.example.a2mobile;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.a2mobile.databinding.ActivityMainBinding;
import com.example.a2mobile.model.Roupa;
import com.example.a2mobile.model.RoupasAdapter;
import com.example.a2mobile.ui.carrinho.CarrinhoFragment;
import com.example.a2mobile.ui.gallery.GalleryFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import org.parceler.Parcels;

import java.util.List;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener,
        GalleryFragment.OnRoupasSelecionadasListener {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private RoupasAdapter roupasAdapter;

    @Override
    public void onRoupasSelecionadas(List<Roupa> roupasSelecionadas) {
        openCarrinhoFragment(roupasSelecionadas);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Context context = this;

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        navigationView.setNavigationItemSelectedListener(this);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_carrinho)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        roupasAdapter = new RoupasAdapter(context, null, null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public List<Roupa> getListaRoupasSelecionadas() {
        if (roupasAdapter != null) {
            return roupasAdapter.getListaRoupasSelecionadas();
        } else {
            return null;
        }
    }

    private void openCarrinhoFragment(List<Roupa> roupasSelecionadas) {
        if (roupasSelecionadas != null) {
            CarrinhoFragment carrinhoFragment = new CarrinhoFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("listaRoupasSelecionadas", Parcels.wrap(roupasSelecionadas));
            carrinhoFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.nav_host_fragment_content_main, carrinhoFragment)
                    .addToBackStack(null)
                    .commit();
        } else {
            Toast.makeText(this, "Nenhuma roupa selecionada", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_carrinho:
                openCarrinhoFragment(getListaRoupasSelecionadas());
                return true;
            // other menu cases
            // ...
        }

        binding.drawerLayout.closeDrawers();
        return true;
    }
}
