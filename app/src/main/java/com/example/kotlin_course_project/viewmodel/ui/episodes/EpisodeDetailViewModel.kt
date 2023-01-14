package com.example.kotlin_course_project.viewmodel.ui.episodes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_course_project.datasource.remotedatasource.dataclassJsonReceiver.episode.toEpisodeByIdDetail
import com.example.kotlin_course_project.viewmodel.domain.CharactersDomain
import com.example.kotlin_course_project.viewmodel.domain.RickAndMortyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject


@HiltViewModel
class EpisodeDetailViewModel @Inject constructor(
    private val repository: RickAndMortyRepository
) : ViewModel() {

    private val _state = MutableStateFlow(EpisodeDetailState())
    val state: StateFlow<EpisodeDetailState> get() = _state


    fun getEpisodeDetail() {

        if (_state.value.characterList==null){
            try {
                _state.value = _state.value.copy(
                    isLoading = true,
                    error = ""
                )
                viewModelScope.launch {

                    val response = repository.getEpisodeById(getEpisodeId()).toEpisodeByIdDetail()

                    _state.value = _state.value.copy(episodeDetailInfo = response)


                    val characterList = mutableListOf<CharactersDomain>()
                    response.characters.forEach { characterUrl ->
                        val characterId = (characterUrl.split("/"))[5].toInt()

                        val character =
                            repository.getCharacterDetailById(characterId).toCharactersDomain()
                        characterList.add(character)

                    }

                    _state.value = _state.value.copy(
                        characterList = characterList
                    )
                    _state.value = _state.value.copy(
                        isLoading = false
                    )


                }

            } catch (e: Exception) {
                _state.value = _state.value.copy(error = "An expected error occured")
            } catch (e: HttpException) {
                _state.value = _state.value.copy(
                    error = "Please check your internet connection"
                )
            }
        }


    }

    fun setEpisodeId(id: Int) {
        _state.value = _state.value.copy(
            episodeId = id
        )
    }

    private fun getEpisodeId(): Int {
        return _state.value.episodeId
    }
}