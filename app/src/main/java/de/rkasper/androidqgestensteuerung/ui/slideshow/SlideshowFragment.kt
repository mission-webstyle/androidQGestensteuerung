package de.rkasper.androidqgestensteuerung.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import de.rkasper.androidqgestensteuerung.R

class SlideshowFragment : Fragment() {

    private lateinit var slideshowViewModel: SlideshowViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        slideshowViewModel =
            ViewModelProviders.of(this).get(SlideshowViewModel::class.java)
        val root = inflater.inflate(R.layout.nav_item_fragment_slideshow, container, false)
        val textView: TextView = root.findViewById(R.id.txtvSlideshow)
        slideshowViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}