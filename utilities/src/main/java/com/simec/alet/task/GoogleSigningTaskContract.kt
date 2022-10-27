package com.simec.alet.task

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.tasks.Task

class GoogleSigningTaskContract(
    private val mGoogleSignInClient: GoogleSignInClient
) : ActivityResultContract<Any?, Task<GoogleSignInAccount>?>() {
    override fun createIntent(context: Context, input: Any?): Intent {
        return mGoogleSignInClient.signInIntent
    }

    override fun parseResult(resultCode: Int, data: Intent?): Task<GoogleSignInAccount>? {
        return if (data == null) null else GoogleSignIn.getSignedInAccountFromIntent(data)
    }
}
