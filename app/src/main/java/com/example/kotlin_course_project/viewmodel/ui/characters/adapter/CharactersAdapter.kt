package com.example.kotlin_course_project.viewmodel.ui.characters.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CharactersAdapter (private val characters : List<Character>) :
    RecyclerView.Adapter<CharactersAdapter.CharactersViewHolder>(){
        class CharactersViewHolder (view : View) : RecyclerView.ViewHolder(view) {
        //    fun
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}