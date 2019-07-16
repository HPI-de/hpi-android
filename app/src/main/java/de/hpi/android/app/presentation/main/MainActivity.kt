package de.hpi.android.app.presentation.main

import android.os.Bundle
import de.hpi.android.R
import de.hpi.android.core.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.app_activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_activity_main)

        bottomAppBar.setNavigationOnClickListener { NavigationDrawerFragment().show(supportFragmentManager) }
    }
}
