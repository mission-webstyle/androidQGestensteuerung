package de.rkasper.androidqgestensteuerung

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu

/**
 * Einstiegspunkt in die App
 */
class MainActivity : AppCompatActivity() {

    //region 1. Decl. and Init Widgets und Attribute
    private lateinit var appBarConfiguration: AppBarConfiguration
    //endregion

    //region 2. Lebenszyklus
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //1. Layout setzen
        setContentView(R.layout.main_activity_layout)

        //2. Widgets generieren
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        val fab: FloatingActionButton = findViewById(R.id.fab)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        this.setSupportActionBar(toolbar)


        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        /**
         * Jede MenuId wird als Set uebergeben da jedes Menu
         * ein Element der obersten Ebene sein sollte
         */
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navItemHome, R.id.navItemGallery, R.id.navItemSlideshow,
                R.id.navItemTools, R.id.navItemShare, R.id.navItemSend
            ), drawerLayout
        )


        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
    //endregion

    //region 3. Menu Handling
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Menu zur Laufzeit entfalten
        menuInflater.inflate(R.menu.main_activity_right_toolbar_menu_layout, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
    //endregion
}
