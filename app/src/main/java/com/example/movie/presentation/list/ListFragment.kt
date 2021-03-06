package com.example.movie.presentation.list
//CARLOS JAIME LOPEZ MARTINEZ

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.movie.R
import com.example.movie.databinding.FragmentListBinding
import com.example.movie.domain.model.Genres
import com.example.movie.domain.model.Movie_table
import com.example.movie.presentation.adapter.DataAdapter
import com.example.movie.presentation.base.BaseFragment


class ListFragment : BaseFragment<FragmentListBinding>(),ListContract.ListView {


    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentListBinding {
        return FragmentListBinding.inflate(inflater,container,false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val presenter:ListPresenter= ListPresenter(requireContext())

        val presenter2:ListPresenter= ListPresenter(requireContext())

        // presenter.
       val adapter= presenter.configuringAdapter(binding.rcList)
        adapter.onMovieClickLisener=object : DataAdapter.OnMovieClickLisener{



                override fun onMovieClick(movie: Movie_table) {

                Log.d("test48",movie.title)
                navigateTo(movie,R.id.action_listFragment_to_detailFragment)
            }



            // ListFragment.findNavController()?.navigate(R.id.action_listFragment_to_detailFragment)
        }


        val adapter2= presenter2.configuringAdapter2(binding.rcList2)
        adapter2.onMovieClickLisener=object : DataAdapter.OnMovieClickLisener{


            override fun onMovieClick(movie: Movie_table) {

                Log.d("test48",movie.title)
                navigateTo(movie,R.id.action_listFragment_to_detailFragment)
            }



            // ListFragment.findNavController()?.navigate(R.id.action_listFragment_to_detailFragment)
        }



            adapter.onGenrsClickLisener=object : DataAdapter.OnGenrsClickLisener{
            override fun onGenrClick(string: String) {
                Log.d("test49",string)

                Log.d("test49",presenter.filterList(string).toString())
               /* if(Genres.list_genres.get(string)!=0){
                adapter.setData(presenter.getMockData(presenter.filterList(Genres.list_genres.get(string).toString())))
                adapter.notifyDataSetChanged()}
                else
                {
                    adapter.setData(presenter.getMockData(presenter.getMovieByList.execute()))
                    adapter.notifyDataSetChanged()
                }*/
            }


        }

        adapter2.onGenrsClickLisener=object : DataAdapter.OnGenrsClickLisener{
            override fun onGenrClick(string: String) {
                Log.d("test49",string)

                Log.d("test49",presenter.filterList(string).toString())
               /* if(Genres.list_genres.get(string)!=0){
                    adapter2.setData(presenter.getMockData(presenter.filterList(Genres.list_genres.get(string).toString())))
                    adapter2.notifyDataSetChanged()}
                else
                {
                    adapter2.setData(presenter.getMockData(presenter.getMovieByList.execute()))
                    adapter2.notifyDataSetChanged()
                }*/
            }


        }

    }

    override fun navigateTo(movie: Movie_table, marshrit: Int) {
        val bundle = Bundle()
        bundle.putString("title", movie.title)
        bundle.putString("year", movie.release_date)
        bundle.putString("original_title", movie.original_title)
        bundle.putString("overview", movie.overview)
        bundle.putString("poster_path", movie.poster_path)
        bundle.putString("rating",movie.rating)
        findNavController().navigate(marshrit,bundle)
    }


}