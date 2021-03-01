package com.ppantaleon.sharedelement_navcomp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.transition.TransitionInflater

/**
 * A simple [Fragment] subclass as the second destination in thgite navigation.
 */
class AssetDetailExampleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_asset_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // this line is required, this define what animation we want to play for transition
        sharedElementEnterTransition = TransitionInflater.from(context)
            .inflateTransition(R.transition.se_transition)
    }
}