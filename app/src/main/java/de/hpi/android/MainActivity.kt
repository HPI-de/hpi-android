package de.hpi.android

import android.os.Bundle
import de.hpi.android.core.presentation.base.BaseActivity
import de.hpi.android.feedback.presentation.FeedbackDialogFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
