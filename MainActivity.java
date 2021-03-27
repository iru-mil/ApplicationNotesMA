package ru.geekbrains.applicationnotesma;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import ru.geekbrains.applicationnotesma.ui.home.HomeFragment;
import ru.geekbrains.applicationnotesma.ui.notes.NotesFragment;
import ru.geekbrains.applicationnotesma.ui.settings.SettingsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(item -> {
            int itemID = item.getItemId();
            if (itemID == R.id.navigation_home) {
                openTab(new HomeFragment(), HomeFragment.TAG);
                return true;
            } else if (itemID == R.id.navigation_notes) {
                openTab(new NotesFragment(), NotesFragment.TAG);
                return true;
            } else if (itemID == R.id.navigation_settings) {
                openTab(new SettingsFragment(), SettingsFragment.TAG);
                return true;
            }
            return false;
        });
        if (savedInstanceState == null) {
            openTab(new HomeFragment(), HomeFragment.TAG);
        }
    }

    private void openTab(Fragment fragment, String tag) {
        Fragment addedFragment = getSupportFragmentManager().findFragmentByTag(tag);
        if (addedFragment == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.host_fragment, fragment, tag)
                    .commit();
        }
    }
}