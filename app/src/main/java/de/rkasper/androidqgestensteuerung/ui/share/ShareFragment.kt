package de.rkasper.androidqgestensteuerung.ui.share

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import de.rkasper.androidqgestensteuerung.R

class ShareFragment : Fragment() {

    private lateinit var shareViewModel: ShareViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        shareViewModel =
            ViewModelProviders.of(this).get(ShareViewModel::class.java)
        val root = inflater.inflate(R.layout.nav_item_fragment_share, container, false)
        val textView: TextView = root.findViewById(R.id.txtvShare)
        shareViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}