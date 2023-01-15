package com.example.kotlin_course_project.viewmodel.ui.locations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlin_course_project.databinding.FragmentLocationDetailBinding
import com.example.kotlin_course_project.viewmodel.ui.locations.adapter.LocationsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LocationDetailFragment : Fragment() {

    private var _binding: FragmentLocationDetailBinding? = null
    lateinit var binding:FragmentLocationDetailBinding
    private val viewModel: LocationDetailViewModel by viewModels()
    private lateinit var adapter: LocationsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLocationDetailBinding.inflate(inflater, container, false)
        binding = _binding!!
        viewModel.setLocationID(locationID)
        viewModel.getLocationInfo()
        prepareAdapter(locationID)

        lifecycleScope.launch {
            viewModel.state.collectLatest {
                binding.viewModel = viewModel
            }
        }

        binding.imageButton.setOnClickListener {

            if (isFromNavigateLocationList) {
                navigateToLocationList()
            } else {
                findNavController().popBackStack()
            }
        }
        return binding.root
    }

    private fun navigateToLocationList() {
        val action =
            LocationDetailFragment.actionToLocationList()
        findNavController().navigate(action)
    }

    private fun navigateToCharacterDetail() {
        val action =
            LocationDetailFragment.actionToCharacterDetail(
                locationArgs.characterID
            )
        findNavController().navigate(action)
    }

    private fun prepareAdapter(locationID: Int) {
        adapter = LocationsAdapter(
            ItemClickListener { characterId ->
                val action =
                    LocationDetailFragment.actionToCharacterDetail(
                        characterId
                    )
                findNavController().navigate(action)
            }
        )
        binding.recyclerView.adapter = adapter

        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), spanCount)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
