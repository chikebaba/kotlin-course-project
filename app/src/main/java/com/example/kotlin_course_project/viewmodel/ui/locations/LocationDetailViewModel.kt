package com.example.kotlin_course_project.viewmodel.ui.locations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_course_project.datasource.remotedatasource.dataclassJsonReceiver.location.toLocationByIdDomain
import com.example.kotlin_course_project.viewmodel.domain.CharactersDomain
import com.example.kotlin_course_project.viewmodel.domain.RickAndMortyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class LocationDetailViewModel @Inject constructor(
    val repository: RickAndMortyRepository,
) : ViewModel() {

    private val _state = MutableStateFlow(LocationDetailState())
    val state: StateFlow<LocationDetailState> get() = _state

    init {
    }
    fun getLocationInfo() {
        if (_state.value.characterList==null){
            try {
                _state.value = _state.value.copy(
                    isLoading = true
                )
                viewModelScope.launch {
                    val data = repository.getLocationDetailById(getLocationId()).toLocationByIdDomain()
                    _state.value = _state.value.copy(
                        locationInfo = data
                    )
                    val characterList = mutableListOf<CharactersDomain>()
                    data.residents.forEach {
                        val characterID = (it.split("/"))[5].toInt()
                        val characters = repository.getCharacterDetailById(characterID)
                        characterList.add(characters.toCharactersDomain())
                    }
                    _state.value = _state.value.copy(
                        isLoading = false
                    )
                    _state.value = _state.value.copy(
                        characterList = characterList
                    )
                }
            }catch (e: Exception){
                _state.value = _state.value.copy(
                    error = "Error"
                )
            }catch (e: HttpException){
                _state.value = _state.value.copy(
                    error = "Http Error"
                )
            }
        }
    }

    fun setLocationID(locationId: Int) {
        _state.value = _state.value.copy(
            locationID = locationId
        )
    }

    private fun getLocationId(): Int {
        return _state.value.locationID
    }
}
