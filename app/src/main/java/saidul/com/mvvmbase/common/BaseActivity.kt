package saidul.com.mvvmbase.common

import android.app.ProgressDialog
import android.arch.lifecycle.Observer
import android.view.MenuItem
import android.view.View
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.app_bar_main.*

/**
 * Created by ankitsharma on 11/01/18.
 */
open class BaseActivity: DaggerAppCompatActivity() {

    companion object {
         var progDailog: ProgressDialog? = null
         var TAG : String = this.javaClass.simpleName;
    }

    fun observeLoader(viewModel: BaseViewModel, loaderView: View) {
        viewModel.loader.observe(this, Observer {
            loaderView.visibility = if(it != null && it) View.VISIBLE else View.GONE
        })
    }


    public fun setToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // handle arrow click here
        if (item.itemId == android.R.id.home) {
            finish() // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item)
    }


    fun showprogessdialog() {

        progDailog = ProgressDialog(this)

        if (progDailog != null) {
            progDailog?.setMessage("Please wait...")
            progDailog?.setCancelable(false)
            progDailog?.show()

        }
    }

    fun hiddenProgressDialog() {
        if (progDailog != null) {
            progDailog?.dismiss()
        }
    }
}