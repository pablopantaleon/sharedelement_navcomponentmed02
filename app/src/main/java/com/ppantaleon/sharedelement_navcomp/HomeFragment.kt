package com.ppantaleon.sharedelement_navcomp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ppantaleon.sharedelement_navcomp.databinding.FragmentHomeBinding

/**
 * Created by Pablo Reyes [devpab@gmail.com] on 2/28/21.
 */
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonAssetExample.setOnClickListener {
            findNavController().navigate(R.id.action_asset_example)
        }
        binding.buttonGlideExample.setOnClickListener {
            findNavController().navigate(R.id.action_glide_example)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}